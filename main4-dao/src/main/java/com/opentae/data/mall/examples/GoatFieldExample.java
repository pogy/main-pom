package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatFieldExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatFieldExample.Criteria> oredCriteria = new ArrayList();

    public GoatFieldExample() {
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

    public List<GoatFieldExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatFieldExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatFieldExample.Criteria or() {
        GoatFieldExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatFieldExample.Criteria createCriteria() {
        GoatFieldExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatFieldExample.Criteria createCriteriaInternal() {
        GoatFieldExample.Criteria criteria = new GoatFieldExample.Criteria();
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

    public static class Criteria extends GoatFieldExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatFieldExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatFieldExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatFieldExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatFieldExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatFieldExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatFieldExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatFieldExample.Criteria andFidIsNull() {
            this.addCriterion("fid is null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidIsNotNull() {
            this.addCriterion("fid is not null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidEqualTo(Long value) {
            this.addCriterion("fid =", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidNotEqualTo(Long value) {
            this.addCriterion("fid <>", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidGreaterThan(Long value) {
            this.addCriterion("fid >", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("fid >=", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidLessThan(Long value) {
            this.addCriterion("fid <", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidLessThanOrEqualTo(Long value) {
            this.addCriterion("fid <=", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidLike(String value) {
            this.addCriterion("fid like", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidNotLike(String value) {
            this.addCriterion("fid not like", value, "fid");
            return (GoatFieldExample.Criteria)this;
        }        public GoatFieldExample.Criteria andFidIn(List<Long> values) {
            this.addCriterion("fid in", values, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidNotIn(List<Long> values) {
            this.addCriterion("fid not in", values, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidBetween(Long value1, Long value2) {
            this.addCriterion("fid between", value1, value2, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFidNotBetween(Long value1, Long value2) {
            this.addCriterion("fid not between", value1, value2, "fid");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (GoatFieldExample.Criteria)this;
        }        public GoatFieldExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeIsNull() {
            this.addCriterion("field_type is null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeIsNotNull() {
            this.addCriterion("field_type is not null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeEqualTo(Integer value) {
            this.addCriterion("field_type =", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeNotEqualTo(Integer value) {
            this.addCriterion("field_type <>", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeGreaterThan(Integer value) {
            this.addCriterion("field_type >", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("field_type >=", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeLessThan(Integer value) {
            this.addCriterion("field_type <", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("field_type <=", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeLike(String value) {
            this.addCriterion("field_type like", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeNotLike(String value) {
            this.addCriterion("field_type not like", value, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }        public GoatFieldExample.Criteria andFieldTypeIn(List<Integer> values) {
            this.addCriterion("field_type in", values, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeNotIn(List<Integer> values) {
            this.addCriterion("field_type not in", values, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("field_type between", value1, value2, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("field_type not between", value1, value2, "fieldType");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveIsNull() {
            this.addCriterion("must_have is null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveIsNotNull() {
            this.addCriterion("must_have is not null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveEqualTo(Boolean value) {
            this.addCriterion("must_have =", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveNotEqualTo(Boolean value) {
            this.addCriterion("must_have <>", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveGreaterThan(Boolean value) {
            this.addCriterion("must_have >", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("must_have >=", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveLessThan(Boolean value) {
            this.addCriterion("must_have <", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveLessThanOrEqualTo(Boolean value) {
            this.addCriterion("must_have <=", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveLike(String value) {
            this.addCriterion("must_have like", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveNotLike(String value) {
            this.addCriterion("must_have not like", value, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }        public GoatFieldExample.Criteria andMustHaveIn(List<Boolean> values) {
            this.addCriterion("must_have in", values, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveNotIn(List<Boolean> values) {
            this.addCriterion("must_have not in", values, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveBetween(Boolean value1, Boolean value2) {
            this.addCriterion("must_have between", value1, value2, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMustHaveNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("must_have not between", value1, value2, "mustHave");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthIsNull() {
            this.addCriterion("max_length is null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthIsNotNull() {
            this.addCriterion("max_length is not null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthEqualTo(Integer value) {
            this.addCriterion("max_length =", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthNotEqualTo(Integer value) {
            this.addCriterion("max_length <>", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthGreaterThan(Integer value) {
            this.addCriterion("max_length >", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("max_length >=", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthLessThan(Integer value) {
            this.addCriterion("max_length <", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthLessThanOrEqualTo(Integer value) {
            this.addCriterion("max_length <=", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthLike(String value) {
            this.addCriterion("max_length like", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthNotLike(String value) {
            this.addCriterion("max_length not like", value, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }        public GoatFieldExample.Criteria andMaxLengthIn(List<Integer> values) {
            this.addCriterion("max_length in", values, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthNotIn(List<Integer> values) {
            this.addCriterion("max_length not in", values, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthBetween(Integer value1, Integer value2) {
            this.addCriterion("max_length between", value1, value2, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andMaxLengthNotBetween(Integer value1, Integer value2) {
            this.addCriterion("max_length not between", value1, value2, "maxLength");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdIsNull() {
            this.addCriterion("location_id is null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdIsNotNull() {
            this.addCriterion("location_id is not null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdEqualTo(Long value) {
            this.addCriterion("location_id =", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdNotEqualTo(Long value) {
            this.addCriterion("location_id <>", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdGreaterThan(Long value) {
            this.addCriterion("location_id >", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("location_id >=", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdLessThan(Long value) {
            this.addCriterion("location_id <", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdLessThanOrEqualTo(Long value) {
            this.addCriterion("location_id <=", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdLike(String value) {
            this.addCriterion("location_id like", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdNotLike(String value) {
            this.addCriterion("location_id not like", value, "locationId");
            return (GoatFieldExample.Criteria)this;
        }        public GoatFieldExample.Criteria andLocationIdIn(List<Long> values) {
            this.addCriterion("location_id in", values, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdNotIn(List<Long> values) {
            this.addCriterion("location_id not in", values, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdBetween(Long value1, Long value2) {
            this.addCriterion("location_id between", value1, value2, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andLocationIdNotBetween(Long value1, Long value2) {
            this.addCriterion("location_id not between", value1, value2, "locationId");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameIsNull() {
            this.addCriterion("field_name is null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameIsNotNull() {
            this.addCriterion("field_name is not null");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameEqualTo(String value) {
            this.addCriterion("field_name =", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameNotEqualTo(String value) {
            this.addCriterion("field_name <>", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameGreaterThan(String value) {
            this.addCriterion("field_name >", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("field_name >=", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameLessThan(String value) {
            this.addCriterion("field_name <", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameLessThanOrEqualTo(String value) {
            this.addCriterion("field_name <=", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameLike(String value) {
            this.addCriterion("field_name like", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameNotLike(String value) {
            this.addCriterion("field_name not like", value, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }        public GoatFieldExample.Criteria andFieldNameIn(List<String> values) {
            this.addCriterion("field_name in", values, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameNotIn(List<String> values) {
            this.addCriterion("field_name not in", values, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameBetween(String value1, String value2) {
            this.addCriterion("field_name between", value1, value2, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }

        public GoatFieldExample.Criteria andFieldNameNotBetween(String value1, String value2) {
            this.addCriterion("field_name not between", value1, value2, "fieldName");
            return (GoatFieldExample.Criteria)this;
        }
    }
}
