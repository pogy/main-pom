package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderCityExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public OrderCityExample() {
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

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
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

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andCityNameIsNull() {
            this.addCriterion("city_name is null");
            return (Criteria)this;
        }

        public Criteria andCityNameIsNotNull() {
            this.addCriterion("city_name is not null");
            return (Criteria)this;
        }

        public Criteria andCityNameEqualTo(String value) {
            this.addCriterion("city_name =", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            this.addCriterion("city_name <>", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            this.addCriterion("city_name >", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("city_name >=", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameLessThan(String value) {
            this.addCriterion("city_name <", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            this.addCriterion("city_name <=", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameLike(String value) {
            this.addCriterion("city_name like", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotLike(String value) {
            this.addCriterion("city_name not like", value, "cityName");
            return (Criteria)this;
        }        public Criteria andCityNameIn(List<String> values) {
            this.addCriterion("city_name in", values, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            this.addCriterion("city_name not in", values, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            this.addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            this.addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria)this;
        }

        public Criteria andProvIdIsNull() {
            this.addCriterion("prov_id is null");
            return (Criteria)this;
        }

        public Criteria andProvIdIsNotNull() {
            this.addCriterion("prov_id is not null");
            return (Criteria)this;
        }

        public Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("prov_id =", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("prov_id <>", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("prov_id >", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("prov_id >=", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdLessThan(Long value) {
            this.addCriterion("prov_id <", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("prov_id <=", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdLike(String value) {
            this.addCriterion("prov_id like", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotLike(String value) {
            this.addCriterion("prov_id not like", value, "provId");
            return (Criteria)this;
        }        public Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("prov_id in", values, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("prov_id not in", values, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("prov_id between", value1, value2, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("prov_id not between", value1, value2, "provId");
            return (Criteria)this;
        }

        public Criteria andCityIdIsNull() {
            this.addCriterion("city_id is null");
            return (Criteria)this;
        }

        public Criteria andCityIdIsNotNull() {
            this.addCriterion("city_id is not null");
            return (Criteria)this;
        }

        public Criteria andCityIdEqualTo(Long value) {
            this.addCriterion("city_id =", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotEqualTo(Long value) {
            this.addCriterion("city_id <>", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdGreaterThan(Long value) {
            this.addCriterion("city_id >", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("city_id >=", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLessThan(Long value) {
            this.addCriterion("city_id <", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("city_id <=", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLike(String value) {
            this.addCriterion("city_id like", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotLike(String value) {
            this.addCriterion("city_id not like", value, "cityId");
            return (Criteria)this;
        }        public Criteria andCityIdIn(List<Long> values) {
            this.addCriterion("city_id in", values, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotIn(List<Long> values) {
            this.addCriterion("city_id not in", values, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdBetween(Long value1, Long value2) {
            this.addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria)this;
        }
    }
}
