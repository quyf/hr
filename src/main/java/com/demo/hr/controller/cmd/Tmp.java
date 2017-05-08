package com.demo.hr.controller.cmd;

import java.util.Date;

public class Tmp{
	private String name;
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")  
	private Date now;
	
	public String getName() {
		return name;
	}
	public Date getNow() {
		return now;
	}
	public void setNow(Date now) {
		this.now = now;
	}
	public void setName(String name) {
		this.name = name;
	}
}
