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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andIdIsNull() {
            return isNull(id);
        }

        public Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public Criteria andFinalShowIsNull() {
            return isNull(finalShow);
        }

        public Criteria andFinalShowIsNotNull() {
            return isNotNull(finalShow);
        }

        public Criteria andFinalShowEqualTo(String value) {
            return equalTo(finalShow, value);
        }

        public Criteria andFinalShowNotEqualTo(String value) {
            return notEqualTo(finalShow, value);
        }

        public Criteria andFinalShowGreaterThan(String value) {
            return greaterThan(finalShow, value);
        }

        public Criteria andFinalShowGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(finalShow, value);
        }

        public Criteria andFinalShowLessThan(String value) {
            return lessThan(finalShow, value);
        }

        public Criteria andFinalShowLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(finalShow, value);
        }

        public Criteria andFinalShowLike(String value) {
            return like(finalShow, value);
        }

        public Criteria andFinalShowNotLike(String value) {
            return notLike(finalShow, value);
        }

        public Criteria andFinalShowIn(List<String> values) {
            return in(finalShow, values);
        }

        public Criteria andFinalShowNotIn(List<String> values) {
            return notIn(finalShow, values);
        }

        public Criteria andFinalShowBetween(String value1, String value2) {
            return between(finalShow, value1, value2);
        }

        public Criteria andFinalShowNotBetween(String value1, String value2) {
            return notBetween(finalShow, value1, value2);
        }
        public Criteria andFinalNumberIsNull() {
            return isNull(finalNumber);
        }

        public Criteria andFinalNumberIsNotNull() {
            return isNotNull(finalNumber);
        }

        public Criteria andFinalNumberEqualTo(Long value) {
            return equalTo(finalNumber, value);
        }

        public Criteria andFinalNumberNotEqualTo(Long value) {
            return notEqualTo(finalNumber, value);
        }

        public Criteria andFinalNumberGreaterThan(Long value) {
            return greaterThan(finalNumber, value);
        }

        public Criteria andFinalNumberGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(finalNumber, value);
        }

        public Criteria andFinalNumberLessThan(Long value) {
            return lessThan(finalNumber, value);
        }

        public Criteria andFinalNumberLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(finalNumber, value);
        }

        public Criteria andFinalNumberIn(List<Long> values) {
            return in(finalNumber, values);
        }

        public Criteria andFinalNumberNotIn(List<Long> values) {
            return notIn(finalNumber, values);
        }

        public Criteria andFinalNumberBetween(Long value1, Long value2) {
            return between(finalNumber, value1, value2);
        }

        public Criteria andFinalNumberNotBetween(Long value1, Long value2) {
            return notBetween(finalNumber, value1, value2);
        }
        public Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public Criteria andUseSituationIsNull() {
            return isNull(useSituation);
        }

        public Criteria andUseSituationIsNotNull() {
            return isNotNull(useSituation);
        }

        public Criteria andUseSituationEqualTo(String value) {
            return equalTo(useSituation, value);
        }

        public Criteria andUseSituationNotEqualTo(String value) {
            return notEqualTo(useSituation, value);
        }

        public Criteria andUseSituationGreaterThan(String value) {
            return greaterThan(useSituation, value);
        }

        public Criteria andUseSituationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(useSituation, value);
        }

        public Criteria andUseSituationLessThan(String value) {
            return lessThan(useSituation, value);
        }

        public Criteria andUseSituationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(useSituation, value);
        }

        public Criteria andUseSituationLike(String value) {
            return like(useSituation, value);
        }

        public Criteria andUseSituationNotLike(String value) {
            return notLike(useSituation, value);
        }

        public Criteria andUseSituationIn(List<String> values) {
            return in(useSituation, values);
        }

        public Criteria andUseSituationNotIn(List<String> values) {
            return notIn(useSituation, values);
        }

        public Criteria andUseSituationBetween(String value1, String value2) {
            return between(useSituation, value1, value2);
        }

        public Criteria andUseSituationNotBetween(String value1, String value2) {
            return notBetween(useSituation, value1, value2);
        }
        public Criteria andBatchIsNull() {
            return isNull(batch);
        }

        public Criteria andBatchIsNotNull() {
            return isNotNull(batch);
        }

        public Criteria andBatchEqualTo(Integer value) {
            return equalTo(batch, value);
        }

        public Criteria andBatchNotEqualTo(Integer value) {
            return notEqualTo(batch, value);
        }

        public Criteria andBatchGreaterThan(Integer value) {
            return greaterThan(batch, value);
        }

        public Criteria andBatchGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(batch, value);
        }

        public Criteria andBatchLessThan(Integer value) {
            return lessThan(batch, value);
        }

        public Criteria andBatchLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(batch, value);
        }

        public Criteria andBatchIn(List<Integer> values) {
            return in(batch, values);
        }

        public Criteria andBatchNotIn(List<Integer> values) {
            return notIn(batch, values);
        }

        public Criteria andBatchBetween(Integer value1, Integer value2) {
            return between(batch, value1, value2);
        }

        public Criteria andBatchNotBetween(Integer value1, Integer value2) {
            return notBetween(batch, value1, value2);
        }
    }
}