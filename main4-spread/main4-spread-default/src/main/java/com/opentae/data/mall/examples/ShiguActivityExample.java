package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguActivityExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguActivityExample.Criteria> oredCriteria = new ArrayList();

    public ShiguActivityExample() {
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

    public List<ShiguActivityExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguActivityExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguActivityExample.Criteria or() {
        ShiguActivityExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguActivityExample.Criteria createCriteria() {
        ShiguActivityExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguActivityExample.Criteria createCriteriaInternal() {
        ShiguActivityExample.Criteria criteria = new ShiguActivityExample.Criteria();
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

    public static class Criteria extends ShiguActivityExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguActivityExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguActivityExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguActivityExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguActivityExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguActivityExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguActivityExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguActivityExample.Criteria andImageIsNull() {
            this.addCriterion("image is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageIsNotNull() {
            this.addCriterion("image is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageEqualTo(String value) {
            this.addCriterion("image =", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageNotEqualTo(String value) {
            this.addCriterion("image <>", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageGreaterThan(String value) {
            this.addCriterion("image >", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageGreaterThanOrEqualTo(String value) {
            this.addCriterion("image >=", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageLessThan(String value) {
            this.addCriterion("image <", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageLessThanOrEqualTo(String value) {
            this.addCriterion("image <=", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageLike(String value) {
            this.addCriterion("image like", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageNotLike(String value) {
            this.addCriterion("image not like", value, "image");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andImageIn(List<String> values) {
            this.addCriterion("image in", values, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageNotIn(List<String> values) {
            this.addCriterion("image not in", values, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageBetween(String value1, String value2) {
            this.addCriterion("image between", value1, value2, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andImageNotBetween(String value1, String value2) {
            this.addCriterion("image not between", value1, value2, "image");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescIsNull() {
            this.addCriterion("cost_desc is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescIsNotNull() {
            this.addCriterion("cost_desc is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescEqualTo(String value) {
            this.addCriterion("cost_desc =", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescNotEqualTo(String value) {
            this.addCriterion("cost_desc <>", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescGreaterThan(String value) {
            this.addCriterion("cost_desc >", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("cost_desc >=", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescLessThan(String value) {
            this.addCriterion("cost_desc <", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescLessThanOrEqualTo(String value) {
            this.addCriterion("cost_desc <=", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescLike(String value) {
            this.addCriterion("cost_desc like", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescNotLike(String value) {
            this.addCriterion("cost_desc not like", value, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andCostDescIn(List<String> values) {
            this.addCriterion("cost_desc in", values, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescNotIn(List<String> values) {
            this.addCriterion("cost_desc not in", values, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescBetween(String value1, String value2) {
            this.addCriterion("cost_desc between", value1, value2, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andCostDescNotBetween(String value1, String value2) {
            this.addCriterion("cost_desc not between", value1, value2, "costDesc");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyIsNull() {
            this.addCriterion("start_apply is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyIsNotNull() {
            this.addCriterion("start_apply is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyEqualTo(Date value) {
            this.addCriterion("start_apply =", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyNotEqualTo(Date value) {
            this.addCriterion("start_apply <>", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyGreaterThan(Date value) {
            this.addCriterion("start_apply >", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyGreaterThanOrEqualTo(Date value) {
            this.addCriterion("start_apply >=", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyLessThan(Date value) {
            this.addCriterion("start_apply <", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyLessThanOrEqualTo(Date value) {
            this.addCriterion("start_apply <=", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyLike(String value) {
            this.addCriterion("start_apply like", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyNotLike(String value) {
            this.addCriterion("start_apply not like", value, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andStartApplyIn(List<Date> values) {
            this.addCriterion("start_apply in", values, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyNotIn(List<Date> values) {
            this.addCriterion("start_apply not in", values, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyBetween(Date value1, Date value2) {
            this.addCriterion("start_apply between", value1, value2, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartApplyNotBetween(Date value1, Date value2) {
            this.addCriterion("start_apply not between", value1, value2, "startApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoIsNull() {
            this.addCriterion("desc_info is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoIsNotNull() {
            this.addCriterion("desc_info is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoEqualTo(String value) {
            this.addCriterion("desc_info =", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoNotEqualTo(String value) {
            this.addCriterion("desc_info <>", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoGreaterThan(String value) {
            this.addCriterion("desc_info >", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoGreaterThanOrEqualTo(String value) {
            this.addCriterion("desc_info >=", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoLessThan(String value) {
            this.addCriterion("desc_info <", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoLessThanOrEqualTo(String value) {
            this.addCriterion("desc_info <=", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoLike(String value) {
            this.addCriterion("desc_info like", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoNotLike(String value) {
            this.addCriterion("desc_info not like", value, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andDescInfoIn(List<String> values) {
            this.addCriterion("desc_info in", values, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoNotIn(List<String> values) {
            this.addCriterion("desc_info not in", values, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoBetween(String value1, String value2) {
            this.addCriterion("desc_info between", value1, value2, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andDescInfoNotBetween(String value1, String value2) {
            this.addCriterion("desc_info not between", value1, value2, "descInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeIsNull() {
            this.addCriterion("end_time is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeIsNotNull() {
            this.addCriterion("end_time is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeEqualTo(Date value) {
            this.addCriterion("end_time =", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeNotEqualTo(Date value) {
            this.addCriterion("end_time <>", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeGreaterThan(Date value) {
            this.addCriterion("end_time >", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("end_time >=", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeLessThan(Date value) {
            this.addCriterion("end_time <", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("end_time <=", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeLike(String value) {
            this.addCriterion("end_time like", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeNotLike(String value) {
            this.addCriterion("end_time not like", value, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andEndTimeIn(List<Date> values) {
            this.addCriterion("end_time in", values, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeNotIn(List<Date> values) {
            this.addCriterion("end_time not in", values, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            this.addCriterion("end_time between", value1, value2, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("end_time not between", value1, value2, "endTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerIsNull() {
            this.addCriterion("banner is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerIsNotNull() {
            this.addCriterion("banner is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerEqualTo(String value) {
            this.addCriterion("banner =", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerNotEqualTo(String value) {
            this.addCriterion("banner <>", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerGreaterThan(String value) {
            this.addCriterion("banner >", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerGreaterThanOrEqualTo(String value) {
            this.addCriterion("banner >=", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerLessThan(String value) {
            this.addCriterion("banner <", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerLessThanOrEqualTo(String value) {
            this.addCriterion("banner <=", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerLike(String value) {
            this.addCriterion("banner like", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerNotLike(String value) {
            this.addCriterion("banner not like", value, "banner");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andBannerIn(List<String> values) {
            this.addCriterion("banner in", values, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerNotIn(List<String> values) {
            this.addCriterion("banner not in", values, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerBetween(String value1, String value2) {
            this.addCriterion("banner between", value1, value2, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBannerNotBetween(String value1, String value2) {
            this.addCriterion("banner not between", value1, value2, "banner");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesIsNull() {
            this.addCriterion("services is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesIsNotNull() {
            this.addCriterion("services is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesEqualTo(String value) {
            this.addCriterion("services =", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesNotEqualTo(String value) {
            this.addCriterion("services <>", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesGreaterThan(String value) {
            this.addCriterion("services >", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesGreaterThanOrEqualTo(String value) {
            this.addCriterion("services >=", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesLessThan(String value) {
            this.addCriterion("services <", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesLessThanOrEqualTo(String value) {
            this.addCriterion("services <=", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesLike(String value) {
            this.addCriterion("services like", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesNotLike(String value) {
            this.addCriterion("services not like", value, "services");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andServicesIn(List<String> values) {
            this.addCriterion("services in", values, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesNotIn(List<String> values) {
            this.addCriterion("services not in", values, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesBetween(String value1, String value2) {
            this.addCriterion("services between", value1, value2, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andServicesNotBetween(String value1, String value2) {
            this.addCriterion("services not between", value1, value2, "services");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdIsNull() {
            this.addCriterion("location_id is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdIsNotNull() {
            this.addCriterion("location_id is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdEqualTo(Long value) {
            this.addCriterion("location_id =", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdNotEqualTo(Long value) {
            this.addCriterion("location_id <>", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdGreaterThan(Long value) {
            this.addCriterion("location_id >", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("location_id >=", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdLessThan(Long value) {
            this.addCriterion("location_id <", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdLessThanOrEqualTo(Long value) {
            this.addCriterion("location_id <=", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdLike(String value) {
            this.addCriterion("location_id like", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdNotLike(String value) {
            this.addCriterion("location_id not like", value, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andLocationIdIn(List<Long> values) {
            this.addCriterion("location_id in", values, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdNotIn(List<Long> values) {
            this.addCriterion("location_id not in", values, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdBetween(Long value1, Long value2) {
            this.addCriterion("location_id between", value1, value2, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andLocationIdNotBetween(Long value1, Long value2) {
            this.addCriterion("location_id not between", value1, value2, "locationId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeIsNull() {
            this.addCriterion("start_time is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeIsNotNull() {
            this.addCriterion("start_time is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeEqualTo(Date value) {
            this.addCriterion("start_time =", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeNotEqualTo(Date value) {
            this.addCriterion("start_time <>", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeGreaterThan(Date value) {
            this.addCriterion("start_time >", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("start_time >=", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeLessThan(Date value) {
            this.addCriterion("start_time <", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("start_time <=", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeLike(String value) {
            this.addCriterion("start_time like", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeNotLike(String value) {
            this.addCriterion("start_time not like", value, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andStartTimeIn(List<Date> values) {
            this.addCriterion("start_time in", values, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeNotIn(List<Date> values) {
            this.addCriterion("start_time not in", values, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            this.addCriterion("start_time between", value1, value2, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("start_time not between", value1, value2, "startTime");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyIsNull() {
            this.addCriterion("end_apply is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyIsNotNull() {
            this.addCriterion("end_apply is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyEqualTo(Date value) {
            this.addCriterion("end_apply =", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyNotEqualTo(Date value) {
            this.addCriterion("end_apply <>", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyGreaterThan(Date value) {
            this.addCriterion("end_apply >", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyGreaterThanOrEqualTo(Date value) {
            this.addCriterion("end_apply >=", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyLessThan(Date value) {
            this.addCriterion("end_apply <", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyLessThanOrEqualTo(Date value) {
            this.addCriterion("end_apply <=", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyLike(String value) {
            this.addCriterion("end_apply like", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyNotLike(String value) {
            this.addCriterion("end_apply not like", value, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andEndApplyIn(List<Date> values) {
            this.addCriterion("end_apply in", values, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyNotIn(List<Date> values) {
            this.addCriterion("end_apply not in", values, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyBetween(Date value1, Date value2) {
            this.addCriterion("end_apply between", value1, value2, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andEndApplyNotBetween(Date value1, Date value2) {
            this.addCriterion("end_apply not between", value1, value2, "endApply");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdIsNull() {
            this.addCriterion("activity_id is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdIsNotNull() {
            this.addCriterion("activity_id is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdEqualTo(Long value) {
            this.addCriterion("activity_id =", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdNotEqualTo(Long value) {
            this.addCriterion("activity_id <>", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdGreaterThan(Long value) {
            this.addCriterion("activity_id >", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("activity_id >=", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdLessThan(Long value) {
            this.addCriterion("activity_id <", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("activity_id <=", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdLike(String value) {
            this.addCriterion("activity_id like", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdNotLike(String value) {
            this.addCriterion("activity_id not like", value, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andActivityIdIn(List<Long> values) {
            this.addCriterion("activity_id in", values, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdNotIn(List<Long> values) {
            this.addCriterion("activity_id not in", values, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            this.addCriterion("activity_id between", value1, value2, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("activity_id not between", value1, value2, "activityId");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoIsNull() {
            this.addCriterion("rule_info is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoIsNotNull() {
            this.addCriterion("rule_info is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoEqualTo(String value) {
            this.addCriterion("rule_info =", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoNotEqualTo(String value) {
            this.addCriterion("rule_info <>", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoGreaterThan(String value) {
            this.addCriterion("rule_info >", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoGreaterThanOrEqualTo(String value) {
            this.addCriterion("rule_info >=", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoLessThan(String value) {
            this.addCriterion("rule_info <", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoLessThanOrEqualTo(String value) {
            this.addCriterion("rule_info <=", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoLike(String value) {
            this.addCriterion("rule_info like", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoNotLike(String value) {
            this.addCriterion("rule_info not like", value, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andRuleInfoIn(List<String> values) {
            this.addCriterion("rule_info in", values, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoNotIn(List<String> values) {
            this.addCriterion("rule_info not in", values, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoBetween(String value1, String value2) {
            this.addCriterion("rule_info between", value1, value2, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andRuleInfoNotBetween(String value1, String value2) {
            this.addCriterion("rule_info not between", value1, value2, "ruleInfo");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorIsNull() {
            this.addCriterion("bkcolor is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorIsNotNull() {
            this.addCriterion("bkcolor is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorEqualTo(String value) {
            this.addCriterion("bkcolor =", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorNotEqualTo(String value) {
            this.addCriterion("bkcolor <>", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorGreaterThan(String value) {
            this.addCriterion("bkcolor >", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorGreaterThanOrEqualTo(String value) {
            this.addCriterion("bkcolor >=", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorLessThan(String value) {
            this.addCriterion("bkcolor <", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorLessThanOrEqualTo(String value) {
            this.addCriterion("bkcolor <=", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorLike(String value) {
            this.addCriterion("bkcolor like", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorNotLike(String value) {
            this.addCriterion("bkcolor not like", value, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andBkcolorIn(List<String> values) {
            this.addCriterion("bkcolor in", values, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorNotIn(List<String> values) {
            this.addCriterion("bkcolor not in", values, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorBetween(String value1, String value2) {
            this.addCriterion("bkcolor between", value1, value2, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andBkcolorNotBetween(String value1, String value2) {
            this.addCriterion("bkcolor not between", value1, value2, "bkcolor");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsIsNull() {
            this.addCriterion("nums is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsIsNotNull() {
            this.addCriterion("nums is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsEqualTo(String value) {
            this.addCriterion("nums =", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsNotEqualTo(String value) {
            this.addCriterion("nums <>", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsGreaterThan(String value) {
            this.addCriterion("nums >", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsGreaterThanOrEqualTo(String value) {
            this.addCriterion("nums >=", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsLessThan(String value) {
            this.addCriterion("nums <", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsLessThanOrEqualTo(String value) {
            this.addCriterion("nums <=", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsLike(String value) {
            this.addCriterion("nums like", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsNotLike(String value) {
            this.addCriterion("nums not like", value, "nums");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andNumsIn(List<String> values) {
            this.addCriterion("nums in", values, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsNotIn(List<String> values) {
            this.addCriterion("nums not in", values, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsBetween(String value1, String value2) {
            this.addCriterion("nums between", value1, value2, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andNumsNotBetween(String value1, String value2) {
            this.addCriterion("nums not between", value1, value2, "nums");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }        public ShiguActivityExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }

        public ShiguActivityExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguActivityExample.Criteria)this;
        }
    }
}
