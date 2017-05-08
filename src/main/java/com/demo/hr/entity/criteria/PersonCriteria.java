package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public PersonCriteria() {
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
	
        public Criteria andNameIsNull() {
            addCriterion("`name` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }
	
        public Criteria andNameLike(String value) {
            addCriterion("`name` LIKE", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` NOT LIKE", value, "name");
            return (Criteria) this;
        }
	
        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` IN", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` NOT IN", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` BETWEEN", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` NOT BETWEEN", value1, value2, "name");
            return (Criteria) this;
        }
	
        public Criteria andPwdIsNull() {
            addCriterion("`pwd` IS NULL");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("`pwd` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("`pwd` =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("`pwd` <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("`pwd` >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("`pwd` >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("`pwd` <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("`pwd` <=", value, "pwd");
            return (Criteria) this;
        }
	
        public Criteria andPwdLike(String value) {
            addCriterion("`pwd` LIKE", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("`pwd` NOT LIKE", value, "pwd");
            return (Criteria) this;
        }
	
        public Criteria andPwdIn(List<String> values) {
            addCriterion("`pwd` IN", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("`pwd` NOT IN", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("`pwd` BETWEEN", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("`pwd` NOT BETWEEN", value1, value2, "pwd");
            return (Criteria) this;
        }
	
        public Criteria andPostIsNull() {
            addCriterion("`post` IS NULL");
            return (Criteria) this;
        }

        public Criteria andPostIsNotNull() {
            addCriterion("`post` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andPostEqualTo(String value) {
            addCriterion("`post` =", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotEqualTo(String value) {
            addCriterion("`post` <>", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThan(String value) {
            addCriterion("`post` >", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostGreaterThanOrEqualTo(String value) {
            addCriterion("`post` >=", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThan(String value) {
            addCriterion("`post` <", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostLessThanOrEqualTo(String value) {
            addCriterion("`post` <=", value, "post");
            return (Criteria) this;
        }
	
        public Criteria andPostLike(String value) {
            addCriterion("`post` LIKE", value, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotLike(String value) {
            addCriterion("`post` NOT LIKE", value, "post");
            return (Criteria) this;
        }
	
        public Criteria andPostIn(List<String> values) {
            addCriterion("`post` IN", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotIn(List<String> values) {
            addCriterion("`post` NOT IN", values, "post");
            return (Criteria) this;
        }

        public Criteria andPostBetween(String value1, String value2) {
            addCriterion("`post` BETWEEN", value1, value2, "post");
            return (Criteria) this;
        }

        public Criteria andPostNotBetween(String value1, String value2) {
            addCriterion("`post` NOT BETWEEN", value1, value2, "post");
            return (Criteria) this;
        }
	
        public Criteria andMobileIsNull() {
            addCriterion("`mobile` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("`mobile` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("`mobile` =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("`mobile` <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("`mobile` >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("`mobile` >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("`mobile` <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("`mobile` <=", value, "mobile");
            return (Criteria) this;
        }
	
        public Criteria andMobileLike(String value) {
            addCriterion("`mobile` LIKE", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("`mobile` NOT LIKE", value, "mobile");
            return (Criteria) this;
        }
	
        public Criteria andMobileIn(List<String> values) {
            addCriterion("`mobile` IN", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("`mobile` NOT IN", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("`mobile` BETWEEN", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("`mobile` NOT BETWEEN", value1, value2, "mobile");
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
	
        public Criteria andCsTimeIsNull() {
            addCriterion("`cs_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andCsTimeIsNotNull() {
            addCriterion("`cs_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andCsTimeEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`cs_time` =", value, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeNotEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`cs_time` <>", value, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeGreaterThan(java.util.Date value) {
            addCriterionForJDBCDate("`cs_time` >", value, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`cs_time` >=", value, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeLessThan(java.util.Date value) {
            addCriterionForJDBCDate("`cs_time` <", value, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`cs_time` <=", value, "csTime");
            return (Criteria) this;
        }
	
        public Criteria andCsTimeIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`cs_time` IN", values, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeNotIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`cs_time` NOT IN", values, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`cs_time` BETWEEN", value1, value2, "csTime");
            return (Criteria) this;
        }

        public Criteria andCsTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`cs_time` NOT BETWEEN", value1, value2, "csTime");
            return (Criteria) this;
        }    
	
        public Criteria andFsTimeIsNull() {
            addCriterion("`fs_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andFsTimeIsNotNull() {
            addCriterion("`fs_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andFsTimeEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`fs_time` =", value, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeNotEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`fs_time` <>", value, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeGreaterThan(java.util.Date value) {
            addCriterionForJDBCDate("`fs_time` >", value, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeGreaterThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`fs_time` >=", value, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeLessThan(java.util.Date value) {
            addCriterionForJDBCDate("`fs_time` <", value, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeLessThanOrEqualTo(java.util.Date value) {
            addCriterionForJDBCDate("`fs_time` <=", value, "fsTime");
            return (Criteria) this;
        }
	
        public Criteria andFsTimeIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`fs_time` IN", values, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeNotIn(List<java.util.Date> values) {
            addCriterionForJDBCDate("`fs_time` NOT IN", values, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`fs_time` BETWEEN", value1, value2, "fsTime");
            return (Criteria) this;
        }

        public Criteria andFsTimeNotBetween(java.util.Date value1, java.util.Date value2) {
            addCriterionForJDBCDate("`fs_time` NOT BETWEEN", value1, value2, "fsTime");
            return (Criteria) this;
        }    
	
        public Criteria andCsResultIsNull() {
            addCriterion("`cs_result` IS NULL");
            return (Criteria) this;
        }

        public Criteria andCsResultIsNotNull() {
            addCriterion("`cs_result` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andCsResultEqualTo(Integer value) {
            addCriterion("`cs_result` =", value, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultNotEqualTo(Integer value) {
            addCriterion("`cs_result` <>", value, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultGreaterThan(Integer value) {
            addCriterion("`cs_result` >", value, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("`cs_result` >=", value, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultLessThan(Integer value) {
            addCriterion("`cs_result` <", value, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultLessThanOrEqualTo(Integer value) {
            addCriterion("`cs_result` <=", value, "csResult");
            return (Criteria) this;
        }
	
        public Criteria andCsResultIn(List<Integer> values) {
            addCriterion("`cs_result` IN", values, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultNotIn(List<Integer> values) {
            addCriterion("`cs_result` NOT IN", values, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultBetween(Integer value1, Integer value2) {
            addCriterion("`cs_result` BETWEEN", value1, value2, "csResult");
            return (Criteria) this;
        }

        public Criteria andCsResultNotBetween(Integer value1, Integer value2) {
            addCriterion("`cs_result` NOT BETWEEN", value1, value2, "csResult");
            return (Criteria) this;
        }
	
        public Criteria andFsResultIsNull() {
            addCriterion("`fs_result` IS NULL");
            return (Criteria) this;
        }

        public Criteria andFsResultIsNotNull() {
            addCriterion("`fs_result` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andFsResultEqualTo(Integer value) {
            addCriterion("`fs_result` =", value, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultNotEqualTo(Integer value) {
            addCriterion("`fs_result` <>", value, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultGreaterThan(Integer value) {
            addCriterion("`fs_result` >", value, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("`fs_result` >=", value, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultLessThan(Integer value) {
            addCriterion("`fs_result` <", value, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultLessThanOrEqualTo(Integer value) {
            addCriterion("`fs_result` <=", value, "fsResult");
            return (Criteria) this;
        }
	
        public Criteria andFsResultIn(List<Integer> values) {
            addCriterion("`fs_result` IN", values, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultNotIn(List<Integer> values) {
            addCriterion("`fs_result` NOT IN", values, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultBetween(Integer value1, Integer value2) {
            addCriterion("`fs_result` BETWEEN", value1, value2, "fsResult");
            return (Criteria) this;
        }

        public Criteria andFsResultNotBetween(Integer value1, Integer value2) {
            addCriterion("`fs_result` NOT BETWEEN", value1, value2, "fsResult");
            return (Criteria) this;
        }
	
        public Criteria andOriginIsNull() {
            addCriterion("`origin` IS NULL");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("`origin` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(Integer value) {
            addCriterion("`origin` =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(Integer value) {
            addCriterion("`origin` <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(Integer value) {
            addCriterion("`origin` >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(Integer value) {
            addCriterion("`origin` >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(Integer value) {
            addCriterion("`origin` <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(Integer value) {
            addCriterion("`origin` <=", value, "origin");
            return (Criteria) this;
        }
	
        public Criteria andOriginIn(List<Integer> values) {
            addCriterion("`origin` IN", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<Integer> values) {
            addCriterion("`origin` NOT IN", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(Integer value1, Integer value2) {
            addCriterion("`origin` BETWEEN", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(Integer value1, Integer value2) {
            addCriterion("`origin` NOT BETWEEN", value1, value2, "origin");
            return (Criteria) this;
        }
	
        public Criteria andWayIsNull() {
            addCriterion("`way` IS NULL");
            return (Criteria) this;
        }

        public Criteria andWayIsNotNull() {
            addCriterion("`way` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andWayEqualTo(Integer value) {
            addCriterion("`way` =", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotEqualTo(Integer value) {
            addCriterion("`way` <>", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayGreaterThan(Integer value) {
            addCriterion("`way` >", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("`way` >=", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayLessThan(Integer value) {
            addCriterion("`way` <", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayLessThanOrEqualTo(Integer value) {
            addCriterion("`way` <=", value, "way");
            return (Criteria) this;
        }
	
        public Criteria andWayIn(List<Integer> values) {
            addCriterion("`way` IN", values, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotIn(List<Integer> values) {
            addCriterion("`way` NOT IN", values, "way");
            return (Criteria) this;
        }

        public Criteria andWayBetween(Integer value1, Integer value2) {
            addCriterion("`way` BETWEEN", value1, value2, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotBetween(Integer value1, Integer value2) {
            addCriterion("`way` NOT BETWEEN", value1, value2, "way");
            return (Criteria) this;
        }
	
        public Criteria andWayInfoIsNull() {
            addCriterion("`way_info` IS NULL");
            return (Criteria) this;
        }

        public Criteria andWayInfoIsNotNull() {
            addCriterion("`way_info` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andWayInfoEqualTo(String value) {
            addCriterion("`way_info` =", value, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoNotEqualTo(String value) {
            addCriterion("`way_info` <>", value, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoGreaterThan(String value) {
            addCriterion("`way_info` >", value, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoGreaterThanOrEqualTo(String value) {
            addCriterion("`way_info` >=", value, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoLessThan(String value) {
            addCriterion("`way_info` <", value, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoLessThanOrEqualTo(String value) {
            addCriterion("`way_info` <=", value, "wayInfo");
            return (Criteria) this;
        }
	
        public Criteria andWayInfoLike(String value) {
            addCriterion("`way_info` LIKE", value, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoNotLike(String value) {
            addCriterion("`way_info` NOT LIKE", value, "wayInfo");
            return (Criteria) this;
        }
	
        public Criteria andWayInfoIn(List<String> values) {
            addCriterion("`way_info` IN", values, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoNotIn(List<String> values) {
            addCriterion("`way_info` NOT IN", values, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoBetween(String value1, String value2) {
            addCriterion("`way_info` BETWEEN", value1, value2, "wayInfo");
            return (Criteria) this;
        }

        public Criteria andWayInfoNotBetween(String value1, String value2) {
            addCriterion("`way_info` NOT BETWEEN", value1, value2, "wayInfo");
            return (Criteria) this;
        }
	
        public Criteria andPreInfoIsNull() {
            addCriterion("`pre_info` IS NULL");
            return (Criteria) this;
        }

        public Criteria andPreInfoIsNotNull() {
            addCriterion("`pre_info` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andPreInfoEqualTo(Integer value) {
            addCriterion("`pre_info` =", value, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoNotEqualTo(Integer value) {
            addCriterion("`pre_info` <>", value, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoGreaterThan(Integer value) {
            addCriterion("`pre_info` >", value, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("`pre_info` >=", value, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoLessThan(Integer value) {
            addCriterion("`pre_info` <", value, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoLessThanOrEqualTo(Integer value) {
            addCriterion("`pre_info` <=", value, "preInfo");
            return (Criteria) this;
        }
	
        public Criteria andPreInfoIn(List<Integer> values) {
            addCriterion("`pre_info` IN", values, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoNotIn(List<Integer> values) {
            addCriterion("`pre_info` NOT IN", values, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoBetween(Integer value1, Integer value2) {
            addCriterion("`pre_info` BETWEEN", value1, value2, "preInfo");
            return (Criteria) this;
        }

        public Criteria andPreInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("`pre_info` NOT BETWEEN", value1, value2, "preInfo");
            return (Criteria) this;
        }
	
        public Criteria andNoteIsNull() {
            addCriterion("`note` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("`note` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("`note` =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("`note` <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("`note` >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("`note` >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("`note` <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("`note` <=", value, "note");
            return (Criteria) this;
        }
	
        public Criteria andNoteLike(String value) {
            addCriterion("`note` LIKE", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("`note` NOT LIKE", value, "note");
            return (Criteria) this;
        }
	
        public Criteria andNoteIn(List<String> values) {
            addCriterion("`note` IN", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("`note` NOT IN", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("`note` BETWEEN", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("`note` NOT BETWEEN", value1, value2, "note");
            return (Criteria) this;
        }
	
        public Criteria andNote2IsNull() {
            addCriterion("`note2` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNote2IsNotNull() {
            addCriterion("`note2` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNote2EqualTo(String value) {
            addCriterion("`note2` =", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotEqualTo(String value) {
            addCriterion("`note2` <>", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2GreaterThan(String value) {
            addCriterion("`note2` >", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2GreaterThanOrEqualTo(String value) {
            addCriterion("`note2` >=", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2LessThan(String value) {
            addCriterion("`note2` <", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2LessThanOrEqualTo(String value) {
            addCriterion("`note2` <=", value, "note2");
            return (Criteria) this;
        }
	
        public Criteria andNote2Like(String value) {
            addCriterion("`note2` LIKE", value, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotLike(String value) {
            addCriterion("`note2` NOT LIKE", value, "note2");
            return (Criteria) this;
        }
	
        public Criteria andNote2In(List<String> values) {
            addCriterion("`note2` IN", values, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotIn(List<String> values) {
            addCriterion("`note2` NOT IN", values, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2Between(String value1, String value2) {
            addCriterion("`note2` BETWEEN", value1, value2, "note2");
            return (Criteria) this;
        }

        public Criteria andNote2NotBetween(String value1, String value2) {
            addCriterion("`note2` NOT BETWEEN", value1, value2, "note2");
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
        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("UPPER(`name`) LIKE", value.toUpperCase(), "name");
            return (Criteria) this;
        }
        public Criteria andPwdLikeInsensitive(String value) {
            addCriterion("UPPER(`pwd`) LIKE", value.toUpperCase(), "pwd");
            return (Criteria) this;
        }
        public Criteria andPostLikeInsensitive(String value) {
            addCriterion("UPPER(`post`) LIKE", value.toUpperCase(), "post");
            return (Criteria) this;
        }
        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("UPPER(`mobile`) LIKE", value.toUpperCase(), "mobile");
            return (Criteria) this;
        }
        public Criteria andEmailLikeInsensitive(String value) {
            addCriterion("UPPER(`email`) LIKE", value.toUpperCase(), "email");
            return (Criteria) this;
        }
        public Criteria andWayInfoLikeInsensitive(String value) {
            addCriterion("UPPER(`way_info`) LIKE", value.toUpperCase(), "wayInfo");
            return (Criteria) this;
        }
        public Criteria andNoteLikeInsensitive(String value) {
            addCriterion("UPPER(`note`) LIKE", value.toUpperCase(), "note");
            return (Criteria) this;
        }
        public Criteria andNote2LikeInsensitive(String value) {
            addCriterion("UPPER(`note2`) LIKE", value.toUpperCase(), "note2");
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