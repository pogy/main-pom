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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andCdkIdIsNull() {
            return isNull(cdkId);
        }

        public Criteria andCdkIdIsNotNull() {
            return isNotNull(cdkId);
        }

        public Criteria andCdkIdEqualTo(Long value) {
            return equalTo(cdkId, value);
        }

        public Criteria andCdkIdNotEqualTo(Long value) {
            return notEqualTo(cdkId, value);
        }

        public Criteria andCdkIdGreaterThan(Long value) {
            return greaterThan(cdkId, value);
        }

        public Criteria andCdkIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cdkId, value);
        }

        public Criteria andCdkIdLessThan(Long value) {
            return lessThan(cdkId, value);
        }

        public Criteria andCdkIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cdkId, value);
        }

        public Criteria andCdkIdIn(List<Long> values) {
            return in(cdkId, values);
        }

        public Criteria andCdkIdNotIn(List<Long> values) {
            return notIn(cdkId, values);
        }

        public Criteria andCdkIdBetween(Long value1, Long value2) {
            return between(cdkId, value1, value2);
        }

        public Criteria andCdkIdNotBetween(Long value1, Long value2) {
            return notBetween(cdkId, value1, value2);
        }
        public Criteria andDateIsNull() {
            return isNull(date);
        }

        public Criteria andDateIsNotNull() {
            return isNotNull(date);
        }

        public Criteria andDateEqualTo(Date value) {
            return equalTo(date, value);
        }

        public Criteria andDateNotEqualTo(Date value) {
            return notEqualTo(date, value);
        }

        public Criteria andDateGreaterThan(Date value) {
            return greaterThan(date, value);
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(date, value);
        }

        public Criteria andDateLessThan(Date value) {
            return lessThan(date, value);
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(date, value);
        }

        public Criteria andDateIn(List<Date> values) {
            return in(date, values);
        }

        public Criteria andDateNotIn(List<Date> values) {
            return notIn(date, values);
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            return between(date, value1, value2);
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            return notBetween(date, value1, value2);
        }
        public Criteria andCdkeyIsNull() {
            return isNull(cdkey);
        }

        public Criteria andCdkeyIsNotNull() {
            return isNotNull(cdkey);
        }

        public Criteria andCdkeyEqualTo(String value) {
            return equalTo(cdkey, value);
        }

        public Criteria andCdkeyNotEqualTo(String value) {
            return notEqualTo(cdkey, value);
        }

        public Criteria andCdkeyGreaterThan(String value) {
            return greaterThan(cdkey, value);
        }

        public Criteria andCdkeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cdkey, value);
        }

        public Criteria andCdkeyLessThan(String value) {
            return lessThan(cdkey, value);
        }

        public Criteria andCdkeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cdkey, value);
        }

        public Criteria andCdkeyLike(String value) {
            return like(cdkey, value);
        }

        public Criteria andCdkeyNotLike(String value) {
            return notLike(cdkey, value);
        }

        public Criteria andCdkeyIn(List<String> values) {
            return in(cdkey, values);
        }

        public Criteria andCdkeyNotIn(List<String> values) {
            return notIn(cdkey, values);
        }

        public Criteria andCdkeyBetween(String value1, String value2) {
            return between(cdkey, value1, value2);
        }

        public Criteria andCdkeyNotBetween(String value1, String value2) {
            return notBetween(cdkey, value1, value2);
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
    }
}