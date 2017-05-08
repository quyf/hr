package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.Interviewer;
import com.demo.hr.entity.criteria.InterviewerCriteria;

public interface InterviewerDao {
	int insert(Interviewer interviewer) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(InterviewerCriteria interviewerCriteria) throws Exception;
	
	int updateById(Interviewer interviewer) throws Exception;
	
	int update(@Param("record") Interviewer interviewer, @Param("criteria") InterviewerCriteria interviewerCriteria) throws Exception;
	
	int count(InterviewerCriteria interviewerCriteria) throws Exception;
	
	Interviewer selectById(Integer id) throws Exception;
	
	List<Interviewer> select(InterviewerCriteria interviewerCriteria) throws Exception;

	List<Interviewer> selectByInterviewId(Integer id) throws Exception;
}
