package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguOuterFloorExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguOuterFloorExample.Criteria> oredCriteria = new ArrayList();

    public ShiguOuterFloorExample() {
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

    public List<ShiguOuterFloorExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguOuterFloorExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguOuterFloorExample.Criteria or() {
        ShiguOuterFloorExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguOuterFloorExample.Criteria createCriteria() {
        ShiguOuterFloorExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguOuterFloorExample.Criteria createCriteriaInternal() {
        ShiguOuterFloorExample.Criteria criteria = new ShiguOuterFloorExample.Criteria();
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

    public static class Criteria extends ShiguOuterFloorExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguOuterFloorExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguOuterFloorExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguOuterFloorExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguOuterFloorExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguOuterFloorExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguOuterFloorExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdIsNull() {
            this.addCriterion("outer_floor_id is null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdIsNotNull() {
            this.addCriterion("outer_floor_id is not null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdEqualTo(Long value) {
            this.addCriterion("outer_floor_id =", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdNotEqualTo(Long value) {
            this.addCriterion("outer_floor_id <>", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdGreaterThan(Long value) {
            this.addCriterion("outer_floor_id >", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("outer_floor_id >=", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdLessThan(Long value) {
            this.addCriterion("outer_floor_id <", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdLessThanOrEqualTo(Long value) {
            this.addCriterion("outer_floor_id <=", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdLike(String value) {
            this.addCriterion("outer_floor_id like", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdNotLike(String value) {
            this.addCriterion("outer_floor_id not like", value, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }        public ShiguOuterFloorExample.Criteria andOuterFloorIdIn(List<Long> values) {
            this.addCriterion("outer_floor_id in", values, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdNotIn(List<Long> values) {
            this.addCriterion("outer_floor_id not in", values, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdBetween(Long value1, Long value2) {
            this.addCriterion("outer_floor_id between", value1, value2, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdNotBetween(Long value1, Long value2) {
            this.addCriterion("outer_floor_id not between", value1, value2, "outerFloorId");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsIsNull() {
            this.addCriterion("floor_ids is null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsIsNotNull() {
            this.addCriterion("floor_ids is not null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsEqualTo(String value) {
            this.addCriterion("floor_ids =", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotEqualTo(String value) {
            this.addCriterion("floor_ids <>", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsGreaterThan(String value) {
            this.addCriterion("floor_ids >", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsGreaterThanOrEqualTo(String value) {
            this.addCriterion("floor_ids >=", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsLessThan(String value) {
            this.addCriterion("floor_ids <", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsLessThanOrEqualTo(String value) {
            this.addCriterion("floor_ids <=", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsLike(String value) {
            this.addCriterion("floor_ids like", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotLike(String value) {
            this.addCriterion("floor_ids not like", value, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }        public ShiguOuterFloorExample.Criteria andFloorIdsIn(List<String> values) {
            this.addCriterion("floor_ids in", values, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotIn(List<String> values) {
            this.addCriterion("floor_ids not in", values, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsBetween(String value1, String value2) {
            this.addCriterion("floor_ids between", value1, value2, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotBetween(String value1, String value2) {
            this.addCriterion("floor_ids not between", value1, value2, "floorIds");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameIsNull() {
            this.addCriterion("show_name is null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameIsNotNull() {
            this.addCriterion("show_name is not null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameEqualTo(String value) {
            this.addCriterion("show_name =", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotEqualTo(String value) {
            this.addCriterion("show_name <>", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameGreaterThan(String value) {
            this.addCriterion("show_name >", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("show_name >=", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameLessThan(String value) {
            this.addCriterion("show_name <", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameLessThanOrEqualTo(String value) {
            this.addCriterion("show_name <=", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameLike(String value) {
            this.addCriterion("show_name like", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotLike(String value) {
            this.addCriterion("show_name not like", value, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }        public ShiguOuterFloorExample.Criteria andShowNameIn(List<String> values) {
            this.addCriterion("show_name in", values, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotIn(List<String> values) {
            this.addCriterion("show_name not in", values, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameBetween(String value1, String value2) {
            this.addCriterion("show_name between", value1, value2, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotBetween(String value1, String value2) {
            this.addCriterion("show_name not between", value1, value2, "showName");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopIsNull() {
            this.addCriterion("added_shop is null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopIsNotNull() {
            this.addCriterion("added_shop is not null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopEqualTo(String value) {
            this.addCriterion("added_shop =", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotEqualTo(String value) {
            this.addCriterion("added_shop <>", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopGreaterThan(String value) {
            this.addCriterion("added_shop >", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopGreaterThanOrEqualTo(String value) {
            this.addCriterion("added_shop >=", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopLessThan(String value) {
            this.addCriterion("added_shop <", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopLessThanOrEqualTo(String value) {
            this.addCriterion("added_shop <=", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopLike(String value) {
            this.addCriterion("added_shop like", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotLike(String value) {
            this.addCriterion("added_shop not like", value, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }        public ShiguOuterFloorExample.Criteria andAddedShopIn(List<String> values) {
            this.addCriterion("added_shop in", values, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotIn(List<String> values) {
            this.addCriterion("added_shop not in", values, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopBetween(String value1, String value2) {
            this.addCriterion("added_shop between", value1, value2, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotBetween(String value1, String value2) {
            this.addCriterion("added_shop not between", value1, value2, "addedShop");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderEqualTo(Integer value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderNotEqualTo(Integer value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderGreaterThan(Integer value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderLessThan(Integer value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }        public ShiguOuterFloorExample.Criteria andSortOrderIn(List<Integer> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderNotIn(List<Integer> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }

        public ShiguOuterFloorExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguOuterFloorExample.Criteria)this;
        }
    }
}
