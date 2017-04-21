package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SpreadAuctScrenExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SpreadAuctScrenExample.Criteria> oredCriteria = new ArrayList();

    public SpreadAuctScrenExample() {
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

    public List<SpreadAuctScrenExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SpreadAuctScrenExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SpreadAuctScrenExample.Criteria or() {
        SpreadAuctScrenExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SpreadAuctScrenExample.Criteria createCriteria() {
        SpreadAuctScrenExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SpreadAuctScrenExample.Criteria createCriteriaInternal() {
        SpreadAuctScrenExample.Criteria criteria = new SpreadAuctScrenExample.Criteria();
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

    public static class Criteria extends SpreadAuctScrenExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SpreadAuctScrenExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SpreadAuctScrenExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SpreadAuctScrenExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SpreadAuctScrenExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SpreadAuctScrenExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SpreadAuctScrenExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SpreadAuctScrenExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdIsNull() {
            this.addCriterion("spread_pm_id is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdIsNotNull() {
            this.addCriterion("spread_pm_id is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdEqualTo(Long value) {
            this.addCriterion("spread_pm_id =", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdNotEqualTo(Long value) {
            this.addCriterion("spread_pm_id <>", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdGreaterThan(Long value) {
            this.addCriterion("spread_pm_id >", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("spread_pm_id >=", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdLessThan(Long value) {
            this.addCriterion("spread_pm_id <", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdLessThanOrEqualTo(Long value) {
            this.addCriterion("spread_pm_id <=", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdLike(String value) {
            this.addCriterion("spread_pm_id like", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdNotLike(String value) {
            this.addCriterion("spread_pm_id not like", value, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andSpreadPmIdIn(List<Long> values) {
            this.addCriterion("spread_pm_id in", values, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdNotIn(List<Long> values) {
            this.addCriterion("spread_pm_id not in", values, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdBetween(Long value1, Long value2) {
            this.addCriterion("spread_pm_id between", value1, value2, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andSpreadPmIdNotBetween(Long value1, Long value2) {
            this.addCriterion("spread_pm_id not between", value1, value2, "spreadPmId");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeIsNull() {
            this.addCriterion("start_time is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeIsNotNull() {
            this.addCriterion("start_time is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeEqualTo(Date value) {
            this.addCriterion("start_time =", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeNotEqualTo(Date value) {
            this.addCriterion("start_time <>", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeGreaterThan(Date value) {
            this.addCriterion("start_time >", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("start_time >=", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeLessThan(Date value) {
            this.addCriterion("start_time <", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("start_time <=", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeLike(String value) {
            this.addCriterion("start_time like", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeNotLike(String value) {
            this.addCriterion("start_time not like", value, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andStartTimeIn(List<Date> values) {
            this.addCriterion("start_time in", values, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeNotIn(List<Date> values) {
            this.addCriterion("start_time not in", values, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            this.addCriterion("start_time between", value1, value2, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("start_time not between", value1, value2, "startTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeIsNull() {
            this.addCriterion("end_time is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeIsNotNull() {
            this.addCriterion("end_time is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeEqualTo(Date value) {
            this.addCriterion("end_time =", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeNotEqualTo(Date value) {
            this.addCriterion("end_time <>", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeGreaterThan(Date value) {
            this.addCriterion("end_time >", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("end_time >=", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeLessThan(Date value) {
            this.addCriterion("end_time <", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("end_time <=", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeLike(String value) {
            this.addCriterion("end_time like", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeNotLike(String value) {
            this.addCriterion("end_time not like", value, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andEndTimeIn(List<Date> values) {
            this.addCriterion("end_time in", values, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeNotIn(List<Date> values) {
            this.addCriterion("end_time not in", values, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            this.addCriterion("end_time between", value1, value2, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("end_time not between", value1, value2, "endTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeIsNull() {
            this.addCriterion("next_scren_time is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeIsNotNull() {
            this.addCriterion("next_scren_time is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeEqualTo(Date value) {
            this.addCriterion("next_scren_time =", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeNotEqualTo(Date value) {
            this.addCriterion("next_scren_time <>", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeGreaterThan(Date value) {
            this.addCriterion("next_scren_time >", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("next_scren_time >=", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeLessThan(Date value) {
            this.addCriterion("next_scren_time <", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("next_scren_time <=", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeLike(String value) {
            this.addCriterion("next_scren_time like", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeNotLike(String value) {
            this.addCriterion("next_scren_time not like", value, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andNextScrenTimeIn(List<Date> values) {
            this.addCriterion("next_scren_time in", values, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeNotIn(List<Date> values) {
            this.addCriterion("next_scren_time not in", values, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeBetween(Date value1, Date value2) {
            this.addCriterion("next_scren_time between", value1, value2, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andNextScrenTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("next_scren_time not between", value1, value2, "nextScrenTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeIsNull() {
            this.addCriterion("delver_start_time is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeIsNotNull() {
            this.addCriterion("delver_start_time is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeEqualTo(Date value) {
            this.addCriterion("delver_start_time =", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeNotEqualTo(Date value) {
            this.addCriterion("delver_start_time <>", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeGreaterThan(Date value) {
            this.addCriterion("delver_start_time >", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("delver_start_time >=", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeLessThan(Date value) {
            this.addCriterion("delver_start_time <", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("delver_start_time <=", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeLike(String value) {
            this.addCriterion("delver_start_time like", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeNotLike(String value) {
            this.addCriterion("delver_start_time not like", value, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andDelverStartTimeIn(List<Date> values) {
            this.addCriterion("delver_start_time in", values, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeNotIn(List<Date> values) {
            this.addCriterion("delver_start_time not in", values, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeBetween(Date value1, Date value2) {
            this.addCriterion("delver_start_time between", value1, value2, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverStartTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("delver_start_time not between", value1, value2, "delverStartTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeIsNull() {
            this.addCriterion("delver_end_time is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeIsNotNull() {
            this.addCriterion("delver_end_time is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeEqualTo(Date value) {
            this.addCriterion("delver_end_time =", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeNotEqualTo(Date value) {
            this.addCriterion("delver_end_time <>", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeGreaterThan(Date value) {
            this.addCriterion("delver_end_time >", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("delver_end_time >=", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeLessThan(Date value) {
            this.addCriterion("delver_end_time <", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("delver_end_time <=", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeLike(String value) {
            this.addCriterion("delver_end_time like", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeNotLike(String value) {
            this.addCriterion("delver_end_time not like", value, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andDelverEndTimeIn(List<Date> values) {
            this.addCriterion("delver_end_time in", values, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeNotIn(List<Date> values) {
            this.addCriterion("delver_end_time not in", values, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeBetween(Date value1, Date value2) {
            this.addCriterion("delver_end_time between", value1, value2, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andDelverEndTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("delver_end_time not between", value1, value2, "delverEndTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeIsNull() {
            this.addCriterion("modify_time is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeIsNotNull() {
            this.addCriterion("modify_time is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeEqualTo(Date value) {
            this.addCriterion("modify_time =", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeNotEqualTo(Date value) {
            this.addCriterion("modify_time <>", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeGreaterThan(Date value) {
            this.addCriterion("modify_time >", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modify_time >=", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeLessThan(Date value) {
            this.addCriterion("modify_time <", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("modify_time <=", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeLike(String value) {
            this.addCriterion("modify_time like", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeNotLike(String value) {
            this.addCriterion("modify_time not like", value, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andModifyTimeIn(List<Date> values) {
            this.addCriterion("modify_time in", values, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeNotIn(List<Date> values) {
            this.addCriterion("modify_time not in", values, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("modify_time between", value1, value2, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledIsNull() {
            this.addCriterion("enabled is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledIsNotNull() {
            this.addCriterion("enabled is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledEqualTo(Boolean value) {
            this.addCriterion("enabled =", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledNotEqualTo(Boolean value) {
            this.addCriterion("enabled <>", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledGreaterThan(Boolean value) {
            this.addCriterion("enabled >", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled >=", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledLessThan(Boolean value) {
            this.addCriterion("enabled <", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled <=", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledLike(String value) {
            this.addCriterion("enabled like", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledNotLike(String value) {
            this.addCriterion("enabled not like", value, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andEnabledIn(List<Boolean> values) {
            this.addCriterion("enabled in", values, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledNotIn(List<Boolean> values) {
            this.addCriterion("enabled not in", values, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled between", value1, value2, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled not between", value1, value2, "enabled");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescIsNull() {
            this.addCriterion("active_rule_desc is null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescIsNotNull() {
            this.addCriterion("active_rule_desc is not null");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescEqualTo(String value) {
            this.addCriterion("active_rule_desc =", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescNotEqualTo(String value) {
            this.addCriterion("active_rule_desc <>", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescGreaterThan(String value) {
            this.addCriterion("active_rule_desc >", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("active_rule_desc >=", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescLessThan(String value) {
            this.addCriterion("active_rule_desc <", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescLessThanOrEqualTo(String value) {
            this.addCriterion("active_rule_desc <=", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescLike(String value) {
            this.addCriterion("active_rule_desc like", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescNotLike(String value) {
            this.addCriterion("active_rule_desc not like", value, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }        public SpreadAuctScrenExample.Criteria andActiveRuleDescIn(List<String> values) {
            this.addCriterion("active_rule_desc in", values, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescNotIn(List<String> values) {
            this.addCriterion("active_rule_desc not in", values, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescBetween(String value1, String value2) {
            this.addCriterion("active_rule_desc between", value1, value2, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }

        public SpreadAuctScrenExample.Criteria andActiveRuleDescNotBetween(String value1, String value2) {
            this.addCriterion("active_rule_desc not between", value1, value2, "activeRuleDesc");
            return (SpreadAuctScrenExample.Criteria)this;
        }
    }
}
