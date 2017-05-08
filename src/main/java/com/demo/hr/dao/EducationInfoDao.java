package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.EducationInfo;
import com.demo.hr.entity.criteria.EducationInfoCriteria;

public interface EducationInfoDao {
	int insert(EducationInfo educationInfo) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(EducationInfoCriteria educationInfoCriteria) throws Exception;
	
	int updateById(EducationInfo educationInfo) throws Exception;

	int update(@Param("record") EducationInfo educationInfo,@Param("criteria")  EducationInfoCriteria educationInfoCriteria) throws Exception;
	
	int count(EducationInfoCriteria educationInfoCriteria) throws Exception;
	
	EducationInfo selectById(Integer id) throws Exception;
	
	List<EducationInfo> select(EducationInfoCriteria educationInfoCriteria) throws Exception;

	List<EducationInfo> selectByPersonId(Integer pid);
}
