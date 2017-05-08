package com.demo.hr.service;

import java.util.List;

import com.demo.hr.entity.InterviewFailure;

public interface InterviewFailureService {

	List<InterviewFailure> selectNeedNotifyList();

	int failureNotifyedChangeStatus(InterviewFailure interviewFailure);
	
}
