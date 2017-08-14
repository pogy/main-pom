package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemCartExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andCartIdIsNull() {
            this.addCriterion("cart_id is null");
            return (Criteria)this;
        }

        public Criteria andCartIdIsNotNull() {
            this.addCriterion("cart_id is not null");
            return (Criteria)this;
        }

        public Criteria andCartIdEqualTo(Long value) {
            this.addCriterion("cart_id =", value, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdNotEqualTo(Long value) {
            this.addCriterion("cart_id <>", value, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdGreaterThan(Long value) {
            this.addCriterion("cart_id >", value, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cart_id >=", value, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdLessThan(Long value) {
            this.addCriterion("cart_id <", value, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cart_id <=", value, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdLike(String value) {
            this.addCriterion("cart_id like", value, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdNotLike(String value) {
            this.addCriterion("cart_id not like", value, "cartId");
            return (Criteria)this;
        }        public Criteria andCartIdIn(List<Long> values) {
            this.addCriterion("cart_id in", values, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdNotIn(List<Long> values) {
            this.addCriterion("cart_id not in", values, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdBetween(Long value1, Long value2) {
            this.addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria)this;
        }

        public Criteria andCartIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cart_id not between", value1, value2, "cartId");
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

        public Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (Criteria)this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (Criteria)this;
        }        public Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
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
