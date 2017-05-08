package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FeedbackHistoryCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public FeedbackHistoryCriteria() {
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
	
        public Criteria andMsTypeIsNull() {
            addCriterion("`ms_type` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMsTypeIsNotNull() {
            addCriterion("`ms_type` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMsTypeEqualTo(Integer value) {
            addCriterion("`ms_type` =", value, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeNotEqualTo(Integer value) {
            addCriterion("`ms_type` <>", value, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeGreaterThan(Integer value) {
            addCriterion("`ms_type` >", value, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`ms_type` >=", value, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeLessThan(Integer value) {
            addCriterion("`ms_type` <", value, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`ms_type` <=", value, "msType");
            return (Criteria) this;
        }
	
        public Criteria andMsTypeIn(List<Integer> values) {
            addCriterion("`ms_type` IN", values, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeNotIn(List<Integer> values) {
            addCriterion("`ms_type` NOT IN", values, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeBetween(Integer value1, Integer value2) {
            addCriterion("`ms_type` BETWEEN", value1, value2, "msType");
            return (Criteria) this;
        }

        public Criteria andMsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`ms_type` NOT BETWEEN", value1, value2, "msType");
            return (Criteria) this;
        }
	
        public Criteria andMsTimeIsNull() {
            addCriterion("`ms_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMsTimeIsNotNull() {
            addCriterion("`ms_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMsTimeEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`ms_time` =", value, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeNotEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`ms_time` <>", value, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeGreaterThan(java.util.Date value) {
            addCriterionForJDBCDate("`ms_time` >", value, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`ms_time` >=", value, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeLessThan(java.util.Date value) {
            addCriterionForJDBCDate("`ms_time` <", value, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`ms_time` <=", value, "msTime");
            return (Criteria) this;
        }
	
        public Criteria andMsTimeIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`ms_time` IN", values, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeNotIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`ms_time` NOT IN", values, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`ms_time` BETWEEN", value1, value2, "msTime");
            return (Criteria) this;
        }

        public Criteria andMsTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`ms_time` NOT BETWEEN", value1, value2, "msTime");
            return (Criteria) this;
        }    
	
        public Criteria andStatusIsNull() {
            addCriterion("`status` IS NULL");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }
	
        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` IN", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` NOT IN", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` BETWEEN", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` NOT BETWEEN", value1, value2, "status");
            return (Criteria) this;
        }
	
        public Criteria andNotifyTimeIsNull() {
            addCriterion("`notify_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNotNull() {
            addCriterion("`notify_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_time` =", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_time` <>", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThan(java.util.Date value) {
            addCriterionForJDBCDate("`notify_time` >", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_time` >=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThan(java.util.Date value) {
            addCriterionForJDBCDate("`notify_time` <", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_time` <=", value, "notifyTime");
            return (Criteria) this;
        }
	
        public Criteria andNotifyTimeIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`notify_time` IN", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`notify_time` NOT IN", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`notify_time` BETWEEN", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`notify_time` NOT BETWEEN", value1, value2, "notifyTime");
            return (Criteria) this;
        }    
	
        public Criteria andNotifyEndTimeIsNull() {
            addCriterion("`notify_end_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeIsNotNull() {
            addCriterion("`notify_end_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_end_time` =", value, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeNotEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_end_time` <>", value, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeGreaterThan(java.util.Date value) {
            addCriterionForJDBCDate("`notify_end_time` >", value, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_end_time` >=", value, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeLessThan(java.util.Date value) {
            addCriterionForJDBCDate("`notify_end_time` <", value, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`notify_end_time` <=", value, "notifyEndTime");
            return (Criteria) this;
        }
	
        public Criteria andNotifyEndTimeIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`notify_end_time` IN", values, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeNotIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`notify_end_time` NOT IN", values, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`notify_end_time` BETWEEN", value1, value2, "notifyEndTime");
            return (Criteria) this;
        }

        public Criteria andNotifyEndTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`notify_end_time` NOT BETWEEN", value1, value2, "notifyEndTime");
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
	
        public Criteria andTypeIsNull() {
            addCriterion("`type` IS NULL");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }
	
        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` IN", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` NOT IN", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` BETWEEN", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` NOT BETWEEN", value1, value2, "type");
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
	
        public Criteria andStaffEmailIsNull() {
            addCriterion("`staff_email` IS NULL");
            return (Criteria) this;
        }

        public Criteria andStaffEmailIsNotNull() {
            addCriterion("`staff_email` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andStaffEmailEqualTo(String value) {
            addCriterion("`staff_email` =", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotEqualTo(String value) {
            addCriterion("`staff_email` <>", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailGreaterThan(String value) {
            addCriterion("`staff_email` >", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`staff_email` >=", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailLessThan(String value) {
            addCriterion("`staff_email` <", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailLessThanOrEqualTo(String value) {
            addCriterion("`staff_email` <=", value, "staffEmail");
            return (Criteria) this;
        }
	
        public Criteria andStaffEmailLike(String value) {
            addCriterion("`staff_email` LIKE", value, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotLike(String value) {
            addCriterion("`staff_email` NOT LIKE", value, "staffEmail");
            return (Criteria) this;
        }
	
        public Criteria andStaffEmailIn(List<String> values) {
            addCriterion("`staff_email` IN", values, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotIn(List<String> values) {
            addCriterion("`staff_email` NOT IN", values, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailBetween(String value1, String value2) {
            addCriterion("`staff_email` BETWEEN", value1, value2, "staffEmail");
            return (Criteria) this;
        }

        public Criteria andStaffEmailNotBetween(String value1, String value2) {
            addCriterion("`staff_email` NOT BETWEEN", value1, value2, "staffEmail");
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
        public Criteria andStaffEmailLikeInsensitive(String value) {
            addCriterion("UPPER(`staff_email`) LIKE", value.toUpperCase(), "staffEmail");
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