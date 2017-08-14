package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoatOneLocation;

import java.util.*;
public class GoatOneLocationExample extends SgExample<GoatOneLocationExample.Criteria> {
    public static final Class<GoatOneLocation> beanClass = GoatOneLocation.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn disEnabled;
    public static EntityColumn createTime;
    public static EntityColumn goatType;
    public static EntityColumn description;
    public static EntityColumn localCode;
    public static EntityColumn localId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        disEnabled = listMap.get("disEnabled");
        createTime = listMap.get("createTime");
        goatType = listMap.get("goatType");
        description = listMap.get("description");
        localCode = listMap.get("localCode");
        localId = listMap.get("localId");
        }

    public GoatOneLocationExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoatOneLocationExample.Criteria createCriteriaInternal() {
        return new GoatOneLocationExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoatOneLocationExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public GoatOneLocationExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public GoatOneLocationExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public GoatOneLocationExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public GoatOneLocationExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public GoatOneLocationExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public GoatOneLocationExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public GoatOneLocationExample.Criteria andDisEnabledIsNull() {
            return isNull(disEnabled);
        }

        public GoatOneLocationExample.Criteria andDisEnabledIsNotNull() {
            return isNotNull(disEnabled);
        }

        public GoatOneLocationExample.Criteria andDisEnabledEqualTo(Boolean value) {
            return equalTo(disEnabled, value);
        }

        public GoatOneLocationExample.Criteria andDisEnabledNotEqualTo(Boolean value) {
            return notEqualTo(disEnabled, value);
        }

        public GoatOneLocationExample.Criteria andDisEnabledGreaterThan(Boolean value) {
            return greaterThan(disEnabled, value);
        }

        public GoatOneLocationExample.Criteria andDisEnabledGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(disEnabled, value);
        }

        public GoatOneLocationExample.Criteria andDisEnabledLessThan(Boolean value) {
            return lessThan(disEnabled, value);
        }

        public GoatOneLocationExample.Criteria andDisEnabledLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(disEnabled, value);
        }

        public GoatOneLocationExample.Criteria andDisEnabledIn(List<Boolean> values) {
            return in(disEnabled, values);
        }

        public GoatOneLocationExample.Criteria andDisEnabledNotIn(List<Boolean> values) {
            return notIn(disEnabled, values);
        }

        public GoatOneLocationExample.Criteria andDisEnabledBetween(Boolean value1, Boolean value2) {
            return between(disEnabled, value1, value2);
        }

        public GoatOneLocationExample.Criteria andDisEnabledNotBetween(Boolean value1, Boolean value2) {
            return notBetween(disEnabled, value1, value2);
        }
        public GoatOneLocationExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public GoatOneLocationExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public GoatOneLocationExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public GoatOneLocationExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public GoatOneLocationExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public GoatOneLocationExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public GoatOneLocationExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public GoatOneLocationExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public GoatOneLocationExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public GoatOneLocationExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public GoatOneLocationExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public GoatOneLocationExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public GoatOneLocationExample.Criteria andGoatTypeIsNull() {
            return isNull(goatType);
        }

        public GoatOneLocationExample.Criteria andGoatTypeIsNotNull() {
            return isNotNull(goatType);
        }

        public GoatOneLocationExample.Criteria andGoatTypeEqualTo(Integer value) {
            return equalTo(goatType, value);
        }

        public GoatOneLocationExample.Criteria andGoatTypeNotEqualTo(Integer value) {
            return notEqualTo(goatType, value);
        }

        public GoatOneLocationExample.Criteria andGoatTypeGreaterThan(Integer value) {
            return greaterThan(goatType, value);
        }

        public GoatOneLocationExample.Criteria andGoatTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goatType, value);
        }

        public GoatOneLocationExample.Criteria andGoatTypeLessThan(Integer value) {
            return lessThan(goatType, value);
        }

        public GoatOneLocationExample.Criteria andGoatTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goatType, value);
        }

        public GoatOneLocationExample.Criteria andGoatTypeIn(List<Integer> values) {
            return in(goatType, values);
        }

        public GoatOneLocationExample.Criteria andGoatTypeNotIn(List<Integer> values) {
            return notIn(goatType, values);
        }

        public GoatOneLocationExample.Criteria andGoatTypeBetween(Integer value1, Integer value2) {
            return between(goatType, value1, value2);
        }

        public GoatOneLocationExample.Criteria andGoatTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(goatType, value1, value2);
        }
        public GoatOneLocationExample.Criteria andDescriptionIsNull() {
            return isNull(description);
        }

        public GoatOneLocationExample.Criteria andDescriptionIsNotNull() {
            return isNotNull(description);
        }

        public GoatOneLocationExample.Criteria andDescriptionEqualTo(String value) {
            return equalTo(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionNotEqualTo(String value) {
            return notEqualTo(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionGreaterThan(String value) {
            return greaterThan(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionLessThan(String value) {
            return lessThan(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionLike(String value) {
            return like(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionNotLike(String value) {
            return notLike(description, value);
        }

        public GoatOneLocationExample.Criteria andDescriptionIn(List<String> values) {
            return in(description, values);
        }

        public GoatOneLocationExample.Criteria andDescriptionNotIn(List<String> values) {
            return notIn(description, values);
        }

        public GoatOneLocationExample.Criteria andDescriptionBetween(String value1, String value2) {
            return between(description, value1, value2);
        }

        public GoatOneLocationExample.Criteria andDescriptionNotBetween(String value1, String value2) {
            return notBetween(description, value1, value2);
        }
        public GoatOneLocationExample.Criteria andLocalCodeIsNull() {
            return isNull(localCode);
        }

        public GoatOneLocationExample.Criteria andLocalCodeIsNotNull() {
            return isNotNull(localCode);
        }

        public GoatOneLocationExample.Criteria andLocalCodeEqualTo(String value) {
            return equalTo(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotEqualTo(String value) {
            return notEqualTo(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeGreaterThan(String value) {
            return greaterThan(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeLessThan(String value) {
            return lessThan(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeLike(String value) {
            return like(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotLike(String value) {
            return notLike(localCode, value);
        }

        public GoatOneLocationExample.Criteria andLocalCodeIn(List<String> values) {
            return in(localCode, values);
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotIn(List<String> values) {
            return notIn(localCode, values);
        }

        public GoatOneLocationExample.Criteria andLocalCodeBetween(String value1, String value2) {
            return between(localCode, value1, value2);
        }

        public GoatOneLocationExample.Criteria andLocalCodeNotBetween(String value1, String value2) {
            return notBetween(localCode, value1, value2);
        }
        public GoatOneLocationExample.Criteria andLocalIdIsNull() {
            return isNull(localId);
        }

        public GoatOneLocationExample.Criteria andLocalIdIsNotNull() {
            return isNotNull(localId);
        }

        public GoatOneLocationExample.Criteria andLocalIdEqualTo(Long value) {
            return equalTo(localId, value);
        }

        public GoatOneLocationExample.Criteria andLocalIdNotEqualTo(Long value) {
            return notEqualTo(localId, value);
        }

        public GoatOneLocationExample.Criteria andLocalIdGreaterThan(Long value) {
            return greaterThan(localId, value);
        }

        public GoatOneLocationExample.Criteria andLocalIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(localId, value);
        }

        public GoatOneLocationExample.Criteria andLocalIdLessThan(Long value) {
            return lessThan(localId, value);
        }

        public GoatOneLocationExample.Criteria andLocalIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(localId, value);
        }

        public GoatOneLocationExample.Criteria andLocalIdIn(List<Long> values) {
            return in(localId, values);
        }

        public GoatOneLocationExample.Criteria andLocalIdNotIn(List<Long> values) {
            return notIn(localId, values);
        }

        public GoatOneLocationExample.Criteria andLocalIdBetween(Long value1, Long value2) {
            return between(localId, value1, value2);
        }

        public GoatOneLocationExample.Criteria andLocalIdNotBetween(Long value1, Long value2) {
            return notBetween(localId, value1, value2);
        }
    }
}
