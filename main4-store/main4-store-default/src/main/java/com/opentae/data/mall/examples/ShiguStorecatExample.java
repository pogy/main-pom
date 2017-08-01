package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguStorecatExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguStorecatExample.Criteria> oredCriteria = new ArrayList();

    public ShiguStorecatExample() {
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

    public List<ShiguStorecatExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguStorecatExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguStorecatExample.Criteria or() {
        ShiguStorecatExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguStorecatExample.Criteria createCriteria() {
        ShiguStorecatExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguStorecatExample.Criteria createCriteriaInternal() {
        ShiguStorecatExample.Criteria criteria = new ShiguStorecatExample.Criteria();
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

    public static class Criteria extends ShiguStorecatExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguStorecatExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguStorecatExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguStorecatExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguStorecatExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguStorecatExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguStorecatExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguStorecatExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentIsNull() {
            this.addCriterion("is_parent is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentIsNotNull() {
            this.addCriterion("is_parent is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentEqualTo(Integer value) {
            this.addCriterion("is_parent =", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentNotEqualTo(Integer value) {
            this.addCriterion("is_parent <>", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentGreaterThan(Integer value) {
            this.addCriterion("is_parent >", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent >=", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentLessThan(Integer value) {
            this.addCriterion("is_parent <", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent <=", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentLike(String value) {
            this.addCriterion("is_parent like", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentNotLike(String value) {
            this.addCriterion("is_parent not like", value, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andIsParentIn(List<Integer> values) {
            this.addCriterion("is_parent in", values, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentNotIn(List<Integer> values) {
            this.addCriterion("is_parent not in", values, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent between", value1, value2, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent not between", value1, value2, "isParent");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeEqualTo(String value) {
            this.addCriterion("type =", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeNotEqualTo(String value) {
            this.addCriterion("type <>", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeGreaterThan(String value) {
            this.addCriterion("type >", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("type >=", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeLessThan(String value) {
            this.addCriterion("type <", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeLessThanOrEqualTo(String value) {
            this.addCriterion("type <=", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andTypeIn(List<String> values) {
            this.addCriterion("type in", values, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeNotIn(List<String> values) {
            this.addCriterion("type not in", values, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeBetween(String value1, String value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTypeNotBetween(String value1, String value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameIsNull() {
            this.addCriterion("sc_name is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameIsNotNull() {
            this.addCriterion("sc_name is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameEqualTo(String value) {
            this.addCriterion("sc_name =", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameNotEqualTo(String value) {
            this.addCriterion("sc_name <>", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameGreaterThan(String value) {
            this.addCriterion("sc_name >", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("sc_name >=", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameLessThan(String value) {
            this.addCriterion("sc_name <", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameLessThanOrEqualTo(String value) {
            this.addCriterion("sc_name <=", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameLike(String value) {
            this.addCriterion("sc_name like", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameNotLike(String value) {
            this.addCriterion("sc_name not like", value, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andScNameIn(List<String> values) {
            this.addCriterion("sc_name in", values, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameNotIn(List<String> values) {
            this.addCriterion("sc_name not in", values, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameBetween(String value1, String value2) {
            this.addCriterion("sc_name between", value1, value2, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScNameNotBetween(String value1, String value2) {
            this.addCriterion("sc_name not between", value1, value2, "scName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedIsNull() {
            this.addCriterion("modified is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedIsNotNull() {
            this.addCriterion("modified is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedEqualTo(Date value) {
            this.addCriterion("modified =", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedNotEqualTo(Date value) {
            this.addCriterion("modified <>", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedGreaterThan(Date value) {
            this.addCriterion("modified >", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modified >=", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedLessThan(Date value) {
            this.addCriterion("modified <", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedLessThanOrEqualTo(Date value) {
            this.addCriterion("modified <=", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedLike(String value) {
            this.addCriterion("modified like", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedNotLike(String value) {
            this.addCriterion("modified not like", value, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andModifiedIn(List<Date> values) {
            this.addCriterion("modified in", values, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedNotIn(List<Date> values) {
            this.addCriterion("modified not in", values, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedBetween(Date value1, Date value2) {
            this.addCriterion("modified between", value1, value2, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andModifiedNotBetween(Date value1, Date value2) {
            this.addCriterion("modified not between", value1, value2, "modified");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderEqualTo(Integer value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderNotEqualTo(Integer value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderGreaterThan(Integer value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderLessThan(Integer value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andSortOrderIn(List<Integer> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderNotIn(List<Integer> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidIsNull() {
            this.addCriterion("scid is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidIsNotNull() {
            this.addCriterion("scid is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidEqualTo(Long value) {
            this.addCriterion("scid =", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidNotEqualTo(Long value) {
            this.addCriterion("scid <>", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidGreaterThan(Long value) {
            this.addCriterion("scid >", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("scid >=", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidLessThan(Long value) {
            this.addCriterion("scid <", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidLessThanOrEqualTo(Long value) {
            this.addCriterion("scid <=", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidLike(String value) {
            this.addCriterion("scid like", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidNotLike(String value) {
            this.addCriterion("scid not like", value, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andScidIn(List<Long> values) {
            this.addCriterion("scid in", values, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidNotIn(List<Long> values) {
            this.addCriterion("scid not in", values, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidBetween(Long value1, Long value2) {
            this.addCriterion("scid between", value1, value2, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andScidNotBetween(Long value1, Long value2) {
            this.addCriterion("scid not between", value1, value2, "scid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidIsNull() {
            this.addCriterion("parent_scid is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidIsNotNull() {
            this.addCriterion("parent_scid is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidEqualTo(Long value) {
            this.addCriterion("parent_scid =", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidNotEqualTo(Long value) {
            this.addCriterion("parent_scid <>", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidGreaterThan(Long value) {
            this.addCriterion("parent_scid >", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_scid >=", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidLessThan(Long value) {
            this.addCriterion("parent_scid <", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_scid <=", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidLike(String value) {
            this.addCriterion("parent_scid like", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidNotLike(String value) {
            this.addCriterion("parent_scid not like", value, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andParentScidIn(List<Long> values) {
            this.addCriterion("parent_scid in", values, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidNotIn(List<Long> values) {
            this.addCriterion("parent_scid not in", values, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidBetween(Long value1, Long value2) {
            this.addCriterion("parent_scid between", value1, value2, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScidNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_scid not between", value1, value2, "parentScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedIsNull() {
            this.addCriterion("created is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedIsNotNull() {
            this.addCriterion("created is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedEqualTo(Date value) {
            this.addCriterion("created =", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedNotEqualTo(Date value) {
            this.addCriterion("created <>", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedGreaterThan(Date value) {
            this.addCriterion("created >", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("created >=", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedLessThan(Date value) {
            this.addCriterion("created <", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            this.addCriterion("created <=", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedLike(String value) {
            this.addCriterion("created like", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedNotLike(String value) {
            this.addCriterion("created not like", value, "created");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andCreatedIn(List<Date> values) {
            this.addCriterion("created in", values, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedNotIn(List<Date> values) {
            this.addCriterion("created not in", values, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedBetween(Date value1, Date value2) {
            this.addCriterion("created between", value1, value2, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            this.addCriterion("created not between", value1, value2, "created");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameIsNull() {
            this.addCriterion("parent_sc_name is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameIsNotNull() {
            this.addCriterion("parent_sc_name is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameEqualTo(String value) {
            this.addCriterion("parent_sc_name =", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameNotEqualTo(String value) {
            this.addCriterion("parent_sc_name <>", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameGreaterThan(String value) {
            this.addCriterion("parent_sc_name >", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_sc_name >=", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameLessThan(String value) {
            this.addCriterion("parent_sc_name <", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameLessThanOrEqualTo(String value) {
            this.addCriterion("parent_sc_name <=", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameLike(String value) {
            this.addCriterion("parent_sc_name like", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameNotLike(String value) {
            this.addCriterion("parent_sc_name not like", value, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andParentScNameIn(List<String> values) {
            this.addCriterion("parent_sc_name in", values, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameNotIn(List<String> values) {
            this.addCriterion("parent_sc_name not in", values, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameBetween(String value1, String value2) {
            this.addCriterion("parent_sc_name between", value1, value2, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentScNameNotBetween(String value1, String value2) {
            this.addCriterion("parent_sc_name not between", value1, value2, "parentScName");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidIsNull() {
            this.addCriterion("taobao_scid is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidIsNotNull() {
            this.addCriterion("taobao_scid is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidEqualTo(String value) {
            this.addCriterion("taobao_scid =", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotEqualTo(String value) {
            this.addCriterion("taobao_scid <>", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidGreaterThan(String value) {
            this.addCriterion("taobao_scid >", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_scid >=", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidLessThan(String value) {
            this.addCriterion("taobao_scid <", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_scid <=", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidLike(String value) {
            this.addCriterion("taobao_scid like", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotLike(String value) {
            this.addCriterion("taobao_scid not like", value, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andTaobaoScidIn(List<String> values) {
            this.addCriterion("taobao_scid in", values, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotIn(List<String> values) {
            this.addCriterion("taobao_scid not in", values, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidBetween(String value1, String value2) {
            this.addCriterion("taobao_scid between", value1, value2, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotBetween(String value1, String value2) {
            this.addCriterion("taobao_scid not between", value1, value2, "taobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlIsNull() {
            this.addCriterion("pic_url is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlIsNotNull() {
            this.addCriterion("pic_url is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("pic_url =", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("pic_url <>", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("pic_url >", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("pic_url >=", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlLessThan(String value) {
            this.addCriterion("pic_url <", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("pic_url <=", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlLike(String value) {
            this.addCriterion("pic_url like", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlNotLike(String value) {
            this.addCriterion("pic_url not like", value, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("pic_url in", values, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("pic_url not in", values, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("pic_url between", value1, value2, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("pic_url not between", value1, value2, "picUrl");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidIsNull() {
            this.addCriterion("parent_taobao_scid is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidIsNotNull() {
            this.addCriterion("parent_taobao_scid is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidEqualTo(String value) {
            this.addCriterion("parent_taobao_scid =", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotEqualTo(String value) {
            this.addCriterion("parent_taobao_scid <>", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidGreaterThan(String value) {
            this.addCriterion("parent_taobao_scid >", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_taobao_scid >=", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidLessThan(String value) {
            this.addCriterion("parent_taobao_scid <", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidLessThanOrEqualTo(String value) {
            this.addCriterion("parent_taobao_scid <=", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidLike(String value) {
            this.addCriterion("parent_taobao_scid like", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotLike(String value) {
            this.addCriterion("parent_taobao_scid not like", value, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andParentTaobaoScidIn(List<String> values) {
            this.addCriterion("parent_taobao_scid in", values, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotIn(List<String> values) {
            this.addCriterion("parent_taobao_scid not in", values, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidBetween(String value1, String value2) {
            this.addCriterion("parent_taobao_scid between", value1, value2, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotBetween(String value1, String value2) {
            this.addCriterion("parent_taobao_scid not between", value1, value2, "parentTaobaoScid");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }        public ShiguStorecatExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }

        public ShiguStorecatExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguStorecatExample.Criteria)this;
        }
    }
}
