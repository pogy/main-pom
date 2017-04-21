package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SpreadAuctTypeExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SpreadAuctTypeExample.Criteria> oredCriteria = new ArrayList();

    public SpreadAuctTypeExample() {
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

    public List<SpreadAuctTypeExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SpreadAuctTypeExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SpreadAuctTypeExample.Criteria or() {
        SpreadAuctTypeExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SpreadAuctTypeExample.Criteria createCriteria() {
        SpreadAuctTypeExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SpreadAuctTypeExample.Criteria createCriteriaInternal() {
        SpreadAuctTypeExample.Criteria criteria = new SpreadAuctTypeExample.Criteria();
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

    public static class Criteria extends SpreadAuctTypeExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SpreadAuctTypeExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SpreadAuctTypeExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SpreadAuctTypeExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SpreadAuctTypeExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SpreadAuctTypeExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SpreadAuctTypeExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SpreadAuctTypeExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }        public SpreadAuctTypeExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }        public SpreadAuctTypeExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumIsNull() {
            this.addCriterion("spread_num is null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumIsNotNull() {
            this.addCriterion("spread_num is not null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumEqualTo(Long value) {
            this.addCriterion("spread_num =", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumNotEqualTo(Long value) {
            this.addCriterion("spread_num <>", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumGreaterThan(Long value) {
            this.addCriterion("spread_num >", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("spread_num >=", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumLessThan(Long value) {
            this.addCriterion("spread_num <", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumLessThanOrEqualTo(Long value) {
            this.addCriterion("spread_num <=", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumLike(String value) {
            this.addCriterion("spread_num like", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumNotLike(String value) {
            this.addCriterion("spread_num not like", value, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }        public SpreadAuctTypeExample.Criteria andSpreadNumIn(List<Long> values) {
            this.addCriterion("spread_num in", values, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumNotIn(List<Long> values) {
            this.addCriterion("spread_num not in", values, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumBetween(Long value1, Long value2) {
            this.addCriterion("spread_num between", value1, value2, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andSpreadNumNotBetween(Long value1, Long value2) {
            this.addCriterion("spread_num not between", value1, value2, "spreadNum");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceEqualTo(Long value) {
            this.addCriterion("price =", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceNotEqualTo(Long value) {
            this.addCriterion("price <>", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceGreaterThan(Long value) {
            this.addCriterion("price >", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("price >=", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceLessThan(Long value) {
            this.addCriterion("price <", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("price <=", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceLike(String value) {
            this.addCriterion("price like", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceNotLike(String value) {
            this.addCriterion("price not like", value, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }        public SpreadAuctTypeExample.Criteria andPriceIn(List<Long> values) {
            this.addCriterion("price in", values, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceNotIn(List<Long> values) {
            this.addCriterion("price not in", values, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceBetween(Long value1, Long value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }        public SpreadAuctTypeExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeIsNull() {
            this.addCriterion("modify_time is null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeIsNotNull() {
            this.addCriterion("modify_time is not null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeEqualTo(Date value) {
            this.addCriterion("modify_time =", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeNotEqualTo(Date value) {
            this.addCriterion("modify_time <>", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeGreaterThan(Date value) {
            this.addCriterion("modify_time >", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modify_time >=", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeLessThan(Date value) {
            this.addCriterion("modify_time <", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("modify_time <=", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeLike(String value) {
            this.addCriterion("modify_time like", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeNotLike(String value) {
            this.addCriterion("modify_time not like", value, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }        public SpreadAuctTypeExample.Criteria andModifyTimeIn(List<Date> values) {
            this.addCriterion("modify_time in", values, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeNotIn(List<Date> values) {
            this.addCriterion("modify_time not in", values, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("modify_time between", value1, value2, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledIsNull() {
            this.addCriterion("dis_enabled is null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledIsNotNull() {
            this.addCriterion("dis_enabled is not null");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledEqualTo(Boolean value) {
            this.addCriterion("dis_enabled =", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledNotEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <>", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledGreaterThan(Boolean value) {
            this.addCriterion("dis_enabled >", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled >=", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledLessThan(Boolean value) {
            this.addCriterion("dis_enabled <", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("dis_enabled <=", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledLike(String value) {
            this.addCriterion("dis_enabled like", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledNotLike(String value) {
            this.addCriterion("dis_enabled not like", value, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }        public SpreadAuctTypeExample.Criteria andDisEnabledIn(List<Boolean> values) {
            this.addCriterion("dis_enabled in", values, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledNotIn(List<Boolean> values) {
            this.addCriterion("dis_enabled not in", values, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled between", value1, value2, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }

        public SpreadAuctTypeExample.Criteria andDisEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("dis_enabled not between", value1, value2, "disEnabled");
            return (SpreadAuctTypeExample.Criteria)this;
        }
    }
}
