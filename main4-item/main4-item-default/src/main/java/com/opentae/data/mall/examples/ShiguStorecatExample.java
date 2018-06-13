package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguStorecat;

import java.util.*;
public class ShiguStorecatExample extends SgExample<ShiguStorecatExample.Criteria> {
    public static final Class<ShiguStorecat> beanClass = ShiguStorecat.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn type;
    public static EntityColumn picUrl;
    public static EntityColumn modified;
    public static EntityColumn parentScid;
    public static EntityColumn scid;
    public static EntityColumn isParent;
    public static EntityColumn created;
    public static EntityColumn parentScName;
    public static EntityColumn storeId;
    public static EntityColumn scName;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn parentTaobaoScid;
    public static EntityColumn lastModifyTime;
    public static EntityColumn sortOrder;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn taobaoScid;
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
        remark15 = listMap.get("remark15");
        remark14 = listMap.get("remark14");
        remark13 = listMap.get("remark13");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        type = listMap.get("type");
        picUrl = listMap.get("picUrl");
        modified = listMap.get("modified");
        parentScid = listMap.get("parentScid");
        scid = listMap.get("scid");
        isParent = listMap.get("isParent");
        created = listMap.get("created");
        parentScName = listMap.get("parentScName");
        storeId = listMap.get("storeId");
        scName = listMap.get("scName");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        parentTaobaoScid = listMap.get("parentTaobaoScid");
        lastModifyTime = listMap.get("lastModifyTime");
        sortOrder = listMap.get("sortOrder");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        taobaoScid = listMap.get("taobaoScid");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public ShiguStorecatExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguStorecatExample.Criteria createCriteriaInternal() {
        return new ShiguStorecatExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguStorecatExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguStorecatExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguStorecatExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguStorecatExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguStorecatExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguStorecatExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguStorecatExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguStorecatExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguStorecatExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguStorecatExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguStorecatExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguStorecatExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguStorecatExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguStorecatExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguStorecatExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguStorecatExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguStorecatExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguStorecatExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguStorecatExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguStorecatExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguStorecatExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguStorecatExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguStorecatExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguStorecatExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguStorecatExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguStorecatExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguStorecatExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguStorecatExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguStorecatExample.Criteria andTypeEqualTo(String value) {
            return equalTo(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeNotEqualTo(String value) {
            return notEqualTo(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeGreaterThan(String value) {
            return greaterThan(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeLessThan(String value) {
            return lessThan(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeLike(String value) {
            return like(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeNotLike(String value) {
            return notLike(type, value);
        }

        public ShiguStorecatExample.Criteria andTypeIn(List<String> values) {
            return in(type, values);
        }

        public ShiguStorecatExample.Criteria andTypeNotIn(List<String> values) {
            return notIn(type, values);
        }

        public ShiguStorecatExample.Criteria andTypeBetween(String value1, String value2) {
            return between(type, value1, value2);
        }

        public ShiguStorecatExample.Criteria andTypeNotBetween(String value1, String value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguStorecatExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ShiguStorecatExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ShiguStorecatExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ShiguStorecatExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ShiguStorecatExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ShiguStorecatExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ShiguStorecatExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ShiguStorecatExample.Criteria andModifiedIsNull() {
            return isNull(modified);
        }

        public ShiguStorecatExample.Criteria andModifiedIsNotNull() {
            return isNotNull(modified);
        }

        public ShiguStorecatExample.Criteria andModifiedEqualTo(Date value) {
            return equalTo(modified, value);
        }

        public ShiguStorecatExample.Criteria andModifiedNotEqualTo(Date value) {
            return notEqualTo(modified, value);
        }

        public ShiguStorecatExample.Criteria andModifiedGreaterThan(Date value) {
            return greaterThan(modified, value);
        }

        public ShiguStorecatExample.Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modified, value);
        }

        public ShiguStorecatExample.Criteria andModifiedLessThan(Date value) {
            return lessThan(modified, value);
        }

        public ShiguStorecatExample.Criteria andModifiedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modified, value);
        }

        public ShiguStorecatExample.Criteria andModifiedIn(List<Date> values) {
            return in(modified, values);
        }

        public ShiguStorecatExample.Criteria andModifiedNotIn(List<Date> values) {
            return notIn(modified, values);
        }

        public ShiguStorecatExample.Criteria andModifiedBetween(Date value1, Date value2) {
            return between(modified, value1, value2);
        }

        public ShiguStorecatExample.Criteria andModifiedNotBetween(Date value1, Date value2) {
            return notBetween(modified, value1, value2);
        }
        public ShiguStorecatExample.Criteria andParentScidIsNull() {
            return isNull(parentScid);
        }

        public ShiguStorecatExample.Criteria andParentScidIsNotNull() {
            return isNotNull(parentScid);
        }

        public ShiguStorecatExample.Criteria andParentScidEqualTo(Long value) {
            return equalTo(parentScid, value);
        }

        public ShiguStorecatExample.Criteria andParentScidNotEqualTo(Long value) {
            return notEqualTo(parentScid, value);
        }

        public ShiguStorecatExample.Criteria andParentScidGreaterThan(Long value) {
            return greaterThan(parentScid, value);
        }

        public ShiguStorecatExample.Criteria andParentScidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentScid, value);
        }

        public ShiguStorecatExample.Criteria andParentScidLessThan(Long value) {
            return lessThan(parentScid, value);
        }

        public ShiguStorecatExample.Criteria andParentScidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentScid, value);
        }

        public ShiguStorecatExample.Criteria andParentScidIn(List<Long> values) {
            return in(parentScid, values);
        }

        public ShiguStorecatExample.Criteria andParentScidNotIn(List<Long> values) {
            return notIn(parentScid, values);
        }

        public ShiguStorecatExample.Criteria andParentScidBetween(Long value1, Long value2) {
            return between(parentScid, value1, value2);
        }

        public ShiguStorecatExample.Criteria andParentScidNotBetween(Long value1, Long value2) {
            return notBetween(parentScid, value1, value2);
        }
        public ShiguStorecatExample.Criteria andScidIsNull() {
            return isNull(scid);
        }

        public ShiguStorecatExample.Criteria andScidIsNotNull() {
            return isNotNull(scid);
        }

        public ShiguStorecatExample.Criteria andScidEqualTo(Long value) {
            return equalTo(scid, value);
        }

        public ShiguStorecatExample.Criteria andScidNotEqualTo(Long value) {
            return notEqualTo(scid, value);
        }

        public ShiguStorecatExample.Criteria andScidGreaterThan(Long value) {
            return greaterThan(scid, value);
        }

        public ShiguStorecatExample.Criteria andScidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(scid, value);
        }

        public ShiguStorecatExample.Criteria andScidLessThan(Long value) {
            return lessThan(scid, value);
        }

        public ShiguStorecatExample.Criteria andScidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(scid, value);
        }

        public ShiguStorecatExample.Criteria andScidIn(List<Long> values) {
            return in(scid, values);
        }

        public ShiguStorecatExample.Criteria andScidNotIn(List<Long> values) {
            return notIn(scid, values);
        }

        public ShiguStorecatExample.Criteria andScidBetween(Long value1, Long value2) {
            return between(scid, value1, value2);
        }

        public ShiguStorecatExample.Criteria andScidNotBetween(Long value1, Long value2) {
            return notBetween(scid, value1, value2);
        }
        public ShiguStorecatExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public ShiguStorecatExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public ShiguStorecatExample.Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public ShiguStorecatExample.Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public ShiguStorecatExample.Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public ShiguStorecatExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public ShiguStorecatExample.Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public ShiguStorecatExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public ShiguStorecatExample.Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public ShiguStorecatExample.Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public ShiguStorecatExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public ShiguStorecatExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public ShiguStorecatExample.Criteria andCreatedIsNull() {
            return isNull(created);
        }

        public ShiguStorecatExample.Criteria andCreatedIsNotNull() {
            return isNotNull(created);
        }

        public ShiguStorecatExample.Criteria andCreatedEqualTo(Date value) {
            return equalTo(created, value);
        }

        public ShiguStorecatExample.Criteria andCreatedNotEqualTo(Date value) {
            return notEqualTo(created, value);
        }

        public ShiguStorecatExample.Criteria andCreatedGreaterThan(Date value) {
            return greaterThan(created, value);
        }

        public ShiguStorecatExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(created, value);
        }

        public ShiguStorecatExample.Criteria andCreatedLessThan(Date value) {
            return lessThan(created, value);
        }

        public ShiguStorecatExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(created, value);
        }

        public ShiguStorecatExample.Criteria andCreatedIn(List<Date> values) {
            return in(created, values);
        }

        public ShiguStorecatExample.Criteria andCreatedNotIn(List<Date> values) {
            return notIn(created, values);
        }

        public ShiguStorecatExample.Criteria andCreatedBetween(Date value1, Date value2) {
            return between(created, value1, value2);
        }

        public ShiguStorecatExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            return notBetween(created, value1, value2);
        }
        public ShiguStorecatExample.Criteria andParentScNameIsNull() {
            return isNull(parentScName);
        }

        public ShiguStorecatExample.Criteria andParentScNameIsNotNull() {
            return isNotNull(parentScName);
        }

        public ShiguStorecatExample.Criteria andParentScNameEqualTo(String value) {
            return equalTo(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameNotEqualTo(String value) {
            return notEqualTo(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameGreaterThan(String value) {
            return greaterThan(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameLessThan(String value) {
            return lessThan(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameLike(String value) {
            return like(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameNotLike(String value) {
            return notLike(parentScName, value);
        }

        public ShiguStorecatExample.Criteria andParentScNameIn(List<String> values) {
            return in(parentScName, values);
        }

        public ShiguStorecatExample.Criteria andParentScNameNotIn(List<String> values) {
            return notIn(parentScName, values);
        }

        public ShiguStorecatExample.Criteria andParentScNameBetween(String value1, String value2) {
            return between(parentScName, value1, value2);
        }

        public ShiguStorecatExample.Criteria andParentScNameNotBetween(String value1, String value2) {
            return notBetween(parentScName, value1, value2);
        }
        public ShiguStorecatExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguStorecatExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguStorecatExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguStorecatExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguStorecatExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguStorecatExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguStorecatExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguStorecatExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguStorecatExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguStorecatExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguStorecatExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguStorecatExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguStorecatExample.Criteria andScNameIsNull() {
            return isNull(scName);
        }

        public ShiguStorecatExample.Criteria andScNameIsNotNull() {
            return isNotNull(scName);
        }

        public ShiguStorecatExample.Criteria andScNameEqualTo(String value) {
            return equalTo(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameNotEqualTo(String value) {
            return notEqualTo(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameGreaterThan(String value) {
            return greaterThan(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameLessThan(String value) {
            return lessThan(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameLike(String value) {
            return like(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameNotLike(String value) {
            return notLike(scName, value);
        }

        public ShiguStorecatExample.Criteria andScNameIn(List<String> values) {
            return in(scName, values);
        }

        public ShiguStorecatExample.Criteria andScNameNotIn(List<String> values) {
            return notIn(scName, values);
        }

        public ShiguStorecatExample.Criteria andScNameBetween(String value1, String value2) {
            return between(scName, value1, value2);
        }

        public ShiguStorecatExample.Criteria andScNameNotBetween(String value1, String value2) {
            return notBetween(scName, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguStorecatExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguStorecatExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguStorecatExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguStorecatExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguStorecatExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguStorecatExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguStorecatExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguStorecatExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguStorecatExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguStorecatExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguStorecatExample.Criteria andParentTaobaoScidIsNull() {
            return isNull(parentTaobaoScid);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidIsNotNull() {
            return isNotNull(parentTaobaoScid);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidEqualTo(String value) {
            return equalTo(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotEqualTo(String value) {
            return notEqualTo(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidGreaterThan(String value) {
            return greaterThan(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidLessThan(String value) {
            return lessThan(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidLike(String value) {
            return like(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotLike(String value) {
            return notLike(parentTaobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidIn(List<String> values) {
            return in(parentTaobaoScid, values);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotIn(List<String> values) {
            return notIn(parentTaobaoScid, values);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidBetween(String value1, String value2) {
            return between(parentTaobaoScid, value1, value2);
        }

        public ShiguStorecatExample.Criteria andParentTaobaoScidNotBetween(String value1, String value2) {
            return notBetween(parentTaobaoScid, value1, value2);
        }
        public ShiguStorecatExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public ShiguStorecatExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public ShiguStorecatExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public ShiguStorecatExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public ShiguStorecatExample.Criteria andSortOrderEqualTo(Integer value) {
            return equalTo(sortOrder, value);
        }

        public ShiguStorecatExample.Criteria andSortOrderNotEqualTo(Integer value) {
            return notEqualTo(sortOrder, value);
        }

        public ShiguStorecatExample.Criteria andSortOrderGreaterThan(Integer value) {
            return greaterThan(sortOrder, value);
        }

        public ShiguStorecatExample.Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public ShiguStorecatExample.Criteria andSortOrderLessThan(Integer value) {
            return lessThan(sortOrder, value);
        }

        public ShiguStorecatExample.Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public ShiguStorecatExample.Criteria andSortOrderIn(List<Integer> values) {
            return in(sortOrder, values);
        }

        public ShiguStorecatExample.Criteria andSortOrderNotIn(List<Integer> values) {
            return notIn(sortOrder, values);
        }

        public ShiguStorecatExample.Criteria andSortOrderBetween(Integer value1, Integer value2) {
            return between(sortOrder, value1, value2);
        }

        public ShiguStorecatExample.Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguStorecatExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguStorecatExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguStorecatExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguStorecatExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguStorecatExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguStorecatExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguStorecatExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguStorecatExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguStorecatExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguStorecatExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguStorecatExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguStorecatExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguStorecatExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguStorecatExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguStorecatExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguStorecatExample.Criteria andTaobaoScidIsNull() {
            return isNull(taobaoScid);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidIsNotNull() {
            return isNotNull(taobaoScid);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidEqualTo(String value) {
            return equalTo(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotEqualTo(String value) {
            return notEqualTo(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidGreaterThan(String value) {
            return greaterThan(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidLessThan(String value) {
            return lessThan(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidLike(String value) {
            return like(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotLike(String value) {
            return notLike(taobaoScid, value);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidIn(List<String> values) {
            return in(taobaoScid, values);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotIn(List<String> values) {
            return notIn(taobaoScid, values);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidBetween(String value1, String value2) {
            return between(taobaoScid, value1, value2);
        }

        public ShiguStorecatExample.Criteria andTaobaoScidNotBetween(String value1, String value2) {
            return notBetween(taobaoScid, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguStorecatExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguStorecatExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguStorecatExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguStorecatExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguStorecatExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguStorecatExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguStorecatExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguStorecatExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguStorecatExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguStorecatExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguStorecatExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguStorecatExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguStorecatExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguStorecatExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguStorecatExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguStorecatExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguStorecatExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguStorecatExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguStorecatExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguStorecatExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguStorecatExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguStorecatExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguStorecatExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguStorecatExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguStorecatExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguStorecatExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguStorecatExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}