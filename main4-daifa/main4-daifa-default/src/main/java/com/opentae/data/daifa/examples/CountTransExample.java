package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.CountTrans;

import java.util.*;
public class CountTransExample extends SgExample<CountTransExample.Criteria> {
    public static final Class<CountTrans> beanClass = CountTrans.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn id;
    public static EntityColumn finalShow;
    public static EntityColumn finalNumber;
    public static EntityColumn createDate;
    public static EntityColumn createTime;
    public static EntityColumn useSituation;
    public static EntityColumn batch;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        id = listMap.get("id");
        finalShow = listMap.get("finalShow");
        finalNumber = listMap.get("finalNumber");
        createDate = listMap.get("createDate");
        createTime = listMap.get("createTime");
        useSituation = listMap.get("useSituation");
        batch = listMap.get("batch");
    }

    public CountTransExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected CountTransExample.Criteria createCriteriaInternal() {
        return new CountTransExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public CountTransExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public CountTransExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public CountTransExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public CountTransExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public CountTransExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public CountTransExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public CountTransExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public CountTransExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public CountTransExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public CountTransExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public CountTransExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public CountTransExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public CountTransExample.Criteria andFinalShowIsNull() {
            return isNull(finalShow);
        }

        public CountTransExample.Criteria andFinalShowIsNotNull() {
            return isNotNull(finalShow);
        }

        public CountTransExample.Criteria andFinalShowEqualTo(String value) {
            return equalTo(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowNotEqualTo(String value) {
            return notEqualTo(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowGreaterThan(String value) {
            return greaterThan(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowLessThan(String value) {
            return lessThan(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowLike(String value) {
            return like(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowNotLike(String value) {
            return notLike(finalShow, value);
        }

        public CountTransExample.Criteria andFinalShowIn(List<String> values) {
            return in(finalShow, values);
        }

        public CountTransExample.Criteria andFinalShowNotIn(List<String> values) {
            return notIn(finalShow, values);
        }

        public CountTransExample.Criteria andFinalShowBetween(String value1, String value2) {
            return between(finalShow, value1, value2);
        }

        public CountTransExample.Criteria andFinalShowNotBetween(String value1, String value2) {
            return notBetween(finalShow, value1, value2);
        }
        public CountTransExample.Criteria andFinalNumberIsNull() {
            return isNull(finalNumber);
        }

        public CountTransExample.Criteria andFinalNumberIsNotNull() {
            return isNotNull(finalNumber);
        }

        public CountTransExample.Criteria andFinalNumberEqualTo(Long value) {
            return equalTo(finalNumber, value);
        }

        public CountTransExample.Criteria andFinalNumberNotEqualTo(Long value) {
            return notEqualTo(finalNumber, value);
        }

        public CountTransExample.Criteria andFinalNumberGreaterThan(Long value) {
            return greaterThan(finalNumber, value);
        }

        public CountTransExample.Criteria andFinalNumberGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(finalNumber, value);
        }

        public CountTransExample.Criteria andFinalNumberLessThan(Long value) {
            return lessThan(finalNumber, value);
        }

        public CountTransExample.Criteria andFinalNumberLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(finalNumber, value);
        }

        public CountTransExample.Criteria andFinalNumberIn(List<Long> values) {
            return in(finalNumber, values);
        }

        public CountTransExample.Criteria andFinalNumberNotIn(List<Long> values) {
            return notIn(finalNumber, values);
        }

        public CountTransExample.Criteria andFinalNumberBetween(Long value1, Long value2) {
            return between(finalNumber, value1, value2);
        }

        public CountTransExample.Criteria andFinalNumberNotBetween(Long value1, Long value2) {
            return notBetween(finalNumber, value1, value2);
        }
        public CountTransExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public CountTransExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public CountTransExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public CountTransExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public CountTransExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public CountTransExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public CountTransExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public CountTransExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public CountTransExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public CountTransExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public CountTransExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public CountTransExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public CountTransExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public CountTransExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public CountTransExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public CountTransExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public CountTransExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public CountTransExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public CountTransExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public CountTransExample.Criteria andUseSituationIsNull() {
            return isNull(useSituation);
        }

        public CountTransExample.Criteria andUseSituationIsNotNull() {
            return isNotNull(useSituation);
        }

        public CountTransExample.Criteria andUseSituationEqualTo(String value) {
            return equalTo(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationNotEqualTo(String value) {
            return notEqualTo(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationGreaterThan(String value) {
            return greaterThan(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationLessThan(String value) {
            return lessThan(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationLike(String value) {
            return like(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationNotLike(String value) {
            return notLike(useSituation, value);
        }

        public CountTransExample.Criteria andUseSituationIn(List<String> values) {
            return in(useSituation, values);
        }

        public CountTransExample.Criteria andUseSituationNotIn(List<String> values) {
            return notIn(useSituation, values);
        }

        public CountTransExample.Criteria andUseSituationBetween(String value1, String value2) {
            return between(useSituation, value1, value2);
        }

        public CountTransExample.Criteria andUseSituationNotBetween(String value1, String value2) {
            return notBetween(useSituation, value1, value2);
        }
        public CountTransExample.Criteria andBatchIsNull() {
            return isNull(batch);
        }

        public CountTransExample.Criteria andBatchIsNotNull() {
            return isNotNull(batch);
        }

        public CountTransExample.Criteria andBatchEqualTo(Integer value) {
            return equalTo(batch, value);
        }

        public CountTransExample.Criteria andBatchNotEqualTo(Integer value) {
            return notEqualTo(batch, value);
        }

        public CountTransExample.Criteria andBatchGreaterThan(Integer value) {
            return greaterThan(batch, value);
        }

        public CountTransExample.Criteria andBatchGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(batch, value);
        }

        public CountTransExample.Criteria andBatchLessThan(Integer value) {
            return lessThan(batch, value);
        }

        public CountTransExample.Criteria andBatchLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(batch, value);
        }

        public CountTransExample.Criteria andBatchIn(List<Integer> values) {
            return in(batch, values);
        }

        public CountTransExample.Criteria andBatchNotIn(List<Integer> values) {
            return notIn(batch, values);
        }

        public CountTransExample.Criteria andBatchBetween(Integer value1, Integer value2) {
            return between(batch, value1, value2);
        }

        public CountTransExample.Criteria andBatchNotBetween(Integer value1, Integer value2) {
            return notBetween(batch, value1, value2);
        }
    }
}