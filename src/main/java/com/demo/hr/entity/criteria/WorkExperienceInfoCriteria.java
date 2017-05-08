package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WorkExperienceInfoCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public WorkExperienceInfoCriteria() {
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
	
        public Criteria andBeginDateIsNull() {
            addCriterion("`begin_date` IS NULL");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("`begin_date` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(String value) {
            addCriterion("`begin_date` =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(String value) {
            addCriterion("`begin_date` <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(String value) {
            addCriterion("`begin_date` >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("`begin_date` >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(String value) {
            addCriterion("`begin_date` <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(String value) {
            addCriterion("`begin_date` <=", value, "beginDate");
            return (Criteria) this;
        }
	
        public Criteria andBeginDateLike(String value) {
            addCriterion("`begin_date` LIKE", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotLike(String value) {
            addCriterion("`begin_date` NOT LIKE", value, "beginDate");
            return (Criteria) this;
        }
	
        public Criteria andBeginDateIn(List<String> values) {
            addCriterion("`begin_date` IN", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<String> values) {
            addCriterion("`begin_date` NOT IN", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(String value1, String value2) {
            addCriterion("`begin_date` BETWEEN", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(String value1, String value2) {
            addCriterion("`begin_date` NOT BETWEEN", value1, value2, "beginDate");
            return (Criteria) this;
        }
	
        public Criteria andEndDateIsNull() {
            addCriterion("`end_date` IS NULL");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("`end_date` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("`end_date` =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("`end_date` <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("`end_date` >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("`end_date` >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("`end_date` <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("`end_date` <=", value, "endDate");
            return (Criteria) this;
        }
	
        public Criteria andEndDateLike(String value) {
            addCriterion("`end_date` LIKE", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("`end_date` NOT LIKE", value, "endDate");
            return (Criteria) this;
        }
	
        public Criteria andEndDateIn(List<String> values) {
            addCriterion("`end_date` IN", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("`end_date` NOT IN", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("`end_date` BETWEEN", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("`end_date` NOT BETWEEN", value1, value2, "endDate");
            return (Criteria) this;
        }
	
        public Criteria andCompanyIsNull() {
            addCriterion("`company` IS NULL");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("`company` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("`company` =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("`company` <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("`company` >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("`company` >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("`company` <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("`company` <=", value, "company");
            return (Criteria) this;
        }
	
        public Criteria andCompanyLike(String value) {
            addCriterion("`company` LIKE", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("`company` NOT LIKE", value, "company");
            return (Criteria) this;
        }
	
        public Criteria andCompanyIn(List<String> values) {
            addCriterion("`company` IN", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("`company` NOT IN", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("`company` BETWEEN", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("`company` NOT BETWEEN", value1, value2, "company");
            return (Criteria) this;
        }
	
        public Criteria andTitleIsNull() {
            addCriterion("`title` IS NULL");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("`title` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("`title` =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("`title` <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("`title` >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`title` >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("`title` <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("`title` <=", value, "title");
            return (Criteria) this;
        }
	
        public Criteria andTitleLike(String value) {
            addCriterion("`title` LIKE", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("`title` NOT LIKE", value, "title");
            return (Criteria) this;
        }
	
        public Criteria andTitleIn(List<String> values) {
            addCriterion("`title` IN", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("`title` NOT IN", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("`title` BETWEEN", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("`title` NOT BETWEEN", value1, value2, "title");
            return (Criteria) this;
        }
	
        public Criteria andReasonIsNull() {
            addCriterion("`reason` IS NULL");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("`reason` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("`reason` =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("`reason` <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("`reason` >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("`reason` >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("`reason` <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("`reason` <=", value, "reason");
            return (Criteria) this;
        }
	
        public Criteria andReasonLike(String value) {
            addCriterion("`reason` LIKE", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("`reason` NOT LIKE", value, "reason");
            return (Criteria) this;
        }
	
        public Criteria andReasonIn(List<String> values) {
            addCriterion("`reason` IN", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("`reason` NOT IN", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("`reason` BETWEEN", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("`reason` NOT BETWEEN", value1, value2, "reason");
            return (Criteria) this;
        }
	
        public Criteria andSalaryIsNull() {
            addCriterion("`salary` IS NULL");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("`salary` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("`salary` =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("`salary` <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("`salary` >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("`salary` >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("`salary` <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("`salary` <=", value, "salary");
            return (Criteria) this;
        }
	
        public Criteria andSalaryLike(String value) {
            addCriterion("`salary` LIKE", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("`salary` NOT LIKE", value, "salary");
            return (Criteria) this;
        }
	
        public Criteria andSalaryIn(List<String> values) {
            addCriterion("`salary` IN", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("`salary` NOT IN", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("`salary` BETWEEN", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("`salary` NOT BETWEEN", value1, value2, "salary");
            return (Criteria) this;
        }
	
        public Criteria andNumIsNull() {
            addCriterion("`num` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("`num` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("`num` =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("`num` <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("`num` >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("`num` >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("`num` <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("`num` <=", value, "num");
            return (Criteria) this;
        }
	
        public Criteria andNumIn(List<Integer> values) {
            addCriterion("`num` IN", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("`num` NOT IN", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("`num` BETWEEN", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("`num` NOT BETWEEN", value1, value2, "num");
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
        public Criteria andBeginDateLikeInsensitive(String value) {
            addCriterion("UPPER(`begin_date`) LIKE", value.toUpperCase(), "beginDate");
            return (Criteria) this;
        }
        public Criteria andEndDateLikeInsensitive(String value) {
            addCriterion("UPPER(`end_date`) LIKE", value.toUpperCase(), "endDate");
            return (Criteria) this;
        }
        public Criteria andCompanyLikeInsensitive(String value) {
            addCriterion("UPPER(`company`) LIKE", value.toUpperCase(), "company");
            return (Criteria) this;
        }
        public Criteria andTitleLikeInsensitive(String value) {
            addCriterion("UPPER(`title`) LIKE", value.toUpperCase(), "title");
            return (Criteria) this;
        }
        public Criteria andReasonLikeInsensitive(String value) {
            addCriterion("UPPER(`reason`) LIKE", value.toUpperCase(), "reason");
            return (Criteria) this;
        }
        public Criteria andSalaryLikeInsensitive(String value) {
            addCriterion("UPPER(`salary`) LIKE", value.toUpperCase(), "salary");
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