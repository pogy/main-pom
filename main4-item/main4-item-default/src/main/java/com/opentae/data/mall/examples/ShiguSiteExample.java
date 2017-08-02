package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguSiteExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguSiteExample.Criteria> oredCriteria = new ArrayList();

    public ShiguSiteExample() {
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

    public List<ShiguSiteExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguSiteExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguSiteExample.Criteria or() {
        ShiguSiteExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguSiteExample.Criteria createCriteria() {
        ShiguSiteExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguSiteExample.Criteria createCriteriaInternal() {
        ShiguSiteExample.Criteria criteria = new ShiguSiteExample.Criteria();
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

    public static class Criteria extends ShiguSiteExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguSiteExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguSiteExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguSiteExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguSiteExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguSiteExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguSiteExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguSiteExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdIsNull() {
            this.addCriterion("buycity_id is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdIsNotNull() {
            this.addCriterion("buycity_id is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdEqualTo(Long value) {
            this.addCriterion("buycity_id =", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdNotEqualTo(Long value) {
            this.addCriterion("buycity_id <>", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdGreaterThan(Long value) {
            this.addCriterion("buycity_id >", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id >=", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdLessThan(Long value) {
            this.addCriterion("buycity_id <", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id <=", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdLike(String value) {
            this.addCriterion("buycity_id like", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdNotLike(String value) {
            this.addCriterion("buycity_id not like", value, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andBuycityIdIn(List<Long> values) {
            this.addCriterion("buycity_id in", values, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdNotIn(List<Long> values) {
            this.addCriterion("buycity_id not in", values, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id between", value1, value2, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id not between", value1, value2, "buycityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteIsNull() {
            this.addCriterion("city_site is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteIsNotNull() {
            this.addCriterion("city_site is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteEqualTo(String value) {
            this.addCriterion("city_site =", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteNotEqualTo(String value) {
            this.addCriterion("city_site <>", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteGreaterThan(String value) {
            this.addCriterion("city_site >", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("city_site >=", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteLessThan(String value) {
            this.addCriterion("city_site <", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteLessThanOrEqualTo(String value) {
            this.addCriterion("city_site <=", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteLike(String value) {
            this.addCriterion("city_site like", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteNotLike(String value) {
            this.addCriterion("city_site not like", value, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andCitySiteIn(List<String> values) {
            this.addCriterion("city_site in", values, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteNotIn(List<String> values) {
            this.addCriterion("city_site not in", values, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteBetween(String value1, String value2) {
            this.addCriterion("city_site between", value1, value2, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCitySiteNotBetween(String value1, String value2) {
            this.addCriterion("city_site not between", value1, value2, "citySite");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameIsNull() {
            this.addCriterion("city_name is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameIsNotNull() {
            this.addCriterion("city_name is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameEqualTo(String value) {
            this.addCriterion("city_name =", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameNotEqualTo(String value) {
            this.addCriterion("city_name <>", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameGreaterThan(String value) {
            this.addCriterion("city_name >", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("city_name >=", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameLessThan(String value) {
            this.addCriterion("city_name <", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            this.addCriterion("city_name <=", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameLike(String value) {
            this.addCriterion("city_name like", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameNotLike(String value) {
            this.addCriterion("city_name not like", value, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andCityNameIn(List<String> values) {
            this.addCriterion("city_name in", values, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameNotIn(List<String> values) {
            this.addCriterion("city_name not in", values, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameBetween(String value1, String value2) {
            this.addCriterion("city_name between", value1, value2, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityNameNotBetween(String value1, String value2) {
            this.addCriterion("city_name not between", value1, value2, "cityName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderEqualTo(Integer value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderNotEqualTo(Integer value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderGreaterThan(Integer value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderLessThan(Integer value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andSortOrderIn(List<Integer> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderNotIn(List<Integer> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameIsNull() {
            this.addCriterion("province_name is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameIsNotNull() {
            this.addCriterion("province_name is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameEqualTo(String value) {
            this.addCriterion("province_name =", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameNotEqualTo(String value) {
            this.addCriterion("province_name <>", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameGreaterThan(String value) {
            this.addCriterion("province_name >", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("province_name >=", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameLessThan(String value) {
            this.addCriterion("province_name <", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameLessThanOrEqualTo(String value) {
            this.addCriterion("province_name <=", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameLike(String value) {
            this.addCriterion("province_name like", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameNotLike(String value) {
            this.addCriterion("province_name not like", value, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andProvinceNameIn(List<String> values) {
            this.addCriterion("province_name in", values, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameNotIn(List<String> values) {
            this.addCriterion("province_name not in", values, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameBetween(String value1, String value2) {
            this.addCriterion("province_name between", value1, value2, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceNameNotBetween(String value1, String value2) {
            this.addCriterion("province_name not between", value1, value2, "provinceName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameIsNull() {
            this.addCriterion("site_name is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameIsNotNull() {
            this.addCriterion("site_name is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameEqualTo(String value) {
            this.addCriterion("site_name =", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameNotEqualTo(String value) {
            this.addCriterion("site_name <>", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameGreaterThan(String value) {
            this.addCriterion("site_name >", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("site_name >=", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameLessThan(String value) {
            this.addCriterion("site_name <", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameLessThanOrEqualTo(String value) {
            this.addCriterion("site_name <=", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameLike(String value) {
            this.addCriterion("site_name like", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameNotLike(String value) {
            this.addCriterion("site_name not like", value, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andSiteNameIn(List<String> values) {
            this.addCriterion("site_name in", values, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameNotIn(List<String> values) {
            this.addCriterion("site_name not in", values, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameBetween(String value1, String value2) {
            this.addCriterion("site_name between", value1, value2, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteNameNotBetween(String value1, String value2) {
            this.addCriterion("site_name not between", value1, value2, "siteName");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpIsNull() {
            this.addCriterion("site_ip is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpIsNotNull() {
            this.addCriterion("site_ip is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpEqualTo(String value) {
            this.addCriterion("site_ip =", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpNotEqualTo(String value) {
            this.addCriterion("site_ip <>", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpGreaterThan(String value) {
            this.addCriterion("site_ip >", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("site_ip >=", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpLessThan(String value) {
            this.addCriterion("site_ip <", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpLessThanOrEqualTo(String value) {
            this.addCriterion("site_ip <=", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpLike(String value) {
            this.addCriterion("site_ip like", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpNotLike(String value) {
            this.addCriterion("site_ip not like", value, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andSiteIpIn(List<String> values) {
            this.addCriterion("site_ip in", values, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpNotIn(List<String> values) {
            this.addCriterion("site_ip not in", values, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpBetween(String value1, String value2) {
            this.addCriterion("site_ip between", value1, value2, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andSiteIpNotBetween(String value1, String value2) {
            this.addCriterion("site_ip not between", value1, value2, "siteIp");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdIsNull() {
            this.addCriterion("province_id is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdIsNotNull() {
            this.addCriterion("province_id is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdEqualTo(Integer value) {
            this.addCriterion("province_id =", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdNotEqualTo(Integer value) {
            this.addCriterion("province_id <>", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdGreaterThan(Integer value) {
            this.addCriterion("province_id >", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("province_id >=", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdLessThan(Integer value) {
            this.addCriterion("province_id <", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("province_id <=", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdLike(String value) {
            this.addCriterion("province_id like", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdNotLike(String value) {
            this.addCriterion("province_id not like", value, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andProvinceIdIn(List<Integer> values) {
            this.addCriterion("province_id in", values, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdNotIn(List<Integer> values) {
            this.addCriterion("province_id not in", values, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            this.addCriterion("province_id between", value1, value2, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("province_id not between", value1, value2, "provinceId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainIsNull() {
            this.addCriterion("domain is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainIsNotNull() {
            this.addCriterion("domain is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainEqualTo(String value) {
            this.addCriterion("domain =", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainNotEqualTo(String value) {
            this.addCriterion("domain <>", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainGreaterThan(String value) {
            this.addCriterion("domain >", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainGreaterThanOrEqualTo(String value) {
            this.addCriterion("domain >=", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainLessThan(String value) {
            this.addCriterion("domain <", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainLessThanOrEqualTo(String value) {
            this.addCriterion("domain <=", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainLike(String value) {
            this.addCriterion("domain like", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainNotLike(String value) {
            this.addCriterion("domain not like", value, "domain");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andDomainIn(List<String> values) {
            this.addCriterion("domain in", values, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainNotIn(List<String> values) {
            this.addCriterion("domain not in", values, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainBetween(String value1, String value2) {
            this.addCriterion("domain between", value1, value2, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andDomainNotBetween(String value1, String value2) {
            this.addCriterion("domain not between", value1, value2, "domain");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdIsNull() {
            this.addCriterion("city_id is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("city_id is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdEqualTo(Integer value) {
            this.addCriterion("city_id =", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdNotEqualTo(Integer value) {
            this.addCriterion("city_id <>", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdGreaterThan(Integer value) {
            this.addCriterion("city_id >", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("city_id >=", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdLessThan(Integer value) {
            this.addCriterion("city_id <", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("city_id <=", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdLike(String value) {
            this.addCriterion("city_id like", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("city_id not like", value, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andCityIdIn(List<Integer> values) {
            this.addCriterion("city_id in", values, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdNotIn(List<Integer> values) {
            this.addCriterion("city_id not in", values, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdBetween(Integer value1, Integer value2) {
            this.addCriterion("city_id between", value1, value2, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("city_id not between", value1, value2, "cityId");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }        public ShiguSiteExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }

        public ShiguSiteExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguSiteExample.Criteria)this;
        }
    }
}
