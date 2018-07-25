package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguHelpcenterLevel2Example extends SgExample<ShiguHelpcenterLevel2Example.Criteria> {
    public static final Class<ShiguHelpcenterLevel2> beanClass = ShiguHelpcenterLevel2.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gid;
    public static EntityColumn name;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gid = listMap.get("gid");
        name = listMap.get("name");
        cid = listMap.get("cid");
        }

    public ShiguHelpcenterLevel2Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguHelpcenterLevel2Example.Criteria createCriteriaInternal() {
        return new ShiguHelpcenterLevel2Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidIsNull() {
            return isNull(gid);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidIsNotNull() {
            return isNotNull(gid);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidEqualTo(Integer value) {
            return equalTo(gid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidNotEqualTo(Integer value) {
            return notEqualTo(gid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidGreaterThan(Integer value) {
            return greaterThan(gid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(gid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidLessThan(Integer value) {
            return lessThan(gid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(gid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidIn(List<Integer> values) {
            return in(gid, values);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidNotIn(List<Integer> values) {
            return notIn(gid, values);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidBetween(Integer value1, Integer value2) {
            return between(gid, value1, value2);
        }

        public ShiguHelpcenterLevel2Example.Criteria andGidNotBetween(Integer value1, Integer value2) {
            return notBetween(gid, value1, value2);
        }
        public ShiguHelpcenterLevel2Example.Criteria andNameIsNull() {
            return isNull(name);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public ShiguHelpcenterLevel2Example.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public ShiguHelpcenterLevel2Example.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidEqualTo(Integer value) {
            return equalTo(cid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidNotEqualTo(Integer value) {
            return notEqualTo(cid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidGreaterThan(Integer value) {
            return greaterThan(cid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidLessThan(Integer value) {
            return lessThan(cid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidIn(List<Integer> values) {
            return in(cid, values);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidNotIn(List<Integer> values) {
            return notIn(cid, values);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidBetween(Integer value1, Integer value2) {
            return between(cid, value1, value2);
        }

        public ShiguHelpcenterLevel2Example.Criteria andCidNotBetween(Integer value1, Integer value2) {
            return notBetween(cid, value1, value2);
        }
    }
}