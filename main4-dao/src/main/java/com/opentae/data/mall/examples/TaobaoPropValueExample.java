package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class TaobaoPropValueExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<TaobaoPropValueExample.Criteria> oredCriteria = new ArrayList();

    public TaobaoPropValueExample() {
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

    public List<TaobaoPropValueExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(TaobaoPropValueExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public TaobaoPropValueExample.Criteria or() {
        TaobaoPropValueExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public TaobaoPropValueExample.Criteria createCriteria() {
        TaobaoPropValueExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected TaobaoPropValueExample.Criteria createCriteriaInternal() {
        TaobaoPropValueExample.Criteria criteria = new TaobaoPropValueExample.Criteria();
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

    public static class Criteria extends TaobaoPropValueExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<TaobaoPropValueExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<TaobaoPropValueExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<TaobaoPropValueExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new TaobaoPropValueExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new TaobaoPropValueExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new TaobaoPropValueExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public TaobaoPropValueExample.Criteria andTbVidIsNull() {
            this.addCriterion("tb_vid is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidIsNotNull() {
            this.addCriterion("tb_vid is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidEqualTo(Long value) {
            this.addCriterion("tb_vid =", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidNotEqualTo(Long value) {
            this.addCriterion("tb_vid <>", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidGreaterThan(Long value) {
            this.addCriterion("tb_vid >", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("tb_vid >=", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidLessThan(Long value) {
            this.addCriterion("tb_vid <", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidLessThanOrEqualTo(Long value) {
            this.addCriterion("tb_vid <=", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidLike(String value) {
            this.addCriterion("tb_vid like", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidNotLike(String value) {
            this.addCriterion("tb_vid not like", value, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andTbVidIn(List<Long> values) {
            this.addCriterion("tb_vid in", values, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidNotIn(List<Long> values) {
            this.addCriterion("tb_vid not in", values, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidBetween(Long value1, Long value2) {
            this.addCriterion("tb_vid between", value1, value2, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andTbVidNotBetween(Long value1, Long value2) {
            this.addCriterion("tb_vid not between", value1, value2, "tbVid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidIsNull() {
            this.addCriterion("pid is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidIsNotNull() {
            this.addCriterion("pid is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidEqualTo(Long value) {
            this.addCriterion("pid =", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidNotEqualTo(Long value) {
            this.addCriterion("pid <>", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidGreaterThan(Long value) {
            this.addCriterion("pid >", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pid >=", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidLessThan(Long value) {
            this.addCriterion("pid <", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidLessThanOrEqualTo(Long value) {
            this.addCriterion("pid <=", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidLike(String value) {
            this.addCriterion("pid like", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidNotLike(String value) {
            this.addCriterion("pid not like", value, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andPidIn(List<Long> values) {
            this.addCriterion("pid in", values, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidNotIn(List<Long> values) {
            this.addCriterion("pid not in", values, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidBetween(Long value1, Long value2) {
            this.addCriterion("pid between", value1, value2, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPidNotBetween(Long value1, Long value2) {
            this.addCriterion("pid not between", value1, value2, "pid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameIsNull() {
            this.addCriterion("prop_name is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameIsNotNull() {
            this.addCriterion("prop_name is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameEqualTo(String value) {
            this.addCriterion("prop_name =", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameNotEqualTo(String value) {
            this.addCriterion("prop_name <>", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameGreaterThan(String value) {
            this.addCriterion("prop_name >", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("prop_name >=", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameLessThan(String value) {
            this.addCriterion("prop_name <", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameLessThanOrEqualTo(String value) {
            this.addCriterion("prop_name <=", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameLike(String value) {
            this.addCriterion("prop_name like", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameNotLike(String value) {
            this.addCriterion("prop_name not like", value, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andPropNameIn(List<String> values) {
            this.addCriterion("prop_name in", values, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameNotIn(List<String> values) {
            this.addCriterion("prop_name not in", values, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameBetween(String value1, String value2) {
            this.addCriterion("prop_name between", value1, value2, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andPropNameNotBetween(String value1, String value2) {
            this.addCriterion("prop_name not between", value1, value2, "propName");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidIsNull() {
            this.addCriterion("vid is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidIsNotNull() {
            this.addCriterion("vid is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidEqualTo(Long value) {
            this.addCriterion("vid =", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidNotEqualTo(Long value) {
            this.addCriterion("vid <>", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidGreaterThan(Long value) {
            this.addCriterion("vid >", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("vid >=", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidLessThan(Long value) {
            this.addCriterion("vid <", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidLessThanOrEqualTo(Long value) {
            this.addCriterion("vid <=", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidLike(String value) {
            this.addCriterion("vid like", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidNotLike(String value) {
            this.addCriterion("vid not like", value, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andVidIn(List<Long> values) {
            this.addCriterion("vid in", values, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidNotIn(List<Long> values) {
            this.addCriterion("vid not in", values, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidBetween(Long value1, Long value2) {
            this.addCriterion("vid between", value1, value2, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andVidNotBetween(Long value1, Long value2) {
            this.addCriterion("vid not between", value1, value2, "vid");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasIsNull() {
            this.addCriterion("name_alias is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasIsNotNull() {
            this.addCriterion("name_alias is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasEqualTo(String value) {
            this.addCriterion("name_alias =", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotEqualTo(String value) {
            this.addCriterion("name_alias <>", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasGreaterThan(String value) {
            this.addCriterion("name_alias >", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasGreaterThanOrEqualTo(String value) {
            this.addCriterion("name_alias >=", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasLessThan(String value) {
            this.addCriterion("name_alias <", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasLessThanOrEqualTo(String value) {
            this.addCriterion("name_alias <=", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasLike(String value) {
            this.addCriterion("name_alias like", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotLike(String value) {
            this.addCriterion("name_alias not like", value, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andNameAliasIn(List<String> values) {
            this.addCriterion("name_alias in", values, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotIn(List<String> values) {
            this.addCriterion("name_alias not in", values, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasBetween(String value1, String value2) {
            this.addCriterion("name_alias between", value1, value2, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotBetween(String value1, String value2) {
            this.addCriterion("name_alias not between", value1, value2, "nameAlias");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentIsNull() {
            this.addCriterion("is_parent is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentIsNotNull() {
            this.addCriterion("is_parent is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentEqualTo(Integer value) {
            this.addCriterion("is_parent =", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentNotEqualTo(Integer value) {
            this.addCriterion("is_parent <>", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentGreaterThan(Integer value) {
            this.addCriterion("is_parent >", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent >=", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentLessThan(Integer value) {
            this.addCriterion("is_parent <", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_parent <=", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentLike(String value) {
            this.addCriterion("is_parent like", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentNotLike(String value) {
            this.addCriterion("is_parent not like", value, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andIsParentIn(List<Integer> values) {
            this.addCriterion("is_parent in", values, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentNotIn(List<Integer> values) {
            this.addCriterion("is_parent not in", values, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent between", value1, value2, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_parent not between", value1, value2, "isParent");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusEqualTo(String value) {
            this.addCriterion("status =", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusNotEqualTo(String value) {
            this.addCriterion("status <>", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusGreaterThan(String value) {
            this.addCriterion("status >", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusGreaterThanOrEqualTo(String value) {
            this.addCriterion("status >=", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusLessThan(String value) {
            this.addCriterion("status <", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusLessThanOrEqualTo(String value) {
            this.addCriterion("status <=", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andStatusIn(List<String> values) {
            this.addCriterion("status in", values, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusNotIn(List<String> values) {
            this.addCriterion("status not in", values, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusBetween(String value1, String value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andStatusNotBetween(String value1, String value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }        public TaobaoPropValueExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (TaobaoPropValueExample.Criteria)this;
        }
    }
}
