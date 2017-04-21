package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SpreadAuctShopExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SpreadAuctShopExample.Criteria> oredCriteria = new ArrayList();

    public SpreadAuctShopExample() {
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

    public List<SpreadAuctShopExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SpreadAuctShopExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SpreadAuctShopExample.Criteria or() {
        SpreadAuctShopExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SpreadAuctShopExample.Criteria createCriteria() {
        SpreadAuctShopExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SpreadAuctShopExample.Criteria createCriteriaInternal() {
        SpreadAuctShopExample.Criteria criteria = new SpreadAuctShopExample.Criteria();
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

    public static class Criteria extends SpreadAuctShopExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SpreadAuctShopExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SpreadAuctShopExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SpreadAuctShopExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SpreadAuctShopExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SpreadAuctShopExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SpreadAuctShopExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SpreadAuctShopExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdIsNull() {
            this.addCriterion("scren_id is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdIsNotNull() {
            this.addCriterion("scren_id is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdEqualTo(Long value) {
            this.addCriterion("scren_id =", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdNotEqualTo(Long value) {
            this.addCriterion("scren_id <>", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdGreaterThan(Long value) {
            this.addCriterion("scren_id >", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("scren_id >=", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdLessThan(Long value) {
            this.addCriterion("scren_id <", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdLessThanOrEqualTo(Long value) {
            this.addCriterion("scren_id <=", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdLike(String value) {
            this.addCriterion("scren_id like", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdNotLike(String value) {
            this.addCriterion("scren_id not like", value, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andScrenIdIn(List<Long> values) {
            this.addCriterion("scren_id in", values, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdNotIn(List<Long> values) {
            this.addCriterion("scren_id not in", values, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdBetween(Long value1, Long value2) {
            this.addCriterion("scren_id between", value1, value2, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andScrenIdNotBetween(Long value1, Long value2) {
            this.addCriterion("scren_id not between", value1, value2, "screnId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawIsNull() {
            this.addCriterion("is_draw is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawIsNotNull() {
            this.addCriterion("is_draw is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawEqualTo(Boolean value) {
            this.addCriterion("is_draw =", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawNotEqualTo(Boolean value) {
            this.addCriterion("is_draw <>", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawGreaterThan(Boolean value) {
            this.addCriterion("is_draw >", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("is_draw >=", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawLessThan(Boolean value) {
            this.addCriterion("is_draw <", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawLessThanOrEqualTo(Boolean value) {
            this.addCriterion("is_draw <=", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawLike(String value) {
            this.addCriterion("is_draw like", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawNotLike(String value) {
            this.addCriterion("is_draw not like", value, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andIsDrawIn(List<Boolean> values) {
            this.addCriterion("is_draw in", values, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawNotIn(List<Boolean> values) {
            this.addCriterion("is_draw not in", values, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawBetween(Boolean value1, Boolean value2) {
            this.addCriterion("is_draw between", value1, value2, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andIsDrawNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("is_draw not between", value1, value2, "isDraw");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneIsNull() {
            this.addCriterion("contacts_phone is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneIsNotNull() {
            this.addCriterion("contacts_phone is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneEqualTo(String value) {
            this.addCriterion("contacts_phone =", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneNotEqualTo(String value) {
            this.addCriterion("contacts_phone <>", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneGreaterThan(String value) {
            this.addCriterion("contacts_phone >", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("contacts_phone >=", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneLessThan(String value) {
            this.addCriterion("contacts_phone <", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("contacts_phone <=", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneLike(String value) {
            this.addCriterion("contacts_phone like", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneNotLike(String value) {
            this.addCriterion("contacts_phone not like", value, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andContactsPhoneIn(List<String> values) {
            this.addCriterion("contacts_phone in", values, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneNotIn(List<String> values) {
            this.addCriterion("contacts_phone not in", values, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneBetween(String value1, String value2) {
            this.addCriterion("contacts_phone between", value1, value2, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsPhoneNotBetween(String value1, String value2) {
            this.addCriterion("contacts_phone not between", value1, value2, "contactsPhone");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameIsNull() {
            this.addCriterion("contacts_name is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameIsNotNull() {
            this.addCriterion("contacts_name is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameEqualTo(String value) {
            this.addCriterion("contacts_name =", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameNotEqualTo(String value) {
            this.addCriterion("contacts_name <>", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameGreaterThan(String value) {
            this.addCriterion("contacts_name >", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("contacts_name >=", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameLessThan(String value) {
            this.addCriterion("contacts_name <", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameLessThanOrEqualTo(String value) {
            this.addCriterion("contacts_name <=", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameLike(String value) {
            this.addCriterion("contacts_name like", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameNotLike(String value) {
            this.addCriterion("contacts_name not like", value, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andContactsNameIn(List<String> values) {
            this.addCriterion("contacts_name in", values, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameNotIn(List<String> values) {
            this.addCriterion("contacts_name not in", values, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameBetween(String value1, String value2) {
            this.addCriterion("contacts_name between", value1, value2, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andContactsNameNotBetween(String value1, String value2) {
            this.addCriterion("contacts_name not between", value1, value2, "contactsName");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeIsNull() {
            this.addCriterion("modify_time is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeIsNotNull() {
            this.addCriterion("modify_time is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeEqualTo(Date value) {
            this.addCriterion("modify_time =", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeNotEqualTo(Date value) {
            this.addCriterion("modify_time <>", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeGreaterThan(Date value) {
            this.addCriterion("modify_time >", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modify_time >=", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeLessThan(Date value) {
            this.addCriterion("modify_time <", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("modify_time <=", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeLike(String value) {
            this.addCriterion("modify_time like", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeNotLike(String value) {
            this.addCriterion("modify_time not like", value, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andModifyTimeIn(List<Date> values) {
            this.addCriterion("modify_time in", values, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeNotIn(List<Date> values) {
            this.addCriterion("modify_time not in", values, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("modify_time between", value1, value2, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledIsNull() {
            this.addCriterion("enabled is null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledIsNotNull() {
            this.addCriterion("enabled is not null");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledEqualTo(Boolean value) {
            this.addCriterion("enabled =", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledNotEqualTo(Boolean value) {
            this.addCriterion("enabled <>", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledGreaterThan(Boolean value) {
            this.addCriterion("enabled >", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled >=", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledLessThan(Boolean value) {
            this.addCriterion("enabled <", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled <=", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledLike(String value) {
            this.addCriterion("enabled like", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledNotLike(String value) {
            this.addCriterion("enabled not like", value, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }        public SpreadAuctShopExample.Criteria andEnabledIn(List<Boolean> values) {
            this.addCriterion("enabled in", values, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledNotIn(List<Boolean> values) {
            this.addCriterion("enabled not in", values, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled between", value1, value2, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }

        public SpreadAuctShopExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled not between", value1, value2, "enabled");
            return (SpreadAuctShopExample.Criteria)this;
        }
    }
}
