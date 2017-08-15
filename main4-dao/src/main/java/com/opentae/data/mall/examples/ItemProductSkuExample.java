package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemProductSkuExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemProductSkuExample.Criteria> oredCriteria = new ArrayList();

    public ItemProductSkuExample() {
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

    public List<ItemProductSkuExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemProductSkuExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemProductSkuExample.Criteria or() {
        ItemProductSkuExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemProductSkuExample.Criteria createCriteria() {
        ItemProductSkuExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemProductSkuExample.Criteria createCriteriaInternal() {
        ItemProductSkuExample.Criteria criteria = new ItemProductSkuExample.Criteria();
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

    public static class Criteria extends ItemProductSkuExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemProductSkuExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemProductSkuExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemProductSkuExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemProductSkuExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemProductSkuExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemProductSkuExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemProductSkuExample.Criteria andColorIsNull() {
            this.addCriterion("color is null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorIsNotNull() {
            this.addCriterion("color is not null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorEqualTo(String value) {
            this.addCriterion("color =", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorNotEqualTo(String value) {
            this.addCriterion("color <>", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorGreaterThan(String value) {
            this.addCriterion("color >", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorGreaterThanOrEqualTo(String value) {
            this.addCriterion("color >=", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorLessThan(String value) {
            this.addCriterion("color <", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorLessThanOrEqualTo(String value) {
            this.addCriterion("color <=", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorLike(String value) {
            this.addCriterion("color like", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorNotLike(String value) {
            this.addCriterion("color not like", value, "color");
            return (ItemProductSkuExample.Criteria)this;
        }        public ItemProductSkuExample.Criteria andColorIn(List<String> values) {
            this.addCriterion("color in", values, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorNotIn(List<String> values) {
            this.addCriterion("color not in", values, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorBetween(String value1, String value2) {
            this.addCriterion("color between", value1, value2, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andColorNotBetween(String value1, String value2) {
            this.addCriterion("color not between", value1, value2, "color");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeIsNull() {
            this.addCriterion("size is null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeIsNotNull() {
            this.addCriterion("size is not null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeEqualTo(String value) {
            this.addCriterion("size =", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeNotEqualTo(String value) {
            this.addCriterion("size <>", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeGreaterThan(String value) {
            this.addCriterion("size >", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeGreaterThanOrEqualTo(String value) {
            this.addCriterion("size >=", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeLessThan(String value) {
            this.addCriterion("size <", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeLessThanOrEqualTo(String value) {
            this.addCriterion("size <=", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeLike(String value) {
            this.addCriterion("size like", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeNotLike(String value) {
            this.addCriterion("size not like", value, "size");
            return (ItemProductSkuExample.Criteria)this;
        }        public ItemProductSkuExample.Criteria andSizeIn(List<String> values) {
            this.addCriterion("size in", values, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeNotIn(List<String> values) {
            this.addCriterion("size not in", values, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeBetween(String value1, String value2) {
            this.addCriterion("size between", value1, value2, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSizeNotBetween(String value1, String value2) {
            this.addCriterion("size not between", value1, value2, "size");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdIsNull() {
            this.addCriterion("sku_id is null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdIsNotNull() {
            this.addCriterion("sku_id is not null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdEqualTo(Long value) {
            this.addCriterion("sku_id =", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdNotEqualTo(Long value) {
            this.addCriterion("sku_id <>", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdGreaterThan(Long value) {
            this.addCriterion("sku_id >", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sku_id >=", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdLessThan(Long value) {
            this.addCriterion("sku_id <", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sku_id <=", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdLike(String value) {
            this.addCriterion("sku_id like", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdNotLike(String value) {
            this.addCriterion("sku_id not like", value, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }        public ItemProductSkuExample.Criteria andSkuIdIn(List<Long> values) {
            this.addCriterion("sku_id in", values, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdNotIn(List<Long> values) {
            this.addCriterion("sku_id not in", values, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            this.addCriterion("sku_id between", value1, value2, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sku_id not between", value1, value2, "skuId");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidIsNull() {
            this.addCriterion("pid is null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidIsNotNull() {
            this.addCriterion("pid is not null");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidEqualTo(Long value) {
            this.addCriterion("pid =", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidNotEqualTo(Long value) {
            this.addCriterion("pid <>", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidGreaterThan(Long value) {
            this.addCriterion("pid >", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pid >=", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidLessThan(Long value) {
            this.addCriterion("pid <", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidLessThanOrEqualTo(Long value) {
            this.addCriterion("pid <=", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidLike(String value) {
            this.addCriterion("pid like", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidNotLike(String value) {
            this.addCriterion("pid not like", value, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }        public ItemProductSkuExample.Criteria andPidIn(List<Long> values) {
            this.addCriterion("pid in", values, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidNotIn(List<Long> values) {
            this.addCriterion("pid not in", values, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidBetween(Long value1, Long value2) {
            this.addCriterion("pid between", value1, value2, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }

        public ItemProductSkuExample.Criteria andPidNotBetween(Long value1, Long value2) {
            this.addCriterion("pid not between", value1, value2, "pid");
            return (ItemProductSkuExample.Criteria)this;
        }
    }
}