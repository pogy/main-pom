package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopFitmentModule;

import java.util.*;
public class ShopFitmentModuleExample extends SgExample<ShopFitmentModuleExample.Criteria> {
    public static final Class<ShopFitmentModule> beanClass = ShopFitmentModule.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn sideType;
    public static EntityColumn canDel;
    public static EntityColumn areaId;
    public static EntityColumn afterModuleId;
    public static EntityColumn moduleValue;
    public static EntityColumn moduleId;
    public static EntityColumn type;
    public static EntityColumn moduleData;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        sideType = listMap.get("sideType");
        canDel = listMap.get("canDel");
        areaId = listMap.get("areaId");
        afterModuleId = listMap.get("afterModuleId");
        moduleValue = listMap.get("moduleValue");
        moduleId = listMap.get("moduleId");
        type = listMap.get("type");
        moduleData = listMap.get("moduleData");
        }

    public ShopFitmentModuleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopFitmentModuleExample.Criteria createCriteriaInternal() {
        return new ShopFitmentModuleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeIsNull() {
            return isNull(sideType);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeIsNotNull() {
            return isNotNull(sideType);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeEqualTo(Integer value) {
            return equalTo(sideType, value);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeNotEqualTo(Integer value) {
            return notEqualTo(sideType, value);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeGreaterThan(Integer value) {
            return greaterThan(sideType, value);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sideType, value);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeLessThan(Integer value) {
            return lessThan(sideType, value);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sideType, value);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeIn(List<Integer> values) {
            return in(sideType, values);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeNotIn(List<Integer> values) {
            return notIn(sideType, values);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeBetween(Integer value1, Integer value2) {
            return between(sideType, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andSideTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(sideType, value1, value2);
        }
        public ShopFitmentModuleExample.Criteria andCanDelIsNull() {
            return isNull(canDel);
        }

        public ShopFitmentModuleExample.Criteria andCanDelIsNotNull() {
            return isNotNull(canDel);
        }

        public ShopFitmentModuleExample.Criteria andCanDelEqualTo(Boolean value) {
            return equalTo(canDel, value);
        }

        public ShopFitmentModuleExample.Criteria andCanDelNotEqualTo(Boolean value) {
            return notEqualTo(canDel, value);
        }

        public ShopFitmentModuleExample.Criteria andCanDelGreaterThan(Boolean value) {
            return greaterThan(canDel, value);
        }

        public ShopFitmentModuleExample.Criteria andCanDelGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(canDel, value);
        }

        public ShopFitmentModuleExample.Criteria andCanDelLessThan(Boolean value) {
            return lessThan(canDel, value);
        }

        public ShopFitmentModuleExample.Criteria andCanDelLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(canDel, value);
        }

        public ShopFitmentModuleExample.Criteria andCanDelIn(List<Boolean> values) {
            return in(canDel, values);
        }

        public ShopFitmentModuleExample.Criteria andCanDelNotIn(List<Boolean> values) {
            return notIn(canDel, values);
        }

        public ShopFitmentModuleExample.Criteria andCanDelBetween(Boolean value1, Boolean value2) {
            return between(canDel, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andCanDelNotBetween(Boolean value1, Boolean value2) {
            return notBetween(canDel, value1, value2);
        }
        public ShopFitmentModuleExample.Criteria andAreaIdIsNull() {
            return isNull(areaId);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdIsNotNull() {
            return isNotNull(areaId);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdEqualTo(Long value) {
            return equalTo(areaId, value);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdNotEqualTo(Long value) {
            return notEqualTo(areaId, value);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdGreaterThan(Long value) {
            return greaterThan(areaId, value);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(areaId, value);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdLessThan(Long value) {
            return lessThan(areaId, value);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(areaId, value);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdIn(List<Long> values) {
            return in(areaId, values);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdNotIn(List<Long> values) {
            return notIn(areaId, values);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdBetween(Long value1, Long value2) {
            return between(areaId, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andAreaIdNotBetween(Long value1, Long value2) {
            return notBetween(areaId, value1, value2);
        }
        public ShopFitmentModuleExample.Criteria andAfterModuleIdIsNull() {
            return isNull(afterModuleId);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdIsNotNull() {
            return isNotNull(afterModuleId);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdEqualTo(Long value) {
            return equalTo(afterModuleId, value);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdNotEqualTo(Long value) {
            return notEqualTo(afterModuleId, value);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdGreaterThan(Long value) {
            return greaterThan(afterModuleId, value);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterModuleId, value);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdLessThan(Long value) {
            return lessThan(afterModuleId, value);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterModuleId, value);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdIn(List<Long> values) {
            return in(afterModuleId, values);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdNotIn(List<Long> values) {
            return notIn(afterModuleId, values);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdBetween(Long value1, Long value2) {
            return between(afterModuleId, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andAfterModuleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterModuleId, value1, value2);
        }
        public ShopFitmentModuleExample.Criteria andModuleValueIsNull() {
            return isNull(moduleValue);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueIsNotNull() {
            return isNotNull(moduleValue);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueEqualTo(String value) {
            return equalTo(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotEqualTo(String value) {
            return notEqualTo(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueGreaterThan(String value) {
            return greaterThan(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueLessThan(String value) {
            return lessThan(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueLike(String value) {
            return like(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotLike(String value) {
            return notLike(moduleValue, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueIn(List<String> values) {
            return in(moduleValue, values);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotIn(List<String> values) {
            return notIn(moduleValue, values);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueBetween(String value1, String value2) {
            return between(moduleValue, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andModuleValueNotBetween(String value1, String value2) {
            return notBetween(moduleValue, value1, value2);
        }
        public ShopFitmentModuleExample.Criteria andModuleIdIsNull() {
            return isNull(moduleId);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdIsNotNull() {
            return isNotNull(moduleId);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdEqualTo(Long value) {
            return equalTo(moduleId, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdNotEqualTo(Long value) {
            return notEqualTo(moduleId, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdGreaterThan(Long value) {
            return greaterThan(moduleId, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(moduleId, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdLessThan(Long value) {
            return lessThan(moduleId, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(moduleId, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdIn(List<Long> values) {
            return in(moduleId, values);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdNotIn(List<Long> values) {
            return notIn(moduleId, values);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdBetween(Long value1, Long value2) {
            return between(moduleId, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andModuleIdNotBetween(Long value1, Long value2) {
            return notBetween(moduleId, value1, value2);
        }
        public ShopFitmentModuleExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShopFitmentModuleExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShopFitmentModuleExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShopFitmentModuleExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShopFitmentModuleExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShopFitmentModuleExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShopFitmentModuleExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShopFitmentModuleExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShopFitmentModuleExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShopFitmentModuleExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShopFitmentModuleExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ShopFitmentModuleExample.Criteria andModuleDataIsNull() {
            return isNull(moduleData);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataIsNotNull() {
            return isNotNull(moduleData);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataEqualTo(String value) {
            return equalTo(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotEqualTo(String value) {
            return notEqualTo(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataGreaterThan(String value) {
            return greaterThan(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataLessThan(String value) {
            return lessThan(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataLike(String value) {
            return like(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotLike(String value) {
            return notLike(moduleData, value);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataIn(List<String> values) {
            return in(moduleData, values);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotIn(List<String> values) {
            return notIn(moduleData, values);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataBetween(String value1, String value2) {
            return between(moduleData, value1, value2);
        }

        public ShopFitmentModuleExample.Criteria andModuleDataNotBetween(String value1, String value2) {
            return notBetween(moduleData, value1, value2);
        }
    }
}