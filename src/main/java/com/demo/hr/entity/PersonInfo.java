package com.demo.hr.entity;

import java.util.List;

/**
 * 求职者详细信息
 * @author quyf
 *
 */
public class PersonInfo implements java.io.Serializable{
	private static final long serialVersionUID = 1l;
	
	private Integer personId;								//个人ID
	private PersonBaseInfo personBaseInfos;					//基本信息
	private List<EducationInfo> educationInfos;				//教育经历
	private List<WorkExperienceInfo> workExperienceInfos;	//工作经历
	private ReferenceInfo referenceInfo;					//背景信息
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public PersonBaseInfo getPersonBaseInfos() {
		return personBaseInfos;
	}
	public void setPersonBaseInfos(PersonBaseInfo personBaseInfos) {
		this.personBaseInfos = personBaseInfos;
	}
	public List<EducationInfo> getEducationInfos() {
		return educationInfos;
	}
	public void setEducationInfos(List<EducationInfo> educationInfos) {
		this.educationInfos = educationInfos;
	}
	public List<WorkExperienceInfo> getWorkExperienceInfos() {
		return workExperienceInfos;
	}
	public void setWorkExperienceInfos(List<WorkExperienceInfo> workExperienceInfos) {
		this.workExperienceInfos = workExperienceInfos;
	}
	public ReferenceInfo getReferenceInfo() {
		return referenceInfo;
	}
	public void setReferenceInfo(ReferenceInfo referenceInfo) {
		this.referenceInfo = referenceInfo;
	}
	
}
