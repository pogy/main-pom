package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SearchCategoryExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SearchCategoryExample.Criteria> oredCriteria = new ArrayList();

    public SearchCategoryExample() {
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

    public List<SearchCategoryExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SearchCategoryExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SearchCategoryExample.Criteria or() {
        SearchCategoryExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SearchCategoryExample.Criteria createCriteria() {
        SearchCategoryExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SearchCategoryExample.Criteria createCriteriaInternal() {
        SearchCategoryExample.Criteria criteria = new SearchCategoryExample.Criteria();
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

    public static class Criteria extends SearchCategoryExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SearchCategoryExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SearchCategoryExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SearchCategoryExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SearchCategoryExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SearchCategoryExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SearchCategoryExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SearchCategoryExample.Criteria andCategoryIdIsNull() {
            this.addCriterion("category_id is null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdIsNotNull() {
            this.addCriterion("category_id is not null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdEqualTo(Long value) {
            this.addCriterion("category_id =", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdNotEqualTo(Long value) {
            this.addCriterion("category_id <>", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdGreaterThan(Long value) {
            this.addCriterion("category_id >", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("category_id >=", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdLessThan(Long value) {
            this.addCriterion("category_id <", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            this.addCriterion("category_id <=", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdLike(String value) {
            this.addCriterion("category_id like", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdNotLike(String value) {
            this.addCriterion("category_id not like", value, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }        public SearchCategoryExample.Criteria andCategoryIdIn(List<Long> values) {
            this.addCriterion("category_id in", values, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdNotIn(List<Long> values) {
            this.addCriterion("category_id not in", values, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdBetween(Long value1, Long value2) {
            this.addCriterion("category_id between", value1, value2, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            this.addCriterion("category_id not between", value1, value2, "categoryId");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (SearchCategoryExample.Criteria)this;
        }        public SearchCategoryExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameIsNull() {
            this.addCriterion("cate_name is null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameIsNotNull() {
            this.addCriterion("cate_name is not null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameEqualTo(String value) {
            this.addCriterion("cate_name =", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameNotEqualTo(String value) {
            this.addCriterion("cate_name <>", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameGreaterThan(String value) {
            this.addCriterion("cate_name >", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("cate_name >=", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameLessThan(String value) {
            this.addCriterion("cate_name <", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameLessThanOrEqualTo(String value) {
            this.addCriterion("cate_name <=", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameLike(String value) {
            this.addCriterion("cate_name like", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameNotLike(String value) {
            this.addCriterion("cate_name not like", value, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }        public SearchCategoryExample.Criteria andCateNameIn(List<String> values) {
            this.addCriterion("cate_name in", values, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameNotIn(List<String> values) {
            this.addCriterion("cate_name not in", values, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameBetween(String value1, String value2) {
            this.addCriterion("cate_name between", value1, value2, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateNameNotBetween(String value1, String value2) {
            this.addCriterion("cate_name not between", value1, value2, "cateName");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueIsNull() {
            this.addCriterion("cate_value is null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueIsNotNull() {
            this.addCriterion("cate_value is not null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueEqualTo(String value) {
            this.addCriterion("cate_value =", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueNotEqualTo(String value) {
            this.addCriterion("cate_value <>", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueGreaterThan(String value) {
            this.addCriterion("cate_value >", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueGreaterThanOrEqualTo(String value) {
            this.addCriterion("cate_value >=", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueLessThan(String value) {
            this.addCriterion("cate_value <", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueLessThanOrEqualTo(String value) {
            this.addCriterion("cate_value <=", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueLike(String value) {
            this.addCriterion("cate_value like", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueNotLike(String value) {
            this.addCriterion("cate_value not like", value, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }        public SearchCategoryExample.Criteria andCateValueIn(List<String> values) {
            this.addCriterion("cate_value in", values, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueNotIn(List<String> values) {
            this.addCriterion("cate_value not in", values, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueBetween(String value1, String value2) {
            this.addCriterion("cate_value between", value1, value2, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andCateValueNotBetween(String value1, String value2) {
            this.addCriterion("cate_value not between", value1, value2, "cateValue");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortIsNull() {
            this.addCriterion("sort is null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortIsNotNull() {
            this.addCriterion("sort is not null");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortEqualTo(Integer value) {
            this.addCriterion("sort =", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortNotEqualTo(Integer value) {
            this.addCriterion("sort <>", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortGreaterThan(Integer value) {
            this.addCriterion("sort >", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort >=", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortLessThan(Integer value) {
            this.addCriterion("sort <", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort <=", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortLike(String value) {
            this.addCriterion("sort like", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortNotLike(String value) {
            this.addCriterion("sort not like", value, "sort");
            return (SearchCategoryExample.Criteria)this;
        }        public SearchCategoryExample.Criteria andSortIn(List<Integer> values) {
            this.addCriterion("sort in", values, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortNotIn(List<Integer> values) {
            this.addCriterion("sort not in", values, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortBetween(Integer value1, Integer value2) {
            this.addCriterion("sort between", value1, value2, "sort");
            return (SearchCategoryExample.Criteria)this;
        }

        public SearchCategoryExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort not between", value1, value2, "sort");
            return (SearchCategoryExample.Criteria)this;
        }
    }
}
