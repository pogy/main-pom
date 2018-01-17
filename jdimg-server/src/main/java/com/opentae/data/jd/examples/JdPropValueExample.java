package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdPropValue;

import java.util.*;
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
    protected JdPropValueExample.Criteria createCriteriaInternal() {
        return new JdPropValueExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdPropValueExample.Criteria andVidIsNull() {
            return isNull(vid);
        }

        public JdPropValueExample.Criteria andVidIsNotNull() {
            return isNotNull(vid);
        }

        public JdPropValueExample.Criteria andVidEqualTo(Long value) {
            return equalTo(vid, value);
        }

        public JdPropValueExample.Criteria andVidNotEqualTo(Long value) {
            return notEqualTo(vid, value);
        }

        public JdPropValueExample.Criteria andVidGreaterThan(Long value) {
            return greaterThan(vid, value);
        }

        public JdPropValueExample.Criteria andVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(vid, value);
        }

        public JdPropValueExample.Criteria andVidLessThan(Long value) {
            return lessThan(vid, value);
        }

        public JdPropValueExample.Criteria andVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(vid, value);
        }

        public JdPropValueExample.Criteria andVidIn(List<Long> values) {
            return in(vid, values);
        }

        public JdPropValueExample.Criteria andVidNotIn(List<Long> values) {
            return notIn(vid, values);
        }

        public JdPropValueExample.Criteria andVidBetween(Long value1, Long value2) {
            return between(vid, value1, value2);
        }

        public JdPropValueExample.Criteria andVidNotBetween(Long value1, Long value2) {
            return notBetween(vid, value1, value2);
        }
        public JdPropValueExample.Criteria andJdVidIsNull() {
            return isNull(jdVid);
        }

        public JdPropValueExample.Criteria andJdVidIsNotNull() {
            return isNotNull(jdVid);
        }

        public JdPropValueExample.Criteria andJdVidEqualTo(Long value) {
            return equalTo(jdVid, value);
        }

        public JdPropValueExample.Criteria andJdVidNotEqualTo(Long value) {
            return notEqualTo(jdVid, value);
        }

        public JdPropValueExample.Criteria andJdVidGreaterThan(Long value) {
            return greaterThan(jdVid, value);
        }

        public JdPropValueExample.Criteria andJdVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdVid, value);
        }

        public JdPropValueExample.Criteria andJdVidLessThan(Long value) {
            return lessThan(jdVid, value);
        }

        public JdPropValueExample.Criteria andJdVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdVid, value);
        }

        public JdPropValueExample.Criteria andJdVidIn(List<Long> values) {
            return in(jdVid, values);
        }

        public JdPropValueExample.Criteria andJdVidNotIn(List<Long> values) {
            return notIn(jdVid, values);
        }

        public JdPropValueExample.Criteria andJdVidBetween(Long value1, Long value2) {
            return between(jdVid, value1, value2);
        }

        public JdPropValueExample.Criteria andJdVidNotBetween(Long value1, Long value2) {
            return notBetween(jdVid, value1, value2);
        }
        public JdPropValueExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public JdPropValueExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public JdPropValueExample.Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public JdPropValueExample.Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public JdPropValueExample.Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public JdPropValueExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public JdPropValueExample.Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public JdPropValueExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public JdPropValueExample.Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public JdPropValueExample.Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public JdPropValueExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public JdPropValueExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public JdPropValueExample.Criteria andNameAliasIsNull() {
            return isNull(nameAlias);
        }

        public JdPropValueExample.Criteria andNameAliasIsNotNull() {
            return isNotNull(nameAlias);
        }

        public JdPropValueExample.Criteria andNameAliasEqualTo(String value) {
            return equalTo(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasNotEqualTo(String value) {
            return notEqualTo(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasGreaterThan(String value) {
            return greaterThan(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasLessThan(String value) {
            return lessThan(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasLike(String value) {
            return like(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasNotLike(String value) {
            return notLike(nameAlias, value);
        }

        public JdPropValueExample.Criteria andNameAliasIn(List<String> values) {
            return in(nameAlias, values);
        }

        public JdPropValueExample.Criteria andNameAliasNotIn(List<String> values) {
            return notIn(nameAlias, values);
        }

        public JdPropValueExample.Criteria andNameAliasBetween(String value1, String value2) {
            return between(nameAlias, value1, value2);
        }

        public JdPropValueExample.Criteria andNameAliasNotBetween(String value1, String value2) {
            return notBetween(nameAlias, value1, value2);
        }
        public JdPropValueExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public JdPropValueExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public JdPropValueExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public JdPropValueExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public JdPropValueExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public JdPropValueExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public JdPropValueExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public JdPropValueExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public JdPropValueExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public JdPropValueExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public JdPropValueExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public JdPropValueExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public JdPropValueExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public JdPropValueExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public JdPropValueExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public JdPropValueExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public JdPropValueExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public JdPropValueExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public JdPropValueExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public JdPropValueExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public JdPropValueExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public JdPropValueExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public JdPropValueExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public JdPropValueExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public JdPropValueExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public JdPropValueExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public JdPropValueExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public JdPropValueExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public JdPropValueExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public JdPropValueExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public JdPropValueExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public JdPropValueExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public JdPropValueExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public JdPropValueExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public JdPropValueExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public JdPropValueExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public JdPropValueExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public JdPropValueExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public JdPropValueExample.Criteria andPropNameIsNull() {
            return isNull(propName);
        }

        public JdPropValueExample.Criteria andPropNameIsNotNull() {
            return isNotNull(propName);
        }

        public JdPropValueExample.Criteria andPropNameEqualTo(String value) {
            return equalTo(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameNotEqualTo(String value) {
            return notEqualTo(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameGreaterThan(String value) {
            return greaterThan(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameLessThan(String value) {
            return lessThan(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameLike(String value) {
            return like(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameNotLike(String value) {
            return notLike(propName, value);
        }

        public JdPropValueExample.Criteria andPropNameIn(List<String> values) {
            return in(propName, values);
        }

        public JdPropValueExample.Criteria andPropNameNotIn(List<String> values) {
            return notIn(propName, values);
        }

        public JdPropValueExample.Criteria andPropNameBetween(String value1, String value2) {
            return between(propName, value1, value2);
        }

        public JdPropValueExample.Criteria andPropNameNotBetween(String value1, String value2) {
            return notBetween(propName, value1, value2);
        }
        public JdPropValueExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public JdPropValueExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public JdPropValueExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public JdPropValueExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public JdPropValueExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public JdPropValueExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public JdPropValueExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public JdPropValueExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public JdPropValueExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public JdPropValueExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public JdPropValueExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public JdPropValueExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public JdPropValueExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public JdPropValueExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public JdPropValueExample.Criteria andStatusEqualTo(String value) {
            return equalTo(status, value);
        }

        public JdPropValueExample.Criteria andStatusNotEqualTo(String value) {
            return notEqualTo(status, value);
        }

        public JdPropValueExample.Criteria andStatusGreaterThan(String value) {
            return greaterThan(status, value);
        }

        public JdPropValueExample.Criteria andStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(status, value);
        }

        public JdPropValueExample.Criteria andStatusLessThan(String value) {
            return lessThan(status, value);
        }

        public JdPropValueExample.Criteria andStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(status, value);
        }

        public JdPropValueExample.Criteria andStatusLike(String value) {
            return like(status, value);
        }

        public JdPropValueExample.Criteria andStatusNotLike(String value) {
            return notLike(status, value);
        }

        public JdPropValueExample.Criteria andStatusIn(List<String> values) {
            return in(status, values);
        }

        public JdPropValueExample.Criteria andStatusNotIn(List<String> values) {
            return notIn(status, values);
        }

        public JdPropValueExample.Criteria andStatusBetween(String value1, String value2) {
            return between(status, value1, value2);
        }

        public JdPropValueExample.Criteria andStatusNotBetween(String value1, String value2) {
            return notBetween(status, value1, value2);
        }
    }
}