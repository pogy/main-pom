package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderSubExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andSoidIsNull() {
            this.addCriterion("soid is null");
            return (Criteria)this;
        }

        public Criteria andSoidIsNotNull() {
            this.addCriterion("soid is not null");
            return (Criteria)this;
        }

        public Criteria andSoidEqualTo(Long value) {
            this.addCriterion("soid =", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotEqualTo(Long value) {
            this.addCriterion("soid <>", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidGreaterThan(Long value) {
            this.addCriterion("soid >", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("soid >=", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidLessThan(Long value) {
            this.addCriterion("soid <", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidLessThanOrEqualTo(Long value) {
            this.addCriterion("soid <=", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidLike(String value) {
            this.addCriterion("soid like", value, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotLike(String value) {
            this.addCriterion("soid not like", value, "soid");
            return (Criteria)this;
        }        public Criteria andSoidIn(List<Long> values) {
            this.addCriterion("soid in", values, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotIn(List<Long> values) {
            this.addCriterion("soid not in", values, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidBetween(Long value1, Long value2) {
            this.addCriterion("soid between", value1, value2, "soid");
            return (Criteria)this;
        }

        public Criteria andSoidNotBetween(Long value1, Long value2) {
            this.addCriterion("soid not between", value1, value2, "soid");
            return (Criteria)this;
        }

        public Criteria andColorIsNull() {
            this.addCriterion("color is null");
            return (Criteria)this;
        }

        public Criteria andColorIsNotNull() {
            this.addCriterion("color is not null");
            return (Criteria)this;
        }

        public Criteria andColorEqualTo(String value) {
            this.addCriterion("color =", value, "color");
            return (Criteria)this;
        }

        public Criteria andColorNotEqualTo(String value) {
            this.addCriterion("color <>", value, "color");
            return (Criteria)this;
        }

        public Criteria andColorGreaterThan(String value) {
            this.addCriterion("color >", value, "color");
            return (Criteria)this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            this.addCriterion("color >=", value, "color");
            return (Criteria)this;
        }

        public Criteria andColorLessThan(String value) {
            this.addCriterion("color <", value, "color");
            return (Criteria)this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            this.addCriterion("color <=", value, "color");
            return (Criteria)this;
        }

        public Criteria andColorLike(String value) {
            this.addCriterion("color like", value, "color");
            return (Criteria)this;
        }

        public Criteria andColorNotLike(String value) {
            this.addCriterion("color not like", value, "color");
            return (Criteria)this;
        }        public Criteria andColorIn(List<String> values) {
            this.addCriterion("color in", values, "color");
            return (Criteria)this;
        }

        public Criteria andColorNotIn(List<String> values) {
            this.addCriterion("color not in", values, "color");
            return (Criteria)this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            this.addCriterion("color between", value1, value2, "color");
            return (Criteria)this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            this.addCriterion("color not between", value1, value2, "color");
            return (Criteria)this;
        }

        public Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (Criteria)this;
        }

        public Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (Criteria)this;
        }

        public Criteria andNumEqualTo(Integer value) {
            this.addCriterion("num =", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            this.addCriterion("num <>", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            this.addCriterion("num >", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("num >=", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumLessThan(Integer value) {
            this.addCriterion("num <", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("num <=", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (Criteria)this;
        }        public Criteria andNumIn(List<Integer> values) {
            this.addCriterion("num in", values, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            this.addCriterion("num not in", values, "num");
            return (Criteria)this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (Criteria)this;
        }

        public Criteria andGoodsNoIsNull() {
            this.addCriterion("goods_no is null");
            return (Criteria)this;
        }

        public Criteria andGoodsNoIsNotNull() {
            this.addCriterion("goods_no is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsNoEqualTo(String value) {
            this.addCriterion("goods_no =", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotEqualTo(String value) {
            this.addCriterion("goods_no <>", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThan(String value) {
            this.addCriterion("goods_no >", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_no >=", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThan(String value) {
            this.addCriterion("goods_no <", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThanOrEqualTo(String value) {
            this.addCriterion("goods_no <=", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLike(String value) {
            this.addCriterion("goods_no like", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotLike(String value) {
            this.addCriterion("goods_no not like", value, "goodsNo");
            return (Criteria)this;
        }        public Criteria andGoodsNoIn(List<String> values) {
            this.addCriterion("goods_no in", values, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotIn(List<String> values) {
            this.addCriterion("goods_no not in", values, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoBetween(String value1, String value2) {
            this.addCriterion("goods_no between", value1, value2, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotBetween(String value1, String value2) {
            this.addCriterion("goods_no not between", value1, value2, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andDistributionNumIsNull() {
            this.addCriterion("distribution_num is null");
            return (Criteria)this;
        }

        public Criteria andDistributionNumIsNotNull() {
            this.addCriterion("distribution_num is not null");
            return (Criteria)this;
        }

        public Criteria andDistributionNumEqualTo(Integer value) {
            this.addCriterion("distribution_num =", value, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumNotEqualTo(Integer value) {
            this.addCriterion("distribution_num <>", value, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumGreaterThan(Integer value) {
            this.addCriterion("distribution_num >", value, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("distribution_num >=", value, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumLessThan(Integer value) {
            this.addCriterion("distribution_num <", value, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("distribution_num <=", value, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumLike(String value) {
            this.addCriterion("distribution_num like", value, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumNotLike(String value) {
            this.addCriterion("distribution_num not like", value, "distributionNum");
            return (Criteria)this;
        }        public Criteria andDistributionNumIn(List<Integer> values) {
            this.addCriterion("distribution_num in", values, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumNotIn(List<Integer> values) {
            this.addCriterion("distribution_num not in", values, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumBetween(Integer value1, Integer value2) {
            this.addCriterion("distribution_num between", value1, value2, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andDistributionNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("distribution_num not between", value1, value2, "distributionNum");
            return (Criteria)this;
        }

        public Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (Criteria)this;
        }

        public Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (Criteria)this;
        }        public Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria)this;
        }

        public Criteria andWeightIsNull() {
            this.addCriterion("weight is null");
            return (Criteria)this;
        }

        public Criteria andWeightIsNotNull() {
            this.addCriterion("weight is not null");
            return (Criteria)this;
        }

        public Criteria andWeightEqualTo(Long value) {
            this.addCriterion("weight =", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotEqualTo(Long value) {
            this.addCriterion("weight <>", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightGreaterThan(Long value) {
            this.addCriterion("weight >", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Long value) {
            this.addCriterion("weight >=", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightLessThan(Long value) {
            this.addCriterion("weight <", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightLessThanOrEqualTo(Long value) {
            this.addCriterion("weight <=", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightLike(String value) {
            this.addCriterion("weight like", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotLike(String value) {
            this.addCriterion("weight not like", value, "weight");
            return (Criteria)this;
        }        public Criteria andWeightIn(List<Long> values) {
            this.addCriterion("weight in", values, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotIn(List<Long> values) {
            this.addCriterion("weight not in", values, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightBetween(Long value1, Long value2) {
            this.addCriterion("weight between", value1, value2, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotBetween(Long value1, Long value2) {
            this.addCriterion("weight not between", value1, value2, "weight");
            return (Criteria)this;
        }

        public Criteria andPidIsNull() {
            this.addCriterion("pid is null");
            return (Criteria)this;
        }

        public Criteria andPidIsNotNull() {
            this.addCriterion("pid is not null");
            return (Criteria)this;
        }

        public Criteria andPidEqualTo(Long value) {
            this.addCriterion("pid =", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            this.addCriterion("pid <>", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidGreaterThan(Long value) {
            this.addCriterion("pid >", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pid >=", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidLessThan(Long value) {
            this.addCriterion("pid <", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            this.addCriterion("pid <=", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidLike(String value) {
            this.addCriterion("pid like", value, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotLike(String value) {
            this.addCriterion("pid not like", value, "pid");
            return (Criteria)this;
        }        public Criteria andPidIn(List<Long> values) {
            this.addCriterion("pid in", values, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            this.addCriterion("pid not in", values, "pid");
            return (Criteria)this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            this.addCriterion("pid between", value1, value2, "pid");
            return (Criteria)this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            this.addCriterion("pid not between", value1, value2, "pid");
            return (Criteria)this;
        }

        public Criteria andSkuIdIsNull() {
            this.addCriterion("sku_id is null");
            return (Criteria)this;
        }

        public Criteria andSkuIdIsNotNull() {
            this.addCriterion("sku_id is not null");
            return (Criteria)this;
        }

        public Criteria andSkuIdEqualTo(Long value) {
            this.addCriterion("sku_id =", value, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            this.addCriterion("sku_id <>", value, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            this.addCriterion("sku_id >", value, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sku_id >=", value, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            this.addCriterion("sku_id <", value, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sku_id <=", value, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdLike(String value) {
            this.addCriterion("sku_id like", value, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdNotLike(String value) {
            this.addCriterion("sku_id not like", value, "skuId");
            return (Criteria)this;
        }        public Criteria andSkuIdIn(List<Long> values) {
            this.addCriterion("sku_id in", values, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            this.addCriterion("sku_id not in", values, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            this.addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria)this;
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sku_id not between", value1, value2, "skuId");
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

        public Criteria andPayMoneyIsNull() {
            this.addCriterion("pay_money is null");
            return (Criteria)this;
        }

        public Criteria andPayMoneyIsNotNull() {
            this.addCriterion("pay_money is not null");
            return (Criteria)this;
        }

        public Criteria andPayMoneyEqualTo(Long value) {
            this.addCriterion("pay_money =", value, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyNotEqualTo(Long value) {
            this.addCriterion("pay_money <>", value, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyGreaterThan(Long value) {
            this.addCriterion("pay_money >", value, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pay_money >=", value, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyLessThan(Long value) {
            this.addCriterion("pay_money <", value, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("pay_money <=", value, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyLike(String value) {
            this.addCriterion("pay_money like", value, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyNotLike(String value) {
            this.addCriterion("pay_money not like", value, "payMoney");
            return (Criteria)this;
        }        public Criteria andPayMoneyIn(List<Long> values) {
            this.addCriterion("pay_money in", values, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyNotIn(List<Long> values) {
            this.addCriterion("pay_money not in", values, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyBetween(Long value1, Long value2) {
            this.addCriterion("pay_money between", value1, value2, "payMoney");
            return (Criteria)this;
        }

        public Criteria andPayMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("pay_money not between", value1, value2, "payMoney");
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

        public Criteria andLogisticsIdIsNull() {
            this.addCriterion("logistics_id is null");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            this.addCriterion("logistics_id is not null");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdEqualTo(Long value) {
            this.addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdNotEqualTo(Long value) {
            this.addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdGreaterThan(Long value) {
            this.addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdLessThan(Long value) {
            this.addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdLike(String value) {
            this.addCriterion("logistics_id like", value, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdNotLike(String value) {
            this.addCriterion("logistics_id not like", value, "logisticsId");
            return (Criteria)this;
        }        public Criteria andLogisticsIdIn(List<Long> values) {
            this.addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdNotIn(List<Long> values) {
            this.addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdBetween(Long value1, Long value2) {
            this.addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andLogisticsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria)this;
        }

        public Criteria andSizeIsNull() {
            this.addCriterion("size is null");
            return (Criteria)this;
        }

        public Criteria andSizeIsNotNull() {
            this.addCriterion("size is not null");
            return (Criteria)this;
        }

        public Criteria andSizeEqualTo(String value) {
            this.addCriterion("size =", value, "size");
            return (Criteria)this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            this.addCriterion("size <>", value, "size");
            return (Criteria)this;
        }

        public Criteria andSizeGreaterThan(String value) {
            this.addCriterion("size >", value, "size");
            return (Criteria)this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            this.addCriterion("size >=", value, "size");
            return (Criteria)this;
        }

        public Criteria andSizeLessThan(String value) {
            this.addCriterion("size <", value, "size");
            return (Criteria)this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            this.addCriterion("size <=", value, "size");
            return (Criteria)this;
        }

        public Criteria andSizeLike(String value) {
            this.addCriterion("size like", value, "size");
            return (Criteria)this;
        }

        public Criteria andSizeNotLike(String value) {
            this.addCriterion("size not like", value, "size");
            return (Criteria)this;
        }        public Criteria andSizeIn(List<String> values) {
            this.addCriterion("size in", values, "size");
            return (Criteria)this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            this.addCriterion("size not in", values, "size");
            return (Criteria)this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            this.addCriterion("size between", value1, value2, "size");
            return (Criteria)this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            this.addCriterion("size not between", value1, value2, "size");
            return (Criteria)this;
        }

        public Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (Criteria)this;
        }

        public Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (Criteria)this;
        }

        public Criteria andPriceEqualTo(Long value) {
            this.addCriterion("price =", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            this.addCriterion("price <>", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            this.addCriterion("price >", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("price >=", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLessThan(Long value) {
            this.addCriterion("price <", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("price <=", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLike(String value) {
            this.addCriterion("price like", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotLike(String value) {
            this.addCriterion("price not like", value, "price");
            return (Criteria)this;
        }        public Criteria andPriceIn(List<Long> values) {
            this.addCriterion("price in", values, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            this.addCriterion("price not in", values, "price");
            return (Criteria)this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("price not between", value1, value2, "price");
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

        public Criteria andPicUrlIsNull() {
            this.addCriterion("pic_url is null");
            return (Criteria)this;
        }

        public Criteria andPicUrlIsNotNull() {
            this.addCriterion("pic_url is not null");
            return (Criteria)this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("pic_url =", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("pic_url <>", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("pic_url >", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("pic_url >=", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlLessThan(String value) {
            this.addCriterion("pic_url <", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("pic_url <=", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlLike(String value) {
            this.addCriterion("pic_url like", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotLike(String value) {
            this.addCriterion("pic_url not like", value, "picUrl");
            return (Criteria)this;
        }        public Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("pic_url in", values, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("pic_url not in", values, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyIsNull() {
            this.addCriterion("should_pay_money is null");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyIsNotNull() {
            this.addCriterion("should_pay_money is not null");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyEqualTo(Long value) {
            this.addCriterion("should_pay_money =", value, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyNotEqualTo(Long value) {
            this.addCriterion("should_pay_money <>", value, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyGreaterThan(Long value) {
            this.addCriterion("should_pay_money >", value, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("should_pay_money >=", value, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyLessThan(Long value) {
            this.addCriterion("should_pay_money <", value, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("should_pay_money <=", value, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyLike(String value) {
            this.addCriterion("should_pay_money like", value, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyNotLike(String value) {
            this.addCriterion("should_pay_money not like", value, "shouldPayMoney");
            return (Criteria)this;
        }        public Criteria andShouldPayMoneyIn(List<Long> values) {
            this.addCriterion("should_pay_money in", values, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyNotIn(List<Long> values) {
            this.addCriterion("should_pay_money not in", values, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyBetween(Long value1, Long value2) {
            this.addCriterion("should_pay_money between", value1, value2, "shouldPayMoney");
            return (Criteria)this;
        }

        public Criteria andShouldPayMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("should_pay_money not between", value1, value2, "shouldPayMoney");
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

        public Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (Criteria)this;
        }

        public Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (Criteria)this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (Criteria)this;
        }        public Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (Criteria)this;
        }
    }
}
