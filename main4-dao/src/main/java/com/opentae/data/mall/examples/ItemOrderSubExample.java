package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderSubExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderSubExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderSubExample() {
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

    public List<ItemOrderSubExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderSubExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderSubExample.Criteria or() {
        ItemOrderSubExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderSubExample.Criteria createCriteria() {
        ItemOrderSubExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderSubExample.Criteria createCriteriaInternal() {
        ItemOrderSubExample.Criteria criteria = new ItemOrderSubExample.Criteria();
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

    public static class Criteria extends ItemOrderSubExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderSubExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderSubExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderSubExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderSubExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderSubExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderSubExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderSubExample.Criteria andSoidIsNull() {
            this.addCriterion("soid is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidIsNotNull() {
            this.addCriterion("soid is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidEqualTo(String value) {
            this.addCriterion("soid =", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotEqualTo(String value) {
            this.addCriterion("soid <>", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidGreaterThan(String value) {
            this.addCriterion("soid >", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidGreaterThanOrEqualTo(String value) {
            this.addCriterion("soid >=", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidLessThan(String value) {
            this.addCriterion("soid <", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidLessThanOrEqualTo(String value) {
            this.addCriterion("soid <=", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidLike(String value) {
            this.addCriterion("soid like", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotLike(String value) {
            this.addCriterion("soid not like", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSoidIn(List<String> values) {
            this.addCriterion("soid in", values, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotIn(List<String> values) {
            this.addCriterion("soid not in", values, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidBetween(String value1, String value2) {
            this.addCriterion("soid between", value1, value2, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotBetween(String value1, String value2) {
            this.addCriterion("soid not between", value1, value2, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidEqualTo(String value) {
            this.addCriterion("oid =", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotEqualTo(String value) {
            this.addCriterion("oid <>", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidGreaterThan(String value) {
            this.addCriterion("oid >", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidGreaterThanOrEqualTo(String value) {
            this.addCriterion("oid >=", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidLessThan(String value) {
            this.addCriterion("oid <", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidLessThanOrEqualTo(String value) {
            this.addCriterion("oid <=", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andOidIn(List<String> values) {
            this.addCriterion("oid in", values, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotIn(List<String> values) {
            this.addCriterion("oid not in", values, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidBetween(String value1, String value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotBetween(String value1, String value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidIsNull() {
            this.addCriterion("pid is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidIsNotNull() {
            this.addCriterion("pid is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidEqualTo(String value) {
            this.addCriterion("pid =", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidNotEqualTo(String value) {
            this.addCriterion("pid <>", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidGreaterThan(String value) {
            this.addCriterion("pid >", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidGreaterThanOrEqualTo(String value) {
            this.addCriterion("pid >=", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidLessThan(String value) {
            this.addCriterion("pid <", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidLessThanOrEqualTo(String value) {
            this.addCriterion("pid <=", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidLike(String value) {
            this.addCriterion("pid like", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidNotLike(String value) {
            this.addCriterion("pid not like", value, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andPidIn(List<String> values) {
            this.addCriterion("pid in", values, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidNotIn(List<String> values) {
            this.addCriterion("pid not in", values, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidBetween(String value1, String value2) {
            this.addCriterion("pid between", value1, value2, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPidNotBetween(String value1, String value2) {
            this.addCriterion("pid not between", value1, value2, "pid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdIsNull() {
            this.addCriterion("sku_id is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdIsNotNull() {
            this.addCriterion("sku_id is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdEqualTo(String value) {
            this.addCriterion("sku_id =", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdNotEqualTo(String value) {
            this.addCriterion("sku_id <>", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdGreaterThan(String value) {
            this.addCriterion("sku_id >", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("sku_id >=", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdLessThan(String value) {
            this.addCriterion("sku_id <", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdLessThanOrEqualTo(String value) {
            this.addCriterion("sku_id <=", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdLike(String value) {
            this.addCriterion("sku_id like", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdNotLike(String value) {
            this.addCriterion("sku_id not like", value, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSkuIdIn(List<String> values) {
            this.addCriterion("sku_id in", values, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdNotIn(List<String> values) {
            this.addCriterion("sku_id not in", values, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdBetween(String value1, String value2) {
            this.addCriterion("sku_id between", value1, value2, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSkuIdNotBetween(String value1, String value2) {
            this.addCriterion("sku_id not between", value1, value2, "skuId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumEqualTo(String value) {
            this.addCriterion("num =", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotEqualTo(String value) {
            this.addCriterion("num <>", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumGreaterThan(String value) {
            this.addCriterion("num >", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("num >=", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumLessThan(String value) {
            this.addCriterion("num <", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumLessThanOrEqualTo(String value) {
            this.addCriterion("num <=", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andNumIn(List<String> values) {
            this.addCriterion("num in", values, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotIn(List<String> values) {
            this.addCriterion("num not in", values, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumBetween(String value1, String value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotBetween(String value1, String value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumIsNull() {
            this.addCriterion("distribution_num is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumIsNotNull() {
            this.addCriterion("distribution_num is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumEqualTo(String value) {
            this.addCriterion("distribution_num =", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotEqualTo(String value) {
            this.addCriterion("distribution_num <>", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumGreaterThan(String value) {
            this.addCriterion("distribution_num >", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("distribution_num >=", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumLessThan(String value) {
            this.addCriterion("distribution_num <", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumLessThanOrEqualTo(String value) {
            this.addCriterion("distribution_num <=", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumLike(String value) {
            this.addCriterion("distribution_num like", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotLike(String value) {
            this.addCriterion("distribution_num not like", value, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andDistributionNumIn(List<String> values) {
            this.addCriterion("distribution_num in", values, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotIn(List<String> values) {
            this.addCriterion("distribution_num not in", values, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumBetween(String value1, String value2) {
            this.addCriterion("distribution_num between", value1, value2, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotBetween(String value1, String value2) {
            this.addCriterion("distribution_num not between", value1, value2, "distributionNum");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyIsNull() {
            this.addCriterion("should_pay_money is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyIsNotNull() {
            this.addCriterion("should_pay_money is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyEqualTo(String value) {
            this.addCriterion("should_pay_money =", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotEqualTo(String value) {
            this.addCriterion("should_pay_money <>", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyGreaterThan(String value) {
            this.addCriterion("should_pay_money >", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyGreaterThanOrEqualTo(String value) {
            this.addCriterion("should_pay_money >=", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLessThan(String value) {
            this.addCriterion("should_pay_money <", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLessThanOrEqualTo(String value) {
            this.addCriterion("should_pay_money <=", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLike(String value) {
            this.addCriterion("should_pay_money like", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotLike(String value) {
            this.addCriterion("should_pay_money not like", value, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andShouldPayMoneyIn(List<String> values) {
            this.addCriterion("should_pay_money in", values, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotIn(List<String> values) {
            this.addCriterion("should_pay_money not in", values, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyBetween(String value1, String value2) {
            this.addCriterion("should_pay_money between", value1, value2, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotBetween(String value1, String value2) {
            this.addCriterion("should_pay_money not between", value1, value2, "shouldPayMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyIsNull() {
            this.addCriterion("pay_money is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyIsNotNull() {
            this.addCriterion("pay_money is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyEqualTo(String value) {
            this.addCriterion("pay_money =", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotEqualTo(String value) {
            this.addCriterion("pay_money <>", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyGreaterThan(String value) {
            this.addCriterion("pay_money >", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyGreaterThanOrEqualTo(String value) {
            this.addCriterion("pay_money >=", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyLessThan(String value) {
            this.addCriterion("pay_money <", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyLessThanOrEqualTo(String value) {
            this.addCriterion("pay_money <=", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyLike(String value) {
            this.addCriterion("pay_money like", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotLike(String value) {
            this.addCriterion("pay_money not like", value, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andPayMoneyIn(List<String> values) {
            this.addCriterion("pay_money in", values, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotIn(List<String> values) {
            this.addCriterion("pay_money not in", values, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyBetween(String value1, String value2) {
            this.addCriterion("pay_money between", value1, value2, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotBetween(String value1, String value2) {
            this.addCriterion("pay_money not between", value1, value2, "payMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyIsNull() {
            this.addCriterion("refund_money is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyIsNotNull() {
            this.addCriterion("refund_money is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyEqualTo(String value) {
            this.addCriterion("refund_money =", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotEqualTo(String value) {
            this.addCriterion("refund_money <>", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyGreaterThan(String value) {
            this.addCriterion("refund_money >", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyGreaterThanOrEqualTo(String value) {
            this.addCriterion("refund_money >=", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLessThan(String value) {
            this.addCriterion("refund_money <", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLessThanOrEqualTo(String value) {
            this.addCriterion("refund_money <=", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLike(String value) {
            this.addCriterion("refund_money like", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotLike(String value) {
            this.addCriterion("refund_money not like", value, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andRefundMoneyIn(List<String> values) {
            this.addCriterion("refund_money in", values, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotIn(List<String> values) {
            this.addCriterion("refund_money not in", values, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyBetween(String value1, String value2) {
            this.addCriterion("refund_money between", value1, value2, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotBetween(String value1, String value2) {
            this.addCriterion("refund_money not between", value1, value2, "refundMoney");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendIsNull() {
            this.addCriterion("send is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendIsNotNull() {
            this.addCriterion("send is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendEqualTo(String value) {
            this.addCriterion("send =", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotEqualTo(String value) {
            this.addCriterion("send <>", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendGreaterThan(String value) {
            this.addCriterion("send >", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendGreaterThanOrEqualTo(String value) {
            this.addCriterion("send >=", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendLessThan(String value) {
            this.addCriterion("send <", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendLessThanOrEqualTo(String value) {
            this.addCriterion("send <=", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendLike(String value) {
            this.addCriterion("send like", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotLike(String value) {
            this.addCriterion("send not like", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSendIn(List<String> values) {
            this.addCriterion("send in", values, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotIn(List<String> values) {
            this.addCriterion("send not in", values, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendBetween(String value1, String value2) {
            this.addCriterion("send between", value1, value2, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotBetween(String value1, String value2) {
            this.addCriterion("send not between", value1, value2, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundIsNull() {
            this.addCriterion("refund is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundIsNotNull() {
            this.addCriterion("refund is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundEqualTo(String value) {
            this.addCriterion("refund =", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotEqualTo(String value) {
            this.addCriterion("refund <>", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundGreaterThan(String value) {
            this.addCriterion("refund >", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundGreaterThanOrEqualTo(String value) {
            this.addCriterion("refund >=", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundLessThan(String value) {
            this.addCriterion("refund <", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundLessThanOrEqualTo(String value) {
            this.addCriterion("refund <=", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundLike(String value) {
            this.addCriterion("refund like", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotLike(String value) {
            this.addCriterion("refund not like", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andRefundIn(List<String> values) {
            this.addCriterion("refund in", values, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotIn(List<String> values) {
            this.addCriterion("refund not in", values, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundBetween(String value1, String value2) {
            this.addCriterion("refund between", value1, value2, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotBetween(String value1, String value2) {
            this.addCriterion("refund not between", value1, value2, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkIsNull() {
            this.addCriterion("mark is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkIsNotNull() {
            this.addCriterion("mark is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkEqualTo(String value) {
            this.addCriterion("mark =", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotEqualTo(String value) {
            this.addCriterion("mark <>", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkGreaterThan(String value) {
            this.addCriterion("mark >", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("mark >=", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkLessThan(String value) {
            this.addCriterion("mark <", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkLessThanOrEqualTo(String value) {
            this.addCriterion("mark <=", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkLike(String value) {
            this.addCriterion("mark like", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotLike(String value) {
            this.addCriterion("mark not like", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andMarkIn(List<String> values) {
            this.addCriterion("mark in", values, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotIn(List<String> values) {
            this.addCriterion("mark not in", values, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkBetween(String value1, String value2) {
            this.addCriterion("mark between", value1, value2, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotBetween(String value1, String value2) {
            this.addCriterion("mark not between", value1, value2, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdIsNull() {
            this.addCriterion("logistics_id is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdIsNotNull() {
            this.addCriterion("logistics_id is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdEqualTo(String value) {
            this.addCriterion("logistics_id =", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotEqualTo(String value) {
            this.addCriterion("logistics_id <>", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdGreaterThan(String value) {
            this.addCriterion("logistics_id >", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("logistics_id >=", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLessThan(String value) {
            this.addCriterion("logistics_id <", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLessThanOrEqualTo(String value) {
            this.addCriterion("logistics_id <=", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLike(String value) {
            this.addCriterion("logistics_id like", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotLike(String value) {
            this.addCriterion("logistics_id not like", value, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andLogisticsIdIn(List<String> values) {
            this.addCriterion("logistics_id in", values, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotIn(List<String> values) {
            this.addCriterion("logistics_id not in", values, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdBetween(String value1, String value2) {
            this.addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotBetween(String value1, String value2) {
            this.addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (ItemOrderSubExample.Criteria)this;
        }
    }
}
