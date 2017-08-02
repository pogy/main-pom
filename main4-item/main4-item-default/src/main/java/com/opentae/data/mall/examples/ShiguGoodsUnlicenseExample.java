package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguGoodsUnlicenseExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsUnlicenseExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsUnlicenseExample() {
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

    public List<ShiguGoodsUnlicenseExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsUnlicenseExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsUnlicenseExample.Criteria or() {
        ShiguGoodsUnlicenseExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsUnlicenseExample.Criteria createCriteria() {
        ShiguGoodsUnlicenseExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsUnlicenseExample.Criteria createCriteriaInternal() {
        ShiguGoodsUnlicenseExample.Criteria criteria = new ShiguGoodsUnlicenseExample.Criteria();
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

    public static class Criteria extends ShiguGoodsUnlicenseExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsUnlicenseExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsUnlicenseExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsUnlicenseExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsUnlicenseExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsUnlicenseExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsUnlicenseExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdIsNull() {
            this.addCriterion("unlicense_id is null");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdIsNotNull() {
            this.addCriterion("unlicense_id is not null");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdEqualTo(Long value) {
            this.addCriterion("unlicense_id =", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdNotEqualTo(Long value) {
            this.addCriterion("unlicense_id <>", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdGreaterThan(Long value) {
            this.addCriterion("unlicense_id >", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("unlicense_id >=", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdLessThan(Long value) {
            this.addCriterion("unlicense_id <", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdLessThanOrEqualTo(Long value) {
            this.addCriterion("unlicense_id <=", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdLike(String value) {
            this.addCriterion("unlicense_id like", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdNotLike(String value) {
            this.addCriterion("unlicense_id not like", value, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdIn(List<Long> values) {
            this.addCriterion("unlicense_id in", values, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdNotIn(List<Long> values) {
            this.addCriterion("unlicense_id not in", values, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdBetween(Long value1, Long value2) {
            this.addCriterion("unlicense_id between", value1, value2, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdNotBetween(Long value1, Long value2) {
            this.addCriterion("unlicense_id not between", value1, value2, "unlicenseId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextIsNull() {
            this.addCriterion("unlicense_context is null");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextIsNotNull() {
            this.addCriterion("unlicense_context is not null");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextEqualTo(String value) {
            this.addCriterion("unlicense_context =", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotEqualTo(String value) {
            this.addCriterion("unlicense_context <>", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextGreaterThan(String value) {
            this.addCriterion("unlicense_context >", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("unlicense_context >=", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextLessThan(String value) {
            this.addCriterion("unlicense_context <", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextLessThanOrEqualTo(String value) {
            this.addCriterion("unlicense_context <=", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextLike(String value) {
            this.addCriterion("unlicense_context like", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotLike(String value) {
            this.addCriterion("unlicense_context not like", value, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextIn(List<String> values) {
            this.addCriterion("unlicense_context in", values, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotIn(List<String> values) {
            this.addCriterion("unlicense_context not in", values, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextBetween(String value1, String value2) {
            this.addCriterion("unlicense_context between", value1, value2, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotBetween(String value1, String value2) {
            this.addCriterion("unlicense_context not between", value1, value2, "unlicenseContext");
            return (ShiguGoodsUnlicenseExample.Criteria)this;
        }
    }
}
