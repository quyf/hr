package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonBaseInfoCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public PersonBaseInfoCriteria() {
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
	
        public Criteria andSexIsNull() {
            addCriterion("`sex` IS NULL");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("`sex` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("`sex` =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("`sex` <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("`sex` >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("`sex` >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("`sex` <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("`sex` <=", value, "sex");
            return (Criteria) this;
        }
	
        public Criteria andSexLike(String value) {
            addCriterion("`sex` LIKE", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("`sex` NOT LIKE", value, "sex");
            return (Criteria) this;
        }
	
        public Criteria andSexIn(List<String> values) {
            addCriterion("`sex` IN", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("`sex` NOT IN", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("`sex` BETWEEN", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("`sex` NOT BETWEEN", value1, value2, "sex");
            return (Criteria) this;
        }
	
        public Criteria andJiguanIsNull() {
            addCriterion("`jiguan` IS NULL");
            return (Criteria) this;
        }

        public Criteria andJiguanIsNotNull() {
            addCriterion("`jiguan` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andJiguanEqualTo(String value) {
            addCriterion("`jiguan` =", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotEqualTo(String value) {
            addCriterion("`jiguan` <>", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThan(String value) {
            addCriterion("`jiguan` >", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanGreaterThanOrEqualTo(String value) {
            addCriterion("`jiguan` >=", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThan(String value) {
            addCriterion("`jiguan` <", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanLessThanOrEqualTo(String value) {
            addCriterion("`jiguan` <=", value, "jiguan");
            return (Criteria) this;
        }
	
        public Criteria andJiguanLike(String value) {
            addCriterion("`jiguan` LIKE", value, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotLike(String value) {
            addCriterion("`jiguan` NOT LIKE", value, "jiguan");
            return (Criteria) this;
        }
	
        public Criteria andJiguanIn(List<String> values) {
            addCriterion("`jiguan` IN", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotIn(List<String> values) {
            addCriterion("`jiguan` NOT IN", values, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanBetween(String value1, String value2) {
            addCriterion("`jiguan` BETWEEN", value1, value2, "jiguan");
            return (Criteria) this;
        }

        public Criteria andJiguanNotBetween(String value1, String value2) {
            addCriterion("`jiguan` NOT BETWEEN", value1, value2, "jiguan");
            return (Criteria) this;
        }
	
        public Criteria andMinzuIsNull() {
            addCriterion("`minzu` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMinzuIsNotNull() {
            addCriterion("`minzu` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMinzuEqualTo(String value) {
            addCriterion("`minzu` =", value, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuNotEqualTo(String value) {
            addCriterion("`minzu` <>", value, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuGreaterThan(String value) {
            addCriterion("`minzu` >", value, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuGreaterThanOrEqualTo(String value) {
            addCriterion("`minzu` >=", value, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuLessThan(String value) {
            addCriterion("`minzu` <", value, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuLessThanOrEqualTo(String value) {
            addCriterion("`minzu` <=", value, "minzu");
            return (Criteria) this;
        }
	
        public Criteria andMinzuLike(String value) {
            addCriterion("`minzu` LIKE", value, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuNotLike(String value) {
            addCriterion("`minzu` NOT LIKE", value, "minzu");
            return (Criteria) this;
        }
	
        public Criteria andMinzuIn(List<String> values) {
            addCriterion("`minzu` IN", values, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuNotIn(List<String> values) {
            addCriterion("`minzu` NOT IN", values, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuBetween(String value1, String value2) {
            addCriterion("`minzu` BETWEEN", value1, value2, "minzu");
            return (Criteria) this;
        }

        public Criteria andMinzuNotBetween(String value1, String value2) {
            addCriterion("`minzu` NOT BETWEEN", value1, value2, "minzu");
            return (Criteria) this;
        }
	
        public Criteria andBirthdayIsNull() {
            addCriterion("`birthday` IS NULL");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("`birthday` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("`birthday` =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("`birthday` <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("`birthday` >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("`birthday` >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("`birthday` <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("`birthday` <=", value, "birthday");
            return (Criteria) this;
        }
	
        public Criteria andBirthdayLike(String value) {
            addCriterion("`birthday` LIKE", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("`birthday` NOT LIKE", value, "birthday");
            return (Criteria) this;
        }
	
        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("`birthday` IN", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("`birthday` NOT IN", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("`birthday` BETWEEN", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("`birthday` NOT BETWEEN", value1, value2, "birthday");
            return (Criteria) this;
        }
	
        public Criteria andNowAddressIsNull() {
            addCriterion("`now_address` IS NULL");
            return (Criteria) this;
        }

        public Criteria andNowAddressIsNotNull() {
            addCriterion("`now_address` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andNowAddressEqualTo(String value) {
            addCriterion("`now_address` =", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotEqualTo(String value) {
            addCriterion("`now_address` <>", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressGreaterThan(String value) {
            addCriterion("`now_address` >", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressGreaterThanOrEqualTo(String value) {
            addCriterion("`now_address` >=", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLessThan(String value) {
            addCriterion("`now_address` <", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressLessThanOrEqualTo(String value) {
            addCriterion("`now_address` <=", value, "nowAddress");
            return (Criteria) this;
        }
	
        public Criteria andNowAddressLike(String value) {
            addCriterion("`now_address` LIKE", value, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotLike(String value) {
            addCriterion("`now_address` NOT LIKE", value, "nowAddress");
            return (Criteria) this;
        }
	
        public Criteria andNowAddressIn(List<String> values) {
            addCriterion("`now_address` IN", values, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotIn(List<String> values) {
            addCriterion("`now_address` NOT IN", values, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressBetween(String value1, String value2) {
            addCriterion("`now_address` BETWEEN", value1, value2, "nowAddress");
            return (Criteria) this;
        }

        public Criteria andNowAddressNotBetween(String value1, String value2) {
            addCriterion("`now_address` NOT BETWEEN", value1, value2, "nowAddress");
            return (Criteria) this;
        }
	
        public Criteria andMarrayFlagIsNull() {
            addCriterion("`marray_flag` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagIsNotNull() {
            addCriterion("`marray_flag` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagEqualTo(Integer value) {
            addCriterion("`marray_flag` =", value, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagNotEqualTo(Integer value) {
            addCriterion("`marray_flag` <>", value, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagGreaterThan(Integer value) {
            addCriterion("`marray_flag` >", value, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("`marray_flag` >=", value, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagLessThan(Integer value) {
            addCriterion("`marray_flag` <", value, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagLessThanOrEqualTo(Integer value) {
            addCriterion("`marray_flag` <=", value, "marrayFlag");
            return (Criteria) this;
        }
	
        public Criteria andMarrayFlagIn(List<Integer> values) {
            addCriterion("`marray_flag` IN", values, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagNotIn(List<Integer> values) {
            addCriterion("`marray_flag` NOT IN", values, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagBetween(Integer value1, Integer value2) {
            addCriterion("`marray_flag` BETWEEN", value1, value2, "marrayFlag");
            return (Criteria) this;
        }

        public Criteria andMarrayFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("`marray_flag` NOT BETWEEN", value1, value2, "marrayFlag");
            return (Criteria) this;
        }
	
        public Criteria andPeiouNameIsNull() {
            addCriterion("`peiou_name` IS NULL");
            return (Criteria) this;
        }

        public Criteria andPeiouNameIsNotNull() {
            addCriterion("`peiou_name` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andPeiouNameEqualTo(String value) {
            addCriterion("`peiou_name` =", value, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameNotEqualTo(String value) {
            addCriterion("`peiou_name` <>", value, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameGreaterThan(String value) {
            addCriterion("`peiou_name` >", value, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameGreaterThanOrEqualTo(String value) {
            addCriterion("`peiou_name` >=", value, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameLessThan(String value) {
            addCriterion("`peiou_name` <", value, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameLessThanOrEqualTo(String value) {
            addCriterion("`peiou_name` <=", value, "peiouName");
            return (Criteria) this;
        }
	
        public Criteria andPeiouNameLike(String value) {
            addCriterion("`peiou_name` LIKE", value, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameNotLike(String value) {
            addCriterion("`peiou_name` NOT LIKE", value, "peiouName");
            return (Criteria) this;
        }
	
        public Criteria andPeiouNameIn(List<String> values) {
            addCriterion("`peiou_name` IN", values, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameNotIn(List<String> values) {
            addCriterion("`peiou_name` NOT IN", values, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameBetween(String value1, String value2) {
            addCriterion("`peiou_name` BETWEEN", value1, value2, "peiouName");
            return (Criteria) this;
        }

        public Criteria andPeiouNameNotBetween(String value1, String value2) {
            addCriterion("`peiou_name` NOT BETWEEN", value1, value2, "peiouName");
            return (Criteria) this;
        }
	
        public Criteria andWorkCompanyIsNull() {
            addCriterion("`work_company` IS NULL");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyIsNotNull() {
            addCriterion("`work_company` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyEqualTo(String value) {
            addCriterion("`work_company` =", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotEqualTo(String value) {
            addCriterion("`work_company` <>", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyGreaterThan(String value) {
            addCriterion("`work_company` >", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("`work_company` >=", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyLessThan(String value) {
            addCriterion("`work_company` <", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyLessThanOrEqualTo(String value) {
            addCriterion("`work_company` <=", value, "workCompany");
            return (Criteria) this;
        }
	
        public Criteria andWorkCompanyLike(String value) {
            addCriterion("`work_company` LIKE", value, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotLike(String value) {
            addCriterion("`work_company` NOT LIKE", value, "workCompany");
            return (Criteria) this;
        }
	
        public Criteria andWorkCompanyIn(List<String> values) {
            addCriterion("`work_company` IN", values, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotIn(List<String> values) {
            addCriterion("`work_company` NOT IN", values, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyBetween(String value1, String value2) {
            addCriterion("`work_company` BETWEEN", value1, value2, "workCompany");
            return (Criteria) this;
        }

        public Criteria andWorkCompanyNotBetween(String value1, String value2) {
            addCriterion("`work_company` NOT BETWEEN", value1, value2, "workCompany");
            return (Criteria) this;
        }
	
        public Criteria andBabysIsNull() {
            addCriterion("`babys` IS NULL");
            return (Criteria) this;
        }

        public Criteria andBabysIsNotNull() {
            addCriterion("`babys` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andBabysEqualTo(Integer value) {
            addCriterion("`babys` =", value, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysNotEqualTo(Integer value) {
            addCriterion("`babys` <>", value, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysGreaterThan(Integer value) {
            addCriterion("`babys` >", value, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysGreaterThanOrEqualTo(Integer value) {
            addCriterion("`babys` >=", value, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysLessThan(Integer value) {
            addCriterion("`babys` <", value, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysLessThanOrEqualTo(Integer value) {
            addCriterion("`babys` <=", value, "babys");
            return (Criteria) this;
        }
	
        public Criteria andBabysIn(List<Integer> values) {
            addCriterion("`babys` IN", values, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysNotIn(List<Integer> values) {
            addCriterion("`babys` NOT IN", values, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysBetween(Integer value1, Integer value2) {
            addCriterion("`babys` BETWEEN", value1, value2, "babys");
            return (Criteria) this;
        }

        public Criteria andBabysNotBetween(Integer value1, Integer value2) {
            addCriterion("`babys` NOT BETWEEN", value1, value2, "babys");
            return (Criteria) this;
        }
	
        public Criteria andDisputeIsNull() {
            addCriterion("`dispute` IS NULL");
            return (Criteria) this;
        }

        public Criteria andDisputeIsNotNull() {
            addCriterion("`dispute` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andDisputeEqualTo(Integer value) {
            addCriterion("`dispute` =", value, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeNotEqualTo(Integer value) {
            addCriterion("`dispute` <>", value, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeGreaterThan(Integer value) {
            addCriterion("`dispute` >", value, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`dispute` >=", value, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeLessThan(Integer value) {
            addCriterion("`dispute` <", value, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeLessThanOrEqualTo(Integer value) {
            addCriterion("`dispute` <=", value, "dispute");
            return (Criteria) this;
        }
	
        public Criteria andDisputeIn(List<Integer> values) {
            addCriterion("`dispute` IN", values, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeNotIn(List<Integer> values) {
            addCriterion("`dispute` NOT IN", values, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeBetween(Integer value1, Integer value2) {
            addCriterion("`dispute` BETWEEN", value1, value2, "dispute");
            return (Criteria) this;
        }

        public Criteria andDisputeNotBetween(Integer value1, Integer value2) {
            addCriterion("`dispute` NOT BETWEEN", value1, value2, "dispute");
            return (Criteria) this;
        }
	
        public Criteria andYearSalaryIsNull() {
            addCriterion("`year_salary` IS NULL");
            return (Criteria) this;
        }

        public Criteria andYearSalaryIsNotNull() {
            addCriterion("`year_salary` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andYearSalaryEqualTo(String value) {
            addCriterion("`year_salary` =", value, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryNotEqualTo(String value) {
            addCriterion("`year_salary` <>", value, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryGreaterThan(String value) {
            addCriterion("`year_salary` >", value, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("`year_salary` >=", value, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryLessThan(String value) {
            addCriterion("`year_salary` <", value, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryLessThanOrEqualTo(String value) {
            addCriterion("`year_salary` <=", value, "yearSalary");
            return (Criteria) this;
        }
	
        public Criteria andYearSalaryLike(String value) {
            addCriterion("`year_salary` LIKE", value, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryNotLike(String value) {
            addCriterion("`year_salary` NOT LIKE", value, "yearSalary");
            return (Criteria) this;
        }
	
        public Criteria andYearSalaryIn(List<String> values) {
            addCriterion("`year_salary` IN", values, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryNotIn(List<String> values) {
            addCriterion("`year_salary` NOT IN", values, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryBetween(String value1, String value2) {
            addCriterion("`year_salary` BETWEEN", value1, value2, "yearSalary");
            return (Criteria) this;
        }

        public Criteria andYearSalaryNotBetween(String value1, String value2) {
            addCriterion("`year_salary` NOT BETWEEN", value1, value2, "yearSalary");
            return (Criteria) this;
        }
	
        public Criteria andMonthSalaryIsNull() {
            addCriterion("`month_salary` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryIsNotNull() {
            addCriterion("`month_salary` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryEqualTo(String value) {
            addCriterion("`month_salary` =", value, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryNotEqualTo(String value) {
            addCriterion("`month_salary` <>", value, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryGreaterThan(String value) {
            addCriterion("`month_salary` >", value, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("`month_salary` >=", value, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryLessThan(String value) {
            addCriterion("`month_salary` <", value, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryLessThanOrEqualTo(String value) {
            addCriterion("`month_salary` <=", value, "monthSalary");
            return (Criteria) this;
        }
	
        public Criteria andMonthSalaryLike(String value) {
            addCriterion("`month_salary` LIKE", value, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryNotLike(String value) {
            addCriterion("`month_salary` NOT LIKE", value, "monthSalary");
            return (Criteria) this;
        }
	
        public Criteria andMonthSalaryIn(List<String> values) {
            addCriterion("`month_salary` IN", values, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryNotIn(List<String> values) {
            addCriterion("`month_salary` NOT IN", values, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryBetween(String value1, String value2) {
            addCriterion("`month_salary` BETWEEN", value1, value2, "monthSalary");
            return (Criteria) this;
        }

        public Criteria andMonthSalaryNotBetween(String value1, String value2) {
            addCriterion("`month_salary` NOT BETWEEN", value1, value2, "monthSalary");
            return (Criteria) this;
        }
	
        public Criteria andWorkTimeIsNull() {
            addCriterion("`work_time` IS NULL");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNotNull() {
            addCriterion("`work_time` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEqualTo(String value) {
            addCriterion("`work_time` =", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotEqualTo(String value) {
            addCriterion("`work_time` <>", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThan(String value) {
            addCriterion("`work_time` >", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`work_time` >=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThan(String value) {
            addCriterion("`work_time` <", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("`work_time` <=", value, "workTime");
            return (Criteria) this;
        }
	
        public Criteria andWorkTimeLike(String value) {
            addCriterion("`work_time` LIKE", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotLike(String value) {
            addCriterion("`work_time` NOT LIKE", value, "workTime");
            return (Criteria) this;
        }
	
        public Criteria andWorkTimeIn(List<String> values) {
            addCriterion("`work_time` IN", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotIn(List<String> values) {
            addCriterion("`work_time` NOT IN", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeBetween(String value1, String value2) {
            addCriterion("`work_time` BETWEEN", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotBetween(String value1, String value2) {
            addCriterion("`work_time` NOT BETWEEN", value1, value2, "workTime");
            return (Criteria) this;
        }
	
        public Criteria andPromiseeIsNull() {
            addCriterion("`promisee` IS NULL");
            return (Criteria) this;
        }

        public Criteria andPromiseeIsNotNull() {
            addCriterion("`promisee` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andPromiseeEqualTo(String value) {
            addCriterion("`promisee` =", value, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeNotEqualTo(String value) {
            addCriterion("`promisee` <>", value, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeGreaterThan(String value) {
            addCriterion("`promisee` >", value, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeGreaterThanOrEqualTo(String value) {
            addCriterion("`promisee` >=", value, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeLessThan(String value) {
            addCriterion("`promisee` <", value, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeLessThanOrEqualTo(String value) {
            addCriterion("`promisee` <=", value, "promisee");
            return (Criteria) this;
        }
	
        public Criteria andPromiseeLike(String value) {
            addCriterion("`promisee` LIKE", value, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeNotLike(String value) {
            addCriterion("`promisee` NOT LIKE", value, "promisee");
            return (Criteria) this;
        }
	
        public Criteria andPromiseeIn(List<String> values) {
            addCriterion("`promisee` IN", values, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeNotIn(List<String> values) {
            addCriterion("`promisee` NOT IN", values, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeBetween(String value1, String value2) {
            addCriterion("`promisee` BETWEEN", value1, value2, "promisee");
            return (Criteria) this;
        }

        public Criteria andPromiseeNotBetween(String value1, String value2) {
            addCriterion("`promisee` NOT BETWEEN", value1, value2, "promisee");
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
        public Criteria andPostLikeInsensitive(String value) {
            addCriterion("UPPER(`post`) LIKE", value.toUpperCase(), "post");
            return (Criteria) this;
        }
        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("UPPER(`name`) LIKE", value.toUpperCase(), "name");
            return (Criteria) this;
        }
        public Criteria andSexLikeInsensitive(String value) {
            addCriterion("UPPER(`sex`) LIKE", value.toUpperCase(), "sex");
            return (Criteria) this;
        }
        public Criteria andJiguanLikeInsensitive(String value) {
            addCriterion("UPPER(`jiguan`) LIKE", value.toUpperCase(), "jiguan");
            return (Criteria) this;
        }
        public Criteria andMinzuLikeInsensitive(String value) {
            addCriterion("UPPER(`minzu`) LIKE", value.toUpperCase(), "minzu");
            return (Criteria) this;
        }
        public Criteria andBirthdayLikeInsensitive(String value) {
            addCriterion("UPPER(`birthday`) LIKE", value.toUpperCase(), "birthday");
            return (Criteria) this;
        }
        public Criteria andNowAddressLikeInsensitive(String value) {
            addCriterion("UPPER(`now_address`) LIKE", value.toUpperCase(), "nowAddress");
            return (Criteria) this;
        }
        public Criteria andPeiouNameLikeInsensitive(String value) {
            addCriterion("UPPER(`peiou_name`) LIKE", value.toUpperCase(), "peiouName");
            return (Criteria) this;
        }
        public Criteria andWorkCompanyLikeInsensitive(String value) {
            addCriterion("UPPER(`work_company`) LIKE", value.toUpperCase(), "workCompany");
            return (Criteria) this;
        }
        public Criteria andPreTaxSalaryLikeInsensitive(String value) {
            addCriterion("UPPER(`pre_tax_salary`) LIKE", value.toUpperCase(), "preTaxSalary");
            return (Criteria) this;
        }
        public Criteria andAfterTaxSalaryLikeInsensitive(String value) {
            addCriterion("UPPER(`after_tax_salary`) LIKE", value.toUpperCase(), "afterTaxSalary");
            return (Criteria) this;
        }
        public Criteria andWorkTimeLikeInsensitive(String value) {
            addCriterion("UPPER(`work_time`) LIKE", value.toUpperCase(), "workTime");
            return (Criteria) this;
        }
        public Criteria andPromiseeLikeInsensitive(String value) {
            addCriterion("UPPER(`promisee`) LIKE", value.toUpperCase(), "promisee");
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