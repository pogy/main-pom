package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguOuterMarket;

import java.util.*;
public class ShiguOuterMarketExample extends SgExample<ShiguOuterMarketExample.Criteria> {
    public static final Class<ShiguOuterMarket> beanClass = ShiguOuterMarket.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn marketName;
    public static EntityColumn pointMarketName;
    public static EntityColumn outerFloorIds;
    public static EntityColumn sortOrder;
    public static EntityColumn ruleId;
    public static EntityColumn markerShow;
    public static EntityColumn marketId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        marketName = listMap.get("marketName");
        pointMarketName = listMap.get("pointMarketName");
        outerFloorIds = listMap.get("outerFloorIds");
        sortOrder = listMap.get("sortOrder");
        ruleId = listMap.get("ruleId");
        marketId = listMap.get("marketId");
        markerShow = listMap.get("markerShow");
        }

    public ShiguOuterMarketExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguOuterMarketExample.Criteria createCriteriaInternal() {
        return new ShiguOuterMarketExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andMarkerShowEqualTo(Integer value) {
            return equalTo(markerShow, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguOuterMarketExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public ShiguOuterMarketExample.Criteria andPointMarketNameIsNull() {
            return isNull(pointMarketName);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameIsNotNull() {
            return isNotNull(pointMarketName);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameEqualTo(String value) {
            return equalTo(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameNotEqualTo(String value) {
            return notEqualTo(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameGreaterThan(String value) {
            return greaterThan(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameLessThan(String value) {
            return lessThan(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameLike(String value) {
            return like(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameNotLike(String value) {
            return notLike(pointMarketName, value);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameIn(List<String> values) {
            return in(pointMarketName, values);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameNotIn(List<String> values) {
            return notIn(pointMarketName, values);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameBetween(String value1, String value2) {
            return between(pointMarketName, value1, value2);
        }

        public ShiguOuterMarketExample.Criteria andPointMarketNameNotBetween(String value1, String value2) {
            return notBetween(pointMarketName, value1, value2);
        }
        public ShiguOuterMarketExample.Criteria andOuterFloorIdsIsNull() {
            return isNull(outerFloorIds);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsIsNotNull() {
            return isNotNull(outerFloorIds);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsEqualTo(String value) {
            return equalTo(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotEqualTo(String value) {
            return notEqualTo(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsGreaterThan(String value) {
            return greaterThan(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsLessThan(String value) {
            return lessThan(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsLike(String value) {
            return like(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotLike(String value) {
            return notLike(outerFloorIds, value);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsIn(List<String> values) {
            return in(outerFloorIds, values);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotIn(List<String> values) {
            return notIn(outerFloorIds, values);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsBetween(String value1, String value2) {
            return between(outerFloorIds, value1, value2);
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotBetween(String value1, String value2) {
            return notBetween(outerFloorIds, value1, value2);
        }
        public ShiguOuterMarketExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderEqualTo(Integer value) {
            return equalTo(sortOrder, value);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderNotEqualTo(Integer value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderGreaterThan(Integer value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderLessThan(Integer value) {
            return lessThan(sortOrder, value);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderIn(List<Integer> values) {
            return in(sortOrder, values);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderNotIn(List<Integer> values) {
            return notIn(sortOrder, values);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguOuterMarketExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguOuterMarketExample.Criteria andRuleIdIsNull() {
            return isNull(ruleId);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdIsNotNull() {
            return isNotNull(ruleId);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdEqualTo(Long value) {
            return equalTo(ruleId, value);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdNotEqualTo(Long value) {
            return notEqualTo(ruleId, value);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdGreaterThan(Long value) {
            return greaterThan(ruleId, value);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ruleId, value);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdLessThan(Long value) {
            return lessThan(ruleId, value);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ruleId, value);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdIn(List<Long> values) {
            return in(ruleId, values);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdNotIn(List<Long> values) {
            return notIn(ruleId, values);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            return between(ruleId, value1, value2);
        }

        public ShiguOuterMarketExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            return notBetween(ruleId, value1, value2);
        }
        public ShiguOuterMarketExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguOuterMarketExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
    }
}
