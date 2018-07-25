package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderLogistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ItemOrderLogisticsExample extends SgExample<ItemOrderLogisticsExample.Criteria> {
    public static final Class<ItemOrderLogistics> beanClass = ItemOrderLogistics.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn zipCode;
    public static EntityColumn companyId;
    public static EntityColumn address;
    public static EntityColumn money;
    public static EntityColumn name;
    public static EntityColumn telephone;
    public static EntityColumn id;
    public static EntityColumn cityId;
    public static EntityColumn townId;
    public static EntityColumn oid;
    public static EntityColumn provId;
    public static EntityColumn courierNumber;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        zipCode = listMap.get("zipCode");
        companyId = listMap.get("companyId");
        address = listMap.get("address");
        money = listMap.get("money");
        name = listMap.get("name");
        telephone = listMap.get("telephone");
        id = listMap.get("id");
        cityId = listMap.get("cityId");
        townId = listMap.get("townId");
        oid = listMap.get("oid");
        provId = listMap.get("provId");
        courierNumber = listMap.get("courierNumber");
        }

    public ItemOrderLogisticsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemOrderLogisticsExample.Criteria createCriteriaInternal() {
        return new ItemOrderLogisticsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeIsNull() {
            return isNull(zipCode);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeIsNotNull() {
            return isNotNull(zipCode);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeEqualTo(String value) {
            return equalTo(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotEqualTo(String value) {
            return notEqualTo(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeGreaterThan(String value) {
            return greaterThan(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLessThan(String value) {
            return lessThan(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLike(String value) {
            return like(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotLike(String value) {
            return notLike(zipCode, value);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeIn(List<String> values) {
            return in(zipCode, values);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotIn(List<String> values) {
            return notIn(zipCode, values);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeBetween(String value1, String value2) {
            return between(zipCode, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotBetween(String value1, String value2) {
            return notBetween(zipCode, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andCompanyIdIsNull() {
            return isNull(companyId);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdIsNotNull() {
            return isNotNull(companyId);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdEqualTo(Long value) {
            return equalTo(companyId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotEqualTo(Long value) {
            return notEqualTo(companyId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdGreaterThan(Long value) {
            return greaterThan(companyId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(companyId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLessThan(Long value) {
            return lessThan(companyId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(companyId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdIn(List<Long> values) {
            return in(companyId, values);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotIn(List<Long> values) {
            return notIn(companyId, values);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdBetween(Long value1, Long value2) {
            return between(companyId, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            return notBetween(companyId, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andAddressIsNull() {
            return isNull(address);
        }

        public ItemOrderLogisticsExample.Criteria andAddressIsNotNull() {
            return isNotNull(address);
        }

        public ItemOrderLogisticsExample.Criteria andAddressEqualTo(String value) {
            return equalTo(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotEqualTo(String value) {
            return notEqualTo(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressGreaterThan(String value) {
            return greaterThan(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressLessThan(String value) {
            return lessThan(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressLike(String value) {
            return like(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotLike(String value) {
            return notLike(address, value);
        }

        public ItemOrderLogisticsExample.Criteria andAddressIn(List<String> values) {
            return in(address, values);
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotIn(List<String> values) {
            return notIn(address, values);
        }

        public ItemOrderLogisticsExample.Criteria andAddressBetween(String value1, String value2) {
            return between(address, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotBetween(String value1, String value2) {
            return notBetween(address, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyEqualTo(Long value) {
            return equalTo(money, value);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyNotEqualTo(Long value) {
            return notEqualTo(money, value);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyGreaterThan(Long value) {
            return greaterThan(money, value);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(money, value);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyLessThan(Long value) {
            return lessThan(money, value);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(money, value);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyIn(List<Long> values) {
            return in(money, values);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyNotIn(List<Long> values) {
            return notIn(money, values);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyBetween(Long value1, Long value2) {
            return between(money, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            return notBetween(money, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public ItemOrderLogisticsExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public ItemOrderLogisticsExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public ItemOrderLogisticsExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public ItemOrderLogisticsExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public ItemOrderLogisticsExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ItemOrderLogisticsExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ItemOrderLogisticsExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ItemOrderLogisticsExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ItemOrderLogisticsExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ItemOrderLogisticsExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ItemOrderLogisticsExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ItemOrderLogisticsExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ItemOrderLogisticsExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ItemOrderLogisticsExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ItemOrderLogisticsExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andCityIdIsNull() {
            return isNull(cityId);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdIsNotNull() {
            return isNotNull(cityId);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdEqualTo(Long value) {
            return equalTo(cityId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotEqualTo(Long value) {
            return notEqualTo(cityId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdGreaterThan(Long value) {
            return greaterThan(cityId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cityId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLessThan(Long value) {
            return lessThan(cityId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cityId, value);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdIn(List<Long> values) {
            return in(cityId, values);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotIn(List<Long> values) {
            return notIn(cityId, values);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdBetween(Long value1, Long value2) {
            return between(cityId, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            return notBetween(cityId, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andTownIdIsNull() {
            return isNull(townId);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdIsNotNull() {
            return isNotNull(townId);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdEqualTo(Long value) {
            return equalTo(townId, value);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotEqualTo(Long value) {
            return notEqualTo(townId, value);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdGreaterThan(Long value) {
            return greaterThan(townId, value);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(townId, value);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLessThan(Long value) {
            return lessThan(townId, value);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(townId, value);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdIn(List<Long> values) {
            return in(townId, values);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotIn(List<Long> values) {
            return notIn(townId, values);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdBetween(Long value1, Long value2) {
            return between(townId, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotBetween(Long value1, Long value2) {
            return notBetween(townId, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public ItemOrderLogisticsExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public ItemOrderLogisticsExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public ItemOrderLogisticsExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public ItemOrderLogisticsExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public ItemOrderLogisticsExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public ItemOrderLogisticsExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public ItemOrderLogisticsExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public ItemOrderLogisticsExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public ItemOrderLogisticsExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public ItemOrderLogisticsExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andProvIdIsNull() {
            return isNull(provId);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdIsNotNull() {
            return isNotNull(provId);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdEqualTo(Long value) {
            return equalTo(provId, value);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotEqualTo(Long value) {
            return notEqualTo(provId, value);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdGreaterThan(Long value) {
            return greaterThan(provId, value);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provId, value);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLessThan(Long value) {
            return lessThan(provId, value);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provId, value);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdIn(List<Long> values) {
            return in(provId, values);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotIn(List<Long> values) {
            return notIn(provId, values);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdBetween(Long value1, Long value2) {
            return between(provId, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            return notBetween(provId, value1, value2);
        }
        public ItemOrderLogisticsExample.Criteria andCourierNumberIsNull() {
            return isNull(courierNumber);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberIsNotNull() {
            return isNotNull(courierNumber);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberEqualTo(String value) {
            return equalTo(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotEqualTo(String value) {
            return notEqualTo(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberGreaterThan(String value) {
            return greaterThan(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLessThan(String value) {
            return lessThan(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLike(String value) {
            return like(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotLike(String value) {
            return notLike(courierNumber, value);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberIn(List<String> values) {
            return in(courierNumber, values);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotIn(List<String> values) {
            return notIn(courierNumber, values);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberBetween(String value1, String value2) {
            return between(courierNumber, value1, value2);
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotBetween(String value1, String value2) {
            return notBetween(courierNumber, value1, value2);
        }
    }
}
