package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderTownExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderTownExample.Criteria> oredCriteria = new ArrayList();

    public OrderTownExample() {
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

    public List<OrderTownExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderTownExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderTownExample.Criteria or() {
        OrderTownExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderTownExample.Criteria createCriteria() {
        OrderTownExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderTownExample.Criteria createCriteriaInternal() {
        OrderTownExample.Criteria criteria = new OrderTownExample.Criteria();
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

    public static class Criteria extends OrderTownExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderTownExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderTownExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderTownExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderTownExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderTownExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderTownExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderTownExample.Criteria andTownIdIsNull() {
            this.addCriterion("townId is null");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdIsNotNull() {
            this.addCriterion("townId is not null");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdEqualTo(String value) {
            this.addCriterion("townId =", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdNotEqualTo(String value) {
            this.addCriterion("townId <>", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdGreaterThan(String value) {
            this.addCriterion("townId >", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("townId >=", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdLessThan(String value) {
            this.addCriterion("townId <", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdLessThanOrEqualTo(String value) {
            this.addCriterion("townId <=", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdLike(String value) {
            this.addCriterion("townId like", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdNotLike(String value) {
            this.addCriterion("townId not like", value, "town_id");
            return (OrderTownExample.Criteria)this;
        }        public OrderTownExample.Criteria andTownIdIn(List<String> values) {
            this.addCriterion("townId in", values, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdNotIn(List<String> values) {
            this.addCriterion("townId not in", values, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdBetween(String value1, String value2) {
            this.addCriterion("townId between", value1, value2, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownIdNotBetween(String value1, String value2) {
            this.addCriterion("townId not between", value1, value2, "town_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameIsNull() {
            this.addCriterion("townName is null");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameIsNotNull() {
            this.addCriterion("townName is not null");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameEqualTo(String value) {
            this.addCriterion("townName =", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameNotEqualTo(String value) {
            this.addCriterion("townName <>", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameGreaterThan(String value) {
            this.addCriterion("townName >", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("townName >=", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameLessThan(String value) {
            this.addCriterion("townName <", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameLessThanOrEqualTo(String value) {
            this.addCriterion("townName <=", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameLike(String value) {
            this.addCriterion("townName like", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameNotLike(String value) {
            this.addCriterion("townName not like", value, "town_name");
            return (OrderTownExample.Criteria)this;
        }        public OrderTownExample.Criteria andTownNameIn(List<String> values) {
            this.addCriterion("townName in", values, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameNotIn(List<String> values) {
            this.addCriterion("townName not in", values, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameBetween(String value1, String value2) {
            this.addCriterion("townName between", value1, value2, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andTownNameNotBetween(String value1, String value2) {
            this.addCriterion("townName not between", value1, value2, "town_name");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdIsNull() {
            this.addCriterion("cityId is null");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("cityId is not null");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdEqualTo(String value) {
            this.addCriterion("cityId =", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdNotEqualTo(String value) {
            this.addCriterion("cityId <>", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdGreaterThan(String value) {
            this.addCriterion("cityId >", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("cityId >=", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdLessThan(String value) {
            this.addCriterion("cityId <", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdLessThanOrEqualTo(String value) {
            this.addCriterion("cityId <=", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdLike(String value) {
            this.addCriterion("cityId like", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("cityId not like", value, "city_id");
            return (OrderTownExample.Criteria)this;
        }        public OrderTownExample.Criteria andCityIdIn(List<String> values) {
            this.addCriterion("cityId in", values, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdNotIn(List<String> values) {
            this.addCriterion("cityId not in", values, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdBetween(String value1, String value2) {
            this.addCriterion("cityId between", value1, value2, "city_id");
            return (OrderTownExample.Criteria)this;
        }

        public OrderTownExample.Criteria andCityIdNotBetween(String value1, String value2) {
            this.addCriterion("cityId not between", value1, value2, "city_id");
            return (OrderTownExample.Criteria)this;
        }
    }
}
