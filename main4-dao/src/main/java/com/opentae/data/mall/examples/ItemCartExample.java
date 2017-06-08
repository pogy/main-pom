package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemCartExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemCartExample.Criteria> oredCriteria = new ArrayList();

    public ItemCartExample() {
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

    public List<ItemCartExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemCartExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemCartExample.Criteria or() {
        ItemCartExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemCartExample.Criteria createCriteria() {
        ItemCartExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemCartExample.Criteria createCriteriaInternal() {
        ItemCartExample.Criteria criteria = new ItemCartExample.Criteria();
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

    public static class Criteria extends ItemCartExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemCartExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemCartExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemCartExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemCartExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemCartExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemCartExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemCartExample.Criteria andCartIdIsNull() {
            this.addCriterion("cartId is null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdIsNotNull() {
            this.addCriterion("cartId is not null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdEqualTo(Long value) {
            this.addCriterion("cartId =", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdNotEqualTo(Long value) {
            this.addCriterion("cartId <>", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdGreaterThan(Long value) {
            this.addCriterion("cartId >", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cartId >=", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdLessThan(Long value) {
            this.addCriterion("cartId <", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cartId <=", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdLike(String value) {
            this.addCriterion("cartId like", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdNotLike(String value) {
            this.addCriterion("cartId not like", value, "cart_id");
            return (ItemCartExample.Criteria)this;
        }        public ItemCartExample.Criteria andCartIdIn(List<Long> values) {
            this.addCriterion("cartId in", values, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdNotIn(List<Long> values) {
            this.addCriterion("cartId not in", values, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdBetween(Long value1, Long value2) {
            this.addCriterion("cartId between", value1, value2, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andCartIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cartId not between", value1, value2, "cart_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdIsNull() {
            this.addCriterion("shopId is null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shopId is not null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shopId =", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shopId <>", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shopId >", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shopId >=", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shopId <", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shopId <=", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shopId like", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shopId not like", value, "shop_id");
            return (ItemCartExample.Criteria)this;
        }        public ItemCartExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shopId in", values, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shopId not in", values, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shopId between", value1, value2, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shopId not between", value1, value2, "shop_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdIsNull() {
            this.addCriterion("userId is null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("userId is not null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("userId =", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("userId <>", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("userId >", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("userId >=", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("userId <", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("userId <=", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdLike(String value) {
            this.addCriterion("userId like", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("userId not like", value, "user_id");
            return (ItemCartExample.Criteria)this;
        }        public ItemCartExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("userId in", values, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("userId not in", values, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("userId between", value1, value2, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("userId not between", value1, value2, "user_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumEqualTo(Integer value) {
            this.addCriterion("num =", value, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumNotEqualTo(Integer value) {
            this.addCriterion("num <>", value, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumGreaterThan(Integer value) {
            this.addCriterion("num >", value, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("num >=", value, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumLessThan(Integer value) {
            this.addCriterion("num <", value, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("num <=", value, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (ItemCartExample.Criteria)this;
        }        public ItemCartExample.Criteria andNumIn(List<Integer> values) {
            this.addCriterion("num in", values, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumNotIn(List<Integer> values) {
            this.addCriterion("num not in", values, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumBetween(Integer value1, Integer value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidIsNull() {
            this.addCriterion("pid is null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidIsNotNull() {
            this.addCriterion("pid is not null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidEqualTo(Long value) {
            this.addCriterion("pid =", value, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidNotEqualTo(Long value) {
            this.addCriterion("pid <>", value, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidGreaterThan(Long value) {
            this.addCriterion("pid >", value, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pid >=", value, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidLessThan(Long value) {
            this.addCriterion("pid <", value, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidLessThanOrEqualTo(Long value) {
            this.addCriterion("pid <=", value, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidLike(String value) {
            this.addCriterion("pid like", value, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidNotLike(String value) {
            this.addCriterion("pid not like", value, "pid");
            return (ItemCartExample.Criteria)this;
        }        public ItemCartExample.Criteria andPidIn(List<Long> values) {
            this.addCriterion("pid in", values, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidNotIn(List<Long> values) {
            this.addCriterion("pid not in", values, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidBetween(Long value1, Long value2) {
            this.addCriterion("pid between", value1, value2, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andPidNotBetween(Long value1, Long value2) {
            this.addCriterion("pid not between", value1, value2, "pid");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdIsNull() {
            this.addCriterion("skuId is null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdIsNotNull() {
            this.addCriterion("skuId is not null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdEqualTo(Long value) {
            this.addCriterion("skuId =", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdNotEqualTo(Long value) {
            this.addCriterion("skuId <>", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdGreaterThan(Long value) {
            this.addCriterion("skuId >", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("skuId >=", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdLessThan(Long value) {
            this.addCriterion("skuId <", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            this.addCriterion("skuId <=", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdLike(String value) {
            this.addCriterion("skuId like", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdNotLike(String value) {
            this.addCriterion("skuId not like", value, "sku_id");
            return (ItemCartExample.Criteria)this;
        }        public ItemCartExample.Criteria andSkuIdIn(List<Long> values) {
            this.addCriterion("skuId in", values, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdNotIn(List<Long> values) {
            this.addCriterion("skuId not in", values, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            this.addCriterion("skuId between", value1, value2, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            this.addCriterion("skuId not between", value1, value2, "sku_id");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteIsNull() {
            this.addCriterion("webSite is null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("webSite is not null");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("webSite =", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("webSite <>", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("webSite >", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("webSite >=", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("webSite <", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("webSite <=", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("webSite like", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("webSite not like", value, "web_site");
            return (ItemCartExample.Criteria)this;
        }        public ItemCartExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("webSite in", values, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("webSite not in", values, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("webSite between", value1, value2, "web_site");
            return (ItemCartExample.Criteria)this;
        }

        public ItemCartExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("webSite not between", value1, value2, "web_site");
            return (ItemCartExample.Criteria)this;
        }
    }
}
