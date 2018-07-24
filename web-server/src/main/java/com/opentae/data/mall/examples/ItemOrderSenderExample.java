package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderSender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ItemOrderSenderExample extends SgExample<ItemOrderSenderExample.Criteria> {
    public static final Class<ItemOrderSender> beanClass = ItemOrderSender.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn senderName;
    public static EntityColumn senderId;
    public static EntityColumn address;
    public static EntityColumn name;
    public static EntityColumn topic;
    public static EntityColumn telephone;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        senderName = listMap.get("senderName");
        senderId = listMap.get("senderId");
        address = listMap.get("address");
        name = listMap.get("name");
        topic = listMap.get("topic");
        telephone = listMap.get("telephone");
        type = listMap.get("type");
        }

    public ItemOrderSenderExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemOrderSenderExample.Criteria createCriteriaInternal() {
        return new ItemOrderSenderExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderSenderExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ItemOrderSenderExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ItemOrderSenderExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ItemOrderSenderExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ItemOrderSenderExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ItemOrderSenderExample.Criteria andSenderNameIsNull() {
            return isNull(senderName);
        }

        public ItemOrderSenderExample.Criteria andSenderNameIsNotNull() {
            return isNotNull(senderName);
        }

        public ItemOrderSenderExample.Criteria andSenderNameEqualTo(String value) {
            return equalTo(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotEqualTo(String value) {
            return notEqualTo(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameGreaterThan(String value) {
            return greaterThan(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameLessThan(String value) {
            return lessThan(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameLike(String value) {
            return like(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotLike(String value) {
            return notLike(senderName, value);
        }

        public ItemOrderSenderExample.Criteria andSenderNameIn(List<String> values) {
            return in(senderName, values);
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotIn(List<String> values) {
            return notIn(senderName, values);
        }

        public ItemOrderSenderExample.Criteria andSenderNameBetween(String value1, String value2) {
            return between(senderName, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andSenderNameNotBetween(String value1, String value2) {
            return notBetween(senderName, value1, value2);
        }
        public ItemOrderSenderExample.Criteria andSenderIdIsNull() {
            return isNull(senderId);
        }

        public ItemOrderSenderExample.Criteria andSenderIdIsNotNull() {
            return isNotNull(senderId);
        }

        public ItemOrderSenderExample.Criteria andSenderIdEqualTo(Long value) {
            return equalTo(senderId, value);
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotEqualTo(Long value) {
            return notEqualTo(senderId, value);
        }

        public ItemOrderSenderExample.Criteria andSenderIdGreaterThan(Long value) {
            return greaterThan(senderId, value);
        }

        public ItemOrderSenderExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(senderId, value);
        }

        public ItemOrderSenderExample.Criteria andSenderIdLessThan(Long value) {
            return lessThan(senderId, value);
        }

        public ItemOrderSenderExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(senderId, value);
        }

        public ItemOrderSenderExample.Criteria andSenderIdIn(List<Long> values) {
            return in(senderId, values);
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotIn(List<Long> values) {
            return notIn(senderId, values);
        }

        public ItemOrderSenderExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            return between(senderId, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            return notBetween(senderId, value1, value2);
        }
        public ItemOrderSenderExample.Criteria andAddressIsNull() {
            return isNull(address);
        }

        public ItemOrderSenderExample.Criteria andAddressIsNotNull() {
            return isNotNull(address);
        }

        public ItemOrderSenderExample.Criteria andAddressEqualTo(String value) {
            return equalTo(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressNotEqualTo(String value) {
            return notEqualTo(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressGreaterThan(String value) {
            return greaterThan(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressLessThan(String value) {
            return lessThan(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressLike(String value) {
            return like(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressNotLike(String value) {
            return notLike(address, value);
        }

        public ItemOrderSenderExample.Criteria andAddressIn(List<String> values) {
            return in(address, values);
        }

        public ItemOrderSenderExample.Criteria andAddressNotIn(List<String> values) {
            return notIn(address, values);
        }

        public ItemOrderSenderExample.Criteria andAddressBetween(String value1, String value2) {
            return between(address, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andAddressNotBetween(String value1, String value2) {
            return notBetween(address, value1, value2);
        }
        public ItemOrderSenderExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public ItemOrderSenderExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public ItemOrderSenderExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public ItemOrderSenderExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public ItemOrderSenderExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public ItemOrderSenderExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public ItemOrderSenderExample.Criteria andTopicIsNull() {
            return isNull(topic);
        }

        public ItemOrderSenderExample.Criteria andTopicIsNotNull() {
            return isNotNull(topic);
        }

        public ItemOrderSenderExample.Criteria andTopicEqualTo(String value) {
            return equalTo(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicNotEqualTo(String value) {
            return notEqualTo(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicGreaterThan(String value) {
            return greaterThan(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicLessThan(String value) {
            return lessThan(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicLike(String value) {
            return like(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicNotLike(String value) {
            return notLike(topic, value);
        }

        public ItemOrderSenderExample.Criteria andTopicIn(List<String> values) {
            return in(topic, values);
        }

        public ItemOrderSenderExample.Criteria andTopicNotIn(List<String> values) {
            return notIn(topic, values);
        }

        public ItemOrderSenderExample.Criteria andTopicBetween(String value1, String value2) {
            return between(topic, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andTopicNotBetween(String value1, String value2) {
            return notBetween(topic, value1, value2);
        }
        public ItemOrderSenderExample.Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public ItemOrderSenderExample.Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public ItemOrderSenderExample.Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public ItemOrderSenderExample.Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public ItemOrderSenderExample.Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public ItemOrderSenderExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ItemOrderSenderExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ItemOrderSenderExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ItemOrderSenderExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ItemOrderSenderExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ItemOrderSenderExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ItemOrderSenderExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ItemOrderSenderExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ItemOrderSenderExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ItemOrderSenderExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ItemOrderSenderExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ItemOrderSenderExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}