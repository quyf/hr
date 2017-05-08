package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EducationInfoCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public EducationInfoCriteria() {
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
	
        public Criteria andSchoolIsNull() {
            addCriterion("`school` IS NULL");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("`school` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("`school` =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("`school` <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("`school` >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("`school` >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("`school` <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("`school` <=", value, "school");
            return (Criteria) this;
        }
	
        public Criteria andSchoolLike(String value) {
            addCriterion("`school` LIKE", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("`school` NOT LIKE", value, "school");
            return (Criteria) this;
        }
	
        public Criteria andSchoolIn(List<String> values) {
            addCriterion("`school` IN", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("`school` NOT IN", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("`school` BETWEEN", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("`school` NOT BETWEEN", value1, value2, "school");
            return (Criteria) this;
        }
	
        public Criteria andMajorIsNull() {
            addCriterion("`major` IS NULL");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("`major` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("`major` =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("`major` <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("`major` >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("`major` >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("`major` <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("`major` <=", value, "major");
            return (Criteria) this;
        }
	
        public Criteria andMajorLike(String value) {
            addCriterion("`major` LIKE", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("`major` NOT LIKE", value, "major");
            return (Criteria) this;
        }
	
        public Criteria andMajorIn(List<String> values) {
            addCriterion("`major` IN", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("`major` NOT IN", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("`major` BETWEEN", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("`major` NOT BETWEEN", value1, value2, "major");
            return (Criteria) this;
        }
	
        public Criteria andXueliIsNull() {
            addCriterion("`xueli` IS NULL");
            return (Criteria) this;
        }

        public Criteria andXueliIsNotNull() {
            addCriterion("`xueli` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andXueliEqualTo(String value) {
            addCriterion("`xueli` =", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotEqualTo(String value) {
            addCriterion("`xueli` <>", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliGreaterThan(String value) {
            addCriterion("`xueli` >", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliGreaterThanOrEqualTo(String value) {
            addCriterion("`xueli` >=", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLessThan(String value) {
            addCriterion("`xueli` <", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliLessThanOrEqualTo(String value) {
            addCriterion("`xueli` <=", value, "xueli");
            return (Criteria) this;
        }
	
        public Criteria andXueliLike(String value) {
            addCriterion("`xueli` LIKE", value, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotLike(String value) {
            addCriterion("`xueli` NOT LIKE", value, "xueli");
            return (Criteria) this;
        }
	
        public Criteria andXueliIn(List<String> values) {
            addCriterion("`xueli` IN", values, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotIn(List<String> values) {
            addCriterion("`xueli` NOT IN", values, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliBetween(String value1, String value2) {
            addCriterion("`xueli` BETWEEN", value1, value2, "xueli");
            return (Criteria) this;
        }

        public Criteria andXueliNotBetween(String value1, String value2) {
            addCriterion("`xueli` NOT BETWEEN", value1, value2, "xueli");
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

        public Criteria andWayEqualTo(String value) {
            addCriterion("`way` =", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotEqualTo(String value) {
            addCriterion("`way` <>", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayGreaterThan(String value) {
            addCriterion("`way` >", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayGreaterThanOrEqualTo(String value) {
            addCriterion("`way` >=", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayLessThan(String value) {
            addCriterion("`way` <", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayLessThanOrEqualTo(String value) {
            addCriterion("`way` <=", value, "way");
            return (Criteria) this;
        }
	
        public Criteria andWayLike(String value) {
            addCriterion("`way` LIKE", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotLike(String value) {
            addCriterion("`way` NOT LIKE", value, "way");
            return (Criteria) this;
        }
	
        public Criteria andWayIn(List<String> values) {
            addCriterion("`way` IN", values, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotIn(List<String> values) {
            addCriterion("`way` NOT IN", values, "way");
            return (Criteria) this;
        }

        public Criteria andWayBetween(String value1, String value2) {
            addCriterion("`way` BETWEEN", value1, value2, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotBetween(String value1, String value2) {
            addCriterion("`way` NOT BETWEEN", value1, value2, "way");
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
        public Criteria andSchoolLikeInsensitive(String value) {
            addCriterion("UPPER(`school`) LIKE", value.toUpperCase(), "school");
            return (Criteria) this;
        }
        public Criteria andMajorLikeInsensitive(String value) {
            addCriterion("UPPER(`major`) LIKE", value.toUpperCase(), "major");
            return (Criteria) this;
        }
        public Criteria andXueliLikeInsensitive(String value) {
            addCriterion("UPPER(`xueli`) LIKE", value.toUpperCase(), "xueli");
            return (Criteria) this;
        }
        public Criteria andWayLikeInsensitive(String value) {
            addCriterion("UPPER(`way`) LIKE", value.toUpperCase(), "way");
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