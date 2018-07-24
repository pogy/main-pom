package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguSite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：ShiguSiteExample.java
 *@文件路径：com.opentae.data.mall.examples.ShiguSiteExample
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 01:22:22
 *@comments:
 *
 *=========================================================
 */
public class ShiguSiteExample extends SgExample<ShiguSiteExample.Criteria>{
    public static final Class<ShiguSite> beanClass = ShiguSite.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn buycityId;
    public static EntityColumn siteName;
    public static EntityColumn domain;
    public static EntityColumn siteIp;
    public static EntityColumn citySite;
    public static EntityColumn sortOrder;
    public static EntityColumn provinceId;
    public static EntityColumn provinceName;
    public static EntityColumn cityId;
    public static EntityColumn cityName;
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

    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        buycityId = listMap.get("buycityId");
        siteName = listMap.get("siteName");
        domain = listMap.get("domain");
        siteIp = listMap.get("siteIp");
        citySite = listMap.get("citySite");
        sortOrder = listMap.get("sortOrder");
        provinceId = listMap.get("provinceId");
        provinceName = listMap.get("provinceName");
        cityId = listMap.get("cityId");
        cityName = listMap.get("cityName");
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
    }

    public ShiguSiteExample() {
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
        public ShiguSiteExample.Criteria andBuycityIdIsNull() {
            return isNull(buycityId);
        }

        public ShiguSiteExample.Criteria andBuycityIdIsNotNull() {
            return isNotNull(buycityId);
        }

        public ShiguSiteExample.Criteria andBuycityIdEqualTo(java.lang.Long value) {
            return equalTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdNotEqualTo(java.lang.Long value) {
            return notEqualTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdGreaterThan(java.lang.Long value) {
            return greaterThan(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdLessThan(java.lang.Long value) {
            return lessThan(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(buycityId, value);
        }

        public ShiguSiteExample.Criteria andBuycityIdIn(List<java.lang.Long> values) {
            return in(buycityId, values);
        }

        public ShiguSiteExample.Criteria andBuycityIdNotIn(List<java.lang.Long> values) {
            return notIn(buycityId, values);
        }

        public ShiguSiteExample.Criteria andBuycityIdBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(buycityId, value1, value2);
        }

        public ShiguSiteExample.Criteria andBuycityIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(buycityId, value1, value2);
        }
        public ShiguSiteExample.Criteria andBuycityIdLike(String value) {return like(buycityId, value);}

        public ShiguSiteExample.Criteria andBuycityIdNotLike(String value) {
            return notLike(buycityId, value);
        }

        public ShiguSiteExample.Criteria andSiteNameIsNull() {
            return isNull(siteName);
        }

        public ShiguSiteExample.Criteria andSiteNameIsNotNull() {
            return isNotNull(siteName);
        }

        public ShiguSiteExample.Criteria andSiteNameEqualTo(java.lang.String value) {
            return equalTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameNotEqualTo(java.lang.String value) {
            return notEqualTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameGreaterThan(java.lang.String value) {
            return greaterThan(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameLessThan(java.lang.String value) {
            return lessThan(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(siteName, value);
        }

        public ShiguSiteExample.Criteria andSiteNameIn(List<java.lang.String> values) {
            return in(siteName, values);
        }

        public ShiguSiteExample.Criteria andSiteNameNotIn(List<java.lang.String> values) {
            return notIn(siteName, values);
        }

        public ShiguSiteExample.Criteria andSiteNameBetween(java.lang.String value1, java.lang.String value2) {
            return between(siteName, value1, value2);
        }

        public ShiguSiteExample.Criteria andSiteNameNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(siteName, value1, value2);
        }
        public ShiguSiteExample.Criteria andSiteNameLike(String value) {return like(siteName, value);}

        public ShiguSiteExample.Criteria andSiteNameNotLike(String value) {
            return notLike(siteName, value);
        }

        public ShiguSiteExample.Criteria andDomainIsNull() {
            return isNull(domain);
        }

        public ShiguSiteExample.Criteria andDomainIsNotNull() {
            return isNotNull(domain);
        }

        public ShiguSiteExample.Criteria andDomainEqualTo(java.lang.String value) {
            return equalTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainNotEqualTo(java.lang.String value) {
            return notEqualTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainGreaterThan(java.lang.String value) {
            return greaterThan(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainLessThan(java.lang.String value) {
            return lessThan(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(domain, value);
        }

        public ShiguSiteExample.Criteria andDomainIn(List<java.lang.String> values) {
            return in(domain, values);
        }

        public ShiguSiteExample.Criteria andDomainNotIn(List<java.lang.String> values) {
            return notIn(domain, values);
        }

        public ShiguSiteExample.Criteria andDomainBetween(java.lang.String value1, java.lang.String value2) {
            return between(domain, value1, value2);
        }

        public ShiguSiteExample.Criteria andDomainNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(domain, value1, value2);
        }
        public ShiguSiteExample.Criteria andDomainLike(String value) {return like(domain, value);}

        public ShiguSiteExample.Criteria andDomainNotLike(String value) {
            return notLike(domain, value);
        }

        public ShiguSiteExample.Criteria andSiteIpIsNull() {
            return isNull(siteIp);
        }

        public ShiguSiteExample.Criteria andSiteIpIsNotNull() {
            return isNotNull(siteIp);
        }

        public ShiguSiteExample.Criteria andSiteIpEqualTo(java.lang.String value) {
            return equalTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpNotEqualTo(java.lang.String value) {
            return notEqualTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpGreaterThan(java.lang.String value) {
            return greaterThan(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpLessThan(java.lang.String value) {
            return lessThan(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(siteIp, value);
        }

        public ShiguSiteExample.Criteria andSiteIpIn(List<java.lang.String> values) {
            return in(siteIp, values);
        }

        public ShiguSiteExample.Criteria andSiteIpNotIn(List<java.lang.String> values) {
            return notIn(siteIp, values);
        }

        public ShiguSiteExample.Criteria andSiteIpBetween(java.lang.String value1, java.lang.String value2) {
            return between(siteIp, value1, value2);
        }

        public ShiguSiteExample.Criteria andSiteIpNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(siteIp, value1, value2);
        }
        public ShiguSiteExample.Criteria andSiteIpLike(String value) {return like(siteIp, value);}

        public ShiguSiteExample.Criteria andSiteIpNotLike(String value) {
            return notLike(siteIp, value);
        }

        public ShiguSiteExample.Criteria andCitySiteIsNull() {
            return isNull(citySite);
        }

        public ShiguSiteExample.Criteria andCitySiteIsNotNull() {
            return isNotNull(citySite);
        }

        public ShiguSiteExample.Criteria andCitySiteEqualTo(java.lang.String value) {
            return equalTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteNotEqualTo(java.lang.String value) {
            return notEqualTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteGreaterThan(java.lang.String value) {
            return greaterThan(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteLessThan(java.lang.String value) {
            return lessThan(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(citySite, value);
        }

        public ShiguSiteExample.Criteria andCitySiteIn(List<java.lang.String> values) {
            return in(citySite, values);
        }

        public ShiguSiteExample.Criteria andCitySiteNotIn(List<java.lang.String> values) {
            return notIn(citySite, values);
        }

        public ShiguSiteExample.Criteria andCitySiteBetween(java.lang.String value1, java.lang.String value2) {
            return between(citySite, value1, value2);
        }

        public ShiguSiteExample.Criteria andCitySiteNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(citySite, value1, value2);
        }
        public ShiguSiteExample.Criteria andCitySiteLike(String value) {return like(citySite, value);}

        public ShiguSiteExample.Criteria andCitySiteNotLike(String value) {
            return notLike(citySite, value);
        }

        public ShiguSiteExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguSiteExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguSiteExample.Criteria andSortOrderEqualTo(java.lang.Long value) {
            return equalTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderNotEqualTo(java.lang.Long value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderGreaterThan(java.lang.Long value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderLessThan(java.lang.Long value) {
            return lessThan(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andSortOrderIn(List<java.lang.Long> values) {
            return in(sortOrder, values);
        }

        public ShiguSiteExample.Criteria andSortOrderNotIn(List<java.lang.Long> values) {
            return notIn(sortOrder, values);
        }

        public ShiguSiteExample.Criteria andSortOrderBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguSiteExample.Criteria andSortOrderNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguSiteExample.Criteria andSortOrderLike(String value) {return like(sortOrder, value);}

        public ShiguSiteExample.Criteria andSortOrderNotLike(String value) {
            return notLike(sortOrder, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdIsNull() {
            return isNull(provinceId);
        }

        public ShiguSiteExample.Criteria andProvinceIdIsNotNull() {
            return isNotNull(provinceId);
        }

        public ShiguSiteExample.Criteria andProvinceIdEqualTo(java.lang.Long value) {
            return equalTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdNotEqualTo(java.lang.Long value) {
            return notEqualTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdGreaterThan(java.lang.Long value) {
            return greaterThan(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdLessThan(java.lang.Long value) {
            return lessThan(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceIdIn(List<java.lang.Long> values) {
            return in(provinceId, values);
        }

        public ShiguSiteExample.Criteria andProvinceIdNotIn(List<java.lang.Long> values) {
            return notIn(provinceId, values);
        }

        public ShiguSiteExample.Criteria andProvinceIdBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(provinceId, value1, value2);
        }

        public ShiguSiteExample.Criteria andProvinceIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(provinceId, value1, value2);
        }
        public ShiguSiteExample.Criteria andProvinceIdLike(String value) {return like(provinceId, value);}

        public ShiguSiteExample.Criteria andProvinceIdNotLike(String value) {
            return notLike(provinceId, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameIsNull() {
            return isNull(provinceName);
        }

        public ShiguSiteExample.Criteria andProvinceNameIsNotNull() {
            return isNotNull(provinceName);
        }

        public ShiguSiteExample.Criteria andProvinceNameEqualTo(java.lang.String value) {
            return equalTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameNotEqualTo(java.lang.String value) {
            return notEqualTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameGreaterThan(java.lang.String value) {
            return greaterThan(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameLessThan(java.lang.String value) {
            return lessThan(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(provinceName, value);
        }

        public ShiguSiteExample.Criteria andProvinceNameIn(List<java.lang.String> values) {
            return in(provinceName, values);
        }

        public ShiguSiteExample.Criteria andProvinceNameNotIn(List<java.lang.String> values) {
            return notIn(provinceName, values);
        }

        public ShiguSiteExample.Criteria andProvinceNameBetween(java.lang.String value1, java.lang.String value2) {
            return between(provinceName, value1, value2);
        }

        public ShiguSiteExample.Criteria andProvinceNameNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(provinceName, value1, value2);
        }
        public ShiguSiteExample.Criteria andProvinceNameLike(String value) {return like(provinceName, value);}

        public ShiguSiteExample.Criteria andProvinceNameNotLike(String value) {
            return notLike(provinceName, value);
        }

        public ShiguSiteExample.Criteria andCityIdIsNull() {
            return isNull(cityId);
        }

        public ShiguSiteExample.Criteria andCityIdIsNotNull() {
            return isNotNull(cityId);
        }

        public ShiguSiteExample.Criteria andCityIdEqualTo(java.lang.Long value) {
            return equalTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdNotEqualTo(java.lang.Long value) {
            return notEqualTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdGreaterThan(java.lang.Long value) {
            return greaterThan(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdLessThan(java.lang.Long value) {
            return lessThan(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityIdIn(List<java.lang.Long> values) {
            return in(cityId, values);
        }

        public ShiguSiteExample.Criteria andCityIdNotIn(List<java.lang.Long> values) {
            return notIn(cityId, values);
        }

        public ShiguSiteExample.Criteria andCityIdBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(cityId, value1, value2);
        }

        public ShiguSiteExample.Criteria andCityIdNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(cityId, value1, value2);
        }
        public ShiguSiteExample.Criteria andCityIdLike(String value) {return like(cityId, value);}

        public ShiguSiteExample.Criteria andCityIdNotLike(String value) {
            return notLike(cityId, value);
        }

        public ShiguSiteExample.Criteria andCityNameIsNull() {
            return isNull(cityName);
        }

        public ShiguSiteExample.Criteria andCityNameIsNotNull() {
            return isNotNull(cityName);
        }

        public ShiguSiteExample.Criteria andCityNameEqualTo(java.lang.String value) {
            return equalTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameNotEqualTo(java.lang.String value) {
            return notEqualTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameGreaterThan(java.lang.String value) {
            return greaterThan(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameLessThan(java.lang.String value) {
            return lessThan(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(cityName, value);
        }

        public ShiguSiteExample.Criteria andCityNameIn(List<java.lang.String> values) {
            return in(cityName, values);
        }

        public ShiguSiteExample.Criteria andCityNameNotIn(List<java.lang.String> values) {
            return notIn(cityName, values);
        }

        public ShiguSiteExample.Criteria andCityNameBetween(java.lang.String value1, java.lang.String value2) {
            return between(cityName, value1, value2);
        }

        public ShiguSiteExample.Criteria andCityNameNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(cityName, value1, value2);
        }
        public ShiguSiteExample.Criteria andCityNameLike(String value) {return like(cityName, value);}

        public ShiguSiteExample.Criteria andCityNameNotLike(String value) {
            return notLike(cityName, value);
        }

        public ShiguSiteExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguSiteExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguSiteExample.Criteria andRemark1EqualTo(java.lang.String value) {
            return equalTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1NotEqualTo(java.lang.String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1GreaterThan(java.lang.String value) {
            return greaterThan(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1LessThan(java.lang.String value) {
            return lessThan(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark1In(List<java.lang.String> values) {
            return in(remark1, values);
        }

        public ShiguSiteExample.Criteria andRemark1NotIn(List<java.lang.String> values) {
            return notIn(remark1, values);
        }

        public ShiguSiteExample.Criteria andRemark1Between(java.lang.String value1, java.lang.String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark1NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark1Like(String value) {return like(remark1, value);}

        public ShiguSiteExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguSiteExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguSiteExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguSiteExample.Criteria andRemark2EqualTo(java.lang.String value) {
            return equalTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2NotEqualTo(java.lang.String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2GreaterThan(java.lang.String value) {
            return greaterThan(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2LessThan(java.lang.String value) {
            return lessThan(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark2In(List<java.lang.String> values) {
            return in(remark2, values);
        }

        public ShiguSiteExample.Criteria andRemark2NotIn(List<java.lang.String> values) {
            return notIn(remark2, values);
        }

        public ShiguSiteExample.Criteria andRemark2Between(java.lang.String value1, java.lang.String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark2NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark2, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark2Like(String value) {return like(remark2, value);}

        public ShiguSiteExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguSiteExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguSiteExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguSiteExample.Criteria andRemark3EqualTo(java.lang.String value) {
            return equalTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3NotEqualTo(java.lang.String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3GreaterThan(java.lang.String value) {
            return greaterThan(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3LessThan(java.lang.String value) {
            return lessThan(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark3In(List<java.lang.String> values) {
            return in(remark3, values);
        }

        public ShiguSiteExample.Criteria andRemark3NotIn(List<java.lang.String> values) {
            return notIn(remark3, values);
        }

        public ShiguSiteExample.Criteria andRemark3Between(java.lang.String value1, java.lang.String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark3NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark3Like(String value) {return like(remark3, value);}

        public ShiguSiteExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguSiteExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguSiteExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguSiteExample.Criteria andRemark4EqualTo(java.lang.String value) {
            return equalTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4NotEqualTo(java.lang.String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4GreaterThan(java.lang.String value) {
            return greaterThan(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4LessThan(java.lang.String value) {
            return lessThan(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark4In(List<java.lang.String> values) {
            return in(remark4, values);
        }

        public ShiguSiteExample.Criteria andRemark4NotIn(List<java.lang.String> values) {
            return notIn(remark4, values);
        }

        public ShiguSiteExample.Criteria andRemark4Between(java.lang.String value1, java.lang.String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark4NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark4Like(String value) {return like(remark4, value);}

        public ShiguSiteExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguSiteExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguSiteExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguSiteExample.Criteria andRemark5EqualTo(java.lang.String value) {
            return equalTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5NotEqualTo(java.lang.String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5GreaterThan(java.lang.String value) {
            return greaterThan(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5LessThan(java.lang.String value) {
            return lessThan(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark5In(List<java.lang.String> values) {
            return in(remark5, values);
        }

        public ShiguSiteExample.Criteria andRemark5NotIn(List<java.lang.String> values) {
            return notIn(remark5, values);
        }

        public ShiguSiteExample.Criteria andRemark5Between(java.lang.String value1, java.lang.String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark5NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark5Like(String value) {return like(remark5, value);}

        public ShiguSiteExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguSiteExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguSiteExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguSiteExample.Criteria andRemark6EqualTo(java.lang.String value) {
            return equalTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6NotEqualTo(java.lang.String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6GreaterThan(java.lang.String value) {
            return greaterThan(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6LessThan(java.lang.String value) {
            return lessThan(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark6In(List<java.lang.String> values) {
            return in(remark6, values);
        }

        public ShiguSiteExample.Criteria andRemark6NotIn(List<java.lang.String> values) {
            return notIn(remark6, values);
        }

        public ShiguSiteExample.Criteria andRemark6Between(java.lang.String value1, java.lang.String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark6NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark6Like(String value) {return like(remark6, value);}

        public ShiguSiteExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguSiteExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguSiteExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguSiteExample.Criteria andRemark7EqualTo(java.lang.String value) {
            return equalTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7NotEqualTo(java.lang.String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7GreaterThan(java.lang.String value) {
            return greaterThan(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7LessThan(java.lang.String value) {
            return lessThan(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark7In(List<java.lang.String> values) {
            return in(remark7, values);
        }

        public ShiguSiteExample.Criteria andRemark7NotIn(List<java.lang.String> values) {
            return notIn(remark7, values);
        }

        public ShiguSiteExample.Criteria andRemark7Between(java.lang.String value1, java.lang.String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark7NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark7Like(String value) {return like(remark7, value);}

        public ShiguSiteExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguSiteExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguSiteExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguSiteExample.Criteria andRemark8EqualTo(java.lang.String value) {
            return equalTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8NotEqualTo(java.lang.String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8GreaterThan(java.lang.String value) {
            return greaterThan(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8LessThan(java.lang.String value) {
            return lessThan(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark8In(List<java.lang.String> values) {
            return in(remark8, values);
        }

        public ShiguSiteExample.Criteria andRemark8NotIn(List<java.lang.String> values) {
            return notIn(remark8, values);
        }

        public ShiguSiteExample.Criteria andRemark8Between(java.lang.String value1, java.lang.String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark8NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark8Like(String value) {return like(remark8, value);}

        public ShiguSiteExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguSiteExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguSiteExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguSiteExample.Criteria andRemark9EqualTo(java.lang.String value) {
            return equalTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9NotEqualTo(java.lang.String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9GreaterThan(java.lang.String value) {
            return greaterThan(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9LessThan(java.lang.String value) {
            return lessThan(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark9In(List<java.lang.String> values) {
            return in(remark9, values);
        }

        public ShiguSiteExample.Criteria andRemark9NotIn(List<java.lang.String> values) {
            return notIn(remark9, values);
        }

        public ShiguSiteExample.Criteria andRemark9Between(java.lang.String value1, java.lang.String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark9NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark9Like(String value) {return like(remark9, value);}

        public ShiguSiteExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguSiteExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguSiteExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguSiteExample.Criteria andRemark10EqualTo(java.lang.String value) {
            return equalTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10NotEqualTo(java.lang.String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10GreaterThan(java.lang.String value) {
            return greaterThan(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10LessThan(java.lang.String value) {
            return lessThan(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark10In(List<java.lang.String> values) {
            return in(remark10, values);
        }

        public ShiguSiteExample.Criteria andRemark10NotIn(List<java.lang.String> values) {
            return notIn(remark10, values);
        }

        public ShiguSiteExample.Criteria andRemark10Between(java.lang.String value1, java.lang.String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark10NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark10Like(String value) {return like(remark10, value);}

        public ShiguSiteExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguSiteExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguSiteExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguSiteExample.Criteria andRemark11EqualTo(java.lang.String value) {
            return equalTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11NotEqualTo(java.lang.String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11GreaterThan(java.lang.String value) {
            return greaterThan(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11LessThan(java.lang.String value) {
            return lessThan(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark11In(List<java.lang.String> values) {
            return in(remark11, values);
        }

        public ShiguSiteExample.Criteria andRemark11NotIn(List<java.lang.String> values) {
            return notIn(remark11, values);
        }

        public ShiguSiteExample.Criteria andRemark11Between(java.lang.String value1, java.lang.String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark11NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark11Like(String value) {return like(remark11, value);}

        public ShiguSiteExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguSiteExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguSiteExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguSiteExample.Criteria andRemark12EqualTo(java.lang.String value) {
            return equalTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12NotEqualTo(java.lang.String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12GreaterThan(java.lang.String value) {
            return greaterThan(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12LessThan(java.lang.String value) {
            return lessThan(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark12In(List<java.lang.String> values) {
            return in(remark12, values);
        }

        public ShiguSiteExample.Criteria andRemark12NotIn(List<java.lang.String> values) {
            return notIn(remark12, values);
        }

        public ShiguSiteExample.Criteria andRemark12Between(java.lang.String value1, java.lang.String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark12NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark12Like(String value) {return like(remark12, value);}

        public ShiguSiteExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguSiteExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguSiteExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguSiteExample.Criteria andRemark13EqualTo(java.lang.String value) {
            return equalTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13NotEqualTo(java.lang.String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13GreaterThan(java.lang.String value) {
            return greaterThan(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13LessThan(java.lang.String value) {
            return lessThan(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark13In(List<java.lang.String> values) {
            return in(remark13, values);
        }

        public ShiguSiteExample.Criteria andRemark13NotIn(List<java.lang.String> values) {
            return notIn(remark13, values);
        }

        public ShiguSiteExample.Criteria andRemark13Between(java.lang.String value1, java.lang.String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark13NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark13Like(String value) {return like(remark13, value);}

        public ShiguSiteExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguSiteExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguSiteExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguSiteExample.Criteria andRemark14EqualTo(java.lang.String value) {
            return equalTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14NotEqualTo(java.lang.String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14GreaterThan(java.lang.String value) {
            return greaterThan(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14LessThan(java.lang.String value) {
            return lessThan(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark14In(List<java.lang.String> values) {
            return in(remark14, values);
        }

        public ShiguSiteExample.Criteria andRemark14NotIn(List<java.lang.String> values) {
            return notIn(remark14, values);
        }

        public ShiguSiteExample.Criteria andRemark14Between(java.lang.String value1, java.lang.String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark14NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark14Like(String value) {return like(remark14, value);}

        public ShiguSiteExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguSiteExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguSiteExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguSiteExample.Criteria andRemark15EqualTo(java.lang.String value) {
            return equalTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15NotEqualTo(java.lang.String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15GreaterThan(java.lang.String value) {
            return greaterThan(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15LessThan(java.lang.String value) {
            return lessThan(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark15In(List<java.lang.String> values) {
            return in(remark15, values);
        }

        public ShiguSiteExample.Criteria andRemark15NotIn(List<java.lang.String> values) {
            return notIn(remark15, values);
        }

        public ShiguSiteExample.Criteria andRemark15Between(java.lang.String value1, java.lang.String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark15NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark15Like(String value) {return like(remark15, value);}

        public ShiguSiteExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguSiteExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public ShiguSiteExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public ShiguSiteExample.Criteria andRemark16EqualTo(java.lang.String value) {
            return equalTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16NotEqualTo(java.lang.String value) {
            return notEqualTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16GreaterThan(java.lang.String value) {
            return greaterThan(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16LessThan(java.lang.String value) {
            return lessThan(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark16In(List<java.lang.String> values) {
            return in(remark16, values);
        }

        public ShiguSiteExample.Criteria andRemark16NotIn(List<java.lang.String> values) {
            return notIn(remark16, values);
        }

        public ShiguSiteExample.Criteria andRemark16Between(java.lang.String value1, java.lang.String value2) {
            return between(remark16, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark16NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark16, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark16Like(String value) {return like(remark16, value);}

        public ShiguSiteExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public ShiguSiteExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public ShiguSiteExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public ShiguSiteExample.Criteria andRemark17EqualTo(java.lang.String value) {
            return equalTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17NotEqualTo(java.lang.String value) {
            return notEqualTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17GreaterThan(java.lang.String value) {
            return greaterThan(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17LessThan(java.lang.String value) {
            return lessThan(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark17In(List<java.lang.String> values) {
            return in(remark17, values);
        }

        public ShiguSiteExample.Criteria andRemark17NotIn(List<java.lang.String> values) {
            return notIn(remark17, values);
        }

        public ShiguSiteExample.Criteria andRemark17Between(java.lang.String value1, java.lang.String value2) {
            return between(remark17, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark17NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark17, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark17Like(String value) {return like(remark17, value);}

        public ShiguSiteExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public ShiguSiteExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public ShiguSiteExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public ShiguSiteExample.Criteria andRemark18EqualTo(java.lang.String value) {
            return equalTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18NotEqualTo(java.lang.String value) {
            return notEqualTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18GreaterThan(java.lang.String value) {
            return greaterThan(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18LessThan(java.lang.String value) {
            return lessThan(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark18In(List<java.lang.String> values) {
            return in(remark18, values);
        }

        public ShiguSiteExample.Criteria andRemark18NotIn(List<java.lang.String> values) {
            return notIn(remark18, values);
        }

        public ShiguSiteExample.Criteria andRemark18Between(java.lang.String value1, java.lang.String value2) {
            return between(remark18, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark18NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark18, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark18Like(String value) {return like(remark18, value);}

        public ShiguSiteExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public ShiguSiteExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public ShiguSiteExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public ShiguSiteExample.Criteria andRemark19EqualTo(java.lang.String value) {
            return equalTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19NotEqualTo(java.lang.String value) {
            return notEqualTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19GreaterThan(java.lang.String value) {
            return greaterThan(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19LessThan(java.lang.String value) {
            return lessThan(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark19In(List<java.lang.String> values) {
            return in(remark19, values);
        }

        public ShiguSiteExample.Criteria andRemark19NotIn(List<java.lang.String> values) {
            return notIn(remark19, values);
        }

        public ShiguSiteExample.Criteria andRemark19Between(java.lang.String value1, java.lang.String value2) {
            return between(remark19, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark19NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark19, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark19Like(String value) {return like(remark19, value);}

        public ShiguSiteExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public ShiguSiteExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public ShiguSiteExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public ShiguSiteExample.Criteria andRemark20EqualTo(java.lang.String value) {
            return equalTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20NotEqualTo(java.lang.String value) {
            return notEqualTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20GreaterThan(java.lang.String value) {
            return greaterThan(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20LessThan(java.lang.String value) {
            return lessThan(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public ShiguSiteExample.Criteria andRemark20In(List<java.lang.String> values) {
            return in(remark20, values);
        }

        public ShiguSiteExample.Criteria andRemark20NotIn(List<java.lang.String> values) {
            return notIn(remark20, values);
        }

        public ShiguSiteExample.Criteria andRemark20Between(java.lang.String value1, java.lang.String value2) {
            return between(remark20, value1, value2);
        }

        public ShiguSiteExample.Criteria andRemark20NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark20, value1, value2);
        }
        public ShiguSiteExample.Criteria andRemark20Like(String value) {return like(remark20, value);}

        public ShiguSiteExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

    }
}
