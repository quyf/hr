package com.demo.hr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.hr.entity.Feedback;
import com.demo.hr.entity.Interview;
import com.demo.hr.entity.Staff;
import com.demo.hr.service.FeedbackService;
import com.demo.hr.service.InterviewService;
import com.demo.hr.service.StaffService;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

/**
 * 处理HR和面试官的反馈
 * @author quyf
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	StaffService staffService;
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	InterviewService interviewService;

	@ResponseBody
	@RequestMapping(value = "/{feedbackTaskId}", method = RequestMethod.POST)
	public Result feedback(HttpServletRequest request, 
			@PathVariable Integer feedbackTaskId,//反馈任务ID
			@RequestParam(value = "interview_id", required = false, defaultValue = "0") Integer interviewId,//面试邀请ID
			@RequestParam(value = "staff_id", required = false, defaultValue = "0") Integer staffId,//提交反馈的员工ID
			@RequestParam(value = "type", required = false, defaultValue = "0") Integer type,//类型 0 hr 1面试官的反馈
			@RequestParam(value = "result", required = false, defaultValue = "0") Integer result,//面试官反馈结果 0 无 1通过 2存档备选 3不通过
			@RequestParam(value="content",required = false) String content	//反馈内容
			) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		
		if( feedbackTaskId<1 || interviewId<1 || staffId<1 || result<0 || result>3){
			rt.setErrorMessage("请检查参数");
			return rt;
		}
		Staff staff = staffService.getStaffById( staffId );
		if( staff == null ){
			rt.setErrorMessage("无此员工信息，不能提交反馈");
			return rt;
		}
		
		Interview interview = interviewService.getInterviewById( interviewId );
		if( interview == null ){
			rt.setErrorMessage("无此面试信息，不能提交反馈");
			return rt;
		}
		//重复提交问题
		Feedback feedbackExist = feedbackService.hasFeed(interviewId,staff.getId());
		if( null!=feedbackExist ){
			rt.setErrorMessage("已经提交过反馈，不能再提交反馈");
			return rt;
		}
		Feedback feedback = new Feedback();
		feedback.setFeedbackId(feedbackTaskId);
		feedback.setInterviewId(interviewId);
		feedback.setPersonId( interview.getPersonId());
		feedback.setPersonName( interview.getName());
		feedback.setStaffId( staff.getId());
		feedback.setStaffName( staff.getName());
		feedback.setMsType( interview.getMsType());
		feedback.setType( type );
		feedback.setResult( result);
		feedback.setContent(content);
		rt = feedbackService.addFeedback( feedback,interview, staff);
		
		return rt;
	}
	
}
