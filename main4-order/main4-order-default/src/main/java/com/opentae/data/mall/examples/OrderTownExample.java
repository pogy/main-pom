package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderTownExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andTownIdIsNull() {
            this.addCriterion("town_id is null");
            return (Criteria)this;
        }

        public Criteria andTownIdIsNotNull() {
            this.addCriterion("town_id is not null");
            return (Criteria)this;
        }

        public Criteria andTownIdEqualTo(Long value) {
            this.addCriterion("town_id =", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotEqualTo(Long value) {
            this.addCriterion("town_id <>", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdGreaterThan(Long value) {
            this.addCriterion("town_id >", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("town_id >=", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdLessThan(Long value) {
            this.addCriterion("town_id <", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("town_id <=", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdLike(String value) {
            this.addCriterion("town_id like", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotLike(String value) {
            this.addCriterion("town_id not like", value, "townId");
            return (Criteria)this;
        }        public Criteria andTownIdIn(List<Long> values) {
            this.addCriterion("town_id in", values, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotIn(List<Long> values) {
            this.addCriterion("town_id not in", values, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdBetween(Long value1, Long value2) {
            this.addCriterion("town_id between", value1, value2, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("town_id not between", value1, value2, "townId");
            return (Criteria)this;
        }

        public Criteria andTownNameIsNull() {
            this.addCriterion("town_name is null");
            return (Criteria)this;
        }

        public Criteria andTownNameIsNotNull() {
            this.addCriterion("town_name is not null");
            return (Criteria)this;
        }

        public Criteria andTownNameEqualTo(String value) {
            this.addCriterion("town_name =", value, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameNotEqualTo(String value) {
            this.addCriterion("town_name <>", value, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameGreaterThan(String value) {
            this.addCriterion("town_name >", value, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("town_name >=", value, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameLessThan(String value) {
            this.addCriterion("town_name <", value, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameLessThanOrEqualTo(String value) {
            this.addCriterion("town_name <=", value, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameLike(String value) {
            this.addCriterion("town_name like", value, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameNotLike(String value) {
            this.addCriterion("town_name not like", value, "townName");
            return (Criteria)this;
        }        public Criteria andTownNameIn(List<String> values) {
            this.addCriterion("town_name in", values, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameNotIn(List<String> values) {
            this.addCriterion("town_name not in", values, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameBetween(String value1, String value2) {
            this.addCriterion("town_name between", value1, value2, "townName");
            return (Criteria)this;
        }

        public Criteria andTownNameNotBetween(String value1, String value2) {
            this.addCriterion("town_name not between", value1, value2, "townName");
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
