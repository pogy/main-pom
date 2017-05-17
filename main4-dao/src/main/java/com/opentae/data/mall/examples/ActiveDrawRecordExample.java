package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ActiveDrawRecordExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ActiveDrawRecordExample.Criteria> oredCriteria = new ArrayList();

    public ActiveDrawRecordExample() {
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

    public List<ActiveDrawRecordExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ActiveDrawRecordExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ActiveDrawRecordExample.Criteria or() {
        ActiveDrawRecordExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ActiveDrawRecordExample.Criteria createCriteria() {
        ActiveDrawRecordExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ActiveDrawRecordExample.Criteria createCriteriaInternal() {
        ActiveDrawRecordExample.Criteria criteria = new ActiveDrawRecordExample.Criteria();
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

    public static class Criteria extends ActiveDrawRecordExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ActiveDrawRecordExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ActiveDrawRecordExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ActiveDrawRecordExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ActiveDrawRecordExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ActiveDrawRecordExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ActiveDrawRecordExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ActiveDrawRecordExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardIsNull() {
            this.addCriterion("ward is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardIsNotNull() {
            this.addCriterion("ward is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardEqualTo(String value) {
            this.addCriterion("ward =", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardNotEqualTo(String value) {
            this.addCriterion("ward <>", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardGreaterThan(String value) {
            this.addCriterion("ward >", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardGreaterThanOrEqualTo(String value) {
            this.addCriterion("ward >=", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardLessThan(String value) {
            this.addCriterion("ward <", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardLessThanOrEqualTo(String value) {
            this.addCriterion("ward <=", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardLike(String value) {
            this.addCriterion("ward like", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardNotLike(String value) {
            this.addCriterion("ward not like", value, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andWardIn(List<String> values) {
            this.addCriterion("ward in", values, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardNotIn(List<String> values) {
            this.addCriterion("ward not in", values, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardBetween(String value1, String value2) {
            this.addCriterion("ward between", value1, value2, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andWardNotBetween(String value1, String value2) {
            this.addCriterion("ward not between", value1, value2, "ward");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdIsNull() {
            this.addCriterion("pem_id is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdIsNotNull() {
            this.addCriterion("pem_id is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdEqualTo(Long value) {
            this.addCriterion("pem_id =", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdNotEqualTo(Long value) {
            this.addCriterion("pem_id <>", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdGreaterThan(Long value) {
            this.addCriterion("pem_id >", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pem_id >=", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdLessThan(Long value) {
            this.addCriterion("pem_id <", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdLessThanOrEqualTo(Long value) {
            this.addCriterion("pem_id <=", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdLike(String value) {
            this.addCriterion("pem_id like", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdNotLike(String value) {
            this.addCriterion("pem_id not like", value, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andPemIdIn(List<Long> values) {
            this.addCriterion("pem_id in", values, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdNotIn(List<Long> values) {
            this.addCriterion("pem_id not in", values, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdBetween(Long value1, Long value2) {
            this.addCriterion("pem_id between", value1, value2, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andPemIdNotBetween(Long value1, Long value2) {
            this.addCriterion("pem_id not between", value1, value2, "pemId");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesIsNull() {
            this.addCriterion("receives_yes is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesIsNotNull() {
            this.addCriterion("receives_yes is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesEqualTo(Boolean value) {
            this.addCriterion("receives_yes =", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesNotEqualTo(Boolean value) {
            this.addCriterion("receives_yes <>", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesGreaterThan(Boolean value) {
            this.addCriterion("receives_yes >", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("receives_yes >=", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesLessThan(Boolean value) {
            this.addCriterion("receives_yes <", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesLessThanOrEqualTo(Boolean value) {
            this.addCriterion("receives_yes <=", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesLike(String value) {
            this.addCriterion("receives_yes like", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesNotLike(String value) {
            this.addCriterion("receives_yes not like", value, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andReceivesYesIn(List<Boolean> values) {
            this.addCriterion("receives_yes in", values, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesNotIn(List<Boolean> values) {
            this.addCriterion("receives_yes not in", values, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesBetween(Boolean value1, Boolean value2) {
            this.addCriterion("receives_yes between", value1, value2, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("receives_yes not between", value1, value2, "receivesYes");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeIsNull() {
            this.addCriterion("draw_code is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeIsNotNull() {
            this.addCriterion("draw_code is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeEqualTo(String value) {
            this.addCriterion("draw_code =", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotEqualTo(String value) {
            this.addCriterion("draw_code <>", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeGreaterThan(String value) {
            this.addCriterion("draw_code >", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("draw_code >=", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeLessThan(String value) {
            this.addCriterion("draw_code <", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeLessThanOrEqualTo(String value) {
            this.addCriterion("draw_code <=", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeLike(String value) {
            this.addCriterion("draw_code like", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotLike(String value) {
            this.addCriterion("draw_code not like", value, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andDrawCodeIn(List<String> values) {
            this.addCriterion("draw_code in", values, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotIn(List<String> values) {
            this.addCriterion("draw_code not in", values, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeBetween(String value1, String value2) {
            this.addCriterion("draw_code between", value1, value2, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotBetween(String value1, String value2) {
            this.addCriterion("draw_code not between", value1, value2, "drawCode");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusIsNull() {
            this.addCriterion("draw_status is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusIsNotNull() {
            this.addCriterion("draw_status is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusEqualTo(Integer value) {
            this.addCriterion("draw_status =", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusNotEqualTo(Integer value) {
            this.addCriterion("draw_status <>", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusGreaterThan(Integer value) {
            this.addCriterion("draw_status >", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("draw_status >=", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusLessThan(Integer value) {
            this.addCriterion("draw_status <", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("draw_status <=", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusLike(String value) {
            this.addCriterion("draw_status like", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusNotLike(String value) {
            this.addCriterion("draw_status not like", value, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andDrawStatusIn(List<Integer> values) {
            this.addCriterion("draw_status in", values, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusNotIn(List<Integer> values) {
            this.addCriterion("draw_status not in", values, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("draw_status between", value1, value2, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("draw_status not between", value1, value2, "drawStatus");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeIsNull() {
            this.addCriterion("modify_time is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeIsNotNull() {
            this.addCriterion("modify_time is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeEqualTo(Date value) {
            this.addCriterion("modify_time =", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeNotEqualTo(Date value) {
            this.addCriterion("modify_time <>", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeGreaterThan(Date value) {
            this.addCriterion("modify_time >", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modify_time >=", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeLessThan(Date value) {
            this.addCriterion("modify_time <", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("modify_time <=", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeLike(String value) {
            this.addCriterion("modify_time like", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeNotLike(String value) {
            this.addCriterion("modify_time not like", value, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andModifyTimeIn(List<Date> values) {
            this.addCriterion("modify_time in", values, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeNotIn(List<Date> values) {
            this.addCriterion("modify_time not in", values, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("modify_time between", value1, value2, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeIsNull() {
            this.addCriterion("refe_time is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeIsNotNull() {
            this.addCriterion("refe_time is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeEqualTo(Date value) {
            this.addCriterion("refe_time =", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeNotEqualTo(Date value) {
            this.addCriterion("refe_time <>", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeGreaterThan(Date value) {
            this.addCriterion("refe_time >", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("refe_time >=", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeLessThan(Date value) {
            this.addCriterion("refe_time <", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("refe_time <=", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeLike(String value) {
            this.addCriterion("refe_time like", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeNotLike(String value) {
            this.addCriterion("refe_time not like", value, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andRefeTimeIn(List<Date> values) {
            this.addCriterion("refe_time in", values, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeNotIn(List<Date> values) {
            this.addCriterion("refe_time not in", values, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeBetween(Date value1, Date value2) {
            this.addCriterion("refe_time between", value1, value2, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("refe_time not between", value1, value2, "refeTime");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledIsNull() {
            this.addCriterion("enabled is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledIsNotNull() {
            this.addCriterion("enabled is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledEqualTo(Boolean value) {
            this.addCriterion("enabled =", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledNotEqualTo(Boolean value) {
            this.addCriterion("enabled <>", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledGreaterThan(Boolean value) {
            this.addCriterion("enabled >", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled >=", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledLessThan(Boolean value) {
            this.addCriterion("enabled <", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled <=", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledLike(String value) {
            this.addCriterion("enabled like", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledNotLike(String value) {
            this.addCriterion("enabled not like", value, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andEnabledIn(List<Boolean> values) {
            this.addCriterion("enabled in", values, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledNotIn(List<Boolean> values) {
            this.addCriterion("enabled not in", values, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled between", value1, value2, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled not between", value1, value2, "enabled");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickIsNull() {
            this.addCriterion("user_nick is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickIsNotNull() {
            this.addCriterion("user_nick is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickEqualTo(String value) {
            this.addCriterion("user_nick =", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotEqualTo(String value) {
            this.addCriterion("user_nick <>", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickGreaterThan(String value) {
            this.addCriterion("user_nick >", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_nick >=", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickLessThan(String value) {
            this.addCriterion("user_nick <", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickLessThanOrEqualTo(String value) {
            this.addCriterion("user_nick <=", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickLike(String value) {
            this.addCriterion("user_nick like", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotLike(String value) {
            this.addCriterion("user_nick not like", value, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andUserNickIn(List<String> values) {
            this.addCriterion("user_nick in", values, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotIn(List<String> values) {
            this.addCriterion("user_nick not in", values, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickBetween(String value1, String value2) {
            this.addCriterion("user_nick between", value1, value2, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotBetween(String value1, String value2) {
            this.addCriterion("user_nick not between", value1, value2, "userNick");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneIsNull() {
            this.addCriterion("login_phone is null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneIsNotNull() {
            this.addCriterion("login_phone is not null");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneEqualTo(String value) {
            this.addCriterion("login_phone =", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotEqualTo(String value) {
            this.addCriterion("login_phone <>", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneGreaterThan(String value) {
            this.addCriterion("login_phone >", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_phone >=", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneLessThan(String value) {
            this.addCriterion("login_phone <", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("login_phone <=", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneLike(String value) {
            this.addCriterion("login_phone like", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotLike(String value) {
            this.addCriterion("login_phone not like", value, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }        public ActiveDrawRecordExample.Criteria andLoginPhoneIn(List<String> values) {
            this.addCriterion("login_phone in", values, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotIn(List<String> values) {
            this.addCriterion("login_phone not in", values, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneBetween(String value1, String value2) {
            this.addCriterion("login_phone between", value1, value2, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotBetween(String value1, String value2) {
            this.addCriterion("login_phone not between", value1, value2, "loginPhone");
            return (ActiveDrawRecordExample.Criteria)this;
        }
    }
}
