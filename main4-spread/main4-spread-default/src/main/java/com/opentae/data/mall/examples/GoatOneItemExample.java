package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatOneItemExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatOneItemExample.Criteria> oredCriteria = new ArrayList();

    public GoatOneItemExample() {
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

    public List<GoatOneItemExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatOneItemExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatOneItemExample.Criteria or() {
        GoatOneItemExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatOneItemExample.Criteria createCriteria() {
        GoatOneItemExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatOneItemExample.Criteria createCriteriaInternal() {
        GoatOneItemExample.Criteria criteria = new GoatOneItemExample.Criteria();
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

    public static class Criteria extends GoatOneItemExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatOneItemExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatOneItemExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatOneItemExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatOneItemExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatOneItemExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatOneItemExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatOneItemExample.Criteria andDisEnabledIsNull() {
            this.addCriterion("dis_enabled is null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledIsNotNull() {
            this.addCriterion("dis_enabled is not null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledEqualTo(Boolean value) {
            this.addCriterion("dis_enabled =", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledNotEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <>", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledGreaterThan(Boolean value) {
            this.addCriterion("dis_enabled >", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled >=", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledLessThan(Boolean value) {
            this.addCriterion("dis_enabled <", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <=", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledLike(String value) {
            this.addCriterion("dis_enabled like", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledNotLike(String value) {
            this.addCriterion("dis_enabled not like", value, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }        public GoatOneItemExample.Criteria andDisEnabledIn(List<Boolean> values) {
            this.addCriterion("dis_enabled in", values, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledNotIn(List<Boolean> values) {
            this.addCriterion("dis_enabled not in", values, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled between", value1, value2, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andDisEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled not between", value1, value2, "disEnabled");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdIsNull() {
            this.addCriterion("local_id is null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdIsNotNull() {
            this.addCriterion("local_id is not null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdEqualTo(Long value) {
            this.addCriterion("local_id =", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdNotEqualTo(Long value) {
            this.addCriterion("local_id <>", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdGreaterThan(Long value) {
            this.addCriterion("local_id >", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("local_id >=", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdLessThan(Long value) {
            this.addCriterion("local_id <", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdLessThanOrEqualTo(Long value) {
            this.addCriterion("local_id <=", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdLike(String value) {
            this.addCriterion("local_id like", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdNotLike(String value) {
            this.addCriterion("local_id not like", value, "localId");
            return (GoatOneItemExample.Criteria)this;
        }        public GoatOneItemExample.Criteria andLocalIdIn(List<Long> values) {
            this.addCriterion("local_id in", values, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdNotIn(List<Long> values) {
            this.addCriterion("local_id not in", values, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdBetween(Long value1, Long value2) {
            this.addCriterion("local_id between", value1, value2, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andLocalIdNotBetween(Long value1, Long value2) {
            this.addCriterion("local_id not between", value1, value2, "localId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonIsNull() {
            this.addCriterion("recommon is null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonIsNotNull() {
            this.addCriterion("recommon is not null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonEqualTo(String value) {
            this.addCriterion("recommon =", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonNotEqualTo(String value) {
            this.addCriterion("recommon <>", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonGreaterThan(String value) {
            this.addCriterion("recommon >", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonGreaterThanOrEqualTo(String value) {
            this.addCriterion("recommon >=", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonLessThan(String value) {
            this.addCriterion("recommon <", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonLessThanOrEqualTo(String value) {
            this.addCriterion("recommon <=", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonLike(String value) {
            this.addCriterion("recommon like", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonNotLike(String value) {
            this.addCriterion("recommon not like", value, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }        public GoatOneItemExample.Criteria andRecommonIn(List<String> values) {
            this.addCriterion("recommon in", values, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonNotIn(List<String> values) {
            this.addCriterion("recommon not in", values, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonBetween(String value1, String value2) {
            this.addCriterion("recommon between", value1, value2, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andRecommonNotBetween(String value1, String value2) {
            this.addCriterion("recommon not between", value1, value2, "recommon");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdIsNull() {
            this.addCriterion("goat_id is null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdIsNotNull() {
            this.addCriterion("goat_id is not null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdEqualTo(Long value) {
            this.addCriterion("goat_id =", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdNotEqualTo(Long value) {
            this.addCriterion("goat_id <>", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdGreaterThan(Long value) {
            this.addCriterion("goat_id >", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goat_id >=", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdLessThan(Long value) {
            this.addCriterion("goat_id <", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goat_id <=", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdLike(String value) {
            this.addCriterion("goat_id like", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdNotLike(String value) {
            this.addCriterion("goat_id not like", value, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }        public GoatOneItemExample.Criteria andGoatIdIn(List<Long> values) {
            this.addCriterion("goat_id in", values, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdNotIn(List<Long> values) {
            this.addCriterion("goat_id not in", values, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            this.addCriterion("goat_id between", value1, value2, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goat_id not between", value1, value2, "goatId");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortIsNull() {
            this.addCriterion("sort is null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortIsNotNull() {
            this.addCriterion("sort is not null");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortEqualTo(Integer value) {
            this.addCriterion("sort =", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortNotEqualTo(Integer value) {
            this.addCriterion("sort <>", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortGreaterThan(Integer value) {
            this.addCriterion("sort >", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort >=", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortLessThan(Integer value) {
            this.addCriterion("sort <", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort <=", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortLike(String value) {
            this.addCriterion("sort like", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortNotLike(String value) {
            this.addCriterion("sort not like", value, "sort");
            return (GoatOneItemExample.Criteria)this;
        }        public GoatOneItemExample.Criteria andSortIn(List<Integer> values) {
            this.addCriterion("sort in", values, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortNotIn(List<Integer> values) {
            this.addCriterion("sort not in", values, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortBetween(Integer value1, Integer value2) {
            this.addCriterion("sort between", value1, value2, "sort");
            return (GoatOneItemExample.Criteria)this;
        }

        public GoatOneItemExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort not between", value1, value2, "sort");
            return (GoatOneItemExample.Criteria)this;
        }
    }
}
