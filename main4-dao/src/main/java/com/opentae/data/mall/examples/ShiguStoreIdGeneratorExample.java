package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Deprecated
public class ShiguStoreIdGeneratorExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguStoreIdGeneratorExample.Criteria> oredCriteria = new ArrayList();

    public ShiguStoreIdGeneratorExample() {
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

    public List<ShiguStoreIdGeneratorExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguStoreIdGeneratorExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguStoreIdGeneratorExample.Criteria or() {
        ShiguStoreIdGeneratorExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguStoreIdGeneratorExample.Criteria createCriteria() {
        ShiguStoreIdGeneratorExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguStoreIdGeneratorExample.Criteria createCriteriaInternal() {
        ShiguStoreIdGeneratorExample.Criteria criteria = new ShiguStoreIdGeneratorExample.Criteria();
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

    public static class Criteria extends ShiguStoreIdGeneratorExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguStoreIdGeneratorExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguStoreIdGeneratorExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguStoreIdGeneratorExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguStoreIdGeneratorExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguStoreIdGeneratorExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguStoreIdGeneratorExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }        public ShiguStoreIdGeneratorExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }        public ShiguStoreIdGeneratorExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }        public ShiguStoreIdGeneratorExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkIsNull() {
            this.addCriterion("remark is null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkIsNotNull() {
            this.addCriterion("remark is not null");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkEqualTo(String value) {
            this.addCriterion("remark =", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkNotEqualTo(String value) {
            this.addCriterion("remark <>", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkGreaterThan(String value) {
            this.addCriterion("remark >", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("remark >=", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkLessThan(String value) {
            this.addCriterion("remark <", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            this.addCriterion("remark <=", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkLike(String value) {
            this.addCriterion("remark like", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkNotLike(String value) {
            this.addCriterion("remark not like", value, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }        public ShiguStoreIdGeneratorExample.Criteria andRemarkIn(List<String> values) {
            this.addCriterion("remark in", values, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkNotIn(List<String> values) {
            this.addCriterion("remark not in", values, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkBetween(String value1, String value2) {
            this.addCriterion("remark between", value1, value2, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }

        public ShiguStoreIdGeneratorExample.Criteria andRemarkNotBetween(String value1, String value2) {
            this.addCriterion("remark not between", value1, value2, "remark");
            return (ShiguStoreIdGeneratorExample.Criteria)this;
        }
    }
}
