package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.StyleChannelSearchParent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class StyleChannelSearchParentExample extends SgExample<StyleChannelSearchParentExample.Criteria> {
    public static final Class<StyleChannelSearchParent> beanClass = StyleChannelSearchParent.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn searchType;
    public static EntityColumn id;
    public static EntityColumn searchPid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        searchType = listMap.get("searchType");
        id = listMap.get("id");
        searchPid = listMap.get("searchPid");
        }

    public StyleChannelSearchParentExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected StyleChannelSearchParentExample.Criteria createCriteriaInternal() {
        return new StyleChannelSearchParentExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public StyleChannelSearchParentExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public StyleChannelSearchParentExample.Criteria andSearchTypeIsNull() {
            return isNull(searchType);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeIsNotNull() {
            return isNotNull(searchType);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeEqualTo(String value) {
            return equalTo(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeNotEqualTo(String value) {
            return notEqualTo(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeGreaterThan(String value) {
            return greaterThan(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeLessThan(String value) {
            return lessThan(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeLike(String value) {
            return like(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeNotLike(String value) {
            return notLike(searchType, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeIn(List<String> values) {
            return in(searchType, values);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeNotIn(List<String> values) {
            return notIn(searchType, values);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeBetween(String value1, String value2) {
            return between(searchType, value1, value2);
        }

        public StyleChannelSearchParentExample.Criteria andSearchTypeNotBetween(String value1, String value2) {
            return notBetween(searchType, value1, value2);
        }
        public StyleChannelSearchParentExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public StyleChannelSearchParentExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public StyleChannelSearchParentExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public StyleChannelSearchParentExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public StyleChannelSearchParentExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public StyleChannelSearchParentExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public StyleChannelSearchParentExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public StyleChannelSearchParentExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public StyleChannelSearchParentExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public StyleChannelSearchParentExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public StyleChannelSearchParentExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public StyleChannelSearchParentExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public StyleChannelSearchParentExample.Criteria andSearchPidIsNull() {
            return isNull(searchPid);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidIsNotNull() {
            return isNotNull(searchPid);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidEqualTo(Long value) {
            return equalTo(searchPid, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidNotEqualTo(Long value) {
            return notEqualTo(searchPid, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidGreaterThan(Long value) {
            return greaterThan(searchPid, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(searchPid, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidLessThan(Long value) {
            return lessThan(searchPid, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(searchPid, value);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidIn(List<Long> values) {
            return in(searchPid, values);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidNotIn(List<Long> values) {
            return notIn(searchPid, values);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidBetween(Long value1, Long value2) {
            return between(searchPid, value1, value2);
        }

        public StyleChannelSearchParentExample.Criteria andSearchPidNotBetween(Long value1, Long value2) {
            return notBetween(searchPid, value1, value2);
        }
    }
}