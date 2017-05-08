package com.demo.hr.entity;

import java.io.Serializable;

public class InterviewFailure implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id; //
    private Integer interviewId; //面试邀请ID
    private Integer feedbackId; //导致淘汰的面试反馈ID
    private Integer personId; //候选人ID
    private String email; //候选人邮箱
    private String name; //姓名
    private String post; //应聘岗位
    private Integer staffId; //淘汰你的面试官,对应staff表
    private java.util.Date notifyTime; //通知时间,面试开始时间后2个工作日
    private java.util.Date notifyEndTime; //通知完成时间
    private java.util.Date createTime; //创建时间
    private Integer status; //通知状态 0 未通知 1 已通知

	
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
     * @param interviewId 面试邀请ID
     */
    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    /**
     * 导致淘汰的面试反馈ID
     */	
    public Integer getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId 导致淘汰的面试反馈ID
     */
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * 候选人ID
     */	
    public Integer getPersonId() {
        return personId;
    }

    /**
     * @param personId 候选人ID
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * 候选人邮箱
     */	
    public String getEmail() {
        return email;
    }

    /**
     * @param email 候选人邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 姓名
     */	
    public String getName() {
        return name;
    }

    /**
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 应聘岗位
     */	
    public String getPost() {
        return post;
    }

    /**
     * @param post 应聘岗位
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 淘汰你的面试官,对应staff表
     */	
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId 淘汰你的面试官,对应staff表
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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
     * 通知状态 0 未通知 1 已通知
     */	
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 通知状态 0 未通知 1 已通知
     */
    public void setStatus(Integer status) {
        this.status = status;
    }



}