package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemRefundLogExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemRefundLogExample.Criteria> oredCriteria = new ArrayList();

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

    public List<ItemRefundLogExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemRefundLogExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemRefundLogExample.Criteria or() {
        ItemRefundLogExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemRefundLogExample.Criteria createCriteria() {
        ItemRefundLogExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemRefundLogExample.Criteria createCriteriaInternal() {
        ItemRefundLogExample.Criteria criteria = new ItemRefundLogExample.Criteria();
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

    public static class Criteria extends ItemRefundLogExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemRefundLogExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemRefundLogExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemRefundLogExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemRefundLogExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemRefundLogExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemRefundLogExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemRefundLogExample.Criteria andToStatusIsNull() {
            this.addCriterion("to_status is null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusIsNotNull() {
            this.addCriterion("to_status is not null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusEqualTo(Integer value) {
            this.addCriterion("to_status =", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusNotEqualTo(Integer value) {
            this.addCriterion("to_status <>", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusGreaterThan(Integer value) {
            this.addCriterion("to_status >", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("to_status >=", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusLessThan(Integer value) {
            this.addCriterion("to_status <", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("to_status <=", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusLike(String value) {
            this.addCriterion("to_status like", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusNotLike(String value) {
            this.addCriterion("to_status not like", value, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }        public ItemRefundLogExample.Criteria andToStatusIn(List<Integer> values) {
            this.addCriterion("to_status in", values, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusNotIn(List<Integer> values) {
            this.addCriterion("to_status not in", values, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("to_status between", value1, value2, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andToStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("to_status not between", value1, value2, "toStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdIsNull() {
            this.addCriterion("refund_id is null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdIsNotNull() {
            this.addCriterion("refund_id is not null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdEqualTo(Long value) {
            this.addCriterion("refund_id =", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdNotEqualTo(Long value) {
            this.addCriterion("refund_id <>", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdGreaterThan(Long value) {
            this.addCriterion("refund_id >", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_id >=", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdLessThan(Long value) {
            this.addCriterion("refund_id <", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_id <=", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdLike(String value) {
            this.addCriterion("refund_id like", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdNotLike(String value) {
            this.addCriterion("refund_id not like", value, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }        public ItemRefundLogExample.Criteria andRefundIdIn(List<Long> values) {
            this.addCriterion("refund_id in", values, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdNotIn(List<Long> values) {
            this.addCriterion("refund_id not in", values, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            this.addCriterion("refund_id between", value1, value2, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_id not between", value1, value2, "refundId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusIsNull() {
            this.addCriterion("from_status is null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusIsNotNull() {
            this.addCriterion("from_status is not null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusEqualTo(Integer value) {
            this.addCriterion("from_status =", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusNotEqualTo(Integer value) {
            this.addCriterion("from_status <>", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusGreaterThan(Integer value) {
            this.addCriterion("from_status >", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("from_status >=", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusLessThan(Integer value) {
            this.addCriterion("from_status <", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("from_status <=", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusLike(String value) {
            this.addCriterion("from_status like", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusNotLike(String value) {
            this.addCriterion("from_status not like", value, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }        public ItemRefundLogExample.Criteria andFromStatusIn(List<Integer> values) {
            this.addCriterion("from_status in", values, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusNotIn(List<Integer> values) {
            this.addCriterion("from_status not in", values, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("from_status between", value1, value2, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andFromStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("from_status not between", value1, value2, "fromStatus");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerIsNull() {
            this.addCriterion("im_buyer is null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerIsNotNull() {
            this.addCriterion("im_buyer is not null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerEqualTo(Boolean value) {
            this.addCriterion("im_buyer =", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerNotEqualTo(Boolean value) {
            this.addCriterion("im_buyer <>", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerGreaterThan(Boolean value) {
            this.addCriterion("im_buyer >", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("im_buyer >=", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerLessThan(Boolean value) {
            this.addCriterion("im_buyer <", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerLessThanOrEqualTo(Boolean value) {
            this.addCriterion("im_buyer <=", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerLike(String value) {
            this.addCriterion("im_buyer like", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerNotLike(String value) {
            this.addCriterion("im_buyer not like", value, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }        public ItemRefundLogExample.Criteria andImBuyerIn(List<Boolean> values) {
            this.addCriterion("im_buyer in", values, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerNotIn(List<Boolean> values) {
            this.addCriterion("im_buyer not in", values, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_buyer between", value1, value2, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andImBuyerNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_buyer not between", value1, value2, "imBuyer");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }        public ItemRefundLogExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdIsNull() {
            this.addCriterion("refund_log_id is null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdIsNotNull() {
            this.addCriterion("refund_log_id is not null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdEqualTo(Long value) {
            this.addCriterion("refund_log_id =", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdNotEqualTo(Long value) {
            this.addCriterion("refund_log_id <>", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdGreaterThan(Long value) {
            this.addCriterion("refund_log_id >", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refund_log_id >=", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdLessThan(Long value) {
            this.addCriterion("refund_log_id <", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdLessThanOrEqualTo(Long value) {
            this.addCriterion("refund_log_id <=", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdLike(String value) {
            this.addCriterion("refund_log_id like", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdNotLike(String value) {
            this.addCriterion("refund_log_id not like", value, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }        public ItemRefundLogExample.Criteria andRefundLogIdIn(List<Long> values) {
            this.addCriterion("refund_log_id in", values, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdNotIn(List<Long> values) {
            this.addCriterion("refund_log_id not in", values, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdBetween(Long value1, Long value2) {
            this.addCriterion("refund_log_id between", value1, value2, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andRefundLogIdNotBetween(Long value1, Long value2) {
            this.addCriterion("refund_log_id not between", value1, value2, "refundLogId");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgIsNull() {
            this.addCriterion("msg is null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgIsNotNull() {
            this.addCriterion("msg is not null");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgEqualTo(String value) {
            this.addCriterion("msg =", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgNotEqualTo(String value) {
            this.addCriterion("msg <>", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgGreaterThan(String value) {
            this.addCriterion("msg >", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgGreaterThanOrEqualTo(String value) {
            this.addCriterion("msg >=", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgLessThan(String value) {
            this.addCriterion("msg <", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgLessThanOrEqualTo(String value) {
            this.addCriterion("msg <=", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgLike(String value) {
            this.addCriterion("msg like", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgNotLike(String value) {
            this.addCriterion("msg not like", value, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }        public ItemRefundLogExample.Criteria andMsgIn(List<String> values) {
            this.addCriterion("msg in", values, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgNotIn(List<String> values) {
            this.addCriterion("msg not in", values, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgBetween(String value1, String value2) {
            this.addCriterion("msg between", value1, value2, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }

        public ItemRefundLogExample.Criteria andMsgNotBetween(String value1, String value2) {
            this.addCriterion("msg not between", value1, value2, "msg");
            return (ItemRefundLogExample.Criteria)this;
        }
    }
}
