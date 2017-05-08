package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.InterviewFailure;
import com.demo.hr.entity.criteria.InterviewFailureCriteria;

public interface InterviewFailureDao {
	int insert(InterviewFailure interviewFailure) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(InterviewFailureCriteria interviewFailureCriteria) throws Exception;
	
	int updateById(InterviewFailure interviewFailure) throws Exception;
	
	int update(@Param("record") InterviewFailure interviewFailure,@Param("criteria")  InterviewFailureCriteria interviewFailureCriteria) throws Exception;
	
	int count(InterviewFailureCriteria interviewFailureCriteria) throws Exception;
	
	InterviewFailure selectById(Integer id) throws Exception;
	
	InterviewFailure selectByInterviewId(Integer interviewId) throws Exception;
	
	List<InterviewFailure> select(InterviewFailureCriteria interviewFailureCriteria) throws Exception;
}
