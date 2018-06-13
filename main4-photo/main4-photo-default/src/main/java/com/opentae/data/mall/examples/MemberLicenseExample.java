package com.opentae.data.mall.examples;

import com.opentae.data.mall.beans.MemberLicense;
import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;

import java.util.*;
public class MemberLicenseExample extends SgExample<MemberLicenseExample.Criteria> {
    public static final Class<MemberLicense> beanClass = MemberLicense.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn licenseType;
    public static EntityColumn userLicenseId;
    public static EntityColumn context;
    public static EntityColumn licenseFailure;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        licenseType = listMap.get("licenseType");
        userLicenseId = listMap.get("userLicenseId");
        context = listMap.get("context");
        licenseFailure = listMap.get("licenseFailure");
        userId = listMap.get("userId");
        }

    public MemberLicenseExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberLicenseExample.Criteria createCriteriaInternal() {
        return new MemberLicenseExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberLicenseExample.Criteria andLicenseTypeIsNull() {
            return isNull(licenseType);
        }

        public MemberLicenseExample.Criteria andLicenseTypeIsNotNull() {
            return isNotNull(licenseType);
        }

        public MemberLicenseExample.Criteria andLicenseTypeEqualTo(Integer value) {
            return equalTo(licenseType, value);
        }

        public MemberLicenseExample.Criteria andLicenseTypeNotEqualTo(Integer value) {
            return notEqualTo(licenseType, value);
        }

        public MemberLicenseExample.Criteria andLicenseTypeGreaterThan(Integer value) {
            return greaterThan(licenseType, value);
        }

        public MemberLicenseExample.Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(licenseType, value);
        }

        public MemberLicenseExample.Criteria andLicenseTypeLessThan(Integer value) {
            return lessThan(licenseType, value);
        }

        public MemberLicenseExample.Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(licenseType, value);
        }

        public MemberLicenseExample.Criteria andLicenseTypeIn(List<Integer> values) {
            return in(licenseType, values);
        }

        public MemberLicenseExample.Criteria andLicenseTypeNotIn(List<Integer> values) {
            return notIn(licenseType, values);
        }

        public MemberLicenseExample.Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            return between(licenseType, value1, value2);
        }

        public MemberLicenseExample.Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(licenseType, value1, value2);
        }
        public MemberLicenseExample.Criteria andUserLicenseIdIsNull() {
            return isNull(userLicenseId);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdIsNotNull() {
            return isNotNull(userLicenseId);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdEqualTo(Long value) {
            return equalTo(userLicenseId, value);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdNotEqualTo(Long value) {
            return notEqualTo(userLicenseId, value);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdGreaterThan(Long value) {
            return greaterThan(userLicenseId, value);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userLicenseId, value);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdLessThan(Long value) {
            return lessThan(userLicenseId, value);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userLicenseId, value);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdIn(List<Long> values) {
            return in(userLicenseId, values);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdNotIn(List<Long> values) {
            return notIn(userLicenseId, values);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdBetween(Long value1, Long value2) {
            return between(userLicenseId, value1, value2);
        }

        public MemberLicenseExample.Criteria andUserLicenseIdNotBetween(Long value1, Long value2) {
            return notBetween(userLicenseId, value1, value2);
        }
        public MemberLicenseExample.Criteria andContextIsNull() {
            return isNull(context);
        }

        public MemberLicenseExample.Criteria andContextIsNotNull() {
            return isNotNull(context);
        }

        public MemberLicenseExample.Criteria andContextEqualTo(String value) {
            return equalTo(context, value);
        }

        public MemberLicenseExample.Criteria andContextNotEqualTo(String value) {
            return notEqualTo(context, value);
        }

        public MemberLicenseExample.Criteria andContextGreaterThan(String value) {
            return greaterThan(context, value);
        }

        public MemberLicenseExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(context, value);
        }

        public MemberLicenseExample.Criteria andContextLessThan(String value) {
            return lessThan(context, value);
        }

        public MemberLicenseExample.Criteria andContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(context, value);
        }

        public MemberLicenseExample.Criteria andContextLike(String value) {
            return like(context, value);
        }

        public MemberLicenseExample.Criteria andContextNotLike(String value) {
            return notLike(context, value);
        }

        public MemberLicenseExample.Criteria andContextIn(List<String> values) {
            return in(context, values);
        }

        public MemberLicenseExample.Criteria andContextNotIn(List<String> values) {
            return notIn(context, values);
        }

        public MemberLicenseExample.Criteria andContextBetween(String value1, String value2) {
            return between(context, value1, value2);
        }

        public MemberLicenseExample.Criteria andContextNotBetween(String value1, String value2) {
            return notBetween(context, value1, value2);
        }
        public MemberLicenseExample.Criteria andLicenseFailureIsNull() {
            return isNull(licenseFailure);
        }

        public MemberLicenseExample.Criteria andLicenseFailureIsNotNull() {
            return isNotNull(licenseFailure);
        }

        public MemberLicenseExample.Criteria andLicenseFailureEqualTo(Integer value) {
            return equalTo(licenseFailure, value);
        }

        public MemberLicenseExample.Criteria andLicenseFailureNotEqualTo(Integer value) {
            return notEqualTo(licenseFailure, value);
        }

        public MemberLicenseExample.Criteria andLicenseFailureGreaterThan(Integer value) {
            return greaterThan(licenseFailure, value);
        }

        public MemberLicenseExample.Criteria andLicenseFailureGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(licenseFailure, value);
        }

        public MemberLicenseExample.Criteria andLicenseFailureLessThan(Integer value) {
            return lessThan(licenseFailure, value);
        }

        public MemberLicenseExample.Criteria andLicenseFailureLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(licenseFailure, value);
        }

        public MemberLicenseExample.Criteria andLicenseFailureIn(List<Integer> values) {
            return in(licenseFailure, values);
        }

        public MemberLicenseExample.Criteria andLicenseFailureNotIn(List<Integer> values) {
            return notIn(licenseFailure, values);
        }

        public MemberLicenseExample.Criteria andLicenseFailureBetween(Integer value1, Integer value2) {
            return between(licenseFailure, value1, value2);
        }

        public MemberLicenseExample.Criteria andLicenseFailureNotBetween(Integer value1, Integer value2) {
            return notBetween(licenseFailure, value1, value2);
        }
        public MemberLicenseExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberLicenseExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberLicenseExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberLicenseExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberLicenseExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberLicenseExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberLicenseExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberLicenseExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberLicenseExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberLicenseExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberLicenseExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberLicenseExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}