package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguShopeeCat;

import java.util.*;
public class ShiguShopeeCatExample extends SgExample<ShiguShopeeCatExample.Criteria> {
    public static final Class<ShiguShopeeCat> beanClass = ShiguShopeeCat.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn parentCname;
    public static EntityColumn parentCid;
    public static EntityColumn isParent;
    public static EntityColumn cname;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        parentCname = listMap.get("parentCname");
        parentCid = listMap.get("parentCid");
        isParent = listMap.get("isParent");
        cname = listMap.get("cname");
        cid = listMap.get("cid");
        }

    public ShiguShopeeCatExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguShopeeCatExample.Criteria createCriteriaInternal() {
        return new ShiguShopeeCatExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameIsNull() {
            return isNull(parentCname);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameIsNotNull() {
            return isNotNull(parentCname);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameEqualTo(String value) {
            return equalTo(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameNotEqualTo(String value) {
            return notEqualTo(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameGreaterThan(String value) {
            return greaterThan(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameLessThan(String value) {
            return lessThan(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameLike(String value) {
            return like(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameNotLike(String value) {
            return notLike(parentCname, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameIn(List<String> values) {
            return in(parentCname, values);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameNotIn(List<String> values) {
            return notIn(parentCname, values);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameBetween(String value1, String value2) {
            return between(parentCname, value1, value2);
        }

        public ShiguShopeeCatExample.Criteria andParentCnameNotBetween(String value1, String value2) {
            return notBetween(parentCname, value1, value2);
        }
        public ShiguShopeeCatExample.Criteria andParentCidIsNull() {
            return isNull(parentCid);
        }

        public ShiguShopeeCatExample.Criteria andParentCidIsNotNull() {
            return isNotNull(parentCid);
        }

        public ShiguShopeeCatExample.Criteria andParentCidEqualTo(Long value) {
            return equalTo(parentCid, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCidNotEqualTo(Long value) {
            return notEqualTo(parentCid, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCidGreaterThan(Long value) {
            return greaterThan(parentCid, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentCid, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCidLessThan(Long value) {
            return lessThan(parentCid, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentCid, value);
        }

        public ShiguShopeeCatExample.Criteria andParentCidIn(List<Long> values) {
            return in(parentCid, values);
        }

        public ShiguShopeeCatExample.Criteria andParentCidNotIn(List<Long> values) {
            return notIn(parentCid, values);
        }

        public ShiguShopeeCatExample.Criteria andParentCidBetween(Long value1, Long value2) {
            return between(parentCid, value1, value2);
        }

        public ShiguShopeeCatExample.Criteria andParentCidNotBetween(Long value1, Long value2) {
            return notBetween(parentCid, value1, value2);
        }
        public ShiguShopeeCatExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public ShiguShopeeCatExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public ShiguShopeeCatExample.Criteria andIsParentEqualTo(Boolean value) {
            return equalTo(isParent, value);
        }

        public ShiguShopeeCatExample.Criteria andIsParentNotEqualTo(Boolean value) {
            return notEqualTo(isParent, value);
        }

        public ShiguShopeeCatExample.Criteria andIsParentGreaterThan(Boolean value) {
            return greaterThan(isParent, value);
        }

        public ShiguShopeeCatExample.Criteria andIsParentGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public ShiguShopeeCatExample.Criteria andIsParentLessThan(Boolean value) {
            return lessThan(isParent, value);
        }

        public ShiguShopeeCatExample.Criteria andIsParentLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public ShiguShopeeCatExample.Criteria andIsParentIn(List<Boolean> values) {
            return in(isParent, values);
        }

        public ShiguShopeeCatExample.Criteria andIsParentNotIn(List<Boolean> values) {
            return notIn(isParent, values);
        }

        public ShiguShopeeCatExample.Criteria andIsParentBetween(Boolean value1, Boolean value2) {
            return between(isParent, value1, value2);
        }

        public ShiguShopeeCatExample.Criteria andIsParentNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isParent, value1, value2);
        }
        public ShiguShopeeCatExample.Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public ShiguShopeeCatExample.Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public ShiguShopeeCatExample.Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public ShiguShopeeCatExample.Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public ShiguShopeeCatExample.Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public ShiguShopeeCatExample.Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public ShiguShopeeCatExample.Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public ShiguShopeeCatExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguShopeeCatExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguShopeeCatExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguShopeeCatExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguShopeeCatExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguShopeeCatExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguShopeeCatExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguShopeeCatExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguShopeeCatExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguShopeeCatExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguShopeeCatExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguShopeeCatExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}