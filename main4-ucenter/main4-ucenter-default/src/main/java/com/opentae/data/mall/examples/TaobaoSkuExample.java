package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class TaobaoSkuExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<TaobaoSkuExample.Criteria> oredCriteria = new ArrayList();

    public TaobaoSkuExample() {
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

    public List<TaobaoSkuExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(TaobaoSkuExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public TaobaoSkuExample.Criteria or() {
        TaobaoSkuExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public TaobaoSkuExample.Criteria createCriteria() {
        TaobaoSkuExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected TaobaoSkuExample.Criteria createCriteriaInternal() {
        TaobaoSkuExample.Criteria criteria = new TaobaoSkuExample.Criteria();
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

    public static class Criteria extends TaobaoSkuExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<TaobaoSkuExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<TaobaoSkuExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<TaobaoSkuExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new TaobaoSkuExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new TaobaoSkuExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new TaobaoSkuExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public TaobaoSkuExample.Criteria andTbSkuIdIsNull() {
            this.addCriterion("tb_sku_id is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdIsNotNull() {
            this.addCriterion("tb_sku_id is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdEqualTo(Long value) {
            this.addCriterion("tb_sku_id =", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdNotEqualTo(Long value) {
            this.addCriterion("tb_sku_id <>", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdGreaterThan(Long value) {
            this.addCriterion("tb_sku_id >", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("tb_sku_id >=", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdLessThan(Long value) {
            this.addCriterion("tb_sku_id <", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdLessThanOrEqualTo(Long value) {
            this.addCriterion("tb_sku_id <=", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdLike(String value) {
            this.addCriterion("tb_sku_id like", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdNotLike(String value) {
            this.addCriterion("tb_sku_id not like", value, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andTbSkuIdIn(List<Long> values) {
            this.addCriterion("tb_sku_id in", values, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdNotIn(List<Long> values) {
            this.addCriterion("tb_sku_id not in", values, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdBetween(Long value1, Long value2) {
            this.addCriterion("tb_sku_id between", value1, value2, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andTbSkuIdNotBetween(Long value1, Long value2) {
            this.addCriterion("tb_sku_id not between", value1, value2, "tbSkuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameIsNull() {
            this.addCriterion("properties_name is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameIsNotNull() {
            this.addCriterion("properties_name is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameEqualTo(String value) {
            this.addCriterion("properties_name =", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotEqualTo(String value) {
            this.addCriterion("properties_name <>", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameGreaterThan(String value) {
            this.addCriterion("properties_name >", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("properties_name >=", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameLessThan(String value) {
            this.addCriterion("properties_name <", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameLessThanOrEqualTo(String value) {
            this.addCriterion("properties_name <=", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameLike(String value) {
            this.addCriterion("properties_name like", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotLike(String value) {
            this.addCriterion("properties_name not like", value, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andPropertiesNameIn(List<String> values) {
            this.addCriterion("properties_name in", values, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotIn(List<String> values) {
            this.addCriterion("properties_name not in", values, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameBetween(String value1, String value2) {
            this.addCriterion("properties_name between", value1, value2, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNameNotBetween(String value1, String value2) {
            this.addCriterion("properties_name not between", value1, value2, "propertiesName");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityIsNull() {
            this.addCriterion("with_hold_quantity is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityIsNotNull() {
            this.addCriterion("with_hold_quantity is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityEqualTo(Long value) {
            this.addCriterion("with_hold_quantity =", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityNotEqualTo(Long value) {
            this.addCriterion("with_hold_quantity <>", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityGreaterThan(Long value) {
            this.addCriterion("with_hold_quantity >", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityGreaterThanOrEqualTo(Long value) {
            this.addCriterion("with_hold_quantity >=", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityLessThan(Long value) {
            this.addCriterion("with_hold_quantity <", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityLessThanOrEqualTo(Long value) {
            this.addCriterion("with_hold_quantity <=", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityLike(String value) {
            this.addCriterion("with_hold_quantity like", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityNotLike(String value) {
            this.addCriterion("with_hold_quantity not like", value, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andWithHoldQuantityIn(List<Long> values) {
            this.addCriterion("with_hold_quantity in", values, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityNotIn(List<Long> values) {
            this.addCriterion("with_hold_quantity not in", values, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityBetween(Long value1, Long value2) {
            this.addCriterion("with_hold_quantity between", value1, value2, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andWithHoldQuantityNotBetween(Long value1, Long value2) {
            this.addCriterion("with_hold_quantity not between", value1, value2, "withHoldQuantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdIsNull() {
            this.addCriterion("outer_id is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdIsNotNull() {
            this.addCriterion("outer_id is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdEqualTo(String value) {
            this.addCriterion("outer_id =", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdNotEqualTo(String value) {
            this.addCriterion("outer_id <>", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdGreaterThan(String value) {
            this.addCriterion("outer_id >", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("outer_id >=", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdLessThan(String value) {
            this.addCriterion("outer_id <", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdLessThanOrEqualTo(String value) {
            this.addCriterion("outer_id <=", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdLike(String value) {
            this.addCriterion("outer_id like", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdNotLike(String value) {
            this.addCriterion("outer_id not like", value, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andOuterIdIn(List<String> values) {
            this.addCriterion("outer_id in", values, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdNotIn(List<String> values) {
            this.addCriterion("outer_id not in", values, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdBetween(String value1, String value2) {
            this.addCriterion("outer_id between", value1, value2, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andOuterIdNotBetween(String value1, String value2) {
            this.addCriterion("outer_id not between", value1, value2, "outerId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeIsNull() {
            this.addCriterion("barcode is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeIsNotNull() {
            this.addCriterion("barcode is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeEqualTo(String value) {
            this.addCriterion("barcode =", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeNotEqualTo(String value) {
            this.addCriterion("barcode <>", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeGreaterThan(String value) {
            this.addCriterion("barcode >", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("barcode >=", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeLessThan(String value) {
            this.addCriterion("barcode <", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeLessThanOrEqualTo(String value) {
            this.addCriterion("barcode <=", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeLike(String value) {
            this.addCriterion("barcode like", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeNotLike(String value) {
            this.addCriterion("barcode not like", value, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andBarcodeIn(List<String> values) {
            this.addCriterion("barcode in", values, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeNotIn(List<String> values) {
            this.addCriterion("barcode not in", values, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeBetween(String value1, String value2) {
            this.addCriterion("barcode between", value1, value2, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andBarcodeNotBetween(String value1, String value2) {
            this.addCriterion("barcode not between", value1, value2, "barcode");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdIsNull() {
            this.addCriterion("sku_id is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdIsNotNull() {
            this.addCriterion("sku_id is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdEqualTo(Long value) {
            this.addCriterion("sku_id =", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdNotEqualTo(Long value) {
            this.addCriterion("sku_id <>", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdGreaterThan(Long value) {
            this.addCriterion("sku_id >", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sku_id >=", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdLessThan(Long value) {
            this.addCriterion("sku_id <", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sku_id <=", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdLike(String value) {
            this.addCriterion("sku_id like", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdNotLike(String value) {
            this.addCriterion("sku_id not like", value, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andSkuIdIn(List<Long> values) {
            this.addCriterion("sku_id in", values, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdNotIn(List<Long> values) {
            this.addCriterion("sku_id not in", values, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            this.addCriterion("sku_id between", value1, value2, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sku_id not between", value1, value2, "skuId");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidIsNull() {
            this.addCriterion("iid is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidIsNotNull() {
            this.addCriterion("iid is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidEqualTo(String value) {
            this.addCriterion("iid =", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidNotEqualTo(String value) {
            this.addCriterion("iid <>", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidGreaterThan(String value) {
            this.addCriterion("iid >", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidGreaterThanOrEqualTo(String value) {
            this.addCriterion("iid >=", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidLessThan(String value) {
            this.addCriterion("iid <", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidLessThanOrEqualTo(String value) {
            this.addCriterion("iid <=", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidLike(String value) {
            this.addCriterion("iid like", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidNotLike(String value) {
            this.addCriterion("iid not like", value, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andIidIn(List<String> values) {
            this.addCriterion("iid in", values, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidNotIn(List<String> values) {
            this.addCriterion("iid not in", values, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidBetween(String value1, String value2) {
            this.addCriterion("iid between", value1, value2, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andIidNotBetween(String value1, String value2) {
            this.addCriterion("iid not between", value1, value2, "iid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidIsNull() {
            this.addCriterion("num_iid is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidIsNotNull() {
            this.addCriterion("num_iid is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidEqualTo(Long value) {
            this.addCriterion("num_iid =", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidNotEqualTo(Long value) {
            this.addCriterion("num_iid <>", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidGreaterThan(Long value) {
            this.addCriterion("num_iid >", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num_iid >=", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidLessThan(Long value) {
            this.addCriterion("num_iid <", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            this.addCriterion("num_iid <=", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidLike(String value) {
            this.addCriterion("num_iid like", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidNotLike(String value) {
            this.addCriterion("num_iid not like", value, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andNumIidIn(List<Long> values) {
            this.addCriterion("num_iid in", values, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidNotIn(List<Long> values) {
            this.addCriterion("num_iid not in", values, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidBetween(Long value1, Long value2) {
            this.addCriterion("num_iid between", value1, value2, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            this.addCriterion("num_iid not between", value1, value2, "numIid");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesIsNull() {
            this.addCriterion("properties is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesIsNotNull() {
            this.addCriterion("properties is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesEqualTo(String value) {
            this.addCriterion("properties =", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNotEqualTo(String value) {
            this.addCriterion("properties <>", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesGreaterThan(String value) {
            this.addCriterion("properties >", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesGreaterThanOrEqualTo(String value) {
            this.addCriterion("properties >=", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesLessThan(String value) {
            this.addCriterion("properties <", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesLessThanOrEqualTo(String value) {
            this.addCriterion("properties <=", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesLike(String value) {
            this.addCriterion("properties like", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNotLike(String value) {
            this.addCriterion("properties not like", value, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andPropertiesIn(List<String> values) {
            this.addCriterion("properties in", values, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNotIn(List<String> values) {
            this.addCriterion("properties not in", values, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesBetween(String value1, String value2) {
            this.addCriterion("properties between", value1, value2, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPropertiesNotBetween(String value1, String value2) {
            this.addCriterion("properties not between", value1, value2, "properties");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityIsNull() {
            this.addCriterion("quantity is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityIsNotNull() {
            this.addCriterion("quantity is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityEqualTo(Long value) {
            this.addCriterion("quantity =", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityNotEqualTo(Long value) {
            this.addCriterion("quantity <>", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityGreaterThan(Long value) {
            this.addCriterion("quantity >", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityGreaterThanOrEqualTo(Long value) {
            this.addCriterion("quantity >=", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityLessThan(Long value) {
            this.addCriterion("quantity <", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityLessThanOrEqualTo(Long value) {
            this.addCriterion("quantity <=", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityLike(String value) {
            this.addCriterion("quantity like", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityNotLike(String value) {
            this.addCriterion("quantity not like", value, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andQuantityIn(List<Long> values) {
            this.addCriterion("quantity in", values, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityNotIn(List<Long> values) {
            this.addCriterion("quantity not in", values, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityBetween(Long value1, Long value2) {
            this.addCriterion("quantity between", value1, value2, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andQuantityNotBetween(Long value1, Long value2) {
            this.addCriterion("quantity not between", value1, value2, "quantity");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceEqualTo(String value) {
            this.addCriterion("price =", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceNotEqualTo(String value) {
            this.addCriterion("price <>", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceGreaterThan(String value) {
            this.addCriterion("price >", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceGreaterThanOrEqualTo(String value) {
            this.addCriterion("price >=", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceLessThan(String value) {
            this.addCriterion("price <", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceLessThanOrEqualTo(String value) {
            this.addCriterion("price <=", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceLike(String value) {
            this.addCriterion("price like", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceNotLike(String value) {
            this.addCriterion("price not like", value, "price");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andPriceIn(List<String> values) {
            this.addCriterion("price in", values, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceNotIn(List<String> values) {
            this.addCriterion("price not in", values, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceBetween(String value1, String value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andPriceNotBetween(String value1, String value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedIsNull() {
            this.addCriterion("created is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedIsNotNull() {
            this.addCriterion("created is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedEqualTo(String value) {
            this.addCriterion("created =", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedNotEqualTo(String value) {
            this.addCriterion("created <>", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedGreaterThan(String value) {
            this.addCriterion("created >", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedGreaterThanOrEqualTo(String value) {
            this.addCriterion("created >=", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedLessThan(String value) {
            this.addCriterion("created <", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedLessThanOrEqualTo(String value) {
            this.addCriterion("created <=", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedLike(String value) {
            this.addCriterion("created like", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedNotLike(String value) {
            this.addCriterion("created not like", value, "created");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andCreatedIn(List<String> values) {
            this.addCriterion("created in", values, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedNotIn(List<String> values) {
            this.addCriterion("created not in", values, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedBetween(String value1, String value2) {
            this.addCriterion("created between", value1, value2, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andCreatedNotBetween(String value1, String value2) {
            this.addCriterion("created not between", value1, value2, "created");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedIsNull() {
            this.addCriterion("modified is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedIsNotNull() {
            this.addCriterion("modified is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedEqualTo(String value) {
            this.addCriterion("modified =", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedNotEqualTo(String value) {
            this.addCriterion("modified <>", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedGreaterThan(String value) {
            this.addCriterion("modified >", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedGreaterThanOrEqualTo(String value) {
            this.addCriterion("modified >=", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedLessThan(String value) {
            this.addCriterion("modified <", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedLessThanOrEqualTo(String value) {
            this.addCriterion("modified <=", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedLike(String value) {
            this.addCriterion("modified like", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedNotLike(String value) {
            this.addCriterion("modified not like", value, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andModifiedIn(List<String> values) {
            this.addCriterion("modified in", values, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedNotIn(List<String> values) {
            this.addCriterion("modified not in", values, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedBetween(String value1, String value2) {
            this.addCriterion("modified between", value1, value2, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andModifiedNotBetween(String value1, String value2) {
            this.addCriterion("modified not between", value1, value2, "modified");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }        public TaobaoSkuExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }

        public TaobaoSkuExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (TaobaoSkuExample.Criteria)this;
        }
    }
}
