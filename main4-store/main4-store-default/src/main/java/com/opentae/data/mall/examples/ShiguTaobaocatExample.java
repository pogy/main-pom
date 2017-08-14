package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguTaobaocatExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguTaobaocatExample.Criteria> oredCriteria = new ArrayList();

    public ShiguTaobaocatExample() {
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

    public List<ShiguTaobaocatExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguTaobaocatExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguTaobaocatExample.Criteria or() {
        ShiguTaobaocatExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguTaobaocatExample.Criteria createCriteria() {
        ShiguTaobaocatExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguTaobaocatExample.Criteria createCriteriaInternal() {
        ShiguTaobaocatExample.Criteria criteria = new ShiguTaobaocatExample.Criteria();
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

    public static class Criteria extends ShiguTaobaocatExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguTaobaocatExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguTaobaocatExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguTaobaocatExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguTaobaocatExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguTaobaocatExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguTaobaocatExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguTaobaocatExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidIsNull() {
            this.addCriterion("parent_cid is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidIsNotNull() {
            this.addCriterion("parent_cid is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidEqualTo(Long value) {
            this.addCriterion("parent_cid =", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotEqualTo(Long value) {
            this.addCriterion("parent_cid <>", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidGreaterThan(Long value) {
            this.addCriterion("parent_cid >", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_cid >=", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidLessThan(Long value) {
            this.addCriterion("parent_cid <", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_cid <=", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidLike(String value) {
            this.addCriterion("parent_cid like", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotLike(String value) {
            this.addCriterion("parent_cid not like", value, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andParentCidIn(List<Long> values) {
            this.addCriterion("parent_cid in", values, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotIn(List<Long> values) {
            this.addCriterion("parent_cid not in", values, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidBetween(Long value1, Long value2) {
            this.addCriterion("parent_cid between", value1, value2, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_cid not between", value1, value2, "parentCid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameIsNull() {
            this.addCriterion("cname is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameIsNotNull() {
            this.addCriterion("cname is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameEqualTo(String value) {
            this.addCriterion("cname =", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameNotEqualTo(String value) {
            this.addCriterion("cname <>", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameGreaterThan(String value) {
            this.addCriterion("cname >", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            this.addCriterion("cname >=", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameLessThan(String value) {
            this.addCriterion("cname <", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameLessThanOrEqualTo(String value) {
            this.addCriterion("cname <=", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameLike(String value) {
            this.addCriterion("cname like", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameNotLike(String value) {
            this.addCriterion("cname not like", value, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andCnameIn(List<String> values) {
            this.addCriterion("cname in", values, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameNotIn(List<String> values) {
            this.addCriterion("cname not in", values, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameBetween(String value1, String value2) {
            this.addCriterion("cname between", value1, value2, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCnameNotBetween(String value1, String value2) {
            this.addCriterion("cname not between", value1, value2, "cname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentIsNull() {
            this.addCriterion("is_parent is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentIsNotNull() {
            this.addCriterion("is_parent is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentEqualTo(Integer value) {
            this.addCriterion("is_parent =", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotEqualTo(Integer value) {
            this.addCriterion("is_parent <>", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentGreaterThan(Integer value) {
            this.addCriterion("is_parent >", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent >=", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentLessThan(Integer value) {
            this.addCriterion("is_parent <", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent <=", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentLike(String value) {
            this.addCriterion("is_parent like", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotLike(String value) {
            this.addCriterion("is_parent not like", value, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andIsParentIn(List<Integer> values) {
            this.addCriterion("is_parent in", values, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotIn(List<Integer> values) {
            this.addCriterion("is_parent not in", values, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent between", value1, value2, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent not between", value1, value2, "isParent");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameIsNull() {
            this.addCriterion("parent_cname is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameIsNotNull() {
            this.addCriterion("parent_cname is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameEqualTo(String value) {
            this.addCriterion("parent_cname =", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotEqualTo(String value) {
            this.addCriterion("parent_cname <>", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameGreaterThan(String value) {
            this.addCriterion("parent_cname >", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_cname >=", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLessThan(String value) {
            this.addCriterion("parent_cname <", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLessThanOrEqualTo(String value) {
            this.addCriterion("parent_cname <=", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLike(String value) {
            this.addCriterion("parent_cname like", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotLike(String value) {
            this.addCriterion("parent_cname not like", value, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andParentCnameIn(List<String> values) {
            this.addCriterion("parent_cname in", values, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotIn(List<String> values) {
            this.addCriterion("parent_cname not in", values, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameBetween(String value1, String value2) {
            this.addCriterion("parent_cname between", value1, value2, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotBetween(String value1, String value2) {
            this.addCriterion("parent_cname not between", value1, value2, "parentCname");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }        public ShiguTaobaocatExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguTaobaocatExample.Criteria)this;
        }
    }
}
