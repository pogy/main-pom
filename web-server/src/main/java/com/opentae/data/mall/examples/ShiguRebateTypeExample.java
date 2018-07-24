package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguRebateType;

import java.util.*;
public class ShiguRebateTypeExample extends SgExample<ShiguRebateTypeExample.Criteria> {
    public static final Class<ShiguRebateType> beanClass = ShiguRebateType.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn isDefault;
    public static EntityColumn typeAbridge;
    public static EntityColumn gmtUpdate;
    public static EntityColumn typeName;
    public static EntityColumn rebateNum;
    public static EntityColumn typeId;
    public static EntityColumn gmtCreate;
    public static EntityColumn isActive;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        isDefault = listMap.get("isDefault");
        typeAbridge = listMap.get("typeAbridge");
        gmtUpdate = listMap.get("gmtUpdate");
        typeName = listMap.get("typeName");
        rebateNum = listMap.get("rebateNum");
        typeId = listMap.get("typeId");
        gmtCreate = listMap.get("gmtCreate");
        isActive = listMap.get("isActive");
        }

    public ShiguRebateTypeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguRebateTypeExample.Criteria createCriteriaInternal() {
        return new ShiguRebateTypeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultIsNull() {
            return isNull(isDefault);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultIsNotNull() {
            return isNotNull(isDefault);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultEqualTo(Integer value) {
            return equalTo(isDefault, value);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultNotEqualTo(Integer value) {
            return notEqualTo(isDefault, value);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultGreaterThan(Integer value) {
            return greaterThan(isDefault, value);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isDefault, value);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultLessThan(Integer value) {
            return lessThan(isDefault, value);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isDefault, value);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultIn(List<Integer> values) {
            return in(isDefault, values);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultNotIn(List<Integer> values) {
            return notIn(isDefault, values);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultBetween(Integer value1, Integer value2) {
            return between(isDefault, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
            return notBetween(isDefault, value1, value2);
        }
        public ShiguRebateTypeExample.Criteria andTypeAbridgeIsNull() {
            return isNull(typeAbridge);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeIsNotNull() {
            return isNotNull(typeAbridge);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeEqualTo(String value) {
            return equalTo(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeNotEqualTo(String value) {
            return notEqualTo(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeGreaterThan(String value) {
            return greaterThan(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeLessThan(String value) {
            return lessThan(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeLike(String value) {
            return like(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeNotLike(String value) {
            return notLike(typeAbridge, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeIn(List<String> values) {
            return in(typeAbridge, values);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeNotIn(List<String> values) {
            return notIn(typeAbridge, values);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeBetween(String value1, String value2) {
            return between(typeAbridge, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andTypeAbridgeNotBetween(String value1, String value2) {
            return notBetween(typeAbridge, value1, value2);
        }
        public ShiguRebateTypeExample.Criteria andGmtUpdateIsNull() {
            return isNull(gmtUpdate);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateIsNotNull() {
            return isNotNull(gmtUpdate);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateEqualTo(Date value) {
            return equalTo(gmtUpdate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateNotEqualTo(Date value) {
            return notEqualTo(gmtUpdate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateGreaterThan(Date value) {
            return greaterThan(gmtUpdate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtUpdate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateLessThan(Date value) {
            return lessThan(gmtUpdate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtUpdate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateIn(List<Date> values) {
            return in(gmtUpdate, values);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateNotIn(List<Date> values) {
            return notIn(gmtUpdate, values);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateBetween(Date value1, Date value2) {
            return between(gmtUpdate, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andGmtUpdateNotBetween(Date value1, Date value2) {
            return notBetween(gmtUpdate, value1, value2);
        }
        public ShiguRebateTypeExample.Criteria andTypeNameIsNull() {
            return isNull(typeName);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameIsNotNull() {
            return isNotNull(typeName);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameEqualTo(String value) {
            return equalTo(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameNotEqualTo(String value) {
            return notEqualTo(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameGreaterThan(String value) {
            return greaterThan(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameLessThan(String value) {
            return lessThan(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameLike(String value) {
            return like(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameNotLike(String value) {
            return notLike(typeName, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameIn(List<String> values) {
            return in(typeName, values);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameNotIn(List<String> values) {
            return notIn(typeName, values);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameBetween(String value1, String value2) {
            return between(typeName, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andTypeNameNotBetween(String value1, String value2) {
            return notBetween(typeName, value1, value2);
        }
        public ShiguRebateTypeExample.Criteria andRebateNumIsNull() {
            return isNull(rebateNum);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumIsNotNull() {
            return isNotNull(rebateNum);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumEqualTo(Integer value) {
            return equalTo(rebateNum, value);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumNotEqualTo(Integer value) {
            return notEqualTo(rebateNum, value);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumGreaterThan(Integer value) {
            return greaterThan(rebateNum, value);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(rebateNum, value);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumLessThan(Integer value) {
            return lessThan(rebateNum, value);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(rebateNum, value);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumIn(List<Integer> values) {
            return in(rebateNum, values);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumNotIn(List<Integer> values) {
            return notIn(rebateNum, values);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumBetween(Integer value1, Integer value2) {
            return between(rebateNum, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andRebateNumNotBetween(Integer value1, Integer value2) {
            return notBetween(rebateNum, value1, value2);
        }
        public ShiguRebateTypeExample.Criteria andTypeIdIsNull() {
            return isNull(typeId);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdIsNotNull() {
            return isNotNull(typeId);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdEqualTo(Long value) {
            return equalTo(typeId, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdNotEqualTo(Long value) {
            return notEqualTo(typeId, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdGreaterThan(Long value) {
            return greaterThan(typeId, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(typeId, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdLessThan(Long value) {
            return lessThan(typeId, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(typeId, value);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdIn(List<Long> values) {
            return in(typeId, values);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdNotIn(List<Long> values) {
            return notIn(typeId, values);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdBetween(Long value1, Long value2) {
            return between(typeId, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andTypeIdNotBetween(Long value1, Long value2) {
            return notBetween(typeId, value1, value2);
        }
        public ShiguRebateTypeExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguRebateTypeExample.Criteria andIsActiveIsNull() {
            return isNull(isActive);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveIsNotNull() {
            return isNotNull(isActive);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveEqualTo(Integer value) {
            return equalTo(isActive, value);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveNotEqualTo(Integer value) {
            return notEqualTo(isActive, value);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveGreaterThan(Integer value) {
            return greaterThan(isActive, value);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isActive, value);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveLessThan(Integer value) {
            return lessThan(isActive, value);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isActive, value);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveIn(List<Integer> values) {
            return in(isActive, values);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveNotIn(List<Integer> values) {
            return notIn(isActive, values);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveBetween(Integer value1, Integer value2) {
            return between(isActive, value1, value2);
        }

        public ShiguRebateTypeExample.Criteria andIsActiveNotBetween(Integer value1, Integer value2) {
            return notBetween(isActive, value1, value2);
        }
    }
}