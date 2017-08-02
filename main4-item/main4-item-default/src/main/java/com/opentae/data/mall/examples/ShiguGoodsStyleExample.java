package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguGoodsStyleExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsStyleExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsStyleExample() {
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

    public List<ShiguGoodsStyleExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsStyleExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsStyleExample.Criteria or() {
        ShiguGoodsStyleExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsStyleExample.Criteria createCriteria() {
        ShiguGoodsStyleExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsStyleExample.Criteria createCriteriaInternal() {
        ShiguGoodsStyleExample.Criteria criteria = new ShiguGoodsStyleExample.Criteria();
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

    public static class Criteria extends ShiguGoodsStyleExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsStyleExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsStyleExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsStyleExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsStyleExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsStyleExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsStyleExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsStyleExample.Criteria andSidsIsNull() {
            this.addCriterion("sids is null");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsIsNotNull() {
            this.addCriterion("sids is not null");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsEqualTo(String value) {
            this.addCriterion("sids =", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotEqualTo(String value) {
            this.addCriterion("sids <>", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsGreaterThan(String value) {
            this.addCriterion("sids >", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsGreaterThanOrEqualTo(String value) {
            this.addCriterion("sids >=", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsLessThan(String value) {
            this.addCriterion("sids <", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsLessThanOrEqualTo(String value) {
            this.addCriterion("sids <=", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsLike(String value) {
            this.addCriterion("sids like", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotLike(String value) {
            this.addCriterion("sids not like", value, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }        public ShiguGoodsStyleExample.Criteria andSidsIn(List<String> values) {
            this.addCriterion("sids in", values, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotIn(List<String> values) {
            this.addCriterion("sids not in", values, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsBetween(String value1, String value2) {
            this.addCriterion("sids between", value1, value2, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotBetween(String value1, String value2) {
            this.addCriterion("sids not between", value1, value2, "sids");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }        public ShiguGoodsStyleExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdIsNull() {
            this.addCriterion("gs_id is null");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdIsNotNull() {
            this.addCriterion("gs_id is not null");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdEqualTo(Long value) {
            this.addCriterion("gs_id =", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdNotEqualTo(Long value) {
            this.addCriterion("gs_id <>", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdGreaterThan(Long value) {
            this.addCriterion("gs_id >", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("gs_id >=", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdLessThan(Long value) {
            this.addCriterion("gs_id <", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("gs_id <=", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdLike(String value) {
            this.addCriterion("gs_id like", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdNotLike(String value) {
            this.addCriterion("gs_id not like", value, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }        public ShiguGoodsStyleExample.Criteria andGsIdIn(List<Long> values) {
            this.addCriterion("gs_id in", values, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdNotIn(List<Long> values) {
            this.addCriterion("gs_id not in", values, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdBetween(Long value1, Long value2) {
            this.addCriterion("gs_id between", value1, value2, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }

        public ShiguGoodsStyleExample.Criteria andGsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("gs_id not between", value1, value2, "gsId");
            return (ShiguGoodsStyleExample.Criteria)this;
        }
    }
}
