package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InterviewerCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public InterviewerCriteria() {
        oredCriteria = new ArrayList<Criteria>();
        extras = new HashMap<String, Object>();
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public void setSortByAsc(String sort) {
		this.sort = sort;
		this.order = "asc";
	}

	public void setSortByDesc(String sort) {
		this.sort = sort;
		this.order = "desc";
	}
	
	public void setSortOrder(String sort, String order) {
		this.sort = sort;
		this.order = order;
	}

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }


	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Object> extras) {
		this.extras = extras;
	}
	
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        sort = null;
        order = null;
        distinct = false;
    }
    

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, java.util.Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<java.util.Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Timestamp> dateList = new ArrayList<java.sql.Timestamp>();
            Iterator<java.util.Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Timestamp(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, java.util.Date value1, java.util.Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Timestamp(value1.getTime()), new java.sql.Timestamp(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, java.sql.Time value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, value, property);
        }

        protected void addCriterionForJDBCTime(String condition, List<java.sql.Time> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> dateList = new ArrayList<java.sql.Time>();
            Iterator<java.sql.Time> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(iter.next());
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCTime(String condition, java.sql.Time value1, java.sql.Time value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, value1, value2, property);
        }

	
        public Criteria andIdIsNull() {
            addCriterion("`id` IS NULL");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }
	
        public Criteria andIdIn(List<Integer> values) {
            addCriterion("`id` IN", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("`id` NOT IN", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("`id` BETWEEN", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`id` NOT BETWEEN", value1, value2, "id");
            return (Criteria) this;
        }
	
        public Criteria andInterviewIdIsNull() {
            addCriterion("`interview_id` IS NULL");
            return (Criteria) this;
        }

        public Criteria andInterviewIdIsNotNull() {
            addCriterion("`interview_id` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andInterviewIdEqualTo(Integer value) {
            addCriterion("`interview_id` =", value, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdNotEqualTo(Integer value) {
            addCriterion("`interview_id` <>", value, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdGreaterThan(Integer value) {
            addCriterion("`interview_id` >", value, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`interview_id` >=", value, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdLessThan(Integer value) {
            addCriterion("`interview_id` <", value, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdLessThanOrEqualTo(Integer value) {
            addCriterion("`interview_id` <=", value, "interviewId");
            return (Criteria) this;
        }
	
        public Criteria andInterviewIdIn(List<Integer> values) {
            addCriterion("`interview_id` IN", values, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdNotIn(List<Integer> values) {
            addCriterion("`interview_id` NOT IN", values, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdBetween(Integer value1, Integer value2) {
            addCriterion("`interview_id` BETWEEN", value1, value2, "interviewId");
            return (Criteria) this;
        }

        public Criteria andInterviewIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`interview_id` NOT BETWEEN", value1, value2, "interviewId");
            return (Criteria) this;
        }
	
        public Criteria andPersonIdIsNull() {
            addCriterion("`person_id` IS NULL");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("`person_id` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Integer value) {
            addCriterion("`person_id` =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Integer value) {
            addCriterion("`person_id` <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Integer value) {
            addCriterion("`person_id` >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`person_id` >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Integer value) {
            addCriterion("`person_id` <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("`person_id` <=", value, "personId");
            return (Criteria) this;
        }
	
        public Criteria andPersonIdIn(List<Integer> values) {
            addCriterion("`person_id` IN", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<Integer> values) {
            addCriterion("`person_id` NOT IN", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("`person_id` BETWEEN", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`person_id` NOT BETWEEN", value1, value2, "personId");
            return (Criteria) this;
        }
	
        public Criteria andStaffIdIsNull() {
            addCriterion("`staff_id` IS NULL");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("`staff_id` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("`staff_id` =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("`staff_id` <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("`staff_id` >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`staff_id` >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("`staff_id` <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("`staff_id` <=", value, "staffId");
            return (Criteria) this;
        }
	
        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("`staff_id` IN", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("`staff_id` NOT IN", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("`staff_id` BETWEEN", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`staff_id` NOT BETWEEN", value1, value2, "staffId");
            return (Criteria) this;
        }
	
        public Criteria andStaffNameIsNull() {
            addCriterion("`staff_name` IS NULL");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("`staff_name` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("`staff_name` =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("`staff_name` <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("`staff_name` >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("`staff_name` >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("`staff_name` <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("`staff_name` <=", value, "staffName");
            return (Criteria) this;
        }
	
        public Criteria andStaffNameLike(String value) {
            addCriterion("`staff_name` LIKE", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("`staff_name` NOT LIKE", value, "staffName");
            return (Criteria) this;
        }
	
        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("`staff_name` IN", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("`staff_name` NOT IN", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("`staff_name` BETWEEN", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("`staff_name` NOT BETWEEN", value1, value2, "staffName");
            return (Criteria) this;
        }
	
        public Criteria andEmailIsNull() {
            addCriterion("`email` IS NULL");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("`email` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("`email` =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("`email` <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("`email` >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`email` >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("`email` <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("`email` <=", value, "email");
            return (Criteria) this;
        }
	
        public Criteria andEmailLike(String value) {
            addCriterion("`email` LIKE", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("`email` NOT LIKE", value, "email");
            return (Criteria) this;
        }
	
        public Criteria andEmailIn(List<String> values) {
            addCriterion("`email` IN", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("`email` NOT IN", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("`email` BETWEEN", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("`email` NOT BETWEEN", value1, value2, "email");
            return (Criteria) this;
        }
	
        public Criteria andNeedNofityIsNull() {
            addCriterion("`need_nofity` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNeedNofityIsNotNull() {
            addCriterion("`need_nofity` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNeedNofityEqualTo(Integer value) {
            addCriterion("`need_nofity` =", value, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityNotEqualTo(Integer value) {
            addCriterion("`need_nofity` <>", value, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityGreaterThan(Integer value) {
            addCriterion("`need_nofity` >", value, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityGreaterThanOrEqualTo(Integer value) {
            addCriterion("`need_nofity` >=", value, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityLessThan(Integer value) {
            addCriterion("`need_nofity` <", value, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityLessThanOrEqualTo(Integer value) {
            addCriterion("`need_nofity` <=", value, "needNofity");
            return (Criteria) this;
        }
	
        public Criteria andNeedNofityIn(List<Integer> values) {
            addCriterion("`need_nofity` IN", values, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityNotIn(List<Integer> values) {
            addCriterion("`need_nofity` NOT IN", values, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityBetween(Integer value1, Integer value2) {
            addCriterion("`need_nofity` BETWEEN", value1, value2, "needNofity");
            return (Criteria) this;
        }

        public Criteria andNeedNofityNotBetween(Integer value1, Integer value2) {
            addCriterion("`need_nofity` NOT BETWEEN", value1, value2, "needNofity");
            return (Criteria) this;
        }
	
        public Criteria andNotifyFlagIsNull() {
            addCriterion("`notify_flag` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagIsNotNull() {
            addCriterion("`notify_flag` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagEqualTo(Integer value) {
            addCriterion("`notify_flag` =", value, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagNotEqualTo(Integer value) {
            addCriterion("`notify_flag` <>", value, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagGreaterThan(Integer value) {
            addCriterion("`notify_flag` >", value, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("`notify_flag` >=", value, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagLessThan(Integer value) {
            addCriterion("`notify_flag` <", value, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagLessThanOrEqualTo(Integer value) {
            addCriterion("`notify_flag` <=", value, "notifyFlag");
            return (Criteria) this;
        }
	
        public Criteria andNotifyFlagIn(List<Integer> values) {
            addCriterion("`notify_flag` IN", values, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagNotIn(List<Integer> values) {
            addCriterion("`notify_flag` NOT IN", values, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagBetween(Integer value1, Integer value2) {
            addCriterion("`notify_flag` BETWEEN", value1, value2, "notifyFlag");
            return (Criteria) this;
        }

        public Criteria andNotifyFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("`notify_flag` NOT BETWEEN", value1, value2, "notifyFlag");
            return (Criteria) this;
        }
	
        public Criteria andCreateTimeIsNull() {
            addCriterion("`create_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("`create_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`create_time` =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`create_time` <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(java.util.Date value) {
            addCriterionForJDBCDate("`create_time` >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`create_time` >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(java.util.Date value) {
            addCriterionForJDBCDate("`create_time` <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`create_time` <=", value, "createTime");
            return (Criteria) this;
        }
	
        public Criteria andCreateTimeIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`create_time` IN", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`create_time` NOT IN", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`create_time` BETWEEN", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`create_time` NOT BETWEEN", value1, value2, "createTime");
            return (Criteria) this;
        }    
	
        public Criteria andModifyTimeIsNull() {
            addCriterion("`modify_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("`modify_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`modify_time` =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`modify_time` <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(java.util.Date value) {
            addCriterionForJDBCDate("`modify_time` >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`modify_time` >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(java.util.Date value) {
            addCriterionForJDBCDate("`modify_time` <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`modify_time` <=", value, "modifyTime");
            return (Criteria) this;
        }
	
        public Criteria andModifyTimeIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`modify_time` IN", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`modify_time` NOT IN", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`modify_time` BETWEEN", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`modify_time` NOT BETWEEN", value1, value2, "modifyTime");
            return (Criteria) this;
        }    
        public Criteria andStaffNameLikeInsensitive(String value) {
            addCriterion("UPPER(`staff_name`) LIKE", value.toUpperCase(), "staffName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}