package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.Interview;
import com.demo.hr.entity.criteria.InterviewCriteria;


public interface InterviewDao {
	int insert(Interview interview) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(InterviewCriteria interviewCriteria) throws Exception;
	
	int updateById(Interview interview) throws Exception;
	
	int update(@Param("record") Interview interview, @Param("criteria") InterviewCriteria interviewCriteria) throws Exception;
	
	int count(InterviewCriteria interviewCriteria) throws Exception;
	
	Interview selectById(Integer id) throws Exception;
	
	List<Interview> select(InterviewCriteria interviewCriteria) throws Exception;
}
