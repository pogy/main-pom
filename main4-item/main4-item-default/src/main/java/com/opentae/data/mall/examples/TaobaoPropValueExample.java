package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TaobaoPropValue;

import java.util.*;
public class TaobaoPropValueExample extends SgExample<TaobaoPropValueExample.Criteria> {
    public static final Class<TaobaoPropValue> beanClass = TaobaoPropValue.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn isParent;
    public static EntityColumn nameAlias;
    public static EntityColumn pid;
    public static EntityColumn propName;
    public static EntityColumn vid;
    public static EntityColumn tbVid;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn sortOrder;
    public static EntityColumn name;
    public static EntityColumn remark10;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn cid;
    public static EntityColumn status;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        isParent = listMap.get("isParent");
        nameAlias = listMap.get("nameAlias");
        pid = listMap.get("pid");
        propName = listMap.get("propName");
        vid = listMap.get("vid");
        tbVid = listMap.get("tbVid");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        sortOrder = listMap.get("sortOrder");
        name = listMap.get("name");
        remark10 = listMap.get("remark10");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        cid = listMap.get("cid");
        status = listMap.get("status");
        remark2 = listMap.get("remark2");
        }

    public TaobaoPropValueExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected TaobaoPropValueExample.Criteria createCriteriaInternal() {
        return new TaobaoPropValueExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TaobaoPropValueExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public TaobaoPropValueExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public TaobaoPropValueExample.Criteria andIsParentEqualTo(Integer value) {
            return equalTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentNotEqualTo(Integer value) {
            return notEqualTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentGreaterThan(Integer value) {
            return greaterThan(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentLessThan(Integer value) {
            return lessThan(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentIn(List<Integer> values) {
            return in(isParent, values);
        }

        public TaobaoPropValueExample.Criteria andIsParentNotIn(List<Integer> values) {
            return notIn(isParent, values);
        }

        public TaobaoPropValueExample.Criteria andIsParentBetween(Integer value1, Integer value2) {
            return between(isParent, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andIsParentNotBetween(Integer value1, Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andNameAliasIsNull() {
            return isNull(nameAlias);
        }

        public TaobaoPropValueExample.Criteria andNameAliasIsNotNull() {
            return isNotNull(nameAlias);
        }

        public TaobaoPropValueExample.Criteria andNameAliasEqualTo(String value) {
            return equalTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotEqualTo(String value) {
            return notEqualTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasGreaterThan(String value) {
            return greaterThan(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasLessThan(String value) {
            return lessThan(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasLike(String value) {
            return like(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotLike(String value) {
            return notLike(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasIn(List<String> values) {
            return in(nameAlias, values);
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotIn(List<String> values) {
            return notIn(nameAlias, values);
        }

        public TaobaoPropValueExample.Criteria andNameAliasBetween(String value1, String value2) {
            return between(nameAlias, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotBetween(String value1, String value2) {
            return notBetween(nameAlias, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public TaobaoPropValueExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public TaobaoPropValueExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public TaobaoPropValueExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public TaobaoPropValueExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andPropNameIsNull() {
            return isNull(propName);
        }

        public TaobaoPropValueExample.Criteria andPropNameIsNotNull() {
            return isNotNull(propName);
        }

        public TaobaoPropValueExample.Criteria andPropNameEqualTo(String value) {
            return equalTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameNotEqualTo(String value) {
            return notEqualTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameGreaterThan(String value) {
            return greaterThan(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameLessThan(String value) {
            return lessThan(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameLike(String value) {
            return like(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameNotLike(String value) {
            return notLike(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameIn(List<String> values) {
            return in(propName, values);
        }

        public TaobaoPropValueExample.Criteria andPropNameNotIn(List<String> values) {
            return notIn(propName, values);
        }

        public TaobaoPropValueExample.Criteria andPropNameBetween(String value1, String value2) {
            return between(propName, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andPropNameNotBetween(String value1, String value2) {
            return notBetween(propName, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andVidIsNull() {
            return isNull(vid);
        }

        public TaobaoPropValueExample.Criteria andVidIsNotNull() {
            return isNotNull(vid);
        }

        public TaobaoPropValueExample.Criteria andVidEqualTo(Long value) {
            return equalTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidNotEqualTo(Long value) {
            return notEqualTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidGreaterThan(Long value) {
            return greaterThan(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidLessThan(Long value) {
            return lessThan(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidIn(List<Long> values) {
            return in(vid, values);
        }

        public TaobaoPropValueExample.Criteria andVidNotIn(List<Long> values) {
            return notIn(vid, values);
        }

        public TaobaoPropValueExample.Criteria andVidBetween(Long value1, Long value2) {
            return between(vid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andVidNotBetween(Long value1, Long value2) {
            return notBetween(vid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andTbVidIsNull() {
            return isNull(tbVid);
        }

        public TaobaoPropValueExample.Criteria andTbVidIsNotNull() {
            return isNotNull(tbVid);
        }

        public TaobaoPropValueExample.Criteria andTbVidEqualTo(Long value) {
            return equalTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidNotEqualTo(Long value) {
            return notEqualTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidGreaterThan(Long value) {
            return greaterThan(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidLessThan(Long value) {
            return lessThan(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidIn(List<Long> values) {
            return in(tbVid, values);
        }

        public TaobaoPropValueExample.Criteria andTbVidNotIn(List<Long> values) {
            return notIn(tbVid, values);
        }

        public TaobaoPropValueExample.Criteria andTbVidBetween(Long value1, Long value2) {
            return between(tbVid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andTbVidNotBetween(Long value1, Long value2) {
            return notBetween(tbVid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public TaobaoPropValueExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public TaobaoPropValueExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public TaobaoPropValueExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public TaobaoPropValueExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public TaobaoPropValueExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public TaobaoPropValueExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public TaobaoPropValueExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public TaobaoPropValueExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public TaobaoPropValueExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public TaobaoPropValueExample.Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public TaobaoPropValueExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public TaobaoPropValueExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public TaobaoPropValueExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public TaobaoPropValueExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public TaobaoPropValueExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public TaobaoPropValueExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public TaobaoPropValueExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public TaobaoPropValueExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public TaobaoPropValueExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public TaobaoPropValueExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public TaobaoPropValueExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public TaobaoPropValueExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public TaobaoPropValueExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public TaobaoPropValueExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public TaobaoPropValueExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public TaobaoPropValueExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public TaobaoPropValueExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public TaobaoPropValueExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public TaobaoPropValueExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public TaobaoPropValueExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public TaobaoPropValueExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public TaobaoPropValueExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public TaobaoPropValueExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public TaobaoPropValueExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public TaobaoPropValueExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public TaobaoPropValueExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public TaobaoPropValueExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public TaobaoPropValueExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public TaobaoPropValueExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public TaobaoPropValueExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public TaobaoPropValueExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public TaobaoPropValueExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public TaobaoPropValueExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public TaobaoPropValueExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public TaobaoPropValueExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public TaobaoPropValueExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public TaobaoPropValueExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public TaobaoPropValueExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public TaobaoPropValueExample.Criteria andStatusEqualTo(String value) {
            return equalTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusNotEqualTo(String value) {
            return notEqualTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusGreaterThan(String value) {
            return greaterThan(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusLessThan(String value) {
            return lessThan(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusLike(String value) {
            return like(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusNotLike(String value) {
            return notLike(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusIn(List<String> values) {
            return in(status, values);
        }

        public TaobaoPropValueExample.Criteria andStatusNotIn(List<String> values) {
            return notIn(status, values);
        }

        public TaobaoPropValueExample.Criteria andStatusBetween(String value1, String value2) {
            return between(status, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andStatusNotBetween(String value1, String value2) {
            return notBetween(status, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public TaobaoPropValueExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public TaobaoPropValueExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public TaobaoPropValueExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public TaobaoPropValueExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}