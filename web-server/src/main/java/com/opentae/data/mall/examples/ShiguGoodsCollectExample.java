package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsCollect;

import java.util.*;
public class ShiguGoodsCollectExample extends SgExample<ShiguGoodsCollectExample.Criteria> {
    public static final Class<ShiguGoodsCollect> beanClass = ShiguGoodsCollect.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remark18;
    public static EntityColumn lastTime;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn goodsId;
    public static EntityColumn remark11;
    public static EntityColumn type;
    public static EntityColumn remark19;
    public static EntityColumn remark20;
    public static EntityColumn website;
    public static EntityColumn storeId;
    public static EntityColumn userId;
    public static EntityColumn useStatus;
    public static EntityColumn goodsCollectId;
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
        lastTime = listMap.get("lastTime");
        remark17 = listMap.get("remark17");
        remark16 = listMap.get("remark16");
        remark15 = listMap.get("remark15");
        remark14 = listMap.get("remark14");
        remark13 = listMap.get("remark13");
        remark12 = listMap.get("remark12");
        goodsId = listMap.get("goodsId");
        remark11 = listMap.get("remark11");
        type = listMap.get("type");
        remark19 = listMap.get("remark19");
        remark20 = listMap.get("remark20");
        website = listMap.get("website");
        storeId = listMap.get("storeId");
        userId = listMap.get("userId");
        useStatus = listMap.get("useStatus");
        goodsCollectId = listMap.get("goodsCollectId");
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

    public ShiguGoodsCollectExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsCollectExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsCollectExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andLastTimeIsNull() {
            return isNull(lastTime);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeIsNotNull() {
            return isNotNull(lastTime);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeEqualTo(Date value) {
            return equalTo(lastTime, value);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeNotEqualTo(Date value) {
            return notEqualTo(lastTime, value);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeGreaterThan(Date value) {
            return greaterThan(lastTime, value);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastTime, value);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeLessThan(Date value) {
            return lessThan(lastTime, value);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastTime, value);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeIn(List<Date> values) {
            return in(lastTime, values);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeNotIn(List<Date> values) {
            return notIn(lastTime, values);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeBetween(Date value1, Date value2) {
            return between(lastTime, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastTime, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguGoodsCollectExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguGoodsCollectExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShiguGoodsCollectExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShiguGoodsCollectExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShiguGoodsCollectExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguGoodsCollectExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShiguGoodsCollectExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguGoodsCollectExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShiguGoodsCollectExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShiguGoodsCollectExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andWebsiteIsNull() {
            return isNull(website);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteIsNotNull() {
            return isNotNull(website);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteEqualTo(String value) {
            return equalTo(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotEqualTo(String value) {
            return notEqualTo(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteGreaterThan(String value) {
            return greaterThan(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteLessThan(String value) {
            return lessThan(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteLike(String value) {
            return like(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotLike(String value) {
            return notLike(website, value);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteIn(List<String> values) {
            return in(website, values);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotIn(List<String> values) {
            return notIn(website, values);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteBetween(String value1, String value2) {
            return between(website, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andWebsiteNotBetween(String value1, String value2) {
            return notBetween(website, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdIsNull() {
            return isNull(goodsCollectId);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdIsNotNull() {
            return isNotNull(goodsCollectId);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdEqualTo(Long value) {
            return equalTo(goodsCollectId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdNotEqualTo(Long value) {
            return notEqualTo(goodsCollectId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdGreaterThan(Long value) {
            return greaterThan(goodsCollectId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsCollectId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdLessThan(Long value) {
            return lessThan(goodsCollectId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsCollectId, value);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdIn(List<Long> values) {
            return in(goodsCollectId, values);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdNotIn(List<Long> values) {
            return notIn(goodsCollectId, values);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdBetween(Long value1, Long value2) {
            return between(goodsCollectId, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andGoodsCollectIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsCollectId, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderEqualTo(Integer value) {
            return equalTo(sortOrder, value);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderNotEqualTo(Integer value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderGreaterThan(Integer value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderLessThan(Integer value) {
            return lessThan(sortOrder, value);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderIn(List<Integer> values) {
            return in(sortOrder, values);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderNotIn(List<Integer> values) {
            return notIn(sortOrder, values);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguGoodsCollectExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguGoodsCollectExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}