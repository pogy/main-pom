package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class TaobaoSessionMapExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<TaobaoSessionMapExample.Criteria> oredCriteria = new ArrayList();

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

    public List<TaobaoSessionMapExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(TaobaoSessionMapExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public TaobaoSessionMapExample.Criteria or() {
        TaobaoSessionMapExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public TaobaoSessionMapExample.Criteria createCriteria() {
        TaobaoSessionMapExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected TaobaoSessionMapExample.Criteria createCriteriaInternal() {
        TaobaoSessionMapExample.Criteria criteria = new TaobaoSessionMapExample.Criteria();
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

    public static class Criteria extends TaobaoSessionMapExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<TaobaoSessionMapExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<TaobaoSessionMapExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<TaobaoSessionMapExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new TaobaoSessionMapExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new TaobaoSessionMapExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new TaobaoSessionMapExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInIsNull() {
            this.addCriterion("w1_expires_in is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInIsNotNull() {
            this.addCriterion("w1_expires_in is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInEqualTo(Long value) {
            this.addCriterion("w1_expires_in =", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInNotEqualTo(Long value) {
            this.addCriterion("w1_expires_in <>", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInGreaterThan(Long value) {
            this.addCriterion("w1_expires_in >", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("w1_expires_in >=", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInLessThan(Long value) {
            this.addCriterion("w1_expires_in <", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("w1_expires_in <=", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInLike(String value) {
            this.addCriterion("w1_expires_in like", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInNotLike(String value) {
            this.addCriterion("w1_expires_in not like", value, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andW1ExpiresInIn(List<Long> values) {
            this.addCriterion("w1_expires_in in", values, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInNotIn(List<Long> values) {
            this.addCriterion("w1_expires_in not in", values, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("w1_expires_in between", value1, value2, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW1ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("w1_expires_in not between", value1, value2, "w1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionIsNull() {
            this.addCriterion("session is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionIsNotNull() {
            this.addCriterion("session is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionEqualTo(String value) {
            this.addCriterion("session =", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionNotEqualTo(String value) {
            this.addCriterion("session <>", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionGreaterThan(String value) {
            this.addCriterion("session >", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionGreaterThanOrEqualTo(String value) {
            this.addCriterion("session >=", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionLessThan(String value) {
            this.addCriterion("session <", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionLessThanOrEqualTo(String value) {
            this.addCriterion("session <=", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionLike(String value) {
            this.addCriterion("session like", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionNotLike(String value) {
            this.addCriterion("session not like", value, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andSessionIn(List<String> values) {
            this.addCriterion("session in", values, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionNotIn(List<String> values) {
            this.addCriterion("session not in", values, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionBetween(String value1, String value2) {
            this.addCriterion("session between", value1, value2, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSessionNotBetween(String value1, String value2) {
            this.addCriterion("session not between", value1, value2, "session");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInIsNull() {
            this.addCriterion("re_expires_in is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInIsNotNull() {
            this.addCriterion("re_expires_in is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInEqualTo(Long value) {
            this.addCriterion("re_expires_in =", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInNotEqualTo(Long value) {
            this.addCriterion("re_expires_in <>", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInGreaterThan(Long value) {
            this.addCriterion("re_expires_in >", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("re_expires_in >=", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInLessThan(Long value) {
            this.addCriterion("re_expires_in <", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("re_expires_in <=", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInLike(String value) {
            this.addCriterion("re_expires_in like", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInNotLike(String value) {
            this.addCriterion("re_expires_in not like", value, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andReExpiresInIn(List<Long> values) {
            this.addCriterion("re_expires_in in", values, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInNotIn(List<Long> values) {
            this.addCriterion("re_expires_in not in", values, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("re_expires_in between", value1, value2, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andReExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("re_expires_in not between", value1, value2, "reExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkIsNull() {
            this.addCriterion("remark is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkIsNotNull() {
            this.addCriterion("remark is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkEqualTo(String value) {
            this.addCriterion("remark =", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotEqualTo(String value) {
            this.addCriterion("remark <>", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkGreaterThan(String value) {
            this.addCriterion("remark >", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("remark >=", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkLessThan(String value) {
            this.addCriterion("remark <", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            this.addCriterion("remark <=", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkLike(String value) {
            this.addCriterion("remark like", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotLike(String value) {
            this.addCriterion("remark not like", value, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemarkIn(List<String> values) {
            this.addCriterion("remark in", values, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotIn(List<String> values) {
            this.addCriterion("remark not in", values, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkBetween(String value1, String value2) {
            this.addCriterion("remark between", value1, value2, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemarkNotBetween(String value1, String value2) {
            this.addCriterion("remark not between", value1, value2, "remark");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretIsNull() {
            this.addCriterion("secret is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretIsNotNull() {
            this.addCriterion("secret is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretEqualTo(String value) {
            this.addCriterion("secret =", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretNotEqualTo(String value) {
            this.addCriterion("secret <>", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretGreaterThan(String value) {
            this.addCriterion("secret >", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretGreaterThanOrEqualTo(String value) {
            this.addCriterion("secret >=", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretLessThan(String value) {
            this.addCriterion("secret <", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretLessThanOrEqualTo(String value) {
            this.addCriterion("secret <=", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretLike(String value) {
            this.addCriterion("secret like", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretNotLike(String value) {
            this.addCriterion("secret not like", value, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andSecretIn(List<String> values) {
            this.addCriterion("secret in", values, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretNotIn(List<String> values) {
            this.addCriterion("secret not in", values, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretBetween(String value1, String value2) {
            this.addCriterion("secret between", value1, value2, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSecretNotBetween(String value1, String value2) {
            this.addCriterion("secret not between", value1, value2, "secret");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeIsNull() {
            this.addCriterion("token_type is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeIsNotNull() {
            this.addCriterion("token_type is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeEqualTo(String value) {
            this.addCriterion("token_type =", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotEqualTo(String value) {
            this.addCriterion("token_type <>", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeGreaterThan(String value) {
            this.addCriterion("token_type >", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("token_type >=", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeLessThan(String value) {
            this.addCriterion("token_type <", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeLessThanOrEqualTo(String value) {
            this.addCriterion("token_type <=", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeLike(String value) {
            this.addCriterion("token_type like", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotLike(String value) {
            this.addCriterion("token_type not like", value, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andTokenTypeIn(List<String> values) {
            this.addCriterion("token_type in", values, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotIn(List<String> values) {
            this.addCriterion("token_type not in", values, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeBetween(String value1, String value2) {
            this.addCriterion("token_type between", value1, value2, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTokenTypeNotBetween(String value1, String value2) {
            this.addCriterion("token_type not between", value1, value2, "tokenType");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickIsNull() {
            this.addCriterion("sub_taobao_user_nick is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickIsNotNull() {
            this.addCriterion("sub_taobao_user_nick is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick =", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick <>", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickGreaterThan(String value) {
            this.addCriterion("sub_taobao_user_nick >", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick >=", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickLessThan(String value) {
            this.addCriterion("sub_taobao_user_nick <", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickLessThanOrEqualTo(String value) {
            this.addCriterion("sub_taobao_user_nick <=", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickLike(String value) {
            this.addCriterion("sub_taobao_user_nick like", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotLike(String value) {
            this.addCriterion("sub_taobao_user_nick not like", value, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickIn(List<String> values) {
            this.addCriterion("sub_taobao_user_nick in", values, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotIn(List<String> values) {
            this.addCriterion("sub_taobao_user_nick not in", values, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickBetween(String value1, String value2) {
            this.addCriterion("sub_taobao_user_nick between", value1, value2, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserNickNotBetween(String value1, String value2) {
            this.addCriterion("sub_taobao_user_nick not between", value1, value2, "subTaobaoUserNick");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInIsNull() {
            this.addCriterion("r1_expires_in is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInIsNotNull() {
            this.addCriterion("r1_expires_in is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInEqualTo(Long value) {
            this.addCriterion("r1_expires_in =", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInNotEqualTo(Long value) {
            this.addCriterion("r1_expires_in <>", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInGreaterThan(Long value) {
            this.addCriterion("r1_expires_in >", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("r1_expires_in >=", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInLessThan(Long value) {
            this.addCriterion("r1_expires_in <", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("r1_expires_in <=", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInLike(String value) {
            this.addCriterion("r1_expires_in like", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInNotLike(String value) {
            this.addCriterion("r1_expires_in not like", value, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andR1ExpiresInIn(List<Long> values) {
            this.addCriterion("r1_expires_in in", values, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInNotIn(List<Long> values) {
            this.addCriterion("r1_expires_in not in", values, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("r1_expires_in between", value1, value2, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR1ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("r1_expires_in not between", value1, value2, "r1ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdIsNull() {
            this.addCriterion("tsm_id is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdIsNotNull() {
            this.addCriterion("tsm_id is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdEqualTo(Long value) {
            this.addCriterion("tsm_id =", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdNotEqualTo(Long value) {
            this.addCriterion("tsm_id <>", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdGreaterThan(Long value) {
            this.addCriterion("tsm_id >", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("tsm_id >=", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdLessThan(Long value) {
            this.addCriterion("tsm_id <", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdLessThanOrEqualTo(Long value) {
            this.addCriterion("tsm_id <=", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdLike(String value) {
            this.addCriterion("tsm_id like", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdNotLike(String value) {
            this.addCriterion("tsm_id not like", value, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andTsmIdIn(List<Long> values) {
            this.addCriterion("tsm_id in", values, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdNotIn(List<Long> values) {
            this.addCriterion("tsm_id not in", values, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdBetween(Long value1, Long value2) {
            this.addCriterion("tsm_id between", value1, value2, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andTsmIdNotBetween(Long value1, Long value2) {
            this.addCriterion("tsm_id not between", value1, value2, "tsmId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeIsNull() {
            this.addCriterion("fresh_time is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeIsNotNull() {
            this.addCriterion("fresh_time is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeEqualTo(Date value) {
            this.addCriterion("fresh_time =", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeNotEqualTo(Date value) {
            this.addCriterion("fresh_time <>", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeGreaterThan(Date value) {
            this.addCriterion("fresh_time >", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("fresh_time >=", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeLessThan(Date value) {
            this.addCriterion("fresh_time <", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("fresh_time <=", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeLike(String value) {
            this.addCriterion("fresh_time like", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeNotLike(String value) {
            this.addCriterion("fresh_time not like", value, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andFreshTimeIn(List<Date> values) {
            this.addCriterion("fresh_time in", values, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeNotIn(List<Date> values) {
            this.addCriterion("fresh_time not in", values, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeBetween(Date value1, Date value2) {
            this.addCriterion("fresh_time between", value1, value2, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andFreshTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("fresh_time not between", value1, value2, "freshTime");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInIsNull() {
            this.addCriterion("r2_expires_in is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInIsNotNull() {
            this.addCriterion("r2_expires_in is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInEqualTo(Long value) {
            this.addCriterion("r2_expires_in =", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInNotEqualTo(Long value) {
            this.addCriterion("r2_expires_in <>", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInGreaterThan(Long value) {
            this.addCriterion("r2_expires_in >", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("r2_expires_in >=", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInLessThan(Long value) {
            this.addCriterion("r2_expires_in <", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("r2_expires_in <=", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInLike(String value) {
            this.addCriterion("r2_expires_in like", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInNotLike(String value) {
            this.addCriterion("r2_expires_in not like", value, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andR2ExpiresInIn(List<Long> values) {
            this.addCriterion("r2_expires_in in", values, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInNotIn(List<Long> values) {
            this.addCriterion("r2_expires_in not in", values, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("r2_expires_in between", value1, value2, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andR2ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("r2_expires_in not between", value1, value2, "r2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInIsNull() {
            this.addCriterion("expires_in is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInIsNotNull() {
            this.addCriterion("expires_in is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInEqualTo(Long value) {
            this.addCriterion("expires_in =", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInNotEqualTo(Long value) {
            this.addCriterion("expires_in <>", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInGreaterThan(Long value) {
            this.addCriterion("expires_in >", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("expires_in >=", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInLessThan(Long value) {
            this.addCriterion("expires_in <", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("expires_in <=", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInLike(String value) {
            this.addCriterion("expires_in like", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInNotLike(String value) {
            this.addCriterion("expires_in not like", value, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andExpiresInIn(List<Long> values) {
            this.addCriterion("expires_in in", values, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInNotIn(List<Long> values) {
            this.addCriterion("expires_in not in", values, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("expires_in between", value1, value2, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("expires_in not between", value1, value2, "expiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdIsNull() {
            this.addCriterion("sub_taobao_user_id is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdIsNotNull() {
            this.addCriterion("sub_taobao_user_id is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id =", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdNotEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id <>", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdGreaterThan(Long value) {
            this.addCriterion("sub_taobao_user_id >", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id >=", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdLessThan(Long value) {
            this.addCriterion("sub_taobao_user_id <", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sub_taobao_user_id <=", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdLike(String value) {
            this.addCriterion("sub_taobao_user_id like", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdNotLike(String value) {
            this.addCriterion("sub_taobao_user_id not like", value, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdIn(List<Long> values) {
            this.addCriterion("sub_taobao_user_id in", values, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdNotIn(List<Long> values) {
            this.addCriterion("sub_taobao_user_id not in", values, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdBetween(Long value1, Long value2) {
            this.addCriterion("sub_taobao_user_id between", value1, value2, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andSubTaobaoUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sub_taobao_user_id not between", value1, value2, "subTaobaoUserId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenIsNull() {
            this.addCriterion("refresh_token is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenIsNotNull() {
            this.addCriterion("refresh_token is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenEqualTo(String value) {
            this.addCriterion("refresh_token =", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotEqualTo(String value) {
            this.addCriterion("refresh_token <>", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenGreaterThan(String value) {
            this.addCriterion("refresh_token >", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            this.addCriterion("refresh_token >=", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenLessThan(String value) {
            this.addCriterion("refresh_token <", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            this.addCriterion("refresh_token <=", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenLike(String value) {
            this.addCriterion("refresh_token like", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotLike(String value) {
            this.addCriterion("refresh_token not like", value, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRefreshTokenIn(List<String> values) {
            this.addCriterion("refresh_token in", values, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotIn(List<String> values) {
            this.addCriterion("refresh_token not in", values, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenBetween(String value1, String value2) {
            this.addCriterion("refresh_token between", value1, value2, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRefreshTokenNotBetween(String value1, String value2) {
            this.addCriterion("refresh_token not between", value1, value2, "refreshToken");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInIsNull() {
            this.addCriterion("w2_expires_in is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInIsNotNull() {
            this.addCriterion("w2_expires_in is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInEqualTo(Long value) {
            this.addCriterion("w2_expires_in =", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInNotEqualTo(Long value) {
            this.addCriterion("w2_expires_in <>", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInGreaterThan(Long value) {
            this.addCriterion("w2_expires_in >", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInGreaterThanOrEqualTo(Long value) {
            this.addCriterion("w2_expires_in >=", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInLessThan(Long value) {
            this.addCriterion("w2_expires_in <", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInLessThanOrEqualTo(Long value) {
            this.addCriterion("w2_expires_in <=", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInLike(String value) {
            this.addCriterion("w2_expires_in like", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInNotLike(String value) {
            this.addCriterion("w2_expires_in not like", value, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andW2ExpiresInIn(List<Long> values) {
            this.addCriterion("w2_expires_in in", values, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInNotIn(List<Long> values) {
            this.addCriterion("w2_expires_in not in", values, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInBetween(Long value1, Long value2) {
            this.addCriterion("w2_expires_in between", value1, value2, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andW2ExpiresInNotBetween(Long value1, Long value2) {
            this.addCriterion("w2_expires_in not between", value1, value2, "w2ExpiresIn");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyIsNull() {
            this.addCriterion("appkey is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyIsNotNull() {
            this.addCriterion("appkey is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyEqualTo(String value) {
            this.addCriterion("appkey =", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotEqualTo(String value) {
            this.addCriterion("appkey <>", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyGreaterThan(String value) {
            this.addCriterion("appkey >", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("appkey >=", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyLessThan(String value) {
            this.addCriterion("appkey <", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyLessThanOrEqualTo(String value) {
            this.addCriterion("appkey <=", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyLike(String value) {
            this.addCriterion("appkey like", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotLike(String value) {
            this.addCriterion("appkey not like", value, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andAppkeyIn(List<String> values) {
            this.addCriterion("appkey in", values, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotIn(List<String> values) {
            this.addCriterion("appkey not in", values, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyBetween(String value1, String value2) {
            this.addCriterion("appkey between", value1, value2, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andAppkeyNotBetween(String value1, String value2) {
            this.addCriterion("appkey not between", value1, value2, "appkey");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }        public TaobaoSessionMapExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }

        public TaobaoSessionMapExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (TaobaoSessionMapExample.Criteria)this;
        }
    }
}
