package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguMarketExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public ShiguMarketExample() {
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

        public Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (Criteria)this;
        }

        public Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (Criteria)this;
        }        public Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (Criteria)this;
        }

        public Criteria andAreaNameIsNull() {
            this.addCriterion("area_name is null");
            return (Criteria)this;
        }

        public Criteria andAreaNameIsNotNull() {
            this.addCriterion("area_name is not null");
            return (Criteria)this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            this.addCriterion("area_name =", value, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            this.addCriterion("area_name <>", value, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            this.addCriterion("area_name >", value, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("area_name >=", value, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameLessThan(String value) {
            this.addCriterion("area_name <", value, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            this.addCriterion("area_name <=", value, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameLike(String value) {
            this.addCriterion("area_name like", value, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameNotLike(String value) {
            this.addCriterion("area_name not like", value, "areaName");
            return (Criteria)this;
        }        public Criteria andAreaNameIn(List<String> values) {
            this.addCriterion("area_name in", values, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            this.addCriterion("area_name not in", values, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            this.addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria)this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            this.addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria)this;
        }

        public Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (Criteria)this;
        }

        public Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (Criteria)this;
        }        public Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (Criteria)this;
        }

        public Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (Criteria)this;
        }        public Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (Criteria)this;
        }

        public Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (Criteria)this;
        }        public Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (Criteria)this;
        }

        public Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (Criteria)this;
        }        public Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (Criteria)this;
        }

        public Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (Criteria)this;
        }        public Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (Criteria)this;
        }

        public Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (Criteria)this;
        }        public Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (Criteria)this;
        }

        public Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (Criteria)this;
        }        public Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (Criteria)this;
        }

        public Criteria andBuycityIdIsNull() {
            this.addCriterion("buycity_id is null");
            return (Criteria)this;
        }

        public Criteria andBuycityIdIsNotNull() {
            this.addCriterion("buycity_id is not null");
            return (Criteria)this;
        }

        public Criteria andBuycityIdEqualTo(Long value) {
            this.addCriterion("buycity_id =", value, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdNotEqualTo(Long value) {
            this.addCriterion("buycity_id <>", value, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdGreaterThan(Long value) {
            this.addCriterion("buycity_id >", value, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id >=", value, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdLessThan(Long value) {
            this.addCriterion("buycity_id <", value, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id <=", value, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdLike(String value) {
            this.addCriterion("buycity_id like", value, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdNotLike(String value) {
            this.addCriterion("buycity_id not like", value, "buycityId");
            return (Criteria)this;
        }        public Criteria andBuycityIdIn(List<Long> values) {
            this.addCriterion("buycity_id in", values, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdNotIn(List<Long> values) {
            this.addCriterion("buycity_id not in", values, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id between", value1, value2, "buycityId");
            return (Criteria)this;
        }

        public Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id not between", value1, value2, "buycityId");
            return (Criteria)this;
        }

        public Criteria andCanRegistIsNull() {
            this.addCriterion("can_regist is null");
            return (Criteria)this;
        }

        public Criteria andCanRegistIsNotNull() {
            this.addCriterion("can_regist is not null");
            return (Criteria)this;
        }

        public Criteria andCanRegistEqualTo(Integer value) {
            this.addCriterion("can_regist =", value, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistNotEqualTo(Integer value) {
            this.addCriterion("can_regist <>", value, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistGreaterThan(Integer value) {
            this.addCriterion("can_regist >", value, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("can_regist >=", value, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistLessThan(Integer value) {
            this.addCriterion("can_regist <", value, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistLessThanOrEqualTo(Integer value) {
            this.addCriterion("can_regist <=", value, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistLike(String value) {
            this.addCriterion("can_regist like", value, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistNotLike(String value) {
            this.addCriterion("can_regist not like", value, "canRegist");
            return (Criteria)this;
        }        public Criteria andCanRegistIn(List<Integer> values) {
            this.addCriterion("can_regist in", values, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistNotIn(List<Integer> values) {
            this.addCriterion("can_regist not in", values, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistBetween(Integer value1, Integer value2) {
            this.addCriterion("can_regist between", value1, value2, "canRegist");
            return (Criteria)this;
        }

        public Criteria andCanRegistNotBetween(Integer value1, Integer value2) {
            this.addCriterion("can_regist not between", value1, value2, "canRegist");
            return (Criteria)this;
        }

        public Criteria andIsParentIsNull() {
            this.addCriterion("is_parent is null");
            return (Criteria)this;
        }

        public Criteria andIsParentIsNotNull() {
            this.addCriterion("is_parent is not null");
            return (Criteria)this;
        }

        public Criteria andIsParentEqualTo(Integer value) {
            this.addCriterion("is_parent =", value, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentNotEqualTo(Integer value) {
            this.addCriterion("is_parent <>", value, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentGreaterThan(Integer value) {
            this.addCriterion("is_parent >", value, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent >=", value, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentLessThan(Integer value) {
            this.addCriterion("is_parent <", value, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent <=", value, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentLike(String value) {
            this.addCriterion("is_parent like", value, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentNotLike(String value) {
            this.addCriterion("is_parent not like", value, "isParent");
            return (Criteria)this;
        }        public Criteria andIsParentIn(List<Integer> values) {
            this.addCriterion("is_parent in", values, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentNotIn(List<Integer> values) {
            this.addCriterion("is_parent not in", values, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent between", value1, value2, "isParent");
            return (Criteria)this;
        }

        public Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent not between", value1, value2, "isParent");
            return (Criteria)this;
        }

        public Criteria andAreaIdIsNull() {
            this.addCriterion("area_id is null");
            return (Criteria)this;
        }

        public Criteria andAreaIdIsNotNull() {
            this.addCriterion("area_id is not null");
            return (Criteria)this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            this.addCriterion("area_id =", value, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            this.addCriterion("area_id <>", value, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            this.addCriterion("area_id >", value, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("area_id >=", value, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            this.addCriterion("area_id <", value, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("area_id <=", value, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdLike(String value) {
            this.addCriterion("area_id like", value, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdNotLike(String value) {
            this.addCriterion("area_id not like", value, "areaId");
            return (Criteria)this;
        }        public Criteria andAreaIdIn(List<Integer> values) {
            this.addCriterion("area_id in", values, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            this.addCriterion("area_id not in", values, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            this.addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria)this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria)this;
        }

        public Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (Criteria)this;
        }

        public Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (Criteria)this;
        }        public Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdIsNull() {
            this.addCriterion("parent_market_id is null");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdIsNotNull() {
            this.addCriterion("parent_market_id is not null");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdEqualTo(Long value) {
            this.addCriterion("parent_market_id =", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotEqualTo(Long value) {
            this.addCriterion("parent_market_id <>", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdGreaterThan(Long value) {
            this.addCriterion("parent_market_id >", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id >=", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdLessThan(Long value) {
            this.addCriterion("parent_market_id <", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id <=", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdLike(String value) {
            this.addCriterion("parent_market_id like", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotLike(String value) {
            this.addCriterion("parent_market_id not like", value, "parentMarketId");
            return (Criteria)this;
        }        public Criteria andParentMarketIdIn(List<Long> values) {
            this.addCriterion("parent_market_id in", values, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotIn(List<Long> values) {
            this.addCriterion("parent_market_id not in", values, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id between", value1, value2, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id not between", value1, value2, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andCityNameIsNull() {
            this.addCriterion("city_name is null");
            return (Criteria)this;
        }

        public Criteria andCityNameIsNotNull() {
            this.addCriterion("city_name is not null");
            return (Criteria)this;
        }

        public Criteria andCityNameEqualTo(String value) {
            this.addCriterion("city_name =", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            this.addCriterion("city_name <>", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            this.addCriterion("city_name >", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("city_name >=", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameLessThan(String value) {
            this.addCriterion("city_name <", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            this.addCriterion("city_name <=", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameLike(String value) {
            this.addCriterion("city_name like", value, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotLike(String value) {
            this.addCriterion("city_name not like", value, "cityName");
            return (Criteria)this;
        }        public Criteria andCityNameIn(List<String> values) {
            this.addCriterion("city_name in", values, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            this.addCriterion("city_name not in", values, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            this.addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria)this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            this.addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria)this;
        }

        public Criteria andFloorsIsNull() {
            this.addCriterion("floors is null");
            return (Criteria)this;
        }

        public Criteria andFloorsIsNotNull() {
            this.addCriterion("floors is not null");
            return (Criteria)this;
        }

        public Criteria andFloorsEqualTo(String value) {
            this.addCriterion("floors =", value, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsNotEqualTo(String value) {
            this.addCriterion("floors <>", value, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsGreaterThan(String value) {
            this.addCriterion("floors >", value, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsGreaterThanOrEqualTo(String value) {
            this.addCriterion("floors >=", value, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsLessThan(String value) {
            this.addCriterion("floors <", value, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsLessThanOrEqualTo(String value) {
            this.addCriterion("floors <=", value, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsLike(String value) {
            this.addCriterion("floors like", value, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsNotLike(String value) {
            this.addCriterion("floors not like", value, "floors");
            return (Criteria)this;
        }        public Criteria andFloorsIn(List<String> values) {
            this.addCriterion("floors in", values, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsNotIn(List<String> values) {
            this.addCriterion("floors not in", values, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsBetween(String value1, String value2) {
            this.addCriterion("floors between", value1, value2, "floors");
            return (Criteria)this;
        }

        public Criteria andFloorsNotBetween(String value1, String value2) {
            this.addCriterion("floors not between", value1, value2, "floors");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameIsNull() {
            this.addCriterion("parent_market_name is null");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameIsNotNull() {
            this.addCriterion("parent_market_name is not null");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameEqualTo(String value) {
            this.addCriterion("parent_market_name =", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotEqualTo(String value) {
            this.addCriterion("parent_market_name <>", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameGreaterThan(String value) {
            this.addCriterion("parent_market_name >", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name >=", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameLessThan(String value) {
            this.addCriterion("parent_market_name <", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name <=", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameLike(String value) {
            this.addCriterion("parent_market_name like", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotLike(String value) {
            this.addCriterion("parent_market_name not like", value, "parentMarketName");
            return (Criteria)this;
        }        public Criteria andParentMarketNameIn(List<String> values) {
            this.addCriterion("parent_market_name in", values, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotIn(List<String> values) {
            this.addCriterion("parent_market_name not in", values, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameBetween(String value1, String value2) {
            this.addCriterion("parent_market_name between", value1, value2, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("parent_market_name not between", value1, value2, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (Criteria)this;
        }

        public Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (Criteria)this;
        }        public Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (Criteria)this;
        }

        public Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (Criteria)this;
        }

        public Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (Criteria)this;
        }

        public Criteria andSortOrderEqualTo(Integer value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotEqualTo(Integer value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderGreaterThan(Integer value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderLessThan(Integer value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (Criteria)this;
        }        public Criteria andSortOrderIn(List<Integer> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotIn(List<Integer> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinIsNull() {
            this.addCriterion("market_pingyin is null");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinIsNotNull() {
            this.addCriterion("market_pingyin is not null");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinEqualTo(String value) {
            this.addCriterion("market_pingyin =", value, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinNotEqualTo(String value) {
            this.addCriterion("market_pingyin <>", value, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinGreaterThan(String value) {
            this.addCriterion("market_pingyin >", value, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_pingyin >=", value, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinLessThan(String value) {
            this.addCriterion("market_pingyin <", value, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinLessThanOrEqualTo(String value) {
            this.addCriterion("market_pingyin <=", value, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinLike(String value) {
            this.addCriterion("market_pingyin like", value, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinNotLike(String value) {
            this.addCriterion("market_pingyin not like", value, "marketPingyin");
            return (Criteria)this;
        }        public Criteria andMarketPingyinIn(List<String> values) {
            this.addCriterion("market_pingyin in", values, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinNotIn(List<String> values) {
            this.addCriterion("market_pingyin not in", values, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinBetween(String value1, String value2) {
            this.addCriterion("market_pingyin between", value1, value2, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andMarketPingyinNotBetween(String value1, String value2) {
            this.addCriterion("market_pingyin not between", value1, value2, "marketPingyin");
            return (Criteria)this;
        }

        public Criteria andNatureIsNull() {
            this.addCriterion("nature is null");
            return (Criteria)this;
        }

        public Criteria andNatureIsNotNull() {
            this.addCriterion("nature is not null");
            return (Criteria)this;
        }

        public Criteria andNatureEqualTo(String value) {
            this.addCriterion("nature =", value, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureNotEqualTo(String value) {
            this.addCriterion("nature <>", value, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureGreaterThan(String value) {
            this.addCriterion("nature >", value, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureGreaterThanOrEqualTo(String value) {
            this.addCriterion("nature >=", value, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureLessThan(String value) {
            this.addCriterion("nature <", value, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureLessThanOrEqualTo(String value) {
            this.addCriterion("nature <=", value, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureLike(String value) {
            this.addCriterion("nature like", value, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureNotLike(String value) {
            this.addCriterion("nature not like", value, "nature");
            return (Criteria)this;
        }        public Criteria andNatureIn(List<String> values) {
            this.addCriterion("nature in", values, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureNotIn(List<String> values) {
            this.addCriterion("nature not in", values, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureBetween(String value1, String value2) {
            this.addCriterion("nature between", value1, value2, "nature");
            return (Criteria)this;
        }

        public Criteria andNatureNotBetween(String value1, String value2) {
            this.addCriterion("nature not between", value1, value2, "nature");
            return (Criteria)this;
        }

        public Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (Criteria)this;
        }

        public Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (Criteria)this;
        }

        public Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (Criteria)this;
        }        public Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketNameIsNull() {
            this.addCriterion("market_name is null");
            return (Criteria)this;
        }

        public Criteria andMarketNameIsNotNull() {
            this.addCriterion("market_name is not null");
            return (Criteria)this;
        }

        public Criteria andMarketNameEqualTo(String value) {
            this.addCriterion("market_name =", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotEqualTo(String value) {
            this.addCriterion("market_name <>", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameGreaterThan(String value) {
            this.addCriterion("market_name >", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_name >=", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameLessThan(String value) {
            this.addCriterion("market_name <", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("market_name <=", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameLike(String value) {
            this.addCriterion("market_name like", value, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotLike(String value) {
            this.addCriterion("market_name not like", value, "marketName");
            return (Criteria)this;
        }        public Criteria andMarketNameIn(List<String> values) {
            this.addCriterion("market_name in", values, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotIn(List<String> values) {
            this.addCriterion("market_name not in", values, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameBetween(String value1, String value2) {
            this.addCriterion("market_name between", value1, value2, "marketName");
            return (Criteria)this;
        }

        public Criteria andMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("market_name not between", value1, value2, "marketName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameIsNull() {
            this.addCriterion("province_name is null");
            return (Criteria)this;
        }

        public Criteria andProvinceNameIsNotNull() {
            this.addCriterion("province_name is not null");
            return (Criteria)this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            this.addCriterion("province_name =", value, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            this.addCriterion("province_name <>", value, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            this.addCriterion("province_name >", value, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("province_name >=", value, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            this.addCriterion("province_name <", value, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            this.addCriterion("province_name <=", value, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameLike(String value) {
            this.addCriterion("province_name like", value, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            this.addCriterion("province_name not like", value, "provinceName");
            return (Criteria)this;
        }        public Criteria andProvinceNameIn(List<String> values) {
            this.addCriterion("province_name in", values, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            this.addCriterion("province_name not in", values, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            this.addCriterion("province_name between", value1, value2, "provinceName");
            return (Criteria)this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            this.addCriterion("province_name not between", value1, value2, "provinceName");
            return (Criteria)this;
        }

        public Criteria andMarketAddrIsNull() {
            this.addCriterion("market_addr is null");
            return (Criteria)this;
        }

        public Criteria andMarketAddrIsNotNull() {
            this.addCriterion("market_addr is not null");
            return (Criteria)this;
        }

        public Criteria andMarketAddrEqualTo(String value) {
            this.addCriterion("market_addr =", value, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrNotEqualTo(String value) {
            this.addCriterion("market_addr <>", value, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrGreaterThan(String value) {
            this.addCriterion("market_addr >", value, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_addr >=", value, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrLessThan(String value) {
            this.addCriterion("market_addr <", value, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrLessThanOrEqualTo(String value) {
            this.addCriterion("market_addr <=", value, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrLike(String value) {
            this.addCriterion("market_addr like", value, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrNotLike(String value) {
            this.addCriterion("market_addr not like", value, "marketAddr");
            return (Criteria)this;
        }        public Criteria andMarketAddrIn(List<String> values) {
            this.addCriterion("market_addr in", values, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrNotIn(List<String> values) {
            this.addCriterion("market_addr not in", values, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrBetween(String value1, String value2) {
            this.addCriterion("market_addr between", value1, value2, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andMarketAddrNotBetween(String value1, String value2) {
            this.addCriterion("market_addr not between", value1, value2, "marketAddr");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalIsNull() {
            this.addCriterion("store_in_total is null");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalIsNotNull() {
            this.addCriterion("store_in_total is not null");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalEqualTo(Integer value) {
            this.addCriterion("store_in_total =", value, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalNotEqualTo(Integer value) {
            this.addCriterion("store_in_total <>", value, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalGreaterThan(Integer value) {
            this.addCriterion("store_in_total >", value, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("store_in_total >=", value, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalLessThan(Integer value) {
            this.addCriterion("store_in_total <", value, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalLessThanOrEqualTo(Integer value) {
            this.addCriterion("store_in_total <=", value, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalLike(String value) {
            this.addCriterion("store_in_total like", value, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalNotLike(String value) {
            this.addCriterion("store_in_total not like", value, "storeInTotal");
            return (Criteria)this;
        }        public Criteria andStoreInTotalIn(List<Integer> values) {
            this.addCriterion("store_in_total in", values, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalNotIn(List<Integer> values) {
            this.addCriterion("store_in_total not in", values, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalBetween(Integer value1, Integer value2) {
            this.addCriterion("store_in_total between", value1, value2, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andStoreInTotalNotBetween(Integer value1, Integer value2) {
            this.addCriterion("store_in_total not between", value1, value2, "storeInTotal");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (Criteria)this;
        }        public Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andProvinceIdIsNull() {
            this.addCriterion("province_id is null");
            return (Criteria)this;
        }

        public Criteria andProvinceIdIsNotNull() {
            this.addCriterion("province_id is not null");
            return (Criteria)this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            this.addCriterion("province_id =", value, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            this.addCriterion("province_id <>", value, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            this.addCriterion("province_id >", value, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("province_id >=", value, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            this.addCriterion("province_id <", value, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("province_id <=", value, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdLike(String value) {
            this.addCriterion("province_id like", value, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdNotLike(String value) {
            this.addCriterion("province_id not like", value, "provinceId");
            return (Criteria)this;
        }        public Criteria andProvinceIdIn(List<Integer> values) {
            this.addCriterion("province_id in", values, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            this.addCriterion("province_id not in", values, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            this.addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria)this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (Criteria)this;
        }        public Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (Criteria)this;
        }        public Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (Criteria)this;
        }        public Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (Criteria)this;
        }        public Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (Criteria)this;
        }        public Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (Criteria)this;
        }        public Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (Criteria)this;
        }        public Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (Criteria)this;
        }        public Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameIsNull() {
            this.addCriterion("market_full_name is null");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameIsNotNull() {
            this.addCriterion("market_full_name is not null");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameEqualTo(String value) {
            this.addCriterion("market_full_name =", value, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameNotEqualTo(String value) {
            this.addCriterion("market_full_name <>", value, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameGreaterThan(String value) {
            this.addCriterion("market_full_name >", value, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_full_name >=", value, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameLessThan(String value) {
            this.addCriterion("market_full_name <", value, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameLessThanOrEqualTo(String value) {
            this.addCriterion("market_full_name <=", value, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameLike(String value) {
            this.addCriterion("market_full_name like", value, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameNotLike(String value) {
            this.addCriterion("market_full_name not like", value, "marketFullName");
            return (Criteria)this;
        }        public Criteria andMarketFullNameIn(List<String> values) {
            this.addCriterion("market_full_name in", values, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameNotIn(List<String> values) {
            this.addCriterion("market_full_name not in", values, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameBetween(String value1, String value2) {
            this.addCriterion("market_full_name between", value1, value2, "marketFullName");
            return (Criteria)this;
        }

        public Criteria andMarketFullNameNotBetween(String value1, String value2) {
            this.addCriterion("market_full_name not between", value1, value2, "marketFullName");
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

        public Criteria andCityIdIsNull() {
            this.addCriterion("city_id is null");
            return (Criteria)this;
        }

        public Criteria andCityIdIsNotNull() {
            this.addCriterion("city_id is not null");
            return (Criteria)this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            this.addCriterion("city_id =", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            this.addCriterion("city_id <>", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            this.addCriterion("city_id >", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("city_id >=", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            this.addCriterion("city_id <", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("city_id <=", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLike(String value) {
            this.addCriterion("city_id like", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotLike(String value) {
            this.addCriterion("city_id not like", value, "cityId");
            return (Criteria)this;
        }        public Criteria andCityIdIn(List<Integer> values) {
            this.addCriterion("city_id in", values, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            this.addCriterion("city_id not in", values, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            this.addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (Criteria)this;
        }        public Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria)this;
        }
    }
}
