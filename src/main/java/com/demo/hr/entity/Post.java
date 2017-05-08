package com.demo.hr.entity;

import java.io.Serializable;

public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Integer id; //
    private String post; //应聘岗位
    private String postLink; //应聘岗位连接
    private java.util.Date createTime; //创建时间
    private java.util.Date modifyTime; //修改时间
    private Integer status; //1 在线，0下线
	
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
     * 应聘岗位连接
     */	
    public String getPostLink() {
        return postLink;
    }

    /**
     * @param postLink 应聘岗位连接
     */
    public void setPostLink(String postLink) {
        this.postLink = postLink;
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

    /**
     * 1 在线，0下线
     */	
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status 1 在线，0下线
     */
    public void setStatus(Integer status) {
        this.status = status;
    }



}