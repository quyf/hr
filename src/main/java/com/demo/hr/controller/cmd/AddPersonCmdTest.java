package com.demo.hr.controller.cmd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * hr添加人才
 * @author quyf
 *
 */
public class AddPersonCmdTest implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String account;
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date time;
	private List<String> list;
	
	private List<Tmp> tmpList;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public List<Tmp> getTmpList() {
		return tmpList;
	}
	public void setTmpList(List<Tmp> tmpList) {
		this.tmpList = tmpList;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	@Override
	public String toString() {
		return "AddPersonCmdTest [account=" + account + ", name=" + name + ", time=" + time + ", list=" + list
				+ ", tmpList=" + tmpList + "]";
	}
	
	public static void main(String[] args) {
		AddPersonCmdTest t = new AddPersonCmdTest();
		String account = "account中文";String name="name中文";
		Date time = new Date();
		
		List<Tmp> tmpList = new ArrayList<Tmp>();
		System.out.println( JSON.toJSONString(tmpList));
		t.setAccount(account);
		t.setName(name);
		t.setTime(time);
		t.setTmpList(tmpList);
		System.out.println( JSON.toJSONString(t));
	}
}

