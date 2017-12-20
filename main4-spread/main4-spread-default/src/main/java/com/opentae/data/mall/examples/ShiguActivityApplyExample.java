package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguActivityApply;

import java.util.*;
public class ShiguActivityApplyExample extends SgExample<ShiguActivityApplyExample.Criteria> {
    public static final Class<ShiguActivityApply> beanClass = ShiguActivityApply.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn applyId;
    public static EntityColumn activityId;
    public static EntityColumn phone;
    public static EntityColumn choose;
    public static EntityColumn shopId;
    public static EntityColumn items;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        applyId = listMap.get("applyId");
        activityId = listMap.get("activityId");
        phone = listMap.get("phone");
        choose = listMap.get("choose");
        shopId = listMap.get("shopId");
        items = listMap.get("items");
        userId = listMap.get("userId");
        }

    public ShiguActivityApplyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguActivityApplyExample.Criteria createCriteriaInternal() {
        return new ShiguActivityApplyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdIsNull() {
            return isNull(applyId);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdIsNotNull() {
            return isNotNull(applyId);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdEqualTo(Long value) {
            return equalTo(applyId, value);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdNotEqualTo(Long value) {
            return notEqualTo(applyId, value);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdGreaterThan(Long value) {
            return greaterThan(applyId, value);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(applyId, value);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdLessThan(Long value) {
            return lessThan(applyId, value);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(applyId, value);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdIn(List<Long> values) {
            return in(applyId, values);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdNotIn(List<Long> values) {
            return notIn(applyId, values);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            return between(applyId, value1, value2);
        }

        public ShiguActivityApplyExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            return notBetween(applyId, value1, value2);
        }
        public ShiguActivityApplyExample.Criteria andActivityIdIsNull() {
            return isNull(activityId);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdIsNotNull() {
            return isNotNull(activityId);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdEqualTo(Long value) {
            return equalTo(activityId, value);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdNotEqualTo(Long value) {
            return notEqualTo(activityId, value);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdGreaterThan(Long value) {
            return greaterThan(activityId, value);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(activityId, value);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdLessThan(Long value) {
            return lessThan(activityId, value);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(activityId, value);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdIn(List<Long> values) {
            return in(activityId, values);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdNotIn(List<Long> values) {
            return notIn(activityId, values);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            return between(activityId, value1, value2);
        }

        public ShiguActivityApplyExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            return notBetween(activityId, value1, value2);
        }
        public ShiguActivityApplyExample.Criteria andPhoneIsNull() {
            return isNull(phone);
        }

        public ShiguActivityApplyExample.Criteria andPhoneIsNotNull() {
            return isNotNull(phone);
        }

        public ShiguActivityApplyExample.Criteria andPhoneEqualTo(String value) {
            return equalTo(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotEqualTo(String value) {
            return notEqualTo(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneGreaterThan(String value) {
            return greaterThan(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneLessThan(String value) {
            return lessThan(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneLike(String value) {
            return like(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotLike(String value) {
            return notLike(phone, value);
        }

        public ShiguActivityApplyExample.Criteria andPhoneIn(List<String> values) {
            return in(phone, values);
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotIn(List<String> values) {
            return notIn(phone, values);
        }

        public ShiguActivityApplyExample.Criteria andPhoneBetween(String value1, String value2) {
            return between(phone, value1, value2);
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotBetween(String value1, String value2) {
            return notBetween(phone, value1, value2);
        }
        public ShiguActivityApplyExample.Criteria andChooseIsNull() {
            return isNull(choose);
        }

        public ShiguActivityApplyExample.Criteria andChooseIsNotNull() {
            return isNotNull(choose);
        }

        public ShiguActivityApplyExample.Criteria andChooseEqualTo(Integer value) {
            return equalTo(choose, value);
        }

        public ShiguActivityApplyExample.Criteria andChooseNotEqualTo(Integer value) {
            return notEqualTo(choose, value);
        }

        public ShiguActivityApplyExample.Criteria andChooseGreaterThan(Integer value) {
            return greaterThan(choose, value);
        }

        public ShiguActivityApplyExample.Criteria andChooseGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(choose, value);
        }

        public ShiguActivityApplyExample.Criteria andChooseLessThan(Integer value) {
            return lessThan(choose, value);
        }

        public ShiguActivityApplyExample.Criteria andChooseLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(choose, value);
        }

        public ShiguActivityApplyExample.Criteria andChooseIn(List<Integer> values) {
            return in(choose, values);
        }

        public ShiguActivityApplyExample.Criteria andChooseNotIn(List<Integer> values) {
            return notIn(choose, values);
        }

        public ShiguActivityApplyExample.Criteria andChooseBetween(Integer value1, Integer value2) {
            return between(choose, value1, value2);
        }

        public ShiguActivityApplyExample.Criteria andChooseNotBetween(Integer value1, Integer value2) {
            return notBetween(choose, value1, value2);
        }
        public ShiguActivityApplyExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShiguActivityApplyExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShiguActivityApplyExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShiguActivityApplyExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShiguActivityApplyExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShiguActivityApplyExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShiguActivityApplyExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShiguActivityApplyExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShiguActivityApplyExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShiguActivityApplyExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShiguActivityApplyExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShiguActivityApplyExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShiguActivityApplyExample.Criteria andItemsIsNull() {
            return isNull(items);
        }

        public ShiguActivityApplyExample.Criteria andItemsIsNotNull() {
            return isNotNull(items);
        }

        public ShiguActivityApplyExample.Criteria andItemsEqualTo(String value) {
            return equalTo(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsNotEqualTo(String value) {
            return notEqualTo(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsGreaterThan(String value) {
            return greaterThan(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsLessThan(String value) {
            return lessThan(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsLike(String value) {
            return like(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsNotLike(String value) {
            return notLike(items, value);
        }

        public ShiguActivityApplyExample.Criteria andItemsIn(List<String> values) {
            return in(items, values);
        }

        public ShiguActivityApplyExample.Criteria andItemsNotIn(List<String> values) {
            return notIn(items, values);
        }

        public ShiguActivityApplyExample.Criteria andItemsBetween(String value1, String value2) {
            return between(items, value1, value2);
        }

        public ShiguActivityApplyExample.Criteria andItemsNotBetween(String value1, String value2) {
            return notBetween(items, value1, value2);
        }
        public ShiguActivityApplyExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguActivityApplyExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguActivityApplyExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguActivityApplyExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguActivityApplyExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguActivityApplyExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguActivityApplyExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguActivityApplyExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguActivityApplyExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguActivityApplyExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguActivityApplyExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguActivityApplyExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}
