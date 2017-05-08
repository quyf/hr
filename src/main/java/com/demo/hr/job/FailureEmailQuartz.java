package com.demo.hr.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.demo.hr.entity.InterviewFailure;
import com.demo.hr.helper.MailSenderHelper;
import com.demo.hr.helper.SpringHelper;
import com.demo.hr.service.InterviewFailureService;
import com.demo.hr.utils.HrUtils;
import com.demo.hr.utils.NullUtils;

/**
 * 定期扫描淘汰记录
 * @author quyf
 *
 */
@Component
public class FailureEmailQuartz {
    
	@Autowired
	InterviewFailureService interviewFailureService;
	
	public void run(){
		//System.out.println("FailureEmailQuartz running...");
		List<InterviewFailure> failureList = interviewFailureService.selectNeedNotifyList();
		if( failureList==null || failureList.isEmpty()){
			return ;
		}
		//组装
		for(InterviewFailure failure:failureList ){
			HrUtils.submit( new FailureEmailJob( failure ));
		}
	}

}

/**
 * 候选人发送淘汰邮件
 * @author quyf
 *
 */
class FailureEmailJob implements Runnable{
	Logger log = LoggerFactory.getLogger( FailureEmailJob.class);
	MailSenderHelper mailSenderHelper = (MailSenderHelper)SpringHelper.getBean( MailSenderHelper.class );
	InterviewFailureService interviewFailureService = (InterviewFailureService)SpringHelper.getBean( InterviewFailureService.class );
	
	private InterviewFailure interviewFailure;
	
	public FailureEmailJob(InterviewFailure failure) {
		this.interviewFailure = failure;
	}

	public void run() {
		String toEmail = interviewFailure.getEmail();
		if( !NullUtils.isEmpty( toEmail )){
			log.info("FailureEmailJob==>toEmail={},failure={},begin",toEmail, JSON.toJSONString(interviewFailure));
			Map<String,Object> params = makeFailureEmailParams( interviewFailure );
			
			int rt = mailSenderHelper.sendInterviewFailureEmail(toEmail, params);
			log.info("FailureEmailJob==>toEmail={},result={},end",toEmail,rt);
		}
		
		// 完了要更新InterviewFailure表中记录
		interviewFailureService.failureNotifyedChangeStatus( interviewFailure );
	}
	
	//封装面试淘汰的参数
	private Map<String, Object> makeFailureEmailParams(InterviewFailure failure) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", failure.getName());//候选人名字
		params.put("post", failure.getPost());//应聘岗位
		
		return params;
	}

	
}