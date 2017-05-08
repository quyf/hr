package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.FeedbackHistory;
import com.demo.hr.entity.criteria.FeedbackHistoryCriteria;

public interface FeedbackHistoryDao {
	int insert(FeedbackHistory feedbackHistory) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(FeedbackHistoryCriteria feedbackHistoryCriteria) throws Exception;
	
	int updateById(FeedbackHistory feedbackHistory) throws Exception;
	
	int update(@Param("record") FeedbackHistory feedbackHistory,@Param("criteria")  FeedbackHistoryCriteria feedbackHistoryCriteria) throws Exception;
	
	int count(FeedbackHistoryCriteria feedbackHistoryCriteria) throws Exception;
	
	FeedbackHistory selectById(Integer id) throws Exception;
	
	List<FeedbackHistory> select(FeedbackHistoryCriteria feedbackHistoryCriteria) throws Exception;
}
