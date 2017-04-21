package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguPropImgsExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguPropImgsExample.Criteria> oredCriteria = new ArrayList();

    public ShiguPropImgsExample() {
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

    public List<ShiguPropImgsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguPropImgsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguPropImgsExample.Criteria or() {
        ShiguPropImgsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguPropImgsExample.Criteria createCriteria() {
        ShiguPropImgsExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguPropImgsExample.Criteria createCriteriaInternal() {
        ShiguPropImgsExample.Criteria criteria = new ShiguPropImgsExample.Criteria();
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

    public static class Criteria extends ShiguPropImgsExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguPropImgsExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguPropImgsExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguPropImgsExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguPropImgsExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguPropImgsExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguPropImgsExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguPropImgsExample.Criteria andPropimgIdIsNull() {
            this.addCriterion("propimg_id is null");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdIsNotNull() {
            this.addCriterion("propimg_id is not null");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdEqualTo(Long value) {
            this.addCriterion("propimg_id =", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdNotEqualTo(Long value) {
            this.addCriterion("propimg_id <>", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdGreaterThan(Long value) {
            this.addCriterion("propimg_id >", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("propimg_id >=", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdLessThan(Long value) {
            this.addCriterion("propimg_id <", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdLessThanOrEqualTo(Long value) {
            this.addCriterion("propimg_id <=", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdLike(String value) {
            this.addCriterion("propimg_id like", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdNotLike(String value) {
            this.addCriterion("propimg_id not like", value, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }        public ShiguPropImgsExample.Criteria andPropimgIdIn(List<Long> values) {
            this.addCriterion("propimg_id in", values, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdNotIn(List<Long> values) {
            this.addCriterion("propimg_id not in", values, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdBetween(Long value1, Long value2) {
            this.addCriterion("propimg_id between", value1, value2, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgIdNotBetween(Long value1, Long value2) {
            this.addCriterion("propimg_id not between", value1, value2, "propimgId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdIsNull() {
            this.addCriterion("item_id is null");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdIsNotNull() {
            this.addCriterion("item_id is not null");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdEqualTo(Long value) {
            this.addCriterion("item_id =", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdNotEqualTo(Long value) {
            this.addCriterion("item_id <>", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdGreaterThan(Long value) {
            this.addCriterion("item_id >", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("item_id >=", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdLessThan(Long value) {
            this.addCriterion("item_id <", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            this.addCriterion("item_id <=", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdLike(String value) {
            this.addCriterion("item_id like", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdNotLike(String value) {
            this.addCriterion("item_id not like", value, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }        public ShiguPropImgsExample.Criteria andItemIdIn(List<Long> values) {
            this.addCriterion("item_id in", values, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdNotIn(List<Long> values) {
            this.addCriterion("item_id not in", values, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdBetween(Long value1, Long value2) {
            this.addCriterion("item_id between", value1, value2, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            this.addCriterion("item_id not between", value1, value2, "itemId");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsIsNull() {
            this.addCriterion("propimgs is null");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsIsNotNull() {
            this.addCriterion("propimgs is not null");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsEqualTo(String value) {
            this.addCriterion("propimgs =", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotEqualTo(String value) {
            this.addCriterion("propimgs <>", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsGreaterThan(String value) {
            this.addCriterion("propimgs >", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsGreaterThanOrEqualTo(String value) {
            this.addCriterion("propimgs >=", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsLessThan(String value) {
            this.addCriterion("propimgs <", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsLessThanOrEqualTo(String value) {
            this.addCriterion("propimgs <=", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsLike(String value) {
            this.addCriterion("propimgs like", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotLike(String value) {
            this.addCriterion("propimgs not like", value, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }        public ShiguPropImgsExample.Criteria andPropimgsIn(List<String> values) {
            this.addCriterion("propimgs in", values, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotIn(List<String> values) {
            this.addCriterion("propimgs not in", values, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsBetween(String value1, String value2) {
            this.addCriterion("propimgs between", value1, value2, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotBetween(String value1, String value2) {
            this.addCriterion("propimgs not between", value1, value2, "propimgs");
            return (ShiguPropImgsExample.Criteria)this;
        }
    }
}
