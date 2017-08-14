package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderRefundExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andReasonIsNull() {
            this.addCriterion("reason is null");
            return (Criteria)this;
        }

        public Criteria andReasonIsNotNull() {
            this.addCriterion("reason is not null");
            return (Criteria)this;
        }

        public Criteria andReasonEqualTo(String value) {
            this.addCriterion("reason =", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            this.addCriterion("reason <>", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonGreaterThan(String value) {
            this.addCriterion("reason >", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("reason >=", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonLessThan(String value) {
            this.addCriterion("reason <", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            this.addCriterion("reason <=", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonLike(String value) {
            this.addCriterion("reason like", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotLike(String value) {
            this.addCriterion("reason not like", value, "reason");
            return (Criteria)this;
        }        public Criteria andReasonIn(List<String> values) {
            this.addCriterion("reason in", values, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            this.addCriterion("reason not in", values, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            this.addCriterion("reason between", value1, value2, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            this.addCriterion("reason not between", value1, value2, "reason");
            return (Criteria)this;
        }

        public Criteria andSoidIsNull() {
            this.addCriterion("soid is null");
            return (Criteria)this;
        }

        public Criteria andSoidIsNotNull() {
            this.addCriterion("soid is not null");
            return (Criteria)this;
        }

        public Criteria andSoidEqualTo(Long value) {
            this.addCriterion("soid =", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotEqualTo(Long value) {
            this.addCriterion("soid <>", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidGreaterThan(Long value) {
            this.addCriterion("soid >", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("soid >=", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidLessThan(Long value) {
            this.addCriterion("soid <", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidLessThanOrEqualTo(Long value) {
            this.addCriterion("soid <=", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidLike(String value) {
            this.addCriterion("soid like", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotLike(String value) {
            this.addCriterion("soid not like", value, "soid");
            return (Criteria)this;
        }        public Criteria andSoidIn(List<Long> values) {
            this.addCriterion("soid in", values, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotIn(List<Long> values) {
            this.addCriterion("soid not in", values, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidBetween(Long value1, Long value2) {
            this.addCriterion("soid between", value1, value2, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotBetween(Long value1, Long value2) {
            this.addCriterion("soid not between", value1, value2, "soid");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyIsNull() {
            this.addCriterion("seller_proposal_money is null");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyIsNotNull() {
            this.addCriterion("seller_proposal_money is not null");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyEqualTo(Long value) {
            this.addCriterion("seller_proposal_money =", value, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyNotEqualTo(Long value) {
            this.addCriterion("seller_proposal_money <>", value, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyGreaterThan(Long value) {
            this.addCriterion("seller_proposal_money >", value, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_proposal_money >=", value, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyLessThan(Long value) {
            this.addCriterion("seller_proposal_money <", value, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_proposal_money <=", value, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyLike(String value) {
            this.addCriterion("seller_proposal_money like", value, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyNotLike(String value) {
            this.addCriterion("seller_proposal_money not like", value, "sellerProposalMoney");
            return (Criteria)this;
        }        public Criteria andSellerProposalMoneyIn(List<Long> values) {
            this.addCriterion("seller_proposal_money in", values, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyNotIn(List<Long> values) {
            this.addCriterion("seller_proposal_money not in", values, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyBetween(Long value1, Long value2) {
            this.addCriterion("seller_proposal_money between", value1, value2, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andSellerProposalMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_proposal_money not between", value1, value2, "sellerProposalMoney");
            return (Criteria)this;
        }

        public Criteria andUserApplyIsNull() {
            this.addCriterion("user_apply is null");
            return (Criteria)this;
        }

        public Criteria andUserApplyIsNotNull() {
            this.addCriterion("user_apply is not null");
            return (Criteria)this;
        }

        public Criteria andUserApplyEqualTo(Boolean value) {
            this.addCriterion("user_apply =", value, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyNotEqualTo(Boolean value) {
            this.addCriterion("user_apply <>", value, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyGreaterThan(Boolean value) {
            this.addCriterion("user_apply >", value, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("user_apply >=", value, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyLessThan(Boolean value) {
            this.addCriterion("user_apply <", value, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyLessThanOrEqualTo(Boolean value) {
            this.addCriterion("user_apply <=", value, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyLike(String value) {
            this.addCriterion("user_apply like", value, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyNotLike(String value) {
            this.addCriterion("user_apply not like", value, "userApply");
            return (Criteria)this;
        }        public Criteria andUserApplyIn(List<Boolean> values) {
            this.addCriterion("user_apply in", values, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyNotIn(List<Boolean> values) {
            this.addCriterion("user_apply not in", values, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyBetween(Boolean value1, Boolean value2) {
            this.addCriterion("user_apply between", value1, value2, "userApply");
            return (Criteria)this;
        }

        public Criteria andUserApplyNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("user_apply not between", value1, value2, "userApply");
            return (Criteria)this;
        }

        public Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (Criteria)this;
        }

        public Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (Criteria)this;
        }

        public Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (Criteria)this;
        }        public Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (Criteria)this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
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

        public Criteria andBuyerCourierIsNull() {
            this.addCriterion("buyer_courier is null");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierIsNotNull() {
            this.addCriterion("buyer_courier is not null");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierEqualTo(String value) {
            this.addCriterion("buyer_courier =", value, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierNotEqualTo(String value) {
            this.addCriterion("buyer_courier <>", value, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierGreaterThan(String value) {
            this.addCriterion("buyer_courier >", value, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierGreaterThanOrEqualTo(String value) {
            this.addCriterion("buyer_courier >=", value, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierLessThan(String value) {
            this.addCriterion("buyer_courier <", value, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierLessThanOrEqualTo(String value) {
            this.addCriterion("buyer_courier <=", value, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierLike(String value) {
            this.addCriterion("buyer_courier like", value, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierNotLike(String value) {
            this.addCriterion("buyer_courier not like", value, "buyerCourier");
            return (Criteria)this;
        }        public Criteria andBuyerCourierIn(List<String> values) {
            this.addCriterion("buyer_courier in", values, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierNotIn(List<String> values) {
            this.addCriterion("buyer_courier not in", values, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierBetween(String value1, String value2) {
            this.addCriterion("buyer_courier between", value1, value2, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andBuyerCourierNotBetween(String value1, String value2) {
            this.addCriterion("buyer_courier not between", value1, value2, "buyerCourier");
            return (Criteria)this;
        }

        public Criteria andRefundIdIsNull() {
            this.addCriterion("refund_id is null");
            return (Criteria)this;
        }

        public Criteria andRefundIdIsNotNull() {
            this.addCriterion("refund_id is not null");
            return (Criteria)this;
        }

        public Criteria andRefundIdEqualTo(Long value) {
            this.addCriterion("refund_id =", value, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdNotEqualTo(Long value) {
            this.addCriterion("refund_id <>", value, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdGreaterThan(Long value) {
            this.addCriterion("refund_id >", value, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_id >=", value, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdLessThan(Long value) {
            this.addCriterion("refund_id <", value, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_id <=", value, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdLike(String value) {
            this.addCriterion("refund_id like", value, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdNotLike(String value) {
            this.addCriterion("refund_id not like", value, "refundId");
            return (Criteria)this;
        }        public Criteria andRefundIdIn(List<Long> values) {
            this.addCriterion("refund_id in", values, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdNotIn(List<Long> values) {
            this.addCriterion("refund_id not in", values, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdBetween(Long value1, Long value2) {
            this.addCriterion("refund_id between", value1, value2, "refundId");
            return (Criteria)this;
        }

        public Criteria andRefundIdNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_id not between", value1, value2, "refundId");
            return (Criteria)this;
        }

        public Criteria andNumberIsNull() {
            this.addCriterion("number is null");
            return (Criteria)this;
        }

        public Criteria andNumberIsNotNull() {
            this.addCriterion("number is not null");
            return (Criteria)this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            this.addCriterion("number =", value, "number");
            return (Criteria)this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            this.addCriterion("number <>", value, "number");
            return (Criteria)this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            this.addCriterion("number >", value, "number");
            return (Criteria)this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("number >=", value, "number");
            return (Criteria)this;
        }

        public Criteria andNumberLessThan(Integer value) {
            this.addCriterion("number <", value, "number");
            return (Criteria)this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            this.addCriterion("number <=", value, "number");
            return (Criteria)this;
        }

        public Criteria andNumberLike(String value) {
            this.addCriterion("number like", value, "number");
            return (Criteria)this;
        }

        public Criteria andNumberNotLike(String value) {
            this.addCriterion("number not like", value, "number");
            return (Criteria)this;
        }        public Criteria andNumberIn(List<Integer> values) {
            this.addCriterion("number in", values, "number");
            return (Criteria)this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            this.addCriterion("number not in", values, "number");
            return (Criteria)this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            this.addCriterion("number between", value1, value2, "number");
            return (Criteria)this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            this.addCriterion("number not between", value1, value2, "number");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyIsNull() {
            this.addCriterion("hope_money is null");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyIsNotNull() {
            this.addCriterion("hope_money is not null");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyEqualTo(Long value) {
            this.addCriterion("hope_money =", value, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyNotEqualTo(Long value) {
            this.addCriterion("hope_money <>", value, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyGreaterThan(Long value) {
            this.addCriterion("hope_money >", value, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("hope_money >=", value, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyLessThan(Long value) {
            this.addCriterion("hope_money <", value, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("hope_money <=", value, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyLike(String value) {
            this.addCriterion("hope_money like", value, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyNotLike(String value) {
            this.addCriterion("hope_money not like", value, "hopeMoney");
            return (Criteria)this;
        }        public Criteria andHopeMoneyIn(List<Long> values) {
            this.addCriterion("hope_money in", values, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyNotIn(List<Long> values) {
            this.addCriterion("hope_money not in", values, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyBetween(Long value1, Long value2) {
            this.addCriterion("hope_money between", value1, value2, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andHopeMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("hope_money not between", value1, value2, "hopeMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyIsNull() {
            this.addCriterion("refund_money is null");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyIsNotNull() {
            this.addCriterion("refund_money is not null");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyEqualTo(Long value) {
            this.addCriterion("refund_money =", value, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyNotEqualTo(Long value) {
            this.addCriterion("refund_money <>", value, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyGreaterThan(Long value) {
            this.addCriterion("refund_money >", value, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_money >=", value, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyLessThan(Long value) {
            this.addCriterion("refund_money <", value, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_money <=", value, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyLike(String value) {
            this.addCriterion("refund_money like", value, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyNotLike(String value) {
            this.addCriterion("refund_money not like", value, "refundMoney");
            return (Criteria)this;
        }        public Criteria andRefundMoneyIn(List<Long> values) {
            this.addCriterion("refund_money in", values, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyNotIn(List<Long> values) {
            this.addCriterion("refund_money not in", values, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyBetween(Long value1, Long value2) {
            this.addCriterion("refund_money between", value1, value2, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_money not between", value1, value2, "refundMoney");
            return (Criteria)this;
        }

        public Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (Criteria)this;
        }

        public Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (Criteria)this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (Criteria)this;
        }        public Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (Criteria)this;
        }

        public Criteria andFailMsgIsNull() {
            this.addCriterion("fail_msg is null");
            return (Criteria)this;
        }

        public Criteria andFailMsgIsNotNull() {
            this.addCriterion("fail_msg is not null");
            return (Criteria)this;
        }

        public Criteria andFailMsgEqualTo(String value) {
            this.addCriterion("fail_msg =", value, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgNotEqualTo(String value) {
            this.addCriterion("fail_msg <>", value, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgGreaterThan(String value) {
            this.addCriterion("fail_msg >", value, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgGreaterThanOrEqualTo(String value) {
            this.addCriterion("fail_msg >=", value, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgLessThan(String value) {
            this.addCriterion("fail_msg <", value, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgLessThanOrEqualTo(String value) {
            this.addCriterion("fail_msg <=", value, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgLike(String value) {
            this.addCriterion("fail_msg like", value, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgNotLike(String value) {
            this.addCriterion("fail_msg not like", value, "failMsg");
            return (Criteria)this;
        }        public Criteria andFailMsgIn(List<String> values) {
            this.addCriterion("fail_msg in", values, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgNotIn(List<String> values) {
            this.addCriterion("fail_msg not in", values, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgBetween(String value1, String value2) {
            this.addCriterion("fail_msg between", value1, value2, "failMsg");
            return (Criteria)this;
        }

        public Criteria andFailMsgNotBetween(String value1, String value2) {
            this.addCriterion("fail_msg not between", value1, value2, "failMsg");
            return (Criteria)this;
        }
    }
}
