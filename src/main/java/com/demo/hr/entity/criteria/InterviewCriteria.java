package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InterviewCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public InterviewCriteria() {
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
	
        public Criteria andMsAddressIsNull() {
            addCriterion("`ms_address` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMsAddressIsNotNull() {
            addCriterion("`ms_address` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMsAddressEqualTo(String value) {
            addCriterion("`ms_address` =", value, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressNotEqualTo(String value) {
            addCriterion("`ms_address` <>", value, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressGreaterThan(String value) {
            addCriterion("`ms_address` >", value, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressGreaterThanOrEqualTo(String value) {
            addCriterion("`ms_address` >=", value, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressLessThan(String value) {
            addCriterion("`ms_address` <", value, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressLessThanOrEqualTo(String value) {
            addCriterion("`ms_address` <=", value, "msAddress");
            return (Criteria) this;
        }
	
        public Criteria andMsAddressLike(String value) {
            addCriterion("`ms_address` LIKE", value, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressNotLike(String value) {
            addCriterion("`ms_address` NOT LIKE", value, "msAddress");
            return (Criteria) this;
        }
	
        public Criteria andMsAddressIn(List<String> values) {
            addCriterion("`ms_address` IN", values, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressNotIn(List<String> values) {
            addCriterion("`ms_address` NOT IN", values, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressBetween(String value1, String value2) {
            addCriterion("`ms_address` BETWEEN", value1, value2, "msAddress");
            return (Criteria) this;
        }

        public Criteria andMsAddressNotBetween(String value1, String value2) {
            addCriterion("`ms_address` NOT BETWEEN", value1, value2, "msAddress");
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
	
        public Criteria andHrIdIsNull() {
            addCriterion("`hr_id` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHrIdIsNotNull() {
            addCriterion("`hr_id` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHrIdEqualTo(Integer value) {
            addCriterion("`hr_id` =", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotEqualTo(Integer value) {
            addCriterion("`hr_id` <>", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdGreaterThan(Integer value) {
            addCriterion("`hr_id` >", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`hr_id` >=", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdLessThan(Integer value) {
            addCriterion("`hr_id` <", value, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdLessThanOrEqualTo(Integer value) {
            addCriterion("`hr_id` <=", value, "hrId");
            return (Criteria) this;
        }
	
        public Criteria andHrIdIn(List<Integer> values) {
            addCriterion("`hr_id` IN", values, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotIn(List<Integer> values) {
            addCriterion("`hr_id` NOT IN", values, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdBetween(Integer value1, Integer value2) {
            addCriterion("`hr_id` BETWEEN", value1, value2, "hrId");
            return (Criteria) this;
        }

        public Criteria andHrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`hr_id` NOT BETWEEN", value1, value2, "hrId");
            return (Criteria) this;
        }
	
        public Criteria andHrNameIsNull() {
            addCriterion("`hr_name` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHrNameIsNotNull() {
            addCriterion("`hr_name` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHrNameEqualTo(String value) {
            addCriterion("`hr_name` =", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotEqualTo(String value) {
            addCriterion("`hr_name` <>", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameGreaterThan(String value) {
            addCriterion("`hr_name` >", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameGreaterThanOrEqualTo(String value) {
            addCriterion("`hr_name` >=", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameLessThan(String value) {
            addCriterion("`hr_name` <", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameLessThanOrEqualTo(String value) {
            addCriterion("`hr_name` <=", value, "hrName");
            return (Criteria) this;
        }
	
        public Criteria andHrNameLike(String value) {
            addCriterion("`hr_name` LIKE", value, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotLike(String value) {
            addCriterion("`hr_name` NOT LIKE", value, "hrName");
            return (Criteria) this;
        }
	
        public Criteria andHrNameIn(List<String> values) {
            addCriterion("`hr_name` IN", values, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotIn(List<String> values) {
            addCriterion("`hr_name` NOT IN", values, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameBetween(String value1, String value2) {
            addCriterion("`hr_name` BETWEEN", value1, value2, "hrName");
            return (Criteria) this;
        }

        public Criteria andHrNameNotBetween(String value1, String value2) {
            addCriterion("`hr_name` NOT BETWEEN", value1, value2, "hrName");
            return (Criteria) this;
        }
	
        public Criteria andHrMobileIsNull() {
            addCriterion("`hr_mobile` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHrMobileIsNotNull() {
            addCriterion("`hr_mobile` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHrMobileEqualTo(String value) {
            addCriterion("`hr_mobile` =", value, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileNotEqualTo(String value) {
            addCriterion("`hr_mobile` <>", value, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileGreaterThan(String value) {
            addCriterion("`hr_mobile` >", value, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileGreaterThanOrEqualTo(String value) {
            addCriterion("`hr_mobile` >=", value, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileLessThan(String value) {
            addCriterion("`hr_mobile` <", value, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileLessThanOrEqualTo(String value) {
            addCriterion("`hr_mobile` <=", value, "hrMobile");
            return (Criteria) this;
        }
	
        public Criteria andHrMobileLike(String value) {
            addCriterion("`hr_mobile` LIKE", value, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileNotLike(String value) {
            addCriterion("`hr_mobile` NOT LIKE", value, "hrMobile");
            return (Criteria) this;
        }
	
        public Criteria andHrMobileIn(List<String> values) {
            addCriterion("`hr_mobile` IN", values, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileNotIn(List<String> values) {
            addCriterion("`hr_mobile` NOT IN", values, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileBetween(String value1, String value2) {
            addCriterion("`hr_mobile` BETWEEN", value1, value2, "hrMobile");
            return (Criteria) this;
        }

        public Criteria andHrMobileNotBetween(String value1, String value2) {
            addCriterion("`hr_mobile` NOT BETWEEN", value1, value2, "hrMobile");
            return (Criteria) this;
        }
	
        public Criteria andHrEmailIsNull() {
            addCriterion("`hr_email` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHrEmailIsNotNull() {
            addCriterion("`hr_email` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHrEmailEqualTo(String value) {
            addCriterion("`hr_email` =", value, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailNotEqualTo(String value) {
            addCriterion("`hr_email` <>", value, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailGreaterThan(String value) {
            addCriterion("`hr_email` >", value, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`hr_email` >=", value, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailLessThan(String value) {
            addCriterion("`hr_email` <", value, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailLessThanOrEqualTo(String value) {
            addCriterion("`hr_email` <=", value, "hrEmail");
            return (Criteria) this;
        }
	
        public Criteria andHrEmailLike(String value) {
            addCriterion("`hr_email` LIKE", value, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailNotLike(String value) {
            addCriterion("`hr_email` NOT LIKE", value, "hrEmail");
            return (Criteria) this;
        }
	
        public Criteria andHrEmailIn(List<String> values) {
            addCriterion("`hr_email` IN", values, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailNotIn(List<String> values) {
            addCriterion("`hr_email` NOT IN", values, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailBetween(String value1, String value2) {
            addCriterion("`hr_email` BETWEEN", value1, value2, "hrEmail");
            return (Criteria) this;
        }

        public Criteria andHrEmailNotBetween(String value1, String value2) {
            addCriterion("`hr_email` NOT BETWEEN", value1, value2, "hrEmail");
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
	
        public Criteria andMsResultIsNull() {
            addCriterion("`ms_result` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMsResultIsNotNull() {
            addCriterion("`ms_result` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMsResultEqualTo(Integer value) {
            addCriterion("`ms_result` =", value, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultNotEqualTo(Integer value) {
            addCriterion("`ms_result` <>", value, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultGreaterThan(Integer value) {
            addCriterion("`ms_result` >", value, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("`ms_result` >=", value, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultLessThan(Integer value) {
            addCriterion("`ms_result` <", value, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultLessThanOrEqualTo(Integer value) {
            addCriterion("`ms_result` <=", value, "msResult");
            return (Criteria) this;
        }
	
        public Criteria andMsResultIn(List<Integer> values) {
            addCriterion("`ms_result` IN", values, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultNotIn(List<Integer> values) {
            addCriterion("`ms_result` NOT IN", values, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultBetween(Integer value1, Integer value2) {
            addCriterion("`ms_result` BETWEEN", value1, value2, "msResult");
            return (Criteria) this;
        }

        public Criteria andMsResultNotBetween(Integer value1, Integer value2) {
            addCriterion("`ms_result` NOT BETWEEN", value1, value2, "msResult");
            return (Criteria) this;
        }
	
        public Criteria andHrResultIsNull() {
            addCriterion("`hr_result` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHrResultIsNotNull() {
            addCriterion("`hr_result` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHrResultEqualTo(Integer value) {
            addCriterion("`hr_result` =", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultNotEqualTo(Integer value) {
            addCriterion("`hr_result` <>", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultGreaterThan(Integer value) {
            addCriterion("`hr_result` >", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("`hr_result` >=", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultLessThan(Integer value) {
            addCriterion("`hr_result` <", value, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultLessThanOrEqualTo(Integer value) {
            addCriterion("`hr_result` <=", value, "hrResult");
            return (Criteria) this;
        }
	
        public Criteria andHrResultIn(List<Integer> values) {
            addCriterion("`hr_result` IN", values, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultNotIn(List<Integer> values) {
            addCriterion("`hr_result` NOT IN", values, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultBetween(Integer value1, Integer value2) {
            addCriterion("`hr_result` BETWEEN", value1, value2, "hrResult");
            return (Criteria) this;
        }

        public Criteria andHrResultNotBetween(Integer value1, Integer value2) {
            addCriterion("`hr_result` NOT BETWEEN", value1, value2, "hrResult");
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
        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("UPPER(`name`) LIKE", value.toUpperCase(), "name");
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
        public Criteria andMsAddressLikeInsensitive(String value) {
            addCriterion("UPPER(`ms_address`) LIKE", value.toUpperCase(), "msAddress");
            return (Criteria) this;
        }
        public Criteria andHrNameLikeInsensitive(String value) {
            addCriterion("UPPER(`hr_name`) LIKE", value.toUpperCase(), "hrName");
            return (Criteria) this;
        }
        public Criteria andHrMobileLikeInsensitive(String value) {
            addCriterion("UPPER(`hr_mobile`) LIKE", value.toUpperCase(), "hrMobile");
            return (Criteria) this;
        }
        public Criteria andHrEmailLikeInsensitive(String value) {
            addCriterion("UPPER(`hr_email`) LIKE", value.toUpperCase(), "hrEmail");
            return (Criteria) this;
        }
        public Criteria andNoteLikeInsensitive(String value) {
            addCriterion("UPPER(`note`) LIKE", value.toUpperCase(), "note");
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