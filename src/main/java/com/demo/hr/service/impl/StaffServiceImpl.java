package com.demo.hr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hr.dao.StaffDao;
import com.demo.hr.entity.Staff;
import com.demo.hr.entity.criteria.StaffCriteria;
import com.demo.hr.service.StaffService;
import com.demo.hr.utils.Result;
import com.demo.hr.utils.ResultCode;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	StaffDao staffDao;
	
	public Staff getStaffById(int id) {
		try {
			return staffDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Staff getStaffById(Integer id, boolean isHr) throws Exception {
		Staff hr = staffDao.selectById(id);
		return hr;
	}

	public Result hrLogin(String account, String pwd) throws Exception {
		Result rt = new Result( ResultCode.DEFAULT_CODE );
		StaffCriteria sCrt = new StaffCriteria();
		StaffCriteria.Criteria crt = sCrt.createCriteria();
		
		crt.andMobileEqualTo(account);
		crt.andPwdEqualTo(pwd);
		sCrt.setLimit(1);
		List<Staff> staffList = staffDao.select(sCrt);
		if( staffList==null || staffList.size()==0 ){
			rt.setErrorMessage("手机或密码错误");
			return rt;
		}
		rt.setStatus( ResultCode.SUCCESS);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("id", staffList.get(0).getId());
		data.put("name", staffList.get(0).getName());
		rt.setData( data );
		return rt;
	}

	public List<Staff> getStaffList(Integer type) {
		StaffCriteria sCrt = new StaffCriteria();
		StaffCriteria.Criteria crt = sCrt.createCriteria();
		
		crt.andStatusEqualTo(1);//1状态有效，0离职无效
		//0:HR 1:面试官 
		if( type==0 ){
			crt.andTypeEqualTo(0);
		}else if( type==1 ){
			crt.andTypeEqualTo(1);
		}
		List<Staff> staffList = new ArrayList<Staff>();
		try {
			staffList = staffDao.select(sCrt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffList;
	}

	public int modifyPwd(Staff hr, String newPwd) {
		Staff updateStaff = new Staff();
		updateStaff.setId( hr.getId());
		updateStaff.setPwd( newPwd);
		try {
			return staffDao.updateById(updateStaff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
