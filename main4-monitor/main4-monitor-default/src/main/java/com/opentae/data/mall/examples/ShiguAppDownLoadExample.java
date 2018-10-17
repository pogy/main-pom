package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguAppDownLoad;

import java.util.*;
public class ShiguAppDownLoadExample extends SgExample<ShiguAppDownLoadExample.Criteria> {
    public static final Class<ShiguAppDownLoad> beanClass = ShiguAppDownLoad.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn terminalType;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        terminalType = listMap.get("terminalType");
        }

    public ShiguAppDownLoadExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguAppDownLoadExample.Criteria createCriteriaInternal() {
        return new ShiguAppDownLoadExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguAppDownLoadExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguAppDownLoadExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguAppDownLoadExample.Criteria andIdEqualTo(Integer value) {
            return equalTo(id, value);
        }

        public ShiguAppDownLoadExample.Criteria andIdNotEqualTo(Integer value) {
            return notEqualTo(id, value);
        }

        public ShiguAppDownLoadExample.Criteria andIdGreaterThan(Integer value) {
            return greaterThan(id, value);
        }

        public ShiguAppDownLoadExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguAppDownLoadExample.Criteria andIdLessThan(Integer value) {
            return lessThan(id, value);
        }

        public ShiguAppDownLoadExample.Criteria andIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguAppDownLoadExample.Criteria andIdIn(List<Integer> values) {
            return in(id, values);
        }

        public ShiguAppDownLoadExample.Criteria andIdNotIn(List<Integer> values) {
            return notIn(id, values);
        }

        public ShiguAppDownLoadExample.Criteria andIdBetween(Integer value1, Integer value2) {
            return between(id, value1, value2);
        }

        public ShiguAppDownLoadExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguAppDownLoadExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguAppDownLoadExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguAppDownLoadExample.Criteria andTerminalTypeIsNull() {
            return isNull(terminalType);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeIsNotNull() {
            return isNotNull(terminalType);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeEqualTo(Integer value) {
            return equalTo(terminalType, value);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeNotEqualTo(Integer value) {
            return notEqualTo(terminalType, value);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeGreaterThan(Integer value) {
            return greaterThan(terminalType, value);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(terminalType, value);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeLessThan(Integer value) {
            return lessThan(terminalType, value);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(terminalType, value);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeIn(List<Integer> values) {
            return in(terminalType, values);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeNotIn(List<Integer> values) {
            return notIn(terminalType, values);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeBetween(Integer value1, Integer value2) {
            return between(terminalType, value1, value2);
        }

        public ShiguAppDownLoadExample.Criteria andTerminalTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(terminalType, value1, value2);
        }
    }
}