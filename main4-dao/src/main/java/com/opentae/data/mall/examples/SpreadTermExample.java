package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SpreadTermExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SpreadTermExample.Criteria> oredCriteria = new ArrayList();

    public SpreadTermExample() {
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

    public List<SpreadTermExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SpreadTermExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SpreadTermExample.Criteria or() {
        SpreadTermExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SpreadTermExample.Criteria createCriteria() {
        SpreadTermExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SpreadTermExample.Criteria createCriteriaInternal() {
        SpreadTermExample.Criteria criteria = new SpreadTermExample.Criteria();
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

    public static class Criteria extends SpreadTermExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SpreadTermExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SpreadTermExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SpreadTermExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SpreadTermExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SpreadTermExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SpreadTermExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SpreadTermExample.Criteria andTermIdIsNull() {
            this.addCriterion("term_id is null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdIsNotNull() {
            this.addCriterion("term_id is not null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdEqualTo(Long value) {
            this.addCriterion("term_id =", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdNotEqualTo(Long value) {
            this.addCriterion("term_id <>", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdGreaterThan(Long value) {
            this.addCriterion("term_id >", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("term_id >=", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdLessThan(Long value) {
            this.addCriterion("term_id <", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdLessThanOrEqualTo(Long value) {
            this.addCriterion("term_id <=", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdLike(String value) {
            this.addCriterion("term_id like", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdNotLike(String value) {
            this.addCriterion("term_id not like", value, "termId");
            return (SpreadTermExample.Criteria)this;
        }        public SpreadTermExample.Criteria andTermIdIn(List<Long> values) {
            this.addCriterion("term_id in", values, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdNotIn(List<Long> values) {
            this.addCriterion("term_id not in", values, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdBetween(Long value1, Long value2) {
            this.addCriterion("term_id between", value1, value2, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTermIdNotBetween(Long value1, Long value2) {
            this.addCriterion("term_id not between", value1, value2, "termId");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeIsNull() {
            this.addCriterion("start_time is null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeIsNotNull() {
            this.addCriterion("start_time is not null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeEqualTo(Date value) {
            this.addCriterion("start_time =", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeNotEqualTo(Date value) {
            this.addCriterion("start_time <>", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeGreaterThan(Date value) {
            this.addCriterion("start_time >", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("start_time >=", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeLessThan(Date value) {
            this.addCriterion("start_time <", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("start_time <=", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeLike(String value) {
            this.addCriterion("start_time like", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeNotLike(String value) {
            this.addCriterion("start_time not like", value, "startTime");
            return (SpreadTermExample.Criteria)this;
        }        public SpreadTermExample.Criteria andStartTimeIn(List<Date> values) {
            this.addCriterion("start_time in", values, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeNotIn(List<Date> values) {
            this.addCriterion("start_time not in", values, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            this.addCriterion("start_time between", value1, value2, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("start_time not between", value1, value2, "startTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeIsNull() {
            this.addCriterion("end_time is null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeIsNotNull() {
            this.addCriterion("end_time is not null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeEqualTo(Date value) {
            this.addCriterion("end_time =", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeNotEqualTo(Date value) {
            this.addCriterion("end_time <>", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeGreaterThan(Date value) {
            this.addCriterion("end_time >", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("end_time >=", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeLessThan(Date value) {
            this.addCriterion("end_time <", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("end_time <=", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeLike(String value) {
            this.addCriterion("end_time like", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeNotLike(String value) {
            this.addCriterion("end_time not like", value, "endTime");
            return (SpreadTermExample.Criteria)this;
        }        public SpreadTermExample.Criteria andEndTimeIn(List<Date> values) {
            this.addCriterion("end_time in", values, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeNotIn(List<Date> values) {
            this.addCriterion("end_time not in", values, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            this.addCriterion("end_time between", value1, value2, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("end_time not between", value1, value2, "endTime");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (SpreadTermExample.Criteria)this;
        }        public SpreadTermExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (SpreadTermExample.Criteria)this;
        }

        public SpreadTermExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (SpreadTermExample.Criteria)this;
        }
    }
}
