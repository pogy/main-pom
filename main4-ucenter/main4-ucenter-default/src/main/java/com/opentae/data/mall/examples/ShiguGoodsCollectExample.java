package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguGoodsCollectExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsCollectExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsCollectExample() {
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

    public List<ShiguGoodsCollectExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsCollectExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsCollectExample.Criteria or() {
        ShiguGoodsCollectExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsCollectExample.Criteria createCriteria() {
        ShiguGoodsCollectExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsCollectExample.Criteria createCriteriaInternal() {
        ShiguGoodsCollectExample.Criteria criteria = new ShiguGoodsCollectExample.Criteria();
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

    public static class Criteria extends ShiguGoodsCollectExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsCollectExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsCollectExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsCollectExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsCollectExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsCollectExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsCollectExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdIsNull() {
            this.addCriterion("goods_collect_id is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdIsNotNull() {
            this.addCriterion("goods_collect_id is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdEqualTo(Long value) {
            this.addCriterion("goods_collect_id =", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdNotEqualTo(Long value) {
            this.addCriterion("goods_collect_id <>", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdGreaterThan(Long value) {
            this.addCriterion("goods_collect_id >", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_collect_id >=", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdLessThan(Long value) {
            this.addCriterion("goods_collect_id <", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_collect_id <=", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdLike(String value) {
            this.addCriterion("goods_collect_id like", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdNotLike(String value) {
            this.addCriterion("goods_collect_id not like", value, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdIn(List<Long> values) {
            this.addCriterion("goods_collect_id in", values, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdNotIn(List<Long> values) {
            this.addCriterion("goods_collect_id not in", values, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_collect_id between", value1, value2, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_collect_id not between", value1, value2, "goodsCollectId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusEqualTo(Integer value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusNotEqualTo(Integer value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusGreaterThan(Integer value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusLessThan(Integer value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andUseStatusIn(List<Integer> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusNotIn(List<Integer> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteIsNull() {
            this.addCriterion("website is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteIsNotNull() {
            this.addCriterion("website is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteEqualTo(String value) {
            this.addCriterion("website =", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotEqualTo(String value) {
            this.addCriterion("website <>", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteGreaterThan(String value) {
            this.addCriterion("website >", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("website >=", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteLessThan(String value) {
            this.addCriterion("website <", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteLessThanOrEqualTo(String value) {
            this.addCriterion("website <=", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteLike(String value) {
            this.addCriterion("website like", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotLike(String value) {
            this.addCriterion("website not like", value, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andWebsiteIn(List<String> values) {
            this.addCriterion("website in", values, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotIn(List<String> values) {
            this.addCriterion("website not in", values, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteBetween(String value1, String value2) {
            this.addCriterion("website between", value1, value2, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotBetween(String value1, String value2) {
            this.addCriterion("website not between", value1, value2, "website");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderEqualTo(Integer value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderNotEqualTo(Integer value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderGreaterThan(Integer value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderLessThan(Integer value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andSortOrderIn(List<Integer> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderNotIn(List<Integer> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeIsNull() {
            this.addCriterion("last_time is null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeIsNotNull() {
            this.addCriterion("last_time is not null");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeEqualTo(Date value) {
            this.addCriterion("last_time =", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeNotEqualTo(Date value) {
            this.addCriterion("last_time <>", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeGreaterThan(Date value) {
            this.addCriterion("last_time >", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_time >=", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeLessThan(Date value) {
            this.addCriterion("last_time <", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_time <=", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeLike(String value) {
            this.addCriterion("last_time like", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeNotLike(String value) {
            this.addCriterion("last_time not like", value, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }        public ShiguGoodsCollectExample.Criteria andLastTimeIn(List<Date> values) {
            this.addCriterion("last_time in", values, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeNotIn(List<Date> values) {
            this.addCriterion("last_time not in", values, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_time between", value1, value2, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_time not between", value1, value2, "lastTime");
            return (ShiguGoodsCollectExample.Criteria)this;
        }
    }
}
