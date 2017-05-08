package com.demo.hr.service;

import java.util.List;

import com.demo.hr.entity.Staff;
import com.demo.hr.utils.Result;

public interface StaffService {
	
	
	public Staff getStaffById(int id);
	
	/**
	 * 
	 * @param id
	 * @param isHr true表示查询hr false则不关心员工角色
	 * @return
	 */
	public Staff getStaffById(Integer id, boolean isHr) throws Exception;

	public Result hrLogin(String account, String pwd) throws Exception;

	public List<Staff> getStaffList(Integer type);
	
	public int modifyPwd(Staff hr, String newPwd);


}
