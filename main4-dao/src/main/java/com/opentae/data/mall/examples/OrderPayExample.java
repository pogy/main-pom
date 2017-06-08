package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderPayExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderPayExample.Criteria> oredCriteria = new ArrayList();

    public OrderPayExample() {
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

    public List<OrderPayExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderPayExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderPayExample.Criteria or() {
        OrderPayExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderPayExample.Criteria createCriteria() {
        OrderPayExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderPayExample.Criteria createCriteriaInternal() {
        OrderPayExample.Criteria criteria = new OrderPayExample.Criteria();
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

    public static class Criteria extends OrderPayExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderPayExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderPayExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderPayExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderPayExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderPayExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderPayExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderPayExample.Criteria andOuterPuserIsNull() {
            this.addCriterion("outerPuser is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserIsNotNull() {
            this.addCriterion("outerPuser is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserEqualTo(String value) {
            this.addCriterion("outerPuser =", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserNotEqualTo(String value) {
            this.addCriterion("outerPuser <>", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserGreaterThan(String value) {
            this.addCriterion("outerPuser >", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserGreaterThanOrEqualTo(String value) {
            this.addCriterion("outerPuser >=", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserLessThan(String value) {
            this.addCriterion("outerPuser <", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserLessThanOrEqualTo(String value) {
            this.addCriterion("outerPuser <=", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserLike(String value) {
            this.addCriterion("outerPuser like", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserNotLike(String value) {
            this.addCriterion("outerPuser not like", value, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andOuterPuserIn(List<String> values) {
            this.addCriterion("outerPuser in", values, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserNotIn(List<String> values) {
            this.addCriterion("outerPuser not in", values, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserBetween(String value1, String value2) {
            this.addCriterion("outerPuser between", value1, value2, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPuserNotBetween(String value1, String value2) {
            this.addCriterion("outerPuser not between", value1, value2, "outer_puser");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidIsNull() {
            this.addCriterion("outerPid is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidIsNotNull() {
            this.addCriterion("outerPid is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidEqualTo(String value) {
            this.addCriterion("outerPid =", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidNotEqualTo(String value) {
            this.addCriterion("outerPid <>", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidGreaterThan(String value) {
            this.addCriterion("outerPid >", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidGreaterThanOrEqualTo(String value) {
            this.addCriterion("outerPid >=", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidLessThan(String value) {
            this.addCriterion("outerPid <", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidLessThanOrEqualTo(String value) {
            this.addCriterion("outerPid <=", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidLike(String value) {
            this.addCriterion("outerPid like", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidNotLike(String value) {
            this.addCriterion("outerPid not like", value, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andOuterPidIn(List<String> values) {
            this.addCriterion("outerPid in", values, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidNotIn(List<String> values) {
            this.addCriterion("outerPid not in", values, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidBetween(String value1, String value2) {
            this.addCriterion("outerPid between", value1, value2, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andOuterPidNotBetween(String value1, String value2) {
            this.addCriterion("outerPid not between", value1, value2, "outer_pid");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyEqualTo(Long value) {
            this.addCriterion("money =", value, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyNotEqualTo(Long value) {
            this.addCriterion("money <>", value, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyGreaterThan(Long value) {
            this.addCriterion("money >", value, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("money >=", value, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyLessThan(Long value) {
            this.addCriterion("money <", value, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("money <=", value, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyLike(String value) {
            this.addCriterion("money like", value, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyNotLike(String value) {
            this.addCriterion("money not like", value, "money");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andMoneyIn(List<Long> values) {
            this.addCriterion("money in", values, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyNotIn(List<Long> values) {
            this.addCriterion("money not in", values, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyBetween(Long value1, Long value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("createTime is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("createTime is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("createTime =", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("createTime <>", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("createTime >", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("createTime >=", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("createTime <", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("createTime <=", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("createTime like", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("createTime not like", value, "create_time");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("createTime in", values, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("createTime not in", values, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("createTime between", value1, value2, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("createTime not between", value1, value2, "create_time");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForIsNull() {
            this.addCriterion("payFor is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForIsNotNull() {
            this.addCriterion("payFor is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForEqualTo(Integer value) {
            this.addCriterion("payFor =", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForNotEqualTo(Integer value) {
            this.addCriterion("payFor <>", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForGreaterThan(Integer value) {
            this.addCriterion("payFor >", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("payFor >=", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForLessThan(Integer value) {
            this.addCriterion("payFor <", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForLessThanOrEqualTo(Integer value) {
            this.addCriterion("payFor <=", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForLike(String value) {
            this.addCriterion("payFor like", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForNotLike(String value) {
            this.addCriterion("payFor not like", value, "pay_for");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andPayForIn(List<Integer> values) {
            this.addCriterion("payFor in", values, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForNotIn(List<Integer> values) {
            this.addCriterion("payFor not in", values, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForBetween(Integer value1, Integer value2) {
            this.addCriterion("payFor between", value1, value2, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayForNotBetween(Integer value1, Integer value2) {
            this.addCriterion("payFor not between", value1, value2, "pay_for");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyIsNull() {
            this.addCriterion("refundMoney is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyIsNotNull() {
            this.addCriterion("refundMoney is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyEqualTo(Long value) {
            this.addCriterion("refundMoney =", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            this.addCriterion("refundMoney <>", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyGreaterThan(Long value) {
            this.addCriterion("refundMoney >", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refundMoney >=", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyLessThan(Long value) {
            this.addCriterion("refundMoney <", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("refundMoney <=", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyLike(String value) {
            this.addCriterion("refundMoney like", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyNotLike(String value) {
            this.addCriterion("refundMoney not like", value, "refund_money");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andRefundMoneyIn(List<Long> values) {
            this.addCriterion("refundMoney in", values, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            this.addCriterion("refundMoney not in", values, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            this.addCriterion("refundMoney between", value1, value2, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("refundMoney not between", value1, value2, "refund_money");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdIsNull() {
            this.addCriterion("applyId is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdIsNotNull() {
            this.addCriterion("applyId is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdEqualTo(Long value) {
            this.addCriterion("applyId =", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdNotEqualTo(Long value) {
            this.addCriterion("applyId <>", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdGreaterThan(Long value) {
            this.addCriterion("applyId >", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("applyId >=", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdLessThan(Long value) {
            this.addCriterion("applyId <", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("applyId <=", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdLike(String value) {
            this.addCriterion("applyId like", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdNotLike(String value) {
            this.addCriterion("applyId not like", value, "apply_id");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andApplyIdIn(List<Long> values) {
            this.addCriterion("applyId in", values, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdNotIn(List<Long> values) {
            this.addCriterion("applyId not in", values, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            this.addCriterion("applyId between", value1, value2, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("applyId not between", value1, value2, "apply_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdIsNull() {
            this.addCriterion("payId is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdIsNotNull() {
            this.addCriterion("payId is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdEqualTo(Long value) {
            this.addCriterion("payId =", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdNotEqualTo(Long value) {
            this.addCriterion("payId <>", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdGreaterThan(Long value) {
            this.addCriterion("payId >", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("payId >=", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdLessThan(Long value) {
            this.addCriterion("payId <", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdLessThanOrEqualTo(Long value) {
            this.addCriterion("payId <=", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdLike(String value) {
            this.addCriterion("payId like", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdNotLike(String value) {
            this.addCriterion("payId not like", value, "pay_id");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andPayIdIn(List<Long> values) {
            this.addCriterion("payId in", values, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdNotIn(List<Long> values) {
            this.addCriterion("payId not in", values, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdBetween(Long value1, Long value2) {
            this.addCriterion("payId between", value1, value2, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andPayIdNotBetween(Long value1, Long value2) {
            this.addCriterion("payId not between", value1, value2, "pay_id");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (OrderPayExample.Criteria)this;
        }        public OrderPayExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (OrderPayExample.Criteria)this;
        }

        public OrderPayExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (OrderPayExample.Criteria)this;
        }
    }
}
