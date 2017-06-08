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

        public ItemOrderExample.Criteria andOrderStatusIsNull() {
            this.addCriterion("orderStatus is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusIsNotNull() {
            this.addCriterion("orderStatus is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusEqualTo(Integer value) {
            this.addCriterion("orderStatus =", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotEqualTo(Integer value) {
            this.addCriterion("orderStatus <>", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusGreaterThan(Integer value) {
            this.addCriterion("orderStatus >", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("orderStatus >=", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusLessThan(Integer value) {
            this.addCriterion("orderStatus <", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("orderStatus <=", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusLike(String value) {
            this.addCriterion("orderStatus like", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotLike(String value) {
            this.addCriterion("orderStatus not like", value, "order_status");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andOrderStatusIn(List<Integer> values) {
            this.addCriterion("orderStatus in", values, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotIn(List<Integer> values) {
            this.addCriterion("orderStatus not in", values, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("orderStatus between", value1, value2, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("orderStatus not between", value1, value2, "order_status");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeIsNull() {
            this.addCriterion("payedFee is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeIsNotNull() {
            this.addCriterion("payedFee is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeEqualTo(Long value) {
            this.addCriterion("payedFee =", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotEqualTo(Long value) {
            this.addCriterion("payedFee <>", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeGreaterThan(Long value) {
            this.addCriterion("payedFee >", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("payedFee >=", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeLessThan(Long value) {
            this.addCriterion("payedFee <", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("payedFee <=", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeLike(String value) {
            this.addCriterion("payedFee like", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotLike(String value) {
            this.addCriterion("payedFee not like", value, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andPayedFeeIn(List<Long> values) {
            this.addCriterion("payedFee in", values, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotIn(List<Long> values) {
            this.addCriterion("payedFee not in", values, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeBetween(Long value1, Long value2) {
            this.addCriterion("payedFee between", value1, value2, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andPayedFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("payedFee not between", value1, value2, "payed_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdIsNull() {
            this.addCriterion("userId is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("userId is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("userId =", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("userId <>", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("userId >", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("userId >=", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("userId <", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("userId <=", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdLike(String value) {
            this.addCriterion("userId like", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("userId not like", value, "user_id");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("userId in", values, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("userId not in", values, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("userId between", value1, value2, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("userId not between", value1, value2, "user_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeIsNull() {
            this.addCriterion("totalFee is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeIsNotNull() {
            this.addCriterion("totalFee is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeEqualTo(Long value) {
            this.addCriterion("totalFee =", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotEqualTo(Long value) {
            this.addCriterion("totalFee <>", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeGreaterThan(Long value) {
            this.addCriterion("totalFee >", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("totalFee >=", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeLessThan(Long value) {
            this.addCriterion("totalFee <", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("totalFee <=", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeLike(String value) {
            this.addCriterion("totalFee like", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotLike(String value) {
            this.addCriterion("totalFee not like", value, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andTotalFeeIn(List<Long> values) {
            this.addCriterion("totalFee in", values, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotIn(List<Long> values) {
            this.addCriterion("totalFee not in", values, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeBetween(Long value1, Long value2) {
            this.addCriterion("totalFee between", value1, value2, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("totalFee not between", value1, value2, "total_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeIsNull() {
            this.addCriterion("refundFee is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeIsNotNull() {
            this.addCriterion("refundFee is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeEqualTo(Long value) {
            this.addCriterion("refundFee =", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotEqualTo(Long value) {
            this.addCriterion("refundFee <>", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeGreaterThan(Long value) {
            this.addCriterion("refundFee >", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refundFee >=", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeLessThan(Long value) {
            this.addCriterion("refundFee <", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("refundFee <=", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeLike(String value) {
            this.addCriterion("refundFee like", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotLike(String value) {
            this.addCriterion("refundFee not like", value, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andRefundFeeIn(List<Long> values) {
            this.addCriterion("refundFee in", values, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotIn(List<Long> values) {
            this.addCriterion("refundFee not in", values, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeBetween(Long value1, Long value2) {
            this.addCriterion("refundFee between", value1, value2, "refund_fee");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andRefundFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("refundFee not between", value1, value2, "refund_fee");
            return (ItemOrderExample.Criteria)this;
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

        public ItemOrderExample.Criteria andSenderIdIsNull() {
            this.addCriterion("senderId is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdIsNotNull() {
            this.addCriterion("senderId is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("senderId =", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("senderId <>", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("senderId >", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("senderId >=", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("senderId <", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("senderId <=", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdLike(String value) {
            this.addCriterion("senderId like", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotLike(String value) {
            this.addCriterion("senderId not like", value, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("senderId in", values, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("senderId not in", values, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("senderId between", value1, value2, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("senderId not between", value1, value2, "sender_id");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteIsNull() {
            this.addCriterion("webSite is null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("webSite is not null");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("webSite =", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("webSite <>", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("webSite >", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("webSite >=", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("webSite <", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("webSite <=", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("webSite like", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("webSite not like", value, "web_site");
            return (ItemOrderExample.Criteria)this;
        }        public ItemOrderExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("webSite in", values, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("webSite not in", values, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("webSite between", value1, value2, "web_site");
            return (ItemOrderExample.Criteria)this;
        }

        public ItemOrderExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("webSite not between", value1, value2, "web_site");
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
