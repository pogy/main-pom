package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoatLicense;

import java.util.*;
public class GoatLicenseExample extends SgExample<GoatLicenseExample.Criteria> {
    public static final Class<GoatLicense> beanClass = GoatLicense.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn spreadToTime;
    public static EntityColumn licenseToTime;
    public static EntityColumn shopId;
    public static EntityColumn goatId;
    public static EntityColumn licenseId;
    public static EntityColumn spreadFromTime;
    public static EntityColumn licenseFromTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        spreadToTime = listMap.get("spreadToTime");
        licenseToTime = listMap.get("licenseToTime");
        shopId = listMap.get("shopId");
        goatId = listMap.get("goatId");
        licenseId = listMap.get("licenseId");
        spreadFromTime = listMap.get("spreadFromTime");
        licenseFromTime = listMap.get("licenseFromTime");
        }

    public GoatLicenseExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoatLicenseExample.Criteria createCriteriaInternal() {
        return new GoatLicenseExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeIsNull() {
            return isNull(spreadToTime);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeIsNotNull() {
            return isNotNull(spreadToTime);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeEqualTo(Date value) {
            return equalTo(spreadToTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeNotEqualTo(Date value) {
            return notEqualTo(spreadToTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeGreaterThan(Date value) {
            return greaterThan(spreadToTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(spreadToTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeLessThan(Date value) {
            return lessThan(spreadToTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(spreadToTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeIn(List<Date> values) {
            return in(spreadToTime, values);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeNotIn(List<Date> values) {
            return notIn(spreadToTime, values);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeBetween(Date value1, Date value2) {
            return between(spreadToTime, value1, value2);
        }

        public GoatLicenseExample.Criteria andSpreadToTimeNotBetween(Date value1, Date value2) {
            return notBetween(spreadToTime, value1, value2);
        }
        public GoatLicenseExample.Criteria andLicenseToTimeIsNull() {
            return isNull(licenseToTime);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeIsNotNull() {
            return isNotNull(licenseToTime);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeEqualTo(Date value) {
            return equalTo(licenseToTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeNotEqualTo(Date value) {
            return notEqualTo(licenseToTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeGreaterThan(Date value) {
            return greaterThan(licenseToTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(licenseToTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeLessThan(Date value) {
            return lessThan(licenseToTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(licenseToTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeIn(List<Date> values) {
            return in(licenseToTime, values);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeNotIn(List<Date> values) {
            return notIn(licenseToTime, values);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeBetween(Date value1, Date value2) {
            return between(licenseToTime, value1, value2);
        }

        public GoatLicenseExample.Criteria andLicenseToTimeNotBetween(Date value1, Date value2) {
            return notBetween(licenseToTime, value1, value2);
        }
        public GoatLicenseExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public GoatLicenseExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public GoatLicenseExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public GoatLicenseExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public GoatLicenseExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public GoatLicenseExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public GoatLicenseExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public GoatLicenseExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public GoatLicenseExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public GoatLicenseExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public GoatLicenseExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public GoatLicenseExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public GoatLicenseExample.Criteria andGoatIdIsNull() {
            return isNull(goatId);
        }

        public GoatLicenseExample.Criteria andGoatIdIsNotNull() {
            return isNotNull(goatId);
        }

        public GoatLicenseExample.Criteria andGoatIdEqualTo(Long value) {
            return equalTo(goatId, value);
        }

        public GoatLicenseExample.Criteria andGoatIdNotEqualTo(Long value) {
            return notEqualTo(goatId, value);
        }

        public GoatLicenseExample.Criteria andGoatIdGreaterThan(Long value) {
            return greaterThan(goatId, value);
        }

        public GoatLicenseExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goatId, value);
        }

        public GoatLicenseExample.Criteria andGoatIdLessThan(Long value) {
            return lessThan(goatId, value);
        }

        public GoatLicenseExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goatId, value);
        }

        public GoatLicenseExample.Criteria andGoatIdIn(List<Long> values) {
            return in(goatId, values);
        }

        public GoatLicenseExample.Criteria andGoatIdNotIn(List<Long> values) {
            return notIn(goatId, values);
        }

        public GoatLicenseExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            return between(goatId, value1, value2);
        }

        public GoatLicenseExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            return notBetween(goatId, value1, value2);
        }
        public GoatLicenseExample.Criteria andLicenseIdIsNull() {
            return isNull(licenseId);
        }

        public GoatLicenseExample.Criteria andLicenseIdIsNotNull() {
            return isNotNull(licenseId);
        }

        public GoatLicenseExample.Criteria andLicenseIdEqualTo(Long value) {
            return equalTo(licenseId, value);
        }

        public GoatLicenseExample.Criteria andLicenseIdNotEqualTo(Long value) {
            return notEqualTo(licenseId, value);
        }

        public GoatLicenseExample.Criteria andLicenseIdGreaterThan(Long value) {
            return greaterThan(licenseId, value);
        }

        public GoatLicenseExample.Criteria andLicenseIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(licenseId, value);
        }

        public GoatLicenseExample.Criteria andLicenseIdLessThan(Long value) {
            return lessThan(licenseId, value);
        }

        public GoatLicenseExample.Criteria andLicenseIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(licenseId, value);
        }

        public GoatLicenseExample.Criteria andLicenseIdIn(List<Long> values) {
            return in(licenseId, values);
        }

        public GoatLicenseExample.Criteria andLicenseIdNotIn(List<Long> values) {
            return notIn(licenseId, values);
        }

        public GoatLicenseExample.Criteria andLicenseIdBetween(Long value1, Long value2) {
            return between(licenseId, value1, value2);
        }

        public GoatLicenseExample.Criteria andLicenseIdNotBetween(Long value1, Long value2) {
            return notBetween(licenseId, value1, value2);
        }
        public GoatLicenseExample.Criteria andSpreadFromTimeIsNull() {
            return isNull(spreadFromTime);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeIsNotNull() {
            return isNotNull(spreadFromTime);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeEqualTo(Date value) {
            return equalTo(spreadFromTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeNotEqualTo(Date value) {
            return notEqualTo(spreadFromTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeGreaterThan(Date value) {
            return greaterThan(spreadFromTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(spreadFromTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeLessThan(Date value) {
            return lessThan(spreadFromTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(spreadFromTime, value);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeIn(List<Date> values) {
            return in(spreadFromTime, values);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeNotIn(List<Date> values) {
            return notIn(spreadFromTime, values);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeBetween(Date value1, Date value2) {
            return between(spreadFromTime, value1, value2);
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeNotBetween(Date value1, Date value2) {
            return notBetween(spreadFromTime, value1, value2);
        }
        public GoatLicenseExample.Criteria andLicenseFromTimeIsNull() {
            return isNull(licenseFromTime);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeIsNotNull() {
            return isNotNull(licenseFromTime);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeEqualTo(Date value) {
            return equalTo(licenseFromTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeNotEqualTo(Date value) {
            return notEqualTo(licenseFromTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeGreaterThan(Date value) {
            return greaterThan(licenseFromTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(licenseFromTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeLessThan(Date value) {
            return lessThan(licenseFromTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(licenseFromTime, value);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeIn(List<Date> values) {
            return in(licenseFromTime, values);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeNotIn(List<Date> values) {
            return notIn(licenseFromTime, values);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeBetween(Date value1, Date value2) {
            return between(licenseFromTime, value1, value2);
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeNotBetween(Date value1, Date value2) {
            return notBetween(licenseFromTime, value1, value2);
        }
    }
}
