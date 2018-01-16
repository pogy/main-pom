package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdTbBind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andJdCidIsNull() {
            return isNull(jdCid);
        }

        public Criteria andJdCidIsNotNull() {
            return isNotNull(jdCid);
        }

        public Criteria andJdCidEqualTo(Long value) {
            return equalTo(jdCid, value);
        }

        public Criteria andJdCidNotEqualTo(Long value) {
            return notEqualTo(jdCid, value);
        }

        public Criteria andJdCidGreaterThan(Long value) {
            return greaterThan(jdCid, value);
        }

        public Criteria andJdCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdCid, value);
        }

        public Criteria andJdCidLessThan(Long value) {
            return lessThan(jdCid, value);
        }

        public Criteria andJdCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdCid, value);
        }

        public Criteria andJdCidIn(List<Long> values) {
            return in(jdCid, values);
        }

        public Criteria andJdCidNotIn(List<Long> values) {
            return notIn(jdCid, values);
        }

        public Criteria andJdCidBetween(Long value1, Long value2) {
            return between(jdCid, value1, value2);
        }

        public Criteria andJdCidNotBetween(Long value1, Long value2) {
            return notBetween(jdCid, value1, value2);
        }
        public Criteria andTbCidIsNull() {
            return isNull(tbCid);
        }

        public Criteria andTbCidIsNotNull() {
            return isNotNull(tbCid);
        }

        public Criteria andTbCidEqualTo(Long value) {
            return equalTo(tbCid, value);
        }

        public Criteria andTbCidNotEqualTo(Long value) {
            return notEqualTo(tbCid, value);
        }

        public Criteria andTbCidGreaterThan(Long value) {
            return greaterThan(tbCid, value);
        }

        public Criteria andTbCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tbCid, value);
        }

        public Criteria andTbCidLessThan(Long value) {
            return lessThan(tbCid, value);
        }

        public Criteria andTbCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tbCid, value);
        }

        public Criteria andTbCidIn(List<Long> values) {
            return in(tbCid, values);
        }

        public Criteria andTbCidNotIn(List<Long> values) {
            return notIn(tbCid, values);
        }

        public Criteria andTbCidBetween(Long value1, Long value2) {
            return between(tbCid, value1, value2);
        }

        public Criteria andTbCidNotBetween(Long value1, Long value2) {
            return notBetween(tbCid, value1, value2);
        }
        public Criteria andSexIsNull() {
            return isNull(sex);
        }

        public Criteria andSexIsNotNull() {
            return isNotNull(sex);
        }

        public Criteria andSexEqualTo(Integer value) {
            return equalTo(sex, value);
        }

        public Criteria andSexNotEqualTo(Integer value) {
            return notEqualTo(sex, value);
        }

        public Criteria andSexGreaterThan(Integer value) {
            return greaterThan(sex, value);
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sex, value);
        }

        public Criteria andSexLessThan(Integer value) {
            return lessThan(sex, value);
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sex, value);
        }

        public Criteria andSexIn(List<Integer> values) {
            return in(sex, values);
        }

        public Criteria andSexNotIn(List<Integer> values) {
            return notIn(sex, values);
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            return between(sex, value1, value2);
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            return notBetween(sex, value1, value2);
        }
        public Criteria andBindIdIsNull() {
            return isNull(bindId);
        }

        public Criteria andBindIdIsNotNull() {
            return isNotNull(bindId);
        }

        public Criteria andBindIdEqualTo(Long value) {
            return equalTo(bindId, value);
        }

        public Criteria andBindIdNotEqualTo(Long value) {
            return notEqualTo(bindId, value);
        }

        public Criteria andBindIdGreaterThan(Long value) {
            return greaterThan(bindId, value);
        }

        public Criteria andBindIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(bindId, value);
        }

        public Criteria andBindIdLessThan(Long value) {
            return lessThan(bindId, value);
        }

        public Criteria andBindIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(bindId, value);
        }

        public Criteria andBindIdIn(List<Long> values) {
            return in(bindId, values);
        }

        public Criteria andBindIdNotIn(List<Long> values) {
            return notIn(bindId, values);
        }

        public Criteria andBindIdBetween(Long value1, Long value2) {
            return between(bindId, value1, value2);
        }

        public Criteria andBindIdNotBetween(Long value1, Long value2) {
            return notBetween(bindId, value1, value2);
        }
    }
}