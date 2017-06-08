package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class LogisticsTemplateExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<LogisticsTemplateExample.Criteria> oredCriteria = new ArrayList();

    public LogisticsTemplateExample() {
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

    public List<LogisticsTemplateExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(LogisticsTemplateExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public LogisticsTemplateExample.Criteria or() {
        LogisticsTemplateExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public LogisticsTemplateExample.Criteria createCriteria() {
        LogisticsTemplateExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected LogisticsTemplateExample.Criteria createCriteriaInternal() {
        LogisticsTemplateExample.Criteria criteria = new LogisticsTemplateExample.Criteria();
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

    public static class Criteria extends LogisticsTemplateExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<LogisticsTemplateExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<LogisticsTemplateExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<LogisticsTemplateExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new LogisticsTemplateExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public LogisticsTemplateExample.Criteria andFromCityIdIsNull() {
            this.addCriterion("fromCityId is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdIsNotNull() {
            this.addCriterion("fromCityId is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdEqualTo(Long value) {
            this.addCriterion("fromCityId =", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdNotEqualTo(Long value) {
            this.addCriterion("fromCityId <>", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdGreaterThan(Long value) {
            this.addCriterion("fromCityId >", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("fromCityId >=", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdLessThan(Long value) {
            this.addCriterion("fromCityId <", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("fromCityId <=", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdLike(String value) {
            this.addCriterion("fromCityId like", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdNotLike(String value) {
            this.addCriterion("fromCityId not like", value, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andFromCityIdIn(List<Long> values) {
            this.addCriterion("fromCityId in", values, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdNotIn(List<Long> values) {
            this.addCriterion("fromCityId not in", values, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdBetween(Long value1, Long value2) {
            this.addCriterion("fromCityId between", value1, value2, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("fromCityId not between", value1, value2, "from_city_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdIsNull() {
            this.addCriterion("fromTownId is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdIsNotNull() {
            this.addCriterion("fromTownId is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdEqualTo(Long value) {
            this.addCriterion("fromTownId =", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdNotEqualTo(Long value) {
            this.addCriterion("fromTownId <>", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdGreaterThan(Long value) {
            this.addCriterion("fromTownId >", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("fromTownId >=", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdLessThan(Long value) {
            this.addCriterion("fromTownId <", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("fromTownId <=", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdLike(String value) {
            this.addCriterion("fromTownId like", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdNotLike(String value) {
            this.addCriterion("fromTownId not like", value, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andFromTownIdIn(List<Long> values) {
            this.addCriterion("fromTownId in", values, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdNotIn(List<Long> values) {
            this.addCriterion("fromTownId not in", values, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdBetween(Long value1, Long value2) {
            this.addCriterion("fromTownId between", value1, value2, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("fromTownId not between", value1, value2, "from_town_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdIsNull() {
            this.addCriterion("templateId is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdIsNotNull() {
            this.addCriterion("templateId is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdEqualTo(Long value) {
            this.addCriterion("templateId =", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdNotEqualTo(Long value) {
            this.addCriterion("templateId <>", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdGreaterThan(Long value) {
            this.addCriterion("templateId >", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("templateId >=", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdLessThan(Long value) {
            this.addCriterion("templateId <", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("templateId <=", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdLike(String value) {
            this.addCriterion("templateId like", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdNotLike(String value) {
            this.addCriterion("templateId not like", value, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andTemplateIdIn(List<Long> values) {
            this.addCriterion("templateId in", values, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdNotIn(List<Long> values) {
            this.addCriterion("templateId not in", values, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            this.addCriterion("templateId between", value1, value2, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("templateId not between", value1, value2, "template_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdIsNull() {
            this.addCriterion("fromProvId is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdIsNotNull() {
            this.addCriterion("fromProvId is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdEqualTo(Long value) {
            this.addCriterion("fromProvId =", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdNotEqualTo(Long value) {
            this.addCriterion("fromProvId <>", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdGreaterThan(Long value) {
            this.addCriterion("fromProvId >", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("fromProvId >=", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdLessThan(Long value) {
            this.addCriterion("fromProvId <", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("fromProvId <=", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdLike(String value) {
            this.addCriterion("fromProvId like", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdNotLike(String value) {
            this.addCriterion("fromProvId not like", value, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andFromProvIdIn(List<Long> values) {
            this.addCriterion("fromProvId in", values, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdNotIn(List<Long> values) {
            this.addCriterion("fromProvId not in", values, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdBetween(Long value1, Long value2) {
            this.addCriterion("fromProvId between", value1, value2, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFromProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("fromProvId not between", value1, value2, "from_prov_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeIsNull() {
            this.addCriterion("free is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeIsNotNull() {
            this.addCriterion("free is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeEqualTo(Boolean value) {
            this.addCriterion("free =", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeNotEqualTo(Boolean value) {
            this.addCriterion("free <>", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeGreaterThan(Boolean value) {
            this.addCriterion("free >", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("free >=", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeLessThan(Boolean value) {
            this.addCriterion("free <", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeLessThanOrEqualTo(Boolean value) {
            this.addCriterion("free <=", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeLike(String value) {
            this.addCriterion("free like", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeNotLike(String value) {
            this.addCriterion("free not like", value, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andFreeIn(List<Boolean> values) {
            this.addCriterion("free in", values, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeNotIn(List<Boolean> values) {
            this.addCriterion("free not in", values, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeBetween(Boolean value1, Boolean value2) {
            this.addCriterion("free between", value1, value2, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andFreeNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("free not between", value1, value2, "free");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdIsNull() {
            this.addCriterion("senderId is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdIsNotNull() {
            this.addCriterion("senderId is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("senderId =", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("senderId <>", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("senderId >", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("senderId >=", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("senderId <", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("senderId <=", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdLike(String value) {
            this.addCriterion("senderId like", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdNotLike(String value) {
            this.addCriterion("senderId not like", value, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("senderId in", values, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("senderId not in", values, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("senderId between", value1, value2, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("senderId not between", value1, value2, "sender_id");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledIsNull() {
            this.addCriterion("enabled is null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledIsNotNull() {
            this.addCriterion("enabled is not null");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledEqualTo(Boolean value) {
            this.addCriterion("enabled =", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledNotEqualTo(Boolean value) {
            this.addCriterion("enabled <>", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledGreaterThan(Boolean value) {
            this.addCriterion("enabled >", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled >=", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledLessThan(Boolean value) {
            this.addCriterion("enabled <", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled <=", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledLike(String value) {
            this.addCriterion("enabled like", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledNotLike(String value) {
            this.addCriterion("enabled not like", value, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }        public LogisticsTemplateExample.Criteria andEnabledIn(List<Boolean> values) {
            this.addCriterion("enabled in", values, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledNotIn(List<Boolean> values) {
            this.addCriterion("enabled not in", values, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled between", value1, value2, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }

        public LogisticsTemplateExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled not between", value1, value2, "enabled");
            return (LogisticsTemplateExample.Criteria)this;
        }
    }
}
