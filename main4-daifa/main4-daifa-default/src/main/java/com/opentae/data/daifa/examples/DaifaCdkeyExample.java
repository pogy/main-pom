package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaCdkey;

import java.util.*;
public class DaifaCdkeyExample extends SgExample<DaifaCdkeyExample.Criteria> {
    public static final Class<DaifaCdkey> beanClass = DaifaCdkey.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn cdkId;
    public static EntityColumn date;
    public static EntityColumn cdkey;
    public static EntityColumn createTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        cdkId = listMap.get("cdkId");
        date = listMap.get("date");
        cdkey = listMap.get("cdkey");
        createTime = listMap.get("createTime");
    }

    public DaifaCdkeyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaCdkeyExample.Criteria createCriteriaInternal() {
        return new DaifaCdkeyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaCdkeyExample.Criteria andCdkIdIsNull() {
            return isNull(cdkId);
        }

        public DaifaCdkeyExample.Criteria andCdkIdIsNotNull() {
            return isNotNull(cdkId);
        }

        public DaifaCdkeyExample.Criteria andCdkIdEqualTo(Long value) {
            return equalTo(cdkId, value);
        }

        public DaifaCdkeyExample.Criteria andCdkIdNotEqualTo(Long value) {
            return notEqualTo(cdkId, value);
        }

        public DaifaCdkeyExample.Criteria andCdkIdGreaterThan(Long value) {
            return greaterThan(cdkId, value);
        }

        public DaifaCdkeyExample.Criteria andCdkIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cdkId, value);
        }

        public DaifaCdkeyExample.Criteria andCdkIdLessThan(Long value) {
            return lessThan(cdkId, value);
        }

        public DaifaCdkeyExample.Criteria andCdkIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cdkId, value);
        }

        public DaifaCdkeyExample.Criteria andCdkIdIn(List<Long> values) {
            return in(cdkId, values);
        }

        public DaifaCdkeyExample.Criteria andCdkIdNotIn(List<Long> values) {
            return notIn(cdkId, values);
        }

        public DaifaCdkeyExample.Criteria andCdkIdBetween(Long value1, Long value2) {
            return between(cdkId, value1, value2);
        }

        public DaifaCdkeyExample.Criteria andCdkIdNotBetween(Long value1, Long value2) {
            return notBetween(cdkId, value1, value2);
        }
        public DaifaCdkeyExample.Criteria andDateIsNull() {
            return isNull(date);
        }

        public DaifaCdkeyExample.Criteria andDateIsNotNull() {
            return isNotNull(date);
        }

        public DaifaCdkeyExample.Criteria andDateEqualTo(Date value) {
            return equalTo(date, value);
        }

        public DaifaCdkeyExample.Criteria andDateNotEqualTo(Date value) {
            return notEqualTo(date, value);
        }

        public DaifaCdkeyExample.Criteria andDateGreaterThan(Date value) {
            return greaterThan(date, value);
        }

        public DaifaCdkeyExample.Criteria andDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(date, value);
        }

        public DaifaCdkeyExample.Criteria andDateLessThan(Date value) {
            return lessThan(date, value);
        }

        public DaifaCdkeyExample.Criteria andDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(date, value);
        }

        public DaifaCdkeyExample.Criteria andDateIn(List<Date> values) {
            return in(date, values);
        }

        public DaifaCdkeyExample.Criteria andDateNotIn(List<Date> values) {
            return notIn(date, values);
        }

        public DaifaCdkeyExample.Criteria andDateBetween(Date value1, Date value2) {
            return between(date, value1, value2);
        }

        public DaifaCdkeyExample.Criteria andDateNotBetween(Date value1, Date value2) {
            return notBetween(date, value1, value2);
        }
        public DaifaCdkeyExample.Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public DaifaCdkeyExample.Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public DaifaCdkeyExample.Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public DaifaCdkeyExample.Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public DaifaCdkeyExample.Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public DaifaCdkeyExample.Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public DaifaCdkeyExample.Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
        }
        public DaifaCdkeyExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaCdkeyExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
    }
}