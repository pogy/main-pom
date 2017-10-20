package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguOuterFloor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShiguOuterFloorExample extends SgExample<ShiguOuterFloorExample.Criteria> {
    public static final Class<ShiguOuterFloor> beanClass = ShiguOuterFloor.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn addedShop;
    public static EntityColumn showName;
    public static EntityColumn outerFloorId;
    public static EntityColumn floorNames;
    public static EntityColumn sortOrder;
    public static EntityColumn floorIds;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        addedShop = listMap.get("addedShop");
        showName = listMap.get("showName");
        outerFloorId = listMap.get("outerFloorId");
        floorNames = listMap.get("floorNames");
        sortOrder = listMap.get("sortOrder");
        floorIds = listMap.get("floorIds");
        }

    public ShiguOuterFloorExample() {
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

        public Criteria andAddedShopIsNull() {
            return isNull(addedShop);
        }

        public Criteria andAddedShopIsNotNull() {
            return isNotNull(addedShop);
        }

        public Criteria andAddedShopEqualTo(String value) {
            return equalTo(addedShop, value);
        }

        public Criteria andAddedShopNotEqualTo(String value) {
            return notEqualTo(addedShop, value);
        }

        public Criteria andAddedShopGreaterThan(String value) {
            return greaterThan(addedShop, value);
        }

        public Criteria andAddedShopGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(addedShop, value);
        }

        public Criteria andAddedShopLessThan(String value) {
            return lessThan(addedShop, value);
        }

        public Criteria andAddedShopLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(addedShop, value);
        }

        public Criteria andAddedShopLike(String value) {
            return like(addedShop, value);
        }

        public Criteria andAddedShopNotLike(String value) {
            return notLike(addedShop, value);
        }

        public Criteria andAddedShopIn(List<String> values) {
            return in(addedShop, values);
        }

        public Criteria andAddedShopNotIn(List<String> values) {
            return notIn(addedShop, values);
        }

        public Criteria andAddedShopBetween(String value1, String value2) {
            return between(addedShop, value1, value2);
        }

        public Criteria andAddedShopNotBetween(String value1, String value2) {
            return notBetween(addedShop, value1, value2);
        }
        public Criteria andShowNameIsNull() {
            return isNull(showName);
        }

        public Criteria andShowNameIsNotNull() {
            return isNotNull(showName);
        }

        public Criteria andShowNameEqualTo(String value) {
            return equalTo(showName, value);
        }

        public Criteria andShowNameNotEqualTo(String value) {
            return notEqualTo(showName, value);
        }

        public Criteria andShowNameGreaterThan(String value) {
            return greaterThan(showName, value);
        }

        public Criteria andShowNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(showName, value);
        }

        public Criteria andShowNameLessThan(String value) {
            return lessThan(showName, value);
        }

        public Criteria andShowNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(showName, value);
        }

        public Criteria andShowNameLike(String value) {
            return like(showName, value);
        }

        public Criteria andShowNameNotLike(String value) {
            return notLike(showName, value);
        }

        public Criteria andShowNameIn(List<String> values) {
            return in(showName, values);
        }

        public Criteria andShowNameNotIn(List<String> values) {
            return notIn(showName, values);
        }

        public Criteria andShowNameBetween(String value1, String value2) {
            return between(showName, value1, value2);
        }

        public Criteria andShowNameNotBetween(String value1, String value2) {
            return notBetween(showName, value1, value2);
        }
        public Criteria andOuterFloorIdIsNull() {
            return isNull(outerFloorId);
        }

        public Criteria andOuterFloorIdIsNotNull() {
            return isNotNull(outerFloorId);
        }

        public Criteria andOuterFloorIdEqualTo(Long value) {
            return equalTo(outerFloorId, value);
        }

        public Criteria andOuterFloorIdNotEqualTo(Long value) {
            return notEqualTo(outerFloorId, value);
        }

        public Criteria andOuterFloorIdGreaterThan(Long value) {
            return greaterThan(outerFloorId, value);
        }

        public Criteria andOuterFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(outerFloorId, value);
        }

        public Criteria andOuterFloorIdLessThan(Long value) {
            return lessThan(outerFloorId, value);
        }

        public Criteria andOuterFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(outerFloorId, value);
        }

        public Criteria andOuterFloorIdIn(List<Long> values) {
            return in(outerFloorId, values);
        }

        public Criteria andOuterFloorIdNotIn(List<Long> values) {
            return notIn(outerFloorId, values);
        }

        public Criteria andOuterFloorIdBetween(Long value1, Long value2) {
            return between(outerFloorId, value1, value2);
        }

        public Criteria andOuterFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(outerFloorId, value1, value2);
        }
        public Criteria andFloorNamesIsNull() {
            return isNull(floorNames);
        }

        public Criteria andFloorNamesIsNotNull() {
            return isNotNull(floorNames);
        }

        public Criteria andFloorNamesEqualTo(String value) {
            return equalTo(floorNames, value);
        }

        public Criteria andFloorNamesNotEqualTo(String value) {
            return notEqualTo(floorNames, value);
        }

        public Criteria andFloorNamesGreaterThan(String value) {
            return greaterThan(floorNames, value);
        }

        public Criteria andFloorNamesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorNames, value);
        }

        public Criteria andFloorNamesLessThan(String value) {
            return lessThan(floorNames, value);
        }

        public Criteria andFloorNamesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorNames, value);
        }

        public Criteria andFloorNamesLike(String value) {
            return like(floorNames, value);
        }

        public Criteria andFloorNamesNotLike(String value) {
            return notLike(floorNames, value);
        }

        public Criteria andFloorNamesIn(List<String> values) {
            return in(floorNames, values);
        }

        public Criteria andFloorNamesNotIn(List<String> values) {
            return notIn(floorNames, values);
        }

        public Criteria andFloorNamesBetween(String value1, String value2) {
            return between(floorNames, value1, value2);
        }

        public Criteria andFloorNamesNotBetween(String value1, String value2) {
            return notBetween(floorNames, value1, value2);
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
        public Criteria andFloorIdsIsNull() {
            return isNull(floorIds);
        }

        public Criteria andFloorIdsIsNotNull() {
            return isNotNull(floorIds);
        }

        public Criteria andFloorIdsEqualTo(String value) {
            return equalTo(floorIds, value);
        }

        public Criteria andFloorIdsNotEqualTo(String value) {
            return notEqualTo(floorIds, value);
        }

        public Criteria andFloorIdsGreaterThan(String value) {
            return greaterThan(floorIds, value);
        }

        public Criteria andFloorIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorIds, value);
        }

        public Criteria andFloorIdsLessThan(String value) {
            return lessThan(floorIds, value);
        }

        public Criteria andFloorIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorIds, value);
        }

        public Criteria andFloorIdsLike(String value) {
            return like(floorIds, value);
        }

        public Criteria andFloorIdsNotLike(String value) {
            return notLike(floorIds, value);
        }

        public Criteria andFloorIdsIn(List<String> values) {
            return in(floorIds, values);
        }

        public Criteria andFloorIdsNotIn(List<String> values) {
            return notIn(floorIds, values);
        }

        public Criteria andFloorIdsBetween(String value1, String value2) {
            return between(floorIds, value1, value2);
        }

        public Criteria andFloorIdsNotBetween(String value1, String value2) {
            return notBetween(floorIds, value1, value2);
        }
    }
}
