package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguGoodsExtendsExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsExtendsExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsExtendsExample() {
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

    public List<ShiguGoodsExtendsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsExtendsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsExtendsExample.Criteria or() {
        ShiguGoodsExtendsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsExtendsExample.Criteria createCriteria() {
        ShiguGoodsExtendsExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsExtendsExample.Criteria createCriteriaInternal() {
        ShiguGoodsExtendsExample.Criteria criteria = new ShiguGoodsExtendsExample.Criteria();
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

    public static class Criteria extends ShiguGoodsExtendsExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsExtendsExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsExtendsExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsExtendsExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsExtendsExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsExtendsExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsExtendsExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescIsNull() {
            this.addCriterion("goods_desc is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescIsNotNull() {
            this.addCriterion("goods_desc is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescEqualTo(String value) {
            this.addCriterion("goods_desc =", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotEqualTo(String value) {
            this.addCriterion("goods_desc <>", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescGreaterThan(String value) {
            this.addCriterion("goods_desc >", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_desc >=", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescLessThan(String value) {
            this.addCriterion("goods_desc <", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescLessThanOrEqualTo(String value) {
            this.addCriterion("goods_desc <=", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescLike(String value) {
            this.addCriterion("goods_desc like", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotLike(String value) {
            this.addCriterion("goods_desc not like", value, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andGoodsDescIn(List<String> values) {
            this.addCriterion("goods_desc in", values, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotIn(List<String> values) {
            this.addCriterion("goods_desc not in", values, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescBetween(String value1, String value2) {
            this.addCriterion("goods_desc between", value1, value2, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andGoodsDescNotBetween(String value1, String value2) {
            this.addCriterion("goods_desc not between", value1, value2, "goodsDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameIsNull() {
            this.addCriterion("props_name is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameIsNotNull() {
            this.addCriterion("props_name is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameEqualTo(String value) {
            this.addCriterion("props_name =", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotEqualTo(String value) {
            this.addCriterion("props_name <>", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameGreaterThan(String value) {
            this.addCriterion("props_name >", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("props_name >=", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameLessThan(String value) {
            this.addCriterion("props_name <", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameLessThanOrEqualTo(String value) {
            this.addCriterion("props_name <=", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameLike(String value) {
            this.addCriterion("props_name like", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotLike(String value) {
            this.addCriterion("props_name not like", value, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andPropsNameIn(List<String> values) {
            this.addCriterion("props_name in", values, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotIn(List<String> values) {
            this.addCriterion("props_name not in", values, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameBetween(String value1, String value2) {
            this.addCriterion("props_name between", value1, value2, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNameNotBetween(String value1, String value2) {
            this.addCriterion("props_name not between", value1, value2, "propsName");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointIsNull() {
            this.addCriterion("auction_point is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointIsNotNull() {
            this.addCriterion("auction_point is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointEqualTo(String value) {
            this.addCriterion("auction_point =", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotEqualTo(String value) {
            this.addCriterion("auction_point <>", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointGreaterThan(String value) {
            this.addCriterion("auction_point >", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointGreaterThanOrEqualTo(String value) {
            this.addCriterion("auction_point >=", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointLessThan(String value) {
            this.addCriterion("auction_point <", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointLessThanOrEqualTo(String value) {
            this.addCriterion("auction_point <=", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointLike(String value) {
            this.addCriterion("auction_point like", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotLike(String value) {
            this.addCriterion("auction_point not like", value, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andAuctionPointIn(List<String> values) {
            this.addCriterion("auction_point in", values, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotIn(List<String> values) {
            this.addCriterion("auction_point not in", values, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointBetween(String value1, String value2) {
            this.addCriterion("auction_point between", value1, value2, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAuctionPointNotBetween(String value1, String value2) {
            this.addCriterion("auction_point not between", value1, value2, "auctionPoint");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasIsNull() {
            this.addCriterion("property_alias is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasIsNotNull() {
            this.addCriterion("property_alias is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasEqualTo(String value) {
            this.addCriterion("property_alias =", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotEqualTo(String value) {
            this.addCriterion("property_alias <>", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasGreaterThan(String value) {
            this.addCriterion("property_alias >", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasGreaterThanOrEqualTo(String value) {
            this.addCriterion("property_alias >=", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasLessThan(String value) {
            this.addCriterion("property_alias <", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasLessThanOrEqualTo(String value) {
            this.addCriterion("property_alias <=", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasLike(String value) {
            this.addCriterion("property_alias like", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotLike(String value) {
            this.addCriterion("property_alias not like", value, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andPropertyAliasIn(List<String> values) {
            this.addCriterion("property_alias in", values, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotIn(List<String> values) {
            this.addCriterion("property_alias not in", values, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasBetween(String value1, String value2) {
            this.addCriterion("property_alias between", value1, value2, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropertyAliasNotBetween(String value1, String value2) {
            this.addCriterion("property_alias not between", value1, value2, "propertyAlias");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdIsNull() {
            this.addCriterion("template_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdIsNotNull() {
            this.addCriterion("template_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdEqualTo(String value) {
            this.addCriterion("template_id =", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotEqualTo(String value) {
            this.addCriterion("template_id <>", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdGreaterThan(String value) {
            this.addCriterion("template_id >", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("template_id >=", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdLessThan(String value) {
            this.addCriterion("template_id <", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdLessThanOrEqualTo(String value) {
            this.addCriterion("template_id <=", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdLike(String value) {
            this.addCriterion("template_id like", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotLike(String value) {
            this.addCriterion("template_id not like", value, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andTemplateIdIn(List<String> values) {
            this.addCriterion("template_id in", values, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotIn(List<String> values) {
            this.addCriterion("template_id not in", values, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdBetween(String value1, String value2) {
            this.addCriterion("template_id between", value1, value2, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andTemplateIdNotBetween(String value1, String value2) {
            this.addCriterion("template_id not between", value1, value2, "templateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdIsNull() {
            this.addCriterion("after_sale_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdIsNotNull() {
            this.addCriterion("after_sale_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdEqualTo(Long value) {
            this.addCriterion("after_sale_id =", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdNotEqualTo(Long value) {
            this.addCriterion("after_sale_id <>", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdGreaterThan(Long value) {
            this.addCriterion("after_sale_id >", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("after_sale_id >=", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdLessThan(Long value) {
            this.addCriterion("after_sale_id <", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("after_sale_id <=", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdLike(String value) {
            this.addCriterion("after_sale_id like", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdNotLike(String value) {
            this.addCriterion("after_sale_id not like", value, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdIn(List<Long> values) {
            this.addCriterion("after_sale_id in", values, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdNotIn(List<Long> values) {
            this.addCriterion("after_sale_id not in", values, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            this.addCriterion("after_sale_id between", value1, value2, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("after_sale_id not between", value1, value2, "afterSaleId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockIsNull() {
            this.addCriterion("sub_stock is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockIsNotNull() {
            this.addCriterion("sub_stock is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockEqualTo(Long value) {
            this.addCriterion("sub_stock =", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockNotEqualTo(Long value) {
            this.addCriterion("sub_stock <>", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockGreaterThan(Long value) {
            this.addCriterion("sub_stock >", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sub_stock >=", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockLessThan(Long value) {
            this.addCriterion("sub_stock <", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockLessThanOrEqualTo(Long value) {
            this.addCriterion("sub_stock <=", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockLike(String value) {
            this.addCriterion("sub_stock like", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockNotLike(String value) {
            this.addCriterion("sub_stock not like", value, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andSubStockIn(List<Long> values) {
            this.addCriterion("sub_stock in", values, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockNotIn(List<Long> values) {
            this.addCriterion("sub_stock not in", values, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockBetween(Long value1, Long value2) {
            this.addCriterion("sub_stock between", value1, value2, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubStockNotBetween(Long value1, Long value2) {
            this.addCriterion("sub_stock not between", value1, value2, "subStock");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdIsNull() {
            this.addCriterion("inner_shop_auction_template_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdIsNotNull() {
            this.addCriterion("inner_shop_auction_template_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdEqualTo(Long value) {
            this.addCriterion("inner_shop_auction_template_id =", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdNotEqualTo(Long value) {
            this.addCriterion("inner_shop_auction_template_id <>", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdGreaterThan(Long value) {
            this.addCriterion("inner_shop_auction_template_id >", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("inner_shop_auction_template_id >=", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdLessThan(Long value) {
            this.addCriterion("inner_shop_auction_template_id <", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("inner_shop_auction_template_id <=", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdLike(String value) {
            this.addCriterion("inner_shop_auction_template_id like", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdNotLike(String value) {
            this.addCriterion("inner_shop_auction_template_id not like", value, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdIn(List<Long> values) {
            this.addCriterion("inner_shop_auction_template_id in", values, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdNotIn(List<Long> values) {
            this.addCriterion("inner_shop_auction_template_id not in", values, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdBetween(Long value1, Long value2) {
            this.addCriterion("inner_shop_auction_template_id between", value1, value2, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInnerShopAuctionTemplateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("inner_shop_auction_template_id not between", value1, value2, "innerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdIsNull() {
            this.addCriterion("outer_shop_auction_template_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdIsNotNull() {
            this.addCriterion("outer_shop_auction_template_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdEqualTo(Long value) {
            this.addCriterion("outer_shop_auction_template_id =", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdNotEqualTo(Long value) {
            this.addCriterion("outer_shop_auction_template_id <>", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdGreaterThan(Long value) {
            this.addCriterion("outer_shop_auction_template_id >", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("outer_shop_auction_template_id >=", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdLessThan(Long value) {
            this.addCriterion("outer_shop_auction_template_id <", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("outer_shop_auction_template_id <=", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdLike(String value) {
            this.addCriterion("outer_shop_auction_template_id like", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdNotLike(String value) {
            this.addCriterion("outer_shop_auction_template_id not like", value, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdIn(List<Long> values) {
            this.addCriterion("outer_shop_auction_template_id in", values, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdNotIn(List<Long> values) {
            this.addCriterion("outer_shop_auction_template_id not in", values, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdBetween(Long value1, Long value2) {
            this.addCriterion("outer_shop_auction_template_id between", value1, value2, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOuterShopAuctionTemplateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("outer_shop_auction_template_id not between", value1, value2, "outerShopAuctionTemplateId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesIsNull() {
            this.addCriterion("features is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesIsNotNull() {
            this.addCriterion("features is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesEqualTo(String value) {
            this.addCriterion("features =", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotEqualTo(String value) {
            this.addCriterion("features <>", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesGreaterThan(String value) {
            this.addCriterion("features >", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesGreaterThanOrEqualTo(String value) {
            this.addCriterion("features >=", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesLessThan(String value) {
            this.addCriterion("features <", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesLessThanOrEqualTo(String value) {
            this.addCriterion("features <=", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesLike(String value) {
            this.addCriterion("features like", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotLike(String value) {
            this.addCriterion("features not like", value, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andFeaturesIn(List<String> values) {
            this.addCriterion("features in", values, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotIn(List<String> values) {
            this.addCriterion("features not in", values, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesBetween(String value1, String value2) {
            this.addCriterion("features between", value1, value2, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andFeaturesNotBetween(String value1, String value2) {
            this.addCriterion("features not between", value1, value2, "features");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightIsNull() {
            this.addCriterion("item_weight is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightIsNotNull() {
            this.addCriterion("item_weight is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightEqualTo(String value) {
            this.addCriterion("item_weight =", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotEqualTo(String value) {
            this.addCriterion("item_weight <>", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightGreaterThan(String value) {
            this.addCriterion("item_weight >", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightGreaterThanOrEqualTo(String value) {
            this.addCriterion("item_weight >=", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightLessThan(String value) {
            this.addCriterion("item_weight <", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightLessThanOrEqualTo(String value) {
            this.addCriterion("item_weight <=", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightLike(String value) {
            this.addCriterion("item_weight like", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotLike(String value) {
            this.addCriterion("item_weight not like", value, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andItemWeightIn(List<String> values) {
            this.addCriterion("item_weight in", values, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotIn(List<String> values) {
            this.addCriterion("item_weight not in", values, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightBetween(String value1, String value2) {
            this.addCriterion("item_weight between", value1, value2, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemWeightNotBetween(String value1, String value2) {
            this.addCriterion("item_weight not between", value1, value2, "itemWeight");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeIsNull() {
            this.addCriterion("item_size is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeIsNotNull() {
            this.addCriterion("item_size is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeEqualTo(String value) {
            this.addCriterion("item_size =", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotEqualTo(String value) {
            this.addCriterion("item_size <>", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeGreaterThan(String value) {
            this.addCriterion("item_size >", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeGreaterThanOrEqualTo(String value) {
            this.addCriterion("item_size >=", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeLessThan(String value) {
            this.addCriterion("item_size <", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeLessThanOrEqualTo(String value) {
            this.addCriterion("item_size <=", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeLike(String value) {
            this.addCriterion("item_size like", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotLike(String value) {
            this.addCriterion("item_size not like", value, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andItemSizeIn(List<String> values) {
            this.addCriterion("item_size in", values, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotIn(List<String> values) {
            this.addCriterion("item_size not in", values, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeBetween(String value1, String value2) {
            this.addCriterion("item_size between", value1, value2, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andItemSizeNotBetween(String value1, String value2) {
            this.addCriterion("item_size not between", value1, value2, "itemSize");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityIsNull() {
            this.addCriterion("with_hold_quantity is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityIsNotNull() {
            this.addCriterion("with_hold_quantity is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityEqualTo(Long value) {
            this.addCriterion("with_hold_quantity =", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityNotEqualTo(Long value) {
            this.addCriterion("with_hold_quantity <>", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityGreaterThan(Long value) {
            this.addCriterion("with_hold_quantity >", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityGreaterThanOrEqualTo(Long value) {
            this.addCriterion("with_hold_quantity >=", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityLessThan(Long value) {
            this.addCriterion("with_hold_quantity <", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityLessThanOrEqualTo(Long value) {
            this.addCriterion("with_hold_quantity <=", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityLike(String value) {
            this.addCriterion("with_hold_quantity like", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityNotLike(String value) {
            this.addCriterion("with_hold_quantity not like", value, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityIn(List<Long> values) {
            this.addCriterion("with_hold_quantity in", values, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityNotIn(List<Long> values) {
            this.addCriterion("with_hold_quantity not in", values, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityBetween(Long value1, Long value2) {
            this.addCriterion("with_hold_quantity between", value1, value2, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWithHoldQuantityNotBetween(Long value1, Long value2) {
            this.addCriterion("with_hold_quantity not between", value1, value2, "withHoldQuantity");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdIsNull() {
            this.addCriterion("custom_made_type_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdIsNotNull() {
            this.addCriterion("custom_made_type_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdEqualTo(String value) {
            this.addCriterion("custom_made_type_id =", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotEqualTo(String value) {
            this.addCriterion("custom_made_type_id <>", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdGreaterThan(String value) {
            this.addCriterion("custom_made_type_id >", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("custom_made_type_id >=", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdLessThan(String value) {
            this.addCriterion("custom_made_type_id <", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdLessThanOrEqualTo(String value) {
            this.addCriterion("custom_made_type_id <=", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdLike(String value) {
            this.addCriterion("custom_made_type_id like", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotLike(String value) {
            this.addCriterion("custom_made_type_id not like", value, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdIn(List<String> values) {
            this.addCriterion("custom_made_type_id in", values, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotIn(List<String> values) {
            this.addCriterion("custom_made_type_id not in", values, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdBetween(String value1, String value2) {
            this.addCriterion("custom_made_type_id between", value1, value2, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCustomMadeTypeIdNotBetween(String value1, String value2) {
            this.addCriterion("custom_made_type_id not between", value1, value2, "customMadeTypeId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescIsNull() {
            this.addCriterion("wireless_desc is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescIsNotNull() {
            this.addCriterion("wireless_desc is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescEqualTo(String value) {
            this.addCriterion("wireless_desc =", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotEqualTo(String value) {
            this.addCriterion("wireless_desc <>", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescGreaterThan(String value) {
            this.addCriterion("wireless_desc >", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("wireless_desc >=", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescLessThan(String value) {
            this.addCriterion("wireless_desc <", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescLessThanOrEqualTo(String value) {
            this.addCriterion("wireless_desc <=", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescLike(String value) {
            this.addCriterion("wireless_desc like", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotLike(String value) {
            this.addCriterion("wireless_desc not like", value, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andWirelessDescIn(List<String> values) {
            this.addCriterion("wireless_desc in", values, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotIn(List<String> values) {
            this.addCriterion("wireless_desc not in", values, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescBetween(String value1, String value2) {
            this.addCriterion("wireless_desc between", value1, value2, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWirelessDescNotBetween(String value1, String value2) {
            this.addCriterion("wireless_desc not between", value1, value2, "wirelessDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeIsNull() {
            this.addCriterion("barcode is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeIsNotNull() {
            this.addCriterion("barcode is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeEqualTo(String value) {
            this.addCriterion("barcode =", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotEqualTo(String value) {
            this.addCriterion("barcode <>", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeGreaterThan(String value) {
            this.addCriterion("barcode >", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("barcode >=", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeLessThan(String value) {
            this.addCriterion("barcode <", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeLessThanOrEqualTo(String value) {
            this.addCriterion("barcode <=", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeLike(String value) {
            this.addCriterion("barcode like", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotLike(String value) {
            this.addCriterion("barcode not like", value, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andBarcodeIn(List<String> values) {
            this.addCriterion("barcode in", values, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotIn(List<String> values) {
            this.addCriterion("barcode not in", values, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeBetween(String value1, String value2) {
            this.addCriterion("barcode between", value1, value2, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andBarcodeNotBetween(String value1, String value2) {
            this.addCriterion("barcode not between", value1, value2, "barcode");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsIsNull() {
            this.addCriterion("seller_cids is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsIsNotNull() {
            this.addCriterion("seller_cids is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsEqualTo(String value) {
            this.addCriterion("seller_cids =", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotEqualTo(String value) {
            this.addCriterion("seller_cids <>", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsGreaterThan(String value) {
            this.addCriterion("seller_cids >", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsGreaterThanOrEqualTo(String value) {
            this.addCriterion("seller_cids >=", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsLessThan(String value) {
            this.addCriterion("seller_cids <", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsLessThanOrEqualTo(String value) {
            this.addCriterion("seller_cids <=", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsLike(String value) {
            this.addCriterion("seller_cids like", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotLike(String value) {
            this.addCriterion("seller_cids not like", value, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andSellerCidsIn(List<String> values) {
            this.addCriterion("seller_cids in", values, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotIn(List<String> values) {
            this.addCriterion("seller_cids not in", values, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsBetween(String value1, String value2) {
            this.addCriterion("seller_cids between", value1, value2, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellerCidsNotBetween(String value1, String value2) {
            this.addCriterion("seller_cids not between", value1, value2, "sellerCids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsIsNull() {
            this.addCriterion("props is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsIsNotNull() {
            this.addCriterion("props is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsEqualTo(String value) {
            this.addCriterion("props =", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotEqualTo(String value) {
            this.addCriterion("props <>", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsGreaterThan(String value) {
            this.addCriterion("props >", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsGreaterThanOrEqualTo(String value) {
            this.addCriterion("props >=", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsLessThan(String value) {
            this.addCriterion("props <", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsLessThanOrEqualTo(String value) {
            this.addCriterion("props <=", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsLike(String value) {
            this.addCriterion("props like", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotLike(String value) {
            this.addCriterion("props not like", value, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andPropsIn(List<String> values) {
            this.addCriterion("props in", values, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotIn(List<String> values) {
            this.addCriterion("props not in", values, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsBetween(String value1, String value2) {
            this.addCriterion("props between", value1, value2, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPropsNotBetween(String value1, String value2) {
            this.addCriterion("props not between", value1, value2, "props");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsIsNull() {
            this.addCriterion("input_pids is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsIsNotNull() {
            this.addCriterion("input_pids is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsEqualTo(String value) {
            this.addCriterion("input_pids =", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotEqualTo(String value) {
            this.addCriterion("input_pids <>", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsGreaterThan(String value) {
            this.addCriterion("input_pids >", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsGreaterThanOrEqualTo(String value) {
            this.addCriterion("input_pids >=", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsLessThan(String value) {
            this.addCriterion("input_pids <", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsLessThanOrEqualTo(String value) {
            this.addCriterion("input_pids <=", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsLike(String value) {
            this.addCriterion("input_pids like", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotLike(String value) {
            this.addCriterion("input_pids not like", value, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andInputPidsIn(List<String> values) {
            this.addCriterion("input_pids in", values, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotIn(List<String> values) {
            this.addCriterion("input_pids not in", values, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsBetween(String value1, String value2) {
            this.addCriterion("input_pids between", value1, value2, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputPidsNotBetween(String value1, String value2) {
            this.addCriterion("input_pids not between", value1, value2, "inputPids");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrIsNull() {
            this.addCriterion("input_str is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrIsNotNull() {
            this.addCriterion("input_str is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrEqualTo(String value) {
            this.addCriterion("input_str =", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotEqualTo(String value) {
            this.addCriterion("input_str <>", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrGreaterThan(String value) {
            this.addCriterion("input_str >", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrGreaterThanOrEqualTo(String value) {
            this.addCriterion("input_str >=", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrLessThan(String value) {
            this.addCriterion("input_str <", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrLessThanOrEqualTo(String value) {
            this.addCriterion("input_str <=", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrLike(String value) {
            this.addCriterion("input_str like", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotLike(String value) {
            this.addCriterion("input_str not like", value, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andInputStrIn(List<String> values) {
            this.addCriterion("input_str in", values, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotIn(List<String> values) {
            this.addCriterion("input_str not in", values, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrBetween(String value1, String value2) {
            this.addCriterion("input_str between", value1, value2, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andInputStrNotBetween(String value1, String value2) {
            this.addCriterion("input_str not between", value1, value2, "inputStr");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesIsNull() {
            this.addCriterion("images is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesIsNotNull() {
            this.addCriterion("images is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesEqualTo(String value) {
            this.addCriterion("images =", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotEqualTo(String value) {
            this.addCriterion("images <>", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesGreaterThan(String value) {
            this.addCriterion("images >", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesGreaterThanOrEqualTo(String value) {
            this.addCriterion("images >=", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesLessThan(String value) {
            this.addCriterion("images <", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesLessThanOrEqualTo(String value) {
            this.addCriterion("images <=", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesLike(String value) {
            this.addCriterion("images like", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotLike(String value) {
            this.addCriterion("images not like", value, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andImagesIn(List<String> values) {
            this.addCriterion("images in", values, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotIn(List<String> values) {
            this.addCriterion("images not in", values, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesBetween(String value1, String value2) {
            this.addCriterion("images between", value1, value2, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andImagesNotBetween(String value1, String value2) {
            this.addCriterion("images not between", value1, value2, "images");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceIsNull() {
            this.addCriterion("has_invoice is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceIsNotNull() {
            this.addCriterion("has_invoice is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceEqualTo(String value) {
            this.addCriterion("has_invoice =", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotEqualTo(String value) {
            this.addCriterion("has_invoice <>", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceGreaterThan(String value) {
            this.addCriterion("has_invoice >", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_invoice >=", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceLessThan(String value) {
            this.addCriterion("has_invoice <", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceLessThanOrEqualTo(String value) {
            this.addCriterion("has_invoice <=", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceLike(String value) {
            this.addCriterion("has_invoice like", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotLike(String value) {
            this.addCriterion("has_invoice not like", value, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andHasInvoiceIn(List<String> values) {
            this.addCriterion("has_invoice in", values, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotIn(List<String> values) {
            this.addCriterion("has_invoice not in", values, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceBetween(String value1, String value2) {
            this.addCriterion("has_invoice between", value1, value2, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasInvoiceNotBetween(String value1, String value2) {
            this.addCriterion("has_invoice not between", value1, value2, "hasInvoice");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyIsNull() {
            this.addCriterion("has_warranty is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyIsNotNull() {
            this.addCriterion("has_warranty is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyEqualTo(String value) {
            this.addCriterion("has_warranty =", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotEqualTo(String value) {
            this.addCriterion("has_warranty <>", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyGreaterThan(String value) {
            this.addCriterion("has_warranty >", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_warranty >=", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyLessThan(String value) {
            this.addCriterion("has_warranty <", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyLessThanOrEqualTo(String value) {
            this.addCriterion("has_warranty <=", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyLike(String value) {
            this.addCriterion("has_warranty like", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotLike(String value) {
            this.addCriterion("has_warranty not like", value, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andHasWarrantyIn(List<String> values) {
            this.addCriterion("has_warranty in", values, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotIn(List<String> values) {
            this.addCriterion("has_warranty not in", values, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyBetween(String value1, String value2) {
            this.addCriterion("has_warranty between", value1, value2, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andHasWarrantyNotBetween(String value1, String value2) {
            this.addCriterion("has_warranty not between", value1, value2, "hasWarranty");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementIsNull() {
            this.addCriterion("increment is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementIsNotNull() {
            this.addCriterion("increment is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementEqualTo(String value) {
            this.addCriterion("increment =", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotEqualTo(String value) {
            this.addCriterion("increment <>", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementGreaterThan(String value) {
            this.addCriterion("increment >", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementGreaterThanOrEqualTo(String value) {
            this.addCriterion("increment >=", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementLessThan(String value) {
            this.addCriterion("increment <", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementLessThanOrEqualTo(String value) {
            this.addCriterion("increment <=", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementLike(String value) {
            this.addCriterion("increment like", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotLike(String value) {
            this.addCriterion("increment not like", value, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andIncrementIn(List<String> values) {
            this.addCriterion("increment in", values, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotIn(List<String> values) {
            this.addCriterion("increment not in", values, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementBetween(String value1, String value2) {
            this.addCriterion("increment between", value1, value2, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIncrementNotBetween(String value1, String value2) {
            this.addCriterion("increment not between", value1, value2, "increment");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusIsNull() {
            this.addCriterion("approve_status is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusIsNotNull() {
            this.addCriterion("approve_status is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusEqualTo(String value) {
            this.addCriterion("approve_status =", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotEqualTo(String value) {
            this.addCriterion("approve_status <>", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusGreaterThan(String value) {
            this.addCriterion("approve_status >", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusGreaterThanOrEqualTo(String value) {
            this.addCriterion("approve_status >=", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusLessThan(String value) {
            this.addCriterion("approve_status <", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusLessThanOrEqualTo(String value) {
            this.addCriterion("approve_status <=", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusLike(String value) {
            this.addCriterion("approve_status like", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotLike(String value) {
            this.addCriterion("approve_status not like", value, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andApproveStatusIn(List<String> values) {
            this.addCriterion("approve_status in", values, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotIn(List<String> values) {
            this.addCriterion("approve_status not in", values, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusBetween(String value1, String value2) {
            this.addCriterion("approve_status between", value1, value2, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andApproveStatusNotBetween(String value1, String value2) {
            this.addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdIsNull() {
            this.addCriterion("product_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdIsNotNull() {
            this.addCriterion("product_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdEqualTo(Long value) {
            this.addCriterion("product_id =", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdNotEqualTo(Long value) {
            this.addCriterion("product_id <>", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdGreaterThan(Long value) {
            this.addCriterion("product_id >", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("product_id >=", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdLessThan(Long value) {
            this.addCriterion("product_id <", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdLessThanOrEqualTo(Long value) {
            this.addCriterion("product_id <=", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdLike(String value) {
            this.addCriterion("product_id like", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdNotLike(String value) {
            this.addCriterion("product_id not like", value, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andProductIdIn(List<Long> values) {
            this.addCriterion("product_id in", values, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdNotIn(List<Long> values) {
            this.addCriterion("product_id not in", values, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdBetween(Long value1, Long value2) {
            this.addCriterion("product_id between", value1, value2, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andProductIdNotBetween(Long value1, Long value2) {
            this.addCriterion("product_id not between", value1, value2, "productId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdIsNull() {
            this.addCriterion("postage_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdIsNotNull() {
            this.addCriterion("postage_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdEqualTo(Long value) {
            this.addCriterion("postage_id =", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdNotEqualTo(Long value) {
            this.addCriterion("postage_id <>", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdGreaterThan(Long value) {
            this.addCriterion("postage_id >", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("postage_id >=", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdLessThan(Long value) {
            this.addCriterion("postage_id <", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("postage_id <=", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdLike(String value) {
            this.addCriterion("postage_id like", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdNotLike(String value) {
            this.addCriterion("postage_id not like", value, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andPostageIdIn(List<Long> values) {
            this.addCriterion("postage_id in", values, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdNotIn(List<Long> values) {
            this.addCriterion("postage_id not in", values, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdBetween(Long value1, Long value2) {
            this.addCriterion("postage_id between", value1, value2, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andPostageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("postage_id not between", value1, value2, "postageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualIsNull() {
            this.addCriterion("is_virtual is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualIsNotNull() {
            this.addCriterion("is_virtual is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualEqualTo(String value) {
            this.addCriterion("is_virtual =", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotEqualTo(String value) {
            this.addCriterion("is_virtual <>", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualGreaterThan(String value) {
            this.addCriterion("is_virtual >", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_virtual >=", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualLessThan(String value) {
            this.addCriterion("is_virtual <", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualLessThanOrEqualTo(String value) {
            this.addCriterion("is_virtual <=", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualLike(String value) {
            this.addCriterion("is_virtual like", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotLike(String value) {
            this.addCriterion("is_virtual not like", value, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andIsVirtualIn(List<String> values) {
            this.addCriterion("is_virtual in", values, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotIn(List<String> values) {
            this.addCriterion("is_virtual not in", values, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualBetween(String value1, String value2) {
            this.addCriterion("is_virtual between", value1, value2, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsVirtualNotBetween(String value1, String value2) {
            this.addCriterion("is_virtual not between", value1, value2, "isVirtual");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoIsNull() {
            this.addCriterion("is_taobao is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoIsNotNull() {
            this.addCriterion("is_taobao is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoEqualTo(String value) {
            this.addCriterion("is_taobao =", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotEqualTo(String value) {
            this.addCriterion("is_taobao <>", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoGreaterThan(String value) {
            this.addCriterion("is_taobao >", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_taobao >=", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoLessThan(String value) {
            this.addCriterion("is_taobao <", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoLessThanOrEqualTo(String value) {
            this.addCriterion("is_taobao <=", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoLike(String value) {
            this.addCriterion("is_taobao like", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotLike(String value) {
            this.addCriterion("is_taobao not like", value, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andIsTaobaoIn(List<String> values) {
            this.addCriterion("is_taobao in", values, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotIn(List<String> values) {
            this.addCriterion("is_taobao not in", values, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoBetween(String value1, String value2) {
            this.addCriterion("is_taobao between", value1, value2, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTaobaoNotBetween(String value1, String value2) {
            this.addCriterion("is_taobao not between", value1, value2, "isTaobao");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExIsNull() {
            this.addCriterion("is_ex is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExIsNotNull() {
            this.addCriterion("is_ex is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExEqualTo(String value) {
            this.addCriterion("is_ex =", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotEqualTo(String value) {
            this.addCriterion("is_ex <>", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExGreaterThan(String value) {
            this.addCriterion("is_ex >", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_ex >=", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExLessThan(String value) {
            this.addCriterion("is_ex <", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExLessThanOrEqualTo(String value) {
            this.addCriterion("is_ex <=", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExLike(String value) {
            this.addCriterion("is_ex like", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotLike(String value) {
            this.addCriterion("is_ex not like", value, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andIsExIn(List<String> values) {
            this.addCriterion("is_ex in", values, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotIn(List<String> values) {
            this.addCriterion("is_ex not in", values, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExBetween(String value1, String value2) {
            this.addCriterion("is_ex between", value1, value2, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsExNotBetween(String value1, String value2) {
            this.addCriterion("is_ex not between", value1, value2, "isEx");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingIsNull() {
            this.addCriterion("is_timing is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingIsNotNull() {
            this.addCriterion("is_timing is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingEqualTo(String value) {
            this.addCriterion("is_timing =", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotEqualTo(String value) {
            this.addCriterion("is_timing <>", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingGreaterThan(String value) {
            this.addCriterion("is_timing >", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_timing >=", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingLessThan(String value) {
            this.addCriterion("is_timing <", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingLessThanOrEqualTo(String value) {
            this.addCriterion("is_timing <=", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingLike(String value) {
            this.addCriterion("is_timing like", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotLike(String value) {
            this.addCriterion("is_timing not like", value, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andIsTimingIn(List<String> values) {
            this.addCriterion("is_timing in", values, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotIn(List<String> values) {
            this.addCriterion("is_timing not in", values, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingBetween(String value1, String value2) {
            this.addCriterion("is_timing between", value1, value2, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIsTimingNotBetween(String value1, String value2) {
            this.addCriterion("is_timing not between", value1, value2, "isTiming");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dIsNull() {
            this.addCriterion("is3d is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dIsNotNull() {
            this.addCriterion("is3d is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dEqualTo(String value) {
            this.addCriterion("is3d =", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotEqualTo(String value) {
            this.addCriterion("is3d <>", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dGreaterThan(String value) {
            this.addCriterion("is3d >", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dGreaterThanOrEqualTo(String value) {
            this.addCriterion("is3d >=", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dLessThan(String value) {
            this.addCriterion("is3d <", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dLessThanOrEqualTo(String value) {
            this.addCriterion("is3d <=", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dLike(String value) {
            this.addCriterion("is3d like", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotLike(String value) {
            this.addCriterion("is3d not like", value, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andIs3dIn(List<String> values) {
            this.addCriterion("is3d in", values, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotIn(List<String> values) {
            this.addCriterion("is3d not in", values, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dBetween(String value1, String value2) {
            this.addCriterion("is3d between", value1, value2, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andIs3dNotBetween(String value1, String value2) {
            this.addCriterion("is3d not between", value1, value2, "is3d");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationIsNull() {
            this.addCriterion("one_station is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationIsNotNull() {
            this.addCriterion("one_station is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationEqualTo(String value) {
            this.addCriterion("one_station =", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotEqualTo(String value) {
            this.addCriterion("one_station <>", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationGreaterThan(String value) {
            this.addCriterion("one_station >", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationGreaterThanOrEqualTo(String value) {
            this.addCriterion("one_station >=", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationLessThan(String value) {
            this.addCriterion("one_station <", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationLessThanOrEqualTo(String value) {
            this.addCriterion("one_station <=", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationLike(String value) {
            this.addCriterion("one_station like", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotLike(String value) {
            this.addCriterion("one_station not like", value, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andOneStationIn(List<String> values) {
            this.addCriterion("one_station in", values, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotIn(List<String> values) {
            this.addCriterion("one_station not in", values, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationBetween(String value1, String value2) {
            this.addCriterion("one_station between", value1, value2, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andOneStationNotBetween(String value1, String value2) {
            this.addCriterion("one_station not between", value1, value2, "oneStation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillIsNull() {
            this.addCriterion("second_kill is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillIsNotNull() {
            this.addCriterion("second_kill is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillEqualTo(String value) {
            this.addCriterion("second_kill =", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotEqualTo(String value) {
            this.addCriterion("second_kill <>", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillGreaterThan(String value) {
            this.addCriterion("second_kill >", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillGreaterThanOrEqualTo(String value) {
            this.addCriterion("second_kill >=", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillLessThan(String value) {
            this.addCriterion("second_kill <", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillLessThanOrEqualTo(String value) {
            this.addCriterion("second_kill <=", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillLike(String value) {
            this.addCriterion("second_kill like", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotLike(String value) {
            this.addCriterion("second_kill not like", value, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andSecondKillIn(List<String> values) {
            this.addCriterion("second_kill in", values, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotIn(List<String> values) {
            this.addCriterion("second_kill not in", values, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillBetween(String value1, String value2) {
            this.addCriterion("second_kill between", value1, value2, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSecondKillNotBetween(String value1, String value2) {
            this.addCriterion("second_kill not between", value1, value2, "secondKill");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationIsNull() {
            this.addCriterion("violation is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationIsNotNull() {
            this.addCriterion("violation is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationEqualTo(String value) {
            this.addCriterion("violation =", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotEqualTo(String value) {
            this.addCriterion("violation <>", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationGreaterThan(String value) {
            this.addCriterion("violation >", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationGreaterThanOrEqualTo(String value) {
            this.addCriterion("violation >=", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationLessThan(String value) {
            this.addCriterion("violation <", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationLessThanOrEqualTo(String value) {
            this.addCriterion("violation <=", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationLike(String value) {
            this.addCriterion("violation like", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotLike(String value) {
            this.addCriterion("violation not like", value, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andViolationIn(List<String> values) {
            this.addCriterion("violation in", values, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotIn(List<String> values) {
            this.addCriterion("violation not in", values, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationBetween(String value1, String value2) {
            this.addCriterion("violation between", value1, value2, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andViolationNotBetween(String value1, String value2) {
            this.addCriterion("violation not between", value1, value2, "violation");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescIsNull() {
            this.addCriterion("wap_desc is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescIsNotNull() {
            this.addCriterion("wap_desc is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescEqualTo(String value) {
            this.addCriterion("wap_desc =", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotEqualTo(String value) {
            this.addCriterion("wap_desc <>", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescGreaterThan(String value) {
            this.addCriterion("wap_desc >", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("wap_desc >=", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescLessThan(String value) {
            this.addCriterion("wap_desc <", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescLessThanOrEqualTo(String value) {
            this.addCriterion("wap_desc <=", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescLike(String value) {
            this.addCriterion("wap_desc like", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotLike(String value) {
            this.addCriterion("wap_desc not like", value, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andWapDescIn(List<String> values) {
            this.addCriterion("wap_desc in", values, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotIn(List<String> values) {
            this.addCriterion("wap_desc not in", values, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescBetween(String value1, String value2) {
            this.addCriterion("wap_desc between", value1, value2, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDescNotBetween(String value1, String value2) {
            this.addCriterion("wap_desc not between", value1, value2, "wapDesc");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlIsNull() {
            this.addCriterion("wap_detail_url is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlIsNotNull() {
            this.addCriterion("wap_detail_url is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlEqualTo(String value) {
            this.addCriterion("wap_detail_url =", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotEqualTo(String value) {
            this.addCriterion("wap_detail_url <>", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlGreaterThan(String value) {
            this.addCriterion("wap_detail_url >", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("wap_detail_url >=", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlLessThan(String value) {
            this.addCriterion("wap_detail_url <", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlLessThanOrEqualTo(String value) {
            this.addCriterion("wap_detail_url <=", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlLike(String value) {
            this.addCriterion("wap_detail_url like", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotLike(String value) {
            this.addCriterion("wap_detail_url not like", value, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlIn(List<String> values) {
            this.addCriterion("wap_detail_url in", values, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotIn(List<String> values) {
            this.addCriterion("wap_detail_url not in", values, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlBetween(String value1, String value2) {
            this.addCriterion("wap_detail_url between", value1, value2, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andWapDetailUrlNotBetween(String value1, String value2) {
            this.addCriterion("wap_detail_url not between", value1, value2, "wapDetailUrl");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdIsNull() {
            this.addCriterion("cod_postage_id is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdIsNotNull() {
            this.addCriterion("cod_postage_id is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdEqualTo(Long value) {
            this.addCriterion("cod_postage_id =", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdNotEqualTo(Long value) {
            this.addCriterion("cod_postage_id <>", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdGreaterThan(Long value) {
            this.addCriterion("cod_postage_id >", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cod_postage_id >=", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdLessThan(Long value) {
            this.addCriterion("cod_postage_id <", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cod_postage_id <=", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdLike(String value) {
            this.addCriterion("cod_postage_id like", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdNotLike(String value) {
            this.addCriterion("cod_postage_id not like", value, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andCodPostageIdIn(List<Long> values) {
            this.addCriterion("cod_postage_id in", values, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdNotIn(List<Long> values) {
            this.addCriterion("cod_postage_id not in", values, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdBetween(Long value1, Long value2) {
            this.addCriterion("cod_postage_id between", value1, value2, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andCodPostageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cod_postage_id not between", value1, value2, "codPostageId");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseIsNull() {
            this.addCriterion("sell_promise is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseIsNotNull() {
            this.addCriterion("sell_promise is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseEqualTo(String value) {
            this.addCriterion("sell_promise =", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotEqualTo(String value) {
            this.addCriterion("sell_promise <>", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseGreaterThan(String value) {
            this.addCriterion("sell_promise >", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseGreaterThanOrEqualTo(String value) {
            this.addCriterion("sell_promise >=", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseLessThan(String value) {
            this.addCriterion("sell_promise <", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseLessThanOrEqualTo(String value) {
            this.addCriterion("sell_promise <=", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseLike(String value) {
            this.addCriterion("sell_promise like", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotLike(String value) {
            this.addCriterion("sell_promise not like", value, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andSellPromiseIn(List<String> values) {
            this.addCriterion("sell_promise in", values, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotIn(List<String> values) {
            this.addCriterion("sell_promise not in", values, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseBetween(String value1, String value2) {
            this.addCriterion("sell_promise between", value1, value2, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSellPromiseNotBetween(String value1, String value2) {
            this.addCriterion("sell_promise not between", value1, value2, "sellPromise");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseIsNull() {
            this.addCriterion("nolose is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseIsNotNull() {
            this.addCriterion("nolose is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseEqualTo(Long value) {
            this.addCriterion("nolose =", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseNotEqualTo(Long value) {
            this.addCriterion("nolose <>", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseGreaterThan(Long value) {
            this.addCriterion("nolose >", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseGreaterThanOrEqualTo(Long value) {
            this.addCriterion("nolose >=", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseLessThan(Long value) {
            this.addCriterion("nolose <", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseLessThanOrEqualTo(Long value) {
            this.addCriterion("nolose <=", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseLike(String value) {
            this.addCriterion("nolose like", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseNotLike(String value) {
            this.addCriterion("nolose not like", value, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andNoloseIn(List<Long> values) {
            this.addCriterion("nolose in", values, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseNotIn(List<Long> values) {
            this.addCriterion("nolose not in", values, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseBetween(Long value1, Long value2) {
            this.addCriterion("nolose between", value1, value2, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andNoloseNotBetween(Long value1, Long value2) {
            this.addCriterion("nolose not between", value1, value2, "nolose");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateIsNull() {
            this.addCriterion("load_date is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateIsNotNull() {
            this.addCriterion("load_date is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateEqualTo(Date value) {
            this.addCriterion("load_date =", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateNotEqualTo(Date value) {
            this.addCriterion("load_date <>", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateGreaterThan(Date value) {
            this.addCriterion("load_date >", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("load_date >=", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateLessThan(Date value) {
            this.addCriterion("load_date <", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateLessThanOrEqualTo(Date value) {
            this.addCriterion("load_date <=", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateLike(String value) {
            this.addCriterion("load_date like", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateNotLike(String value) {
            this.addCriterion("load_date not like", value, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andLoadDateIn(List<Date> values) {
            this.addCriterion("load_date in", values, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateNotIn(List<Date> values) {
            this.addCriterion("load_date not in", values, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateBetween(Date value1, Date value2) {
            this.addCriterion("load_date between", value1, value2, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLoadDateNotBetween(Date value1, Date value2) {
            this.addCriterion("load_date not between", value1, value2, "loadDate");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeIsNull() {
            this.addCriterion("update_time is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeIsNotNull() {
            this.addCriterion("update_time is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeEqualTo(Date value) {
            this.addCriterion("update_time =", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            this.addCriterion("update_time <>", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeGreaterThan(Date value) {
            this.addCriterion("update_time >", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("update_time >=", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeLessThan(Date value) {
            this.addCriterion("update_time <", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("update_time <=", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeLike(String value) {
            this.addCriterion("update_time like", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeNotLike(String value) {
            this.addCriterion("update_time not like", value, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andUpdateTimeIn(List<Date> values) {
            this.addCriterion("update_time in", values, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            this.addCriterion("update_time not in", values, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            this.addCriterion("update_time between", value1, value2, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("update_time not between", value1, value2, "updateTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleIsNull() {
            this.addCriterion("subtitle is null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleIsNotNull() {
            this.addCriterion("subtitle is not null");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleEqualTo(String value) {
            this.addCriterion("subtitle =", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotEqualTo(String value) {
            this.addCriterion("subtitle <>", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleGreaterThan(String value) {
            this.addCriterion("subtitle >", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("subtitle >=", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleLessThan(String value) {
            this.addCriterion("subtitle <", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleLessThanOrEqualTo(String value) {
            this.addCriterion("subtitle <=", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleLike(String value) {
            this.addCriterion("subtitle like", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotLike(String value) {
            this.addCriterion("subtitle not like", value, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }        public ShiguGoodsExtendsExample.Criteria andSubtitleIn(List<String> values) {
            this.addCriterion("subtitle in", values, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotIn(List<String> values) {
            this.addCriterion("subtitle not in", values, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleBetween(String value1, String value2) {
            this.addCriterion("subtitle between", value1, value2, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }

        public ShiguGoodsExtendsExample.Criteria andSubtitleNotBetween(String value1, String value2) {
            this.addCriterion("subtitle not between", value1, value2, "subtitle");
            return (ShiguGoodsExtendsExample.Criteria)this;
        }
    }
}
