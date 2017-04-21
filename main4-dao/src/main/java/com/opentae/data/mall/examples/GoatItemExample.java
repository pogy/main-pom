package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatItemExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatItemExample.Criteria> oredCriteria = new ArrayList();

    public GoatItemExample() {
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

    public List<GoatItemExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatItemExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatItemExample.Criteria or() {
        GoatItemExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatItemExample.Criteria createCriteria() {
        GoatItemExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatItemExample.Criteria createCriteriaInternal() {
        GoatItemExample.Criteria criteria = new GoatItemExample.Criteria();
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

    public static class Criteria extends GoatItemExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatItemExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatItemExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatItemExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatItemExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatItemExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatItemExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatItemExample.Criteria andGoatIdIsNull() {
            this.addCriterion("goat_id is null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdIsNotNull() {
            this.addCriterion("goat_id is not null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdEqualTo(Long value) {
            this.addCriterion("goat_id =", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdNotEqualTo(Long value) {
            this.addCriterion("goat_id <>", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdGreaterThan(Long value) {
            this.addCriterion("goat_id >", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goat_id >=", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdLessThan(Long value) {
            this.addCriterion("goat_id <", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goat_id <=", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdLike(String value) {
            this.addCriterion("goat_id like", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdNotLike(String value) {
            this.addCriterion("goat_id not like", value, "goatId");
            return (GoatItemExample.Criteria)this;
        }        public GoatItemExample.Criteria andGoatIdIn(List<Long> values) {
            this.addCriterion("goat_id in", values, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdNotIn(List<Long> values) {
            this.addCriterion("goat_id not in", values, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            this.addCriterion("goat_id between", value1, value2, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goat_id not between", value1, value2, "goatId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdIsNull() {
            this.addCriterion("local_id is null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdIsNotNull() {
            this.addCriterion("local_id is not null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdEqualTo(Long value) {
            this.addCriterion("local_id =", value, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdNotEqualTo(Long value) {
            this.addCriterion("local_id <>", value, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdGreaterThan(Long value) {
            this.addCriterion("local_id >", value, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("local_id >=", value, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdLessThan(Long value) {
            this.addCriterion("local_id <", value, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdLessThanOrEqualTo(Long value) {
            this.addCriterion("local_id <=", value, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdLike(String value) {
            this.addCriterion("local_id like", value, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdNotLike(String value) {
            this.addCriterion("local_id not like", value, "localId");
            return (GoatItemExample.Criteria)this;
        }        public GoatItemExample.Criteria andLocalIdIn(List<Long> values) {
            this.addCriterion("local_id in", values, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdNotIn(List<Long> values) {
            this.addCriterion("local_id not in", values, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdBetween(Long value1, Long value2) {
            this.addCriterion("local_id between", value1, value2, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andLocalIdNotBetween(Long value1, Long value2) {
            this.addCriterion("local_id not between", value1, value2, "localId");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeIsNull() {
            this.addCriterion("start_time is null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeIsNotNull() {
            this.addCriterion("start_time is not null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeEqualTo(Date value) {
            this.addCriterion("start_time =", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeNotEqualTo(Date value) {
            this.addCriterion("start_time <>", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeGreaterThan(Date value) {
            this.addCriterion("start_time >", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("start_time >=", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeLessThan(Date value) {
            this.addCriterion("start_time <", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("start_time <=", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeLike(String value) {
            this.addCriterion("start_time like", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeNotLike(String value) {
            this.addCriterion("start_time not like", value, "startTime");
            return (GoatItemExample.Criteria)this;
        }        public GoatItemExample.Criteria andStartTimeIn(List<Date> values) {
            this.addCriterion("start_time in", values, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeNotIn(List<Date> values) {
            this.addCriterion("start_time not in", values, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            this.addCriterion("start_time between", value1, value2, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("start_time not between", value1, value2, "startTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeIsNull() {
            this.addCriterion("end_time is null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeIsNotNull() {
            this.addCriterion("end_time is not null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeEqualTo(Date value) {
            this.addCriterion("end_time =", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeNotEqualTo(Date value) {
            this.addCriterion("end_time <>", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeGreaterThan(Date value) {
            this.addCriterion("end_time >", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("end_time >=", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeLessThan(Date value) {
            this.addCriterion("end_time <", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("end_time <=", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeLike(String value) {
            this.addCriterion("end_time like", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeNotLike(String value) {
            this.addCriterion("end_time not like", value, "endTime");
            return (GoatItemExample.Criteria)this;
        }        public GoatItemExample.Criteria andEndTimeIn(List<Date> values) {
            this.addCriterion("end_time in", values, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeNotIn(List<Date> values) {
            this.addCriterion("end_time not in", values, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            this.addCriterion("end_time between", value1, value2, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("end_time not between", value1, value2, "endTime");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledIsNull() {
            this.addCriterion("dis_enabled is null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledIsNotNull() {
            this.addCriterion("dis_enabled is not null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledEqualTo(Boolean value) {
            this.addCriterion("dis_enabled =", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledNotEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <>", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledGreaterThan(Boolean value) {
            this.addCriterion("dis_enabled >", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled >=", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledLessThan(Boolean value) {
            this.addCriterion("dis_enabled <", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <=", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledLike(String value) {
            this.addCriterion("dis_enabled like", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledNotLike(String value) {
            this.addCriterion("dis_enabled not like", value, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }        public GoatItemExample.Criteria andDisEnabledIn(List<Boolean> values) {
            this.addCriterion("dis_enabled in", values, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledNotIn(List<Boolean> values) {
            this.addCriterion("dis_enabled not in", values, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled between", value1, value2, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andDisEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled not between", value1, value2, "disEnabled");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortIsNull() {
            this.addCriterion("sort is null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortIsNotNull() {
            this.addCriterion("sort is not null");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortEqualTo(Integer value) {
            this.addCriterion("sort =", value, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortNotEqualTo(Integer value) {
            this.addCriterion("sort <>", value, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortGreaterThan(Integer value) {
            this.addCriterion("sort >", value, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort >=", value, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortLessThan(Integer value) {
            this.addCriterion("sort <", value, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort <=", value, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortLike(String value) {
            this.addCriterion("sort like", value, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortNotLike(String value) {
            this.addCriterion("sort not like", value, "sort");
            return (GoatItemExample.Criteria)this;
        }        public GoatItemExample.Criteria andSortIn(List<Integer> values) {
            this.addCriterion("sort in", values, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortNotIn(List<Integer> values) {
            this.addCriterion("sort not in", values, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortBetween(Integer value1, Integer value2) {
            this.addCriterion("sort between", value1, value2, "sort");
            return (GoatItemExample.Criteria)this;
        }

        public GoatItemExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort not between", value1, value2, "sort");
            return (GoatItemExample.Criteria)this;
        }
    }
}
