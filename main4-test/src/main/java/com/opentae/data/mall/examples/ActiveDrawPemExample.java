package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ActiveDrawPemExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ActiveDrawPemExample.Criteria> oredCriteria = new ArrayList();

    public ActiveDrawPemExample() {
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

    public List<ActiveDrawPemExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ActiveDrawPemExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ActiveDrawPemExample.Criteria or() {
        ActiveDrawPemExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ActiveDrawPemExample.Criteria createCriteria() {
        ActiveDrawPemExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ActiveDrawPemExample.Criteria createCriteriaInternal() {
        ActiveDrawPemExample.Criteria criteria = new ActiveDrawPemExample.Criteria();
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

    public static class Criteria extends ActiveDrawPemExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ActiveDrawPemExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ActiveDrawPemExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ActiveDrawPemExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ActiveDrawPemExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ActiveDrawPemExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ActiveDrawPemExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ActiveDrawPemExample.Criteria andStartTimeIsNull() {
            this.addCriterion("start_time is null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeIsNotNull() {
            this.addCriterion("start_time is not null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeEqualTo(Date value) {
            this.addCriterion("start_time =", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeNotEqualTo(Date value) {
            this.addCriterion("start_time <>", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeGreaterThan(Date value) {
            this.addCriterion("start_time >", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("start_time >=", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeLessThan(Date value) {
            this.addCriterion("start_time <", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("start_time <=", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeLike(String value) {
            this.addCriterion("start_time like", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeNotLike(String value) {
            this.addCriterion("start_time not like", value, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }        public ActiveDrawPemExample.Criteria andStartTimeIn(List<Date> values) {
            this.addCriterion("start_time in", values, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeNotIn(List<Date> values) {
            this.addCriterion("start_time not in", values, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            this.addCriterion("start_time between", value1, value2, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("start_time not between", value1, value2, "startTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }        public ActiveDrawPemExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermIsNull() {
            this.addCriterion("term is null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermIsNotNull() {
            this.addCriterion("term is not null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermEqualTo(Integer value) {
            this.addCriterion("term =", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermNotEqualTo(Integer value) {
            this.addCriterion("term <>", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermGreaterThan(Integer value) {
            this.addCriterion("term >", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("term >=", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermLessThan(Integer value) {
            this.addCriterion("term <", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermLessThanOrEqualTo(Integer value) {
            this.addCriterion("term <=", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermLike(String value) {
            this.addCriterion("term like", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermNotLike(String value) {
            this.addCriterion("term not like", value, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }        public ActiveDrawPemExample.Criteria andTermIn(List<Integer> values) {
            this.addCriterion("term in", values, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermNotIn(List<Integer> values) {
            this.addCriterion("term not in", values, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermBetween(Integer value1, Integer value2) {
            this.addCriterion("term between", value1, value2, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andTermNotBetween(Integer value1, Integer value2) {
            this.addCriterion("term not between", value1, value2, "term");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }        public ActiveDrawPemExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoIsNull() {
            this.addCriterion("info is null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoIsNotNull() {
            this.addCriterion("info is not null");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoEqualTo(String value) {
            this.addCriterion("info =", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoNotEqualTo(String value) {
            this.addCriterion("info <>", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoGreaterThan(String value) {
            this.addCriterion("info >", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoGreaterThanOrEqualTo(String value) {
            this.addCriterion("info >=", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoLessThan(String value) {
            this.addCriterion("info <", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoLessThanOrEqualTo(String value) {
            this.addCriterion("info <=", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoLike(String value) {
            this.addCriterion("info like", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoNotLike(String value) {
            this.addCriterion("info not like", value, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }        public ActiveDrawPemExample.Criteria andInfoIn(List<String> values) {
            this.addCriterion("info in", values, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoNotIn(List<String> values) {
            this.addCriterion("info not in", values, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoBetween(String value1, String value2) {
            this.addCriterion("info between", value1, value2, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }

        public ActiveDrawPemExample.Criteria andInfoNotBetween(String value1, String value2) {
            this.addCriterion("info not between", value1, value2, "info");
            return (ActiveDrawPemExample.Criteria)this;
        }
    }
}
