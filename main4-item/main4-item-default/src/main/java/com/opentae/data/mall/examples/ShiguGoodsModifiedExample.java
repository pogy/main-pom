package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguGoodsModifiedExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsModifiedExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsModifiedExample() {
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

    public List<ShiguGoodsModifiedExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsModifiedExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsModifiedExample.Criteria or() {
        ShiguGoodsModifiedExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsModifiedExample.Criteria createCriteria() {
        ShiguGoodsModifiedExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsModifiedExample.Criteria createCriteriaInternal() {
        ShiguGoodsModifiedExample.Criteria criteria = new ShiguGoodsModifiedExample.Criteria();
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

    public static class Criteria extends ShiguGoodsModifiedExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsModifiedExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsModifiedExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsModifiedExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsModifiedExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsModifiedExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsModifiedExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdIsNull() {
            this.addCriterion("item_id is null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdIsNotNull() {
            this.addCriterion("item_id is not null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdEqualTo(Long value) {
            this.addCriterion("item_id =", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdNotEqualTo(Long value) {
            this.addCriterion("item_id <>", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdGreaterThan(Long value) {
            this.addCriterion("item_id >", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("item_id >=", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdLessThan(Long value) {
            this.addCriterion("item_id <", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            this.addCriterion("item_id <=", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdLike(String value) {
            this.addCriterion("item_id like", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdNotLike(String value) {
            this.addCriterion("item_id not like", value, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }        public ShiguGoodsModifiedExample.Criteria andItemIdIn(List<Long> values) {
            this.addCriterion("item_id in", values, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdNotIn(List<Long> values) {
            this.addCriterion("item_id not in", values, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdBetween(Long value1, Long value2) {
            this.addCriterion("item_id between", value1, value2, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            this.addCriterion("item_id not between", value1, value2, "itemId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoIsNull() {
            this.addCriterion("has_set_goodsno is null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoIsNotNull() {
            this.addCriterion("has_set_goodsno is not null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoEqualTo(Integer value) {
            this.addCriterion("has_set_goodsno =", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoNotEqualTo(Integer value) {
            this.addCriterion("has_set_goodsno <>", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoGreaterThan(Integer value) {
            this.addCriterion("has_set_goodsno >", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_goodsno >=", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoLessThan(Integer value) {
            this.addCriterion("has_set_goodsno <", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoLessThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_goodsno <=", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoLike(String value) {
            this.addCriterion("has_set_goodsno like", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoNotLike(String value) {
            this.addCriterion("has_set_goodsno not like", value, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoIn(List<Integer> values) {
            this.addCriterion("has_set_goodsno in", values, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoNotIn(List<Integer> values) {
            this.addCriterion("has_set_goodsno not in", values, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_goodsno between", value1, value2, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_goodsno not between", value1, value2, "hasSetGoodsno");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdIsNull() {
            this.addCriterion("modify_id is null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdIsNotNull() {
            this.addCriterion("modify_id is not null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdEqualTo(Long value) {
            this.addCriterion("modify_id =", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdNotEqualTo(Long value) {
            this.addCriterion("modify_id <>", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdGreaterThan(Long value) {
            this.addCriterion("modify_id >", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("modify_id >=", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdLessThan(Long value) {
            this.addCriterion("modify_id <", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("modify_id <=", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdLike(String value) {
            this.addCriterion("modify_id like", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdNotLike(String value) {
            this.addCriterion("modify_id not like", value, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }        public ShiguGoodsModifiedExample.Criteria andModifyIdIn(List<Long> values) {
            this.addCriterion("modify_id in", values, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdNotIn(List<Long> values) {
            this.addCriterion("modify_id not in", values, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdBetween(Long value1, Long value2) {
            this.addCriterion("modify_id between", value1, value2, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("modify_id not between", value1, value2, "modifyId");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleIsNull() {
            this.addCriterion("has_set_title is null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleIsNotNull() {
            this.addCriterion("has_set_title is not null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleEqualTo(Integer value) {
            this.addCriterion("has_set_title =", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleNotEqualTo(Integer value) {
            this.addCriterion("has_set_title <>", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleGreaterThan(Integer value) {
            this.addCriterion("has_set_title >", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_title >=", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleLessThan(Integer value) {
            this.addCriterion("has_set_title <", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleLessThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_title <=", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleLike(String value) {
            this.addCriterion("has_set_title like", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleNotLike(String value) {
            this.addCriterion("has_set_title not like", value, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }        public ShiguGoodsModifiedExample.Criteria andHasSetTitleIn(List<Integer> values) {
            this.addCriterion("has_set_title in", values, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleNotIn(List<Integer> values) {
            this.addCriterion("has_set_title not in", values, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_title between", value1, value2, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleNotBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_title not between", value1, value2, "hasSetTitle");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockIsNull() {
            this.addCriterion("has_mod_instock is null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockIsNotNull() {
            this.addCriterion("has_mod_instock is not null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockEqualTo(Integer value) {
            this.addCriterion("has_mod_instock =", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockNotEqualTo(Integer value) {
            this.addCriterion("has_mod_instock <>", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockGreaterThan(Integer value) {
            this.addCriterion("has_mod_instock >", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("has_mod_instock >=", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockLessThan(Integer value) {
            this.addCriterion("has_mod_instock <", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockLessThanOrEqualTo(Integer value) {
            this.addCriterion("has_mod_instock <=", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockLike(String value) {
            this.addCriterion("has_mod_instock like", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockNotLike(String value) {
            this.addCriterion("has_mod_instock not like", value, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }        public ShiguGoodsModifiedExample.Criteria andHasModInstockIn(List<Integer> values) {
            this.addCriterion("has_mod_instock in", values, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockNotIn(List<Integer> values) {
            this.addCriterion("has_mod_instock not in", values, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockBetween(Integer value1, Integer value2) {
            this.addCriterion("has_mod_instock between", value1, value2, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockNotBetween(Integer value1, Integer value2) {
            this.addCriterion("has_mod_instock not between", value1, value2, "hasModInstock");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceIsNull() {
            this.addCriterion("has_set_price is null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceIsNotNull() {
            this.addCriterion("has_set_price is not null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceEqualTo(Integer value) {
            this.addCriterion("has_set_price =", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceNotEqualTo(Integer value) {
            this.addCriterion("has_set_price <>", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceGreaterThan(Integer value) {
            this.addCriterion("has_set_price >", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_price >=", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceLessThan(Integer value) {
            this.addCriterion("has_set_price <", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_price <=", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceLike(String value) {
            this.addCriterion("has_set_price like", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceNotLike(String value) {
            this.addCriterion("has_set_price not like", value, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }        public ShiguGoodsModifiedExample.Criteria andHasSetPriceIn(List<Integer> values) {
            this.addCriterion("has_set_price in", values, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceNotIn(List<Integer> values) {
            this.addCriterion("has_set_price not in", values, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_price between", value1, value2, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_price not between", value1, value2, "hasSetPrice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceIsNull() {
            this.addCriterion("has_set_piprice is null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceIsNotNull() {
            this.addCriterion("has_set_piprice is not null");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceEqualTo(Integer value) {
            this.addCriterion("has_set_piprice =", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceNotEqualTo(Integer value) {
            this.addCriterion("has_set_piprice <>", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceGreaterThan(Integer value) {
            this.addCriterion("has_set_piprice >", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_piprice >=", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceLessThan(Integer value) {
            this.addCriterion("has_set_piprice <", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("has_set_piprice <=", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceLike(String value) {
            this.addCriterion("has_set_piprice like", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceNotLike(String value) {
            this.addCriterion("has_set_piprice not like", value, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceIn(List<Integer> values) {
            this.addCriterion("has_set_piprice in", values, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceNotIn(List<Integer> values) {
            this.addCriterion("has_set_piprice not in", values, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_piprice between", value1, value2, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("has_set_piprice not between", value1, value2, "hasSetPiprice");
            return (ShiguGoodsModifiedExample.Criteria)this;
        }
    }
}
