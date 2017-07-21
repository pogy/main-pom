package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderRefundExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderRefundExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderRefundExample() {
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

    public List<ItemOrderRefundExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderRefundExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderRefundExample.Criteria or() {
        ItemOrderRefundExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderRefundExample.Criteria createCriteria() {
        ItemOrderRefundExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderRefundExample.Criteria createCriteriaInternal() {
        ItemOrderRefundExample.Criteria criteria = new ItemOrderRefundExample.Criteria();
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

    public static class Criteria extends ItemOrderRefundExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderRefundExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderRefundExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderRefundExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderRefundExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderRefundExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderRefundExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderRefundExample.Criteria andRefundIdIsNull() {
            this.addCriterion("refund_id is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdIsNotNull() {
            this.addCriterion("refund_id is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdEqualTo(Long value) {
            this.addCriterion("refund_id =", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdNotEqualTo(Long value) {
            this.addCriterion("refund_id <>", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdGreaterThan(Long value) {
            this.addCriterion("refund_id >", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_id >=", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdLessThan(Long value) {
            this.addCriterion("refund_id <", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_id <=", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdLike(String value) {
            this.addCriterion("refund_id like", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdNotLike(String value) {
            this.addCriterion("refund_id not like", value, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andRefundIdIn(List<Long> values) {
            this.addCriterion("refund_id in", values, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdNotIn(List<Long> values) {
            this.addCriterion("refund_id not in", values, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            this.addCriterion("refund_id between", value1, value2, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_id not between", value1, value2, "refundId");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyIsNull() {
            this.addCriterion("hope_money is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyIsNotNull() {
            this.addCriterion("hope_money is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyEqualTo(Long value) {
            this.addCriterion("hope_money =", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyNotEqualTo(Long value) {
            this.addCriterion("hope_money <>", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyGreaterThan(Long value) {
            this.addCriterion("hope_money >", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("hope_money >=", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyLessThan(Long value) {
            this.addCriterion("hope_money <", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("hope_money <=", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyLike(String value) {
            this.addCriterion("hope_money like", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyNotLike(String value) {
            this.addCriterion("hope_money not like", value, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andHopeMoneyIn(List<Long> values) {
            this.addCriterion("hope_money in", values, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyNotIn(List<Long> values) {
            this.addCriterion("hope_money not in", values, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyBetween(Long value1, Long value2) {
            this.addCriterion("hope_money between", value1, value2, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("hope_money not between", value1, value2, "hopeMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonIsNull() {
            this.addCriterion("reason is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonIsNotNull() {
            this.addCriterion("reason is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonEqualTo(String value) {
            this.addCriterion("reason =", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonNotEqualTo(String value) {
            this.addCriterion("reason <>", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonGreaterThan(String value) {
            this.addCriterion("reason >", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("reason >=", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonLessThan(String value) {
            this.addCriterion("reason <", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonLessThanOrEqualTo(String value) {
            this.addCriterion("reason <=", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonLike(String value) {
            this.addCriterion("reason like", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonNotLike(String value) {
            this.addCriterion("reason not like", value, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andReasonIn(List<String> values) {
            this.addCriterion("reason in", values, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonNotIn(List<String> values) {
            this.addCriterion("reason not in", values, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonBetween(String value1, String value2) {
            this.addCriterion("reason between", value1, value2, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andReasonNotBetween(String value1, String value2) {
            this.addCriterion("reason not between", value1, value2, "reason");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyIsNull() {
            this.addCriterion("user_apply is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyIsNotNull() {
            this.addCriterion("user_apply is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyEqualTo(Boolean value) {
            this.addCriterion("user_apply =", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyNotEqualTo(Boolean value) {
            this.addCriterion("user_apply <>", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyGreaterThan(Boolean value) {
            this.addCriterion("user_apply >", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("user_apply >=", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyLessThan(Boolean value) {
            this.addCriterion("user_apply <", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyLessThanOrEqualTo(Boolean value) {
            this.addCriterion("user_apply <=", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyLike(String value) {
            this.addCriterion("user_apply like", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyNotLike(String value) {
            this.addCriterion("user_apply not like", value, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andUserApplyIn(List<Boolean> values) {
            this.addCriterion("user_apply in", values, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyNotIn(List<Boolean> values) {
            this.addCriterion("user_apply not in", values, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyBetween(Boolean value1, Boolean value2) {
            this.addCriterion("user_apply between", value1, value2, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andUserApplyNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("user_apply not between", value1, value2, "userApply");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidIsNull() {
            this.addCriterion("soid is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidIsNotNull() {
            this.addCriterion("soid is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidEqualTo(Long value) {
            this.addCriterion("soid =", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidNotEqualTo(Long value) {
            this.addCriterion("soid <>", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidGreaterThan(Long value) {
            this.addCriterion("soid >", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("soid >=", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidLessThan(Long value) {
            this.addCriterion("soid <", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidLessThanOrEqualTo(Long value) {
            this.addCriterion("soid <=", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidLike(String value) {
            this.addCriterion("soid like", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidNotLike(String value) {
            this.addCriterion("soid not like", value, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andSoidIn(List<Long> values) {
            this.addCriterion("soid in", values, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidNotIn(List<Long> values) {
            this.addCriterion("soid not in", values, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidBetween(Long value1, Long value2) {
            this.addCriterion("soid between", value1, value2, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSoidNotBetween(Long value1, Long value2) {
            this.addCriterion("soid not between", value1, value2, "soid");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierIsNull() {
            this.addCriterion("buyer_courier is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierIsNotNull() {
            this.addCriterion("buyer_courier is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierEqualTo(String value) {
            this.addCriterion("buyer_courier =", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotEqualTo(String value) {
            this.addCriterion("buyer_courier <>", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierGreaterThan(String value) {
            this.addCriterion("buyer_courier >", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierGreaterThanOrEqualTo(String value) {
            this.addCriterion("buyer_courier >=", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierLessThan(String value) {
            this.addCriterion("buyer_courier <", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierLessThanOrEqualTo(String value) {
            this.addCriterion("buyer_courier <=", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierLike(String value) {
            this.addCriterion("buyer_courier like", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotLike(String value) {
            this.addCriterion("buyer_courier not like", value, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andBuyerCourierIn(List<String> values) {
            this.addCriterion("buyer_courier in", values, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotIn(List<String> values) {
            this.addCriterion("buyer_courier not in", values, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierBetween(String value1, String value2) {
            this.addCriterion("buyer_courier between", value1, value2, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotBetween(String value1, String value2) {
            this.addCriterion("buyer_courier not between", value1, value2, "buyerCourier");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyIsNull() {
            this.addCriterion("seller_proposal_money is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyIsNotNull() {
            this.addCriterion("seller_proposal_money is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyEqualTo(Long value) {
            this.addCriterion("seller_proposal_money =", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyNotEqualTo(Long value) {
            this.addCriterion("seller_proposal_money <>", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyGreaterThan(Long value) {
            this.addCriterion("seller_proposal_money >", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_proposal_money >=", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyLessThan(Long value) {
            this.addCriterion("seller_proposal_money <", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_proposal_money <=", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyLike(String value) {
            this.addCriterion("seller_proposal_money like", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyNotLike(String value) {
            this.addCriterion("seller_proposal_money not like", value, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andSellerProposalMoneyIn(List<Long> values) {
            this.addCriterion("seller_proposal_money in", values, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyNotIn(List<Long> values) {
            this.addCriterion("seller_proposal_money not in", values, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyBetween(Long value1, Long value2) {
            this.addCriterion("seller_proposal_money between", value1, value2, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_proposal_money not between", value1, value2, "sellerProposalMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberIsNull() {
            this.addCriterion("number is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberIsNotNull() {
            this.addCriterion("number is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberEqualTo(Integer value) {
            this.addCriterion("number =", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberNotEqualTo(Integer value) {
            this.addCriterion("number <>", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberGreaterThan(Integer value) {
            this.addCriterion("number >", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("number >=", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberLessThan(Integer value) {
            this.addCriterion("number <", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberLessThanOrEqualTo(Integer value) {
            this.addCriterion("number <=", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberLike(String value) {
            this.addCriterion("number like", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberNotLike(String value) {
            this.addCriterion("number not like", value, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andNumberIn(List<Integer> values) {
            this.addCriterion("number in", values, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberNotIn(List<Integer> values) {
            this.addCriterion("number not in", values, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberBetween(Integer value1, Integer value2) {
            this.addCriterion("number between", value1, value2, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andNumberNotBetween(Integer value1, Integer value2) {
            this.addCriterion("number not between", value1, value2, "number");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyIsNull() {
            this.addCriterion("refund_money is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyIsNotNull() {
            this.addCriterion("refund_money is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyEqualTo(Long value) {
            this.addCriterion("refund_money =", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            this.addCriterion("refund_money <>", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyGreaterThan(Long value) {
            this.addCriterion("refund_money >", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_money >=", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyLessThan(Long value) {
            this.addCriterion("refund_money <", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_money <=", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyLike(String value) {
            this.addCriterion("refund_money like", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyNotLike(String value) {
            this.addCriterion("refund_money not like", value, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andRefundMoneyIn(List<Long> values) {
            this.addCriterion("refund_money in", values, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            this.addCriterion("refund_money not in", values, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            this.addCriterion("refund_money between", value1, value2, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_money not between", value1, value2, "refundMoney");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgIsNull() {
            this.addCriterion("fail_msg is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgIsNotNull() {
            this.addCriterion("fail_msg is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgEqualTo(String value) {
            this.addCriterion("fail_msg =", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotEqualTo(String value) {
            this.addCriterion("fail_msg <>", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgGreaterThan(String value) {
            this.addCriterion("fail_msg >", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgGreaterThanOrEqualTo(String value) {
            this.addCriterion("fail_msg >=", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgLessThan(String value) {
            this.addCriterion("fail_msg <", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgLessThanOrEqualTo(String value) {
            this.addCriterion("fail_msg <=", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgLike(String value) {
            this.addCriterion("fail_msg like", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotLike(String value) {
            this.addCriterion("fail_msg not like", value, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andFailMsgIn(List<String> values) {
            this.addCriterion("fail_msg in", values, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotIn(List<String> values) {
            this.addCriterion("fail_msg not in", values, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgBetween(String value1, String value2) {
            this.addCriterion("fail_msg between", value1, value2, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotBetween(String value1, String value2) {
            this.addCriterion("fail_msg not between", value1, value2, "failMsg");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }        public ItemOrderRefundExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }

        public ItemOrderRefundExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ItemOrderRefundExample.Criteria)this;
        }
    }
}
