package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.ReferenceInfo;
import com.demo.hr.entity.criteria.ReferenceInfoCriteria;

public interface ReferenceInfoDao {
	int insert(ReferenceInfo referenceInfo) throws Exception;
	
	int deleteById(Integer id) throws Exception;

	int delete(ReferenceInfoCriteria referenceInfoCriteria) throws Exception;
	
	int updateById(ReferenceInfo referenceInfo) throws Exception;
	
	int update(@Param("record") ReferenceInfo referenceInfo,@Param("criteria")  ReferenceInfoCriteria referenceInfoCriteria) throws Exception;
	
	int count(ReferenceInfoCriteria referenceInfoCriteria) throws Exception;
	
	ReferenceInfo selectById(Integer id) throws Exception;
	
	List<ReferenceInfo> select(ReferenceInfoCriteria referenceInfoCriteria) throws Exception;

	ReferenceInfo selectByPersonId(Integer pid);
}
