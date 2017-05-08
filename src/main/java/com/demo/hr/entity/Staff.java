package com.demo.hr.entity;

/**
 * 员工，包括了HR 面试官等信息
 * 
 * @author quyf
 *
 */
public class Staff implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id; //
	private String name; // 姓名
	private String pwd; //
	private String mobile; // 手机
	private String email; // 工作邮箱
	private String wechat; // 微信
	private String department; // 部门
	private String major; // 专业
	private Integer status; // 1状态有效，0离职无效
	private Integer type; // 0 面试官 1 HR角色的面试官
	private java.util.Date createTime; // 创建时间

	/**
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 手机
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 工作邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            工作邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 微信
	 */
	public String getWechat() {
		return wechat;
	}

	/**
	 * @param wechat
	 *            微信
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	/**
	 * 部门
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 专业
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * @param major
	 *            专业
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * 1状态有效，0离职无效
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            1状态有效，0离职无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 0 面试官 1 HR角色的面试官
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            0 面试官 1 HR角色的面试官
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
}
