package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.SearchCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class SearchCategoryExample extends SgExample<SearchCategoryExample.Criteria> {
    public static final Class<SearchCategory> beanClass = SearchCategory.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn sort;
    public static EntityColumn cateValue;
    public static EntityColumn type;
    public static EntityColumn cateName;
    public static EntityColumn categoryId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        sort = listMap.get("sort");
        cateValue = listMap.get("cateValue");
        type = listMap.get("type");
        cateName = listMap.get("cateName");
        categoryId = listMap.get("categoryId");
        }

    public SearchCategoryExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SearchCategoryExample.Criteria createCriteriaInternal() {
        return new SearchCategoryExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SearchCategoryExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public SearchCategoryExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public SearchCategoryExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public SearchCategoryExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public SearchCategoryExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public SearchCategoryExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public SearchCategoryExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public SearchCategoryExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public SearchCategoryExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public SearchCategoryExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public SearchCategoryExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public SearchCategoryExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public SearchCategoryExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public SearchCategoryExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public SearchCategoryExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public SearchCategoryExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public SearchCategoryExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public SearchCategoryExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public SearchCategoryExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public SearchCategoryExample.Criteria andCateValueIsNull() {
            return isNull(cateValue);
        }

        public SearchCategoryExample.Criteria andCateValueIsNotNull() {
            return isNotNull(cateValue);
        }

        public SearchCategoryExample.Criteria andCateValueEqualTo(String value) {
            return equalTo(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueNotEqualTo(String value) {
            return notEqualTo(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueGreaterThan(String value) {
            return greaterThan(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueLessThan(String value) {
            return lessThan(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueLike(String value) {
            return like(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueNotLike(String value) {
            return notLike(cateValue, value);
        }

        public SearchCategoryExample.Criteria andCateValueIn(List<String> values) {
            return in(cateValue, values);
        }

        public SearchCategoryExample.Criteria andCateValueNotIn(List<String> values) {
            return notIn(cateValue, values);
        }

        public SearchCategoryExample.Criteria andCateValueBetween(String value1, String value2) {
            return between(cateValue, value1, value2);
        }

        public SearchCategoryExample.Criteria andCateValueNotBetween(String value1, String value2) {
            return notBetween(cateValue, value1, value2);
        }
        public SearchCategoryExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public SearchCategoryExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public SearchCategoryExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public SearchCategoryExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public SearchCategoryExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public SearchCategoryExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public SearchCategoryExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public SearchCategoryExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public SearchCategoryExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public SearchCategoryExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public SearchCategoryExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public SearchCategoryExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public SearchCategoryExample.Criteria andCateNameIsNull() {
            return isNull(cateName);
        }

        public SearchCategoryExample.Criteria andCateNameIsNotNull() {
            return isNotNull(cateName);
        }

        public SearchCategoryExample.Criteria andCateNameEqualTo(String value) {
            return equalTo(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameNotEqualTo(String value) {
            return notEqualTo(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameGreaterThan(String value) {
            return greaterThan(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameLessThan(String value) {
            return lessThan(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameLike(String value) {
            return like(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameNotLike(String value) {
            return notLike(cateName, value);
        }

        public SearchCategoryExample.Criteria andCateNameIn(List<String> values) {
            return in(cateName, values);
        }

        public SearchCategoryExample.Criteria andCateNameNotIn(List<String> values) {
            return notIn(cateName, values);
        }

        public SearchCategoryExample.Criteria andCateNameBetween(String value1, String value2) {
            return between(cateName, value1, value2);
        }

        public SearchCategoryExample.Criteria andCateNameNotBetween(String value1, String value2) {
            return notBetween(cateName, value1, value2);
        }
        public SearchCategoryExample.Criteria andCategoryIdIsNull() {
            return isNull(categoryId);
        }

        public SearchCategoryExample.Criteria andCategoryIdIsNotNull() {
            return isNotNull(categoryId);
        }

        public SearchCategoryExample.Criteria andCategoryIdEqualTo(Long value) {
            return equalTo(categoryId, value);
        }

        public SearchCategoryExample.Criteria andCategoryIdNotEqualTo(Long value) {
            return notEqualTo(categoryId, value);
        }

        public SearchCategoryExample.Criteria andCategoryIdGreaterThan(Long value) {
            return greaterThan(categoryId, value);
        }

        public SearchCategoryExample.Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(categoryId, value);
        }

        public SearchCategoryExample.Criteria andCategoryIdLessThan(Long value) {
            return lessThan(categoryId, value);
        }

        public SearchCategoryExample.Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(categoryId, value);
        }

        public SearchCategoryExample.Criteria andCategoryIdIn(List<Long> values) {
            return in(categoryId, values);
        }

        public SearchCategoryExample.Criteria andCategoryIdNotIn(List<Long> values) {
            return notIn(categoryId, values);
        }

        public SearchCategoryExample.Criteria andCategoryIdBetween(Long value1, Long value2) {
            return between(categoryId, value1, value2);
        }

        public SearchCategoryExample.Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            return notBetween(categoryId, value1, value2);
        }
    }
}