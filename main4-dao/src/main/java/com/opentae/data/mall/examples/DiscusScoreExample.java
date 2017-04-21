package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiscusScoreExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<DiscusScoreExample.Criteria> oredCriteria = new ArrayList();

    public DiscusScoreExample() {
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

    public List<DiscusScoreExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(DiscusScoreExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public DiscusScoreExample.Criteria or() {
        DiscusScoreExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public DiscusScoreExample.Criteria createCriteria() {
        DiscusScoreExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected DiscusScoreExample.Criteria createCriteriaInternal() {
        DiscusScoreExample.Criteria criteria = new DiscusScoreExample.Criteria();
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

    public static class Criteria extends DiscusScoreExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<DiscusScoreExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<DiscusScoreExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<DiscusScoreExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new DiscusScoreExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new DiscusScoreExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new DiscusScoreExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public DiscusScoreExample.Criteria andDsIdIsNull() {
            this.addCriterion("ds_id is null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdIsNotNull() {
            this.addCriterion("ds_id is not null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdEqualTo(Long value) {
            this.addCriterion("ds_id =", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdNotEqualTo(Long value) {
            this.addCriterion("ds_id <>", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdGreaterThan(Long value) {
            this.addCriterion("ds_id >", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("ds_id >=", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdLessThan(Long value) {
            this.addCriterion("ds_id <", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("ds_id <=", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdLike(String value) {
            this.addCriterion("ds_id like", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdNotLike(String value) {
            this.addCriterion("ds_id not like", value, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }        public DiscusScoreExample.Criteria andDsIdIn(List<Long> values) {
            this.addCriterion("ds_id in", values, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdNotIn(List<Long> values) {
            this.addCriterion("ds_id not in", values, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdBetween(Long value1, Long value2) {
            this.addCriterion("ds_id between", value1, value2, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andDsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("ds_id not between", value1, value2, "dsId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }        public DiscusScoreExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }        public DiscusScoreExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (DiscusScoreExample.Criteria)this;
        }        public DiscusScoreExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumIsNull() {
            this.addCriterion("score_num is null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumIsNotNull() {
            this.addCriterion("score_num is not null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumEqualTo(Integer value) {
            this.addCriterion("score_num =", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumNotEqualTo(Integer value) {
            this.addCriterion("score_num <>", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumGreaterThan(Integer value) {
            this.addCriterion("score_num >", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("score_num >=", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumLessThan(Integer value) {
            this.addCriterion("score_num <", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("score_num <=", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumLike(String value) {
            this.addCriterion("score_num like", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumNotLike(String value) {
            this.addCriterion("score_num not like", value, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }        public DiscusScoreExample.Criteria andScoreNumIn(List<Integer> values) {
            this.addCriterion("score_num in", values, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumNotIn(List<Integer> values) {
            this.addCriterion("score_num not in", values, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumBetween(Integer value1, Integer value2) {
            this.addCriterion("score_num between", value1, value2, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andScoreNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("score_num not between", value1, value2, "scoreNum");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeIsNull() {
            this.addCriterion("created_time is null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeIsNotNull() {
            this.addCriterion("created_time is not null");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeEqualTo(Date value) {
            this.addCriterion("created_time =", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeNotEqualTo(Date value) {
            this.addCriterion("created_time <>", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeGreaterThan(Date value) {
            this.addCriterion("created_time >", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("created_time >=", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeLessThan(Date value) {
            this.addCriterion("created_time <", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("created_time <=", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeLike(String value) {
            this.addCriterion("created_time like", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeNotLike(String value) {
            this.addCriterion("created_time not like", value, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }        public DiscusScoreExample.Criteria andCreatedTimeIn(List<Date> values) {
            this.addCriterion("created_time in", values, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeNotIn(List<Date> values) {
            this.addCriterion("created_time not in", values, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeBetween(Date value1, Date value2) {
            this.addCriterion("created_time between", value1, value2, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }

        public DiscusScoreExample.Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("created_time not between", value1, value2, "createdTime");
            return (DiscusScoreExample.Criteria)this;
        }
    }
}
