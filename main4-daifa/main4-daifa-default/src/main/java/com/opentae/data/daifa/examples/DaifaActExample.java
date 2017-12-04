package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAct;

import java.util.*;
public class DaifaActExample extends SgExample<DaifaActExample.Criteria> {
    public static final Class<DaifaAct> beanClass = DaifaAct.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn workerId;
    public static EntityColumn param;
    public static EntityColumn created;
    public static EntityColumn actId;
    public static EntityColumn url;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        workerId = listMap.get("workerId");
        param = listMap.get("param");
        created = listMap.get("created");
        actId = listMap.get("actId");
        url = listMap.get("url");
        }

    public DaifaActExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaActExample.Criteria createCriteriaInternal() {
        return new DaifaActExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaActExample.Criteria andWorkerIdIsNull() {
            return isNull(workerId);
        }

        public DaifaActExample.Criteria andWorkerIdIsNotNull() {
            return isNotNull(workerId);
        }

        public DaifaActExample.Criteria andWorkerIdEqualTo(Long value) {
            return equalTo(workerId, value);
        }

        public DaifaActExample.Criteria andWorkerIdNotEqualTo(Long value) {
            return notEqualTo(workerId, value);
        }

        public DaifaActExample.Criteria andWorkerIdGreaterThan(Long value) {
            return greaterThan(workerId, value);
        }

        public DaifaActExample.Criteria andWorkerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(workerId, value);
        }

        public DaifaActExample.Criteria andWorkerIdLessThan(Long value) {
            return lessThan(workerId, value);
        }

        public DaifaActExample.Criteria andWorkerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(workerId, value);
        }

        public DaifaActExample.Criteria andWorkerIdIn(List<Long> values) {
            return in(workerId, values);
        }

        public DaifaActExample.Criteria andWorkerIdNotIn(List<Long> values) {
            return notIn(workerId, values);
        }

        public DaifaActExample.Criteria andWorkerIdBetween(Long value1, Long value2) {
            return between(workerId, value1, value2);
        }

        public DaifaActExample.Criteria andWorkerIdNotBetween(Long value1, Long value2) {
            return notBetween(workerId, value1, value2);
        }
        public DaifaActExample.Criteria andParamIsNull() {
            return isNull(param);
        }

        public DaifaActExample.Criteria andParamIsNotNull() {
            return isNotNull(param);
        }

        public DaifaActExample.Criteria andParamEqualTo(String value) {
            return equalTo(param, value);
        }

        public DaifaActExample.Criteria andParamNotEqualTo(String value) {
            return notEqualTo(param, value);
        }

        public DaifaActExample.Criteria andParamGreaterThan(String value) {
            return greaterThan(param, value);
        }

        public DaifaActExample.Criteria andParamGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(param, value);
        }

        public DaifaActExample.Criteria andParamLessThan(String value) {
            return lessThan(param, value);
        }

        public DaifaActExample.Criteria andParamLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(param, value);
        }

        public DaifaActExample.Criteria andParamLike(String value) {
            return like(param, value);
        }

        public DaifaActExample.Criteria andParamNotLike(String value) {
            return notLike(param, value);
        }

        public DaifaActExample.Criteria andParamIn(List<String> values) {
            return in(param, values);
        }

        public DaifaActExample.Criteria andParamNotIn(List<String> values) {
            return notIn(param, values);
        }

        public DaifaActExample.Criteria andParamBetween(String value1, String value2) {
            return between(param, value1, value2);
        }

        public DaifaActExample.Criteria andParamNotBetween(String value1, String value2) {
            return notBetween(param, value1, value2);
        }
        public DaifaActExample.Criteria andCreatedIsNull() {
            return isNull(created);
        }

        public DaifaActExample.Criteria andCreatedIsNotNull() {
            return isNotNull(created);
        }

        public DaifaActExample.Criteria andCreatedEqualTo(Date value) {
            return equalTo(created, value);
        }

        public DaifaActExample.Criteria andCreatedNotEqualTo(Date value) {
            return notEqualTo(created, value);
        }

        public DaifaActExample.Criteria andCreatedGreaterThan(Date value) {
            return greaterThan(created, value);
        }

        public DaifaActExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(created, value);
        }

        public DaifaActExample.Criteria andCreatedLessThan(Date value) {
            return lessThan(created, value);
        }

        public DaifaActExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(created, value);
        }

        public DaifaActExample.Criteria andCreatedIn(List<Date> values) {
            return in(created, values);
        }

        public DaifaActExample.Criteria andCreatedNotIn(List<Date> values) {
            return notIn(created, values);
        }

        public DaifaActExample.Criteria andCreatedBetween(Date value1, Date value2) {
            return between(created, value1, value2);
        }

        public DaifaActExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            return notBetween(created, value1, value2);
        }
        public DaifaActExample.Criteria andActIdIsNull() {
            return isNull(actId);
        }

        public DaifaActExample.Criteria andActIdIsNotNull() {
            return isNotNull(actId);
        }

        public DaifaActExample.Criteria andActIdEqualTo(Long value) {
            return equalTo(actId, value);
        }

        public DaifaActExample.Criteria andActIdNotEqualTo(Long value) {
            return notEqualTo(actId, value);
        }

        public DaifaActExample.Criteria andActIdGreaterThan(Long value) {
            return greaterThan(actId, value);
        }

        public DaifaActExample.Criteria andActIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(actId, value);
        }

        public DaifaActExample.Criteria andActIdLessThan(Long value) {
            return lessThan(actId, value);
        }

        public DaifaActExample.Criteria andActIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(actId, value);
        }

        public DaifaActExample.Criteria andActIdIn(List<Long> values) {
            return in(actId, values);
        }

        public DaifaActExample.Criteria andActIdNotIn(List<Long> values) {
            return notIn(actId, values);
        }

        public DaifaActExample.Criteria andActIdBetween(Long value1, Long value2) {
            return between(actId, value1, value2);
        }

        public DaifaActExample.Criteria andActIdNotBetween(Long value1, Long value2) {
            return notBetween(actId, value1, value2);
        }
        public DaifaActExample.Criteria andUrlIsNull() {
            return isNull(url);
        }

        public DaifaActExample.Criteria andUrlIsNotNull() {
            return isNotNull(url);
        }

        public DaifaActExample.Criteria andUrlEqualTo(String value) {
            return equalTo(url, value);
        }

        public DaifaActExample.Criteria andUrlNotEqualTo(String value) {
            return notEqualTo(url, value);
        }

        public DaifaActExample.Criteria andUrlGreaterThan(String value) {
            return greaterThan(url, value);
        }

        public DaifaActExample.Criteria andUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(url, value);
        }

        public DaifaActExample.Criteria andUrlLessThan(String value) {
            return lessThan(url, value);
        }

        public DaifaActExample.Criteria andUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(url, value);
        }

        public DaifaActExample.Criteria andUrlLike(String value) {
            return like(url, value);
        }

        public DaifaActExample.Criteria andUrlNotLike(String value) {
            return notLike(url, value);
        }

        public DaifaActExample.Criteria andUrlIn(List<String> values) {
            return in(url, values);
        }

        public DaifaActExample.Criteria andUrlNotIn(List<String> values) {
            return notIn(url, values);
        }

        public DaifaActExample.Criteria andUrlBetween(String value1, String value2) {
            return between(url, value1, value2);
        }

        public DaifaActExample.Criteria andUrlNotBetween(String value1, String value2) {
            return notBetween(url, value1, value2);
        }
    }
}