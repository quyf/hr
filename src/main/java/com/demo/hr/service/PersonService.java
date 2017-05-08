package com.demo.hr.service;

import java.util.List;

import com.demo.hr.controller.cmd.AddPersonCmd;
import com.demo.hr.controller.cmd.AddPersonInfoCmd;
import com.demo.hr.entity.Person;
import com.demo.hr.entity.PersonInfo;
import com.demo.hr.entity.Staff;
import com.demo.hr.utils.Result;

public interface PersonService {

	/**
	 * 登录
	 * @param account
	 * @param pwd
	 * @param name
	 * @return
	 */
	public Result login(String account, String pwd, String name) throws Exception;
	
	/**
	 * 获取求职者
	 * @param id
	 * @return
	 */
	public Person getById(Integer id) throws Exception;
	
	/**
	 * 获取求职者
	 * @param id
	 * @return
	 */
	public Person getByMobile(String mobile) throws Exception;
	
	/**
	 * 获取个人简历信息
	 * @param pid
	 * @return
	 */
	public PersonInfo getInfoByPId(Integer pid);

	/**
	 * hr获取人才列表
	 * @param likeAccount
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Person> getPersonList(String likeAccount, Integer offset, Integer pageSize) throws Exception;

	/**
	 * hr新增人才
	 * @param addCmd
	 * @return
	 */
	public int addPerson(Staff hr,AddPersonCmd addCmd) throws Exception;

	/**
	 * 更新个人简历信息，求职者自己填写时调用
	 * @param person
	 * @param addCmd
	 * @return
	 */
	public int addPersonInfo(Person person, AddPersonInfoCmd addCmd);
	
}
