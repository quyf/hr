package com.demo.hr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.demo.hr.controller.cmd.CreateInterviewCmd;
import com.demo.hr.controller.cmd.InterviewerCmd;
import com.demo.hr.dao.FeedbackTaskDao;
import com.demo.hr.dao.InterviewDao;
import com.demo.hr.dao.InterviewerDao;
import com.demo.hr.dao.PersonDao;
import com.demo.hr.dao.PostDao;
import com.demo.hr.entity.FeedbackTask;
import com.demo.hr.entity.Interview;
import com.demo.hr.entity.Interviewer;
import com.demo.hr.entity.Person;
import com.demo.hr.entity.Post;
import com.demo.hr.entity.criteria.InterviewCriteria;
import com.demo.hr.job.InterviewInviteEmailJob;
import com.demo.hr.service.InterviewService;
import com.demo.hr.utils.HrUtils;
import com.demo.hr.utils.NullUtils;

@Service
public class InterviewServiceImpl implements InterviewService{

	@Autowired
	PersonDao personDao;
	@Autowired
	InterviewDao interviewDao;
	@Autowired
	InterviewerDao interviewerDao;
	@Autowired
	FeedbackTaskDao feedbackTaskDao;
	@Autowired
	PostDao postDao;
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	public Interview getInterviewById(Integer id) {
		Interview interview = null;
		try {
			interview = interviewDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return interview;
	}
	
	public Interview getInterviewInfoById(Integer id) {
		Interview interview = getInterviewById( id );
		if( interview == null )
			return null;
		
		try {
			List<Interviewer> interviewerList = interviewerDao.selectByInterviewId( interview.getId() );
			interview.setInterviewerList(interviewerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return interview;
	}

	public List<Interview> getList(String likeAccount, Integer offset, Integer pageSize) {
		InterviewCriteria pCrt = new InterviewCriteria();
		InterviewCriteria.Criteria crt = pCrt.createCriteria();
		pCrt.setLimit(pageSize);
		pCrt.setOffset(offset);
		pCrt.setSortByDesc("id");
		if( !NullUtils.isEmpty(likeAccount) ){
			crt.andNameLike( likeAccount.trim() );
		}
		List<Interview> infoList = null ;
		try {
			infoList = interviewDao.select( pCrt );
		} catch (Exception e) {
			e.printStackTrace();
		}
		if( infoList==null ){
			infoList = new ArrayList<Interview>();
		}
		return infoList;
	}

	public int createInterview(Person person, CreateInterviewCmd createCmd)  {
		Integer postId = createCmd.getPostId();
		
		Post post = null;
		try {
			post = postDao.selectById( postId );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if( null == post ){
			return -1;
		}
		Interview interview = new Interview();
		interview.setName( createCmd.getName() );
		interview.setPost( post.getPost());
		interview.setPostLink( createCmd.getPostLink());
		interview.setMobile( createCmd.getMobile() );
		interview.setEmail( createCmd.getEmail());
		
		interview.setOrigin( createCmd.getOrigin());
		interview.setWay( createCmd.getWay() );
		interview.setWayInfo( createCmd.getWayInfo());
		interview.setMsTime( createCmd.getMsTime());
		interview.setMsAddress( createCmd.getMsAddress());
		interview.setMsType( createCmd.getMsType());
		interview.setHrId( createCmd.getHrId() );
		interview.setHrName( createCmd.getHrName() );
		interview.setHrEmail( createCmd.getHrEmail());
		interview.setHrMobile( createCmd.getHrMobile());
		
		//事务开始
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(txDef);
		try {
			if( person == null ){//如果是没有候选人信息，则需插入
				person = new Person();
				person.setName( createCmd.getName());
				person.setPost( post.getPost());
				person.setMobile( createCmd.getMobile() );
				
				person.setEmail( createCmd.getEmail() );
				person.setOrigin( createCmd.getOrigin() );
				person.setWay( createCmd.getWay() );
				
				person.setWayInfo( createCmd.getWayInfo() );
				person.setPreInfo( 0 );
				if( createCmd.getMsType()==0 ){//初试
					person.setCsTime( createCmd.getMsTime());
				}else if( createCmd.getMsType()==1 ){//复试
					person.setFsTime( createCmd.getMsTime());
				}
				
				personDao.insert(person);
			}else{
				Person updatePerson = new Person();
				updatePerson.setId( person.getId()  );
				if( createCmd.getMsType()==0 ){//初试
					updatePerson.setCreateTime( createCmd.getMsTime());
				}else if( createCmd.getMsType()==1 ){//复试
					updatePerson.setFsTime( createCmd.getMsTime());
				}
				updatePerson.setModifyTime(new Date());
				personDao.updateById( updatePerson );
			}
			interview.setPersonId( person.getId() );
			interviewDao.insert( interview );
			//更新职位连接
			if( !NullUtils.isEmpty(post.getPostLink())){
				Post updatePost = new Post();
				updatePost.setId( postId );
				updatePost.setPostLink( createCmd.getPostLink());
				postDao.updateById(updatePost);
			}
			
			List<Interviewer> viewerList = new ArrayList<Interviewer>();//需要通知会议邀请的面试官列表
			//插入面试官信息
			List<InterviewerCmd> interviewerList = createCmd.getInterviewerList();
			for(InterviewerCmd interviewer:interviewerList){
				Interviewer viewer = new Interviewer();
				viewer.setInterviewId( interview.getId() );
				viewer.setPersonId( person.getId() );
				viewer.setStaffId( interviewer.getStaffId());
				viewer.setStaffName( interviewer.getStaffName());
				viewer.setEmail( interviewer.getEmail());
				viewer.setNeedNofity( interviewer.getNeedNofity());
				interviewerDao.insert(viewer);
				if( interviewer.getNeedNofity()==1 ){
					viewerList.add(viewer);
				}
			}
			Date notifyTime = HrUtils.addHour(createCmd.getMsTime(), 2);
			
			//根据面试的 时间 插入 面试评估的邮件task
			FeedbackTask taskHr = new FeedbackTask();
			taskHr.setInterviewId( interview.getId());
			taskHr.setPersonId( person.getId());
			taskHr.setMsType( createCmd.getMsType() );
			taskHr.setMsTime( createCmd.getMsTime());
			taskHr.setNotifyTime( notifyTime );
			taskHr.setType( 0 );
			taskHr.setStaffId( interview.getHrId());
			taskHr.setStaffEmail( interview.getHrEmail());
			taskHr.setStaffName( interview.getHrName());
			feedbackTaskDao.insert(taskHr);
			//插入面试官通知
			for(InterviewerCmd interviewer:interviewerList){
				if( interviewer.getNeedNofity()==0 ){
					continue;
				}
				FeedbackTask task = new FeedbackTask();
				task.setInterviewId( interview.getId());
				task.setPersonId( person.getId());
				task.setMsType( createCmd.getMsType() );
				task.setMsTime( createCmd.getMsTime());
				task.setNotifyTime( notifyTime );
				task.setType( 1 );
				task.setStaffId( interviewer.getStaffId());
				task.setStaffEmail( interviewer.getEmail());
				task.setStaffName( interviewer.getStaffName());
				feedbackTaskDao.insert(task);
			}
			transactionManager.commit(status);
			//TODO 异步通知 候选人面试1、发给候选人 2、发给面试官，面试官以会议邀请的形式通知  3、属于 异步，发送失败问题
			HrUtils.submit(new InterviewInviteEmailJob(interview,viewerList));
			
			return 200;
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		
		return -1;
	}

}
