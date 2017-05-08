package com.demo.hr.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.hr.entity.Interview;
import com.demo.hr.entity.Interviewer;
import com.demo.hr.helper.MailSenderHelper;
import com.demo.hr.helper.SpringHelper;
import com.demo.hr.utils.HrUtils;
import com.demo.hr.utils.NullUtils;

/**
 * HR创建面试邀请之后发送邮件给候选人和发送会议邀请给面试官
 * @author quyf
 *
 */
public class InterviewInviteEmailJob implements Runnable {
	Logger log = LoggerFactory.getLogger( InterviewInviteEmailJob.class );
	
	MailSenderHelper mailSenderHelper = (MailSenderHelper)SpringHelper.getBean( "mailSenderHelper" );
	
	private Interview interview;
	private List<Interviewer> viewerList;
	
	public InterviewInviteEmailJob(Interview interview, List<Interviewer> viewerList) {
		this.interview = interview;
		this.viewerList = viewerList;
	}

	public void run() {
		log.info("InterviewInviteEmailJob.run()->pId={};name=={};post={}",interview.getPersonId(),interview.getName(),interview.getPost());
		//组装候选人邮件参数
		Map<String,Object> params = makeInterviewEmailParams( interview );
		if( !NullUtils.isEmpty( interview.getEmail())){
			mailSenderHelper.sendInterviewInvite(interview.getEmail(), params);
		}
		if( viewerList==null||viewerList.size()==0 ){
			return ;
		}
		//组装面试官的会议邀请
		for(Interviewer viewer: viewerList){
			if( !NullUtils.isEmpty( viewer.getEmail())){
				Map<String,Object> meetingParams = makeMeetingEmailParmas( interview,viewer );
				mailSenderHelper.sendMeetingInvite(viewer.getEmail(), meetingParams);
			}
		}
		log.info("InterviewInviteEmailJob.run()->pId={};name=={};post={}====over",interview.getPersonId(),interview.getName(),interview.getPost());
	}
	
	private Map<String, Object> makeMeetingEmailParmas(Interview interview,Interviewer viewer) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("viewer_name", viewer.getStaffName());//面试官名字
		params.put("viewer_email", viewer.getEmail());//面试官邮箱
		
		params.put("person_name", interview.getName());//候选人名字
		params.put("post", interview.getPost());//岗位
		params.put("subject", "面试邀请-"+interview.getName()+"("+interview.getPost()+")");//面试官邮箱
		
		params.put("post_link", interview.getPostLink() );//岗位链接
		params.put("ms_time_str", HrUtils.format(interview.getMsTime()));//面试时间
		params.put("ms_time", interview.getMsTime());//面试时间
		params.put("ms_address", interview.getMsAddress() );//面试地址
		
		return params;
	}

	private Map<String, Object> makeInterviewEmailParams(Interview interview) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("person_name", interview.getName());
		params.put("post", interview.getPost());
		params.put("post_link", interview.getPostLink() );
		params.put("ms_time_str", HrUtils.format(interview.getMsTime()));//面试时间
		params.put("ms_address", interview.getMsAddress() );
		
		params.put("hr", interview.getHrName());
		params.put("hr_mobile", interview.getHrMobile());
		return params;
	}

}
