package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShopFitmentPageExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShopFitmentPageExample.Criteria> oredCriteria = new ArrayList();

    public ShopFitmentPageExample() {
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

    public List<ShopFitmentPageExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShopFitmentPageExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShopFitmentPageExample.Criteria or() {
        ShopFitmentPageExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShopFitmentPageExample.Criteria createCriteria() {
        ShopFitmentPageExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShopFitmentPageExample.Criteria createCriteriaInternal() {
        ShopFitmentPageExample.Criteria criteria = new ShopFitmentPageExample.Criteria();
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

    public static class Criteria extends ShopFitmentPageExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShopFitmentPageExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShopFitmentPageExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShopFitmentPageExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShopFitmentPageExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShopFitmentPageExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShopFitmentPageExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShopFitmentPageExample.Criteria andPageIdIsNull() {
            this.addCriterion("page_id is null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdIsNotNull() {
            this.addCriterion("page_id is not null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdEqualTo(Long value) {
            this.addCriterion("page_id =", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdNotEqualTo(Long value) {
            this.addCriterion("page_id <>", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdGreaterThan(Long value) {
            this.addCriterion("page_id >", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("page_id >=", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdLessThan(Long value) {
            this.addCriterion("page_id <", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("page_id <=", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdLike(String value) {
            this.addCriterion("page_id like", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdNotLike(String value) {
            this.addCriterion("page_id not like", value, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }        public ShopFitmentPageExample.Criteria andPageIdIn(List<Long> values) {
            this.addCriterion("page_id in", values, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdNotIn(List<Long> values) {
            this.addCriterion("page_id not in", values, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdBetween(Long value1, Long value2) {
            this.addCriterion("page_id between", value1, value2, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andPageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("page_id not between", value1, value2, "pageId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }        public ShopFitmentPageExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicIsNull() {
            this.addCriterion("background_pic is null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicIsNotNull() {
            this.addCriterion("background_pic is not null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicEqualTo(String value) {
            this.addCriterion("background_pic =", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotEqualTo(String value) {
            this.addCriterion("background_pic <>", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicGreaterThan(String value) {
            this.addCriterion("background_pic >", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicGreaterThanOrEqualTo(String value) {
            this.addCriterion("background_pic >=", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicLessThan(String value) {
            this.addCriterion("background_pic <", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicLessThanOrEqualTo(String value) {
            this.addCriterion("background_pic <=", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicLike(String value) {
            this.addCriterion("background_pic like", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotLike(String value) {
            this.addCriterion("background_pic not like", value, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }        public ShopFitmentPageExample.Criteria andBackgroundPicIn(List<String> values) {
            this.addCriterion("background_pic in", values, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotIn(List<String> values) {
            this.addCriterion("background_pic not in", values, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicBetween(String value1, String value2) {
            this.addCriterion("background_pic between", value1, value2, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundPicNotBetween(String value1, String value2) {
            this.addCriterion("background_pic not between", value1, value2, "backgroundPic");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeIsNull() {
            this.addCriterion("code is null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeIsNotNull() {
            this.addCriterion("code is not null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeEqualTo(Long value) {
            this.addCriterion("code =", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeNotEqualTo(Long value) {
            this.addCriterion("code <>", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeGreaterThan(Long value) {
            this.addCriterion("code >", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("code >=", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeLessThan(Long value) {
            this.addCriterion("code <", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeLessThanOrEqualTo(Long value) {
            this.addCriterion("code <=", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeLike(String value) {
            this.addCriterion("code like", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeNotLike(String value) {
            this.addCriterion("code not like", value, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }        public ShopFitmentPageExample.Criteria andCodeIn(List<Long> values) {
            this.addCriterion("code in", values, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeNotIn(List<Long> values) {
            this.addCriterion("code not in", values, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeBetween(Long value1, Long value2) {
            this.addCriterion("code between", value1, value2, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andCodeNotBetween(Long value1, Long value2) {
            this.addCriterion("code not between", value1, value2, "code");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }        public ShopFitmentPageExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }        public ShopFitmentPageExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeIsNull() {
            this.addCriterion("background_type is null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeIsNotNull() {
            this.addCriterion("background_type is not null");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeEqualTo(Integer value) {
            this.addCriterion("background_type =", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeNotEqualTo(Integer value) {
            this.addCriterion("background_type <>", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeGreaterThan(Integer value) {
            this.addCriterion("background_type >", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("background_type >=", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeLessThan(Integer value) {
            this.addCriterion("background_type <", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("background_type <=", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeLike(String value) {
            this.addCriterion("background_type like", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeNotLike(String value) {
            this.addCriterion("background_type not like", value, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }        public ShopFitmentPageExample.Criteria andBackgroundTypeIn(List<Integer> values) {
            this.addCriterion("background_type in", values, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeNotIn(List<Integer> values) {
            this.addCriterion("background_type not in", values, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("background_type between", value1, value2, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }

        public ShopFitmentPageExample.Criteria andBackgroundTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("background_type not between", value1, value2, "backgroundType");
            return (ShopFitmentPageExample.Criteria)this;
        }
    }
}
