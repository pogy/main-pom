package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsDataPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguGoodsDataPackageExample extends SgExample<ShiguGoodsDataPackageExample.Criteria> {
    public static final Class<ShiguGoodsDataPackage> beanClass = ShiguGoodsDataPackage.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remark18;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn dataPackageSavePath;
    public static EntityColumn remark13;
    public static EntityColumn goodsId;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn remark19;
    public static EntityColumn dataPackageUrl;
    public static EntityColumn remark20;
    public static EntityColumn storeId;
    public static EntityColumn userId;
    public static EntityColumn useStatus;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn sortOrder;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn dataPackageId;
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
        dataPackageSavePath = listMap.get("dataPackageSavePath");
        remark13 = listMap.get("remark13");
        goodsId = listMap.get("goodsId");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        remark19 = listMap.get("remark19");
        dataPackageUrl = listMap.get("dataPackageUrl");
        remark20 = listMap.get("remark20");
        storeId = listMap.get("storeId");
        userId = listMap.get("userId");
        useStatus = listMap.get("useStatus");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        sortOrder = listMap.get("sortOrder");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        dataPackageId = listMap.get("dataPackageId");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public ShiguGoodsDataPackageExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsDataPackageExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsDataPackageExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathIsNull() {
            return isNull(dataPackageSavePath);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathIsNotNull() {
            return isNotNull(dataPackageSavePath);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathEqualTo(String value) {
            return equalTo(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotEqualTo(String value) {
            return notEqualTo(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathGreaterThan(String value) {
            return greaterThan(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathLessThan(String value) {
            return lessThan(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathLike(String value) {
            return like(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotLike(String value) {
            return notLike(dataPackageSavePath, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathIn(List<String> values) {
            return in(dataPackageSavePath, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotIn(List<String> values) {
            return notIn(dataPackageSavePath, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathBetween(String value1, String value2) {
            return between(dataPackageSavePath, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotBetween(String value1, String value2) {
            return notBetween(dataPackageSavePath, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlIsNull() {
            return isNull(dataPackageUrl);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlIsNotNull() {
            return isNotNull(dataPackageUrl);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlEqualTo(String value) {
            return equalTo(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotEqualTo(String value) {
            return notEqualTo(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlGreaterThan(String value) {
            return greaterThan(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlLessThan(String value) {
            return lessThan(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlLike(String value) {
            return like(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotLike(String value) {
            return notLike(dataPackageUrl, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlIn(List<String> values) {
            return in(dataPackageUrl, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotIn(List<String> values) {
            return notIn(dataPackageUrl, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlBetween(String value1, String value2) {
            return between(dataPackageUrl, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotBetween(String value1, String value2) {
            return notBetween(dataPackageUrl, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdIsNull() {
            return isNull(dataPackageId);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdIsNotNull() {
            return isNotNull(dataPackageId);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdEqualTo(Long value) {
            return equalTo(dataPackageId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdNotEqualTo(Long value) {
            return notEqualTo(dataPackageId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdGreaterThan(Long value) {
            return greaterThan(dataPackageId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dataPackageId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdLessThan(Long value) {
            return lessThan(dataPackageId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dataPackageId, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdIn(List<Long> values) {
            return in(dataPackageId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdNotIn(List<Long> values) {
            return notIn(dataPackageId, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdBetween(Long value1, Long value2) {
            return between(dataPackageId, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdNotBetween(Long value1, Long value2) {
            return notBetween(dataPackageId, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguGoodsDataPackageExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
