package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderServiceExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderServiceExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderServiceExample() {
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

    public List<ItemOrderServiceExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderServiceExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderServiceExample.Criteria or() {
        ItemOrderServiceExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderServiceExample.Criteria createCriteria() {
        ItemOrderServiceExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderServiceExample.Criteria createCriteriaInternal() {
        ItemOrderServiceExample.Criteria criteria = new ItemOrderServiceExample.Criteria();
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

    public static class Criteria extends ItemOrderServiceExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderServiceExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderServiceExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderServiceExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderServiceExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderServiceExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderServiceExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderServiceExample.Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyEqualTo(String value) {
            this.addCriterion("money =", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyNotEqualTo(String value) {
            this.addCriterion("money <>", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyGreaterThan(String value) {
            this.addCriterion("money >", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyGreaterThanOrEqualTo(String value) {
            this.addCriterion("money >=", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyLessThan(String value) {
            this.addCriterion("money <", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyLessThanOrEqualTo(String value) {
            this.addCriterion("money <=", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyLike(String value) {
            this.addCriterion("money like", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyNotLike(String value) {
            this.addCriterion("money not like", value, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }        public ItemOrderServiceExample.Criteria andMoneyIn(List<String> values) {
            this.addCriterion("money in", values, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyNotIn(List<String> values) {
            this.addCriterion("money not in", values, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyBetween(String value1, String value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andMoneyNotBetween(String value1, String value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdIsNull() {
            this.addCriterion("serviceId is null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdIsNotNull() {
            this.addCriterion("serviceId is not null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdEqualTo(String value) {
            this.addCriterion("serviceId =", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdNotEqualTo(String value) {
            this.addCriterion("serviceId <>", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdGreaterThan(String value) {
            this.addCriterion("serviceId >", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("serviceId >=", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdLessThan(String value) {
            this.addCriterion("serviceId <", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdLessThanOrEqualTo(String value) {
            this.addCriterion("serviceId <=", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdLike(String value) {
            this.addCriterion("serviceId like", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdNotLike(String value) {
            this.addCriterion("serviceId not like", value, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }        public ItemOrderServiceExample.Criteria andServiceIdIn(List<String> values) {
            this.addCriterion("serviceId in", values, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdNotIn(List<String> values) {
            this.addCriterion("serviceId not in", values, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdBetween(String value1, String value2) {
            this.addCriterion("serviceId between", value1, value2, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andServiceIdNotBetween(String value1, String value2) {
            this.addCriterion("serviceId not between", value1, value2, "service_id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }        public ItemOrderServiceExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdEqualTo(String value) {
            this.addCriterion("id =", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdNotEqualTo(String value) {
            this.addCriterion("id <>", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdGreaterThan(String value) {
            this.addCriterion("id >", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("id >=", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdLessThan(String value) {
            this.addCriterion("id <", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdLessThanOrEqualTo(String value) {
            this.addCriterion("id <=", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }        public ItemOrderServiceExample.Criteria andIdIn(List<String> values) {
            this.addCriterion("id in", values, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdNotIn(List<String> values) {
            this.addCriterion("id not in", values, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdBetween(String value1, String value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andIdNotBetween(String value1, String value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidEqualTo(String value) {
            this.addCriterion("oid =", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidNotEqualTo(String value) {
            this.addCriterion("oid <>", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidGreaterThan(String value) {
            this.addCriterion("oid >", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidGreaterThanOrEqualTo(String value) {
            this.addCriterion("oid >=", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidLessThan(String value) {
            this.addCriterion("oid <", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidLessThanOrEqualTo(String value) {
            this.addCriterion("oid <=", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }        public ItemOrderServiceExample.Criteria andOidIn(List<String> values) {
            this.addCriterion("oid in", values, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidNotIn(List<String> values) {
            this.addCriterion("oid not in", values, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidBetween(String value1, String value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }

        public ItemOrderServiceExample.Criteria andOidNotBetween(String value1, String value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (ItemOrderServiceExample.Criteria)this;
        }
    }
}
