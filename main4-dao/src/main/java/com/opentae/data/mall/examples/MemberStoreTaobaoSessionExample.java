package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class MemberStoreTaobaoSessionExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberStoreTaobaoSessionExample.Criteria> oredCriteria = new ArrayList();

    public MemberStoreTaobaoSessionExample() {
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

    public List<MemberStoreTaobaoSessionExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberStoreTaobaoSessionExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberStoreTaobaoSessionExample.Criteria or() {
        MemberStoreTaobaoSessionExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberStoreTaobaoSessionExample.Criteria createCriteria() {
        MemberStoreTaobaoSessionExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected MemberStoreTaobaoSessionExample.Criteria createCriteriaInternal() {
        MemberStoreTaobaoSessionExample.Criteria criteria = new MemberStoreTaobaoSessionExample.Criteria();
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

    public static class Criteria extends MemberStoreTaobaoSessionExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberStoreTaobaoSessionExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberStoreTaobaoSessionExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberStoreTaobaoSessionExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberStoreTaobaoSessionExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberStoreTaobaoSessionExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberStoreTaobaoSessionExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusIsNull() {
            this.addCriterion("store_status is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusIsNotNull() {
            this.addCriterion("store_status is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusEqualTo(Integer value) {
            this.addCriterion("store_status =", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusNotEqualTo(Integer value) {
            this.addCriterion("store_status <>", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusGreaterThan(Integer value) {
            this.addCriterion("store_status >", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("store_status >=", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusLessThan(Integer value) {
            this.addCriterion("store_status <", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("store_status <=", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusLike(String value) {
            this.addCriterion("store_status like", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusNotLike(String value) {
            this.addCriterion("store_status not like", value, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusIn(List<Integer> values) {
            this.addCriterion("store_status in", values, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusNotIn(List<Integer> values) {
            this.addCriterion("store_status not in", values, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("store_status between", value1, value2, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("store_status not between", value1, value2, "storeStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusIsNull() {
            this.addCriterion("open_status is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusIsNotNull() {
            this.addCriterion("open_status is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusEqualTo(Integer value) {
            this.addCriterion("open_status =", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusNotEqualTo(Integer value) {
            this.addCriterion("open_status <>", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusGreaterThan(Integer value) {
            this.addCriterion("open_status >", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("open_status >=", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusLessThan(Integer value) {
            this.addCriterion("open_status <", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("open_status <=", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusLike(String value) {
            this.addCriterion("open_status like", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusNotLike(String value) {
            this.addCriterion("open_status not like", value, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusIn(List<Integer> values) {
            this.addCriterion("open_status in", values, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusNotIn(List<Integer> values) {
            this.addCriterion("open_status not in", values, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("open_status between", value1, value2, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("open_status not between", value1, value2, "openStatus");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeIsNull() {
            this.addCriterion("update_time is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeIsNotNull() {
            this.addCriterion("update_time is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeEqualTo(Date value) {
            this.addCriterion("update_time =", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            this.addCriterion("update_time <>", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeGreaterThan(Date value) {
            this.addCriterion("update_time >", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("update_time >=", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeLessThan(Date value) {
            this.addCriterion("update_time <", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("update_time <=", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeLike(String value) {
            this.addCriterion("update_time like", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeNotLike(String value) {
            this.addCriterion("update_time not like", value, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeIn(List<Date> values) {
            this.addCriterion("update_time in", values, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            this.addCriterion("update_time not in", values, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            this.addCriterion("update_time between", value1, value2, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("update_time not between", value1, value2, "updateTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionIsNull() {
            this.addCriterion("taobao_bind_session is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionIsNotNull() {
            this.addCriterion("taobao_bind_session is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionEqualTo(String value) {
            this.addCriterion("taobao_bind_session =", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotEqualTo(String value) {
            this.addCriterion("taobao_bind_session <>", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionGreaterThan(String value) {
            this.addCriterion("taobao_bind_session >", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_bind_session >=", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionLessThan(String value) {
            this.addCriterion("taobao_bind_session <", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_bind_session <=", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionLike(String value) {
            this.addCriterion("taobao_bind_session like", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotLike(String value) {
            this.addCriterion("taobao_bind_session not like", value, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionIn(List<String> values) {
            this.addCriterion("taobao_bind_session in", values, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotIn(List<String> values) {
            this.addCriterion("taobao_bind_session not in", values, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionBetween(String value1, String value2) {
            this.addCriterion("taobao_bind_session between", value1, value2, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotBetween(String value1, String value2) {
            this.addCriterion("taobao_bind_session not between", value1, value2, "taobaoBindSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsIsNull() {
            this.addCriterion("open_logs is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsIsNotNull() {
            this.addCriterion("open_logs is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsEqualTo(String value) {
            this.addCriterion("open_logs =", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotEqualTo(String value) {
            this.addCriterion("open_logs <>", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsGreaterThan(String value) {
            this.addCriterion("open_logs >", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsGreaterThanOrEqualTo(String value) {
            this.addCriterion("open_logs >=", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsLessThan(String value) {
            this.addCriterion("open_logs <", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsLessThanOrEqualTo(String value) {
            this.addCriterion("open_logs <=", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsLike(String value) {
            this.addCriterion("open_logs like", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotLike(String value) {
            this.addCriterion("open_logs not like", value, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsIn(List<String> values) {
            this.addCriterion("open_logs in", values, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotIn(List<String> values) {
            this.addCriterion("open_logs not in", values, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsBetween(String value1, String value2) {
            this.addCriterion("open_logs between", value1, value2, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotBetween(String value1, String value2) {
            this.addCriterion("open_logs not between", value1, value2, "openLogs");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdIsNull() {
            this.addCriterion("msts_id is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdIsNotNull() {
            this.addCriterion("msts_id is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdEqualTo(Long value) {
            this.addCriterion("msts_id =", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdNotEqualTo(Long value) {
            this.addCriterion("msts_id <>", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdGreaterThan(Long value) {
            this.addCriterion("msts_id >", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("msts_id >=", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdLessThan(Long value) {
            this.addCriterion("msts_id <", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("msts_id <=", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdLike(String value) {
            this.addCriterion("msts_id like", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdNotLike(String value) {
            this.addCriterion("msts_id not like", value, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andMstsIdIn(List<Long> values) {
            this.addCriterion("msts_id in", values, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdNotIn(List<Long> values) {
            this.addCriterion("msts_id not in", values, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdBetween(Long value1, Long value2) {
            this.addCriterion("msts_id between", value1, value2, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("msts_id not between", value1, value2, "mstsId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpIsNull() {
            this.addCriterion("login_ip is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpIsNotNull() {
            this.addCriterion("login_ip is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpEqualTo(String value) {
            this.addCriterion("login_ip =", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotEqualTo(String value) {
            this.addCriterion("login_ip <>", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpGreaterThan(String value) {
            this.addCriterion("login_ip >", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_ip >=", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpLessThan(String value) {
            this.addCriterion("login_ip <", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpLessThanOrEqualTo(String value) {
            this.addCriterion("login_ip <=", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpLike(String value) {
            this.addCriterion("login_ip like", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotLike(String value) {
            this.addCriterion("login_ip not like", value, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andLoginIpIn(List<String> values) {
            this.addCriterion("login_ip in", values, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotIn(List<String> values) {
            this.addCriterion("login_ip not in", values, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpBetween(String value1, String value2) {
            this.addCriterion("login_ip between", value1, value2, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotBetween(String value1, String value2) {
            this.addCriterion("login_ip not between", value1, value2, "loginIp");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteIsNull() {
            this.addCriterion("site is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteIsNotNull() {
            this.addCriterion("site is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteEqualTo(String value) {
            this.addCriterion("site =", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotEqualTo(String value) {
            this.addCriterion("site <>", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteGreaterThan(String value) {
            this.addCriterion("site >", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("site >=", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteLessThan(String value) {
            this.addCriterion("site <", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteLessThanOrEqualTo(String value) {
            this.addCriterion("site <=", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteLike(String value) {
            this.addCriterion("site like", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotLike(String value) {
            this.addCriterion("site not like", value, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andSiteIn(List<String> values) {
            this.addCriterion("site in", values, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotIn(List<String> values) {
            this.addCriterion("site not in", values, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteBetween(String value1, String value2) {
            this.addCriterion("site between", value1, value2, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotBetween(String value1, String value2) {
            this.addCriterion("site not between", value1, value2, "site");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionIsNull() {
            this.addCriterion("taobao_login_session is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionIsNotNull() {
            this.addCriterion("taobao_login_session is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionEqualTo(String value) {
            this.addCriterion("taobao_login_session =", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotEqualTo(String value) {
            this.addCriterion("taobao_login_session <>", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionGreaterThan(String value) {
            this.addCriterion("taobao_login_session >", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_login_session >=", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionLessThan(String value) {
            this.addCriterion("taobao_login_session <", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_login_session <=", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionLike(String value) {
            this.addCriterion("taobao_login_session like", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotLike(String value) {
            this.addCriterion("taobao_login_session not like", value, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionIn(List<String> values) {
            this.addCriterion("taobao_login_session in", values, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotIn(List<String> values) {
            this.addCriterion("taobao_login_session not in", values, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionBetween(String value1, String value2) {
            this.addCriterion("taobao_login_session between", value1, value2, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotBetween(String value1, String value2) {
            this.addCriterion("taobao_login_session not between", value1, value2, "taobaoLoginSession");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }        public MemberStoreTaobaoSessionExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (MemberStoreTaobaoSessionExample.Criteria)this;
        }
    }
}
