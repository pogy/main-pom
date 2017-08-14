package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguSite;

import java.util.*;
public class ShiguSiteExample extends SgExample<ShiguSiteExample.Criteria> {
    public static final Class<ShiguSite> beanClass = ShiguSite.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remark18;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn siteName;
    public static EntityColumn cityId;
    public static EntityColumn remark19;
    public static EntityColumn cityName;
    public static EntityColumn citySite;
    public static EntityColumn remark20;
    public static EntityColumn provinceId;
    public static EntityColumn remark9;
    public static EntityColumn siteIp;
    public static EntityColumn remark8;
    public static EntityColumn buycityId;
    public static EntityColumn domain;
    public static EntityColumn sortOrder;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn provinceName;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        remark18 = listMap.get("remark18");
        remark17 = listMap.get("remark17");
        remark16 = listMap.get("remark16");
        remark15 = listMap.get("remark15");
        remark14 = listMap.get("remark14");
        remark13 = listMap.get("remark13");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        siteName = listMap.get("siteName");
        cityId = listMap.get("cityId");
        remark19 = listMap.get("remark19");
        cityName = listMap.get("cityName");
        citySite = listMap.get("citySite");
        remark20 = listMap.get("remark20");
        provinceId = listMap.get("provinceId");
        remark9 = listMap.get("remark9");
        siteIp = listMap.get("siteIp");
        remark8 = listMap.get("remark8");
        buycityId = listMap.get("buycityId");
        domain = listMap.get("domain");
        sortOrder = listMap.get("sortOrder");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        provinceName = listMap.get("provinceName");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public ShiguSiteExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguSiteExample.Criteria createCriteriaInternal() {
        return new ShiguSiteExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguSiteExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public ShiguSiteExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public ShiguSiteExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public ShiguSiteExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public ShiguSiteExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public ShiguSiteExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public ShiguSiteExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public ShiguSiteExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public ShiguSiteExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public ShiguSiteExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public ShiguSiteExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public ShiguSiteExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public ShiguSiteExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguSiteExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguSiteExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguSiteExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguSiteExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguSiteExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguSiteExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguSiteExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguSiteExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguSiteExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguSiteExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguSiteExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguSiteExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguSiteExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguSiteExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguSiteExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguSiteExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguSiteExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguSiteExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguSiteExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguSiteExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguSiteExample.Criteria andSiteNameIsNull() {
            return isNull(siteName);
        }

        public ShiguSiteExample.Criteria andSiteNameIsNotNull() {
            return isNotNull(siteName);
        }

        public ShiguSiteExample.Criteria andSiteNameEqualTo(String value) {
            return equalTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameNotEqualTo(String value) {
            return notEqualTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameGreaterThan(String value) {
            return greaterThan(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameLessThan(String value) {
            return lessThan(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameLike(String value) {
            return like(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameNotLike(String value) {
            return notLike(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameIn(List<String> values) {
            return in(siteName, values);
        }

        public ShiguSiteExample.Criteria andSiteNameNotIn(List<String> values) {
            return notIn(siteName, values);
        }

        public ShiguSiteExample.Criteria andSiteNameBetween(String value1, String value2) {
            return between(siteName, value1, value2);
        }

        public ShiguSiteExample.Criteria andSiteNameNotBetween(String value1, String value2) {
            return notBetween(siteName, value1, value2);
        }
        public ShiguSiteExample.Criteria andCityIdIsNull() {
            return isNull(cityId);
        }

        public ShiguSiteExample.Criteria andCityIdIsNotNull() {
            return isNotNull(cityId);
        }

        public ShiguSiteExample.Criteria andCityIdEqualTo(Long value) {
            return equalTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdNotEqualTo(Long value) {
            return notEqualTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdGreaterThan(Long value) {
            return greaterThan(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdLessThan(Long value) {
            return lessThan(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdIn(List<Long> values) {
            return in(cityId, values);
        }

        public ShiguSiteExample.Criteria andCityIdNotIn(List<Long> values) {
            return notIn(cityId, values);
        }

        public ShiguSiteExample.Criteria andCityIdBetween(Long value1, Long value2) {
            return between(cityId, value1, value2);
        }

        public ShiguSiteExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            return notBetween(cityId, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public ShiguSiteExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public ShiguSiteExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public ShiguSiteExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public ShiguSiteExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public ShiguSiteExample.Criteria andCityNameIsNull() {
            return isNull(cityName);
        }

        public ShiguSiteExample.Criteria andCityNameIsNotNull() {
            return isNotNull(cityName);
        }

        public ShiguSiteExample.Criteria andCityNameEqualTo(String value) {
            return equalTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameNotEqualTo(String value) {
            return notEqualTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameGreaterThan(String value) {
            return greaterThan(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameLessThan(String value) {
            return lessThan(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameLike(String value) {
            return like(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameNotLike(String value) {
            return notLike(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameIn(List<String> values) {
            return in(cityName, values);
        }

        public ShiguSiteExample.Criteria andCityNameNotIn(List<String> values) {
            return notIn(cityName, values);
        }

        public ShiguSiteExample.Criteria andCityNameBetween(String value1, String value2) {
            return between(cityName, value1, value2);
        }

        public ShiguSiteExample.Criteria andCityNameNotBetween(String value1, String value2) {
            return notBetween(cityName, value1, value2);
        }
        public ShiguSiteExample.Criteria andCitySiteIsNull() {
            return isNull(citySite);
        }

        public ShiguSiteExample.Criteria andCitySiteIsNotNull() {
            return isNotNull(citySite);
        }

        public ShiguSiteExample.Criteria andCitySiteEqualTo(String value) {
            return equalTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteNotEqualTo(String value) {
            return notEqualTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteGreaterThan(String value) {
            return greaterThan(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteLessThan(String value) {
            return lessThan(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteLike(String value) {
            return like(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteNotLike(String value) {
            return notLike(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteIn(List<String> values) {
            return in(citySite, values);
        }

        public ShiguSiteExample.Criteria andCitySiteNotIn(List<String> values) {
            return notIn(citySite, values);
        }

        public ShiguSiteExample.Criteria andCitySiteBetween(String value1, String value2) {
            return between(citySite, value1, value2);
        }

        public ShiguSiteExample.Criteria andCitySiteNotBetween(String value1, String value2) {
            return notBetween(citySite, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public ShiguSiteExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public ShiguSiteExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public ShiguSiteExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public ShiguSiteExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public ShiguSiteExample.Criteria andProvinceIdIsNull() {
            return isNull(provinceId);
        }

        public ShiguSiteExample.Criteria andProvinceIdIsNotNull() {
            return isNotNull(provinceId);
        }

        public ShiguSiteExample.Criteria andProvinceIdEqualTo(Long value) {
            return equalTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdNotEqualTo(Long value) {
            return notEqualTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdGreaterThan(Long value) {
            return greaterThan(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdLessThan(Long value) {
            return lessThan(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdIn(List<Long> values) {
            return in(provinceId, values);
        }

        public ShiguSiteExample.Criteria andProvinceIdNotIn(List<Long> values) {
            return notIn(provinceId, values);
        }

        public ShiguSiteExample.Criteria andProvinceIdBetween(Long value1, Long value2) {
            return between(provinceId, value1, value2);
        }

        public ShiguSiteExample.Criteria andProvinceIdNotBetween(Long value1, Long value2) {
            return notBetween(provinceId, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguSiteExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguSiteExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguSiteExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguSiteExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguSiteExample.Criteria andSiteIpIsNull() {
            return isNull(siteIp);
        }

        public ShiguSiteExample.Criteria andSiteIpIsNotNull() {
            return isNotNull(siteIp);
        }

        public ShiguSiteExample.Criteria andSiteIpEqualTo(String value) {
            return equalTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpNotEqualTo(String value) {
            return notEqualTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpGreaterThan(String value) {
            return greaterThan(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpLessThan(String value) {
            return lessThan(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpLike(String value) {
            return like(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpNotLike(String value) {
            return notLike(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpIn(List<String> values) {
            return in(siteIp, values);
        }

        public ShiguSiteExample.Criteria andSiteIpNotIn(List<String> values) {
            return notIn(siteIp, values);
        }

        public ShiguSiteExample.Criteria andSiteIpBetween(String value1, String value2) {
            return between(siteIp, value1, value2);
        }

        public ShiguSiteExample.Criteria andSiteIpNotBetween(String value1, String value2) {
            return notBetween(siteIp, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguSiteExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguSiteExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguSiteExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguSiteExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguSiteExample.Criteria andBuycityIdIsNull() {
            return isNull(buycityId);
        }

        public ShiguSiteExample.Criteria andBuycityIdIsNotNull() {
            return isNotNull(buycityId);
        }

        public ShiguSiteExample.Criteria andBuycityIdEqualTo(Long value) {
            return equalTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdNotEqualTo(Long value) {
            return notEqualTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdGreaterThan(Long value) {
            return greaterThan(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdLessThan(Long value) {
            return lessThan(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdIn(List<Long> values) {
            return in(buycityId, values);
        }

        public ShiguSiteExample.Criteria andBuycityIdNotIn(List<Long> values) {
            return notIn(buycityId, values);
        }

        public ShiguSiteExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            return between(buycityId, value1, value2);
        }

        public ShiguSiteExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            return notBetween(buycityId, value1, value2);
        }
        public ShiguSiteExample.Criteria andDomainIsNull() {
            return isNull(domain);
        }

        public ShiguSiteExample.Criteria andDomainIsNotNull() {
            return isNotNull(domain);
        }

        public ShiguSiteExample.Criteria andDomainEqualTo(String value) {
            return equalTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainNotEqualTo(String value) {
            return notEqualTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainGreaterThan(String value) {
            return greaterThan(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainLessThan(String value) {
            return lessThan(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainLike(String value) {
            return like(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainNotLike(String value) {
            return notLike(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainIn(List<String> values) {
            return in(domain, values);
        }

        public ShiguSiteExample.Criteria andDomainNotIn(List<String> values) {
            return notIn(domain, values);
        }

        public ShiguSiteExample.Criteria andDomainBetween(String value1, String value2) {
            return between(domain, value1, value2);
        }

        public ShiguSiteExample.Criteria andDomainNotBetween(String value1, String value2) {
            return notBetween(domain, value1, value2);
        }
        public ShiguSiteExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguSiteExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguSiteExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public ShiguSiteExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public ShiguSiteExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguSiteExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguSiteExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguSiteExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguSiteExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguSiteExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguSiteExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguSiteExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguSiteExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguSiteExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguSiteExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguSiteExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguSiteExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguSiteExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguSiteExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguSiteExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguSiteExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguSiteExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguSiteExample.Criteria andProvinceNameIsNull() {
            return isNull(provinceName);
        }

        public ShiguSiteExample.Criteria andProvinceNameIsNotNull() {
            return isNotNull(provinceName);
        }

        public ShiguSiteExample.Criteria andProvinceNameEqualTo(String value) {
            return equalTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameNotEqualTo(String value) {
            return notEqualTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameGreaterThan(String value) {
            return greaterThan(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameLessThan(String value) {
            return lessThan(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameLike(String value) {
            return like(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameNotLike(String value) {
            return notLike(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameIn(List<String> values) {
            return in(provinceName, values);
        }

        public ShiguSiteExample.Criteria andProvinceNameNotIn(List<String> values) {
            return notIn(provinceName, values);
        }

        public ShiguSiteExample.Criteria andProvinceNameBetween(String value1, String value2) {
            return between(provinceName, value1, value2);
        }

        public ShiguSiteExample.Criteria andProvinceNameNotBetween(String value1, String value2) {
            return notBetween(provinceName, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguSiteExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguSiteExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguSiteExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguSiteExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguSiteExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguSiteExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguSiteExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguSiteExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguSiteExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguSiteExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguSiteExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguSiteExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguSiteExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguSiteExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguSiteExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguSiteExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
