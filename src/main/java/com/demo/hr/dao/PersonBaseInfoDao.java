package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.PersonBaseInfo;
import com.demo.hr.entity.criteria.PersonBaseInfoCriteria;

public interface PersonBaseInfoDao {
	int insert(PersonBaseInfo personBaseInfo) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(PersonBaseInfoCriteria personBaseInfoCriteria) throws Exception;
	
	int updateById(PersonBaseInfo personBaseInfo) throws Exception;
	
	int update(@Param("record") PersonBaseInfo personBaseInfo,@Param("criteria")  PersonBaseInfoCriteria personBaseInfoCriteria) throws Exception;
	
	int count(PersonBaseInfoCriteria personBaseInfoCriteria) throws Exception;
	
	PersonBaseInfo selectById(Integer id) throws Exception;
	
	List<PersonBaseInfo> select(PersonBaseInfoCriteria personBaseInfoCriteria) throws Exception;

	PersonBaseInfo selectByPersonId(Integer pid);
}
