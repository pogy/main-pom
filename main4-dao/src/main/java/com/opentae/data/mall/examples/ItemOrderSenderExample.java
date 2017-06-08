package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderSenderExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderSenderExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderSenderExample() {
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

    public List<ItemOrderSenderExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderSenderExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderSenderExample.Criteria or() {
        ItemOrderSenderExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderSenderExample.Criteria createCriteria() {
        ItemOrderSenderExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderSenderExample.Criteria createCriteriaInternal() {
        ItemOrderSenderExample.Criteria criteria = new ItemOrderSenderExample.Criteria();
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

    public static class Criteria extends ItemOrderSenderExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderSenderExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderSenderExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderSenderExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderSenderExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderSenderExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderSenderExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderSenderExample.Criteria andTopicIsNull() {
            this.addCriterion("topic is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicIsNotNull() {
            this.addCriterion("topic is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicEqualTo(String value) {
            this.addCriterion("topic =", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicNotEqualTo(String value) {
            this.addCriterion("topic <>", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicGreaterThan(String value) {
            this.addCriterion("topic >", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicGreaterThanOrEqualTo(String value) {
            this.addCriterion("topic >=", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicLessThan(String value) {
            this.addCriterion("topic <", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicLessThanOrEqualTo(String value) {
            this.addCriterion("topic <=", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicLike(String value) {
            this.addCriterion("topic like", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicNotLike(String value) {
            this.addCriterion("topic not like", value, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andTopicIn(List<String> values) {
            this.addCriterion("topic in", values, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicNotIn(List<String> values) {
            this.addCriterion("topic not in", values, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicBetween(String value1, String value2) {
            this.addCriterion("topic between", value1, value2, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTopicNotBetween(String value1, String value2) {
            this.addCriterion("topic not between", value1, value2, "topic");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameIsNull() {
            this.addCriterion("senderName is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameIsNotNull() {
            this.addCriterion("senderName is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameEqualTo(String value) {
            this.addCriterion("senderName =", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotEqualTo(String value) {
            this.addCriterion("senderName <>", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameGreaterThan(String value) {
            this.addCriterion("senderName >", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("senderName >=", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameLessThan(String value) {
            this.addCriterion("senderName <", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameLessThanOrEqualTo(String value) {
            this.addCriterion("senderName <=", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameLike(String value) {
            this.addCriterion("senderName like", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotLike(String value) {
            this.addCriterion("senderName not like", value, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andSenderNameIn(List<String> values) {
            this.addCriterion("senderName in", values, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotIn(List<String> values) {
            this.addCriterion("senderName not in", values, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameBetween(String value1, String value2) {
            this.addCriterion("senderName between", value1, value2, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotBetween(String value1, String value2) {
            this.addCriterion("senderName not between", value1, value2, "sender_name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdIsNull() {
            this.addCriterion("senderId is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdIsNotNull() {
            this.addCriterion("senderId is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("senderId =", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("senderId <>", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("senderId >", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("senderId >=", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("senderId <", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("senderId <=", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdLike(String value) {
            this.addCriterion("senderId like", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotLike(String value) {
            this.addCriterion("senderId not like", value, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("senderId in", values, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("senderId not in", values, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("senderId between", value1, value2, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("senderId not between", value1, value2, "sender_id");
            return (ItemOrderSenderExample.Criteria)this;
        }
    }
}
