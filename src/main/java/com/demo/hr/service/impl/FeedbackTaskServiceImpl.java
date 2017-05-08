package com.demo.hr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.demo.hr.dao.FeedbackTaskDao;
import com.demo.hr.entity.FeedbackTask;
import com.demo.hr.entity.criteria.FeedbackTaskCriteria;
import com.demo.hr.service.FeedbackTaskService;
import com.demo.hr.utils.HrUtils;


@Service
public class FeedbackTaskServiceImpl implements FeedbackTaskService {

	@Autowired
	FeedbackTaskDao feedbackTaskDao;

	@Autowired
	DataSourceTransactionManager transactionManager;

	public List<FeedbackTask> selectNeedNotifyList() {
		//查询未通知，时间在现在之前的还没发的
		FeedbackTaskCriteria fCrt = new FeedbackTaskCriteria();
		FeedbackTaskCriteria.Criteria crt = fCrt.createCriteria();
		crt.andStatusEqualTo( 0 );
		Date now = new Date();
		//这里主要是为了缩小查询范围 数据量大的时候优势体现，仅查过去一小时内未处理的
		Date notifyTimebegin = HrUtils.addHour(now, -1);
		crt.andNotifyTimeBetween(notifyTimebegin, now);
		fCrt.setOffset( 0 );
		fCrt.setLimit( 20 );
		try {
			List<FeedbackTask> taskList = feedbackTaskDao.select(fCrt);
			return taskList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int taskNotifyedChangeStatus(FeedbackTask feedbackTask) {
		FeedbackTask updateTask = new FeedbackTask();
		updateTask.setId( feedbackTask.getId() );
		updateTask.setNotifyEndTime( new Date());
		updateTask.setStatus( 1 );
		try {
			return feedbackTaskDao.updateById(updateTask);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


}
