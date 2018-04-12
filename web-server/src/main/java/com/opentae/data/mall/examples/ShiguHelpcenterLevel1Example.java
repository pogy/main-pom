package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguHelpcenterLevel1;

import java.util.*;
public class ShiguHelpcenterLevel1Example extends SgExample<ShiguHelpcenterLevel1Example.Criteria> {
    public static final Class<ShiguHelpcenterLevel1> beanClass = ShiguHelpcenterLevel1.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn name;
    public static EntityColumn pid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        name = listMap.get("name");
        pid = listMap.get("pid");
        }

    public ShiguHelpcenterLevel1Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguHelpcenterLevel1Example.Criteria createCriteriaInternal() {
        return new ShiguHelpcenterLevel1Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameIsNull() {
            return isNull(name);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public ShiguHelpcenterLevel1Example.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public ShiguHelpcenterLevel1Example.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidEqualTo(Integer value) {
            return equalTo(pid, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidNotEqualTo(Integer value) {
            return notEqualTo(pid, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidGreaterThan(Integer value) {
            return greaterThan(pid, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidLessThan(Integer value) {
            return lessThan(pid, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(pid, value);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidIn(List<Integer> values) {
            return in(pid, values);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidNotIn(List<Integer> values) {
            return notIn(pid, values);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidBetween(Integer value1, Integer value2) {
            return between(pid, value1, value2);
        }

        public ShiguHelpcenterLevel1Example.Criteria andPidNotBetween(Integer value1, Integer value2) {
            return notBetween(pid, value1, value2);
        }
    }
}