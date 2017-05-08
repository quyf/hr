package com.demo.hr.controller.cmd;

/**
 * 面试邀请中的面试官列表
 * @author quyf
 *
 */
public class InterviewerCmd {
	
	private Integer interviewId; // 面试邀请ID
	private Integer staffId; // 面试官员工ID
	private String staffName; // 面试官姓名
	private String email;	//邮箱
	private Integer needNofity; // 面试官需要填写面试反馈意见 0不需要 1需要
	
	public Integer getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Integer getNeedNofity() {
		return needNofity;
	}
	public void setNeedNofity(Integer needNofity) {
		this.needNofity = needNofity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
