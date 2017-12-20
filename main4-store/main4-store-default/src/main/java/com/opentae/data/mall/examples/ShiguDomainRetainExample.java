package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguDomainRetain;

import java.util.*;
public class ShiguDomainRetainExample extends SgExample<ShiguDomainRetainExample.Criteria> {
    public static final Class<ShiguDomainRetain> beanClass = ShiguDomainRetain.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remark9;
    public static EntityColumn createTime;
    public static EntityColumn remark8;
    public static EntityColumn domain;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn id;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn status;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        remark9 = listMap.get("remark9");
        createTime = listMap.get("createTime");
        remark8 = listMap.get("remark8");
        domain = listMap.get("domain");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        id = listMap.get("id");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        status = listMap.get("status");
        remark2 = listMap.get("remark2");
        }

    public ShiguDomainRetainExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguDomainRetainExample.Criteria createCriteriaInternal() {
        return new ShiguDomainRetainExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguDomainRetainExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public ShiguDomainRetainExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public ShiguDomainRetainExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public ShiguDomainRetainExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public ShiguDomainRetainExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andDomainIsNull() {
            return isNull(domain);
        }

        public ShiguDomainRetainExample.Criteria andDomainIsNotNull() {
            return isNotNull(domain);
        }

        public ShiguDomainRetainExample.Criteria andDomainEqualTo(String value) {
            return equalTo(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainNotEqualTo(String value) {
            return notEqualTo(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainGreaterThan(String value) {
            return greaterThan(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainLessThan(String value) {
            return lessThan(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainLike(String value) {
            return like(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainNotLike(String value) {
            return notLike(domain, value);
        }

        public ShiguDomainRetainExample.Criteria andDomainIn(List<String> values) {
            return in(domain, values);
        }

        public ShiguDomainRetainExample.Criteria andDomainNotIn(List<String> values) {
            return notIn(domain, values);
        }

        public ShiguDomainRetainExample.Criteria andDomainBetween(String value1, String value2) {
            return between(domain, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andDomainNotBetween(String value1, String value2) {
            return notBetween(domain, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguDomainRetainExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguDomainRetainExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public ShiguDomainRetainExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public ShiguDomainRetainExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguDomainRetainExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguDomainRetainExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public ShiguDomainRetainExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public ShiguDomainRetainExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguDomainRetainExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguDomainRetainExample.Criteria andIdEqualTo(Integer value) {
            return equalTo(id, value);
        }

        public ShiguDomainRetainExample.Criteria andIdNotEqualTo(Integer value) {
            return notEqualTo(id, value);
        }

        public ShiguDomainRetainExample.Criteria andIdGreaterThan(Integer value) {
            return greaterThan(id, value);
        }

        public ShiguDomainRetainExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguDomainRetainExample.Criteria andIdLessThan(Integer value) {
            return lessThan(id, value);
        }

        public ShiguDomainRetainExample.Criteria andIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguDomainRetainExample.Criteria andIdIn(List<Integer> values) {
            return in(id, values);
        }

        public ShiguDomainRetainExample.Criteria andIdNotIn(List<Integer> values) {
            return notIn(id, values);
        }

        public ShiguDomainRetainExample.Criteria andIdBetween(Integer value1, Integer value2) {
            return between(id, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public ShiguDomainRetainExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public ShiguDomainRetainExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguDomainRetainExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguDomainRetainExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguDomainRetainExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguDomainRetainExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguDomainRetainExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguDomainRetainExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguDomainRetainExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguDomainRetainExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguDomainRetainExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguDomainRetainExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguDomainRetainExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguDomainRetainExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguDomainRetainExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguDomainRetainExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
        public ShiguDomainRetainExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguDomainRetainExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguDomainRetainExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguDomainRetainExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguDomainRetainExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguDomainRetainExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
