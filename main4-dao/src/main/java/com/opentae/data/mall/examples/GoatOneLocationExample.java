package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatOneLocationExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatOneLocationExample.Criteria> oredCriteria = new ArrayList();

    public GoatOneLocationExample() {
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

    public List<GoatOneLocationExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatOneLocationExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatOneLocationExample.Criteria or() {
        GoatOneLocationExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatOneLocationExample.Criteria createCriteria() {
        GoatOneLocationExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatOneLocationExample.Criteria createCriteriaInternal() {
        GoatOneLocationExample.Criteria criteria = new GoatOneLocationExample.Criteria();
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

    public static class Criteria extends GoatOneLocationExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatOneLocationExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatOneLocationExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatOneLocationExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatOneLocationExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatOneLocationExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatOneLocationExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatOneLocationExample.Criteria andLocalIdIsNull() {
            this.addCriterion("local_id is null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdIsNotNull() {
            this.addCriterion("local_id is not null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdEqualTo(Long value) {
            this.addCriterion("local_id =", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdNotEqualTo(Long value) {
            this.addCriterion("local_id <>", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdGreaterThan(Long value) {
            this.addCriterion("local_id >", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("local_id >=", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdLessThan(Long value) {
            this.addCriterion("local_id <", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdLessThanOrEqualTo(Long value) {
            this.addCriterion("local_id <=", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdLike(String value) {
            this.addCriterion("local_id like", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdNotLike(String value) {
            this.addCriterion("local_id not like", value, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }        public GoatOneLocationExample.Criteria andLocalIdIn(List<Long> values) {
            this.addCriterion("local_id in", values, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdNotIn(List<Long> values) {
            this.addCriterion("local_id not in", values, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdBetween(Long value1, Long value2) {
            this.addCriterion("local_id between", value1, value2, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalIdNotBetween(Long value1, Long value2) {
            this.addCriterion("local_id not between", value1, value2, "localId");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeIsNull() {
            this.addCriterion("local_code is null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeIsNotNull() {
            this.addCriterion("local_code is not null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeEqualTo(String value) {
            this.addCriterion("local_code =", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotEqualTo(String value) {
            this.addCriterion("local_code <>", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeGreaterThan(String value) {
            this.addCriterion("local_code >", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("local_code >=", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeLessThan(String value) {
            this.addCriterion("local_code <", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeLessThanOrEqualTo(String value) {
            this.addCriterion("local_code <=", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeLike(String value) {
            this.addCriterion("local_code like", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotLike(String value) {
            this.addCriterion("local_code not like", value, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }        public GoatOneLocationExample.Criteria andLocalCodeIn(List<String> values) {
            this.addCriterion("local_code in", values, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotIn(List<String> values) {
            this.addCriterion("local_code not in", values, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeBetween(String value1, String value2) {
            this.addCriterion("local_code between", value1, value2, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotBetween(String value1, String value2) {
            this.addCriterion("local_code not between", value1, value2, "localCode");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionIsNull() {
            this.addCriterion("description is null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionIsNotNull() {
            this.addCriterion("description is not null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionEqualTo(String value) {
            this.addCriterion("description =", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionNotEqualTo(String value) {
            this.addCriterion("description <>", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionGreaterThan(String value) {
            this.addCriterion("description >", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            this.addCriterion("description >=", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionLessThan(String value) {
            this.addCriterion("description <", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            this.addCriterion("description <=", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionLike(String value) {
            this.addCriterion("description like", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionNotLike(String value) {
            this.addCriterion("description not like", value, "description");
            return (GoatOneLocationExample.Criteria)this;
        }        public GoatOneLocationExample.Criteria andDescriptionIn(List<String> values) {
            this.addCriterion("description in", values, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionNotIn(List<String> values) {
            this.addCriterion("description not in", values, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionBetween(String value1, String value2) {
            this.addCriterion("description between", value1, value2, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            this.addCriterion("description not between", value1, value2, "description");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }        public GoatOneLocationExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledIsNull() {
            this.addCriterion("dis_enabled is null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledIsNotNull() {
            this.addCriterion("dis_enabled is not null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledEqualTo(Boolean value) {
            this.addCriterion("dis_enabled =", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledNotEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <>", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledGreaterThan(Boolean value) {
            this.addCriterion("dis_enabled >", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled >=", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledLessThan(Boolean value) {
            this.addCriterion("dis_enabled <", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <=", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledLike(String value) {
            this.addCriterion("dis_enabled like", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledNotLike(String value) {
            this.addCriterion("dis_enabled not like", value, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }        public GoatOneLocationExample.Criteria andDisEnabledIn(List<Boolean> values) {
            this.addCriterion("dis_enabled in", values, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledNotIn(List<Boolean> values) {
            this.addCriterion("dis_enabled not in", values, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled between", value1, value2, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andDisEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled not between", value1, value2, "disEnabled");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }        public GoatOneLocationExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }

        public GoatOneLocationExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (GoatOneLocationExample.Criteria)this;
        }
    }
}
