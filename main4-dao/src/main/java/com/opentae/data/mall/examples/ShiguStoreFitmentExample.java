package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;
@Deprecated
public class ShiguStoreFitmentExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguStoreFitmentExample.Criteria> oredCriteria = new ArrayList();

    public ShiguStoreFitmentExample() {
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

    public List<ShiguStoreFitmentExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguStoreFitmentExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguStoreFitmentExample.Criteria or() {
        ShiguStoreFitmentExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguStoreFitmentExample.Criteria createCriteria() {
        ShiguStoreFitmentExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguStoreFitmentExample.Criteria createCriteriaInternal() {
        ShiguStoreFitmentExample.Criteria criteria = new ShiguStoreFitmentExample.Criteria();
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

    public static class Criteria extends ShiguStoreFitmentExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguStoreFitmentExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguStoreFitmentExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguStoreFitmentExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguStoreFitmentExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguStoreFitmentExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguStoreFitmentExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdIsNull() {
            this.addCriterion("fitment_id is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdIsNotNull() {
            this.addCriterion("fitment_id is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdEqualTo(Long value) {
            this.addCriterion("fitment_id =", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdNotEqualTo(Long value) {
            this.addCriterion("fitment_id <>", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdGreaterThan(Long value) {
            this.addCriterion("fitment_id >", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("fitment_id >=", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdLessThan(Long value) {
            this.addCriterion("fitment_id <", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdLessThanOrEqualTo(Long value) {
            this.addCriterion("fitment_id <=", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdLike(String value) {
            this.addCriterion("fitment_id like", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdNotLike(String value) {
            this.addCriterion("fitment_id not like", value, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andFitmentIdIn(List<Long> values) {
            this.addCriterion("fitment_id in", values, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdNotIn(List<Long> values) {
            this.addCriterion("fitment_id not in", values, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdBetween(Long value1, Long value2) {
            this.addCriterion("fitment_id between", value1, value2, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentIdNotBetween(Long value1, Long value2) {
            this.addCriterion("fitment_id not between", value1, value2, "fitmentId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameIsNull() {
            this.addCriterion("store_name is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameIsNotNull() {
            this.addCriterion("store_name is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameEqualTo(String value) {
            this.addCriterion("store_name =", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameNotEqualTo(String value) {
            this.addCriterion("store_name <>", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameGreaterThan(String value) {
            this.addCriterion("store_name >", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_name >=", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameLessThan(String value) {
            this.addCriterion("store_name <", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameLessThanOrEqualTo(String value) {
            this.addCriterion("store_name <=", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameLike(String value) {
            this.addCriterion("store_name like", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameNotLike(String value) {
            this.addCriterion("store_name not like", value, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreNameIn(List<String> values) {
            this.addCriterion("store_name in", values, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameNotIn(List<String> values) {
            this.addCriterion("store_name not in", values, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameBetween(String value1, String value2) {
            this.addCriterion("store_name between", value1, value2, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreNameNotBetween(String value1, String value2) {
            this.addCriterion("store_name not between", value1, value2, "storeName");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateIsNull() {
            this.addCriterion("fitment_date is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateIsNotNull() {
            this.addCriterion("fitment_date is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateEqualTo(Date value) {
            this.addCriterion("fitment_date =", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateNotEqualTo(Date value) {
            this.addCriterion("fitment_date <>", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateGreaterThan(Date value) {
            this.addCriterion("fitment_date >", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("fitment_date >=", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateLessThan(Date value) {
            this.addCriterion("fitment_date <", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateLessThanOrEqualTo(Date value) {
            this.addCriterion("fitment_date <=", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateLike(String value) {
            this.addCriterion("fitment_date like", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateNotLike(String value) {
            this.addCriterion("fitment_date not like", value, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andFitmentDateIn(List<Date> values) {
            this.addCriterion("fitment_date in", values, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateNotIn(List<Date> values) {
            this.addCriterion("fitment_date not in", values, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateBetween(Date value1, Date value2) {
            this.addCriterion("fitment_date between", value1, value2, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andFitmentDateNotBetween(Date value1, Date value2) {
            this.addCriterion("fitment_date not between", value1, value2, "fitmentDate");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeIsNull() {
            this.addCriterion("theme is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeIsNotNull() {
            this.addCriterion("theme is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeEqualTo(String value) {
            this.addCriterion("theme =", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeNotEqualTo(String value) {
            this.addCriterion("theme <>", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeGreaterThan(String value) {
            this.addCriterion("theme >", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeGreaterThanOrEqualTo(String value) {
            this.addCriterion("theme >=", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeLessThan(String value) {
            this.addCriterion("theme <", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeLessThanOrEqualTo(String value) {
            this.addCriterion("theme <=", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeLike(String value) {
            this.addCriterion("theme like", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeNotLike(String value) {
            this.addCriterion("theme not like", value, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andThemeIn(List<String> values) {
            this.addCriterion("theme in", values, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeNotIn(List<String> values) {
            this.addCriterion("theme not in", values, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeBetween(String value1, String value2) {
            this.addCriterion("theme between", value1, value2, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andThemeNotBetween(String value1, String value2) {
            this.addCriterion("theme not between", value1, value2, "theme");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerIsNull() {
            this.addCriterion("store_banner is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerIsNotNull() {
            this.addCriterion("store_banner is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerEqualTo(String value) {
            this.addCriterion("store_banner =", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerNotEqualTo(String value) {
            this.addCriterion("store_banner <>", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerGreaterThan(String value) {
            this.addCriterion("store_banner >", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_banner >=", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerLessThan(String value) {
            this.addCriterion("store_banner <", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerLessThanOrEqualTo(String value) {
            this.addCriterion("store_banner <=", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerLike(String value) {
            this.addCriterion("store_banner like", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerNotLike(String value) {
            this.addCriterion("store_banner not like", value, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreBannerIn(List<String> values) {
            this.addCriterion("store_banner in", values, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerNotIn(List<String> values) {
            this.addCriterion("store_banner not in", values, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerBetween(String value1, String value2) {
            this.addCriterion("store_banner between", value1, value2, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBannerNotBetween(String value1, String value2) {
            this.addCriterion("store_banner not between", value1, value2, "storeBanner");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2IsNull() {
            this.addCriterion("store_banner2 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2IsNotNull() {
            this.addCriterion("store_banner2 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2EqualTo(String value) {
            this.addCriterion("store_banner2 =", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2NotEqualTo(String value) {
            this.addCriterion("store_banner2 <>", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2GreaterThan(String value) {
            this.addCriterion("store_banner2 >", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2GreaterThanOrEqualTo(String value) {
            this.addCriterion("store_banner2 >=", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2LessThan(String value) {
            this.addCriterion("store_banner2 <", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2LessThanOrEqualTo(String value) {
            this.addCriterion("store_banner2 <=", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2Like(String value) {
            this.addCriterion("store_banner2 like", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2NotLike(String value) {
            this.addCriterion("store_banner2 not like", value, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreBanner2In(List<String> values) {
            this.addCriterion("store_banner2 in", values, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2NotIn(List<String> values) {
            this.addCriterion("store_banner2 not in", values, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2Between(String value1, String value2) {
            this.addCriterion("store_banner2 between", value1, value2, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner2NotBetween(String value1, String value2) {
            this.addCriterion("store_banner2 not between", value1, value2, "storeBanner2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3IsNull() {
            this.addCriterion("store_banner3 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3IsNotNull() {
            this.addCriterion("store_banner3 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3EqualTo(String value) {
            this.addCriterion("store_banner3 =", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3NotEqualTo(String value) {
            this.addCriterion("store_banner3 <>", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3GreaterThan(String value) {
            this.addCriterion("store_banner3 >", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3GreaterThanOrEqualTo(String value) {
            this.addCriterion("store_banner3 >=", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3LessThan(String value) {
            this.addCriterion("store_banner3 <", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3LessThanOrEqualTo(String value) {
            this.addCriterion("store_banner3 <=", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3Like(String value) {
            this.addCriterion("store_banner3 like", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3NotLike(String value) {
            this.addCriterion("store_banner3 not like", value, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreBanner3In(List<String> values) {
            this.addCriterion("store_banner3 in", values, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3NotIn(List<String> values) {
            this.addCriterion("store_banner3 not in", values, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3Between(String value1, String value2) {
            this.addCriterion("store_banner3 between", value1, value2, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner3NotBetween(String value1, String value2) {
            this.addCriterion("store_banner3 not between", value1, value2, "storeBanner3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4IsNull() {
            this.addCriterion("store_banner4 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4IsNotNull() {
            this.addCriterion("store_banner4 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4EqualTo(String value) {
            this.addCriterion("store_banner4 =", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4NotEqualTo(String value) {
            this.addCriterion("store_banner4 <>", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4GreaterThan(String value) {
            this.addCriterion("store_banner4 >", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4GreaterThanOrEqualTo(String value) {
            this.addCriterion("store_banner4 >=", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4LessThan(String value) {
            this.addCriterion("store_banner4 <", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4LessThanOrEqualTo(String value) {
            this.addCriterion("store_banner4 <=", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4Like(String value) {
            this.addCriterion("store_banner4 like", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4NotLike(String value) {
            this.addCriterion("store_banner4 not like", value, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreBanner4In(List<String> values) {
            this.addCriterion("store_banner4 in", values, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4NotIn(List<String> values) {
            this.addCriterion("store_banner4 not in", values, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4Between(String value1, String value2) {
            this.addCriterion("store_banner4 between", value1, value2, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner4NotBetween(String value1, String value2) {
            this.addCriterion("store_banner4 not between", value1, value2, "storeBanner4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5IsNull() {
            this.addCriterion("store_banner5 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5IsNotNull() {
            this.addCriterion("store_banner5 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5EqualTo(String value) {
            this.addCriterion("store_banner5 =", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5NotEqualTo(String value) {
            this.addCriterion("store_banner5 <>", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5GreaterThan(String value) {
            this.addCriterion("store_banner5 >", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5GreaterThanOrEqualTo(String value) {
            this.addCriterion("store_banner5 >=", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5LessThan(String value) {
            this.addCriterion("store_banner5 <", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5LessThanOrEqualTo(String value) {
            this.addCriterion("store_banner5 <=", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5Like(String value) {
            this.addCriterion("store_banner5 like", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5NotLike(String value) {
            this.addCriterion("store_banner5 not like", value, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreBanner5In(List<String> values) {
            this.addCriterion("store_banner5 in", values, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5NotIn(List<String> values) {
            this.addCriterion("store_banner5 not in", values, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5Between(String value1, String value2) {
            this.addCriterion("store_banner5 between", value1, value2, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreBanner5NotBetween(String value1, String value2) {
            this.addCriterion("store_banner5 not between", value1, value2, "storeBanner5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoIsNull() {
            this.addCriterion("store_logo is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoIsNotNull() {
            this.addCriterion("store_logo is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoEqualTo(String value) {
            this.addCriterion("store_logo =", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoNotEqualTo(String value) {
            this.addCriterion("store_logo <>", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoGreaterThan(String value) {
            this.addCriterion("store_logo >", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_logo >=", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoLessThan(String value) {
            this.addCriterion("store_logo <", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoLessThanOrEqualTo(String value) {
            this.addCriterion("store_logo <=", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoLike(String value) {
            this.addCriterion("store_logo like", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoNotLike(String value) {
            this.addCriterion("store_logo not like", value, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStoreLogoIn(List<String> values) {
            this.addCriterion("store_logo in", values, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoNotIn(List<String> values) {
            this.addCriterion("store_logo not in", values, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoBetween(String value1, String value2) {
            this.addCriterion("store_logo between", value1, value2, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStoreLogoNotBetween(String value1, String value2) {
            this.addCriterion("store_logo not between", value1, value2, "storeLogo");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionIsNull() {
            this.addCriterion("description is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionIsNotNull() {
            this.addCriterion("description is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionEqualTo(String value) {
            this.addCriterion("description =", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionNotEqualTo(String value) {
            this.addCriterion("description <>", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionGreaterThan(String value) {
            this.addCriterion("description >", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            this.addCriterion("description >=", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionLessThan(String value) {
            this.addCriterion("description <", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            this.addCriterion("description <=", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionLike(String value) {
            this.addCriterion("description like", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionNotLike(String value) {
            this.addCriterion("description not like", value, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andDescriptionIn(List<String> values) {
            this.addCriterion("description in", values, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionNotIn(List<String> values) {
            this.addCriterion("description not in", values, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionBetween(String value1, String value2) {
            this.addCriterion("description between", value1, value2, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            this.addCriterion("description not between", value1, value2, "description");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1IsNull() {
            this.addCriterion("image1 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1IsNotNull() {
            this.addCriterion("image1 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1EqualTo(String value) {
            this.addCriterion("image1 =", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1NotEqualTo(String value) {
            this.addCriterion("image1 <>", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1GreaterThan(String value) {
            this.addCriterion("image1 >", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1GreaterThanOrEqualTo(String value) {
            this.addCriterion("image1 >=", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1LessThan(String value) {
            this.addCriterion("image1 <", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1LessThanOrEqualTo(String value) {
            this.addCriterion("image1 <=", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1Like(String value) {
            this.addCriterion("image1 like", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1NotLike(String value) {
            this.addCriterion("image1 not like", value, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andImage1In(List<String> values) {
            this.addCriterion("image1 in", values, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1NotIn(List<String> values) {
            this.addCriterion("image1 not in", values, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1Between(String value1, String value2) {
            this.addCriterion("image1 between", value1, value2, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage1NotBetween(String value1, String value2) {
            this.addCriterion("image1 not between", value1, value2, "image1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2IsNull() {
            this.addCriterion("image2 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2IsNotNull() {
            this.addCriterion("image2 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2EqualTo(String value) {
            this.addCriterion("image2 =", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2NotEqualTo(String value) {
            this.addCriterion("image2 <>", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2GreaterThan(String value) {
            this.addCriterion("image2 >", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2GreaterThanOrEqualTo(String value) {
            this.addCriterion("image2 >=", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2LessThan(String value) {
            this.addCriterion("image2 <", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2LessThanOrEqualTo(String value) {
            this.addCriterion("image2 <=", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2Like(String value) {
            this.addCriterion("image2 like", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2NotLike(String value) {
            this.addCriterion("image2 not like", value, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andImage2In(List<String> values) {
            this.addCriterion("image2 in", values, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2NotIn(List<String> values) {
            this.addCriterion("image2 not in", values, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2Between(String value1, String value2) {
            this.addCriterion("image2 between", value1, value2, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage2NotBetween(String value1, String value2) {
            this.addCriterion("image2 not between", value1, value2, "image2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3IsNull() {
            this.addCriterion("image3 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3IsNotNull() {
            this.addCriterion("image3 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3EqualTo(String value) {
            this.addCriterion("image3 =", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3NotEqualTo(String value) {
            this.addCriterion("image3 <>", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3GreaterThan(String value) {
            this.addCriterion("image3 >", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3GreaterThanOrEqualTo(String value) {
            this.addCriterion("image3 >=", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3LessThan(String value) {
            this.addCriterion("image3 <", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3LessThanOrEqualTo(String value) {
            this.addCriterion("image3 <=", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3Like(String value) {
            this.addCriterion("image3 like", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3NotLike(String value) {
            this.addCriterion("image3 not like", value, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andImage3In(List<String> values) {
            this.addCriterion("image3 in", values, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3NotIn(List<String> values) {
            this.addCriterion("image3 not in", values, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3Between(String value1, String value2) {
            this.addCriterion("image3 between", value1, value2, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andImage3NotBetween(String value1, String value2) {
            this.addCriterion("image3 not between", value1, value2, "image3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }        public ShiguStoreFitmentExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }

        public ShiguStoreFitmentExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguStoreFitmentExample.Criteria)this;
        }
    }
}
