package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguGoodsIdGeneratorExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsIdGeneratorExample() {
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

        public Criteria andGoodIdIsNull() {
            this.addCriterion("good_id is null");
            return (Criteria)this;
        }

        public Criteria andGoodIdIsNotNull() {
            this.addCriterion("good_id is not null");
            return (Criteria)this;
        }

        public Criteria andGoodIdEqualTo(Long value) {
            this.addCriterion("good_id =", value, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdNotEqualTo(Long value) {
            this.addCriterion("good_id <>", value, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdGreaterThan(Long value) {
            this.addCriterion("good_id >", value, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("good_id >=", value, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdLessThan(Long value) {
            this.addCriterion("good_id <", value, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Long value) {
            this.addCriterion("good_id <=", value, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdLike(String value) {
            this.addCriterion("good_id like", value, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdNotLike(String value) {
            this.addCriterion("good_id not like", value, "goodId");
            return (Criteria)this;
        }        public Criteria andGoodIdIn(List<Long> values) {
            this.addCriterion("good_id in", values, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdNotIn(List<Long> values) {
            this.addCriterion("good_id not in", values, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdBetween(Long value1, Long value2) {
            this.addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria)this;
        }

        public Criteria andGoodIdNotBetween(Long value1, Long value2) {
            this.addCriterion("good_id not between", value1, value2, "goodId");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (Criteria)this;
        }

        public Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (Criteria)this;
        }        public Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (Criteria)this;
        }
    }
}
