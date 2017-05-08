package com.demo.hr.entity;

public class PersonBaseInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id; //
    private Integer personId; //候选人ID
    private String post; //应聘岗位
    private String name; //姓名
    private String sex; //性别，男女
    private String jiguan; //籍贯
    private String minzu; //民族
    private String birthday; //出生日期
    private String nowAddress; //现居地址
    private Integer marrayFlag; //婚姻状态 0未婚 1已婚
    private String peiouName; //配偶姓名
    private String workCompany; //配偶工作单位
    private Integer babys; //子女数量
    private Integer dispute; //是否与之前就职公司存在法律纠纷 0 无 1有
    private String yearSalary; //税前年薪
    private String monthSalary; //税前月薪
    private String workTime; //到岗时间
    private String promisee; //承诺人
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
	 * 应聘岗位
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @param post
	 *            应聘岗位
	 */
	public void setPost(String post) {
		this.post = post;
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
	 * 性别，男女
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            性别，男女
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 籍贯
	 */
	public String getJiguan() {
		return jiguan;
	}

	/**
	 * @param jiguan
	 *            籍贯
	 */
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	/**
	 * 民族
	 */
	public String getMinzu() {
		return minzu;
	}

	/**
	 * @param minzu
	 *            民族
	 */
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	/**
	 * 出生日期
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            出生日期
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 现居地址
	 */
	public String getNowAddress() {
		return nowAddress;
	}

	/**
	 * @param nowAddress
	 *            现居地址
	 */
	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}

	/**
	 * 婚姻状态 0未婚 1已婚
	 */
	public Integer getMarrayFlag() {
		return marrayFlag;
	}

	/**
	 * @param marrayFlag
	 *            婚姻状态 0未婚 1已婚
	 */
	public void setMarrayFlag(Integer marrayFlag) {
		this.marrayFlag = marrayFlag;
	}

	/**
	 * 配偶姓名
	 */
	public String getPeiouName() {
		return peiouName;
	}

	/**
	 * @param peiouName
	 *            配偶姓名
	 */
	public void setPeiouName(String peiouName) {
		this.peiouName = peiouName;
	}

	/**
	 * 配偶工作单位
	 */
	public String getWorkCompany() {
		return workCompany;
	}

	/**
	 * @param workCompany
	 *            配偶工作单位
	 */
	public void setWorkCompany(String workCompany) {
		this.workCompany = workCompany;
	}

	/**
	 * 子女数量
	 */
	public Integer getBabys() {
		return babys;
	}

	/**
	 * @param babys
	 *            子女数量
	 */
	public void setBabys(Integer babys) {
		this.babys = babys;
	}

	/**
	 * 是否与之前就职公司存在法律纠纷 0 无 1有
	 */
	public Integer getDispute() {
		return dispute;
	}

	/**
	 * @param dispute
	 *            是否与之前就职公司存在法律纠纷 0 无 1有
	 */
	public void setDispute(Integer dispute) {
		this.dispute = dispute;
	}

    /**
     * 税前年薪
     */	
    public String getYearSalary() {
        return yearSalary;
    }

    /**
     * @param yearSalary 税前年薪
     */
    public void setYearSalary(String yearSalary) {
        this.yearSalary = yearSalary;
    }

    /**
     * 税前月薪
     */	
    public String getMonthSalary() {
        return monthSalary;
    }

    /**
     * @param monthSalary 税前月薪
     */
    public void setMonthSalary(String monthSalary) {
        this.monthSalary = monthSalary;
    }

	/**
	 * 到岗时间
	 */
	public String getWorkTime() {
		return workTime;
	}

	/**
	 * @param workTime
	 *            到岗时间
	 */
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	/**
	 * 承诺人
	 */
	public String getPromisee() {
		return promisee;
	}

	/**
	 * @param promisee
	 *            承诺人
	 */
	public void setPromisee(String promisee) {
		this.promisee = promisee;
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
