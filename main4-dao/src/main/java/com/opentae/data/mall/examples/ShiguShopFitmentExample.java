package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Deprecated
public class ShiguShopFitmentExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguShopFitmentExample.Criteria> oredCriteria = new ArrayList();

    public ShiguShopFitmentExample() {
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

    public List<ShiguShopFitmentExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguShopFitmentExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguShopFitmentExample.Criteria or() {
        ShiguShopFitmentExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguShopFitmentExample.Criteria createCriteria() {
        ShiguShopFitmentExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguShopFitmentExample.Criteria createCriteriaInternal() {
        ShiguShopFitmentExample.Criteria criteria = new ShiguShopFitmentExample.Criteria();
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

    public static class Criteria extends ShiguShopFitmentExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguShopFitmentExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguShopFitmentExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguShopFitmentExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguShopFitmentExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguShopFitmentExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguShopFitmentExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdIsNull() {
            this.addCriterion("fitment_id is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdIsNotNull() {
            this.addCriterion("fitment_id is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdEqualTo(Long value) {
            this.addCriterion("fitment_id =", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdNotEqualTo(Long value) {
            this.addCriterion("fitment_id <>", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdGreaterThan(Long value) {
            this.addCriterion("fitment_id >", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("fitment_id >=", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdLessThan(Long value) {
            this.addCriterion("fitment_id <", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdLessThanOrEqualTo(Long value) {
            this.addCriterion("fitment_id <=", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdLike(String value) {
            this.addCriterion("fitment_id like", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdNotLike(String value) {
            this.addCriterion("fitment_id not like", value, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andFitmentIdIn(List<Long> values) {
            this.addCriterion("fitment_id in", values, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdNotIn(List<Long> values) {
            this.addCriterion("fitment_id not in", values, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdBetween(Long value1, Long value2) {
            this.addCriterion("fitment_id between", value1, value2, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentIdNotBetween(Long value1, Long value2) {
            this.addCriterion("fitment_id not between", value1, value2, "fitmentId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameIsNull() {
            this.addCriterion("shop_name is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameIsNotNull() {
            this.addCriterion("shop_name is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameEqualTo(String value) {
            this.addCriterion("shop_name =", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameNotEqualTo(String value) {
            this.addCriterion("shop_name <>", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameGreaterThan(String value) {
            this.addCriterion("shop_name >", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_name >=", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameLessThan(String value) {
            this.addCriterion("shop_name <", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameLessThanOrEqualTo(String value) {
            this.addCriterion("shop_name <=", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameLike(String value) {
            this.addCriterion("shop_name like", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameNotLike(String value) {
            this.addCriterion("shop_name not like", value, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopNameIn(List<String> values) {
            this.addCriterion("shop_name in", values, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameNotIn(List<String> values) {
            this.addCriterion("shop_name not in", values, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameBetween(String value1, String value2) {
            this.addCriterion("shop_name between", value1, value2, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopNameNotBetween(String value1, String value2) {
            this.addCriterion("shop_name not between", value1, value2, "shopName");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateIsNull() {
            this.addCriterion("fitment_date is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateIsNotNull() {
            this.addCriterion("fitment_date is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateEqualTo(Date value) {
            this.addCriterion("fitment_date =", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateNotEqualTo(Date value) {
            this.addCriterion("fitment_date <>", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateGreaterThan(Date value) {
            this.addCriterion("fitment_date >", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("fitment_date >=", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateLessThan(Date value) {
            this.addCriterion("fitment_date <", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateLessThanOrEqualTo(Date value) {
            this.addCriterion("fitment_date <=", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateLike(String value) {
            this.addCriterion("fitment_date like", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateNotLike(String value) {
            this.addCriterion("fitment_date not like", value, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andFitmentDateIn(List<Date> values) {
            this.addCriterion("fitment_date in", values, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateNotIn(List<Date> values) {
            this.addCriterion("fitment_date not in", values, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateBetween(Date value1, Date value2) {
            this.addCriterion("fitment_date between", value1, value2, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andFitmentDateNotBetween(Date value1, Date value2) {
            this.addCriterion("fitment_date not between", value1, value2, "fitmentDate");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeIsNull() {
            this.addCriterion("theme is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeIsNotNull() {
            this.addCriterion("theme is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeEqualTo(String value) {
            this.addCriterion("theme =", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeNotEqualTo(String value) {
            this.addCriterion("theme <>", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeGreaterThan(String value) {
            this.addCriterion("theme >", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeGreaterThanOrEqualTo(String value) {
            this.addCriterion("theme >=", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeLessThan(String value) {
            this.addCriterion("theme <", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeLessThanOrEqualTo(String value) {
            this.addCriterion("theme <=", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeLike(String value) {
            this.addCriterion("theme like", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeNotLike(String value) {
            this.addCriterion("theme not like", value, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andThemeIn(List<String> values) {
            this.addCriterion("theme in", values, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeNotIn(List<String> values) {
            this.addCriterion("theme not in", values, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeBetween(String value1, String value2) {
            this.addCriterion("theme between", value1, value2, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andThemeNotBetween(String value1, String value2) {
            this.addCriterion("theme not between", value1, value2, "theme");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerIsNull() {
            this.addCriterion("shop_banner is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerIsNotNull() {
            this.addCriterion("shop_banner is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerEqualTo(String value) {
            this.addCriterion("shop_banner =", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerNotEqualTo(String value) {
            this.addCriterion("shop_banner <>", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerGreaterThan(String value) {
            this.addCriterion("shop_banner >", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_banner >=", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerLessThan(String value) {
            this.addCriterion("shop_banner <", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerLessThanOrEqualTo(String value) {
            this.addCriterion("shop_banner <=", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerLike(String value) {
            this.addCriterion("shop_banner like", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerNotLike(String value) {
            this.addCriterion("shop_banner not like", value, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopBannerIn(List<String> values) {
            this.addCriterion("shop_banner in", values, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerNotIn(List<String> values) {
            this.addCriterion("shop_banner not in", values, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerBetween(String value1, String value2) {
            this.addCriterion("shop_banner between", value1, value2, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBannerNotBetween(String value1, String value2) {
            this.addCriterion("shop_banner not between", value1, value2, "shopBanner");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2IsNull() {
            this.addCriterion("shop_banner2 is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2IsNotNull() {
            this.addCriterion("shop_banner2 is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2EqualTo(String value) {
            this.addCriterion("shop_banner2 =", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2NotEqualTo(String value) {
            this.addCriterion("shop_banner2 <>", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2GreaterThan(String value) {
            this.addCriterion("shop_banner2 >", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2GreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_banner2 >=", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2LessThan(String value) {
            this.addCriterion("shop_banner2 <", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2LessThanOrEqualTo(String value) {
            this.addCriterion("shop_banner2 <=", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2Like(String value) {
            this.addCriterion("shop_banner2 like", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2NotLike(String value) {
            this.addCriterion("shop_banner2 not like", value, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopBanner2In(List<String> values) {
            this.addCriterion("shop_banner2 in", values, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2NotIn(List<String> values) {
            this.addCriterion("shop_banner2 not in", values, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2Between(String value1, String value2) {
            this.addCriterion("shop_banner2 between", value1, value2, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner2NotBetween(String value1, String value2) {
            this.addCriterion("shop_banner2 not between", value1, value2, "shopBanner2");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3IsNull() {
            this.addCriterion("shop_banner3 is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3IsNotNull() {
            this.addCriterion("shop_banner3 is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3EqualTo(String value) {
            this.addCriterion("shop_banner3 =", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3NotEqualTo(String value) {
            this.addCriterion("shop_banner3 <>", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3GreaterThan(String value) {
            this.addCriterion("shop_banner3 >", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3GreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_banner3 >=", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3LessThan(String value) {
            this.addCriterion("shop_banner3 <", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3LessThanOrEqualTo(String value) {
            this.addCriterion("shop_banner3 <=", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3Like(String value) {
            this.addCriterion("shop_banner3 like", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3NotLike(String value) {
            this.addCriterion("shop_banner3 not like", value, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopBanner3In(List<String> values) {
            this.addCriterion("shop_banner3 in", values, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3NotIn(List<String> values) {
            this.addCriterion("shop_banner3 not in", values, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3Between(String value1, String value2) {
            this.addCriterion("shop_banner3 between", value1, value2, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner3NotBetween(String value1, String value2) {
            this.addCriterion("shop_banner3 not between", value1, value2, "shopBanner3");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4IsNull() {
            this.addCriterion("shop_banner4 is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4IsNotNull() {
            this.addCriterion("shop_banner4 is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4EqualTo(String value) {
            this.addCriterion("shop_banner4 =", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4NotEqualTo(String value) {
            this.addCriterion("shop_banner4 <>", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4GreaterThan(String value) {
            this.addCriterion("shop_banner4 >", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4GreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_banner4 >=", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4LessThan(String value) {
            this.addCriterion("shop_banner4 <", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4LessThanOrEqualTo(String value) {
            this.addCriterion("shop_banner4 <=", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4Like(String value) {
            this.addCriterion("shop_banner4 like", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4NotLike(String value) {
            this.addCriterion("shop_banner4 not like", value, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopBanner4In(List<String> values) {
            this.addCriterion("shop_banner4 in", values, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4NotIn(List<String> values) {
            this.addCriterion("shop_banner4 not in", values, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4Between(String value1, String value2) {
            this.addCriterion("shop_banner4 between", value1, value2, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner4NotBetween(String value1, String value2) {
            this.addCriterion("shop_banner4 not between", value1, value2, "shopBanner4");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5IsNull() {
            this.addCriterion("shop_banner5 is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5IsNotNull() {
            this.addCriterion("shop_banner5 is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5EqualTo(String value) {
            this.addCriterion("shop_banner5 =", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5NotEqualTo(String value) {
            this.addCriterion("shop_banner5 <>", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5GreaterThan(String value) {
            this.addCriterion("shop_banner5 >", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5GreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_banner5 >=", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5LessThan(String value) {
            this.addCriterion("shop_banner5 <", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5LessThanOrEqualTo(String value) {
            this.addCriterion("shop_banner5 <=", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5Like(String value) {
            this.addCriterion("shop_banner5 like", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5NotLike(String value) {
            this.addCriterion("shop_banner5 not like", value, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopBanner5In(List<String> values) {
            this.addCriterion("shop_banner5 in", values, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5NotIn(List<String> values) {
            this.addCriterion("shop_banner5 not in", values, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5Between(String value1, String value2) {
            this.addCriterion("shop_banner5 between", value1, value2, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopBanner5NotBetween(String value1, String value2) {
            this.addCriterion("shop_banner5 not between", value1, value2, "shopBanner5");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoIsNull() {
            this.addCriterion("shop_logo is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoIsNotNull() {
            this.addCriterion("shop_logo is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoEqualTo(String value) {
            this.addCriterion("shop_logo =", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoNotEqualTo(String value) {
            this.addCriterion("shop_logo <>", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoGreaterThan(String value) {
            this.addCriterion("shop_logo >", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_logo >=", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoLessThan(String value) {
            this.addCriterion("shop_logo <", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoLessThanOrEqualTo(String value) {
            this.addCriterion("shop_logo <=", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoLike(String value) {
            this.addCriterion("shop_logo like", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoNotLike(String value) {
            this.addCriterion("shop_logo not like", value, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShopLogoIn(List<String> values) {
            this.addCriterion("shop_logo in", values, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoNotIn(List<String> values) {
            this.addCriterion("shop_logo not in", values, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoBetween(String value1, String value2) {
            this.addCriterion("shop_logo between", value1, value2, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShopLogoNotBetween(String value1, String value2) {
            this.addCriterion("shop_logo not between", value1, value2, "shopLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionIsNull() {
            this.addCriterion("description is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionIsNotNull() {
            this.addCriterion("description is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionEqualTo(String value) {
            this.addCriterion("description =", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionNotEqualTo(String value) {
            this.addCriterion("description <>", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionGreaterThan(String value) {
            this.addCriterion("description >", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            this.addCriterion("description >=", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionLessThan(String value) {
            this.addCriterion("description <", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            this.addCriterion("description <=", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionLike(String value) {
            this.addCriterion("description like", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionNotLike(String value) {
            this.addCriterion("description not like", value, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andDescriptionIn(List<String> values) {
            this.addCriterion("description in", values, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionNotIn(List<String> values) {
            this.addCriterion("description not in", values, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionBetween(String value1, String value2) {
            this.addCriterion("description between", value1, value2, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            this.addCriterion("description not between", value1, value2, "description");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoIsNull() {
            this.addCriterion("show_logo is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoIsNotNull() {
            this.addCriterion("show_logo is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoEqualTo(Integer value) {
            this.addCriterion("show_logo =", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoNotEqualTo(Integer value) {
            this.addCriterion("show_logo <>", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoGreaterThan(Integer value) {
            this.addCriterion("show_logo >", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("show_logo >=", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoLessThan(Integer value) {
            this.addCriterion("show_logo <", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoLessThanOrEqualTo(Integer value) {
            this.addCriterion("show_logo <=", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoLike(String value) {
            this.addCriterion("show_logo like", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoNotLike(String value) {
            this.addCriterion("show_logo not like", value, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShowLogoIn(List<Integer> values) {
            this.addCriterion("show_logo in", values, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoNotIn(List<Integer> values) {
            this.addCriterion("show_logo not in", values, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoBetween(Integer value1, Integer value2) {
            this.addCriterion("show_logo between", value1, value2, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowLogoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("show_logo not between", value1, value2, "showLogo");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideIsNull() {
            this.addCriterion("show_slide is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideIsNotNull() {
            this.addCriterion("show_slide is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideEqualTo(Integer value) {
            this.addCriterion("show_slide =", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideNotEqualTo(Integer value) {
            this.addCriterion("show_slide <>", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideGreaterThan(Integer value) {
            this.addCriterion("show_slide >", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("show_slide >=", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideLessThan(Integer value) {
            this.addCriterion("show_slide <", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideLessThanOrEqualTo(Integer value) {
            this.addCriterion("show_slide <=", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideLike(String value) {
            this.addCriterion("show_slide like", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideNotLike(String value) {
            this.addCriterion("show_slide not like", value, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShowSlideIn(List<Integer> values) {
            this.addCriterion("show_slide in", values, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideNotIn(List<Integer> values) {
            this.addCriterion("show_slide not in", values, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideBetween(Integer value1, Integer value2) {
            this.addCriterion("show_slide between", value1, value2, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowSlideNotBetween(Integer value1, Integer value2) {
            this.addCriterion("show_slide not between", value1, value2, "showSlide");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionIsNull() {
            this.addCriterion("show_description is null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionIsNotNull() {
            this.addCriterion("show_description is not null");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionEqualTo(Integer value) {
            this.addCriterion("show_description =", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionNotEqualTo(Integer value) {
            this.addCriterion("show_description <>", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionGreaterThan(Integer value) {
            this.addCriterion("show_description >", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("show_description >=", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionLessThan(Integer value) {
            this.addCriterion("show_description <", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionLessThanOrEqualTo(Integer value) {
            this.addCriterion("show_description <=", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionLike(String value) {
            this.addCriterion("show_description like", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionNotLike(String value) {
            this.addCriterion("show_description not like", value, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }        public ShiguShopFitmentExample.Criteria andShowDescriptionIn(List<Integer> values) {
            this.addCriterion("show_description in", values, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionNotIn(List<Integer> values) {
            this.addCriterion("show_description not in", values, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionBetween(Integer value1, Integer value2) {
            this.addCriterion("show_description between", value1, value2, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }

        public ShiguShopFitmentExample.Criteria andShowDescriptionNotBetween(Integer value1, Integer value2) {
            this.addCriterion("show_description not between", value1, value2, "showDescription");
            return (ShiguShopFitmentExample.Criteria)this;
        }
    }
}
