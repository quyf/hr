package com.demo.hr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.hr.entity.Person;
import com.demo.hr.entity.criteria.PersonCriteria;

public interface PersonDao {

	int insert(Person person) throws Exception;

	int deleteById(Integer id) throws Exception;

	int delete(PersonCriteria personCriteria) throws Exception;

	int updateById(Person person) throws Exception;

	int update(@Param("record") Person person, @Param("criteria")  PersonCriteria personCriteria) throws Exception;

	int count(PersonCriteria personCriteria) throws Exception;

	Person selectById(Integer id) throws Exception;
	
	Person selectByMobile(String mobile) throws Exception;

	List<Person> select(PersonCriteria personCriteria) throws Exception;
}
