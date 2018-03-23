package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguOuterMarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andMarkerShowEqualTo(Integer value) {
            return equalTo(markerShow, value);
        }

        public Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public Criteria andPointMarketNameIsNull() {
            return isNull(pointMarketName);
        }

        public Criteria andPointMarketNameIsNotNull() {
            return isNotNull(pointMarketName);
        }

        public Criteria andPointMarketNameEqualTo(String value) {
            return equalTo(pointMarketName, value);
        }

        public Criteria andPointMarketNameNotEqualTo(String value) {
            return notEqualTo(pointMarketName, value);
        }

        public Criteria andPointMarketNameGreaterThan(String value) {
            return greaterThan(pointMarketName, value);
        }

        public Criteria andPointMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(pointMarketName, value);
        }

        public Criteria andPointMarketNameLessThan(String value) {
            return lessThan(pointMarketName, value);
        }

        public Criteria andPointMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(pointMarketName, value);
        }

        public Criteria andPointMarketNameLike(String value) {
            return like(pointMarketName, value);
        }

        public Criteria andPointMarketNameNotLike(String value) {
            return notLike(pointMarketName, value);
        }

        public Criteria andPointMarketNameIn(List<String> values) {
            return in(pointMarketName, values);
        }

        public Criteria andPointMarketNameNotIn(List<String> values) {
            return notIn(pointMarketName, values);
        }

        public Criteria andPointMarketNameBetween(String value1, String value2) {
            return between(pointMarketName, value1, value2);
        }

        public Criteria andPointMarketNameNotBetween(String value1, String value2) {
            return notBetween(pointMarketName, value1, value2);
        }
        public Criteria andOuterFloorIdsIsNull() {
            return isNull(outerFloorIds);
        }

        public Criteria andOuterFloorIdsIsNotNull() {
            return isNotNull(outerFloorIds);
        }

        public Criteria andOuterFloorIdsEqualTo(String value) {
            return equalTo(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsNotEqualTo(String value) {
            return notEqualTo(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsGreaterThan(String value) {
            return greaterThan(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsLessThan(String value) {
            return lessThan(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsLike(String value) {
            return like(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsNotLike(String value) {
            return notLike(outerFloorIds, value);
        }

        public Criteria andOuterFloorIdsIn(List<String> values) {
            return in(outerFloorIds, values);
        }

        public Criteria andOuterFloorIdsNotIn(List<String> values) {
            return notIn(outerFloorIds, values);
        }

        public Criteria andOuterFloorIdsBetween(String value1, String value2) {
            return between(outerFloorIds, value1, value2);
        }

        public Criteria andOuterFloorIdsNotBetween(String value1, String value2) {
            return notBetween(outerFloorIds, value1, value2);
        }
        public Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public Criteria andSortOrderEqualTo(Integer value) {
            return equalTo(sortOrder, value);
        }

        public Criteria andSortOrderNotEqualTo(Integer value) {
            return notEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderGreaterThan(Integer value) {
            return greaterThan(sortOrder, value);
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderLessThan(Integer value) {
            return lessThan(sortOrder, value);
        }

        public Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderIn(List<Integer> values) {
            return in(sortOrder, values);
        }

        public Criteria andSortOrderNotIn(List<Integer> values) {
            return notIn(sortOrder, values);
        }

        public Criteria andSortOrderBetween(Integer value1, Integer value2) {
            return between(sortOrder, value1, value2);
        }

        public Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public Criteria andRuleIdIsNull() {
            return isNull(ruleId);
        }

        public Criteria andRuleIdIsNotNull() {
            return isNotNull(ruleId);
        }

        public Criteria andRuleIdEqualTo(Long value) {
            return equalTo(ruleId, value);
        }

        public Criteria andRuleIdNotEqualTo(Long value) {
            return notEqualTo(ruleId, value);
        }

        public Criteria andRuleIdGreaterThan(Long value) {
            return greaterThan(ruleId, value);
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ruleId, value);
        }

        public Criteria andRuleIdLessThan(Long value) {
            return lessThan(ruleId, value);
        }

        public Criteria andRuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ruleId, value);
        }

        public Criteria andRuleIdIn(List<Long> values) {
            return in(ruleId, values);
        }

        public Criteria andRuleIdNotIn(List<Long> values) {
            return notIn(ruleId, values);
        }

        public Criteria andRuleIdBetween(Long value1, Long value2) {
            return between(ruleId, value1, value2);
        }

        public Criteria andRuleIdNotBetween(Long value1, Long value2) {
            return notBetween(ruleId, value1, value2);
        }
        public Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
    }
}
