package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguTaobaocat;

import java.util.*;
public class ShiguTaobaocatExample extends SgExample<ShiguTaobaocatExample.Criteria> {
    public static final Class<ShiguTaobaocat> beanClass = ShiguTaobaocat.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn isParent;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn cname;
    public static EntityColumn parentCname;
    public static EntityColumn parentCid;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn cid;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        isParent = listMap.get("isParent");
        remark15 = listMap.get("remark15");
        remark14 = listMap.get("remark14");
        remark13 = listMap.get("remark13");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        cname = listMap.get("cname");
        parentCname = listMap.get("parentCname");
        parentCid = listMap.get("parentCid");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        cid = listMap.get("cid");
        remark2 = listMap.get("remark2");
        }

    public ShiguTaobaocatExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguTaobaocatExample.Criteria createCriteriaInternal() {
        return new ShiguTaobaocatExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguTaobaocatExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public ShiguTaobaocatExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public ShiguTaobaocatExample.Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public ShiguTaobaocatExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguTaobaocatExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguTaobaocatExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguTaobaocatExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguTaobaocatExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguTaobaocatExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguTaobaocatExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguTaobaocatExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguTaobaocatExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguTaobaocatExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguTaobaocatExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public ShiguTaobaocatExample.Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public ShiguTaobaocatExample.Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public ShiguTaobaocatExample.Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public ShiguTaobaocatExample.Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andParentCnameIsNull() {
            return isNull(parentCname);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameIsNotNull() {
            return isNotNull(parentCname);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameEqualTo(String value) {
            return equalTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotEqualTo(String value) {
            return notEqualTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameGreaterThan(String value) {
            return greaterThan(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLessThan(String value) {
            return lessThan(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLike(String value) {
            return like(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotLike(String value) {
            return notLike(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameIn(List<String> values) {
            return in(parentCname, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotIn(List<String> values) {
            return notIn(parentCname, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameBetween(String value1, String value2) {
            return between(parentCname, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotBetween(String value1, String value2) {
            return notBetween(parentCname, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andParentCidIsNull() {
            return isNull(parentCid);
        }

        public ShiguTaobaocatExample.Criteria andParentCidIsNotNull() {
            return isNotNull(parentCid);
        }

        public ShiguTaobaocatExample.Criteria andParentCidEqualTo(Long value) {
            return equalTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotEqualTo(Long value) {
            return notEqualTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidGreaterThan(Long value) {
            return greaterThan(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidLessThan(Long value) {
            return lessThan(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidIn(List<Long> values) {
            return in(parentCid, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotIn(List<Long> values) {
            return notIn(parentCid, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCidBetween(Long value1, Long value2) {
            return between(parentCid, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotBetween(Long value1, Long value2) {
            return notBetween(parentCid, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguTaobaocatExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguTaobaocatExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguTaobaocatExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguTaobaocatExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguTaobaocatExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguTaobaocatExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguTaobaocatExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguTaobaocatExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguTaobaocatExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguTaobaocatExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguTaobaocatExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguTaobaocatExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguTaobaocatExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguTaobaocatExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguTaobaocatExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguTaobaocatExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguTaobaocatExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguTaobaocatExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguTaobaocatExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguTaobaocatExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguTaobaocatExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguTaobaocatExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguTaobaocatExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguTaobaocatExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
