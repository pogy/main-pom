package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderCityExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderCityExample.Criteria> oredCriteria = new ArrayList();

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

    public List<OrderCityExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderCityExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderCityExample.Criteria or() {
        OrderCityExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderCityExample.Criteria createCriteria() {
        OrderCityExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderCityExample.Criteria createCriteriaInternal() {
        OrderCityExample.Criteria criteria = new OrderCityExample.Criteria();
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

    public static class Criteria extends OrderCityExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderCityExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderCityExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderCityExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderCityExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderCityExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderCityExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderCityExample.Criteria andCityNameIsNull() {
            this.addCriterion("cityName is null");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameIsNotNull() {
            this.addCriterion("cityName is not null");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameEqualTo(String value) {
            this.addCriterion("cityName =", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameNotEqualTo(String value) {
            this.addCriterion("cityName <>", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameGreaterThan(String value) {
            this.addCriterion("cityName >", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("cityName >=", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameLessThan(String value) {
            this.addCriterion("cityName <", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            this.addCriterion("cityName <=", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameLike(String value) {
            this.addCriterion("cityName like", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameNotLike(String value) {
            this.addCriterion("cityName not like", value, "city_name");
            return (OrderCityExample.Criteria)this;
        }        public OrderCityExample.Criteria andCityNameIn(List<String> values) {
            this.addCriterion("cityName in", values, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameNotIn(List<String> values) {
            this.addCriterion("cityName not in", values, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameBetween(String value1, String value2) {
            this.addCriterion("cityName between", value1, value2, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityNameNotBetween(String value1, String value2) {
            this.addCriterion("cityName not between", value1, value2, "city_name");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdIsNull() {
            this.addCriterion("provId is null");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdIsNotNull() {
            this.addCriterion("provId is not null");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdEqualTo(String value) {
            this.addCriterion("provId =", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdNotEqualTo(String value) {
            this.addCriterion("provId <>", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdGreaterThan(String value) {
            this.addCriterion("provId >", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("provId >=", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdLessThan(String value) {
            this.addCriterion("provId <", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdLessThanOrEqualTo(String value) {
            this.addCriterion("provId <=", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdLike(String value) {
            this.addCriterion("provId like", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdNotLike(String value) {
            this.addCriterion("provId not like", value, "prov_id");
            return (OrderCityExample.Criteria)this;
        }        public OrderCityExample.Criteria andProvIdIn(List<String> values) {
            this.addCriterion("provId in", values, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdNotIn(List<String> values) {
            this.addCriterion("provId not in", values, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdBetween(String value1, String value2) {
            this.addCriterion("provId between", value1, value2, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andProvIdNotBetween(String value1, String value2) {
            this.addCriterion("provId not between", value1, value2, "prov_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdIsNull() {
            this.addCriterion("cityId is null");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("cityId is not null");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdEqualTo(String value) {
            this.addCriterion("cityId =", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdNotEqualTo(String value) {
            this.addCriterion("cityId <>", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdGreaterThan(String value) {
            this.addCriterion("cityId >", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("cityId >=", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdLessThan(String value) {
            this.addCriterion("cityId <", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdLessThanOrEqualTo(String value) {
            this.addCriterion("cityId <=", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdLike(String value) {
            this.addCriterion("cityId like", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("cityId not like", value, "city_id");
            return (OrderCityExample.Criteria)this;
        }        public OrderCityExample.Criteria andCityIdIn(List<String> values) {
            this.addCriterion("cityId in", values, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdNotIn(List<String> values) {
            this.addCriterion("cityId not in", values, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdBetween(String value1, String value2) {
            this.addCriterion("cityId between", value1, value2, "city_id");
            return (OrderCityExample.Criteria)this;
        }

        public OrderCityExample.Criteria andCityIdNotBetween(String value1, String value2) {
            this.addCriterion("cityId not between", value1, value2, "city_id");
            return (OrderCityExample.Criteria)this;
        }
    }
}
