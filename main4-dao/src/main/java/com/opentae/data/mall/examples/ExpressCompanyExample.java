package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ExpressCompanyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ExpressCompanyExample.Criteria> oredCriteria = new ArrayList();

    public ExpressCompanyExample() {
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

    public List<ExpressCompanyExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ExpressCompanyExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ExpressCompanyExample.Criteria or() {
        ExpressCompanyExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ExpressCompanyExample.Criteria createCriteria() {
        ExpressCompanyExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ExpressCompanyExample.Criteria createCriteriaInternal() {
        ExpressCompanyExample.Criteria criteria = new ExpressCompanyExample.Criteria();
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

    public static class Criteria extends ExpressCompanyExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ExpressCompanyExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ExpressCompanyExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ExpressCompanyExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ExpressCompanyExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ExpressCompanyExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ExpressCompanyExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ExpressCompanyExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameIsNull() {
            this.addCriterion("express_name is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameIsNotNull() {
            this.addCriterion("express_name is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameEqualTo(String value) {
            this.addCriterion("express_name =", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameNotEqualTo(String value) {
            this.addCriterion("express_name <>", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameGreaterThan(String value) {
            this.addCriterion("express_name >", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("express_name >=", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameLessThan(String value) {
            this.addCriterion("express_name <", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameLessThanOrEqualTo(String value) {
            this.addCriterion("express_name <=", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameLike(String value) {
            this.addCriterion("express_name like", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameNotLike(String value) {
            this.addCriterion("express_name not like", value, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andExpressNameIn(List<String> values) {
            this.addCriterion("express_name in", values, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameNotIn(List<String> values) {
            this.addCriterion("express_name not in", values, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameBetween(String value1, String value2) {
            this.addCriterion("express_name between", value1, value2, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressNameNotBetween(String value1, String value2) {
            this.addCriterion("express_name not between", value1, value2, "expressName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameIsNull() {
            this.addCriterion("en_name is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameIsNotNull() {
            this.addCriterion("en_name is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameEqualTo(String value) {
            this.addCriterion("en_name =", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameNotEqualTo(String value) {
            this.addCriterion("en_name <>", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameGreaterThan(String value) {
            this.addCriterion("en_name >", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("en_name >=", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameLessThan(String value) {
            this.addCriterion("en_name <", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameLessThanOrEqualTo(String value) {
            this.addCriterion("en_name <=", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameLike(String value) {
            this.addCriterion("en_name like", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameNotLike(String value) {
            this.addCriterion("en_name not like", value, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andEnNameIn(List<String> values) {
            this.addCriterion("en_name in", values, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameNotIn(List<String> values) {
            this.addCriterion("en_name not in", values, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameBetween(String value1, String value2) {
            this.addCriterion("en_name between", value1, value2, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andEnNameNotBetween(String value1, String value2) {
            this.addCriterion("en_name not between", value1, value2, "enName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusEqualTo(Integer value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusNotEqualTo(Integer value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusGreaterThan(Integer value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusLessThan(Integer value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andUseStatusIn(List<Integer> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusNotIn(List<Integer> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdIsNull() {
            this.addCriterion("express_company_id is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdIsNotNull() {
            this.addCriterion("express_company_id is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdEqualTo(Long value) {
            this.addCriterion("express_company_id =", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdNotEqualTo(Long value) {
            this.addCriterion("express_company_id <>", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdGreaterThan(Long value) {
            this.addCriterion("express_company_id >", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("express_company_id >=", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdLessThan(Long value) {
            this.addCriterion("express_company_id <", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("express_company_id <=", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdLike(String value) {
            this.addCriterion("express_company_id like", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdNotLike(String value) {
            this.addCriterion("express_company_id not like", value, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andExpressCompanyIdIn(List<Long> values) {
            this.addCriterion("express_company_id in", values, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdNotIn(List<Long> values) {
            this.addCriterion("express_company_id not in", values, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdBetween(Long value1, Long value2) {
            this.addCriterion("express_company_id between", value1, value2, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("express_company_id not between", value1, value2, "expressCompanyId");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameIsNull() {
            this.addCriterion("short_name is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameIsNotNull() {
            this.addCriterion("short_name is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameEqualTo(String value) {
            this.addCriterion("short_name =", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameNotEqualTo(String value) {
            this.addCriterion("short_name <>", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameGreaterThan(String value) {
            this.addCriterion("short_name >", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("short_name >=", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameLessThan(String value) {
            this.addCriterion("short_name <", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameLessThanOrEqualTo(String value) {
            this.addCriterion("short_name <=", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameLike(String value) {
            this.addCriterion("short_name like", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameNotLike(String value) {
            this.addCriterion("short_name not like", value, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andShortNameIn(List<String> values) {
            this.addCriterion("short_name in", values, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameNotIn(List<String> values) {
            this.addCriterion("short_name not in", values, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameBetween(String value1, String value2) {
            this.addCriterion("short_name between", value1, value2, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andShortNameNotBetween(String value1, String value2) {
            this.addCriterion("short_name not between", value1, value2, "shortName");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }        public ExpressCompanyExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }

        public ExpressCompanyExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ExpressCompanyExample.Criteria)this;
        }
    }
}
