package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaGgoodsMistake;

import java.util.*;
public class DaifaGgoodsMistakeExample extends SgExample<DaifaGgoodsMistakeExample.Criteria> {
    public static final Class<DaifaGgoodsMistake> beanClass = DaifaGgoodsMistake.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn daifaWorkerId;
    public static EntityColumn tasksId;
    public static EntityColumn mistakeId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        daifaWorkerId = listMap.get("daifaWorkerId");
        tasksId = listMap.get("tasksId");
        mistakeId = listMap.get("mistakeId");
        }

    public DaifaGgoodsMistakeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaGgoodsMistakeExample.Criteria createCriteriaInternal() {
        return new DaifaGgoodsMistakeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdIsNull() {
            return isNull(daifaWorkerId);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdIsNotNull() {
            return isNotNull(daifaWorkerId);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdEqualTo(Long value) {
            return equalTo(daifaWorkerId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdNotEqualTo(Long value) {
            return notEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdGreaterThan(Long value) {
            return greaterThan(daifaWorkerId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdLessThan(Long value) {
            return lessThan(daifaWorkerId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(daifaWorkerId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdIn(List<Long> values) {
            return in(daifaWorkerId, values);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdNotIn(List<Long> values) {
            return notIn(daifaWorkerId, values);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdBetween(Long value1, Long value2) {
            return between(daifaWorkerId, value1, value2);
        }

        public DaifaGgoodsMistakeExample.Criteria andDaifaWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(daifaWorkerId, value1, value2);
        }
        public DaifaGgoodsMistakeExample.Criteria andTasksIdIsNull() {
            return isNull(tasksId);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdIsNotNull() {
            return isNotNull(tasksId);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdEqualTo(Long value) {
            return equalTo(tasksId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdNotEqualTo(Long value) {
            return notEqualTo(tasksId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdGreaterThan(Long value) {
            return greaterThan(tasksId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tasksId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdLessThan(Long value) {
            return lessThan(tasksId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tasksId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdIn(List<Long> values) {
            return in(tasksId, values);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdNotIn(List<Long> values) {
            return notIn(tasksId, values);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdBetween(Long value1, Long value2) {
            return between(tasksId, value1, value2);
        }

        public DaifaGgoodsMistakeExample.Criteria andTasksIdNotBetween(Long value1, Long value2) {
            return notBetween(tasksId, value1, value2);
        }
        public DaifaGgoodsMistakeExample.Criteria andMistakeIdIsNull() {
            return isNull(mistakeId);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdIsNotNull() {
            return isNotNull(mistakeId);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdEqualTo(Long value) {
            return equalTo(mistakeId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdNotEqualTo(Long value) {
            return notEqualTo(mistakeId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdGreaterThan(Long value) {
            return greaterThan(mistakeId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(mistakeId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdLessThan(Long value) {
            return lessThan(mistakeId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(mistakeId, value);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdIn(List<Long> values) {
            return in(mistakeId, values);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdNotIn(List<Long> values) {
            return notIn(mistakeId, values);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdBetween(Long value1, Long value2) {
            return between(mistakeId, value1, value2);
        }

        public DaifaGgoodsMistakeExample.Criteria andMistakeIdNotBetween(Long value1, Long value2) {
            return notBetween(mistakeId, value1, value2);
        }
    }
}