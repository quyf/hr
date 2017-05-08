package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.FeedbackTask;
import com.demo.hr.entity.criteria.FeedbackTaskCriteria;

public interface FeedbackTaskDao {
	int insert(FeedbackTask feedbackTask) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(FeedbackTaskCriteria feedbackTaskCriteria) throws Exception;
	
	int updateById(FeedbackTask feedbackTask) throws Exception;
	
	int update(@Param("record") FeedbackTask feedbackTask,@Param("criteria")  FeedbackTaskCriteria feedbackTaskCriteria) throws Exception;
	
	int count(FeedbackTaskCriteria feedbackTaskCriteria) throws Exception;
	
	FeedbackTask selectById(Integer id) throws Exception;
	
	List<FeedbackTask> select(FeedbackTaskCriteria feedbackTaskCriteria) throws Exception;
}
