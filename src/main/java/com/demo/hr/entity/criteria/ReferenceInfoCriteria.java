package com.demo.hr.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReferenceInfoCriteria {
	protected String sort;
	
	protected String order;

    protected boolean distinct;

	protected Integer offset;

	protected Integer limit;

	protected Map<String,Object> extras;
	
    protected List<Criteria> oredCriteria;

    public ReferenceInfoCriteria() {
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
	
        public Criteria andHrComTitleIsNull() {
            addCriterion("`hr_com_title` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHrComTitleIsNotNull() {
            addCriterion("`hr_com_title` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHrComTitleEqualTo(String value) {
            addCriterion("`hr_com_title` =", value, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleNotEqualTo(String value) {
            addCriterion("`hr_com_title` <>", value, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleGreaterThan(String value) {
            addCriterion("`hr_com_title` >", value, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`hr_com_title` >=", value, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleLessThan(String value) {
            addCriterion("`hr_com_title` <", value, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleLessThanOrEqualTo(String value) {
            addCriterion("`hr_com_title` <=", value, "hrComTitle");
            return (Criteria) this;
        }
	
        public Criteria andHrComTitleLike(String value) {
            addCriterion("`hr_com_title` LIKE", value, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleNotLike(String value) {
            addCriterion("`hr_com_title` NOT LIKE", value, "hrComTitle");
            return (Criteria) this;
        }
	
        public Criteria andHrComTitleIn(List<String> values) {
            addCriterion("`hr_com_title` IN", values, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleNotIn(List<String> values) {
            addCriterion("`hr_com_title` NOT IN", values, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleBetween(String value1, String value2) {
            addCriterion("`hr_com_title` BETWEEN", value1, value2, "hrComTitle");
            return (Criteria) this;
        }

        public Criteria andHrComTitleNotBetween(String value1, String value2) {
            addCriterion("`hr_com_title` NOT BETWEEN", value1, value2, "hrComTitle");
            return (Criteria) this;
        }
	
        public Criteria andHrLinkIsNull() {
            addCriterion("`hr_link` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHrLinkIsNotNull() {
            addCriterion("`hr_link` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHrLinkEqualTo(String value) {
            addCriterion("`hr_link` =", value, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkNotEqualTo(String value) {
            addCriterion("`hr_link` <>", value, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkGreaterThan(String value) {
            addCriterion("`hr_link` >", value, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkGreaterThanOrEqualTo(String value) {
            addCriterion("`hr_link` >=", value, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkLessThan(String value) {
            addCriterion("`hr_link` <", value, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkLessThanOrEqualTo(String value) {
            addCriterion("`hr_link` <=", value, "hrLink");
            return (Criteria) this;
        }
	
        public Criteria andHrLinkLike(String value) {
            addCriterion("`hr_link` LIKE", value, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkNotLike(String value) {
            addCriterion("`hr_link` NOT LIKE", value, "hrLink");
            return (Criteria) this;
        }
	
        public Criteria andHrLinkIn(List<String> values) {
            addCriterion("`hr_link` IN", values, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkNotIn(List<String> values) {
            addCriterion("`hr_link` NOT IN", values, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkBetween(String value1, String value2) {
            addCriterion("`hr_link` BETWEEN", value1, value2, "hrLink");
            return (Criteria) this;
        }

        public Criteria andHrLinkNotBetween(String value1, String value2) {
            addCriterion("`hr_link` NOT BETWEEN", value1, value2, "hrLink");
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
	
        public Criteria andLeaderNameIsNull() {
            addCriterion("`leader_name` IS NULL");
            return (Criteria) this;
        }

        public Criteria andLeaderNameIsNotNull() {
            addCriterion("`leader_name` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andLeaderNameEqualTo(String value) {
            addCriterion("`leader_name` =", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotEqualTo(String value) {
            addCriterion("`leader_name` <>", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameGreaterThan(String value) {
            addCriterion("`leader_name` >", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("`leader_name` >=", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameLessThan(String value) {
            addCriterion("`leader_name` <", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("`leader_name` <=", value, "leaderName");
            return (Criteria) this;
        }
	
        public Criteria andLeaderNameLike(String value) {
            addCriterion("`leader_name` LIKE", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotLike(String value) {
            addCriterion("`leader_name` NOT LIKE", value, "leaderName");
            return (Criteria) this;
        }
	
        public Criteria andLeaderNameIn(List<String> values) {
            addCriterion("`leader_name` IN", values, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotIn(List<String> values) {
            addCriterion("`leader_name` NOT IN", values, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameBetween(String value1, String value2) {
            addCriterion("`leader_name` BETWEEN", value1, value2, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotBetween(String value1, String value2) {
            addCriterion("`leader_name` NOT BETWEEN", value1, value2, "leaderName");
            return (Criteria) this;
        }
	
        public Criteria andLdComTitleIsNull() {
            addCriterion("`ld_com_title` IS NULL");
            return (Criteria) this;
        }

        public Criteria andLdComTitleIsNotNull() {
            addCriterion("`ld_com_title` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andLdComTitleEqualTo(String value) {
            addCriterion("`ld_com_title` =", value, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleNotEqualTo(String value) {
            addCriterion("`ld_com_title` <>", value, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleGreaterThan(String value) {
            addCriterion("`ld_com_title` >", value, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`ld_com_title` >=", value, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleLessThan(String value) {
            addCriterion("`ld_com_title` <", value, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleLessThanOrEqualTo(String value) {
            addCriterion("`ld_com_title` <=", value, "ldComTitle");
            return (Criteria) this;
        }
	
        public Criteria andLdComTitleLike(String value) {
            addCriterion("`ld_com_title` LIKE", value, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleNotLike(String value) {
            addCriterion("`ld_com_title` NOT LIKE", value, "ldComTitle");
            return (Criteria) this;
        }
	
        public Criteria andLdComTitleIn(List<String> values) {
            addCriterion("`ld_com_title` IN", values, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleNotIn(List<String> values) {
            addCriterion("`ld_com_title` NOT IN", values, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleBetween(String value1, String value2) {
            addCriterion("`ld_com_title` BETWEEN", value1, value2, "ldComTitle");
            return (Criteria) this;
        }

        public Criteria andLdComTitleNotBetween(String value1, String value2) {
            addCriterion("`ld_com_title` NOT BETWEEN", value1, value2, "ldComTitle");
            return (Criteria) this;
        }
	
        public Criteria andLdLinkIsNull() {
            addCriterion("`ld_link` IS NULL");
            return (Criteria) this;
        }

        public Criteria andLdLinkIsNotNull() {
            addCriterion("`ld_link` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andLdLinkEqualTo(String value) {
            addCriterion("`ld_link` =", value, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkNotEqualTo(String value) {
            addCriterion("`ld_link` <>", value, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkGreaterThan(String value) {
            addCriterion("`ld_link` >", value, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkGreaterThanOrEqualTo(String value) {
            addCriterion("`ld_link` >=", value, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkLessThan(String value) {
            addCriterion("`ld_link` <", value, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkLessThanOrEqualTo(String value) {
            addCriterion("`ld_link` <=", value, "ldLink");
            return (Criteria) this;
        }
	
        public Criteria andLdLinkLike(String value) {
            addCriterion("`ld_link` LIKE", value, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkNotLike(String value) {
            addCriterion("`ld_link` NOT LIKE", value, "ldLink");
            return (Criteria) this;
        }
	
        public Criteria andLdLinkIn(List<String> values) {
            addCriterion("`ld_link` IN", values, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkNotIn(List<String> values) {
            addCriterion("`ld_link` NOT IN", values, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkBetween(String value1, String value2) {
            addCriterion("`ld_link` BETWEEN", value1, value2, "ldLink");
            return (Criteria) this;
        }

        public Criteria andLdLinkNotBetween(String value1, String value2) {
            addCriterion("`ld_link` NOT BETWEEN", value1, value2, "ldLink");
            return (Criteria) this;
        }
	
        public Criteria andLdEmailIsNull() {
            addCriterion("`ld_email` IS NULL");
            return (Criteria) this;
        }

        public Criteria andLdEmailIsNotNull() {
            addCriterion("`ld_email` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andLdEmailEqualTo(String value) {
            addCriterion("`ld_email` =", value, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailNotEqualTo(String value) {
            addCriterion("`ld_email` <>", value, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailGreaterThan(String value) {
            addCriterion("`ld_email` >", value, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`ld_email` >=", value, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailLessThan(String value) {
            addCriterion("`ld_email` <", value, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailLessThanOrEqualTo(String value) {
            addCriterion("`ld_email` <=", value, "ldEmail");
            return (Criteria) this;
        }
	
        public Criteria andLdEmailLike(String value) {
            addCriterion("`ld_email` LIKE", value, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailNotLike(String value) {
            addCriterion("`ld_email` NOT LIKE", value, "ldEmail");
            return (Criteria) this;
        }
	
        public Criteria andLdEmailIn(List<String> values) {
            addCriterion("`ld_email` IN", values, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailNotIn(List<String> values) {
            addCriterion("`ld_email` NOT IN", values, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailBetween(String value1, String value2) {
            addCriterion("`ld_email` BETWEEN", value1, value2, "ldEmail");
            return (Criteria) this;
        }

        public Criteria andLdEmailNotBetween(String value1, String value2) {
            addCriterion("`ld_email` NOT BETWEEN", value1, value2, "ldEmail");
            return (Criteria) this;
        }
	
        public Criteria andHasYyIsNull() {
            addCriterion("`has_yy` IS NULL");
            return (Criteria) this;
        }

        public Criteria andHasYyIsNotNull() {
            addCriterion("`has_yy` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andHasYyEqualTo(Integer value) {
            addCriterion("`has_yy` =", value, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyNotEqualTo(Integer value) {
            addCriterion("`has_yy` <>", value, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyGreaterThan(Integer value) {
            addCriterion("`has_yy` >", value, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyGreaterThanOrEqualTo(Integer value) {
            addCriterion("`has_yy` >=", value, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyLessThan(Integer value) {
            addCriterion("`has_yy` <", value, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyLessThanOrEqualTo(Integer value) {
            addCriterion("`has_yy` <=", value, "hasYy");
            return (Criteria) this;
        }
	
        public Criteria andHasYyIn(List<Integer> values) {
            addCriterion("`has_yy` IN", values, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyNotIn(List<Integer> values) {
            addCriterion("`has_yy` NOT IN", values, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyBetween(Integer value1, Integer value2) {
            addCriterion("`has_yy` BETWEEN", value1, value2, "hasYy");
            return (Criteria) this;
        }

        public Criteria andHasYyNotBetween(Integer value1, Integer value2) {
            addCriterion("`has_yy` NOT BETWEEN", value1, value2, "hasYy");
            return (Criteria) this;
        }
	
        public Criteria andYyNameIsNull() {
            addCriterion("`yy_name` IS NULL");
            return (Criteria) this;
        }

        public Criteria andYyNameIsNotNull() {
            addCriterion("`yy_name` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andYyNameEqualTo(String value) {
            addCriterion("`yy_name` =", value, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameNotEqualTo(String value) {
            addCriterion("`yy_name` <>", value, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameGreaterThan(String value) {
            addCriterion("`yy_name` >", value, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameGreaterThanOrEqualTo(String value) {
            addCriterion("`yy_name` >=", value, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameLessThan(String value) {
            addCriterion("`yy_name` <", value, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameLessThanOrEqualTo(String value) {
            addCriterion("`yy_name` <=", value, "yyName");
            return (Criteria) this;
        }
	
        public Criteria andYyNameLike(String value) {
            addCriterion("`yy_name` LIKE", value, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameNotLike(String value) {
            addCriterion("`yy_name` NOT LIKE", value, "yyName");
            return (Criteria) this;
        }
	
        public Criteria andYyNameIn(List<String> values) {
            addCriterion("`yy_name` IN", values, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameNotIn(List<String> values) {
            addCriterion("`yy_name` NOT IN", values, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameBetween(String value1, String value2) {
            addCriterion("`yy_name` BETWEEN", value1, value2, "yyName");
            return (Criteria) this;
        }

        public Criteria andYyNameNotBetween(String value1, String value2) {
            addCriterion("`yy_name` NOT BETWEEN", value1, value2, "yyName");
            return (Criteria) this;
        }
	
        public Criteria andYygxIsNull() {
            addCriterion("`yygx` IS NULL");
            return (Criteria) this;
        }

        public Criteria andYygxIsNotNull() {
            addCriterion("`yygx` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andYygxEqualTo(String value) {
            addCriterion("`yygx` =", value, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxNotEqualTo(String value) {
            addCriterion("`yygx` <>", value, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxGreaterThan(String value) {
            addCriterion("`yygx` >", value, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxGreaterThanOrEqualTo(String value) {
            addCriterion("`yygx` >=", value, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxLessThan(String value) {
            addCriterion("`yygx` <", value, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxLessThanOrEqualTo(String value) {
            addCriterion("`yygx` <=", value, "yygx");
            return (Criteria) this;
        }
	
        public Criteria andYygxLike(String value) {
            addCriterion("`yygx` LIKE", value, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxNotLike(String value) {
            addCriterion("`yygx` NOT LIKE", value, "yygx");
            return (Criteria) this;
        }
	
        public Criteria andYygxIn(List<String> values) {
            addCriterion("`yygx` IN", values, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxNotIn(List<String> values) {
            addCriterion("`yygx` NOT IN", values, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxBetween(String value1, String value2) {
            addCriterion("`yygx` BETWEEN", value1, value2, "yygx");
            return (Criteria) this;
        }

        public Criteria andYygxNotBetween(String value1, String value2) {
            addCriterion("`yygx` NOT BETWEEN", value1, value2, "yygx");
            return (Criteria) this;
        }
	
        public Criteria andYyTitleIsNull() {
            addCriterion("`yy_title` IS NULL");
            return (Criteria) this;
        }

        public Criteria andYyTitleIsNotNull() {
            addCriterion("`yy_title` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andYyTitleEqualTo(String value) {
            addCriterion("`yy_title` =", value, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleNotEqualTo(String value) {
            addCriterion("`yy_title` <>", value, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleGreaterThan(String value) {
            addCriterion("`yy_title` >", value, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`yy_title` >=", value, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleLessThan(String value) {
            addCriterion("`yy_title` <", value, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleLessThanOrEqualTo(String value) {
            addCriterion("`yy_title` <=", value, "yyTitle");
            return (Criteria) this;
        }
	
        public Criteria andYyTitleLike(String value) {
            addCriterion("`yy_title` LIKE", value, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleNotLike(String value) {
            addCriterion("`yy_title` NOT LIKE", value, "yyTitle");
            return (Criteria) this;
        }
	
        public Criteria andYyTitleIn(List<String> values) {
            addCriterion("`yy_title` IN", values, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleNotIn(List<String> values) {
            addCriterion("`yy_title` NOT IN", values, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleBetween(String value1, String value2) {
            addCriterion("`yy_title` BETWEEN", value1, value2, "yyTitle");
            return (Criteria) this;
        }

        public Criteria andYyTitleNotBetween(String value1, String value2) {
            addCriterion("`yy_title` NOT BETWEEN", value1, value2, "yyTitle");
            return (Criteria) this;
        }
	
        public Criteria andYyEmailIsNull() {
            addCriterion("`yy_email` IS NULL");
            return (Criteria) this;
        }

        public Criteria andYyEmailIsNotNull() {
            addCriterion("`yy_email` IS NOT NULL");
            return (Criteria) this;
        }

        public Criteria andYyEmailEqualTo(String value) {
            addCriterion("`yy_email` =", value, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailNotEqualTo(String value) {
            addCriterion("`yy_email` <>", value, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailGreaterThan(String value) {
            addCriterion("`yy_email` >", value, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`yy_email` >=", value, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailLessThan(String value) {
            addCriterion("`yy_email` <", value, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailLessThanOrEqualTo(String value) {
            addCriterion("`yy_email` <=", value, "yyEmail");
            return (Criteria) this;
        }
	
        public Criteria andYyEmailLike(String value) {
            addCriterion("`yy_email` LIKE", value, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailNotLike(String value) {
            addCriterion("`yy_email` NOT LIKE", value, "yyEmail");
            return (Criteria) this;
        }
	
        public Criteria andYyEmailIn(List<String> values) {
            addCriterion("`yy_email` IN", values, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailNotIn(List<String> values) {
            addCriterion("`yy_email` NOT IN", values, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailBetween(String value1, String value2) {
            addCriterion("`yy_email` BETWEEN", value1, value2, "yyEmail");
            return (Criteria) this;
        }

        public Criteria andYyEmailNotBetween(String value1, String value2) {
            addCriterion("`yy_email` NOT BETWEEN", value1, value2, "yyEmail");
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
        public Criteria andHrNameLikeInsensitive(String value) {
            addCriterion("UPPER(`hr_name`) LIKE", value.toUpperCase(), "hrName");
            return (Criteria) this;
        }
        public Criteria andHrComTitleLikeInsensitive(String value) {
            addCriterion("UPPER(`hr_com_title`) LIKE", value.toUpperCase(), "hrComTitle");
            return (Criteria) this;
        }
        public Criteria andHrLinkLikeInsensitive(String value) {
            addCriterion("UPPER(`hr_link`) LIKE", value.toUpperCase(), "hrLink");
            return (Criteria) this;
        }
        public Criteria andHrEmailLikeInsensitive(String value) {
            addCriterion("UPPER(`hr_email`) LIKE", value.toUpperCase(), "hrEmail");
            return (Criteria) this;
        }
        public Criteria andLeaderNameLikeInsensitive(String value) {
            addCriterion("UPPER(`leader_name`) LIKE", value.toUpperCase(), "leaderName");
            return (Criteria) this;
        }
        public Criteria andLdComTitleLikeInsensitive(String value) {
            addCriterion("UPPER(`ld_com_title`) LIKE", value.toUpperCase(), "ldComTitle");
            return (Criteria) this;
        }
        public Criteria andLdLinkLikeInsensitive(String value) {
            addCriterion("UPPER(`ld_link`) LIKE", value.toUpperCase(), "ldLink");
            return (Criteria) this;
        }
        public Criteria andLdEmailLikeInsensitive(String value) {
            addCriterion("UPPER(`ld_email`) LIKE", value.toUpperCase(), "ldEmail");
            return (Criteria) this;
        }
        public Criteria andYyNameLikeInsensitive(String value) {
            addCriterion("UPPER(`yy_name`) LIKE", value.toUpperCase(), "yyName");
            return (Criteria) this;
        }
        public Criteria andYygxLikeInsensitive(String value) {
            addCriterion("UPPER(`yygx`) LIKE", value.toUpperCase(), "yygx");
            return (Criteria) this;
        }
        public Criteria andYyTitleLikeInsensitive(String value) {
            addCriterion("UPPER(`yy_title`) LIKE", value.toUpperCase(), "yyTitle");
            return (Criteria) this;
        }
        public Criteria andYyEmailLikeInsensitive(String value) {
            addCriterion("UPPER(`yy_email`) LIKE", value.toUpperCase(), "yyEmail");
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