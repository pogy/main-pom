package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaobaoSessionMapExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public TaobaoSessionMapExample() {
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

        public Criteria andTsmIdIsNull() {
            this.addCriterion("tsm_id is null");
            return (Criteria)this;
        }

        public Criteria andTsmIdIsNotNull() {
            this.addCriterion("tsm_id is not null");
            return (Criteria)this;
        }

        public Criteria andTsmIdEqualTo(Long value) {
            this.addCriterion("tsm_id =", value, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdNotEqualTo(Long value) {
            this.addCriterion("tsm_id <>", value, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdGreaterThan(Long value) {
            this.addCriterion("tsm_id >", value, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("tsm_id >=", value, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdLessThan(Long value) {
            this.addCriterion("tsm_id <", value, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdLessThanOrEqualTo(Long value) {
            this.addCriterion("tsm_id <=", value, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdLike(String value) {
            this.addCriterion("tsm_id like", value, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdNotLike(String value) {
            this.addCriterion("tsm_id not like", value, "tsmId");
            return (Criteria)this;
        }        public Criteria andTsmIdIn(List<Long> values) {
            this.addCriterion("tsm_id in", values, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdNotIn(List<Long> values) {
            this.addCriterion("tsm_id not in", values, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdBetween(Long value1, Long value2) {
            this.addCriterion("tsm_id between", value1, value2, "tsmId");
            return (Criteria)this;
        }

        public Criteria andTsmIdNotBetween(Long value1, Long value2) {
            this.addCriterion("tsm_id not between", value1, value2, "tsmId");
            return (Criteria)this;
        }

        public Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (Criteria)this;
        }

        public Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (Criteria)this;
        }

        public Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (Criteria)this;
        }        public Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (Criteria)this;
        }

        public Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (Criteria)this;
        }

        public Criteria andAppkeyIsNull() {
            this.addCriterion("appkey is null");
            return (Criteria)this;
        }

        public Criteria andAppkeyIsNotNull() {
            this.addCriterion("appkey is not null");
            return (Criteria)this;
        }

        public Criteria andAppkeyEqualTo(String value) {
            this.addCriterion("appkey =", value, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyNotEqualTo(String value) {
            this.addCriterion("appkey <>", value, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyGreaterThan(String value) {
            this.addCriterion("appkey >", value, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("appkey >=", value, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyLessThan(String value) {
            this.addCriterion("appkey <", value, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyLessThanOrEqualTo(String value) {
            this.addCriterion("appkey <=", value, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyLike(String value) {
            this.addCriterion("appkey like", value, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyNotLike(String value) {
            this.addCriterion("appkey not like", value, "appkey");
            return (Criteria)this;
        }        public Criteria andAppkeyIn(List<String> values) {
            this.addCriterion("appkey in", values, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyNotIn(List<String> values) {
            this.addCriterion("appkey not in", values, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyBetween(String value1, String value2) {
            this.addCriterion("appkey between", value1, value2, "appkey");
            return (Criteria)this;
        }

        public Criteria andAppkeyNotBetween(String value1, String value2) {
            this.addCriterion("appkey not between", value1, value2, "appkey");
            return (Criteria)this;
        }

        public Criteria andSecretIsNull() {
            this.addCriterion("secret is null");
            return (Criteria)this;
        }

        public Criteria andSecretIsNotNull() {
            this.addCriterion("secret is not null");
            return (Criteria)this;
        }

        public Criteria andSecretEqualTo(String value) {
            this.addCriterion("secret =", value, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretNotEqualTo(String value) {
            this.addCriterion("secret <>", value, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretGreaterThan(String value) {
            this.addCriterion("secret >", value, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretGreaterThanOrEqualTo(String value) {
            this.addCriterion("secret >=", value, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretLessThan(String value) {
            this.addCriterion("secret <", value, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretLessThanOrEqualTo(String value) {
            this.addCriterion("secret <=", value, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretLike(String value) {
            this.addCriterion("secret like", value, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretNotLike(String value) {
            this.addCriterion("secret not like", value, "secret");
            return (Criteria)this;
        }        public Criteria andSecretIn(List<String> values) {
            this.addCriterion("secret in", values, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretNotIn(List<String> values) {
            this.addCriterion("secret not in", values, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretBetween(String value1, String value2) {
            this.addCriterion("secret between", value1, value2, "secret");
            return (Criteria)this;
        }

        public Criteria andSecretNotBetween(String value1, String value2) {
            this.addCriterion("secret not between", value1, value2, "secret");
            return (Criteria)this;
        }

        public Criteria andSessionIsNull() {
            this.addCriterion("session is null");
            return (Criteria)this;
        }

        public Criteria andSessionIsNotNull() {
            this.addCriterion("session is not null");
            return (Criteria)this;
        }

        public Criteria andSessionEqualTo(String value) {
            this.addCriterion("session =", value, "session");
            return (Criteria)this;
        }

        public Criteria andSessionNotEqualTo(String value) {
            this.addCriterion("session <>", value, "session");
            return (Criteria)this;
        }

        public Criteria andSessionGreaterThan(String value) {
            this.addCriterion("session >", value, "session");
            return (Criteria)this;
        }

        public Criteria andSessionGreaterThanOrEqualTo(String value) {
            this.addCriterion("session >=", value, "session");
            return (Criteria)this;
        }

        public Criteria andSessionLessThan(String value) {
            this.addCriterion("session <", value, "session");
            return (Criteria)this;
        }

        public Criteria andSessionLessThanOrEqualTo(String value) {
            this.addCriterion("session <=", value, "session");
            return (Criteria)this;
        }

        public Criteria andSessionLike(String value) {
            this.addCriterion("session like", value, "session");
            return (Criteria)this;
        }

        public Criteria andSessionNotLike(String value) {
            this.addCriterion("session not like", value, "session");
            return (Criteria)this;
        }        public Criteria andSessionIn(List<String> values) {
            this.addCriterion("session in", values, "session");
            return (Criteria)this;
        }

        public Criteria andSessionNotIn(List<String> values) {
            this.addCriterion("session not in", values, "session");
            return (Criteria)this;
        }

        public Criteria andSessionBetween(String value1, String value2) {
            this.addCriterion("session between", value1, value2, "session");
            return (Criteria)this;
        }

        public Criteria andSessionNotBetween(String value1, String value2) {
            this.addCriterion("session not between", value1, value2, "session");
            return (Criteria)this;
        }

        public Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (Criteria)this;
        }

        public Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (Criteria)this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (Criteria)this;
        }        public Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria)this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (Criteria)this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (Criteria)this;
        }        public Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenIsNull() {
            this.addCriterion("refresh_token is null");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenIsNotNull() {
            this.addCriterion("refresh_token is not null");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenEqualTo(String value) {
            this.addCriterion("refresh_token =", value, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenNotEqualTo(String value) {
            this.addCriterion("refresh_token <>", value, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenGreaterThan(String value) {
            this.addCriterion("refresh_token >", value, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            this.addCriterion("refresh_token >=", value, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenLessThan(String value) {
            this.addCriterion("refresh_token <", value, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            this.addCriterion("refresh_token <=", value, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenLike(String value) {
            this.addCriterion("refresh_token like", value, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenNotLike(String value) {
            this.addCriterion("refresh_token not like", value, "refreshToken");
            return (Criteria)this;
        }        public Criteria andRefreshTokenIn(List<String> values) {
            this.addCriterion("refresh_token in", values, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenNotIn(List<String> values) {
            this.addCriterion("refresh_token not in", values, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenBetween(String value1, String value2) {
            this.addCriterion("refresh_token between", value1, value2, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andRefreshTokenNotBetween(String value1, String value2) {
            this.addCriterion("refresh_token not between", value1, value2, "refreshToken");
            return (Criteria)this;
        }

        public Criteria andFreshTimeIsNull() {
            this.addCriterion("fresh_time is null");
            return (Criteria)this;
        }

        public Criteria andFreshTimeIsNotNull() {
            this.addCriterion("fresh_time is not null");
            return (Criteria)this;
        }

        public Criteria andFreshTimeEqualTo(Date value) {
            this.addCriterion("fresh_time =", value, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeNotEqualTo(Date value) {
            this.addCriterion("fresh_time <>", value, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeGreaterThan(Date value) {
            this.addCriterion("fresh_time >", value, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("fresh_time >=", value, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeLessThan(Date value) {
            this.addCriterion("fresh_time <", value, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("fresh_time <=", value, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeLike(String value) {
            this.addCriterion("fresh_time like", value, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeNotLike(String value) {
            this.addCriterion("fresh_time not like", value, "freshTime");
            return (Criteria)this;
        }        public Criteria andFreshTimeIn(List<Date> values) {
            this.addCriterion("fresh_time in", values, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeNotIn(List<Date> values) {
            this.addCriterion("fresh_time not in", values, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeBetween(Date value1, Date value2) {
            this.addCriterion("fresh_time between", value1, value2, "freshTime");
            return (Criteria)this;
        }

        public Criteria andFreshTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("fresh_time not between", value1, value2, "freshTime");
            return (Criteria)this;
        }

        public Criteria andReExpiresInIsNull() {
            this.addCriterion("re_expires_in is null");
            return (Criteria)this;
        }

        public Criteria andReExpiresInIsNotNull() {
            this.addCriterion("re_expires_in is not null");
            return (Criteria)this;
        }

        public Criteria andReExpiresInEqualTo(Long value) {
            this.addCriterion("re_expires_in =", value, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInNotEqualTo(Long value) {
            this.addCriterion("re_expires_in <>", value, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInGreaterThan(Long value) {
            this.addCriterion("re_expires_in >", value, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("re_expires_in >=", value, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInLessThan(Long value) {
            this.addCriterion("re_expires_in <", value, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("re_expires_in <=", value, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInLike(String value) {
            this.addCriterion("re_expires_in like", value, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInNotLike(String value) {
            this.addCriterion("re_expires_in not like", value, "reExpiresIn");
            return (Criteria)this;
        }        public Criteria andReExpiresInIn(List<Long> values) {
            this.addCriterion("re_expires_in in", values, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInNotIn(List<Long> values) {
            this.addCriterion("re_expires_in not in", values, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("re_expires_in between", value1, value2, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andReExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("re_expires_in not between", value1, value2, "reExpiresIn");
            return (Criteria)this;
        }

        public Criteria andTokenTypeIsNull() {
            this.addCriterion("token_type is null");
            return (Criteria)this;
        }

        public Criteria andTokenTypeIsNotNull() {
            this.addCriterion("token_type is not null");
            return (Criteria)this;
        }

        public Criteria andTokenTypeEqualTo(String value) {
            this.addCriterion("token_type =", value, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeNotEqualTo(String value) {
            this.addCriterion("token_type <>", value, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeGreaterThan(String value) {
            this.addCriterion("token_type >", value, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("token_type >=", value, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeLessThan(String value) {
            this.addCriterion("token_type <", value, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeLessThanOrEqualTo(String value) {
            this.addCriterion("token_type <=", value, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeLike(String value) {
            this.addCriterion("token_type like", value, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeNotLike(String value) {
            this.addCriterion("token_type not like", value, "tokenType");
            return (Criteria)this;
        }        public Criteria andTokenTypeIn(List<String> values) {
            this.addCriterion("token_type in", values, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeNotIn(List<String> values) {
            this.addCriterion("token_type not in", values, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeBetween(String value1, String value2) {
            this.addCriterion("token_type between", value1, value2, "tokenType");
            return (Criteria)this;
        }

        public Criteria andTokenTypeNotBetween(String value1, String value2) {
            this.addCriterion("token_type not between", value1, value2, "tokenType");
            return (Criteria)this;
        }

        public Criteria andExpiresInIsNull() {
            this.addCriterion("expires_in is null");
            return (Criteria)this;
        }

        public Criteria andExpiresInIsNotNull() {
            this.addCriterion("expires_in is not null");
            return (Criteria)this;
        }

        public Criteria andExpiresInEqualTo(Long value) {
            this.addCriterion("expires_in =", value, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInNotEqualTo(Long value) {
            this.addCriterion("expires_in <>", value, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInGreaterThan(Long value) {
            this.addCriterion("expires_in >", value, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("expires_in >=", value, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInLessThan(Long value) {
            this.addCriterion("expires_in <", value, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("expires_in <=", value, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInLike(String value) {
            this.addCriterion("expires_in like", value, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInNotLike(String value) {
            this.addCriterion("expires_in not like", value, "expiresIn");
            return (Criteria)this;
        }        public Criteria andExpiresInIn(List<Long> values) {
            this.addCriterion("expires_in in", values, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInNotIn(List<Long> values) {
            this.addCriterion("expires_in not in", values, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("expires_in between", value1, value2, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("expires_in not between", value1, value2, "expiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInIsNull() {
            this.addCriterion("r1_expires_in is null");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInIsNotNull() {
            this.addCriterion("r1_expires_in is not null");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInEqualTo(Long value) {
            this.addCriterion("r1_expires_in =", value, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInNotEqualTo(Long value) {
            this.addCriterion("r1_expires_in <>", value, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInGreaterThan(Long value) {
            this.addCriterion("r1_expires_in >", value, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("r1_expires_in >=", value, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInLessThan(Long value) {
            this.addCriterion("r1_expires_in <", value, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("r1_expires_in <=", value, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInLike(String value) {
            this.addCriterion("r1_expires_in like", value, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInNotLike(String value) {
            this.addCriterion("r1_expires_in not like", value, "r1ExpiresIn");
            return (Criteria)this;
        }        public Criteria andR1ExpiresInIn(List<Long> values) {
            this.addCriterion("r1_expires_in in", values, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInNotIn(List<Long> values) {
            this.addCriterion("r1_expires_in not in", values, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("r1_expires_in between", value1, value2, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR1ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("r1_expires_in not between", value1, value2, "r1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInIsNull() {
            this.addCriterion("r2_expires_in is null");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInIsNotNull() {
            this.addCriterion("r2_expires_in is not null");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInEqualTo(Long value) {
            this.addCriterion("r2_expires_in =", value, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInNotEqualTo(Long value) {
            this.addCriterion("r2_expires_in <>", value, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInGreaterThan(Long value) {
            this.addCriterion("r2_expires_in >", value, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("r2_expires_in >=", value, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInLessThan(Long value) {
            this.addCriterion("r2_expires_in <", value, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("r2_expires_in <=", value, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInLike(String value) {
            this.addCriterion("r2_expires_in like", value, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInNotLike(String value) {
            this.addCriterion("r2_expires_in not like", value, "r2ExpiresIn");
            return (Criteria)this;
        }        public Criteria andR2ExpiresInIn(List<Long> values) {
            this.addCriterion("r2_expires_in in", values, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInNotIn(List<Long> values) {
            this.addCriterion("r2_expires_in not in", values, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("r2_expires_in between", value1, value2, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andR2ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("r2_expires_in not between", value1, value2, "r2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInIsNull() {
            this.addCriterion("w1_expires_in is null");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInIsNotNull() {
            this.addCriterion("w1_expires_in is not null");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInEqualTo(Long value) {
            this.addCriterion("w1_expires_in =", value, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInNotEqualTo(Long value) {
            this.addCriterion("w1_expires_in <>", value, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInGreaterThan(Long value) {
            this.addCriterion("w1_expires_in >", value, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("w1_expires_in >=", value, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInLessThan(Long value) {
            this.addCriterion("w1_expires_in <", value, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("w1_expires_in <=", value, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInLike(String value) {
            this.addCriterion("w1_expires_in like", value, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInNotLike(String value) {
            this.addCriterion("w1_expires_in not like", value, "w1ExpiresIn");
            return (Criteria)this;
        }        public Criteria andW1ExpiresInIn(List<Long> values) {
            this.addCriterion("w1_expires_in in", values, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInNotIn(List<Long> values) {
            this.addCriterion("w1_expires_in not in", values, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("w1_expires_in between", value1, value2, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW1ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("w1_expires_in not between", value1, value2, "w1ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInIsNull() {
            this.addCriterion("w2_expires_in is null");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInIsNotNull() {
            this.addCriterion("w2_expires_in is not null");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInEqualTo(Long value) {
            this.addCriterion("w2_expires_in =", value, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInNotEqualTo(Long value) {
            this.addCriterion("w2_expires_in <>", value, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInGreaterThan(Long value) {
            this.addCriterion("w2_expires_in >", value, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("w2_expires_in >=", value, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInLessThan(Long value) {
            this.addCriterion("w2_expires_in <", value, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("w2_expires_in <=", value, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInLike(String value) {
            this.addCriterion("w2_expires_in like", value, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInNotLike(String value) {
            this.addCriterion("w2_expires_in not like", value, "w2ExpiresIn");
            return (Criteria)this;
        }        public Criteria andW2ExpiresInIn(List<Long> values) {
            this.addCriterion("w2_expires_in in", values, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInNotIn(List<Long> values) {
            this.addCriterion("w2_expires_in not in", values, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("w2_expires_in between", value1, value2, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andW2ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("w2_expires_in not between", value1, value2, "w2ExpiresIn");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdIsNull() {
            this.addCriterion("sub_taobao_user_id is null");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdIsNotNull() {
            this.addCriterion("sub_taobao_user_id is not null");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id =", value, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdNotEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id <>", value, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdGreaterThan(Long value) {
            this.addCriterion("sub_taobao_user_id >", value, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id >=", value, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdLessThan(Long value) {
            this.addCriterion("sub_taobao_user_id <", value, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id <=", value, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdLike(String value) {
            this.addCriterion("sub_taobao_user_id like", value, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdNotLike(String value) {
            this.addCriterion("sub_taobao_user_id not like", value, "subTaobaoUserId");
            return (Criteria)this;
        }        public Criteria andSubTaobaoUserIdIn(List<Long> values) {
            this.addCriterion("sub_taobao_user_id in", values, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdNotIn(List<Long> values) {
            this.addCriterion("sub_taobao_user_id not in", values, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdBetween(Long value1, Long value2) {
            this.addCriterion("sub_taobao_user_id between", value1, value2, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sub_taobao_user_id not between", value1, value2, "subTaobaoUserId");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickIsNull() {
            this.addCriterion("sub_taobao_user_nick is null");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickIsNotNull() {
            this.addCriterion("sub_taobao_user_nick is not null");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick =", value, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickNotEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick <>", value, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickGreaterThan(String value) {
            this.addCriterion("sub_taobao_user_nick >", value, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick >=", value, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickLessThan(String value) {
            this.addCriterion("sub_taobao_user_nick <", value, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickLessThanOrEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick <=", value, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickLike(String value) {
            this.addCriterion("sub_taobao_user_nick like", value, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickNotLike(String value) {
            this.addCriterion("sub_taobao_user_nick not like", value, "subTaobaoUserNick");
            return (Criteria)this;
        }        public Criteria andSubTaobaoUserNickIn(List<String> values) {
            this.addCriterion("sub_taobao_user_nick in", values, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickNotIn(List<String> values) {
            this.addCriterion("sub_taobao_user_nick not in", values, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickBetween(String value1, String value2) {
            this.addCriterion("sub_taobao_user_nick between", value1, value2, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andSubTaobaoUserNickNotBetween(String value1, String value2) {
            this.addCriterion("sub_taobao_user_nick not between", value1, value2, "subTaobaoUserNick");
            return (Criteria)this;
        }

        public Criteria andRemarkIsNull() {
            this.addCriterion("remark is null");
            return (Criteria)this;
        }

        public Criteria andRemarkIsNotNull() {
            this.addCriterion("remark is not null");
            return (Criteria)this;
        }

        public Criteria andRemarkEqualTo(String value) {
            this.addCriterion("remark =", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            this.addCriterion("remark <>", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            this.addCriterion("remark >", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("remark >=", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkLessThan(String value) {
            this.addCriterion("remark <", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            this.addCriterion("remark <=", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkLike(String value) {
            this.addCriterion("remark like", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotLike(String value) {
            this.addCriterion("remark not like", value, "remark");
            return (Criteria)this;
        }        public Criteria andRemarkIn(List<String> values) {
            this.addCriterion("remark in", values, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            this.addCriterion("remark not in", values, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            this.addCriterion("remark between", value1, value2, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            this.addCriterion("remark not between", value1, value2, "remark");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (Criteria)this;
        }        public Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (Criteria)this;
        }        public Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (Criteria)this;
        }        public Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (Criteria)this;
        }        public Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (Criteria)this;
        }        public Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (Criteria)this;
        }        public Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (Criteria)this;
        }        public Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (Criteria)this;
        }        public Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (Criteria)this;
        }        public Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (Criteria)this;
        }        public Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria)this;
        }
    }
}
