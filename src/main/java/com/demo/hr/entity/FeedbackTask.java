package com.demo.hr.entity;

import java.io.Serializable;

public class FeedbackTask implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id; //
    private Integer interviewId; //对应的面试邀请ID
    private Integer personId; //对应的候选人ID
    private Integer msType; //0 初试 1复试
    private java.util.Date msTime; //面试时间
    private Integer status; //发送状态 0 未发送 1 已发送
    private java.util.Date notifyTime; //通知时间,面试之后2小时
    private java.util.Date notifyEndTime; //通知完成时间
    private java.util.Date createTime; //创建时间
    
    private Integer type ;//通知类型 0 hr 1 面试官
    private Integer staffId;	//员工ID
    private String staffEmail;	//员工邮件
    private String staffName;	//员工名字
	
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
     * 对应的面试邀请ID
     */	
    public Integer getInterviewId() {
        return interviewId;
    }

    /**
     * @param interviewId 对应的面试邀请ID
     */
    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    /**
     * 对应的候选人ID
     */	
    public Integer getPersonId() {
        return personId;
    }

    /**
     * @param personId 对应的候选人ID
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * 0 初试 1复试
     */	
    public Integer getMsType() {
        return msType;
    }

    /**
     * @param msType 0 初试 1复试
     */
    public void setMsType(Integer msType) {
        this.msType = msType;
    }

    /**
     * 面试时间
     */	
    public java.util.Date getMsTime() {
        return msTime;
    }

    /**
     * @param msTime 面试时间
     */
    public void setMsTime(java.util.Date msTime) {
        this.msTime = msTime;
    }

    /**
     * 发送状态 0 未发送 1 已发送
     */	
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 发送状态 0 未发送 1 已发送
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 通知时间,面试之后2小时
     */	
    public java.util.Date getNotifyTime() {
        return notifyTime;
    }

    /**
     * @param notifyTime 通知时间,面试之后2小时
     */
    public void setNotifyTime(java.util.Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    /**
     * 通知完成时间
     */	
    public java.util.Date getNotifyEndTime() {
        return notifyEndTime;
    }

    /**
     * @param notifyEndTime 通知完成时间
     */
    public void setNotifyEndTime(java.util.Date notifyEndTime) {
        this.notifyEndTime = notifyEndTime;
    }

    /**
     * 创建时间
     */	
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 创建时间
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 通知对象 0 HR 1 面试官
     */	
    public Integer getType() {
        return type;
    }

    /**
     * @param type 通知对象 0 HR 1 面试官
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 通知对象ID,对应staff表
     */	
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId 通知对象ID,对应staff表
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * 通知对象的邮箱
     */	
    public String getStaffEmail() {
        return staffEmail;
    }

    /**
     * @param staffEmail 通知对象的邮箱
     */
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    /**
     * 通知对象姓名
     */	
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName 通知对象姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }



}