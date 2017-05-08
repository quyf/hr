package com.demo.hr.controller.cmd;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * hr创建面试邀请
 * @author quyf
 *
 */
public class CreateInterviewCmd {
	
	private Integer personId; // 候选人ID
	private String name; // 姓名
	private Integer postId;//岗位ID
//	private String post; // 应聘岗位
	private String postLink; // 应聘岗位连接
	private String mobile; // 联系电话
	private String email; // 邮箱
	private Integer origin; // 应聘渠道 0 无 1-10各种
	private Integer way; // 简历获取方式 0 主动投递 1 简历下载 2推荐人
	private String wayInfo; // way=1时为简历下载地址 way=2时为推荐人姓名
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
	private java.util.Date msTime; // 面试时间
	private String msAddress; // 面试地址
	private Integer msType; // 0 初试 1复试
	private List<InterviewerCmd> interviewerList;//面试官列表
	private Integer hrId; // 联系的HR
	private String hrName; // HR姓名
	private String hrEmail;//hr邮箱
	private String hrMobile; // hr联系电话
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
//	public String getPost() {
//		return post;
//	}
//	public void setPost(String post) {
//		this.post = post;
//	}
	public String getPostLink() {
		return postLink;
	}
	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getOrigin() {
		return origin;
	}
	public void setOrigin(Integer origin) {
		this.origin = origin;
	}
	public Integer getWay() {
		return way;
	}
	public void setWay(Integer way) {
		this.way = way;
	}
	public String getWayInfo() {
		return wayInfo;
	}
	public void setWayInfo(String wayInfo) {
		this.wayInfo = wayInfo;
	}
	public java.util.Date getMsTime() {
		return msTime;
	}
	public void setMsTime(java.util.Date msTime) {
		this.msTime = msTime;
	}
	public String getMsAddress() {
		return msAddress;
	}
	public void setMsAddress(String msAddress) {
		this.msAddress = msAddress;
	}
	public Integer getMsType() {
		return msType;
	}
	public void setMsType(Integer msType) {
		this.msType = msType;
	}
	public List<InterviewerCmd> getInterviewerList() {
		return interviewerList;
	}
	public void setInterviewerList(List<InterviewerCmd> interviewerList) {
		this.interviewerList = interviewerList;
	}
	public Integer getHrId() {
		return hrId;
	}
	public void setHrId(Integer hrId) {
		this.hrId = hrId;
	}
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public String getHrEmail() {
		return hrEmail;
	}
	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}
	public String getHrMobile() {
		return hrMobile;
	}
	public void setHrMobile(String hrMobile) {
		this.hrMobile = hrMobile;
	}
	
}
