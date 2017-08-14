package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderPayRelationshipExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andRidIsNull() {
            this.addCriterion("rid is null");
            return (Criteria)this;
        }

        public Criteria andRidIsNotNull() {
            this.addCriterion("rid is not null");
            return (Criteria)this;
        }

        public Criteria andRidEqualTo(Long value) {
            this.addCriterion("rid =", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidNotEqualTo(Long value) {
            this.addCriterion("rid <>", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidGreaterThan(Long value) {
            this.addCriterion("rid >", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("rid >=", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidLessThan(Long value) {
            this.addCriterion("rid <", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidLessThanOrEqualTo(Long value) {
            this.addCriterion("rid <=", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidLike(String value) {
            this.addCriterion("rid like", value, "rid");
            return (Criteria)this;
        }

        public Criteria andRidNotLike(String value) {
            this.addCriterion("rid not like", value, "rid");
            return (Criteria)this;
        }        public Criteria andRidIn(List<Long> values) {
            this.addCriterion("rid in", values, "rid");
            return (Criteria)this;
        }

        public Criteria andRidNotIn(List<Long> values) {
            this.addCriterion("rid not in", values, "rid");
            return (Criteria)this;
        }

        public Criteria andRidBetween(Long value1, Long value2) {
            this.addCriterion("rid between", value1, value2, "rid");
            return (Criteria)this;
        }

        public Criteria andRidNotBetween(Long value1, Long value2) {
            this.addCriterion("rid not between", value1, value2, "rid");
            return (Criteria)this;
        }

        public Criteria andPayIdIsNull() {
            this.addCriterion("pay_id is null");
            return (Criteria)this;
        }

        public Criteria andPayIdIsNotNull() {
            this.addCriterion("pay_id is not null");
            return (Criteria)this;
        }

        public Criteria andPayIdEqualTo(Long value) {
            this.addCriterion("pay_id =", value, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdNotEqualTo(Long value) {
            this.addCriterion("pay_id <>", value, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdGreaterThan(Long value) {
            this.addCriterion("pay_id >", value, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pay_id >=", value, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdLessThan(Long value) {
            this.addCriterion("pay_id <", value, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdLessThanOrEqualTo(Long value) {
            this.addCriterion("pay_id <=", value, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdLike(String value) {
            this.addCriterion("pay_id like", value, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdNotLike(String value) {
            this.addCriterion("pay_id not like", value, "payId");
            return (Criteria)this;
        }        public Criteria andPayIdIn(List<Long> values) {
            this.addCriterion("pay_id in", values, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdNotIn(List<Long> values) {
            this.addCriterion("pay_id not in", values, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdBetween(Long value1, Long value2) {
            this.addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria)this;
        }

        public Criteria andPayIdNotBetween(Long value1, Long value2) {
            this.addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria)this;
        }
    }
}
