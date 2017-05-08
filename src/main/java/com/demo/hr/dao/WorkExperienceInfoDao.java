package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.WorkExperienceInfo;
import com.demo.hr.entity.criteria.WorkExperienceInfoCriteria;


public interface WorkExperienceInfoDao {
	int insert(WorkExperienceInfo workExperienceInfo) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(WorkExperienceInfoCriteria workExperienceInfoCriteria) throws Exception;
	
	int updateById(WorkExperienceInfo workExperienceInfo) throws Exception;
	
	int update(@Param("record") WorkExperienceInfo workExperienceInfo,@Param("criteria")  WorkExperienceInfoCriteria workExperienceInfoCriteria) throws Exception;
	
	int count(WorkExperienceInfoCriteria workExperienceInfoCriteria) throws Exception;
	
	WorkExperienceInfo selectById(Integer id) throws Exception;
	
	List<WorkExperienceInfo> select(WorkExperienceInfoCriteria workExperienceInfoCriteria) throws Exception;

	List<WorkExperienceInfo> selectByPersonId(Integer pid);
}
