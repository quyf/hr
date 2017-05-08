package com.demo.hr.entity;

/**
 * 背景信息
 * 
 * @author quyf
 *
 */
public class ReferenceInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; //
	private Integer personId; // 候选人ID
	private String hrName; // 证明人姓名
	private String hrComTitle; // 单位名称及职务
	private String hrLink; // 联系方式
	private String hrEmail; // 邮箱
	private String leaderName; // 证明人姓名
	private String ldComTitle; // 单位名称及职务
	private String ldLink; // 联系方式
	private String ldEmail; // 邮箱
	private Integer hasYy; // 是否有用友成员公司及本公司亲属/朋友信息，0:无 1:有
	private String yyName; // 员工姓名
	private String yygx; // 与员工的关系
	private String yyTitle; // 员工职务
	private String yyEmail; // 员工邮箱
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
	 * 证明人姓名
	 */
	public String getHrName() {
		return hrName;
	}

	/**
	 * @param hrName
	 *            证明人姓名
	 */
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	/**
	 * 单位名称及职务
	 */
	public String getHrComTitle() {
		return hrComTitle;
	}

	/**
	 * @param hrComTitle
	 *            单位名称及职务
	 */
	public void setHrComTitle(String hrComTitle) {
		this.hrComTitle = hrComTitle;
	}

	/**
	 * 联系方式
	 */
	public String getHrLink() {
		return hrLink;
	}

	/**
	 * @param hrLink
	 *            联系方式
	 */
	public void setHrLink(String hrLink) {
		this.hrLink = hrLink;
	}

	/**
	 * 邮箱
	 */
	public String getHrEmail() {
		return hrEmail;
	}

	/**
	 * @param hrEmail
	 *            邮箱
	 */
	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}

	/**
	 * 证明人姓名
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * @param leaderName
	 *            证明人姓名
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * 单位名称及职务
	 */
	public String getLdComTitle() {
		return ldComTitle;
	}

	/**
	 * @param ldComTitle
	 *            单位名称及职务
	 */
	public void setLdComTitle(String ldComTitle) {
		this.ldComTitle = ldComTitle;
	}

	/**
	 * 联系方式
	 */
	public String getLdLink() {
		return ldLink;
	}

	/**
	 * @param ldLink
	 *            联系方式
	 */
	public void setLdLink(String ldLink) {
		this.ldLink = ldLink;
	}

	/**
	 * 邮箱
	 */
	public String getLdEmail() {
		return ldEmail;
	}

	/**
	 * @param ldEmail
	 *            邮箱
	 */
	public void setLdEmail(String ldEmail) {
		this.ldEmail = ldEmail;
	}

	/**
	 * 是否有用友成员公司及本公司亲属/朋友信息，0:无 1:有
	 */
	public Integer getHasYy() {
		return hasYy;
	}

	/**
	 * @param hasYy
	 *            是否有用友成员公司及本公司亲属/朋友信息，0:无 1:有
	 */
	public void setHasYy(Integer hasYy) {
		this.hasYy = hasYy;
	}

	/**
	 * 员工姓名
	 */
	public String getYyName() {
		return yyName;
	}

	/**
	 * @param yyName
	 *            员工姓名
	 */
	public void setYyName(String yyName) {
		this.yyName = yyName;
	}

	/**
	 * 与员工的关系
	 */
	public String getYygx() {
		return yygx;
	}

	/**
	 * @param yygx
	 *            与员工的关系
	 */
	public void setYygx(String yygx) {
		this.yygx = yygx;
	}

	/**
	 * 员工职务
	 */
	public String getYyTitle() {
		return yyTitle;
	}

	/**
	 * @param yyTitle
	 *            员工职务
	 */
	public void setYyTitle(String yyTitle) {
		this.yyTitle = yyTitle;
	}

	/**
	 * 员工邮箱
	 */
	public String getYyEmail() {
		return yyEmail;
	}

	/**
	 * @param yyEmail
	 *            员工邮箱
	 */
	public void setYyEmail(String yyEmail) {
		this.yyEmail = yyEmail;
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
