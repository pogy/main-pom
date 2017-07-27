package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoodsFileExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoodsFileExample.Criteria> oredCriteria = new ArrayList();

    public GoodsFileExample() {
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

    public List<GoodsFileExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoodsFileExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoodsFileExample.Criteria or() {
        GoodsFileExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoodsFileExample.Criteria createCriteria() {
        GoodsFileExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoodsFileExample.Criteria createCriteriaInternal() {
        GoodsFileExample.Criteria criteria = new GoodsFileExample.Criteria();
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

    public static class Criteria extends GoodsFileExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoodsFileExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoodsFileExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoodsFileExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoodsFileExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoodsFileExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoodsFileExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoodsFileExample.Criteria andFileKeyIsNull() {
            this.addCriterion("file_key is null");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyIsNotNull() {
            this.addCriterion("file_key is not null");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyEqualTo(String value) {
            this.addCriterion("file_key =", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyNotEqualTo(String value) {
            this.addCriterion("file_key <>", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyGreaterThan(String value) {
            this.addCriterion("file_key >", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("file_key >=", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyLessThan(String value) {
            this.addCriterion("file_key <", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyLessThanOrEqualTo(String value) {
            this.addCriterion("file_key <=", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyLike(String value) {
            this.addCriterion("file_key like", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyNotLike(String value) {
            this.addCriterion("file_key not like", value, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }        public GoodsFileExample.Criteria andFileKeyIn(List<String> values) {
            this.addCriterion("file_key in", values, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyNotIn(List<String> values) {
            this.addCriterion("file_key not in", values, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyBetween(String value1, String value2) {
            this.addCriterion("file_key between", value1, value2, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andFileKeyNotBetween(String value1, String value2) {
            this.addCriterion("file_key not between", value1, value2, "fileKey");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }        public GoodsFileExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (GoodsFileExample.Criteria)this;
        }        public GoodsFileExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (GoodsFileExample.Criteria)this;
        }

        public GoodsFileExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (GoodsFileExample.Criteria)this;
        }
    }
}
