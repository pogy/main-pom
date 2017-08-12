package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguActivityCategoryExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguActivityCategoryExample.Criteria> oredCriteria = new ArrayList();

    public ShiguActivityCategoryExample() {
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

    public List<ShiguActivityCategoryExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguActivityCategoryExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguActivityCategoryExample.Criteria or() {
        ShiguActivityCategoryExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguActivityCategoryExample.Criteria createCriteria() {
        ShiguActivityCategoryExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguActivityCategoryExample.Criteria createCriteriaInternal() {
        ShiguActivityCategoryExample.Criteria criteria = new ShiguActivityCategoryExample.Criteria();
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

    public static class Criteria extends ShiguActivityCategoryExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguActivityCategoryExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguActivityCategoryExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguActivityCategoryExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguActivityCategoryExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguActivityCategoryExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguActivityCategoryExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdIsNull() {
            this.addCriterion("active_id is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdIsNotNull() {
            this.addCriterion("active_id is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdEqualTo(Long value) {
            this.addCriterion("active_id =", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdNotEqualTo(Long value) {
            this.addCriterion("active_id <>", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdGreaterThan(Long value) {
            this.addCriterion("active_id >", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("active_id >=", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdLessThan(Long value) {
            this.addCriterion("active_id <", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdLessThanOrEqualTo(Long value) {
            this.addCriterion("active_id <=", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdLike(String value) {
            this.addCriterion("active_id like", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdNotLike(String value) {
            this.addCriterion("active_id not like", value, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andActiveIdIn(List<Long> values) {
            this.addCriterion("active_id in", values, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdNotIn(List<Long> values) {
            this.addCriterion("active_id not in", values, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdBetween(Long value1, Long value2) {
            this.addCriterion("active_id between", value1, value2, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdNotBetween(Long value1, Long value2) {
            this.addCriterion("active_id not between", value1, value2, "activeId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdIsNull() {
            this.addCriterion("cate_id is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdIsNotNull() {
            this.addCriterion("cate_id is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdEqualTo(Long value) {
            this.addCriterion("cate_id =", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdNotEqualTo(Long value) {
            this.addCriterion("cate_id <>", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdGreaterThan(Long value) {
            this.addCriterion("cate_id >", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cate_id >=", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdLessThan(Long value) {
            this.addCriterion("cate_id <", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cate_id <=", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdLike(String value) {
            this.addCriterion("cate_id like", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdNotLike(String value) {
            this.addCriterion("cate_id not like", value, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andCateIdIn(List<Long> values) {
            this.addCriterion("cate_id in", values, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdNotIn(List<Long> values) {
            this.addCriterion("cate_id not in", values, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdBetween(Long value1, Long value2) {
            this.addCriterion("cate_id between", value1, value2, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andCateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cate_id not between", value1, value2, "cateId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgIsNull() {
            this.addCriterion("title_img is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgIsNotNull() {
            this.addCriterion("title_img is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgEqualTo(String value) {
            this.addCriterion("title_img =", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotEqualTo(String value) {
            this.addCriterion("title_img <>", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgGreaterThan(String value) {
            this.addCriterion("title_img >", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgGreaterThanOrEqualTo(String value) {
            this.addCriterion("title_img >=", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgLessThan(String value) {
            this.addCriterion("title_img <", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgLessThanOrEqualTo(String value) {
            this.addCriterion("title_img <=", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgLike(String value) {
            this.addCriterion("title_img like", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotLike(String value) {
            this.addCriterion("title_img not like", value, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andTitleImgIn(List<String> values) {
            this.addCriterion("title_img in", values, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotIn(List<String> values) {
            this.addCriterion("title_img not in", values, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgBetween(String value1, String value2) {
            this.addCriterion("title_img between", value1, value2, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotBetween(String value1, String value2) {
            this.addCriterion("title_img not between", value1, value2, "titleImg");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ShiguActivityCategoryExample.Criteria)this;
        }
    }
}
