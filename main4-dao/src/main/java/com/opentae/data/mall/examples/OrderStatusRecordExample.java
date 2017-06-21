package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderStatusRecordExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderStatusRecordExample.Criteria> oredCriteria = new ArrayList();

    public OrderStatusRecordExample() {
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

    public List<OrderStatusRecordExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderStatusRecordExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderStatusRecordExample.Criteria or() {
        OrderStatusRecordExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderStatusRecordExample.Criteria createCriteria() {
        OrderStatusRecordExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderStatusRecordExample.Criteria createCriteriaInternal() {
        OrderStatusRecordExample.Criteria criteria = new OrderStatusRecordExample.Criteria();
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

    public static class Criteria extends OrderStatusRecordExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderStatusRecordExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderStatusRecordExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderStatusRecordExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderStatusRecordExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderStatusRecordExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderStatusRecordExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderStatusRecordExample.Criteria andStatusIdIsNull() {
            this.addCriterion("status_id is null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdIsNotNull() {
            this.addCriterion("status_id is not null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdEqualTo(Long value) {
            this.addCriterion("status_id =", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdNotEqualTo(Long value) {
            this.addCriterion("status_id <>", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdGreaterThan(Long value) {
            this.addCriterion("status_id >", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("status_id >=", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdLessThan(Long value) {
            this.addCriterion("status_id <", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdLessThanOrEqualTo(Long value) {
            this.addCriterion("status_id <=", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdLike(String value) {
            this.addCriterion("status_id like", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdNotLike(String value) {
            this.addCriterion("status_id not like", value, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }        public OrderStatusRecordExample.Criteria andStatusIdIn(List<Long> values) {
            this.addCriterion("status_id in", values, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdNotIn(List<Long> values) {
            this.addCriterion("status_id not in", values, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdBetween(Long value1, Long value2) {
            this.addCriterion("status_id between", value1, value2, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIdNotBetween(Long value1, Long value2) {
            this.addCriterion("status_id not between", value1, value2, "statusId");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }        public OrderStatusRecordExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }        public OrderStatusRecordExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }        public OrderStatusRecordExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }

        public OrderStatusRecordExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (OrderStatusRecordExample.Criteria)this;
        }
    }
}
