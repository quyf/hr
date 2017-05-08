package com.demo.hr.entity;

import java.io.Serializable;

/**
 * 面试官信息
 *  
 * @author quyf
 */
public class Interviewer implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; //
	private Integer interviewId; // 面试邀请ID
	private Integer personId; // 候选人ID
	private Integer staffId; // 面试官员工ID
	private String staffName; // 面试官姓名
	private String email;	//面试官邮箱
	private Integer needNofity; // 面试官需要填写面试反馈意见 0不需要 1需要
	private Integer notifyFlag; // 面试官是否已经填写面试反馈意见，0 没写 1写了
	private java.util.Date createTime; // 创建时间
	private java.util.Date modifyTime; // 修改时间



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
	 * 面试邀请ID
	 */
	public Integer getInterviewId() {
		return interviewId;
	}

	/**
	 * @param interviewId
	 *            面试邀请ID
	 */
	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	/**
	 * 候选人ID
	 */
	public Integer getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            候选人ID
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	/**
	 * 面试官员工ID
	 */
	public Integer getStaffId() {
		return staffId;
	}

	/**
	 * @param staffId
	 *            面试官员工ID
	 */
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	/**
	 * 面试官姓名
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * @param staffName
	 *            面试官姓名
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

    /**
     * 面试官邮箱
     */	
    public String getEmail() {
        return email;
    }

    /**
     * @param email 面试官邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 面试官需要填写面试反馈意见 0不需要 1需要
     */	
    public Integer getNeedNofity() {
        return needNofity;
    }

	/**
	 * @param needNofity
	 *            面试官需要填写面试反馈意见 0不需要 1需要
	 */
	public void setNeedNofity(Integer needNofity) {
		this.needNofity = needNofity;
	}

	/**
	 * 面试官是否已经填写面试反馈意见，0 没写 1写了
	 */
	public Integer getNotifyFlag() {
		return notifyFlag;
	}

	/**
	 * @param notifyFlag
	 *            面试官是否已经填写面试反馈意见，0 没写 1写了
	 */
	public void setNotifyFlag(Integer notifyFlag) {
		this.notifyFlag = notifyFlag;
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

	/**
	 * 修改时间
	 */
	public java.util.Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime
	 *            修改时间
	 */
	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}