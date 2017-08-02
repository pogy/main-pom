package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (Criteria)this;
        }        public Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (Criteria)this;
        }

        public Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (Criteria)this;
        }

        public Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (Criteria)this;
        }        public Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (Criteria)this;
        }

        public Criteria andOuterIdIsNull() {
            this.addCriterion("outer_id is null");
            return (Criteria)this;
        }

        public Criteria andOuterIdIsNotNull() {
            this.addCriterion("outer_id is not null");
            return (Criteria)this;
        }

        public Criteria andOuterIdEqualTo(String value) {
            this.addCriterion("outer_id =", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotEqualTo(String value) {
            this.addCriterion("outer_id <>", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdGreaterThan(String value) {
            this.addCriterion("outer_id >", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("outer_id >=", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdLessThan(String value) {
            this.addCriterion("outer_id <", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdLessThanOrEqualTo(String value) {
            this.addCriterion("outer_id <=", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdLike(String value) {
            this.addCriterion("outer_id like", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotLike(String value) {
            this.addCriterion("outer_id not like", value, "outerId");
            return (Criteria)this;
        }        public Criteria andOuterIdIn(List<String> values) {
            this.addCriterion("outer_id in", values, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotIn(List<String> values) {
            this.addCriterion("outer_id not in", values, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdBetween(String value1, String value2) {
            this.addCriterion("outer_id between", value1, value2, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotBetween(String value1, String value2) {
            this.addCriterion("outer_id not between", value1, value2, "outerId");
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

        public Criteria andFinishTimeIsNull() {
            this.addCriterion("finish_time is null");
            return (Criteria)this;
        }

        public Criteria andFinishTimeIsNotNull() {
            this.addCriterion("finish_time is not null");
            return (Criteria)this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            this.addCriterion("finish_time =", value, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            this.addCriterion("finish_time <>", value, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            this.addCriterion("finish_time >", value, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("finish_time >=", value, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            this.addCriterion("finish_time <", value, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("finish_time <=", value, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeLike(String value) {
            this.addCriterion("finish_time like", value, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeNotLike(String value) {
            this.addCriterion("finish_time not like", value, "finishTime");
            return (Criteria)this;
        }        public Criteria andFinishTimeIn(List<Date> values) {
            this.addCriterion("finish_time in", values, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            this.addCriterion("finish_time not in", values, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            this.addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria)this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria)this;
        }

        public Criteria andOrderStatusIsNull() {
            this.addCriterion("order_status is null");
            return (Criteria)this;
        }

        public Criteria andOrderStatusIsNotNull() {
            this.addCriterion("order_status is not null");
            return (Criteria)this;
        }

        public Criteria andOrderStatusEqualTo(Integer value) {
            this.addCriterion("order_status =", value, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusNotEqualTo(Integer value) {
            this.addCriterion("order_status <>", value, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusGreaterThan(Integer value) {
            this.addCriterion("order_status >", value, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("order_status >=", value, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusLessThan(Integer value) {
            this.addCriterion("order_status <", value, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("order_status <=", value, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusLike(String value) {
            this.addCriterion("order_status like", value, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            this.addCriterion("order_status not like", value, "orderStatus");
            return (Criteria)this;
        }        public Criteria andOrderStatusIn(List<Integer> values) {
            this.addCriterion("order_status in", values, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusNotIn(List<Integer> values) {
            this.addCriterion("order_status not in", values, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria)this;
        }

        public Criteria andPayedFeeIsNull() {
            this.addCriterion("payed_fee is null");
            return (Criteria)this;
        }

        public Criteria andPayedFeeIsNotNull() {
            this.addCriterion("payed_fee is not null");
            return (Criteria)this;
        }

        public Criteria andPayedFeeEqualTo(Long value) {
            this.addCriterion("payed_fee =", value, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeNotEqualTo(Long value) {
            this.addCriterion("payed_fee <>", value, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeGreaterThan(Long value) {
            this.addCriterion("payed_fee >", value, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("payed_fee >=", value, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeLessThan(Long value) {
            this.addCriterion("payed_fee <", value, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("payed_fee <=", value, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeLike(String value) {
            this.addCriterion("payed_fee like", value, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeNotLike(String value) {
            this.addCriterion("payed_fee not like", value, "payedFee");
            return (Criteria)this;
        }        public Criteria andPayedFeeIn(List<Long> values) {
            this.addCriterion("payed_fee in", values, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeNotIn(List<Long> values) {
            this.addCriterion("payed_fee not in", values, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeBetween(Long value1, Long value2) {
            this.addCriterion("payed_fee between", value1, value2, "payedFee");
            return (Criteria)this;
        }

        public Criteria andPayedFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("payed_fee not between", value1, value2, "payedFee");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (Criteria)this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (Criteria)this;
        }        public Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andTotalFeeIsNull() {
            this.addCriterion("total_fee is null");
            return (Criteria)this;
        }

        public Criteria andTotalFeeIsNotNull() {
            this.addCriterion("total_fee is not null");
            return (Criteria)this;
        }

        public Criteria andTotalFeeEqualTo(Long value) {
            this.addCriterion("total_fee =", value, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeNotEqualTo(Long value) {
            this.addCriterion("total_fee <>", value, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeGreaterThan(Long value) {
            this.addCriterion("total_fee >", value, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("total_fee >=", value, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeLessThan(Long value) {
            this.addCriterion("total_fee <", value, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("total_fee <=", value, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeLike(String value) {
            this.addCriterion("total_fee like", value, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeNotLike(String value) {
            this.addCriterion("total_fee not like", value, "totalFee");
            return (Criteria)this;
        }        public Criteria andTotalFeeIn(List<Long> values) {
            this.addCriterion("total_fee in", values, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeNotIn(List<Long> values) {
            this.addCriterion("total_fee not in", values, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeBetween(Long value1, Long value2) {
            this.addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria)this;
        }

        public Criteria andTotalFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeIsNull() {
            this.addCriterion("refund_fee is null");
            return (Criteria)this;
        }

        public Criteria andRefundFeeIsNotNull() {
            this.addCriterion("refund_fee is not null");
            return (Criteria)this;
        }

        public Criteria andRefundFeeEqualTo(Long value) {
            this.addCriterion("refund_fee =", value, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeNotEqualTo(Long value) {
            this.addCriterion("refund_fee <>", value, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeGreaterThan(Long value) {
            this.addCriterion("refund_fee >", value, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_fee >=", value, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeLessThan(Long value) {
            this.addCriterion("refund_fee <", value, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_fee <=", value, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeLike(String value) {
            this.addCriterion("refund_fee like", value, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeNotLike(String value) {
            this.addCriterion("refund_fee not like", value, "refundFee");
            return (Criteria)this;
        }        public Criteria andRefundFeeIn(List<Long> values) {
            this.addCriterion("refund_fee in", values, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeNotIn(List<Long> values) {
            this.addCriterion("refund_fee not in", values, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeBetween(Long value1, Long value2) {
            this.addCriterion("refund_fee between", value1, value2, "refundFee");
            return (Criteria)this;
        }

        public Criteria andRefundFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_fee not between", value1, value2, "refundFee");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (Criteria)this;
        }

        public Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (Criteria)this;
        }        public Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (Criteria)this;
        }

        public Criteria andMarkIsNull() {
            this.addCriterion("mark is null");
            return (Criteria)this;
        }

        public Criteria andMarkIsNotNull() {
            this.addCriterion("mark is not null");
            return (Criteria)this;
        }

        public Criteria andMarkEqualTo(String value) {
            this.addCriterion("mark =", value, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            this.addCriterion("mark <>", value, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkGreaterThan(String value) {
            this.addCriterion("mark >", value, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("mark >=", value, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkLessThan(String value) {
            this.addCriterion("mark <", value, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            this.addCriterion("mark <=", value, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkLike(String value) {
            this.addCriterion("mark like", value, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkNotLike(String value) {
            this.addCriterion("mark not like", value, "mark");
            return (Criteria)this;
        }        public Criteria andMarkIn(List<String> values) {
            this.addCriterion("mark in", values, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            this.addCriterion("mark not in", values, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            this.addCriterion("mark between", value1, value2, "mark");
            return (Criteria)this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            this.addCriterion("mark not between", value1, value2, "mark");
            return (Criteria)this;
        }
    }
}
