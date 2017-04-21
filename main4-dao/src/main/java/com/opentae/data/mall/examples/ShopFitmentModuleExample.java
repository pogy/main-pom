package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShopFitmentModuleExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShopFitmentModuleExample.Criteria> oredCriteria = new ArrayList();

    public ShopFitmentModuleExample() {
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

    public List<ShopFitmentModuleExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShopFitmentModuleExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShopFitmentModuleExample.Criteria or() {
        ShopFitmentModuleExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShopFitmentModuleExample.Criteria createCriteria() {
        ShopFitmentModuleExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShopFitmentModuleExample.Criteria createCriteriaInternal() {
        ShopFitmentModuleExample.Criteria criteria = new ShopFitmentModuleExample.Criteria();
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

    public static class Criteria extends ShopFitmentModuleExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShopFitmentModuleExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShopFitmentModuleExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShopFitmentModuleExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShopFitmentModuleExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShopFitmentModuleExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShopFitmentModuleExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShopFitmentModuleExample.Criteria andModuleIdIsNull() {
            this.addCriterion("module_id is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdIsNotNull() {
            this.addCriterion("module_id is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdEqualTo(Long value) {
            this.addCriterion("module_id =", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdNotEqualTo(Long value) {
            this.addCriterion("module_id <>", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdGreaterThan(Long value) {
            this.addCriterion("module_id >", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("module_id >=", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdLessThan(Long value) {
            this.addCriterion("module_id <", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("module_id <=", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdLike(String value) {
            this.addCriterion("module_id like", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdNotLike(String value) {
            this.addCriterion("module_id not like", value, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andModuleIdIn(List<Long> values) {
            this.addCriterion("module_id in", values, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdNotIn(List<Long> values) {
            this.addCriterion("module_id not in", values, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdBetween(Long value1, Long value2) {
            this.addCriterion("module_id between", value1, value2, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("module_id not between", value1, value2, "moduleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeIsNull() {
            this.addCriterion("side_type is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeIsNotNull() {
            this.addCriterion("side_type is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeEqualTo(Integer value) {
            this.addCriterion("side_type =", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeNotEqualTo(Integer value) {
            this.addCriterion("side_type <>", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeGreaterThan(Integer value) {
            this.addCriterion("side_type >", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("side_type >=", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeLessThan(Integer value) {
            this.addCriterion("side_type <", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("side_type <=", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeLike(String value) {
            this.addCriterion("side_type like", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeNotLike(String value) {
            this.addCriterion("side_type not like", value, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andSideTypeIn(List<Integer> values) {
            this.addCriterion("side_type in", values, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeNotIn(List<Integer> values) {
            this.addCriterion("side_type not in", values, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("side_type between", value1, value2, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andSideTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("side_type not between", value1, value2, "sideType");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdIsNull() {
            this.addCriterion("after_module_id is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdIsNotNull() {
            this.addCriterion("after_module_id is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdEqualTo(Long value) {
            this.addCriterion("after_module_id =", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdNotEqualTo(Long value) {
            this.addCriterion("after_module_id <>", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdGreaterThan(Long value) {
            this.addCriterion("after_module_id >", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("after_module_id >=", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdLessThan(Long value) {
            this.addCriterion("after_module_id <", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("after_module_id <=", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdLike(String value) {
            this.addCriterion("after_module_id like", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdNotLike(String value) {
            this.addCriterion("after_module_id not like", value, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andAfterModuleIdIn(List<Long> values) {
            this.addCriterion("after_module_id in", values, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdNotIn(List<Long> values) {
            this.addCriterion("after_module_id not in", values, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdBetween(Long value1, Long value2) {
            this.addCriterion("after_module_id between", value1, value2, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("after_module_id not between", value1, value2, "afterModuleId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdIsNull() {
            this.addCriterion("area_id is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdIsNotNull() {
            this.addCriterion("area_id is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdEqualTo(Long value) {
            this.addCriterion("area_id =", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdNotEqualTo(Long value) {
            this.addCriterion("area_id <>", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdGreaterThan(Long value) {
            this.addCriterion("area_id >", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("area_id >=", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdLessThan(Long value) {
            this.addCriterion("area_id <", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdLessThanOrEqualTo(Long value) {
            this.addCriterion("area_id <=", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdLike(String value) {
            this.addCriterion("area_id like", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdNotLike(String value) {
            this.addCriterion("area_id not like", value, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andAreaIdIn(List<Long> values) {
            this.addCriterion("area_id in", values, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdNotIn(List<Long> values) {
            this.addCriterion("area_id not in", values, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdBetween(Long value1, Long value2) {
            this.addCriterion("area_id between", value1, value2, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andAreaIdNotBetween(Long value1, Long value2) {
            this.addCriterion("area_id not between", value1, value2, "areaId");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueIsNull() {
            this.addCriterion("module_value is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueIsNotNull() {
            this.addCriterion("module_value is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueEqualTo(String value) {
            this.addCriterion("module_value =", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotEqualTo(String value) {
            this.addCriterion("module_value <>", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueGreaterThan(String value) {
            this.addCriterion("module_value >", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueGreaterThanOrEqualTo(String value) {
            this.addCriterion("module_value >=", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueLessThan(String value) {
            this.addCriterion("module_value <", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueLessThanOrEqualTo(String value) {
            this.addCriterion("module_value <=", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueLike(String value) {
            this.addCriterion("module_value like", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotLike(String value) {
            this.addCriterion("module_value not like", value, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andModuleValueIn(List<String> values) {
            this.addCriterion("module_value in", values, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotIn(List<String> values) {
            this.addCriterion("module_value not in", values, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueBetween(String value1, String value2) {
            this.addCriterion("module_value between", value1, value2, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotBetween(String value1, String value2) {
            this.addCriterion("module_value not between", value1, value2, "moduleValue");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataIsNull() {
            this.addCriterion("module_data is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataIsNotNull() {
            this.addCriterion("module_data is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataEqualTo(String value) {
            this.addCriterion("module_data =", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotEqualTo(String value) {
            this.addCriterion("module_data <>", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataGreaterThan(String value) {
            this.addCriterion("module_data >", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataGreaterThanOrEqualTo(String value) {
            this.addCriterion("module_data >=", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataLessThan(String value) {
            this.addCriterion("module_data <", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataLessThanOrEqualTo(String value) {
            this.addCriterion("module_data <=", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataLike(String value) {
            this.addCriterion("module_data like", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotLike(String value) {
            this.addCriterion("module_data not like", value, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andModuleDataIn(List<String> values) {
            this.addCriterion("module_data in", values, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotIn(List<String> values) {
            this.addCriterion("module_data not in", values, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataBetween(String value1, String value2) {
            this.addCriterion("module_data between", value1, value2, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotBetween(String value1, String value2) {
            this.addCriterion("module_data not between", value1, value2, "moduleData");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelIsNull() {
            this.addCriterion("can_del is null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelIsNotNull() {
            this.addCriterion("can_del is not null");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelEqualTo(Boolean value) {
            this.addCriterion("can_del =", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelNotEqualTo(Boolean value) {
            this.addCriterion("can_del <>", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelGreaterThan(Boolean value) {
            this.addCriterion("can_del >", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("can_del >=", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelLessThan(Boolean value) {
            this.addCriterion("can_del <", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelLessThanOrEqualTo(Boolean value) {
            this.addCriterion("can_del <=", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelLike(String value) {
            this.addCriterion("can_del like", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelNotLike(String value) {
            this.addCriterion("can_del not like", value, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }        public ShopFitmentModuleExample.Criteria andCanDelIn(List<Boolean> values) {
            this.addCriterion("can_del in", values, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelNotIn(List<Boolean> values) {
            this.addCriterion("can_del not in", values, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelBetween(Boolean value1, Boolean value2) {
            this.addCriterion("can_del between", value1, value2, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }

        public ShopFitmentModuleExample.Criteria andCanDelNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("can_del not between", value1, value2, "canDel");
            return (ShopFitmentModuleExample.Criteria)this;
        }
    }
}
