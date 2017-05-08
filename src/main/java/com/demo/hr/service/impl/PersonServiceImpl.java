package com.demo.hr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.demo.hr.controller.cmd.AddPersonCmd;
import com.demo.hr.controller.cmd.AddPersonInfoCmd;
import com.demo.hr.dao.EducationInfoDao;
import com.demo.hr.dao.PersonBaseInfoDao;
import com.demo.hr.dao.PersonDao;
import com.demo.hr.dao.ReferenceInfoDao;
import com.demo.hr.dao.WorkExperienceInfoDao;
import com.demo.hr.entity.EducationInfo;
import com.demo.hr.entity.Person;
import com.demo.hr.entity.PersonBaseInfo;
import com.demo.hr.entity.PersonInfo;
import com.demo.hr.entity.ReferenceInfo;
import com.demo.hr.entity.Staff;
import com.demo.hr.entity.WorkExperienceInfo;
import com.demo.hr.entity.criteria.PersonCriteria;
import com.demo.hr.service.PersonService;
import com.demo.hr.utils.NullUtils;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao;
	@Autowired
	PersonBaseInfoDao personBaseInfoDao;
	@Autowired
	ReferenceInfoDao referenceInfoDao;
	@Autowired
	EducationInfoDao educationInfoDao;
	@Autowired
	WorkExperienceInfoDao workExperienceInfoDao;
	
	@Autowired
	DataSourceTransactionManager transactionManager;
	
	public Result login(String account, String pwd, String name) throws Exception {
		
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		PersonCriteria pCrt = new PersonCriteria();
		PersonCriteria.Criteria crt = pCrt.createCriteria();
		
		crt.andMobileEqualTo(account);
		//crt.andNameEqualTo(name);
		pCrt.setLimit(1);
		List<Person> personList = personDao.select(pCrt);
		if( personList==null || personList.size()==0 ){
			rt.setErrorMessage("手机或姓名错误");
			return rt;
		}
		rt.setStatus( ResultCode.SUCCESS);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("id", personList.get(0).getId());
		data.put("name", personList.get(0).getName());
		rt.setData( data );
		return rt;
	}
	
	public List<Person> getPersonList(String likeAccount, Integer offset, Integer pageSize) throws Exception {
		PersonCriteria pCrt = new PersonCriteria();
		PersonCriteria.Criteria crt = pCrt.createCriteria();
		pCrt.setLimit(pageSize);
		pCrt.setOffset(offset);
		pCrt.setSortByDesc("id");
		if( !NullUtils.isEmpty(likeAccount) ){
			crt.andMobileLike( likeAccount.trim() );
		}
		List<Person> infoList = personDao.select( pCrt );
		if( infoList==null ){
			infoList = new ArrayList<Person>();
		}
		return infoList;
	}

	public int addPerson(Staff hr, AddPersonCmd addCmd) throws Exception {
		Person person = new Person();
		person.setName( addCmd.getName());
		person.setPost( addCmd.getPost());
		person.setMobile( addCmd.getMobile() );
		
		person.setEmail( addCmd.getEmail() );
		person.setOrigin( addCmd.getOrigin() );
		person.setWay( addCmd.getWay() );
		
		person.setWayInfo( addCmd.getWayInfo() );
		person.setPreInfo( addCmd.getPreInfo() );
		person.setNote( addCmd.getNote() );
		personDao.insert(person);
		return person.getId();
	}

	public Person getById(Integer id) throws Exception {
		if( id<1 ){
			return null;
		}
		return personDao.selectById(id);
	}
	
	public Person getByMobile(String mobile) throws Exception {
		if( NullUtils.isEmpty( mobile )){
			return null;
		}
		return personDao.selectByMobile(mobile);
	}

	public PersonInfo getInfoByPId(Integer pid) {
		PersonBaseInfo baseInfo = personBaseInfoDao.selectByPersonId( pid );
		if( baseInfo==null ){//个人简历信息都没有，肯定没填写，直接返回
			return null;
		}
		
		PersonInfo info = new PersonInfo();
		info.setPersonBaseInfos(baseInfo);
		List<EducationInfo> educationInfos = educationInfoDao.selectByPersonId( pid );
		if( educationInfos==null ){
			educationInfos = new ArrayList<EducationInfo>();
		}
		info.setEducationInfos(educationInfos);
		List<WorkExperienceInfo> workExperienceInfos = workExperienceInfoDao.selectByPersonId(pid);
		if( workExperienceInfos==null ){
			workExperienceInfos = new ArrayList<WorkExperienceInfo>();
		}
		info.setWorkExperienceInfos(workExperienceInfos);
		ReferenceInfo referenceInfo = referenceInfoDao.selectByPersonId(pid);
		if( referenceInfo==null ){
			referenceInfo = new ReferenceInfo();
		}
		info.setReferenceInfo(referenceInfo);
		return info;
	}
	
	public int addPersonInfo(Person person, AddPersonInfoCmd addCmd) {
		//开启事务
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction( txDef );
		
		try {
			int personId = person.getId();
			PersonBaseInfo baseInfo = addCmd.getPersonBaseInfos();
			if( baseInfo!=null ){
				baseInfo.setPersonId( personId );
				personBaseInfoDao.insert( baseInfo );
			}
			List<EducationInfo> educationInfos = addCmd.getEducationInfos();
			if( educationInfos!=null && educationInfos.size()>0 ){
				
				for(EducationInfo info:educationInfos ){
					info.setPersonId(personId);
					educationInfoDao.insert(info);
				}
			}
			List<WorkExperienceInfo> workExperienceInfos = addCmd.getWorkExperienceInfos();
			if( workExperienceInfos!=null && workExperienceInfos.size()>0 ){
				for(WorkExperienceInfo info:workExperienceInfos ){
					info.setPersonId(personId);
					workExperienceInfoDao.insert(info);
				}
			}
			
			ReferenceInfo referenceInfo = addCmd.getReferenceInfo();
			if( referenceInfo!=null ){
				referenceInfo.setPersonId(personId);
				referenceInfoDao.insert(referenceInfo);
			}
			
			transactionManager.commit(status);
			return 200;
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return 0;
	}


}
