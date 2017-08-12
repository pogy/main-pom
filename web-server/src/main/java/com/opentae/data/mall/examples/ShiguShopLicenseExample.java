package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguShopLicense;

import java.util.*;
public class ShiguShopLicenseExample extends SgExample<ShiguShopLicenseExample.Criteria> {
    public static final Class<ShiguShopLicense> beanClass = ShiguShopLicense.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn licenseType;
    public static EntityColumn context;
    public static EntityColumn shopId;
    public static EntityColumn licenseId;
    public static EntityColumn licenseFailure;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        licenseType = listMap.get("licenseType");
        context = listMap.get("context");
        shopId = listMap.get("shopId");
        licenseId = listMap.get("licenseId");
        licenseFailure = listMap.get("licenseFailure");
        }

    public ShiguShopLicenseExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguShopLicenseExample.Criteria createCriteriaInternal() {
        return new ShiguShopLicenseExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeIsNull() {
            return isNull(licenseType);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeIsNotNull() {
            return isNotNull(licenseType);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeEqualTo(Integer value) {
            return equalTo(licenseType, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeNotEqualTo(Integer value) {
            return notEqualTo(licenseType, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeGreaterThan(Integer value) {
            return greaterThan(licenseType, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(licenseType, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeLessThan(Integer value) {
            return lessThan(licenseType, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(licenseType, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeIn(List<Integer> values) {
            return in(licenseType, values);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeNotIn(List<Integer> values) {
            return notIn(licenseType, values);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            return between(licenseType, value1, value2);
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(licenseType, value1, value2);
        }
        public ShiguShopLicenseExample.Criteria andContextIsNull() {
            return isNull(context);
        }

        public ShiguShopLicenseExample.Criteria andContextIsNotNull() {
            return isNotNull(context);
        }

        public ShiguShopLicenseExample.Criteria andContextEqualTo(String value) {
            return equalTo(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextNotEqualTo(String value) {
            return notEqualTo(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextGreaterThan(String value) {
            return greaterThan(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextLessThan(String value) {
            return lessThan(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextLike(String value) {
            return like(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextNotLike(String value) {
            return notLike(context, value);
        }

        public ShiguShopLicenseExample.Criteria andContextIn(List<String> values) {
            return in(context, values);
        }

        public ShiguShopLicenseExample.Criteria andContextNotIn(List<String> values) {
            return notIn(context, values);
        }

        public ShiguShopLicenseExample.Criteria andContextBetween(String value1, String value2) {
            return between(context, value1, value2);
        }

        public ShiguShopLicenseExample.Criteria andContextNotBetween(String value1, String value2) {
            return notBetween(context, value1, value2);
        }
        public ShiguShopLicenseExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShiguShopLicenseExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShiguShopLicenseExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShiguShopLicenseExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShiguShopLicenseExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShiguShopLicenseExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShiguShopLicenseExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShiguShopLicenseExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShiguShopLicenseExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShiguShopLicenseExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShiguShopLicenseExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShiguShopLicenseExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShiguShopLicenseExample.Criteria andLicenseIdIsNull() {
            return isNull(licenseId);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdIsNotNull() {
            return isNotNull(licenseId);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdEqualTo(Long value) {
            return equalTo(licenseId, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdNotEqualTo(Long value) {
            return notEqualTo(licenseId, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdGreaterThan(Long value) {
            return greaterThan(licenseId, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(licenseId, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdLessThan(Long value) {
            return lessThan(licenseId, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(licenseId, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdIn(List<Long> values) {
            return in(licenseId, values);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdNotIn(List<Long> values) {
            return notIn(licenseId, values);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdBetween(Long value1, Long value2) {
            return between(licenseId, value1, value2);
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdNotBetween(Long value1, Long value2) {
            return notBetween(licenseId, value1, value2);
        }
        public ShiguShopLicenseExample.Criteria andLicenseFailureIsNull() {
            return isNull(licenseFailure);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureIsNotNull() {
            return isNotNull(licenseFailure);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureEqualTo(Integer value) {
            return equalTo(licenseFailure, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureNotEqualTo(Integer value) {
            return notEqualTo(licenseFailure, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureGreaterThan(Integer value) {
            return greaterThan(licenseFailure, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(licenseFailure, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureLessThan(Integer value) {
            return lessThan(licenseFailure, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(licenseFailure, value);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureIn(List<Integer> values) {
            return in(licenseFailure, values);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureNotIn(List<Integer> values) {
            return notIn(licenseFailure, values);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureBetween(Integer value1, Integer value2) {
            return between(licenseFailure, value1, value2);
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureNotBetween(Integer value1, Integer value2) {
            return notBetween(licenseFailure, value1, value2);
        }
    }
}