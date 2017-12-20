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
    protected DataDictionarySetExample.Criteria createCriteriaInternal() {
        return new DataDictionarySetExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdIsNull() {
            return isNull(dataDictionaryId);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdIsNotNull() {
            return isNotNull(dataDictionaryId);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdEqualTo(Long value) {
            return equalTo(dataDictionaryId, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdNotEqualTo(Long value) {
            return notEqualTo(dataDictionaryId, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdGreaterThan(Long value) {
            return greaterThan(dataDictionaryId, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dataDictionaryId, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdLessThan(Long value) {
            return lessThan(dataDictionaryId, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dataDictionaryId, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdIn(List<Long> values) {
            return in(dataDictionaryId, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdNotIn(List<Long> values) {
            return notIn(dataDictionaryId, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdBetween(Long value1, Long value2) {
            return between(dataDictionaryId, value1, value2);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryIdNotBetween(Long value1, Long value2) {
            return notBetween(dataDictionaryId, value1, value2);
        }
        public DataDictionarySetExample.Criteria andUseTypeIsNull() {
            return isNull(useType);
        }

        public DataDictionarySetExample.Criteria andUseTypeIsNotNull() {
            return isNotNull(useType);
        }

        public DataDictionarySetExample.Criteria andUseTypeEqualTo(String value) {
            return equalTo(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeNotEqualTo(String value) {
            return notEqualTo(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeGreaterThan(String value) {
            return greaterThan(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeLessThan(String value) {
            return lessThan(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeLike(String value) {
            return like(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeNotLike(String value) {
            return notLike(useType, value);
        }

        public DataDictionarySetExample.Criteria andUseTypeIn(List<String> values) {
            return in(useType, values);
        }

        public DataDictionarySetExample.Criteria andUseTypeNotIn(List<String> values) {
            return notIn(useType, values);
        }

        public DataDictionarySetExample.Criteria andUseTypeBetween(String value1, String value2) {
            return between(useType, value1, value2);
        }

        public DataDictionarySetExample.Criteria andUseTypeNotBetween(String value1, String value2) {
            return notBetween(useType, value1, value2);
        }
        public DataDictionarySetExample.Criteria andServiceIdIsNull() {
            return isNull(serviceId);
        }

        public DataDictionarySetExample.Criteria andServiceIdIsNotNull() {
            return isNotNull(serviceId);
        }

        public DataDictionarySetExample.Criteria andServiceIdEqualTo(Long value) {
            return equalTo(serviceId, value);
        }

        public DataDictionarySetExample.Criteria andServiceIdNotEqualTo(Long value) {
            return notEqualTo(serviceId, value);
        }

        public DataDictionarySetExample.Criteria andServiceIdGreaterThan(Long value) {
            return greaterThan(serviceId, value);
        }

        public DataDictionarySetExample.Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(serviceId, value);
        }

        public DataDictionarySetExample.Criteria andServiceIdLessThan(Long value) {
            return lessThan(serviceId, value);
        }

        public DataDictionarySetExample.Criteria andServiceIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(serviceId, value);
        }

        public DataDictionarySetExample.Criteria andServiceIdIn(List<Long> values) {
            return in(serviceId, values);
        }

        public DataDictionarySetExample.Criteria andServiceIdNotIn(List<Long> values) {
            return notIn(serviceId, values);
        }

        public DataDictionarySetExample.Criteria andServiceIdBetween(Long value1, Long value2) {
            return between(serviceId, value1, value2);
        }

        public DataDictionarySetExample.Criteria andServiceIdNotBetween(Long value1, Long value2) {
            return notBetween(serviceId, value1, value2);
        }
        public DataDictionarySetExample.Criteria andDataDictionaryNameIsNull() {
            return isNull(dataDictionaryName);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameIsNotNull() {
            return isNotNull(dataDictionaryName);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameEqualTo(String value) {
            return equalTo(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameNotEqualTo(String value) {
            return notEqualTo(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameGreaterThan(String value) {
            return greaterThan(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameLessThan(String value) {
            return lessThan(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameLike(String value) {
            return like(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameNotLike(String value) {
            return notLike(dataDictionaryName, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameIn(List<String> values) {
            return in(dataDictionaryName, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameNotIn(List<String> values) {
            return notIn(dataDictionaryName, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameBetween(String value1, String value2) {
            return between(dataDictionaryName, value1, value2);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryNameNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryName, value1, value2);
        }
        public DataDictionarySetExample.Criteria andDataDictionaryTypeIsNull() {
            return isNull(dataDictionaryType);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeIsNotNull() {
            return isNotNull(dataDictionaryType);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeEqualTo(String value) {
            return equalTo(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeNotEqualTo(String value) {
            return notEqualTo(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeGreaterThan(String value) {
            return greaterThan(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeLessThan(String value) {
            return lessThan(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeLike(String value) {
            return like(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeNotLike(String value) {
            return notLike(dataDictionaryType, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeIn(List<String> values) {
            return in(dataDictionaryType, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeNotIn(List<String> values) {
            return notIn(dataDictionaryType, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeBetween(String value1, String value2) {
            return between(dataDictionaryType, value1, value2);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryTypeNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryType, value1, value2);
        }
        public DataDictionarySetExample.Criteria andDataDictionaryKeyIsNull() {
            return isNull(dataDictionaryKey);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyIsNotNull() {
            return isNotNull(dataDictionaryKey);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyEqualTo(String value) {
            return equalTo(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyNotEqualTo(String value) {
            return notEqualTo(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyGreaterThan(String value) {
            return greaterThan(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyLessThan(String value) {
            return lessThan(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyLike(String value) {
            return like(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyNotLike(String value) {
            return notLike(dataDictionaryKey, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyIn(List<String> values) {
            return in(dataDictionaryKey, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyNotIn(List<String> values) {
            return notIn(dataDictionaryKey, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyBetween(String value1, String value2) {
            return between(dataDictionaryKey, value1, value2);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryKeyNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryKey, value1, value2);
        }
        public DataDictionarySetExample.Criteria andDataDictionaryRemarkIsNull() {
            return isNull(dataDictionaryRemark);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkIsNotNull() {
            return isNotNull(dataDictionaryRemark);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkEqualTo(String value) {
            return equalTo(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkNotEqualTo(String value) {
            return notEqualTo(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkGreaterThan(String value) {
            return greaterThan(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkLessThan(String value) {
            return lessThan(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkLike(String value) {
            return like(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkNotLike(String value) {
            return notLike(dataDictionaryRemark, value);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkIn(List<String> values) {
            return in(dataDictionaryRemark, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkNotIn(List<String> values) {
            return notIn(dataDictionaryRemark, values);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkBetween(String value1, String value2) {
            return between(dataDictionaryRemark, value1, value2);
        }

        public DataDictionarySetExample.Criteria andDataDictionaryRemarkNotBetween(String value1, String value2) {
            return notBetween(dataDictionaryRemark, value1, value2);
        }
    }
}
