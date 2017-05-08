package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PostCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public PostCriteria() {
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
	
        public Criteria andPostLinkIsNull() {
            addCriterion("`post_link` IS NULL");
            return (Criteria) this;
        }

        public Criteria andPostLinkIsNotNull() {
            addCriterion("`post_link` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andPostLinkEqualTo(String value) {
            addCriterion("`post_link` =", value, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkNotEqualTo(String value) {
            addCriterion("`post_link` <>", value, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkGreaterThan(String value) {
            addCriterion("`post_link` >", value, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkGreaterThanOrEqualTo(String value) {
            addCriterion("`post_link` >=", value, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkLessThan(String value) {
            addCriterion("`post_link` <", value, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkLessThanOrEqualTo(String value) {
            addCriterion("`post_link` <=", value, "postLink");
            return (Criteria) this;
        }
	
        public Criteria andPostLinkLike(String value) {
            addCriterion("`post_link` LIKE", value, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkNotLike(String value) {
            addCriterion("`post_link` NOT LIKE", value, "postLink");
            return (Criteria) this;
        }
	
        public Criteria andPostLinkIn(List<String> values) {
            addCriterion("`post_link` IN", values, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkNotIn(List<String> values) {
            addCriterion("`post_link` NOT IN", values, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkBetween(String value1, String value2) {
            addCriterion("`post_link` BETWEEN", value1, value2, "postLink");
            return (Criteria) this;
        }

        public Criteria andPostLinkNotBetween(String value1, String value2) {
            addCriterion("`post_link` NOT BETWEEN", value1, value2, "postLink");
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
        public Criteria andPostLikeInsensitive(String value) {
            addCriterion("UPPER(`post`) LIKE", value.toUpperCase(), "post");
            return (Criteria) this;
        }
        public Criteria andPostLinkLikeInsensitive(String value) {
            addCriterion("UPPER(`post_link`) LIKE", value.toUpperCase(), "postLink");
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