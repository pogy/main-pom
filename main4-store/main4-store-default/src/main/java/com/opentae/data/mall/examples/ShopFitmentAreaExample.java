package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShopFitmentAreaExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShopFitmentAreaExample.Criteria> oredCriteria = new ArrayList();

    public ShopFitmentAreaExample() {
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

    public List<ShopFitmentAreaExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShopFitmentAreaExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShopFitmentAreaExample.Criteria or() {
        ShopFitmentAreaExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShopFitmentAreaExample.Criteria createCriteria() {
        ShopFitmentAreaExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShopFitmentAreaExample.Criteria createCriteriaInternal() {
        ShopFitmentAreaExample.Criteria criteria = new ShopFitmentAreaExample.Criteria();
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

    public static class Criteria extends ShopFitmentAreaExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShopFitmentAreaExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShopFitmentAreaExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShopFitmentAreaExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShopFitmentAreaExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShopFitmentAreaExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShopFitmentAreaExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShopFitmentAreaExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }        public ShopFitmentAreaExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdIsNull() {
            this.addCriterion("page_id is null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdIsNotNull() {
            this.addCriterion("page_id is not null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdEqualTo(Long value) {
            this.addCriterion("page_id =", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdNotEqualTo(Long value) {
            this.addCriterion("page_id <>", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdGreaterThan(Long value) {
            this.addCriterion("page_id >", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("page_id >=", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdLessThan(Long value) {
            this.addCriterion("page_id <", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("page_id <=", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdLike(String value) {
            this.addCriterion("page_id like", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdNotLike(String value) {
            this.addCriterion("page_id not like", value, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }        public ShopFitmentAreaExample.Criteria andPageIdIn(List<Long> values) {
            this.addCriterion("page_id in", values, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdNotIn(List<Long> values) {
            this.addCriterion("page_id not in", values, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdBetween(Long value1, Long value2) {
            this.addCriterion("page_id between", value1, value2, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andPageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("page_id not between", value1, value2, "pageId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelIsNull() {
            this.addCriterion("can_del is null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelIsNotNull() {
            this.addCriterion("can_del is not null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelEqualTo(Boolean value) {
            this.addCriterion("can_del =", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelNotEqualTo(Boolean value) {
            this.addCriterion("can_del <>", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelGreaterThan(Boolean value) {
            this.addCriterion("can_del >", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("can_del >=", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelLessThan(Boolean value) {
            this.addCriterion("can_del <", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelLessThanOrEqualTo(Boolean value) {
            this.addCriterion("can_del <=", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelLike(String value) {
            this.addCriterion("can_del like", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelNotLike(String value) {
            this.addCriterion("can_del not like", value, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }        public ShopFitmentAreaExample.Criteria andCanDelIn(List<Boolean> values) {
            this.addCriterion("can_del in", values, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelNotIn(List<Boolean> values) {
            this.addCriterion("can_del not in", values, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelBetween(Boolean value1, Boolean value2) {
            this.addCriterion("can_del between", value1, value2, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andCanDelNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("can_del not between", value1, value2, "canDel");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdIsNull() {
            this.addCriterion("after_area_id is null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdIsNotNull() {
            this.addCriterion("after_area_id is not null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdEqualTo(Long value) {
            this.addCriterion("after_area_id =", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdNotEqualTo(Long value) {
            this.addCriterion("after_area_id <>", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdGreaterThan(Long value) {
            this.addCriterion("after_area_id >", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("after_area_id >=", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdLessThan(Long value) {
            this.addCriterion("after_area_id <", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdLessThanOrEqualTo(Long value) {
            this.addCriterion("after_area_id <=", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdLike(String value) {
            this.addCriterion("after_area_id like", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdNotLike(String value) {
            this.addCriterion("after_area_id not like", value, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }        public ShopFitmentAreaExample.Criteria andAfterAreaIdIn(List<Long> values) {
            this.addCriterion("after_area_id in", values, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdNotIn(List<Long> values) {
            this.addCriterion("after_area_id not in", values, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdBetween(Long value1, Long value2) {
            this.addCriterion("after_area_id between", value1, value2, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdNotBetween(Long value1, Long value2) {
            this.addCriterion("after_area_id not between", value1, value2, "afterAreaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdIsNull() {
            this.addCriterion("area_id is null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdIsNotNull() {
            this.addCriterion("area_id is not null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdEqualTo(Long value) {
            this.addCriterion("area_id =", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdNotEqualTo(Long value) {
            this.addCriterion("area_id <>", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdGreaterThan(Long value) {
            this.addCriterion("area_id >", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("area_id >=", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdLessThan(Long value) {
            this.addCriterion("area_id <", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdLessThanOrEqualTo(Long value) {
            this.addCriterion("area_id <=", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdLike(String value) {
            this.addCriterion("area_id like", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdNotLike(String value) {
            this.addCriterion("area_id not like", value, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }        public ShopFitmentAreaExample.Criteria andAreaIdIn(List<Long> values) {
            this.addCriterion("area_id in", values, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdNotIn(List<Long> values) {
            this.addCriterion("area_id not in", values, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdBetween(Long value1, Long value2) {
            this.addCriterion("area_id between", value1, value2, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaIdNotBetween(Long value1, Long value2) {
            this.addCriterion("area_id not between", value1, value2, "areaId");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeIsNull() {
            this.addCriterion("area_type is null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeIsNotNull() {
            this.addCriterion("area_type is not null");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeEqualTo(Integer value) {
            this.addCriterion("area_type =", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeNotEqualTo(Integer value) {
            this.addCriterion("area_type <>", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeGreaterThan(Integer value) {
            this.addCriterion("area_type >", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("area_type >=", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeLessThan(Integer value) {
            this.addCriterion("area_type <", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("area_type <=", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeLike(String value) {
            this.addCriterion("area_type like", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeNotLike(String value) {
            this.addCriterion("area_type not like", value, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }        public ShopFitmentAreaExample.Criteria andAreaTypeIn(List<Integer> values) {
            this.addCriterion("area_type in", values, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeNotIn(List<Integer> values) {
            this.addCriterion("area_type not in", values, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("area_type between", value1, value2, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("area_type not between", value1, value2, "areaType");
            return (ShopFitmentAreaExample.Criteria)this;
        }
    }
}
