package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.BuyerAddress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class BuyerAddressExample extends SgExample<BuyerAddressExample.Criteria> {
    public static final Class<BuyerAddress> beanClass = BuyerAddress.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn zipCode;
    public static EntityColumn townName;
    public static EntityColumn address;
    public static EntityColumn provName;
    public static EntityColumn cityName;
    public static EntityColumn name;
    public static EntityColumn telephone;
    public static EntityColumn townId;
    public static EntityColumn cityId;
    public static EntityColumn provId;
    public static EntityColumn userId;
    public static EntityColumn addressId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        zipCode = listMap.get("zipCode");
        townName = listMap.get("townName");
        address = listMap.get("address");
        provName = listMap.get("provName");
        cityName = listMap.get("cityName");
        name = listMap.get("name");
        telephone = listMap.get("telephone");
        townId = listMap.get("townId");
        cityId = listMap.get("cityId");
        provId = listMap.get("provId");
        userId = listMap.get("userId");
        addressId = listMap.get("addressId");
        }

    public BuyerAddressExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected BuyerAddressExample.Criteria createCriteriaInternal() {
        return new BuyerAddressExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public BuyerAddressExample.Criteria andZipCodeIsNull() {
            return isNull(zipCode);
        }

        public BuyerAddressExample.Criteria andZipCodeIsNotNull() {
            return isNotNull(zipCode);
        }

        public BuyerAddressExample.Criteria andZipCodeEqualTo(String value) {
            return equalTo(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeNotEqualTo(String value) {
            return notEqualTo(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeGreaterThan(String value) {
            return greaterThan(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeLessThan(String value) {
            return lessThan(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeLike(String value) {
            return like(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeNotLike(String value) {
            return notLike(zipCode, value);
        }

        public BuyerAddressExample.Criteria andZipCodeIn(List<String> values) {
            return in(zipCode, values);
        }

        public BuyerAddressExample.Criteria andZipCodeNotIn(List<String> values) {
            return notIn(zipCode, values);
        }

        public BuyerAddressExample.Criteria andZipCodeBetween(String value1, String value2) {
            return between(zipCode, value1, value2);
        }

        public BuyerAddressExample.Criteria andZipCodeNotBetween(String value1, String value2) {
            return notBetween(zipCode, value1, value2);
        }
        public BuyerAddressExample.Criteria andTownNameIsNull() {
            return isNull(townName);
        }

        public BuyerAddressExample.Criteria andTownNameIsNotNull() {
            return isNotNull(townName);
        }

        public BuyerAddressExample.Criteria andTownNameEqualTo(String value) {
            return equalTo(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameNotEqualTo(String value) {
            return notEqualTo(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameGreaterThan(String value) {
            return greaterThan(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameLessThan(String value) {
            return lessThan(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameLike(String value) {
            return like(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameNotLike(String value) {
            return notLike(townName, value);
        }

        public BuyerAddressExample.Criteria andTownNameIn(List<String> values) {
            return in(townName, values);
        }

        public BuyerAddressExample.Criteria andTownNameNotIn(List<String> values) {
            return notIn(townName, values);
        }

        public BuyerAddressExample.Criteria andTownNameBetween(String value1, String value2) {
            return between(townName, value1, value2);
        }

        public BuyerAddressExample.Criteria andTownNameNotBetween(String value1, String value2) {
            return notBetween(townName, value1, value2);
        }
        public BuyerAddressExample.Criteria andAddressIsNull() {
            return isNull(address);
        }

        public BuyerAddressExample.Criteria andAddressIsNotNull() {
            return isNotNull(address);
        }

        public BuyerAddressExample.Criteria andAddressEqualTo(String value) {
            return equalTo(address, value);
        }

        public BuyerAddressExample.Criteria andAddressNotEqualTo(String value) {
            return notEqualTo(address, value);
        }

        public BuyerAddressExample.Criteria andAddressGreaterThan(String value) {
            return greaterThan(address, value);
        }

        public BuyerAddressExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(address, value);
        }

        public BuyerAddressExample.Criteria andAddressLessThan(String value) {
            return lessThan(address, value);
        }

        public BuyerAddressExample.Criteria andAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(address, value);
        }

        public BuyerAddressExample.Criteria andAddressLike(String value) {
            return like(address, value);
        }

        public BuyerAddressExample.Criteria andAddressNotLike(String value) {
            return notLike(address, value);
        }

        public BuyerAddressExample.Criteria andAddressIn(List<String> values) {
            return in(address, values);
        }

        public BuyerAddressExample.Criteria andAddressNotIn(List<String> values) {
            return notIn(address, values);
        }

        public BuyerAddressExample.Criteria andAddressBetween(String value1, String value2) {
            return between(address, value1, value2);
        }

        public BuyerAddressExample.Criteria andAddressNotBetween(String value1, String value2) {
            return notBetween(address, value1, value2);
        }
        public BuyerAddressExample.Criteria andProvNameIsNull() {
            return isNull(provName);
        }

        public BuyerAddressExample.Criteria andProvNameIsNotNull() {
            return isNotNull(provName);
        }

        public BuyerAddressExample.Criteria andProvNameEqualTo(String value) {
            return equalTo(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameNotEqualTo(String value) {
            return notEqualTo(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameGreaterThan(String value) {
            return greaterThan(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameLessThan(String value) {
            return lessThan(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameLike(String value) {
            return like(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameNotLike(String value) {
            return notLike(provName, value);
        }

        public BuyerAddressExample.Criteria andProvNameIn(List<String> values) {
            return in(provName, values);
        }

        public BuyerAddressExample.Criteria andProvNameNotIn(List<String> values) {
            return notIn(provName, values);
        }

        public BuyerAddressExample.Criteria andProvNameBetween(String value1, String value2) {
            return between(provName, value1, value2);
        }

        public BuyerAddressExample.Criteria andProvNameNotBetween(String value1, String value2) {
            return notBetween(provName, value1, value2);
        }
        public BuyerAddressExample.Criteria andCityNameIsNull() {
            return isNull(cityName);
        }

        public BuyerAddressExample.Criteria andCityNameIsNotNull() {
            return isNotNull(cityName);
        }

        public BuyerAddressExample.Criteria andCityNameEqualTo(String value) {
            return equalTo(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameNotEqualTo(String value) {
            return notEqualTo(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameGreaterThan(String value) {
            return greaterThan(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameLessThan(String value) {
            return lessThan(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameLike(String value) {
            return like(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameNotLike(String value) {
            return notLike(cityName, value);
        }

        public BuyerAddressExample.Criteria andCityNameIn(List<String> values) {
            return in(cityName, values);
        }

        public BuyerAddressExample.Criteria andCityNameNotIn(List<String> values) {
            return notIn(cityName, values);
        }

        public BuyerAddressExample.Criteria andCityNameBetween(String value1, String value2) {
            return between(cityName, value1, value2);
        }

        public BuyerAddressExample.Criteria andCityNameNotBetween(String value1, String value2) {
            return notBetween(cityName, value1, value2);
        }
        public BuyerAddressExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public BuyerAddressExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public BuyerAddressExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public BuyerAddressExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public BuyerAddressExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public BuyerAddressExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public BuyerAddressExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public BuyerAddressExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public BuyerAddressExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public BuyerAddressExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public BuyerAddressExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public BuyerAddressExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public BuyerAddressExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public BuyerAddressExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public BuyerAddressExample.Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public BuyerAddressExample.Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public BuyerAddressExample.Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public BuyerAddressExample.Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public BuyerAddressExample.Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public BuyerAddressExample.Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public BuyerAddressExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public BuyerAddressExample.Criteria andTownIdIsNull() {
            return isNull(townId);
        }

        public BuyerAddressExample.Criteria andTownIdIsNotNull() {
            return isNotNull(townId);
        }

        public BuyerAddressExample.Criteria andTownIdEqualTo(Long value) {
            return equalTo(townId, value);
        }

        public BuyerAddressExample.Criteria andTownIdNotEqualTo(Long value) {
            return notEqualTo(townId, value);
        }

        public BuyerAddressExample.Criteria andTownIdGreaterThan(Long value) {
            return greaterThan(townId, value);
        }

        public BuyerAddressExample.Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(townId, value);
        }

        public BuyerAddressExample.Criteria andTownIdLessThan(Long value) {
            return lessThan(townId, value);
        }

        public BuyerAddressExample.Criteria andTownIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(townId, value);
        }

        public BuyerAddressExample.Criteria andTownIdIn(List<Long> values) {
            return in(townId, values);
        }

        public BuyerAddressExample.Criteria andTownIdNotIn(List<Long> values) {
            return notIn(townId, values);
        }

        public BuyerAddressExample.Criteria andTownIdBetween(Long value1, Long value2) {
            return between(townId, value1, value2);
        }

        public BuyerAddressExample.Criteria andTownIdNotBetween(Long value1, Long value2) {
            return notBetween(townId, value1, value2);
        }
        public BuyerAddressExample.Criteria andCityIdIsNull() {
            return isNull(cityId);
        }

        public BuyerAddressExample.Criteria andCityIdIsNotNull() {
            return isNotNull(cityId);
        }

        public BuyerAddressExample.Criteria andCityIdEqualTo(Long value) {
            return equalTo(cityId, value);
        }

        public BuyerAddressExample.Criteria andCityIdNotEqualTo(Long value) {
            return notEqualTo(cityId, value);
        }

        public BuyerAddressExample.Criteria andCityIdGreaterThan(Long value) {
            return greaterThan(cityId, value);
        }

        public BuyerAddressExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cityId, value);
        }

        public BuyerAddressExample.Criteria andCityIdLessThan(Long value) {
            return lessThan(cityId, value);
        }

        public BuyerAddressExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cityId, value);
        }

        public BuyerAddressExample.Criteria andCityIdIn(List<Long> values) {
            return in(cityId, values);
        }

        public BuyerAddressExample.Criteria andCityIdNotIn(List<Long> values) {
            return notIn(cityId, values);
        }

        public BuyerAddressExample.Criteria andCityIdBetween(Long value1, Long value2) {
            return between(cityId, value1, value2);
        }

        public BuyerAddressExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            return notBetween(cityId, value1, value2);
        }
        public BuyerAddressExample.Criteria andProvIdIsNull() {
            return isNull(provId);
        }

        public BuyerAddressExample.Criteria andProvIdIsNotNull() {
            return isNotNull(provId);
        }

        public BuyerAddressExample.Criteria andProvIdEqualTo(Long value) {
            return equalTo(provId, value);
        }

        public BuyerAddressExample.Criteria andProvIdNotEqualTo(Long value) {
            return notEqualTo(provId, value);
        }

        public BuyerAddressExample.Criteria andProvIdGreaterThan(Long value) {
            return greaterThan(provId, value);
        }

        public BuyerAddressExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provId, value);
        }

        public BuyerAddressExample.Criteria andProvIdLessThan(Long value) {
            return lessThan(provId, value);
        }

        public BuyerAddressExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provId, value);
        }

        public BuyerAddressExample.Criteria andProvIdIn(List<Long> values) {
            return in(provId, values);
        }

        public BuyerAddressExample.Criteria andProvIdNotIn(List<Long> values) {
            return notIn(provId, values);
        }

        public BuyerAddressExample.Criteria andProvIdBetween(Long value1, Long value2) {
            return between(provId, value1, value2);
        }

        public BuyerAddressExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            return notBetween(provId, value1, value2);
        }
        public BuyerAddressExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public BuyerAddressExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public BuyerAddressExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public BuyerAddressExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public BuyerAddressExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public BuyerAddressExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public BuyerAddressExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public BuyerAddressExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public BuyerAddressExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public BuyerAddressExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public BuyerAddressExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public BuyerAddressExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public BuyerAddressExample.Criteria andAddressIdIsNull() {
            return isNull(addressId);
        }

        public BuyerAddressExample.Criteria andAddressIdIsNotNull() {
            return isNotNull(addressId);
        }

        public BuyerAddressExample.Criteria andAddressIdEqualTo(Long value) {
            return equalTo(addressId, value);
        }

        public BuyerAddressExample.Criteria andAddressIdNotEqualTo(Long value) {
            return notEqualTo(addressId, value);
        }

        public BuyerAddressExample.Criteria andAddressIdGreaterThan(Long value) {
            return greaterThan(addressId, value);
        }

        public BuyerAddressExample.Criteria andAddressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(addressId, value);
        }

        public BuyerAddressExample.Criteria andAddressIdLessThan(Long value) {
            return lessThan(addressId, value);
        }

        public BuyerAddressExample.Criteria andAddressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(addressId, value);
        }

        public BuyerAddressExample.Criteria andAddressIdIn(List<Long> values) {
            return in(addressId, values);
        }

        public BuyerAddressExample.Criteria andAddressIdNotIn(List<Long> values) {
            return notIn(addressId, values);
        }

        public BuyerAddressExample.Criteria andAddressIdBetween(Long value1, Long value2) {
            return between(addressId, value1, value2);
        }

        public BuyerAddressExample.Criteria andAddressIdNotBetween(Long value1, Long value2) {
            return notBetween(addressId, value1, value2);
        }
    }
}