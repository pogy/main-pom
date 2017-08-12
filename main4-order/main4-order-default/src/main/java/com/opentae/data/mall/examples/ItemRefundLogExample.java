package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemRefundLogExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public ItemRefundLogExample() {
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

        public Criteria andMsgIsNull() {
            this.addCriterion("msg is null");
            return (Criteria)this;
        }

        public Criteria andMsgIsNotNull() {
            this.addCriterion("msg is not null");
            return (Criteria)this;
        }

        public Criteria andMsgEqualTo(String value) {
            this.addCriterion("msg =", value, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            this.addCriterion("msg <>", value, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgGreaterThan(String value) {
            this.addCriterion("msg >", value, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            this.addCriterion("msg >=", value, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgLessThan(String value) {
            this.addCriterion("msg <", value, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            this.addCriterion("msg <=", value, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgLike(String value) {
            this.addCriterion("msg like", value, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgNotLike(String value) {
            this.addCriterion("msg not like", value, "msg");
            return (Criteria)this;
        }        public Criteria andMsgIn(List<String> values) {
            this.addCriterion("msg in", values, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            this.addCriterion("msg not in", values, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            this.addCriterion("msg between", value1, value2, "msg");
            return (Criteria)this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            this.addCriterion("msg not between", value1, value2, "msg");
            return (Criteria)this;
        }

        public Criteria andImBuyerIsNull() {
            this.addCriterion("im_buyer is null");
            return (Criteria)this;
        }

        public Criteria andImBuyerIsNotNull() {
            this.addCriterion("im_buyer is not null");
            return (Criteria)this;
        }

        public Criteria andImBuyerEqualTo(Boolean value) {
            this.addCriterion("im_buyer =", value, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerNotEqualTo(Boolean value) {
            this.addCriterion("im_buyer <>", value, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerGreaterThan(Boolean value) {
            this.addCriterion("im_buyer >", value, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("im_buyer >=", value, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerLessThan(Boolean value) {
            this.addCriterion("im_buyer <", value, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerLessThanOrEqualTo(Boolean value) {
            this.addCriterion("im_buyer <=", value, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerLike(String value) {
            this.addCriterion("im_buyer like", value, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerNotLike(String value) {
            this.addCriterion("im_buyer not like", value, "imBuyer");
            return (Criteria)this;
        }        public Criteria andImBuyerIn(List<Boolean> values) {
            this.addCriterion("im_buyer in", values, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerNotIn(List<Boolean> values) {
            this.addCriterion("im_buyer not in", values, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_buyer between", value1, value2, "imBuyer");
            return (Criteria)this;
        }

        public Criteria andImBuyerNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_buyer not between", value1, value2, "imBuyer");
            return (Criteria)this;
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

        public Criteria andToStatusIsNull() {
            this.addCriterion("to_status is null");
            return (Criteria)this;
        }

        public Criteria andToStatusIsNotNull() {
            this.addCriterion("to_status is not null");
            return (Criteria)this;
        }

        public Criteria andToStatusEqualTo(Integer value) {
            this.addCriterion("to_status =", value, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusNotEqualTo(Integer value) {
            this.addCriterion("to_status <>", value, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusGreaterThan(Integer value) {
            this.addCriterion("to_status >", value, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("to_status >=", value, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusLessThan(Integer value) {
            this.addCriterion("to_status <", value, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("to_status <=", value, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusLike(String value) {
            this.addCriterion("to_status like", value, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusNotLike(String value) {
            this.addCriterion("to_status not like", value, "toStatus");
            return (Criteria)this;
        }        public Criteria andToStatusIn(List<Integer> values) {
            this.addCriterion("to_status in", values, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusNotIn(List<Integer> values) {
            this.addCriterion("to_status not in", values, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("to_status between", value1, value2, "toStatus");
            return (Criteria)this;
        }

        public Criteria andToStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("to_status not between", value1, value2, "toStatus");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdIsNull() {
            this.addCriterion("refund_log_id is null");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdIsNotNull() {
            this.addCriterion("refund_log_id is not null");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdEqualTo(Long value) {
            this.addCriterion("refund_log_id =", value, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdNotEqualTo(Long value) {
            this.addCriterion("refund_log_id <>", value, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdGreaterThan(Long value) {
            this.addCriterion("refund_log_id >", value, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_log_id >=", value, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdLessThan(Long value) {
            this.addCriterion("refund_log_id <", value, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_log_id <=", value, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdLike(String value) {
            this.addCriterion("refund_log_id like", value, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdNotLike(String value) {
            this.addCriterion("refund_log_id not like", value, "refundLogId");
            return (Criteria)this;
        }        public Criteria andRefundLogIdIn(List<Long> values) {
            this.addCriterion("refund_log_id in", values, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdNotIn(List<Long> values) {
            this.addCriterion("refund_log_id not in", values, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdBetween(Long value1, Long value2) {
            this.addCriterion("refund_log_id between", value1, value2, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andRefundLogIdNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_log_id not between", value1, value2, "refundLogId");
            return (Criteria)this;
        }

        public Criteria andFromStatusIsNull() {
            this.addCriterion("from_status is null");
            return (Criteria)this;
        }

        public Criteria andFromStatusIsNotNull() {
            this.addCriterion("from_status is not null");
            return (Criteria)this;
        }

        public Criteria andFromStatusEqualTo(Integer value) {
            this.addCriterion("from_status =", value, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusNotEqualTo(Integer value) {
            this.addCriterion("from_status <>", value, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusGreaterThan(Integer value) {
            this.addCriterion("from_status >", value, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("from_status >=", value, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusLessThan(Integer value) {
            this.addCriterion("from_status <", value, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("from_status <=", value, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusLike(String value) {
            this.addCriterion("from_status like", value, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusNotLike(String value) {
            this.addCriterion("from_status not like", value, "fromStatus");
            return (Criteria)this;
        }        public Criteria andFromStatusIn(List<Integer> values) {
            this.addCriterion("from_status in", values, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusNotIn(List<Integer> values) {
            this.addCriterion("from_status not in", values, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("from_status between", value1, value2, "fromStatus");
            return (Criteria)this;
        }

        public Criteria andFromStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("from_status not between", value1, value2, "fromStatus");
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
    }
}
