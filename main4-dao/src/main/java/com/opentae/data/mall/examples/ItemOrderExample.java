package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderExample() {
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

    public List<ItemOrderExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderExample.Criteria or() {
        ItemOrderExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderExample.Criteria createCriteria() {
        ItemOrderExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderExample.Criteria createCriteriaInternal() {
        ItemOrderExample.Criteria criteria = new ItemOrderExample.Criteria();
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

    public static class Criteria extends ItemOrderExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeIsNull() {
            this.addCriterion("total_fee is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeIsNotNull() {
            this.addCriterion("total_fee is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeEqualTo(Long value) {
            this.addCriterion("total_fee =", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotEqualTo(Long value) {
            this.addCriterion("total_fee <>", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeGreaterThan(Long value) {
            this.addCriterion("total_fee >", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("total_fee >=", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeLessThan(Long value) {
            this.addCriterion("total_fee <", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("total_fee <=", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeLike(String value) {
            this.addCriterion("total_fee like", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotLike(String value) {
            this.addCriterion("total_fee not like", value, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andTotalFeeIn(List<Long> values) {
            this.addCriterion("total_fee in", values, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotIn(List<Long> values) {
            this.addCriterion("total_fee not in", values, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeBetween(Long value1, Long value2) {
            this.addCriterion("total_fee between", value1, value2, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("total_fee not between", value1, value2, "totalFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeIsNull() {
            this.addCriterion("payed_fee is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeIsNotNull() {
            this.addCriterion("payed_fee is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeEqualTo(Long value) {
            this.addCriterion("payed_fee =", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotEqualTo(Long value) {
            this.addCriterion("payed_fee <>", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeGreaterThan(Long value) {
            this.addCriterion("payed_fee >", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("payed_fee >=", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeLessThan(Long value) {
            this.addCriterion("payed_fee <", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("payed_fee <=", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeLike(String value) {
            this.addCriterion("payed_fee like", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotLike(String value) {
            this.addCriterion("payed_fee not like", value, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andPayedFeeIn(List<Long> values) {
            this.addCriterion("payed_fee in", values, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotIn(List<Long> values) {
            this.addCriterion("payed_fee not in", values, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeBetween(Long value1, Long value2) {
            this.addCriterion("payed_fee between", value1, value2, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("payed_fee not between", value1, value2, "payedFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeIsNull() {
            this.addCriterion("refund_fee is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeIsNotNull() {
            this.addCriterion("refund_fee is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeEqualTo(Long value) {
            this.addCriterion("refund_fee =", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotEqualTo(Long value) {
            this.addCriterion("refund_fee <>", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeGreaterThan(Long value) {
            this.addCriterion("refund_fee >", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_fee >=", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeLessThan(Long value) {
            this.addCriterion("refund_fee <", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_fee <=", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeLike(String value) {
            this.addCriterion("refund_fee like", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotLike(String value) {
            this.addCriterion("refund_fee not like", value, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andRefundFeeIn(List<Long> values) {
            this.addCriterion("refund_fee in", values, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotIn(List<Long> values) {
            this.addCriterion("refund_fee not in", values, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeBetween(Long value1, Long value2) {
            this.addCriterion("refund_fee between", value1, value2, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_fee not between", value1, value2, "refundFee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdIsNull() {
            this.addCriterion("sender_id is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdIsNotNull() {
            this.addCriterion("sender_id is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("sender_id =", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("sender_id <>", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("sender_id >", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sender_id >=", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("sender_id <", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sender_id <=", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdLike(String value) {
            this.addCriterion("sender_id like", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotLike(String value) {
            this.addCriterion("sender_id not like", value, "senderId");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("sender_id in", values, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("sender_id not in", values, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("sender_id between", value1, value2, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sender_id not between", value1, value2, "senderId");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusIsNull() {
            this.addCriterion("order_status is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusIsNotNull() {
            this.addCriterion("order_status is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusEqualTo(Integer value) {
            this.addCriterion("order_status =", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotEqualTo(Integer value) {
            this.addCriterion("order_status <>", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusGreaterThan(Integer value) {
            this.addCriterion("order_status >", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("order_status >=", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusLessThan(Integer value) {
            this.addCriterion("order_status <", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("order_status <=", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusLike(String value) {
            this.addCriterion("order_status like", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotLike(String value) {
            this.addCriterion("order_status not like", value, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andOrderStatusIn(List<Integer> values) {
            this.addCriterion("order_status in", values, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotIn(List<Integer> values) {
            this.addCriterion("order_status not in", values, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("order_status between", value1, value2, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("order_status not between", value1, value2, "orderStatus");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkIsNull() {
            this.addCriterion("mark is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkIsNotNull() {
            this.addCriterion("mark is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkEqualTo(String value) {
            this.addCriterion("mark =", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkNotEqualTo(String value) {
            this.addCriterion("mark <>", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkGreaterThan(String value) {
            this.addCriterion("mark >", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("mark >=", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkLessThan(String value) {
            this.addCriterion("mark <", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkLessThanOrEqualTo(String value) {
            this.addCriterion("mark <=", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkLike(String value) {
            this.addCriterion("mark like", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkNotLike(String value) {
            this.addCriterion("mark not like", value, "mark");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andMarkIn(List<String> values) {
            this.addCriterion("mark in", values, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkNotIn(List<String> values) {
            this.addCriterion("mark not in", values, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkBetween(String value1, String value2) {
            this.addCriterion("mark between", value1, value2, "mark");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andMarkNotBetween(String value1, String value2) {
            this.addCriterion("mark not between", value1, value2, "mark");
            return (ItemOrderExample.Criteria)this;
        }
    }
}
