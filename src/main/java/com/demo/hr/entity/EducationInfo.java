package com.demo.hr.entity;

/**
 * 教育信息
 * 
 * @author quyf
 *
 */
public class EducationInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id; //
    private Integer personId; //候选人ID
    private String beginDate; //开始时间
    private String endDate; //结束时间
    private String school; //学校
    private String major; //专业
    private String xueli; //学历
    private String way; //就读方式
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
	 * 学校
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school
	 *            学校
	 */
	public void setSchool(String school) {
		this.school = school;
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
	 * 学历
	 */
	public String getXueli() {
		return xueli;
	}

	/**
	 * @param xueli
	 *            学历
	 */
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	/**
	 * 就读方式
	 */
	public String getWay() {
		return way;
	}

	/**
	 * @param way
	 *            就读方式
	 */
	public void setWay(String way) {
		this.way = way;
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
