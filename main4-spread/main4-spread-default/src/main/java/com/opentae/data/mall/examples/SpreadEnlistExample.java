package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.SpreadEnlist;

import java.util.*;
public class SpreadEnlistExample extends SgExample<SpreadEnlistExample.Criteria> {
    public static final Class<SpreadEnlist> beanClass = SpreadEnlist.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn activityId;
    public static EntityColumn createTime;
    public static EntityColumn name;
    public static EntityColumn telephone;
    public static EntityColumn shopId;
    public static EntityColumn draw;
    public static EntityColumn userId;
    public static EntityColumn enlistId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        activityId = listMap.get("activityId");
        createTime = listMap.get("createTime");
        name = listMap.get("name");
        telephone = listMap.get("telephone");
        shopId = listMap.get("shopId");
        draw = listMap.get("draw");
        userId = listMap.get("userId");
        enlistId = listMap.get("enlistId");
        }

    public SpreadEnlistExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SpreadEnlistExample.Criteria createCriteriaInternal() {
        return new SpreadEnlistExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SpreadEnlistExample.Criteria andActivityIdIsNull() {
            return isNull(activityId);
        }

        public SpreadEnlistExample.Criteria andActivityIdIsNotNull() {
            return isNotNull(activityId);
        }

        public SpreadEnlistExample.Criteria andActivityIdEqualTo(Long value) {
            return equalTo(activityId, value);
        }

        public SpreadEnlistExample.Criteria andActivityIdNotEqualTo(Long value) {
            return notEqualTo(activityId, value);
        }

        public SpreadEnlistExample.Criteria andActivityIdGreaterThan(Long value) {
            return greaterThan(activityId, value);
        }

        public SpreadEnlistExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(activityId, value);
        }

        public SpreadEnlistExample.Criteria andActivityIdLessThan(Long value) {
            return lessThan(activityId, value);
        }

        public SpreadEnlistExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(activityId, value);
        }

        public SpreadEnlistExample.Criteria andActivityIdIn(List<Long> values) {
            return in(activityId, values);
        }

        public SpreadEnlistExample.Criteria andActivityIdNotIn(List<Long> values) {
            return notIn(activityId, values);
        }

        public SpreadEnlistExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            return between(activityId, value1, value2);
        }

        public SpreadEnlistExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            return notBetween(activityId, value1, value2);
        }
        public SpreadEnlistExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public SpreadEnlistExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public SpreadEnlistExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public SpreadEnlistExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public SpreadEnlistExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public SpreadEnlistExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public SpreadEnlistExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public SpreadEnlistExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public SpreadEnlistExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public SpreadEnlistExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public SpreadEnlistExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public SpreadEnlistExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public SpreadEnlistExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public SpreadEnlistExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public SpreadEnlistExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public SpreadEnlistExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public SpreadEnlistExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public SpreadEnlistExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public SpreadEnlistExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public SpreadEnlistExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public SpreadEnlistExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public SpreadEnlistExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public SpreadEnlistExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public SpreadEnlistExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public SpreadEnlistExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public SpreadEnlistExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public SpreadEnlistExample.Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public SpreadEnlistExample.Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public SpreadEnlistExample.Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public SpreadEnlistExample.Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public SpreadEnlistExample.Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public SpreadEnlistExample.Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public SpreadEnlistExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public SpreadEnlistExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public SpreadEnlistExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public SpreadEnlistExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public SpreadEnlistExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public SpreadEnlistExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public SpreadEnlistExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public SpreadEnlistExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public SpreadEnlistExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public SpreadEnlistExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public SpreadEnlistExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public SpreadEnlistExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public SpreadEnlistExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public SpreadEnlistExample.Criteria andDrawIsNull() {
            return isNull(draw);
        }

        public SpreadEnlistExample.Criteria andDrawIsNotNull() {
            return isNotNull(draw);
        }

        public SpreadEnlistExample.Criteria andDrawEqualTo(Integer value) {
            return equalTo(draw, value);
        }

        public SpreadEnlistExample.Criteria andDrawNotEqualTo(Integer value) {
            return notEqualTo(draw, value);
        }

        public SpreadEnlistExample.Criteria andDrawGreaterThan(Integer value) {
            return greaterThan(draw, value);
        }

        public SpreadEnlistExample.Criteria andDrawGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(draw, value);
        }

        public SpreadEnlistExample.Criteria andDrawLessThan(Integer value) {
            return lessThan(draw, value);
        }

        public SpreadEnlistExample.Criteria andDrawLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(draw, value);
        }

        public SpreadEnlistExample.Criteria andDrawIn(List<Integer> values) {
            return in(draw, values);
        }

        public SpreadEnlistExample.Criteria andDrawNotIn(List<Integer> values) {
            return notIn(draw, values);
        }

        public SpreadEnlistExample.Criteria andDrawBetween(Integer value1, Integer value2) {
            return between(draw, value1, value2);
        }

        public SpreadEnlistExample.Criteria andDrawNotBetween(Integer value1, Integer value2) {
            return notBetween(draw, value1, value2);
        }
        public SpreadEnlistExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public SpreadEnlistExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public SpreadEnlistExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public SpreadEnlistExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public SpreadEnlistExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public SpreadEnlistExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public SpreadEnlistExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public SpreadEnlistExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public SpreadEnlistExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public SpreadEnlistExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public SpreadEnlistExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public SpreadEnlistExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public SpreadEnlistExample.Criteria andEnlistIdIsNull() {
            return isNull(enlistId);
        }

        public SpreadEnlistExample.Criteria andEnlistIdIsNotNull() {
            return isNotNull(enlistId);
        }

        public SpreadEnlistExample.Criteria andEnlistIdEqualTo(Long value) {
            return equalTo(enlistId, value);
        }

        public SpreadEnlistExample.Criteria andEnlistIdNotEqualTo(Long value) {
            return notEqualTo(enlistId, value);
        }

        public SpreadEnlistExample.Criteria andEnlistIdGreaterThan(Long value) {
            return greaterThan(enlistId, value);
        }

        public SpreadEnlistExample.Criteria andEnlistIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(enlistId, value);
        }

        public SpreadEnlistExample.Criteria andEnlistIdLessThan(Long value) {
            return lessThan(enlistId, value);
        }

        public SpreadEnlistExample.Criteria andEnlistIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(enlistId, value);
        }

        public SpreadEnlistExample.Criteria andEnlistIdIn(List<Long> values) {
            return in(enlistId, values);
        }

        public SpreadEnlistExample.Criteria andEnlistIdNotIn(List<Long> values) {
            return notIn(enlistId, values);
        }

        public SpreadEnlistExample.Criteria andEnlistIdBetween(Long value1, Long value2) {
            return between(enlistId, value1, value2);
        }

        public SpreadEnlistExample.Criteria andEnlistIdNotBetween(Long value1, Long value2) {
            return notBetween(enlistId, value1, value2);
        }
    }
}
