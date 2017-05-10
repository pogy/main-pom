package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SpreadActivityExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SpreadActivityExample.Criteria> oredCriteria = new ArrayList();

    public SpreadActivityExample() {
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

    public List<SpreadActivityExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SpreadActivityExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SpreadActivityExample.Criteria or() {
        SpreadActivityExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SpreadActivityExample.Criteria createCriteria() {
        SpreadActivityExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SpreadActivityExample.Criteria createCriteriaInternal() {
        SpreadActivityExample.Criteria criteria = new SpreadActivityExample.Criteria();
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

    public static class Criteria extends SpreadActivityExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SpreadActivityExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SpreadActivityExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SpreadActivityExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SpreadActivityExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SpreadActivityExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SpreadActivityExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SpreadActivityExample.Criteria andActivityIdIsNull() {
            this.addCriterion("activity_id is null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdIsNotNull() {
            this.addCriterion("activity_id is not null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdEqualTo(Long value) {
            this.addCriterion("activity_id =", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdNotEqualTo(Long value) {
            this.addCriterion("activity_id <>", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdGreaterThan(Long value) {
            this.addCriterion("activity_id >", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("activity_id >=", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdLessThan(Long value) {
            this.addCriterion("activity_id <", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("activity_id <=", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdLike(String value) {
            this.addCriterion("activity_id like", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdNotLike(String value) {
            this.addCriterion("activity_id not like", value, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }        public SpreadActivityExample.Criteria andActivityIdIn(List<Long> values) {
            this.addCriterion("activity_id in", values, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdNotIn(List<Long> values) {
            this.addCriterion("activity_id not in", values, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            this.addCriterion("activity_id between", value1, value2, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("activity_id not between", value1, value2, "activityId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdIsNull() {
            this.addCriterion("term_id is null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdIsNotNull() {
            this.addCriterion("term_id is not null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdEqualTo(Long value) {
            this.addCriterion("term_id =", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdNotEqualTo(Long value) {
            this.addCriterion("term_id <>", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdGreaterThan(Long value) {
            this.addCriterion("term_id >", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("term_id >=", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdLessThan(Long value) {
            this.addCriterion("term_id <", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdLessThanOrEqualTo(Long value) {
            this.addCriterion("term_id <=", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdLike(String value) {
            this.addCriterion("term_id like", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdNotLike(String value) {
            this.addCriterion("term_id not like", value, "termId");
            return (SpreadActivityExample.Criteria)this;
        }        public SpreadActivityExample.Criteria andTermIdIn(List<Long> values) {
            this.addCriterion("term_id in", values, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdNotIn(List<Long> values) {
            this.addCriterion("term_id not in", values, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdBetween(Long value1, Long value2) {
            this.addCriterion("term_id between", value1, value2, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTermIdNotBetween(Long value1, Long value2) {
            this.addCriterion("term_id not between", value1, value2, "termId");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionIsNull() {
            this.addCriterion("description is null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionIsNotNull() {
            this.addCriterion("description is not null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionEqualTo(String value) {
            this.addCriterion("description =", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionNotEqualTo(String value) {
            this.addCriterion("description <>", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionGreaterThan(String value) {
            this.addCriterion("description >", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            this.addCriterion("description >=", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionLessThan(String value) {
            this.addCriterion("description <", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            this.addCriterion("description <=", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionLike(String value) {
            this.addCriterion("description like", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionNotLike(String value) {
            this.addCriterion("description not like", value, "description");
            return (SpreadActivityExample.Criteria)this;
        }        public SpreadActivityExample.Criteria andDescriptionIn(List<String> values) {
            this.addCriterion("description in", values, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionNotIn(List<String> values) {
            this.addCriterion("description not in", values, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionBetween(String value1, String value2) {
            this.addCriterion("description between", value1, value2, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            this.addCriterion("description not between", value1, value2, "description");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortIsNull() {
            this.addCriterion("sort is null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortIsNotNull() {
            this.addCriterion("sort is not null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortEqualTo(Integer value) {
            this.addCriterion("sort =", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortNotEqualTo(Integer value) {
            this.addCriterion("sort <>", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortGreaterThan(Integer value) {
            this.addCriterion("sort >", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort >=", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortLessThan(Integer value) {
            this.addCriterion("sort <", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort <=", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortLike(String value) {
            this.addCriterion("sort like", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortNotLike(String value) {
            this.addCriterion("sort not like", value, "sort");
            return (SpreadActivityExample.Criteria)this;
        }        public SpreadActivityExample.Criteria andSortIn(List<Integer> values) {
            this.addCriterion("sort in", values, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortNotIn(List<Integer> values) {
            this.addCriterion("sort not in", values, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortBetween(Integer value1, Integer value2) {
            this.addCriterion("sort between", value1, value2, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort not between", value1, value2, "sort");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (SpreadActivityExample.Criteria)this;
        }        public SpreadActivityExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (SpreadActivityExample.Criteria)this;
        }        public SpreadActivityExample.Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyIsNull() {
            this.addCriterion("key is null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyIsNotNull() {
            this.addCriterion("key is not null");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyEqualTo(String value) {
            this.addCriterion("key =", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyNotEqualTo(String value) {
            this.addCriterion("key <>", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyGreaterThan(String value) {
            this.addCriterion("key >", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("key >=", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyLessThan(String value) {
            this.addCriterion("key <", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyLessThanOrEqualTo(String value) {
            this.addCriterion("key <=", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyLike(String value) {
            this.addCriterion("key like", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyNotLike(String value) {
            this.addCriterion("key not like", value, "key");
            return (SpreadActivityExample.Criteria)this;
        }        public SpreadActivityExample.Criteria andKeyIn(List<String> values) {
            this.addCriterion("key in", values, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyNotIn(List<String> values) {
            this.addCriterion("key not in", values, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyBetween(String value1, String value2) {
            this.addCriterion("key between", value1, value2, "key");
            return (SpreadActivityExample.Criteria)this;
        }

        public SpreadActivityExample.Criteria andKeyNotBetween(String value1, String value2) {
            this.addCriterion("key not between", value1, value2, "key");
            return (SpreadActivityExample.Criteria)this;
        }
    }
}
