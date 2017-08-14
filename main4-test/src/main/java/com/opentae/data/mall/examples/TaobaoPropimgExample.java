package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class TaobaoPropimgExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<TaobaoPropimgExample.Criteria> oredCriteria = new ArrayList();

    public TaobaoPropimgExample() {
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

    public List<TaobaoPropimgExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(TaobaoPropimgExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public TaobaoPropimgExample.Criteria or() {
        TaobaoPropimgExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public TaobaoPropimgExample.Criteria createCriteria() {
        TaobaoPropimgExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected TaobaoPropimgExample.Criteria createCriteriaInternal() {
        TaobaoPropimgExample.Criteria criteria = new TaobaoPropimgExample.Criteria();
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

    public static class Criteria extends TaobaoPropimgExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<TaobaoPropimgExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<TaobaoPropimgExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<TaobaoPropimgExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new TaobaoPropimgExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new TaobaoPropimgExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new TaobaoPropimgExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public TaobaoPropimgExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdIsNull() {
            this.addCriterion("item_id is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdIsNotNull() {
            this.addCriterion("item_id is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdEqualTo(Long value) {
            this.addCriterion("item_id =", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdNotEqualTo(Long value) {
            this.addCriterion("item_id <>", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdGreaterThan(Long value) {
            this.addCriterion("item_id >", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("item_id >=", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdLessThan(Long value) {
            this.addCriterion("item_id <", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            this.addCriterion("item_id <=", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdLike(String value) {
            this.addCriterion("item_id like", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdNotLike(String value) {
            this.addCriterion("item_id not like", value, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andItemIdIn(List<Long> values) {
            this.addCriterion("item_id in", values, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdNotIn(List<Long> values) {
            this.addCriterion("item_id not in", values, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdBetween(Long value1, Long value2) {
            this.addCriterion("item_id between", value1, value2, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            this.addCriterion("item_id not between", value1, value2, "itemId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidIsNull() {
            this.addCriterion("num_iid is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidIsNotNull() {
            this.addCriterion("num_iid is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidEqualTo(Long value) {
            this.addCriterion("num_iid =", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidNotEqualTo(Long value) {
            this.addCriterion("num_iid <>", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidGreaterThan(Long value) {
            this.addCriterion("num_iid >", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num_iid >=", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidLessThan(Long value) {
            this.addCriterion("num_iid <", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            this.addCriterion("num_iid <=", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidLike(String value) {
            this.addCriterion("num_iid like", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidNotLike(String value) {
            this.addCriterion("num_iid not like", value, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andNumIidIn(List<Long> values) {
            this.addCriterion("num_iid in", values, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidNotIn(List<Long> values) {
            this.addCriterion("num_iid not in", values, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidBetween(Long value1, Long value2) {
            this.addCriterion("num_iid between", value1, value2, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            this.addCriterion("num_iid not between", value1, value2, "numIid");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlIsNull() {
            this.addCriterion("url is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlIsNotNull() {
            this.addCriterion("url is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlEqualTo(String value) {
            this.addCriterion("url =", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlNotEqualTo(String value) {
            this.addCriterion("url <>", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlGreaterThan(String value) {
            this.addCriterion("url >", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("url >=", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlLessThan(String value) {
            this.addCriterion("url <", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlLessThanOrEqualTo(String value) {
            this.addCriterion("url <=", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlLike(String value) {
            this.addCriterion("url like", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlNotLike(String value) {
            this.addCriterion("url not like", value, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andUrlIn(List<String> values) {
            this.addCriterion("url in", values, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlNotIn(List<String> values) {
            this.addCriterion("url not in", values, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlBetween(String value1, String value2) {
            this.addCriterion("url between", value1, value2, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andUrlNotBetween(String value1, String value2) {
            this.addCriterion("url not between", value1, value2, "url");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdIsNull() {
            this.addCriterion("tb_pi_id is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdIsNotNull() {
            this.addCriterion("tb_pi_id is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdEqualTo(Long value) {
            this.addCriterion("tb_pi_id =", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdNotEqualTo(Long value) {
            this.addCriterion("tb_pi_id <>", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdGreaterThan(Long value) {
            this.addCriterion("tb_pi_id >", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("tb_pi_id >=", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdLessThan(Long value) {
            this.addCriterion("tb_pi_id <", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdLessThanOrEqualTo(Long value) {
            this.addCriterion("tb_pi_id <=", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdLike(String value) {
            this.addCriterion("tb_pi_id like", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdNotLike(String value) {
            this.addCriterion("tb_pi_id not like", value, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andTbPiIdIn(List<Long> values) {
            this.addCriterion("tb_pi_id in", values, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdNotIn(List<Long> values) {
            this.addCriterion("tb_pi_id not in", values, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdBetween(Long value1, Long value2) {
            this.addCriterion("tb_pi_id between", value1, value2, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andTbPiIdNotBetween(Long value1, Long value2) {
            this.addCriterion("tb_pi_id not between", value1, value2, "tbPiId");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionIsNull() {
            this.addCriterion("position is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionIsNotNull() {
            this.addCriterion("position is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionEqualTo(Integer value) {
            this.addCriterion("position =", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionNotEqualTo(Integer value) {
            this.addCriterion("position <>", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionGreaterThan(Integer value) {
            this.addCriterion("position >", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("position >=", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionLessThan(Integer value) {
            this.addCriterion("position <", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionLessThanOrEqualTo(Integer value) {
            this.addCriterion("position <=", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionLike(String value) {
            this.addCriterion("position like", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionNotLike(String value) {
            this.addCriterion("position not like", value, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andPositionIn(List<Integer> values) {
            this.addCriterion("position in", values, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionNotIn(List<Integer> values) {
            this.addCriterion("position not in", values, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionBetween(Integer value1, Integer value2) {
            this.addCriterion("position between", value1, value2, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPositionNotBetween(Integer value1, Integer value2) {
            this.addCriterion("position not between", value1, value2, "position");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesIsNull() {
            this.addCriterion("properties is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesIsNotNull() {
            this.addCriterion("properties is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesEqualTo(String value) {
            this.addCriterion("properties =", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotEqualTo(String value) {
            this.addCriterion("properties <>", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesGreaterThan(String value) {
            this.addCriterion("properties >", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesGreaterThanOrEqualTo(String value) {
            this.addCriterion("properties >=", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesLessThan(String value) {
            this.addCriterion("properties <", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesLessThanOrEqualTo(String value) {
            this.addCriterion("properties <=", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesLike(String value) {
            this.addCriterion("properties like", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotLike(String value) {
            this.addCriterion("properties not like", value, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andPropertiesIn(List<String> values) {
            this.addCriterion("properties in", values, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotIn(List<String> values) {
            this.addCriterion("properties not in", values, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesBetween(String value1, String value2) {
            this.addCriterion("properties between", value1, value2, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andPropertiesNotBetween(String value1, String value2) {
            this.addCriterion("properties not between", value1, value2, "properties");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }        public TaobaoPropimgExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }

        public TaobaoPropimgExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (TaobaoPropimgExample.Criteria)this;
        }
    }
}
