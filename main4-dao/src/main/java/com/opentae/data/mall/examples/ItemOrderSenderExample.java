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

        public ItemOrderSenderExample.Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (ItemOrderSenderExample.Criteria)this;
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
            this.addCriterion("sender_name is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameIsNotNull() {
            this.addCriterion("sender_name is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameEqualTo(String value) {
            this.addCriterion("sender_name =", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotEqualTo(String value) {
            this.addCriterion("sender_name <>", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameGreaterThan(String value) {
            this.addCriterion("sender_name >", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("sender_name >=", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameLessThan(String value) {
            this.addCriterion("sender_name <", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameLessThanOrEqualTo(String value) {
            this.addCriterion("sender_name <=", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameLike(String value) {
            this.addCriterion("sender_name like", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotLike(String value) {
            this.addCriterion("sender_name not like", value, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andSenderNameIn(List<String> values) {
            this.addCriterion("sender_name in", values, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotIn(List<String> values) {
            this.addCriterion("sender_name not in", values, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameBetween(String value1, String value2) {
            this.addCriterion("sender_name between", value1, value2, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotBetween(String value1, String value2) {
            this.addCriterion("sender_name not between", value1, value2, "senderName");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
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
            this.addCriterion("sender_id is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdIsNotNull() {
            this.addCriterion("sender_id is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("sender_id =", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("sender_id <>", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("sender_id >", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sender_id >=", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("sender_id <", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sender_id <=", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdLike(String value) {
            this.addCriterion("sender_id like", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotLike(String value) {
            this.addCriterion("sender_id not like", value, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("sender_id in", values, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("sender_id not in", values, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("sender_id between", value1, value2, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sender_id not between", value1, value2, "senderId");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }        public ItemOrderSenderExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ItemOrderSenderExample.Criteria)this;
        }
    }
}
