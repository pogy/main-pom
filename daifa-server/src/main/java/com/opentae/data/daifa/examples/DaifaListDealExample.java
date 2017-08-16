package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaListDeal;

import java.util.*;
public class DaifaListDealExample extends SgExample<DaifaListDealExample.Criteria> {
    public static final Class<DaifaListDeal> beanClass = DaifaListDeal.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn listId;
    public static EntityColumn createDate;
    public static EntityColumn sellerId;
    public static EntityColumn userId;
    public static EntityColumn type;
    public static EntityColumn num;
    public static EntityColumn listCode;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn remark3;
    public static EntityColumn remark4;
    public static EntityColumn remark5;
    public static EntityColumn remark6;
    public static EntityColumn remark7;
    public static EntityColumn remark8;
    public static EntityColumn remark9;
    public static EntityColumn remark10;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        listId = listMap.get("listId");
        createDate = listMap.get("createDate");
        sellerId = listMap.get("sellerId");
        userId = listMap.get("userId");
        type = listMap.get("type");
        num = listMap.get("num");
        listCode = listMap.get("listCode");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        remark3 = listMap.get("remark3");
        remark4 = listMap.get("remark4");
        remark5 = listMap.get("remark5");
        remark6 = listMap.get("remark6");
        remark7 = listMap.get("remark7");
        remark8 = listMap.get("remark8");
        remark9 = listMap.get("remark9");
        remark10 = listMap.get("remark10");
    }

    public DaifaListDealExample() {
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

        public Criteria andListIdIsNull() {
            return isNull(listId);
        }

        public Criteria andListIdIsNotNull() {
            return isNotNull(listId);
        }

        public Criteria andListIdEqualTo(Long value) {
            return equalTo(listId, value);
        }

        public Criteria andListIdNotEqualTo(Long value) {
            return notEqualTo(listId, value);
        }

        public Criteria andListIdGreaterThan(Long value) {
            return greaterThan(listId, value);
        }

        public Criteria andListIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(listId, value);
        }

        public Criteria andListIdLessThan(Long value) {
            return lessThan(listId, value);
        }

        public Criteria andListIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(listId, value);
        }

        public Criteria andListIdIn(List<Long> values) {
            return in(listId, values);
        }

        public Criteria andListIdNotIn(List<Long> values) {
            return notIn(listId, values);
        }

        public Criteria andListIdBetween(Long value1, Long value2) {
            return between(listId, value1, value2);
        }

        public Criteria andListIdNotBetween(Long value1, Long value2) {
            return notBetween(listId, value1, value2);
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
        public Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public Criteria andTypeIsNull() {
            return isNull(type);
        }

        public Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public Criteria andTypeEqualTo(String value) {
            return equalTo(type, value);
        }

        public Criteria andTypeNotEqualTo(String value) {
            return notEqualTo(type, value);
        }

        public Criteria andTypeGreaterThan(String value) {
            return greaterThan(type, value);
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(type, value);
        }

        public Criteria andTypeLessThan(String value) {
            return lessThan(type, value);
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(type, value);
        }

        public Criteria andTypeLike(String value) {
            return like(type, value);
        }

        public Criteria andTypeNotLike(String value) {
            return notLike(type, value);
        }

        public Criteria andTypeIn(List<String> values) {
            return in(type, values);
        }

        public Criteria andTypeNotIn(List<String> values) {
            return notIn(type, values);
        }

        public Criteria andTypeBetween(String value1, String value2) {
            return between(type, value1, value2);
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            return notBetween(type, value1, value2);
        }
        public Criteria andNumIsNull() {
            return isNull(num);
        }

        public Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public Criteria andNumEqualTo(Integer value) {
            return equalTo(num, value);
        }

        public Criteria andNumNotEqualTo(Integer value) {
            return notEqualTo(num, value);
        }

        public Criteria andNumGreaterThan(Integer value) {
            return greaterThan(num, value);
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(num, value);
        }

        public Criteria andNumLessThan(Integer value) {
            return lessThan(num, value);
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(num, value);
        }

        public Criteria andNumIn(List<Integer> values) {
            return in(num, values);
        }

        public Criteria andNumNotIn(List<Integer> values) {
            return notIn(num, values);
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            return between(num, value1, value2);
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            return notBetween(num, value1, value2);
        }
        public Criteria andListCodeIsNull() {
            return isNull(listCode);
        }

        public Criteria andListCodeIsNotNull() {
            return isNotNull(listCode);
        }

        public Criteria andListCodeEqualTo(String value) {
            return equalTo(listCode, value);
        }

        public Criteria andListCodeNotEqualTo(String value) {
            return notEqualTo(listCode, value);
        }

        public Criteria andListCodeGreaterThan(String value) {
            return greaterThan(listCode, value);
        }

        public Criteria andListCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(listCode, value);
        }

        public Criteria andListCodeLessThan(String value) {
            return lessThan(listCode, value);
        }

        public Criteria andListCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(listCode, value);
        }

        public Criteria andListCodeLike(String value) {
            return like(listCode, value);
        }

        public Criteria andListCodeNotLike(String value) {
            return notLike(listCode, value);
        }

        public Criteria andListCodeIn(List<String> values) {
            return in(listCode, values);
        }

        public Criteria andListCodeNotIn(List<String> values) {
            return notIn(listCode, values);
        }

        public Criteria andListCodeBetween(String value1, String value2) {
            return between(listCode, value1, value2);
        }

        public Criteria andListCodeNotBetween(String value1, String value2) {
            return notBetween(listCode, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
    }
}