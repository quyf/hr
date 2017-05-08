package com.demo.hr.service;

import java.util.List;

import com.demo.hr.controller.cmd.CreateInterviewCmd;
import com.demo.hr.entity.Interview;
import com.demo.hr.entity.Person;

public interface InterviewService {

	Interview getInterviewById(Integer id);
	
	Interview getInterviewInfoById(Integer id);

	List<Interview> getList(String likeAccount, Integer offset, Integer pageSize);

	/**
	 * 添加面试邀请
	 * @param person
	 * @param createCmd
	 */
	int createInterview(Person person, CreateInterviewCmd createCmd) ;
	
	

}
