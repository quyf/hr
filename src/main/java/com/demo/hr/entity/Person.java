package com.demo.hr.entity;

public class Person implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id; //
    private String name; //姓名
    private String pwd; //
    private String post; //应聘岗位
    private String mobile; //手机
    private String email; //邮箱
    private java.util.Date csTime; //初试时间
    private java.util.Date fsTime; //复试时间
    private Integer csResult; //初试结果 0:暂无 1 复试 2存档备选 3 不合格
    private Integer fsResult; //初试结果 0:暂无 1 复试 2存档备选 3 不合格
    private Integer origin; //应聘渠道 0 无 1-10各种
    private Integer way; //简历获取方式 0 主动投递 1 简历下载 2推荐人
    private String wayInfo; //way=1时为简历下载地址 way=2时为推荐人姓名
    private Integer preInfo; //电话预约情况，1电话淘汰，2 待候选人考虑 3候选人不考虑
    private String note; //备注
    private String note2; //扩展备注
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
     * 手机
     */	
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile 手机
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
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 初试时间
     */	
    public java.util.Date getCsTime() {
        return csTime;
    }

    /**
     * @param csTime 初试时间
     */
    public void setCsTime(java.util.Date csTime) {
        this.csTime = csTime;
    }

    /**
     * 复试时间
     */	
    public java.util.Date getFsTime() {
        return fsTime;
    }

    /**
     * @param fsTime 复试时间
     */
    public void setFsTime(java.util.Date fsTime) {
        this.fsTime = fsTime;
    }

    /**
     * 初试结果 0:暂无 1 复试 2存档备选 3 不合格
     */	
    public Integer getCsResult() {
        return csResult;
    }

    /**
     * @param csResult 初试结果 0:暂无 1 复试 2存档备选 3 不合格
     */
    public void setCsResult(Integer csResult) {
        this.csResult = csResult;
    }

    /**
     * 初试结果 0:暂无 1 复试 2存档备选 3 不合格
     */	
    public Integer getFsResult() {
        return fsResult;
    }

    /**
     * @param fsResult 初试结果 0:暂无 1 复试 2存档备选 3 不合格
     */
    public void setFsResult(Integer fsResult) {
        this.fsResult = fsResult;
    }

    /**
     * 应聘渠道 0 无 1-10各种
     */	
    public Integer getOrigin() {
        return origin;
    }

    /**
     * @param origin 应聘渠道 0 无 1-10各种
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
     * @param way 简历获取方式 0 主动投递 1 简历下载 2推荐人
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
     * @param wayInfo way=1时为简历下载地址 way=2时为推荐人姓名
     */
    public void setWayInfo(String wayInfo) {
        this.wayInfo = wayInfo;
    }

    /**
     * 电话预约情况，1电话淘汰，2 待候选人考虑 3候选人不考虑
     */	
    public Integer getPreInfo() {
        return preInfo;
    }

    /**
     * @param preInfo 电话预约情况，1电话淘汰，2 待候选人考虑 3候选人不考虑
     */
    public void setPreInfo(Integer preInfo) {
        this.preInfo = preInfo;
    }

    /**
     * 备注
     */	
    public String getNote() {
        return note;
    }

    /**
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 扩展备注
     */	
    public String getNote2() {
        return note2;
    }

    /**
     * @param note2 扩展备注
     */
    public void setNote2(String note2) {
        this.note2 = note2;
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
     * 修改时间
     */	
    public java.util.Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime 修改时间
     */
    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
}
