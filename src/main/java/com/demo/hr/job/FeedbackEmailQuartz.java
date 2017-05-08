package com.demo.hr.job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.hr.entity.FeedbackTask;
import com.demo.hr.entity.Interview;
import com.demo.hr.helper.MailSenderHelper;
import com.demo.hr.helper.SpringHelper;
import com.demo.hr.service.FeedbackTaskService;
import com.demo.hr.service.InterviewService;
import com.demo.hr.utils.Constants;
import com.demo.hr.utils.HrUtils;
import com.demo.hr.utils.NullUtils;

/**
 * 定期扫描反馈表
 * @author quyf
 *
 */
@Component
public class FeedbackEmailQuartz {
    
	@Autowired
	FeedbackTaskService feedbackTaskService;
	@Autowired
	InterviewService interviewService;
	
	public void run(){
		List<FeedbackTask> taskList = feedbackTaskService.selectNeedNotifyList();
		if( taskList==null || taskList.isEmpty()){
			return ;
		}
		//组装
		for(FeedbackTask task:taskList ){
			handle( task );
		}
	}

	private void handle(FeedbackTask task) {
		Interview interview = interviewService.getInterviewById( task.getInterviewId() );
		HrUtils.submit( new FeedbackEmailJob(task, interview ));
	}
   
}

/**
 * 面试官和HR发送反馈邮件
 * @author quyf
 *
 */
class FeedbackEmailJob implements Runnable{

	MailSenderHelper mailSenderHelper = (MailSenderHelper)SpringHelper.getBean( MailSenderHelper.class );
	FeedbackTaskService feedbackTaskService = (FeedbackTaskService)SpringHelper.getBean( FeedbackTaskService.class );
	
	private FeedbackTask feedbackTask;
	private Interview interview;
	
	public FeedbackEmailJob(FeedbackTask task,Interview interview) {
		this.feedbackTask = task;
		this.interview = interview;
	}

	public void run() {
		String toEmail = feedbackTask.getStaffEmail();
		if( !NullUtils.isEmpty( toEmail )){
			Map<String,Object> params = makeFeedbackEmailParams(interview, feedbackTask );
			
			if( feedbackTask.getType()==0 ){//HR
				mailSenderHelper.sendHrFeedbackEmail(toEmail, params, feedbackTask.getMsType());
			}else{//面试官
				mailSenderHelper.sendFeedbackEmail(toEmail, params , interview.getMsType());
			}
		}
		
		// 完了要更新FeedbackTask表中记录
		feedbackTaskService.taskNotifyedChangeStatus( feedbackTask );
	}
	//封装面试反馈的参数
	private Map<String, Object> makeFeedbackEmailParams(Interview interview,FeedbackTask feedbackTask) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staff_name", feedbackTask.getStaffName());//面试官名字
		params.put("staff_id", feedbackTask.getStaffId());//面试官ID
		
		params.put("person_id", interview.getPersonId());//候选人ID
		params.put("person_name", interview.getName());//候选人名字
		params.put("post", interview.getPost());//岗位
		params.put("post_link", interview.getPostLink() );//岗位链接
		
		params.put("interview_id", interview.getId());//面试邀请ID
		params.put("feedback_task_id", feedbackTask.getId());//反馈任务ID
		
		params.put("ms_type", feedbackTask.getMsType());//面试类型 0 初试 1复试
		params.put("feedback_type", feedbackTask.getType());//反馈类型 0 HR 1 面试官
		
		String info = HrUtils.encoder(HrUtils.mapToString(params) );
		params.put("click_url", Constants.HR_NODE_DOMAIN+"?info="+info);
		return params;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public FeedbackTask getFeedbackTask() {
		return feedbackTask;
	}

	public void setFeedbackTask(FeedbackTask feedbackTask) {
		this.feedbackTask = feedbackTask;
	}

}