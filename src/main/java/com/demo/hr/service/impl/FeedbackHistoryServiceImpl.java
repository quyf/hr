package com.demo.hr.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.demo.hr.dao.FeedbackHistoryDao;
import com.demo.hr.service.FeedbackHistoryService;

@Service
public class FeedbackHistoryServiceImpl implements FeedbackHistoryService {
	public static final Logger log = LoggerFactory.getLogger(FeedbackHistoryServiceImpl.class);


	@Autowired
	FeedbackHistoryDao feedbackHistoryDao;

	@Autowired
	DataSourceTransactionManager transactionManager;

}
