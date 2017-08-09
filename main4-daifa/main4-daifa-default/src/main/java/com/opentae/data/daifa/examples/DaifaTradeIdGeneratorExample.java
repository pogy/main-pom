package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaTradeIdGenerator;

import java.util.*;
public class DaifaTradeIdGeneratorExample extends SgExample<DaifaTradeIdGeneratorExample.Criteria> {
    public static final Class<DaifaTradeIdGenerator> beanClass = DaifaTradeIdGenerator.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dfTradeId;
    public static EntityColumn createTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dfTradeId = listMap.get("dfTradeId");
        createTime = listMap.get("createTime");
    }

    public DaifaTradeIdGeneratorExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaTradeIdGeneratorExample.Criteria createCriteriaInternal() {
        return new DaifaTradeIdGeneratorExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaTradeIdGeneratorExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaTradeIdGeneratorExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
    }
}
