package com.opentae.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.photo.beans.ShiguPhotoCat;

import java.util.*;
public class ShiguPhotoCatExample extends SgExample<ShiguPhotoCatExample.Criteria> {
    public static final Class<ShiguPhotoCat> beanClass = ShiguPhotoCat.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn cname;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        cname = listMap.get("cname");
        cid = listMap.get("cid");
        }

    public ShiguPhotoCatExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoCatExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoCatExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoCatExample.Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public ShiguPhotoCatExample.Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public ShiguPhotoCatExample.Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public ShiguPhotoCatExample.Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public ShiguPhotoCatExample.Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public ShiguPhotoCatExample.Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public ShiguPhotoCatExample.Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public ShiguPhotoCatExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguPhotoCatExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguPhotoCatExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguPhotoCatExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguPhotoCatExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguPhotoCatExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguPhotoCatExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguPhotoCatExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguPhotoCatExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguPhotoCatExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguPhotoCatExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguPhotoCatExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}