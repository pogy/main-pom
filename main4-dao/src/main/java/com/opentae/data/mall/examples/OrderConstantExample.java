package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderConstantExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderConstantExample.Criteria> oredCriteria = new ArrayList();

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

    public List<OrderConstantExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderConstantExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderConstantExample.Criteria or() {
        OrderConstantExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderConstantExample.Criteria createCriteria() {
        OrderConstantExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderConstantExample.Criteria createCriteriaInternal() {
        OrderConstantExample.Criteria criteria = new OrderConstantExample.Criteria();
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

    public static class Criteria extends OrderConstantExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderConstantExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderConstantExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderConstantExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderConstantExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderConstantExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderConstantExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderConstantExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (OrderConstantExample.Criteria)this;
        }        public OrderConstantExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (OrderConstantExample.Criteria)this;
        }        public OrderConstantExample.Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (OrderConstantExample.Criteria)this;
        }        public OrderConstantExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (OrderConstantExample.Criteria)this;
        }        public OrderConstantExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdIsNull() {
            this.addCriterion("senderId is null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdIsNotNull() {
            this.addCriterion("senderId is not null");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("senderId =", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("senderId <>", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("senderId >", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("senderId >=", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("senderId <", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("senderId <=", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdLike(String value) {
            this.addCriterion("senderId like", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdNotLike(String value) {
            this.addCriterion("senderId not like", value, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }        public OrderConstantExample.Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("senderId in", values, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("senderId not in", values, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("senderId between", value1, value2, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }

        public OrderConstantExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("senderId not between", value1, value2, "sender_id");
            return (OrderConstantExample.Criteria)this;
        }
    }
}
