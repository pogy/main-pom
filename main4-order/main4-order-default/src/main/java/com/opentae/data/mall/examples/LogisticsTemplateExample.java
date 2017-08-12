package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class LogisticsTemplateExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
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

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andFromCityIdIsNull() {
            this.addCriterion("from_city_id is null");
            return (Criteria)this;
        }

        public Criteria andFromCityIdIsNotNull() {
            this.addCriterion("from_city_id is not null");
            return (Criteria)this;
        }

        public Criteria andFromCityIdEqualTo(Long value) {
            this.addCriterion("from_city_id =", value, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdNotEqualTo(Long value) {
            this.addCriterion("from_city_id <>", value, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdGreaterThan(Long value) {
            this.addCriterion("from_city_id >", value, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("from_city_id >=", value, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdLessThan(Long value) {
            this.addCriterion("from_city_id <", value, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("from_city_id <=", value, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdLike(String value) {
            this.addCriterion("from_city_id like", value, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdNotLike(String value) {
            this.addCriterion("from_city_id not like", value, "fromCityId");
            return (Criteria)this;
        }        public Criteria andFromCityIdIn(List<Long> values) {
            this.addCriterion("from_city_id in", values, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdNotIn(List<Long> values) {
            this.addCriterion("from_city_id not in", values, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdBetween(Long value1, Long value2) {
            this.addCriterion("from_city_id between", value1, value2, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("from_city_id not between", value1, value2, "fromCityId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdIsNull() {
            this.addCriterion("from_town_id is null");
            return (Criteria)this;
        }

        public Criteria andFromTownIdIsNotNull() {
            this.addCriterion("from_town_id is not null");
            return (Criteria)this;
        }

        public Criteria andFromTownIdEqualTo(Long value) {
            this.addCriterion("from_town_id =", value, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdNotEqualTo(Long value) {
            this.addCriterion("from_town_id <>", value, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdGreaterThan(Long value) {
            this.addCriterion("from_town_id >", value, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("from_town_id >=", value, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdLessThan(Long value) {
            this.addCriterion("from_town_id <", value, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("from_town_id <=", value, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdLike(String value) {
            this.addCriterion("from_town_id like", value, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdNotLike(String value) {
            this.addCriterion("from_town_id not like", value, "fromTownId");
            return (Criteria)this;
        }        public Criteria andFromTownIdIn(List<Long> values) {
            this.addCriterion("from_town_id in", values, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdNotIn(List<Long> values) {
            this.addCriterion("from_town_id not in", values, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdBetween(Long value1, Long value2) {
            this.addCriterion("from_town_id between", value1, value2, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andFromTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("from_town_id not between", value1, value2, "fromTownId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdIsNull() {
            this.addCriterion("template_id is null");
            return (Criteria)this;
        }

        public Criteria andTemplateIdIsNotNull() {
            this.addCriterion("template_id is not null");
            return (Criteria)this;
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            this.addCriterion("template_id =", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            this.addCriterion("template_id <>", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            this.addCriterion("template_id >", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("template_id >=", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdLessThan(Long value) {
            this.addCriterion("template_id <", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("template_id <=", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdLike(String value) {
            this.addCriterion("template_id like", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            this.addCriterion("template_id not like", value, "templateId");
            return (Criteria)this;
        }        public Criteria andTemplateIdIn(List<Long> values) {
            this.addCriterion("template_id in", values, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            this.addCriterion("template_id not in", values, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            this.addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria)this;
        }

        public Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (Criteria)this;
        }

        public Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (Criteria)this;
        }

        public Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (Criteria)this;
        }        public Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (Criteria)this;
        }

        public Criteria andFromProvIdIsNull() {
            this.addCriterion("from_prov_id is null");
            return (Criteria)this;
        }

        public Criteria andFromProvIdIsNotNull() {
            this.addCriterion("from_prov_id is not null");
            return (Criteria)this;
        }

        public Criteria andFromProvIdEqualTo(Long value) {
            this.addCriterion("from_prov_id =", value, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdNotEqualTo(Long value) {
            this.addCriterion("from_prov_id <>", value, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdGreaterThan(Long value) {
            this.addCriterion("from_prov_id >", value, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("from_prov_id >=", value, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdLessThan(Long value) {
            this.addCriterion("from_prov_id <", value, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("from_prov_id <=", value, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdLike(String value) {
            this.addCriterion("from_prov_id like", value, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdNotLike(String value) {
            this.addCriterion("from_prov_id not like", value, "fromProvId");
            return (Criteria)this;
        }        public Criteria andFromProvIdIn(List<Long> values) {
            this.addCriterion("from_prov_id in", values, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdNotIn(List<Long> values) {
            this.addCriterion("from_prov_id not in", values, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdBetween(Long value1, Long value2) {
            this.addCriterion("from_prov_id between", value1, value2, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFromProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("from_prov_id not between", value1, value2, "fromProvId");
            return (Criteria)this;
        }

        public Criteria andFreeIsNull() {
            this.addCriterion("free is null");
            return (Criteria)this;
        }

        public Criteria andFreeIsNotNull() {
            this.addCriterion("free is not null");
            return (Criteria)this;
        }

        public Criteria andFreeEqualTo(Boolean value) {
            this.addCriterion("free =", value, "free");
            return (Criteria)this;
        }

        public Criteria andFreeNotEqualTo(Boolean value) {
            this.addCriterion("free <>", value, "free");
            return (Criteria)this;
        }

        public Criteria andFreeGreaterThan(Boolean value) {
            this.addCriterion("free >", value, "free");
            return (Criteria)this;
        }

        public Criteria andFreeGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("free >=", value, "free");
            return (Criteria)this;
        }

        public Criteria andFreeLessThan(Boolean value) {
            this.addCriterion("free <", value, "free");
            return (Criteria)this;
        }

        public Criteria andFreeLessThanOrEqualTo(Boolean value) {
            this.addCriterion("free <=", value, "free");
            return (Criteria)this;
        }

        public Criteria andFreeLike(String value) {
            this.addCriterion("free like", value, "free");
            return (Criteria)this;
        }

        public Criteria andFreeNotLike(String value) {
            this.addCriterion("free not like", value, "free");
            return (Criteria)this;
        }        public Criteria andFreeIn(List<Boolean> values) {
            this.addCriterion("free in", values, "free");
            return (Criteria)this;
        }

        public Criteria andFreeNotIn(List<Boolean> values) {
            this.addCriterion("free not in", values, "free");
            return (Criteria)this;
        }

        public Criteria andFreeBetween(Boolean value1, Boolean value2) {
            this.addCriterion("free between", value1, value2, "free");
            return (Criteria)this;
        }

        public Criteria andFreeNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("free not between", value1, value2, "free");
            return (Criteria)this;
        }

        public Criteria andSenderIdIsNull() {
            this.addCriterion("sender_id is null");
            return (Criteria)this;
        }

        public Criteria andSenderIdIsNotNull() {
            this.addCriterion("sender_id is not null");
            return (Criteria)this;
        }

        public Criteria andSenderIdEqualTo(Long value) {
            this.addCriterion("sender_id =", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotEqualTo(Long value) {
            this.addCriterion("sender_id <>", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdGreaterThan(Long value) {
            this.addCriterion("sender_id >", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sender_id >=", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdLessThan(Long value) {
            this.addCriterion("sender_id <", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sender_id <=", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdLike(String value) {
            this.addCriterion("sender_id like", value, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotLike(String value) {
            this.addCriterion("sender_id not like", value, "senderId");
            return (Criteria)this;
        }        public Criteria andSenderIdIn(List<Long> values) {
            this.addCriterion("sender_id in", values, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotIn(List<Long> values) {
            this.addCriterion("sender_id not in", values, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdBetween(Long value1, Long value2) {
            this.addCriterion("sender_id between", value1, value2, "senderId");
            return (Criteria)this;
        }

        public Criteria andSenderIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sender_id not between", value1, value2, "senderId");
            return (Criteria)this;
        }

        public Criteria andEnabledIsNull() {
            this.addCriterion("enabled is null");
            return (Criteria)this;
        }

        public Criteria andEnabledIsNotNull() {
            this.addCriterion("enabled is not null");
            return (Criteria)this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            this.addCriterion("enabled =", value, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            this.addCriterion("enabled <>", value, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            this.addCriterion("enabled >", value, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled >=", value, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            this.addCriterion("enabled <", value, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled <=", value, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledLike(String value) {
            this.addCriterion("enabled like", value, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledNotLike(String value) {
            this.addCriterion("enabled not like", value, "enabled");
            return (Criteria)this;
        }        public Criteria andEnabledIn(List<Boolean> values) {
            this.addCriterion("enabled in", values, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            this.addCriterion("enabled not in", values, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria)this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria)this;
        }
    }
}
