package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguStoreCollect;

import java.util.*;
public class ShiguStoreCollectExample extends SgExample<ShiguStoreCollectExample.Criteria> {
    public static final Class<ShiguStoreCollect> beanClass = ShiguStoreCollect.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remark18;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn storeCollectId;
    public static EntityColumn remark19;
    public static EntityColumn webSite;
    public static EntityColumn remark20;
    public static EntityColumn storeId;
    public static EntityColumn userId;
    public static EntityColumn useStatus;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn sortOrder;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
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
        storeCollectId = listMap.get("storeCollectId");
        remark19 = listMap.get("remark19");
        webSite = listMap.get("webSite");
        remark20 = listMap.get("remark20");
        storeId = listMap.get("storeId");
        userId = listMap.get("userId");
        useStatus = listMap.get("useStatus");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        sortOrder = listMap.get("sortOrder");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public ShiguStoreCollectExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguStoreCollectExample.Criteria createCriteriaInternal() {
        return new ShiguStoreCollectExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguStoreCollectExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public ShiguStoreCollectExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public ShiguStoreCollectExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public ShiguStoreCollectExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public ShiguStoreCollectExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public ShiguStoreCollectExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public ShiguStoreCollectExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguStoreCollectExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguStoreCollectExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguStoreCollectExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguStoreCollectExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguStoreCollectExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguStoreCollectExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguStoreCollectExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguStoreCollectExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguStoreCollectExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguStoreCollectExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andStoreCollectIdIsNull() {
            return isNull(storeCollectId);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdIsNotNull() {
            return isNotNull(storeCollectId);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdEqualTo(Long value) {
            return equalTo(storeCollectId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdNotEqualTo(Long value) {
            return notEqualTo(storeCollectId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdGreaterThan(Long value) {
            return greaterThan(storeCollectId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeCollectId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdLessThan(Long value) {
            return lessThan(storeCollectId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeCollectId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdIn(List<Long> values) {
            return in(storeCollectId, values);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdNotIn(List<Long> values) {
            return notIn(storeCollectId, values);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdBetween(Long value1, Long value2) {
            return between(storeCollectId, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdNotBetween(Long value1, Long value2) {
            return notBetween(storeCollectId, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public ShiguStoreCollectExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public ShiguStoreCollectExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public ShiguStoreCollectExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public ShiguStoreCollectExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguStoreCollectExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguStoreCollectExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguStoreCollectExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguStoreCollectExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguStoreCollectExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguStoreCollectExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguStoreCollectExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguStoreCollectExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguStoreCollectExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguStoreCollectExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguStoreCollectExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguStoreCollectExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguStoreCollectExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguStoreCollectExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguStoreCollectExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguStoreCollectExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguStoreCollectExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguStoreCollectExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguStoreCollectExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguStoreCollectExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguStoreCollectExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguStoreCollectExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguStoreCollectExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguStoreCollectExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguStoreCollectExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguStoreCollectExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguStoreCollectExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguStoreCollectExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguStoreCollectExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguStoreCollectExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguStoreCollectExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguStoreCollectExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguStoreCollectExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
