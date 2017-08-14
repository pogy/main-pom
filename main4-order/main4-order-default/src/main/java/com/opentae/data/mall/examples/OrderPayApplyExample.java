package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderPayApplyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public OrderPayApplyExample() {
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

        public Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (Criteria)this;
        }

        public Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (Criteria)this;
        }

        public Criteria andMoneyEqualTo(Long value) {
            this.addCriterion("money =", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotEqualTo(Long value) {
            this.addCriterion("money <>", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThan(Long value) {
            this.addCriterion("money >", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("money >=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThan(Long value) {
            this.addCriterion("money <", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("money <=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLike(String value) {
            this.addCriterion("money like", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotLike(String value) {
            this.addCriterion("money not like", value, "money");
            return (Criteria)this;
        }        public Criteria andMoneyIn(List<Long> values) {
            this.addCriterion("money in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotIn(List<Long> values) {
            this.addCriterion("money not in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyBetween(Long value1, Long value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (Criteria)this;
        }

        public Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (Criteria)this;
        }        public Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria)this;
        }

        public Criteria andPayLinkIsNull() {
            this.addCriterion("pay_link is null");
            return (Criteria)this;
        }

        public Criteria andPayLinkIsNotNull() {
            this.addCriterion("pay_link is not null");
            return (Criteria)this;
        }

        public Criteria andPayLinkEqualTo(String value) {
            this.addCriterion("pay_link =", value, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkNotEqualTo(String value) {
            this.addCriterion("pay_link <>", value, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkGreaterThan(String value) {
            this.addCriterion("pay_link >", value, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkGreaterThanOrEqualTo(String value) {
            this.addCriterion("pay_link >=", value, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkLessThan(String value) {
            this.addCriterion("pay_link <", value, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkLessThanOrEqualTo(String value) {
            this.addCriterion("pay_link <=", value, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkLike(String value) {
            this.addCriterion("pay_link like", value, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkNotLike(String value) {
            this.addCriterion("pay_link not like", value, "payLink");
            return (Criteria)this;
        }        public Criteria andPayLinkIn(List<String> values) {
            this.addCriterion("pay_link in", values, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkNotIn(List<String> values) {
            this.addCriterion("pay_link not in", values, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkBetween(String value1, String value2) {
            this.addCriterion("pay_link between", value1, value2, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayLinkNotBetween(String value1, String value2) {
            this.addCriterion("pay_link not between", value1, value2, "payLink");
            return (Criteria)this;
        }

        public Criteria andPayForIsNull() {
            this.addCriterion("pay_for is null");
            return (Criteria)this;
        }

        public Criteria andPayForIsNotNull() {
            this.addCriterion("pay_for is not null");
            return (Criteria)this;
        }

        public Criteria andPayForEqualTo(Integer value) {
            this.addCriterion("pay_for =", value, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForNotEqualTo(Integer value) {
            this.addCriterion("pay_for <>", value, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForGreaterThan(Integer value) {
            this.addCriterion("pay_for >", value, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("pay_for >=", value, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForLessThan(Integer value) {
            this.addCriterion("pay_for <", value, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForLessThanOrEqualTo(Integer value) {
            this.addCriterion("pay_for <=", value, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForLike(String value) {
            this.addCriterion("pay_for like", value, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForNotLike(String value) {
            this.addCriterion("pay_for not like", value, "payFor");
            return (Criteria)this;
        }        public Criteria andPayForIn(List<Integer> values) {
            this.addCriterion("pay_for in", values, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForNotIn(List<Integer> values) {
            this.addCriterion("pay_for not in", values, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForBetween(Integer value1, Integer value2) {
            this.addCriterion("pay_for between", value1, value2, "payFor");
            return (Criteria)this;
        }

        public Criteria andPayForNotBetween(Integer value1, Integer value2) {
            this.addCriterion("pay_for not between", value1, value2, "payFor");
            return (Criteria)this;
        }

        public Criteria andApplyIdIsNull() {
            this.addCriterion("apply_id is null");
            return (Criteria)this;
        }

        public Criteria andApplyIdIsNotNull() {
            this.addCriterion("apply_id is not null");
            return (Criteria)this;
        }

        public Criteria andApplyIdEqualTo(Long value) {
            this.addCriterion("apply_id =", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotEqualTo(Long value) {
            this.addCriterion("apply_id <>", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdGreaterThan(Long value) {
            this.addCriterion("apply_id >", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("apply_id >=", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdLessThan(Long value) {
            this.addCriterion("apply_id <", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("apply_id <=", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdLike(String value) {
            this.addCriterion("apply_id like", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotLike(String value) {
            this.addCriterion("apply_id not like", value, "applyId");
            return (Criteria)this;
        }        public Criteria andApplyIdIn(List<Long> values) {
            this.addCriterion("apply_id in", values, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotIn(List<Long> values) {
            this.addCriterion("apply_id not in", values, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdBetween(Long value1, Long value2) {
            this.addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria)this;
        }

        public Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (Criteria)this;
        }

        public Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (Criteria)this;
        }

        public Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (Criteria)this;
        }        public Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (Criteria)this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (Criteria)this;
        }

        public Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (Criteria)this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (Criteria)this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (Criteria)this;
        }        public Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (Criteria)this;
        }
    }
}
