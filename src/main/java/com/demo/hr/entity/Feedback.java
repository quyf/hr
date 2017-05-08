package com.demo.hr.entity;

/**
 * 面试反馈
 * 
 * @author
 *
 */
public class Feedback implements java.io.Serializable {
	private static final long serialVersionUID = 1l;

	private Integer id; //
	private Integer feedbackId; // 反馈通知ID
	private Integer interviewId; // 面试邀请ID
	private Integer personId; // 候选人ID
	private String personName; // 候选人姓名
	private Integer staffId; // 反馈员工ID
	private String staffName; // 反馈员工姓名
	private Integer msType; // 0 初试 1复试
	private Integer type; // 类型 0 hr 1面试官的反馈
	private Integer result; // 面试官反馈结果 0 无 1通过 2存档备选 3不通过
	private String content; // 反馈内容
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
	 * 反馈通知ID
	 */
	public Integer getFeedbackId() {
		return feedbackId;
	}

	/**
	 * @param feedbackId
	 *            反馈通知ID
	 */
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
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
	 * 候选人姓名
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName
	 *            候选人姓名
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * 反馈员工ID
	 */
	public Integer getStaffId() {
		return staffId;
	}

	/**
	 * @param staffId
	 *            反馈员工ID
	 */
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	/**
	 * 反馈员工姓名
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * @param staffName
	 *            反馈员工姓名
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * 0 初试 1复试
	 */
	public Integer getMsType() {
		return msType;
	}

	/**
	 * @param msType
	 *            0 初试 1复试
	 */
	public void setMsType(Integer msType) {
		this.msType = msType;
	}

	/**
	 * 类型 0 hr 1面试官的反馈
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            类型 0 hr 1面试官的反馈
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 面试官反馈结果 0 无 1通过 2存档备选 3不通过
	 */
	public Integer getResult() {
		return result;
	}

	/**
	 * @param result
	 *            面试官反馈结果 0 无 1通过 2存档备选 3不通过
	 */
	public void setResult(Integer result) {
		this.result = result;
	}

	/**
	 * 反馈内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            反馈内容
	 */
	public void setContent(String content) {
		this.content = content;
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
