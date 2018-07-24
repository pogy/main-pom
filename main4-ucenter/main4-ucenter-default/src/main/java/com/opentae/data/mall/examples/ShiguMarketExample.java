package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguMarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguMarketExample extends SgExample<ShiguMarketExample.Criteria> {
    public static final Class<ShiguMarket> beanClass = ShiguMarket.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn marketId;
    public static EntityColumn marketName;
    public static EntityColumn parentMarketId;
    public static EntityColumn parentMarketName;
    public static EntityColumn isParent;
    public static EntityColumn buycityId;
    public static EntityColumn provinceId;
    public static EntityColumn provinceName;
    public static EntityColumn cityId;
    public static EntityColumn cityName;
    public static EntityColumn marketAddr;
    public static EntityColumn sortOrder;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn remark3;
    public static EntityColumn remark4;
    public static EntityColumn remark5;
    public static EntityColumn remark6;
    public static EntityColumn remark7;
    public static EntityColumn remark8;
    public static EntityColumn remark9;
    public static EntityColumn remark10;
    public static EntityColumn remark11;
    public static EntityColumn remark12;
    public static EntityColumn remark13;
    public static EntityColumn remark14;
    public static EntityColumn remark15;
    public static EntityColumn remark16;
    public static EntityColumn remark17;
    public static EntityColumn remark18;
    public static EntityColumn remark19;
    public static EntityColumn remark20;
    public static EntityColumn areaId;
    public static EntityColumn areaName;
    public static EntityColumn marketFullName;
    public static EntityColumn nature;
    public static EntityColumn floors;
    public static EntityColumn storeInTotal;
    public static EntityColumn marketPingyin;
    public static EntityColumn canRegist;
    public static EntityColumn webSite;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        marketId = listMap.get("marketId");
        marketName = listMap.get("marketName");
        parentMarketId = listMap.get("parentMarketId");
        parentMarketName = listMap.get("parentMarketName");
        isParent = listMap.get("isParent");
        buycityId = listMap.get("buycityId");
        provinceId = listMap.get("provinceId");
        provinceName = listMap.get("provinceName");
        cityId = listMap.get("cityId");
        cityName = listMap.get("cityName");
        marketAddr = listMap.get("marketAddr");
        sortOrder = listMap.get("sortOrder");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        remark3 = listMap.get("remark3");
        remark4 = listMap.get("remark4");
        remark5 = listMap.get("remark5");
        remark6 = listMap.get("remark6");
        remark7 = listMap.get("remark7");
        remark8 = listMap.get("remark8");
        remark9 = listMap.get("remark9");
        remark10 = listMap.get("remark10");
        remark11 = listMap.get("remark11");
        remark12 = listMap.get("remark12");
        remark13 = listMap.get("remark13");
        remark14 = listMap.get("remark14");
        remark15 = listMap.get("remark15");
        remark16 = listMap.get("remark16");
        remark17 = listMap.get("remark17");
        remark18 = listMap.get("remark18");
        remark19 = listMap.get("remark19");
        remark20 = listMap.get("remark20");
        areaId = listMap.get("areaId");
        areaName = listMap.get("areaName");
        marketFullName = listMap.get("marketFullName");
        nature = listMap.get("nature");
        floors = listMap.get("floors");
        storeInTotal = listMap.get("storeInTotal");
        marketPingyin = listMap.get("marketPingyin");
        canRegist = listMap.get("canRegist");
        webSite = listMap.get("webSite");
    }

    public ShiguMarketExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguMarketExample.Criteria createCriteriaInternal() {
        return new ShiguMarketExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguMarketExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguMarketExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguMarketExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguMarketExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguMarketExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguMarketExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguMarketExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguMarketExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguMarketExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguMarketExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguMarketExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguMarketExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ShiguMarketExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public ShiguMarketExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public ShiguMarketExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public ShiguMarketExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public ShiguMarketExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public ShiguMarketExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public ShiguMarketExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public ShiguMarketExample.Criteria andParentMarketIdIsNull() {
            return isNull(parentMarketId);
        }

        public ShiguMarketExample.Criteria andParentMarketIdIsNotNull() {
            return isNotNull(parentMarketId);
        }

        public ShiguMarketExample.Criteria andParentMarketIdEqualTo(Long value) {
            return equalTo(parentMarketId, value);
        }

        public ShiguMarketExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            return notEqualTo(parentMarketId, value);
        }

        public ShiguMarketExample.Criteria andParentMarketIdGreaterThan(Long value) {
            return greaterThan(parentMarketId, value);
        }

        public ShiguMarketExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentMarketId, value);
        }

        public ShiguMarketExample.Criteria andParentMarketIdLessThan(Long value) {
            return lessThan(parentMarketId, value);
        }

        public ShiguMarketExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentMarketId, value);
        }

        public ShiguMarketExample.Criteria andParentMarketIdIn(List<Long> values) {
            return in(parentMarketId, values);
        }

        public ShiguMarketExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            return notIn(parentMarketId, values);
        }

        public ShiguMarketExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            return between(parentMarketId, value1, value2);
        }

        public ShiguMarketExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(parentMarketId, value1, value2);
        }
        public ShiguMarketExample.Criteria andParentMarketNameIsNull() {
            return isNull(parentMarketName);
        }

        public ShiguMarketExample.Criteria andParentMarketNameIsNotNull() {
            return isNotNull(parentMarketName);
        }

        public ShiguMarketExample.Criteria andParentMarketNameEqualTo(String value) {
            return equalTo(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotEqualTo(String value) {
            return notEqualTo(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameGreaterThan(String value) {
            return greaterThan(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameLessThan(String value) {
            return lessThan(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameLike(String value) {
            return like(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotLike(String value) {
            return notLike(parentMarketName, value);
        }

        public ShiguMarketExample.Criteria andParentMarketNameIn(List<String> values) {
            return in(parentMarketName, values);
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotIn(List<String> values) {
            return notIn(parentMarketName, values);
        }

        public ShiguMarketExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            return between(parentMarketName, value1, value2);
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            return notBetween(parentMarketName, value1, value2);
        }
        public ShiguMarketExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public ShiguMarketExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public ShiguMarketExample.Criteria andIsParentEqualTo(Long value) {
            return equalTo(isParent, value);
        }

        public ShiguMarketExample.Criteria andIsParentNotEqualTo(Long value) {
            return notEqualTo(isParent, value);
        }

        public ShiguMarketExample.Criteria andIsParentGreaterThan(Long value) {
            return greaterThan(isParent, value);
        }

        public ShiguMarketExample.Criteria andIsParentGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public ShiguMarketExample.Criteria andIsParentLessThan(Long value) {
            return lessThan(isParent, value);
        }

        public ShiguMarketExample.Criteria andIsParentLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public ShiguMarketExample.Criteria andIsParentIn(List<Long> values) {
            return in(isParent, values);
        }

        public ShiguMarketExample.Criteria andIsParentNotIn(List<Long> values) {
            return notIn(isParent, values);
        }

        public ShiguMarketExample.Criteria andIsParentBetween(Long value1, Long value2) {
            return between(isParent, value1, value2);
        }

        public ShiguMarketExample.Criteria andIsParentNotBetween(Long value1, Long value2) {
            return notBetween(isParent, value1, value2);
        }
        public ShiguMarketExample.Criteria andBuycityIdIsNull() {
            return isNull(buycityId);
        }

        public ShiguMarketExample.Criteria andBuycityIdIsNotNull() {
            return isNotNull(buycityId);
        }

        public ShiguMarketExample.Criteria andBuycityIdEqualTo(Long value) {
            return equalTo(buycityId, value);
        }

        public ShiguMarketExample.Criteria andBuycityIdNotEqualTo(Long value) {
            return notEqualTo(buycityId, value);
        }

        public ShiguMarketExample.Criteria andBuycityIdGreaterThan(Long value) {
            return greaterThan(buycityId, value);
        }

        public ShiguMarketExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buycityId, value);
        }

        public ShiguMarketExample.Criteria andBuycityIdLessThan(Long value) {
            return lessThan(buycityId, value);
        }

        public ShiguMarketExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buycityId, value);
        }

        public ShiguMarketExample.Criteria andBuycityIdIn(List<Long> values) {
            return in(buycityId, values);
        }

        public ShiguMarketExample.Criteria andBuycityIdNotIn(List<Long> values) {
            return notIn(buycityId, values);
        }

        public ShiguMarketExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            return between(buycityId, value1, value2);
        }

        public ShiguMarketExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            return notBetween(buycityId, value1, value2);
        }
        public ShiguMarketExample.Criteria andProvinceIdIsNull() {
            return isNull(provinceId);
        }

        public ShiguMarketExample.Criteria andProvinceIdIsNotNull() {
            return isNotNull(provinceId);
        }

        public ShiguMarketExample.Criteria andProvinceIdEqualTo(Long value) {
            return equalTo(provinceId, value);
        }

        public ShiguMarketExample.Criteria andProvinceIdNotEqualTo(Long value) {
            return notEqualTo(provinceId, value);
        }

        public ShiguMarketExample.Criteria andProvinceIdGreaterThan(Long value) {
            return greaterThan(provinceId, value);
        }

        public ShiguMarketExample.Criteria andProvinceIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provinceId, value);
        }

        public ShiguMarketExample.Criteria andProvinceIdLessThan(Long value) {
            return lessThan(provinceId, value);
        }

        public ShiguMarketExample.Criteria andProvinceIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provinceId, value);
        }

        public ShiguMarketExample.Criteria andProvinceIdIn(List<Long> values) {
            return in(provinceId, values);
        }

        public ShiguMarketExample.Criteria andProvinceIdNotIn(List<Long> values) {
            return notIn(provinceId, values);
        }

        public ShiguMarketExample.Criteria andProvinceIdBetween(Long value1, Long value2) {
            return between(provinceId, value1, value2);
        }

        public ShiguMarketExample.Criteria andProvinceIdNotBetween(Long value1, Long value2) {
            return notBetween(provinceId, value1, value2);
        }
        public ShiguMarketExample.Criteria andProvinceNameIsNull() {
            return isNull(provinceName);
        }

        public ShiguMarketExample.Criteria andProvinceNameIsNotNull() {
            return isNotNull(provinceName);
        }

        public ShiguMarketExample.Criteria andProvinceNameEqualTo(String value) {
            return equalTo(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameNotEqualTo(String value) {
            return notEqualTo(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameGreaterThan(String value) {
            return greaterThan(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameLessThan(String value) {
            return lessThan(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameLike(String value) {
            return like(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameNotLike(String value) {
            return notLike(provinceName, value);
        }

        public ShiguMarketExample.Criteria andProvinceNameIn(List<String> values) {
            return in(provinceName, values);
        }

        public ShiguMarketExample.Criteria andProvinceNameNotIn(List<String> values) {
            return notIn(provinceName, values);
        }

        public ShiguMarketExample.Criteria andProvinceNameBetween(String value1, String value2) {
            return between(provinceName, value1, value2);
        }

        public ShiguMarketExample.Criteria andProvinceNameNotBetween(String value1, String value2) {
            return notBetween(provinceName, value1, value2);
        }
        public ShiguMarketExample.Criteria andCityIdIsNull() {
            return isNull(cityId);
        }

        public ShiguMarketExample.Criteria andCityIdIsNotNull() {
            return isNotNull(cityId);
        }

        public ShiguMarketExample.Criteria andCityIdEqualTo(Long value) {
            return equalTo(cityId, value);
        }

        public ShiguMarketExample.Criteria andCityIdNotEqualTo(Long value) {
            return notEqualTo(cityId, value);
        }

        public ShiguMarketExample.Criteria andCityIdGreaterThan(Long value) {
            return greaterThan(cityId, value);
        }

        public ShiguMarketExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cityId, value);
        }

        public ShiguMarketExample.Criteria andCityIdLessThan(Long value) {
            return lessThan(cityId, value);
        }

        public ShiguMarketExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cityId, value);
        }

        public ShiguMarketExample.Criteria andCityIdIn(List<Long> values) {
            return in(cityId, values);
        }

        public ShiguMarketExample.Criteria andCityIdNotIn(List<Long> values) {
            return notIn(cityId, values);
        }

        public ShiguMarketExample.Criteria andCityIdBetween(Long value1, Long value2) {
            return between(cityId, value1, value2);
        }

        public ShiguMarketExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            return notBetween(cityId, value1, value2);
        }
        public ShiguMarketExample.Criteria andCityNameIsNull() {
            return isNull(cityName);
        }

        public ShiguMarketExample.Criteria andCityNameIsNotNull() {
            return isNotNull(cityName);
        }

        public ShiguMarketExample.Criteria andCityNameEqualTo(String value) {
            return equalTo(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameNotEqualTo(String value) {
            return notEqualTo(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameGreaterThan(String value) {
            return greaterThan(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameLessThan(String value) {
            return lessThan(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameLike(String value) {
            return like(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameNotLike(String value) {
            return notLike(cityName, value);
        }

        public ShiguMarketExample.Criteria andCityNameIn(List<String> values) {
            return in(cityName, values);
        }

        public ShiguMarketExample.Criteria andCityNameNotIn(List<String> values) {
            return notIn(cityName, values);
        }

        public ShiguMarketExample.Criteria andCityNameBetween(String value1, String value2) {
            return between(cityName, value1, value2);
        }

        public ShiguMarketExample.Criteria andCityNameNotBetween(String value1, String value2) {
            return notBetween(cityName, value1, value2);
        }
        public ShiguMarketExample.Criteria andMarketAddrIsNull() {
            return isNull(marketAddr);
        }

        public ShiguMarketExample.Criteria andMarketAddrIsNotNull() {
            return isNotNull(marketAddr);
        }

        public ShiguMarketExample.Criteria andMarketAddrEqualTo(String value) {
            return equalTo(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrNotEqualTo(String value) {
            return notEqualTo(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrGreaterThan(String value) {
            return greaterThan(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrLessThan(String value) {
            return lessThan(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrLike(String value) {
            return like(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrNotLike(String value) {
            return notLike(marketAddr, value);
        }

        public ShiguMarketExample.Criteria andMarketAddrIn(List<String> values) {
            return in(marketAddr, values);
        }

        public ShiguMarketExample.Criteria andMarketAddrNotIn(List<String> values) {
            return notIn(marketAddr, values);
        }

        public ShiguMarketExample.Criteria andMarketAddrBetween(String value1, String value2) {
            return between(marketAddr, value1, value2);
        }

        public ShiguMarketExample.Criteria andMarketAddrNotBetween(String value1, String value2) {
            return notBetween(marketAddr, value1, value2);
        }
        public ShiguMarketExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguMarketExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguMarketExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public ShiguMarketExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguMarketExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguMarketExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguMarketExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public ShiguMarketExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguMarketExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public ShiguMarketExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public ShiguMarketExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguMarketExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguMarketExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguMarketExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguMarketExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguMarketExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguMarketExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguMarketExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguMarketExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguMarketExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguMarketExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguMarketExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguMarketExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguMarketExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguMarketExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguMarketExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguMarketExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguMarketExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguMarketExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguMarketExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguMarketExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguMarketExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguMarketExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguMarketExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguMarketExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguMarketExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguMarketExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguMarketExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguMarketExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguMarketExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguMarketExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguMarketExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguMarketExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguMarketExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguMarketExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguMarketExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguMarketExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguMarketExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguMarketExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguMarketExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguMarketExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguMarketExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguMarketExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguMarketExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguMarketExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguMarketExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguMarketExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguMarketExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguMarketExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguMarketExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguMarketExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguMarketExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguMarketExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguMarketExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguMarketExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguMarketExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguMarketExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguMarketExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguMarketExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguMarketExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguMarketExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguMarketExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguMarketExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguMarketExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguMarketExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguMarketExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguMarketExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguMarketExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguMarketExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguMarketExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguMarketExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguMarketExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguMarketExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguMarketExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguMarketExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguMarketExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguMarketExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public ShiguMarketExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public ShiguMarketExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public ShiguMarketExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public ShiguMarketExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public ShiguMarketExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public ShiguMarketExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public ShiguMarketExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public ShiguMarketExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public ShiguMarketExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public ShiguMarketExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public ShiguMarketExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public ShiguMarketExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public ShiguMarketExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public ShiguMarketExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public ShiguMarketExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public ShiguMarketExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public ShiguMarketExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public ShiguMarketExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public ShiguMarketExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public ShiguMarketExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public ShiguMarketExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public ShiguMarketExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public ShiguMarketExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public ShiguMarketExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public ShiguMarketExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public ShiguMarketExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public ShiguMarketExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public ShiguMarketExample.Criteria andAreaIdIsNull() {
            return isNull(areaId);
        }

        public ShiguMarketExample.Criteria andAreaIdIsNotNull() {
            return isNotNull(areaId);
        }

        public ShiguMarketExample.Criteria andAreaIdEqualTo(Long value) {
            return equalTo(areaId, value);
        }

        public ShiguMarketExample.Criteria andAreaIdNotEqualTo(Long value) {
            return notEqualTo(areaId, value);
        }

        public ShiguMarketExample.Criteria andAreaIdGreaterThan(Long value) {
            return greaterThan(areaId, value);
        }

        public ShiguMarketExample.Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(areaId, value);
        }

        public ShiguMarketExample.Criteria andAreaIdLessThan(Long value) {
            return lessThan(areaId, value);
        }

        public ShiguMarketExample.Criteria andAreaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(areaId, value);
        }

        public ShiguMarketExample.Criteria andAreaIdIn(List<Long> values) {
            return in(areaId, values);
        }

        public ShiguMarketExample.Criteria andAreaIdNotIn(List<Long> values) {
            return notIn(areaId, values);
        }

        public ShiguMarketExample.Criteria andAreaIdBetween(Long value1, Long value2) {
            return between(areaId, value1, value2);
        }

        public ShiguMarketExample.Criteria andAreaIdNotBetween(Long value1, Long value2) {
            return notBetween(areaId, value1, value2);
        }
        public ShiguMarketExample.Criteria andAreaNameIsNull() {
            return isNull(areaName);
        }

        public ShiguMarketExample.Criteria andAreaNameIsNotNull() {
            return isNotNull(areaName);
        }

        public ShiguMarketExample.Criteria andAreaNameEqualTo(String value) {
            return equalTo(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameNotEqualTo(String value) {
            return notEqualTo(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameGreaterThan(String value) {
            return greaterThan(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameLessThan(String value) {
            return lessThan(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameLike(String value) {
            return like(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameNotLike(String value) {
            return notLike(areaName, value);
        }

        public ShiguMarketExample.Criteria andAreaNameIn(List<String> values) {
            return in(areaName, values);
        }

        public ShiguMarketExample.Criteria andAreaNameNotIn(List<String> values) {
            return notIn(areaName, values);
        }

        public ShiguMarketExample.Criteria andAreaNameBetween(String value1, String value2) {
            return between(areaName, value1, value2);
        }

        public ShiguMarketExample.Criteria andAreaNameNotBetween(String value1, String value2) {
            return notBetween(areaName, value1, value2);
        }
        public ShiguMarketExample.Criteria andMarketFullNameIsNull() {
            return isNull(marketFullName);
        }

        public ShiguMarketExample.Criteria andMarketFullNameIsNotNull() {
            return isNotNull(marketFullName);
        }

        public ShiguMarketExample.Criteria andMarketFullNameEqualTo(String value) {
            return equalTo(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotEqualTo(String value) {
            return notEqualTo(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameGreaterThan(String value) {
            return greaterThan(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameLessThan(String value) {
            return lessThan(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameLike(String value) {
            return like(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotLike(String value) {
            return notLike(marketFullName, value);
        }

        public ShiguMarketExample.Criteria andMarketFullNameIn(List<String> values) {
            return in(marketFullName, values);
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotIn(List<String> values) {
            return notIn(marketFullName, values);
        }

        public ShiguMarketExample.Criteria andMarketFullNameBetween(String value1, String value2) {
            return between(marketFullName, value1, value2);
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotBetween(String value1, String value2) {
            return notBetween(marketFullName, value1, value2);
        }
        public ShiguMarketExample.Criteria andNatureIsNull() {
            return isNull(nature);
        }

        public ShiguMarketExample.Criteria andNatureIsNotNull() {
            return isNotNull(nature);
        }

        public ShiguMarketExample.Criteria andNatureEqualTo(String value) {
            return equalTo(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureNotEqualTo(String value) {
            return notEqualTo(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureGreaterThan(String value) {
            return greaterThan(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureLessThan(String value) {
            return lessThan(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureLike(String value) {
            return like(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureNotLike(String value) {
            return notLike(nature, value);
        }

        public ShiguMarketExample.Criteria andNatureIn(List<String> values) {
            return in(nature, values);
        }

        public ShiguMarketExample.Criteria andNatureNotIn(List<String> values) {
            return notIn(nature, values);
        }

        public ShiguMarketExample.Criteria andNatureBetween(String value1, String value2) {
            return between(nature, value1, value2);
        }

        public ShiguMarketExample.Criteria andNatureNotBetween(String value1, String value2) {
            return notBetween(nature, value1, value2);
        }
        public ShiguMarketExample.Criteria andFloorsIsNull() {
            return isNull(floors);
        }

        public ShiguMarketExample.Criteria andFloorsIsNotNull() {
            return isNotNull(floors);
        }

        public ShiguMarketExample.Criteria andFloorsEqualTo(String value) {
            return equalTo(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsNotEqualTo(String value) {
            return notEqualTo(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsGreaterThan(String value) {
            return greaterThan(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsLessThan(String value) {
            return lessThan(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsLike(String value) {
            return like(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsNotLike(String value) {
            return notLike(floors, value);
        }

        public ShiguMarketExample.Criteria andFloorsIn(List<String> values) {
            return in(floors, values);
        }

        public ShiguMarketExample.Criteria andFloorsNotIn(List<String> values) {
            return notIn(floors, values);
        }

        public ShiguMarketExample.Criteria andFloorsBetween(String value1, String value2) {
            return between(floors, value1, value2);
        }

        public ShiguMarketExample.Criteria andFloorsNotBetween(String value1, String value2) {
            return notBetween(floors, value1, value2);
        }
        public ShiguMarketExample.Criteria andStoreInTotalIsNull() {
            return isNull(storeInTotal);
        }

        public ShiguMarketExample.Criteria andStoreInTotalIsNotNull() {
            return isNotNull(storeInTotal);
        }

        public ShiguMarketExample.Criteria andStoreInTotalEqualTo(Integer value) {
            return equalTo(storeInTotal, value);
        }

        public ShiguMarketExample.Criteria andStoreInTotalNotEqualTo(Integer value) {
            return notEqualTo(storeInTotal, value);
        }

        public ShiguMarketExample.Criteria andStoreInTotalGreaterThan(Integer value) {
            return greaterThan(storeInTotal, value);
        }

        public ShiguMarketExample.Criteria andStoreInTotalGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(storeInTotal, value);
        }

        public ShiguMarketExample.Criteria andStoreInTotalLessThan(Integer value) {
            return lessThan(storeInTotal, value);
        }

        public ShiguMarketExample.Criteria andStoreInTotalLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(storeInTotal, value);
        }

        public ShiguMarketExample.Criteria andStoreInTotalIn(List<Integer> values) {
            return in(storeInTotal, values);
        }

        public ShiguMarketExample.Criteria andStoreInTotalNotIn(List<Integer> values) {
            return notIn(storeInTotal, values);
        }

        public ShiguMarketExample.Criteria andStoreInTotalBetween(Integer value1, Integer value2) {
            return between(storeInTotal, value1, value2);
        }

        public ShiguMarketExample.Criteria andStoreInTotalNotBetween(Integer value1, Integer value2) {
            return notBetween(storeInTotal, value1, value2);
        }
        public ShiguMarketExample.Criteria andMarketPingyinIsNull() {
            return isNull(marketPingyin);
        }

        public ShiguMarketExample.Criteria andMarketPingyinIsNotNull() {
            return isNotNull(marketPingyin);
        }

        public ShiguMarketExample.Criteria andMarketPingyinEqualTo(String value) {
            return equalTo(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotEqualTo(String value) {
            return notEqualTo(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinGreaterThan(String value) {
            return greaterThan(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinLessThan(String value) {
            return lessThan(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinLike(String value) {
            return like(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotLike(String value) {
            return notLike(marketPingyin, value);
        }

        public ShiguMarketExample.Criteria andMarketPingyinIn(List<String> values) {
            return in(marketPingyin, values);
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotIn(List<String> values) {
            return notIn(marketPingyin, values);
        }

        public ShiguMarketExample.Criteria andMarketPingyinBetween(String value1, String value2) {
            return between(marketPingyin, value1, value2);
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotBetween(String value1, String value2) {
            return notBetween(marketPingyin, value1, value2);
        }
        public ShiguMarketExample.Criteria andCanRegistIsNull() {
            return isNull(canRegist);
        }

        public ShiguMarketExample.Criteria andCanRegistIsNotNull() {
            return isNotNull(canRegist);
        }

        public ShiguMarketExample.Criteria andCanRegistEqualTo(Integer value) {
            return equalTo(canRegist, value);
        }

        public ShiguMarketExample.Criteria andCanRegistNotEqualTo(Integer value) {
            return notEqualTo(canRegist, value);
        }

        public ShiguMarketExample.Criteria andCanRegistGreaterThan(Integer value) {
            return greaterThan(canRegist, value);
        }

        public ShiguMarketExample.Criteria andCanRegistGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(canRegist, value);
        }

        public ShiguMarketExample.Criteria andCanRegistLessThan(Integer value) {
            return lessThan(canRegist, value);
        }

        public ShiguMarketExample.Criteria andCanRegistLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(canRegist, value);
        }

        public ShiguMarketExample.Criteria andCanRegistIn(List<Integer> values) {
            return in(canRegist, values);
        }

        public ShiguMarketExample.Criteria andCanRegistNotIn(List<Integer> values) {
            return notIn(canRegist, values);
        }

        public ShiguMarketExample.Criteria andCanRegistBetween(Integer value1, Integer value2) {
            return between(canRegist, value1, value2);
        }

        public ShiguMarketExample.Criteria andCanRegistNotBetween(Integer value1, Integer value2) {
            return notBetween(canRegist, value1, value2);
        }
        public ShiguMarketExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguMarketExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguMarketExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguMarketExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguMarketExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguMarketExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguMarketExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
    }
}