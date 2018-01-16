package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdPropValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JdPropValueExample extends SgExample<JdPropValueExample.Criteria> {
    public static final Class<JdPropValue> beanClass = JdPropValue.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn vid;
    public static EntityColumn jdVid;
    public static EntityColumn isParent;
    public static EntityColumn nameAlias;
    public static EntityColumn sortOrder;
    public static EntityColumn name;
    public static EntityColumn pid;
    public static EntityColumn propName;
    public static EntityColumn cid;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        vid = listMap.get("vid");
        jdVid = listMap.get("jdVid");
        isParent = listMap.get("isParent");
        nameAlias = listMap.get("nameAlias");
        sortOrder = listMap.get("sortOrder");
        name = listMap.get("name");
        pid = listMap.get("pid");
        propName = listMap.get("propName");
        cid = listMap.get("cid");
        status = listMap.get("status");
        }

    public JdPropValueExample() {
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

        public Criteria andVidIsNull() {
            return isNull(vid);
        }

        public Criteria andVidIsNotNull() {
            return isNotNull(vid);
        }

        public Criteria andVidEqualTo(Long value) {
            return equalTo(vid, value);
        }

        public Criteria andVidNotEqualTo(Long value) {
            return notEqualTo(vid, value);
        }

        public Criteria andVidGreaterThan(Long value) {
            return greaterThan(vid, value);
        }

        public Criteria andVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(vid, value);
        }

        public Criteria andVidLessThan(Long value) {
            return lessThan(vid, value);
        }

        public Criteria andVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(vid, value);
        }

        public Criteria andVidIn(List<Long> values) {
            return in(vid, values);
        }

        public Criteria andVidNotIn(List<Long> values) {
            return notIn(vid, values);
        }

        public Criteria andVidBetween(Long value1, Long value2) {
            return between(vid, value1, value2);
        }

        public Criteria andVidNotBetween(Long value1, Long value2) {
            return notBetween(vid, value1, value2);
        }
        public Criteria andJdVidIsNull() {
            return isNull(jdVid);
        }

        public Criteria andJdVidIsNotNull() {
            return isNotNull(jdVid);
        }

        public Criteria andJdVidEqualTo(Long value) {
            return equalTo(jdVid, value);
        }

        public Criteria andJdVidNotEqualTo(Long value) {
            return notEqualTo(jdVid, value);
        }

        public Criteria andJdVidGreaterThan(Long value) {
            return greaterThan(jdVid, value);
        }

        public Criteria andJdVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdVid, value);
        }

        public Criteria andJdVidLessThan(Long value) {
            return lessThan(jdVid, value);
        }

        public Criteria andJdVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdVid, value);
        }

        public Criteria andJdVidIn(List<Long> values) {
            return in(jdVid, values);
        }

        public Criteria andJdVidNotIn(List<Long> values) {
            return notIn(jdVid, values);
        }

        public Criteria andJdVidBetween(Long value1, Long value2) {
            return between(jdVid, value1, value2);
        }

        public Criteria andJdVidNotBetween(Long value1, Long value2) {
            return notBetween(jdVid, value1, value2);
        }
        public Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public Criteria andNameAliasIsNull() {
            return isNull(nameAlias);
        }

        public Criteria andNameAliasIsNotNull() {
            return isNotNull(nameAlias);
        }

        public Criteria andNameAliasEqualTo(String value) {
            return equalTo(nameAlias, value);
        }

        public Criteria andNameAliasNotEqualTo(String value) {
            return notEqualTo(nameAlias, value);
        }

        public Criteria andNameAliasGreaterThan(String value) {
            return greaterThan(nameAlias, value);
        }

        public Criteria andNameAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nameAlias, value);
        }

        public Criteria andNameAliasLessThan(String value) {
            return lessThan(nameAlias, value);
        }

        public Criteria andNameAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nameAlias, value);
        }

        public Criteria andNameAliasLike(String value) {
            return like(nameAlias, value);
        }

        public Criteria andNameAliasNotLike(String value) {
            return notLike(nameAlias, value);
        }

        public Criteria andNameAliasIn(List<String> values) {
            return in(nameAlias, values);
        }

        public Criteria andNameAliasNotIn(List<String> values) {
            return notIn(nameAlias, values);
        }

        public Criteria andNameAliasBetween(String value1, String value2) {
            return between(nameAlias, value1, value2);
        }

        public Criteria andNameAliasNotBetween(String value1, String value2) {
            return notBetween(nameAlias, value1, value2);
        }
        public Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public Criteria andNameIsNull() {
            return isNull(name);
        }

        public Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public Criteria andNameLike(String value) {
            return like(name, value);
        }

        public Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public Criteria andPidIsNull() {
            return isNull(pid);
        }

        public Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public Criteria andPropNameIsNull() {
            return isNull(propName);
        }

        public Criteria andPropNameIsNotNull() {
            return isNotNull(propName);
        }

        public Criteria andPropNameEqualTo(String value) {
            return equalTo(propName, value);
        }

        public Criteria andPropNameNotEqualTo(String value) {
            return notEqualTo(propName, value);
        }

        public Criteria andPropNameGreaterThan(String value) {
            return greaterThan(propName, value);
        }

        public Criteria andPropNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propName, value);
        }

        public Criteria andPropNameLessThan(String value) {
            return lessThan(propName, value);
        }

        public Criteria andPropNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propName, value);
        }

        public Criteria andPropNameLike(String value) {
            return like(propName, value);
        }

        public Criteria andPropNameNotLike(String value) {
            return notLike(propName, value);
        }

        public Criteria andPropNameIn(List<String> values) {
            return in(propName, values);
        }

        public Criteria andPropNameNotIn(List<String> values) {
            return notIn(propName, values);
        }

        public Criteria andPropNameBetween(String value1, String value2) {
            return between(propName, value1, value2);
        }

        public Criteria andPropNameNotBetween(String value1, String value2) {
            return notBetween(propName, value1, value2);
        }
        public Criteria andCidIsNull() {
            return isNull(cid);
        }

        public Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public Criteria andStatusIsNull() {
            return isNull(status);
        }

        public Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public Criteria andStatusEqualTo(String value) {
            return equalTo(status, value);
        }

        public Criteria andStatusNotEqualTo(String value) {
            return notEqualTo(status, value);
        }

        public Criteria andStatusGreaterThan(String value) {
            return greaterThan(status, value);
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(status, value);
        }

        public Criteria andStatusLessThan(String value) {
            return lessThan(status, value);
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(status, value);
        }

        public Criteria andStatusLike(String value) {
            return like(status, value);
        }

        public Criteria andStatusNotLike(String value) {
            return notLike(status, value);
        }

        public Criteria andStatusIn(List<String> values) {
            return in(status, values);
        }

        public Criteria andStatusNotIn(List<String> values) {
            return notIn(status, values);
        }

        public Criteria andStatusBetween(String value1, String value2) {
            return between(status, value1, value2);
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            return notBetween(status, value1, value2);
        }
    }
}