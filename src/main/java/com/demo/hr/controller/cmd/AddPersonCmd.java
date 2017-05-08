package com.demo.hr.controller.cmd;

/**
 * hr添加人才
 * @author quyf
 *
 */
public class AddPersonCmd {
	
    private String name; //姓名
    private String post; //应聘岗位
    private String mobile; //手机
    private String email; //邮箱
    private Integer origin; //应聘渠道 0 无 1-10各种
    private Integer way; //简历获取方式 0 主动投递 1 简历下载 2推荐人
    private String wayInfo; //way=1时为简历下载地址 way=2时为推荐人姓名
    private Integer preInfo; //电话预约情况，1电话淘汰，2 待候选人考虑 3候选人不考虑
    private String note; //备注
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
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
	public Integer getPreInfo() {
		return preInfo;
	}
	public void setPreInfo(Integer preInfo) {
		this.preInfo = preInfo;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "AddPersonCmd [name=" + name + ", post=" + post + ", mobile=" + mobile + ", email=" + email + ", origin="
				+ origin + ", way=" + way + ", wayInfo=" + wayInfo + ", preInfo=" + preInfo + ", note=" + note + "]";
	}

    
}
