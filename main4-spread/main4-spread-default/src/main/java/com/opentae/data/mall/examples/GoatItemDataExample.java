package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatItemDataExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatItemDataExample.Criteria> oredCriteria = new ArrayList();

    public GoatItemDataExample() {
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

    public List<GoatItemDataExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatItemDataExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatItemDataExample.Criteria or() {
        GoatItemDataExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatItemDataExample.Criteria createCriteria() {
        GoatItemDataExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatItemDataExample.Criteria createCriteriaInternal() {
        GoatItemDataExample.Criteria criteria = new GoatItemDataExample.Criteria();
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

    public static class Criteria extends GoatItemDataExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatItemDataExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatItemDataExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatItemDataExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatItemDataExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatItemDataExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatItemDataExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatItemDataExample.Criteria andDataIdIsNull() {
            this.addCriterion("data_id is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdIsNotNull() {
            this.addCriterion("data_id is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdEqualTo(Long value) {
            this.addCriterion("data_id =", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdNotEqualTo(Long value) {
            this.addCriterion("data_id <>", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdGreaterThan(Long value) {
            this.addCriterion("data_id >", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("data_id >=", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdLessThan(Long value) {
            this.addCriterion("data_id <", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdLessThanOrEqualTo(Long value) {
            this.addCriterion("data_id <=", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdLike(String value) {
            this.addCriterion("data_id like", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdNotLike(String value) {
            this.addCriterion("data_id not like", value, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andDataIdIn(List<Long> values) {
            this.addCriterion("data_id in", values, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdNotIn(List<Long> values) {
            this.addCriterion("data_id not in", values, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdBetween(Long value1, Long value2) {
            this.addCriterion("data_id between", value1, value2, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andDataIdNotBetween(Long value1, Long value2) {
            this.addCriterion("data_id not between", value1, value2, "dataId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdIsNull() {
            this.addCriterion("goat_id is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdIsNotNull() {
            this.addCriterion("goat_id is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdEqualTo(Long value) {
            this.addCriterion("goat_id =", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdNotEqualTo(Long value) {
            this.addCriterion("goat_id <>", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdGreaterThan(Long value) {
            this.addCriterion("goat_id >", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goat_id >=", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdLessThan(Long value) {
            this.addCriterion("goat_id <", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goat_id <=", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdLike(String value) {
            this.addCriterion("goat_id like", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdNotLike(String value) {
            this.addCriterion("goat_id not like", value, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andGoatIdIn(List<Long> values) {
            this.addCriterion("goat_id in", values, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdNotIn(List<Long> values) {
            this.addCriterion("goat_id not in", values, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            this.addCriterion("goat_id between", value1, value2, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goat_id not between", value1, value2, "goatId");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeIsNull() {
            this.addCriterion("to_time is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeIsNotNull() {
            this.addCriterion("to_time is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeEqualTo(Date value) {
            this.addCriterion("to_time =", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeNotEqualTo(Date value) {
            this.addCriterion("to_time <>", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeGreaterThan(Date value) {
            this.addCriterion("to_time >", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("to_time >=", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeLessThan(Date value) {
            this.addCriterion("to_time <", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("to_time <=", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeLike(String value) {
            this.addCriterion("to_time like", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeNotLike(String value) {
            this.addCriterion("to_time not like", value, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andToTimeIn(List<Date> values) {
            this.addCriterion("to_time in", values, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeNotIn(List<Date> values) {
            this.addCriterion("to_time not in", values, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeBetween(Date value1, Date value2) {
            this.addCriterion("to_time between", value1, value2, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andToTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("to_time not between", value1, value2, "toTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeIsNull() {
            this.addCriterion("from_time is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeIsNotNull() {
            this.addCriterion("from_time is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeEqualTo(Date value) {
            this.addCriterion("from_time =", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeNotEqualTo(Date value) {
            this.addCriterion("from_time <>", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeGreaterThan(Date value) {
            this.addCriterion("from_time >", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("from_time >=", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeLessThan(Date value) {
            this.addCriterion("from_time <", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("from_time <=", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeLike(String value) {
            this.addCriterion("from_time like", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeNotLike(String value) {
            this.addCriterion("from_time not like", value, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andFromTimeIn(List<Date> values) {
            this.addCriterion("from_time in", values, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeNotIn(List<Date> values) {
            this.addCriterion("from_time not in", values, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeBetween(Date value1, Date value2) {
            this.addCriterion("from_time between", value1, value2, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andFromTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("from_time not between", value1, value2, "fromTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeIsNull() {
            this.addCriterion("last_publish_time is null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeIsNotNull() {
            this.addCriterion("last_publish_time is not null");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeEqualTo(Date value) {
            this.addCriterion("last_publish_time =", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeNotEqualTo(Date value) {
            this.addCriterion("last_publish_time <>", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeGreaterThan(Date value) {
            this.addCriterion("last_publish_time >", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_publish_time >=", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeLessThan(Date value) {
            this.addCriterion("last_publish_time <", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_publish_time <=", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeLike(String value) {
            this.addCriterion("last_publish_time like", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeNotLike(String value) {
            this.addCriterion("last_publish_time not like", value, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }        public GoatItemDataExample.Criteria andLastPublishTimeIn(List<Date> values) {
            this.addCriterion("last_publish_time in", values, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeNotIn(List<Date> values) {
            this.addCriterion("last_publish_time not in", values, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_publish_time between", value1, value2, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }

        public GoatItemDataExample.Criteria andLastPublishTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_publish_time not between", value1, value2, "lastPublishTime");
            return (GoatItemDataExample.Criteria)this;
        }
    }
}
