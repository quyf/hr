package com.demo.hr.service;

import com.demo.hr.entity.Feedback;
import com.demo.hr.entity.Interview;
import com.demo.hr.entity.Staff;
import com.demo.hr.utils.Result;

public interface FeedbackService {

	/**
	 * 面试官和HR提交的面试反馈都在这里处理，会判断面试结果 处理淘汰邮件
	 * @param feedback
	 * @param interview
	 * @param staff
	 */
	Result addFeedback(Feedback feedback, Interview interview, Staff staff);

	/**
	 * 
	 * 根据面试邀请ID，面试官|HR 的staffId 查询是否已经反馈过
	 * @param interviewId
	 * @param staffId
	 * @return
	 * @author quyf
	 * @date 2017年5月6日 下午2:43:53
	 */
	Feedback hasFeed(Integer interviewId, Integer staffId);

}
