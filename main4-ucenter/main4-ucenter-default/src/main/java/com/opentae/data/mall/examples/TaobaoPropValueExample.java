package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TaobaoPropValue;

import java.util.*;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TaobaoPropValueExample.java
 *@文件路径：com.opentae.data.mall.examples.TaobaoPropValueExample
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 06:01:29
 *@comments:
 *
 *=========================================================
 */
public class TaobaoPropValueExample extends SgExample<TaobaoPropValueExample.Criteria>{
    public static final Class<TaobaoPropValue> beanClass = TaobaoPropValue.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn tbVid;
    public static EntityColumn cid;
    public static EntityColumn pid;
    public static EntityColumn propName;
    public static EntityColumn vid;
    public static EntityColumn name;
    public static EntityColumn nameAlias;
    public static EntityColumn isParent;
    public static EntityColumn status;
    public static EntityColumn sortOrder;
    public static EntityColumn remark10;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn remark3;
    public static EntityColumn remark1;
    public static EntityColumn remark2;

    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        tbVid = listMap.get("tbVid");
        cid = listMap.get("cid");
        pid = listMap.get("pid");
        propName = listMap.get("propName");
        vid = listMap.get("vid");
        name = listMap.get("name");
        nameAlias = listMap.get("nameAlias");
        isParent = listMap.get("isParent");
        status = listMap.get("status");
        sortOrder = listMap.get("sortOrder");
        remark10 = listMap.get("remark10");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        remark3 = listMap.get("remark3");
        remark1 = listMap.get("remark1");
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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }
        public TaobaoPropValueExample.Criteria andTbVidIsNull() {
            return isNull(tbVid);
        }

        public TaobaoPropValueExample.Criteria andTbVidIsNotNull() {
            return isNotNull(tbVid);
        }

        public TaobaoPropValueExample.Criteria andTbVidEqualTo(java.lang.Long value) {
            return equalTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidNotEqualTo(java.lang.Long value) {
            return notEqualTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidGreaterThan(java.lang.Long value) {
            return greaterThan(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidLessThan(java.lang.Long value) {
            return lessThan(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andTbVidIn(List<java.lang.Long> values) {
            return in(tbVid, values);
        }

        public TaobaoPropValueExample.Criteria andTbVidNotIn(List<java.lang.Long> values) {
            return notIn(tbVid, values);
        }

        public TaobaoPropValueExample.Criteria andTbVidBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(tbVid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andTbVidNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(tbVid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andTbVidLike(String value) {return like(tbVid, value);}

        public TaobaoPropValueExample.Criteria andTbVidNotLike(String value) {
            return notLike(tbVid, value);
        }

        public TaobaoPropValueExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public TaobaoPropValueExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public TaobaoPropValueExample.Criteria andCidEqualTo(java.lang.Long value) {
            return equalTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidNotEqualTo(java.lang.Long value) {
            return notEqualTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidGreaterThan(java.lang.Long value) {
            return greaterThan(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidLessThan(java.lang.Long value) {
            return lessThan(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public TaobaoPropValueExample.Criteria andCidIn(List<java.lang.Long> values) {
            return in(cid, values);
        }

        public TaobaoPropValueExample.Criteria andCidNotIn(List<java.lang.Long> values) {
            return notIn(cid, values);
        }

        public TaobaoPropValueExample.Criteria andCidBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(cid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andCidNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(cid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andCidLike(String value) {return like(cid, value);}

        public TaobaoPropValueExample.Criteria andCidNotLike(String value) {
            return notLike(cid, value);
        }

        public TaobaoPropValueExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public TaobaoPropValueExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public TaobaoPropValueExample.Criteria andPidEqualTo(java.lang.Long value) {
            return equalTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidNotEqualTo(java.lang.Long value) {
            return notEqualTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidGreaterThan(java.lang.Long value) {
            return greaterThan(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidLessThan(java.lang.Long value) {
            return lessThan(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPidIn(List<java.lang.Long> values) {
            return in(pid, values);
        }

        public TaobaoPropValueExample.Criteria andPidNotIn(List<java.lang.Long> values) {
            return notIn(pid, values);
        }

        public TaobaoPropValueExample.Criteria andPidBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(pid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andPidNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(pid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andPidLike(String value) {return like(pid, value);}

        public TaobaoPropValueExample.Criteria andPidNotLike(String value) {
            return notLike(pid, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameIsNull() {
            return isNull(propName);
        }

        public TaobaoPropValueExample.Criteria andPropNameIsNotNull() {
            return isNotNull(propName);
        }

        public TaobaoPropValueExample.Criteria andPropNameEqualTo(java.lang.String value) {
            return equalTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameNotEqualTo(java.lang.String value) {
            return notEqualTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameGreaterThan(java.lang.String value) {
            return greaterThan(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameLessThan(java.lang.String value) {
            return lessThan(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(propName, value);
        }

        public TaobaoPropValueExample.Criteria andPropNameIn(List<java.lang.String> values) {
            return in(propName, values);
        }

        public TaobaoPropValueExample.Criteria andPropNameNotIn(List<java.lang.String> values) {
            return notIn(propName, values);
        }

        public TaobaoPropValueExample.Criteria andPropNameBetween(java.lang.String value1, java.lang.String value2) {
            return between(propName, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andPropNameNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(propName, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andPropNameLike(String value) {return like(propName, value);}

        public TaobaoPropValueExample.Criteria andPropNameNotLike(String value) {
            return notLike(propName, value);
        }

        public TaobaoPropValueExample.Criteria andVidIsNull() {
            return isNull(vid);
        }

        public TaobaoPropValueExample.Criteria andVidIsNotNull() {
            return isNotNull(vid);
        }

        public TaobaoPropValueExample.Criteria andVidEqualTo(java.lang.Long value) {
            return equalTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidNotEqualTo(java.lang.Long value) {
            return notEqualTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidGreaterThan(java.lang.Long value) {
            return greaterThan(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidLessThan(java.lang.Long value) {
            return lessThan(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(vid, value);
        }

        public TaobaoPropValueExample.Criteria andVidIn(List<java.lang.Long> values) {
            return in(vid, values);
        }

        public TaobaoPropValueExample.Criteria andVidNotIn(List<java.lang.Long> values) {
            return notIn(vid, values);
        }

        public TaobaoPropValueExample.Criteria andVidBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(vid, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andVidNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(vid, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andVidLike(String value) {return like(vid, value);}

        public TaobaoPropValueExample.Criteria andVidNotLike(String value) {
            return notLike(vid, value);
        }

        public TaobaoPropValueExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public TaobaoPropValueExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public TaobaoPropValueExample.Criteria andNameEqualTo(java.lang.String value) {
            return equalTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameNotEqualTo(java.lang.String value) {
            return notEqualTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameGreaterThan(java.lang.String value) {
            return greaterThan(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameLessThan(java.lang.String value) {
            return lessThan(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameIn(List<java.lang.String> values) {
            return in(name, values);
        }

        public TaobaoPropValueExample.Criteria andNameNotIn(List<java.lang.String> values) {
            return notIn(name, values);
        }

        public TaobaoPropValueExample.Criteria andNameBetween(java.lang.String value1, java.lang.String value2) {
            return between(name, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andNameNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(name, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andNameLike(String value) {return like(name, value);}

        public TaobaoPropValueExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasIsNull() {
            return isNull(nameAlias);
        }

        public TaobaoPropValueExample.Criteria andNameAliasIsNotNull() {
            return isNotNull(nameAlias);
        }

        public TaobaoPropValueExample.Criteria andNameAliasEqualTo(java.lang.String value) {
            return equalTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotEqualTo(java.lang.String value) {
            return notEqualTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasGreaterThan(java.lang.String value) {
            return greaterThan(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasLessThan(java.lang.String value) {
            return lessThan(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andNameAliasIn(List<java.lang.String> values) {
            return in(nameAlias, values);
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotIn(List<java.lang.String> values) {
            return notIn(nameAlias, values);
        }

        public TaobaoPropValueExample.Criteria andNameAliasBetween(java.lang.String value1, java.lang.String value2) {
            return between(nameAlias, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andNameAliasNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(nameAlias, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andNameAliasLike(String value) {return like(nameAlias, value);}

        public TaobaoPropValueExample.Criteria andNameAliasNotLike(String value) {
            return notLike(nameAlias, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public TaobaoPropValueExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public TaobaoPropValueExample.Criteria andIsParentEqualTo(java.lang.Integer value) {
            return equalTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentNotEqualTo(java.lang.Integer value) {
            return notEqualTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentGreaterThan(java.lang.Integer value) {
            return greaterThan(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentGreaterThanOrEqualTo(java.lang.Integer value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentLessThan(java.lang.Integer value) {
            return lessThan(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentLessThanOrEqualTo(java.lang.Integer value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andIsParentIn(List<java.lang.Integer> values) {
            return in(isParent, values);
        }

        public TaobaoPropValueExample.Criteria andIsParentNotIn(List<java.lang.Integer> values) {
            return notIn(isParent, values);
        }

        public TaobaoPropValueExample.Criteria andIsParentBetween(java.lang.Integer value1, java.lang.Integer value2) {
            return between(isParent, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andIsParentNotBetween(java.lang.Integer value1, java.lang.Integer value2) {
            return notBetween(isParent, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andIsParentLike(String value) {return like(isParent, value);}

        public TaobaoPropValueExample.Criteria andIsParentNotLike(String value) {
            return notLike(isParent, value);
        }

        public TaobaoPropValueExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public TaobaoPropValueExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public TaobaoPropValueExample.Criteria andStatusEqualTo(java.lang.String value) {
            return equalTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusNotEqualTo(java.lang.String value) {
            return notEqualTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusGreaterThan(java.lang.String value) {
            return greaterThan(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusGreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusLessThan(java.lang.String value) {
            return lessThan(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusLessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(status, value);
        }

        public TaobaoPropValueExample.Criteria andStatusIn(List<java.lang.String> values) {
            return in(status, values);
        }

        public TaobaoPropValueExample.Criteria andStatusNotIn(List<java.lang.String> values) {
            return notIn(status, values);
        }

        public TaobaoPropValueExample.Criteria andStatusBetween(java.lang.String value1, java.lang.String value2) {
            return between(status, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andStatusNotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(status, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andStatusLike(String value) {return like(status, value);}

        public TaobaoPropValueExample.Criteria andStatusNotLike(String value) {
            return notLike(status, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public TaobaoPropValueExample.Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public TaobaoPropValueExample.Criteria andSortOrderEqualTo(java.lang.Long value) {
            return equalTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotEqualTo(java.lang.Long value) {
            return notEqualTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderGreaterThan(java.lang.Long value) {
            return greaterThan(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderGreaterThanOrEqualTo(java.lang.Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderLessThan(java.lang.Long value) {
            return lessThan(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderLessThanOrEqualTo(java.lang.Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andSortOrderIn(List<java.lang.Long> values) {
            return in(sortOrder, values);
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotIn(List<java.lang.Long> values) {
            return notIn(sortOrder, values);
        }

        public TaobaoPropValueExample.Criteria andSortOrderBetween(java.lang.Long value1, java.lang.Long value2) {
            return between(sortOrder, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andSortOrderNotBetween(java.lang.Long value1, java.lang.Long value2) {
            return notBetween(sortOrder, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andSortOrderLike(String value) {return like(sortOrder, value);}

        public TaobaoPropValueExample.Criteria andSortOrderNotLike(String value) {
            return notLike(sortOrder, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public TaobaoPropValueExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public TaobaoPropValueExample.Criteria andRemark10EqualTo(java.lang.String value) {
            return equalTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10NotEqualTo(java.lang.String value) {
            return notEqualTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10GreaterThan(java.lang.String value) {
            return greaterThan(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10LessThan(java.lang.String value) {
            return lessThan(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark10In(List<java.lang.String> values) {
            return in(remark10, values);
        }

        public TaobaoPropValueExample.Criteria andRemark10NotIn(List<java.lang.String> values) {
            return notIn(remark10, values);
        }

        public TaobaoPropValueExample.Criteria andRemark10Between(java.lang.String value1, java.lang.String value2) {
            return between(remark10, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark10NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark10, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark10Like(String value) {return like(remark10, value);}

        public TaobaoPropValueExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public TaobaoPropValueExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public TaobaoPropValueExample.Criteria andRemark9EqualTo(java.lang.String value) {
            return equalTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9NotEqualTo(java.lang.String value) {
            return notEqualTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9GreaterThan(java.lang.String value) {
            return greaterThan(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9LessThan(java.lang.String value) {
            return lessThan(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark9In(List<java.lang.String> values) {
            return in(remark9, values);
        }

        public TaobaoPropValueExample.Criteria andRemark9NotIn(List<java.lang.String> values) {
            return notIn(remark9, values);
        }

        public TaobaoPropValueExample.Criteria andRemark9Between(java.lang.String value1, java.lang.String value2) {
            return between(remark9, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark9NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark9, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark9Like(String value) {return like(remark9, value);}

        public TaobaoPropValueExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public TaobaoPropValueExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public TaobaoPropValueExample.Criteria andRemark8EqualTo(java.lang.String value) {
            return equalTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8NotEqualTo(java.lang.String value) {
            return notEqualTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8GreaterThan(java.lang.String value) {
            return greaterThan(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8LessThan(java.lang.String value) {
            return lessThan(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark8In(List<java.lang.String> values) {
            return in(remark8, values);
        }

        public TaobaoPropValueExample.Criteria andRemark8NotIn(List<java.lang.String> values) {
            return notIn(remark8, values);
        }

        public TaobaoPropValueExample.Criteria andRemark8Between(java.lang.String value1, java.lang.String value2) {
            return between(remark8, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark8NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark8, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark8Like(String value) {return like(remark8, value);}

        public TaobaoPropValueExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public TaobaoPropValueExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public TaobaoPropValueExample.Criteria andRemark7EqualTo(java.lang.String value) {
            return equalTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7NotEqualTo(java.lang.String value) {
            return notEqualTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7GreaterThan(java.lang.String value) {
            return greaterThan(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7LessThan(java.lang.String value) {
            return lessThan(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark7In(List<java.lang.String> values) {
            return in(remark7, values);
        }

        public TaobaoPropValueExample.Criteria andRemark7NotIn(List<java.lang.String> values) {
            return notIn(remark7, values);
        }

        public TaobaoPropValueExample.Criteria andRemark7Between(java.lang.String value1, java.lang.String value2) {
            return between(remark7, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark7NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark7, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark7Like(String value) {return like(remark7, value);}

        public TaobaoPropValueExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public TaobaoPropValueExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public TaobaoPropValueExample.Criteria andRemark6EqualTo(java.lang.String value) {
            return equalTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6NotEqualTo(java.lang.String value) {
            return notEqualTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6GreaterThan(java.lang.String value) {
            return greaterThan(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6LessThan(java.lang.String value) {
            return lessThan(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark6In(List<java.lang.String> values) {
            return in(remark6, values);
        }

        public TaobaoPropValueExample.Criteria andRemark6NotIn(List<java.lang.String> values) {
            return notIn(remark6, values);
        }

        public TaobaoPropValueExample.Criteria andRemark6Between(java.lang.String value1, java.lang.String value2) {
            return between(remark6, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark6NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark6, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark6Like(String value) {return like(remark6, value);}

        public TaobaoPropValueExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public TaobaoPropValueExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public TaobaoPropValueExample.Criteria andRemark5EqualTo(java.lang.String value) {
            return equalTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5NotEqualTo(java.lang.String value) {
            return notEqualTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5GreaterThan(java.lang.String value) {
            return greaterThan(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5LessThan(java.lang.String value) {
            return lessThan(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark5In(List<java.lang.String> values) {
            return in(remark5, values);
        }

        public TaobaoPropValueExample.Criteria andRemark5NotIn(List<java.lang.String> values) {
            return notIn(remark5, values);
        }

        public TaobaoPropValueExample.Criteria andRemark5Between(java.lang.String value1, java.lang.String value2) {
            return between(remark5, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark5NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark5, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark5Like(String value) {return like(remark5, value);}

        public TaobaoPropValueExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public TaobaoPropValueExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public TaobaoPropValueExample.Criteria andRemark4EqualTo(java.lang.String value) {
            return equalTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4NotEqualTo(java.lang.String value) {
            return notEqualTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4GreaterThan(java.lang.String value) {
            return greaterThan(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4LessThan(java.lang.String value) {
            return lessThan(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark4In(List<java.lang.String> values) {
            return in(remark4, values);
        }

        public TaobaoPropValueExample.Criteria andRemark4NotIn(List<java.lang.String> values) {
            return notIn(remark4, values);
        }

        public TaobaoPropValueExample.Criteria andRemark4Between(java.lang.String value1, java.lang.String value2) {
            return between(remark4, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark4NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark4, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark4Like(String value) {return like(remark4, value);}

        public TaobaoPropValueExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public TaobaoPropValueExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public TaobaoPropValueExample.Criteria andRemark3EqualTo(java.lang.String value) {
            return equalTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3NotEqualTo(java.lang.String value) {
            return notEqualTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3GreaterThan(java.lang.String value) {
            return greaterThan(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3LessThan(java.lang.String value) {
            return lessThan(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark3In(List<java.lang.String> values) {
            return in(remark3, values);
        }

        public TaobaoPropValueExample.Criteria andRemark3NotIn(List<java.lang.String> values) {
            return notIn(remark3, values);
        }

        public TaobaoPropValueExample.Criteria andRemark3Between(java.lang.String value1, java.lang.String value2) {
            return between(remark3, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark3NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark3, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark3Like(String value) {return like(remark3, value);}

        public TaobaoPropValueExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public TaobaoPropValueExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public TaobaoPropValueExample.Criteria andRemark1EqualTo(java.lang.String value) {
            return equalTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1NotEqualTo(java.lang.String value) {
            return notEqualTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1GreaterThan(java.lang.String value) {
            return greaterThan(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1LessThan(java.lang.String value) {
            return lessThan(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark1In(List<java.lang.String> values) {
            return in(remark1, values);
        }

        public TaobaoPropValueExample.Criteria andRemark1NotIn(List<java.lang.String> values) {
            return notIn(remark1, values);
        }

        public TaobaoPropValueExample.Criteria andRemark1Between(java.lang.String value1, java.lang.String value2) {
            return between(remark1, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark1NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark1, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark1Like(String value) {return like(remark1, value);}

        public TaobaoPropValueExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public TaobaoPropValueExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public TaobaoPropValueExample.Criteria andRemark2EqualTo(java.lang.String value) {
            return equalTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2NotEqualTo(java.lang.String value) {
            return notEqualTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2GreaterThan(java.lang.String value) {
            return greaterThan(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2GreaterThanOrEqualTo(java.lang.String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2LessThan(java.lang.String value) {
            return lessThan(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2LessThanOrEqualTo(java.lang.String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public TaobaoPropValueExample.Criteria andRemark2In(List<java.lang.String> values) {
            return in(remark2, values);
        }

        public TaobaoPropValueExample.Criteria andRemark2NotIn(List<java.lang.String> values) {
            return notIn(remark2, values);
        }

        public TaobaoPropValueExample.Criteria andRemark2Between(java.lang.String value1, java.lang.String value2) {
            return between(remark2, value1, value2);
        }

        public TaobaoPropValueExample.Criteria andRemark2NotBetween(java.lang.String value1, java.lang.String value2) {
            return notBetween(remark2, value1, value2);
        }
        public TaobaoPropValueExample.Criteria andRemark2Like(String value) {return like(remark2, value);}

        public TaobaoPropValueExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

    }
}
