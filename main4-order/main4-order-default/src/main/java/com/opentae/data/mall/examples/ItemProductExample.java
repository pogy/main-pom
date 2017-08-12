package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemProductExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public ItemProductExample() {
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

        public Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (Criteria)this;
        }

        public Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (Criteria)this;
        }

        public Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (Criteria)this;
        }        public Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
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

        public Criteria andShopNumIsNull() {
            this.addCriterion("shop_num is null");
            return (Criteria)this;
        }

        public Criteria andShopNumIsNotNull() {
            this.addCriterion("shop_num is not null");
            return (Criteria)this;
        }

        public Criteria andShopNumEqualTo(String value) {
            this.addCriterion("shop_num =", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotEqualTo(String value) {
            this.addCriterion("shop_num <>", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumGreaterThan(String value) {
            this.addCriterion("shop_num >", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_num >=", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumLessThan(String value) {
            this.addCriterion("shop_num <", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumLessThanOrEqualTo(String value) {
            this.addCriterion("shop_num <=", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumLike(String value) {
            this.addCriterion("shop_num like", value, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotLike(String value) {
            this.addCriterion("shop_num not like", value, "shopNum");
            return (Criteria)this;
        }        public Criteria andShopNumIn(List<String> values) {
            this.addCriterion("shop_num in", values, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotIn(List<String> values) {
            this.addCriterion("shop_num not in", values, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumBetween(String value1, String value2) {
            this.addCriterion("shop_num between", value1, value2, "shopNum");
            return (Criteria)this;
        }

        public Criteria andShopNumNotBetween(String value1, String value2) {
            this.addCriterion("shop_num not between", value1, value2, "shopNum");
            return (Criteria)this;
        }

        public Criteria andMarketNameIsNull() {
            this.addCriterion("market_name is null");
            return (Criteria)this;
        }

        public Criteria andMarketNameIsNotNull() {
            this.addCriterion("market_name is not null");
            return (Criteria)this;
        }

        public Criteria andMarketNameEqualTo(String value) {
            this.addCriterion("market_name =", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotEqualTo(String value) {
            this.addCriterion("market_name <>", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameGreaterThan(String value) {
            this.addCriterion("market_name >", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_name >=", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameLessThan(String value) {
            this.addCriterion("market_name <", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("market_name <=", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameLike(String value) {
            this.addCriterion("market_name like", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotLike(String value) {
            this.addCriterion("market_name not like", value, "marketName");
            return (Criteria)this;
        }        public Criteria andMarketNameIn(List<String> values) {
            this.addCriterion("market_name in", values, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotIn(List<String> values) {
            this.addCriterion("market_name not in", values, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameBetween(String value1, String value2) {
            this.addCriterion("market_name between", value1, value2, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("market_name not between", value1, value2, "marketName");
            return (Criteria)this;
        }

        public Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (Criteria)this;
        }

        public Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (Criteria)this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (Criteria)this;
        }        public Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
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

        public Criteria andFloorIdIsNull() {
            this.addCriterion("floor_id is null");
            return (Criteria)this;
        }

        public Criteria andFloorIdIsNotNull() {
            this.addCriterion("floor_id is not null");
            return (Criteria)this;
        }

        public Criteria andFloorIdEqualTo(Long value) {
            this.addCriterion("floor_id =", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotEqualTo(Long value) {
            this.addCriterion("floor_id <>", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdGreaterThan(Long value) {
            this.addCriterion("floor_id >", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("floor_id >=", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdLessThan(Long value) {
            this.addCriterion("floor_id <", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdLessThanOrEqualTo(Long value) {
            this.addCriterion("floor_id <=", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdLike(String value) {
            this.addCriterion("floor_id like", value, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotLike(String value) {
            this.addCriterion("floor_id not like", value, "floorId");
            return (Criteria)this;
        }        public Criteria andFloorIdIn(List<Long> values) {
            this.addCriterion("floor_id in", values, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotIn(List<Long> values) {
            this.addCriterion("floor_id not in", values, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdBetween(Long value1, Long value2) {
            this.addCriterion("floor_id between", value1, value2, "floorId");
            return (Criteria)this;
        }

        public Criteria andFloorIdNotBetween(Long value1, Long value2) {
            this.addCriterion("floor_id not between", value1, value2, "floorId");
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

        public Criteria andFloorIsNull() {
            this.addCriterion("floor is null");
            return (Criteria)this;
        }

        public Criteria andFloorIsNotNull() {
            this.addCriterion("floor is not null");
            return (Criteria)this;
        }

        public Criteria andFloorEqualTo(String value) {
            this.addCriterion("floor =", value, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorNotEqualTo(String value) {
            this.addCriterion("floor <>", value, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorGreaterThan(String value) {
            this.addCriterion("floor >", value, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            this.addCriterion("floor >=", value, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorLessThan(String value) {
            this.addCriterion("floor <", value, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            this.addCriterion("floor <=", value, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorLike(String value) {
            this.addCriterion("floor like", value, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorNotLike(String value) {
            this.addCriterion("floor not like", value, "floor");
            return (Criteria)this;
        }        public Criteria andFloorIn(List<String> values) {
            this.addCriterion("floor in", values, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorNotIn(List<String> values) {
            this.addCriterion("floor not in", values, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorBetween(String value1, String value2) {
            this.addCriterion("floor between", value1, value2, "floor");
            return (Criteria)this;
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            this.addCriterion("floor not between", value1, value2, "floor");
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
    }
}
