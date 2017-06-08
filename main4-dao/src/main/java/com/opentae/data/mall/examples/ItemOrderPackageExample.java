package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderPackageExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderPackageExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderPackageExample() {
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

    public List<ItemOrderPackageExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderPackageExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderPackageExample.Criteria or() {
        ItemOrderPackageExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderPackageExample.Criteria createCriteria() {
        ItemOrderPackageExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderPackageExample.Criteria createCriteriaInternal() {
        ItemOrderPackageExample.Criteria criteria = new ItemOrderPackageExample.Criteria();
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

    public static class Criteria extends ItemOrderPackageExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderPackageExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderPackageExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderPackageExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderPackageExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderPackageExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderPackageExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderPackageExample.Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyEqualTo(Long value) {
            this.addCriterion("money =", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyNotEqualTo(Long value) {
            this.addCriterion("money <>", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyGreaterThan(Long value) {
            this.addCriterion("money >", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("money >=", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyLessThan(Long value) {
            this.addCriterion("money <", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("money <=", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyLike(String value) {
            this.addCriterion("money like", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyNotLike(String value) {
            this.addCriterion("money not like", value, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }        public ItemOrderPackageExample.Criteria andMoneyIn(List<Long> values) {
            this.addCriterion("money in", values, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyNotIn(List<Long> values) {
            this.addCriterion("money not in", values, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyBetween(Long value1, Long value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumEqualTo(Integer value) {
            this.addCriterion("num =", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumNotEqualTo(Integer value) {
            this.addCriterion("num <>", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumGreaterThan(Integer value) {
            this.addCriterion("num >", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("num >=", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumLessThan(Integer value) {
            this.addCriterion("num <", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("num <=", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }        public ItemOrderPackageExample.Criteria andNumIn(List<Integer> values) {
            this.addCriterion("num in", values, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumNotIn(List<Integer> values) {
            this.addCriterion("num not in", values, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumBetween(Integer value1, Integer value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }        public ItemOrderPackageExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdIsNull() {
            this.addCriterion("metarialId is null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdIsNotNull() {
            this.addCriterion("metarialId is not null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdEqualTo(Long value) {
            this.addCriterion("metarialId =", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdNotEqualTo(Long value) {
            this.addCriterion("metarialId <>", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdGreaterThan(Long value) {
            this.addCriterion("metarialId >", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("metarialId >=", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdLessThan(Long value) {
            this.addCriterion("metarialId <", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdLessThanOrEqualTo(Long value) {
            this.addCriterion("metarialId <=", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdLike(String value) {
            this.addCriterion("metarialId like", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdNotLike(String value) {
            this.addCriterion("metarialId not like", value, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }        public ItemOrderPackageExample.Criteria andMetarialIdIn(List<Long> values) {
            this.addCriterion("metarialId in", values, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdNotIn(List<Long> values) {
            this.addCriterion("metarialId not in", values, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdBetween(Long value1, Long value2) {
            this.addCriterion("metarialId between", value1, value2, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andMetarialIdNotBetween(Long value1, Long value2) {
            this.addCriterion("metarialId not between", value1, value2, "metarial_id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }        public ItemOrderPackageExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }        public ItemOrderPackageExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }

        public ItemOrderPackageExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (ItemOrderPackageExample.Criteria)this;
        }
    }
}
