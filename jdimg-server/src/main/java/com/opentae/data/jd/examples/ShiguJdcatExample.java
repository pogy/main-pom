package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.ShiguJdcat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andTbCidIsNull() {
            return isNull(tbCid);
        }

        public Criteria andTbCidIsNotNull() {
            return isNotNull(tbCid);
        }

        public Criteria andTbCidEqualTo(Long value) {
            return equalTo(tbCid, value);
        }

        public Criteria andTbCidNotEqualTo(Long value) {
            return notEqualTo(tbCid, value);
        }

        public Criteria andTbCidGreaterThan(Long value) {
            return greaterThan(tbCid, value);
        }

        public Criteria andTbCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tbCid, value);
        }

        public Criteria andTbCidLessThan(Long value) {
            return lessThan(tbCid, value);
        }

        public Criteria andTbCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tbCid, value);
        }

        public Criteria andTbCidIn(List<Long> values) {
            return in(tbCid, values);
        }

        public Criteria andTbCidNotIn(List<Long> values) {
            return notIn(tbCid, values);
        }

        public Criteria andTbCidBetween(Long value1, Long value2) {
            return between(tbCid, value1, value2);
        }

        public Criteria andTbCidNotBetween(Long value1, Long value2) {
            return notBetween(tbCid, value1, value2);
        }
        public Criteria andParentCnameIsNull() {
            return isNull(parentCname);
        }

        public Criteria andParentCnameIsNotNull() {
            return isNotNull(parentCname);
        }

        public Criteria andParentCnameEqualTo(String value) {
            return equalTo(parentCname, value);
        }

        public Criteria andParentCnameNotEqualTo(String value) {
            return notEqualTo(parentCname, value);
        }

        public Criteria andParentCnameGreaterThan(String value) {
            return greaterThan(parentCname, value);
        }

        public Criteria andParentCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentCname, value);
        }

        public Criteria andParentCnameLessThan(String value) {
            return lessThan(parentCname, value);
        }

        public Criteria andParentCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentCname, value);
        }

        public Criteria andParentCnameLike(String value) {
            return like(parentCname, value);
        }

        public Criteria andParentCnameNotLike(String value) {
            return notLike(parentCname, value);
        }

        public Criteria andParentCnameIn(List<String> values) {
            return in(parentCname, values);
        }

        public Criteria andParentCnameNotIn(List<String> values) {
            return notIn(parentCname, values);
        }

        public Criteria andParentCnameBetween(String value1, String value2) {
            return between(parentCname, value1, value2);
        }

        public Criteria andParentCnameNotBetween(String value1, String value2) {
            return notBetween(parentCname, value1, value2);
        }
        public Criteria andParentCidIsNull() {
            return isNull(parentCid);
        }

        public Criteria andParentCidIsNotNull() {
            return isNotNull(parentCid);
        }

        public Criteria andParentCidEqualTo(Long value) {
            return equalTo(parentCid, value);
        }

        public Criteria andParentCidNotEqualTo(Long value) {
            return notEqualTo(parentCid, value);
        }

        public Criteria andParentCidGreaterThan(Long value) {
            return greaterThan(parentCid, value);
        }

        public Criteria andParentCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentCid, value);
        }

        public Criteria andParentCidLessThan(Long value) {
            return lessThan(parentCid, value);
        }

        public Criteria andParentCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentCid, value);
        }

        public Criteria andParentCidIn(List<Long> values) {
            return in(parentCid, values);
        }

        public Criteria andParentCidNotIn(List<Long> values) {
            return notIn(parentCid, values);
        }

        public Criteria andParentCidBetween(Long value1, Long value2) {
            return between(parentCid, value1, value2);
        }

        public Criteria andParentCidNotBetween(Long value1, Long value2) {
            return notBetween(parentCid, value1, value2);
        }
        public Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andCidIsNull() {
            return isNull(cid);
        }

        public Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}