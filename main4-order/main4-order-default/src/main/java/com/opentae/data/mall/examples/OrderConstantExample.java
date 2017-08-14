package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderConstantExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public OrderConstantExample() {
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

        public Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (Criteria)this;
        }

        public Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (Criteria)this;
        }

        public Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (Criteria)this;
        }        public Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (Criteria)this;
        }

        public Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (Criteria)this;
        }

        public Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (Criteria)this;
        }        public Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (Criteria)this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (Criteria)this;
        }

        public Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (Criteria)this;
        }

        public Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (Criteria)this;
        }

        public Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (Criteria)this;
        }        public Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (Criteria)this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (Criteria)this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (Criteria)this;
        }        public Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andSenderIdIsNull() {
            this.addCriterion("sender_id is null");
            return (Criteria)this;
        }

        public Criteria andSenderIdIsNotNull() {
            this.addCriterion("sender_id is not null");
            return (Criteria)this;
        }

        public Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("sender_id =", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("sender_id <>", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("sender_id >", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sender_id >=", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("sender_id <", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sender_id <=", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdLike(String value) {
            this.addCriterion("sender_id like", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotLike(String value) {
            this.addCriterion("sender_id not like", value, "senderId");
            return (Criteria)this;
        }        public Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("sender_id in", values, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("sender_id not in", values, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("sender_id between", value1, value2, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sender_id not between", value1, value2, "senderId");
            return (Criteria)this;
        }
    }
}
