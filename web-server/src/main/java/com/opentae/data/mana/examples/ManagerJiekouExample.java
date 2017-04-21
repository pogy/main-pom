package com.opentae.data.mana.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerJiekouExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ManagerJiekouExample.Criteria> oredCriteria = new ArrayList();

    public ManagerJiekouExample() {
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

    public List<ManagerJiekouExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ManagerJiekouExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ManagerJiekouExample.Criteria or() {
        ManagerJiekouExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ManagerJiekouExample.Criteria createCriteria() {
        ManagerJiekouExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ManagerJiekouExample.Criteria createCriteriaInternal() {
        ManagerJiekouExample.Criteria criteria = new ManagerJiekouExample.Criteria();
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

    public static class Criteria extends ManagerJiekouExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ManagerJiekouExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ManagerJiekouExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ManagerJiekouExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ManagerJiekouExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ManagerJiekouExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ManagerJiekouExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ManagerJiekouExample.Criteria andJkIdIsNull() {
            this.addCriterion("jk_id is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdIsNotNull() {
            this.addCriterion("jk_id is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdEqualTo(Long value) {
            this.addCriterion("jk_id =", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdNotEqualTo(Long value) {
            this.addCriterion("jk_id <>", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdGreaterThan(Long value) {
            this.addCriterion("jk_id >", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("jk_id >=", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdLessThan(Long value) {
            this.addCriterion("jk_id <", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdLessThanOrEqualTo(Long value) {
            this.addCriterion("jk_id <=", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdLike(String value) {
            this.addCriterion("jk_id like", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdNotLike(String value) {
            this.addCriterion("jk_id not like", value, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andJkIdIn(List<Long> values) {
            this.addCriterion("jk_id in", values, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdNotIn(List<Long> values) {
            this.addCriterion("jk_id not in", values, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdBetween(Long value1, Long value2) {
            this.addCriterion("jk_id between", value1, value2, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andJkIdNotBetween(Long value1, Long value2) {
            this.addCriterion("jk_id not between", value1, value2, "jkId");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyIsNull() {
            this.addCriterion("appkey is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyIsNotNull() {
            this.addCriterion("appkey is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyEqualTo(String value) {
            this.addCriterion("appkey =", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyNotEqualTo(String value) {
            this.addCriterion("appkey <>", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyGreaterThan(String value) {
            this.addCriterion("appkey >", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("appkey >=", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyLessThan(String value) {
            this.addCriterion("appkey <", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyLessThanOrEqualTo(String value) {
            this.addCriterion("appkey <=", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyLike(String value) {
            this.addCriterion("appkey like", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyNotLike(String value) {
            this.addCriterion("appkey not like", value, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andAppkeyIn(List<String> values) {
            this.addCriterion("appkey in", values, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyNotIn(List<String> values) {
            this.addCriterion("appkey not in", values, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyBetween(String value1, String value2) {
            this.addCriterion("appkey between", value1, value2, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andAppkeyNotBetween(String value1, String value2) {
            this.addCriterion("appkey not between", value1, value2, "appkey");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretIsNull() {
            this.addCriterion("secret is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretIsNotNull() {
            this.addCriterion("secret is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretEqualTo(String value) {
            this.addCriterion("secret =", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretNotEqualTo(String value) {
            this.addCriterion("secret <>", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretGreaterThan(String value) {
            this.addCriterion("secret >", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretGreaterThanOrEqualTo(String value) {
            this.addCriterion("secret >=", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretLessThan(String value) {
            this.addCriterion("secret <", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretLessThanOrEqualTo(String value) {
            this.addCriterion("secret <=", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretLike(String value) {
            this.addCriterion("secret like", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretNotLike(String value) {
            this.addCriterion("secret not like", value, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andSecretIn(List<String> values) {
            this.addCriterion("secret in", values, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretNotIn(List<String> values) {
            this.addCriterion("secret not in", values, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretBetween(String value1, String value2) {
            this.addCriterion("secret between", value1, value2, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andSecretNotBetween(String value1, String value2) {
            this.addCriterion("secret not between", value1, value2, "secret");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformIsNull() {
            this.addCriterion("platform is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformIsNotNull() {
            this.addCriterion("platform is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformEqualTo(String value) {
            this.addCriterion("platform =", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformNotEqualTo(String value) {
            this.addCriterion("platform <>", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformGreaterThan(String value) {
            this.addCriterion("platform >", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformGreaterThanOrEqualTo(String value) {
            this.addCriterion("platform >=", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformLessThan(String value) {
            this.addCriterion("platform <", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformLessThanOrEqualTo(String value) {
            this.addCriterion("platform <=", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformLike(String value) {
            this.addCriterion("platform like", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformNotLike(String value) {
            this.addCriterion("platform not like", value, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andPlatformIn(List<String> values) {
            this.addCriterion("platform in", values, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformNotIn(List<String> values) {
            this.addCriterion("platform not in", values, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformBetween(String value1, String value2) {
            this.addCriterion("platform between", value1, value2, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andPlatformNotBetween(String value1, String value2) {
            this.addCriterion("platform not between", value1, value2, "platform");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlIsNull() {
            this.addCriterion("head_url is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlIsNotNull() {
            this.addCriterion("head_url is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlEqualTo(String value) {
            this.addCriterion("head_url =", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlNotEqualTo(String value) {
            this.addCriterion("head_url <>", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlGreaterThan(String value) {
            this.addCriterion("head_url >", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("head_url >=", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlLessThan(String value) {
            this.addCriterion("head_url <", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlLessThanOrEqualTo(String value) {
            this.addCriterion("head_url <=", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlLike(String value) {
            this.addCriterion("head_url like", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlNotLike(String value) {
            this.addCriterion("head_url not like", value, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andHeadUrlIn(List<String> values) {
            this.addCriterion("head_url in", values, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlNotIn(List<String> values) {
            this.addCriterion("head_url not in", values, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlBetween(String value1, String value2) {
            this.addCriterion("head_url between", value1, value2, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andHeadUrlNotBetween(String value1, String value2) {
            this.addCriterion("head_url not between", value1, value2, "headUrl");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkIsNull() {
            this.addCriterion("remark is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkIsNotNull() {
            this.addCriterion("remark is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkEqualTo(String value) {
            this.addCriterion("remark =", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkNotEqualTo(String value) {
            this.addCriterion("remark <>", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkGreaterThan(String value) {
            this.addCriterion("remark >", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("remark >=", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkLessThan(String value) {
            this.addCriterion("remark <", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            this.addCriterion("remark <=", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkLike(String value) {
            this.addCriterion("remark like", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkNotLike(String value) {
            this.addCriterion("remark not like", value, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andRemarkIn(List<String> values) {
            this.addCriterion("remark in", values, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkNotIn(List<String> values) {
            this.addCriterion("remark not in", values, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkBetween(String value1, String value2) {
            this.addCriterion("remark between", value1, value2, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andRemarkNotBetween(String value1, String value2) {
            this.addCriterion("remark not between", value1, value2, "remark");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (ManagerJiekouExample.Criteria)this;
        }        public ManagerJiekouExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (ManagerJiekouExample.Criteria)this;
        }

        public ManagerJiekouExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (ManagerJiekouExample.Criteria)this;
        }
    }
}
