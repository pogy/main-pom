package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatLocationExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatLocationExample.Criteria> oredCriteria = new ArrayList();

    public GoatLocationExample() {
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

    public List<GoatLocationExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatLocationExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatLocationExample.Criteria or() {
        GoatLocationExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatLocationExample.Criteria createCriteria() {
        GoatLocationExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatLocationExample.Criteria createCriteriaInternal() {
        GoatLocationExample.Criteria criteria = new GoatLocationExample.Criteria();
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

    public static class Criteria extends GoatLocationExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatLocationExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatLocationExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatLocationExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatLocationExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatLocationExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatLocationExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatLocationExample.Criteria andLocalIdIsNull() {
            this.addCriterion("local_id is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdIsNotNull() {
            this.addCriterion("local_id is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdEqualTo(Long value) {
            this.addCriterion("local_id =", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdNotEqualTo(Long value) {
            this.addCriterion("local_id <>", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdGreaterThan(Long value) {
            this.addCriterion("local_id >", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("local_id >=", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdLessThan(Long value) {
            this.addCriterion("local_id <", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdLessThanOrEqualTo(Long value) {
            this.addCriterion("local_id <=", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdLike(String value) {
            this.addCriterion("local_id like", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdNotLike(String value) {
            this.addCriterion("local_id not like", value, "localId");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andLocalIdIn(List<Long> values) {
            this.addCriterion("local_id in", values, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdNotIn(List<Long> values) {
            this.addCriterion("local_id not in", values, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdBetween(Long value1, Long value2) {
            this.addCriterion("local_id between", value1, value2, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalIdNotBetween(Long value1, Long value2) {
            this.addCriterion("local_id not between", value1, value2, "localId");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeIsNull() {
            this.addCriterion("local_code is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeIsNotNull() {
            this.addCriterion("local_code is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeEqualTo(String value) {
            this.addCriterion("local_code =", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeNotEqualTo(String value) {
            this.addCriterion("local_code <>", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeGreaterThan(String value) {
            this.addCriterion("local_code >", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("local_code >=", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeLessThan(String value) {
            this.addCriterion("local_code <", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeLessThanOrEqualTo(String value) {
            this.addCriterion("local_code <=", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeLike(String value) {
            this.addCriterion("local_code like", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeNotLike(String value) {
            this.addCriterion("local_code not like", value, "localCode");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andLocalCodeIn(List<String> values) {
            this.addCriterion("local_code in", values, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeNotIn(List<String> values) {
            this.addCriterion("local_code not in", values, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeBetween(String value1, String value2) {
            this.addCriterion("local_code between", value1, value2, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalCodeNotBetween(String value1, String value2) {
            this.addCriterion("local_code not between", value1, value2, "localCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeIsNull() {
            this.addCriterion("local_area_code is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeIsNotNull() {
            this.addCriterion("local_area_code is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeEqualTo(String value) {
            this.addCriterion("local_area_code =", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeNotEqualTo(String value) {
            this.addCriterion("local_area_code <>", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeGreaterThan(String value) {
            this.addCriterion("local_area_code >", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("local_area_code >=", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeLessThan(String value) {
            this.addCriterion("local_area_code <", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeLessThanOrEqualTo(String value) {
            this.addCriterion("local_area_code <=", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeLike(String value) {
            this.addCriterion("local_area_code like", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeNotLike(String value) {
            this.addCriterion("local_area_code not like", value, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andLocalAreaCodeIn(List<String> values) {
            this.addCriterion("local_area_code in", values, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeNotIn(List<String> values) {
            this.addCriterion("local_area_code not in", values, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeBetween(String value1, String value2) {
            this.addCriterion("local_area_code between", value1, value2, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andLocalAreaCodeNotBetween(String value1, String value2) {
            this.addCriterion("local_area_code not between", value1, value2, "localAreaCode");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineIsNull() {
            this.addCriterion("under_line is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineIsNotNull() {
            this.addCriterion("under_line is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineEqualTo(Boolean value) {
            this.addCriterion("under_line =", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineNotEqualTo(Boolean value) {
            this.addCriterion("under_line <>", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineGreaterThan(Boolean value) {
            this.addCriterion("under_line >", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("under_line >=", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineLessThan(Boolean value) {
            this.addCriterion("under_line <", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineLessThanOrEqualTo(Boolean value) {
            this.addCriterion("under_line <=", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineLike(String value) {
            this.addCriterion("under_line like", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineNotLike(String value) {
            this.addCriterion("under_line not like", value, "underLine");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andUnderLineIn(List<Boolean> values) {
            this.addCriterion("under_line in", values, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineNotIn(List<Boolean> values) {
            this.addCriterion("under_line not in", values, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineBetween(Boolean value1, Boolean value2) {
            this.addCriterion("under_line between", value1, value2, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andUnderLineNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("under_line not between", value1, value2, "underLine");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledIsNull() {
            this.addCriterion("dis_enabled is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledIsNotNull() {
            this.addCriterion("dis_enabled is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledEqualTo(Boolean value) {
            this.addCriterion("dis_enabled =", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledNotEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <>", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledGreaterThan(Boolean value) {
            this.addCriterion("dis_enabled >", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled >=", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledLessThan(Boolean value) {
            this.addCriterion("dis_enabled <", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <=", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledLike(String value) {
            this.addCriterion("dis_enabled like", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledNotLike(String value) {
            this.addCriterion("dis_enabled not like", value, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andDisEnabledIn(List<Boolean> values) {
            this.addCriterion("dis_enabled in", values, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledNotIn(List<Boolean> values) {
            this.addCriterion("dis_enabled not in", values, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled between", value1, value2, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDisEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled not between", value1, value2, "disEnabled");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionIsNull() {
            this.addCriterion("description is null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionIsNotNull() {
            this.addCriterion("description is not null");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionEqualTo(String value) {
            this.addCriterion("description =", value, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionNotEqualTo(String value) {
            this.addCriterion("description <>", value, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionGreaterThan(String value) {
            this.addCriterion("description >", value, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            this.addCriterion("description >=", value, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionLessThan(String value) {
            this.addCriterion("description <", value, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            this.addCriterion("description <=", value, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionLike(String value) {
            this.addCriterion("description like", value, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionNotLike(String value) {
            this.addCriterion("description not like", value, "description");
            return (GoatLocationExample.Criteria)this;
        }        public GoatLocationExample.Criteria andDescriptionIn(List<String> values) {
            this.addCriterion("description in", values, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionNotIn(List<String> values) {
            this.addCriterion("description not in", values, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionBetween(String value1, String value2) {
            this.addCriterion("description between", value1, value2, "description");
            return (GoatLocationExample.Criteria)this;
        }

        public GoatLocationExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            this.addCriterion("description not between", value1, value2, "description");
            return (GoatLocationExample.Criteria)this;
        }
    }
}
