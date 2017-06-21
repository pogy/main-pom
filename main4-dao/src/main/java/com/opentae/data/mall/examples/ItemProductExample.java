package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemProductExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemProductExample.Criteria> oredCriteria = new ArrayList();

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

    public List<ItemProductExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemProductExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemProductExample.Criteria or() {
        ItemProductExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemProductExample.Criteria createCriteria() {
        ItemProductExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemProductExample.Criteria createCriteriaInternal() {
        ItemProductExample.Criteria criteria = new ItemProductExample.Criteria();
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

    public static class Criteria extends ItemProductExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemProductExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemProductExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemProductExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemProductExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemProductExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemProductExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemProductExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightIsNull() {
            this.addCriterion("weight is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightIsNotNull() {
            this.addCriterion("weight is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightEqualTo(Long value) {
            this.addCriterion("weight =", value, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightNotEqualTo(Long value) {
            this.addCriterion("weight <>", value, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightGreaterThan(Long value) {
            this.addCriterion("weight >", value, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightGreaterThanOrEqualTo(Long value) {
            this.addCriterion("weight >=", value, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightLessThan(Long value) {
            this.addCriterion("weight <", value, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightLessThanOrEqualTo(Long value) {
            this.addCriterion("weight <=", value, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightLike(String value) {
            this.addCriterion("weight like", value, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightNotLike(String value) {
            this.addCriterion("weight not like", value, "weight");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andWeightIn(List<Long> values) {
            this.addCriterion("weight in", values, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightNotIn(List<Long> values) {
            this.addCriterion("weight not in", values, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightBetween(Long value1, Long value2) {
            this.addCriterion("weight between", value1, value2, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWeightNotBetween(Long value1, Long value2) {
            this.addCriterion("weight not between", value1, value2, "weight");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidIsNull() {
            this.addCriterion("pid is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidIsNotNull() {
            this.addCriterion("pid is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidEqualTo(Long value) {
            this.addCriterion("pid =", value, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidNotEqualTo(Long value) {
            this.addCriterion("pid <>", value, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidGreaterThan(Long value) {
            this.addCriterion("pid >", value, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pid >=", value, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidLessThan(Long value) {
            this.addCriterion("pid <", value, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidLessThanOrEqualTo(Long value) {
            this.addCriterion("pid <=", value, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidLike(String value) {
            this.addCriterion("pid like", value, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidNotLike(String value) {
            this.addCriterion("pid not like", value, "pid");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andPidIn(List<Long> values) {
            this.addCriterion("pid in", values, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidNotIn(List<Long> values) {
            this.addCriterion("pid not in", values, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidBetween(Long value1, Long value2) {
            this.addCriterion("pid between", value1, value2, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPidNotBetween(Long value1, Long value2) {
            this.addCriterion("pid not between", value1, value2, "pid");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumIsNull() {
            this.addCriterion("shop_num is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumIsNotNull() {
            this.addCriterion("shop_num is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumEqualTo(String value) {
            this.addCriterion("shop_num =", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumNotEqualTo(String value) {
            this.addCriterion("shop_num <>", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumGreaterThan(String value) {
            this.addCriterion("shop_num >", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_num >=", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumLessThan(String value) {
            this.addCriterion("shop_num <", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            this.addCriterion("shop_num <=", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumLike(String value) {
            this.addCriterion("shop_num like", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumNotLike(String value) {
            this.addCriterion("shop_num not like", value, "shopNum");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andShopNumIn(List<String> values) {
            this.addCriterion("shop_num in", values, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumNotIn(List<String> values) {
            this.addCriterion("shop_num not in", values, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumBetween(String value1, String value2) {
            this.addCriterion("shop_num between", value1, value2, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopNumNotBetween(String value1, String value2) {
            this.addCriterion("shop_num not between", value1, value2, "shopNum");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameIsNull() {
            this.addCriterion("market_name is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameIsNotNull() {
            this.addCriterion("market_name is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameEqualTo(String value) {
            this.addCriterion("market_name =", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameNotEqualTo(String value) {
            this.addCriterion("market_name <>", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameGreaterThan(String value) {
            this.addCriterion("market_name >", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_name >=", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameLessThan(String value) {
            this.addCriterion("market_name <", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("market_name <=", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameLike(String value) {
            this.addCriterion("market_name like", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameNotLike(String value) {
            this.addCriterion("market_name not like", value, "marketName");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andMarketNameIn(List<String> values) {
            this.addCriterion("market_name in", values, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameNotIn(List<String> values) {
            this.addCriterion("market_name not in", values, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameBetween(String value1, String value2) {
            this.addCriterion("market_name between", value1, value2, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("market_name not between", value1, value2, "marketName");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceEqualTo(Long value) {
            this.addCriterion("price =", value, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceNotEqualTo(Long value) {
            this.addCriterion("price <>", value, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceGreaterThan(Long value) {
            this.addCriterion("price >", value, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("price >=", value, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceLessThan(Long value) {
            this.addCriterion("price <", value, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("price <=", value, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceLike(String value) {
            this.addCriterion("price like", value, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceNotLike(String value) {
            this.addCriterion("price not like", value, "price");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andPriceIn(List<Long> values) {
            this.addCriterion("price in", values, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceNotIn(List<Long> values) {
            this.addCriterion("price not in", values, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceBetween(Long value1, Long value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdIsNull() {
            this.addCriterion("floor_id is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdIsNotNull() {
            this.addCriterion("floor_id is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdEqualTo(Long value) {
            this.addCriterion("floor_id =", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdNotEqualTo(Long value) {
            this.addCriterion("floor_id <>", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdGreaterThan(Long value) {
            this.addCriterion("floor_id >", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("floor_id >=", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdLessThan(Long value) {
            this.addCriterion("floor_id <", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            this.addCriterion("floor_id <=", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdLike(String value) {
            this.addCriterion("floor_id like", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdNotLike(String value) {
            this.addCriterion("floor_id not like", value, "floorId");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andFloorIdIn(List<Long> values) {
            this.addCriterion("floor_id in", values, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdNotIn(List<Long> values) {
            this.addCriterion("floor_id not in", values, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            this.addCriterion("floor_id between", value1, value2, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            this.addCriterion("floor_id not between", value1, value2, "floorId");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlIsNull() {
            this.addCriterion("pic_url is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlIsNotNull() {
            this.addCriterion("pic_url is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("pic_url =", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("pic_url <>", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("pic_url >", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("pic_url >=", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlLessThan(String value) {
            this.addCriterion("pic_url <", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("pic_url <=", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlLike(String value) {
            this.addCriterion("pic_url like", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlNotLike(String value) {
            this.addCriterion("pic_url not like", value, "picUrl");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("pic_url in", values, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("pic_url not in", values, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("pic_url between", value1, value2, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("pic_url not between", value1, value2, "picUrl");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIsNull() {
            this.addCriterion("floor is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorIsNotNull() {
            this.addCriterion("floor is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorEqualTo(String value) {
            this.addCriterion("floor =", value, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorNotEqualTo(String value) {
            this.addCriterion("floor <>", value, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorGreaterThan(String value) {
            this.addCriterion("floor >", value, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorGreaterThanOrEqualTo(String value) {
            this.addCriterion("floor >=", value, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorLessThan(String value) {
            this.addCriterion("floor <", value, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorLessThanOrEqualTo(String value) {
            this.addCriterion("floor <=", value, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorLike(String value) {
            this.addCriterion("floor like", value, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorNotLike(String value) {
            this.addCriterion("floor not like", value, "floor");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andFloorIn(List<String> values) {
            this.addCriterion("floor in", values, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorNotIn(List<String> values) {
            this.addCriterion("floor not in", values, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorBetween(String value1, String value2) {
            this.addCriterion("floor between", value1, value2, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andFloorNotBetween(String value1, String value2) {
            this.addCriterion("floor not between", value1, value2, "floor");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ItemProductExample.Criteria)this;
        }        public ItemProductExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ItemProductExample.Criteria)this;
        }

        public ItemProductExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ItemProductExample.Criteria)this;
        }
    }
}
