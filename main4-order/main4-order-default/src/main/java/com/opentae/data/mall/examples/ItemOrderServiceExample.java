package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderServiceExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public ItemOrderServiceExample() {
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

        public Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (Criteria)this;
        }

        public Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (Criteria)this;
        }

        public Criteria andMoneyEqualTo(Long value) {
            this.addCriterion("money =", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotEqualTo(Long value) {
            this.addCriterion("money <>", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThan(Long value) {
            this.addCriterion("money >", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("money >=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThan(Long value) {
            this.addCriterion("money <", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("money <=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLike(String value) {
            this.addCriterion("money like", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotLike(String value) {
            this.addCriterion("money not like", value, "money");
            return (Criteria)this;
        }        public Criteria andMoneyIn(List<Long> values) {
            this.addCriterion("money in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotIn(List<Long> values) {
            this.addCriterion("money not in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyBetween(Long value1, Long value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (Criteria)this;
        }

        public Criteria andServiceIdIsNull() {
            this.addCriterion("service_id is null");
            return (Criteria)this;
        }

        public Criteria andServiceIdIsNotNull() {
            this.addCriterion("service_id is not null");
            return (Criteria)this;
        }

        public Criteria andServiceIdEqualTo(Long value) {
            this.addCriterion("service_id =", value, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdNotEqualTo(Long value) {
            this.addCriterion("service_id <>", value, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdGreaterThan(Long value) {
            this.addCriterion("service_id >", value, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("service_id >=", value, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdLessThan(Long value) {
            this.addCriterion("service_id <", value, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Long value) {
            this.addCriterion("service_id <=", value, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdLike(String value) {
            this.addCriterion("service_id like", value, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdNotLike(String value) {
            this.addCriterion("service_id not like", value, "serviceId");
            return (Criteria)this;
        }        public Criteria andServiceIdIn(List<Long> values) {
            this.addCriterion("service_id in", values, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdNotIn(List<Long> values) {
            this.addCriterion("service_id not in", values, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdBetween(Long value1, Long value2) {
            this.addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria)this;
        }

        public Criteria andServiceIdNotBetween(Long value1, Long value2) {
            this.addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria)this;
        }

        public Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (Criteria)this;
        }

        public Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (Criteria)this;
        }

        public Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (Criteria)this;
        }        public Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
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

        public Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (Criteria)this;
        }

        public Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (Criteria)this;
        }

        public Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (Criteria)this;
        }        public Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
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
    }
}
