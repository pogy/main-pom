package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdTbBind;

import java.util.*;
public class JdTbBindExample extends SgExample<JdTbBindExample.Criteria> {
    public static final Class<JdTbBind> beanClass = JdTbBind.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn jdCid;
    public static EntityColumn tbCid;
    public static EntityColumn sex;
    public static EntityColumn bindId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        jdCid = listMap.get("jdCid");
        tbCid = listMap.get("tbCid");
        sex = listMap.get("sex");
        bindId = listMap.get("bindId");
        }

    public JdTbBindExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected JdTbBindExample.Criteria createCriteriaInternal() {
        return new JdTbBindExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdTbBindExample.Criteria andJdCidIsNull() {
            return isNull(jdCid);
        }

        public JdTbBindExample.Criteria andJdCidIsNotNull() {
            return isNotNull(jdCid);
        }

        public JdTbBindExample.Criteria andJdCidEqualTo(Long value) {
            return equalTo(jdCid, value);
        }

        public JdTbBindExample.Criteria andJdCidNotEqualTo(Long value) {
            return notEqualTo(jdCid, value);
        }

        public JdTbBindExample.Criteria andJdCidGreaterThan(Long value) {
            return greaterThan(jdCid, value);
        }

        public JdTbBindExample.Criteria andJdCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdCid, value);
        }

        public JdTbBindExample.Criteria andJdCidLessThan(Long value) {
            return lessThan(jdCid, value);
        }

        public JdTbBindExample.Criteria andJdCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdCid, value);
        }

        public JdTbBindExample.Criteria andJdCidIn(List<Long> values) {
            return in(jdCid, values);
        }

        public JdTbBindExample.Criteria andJdCidNotIn(List<Long> values) {
            return notIn(jdCid, values);
        }

        public JdTbBindExample.Criteria andJdCidBetween(Long value1, Long value2) {
            return between(jdCid, value1, value2);
        }

        public JdTbBindExample.Criteria andJdCidNotBetween(Long value1, Long value2) {
            return notBetween(jdCid, value1, value2);
        }
        public JdTbBindExample.Criteria andTbCidIsNull() {
            return isNull(tbCid);
        }

        public JdTbBindExample.Criteria andTbCidIsNotNull() {
            return isNotNull(tbCid);
        }

        public JdTbBindExample.Criteria andTbCidEqualTo(Long value) {
            return equalTo(tbCid, value);
        }

        public JdTbBindExample.Criteria andTbCidNotEqualTo(Long value) {
            return notEqualTo(tbCid, value);
        }

        public JdTbBindExample.Criteria andTbCidGreaterThan(Long value) {
            return greaterThan(tbCid, value);
        }

        public JdTbBindExample.Criteria andTbCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tbCid, value);
        }

        public JdTbBindExample.Criteria andTbCidLessThan(Long value) {
            return lessThan(tbCid, value);
        }

        public JdTbBindExample.Criteria andTbCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tbCid, value);
        }

        public JdTbBindExample.Criteria andTbCidIn(List<Long> values) {
            return in(tbCid, values);
        }

        public JdTbBindExample.Criteria andTbCidNotIn(List<Long> values) {
            return notIn(tbCid, values);
        }

        public JdTbBindExample.Criteria andTbCidBetween(Long value1, Long value2) {
            return between(tbCid, value1, value2);
        }

        public JdTbBindExample.Criteria andTbCidNotBetween(Long value1, Long value2) {
            return notBetween(tbCid, value1, value2);
        }
        public JdTbBindExample.Criteria andSexIsNull() {
            return isNull(sex);
        }

        public JdTbBindExample.Criteria andSexIsNotNull() {
            return isNotNull(sex);
        }

        public JdTbBindExample.Criteria andSexEqualTo(Integer value) {
            return equalTo(sex, value);
        }

        public JdTbBindExample.Criteria andSexNotEqualTo(Integer value) {
            return notEqualTo(sex, value);
        }

        public JdTbBindExample.Criteria andSexGreaterThan(Integer value) {
            return greaterThan(sex, value);
        }

        public JdTbBindExample.Criteria andSexGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sex, value);
        }

        public JdTbBindExample.Criteria andSexLessThan(Integer value) {
            return lessThan(sex, value);
        }

        public JdTbBindExample.Criteria andSexLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sex, value);
        }

        public JdTbBindExample.Criteria andSexIn(List<Integer> values) {
            return in(sex, values);
        }

        public JdTbBindExample.Criteria andSexNotIn(List<Integer> values) {
            return notIn(sex, values);
        }

        public JdTbBindExample.Criteria andSexBetween(Integer value1, Integer value2) {
            return between(sex, value1, value2);
        }

        public JdTbBindExample.Criteria andSexNotBetween(Integer value1, Integer value2) {
            return notBetween(sex, value1, value2);
        }
        public JdTbBindExample.Criteria andBindIdIsNull() {
            return isNull(bindId);
        }

        public JdTbBindExample.Criteria andBindIdIsNotNull() {
            return isNotNull(bindId);
        }

        public JdTbBindExample.Criteria andBindIdEqualTo(Long value) {
            return equalTo(bindId, value);
        }

        public JdTbBindExample.Criteria andBindIdNotEqualTo(Long value) {
            return notEqualTo(bindId, value);
        }

        public JdTbBindExample.Criteria andBindIdGreaterThan(Long value) {
            return greaterThan(bindId, value);
        }

        public JdTbBindExample.Criteria andBindIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(bindId, value);
        }

        public JdTbBindExample.Criteria andBindIdLessThan(Long value) {
            return lessThan(bindId, value);
        }

        public JdTbBindExample.Criteria andBindIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(bindId, value);
        }

        public JdTbBindExample.Criteria andBindIdIn(List<Long> values) {
            return in(bindId, values);
        }

        public JdTbBindExample.Criteria andBindIdNotIn(List<Long> values) {
            return notIn(bindId, values);
        }

        public JdTbBindExample.Criteria andBindIdBetween(Long value1, Long value2) {
            return between(bindId, value1, value2);
        }

        public JdTbBindExample.Criteria andBindIdNotBetween(Long value1, Long value2) {
            return notBetween(bindId, value1, value2);
        }
    }
}