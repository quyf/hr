package com.demo.hr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hr.dao.InterviewFailureDao;
import com.demo.hr.entity.InterviewFailure;
import com.demo.hr.entity.criteria.InterviewFailureCriteria;
import com.demo.hr.service.InterviewFailureService;
import com.demo.hr.utils.HrUtils;

@Service
public class InterviewFailureServiceImpl implements InterviewFailureService{

	@Autowired
	InterviewFailureDao interviewFailureDao;
	
	public List<InterviewFailure> selectNeedNotifyList() {
		//查询未通知，时间在现在之前的还没发的
		InterviewFailureCriteria fCrt = new InterviewFailureCriteria();
		InterviewFailureCriteria.Criteria crt = fCrt.createCriteria();
		crt.andStatusEqualTo( 0 );
		Date now = new Date();
		// 这里主要是为了缩小查询范围 数据量大的时候优势体现，仅查过去一小时内未处理的
		Date notifyTimebegin = HrUtils.addHour(now, -1);
		crt.andNotifyTimeBetween(notifyTimebegin, now);
		fCrt.setOffset(0);
		fCrt.setLimit(20);
		try {
			List<InterviewFailure> failureList = interviewFailureDao.select(fCrt);
			return failureList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public int failureNotifyedChangeStatus(InterviewFailure interviewFailure) {
		InterviewFailure update = new InterviewFailure();
		update.setId( interviewFailure.getId() );
		update.setStatus( 1 );
		update.setNotifyEndTime( new Date());
		try {
			return interviewFailureDao.updateById( update );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
