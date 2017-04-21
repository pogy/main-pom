package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguDomainRetainExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguDomainRetainExample.Criteria> oredCriteria = new ArrayList();

    public ShiguDomainRetainExample() {
    }

    private Integer startIndex;
    private Integer endIndex;
    private String fields;
    protected String sqlStirng;
    private String webSite;

    public String getWebSite() {
        return this.webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getSqlStirng() {
        return this.sqlStirng;
    }

    public void setSqlStirng(String sqlStirng) {
        this.sqlStirng = sqlStirng;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return this.endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public String getFields() {
        return this.fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public List<ShiguDomainRetainExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguDomainRetainExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguDomainRetainExample.Criteria or() {
        ShiguDomainRetainExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguDomainRetainExample.Criteria createCriteria() {
        ShiguDomainRetainExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguDomainRetainExample.Criteria createCriteriaInternal() {
        ShiguDomainRetainExample.Criteria criteria = new ShiguDomainRetainExample.Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
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
            return this.condition;
        }

        public Object getValue() {
            return this.value;
        }

        public Object getSecondValue() {
            return this.secondValue;
        }

        public boolean isNoValue() {
            return this.noValue;
        }

        public boolean isSingleValue() {
            return this.singleValue;
        }

        public boolean isBetweenValue() {
            return this.betweenValue;
        }

        public boolean isListValue() {
            return this.listValue;
        }

        public String getTypeHandler() {
            return this.typeHandler;
        }

        protected Criterion(String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if(value instanceof List) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }

        }

        protected Criterion(String condition, Object value) {
            this(condition, value, (String)null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, (String)null);
        }
    }

    public static class Criteria extends ShiguDomainRetainExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguDomainRetainExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguDomainRetainExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguDomainRetainExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguDomainRetainExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguDomainRetainExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguDomainRetainExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguDomainRetainExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainIsNull() {
            this.addCriterion("domain is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainIsNotNull() {
            this.addCriterion("domain is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainEqualTo(String value) {
            this.addCriterion("domain =", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainNotEqualTo(String value) {
            this.addCriterion("domain <>", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainGreaterThan(String value) {
            this.addCriterion("domain >", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainGreaterThanOrEqualTo(String value) {
            this.addCriterion("domain >=", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainLessThan(String value) {
            this.addCriterion("domain <", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainLessThanOrEqualTo(String value) {
            this.addCriterion("domain <=", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainLike(String value) {
            this.addCriterion("domain like", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainNotLike(String value) {
            this.addCriterion("domain not like", value, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andDomainIn(List<String> values) {
            this.addCriterion("domain in", values, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainNotIn(List<String> values) {
            this.addCriterion("domain not in", values, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainBetween(String value1, String value2) {
            this.addCriterion("domain between", value1, value2, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andDomainNotBetween(String value1, String value2) {
            this.addCriterion("domain not between", value1, value2, "domain");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }        public ShiguDomainRetainExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguDomainRetainExample.Criteria)this;
        }
    }
}
