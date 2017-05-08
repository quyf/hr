package com.demo.hr.service;

import java.util.List;

import com.demo.hr.entity.FeedbackTask;

public interface FeedbackTaskService {

	/**
	 * 查询2小时以内 未发送的反馈
	 * @return
	 */
	List<FeedbackTask> selectNeedNotifyList();

	int taskNotifyedChangeStatus(FeedbackTask feedbackTask);

	
}
