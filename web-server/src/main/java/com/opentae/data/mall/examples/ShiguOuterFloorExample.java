package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguOuterFloor;

import java.util.*;
public class ShiguOuterFloorExample extends SgExample<ShiguOuterFloorExample.Criteria> {
    public static final Class<ShiguOuterFloor> beanClass = ShiguOuterFloor.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn addedShop;
    public static EntityColumn showName;
    public static EntityColumn outerFloorId;
    public static EntityColumn parentStyleIds;
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
        parentStyleIds = listMap.get("parentStyleIds");
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
    protected ShiguOuterFloorExample.Criteria createCriteriaInternal() {
        return new ShiguOuterFloorExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopIsNull() {
            return isNull(addedShop);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopIsNotNull() {
            return isNotNull(addedShop);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopEqualTo(String value) {
            return equalTo(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotEqualTo(String value) {
            return notEqualTo(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopGreaterThan(String value) {
            return greaterThan(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopLessThan(String value) {
            return lessThan(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopLike(String value) {
            return like(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotLike(String value) {
            return notLike(addedShop, value);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopIn(List<String> values) {
            return in(addedShop, values);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotIn(List<String> values) {
            return notIn(addedShop, values);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopBetween(String value1, String value2) {
            return between(addedShop, value1, value2);
        }

        public ShiguOuterFloorExample.Criteria andAddedShopNotBetween(String value1, String value2) {
            return notBetween(addedShop, value1, value2);
        }
        public ShiguOuterFloorExample.Criteria andShowNameIsNull() {
            return isNull(showName);
        }

        public ShiguOuterFloorExample.Criteria andShowNameIsNotNull() {
            return isNotNull(showName);
        }

        public ShiguOuterFloorExample.Criteria andShowNameEqualTo(String value) {
            return equalTo(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotEqualTo(String value) {
            return notEqualTo(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameGreaterThan(String value) {
            return greaterThan(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameLessThan(String value) {
            return lessThan(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameLike(String value) {
            return like(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotLike(String value) {
            return notLike(showName, value);
        }

        public ShiguOuterFloorExample.Criteria andShowNameIn(List<String> values) {
            return in(showName, values);
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotIn(List<String> values) {
            return notIn(showName, values);
        }

        public ShiguOuterFloorExample.Criteria andShowNameBetween(String value1, String value2) {
            return between(showName, value1, value2);
        }

        public ShiguOuterFloorExample.Criteria andShowNameNotBetween(String value1, String value2) {
            return notBetween(showName, value1, value2);
        }
        public ShiguOuterFloorExample.Criteria andOuterFloorIdIsNull() {
            return isNull(outerFloorId);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdIsNotNull() {
            return isNotNull(outerFloorId);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdEqualTo(Long value) {
            return equalTo(outerFloorId, value);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdNotEqualTo(Long value) {
            return notEqualTo(outerFloorId, value);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdGreaterThan(Long value) {
            return greaterThan(outerFloorId, value);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(outerFloorId, value);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdLessThan(Long value) {
            return lessThan(outerFloorId, value);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(outerFloorId, value);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdIn(List<Long> values) {
            return in(outerFloorId, values);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdNotIn(List<Long> values) {
            return notIn(outerFloorId, values);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdBetween(Long value1, Long value2) {
            return between(outerFloorId, value1, value2);
        }

        public ShiguOuterFloorExample.Criteria andOuterFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(outerFloorId, value1, value2);
        }
        public ShiguOuterFloorExample.Criteria andParentStyleIdsIsNull() {
            return isNull(parentStyleIds);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsIsNotNull() {
            return isNotNull(parentStyleIds);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsEqualTo(String value) {
            return equalTo(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsNotEqualTo(String value) {
            return notEqualTo(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsGreaterThan(String value) {
            return greaterThan(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsLessThan(String value) {
            return lessThan(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsLike(String value) {
            return like(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsNotLike(String value) {
            return notLike(parentStyleIds, value);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsIn(List<String> values) {
            return in(parentStyleIds, values);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsNotIn(List<String> values) {
            return notIn(parentStyleIds, values);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsBetween(String value1, String value2) {
            return between(parentStyleIds, value1, value2);
        }

        public ShiguOuterFloorExample.Criteria andParentStyleIdsNotBetween(String value1, String value2) {
            return notBetween(parentStyleIds, value1, value2);
        }
        public ShiguOuterFloorExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderEqualTo(Integer value) {
            return equalTo(sortOrder, value);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderNotEqualTo(Integer value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderGreaterThan(Integer value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderLessThan(Integer value) {
            return lessThan(sortOrder, value);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderIn(List<Integer> values) {
            return in(sortOrder, values);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderNotIn(List<Integer> values) {
            return notIn(sortOrder, values);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguOuterFloorExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguOuterFloorExample.Criteria andFloorIdsIsNull() {
            return isNull(floorIds);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsIsNotNull() {
            return isNotNull(floorIds);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsEqualTo(String value) {
            return equalTo(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotEqualTo(String value) {
            return notEqualTo(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsGreaterThan(String value) {
            return greaterThan(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsLessThan(String value) {
            return lessThan(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsLike(String value) {
            return like(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotLike(String value) {
            return notLike(floorIds, value);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsIn(List<String> values) {
            return in(floorIds, values);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotIn(List<String> values) {
            return notIn(floorIds, values);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsBetween(String value1, String value2) {
            return between(floorIds, value1, value2);
        }

        public ShiguOuterFloorExample.Criteria andFloorIdsNotBetween(String value1, String value2) {
            return notBetween(floorIds, value1, value2);
        }
    }
}