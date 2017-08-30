package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.DiscusScore;

import java.util.*;
public class DiscusScoreExample extends SgExample<DiscusScoreExample.Criteria> {
    public static final Class<DiscusScore> beanClass = DiscusScore.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn dsId;
    public static EntityColumn createdTime;
    public static EntityColumn scoreNum;
    public static EntityColumn storeId;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        dsId = listMap.get("dsId");
        createdTime = listMap.get("createdTime");
        scoreNum = listMap.get("scoreNum");
        storeId = listMap.get("storeId");
        userId = listMap.get("userId");
        }

    public DiscusScoreExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DiscusScoreExample.Criteria createCriteriaInternal() {
        return new DiscusScoreExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DiscusScoreExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DiscusScoreExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DiscusScoreExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DiscusScoreExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DiscusScoreExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DiscusScoreExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DiscusScoreExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DiscusScoreExample.Criteria andDsIdIsNull() {
            return isNull(dsId);
        }

        public DiscusScoreExample.Criteria andDsIdIsNotNull() {
            return isNotNull(dsId);
        }

        public DiscusScoreExample.Criteria andDsIdEqualTo(Long value) {
            return equalTo(dsId, value);
        }

        public DiscusScoreExample.Criteria andDsIdNotEqualTo(Long value) {
            return notEqualTo(dsId, value);
        }

        public DiscusScoreExample.Criteria andDsIdGreaterThan(Long value) {
            return greaterThan(dsId, value);
        }

        public DiscusScoreExample.Criteria andDsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dsId, value);
        }

        public DiscusScoreExample.Criteria andDsIdLessThan(Long value) {
            return lessThan(dsId, value);
        }

        public DiscusScoreExample.Criteria andDsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dsId, value);
        }

        public DiscusScoreExample.Criteria andDsIdIn(List<Long> values) {
            return in(dsId, values);
        }

        public DiscusScoreExample.Criteria andDsIdNotIn(List<Long> values) {
            return notIn(dsId, values);
        }

        public DiscusScoreExample.Criteria andDsIdBetween(Long value1, Long value2) {
            return between(dsId, value1, value2);
        }

        public DiscusScoreExample.Criteria andDsIdNotBetween(Long value1, Long value2) {
            return notBetween(dsId, value1, value2);
        }
        public DiscusScoreExample.Criteria andCreatedTimeIsNull() {
            return isNull(createdTime);
        }

        public DiscusScoreExample.Criteria andCreatedTimeIsNotNull() {
            return isNotNull(createdTime);
        }

        public DiscusScoreExample.Criteria andCreatedTimeEqualTo(Date value) {
            return equalTo(createdTime, value);
        }

        public DiscusScoreExample.Criteria andCreatedTimeNotEqualTo(Date value) {
            return notEqualTo(createdTime, value);
        }

        public DiscusScoreExample.Criteria andCreatedTimeGreaterThan(Date value) {
            return greaterThan(createdTime, value);
        }

        public DiscusScoreExample.Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createdTime, value);
        }

        public DiscusScoreExample.Criteria andCreatedTimeLessThan(Date value) {
            return lessThan(createdTime, value);
        }

        public DiscusScoreExample.Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createdTime, value);
        }

        public DiscusScoreExample.Criteria andCreatedTimeIn(List<Date> values) {
            return in(createdTime, values);
        }

        public DiscusScoreExample.Criteria andCreatedTimeNotIn(List<Date> values) {
            return notIn(createdTime, values);
        }

        public DiscusScoreExample.Criteria andCreatedTimeBetween(Date value1, Date value2) {
            return between(createdTime, value1, value2);
        }

        public DiscusScoreExample.Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            return notBetween(createdTime, value1, value2);
        }
        public DiscusScoreExample.Criteria andScoreNumIsNull() {
            return isNull(scoreNum);
        }

        public DiscusScoreExample.Criteria andScoreNumIsNotNull() {
            return isNotNull(scoreNum);
        }

        public DiscusScoreExample.Criteria andScoreNumEqualTo(Integer value) {
            return equalTo(scoreNum, value);
        }

        public DiscusScoreExample.Criteria andScoreNumNotEqualTo(Integer value) {
            return notEqualTo(scoreNum, value);
        }

        public DiscusScoreExample.Criteria andScoreNumGreaterThan(Integer value) {
            return greaterThan(scoreNum, value);
        }

        public DiscusScoreExample.Criteria andScoreNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(scoreNum, value);
        }

        public DiscusScoreExample.Criteria andScoreNumLessThan(Integer value) {
            return lessThan(scoreNum, value);
        }

        public DiscusScoreExample.Criteria andScoreNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(scoreNum, value);
        }

        public DiscusScoreExample.Criteria andScoreNumIn(List<Integer> values) {
            return in(scoreNum, values);
        }

        public DiscusScoreExample.Criteria andScoreNumNotIn(List<Integer> values) {
            return notIn(scoreNum, values);
        }

        public DiscusScoreExample.Criteria andScoreNumBetween(Integer value1, Integer value2) {
            return between(scoreNum, value1, value2);
        }

        public DiscusScoreExample.Criteria andScoreNumNotBetween(Integer value1, Integer value2) {
            return notBetween(scoreNum, value1, value2);
        }
        public DiscusScoreExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DiscusScoreExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DiscusScoreExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DiscusScoreExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DiscusScoreExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DiscusScoreExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DiscusScoreExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DiscusScoreExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DiscusScoreExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DiscusScoreExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DiscusScoreExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DiscusScoreExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DiscusScoreExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public DiscusScoreExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public DiscusScoreExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public DiscusScoreExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public DiscusScoreExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public DiscusScoreExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public DiscusScoreExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public DiscusScoreExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public DiscusScoreExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public DiscusScoreExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public DiscusScoreExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public DiscusScoreExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}
