package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.Staff;
import com.demo.hr.entity.criteria.StaffCriteria;


public interface StaffDao {
	int insert(Staff staff) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(StaffCriteria staffCriteria) throws Exception;
	
	int updateById(Staff staff) throws Exception;
	
	int update(@Param("record") Staff staff,@Param("criteria")  StaffCriteria staffCriteria) throws Exception;
	
	int count(StaffCriteria staffCriteria) throws Exception;
	
	Staff selectById(Integer id) throws Exception;
	
	List<Staff> select(StaffCriteria staffCriteria) throws Exception;
}
