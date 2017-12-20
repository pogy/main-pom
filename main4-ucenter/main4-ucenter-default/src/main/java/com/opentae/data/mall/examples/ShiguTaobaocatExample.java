package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguTaobaocat;

import java.util.*;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：ShiguTaobaocatExample.java
 *@文件路径：com.opentae.data.mall.examples.ShiguTaobaocatExample
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 02:22:10
 *@comments:
 *
 *=========================================================
 */
public class ShiguTaobaocatExample extends SgExample<ShiguTaobaocatExample.Criteria>{
    public static final Class<ShiguTaobaocat> beanClass = ShiguTaobaocat.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn cid;
    public static EntityColumn cname;
    public static EntityColumn parentCid;
    public static EntityColumn parentCname;
    public static EntityColumn isParent;
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

    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        cid = listMap.get("cid");
        cname = listMap.get("cname");
        parentCid = listMap.get("parentCid");
        parentCname = listMap.get("parentCname");
        isParent = listMap.get("isParent");
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
    }

    public ShiguTaobaocatExample() {
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
        public ShiguTaobaocatExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguTaobaocatExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguTaobaocatExample.Criteria andCidEqualTo(java.lang.Long value) {
            return equalTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidNotEqualTo(java.lang.Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidGreaterThan(java.lang.Long value) {
            return greaterThan(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidLessThan(java.lang.Long value) {
            return lessThan(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCidIn(List<java.lang.Long> values) {
            return in(cid, values);
        }

        public ShiguTaobaocatExample.Criteria andCidNotIn(List<java.lang.Long> values) {
            return notIn(cid, values);
        }

        public ShiguTaobaocatExample.Criteria andCidBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andCidNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(cid, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andCidLike(String value) {return like(cid, value);}

        public ShiguTaobaocatExample.Criteria andCidNotLike(String value) {
            return notLike(cid, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public ShiguTaobaocatExample.Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public ShiguTaobaocatExample.Criteria andCnameEqualTo(java.lang.String value) {
            return equalTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameNotEqualTo(java.lang.String value) {
            return notEqualTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameGreaterThan(java.lang.String value) {
            return greaterThan(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameLessThan(java.lang.String value) {
            return lessThan(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andCnameIn(List<java.lang.String> values) {
            return in(cname, values);
        }

        public ShiguTaobaocatExample.Criteria andCnameNotIn(List<java.lang.String> values) {
            return notIn(cname, values);
        }

        public ShiguTaobaocatExample.Criteria andCnameBetween(java.lang.String value1, java.lang.String value2) {
            return between(cname, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andCnameNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(cname, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andCnameLike(String value) {return like(cname, value);}

        public ShiguTaobaocatExample.Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidIsNull() {
            return isNull(parentCid);
        }

        public ShiguTaobaocatExample.Criteria andParentCidIsNotNull() {
            return isNotNull(parentCid);
        }

        public ShiguTaobaocatExample.Criteria andParentCidEqualTo(java.lang.Long value) {
            return equalTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotEqualTo(java.lang.Long value) {
            return notEqualTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidGreaterThan(java.lang.Long value) {
            return greaterThan(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidLessThan(java.lang.Long value) {
            return lessThan(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCidIn(List<java.lang.Long> values) {
            return in(parentCid, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotIn(List<java.lang.Long> values) {
            return notIn(parentCid, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCidBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(parentCid, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andParentCidNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(parentCid, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andParentCidLike(String value) {return like(parentCid, value);}

        public ShiguTaobaocatExample.Criteria andParentCidNotLike(String value) {
            return notLike(parentCid, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameIsNull() {
            return isNull(parentCname);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameIsNotNull() {
            return isNotNull(parentCname);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameEqualTo(java.lang.String value) {
            return equalTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotEqualTo(java.lang.String value) {
            return notEqualTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameGreaterThan(java.lang.String value) {
            return greaterThan(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLessThan(java.lang.String value) {
            return lessThan(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameIn(List<java.lang.String> values) {
            return in(parentCname, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotIn(List<java.lang.String> values) {
            return notIn(parentCname, values);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameBetween(java.lang.String value1, java.lang.String value2) {
            return between(parentCname, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andParentCnameNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(parentCname, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andParentCnameLike(String value) {return like(parentCname, value);}

        public ShiguTaobaocatExample.Criteria andParentCnameNotLike(String value) {
            return notLike(parentCname, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public ShiguTaobaocatExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public ShiguTaobaocatExample.Criteria andIsParentEqualTo(java.lang.Long value) {
            return equalTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotEqualTo(java.lang.Long value) {
            return notEqualTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentGreaterThan(java.lang.Long value) {
            return greaterThan(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentLessThan(java.lang.Long value) {
            return lessThan(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andIsParentIn(List<java.lang.Long> values) {
            return in(isParent, values);
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotIn(List<java.lang.Long> values) {
            return notIn(isParent, values);
        }

        public ShiguTaobaocatExample.Criteria andIsParentBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(isParent, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andIsParentNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(isParent, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andIsParentLike(String value) {return like(isParent, value);}

        public ShiguTaobaocatExample.Criteria andIsParentNotLike(String value) {
            return notLike(isParent, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguTaobaocatExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguTaobaocatExample.Criteria andRemark1EqualTo(java.lang.String value) {
            return equalTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotEqualTo(java.lang.String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1GreaterThan(java.lang.String value) {
            return greaterThan(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1LessThan(java.lang.String value) {
            return lessThan(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark1In(List<java.lang.String> values) {
            return in(remark1, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotIn(List<java.lang.String> values) {
            return notIn(remark1, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark1Between(java.lang.String value1, java.lang.String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark1NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark1Like(String value) {return like(remark1, value);}

        public ShiguTaobaocatExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguTaobaocatExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguTaobaocatExample.Criteria andRemark2EqualTo(java.lang.String value) {
            return equalTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotEqualTo(java.lang.String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2GreaterThan(java.lang.String value) {
            return greaterThan(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2LessThan(java.lang.String value) {
            return lessThan(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark2In(List<java.lang.String> values) {
            return in(remark2, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotIn(List<java.lang.String> values) {
            return notIn(remark2, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark2Between(java.lang.String value1, java.lang.String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark2NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark2, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark2Like(String value) {return like(remark2, value);}

        public ShiguTaobaocatExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguTaobaocatExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguTaobaocatExample.Criteria andRemark3EqualTo(java.lang.String value) {
            return equalTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotEqualTo(java.lang.String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3GreaterThan(java.lang.String value) {
            return greaterThan(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3LessThan(java.lang.String value) {
            return lessThan(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark3In(List<java.lang.String> values) {
            return in(remark3, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotIn(List<java.lang.String> values) {
            return notIn(remark3, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark3Between(java.lang.String value1, java.lang.String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark3NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark3Like(String value) {return like(remark3, value);}

        public ShiguTaobaocatExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguTaobaocatExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguTaobaocatExample.Criteria andRemark4EqualTo(java.lang.String value) {
            return equalTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotEqualTo(java.lang.String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4GreaterThan(java.lang.String value) {
            return greaterThan(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4LessThan(java.lang.String value) {
            return lessThan(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark4In(List<java.lang.String> values) {
            return in(remark4, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotIn(List<java.lang.String> values) {
            return notIn(remark4, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark4Between(java.lang.String value1, java.lang.String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark4NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark4Like(String value) {return like(remark4, value);}

        public ShiguTaobaocatExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguTaobaocatExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguTaobaocatExample.Criteria andRemark5EqualTo(java.lang.String value) {
            return equalTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotEqualTo(java.lang.String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5GreaterThan(java.lang.String value) {
            return greaterThan(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5LessThan(java.lang.String value) {
            return lessThan(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark5In(List<java.lang.String> values) {
            return in(remark5, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotIn(List<java.lang.String> values) {
            return notIn(remark5, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark5Between(java.lang.String value1, java.lang.String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark5NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark5Like(String value) {return like(remark5, value);}

        public ShiguTaobaocatExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguTaobaocatExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguTaobaocatExample.Criteria andRemark6EqualTo(java.lang.String value) {
            return equalTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotEqualTo(java.lang.String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6GreaterThan(java.lang.String value) {
            return greaterThan(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6LessThan(java.lang.String value) {
            return lessThan(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark6In(List<java.lang.String> values) {
            return in(remark6, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotIn(List<java.lang.String> values) {
            return notIn(remark6, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark6Between(java.lang.String value1, java.lang.String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark6NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark6Like(String value) {return like(remark6, value);}

        public ShiguTaobaocatExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguTaobaocatExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguTaobaocatExample.Criteria andRemark7EqualTo(java.lang.String value) {
            return equalTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotEqualTo(java.lang.String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7GreaterThan(java.lang.String value) {
            return greaterThan(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7LessThan(java.lang.String value) {
            return lessThan(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark7In(List<java.lang.String> values) {
            return in(remark7, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotIn(List<java.lang.String> values) {
            return notIn(remark7, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark7Between(java.lang.String value1, java.lang.String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark7NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark7Like(String value) {return like(remark7, value);}

        public ShiguTaobaocatExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguTaobaocatExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguTaobaocatExample.Criteria andRemark8EqualTo(java.lang.String value) {
            return equalTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotEqualTo(java.lang.String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8GreaterThan(java.lang.String value) {
            return greaterThan(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8LessThan(java.lang.String value) {
            return lessThan(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark8In(List<java.lang.String> values) {
            return in(remark8, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotIn(List<java.lang.String> values) {
            return notIn(remark8, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark8Between(java.lang.String value1, java.lang.String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark8NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark8Like(String value) {return like(remark8, value);}

        public ShiguTaobaocatExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguTaobaocatExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguTaobaocatExample.Criteria andRemark9EqualTo(java.lang.String value) {
            return equalTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotEqualTo(java.lang.String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9GreaterThan(java.lang.String value) {
            return greaterThan(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9LessThan(java.lang.String value) {
            return lessThan(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark9In(List<java.lang.String> values) {
            return in(remark9, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotIn(List<java.lang.String> values) {
            return notIn(remark9, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark9Between(java.lang.String value1, java.lang.String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark9NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark9Like(String value) {return like(remark9, value);}

        public ShiguTaobaocatExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguTaobaocatExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguTaobaocatExample.Criteria andRemark10EqualTo(java.lang.String value) {
            return equalTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotEqualTo(java.lang.String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10GreaterThan(java.lang.String value) {
            return greaterThan(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10LessThan(java.lang.String value) {
            return lessThan(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark10In(List<java.lang.String> values) {
            return in(remark10, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotIn(List<java.lang.String> values) {
            return notIn(remark10, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark10Between(java.lang.String value1, java.lang.String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark10NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark10Like(String value) {return like(remark10, value);}

        public ShiguTaobaocatExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public ShiguTaobaocatExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public ShiguTaobaocatExample.Criteria andRemark11EqualTo(java.lang.String value) {
            return equalTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotEqualTo(java.lang.String value) {
            return notEqualTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11GreaterThan(java.lang.String value) {
            return greaterThan(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11LessThan(java.lang.String value) {
            return lessThan(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark11In(List<java.lang.String> values) {
            return in(remark11, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotIn(List<java.lang.String> values) {
            return notIn(remark11, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark11Between(java.lang.String value1, java.lang.String value2) {
            return between(remark11, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark11NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark11, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark11Like(String value) {return like(remark11, value);}

        public ShiguTaobaocatExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public ShiguTaobaocatExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public ShiguTaobaocatExample.Criteria andRemark12EqualTo(java.lang.String value) {
            return equalTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotEqualTo(java.lang.String value) {
            return notEqualTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12GreaterThan(java.lang.String value) {
            return greaterThan(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12LessThan(java.lang.String value) {
            return lessThan(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark12In(List<java.lang.String> values) {
            return in(remark12, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotIn(List<java.lang.String> values) {
            return notIn(remark12, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark12Between(java.lang.String value1, java.lang.String value2) {
            return between(remark12, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark12NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark12, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark12Like(String value) {return like(remark12, value);}

        public ShiguTaobaocatExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public ShiguTaobaocatExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public ShiguTaobaocatExample.Criteria andRemark13EqualTo(java.lang.String value) {
            return equalTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotEqualTo(java.lang.String value) {
            return notEqualTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13GreaterThan(java.lang.String value) {
            return greaterThan(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13LessThan(java.lang.String value) {
            return lessThan(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark13In(List<java.lang.String> values) {
            return in(remark13, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotIn(List<java.lang.String> values) {
            return notIn(remark13, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark13Between(java.lang.String value1, java.lang.String value2) {
            return between(remark13, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark13NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark13, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark13Like(String value) {return like(remark13, value);}

        public ShiguTaobaocatExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public ShiguTaobaocatExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public ShiguTaobaocatExample.Criteria andRemark14EqualTo(java.lang.String value) {
            return equalTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotEqualTo(java.lang.String value) {
            return notEqualTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14GreaterThan(java.lang.String value) {
            return greaterThan(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14LessThan(java.lang.String value) {
            return lessThan(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark14In(List<java.lang.String> values) {
            return in(remark14, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotIn(List<java.lang.String> values) {
            return notIn(remark14, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark14Between(java.lang.String value1, java.lang.String value2) {
            return between(remark14, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark14NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark14, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark14Like(String value) {return like(remark14, value);}

        public ShiguTaobaocatExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public ShiguTaobaocatExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public ShiguTaobaocatExample.Criteria andRemark15EqualTo(java.lang.String value) {
            return equalTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotEqualTo(java.lang.String value) {
            return notEqualTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15GreaterThan(java.lang.String value) {
            return greaterThan(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15LessThan(java.lang.String value) {
            return lessThan(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public ShiguTaobaocatExample.Criteria andRemark15In(List<java.lang.String> values) {
            return in(remark15, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotIn(List<java.lang.String> values) {
            return notIn(remark15, values);
        }

        public ShiguTaobaocatExample.Criteria andRemark15Between(java.lang.String value1, java.lang.String value2) {
            return between(remark15, value1, value2);
        }

        public ShiguTaobaocatExample.Criteria andRemark15NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark15, value1, value2);
        }
        public ShiguTaobaocatExample.Criteria andRemark15Like(String value) {return like(remark15, value);}

        public ShiguTaobaocatExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

    }
}
