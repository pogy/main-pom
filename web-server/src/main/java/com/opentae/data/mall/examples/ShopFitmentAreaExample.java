package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopFitmentArea;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShopFitmentAreaExample extends SgExample<ShopFitmentAreaExample.Criteria> {
    public static final Class<ShopFitmentArea> beanClass = ShopFitmentArea.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn canDel;
    public static EntityColumn areaId;
    public static EntityColumn areaType;
    public static EntityColumn shopId;
    public static EntityColumn pageId;
    public static EntityColumn afterAreaId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        canDel = listMap.get("canDel");
        areaId = listMap.get("areaId");
        areaType = listMap.get("areaType");
        shopId = listMap.get("shopId");
        pageId = listMap.get("pageId");
        afterAreaId = listMap.get("afterAreaId");
        }

    public ShopFitmentAreaExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopFitmentAreaExample.Criteria createCriteriaInternal() {
        return new ShopFitmentAreaExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopFitmentAreaExample.Criteria andCanDelIsNull() {
            return isNull(canDel);
        }

        public ShopFitmentAreaExample.Criteria andCanDelIsNotNull() {
            return isNotNull(canDel);
        }

        public ShopFitmentAreaExample.Criteria andCanDelEqualTo(Boolean value) {
            return equalTo(canDel, value);
        }

        public ShopFitmentAreaExample.Criteria andCanDelNotEqualTo(Boolean value) {
            return notEqualTo(canDel, value);
        }

        public ShopFitmentAreaExample.Criteria andCanDelGreaterThan(Boolean value) {
            return greaterThan(canDel, value);
        }

        public ShopFitmentAreaExample.Criteria andCanDelGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(canDel, value);
        }

        public ShopFitmentAreaExample.Criteria andCanDelLessThan(Boolean value) {
            return lessThan(canDel, value);
        }

        public ShopFitmentAreaExample.Criteria andCanDelLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(canDel, value);
        }

        public ShopFitmentAreaExample.Criteria andCanDelIn(List<Boolean> values) {
            return in(canDel, values);
        }

        public ShopFitmentAreaExample.Criteria andCanDelNotIn(List<Boolean> values) {
            return notIn(canDel, values);
        }

        public ShopFitmentAreaExample.Criteria andCanDelBetween(Boolean value1, Boolean value2) {
            return between(canDel, value1, value2);
        }

        public ShopFitmentAreaExample.Criteria andCanDelNotBetween(Boolean value1, Boolean value2) {
            return notBetween(canDel, value1, value2);
        }
        public ShopFitmentAreaExample.Criteria andAreaIdIsNull() {
            return isNull(areaId);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdIsNotNull() {
            return isNotNull(areaId);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdEqualTo(Long value) {
            return equalTo(areaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdNotEqualTo(Long value) {
            return notEqualTo(areaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdGreaterThan(Long value) {
            return greaterThan(areaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(areaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdLessThan(Long value) {
            return lessThan(areaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(areaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdIn(List<Long> values) {
            return in(areaId, values);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdNotIn(List<Long> values) {
            return notIn(areaId, values);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdBetween(Long value1, Long value2) {
            return between(areaId, value1, value2);
        }

        public ShopFitmentAreaExample.Criteria andAreaIdNotBetween(Long value1, Long value2) {
            return notBetween(areaId, value1, value2);
        }
        public ShopFitmentAreaExample.Criteria andAreaTypeIsNull() {
            return isNull(areaType);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeIsNotNull() {
            return isNotNull(areaType);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeEqualTo(Integer value) {
            return equalTo(areaType, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeNotEqualTo(Integer value) {
            return notEqualTo(areaType, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeGreaterThan(Integer value) {
            return greaterThan(areaType, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(areaType, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeLessThan(Integer value) {
            return lessThan(areaType, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(areaType, value);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeIn(List<Integer> values) {
            return in(areaType, values);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeNotIn(List<Integer> values) {
            return notIn(areaType, values);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeBetween(Integer value1, Integer value2) {
            return between(areaType, value1, value2);
        }

        public ShopFitmentAreaExample.Criteria andAreaTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(areaType, value1, value2);
        }
        public ShopFitmentAreaExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShopFitmentAreaExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShopFitmentAreaExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShopFitmentAreaExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShopFitmentAreaExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShopFitmentAreaExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShopFitmentAreaExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShopFitmentAreaExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShopFitmentAreaExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShopFitmentAreaExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShopFitmentAreaExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShopFitmentAreaExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShopFitmentAreaExample.Criteria andPageIdIsNull() {
            return isNull(pageId);
        }

        public ShopFitmentAreaExample.Criteria andPageIdIsNotNull() {
            return isNotNull(pageId);
        }

        public ShopFitmentAreaExample.Criteria andPageIdEqualTo(Long value) {
            return equalTo(pageId, value);
        }

        public ShopFitmentAreaExample.Criteria andPageIdNotEqualTo(Long value) {
            return notEqualTo(pageId, value);
        }

        public ShopFitmentAreaExample.Criteria andPageIdGreaterThan(Long value) {
            return greaterThan(pageId, value);
        }

        public ShopFitmentAreaExample.Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pageId, value);
        }

        public ShopFitmentAreaExample.Criteria andPageIdLessThan(Long value) {
            return lessThan(pageId, value);
        }

        public ShopFitmentAreaExample.Criteria andPageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pageId, value);
        }

        public ShopFitmentAreaExample.Criteria andPageIdIn(List<Long> values) {
            return in(pageId, values);
        }

        public ShopFitmentAreaExample.Criteria andPageIdNotIn(List<Long> values) {
            return notIn(pageId, values);
        }

        public ShopFitmentAreaExample.Criteria andPageIdBetween(Long value1, Long value2) {
            return between(pageId, value1, value2);
        }

        public ShopFitmentAreaExample.Criteria andPageIdNotBetween(Long value1, Long value2) {
            return notBetween(pageId, value1, value2);
        }
        public ShopFitmentAreaExample.Criteria andAfterAreaIdIsNull() {
            return isNull(afterAreaId);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdIsNotNull() {
            return isNotNull(afterAreaId);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdEqualTo(Long value) {
            return equalTo(afterAreaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdNotEqualTo(Long value) {
            return notEqualTo(afterAreaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdGreaterThan(Long value) {
            return greaterThan(afterAreaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterAreaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdLessThan(Long value) {
            return lessThan(afterAreaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterAreaId, value);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdIn(List<Long> values) {
            return in(afterAreaId, values);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdNotIn(List<Long> values) {
            return notIn(afterAreaId, values);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdBetween(Long value1, Long value2) {
            return between(afterAreaId, value1, value2);
        }

        public ShopFitmentAreaExample.Criteria andAfterAreaIdNotBetween(Long value1, Long value2) {
            return notBetween(afterAreaId, value1, value2);
        }
    }
}
