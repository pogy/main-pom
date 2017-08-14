package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderPayRelationshipExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderPayRelationshipExample.Criteria> oredCriteria = new ArrayList();

    public OrderPayRelationshipExample() {
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

    public List<OrderPayRelationshipExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderPayRelationshipExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderPayRelationshipExample.Criteria or() {
        OrderPayRelationshipExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderPayRelationshipExample.Criteria createCriteria() {
        OrderPayRelationshipExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderPayRelationshipExample.Criteria createCriteriaInternal() {
        OrderPayRelationshipExample.Criteria criteria = new OrderPayRelationshipExample.Criteria();
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

    public static class Criteria extends OrderPayRelationshipExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderPayRelationshipExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderPayRelationshipExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderPayRelationshipExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderPayRelationshipExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderPayRelationshipExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderPayRelationshipExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderPayRelationshipExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }        public OrderPayRelationshipExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidIsNull() {
            this.addCriterion("rid is null");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidIsNotNull() {
            this.addCriterion("rid is not null");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidEqualTo(Long value) {
            this.addCriterion("rid =", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidNotEqualTo(Long value) {
            this.addCriterion("rid <>", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidGreaterThan(Long value) {
            this.addCriterion("rid >", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("rid >=", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidLessThan(Long value) {
            this.addCriterion("rid <", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidLessThanOrEqualTo(Long value) {
            this.addCriterion("rid <=", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidLike(String value) {
            this.addCriterion("rid like", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidNotLike(String value) {
            this.addCriterion("rid not like", value, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }        public OrderPayRelationshipExample.Criteria andRidIn(List<Long> values) {
            this.addCriterion("rid in", values, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidNotIn(List<Long> values) {
            this.addCriterion("rid not in", values, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidBetween(Long value1, Long value2) {
            this.addCriterion("rid between", value1, value2, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andRidNotBetween(Long value1, Long value2) {
            this.addCriterion("rid not between", value1, value2, "rid");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdIsNull() {
            this.addCriterion("pay_id is null");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdIsNotNull() {
            this.addCriterion("pay_id is not null");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdEqualTo(Long value) {
            this.addCriterion("pay_id =", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdNotEqualTo(Long value) {
            this.addCriterion("pay_id <>", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdGreaterThan(Long value) {
            this.addCriterion("pay_id >", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pay_id >=", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdLessThan(Long value) {
            this.addCriterion("pay_id <", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdLessThanOrEqualTo(Long value) {
            this.addCriterion("pay_id <=", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdLike(String value) {
            this.addCriterion("pay_id like", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdNotLike(String value) {
            this.addCriterion("pay_id not like", value, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }        public OrderPayRelationshipExample.Criteria andPayIdIn(List<Long> values) {
            this.addCriterion("pay_id in", values, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdNotIn(List<Long> values) {
            this.addCriterion("pay_id not in", values, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdBetween(Long value1, Long value2) {
            this.addCriterion("pay_id between", value1, value2, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }

        public OrderPayRelationshipExample.Criteria andPayIdNotBetween(Long value1, Long value2) {
            this.addCriterion("pay_id not between", value1, value2, "payId");
            return (OrderPayRelationshipExample.Criteria)this;
        }
    }
}
