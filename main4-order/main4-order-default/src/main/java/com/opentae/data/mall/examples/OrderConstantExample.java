package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.OrderConstant;

import java.util.*;
public class OrderConstantExample extends SgExample<OrderConstantExample.Criteria> {
    public static final Class<OrderConstant> beanClass = OrderConstant.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn senderId;
    public static EntityColumn name;
    public static EntityColumn context;
    public static EntityColumn id;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        senderId = listMap.get("senderId");
        name = listMap.get("name");
        context = listMap.get("context");
        id = listMap.get("id");
        type = listMap.get("type");
        }

    public OrderConstantExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected OrderConstantExample.Criteria createCriteriaInternal() {
        return new OrderConstantExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public OrderConstantExample.Criteria andSenderIdIsNull() {
            return isNull(senderId);
        }

        public OrderConstantExample.Criteria andSenderIdIsNotNull() {
            return isNotNull(senderId);
        }

        public OrderConstantExample.Criteria andSenderIdEqualTo(Long value) {
            return equalTo(senderId, value);
        }

        public OrderConstantExample.Criteria andSenderIdNotEqualTo(Long value) {
            return notEqualTo(senderId, value);
        }

        public OrderConstantExample.Criteria andSenderIdGreaterThan(Long value) {
            return greaterThan(senderId, value);
        }

        public OrderConstantExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(senderId, value);
        }

        public OrderConstantExample.Criteria andSenderIdLessThan(Long value) {
            return lessThan(senderId, value);
        }

        public OrderConstantExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(senderId, value);
        }

        public OrderConstantExample.Criteria andSenderIdIn(List<Long> values) {
            return in(senderId, values);
        }

        public OrderConstantExample.Criteria andSenderIdNotIn(List<Long> values) {
            return notIn(senderId, values);
        }

        public OrderConstantExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            return between(senderId, value1, value2);
        }

        public OrderConstantExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            return notBetween(senderId, value1, value2);
        }
        public OrderConstantExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public OrderConstantExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public OrderConstantExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public OrderConstantExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public OrderConstantExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public OrderConstantExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public OrderConstantExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public OrderConstantExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public OrderConstantExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public OrderConstantExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public OrderConstantExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public OrderConstantExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public OrderConstantExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public OrderConstantExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public OrderConstantExample.Criteria andContextIsNull() {
            return isNull(context);
        }

        public OrderConstantExample.Criteria andContextIsNotNull() {
            return isNotNull(context);
        }

        public OrderConstantExample.Criteria andContextEqualTo(String value) {
            return equalTo(context, value);
        }

        public OrderConstantExample.Criteria andContextNotEqualTo(String value) {
            return notEqualTo(context, value);
        }

        public OrderConstantExample.Criteria andContextGreaterThan(String value) {
            return greaterThan(context, value);
        }

        public OrderConstantExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(context, value);
        }

        public OrderConstantExample.Criteria andContextLessThan(String value) {
            return lessThan(context, value);
        }

        public OrderConstantExample.Criteria andContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(context, value);
        }

        public OrderConstantExample.Criteria andContextLike(String value) {
            return like(context, value);
        }

        public OrderConstantExample.Criteria andContextNotLike(String value) {
            return notLike(context, value);
        }

        public OrderConstantExample.Criteria andContextIn(List<String> values) {
            return in(context, values);
        }

        public OrderConstantExample.Criteria andContextNotIn(List<String> values) {
            return notIn(context, values);
        }

        public OrderConstantExample.Criteria andContextBetween(String value1, String value2) {
            return between(context, value1, value2);
        }

        public OrderConstantExample.Criteria andContextNotBetween(String value1, String value2) {
            return notBetween(context, value1, value2);
        }
        public OrderConstantExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public OrderConstantExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public OrderConstantExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public OrderConstantExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public OrderConstantExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public OrderConstantExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public OrderConstantExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public OrderConstantExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public OrderConstantExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public OrderConstantExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public OrderConstantExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public OrderConstantExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public OrderConstantExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public OrderConstantExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public OrderConstantExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public OrderConstantExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public OrderConstantExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public OrderConstantExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public OrderConstantExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public OrderConstantExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public OrderConstantExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public OrderConstantExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public OrderConstantExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public OrderConstantExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}
