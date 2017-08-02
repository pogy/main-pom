package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemProductSkuExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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
    }
}
