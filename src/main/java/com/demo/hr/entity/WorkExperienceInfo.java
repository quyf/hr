package com.demo.hr.entity;

/**
 * 工作经历
 * 
 * @author quyf
 *
 */
public class WorkExperienceInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id; //
    private Integer personId; //候选人ID
    private String beginDate; //开始时间
    private String endDate; //结束时间
    private String company; //公司
    private String title; //职位
    private String reason; //离职原因
    private String salary; //当时薪资
    private Integer num; //展示顺序
    private java.util.Date createTime; //创建时间
    private java.util.Date modifyTime; //修改时间

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
	 * 开始时间
	 */
	public String getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate
	 *            开始时间
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * 结束时间
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            结束时间
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 公司
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            公司
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 职位
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            职位
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 离职原因
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reson
	 *            离职原因
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * 当时薪资
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            当时薪资
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

    /**
     * 展示顺序
     */	
    public Integer getNum() {
        return num;
    }

    /**
     * @param num 展示顺序
     */
    public void setNum(Integer num) {
        this.num = num;
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
