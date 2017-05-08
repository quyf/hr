package com.demo.hr.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.demo.hr.dao.FeedbackDao;
import com.demo.hr.dao.InterviewDao;
import com.demo.hr.dao.InterviewFailureDao;
import com.demo.hr.dao.InterviewerDao;
import com.demo.hr.entity.Feedback;
import com.demo.hr.entity.Interview;
import com.demo.hr.entity.InterviewFailure;
import com.demo.hr.entity.Interviewer;
import com.demo.hr.entity.Staff;
import com.demo.hr.entity.criteria.FeedbackCriteria;
import com.demo.hr.entity.criteria.InterviewerCriteria;
import com.demo.hr.job.FeedbackNotifyHrJob;
import com.demo.hr.service.FeedbackService;
import com.demo.hr.utils.Constants;
import com.demo.hr.utils.HrUtils;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDao feedbackDao;
	@Autowired
	InterviewerDao interviewerDao;
	@Autowired
	InterviewDao interviewDao;
	@Autowired
	InterviewFailureDao interviewFailureDao;
	@Autowired
	DataSourceTransactionManager transactionManager; 

	public Feedback hasFeed(Integer interviewId, Integer staffId) {
		FeedbackCriteria fCrt = new FeedbackCriteria();
		FeedbackCriteria.Criteria crt = fCrt.createCriteria();
		crt.andInterviewIdEqualTo(interviewId);
		crt.andStaffIdEqualTo(staffId);
		try {
			List<Feedback> list = feedbackDao.select(fCrt);
			if( null!=list && list.size()>0 ){
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Result addFeedback(Feedback feedback, Interview interview, Staff staff) {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(txDef);
		try {
			feedbackDao.insert(feedback);
			//如果是面试官则更新反馈结果的状态
			if( feedback.getType()==1 ){//是面试官的反馈
				//条件
				InterviewerCriteria iCrt = new InterviewerCriteria();
				InterviewerCriteria.Criteria crt = iCrt.createCriteria();
				crt.andStaffIdEqualTo( staff.getId());
				crt.andInterviewIdEqualTo( interview.getId());
				//对象
				Interviewer updateInterviewer = new Interviewer();
				updateInterviewer.setNotifyFlag( 1 );
				updateInterviewer.setModifyTime( new Date());
				interviewerDao.update(updateInterviewer, iCrt);
			}
			//更新面试结果
			Interview updateInterview = new Interview();
			updateInterview.setId( interview.getId() );
			Integer msResult = feedback.getResult();
			if( feedback.getType()==1 ){
				updateInterview.setMsResult( msResult );
			}else{
				updateInterview.setHrResult( msResult );
			}
			interviewDao.updateById(updateInterview);
			//结果不通过就插入淘汰邮件 如果已经有，则不用
			if( msResult==3 ){
				InterviewFailure interviewFailure=interviewFailureDao.selectByInterviewId( interview.getId());
				if( interviewFailure==null ){
					interviewFailureDao.insert( makeInterviewFailure(interview,staff.getId(),feedback.getId()) );
				}
			}
			
			transactionManager.commit(status);
			if( feedback.getType()==1 ){//是面试官的反馈 还需要邮件告知hr 面试官已反馈
				HrUtils.submit( new FeedbackNotifyHrJob(feedback, interview ));
			}
			rt.setStatus( ResultCode.SUCCESS);
			return rt;
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
			rt.setErrorMessage( e.getMessage());
		}
		return rt;
	}
	
	private InterviewFailure makeInterviewFailure(Interview interview, Integer staffId,Integer feedbackId){
		InterviewFailure interviewFailure = new InterviewFailure();
		interviewFailure.setInterviewId( interview.getId());
		interviewFailure.setPersonId( interview.getPersonId());
		interviewFailure.setFeedbackId(feedbackId);
		interviewFailure.setName( interview.getName());
		interviewFailure.setEmail( interview.getEmail());
		interviewFailure.setPost( interview.getPost());
		interviewFailure.setStaffId( staffId );
		interviewFailure.setStatus( 0 );
		interviewFailure.setNotifyTime( HrUtils.addDateByWorkDay(interview.getMsTime(), Constants.FAILURE_NOTIFY_DAYS));
		return interviewFailure;
	}

}
