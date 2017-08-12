package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DataDictionarySet;

import java.util.*;
public class DataDictionarySetExample extends SgExample<DataDictionarySetExample.Criteria> {
    public static final Class<DataDictionarySet> beanClass = DataDictionarySet.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dataDictionaryId;
    public static EntityColumn useType;
    public static EntityColumn serviceId;
    public static EntityColumn dataDictionaryName;
    public static EntityColumn dataDictionaryType;
    public static EntityColumn dataDictionaryKey;
    public static EntityColumn dataDictionaryRemark;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dataDictionaryId = listMap.get("dataDictionaryId");
        useType = listMap.get("useType");
        serviceId = listMap.get("serviceId");
        dataDictionaryName = listMap.get("dataDictionaryName");
        dataDictionaryType = listMap.get("dataDictionaryType");
        dataDictionaryKey = listMap.get("dataDictionaryKey");
        dataDictionaryRemark = listMap.get("dataDictionaryRemark");
    }

    public DataDictionarySetExample() {
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

        public Criteria andDataDictionaryIdIsNull() {
            return isNull(dataDictionaryId);
        }

        public Criteria andDataDictionaryIdIsNotNull() {
            return isNotNull(dataDictionaryId);
        }

        public Criteria andDataDictionaryIdEqualTo(Long value) {
            return equalTo(dataDictionaryId, value);
        }

        public Criteria andDataDictionaryIdNotEqualTo(Long value) {
            return notEqualTo(dataDictionaryId, value);
        }

        public Criteria andDataDictionaryIdGreaterThan(Long value) {
            return greaterThan(dataDictionaryId, value);
        }

        public Criteria andDataDictionaryIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dataDictionaryId, value);
        }

        public Criteria andDataDictionaryIdLessThan(Long value) {
            return lessThan(dataDictionaryId, value);
        }

        public Criteria andDataDictionaryIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dataDictionaryId, value);
        }

        public Criteria andDataDictionaryIdIn(List<Long> values) {
            return in(dataDictionaryId, values);
        }

        public Criteria andDataDictionaryIdNotIn(List<Long> values) {
            return notIn(dataDictionaryId, values);
        }

        public Criteria andDataDictionaryIdBetween(Long value1, Long value2) {
            return between(dataDictionaryId, value1, value2);
        }

        public Criteria andDataDictionaryIdNotBetween(Long value1, Long value2) {
            return notBetween(dataDictionaryId, value1, value2);
        }
        public Criteria andUseTypeIsNull() {
            return isNull(useType);
        }

        public Criteria andUseTypeIsNotNull() {
            return isNotNull(useType);
        }

        public Criteria andUseTypeEqualTo(String value) {
            return equalTo(useType, value);
        }

        public Criteria andUseTypeNotEqualTo(String value) {
            return notEqualTo(useType, value);
        }

        public Criteria andUseTypeGreaterThan(String value) {
            return greaterThan(useType, value);
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(useType, value);
        }

        public Criteria andUseTypeLessThan(String value) {
            return lessThan(useType, value);
        }

        public Criteria andUseTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(useType, value);
        }

        public Criteria andUseTypeLike(String value) {
            return like(useType, value);
        }

        public Criteria andUseTypeNotLike(String value) {
            return notLike(useType, value);
        }

        public Criteria andUseTypeIn(List<String> values) {
            return in(useType, values);
        }

        public Criteria andUseTypeNotIn(List<String> values) {
            return notIn(useType, values);
        }

        public Criteria andUseTypeBetween(String value1, String value2) {
            return between(useType, value1, value2);
        }

        public Criteria andUseTypeNotBetween(String value1, String value2) {
            return notBetween(useType, value1, value2);
        }
        public Criteria andServiceIdIsNull() {
            return isNull(serviceId);
        }

        public Criteria andServiceIdIsNotNull() {
            return isNotNull(serviceId);
        }

        public Criteria andServiceIdEqualTo(Long value) {
            return equalTo(serviceId, value);
        }

        public Criteria andServiceIdNotEqualTo(Long value) {
            return notEqualTo(serviceId, value);
        }

        public Criteria andServiceIdGreaterThan(Long value) {
            return greaterThan(serviceId, value);
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(serviceId, value);
        }

        public Criteria andServiceIdLessThan(Long value) {
            return lessThan(serviceId, value);
        }

        public Criteria andServiceIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(serviceId, value);
        }

        public Criteria andServiceIdIn(List<Long> values) {
            return in(serviceId, values);
        }

        public Criteria andServiceIdNotIn(List<Long> values) {
            return notIn(serviceId, values);
        }

        public Criteria andServiceIdBetween(Long value1, Long value2) {
            return between(serviceId, value1, value2);
        }

        public Criteria andServiceIdNotBetween(Long value1, Long value2) {
            return notBetween(serviceId, value1, value2);
        }
        public Criteria andDataDictionaryNameIsNull() {
            return isNull(dataDictionaryName);
        }

        public Criteria andDataDictionaryNameIsNotNull() {
            return isNotNull(dataDictionaryName);
        }

        public Criteria andDataDictionaryNameEqualTo(String value) {
            return equalTo(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameNotEqualTo(String value) {
            return notEqualTo(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameGreaterThan(String value) {
            return greaterThan(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameLessThan(String value) {
            return lessThan(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameLike(String value) {
            return like(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameNotLike(String value) {
            return notLike(dataDictionaryName, value);
        }

        public Criteria andDataDictionaryNameIn(List<String> values) {
            return in(dataDictionaryName, values);
        }

        public Criteria andDataDictionaryNameNotIn(List<String> values) {
            return notIn(dataDictionaryName, values);
        }

        public Criteria andDataDictionaryNameBetween(String value1, String value2) {
            return between(dataDictionaryName, value1, value2);
        }

        public Criteria andDataDictionaryNameNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryName, value1, value2);
        }
        public Criteria andDataDictionaryTypeIsNull() {
            return isNull(dataDictionaryType);
        }

        public Criteria andDataDictionaryTypeIsNotNull() {
            return isNotNull(dataDictionaryType);
        }

        public Criteria andDataDictionaryTypeEqualTo(String value) {
            return equalTo(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeNotEqualTo(String value) {
            return notEqualTo(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeGreaterThan(String value) {
            return greaterThan(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeLessThan(String value) {
            return lessThan(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeLike(String value) {
            return like(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeNotLike(String value) {
            return notLike(dataDictionaryType, value);
        }

        public Criteria andDataDictionaryTypeIn(List<String> values) {
            return in(dataDictionaryType, values);
        }

        public Criteria andDataDictionaryTypeNotIn(List<String> values) {
            return notIn(dataDictionaryType, values);
        }

        public Criteria andDataDictionaryTypeBetween(String value1, String value2) {
            return between(dataDictionaryType, value1, value2);
        }

        public Criteria andDataDictionaryTypeNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryType, value1, value2);
        }
        public Criteria andDataDictionaryKeyIsNull() {
            return isNull(dataDictionaryKey);
        }

        public Criteria andDataDictionaryKeyIsNotNull() {
            return isNotNull(dataDictionaryKey);
        }

        public Criteria andDataDictionaryKeyEqualTo(String value) {
            return equalTo(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyNotEqualTo(String value) {
            return notEqualTo(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyGreaterThan(String value) {
            return greaterThan(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyLessThan(String value) {
            return lessThan(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyLike(String value) {
            return like(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyNotLike(String value) {
            return notLike(dataDictionaryKey, value);
        }

        public Criteria andDataDictionaryKeyIn(List<String> values) {
            return in(dataDictionaryKey, values);
        }

        public Criteria andDataDictionaryKeyNotIn(List<String> values) {
            return notIn(dataDictionaryKey, values);
        }

        public Criteria andDataDictionaryKeyBetween(String value1, String value2) {
            return between(dataDictionaryKey, value1, value2);
        }

        public Criteria andDataDictionaryKeyNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryKey, value1, value2);
        }
        public Criteria andDataDictionaryRemarkIsNull() {
            return isNull(dataDictionaryRemark);
        }

        public Criteria andDataDictionaryRemarkIsNotNull() {
            return isNotNull(dataDictionaryRemark);
        }

        public Criteria andDataDictionaryRemarkEqualTo(String value) {
            return equalTo(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkNotEqualTo(String value) {
            return notEqualTo(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkGreaterThan(String value) {
            return greaterThan(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkLessThan(String value) {
            return lessThan(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkLike(String value) {
            return like(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkNotLike(String value) {
            return notLike(dataDictionaryRemark, value);
        }

        public Criteria andDataDictionaryRemarkIn(List<String> values) {
            return in(dataDictionaryRemark, values);
        }

        public Criteria andDataDictionaryRemarkNotIn(List<String> values) {
            return notIn(dataDictionaryRemark, values);
        }

        public Criteria andDataDictionaryRemarkBetween(String value1, String value2) {
            return between(dataDictionaryRemark, value1, value2);
        }

        public Criteria andDataDictionaryRemarkNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryRemark, value1, value2);
        }
    }
}
