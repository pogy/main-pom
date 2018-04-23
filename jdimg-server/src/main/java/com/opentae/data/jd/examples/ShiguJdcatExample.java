package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.ShiguJdcat;

import java.util.*;
public class ShiguJdcatExample extends SgExample<ShiguJdcatExample.Criteria> {
    public static final Class<ShiguJdcat> beanClass = ShiguJdcat.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn tbCid;
    public static EntityColumn parentCname;
    public static EntityColumn parentCid;
    public static EntityColumn isParent;
    public static EntityColumn cname;
    public static EntityColumn remark1;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        tbCid = listMap.get("tbCid");
        parentCname = listMap.get("parentCname");
        parentCid = listMap.get("parentCid");
        isParent = listMap.get("isParent");
        cname = listMap.get("cname");
        remark1 = listMap.get("remark1");
        cid = listMap.get("cid");
        }

    public ShiguJdcatExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguJdcatExample.Criteria createCriteriaInternal() {
        return new ShiguJdcatExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguJdcatExample.Criteria andTbCidIsNull() {
            return isNull(tbCid);
        }

        public ShiguJdcatExample.Criteria andTbCidIsNotNull() {
            return isNotNull(tbCid);
        }

        public ShiguJdcatExample.Criteria andTbCidEqualTo(Long value) {
            return equalTo(tbCid, value);
        }

        public ShiguJdcatExample.Criteria andTbCidNotEqualTo(Long value) {
            return notEqualTo(tbCid, value);
        }

        public ShiguJdcatExample.Criteria andTbCidGreaterThan(Long value) {
            return greaterThan(tbCid, value);
        }

        public ShiguJdcatExample.Criteria andTbCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tbCid, value);
        }

        public ShiguJdcatExample.Criteria andTbCidLessThan(Long value) {
            return lessThan(tbCid, value);
        }

        public ShiguJdcatExample.Criteria andTbCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tbCid, value);
        }

        public ShiguJdcatExample.Criteria andTbCidIn(List<Long> values) {
            return in(tbCid, values);
        }

        public ShiguJdcatExample.Criteria andTbCidNotIn(List<Long> values) {
            return notIn(tbCid, values);
        }

        public ShiguJdcatExample.Criteria andTbCidBetween(Long value1, Long value2) {
            return between(tbCid, value1, value2);
        }

        public ShiguJdcatExample.Criteria andTbCidNotBetween(Long value1, Long value2) {
            return notBetween(tbCid, value1, value2);
        }
        public ShiguJdcatExample.Criteria andParentCnameIsNull() {
            return isNull(parentCname);
        }

        public ShiguJdcatExample.Criteria andParentCnameIsNotNull() {
            return isNotNull(parentCname);
        }

        public ShiguJdcatExample.Criteria andParentCnameEqualTo(String value) {
            return equalTo(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameNotEqualTo(String value) {
            return notEqualTo(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameGreaterThan(String value) {
            return greaterThan(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameLessThan(String value) {
            return lessThan(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameLike(String value) {
            return like(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameNotLike(String value) {
            return notLike(parentCname, value);
        }

        public ShiguJdcatExample.Criteria andParentCnameIn(List<String> values) {
            return in(parentCname, values);
        }

        public ShiguJdcatExample.Criteria andParentCnameNotIn(List<String> values) {
            return notIn(parentCname, values);
        }

        public ShiguJdcatExample.Criteria andParentCnameBetween(String value1, String value2) {
            return between(parentCname, value1, value2);
        }

        public ShiguJdcatExample.Criteria andParentCnameNotBetween(String value1, String value2) {
            return notBetween(parentCname, value1, value2);
        }
        public ShiguJdcatExample.Criteria andParentCidIsNull() {
            return isNull(parentCid);
        }

        public ShiguJdcatExample.Criteria andParentCidIsNotNull() {
            return isNotNull(parentCid);
        }

        public ShiguJdcatExample.Criteria andParentCidEqualTo(Long value) {
            return equalTo(parentCid, value);
        }

        public ShiguJdcatExample.Criteria andParentCidNotEqualTo(Long value) {
            return notEqualTo(parentCid, value);
        }

        public ShiguJdcatExample.Criteria andParentCidGreaterThan(Long value) {
            return greaterThan(parentCid, value);
        }

        public ShiguJdcatExample.Criteria andParentCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentCid, value);
        }

        public ShiguJdcatExample.Criteria andParentCidLessThan(Long value) {
            return lessThan(parentCid, value);
        }

        public ShiguJdcatExample.Criteria andParentCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentCid, value);
        }

        public ShiguJdcatExample.Criteria andParentCidIn(List<Long> values) {
            return in(parentCid, values);
        }

        public ShiguJdcatExample.Criteria andParentCidNotIn(List<Long> values) {
            return notIn(parentCid, values);
        }

        public ShiguJdcatExample.Criteria andParentCidBetween(Long value1, Long value2) {
            return between(parentCid, value1, value2);
        }

        public ShiguJdcatExample.Criteria andParentCidNotBetween(Long value1, Long value2) {
            return notBetween(parentCid, value1, value2);
        }
        public ShiguJdcatExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public ShiguJdcatExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public ShiguJdcatExample.Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public ShiguJdcatExample.Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public ShiguJdcatExample.Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public ShiguJdcatExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public ShiguJdcatExample.Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public ShiguJdcatExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public ShiguJdcatExample.Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public ShiguJdcatExample.Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public ShiguJdcatExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public ShiguJdcatExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public ShiguJdcatExample.Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public ShiguJdcatExample.Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public ShiguJdcatExample.Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public ShiguJdcatExample.Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public ShiguJdcatExample.Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public ShiguJdcatExample.Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public ShiguJdcatExample.Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public ShiguJdcatExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguJdcatExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguJdcatExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguJdcatExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguJdcatExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguJdcatExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguJdcatExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguJdcatExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguJdcatExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguJdcatExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguJdcatExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguJdcatExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguJdcatExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguJdcatExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguJdcatExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguJdcatExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguJdcatExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguJdcatExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguJdcatExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}