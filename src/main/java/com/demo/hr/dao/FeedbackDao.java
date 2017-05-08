package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.Feedback;
import com.demo.hr.entity.criteria.FeedbackCriteria;

public interface FeedbackDao {
	int insert(Feedback feedback) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(FeedbackCriteria feedbackCriteria) throws Exception;
	
	int updateById(Feedback feedback) throws Exception;
	
	int update(@Param("record") Feedback feedback, @Param("criteria") FeedbackCriteria feedbackCriteria) throws Exception;
	
	int count(FeedbackCriteria feedbackCriteria) throws Exception;
	
	Feedback selectById(Integer id) throws Exception;
	
	List<Feedback> select(FeedbackCriteria feedbackCriteria) throws Exception;
}
