package com.demo.hr.entity;

import java.util.List;

/**
 * 面试邀请
 * 
 * @author quyf
 *
 */
public class Interview implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id; //
    private Integer personId; //候选人ID
    private String name; //姓名
    private String post; //应聘岗位
    private String postLink; //应聘岗位连接
    private String mobile; //联系电话
    private String email; //邮箱
    private Integer origin; //应聘渠道 0 无 1-10各种
    private Integer way; //简历获取方式 0 主动投递 1 简历下载 2推荐人
    private String wayInfo; //way=1时为简历下载地址 way=2时为推荐人姓名
    private java.util.Date msTime; //面试时间
    private String msAddress; //面试地址
    private Integer msType; //0 初试 1复试
    private Integer hrId; //联系的HR
    private String hrName; //HR姓名
    private String hrEmail;//HR邮箱
    private String hrMobile; //hr联系电话
    private String note; //备注
    private Integer msResult; //面试官反馈结果 0 无 1通过 2存档备选 3不通过
    private Integer hrResult; //HR反馈结果 0 无 1通过 2存档备选 3不通过
    private java.util.Date createTime; //创建时间

    private List<Interviewer> interviewerList;//面试官列表
    
	public List<Interviewer> getInterviewerList() {
		return interviewerList;
	}

	public void setInterviewerList(List<Interviewer> interviewerList) {
		this.interviewerList = interviewerList;
	}

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
	 * 应聘岗位连接
	 */
	public String getPostLink() {
		return postLink;
	}

	/**
	 * @param postLink
	 *            应聘岗位连接
	 */
	public void setPostLink(String postLink) {
		this.postLink = postLink;
	}

	/**
	 * 联系电话
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            联系电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 应聘渠道 0 无 1-10各种
	 */
	public Integer getOrigin() {
		return origin;
	}

	/**
	 * @param origin
	 *            应聘渠道 0 无 1-10各种
	 */
	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	/**
	 * 简历获取方式 0 主动投递 1 简历下载 2推荐人
	 */
	public Integer getWay() {
		return way;
	}

	/**
	 * @param way
	 *            简历获取方式 0 主动投递 1 简历下载 2推荐人
	 */
	public void setWay(Integer way) {
		this.way = way;
	}

	/**
	 * way=1时为简历下载地址 way=2时为推荐人姓名
	 */
	public String getWayInfo() {
		return wayInfo;
	}

	/**
	 * @param wayInfo
	 *            way=1时为简历下载地址 way=2时为推荐人姓名
	 */
	public void setWayInfo(String wayInfo) {
		this.wayInfo = wayInfo;
	}

	/**
	 * 面试时间
	 */
	public java.util.Date getMsTime() {
		return msTime;
	}

	/**
	 * @param msTime
	 *            面试时间
	 */
	public void setMsTime(java.util.Date msTime) {
		this.msTime = msTime;
	}

	/**
	 * 面试地址
	 */
	public String getMsAddress() {
		return msAddress;
	}

	/**
	 * @param msAddress
	 *            面试地址
	 */
	public void setMsAddress(String msAddress) {
		this.msAddress = msAddress;
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
	 * 联系的HR
	 */
	public Integer getHrId() {
		return hrId;
	}

	/**
	 * @param hrId
	 *            联系的HR
	 */
	public void setHrId(Integer hrId) {
		this.hrId = hrId;
	}

	/**
	 * HR姓名
	 */
	public String getHrName() {
		return hrName;
	}

	/**
	 * @param hrName
	 *            HR姓名
	 */
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrEmail() {
		return hrEmail;
	}

	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}

	/**
	 * hr联系电话
	 */
	public String getHrMobile() {
		return hrMobile;
	}

	/**
	 * @param hrMobile
	 *            hr联系电话
	 */
	public void setHrMobile(String hrMobile) {
		this.hrMobile = hrMobile;
	}

	/**
	 * 备注
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note
	 *            备注
	 */
	public void setNote(String note) {
		this.note = note;
	}

    /**
     * 面试结果 0 无 1通过 2存档备选 3不通过
     */	
    public Integer getMsResult() {
        return msResult;
    }

    /**
     * @param msResult 面试结果 0 无 1通过 2存档备选 3不通过
     */
    public void setMsResult(Integer msResult) {
        this.msResult = msResult;
    }

    /**
     * HR反馈结果 0 无 1通过 2存档备选 3不通过
     */	
    public Integer getHrResult() {
        return hrResult;
    }

    /**
     * @param hrResult HR反馈结果 0 无 1通过 2存档备选 3不通过
     */
    public void setHrResult(Integer hrResult) {
        this.hrResult = hrResult;
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
