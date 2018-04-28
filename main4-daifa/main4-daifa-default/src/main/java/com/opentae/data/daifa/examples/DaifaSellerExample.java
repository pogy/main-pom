package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaSeller;

import java.util.*;
public class DaifaSellerExample extends SgExample<DaifaSellerExample.Criteria> {
    public static final Class<DaifaSeller> beanClass = DaifaSeller.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn lastLogin;
    public static EntityColumn endSpeed;
    public static EntityColumn address;
    public static EntityColumn dfSellerId;
    public static EntityColumn telephone;
    public static EntityColumn alipayAccount;
    public static EntityColumn webSite;
    public static EntityColumn imWw;
    public static EntityColumn imQq;
    public static EntityColumn createTime;
    public static EntityColumn buycityId;
    public static EntityColumn name;
    public static EntityColumn weixinAccount;
    public static EntityColumn remark1;
    public static EntityColumn email;
    public static EntityColumn lastDoTime;
    public static EntityColumn status;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        lastLogin = listMap.get("lastLogin");
        endSpeed = listMap.get("endSpeed");
        address = listMap.get("address");
        dfSellerId = listMap.get("dfSellerId");
        telephone = listMap.get("telephone");
        alipayAccount = listMap.get("alipayAccount");
        webSite = listMap.get("webSite");
        imWw = listMap.get("imWw");
        imQq = listMap.get("imQq");
        createTime = listMap.get("createTime");
        buycityId = listMap.get("buycityId");
        name = listMap.get("name");
        weixinAccount = listMap.get("weixinAccount");
        remark1 = listMap.get("remark1");
        email = listMap.get("email");
        lastDoTime = listMap.get("lastDoTime");
        status = listMap.get("status");
        remark2 = listMap.get("remark2");
        }

    public DaifaSellerExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaSellerExample.Criteria createCriteriaInternal() {
        return new DaifaSellerExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaSellerExample.Criteria andLastLoginIsNull() {
            return isNull(lastLogin);
        }

        public DaifaSellerExample.Criteria andLastLoginIsNotNull() {
            return isNotNull(lastLogin);
        }

        public DaifaSellerExample.Criteria andLastLoginEqualTo(Date value) {
            return equalTo(lastLogin, value);
        }

        public DaifaSellerExample.Criteria andLastLoginNotEqualTo(Date value) {
            return notEqualTo(lastLogin, value);
        }

        public DaifaSellerExample.Criteria andLastLoginGreaterThan(Date value) {
            return greaterThan(lastLogin, value);
        }

        public DaifaSellerExample.Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastLogin, value);
        }

        public DaifaSellerExample.Criteria andLastLoginLessThan(Date value) {
            return lessThan(lastLogin, value);
        }

        public DaifaSellerExample.Criteria andLastLoginLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastLogin, value);
        }

        public DaifaSellerExample.Criteria andLastLoginIn(List<Date> values) {
            return in(lastLogin, values);
        }

        public DaifaSellerExample.Criteria andLastLoginNotIn(List<Date> values) {
            return notIn(lastLogin, values);
        }

        public DaifaSellerExample.Criteria andLastLoginBetween(Date value1, Date value2) {
            return between(lastLogin, value1, value2);
        }

        public DaifaSellerExample.Criteria andLastLoginNotBetween(Date value1, Date value2) {
            return notBetween(lastLogin, value1, value2);
        }
        public DaifaSellerExample.Criteria andEndSpeedIsNull() {
            return isNull(endSpeed);
        }

        public DaifaSellerExample.Criteria andEndSpeedIsNotNull() {
            return isNotNull(endSpeed);
        }

        public DaifaSellerExample.Criteria andEndSpeedEqualTo(Integer value) {
            return equalTo(endSpeed, value);
        }

        public DaifaSellerExample.Criteria andEndSpeedNotEqualTo(Integer value) {
            return notEqualTo(endSpeed, value);
        }

        public DaifaSellerExample.Criteria andEndSpeedGreaterThan(Integer value) {
            return greaterThan(endSpeed, value);
        }

        public DaifaSellerExample.Criteria andEndSpeedGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(endSpeed, value);
        }

        public DaifaSellerExample.Criteria andEndSpeedLessThan(Integer value) {
            return lessThan(endSpeed, value);
        }

        public DaifaSellerExample.Criteria andEndSpeedLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(endSpeed, value);
        }

        public DaifaSellerExample.Criteria andEndSpeedIn(List<Integer> values) {
            return in(endSpeed, values);
        }

        public DaifaSellerExample.Criteria andEndSpeedNotIn(List<Integer> values) {
            return notIn(endSpeed, values);
        }

        public DaifaSellerExample.Criteria andEndSpeedBetween(Integer value1, Integer value2) {
            return between(endSpeed, value1, value2);
        }

        public DaifaSellerExample.Criteria andEndSpeedNotBetween(Integer value1, Integer value2) {
            return notBetween(endSpeed, value1, value2);
        }
        public DaifaSellerExample.Criteria andAddressIsNull() {
            return isNull(address);
        }

        public DaifaSellerExample.Criteria andAddressIsNotNull() {
            return isNotNull(address);
        }

        public DaifaSellerExample.Criteria andAddressEqualTo(String value) {
            return equalTo(address, value);
        }

        public DaifaSellerExample.Criteria andAddressNotEqualTo(String value) {
            return notEqualTo(address, value);
        }

        public DaifaSellerExample.Criteria andAddressGreaterThan(String value) {
            return greaterThan(address, value);
        }

        public DaifaSellerExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(address, value);
        }

        public DaifaSellerExample.Criteria andAddressLessThan(String value) {
            return lessThan(address, value);
        }

        public DaifaSellerExample.Criteria andAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(address, value);
        }

        public DaifaSellerExample.Criteria andAddressLike(String value) {
            return like(address, value);
        }

        public DaifaSellerExample.Criteria andAddressNotLike(String value) {
            return notLike(address, value);
        }

        public DaifaSellerExample.Criteria andAddressIn(List<String> values) {
            return in(address, values);
        }

        public DaifaSellerExample.Criteria andAddressNotIn(List<String> values) {
            return notIn(address, values);
        }

        public DaifaSellerExample.Criteria andAddressBetween(String value1, String value2) {
            return between(address, value1, value2);
        }

        public DaifaSellerExample.Criteria andAddressNotBetween(String value1, String value2) {
            return notBetween(address, value1, value2);
        }
        public DaifaSellerExample.Criteria andDfSellerIdIsNull() {
            return isNull(dfSellerId);
        }

        public DaifaSellerExample.Criteria andDfSellerIdIsNotNull() {
            return isNotNull(dfSellerId);
        }

        public DaifaSellerExample.Criteria andDfSellerIdEqualTo(Long value) {
            return equalTo(dfSellerId, value);
        }

        public DaifaSellerExample.Criteria andDfSellerIdNotEqualTo(Long value) {
            return notEqualTo(dfSellerId, value);
        }

        public DaifaSellerExample.Criteria andDfSellerIdGreaterThan(Long value) {
            return greaterThan(dfSellerId, value);
        }

        public DaifaSellerExample.Criteria andDfSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfSellerId, value);
        }

        public DaifaSellerExample.Criteria andDfSellerIdLessThan(Long value) {
            return lessThan(dfSellerId, value);
        }

        public DaifaSellerExample.Criteria andDfSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfSellerId, value);
        }

        public DaifaSellerExample.Criteria andDfSellerIdIn(List<Long> values) {
            return in(dfSellerId, values);
        }

        public DaifaSellerExample.Criteria andDfSellerIdNotIn(List<Long> values) {
            return notIn(dfSellerId, values);
        }

        public DaifaSellerExample.Criteria andDfSellerIdBetween(Long value1, Long value2) {
            return between(dfSellerId, value1, value2);
        }

        public DaifaSellerExample.Criteria andDfSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(dfSellerId, value1, value2);
        }
        public DaifaSellerExample.Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public DaifaSellerExample.Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public DaifaSellerExample.Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public DaifaSellerExample.Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public DaifaSellerExample.Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public DaifaSellerExample.Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public DaifaSellerExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public DaifaSellerExample.Criteria andAlipayAccountIsNull() {
            return isNull(alipayAccount);
        }

        public DaifaSellerExample.Criteria andAlipayAccountIsNotNull() {
            return isNotNull(alipayAccount);
        }

        public DaifaSellerExample.Criteria andAlipayAccountEqualTo(String value) {
            return equalTo(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountNotEqualTo(String value) {
            return notEqualTo(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountGreaterThan(String value) {
            return greaterThan(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountLessThan(String value) {
            return lessThan(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountLike(String value) {
            return like(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountNotLike(String value) {
            return notLike(alipayAccount, value);
        }

        public DaifaSellerExample.Criteria andAlipayAccountIn(List<String> values) {
            return in(alipayAccount, values);
        }

        public DaifaSellerExample.Criteria andAlipayAccountNotIn(List<String> values) {
            return notIn(alipayAccount, values);
        }

        public DaifaSellerExample.Criteria andAlipayAccountBetween(String value1, String value2) {
            return between(alipayAccount, value1, value2);
        }

        public DaifaSellerExample.Criteria andAlipayAccountNotBetween(String value1, String value2) {
            return notBetween(alipayAccount, value1, value2);
        }
        public DaifaSellerExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public DaifaSellerExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public DaifaSellerExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public DaifaSellerExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public DaifaSellerExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public DaifaSellerExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public DaifaSellerExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public DaifaSellerExample.Criteria andImWwIsNull() {
            return isNull(imWw);
        }

        public DaifaSellerExample.Criteria andImWwIsNotNull() {
            return isNotNull(imWw);
        }

        public DaifaSellerExample.Criteria andImWwEqualTo(String value) {
            return equalTo(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwNotEqualTo(String value) {
            return notEqualTo(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwGreaterThan(String value) {
            return greaterThan(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwLessThan(String value) {
            return lessThan(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwLike(String value) {
            return like(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwNotLike(String value) {
            return notLike(imWw, value);
        }

        public DaifaSellerExample.Criteria andImWwIn(List<String> values) {
            return in(imWw, values);
        }

        public DaifaSellerExample.Criteria andImWwNotIn(List<String> values) {
            return notIn(imWw, values);
        }

        public DaifaSellerExample.Criteria andImWwBetween(String value1, String value2) {
            return between(imWw, value1, value2);
        }

        public DaifaSellerExample.Criteria andImWwNotBetween(String value1, String value2) {
            return notBetween(imWw, value1, value2);
        }
        public DaifaSellerExample.Criteria andImQqIsNull() {
            return isNull(imQq);
        }

        public DaifaSellerExample.Criteria andImQqIsNotNull() {
            return isNotNull(imQq);
        }

        public DaifaSellerExample.Criteria andImQqEqualTo(String value) {
            return equalTo(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqNotEqualTo(String value) {
            return notEqualTo(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqGreaterThan(String value) {
            return greaterThan(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqLessThan(String value) {
            return lessThan(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqLike(String value) {
            return like(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqNotLike(String value) {
            return notLike(imQq, value);
        }

        public DaifaSellerExample.Criteria andImQqIn(List<String> values) {
            return in(imQq, values);
        }

        public DaifaSellerExample.Criteria andImQqNotIn(List<String> values) {
            return notIn(imQq, values);
        }

        public DaifaSellerExample.Criteria andImQqBetween(String value1, String value2) {
            return between(imQq, value1, value2);
        }

        public DaifaSellerExample.Criteria andImQqNotBetween(String value1, String value2) {
            return notBetween(imQq, value1, value2);
        }
        public DaifaSellerExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaSellerExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaSellerExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaSellerExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaSellerExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaSellerExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaSellerExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaSellerExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaSellerExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaSellerExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaSellerExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaSellerExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaSellerExample.Criteria andBuycityIdIsNull() {
            return isNull(buycityId);
        }

        public DaifaSellerExample.Criteria andBuycityIdIsNotNull() {
            return isNotNull(buycityId);
        }

        public DaifaSellerExample.Criteria andBuycityIdEqualTo(Long value) {
            return equalTo(buycityId, value);
        }

        public DaifaSellerExample.Criteria andBuycityIdNotEqualTo(Long value) {
            return notEqualTo(buycityId, value);
        }

        public DaifaSellerExample.Criteria andBuycityIdGreaterThan(Long value) {
            return greaterThan(buycityId, value);
        }

        public DaifaSellerExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buycityId, value);
        }

        public DaifaSellerExample.Criteria andBuycityIdLessThan(Long value) {
            return lessThan(buycityId, value);
        }

        public DaifaSellerExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buycityId, value);
        }

        public DaifaSellerExample.Criteria andBuycityIdIn(List<Long> values) {
            return in(buycityId, values);
        }

        public DaifaSellerExample.Criteria andBuycityIdNotIn(List<Long> values) {
            return notIn(buycityId, values);
        }

        public DaifaSellerExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            return between(buycityId, value1, value2);
        }

        public DaifaSellerExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            return notBetween(buycityId, value1, value2);
        }
        public DaifaSellerExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public DaifaSellerExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public DaifaSellerExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public DaifaSellerExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public DaifaSellerExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public DaifaSellerExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public DaifaSellerExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public DaifaSellerExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public DaifaSellerExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public DaifaSellerExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public DaifaSellerExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public DaifaSellerExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public DaifaSellerExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public DaifaSellerExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public DaifaSellerExample.Criteria andWeixinAccountIsNull() {
            return isNull(weixinAccount);
        }

        public DaifaSellerExample.Criteria andWeixinAccountIsNotNull() {
            return isNotNull(weixinAccount);
        }

        public DaifaSellerExample.Criteria andWeixinAccountEqualTo(String value) {
            return equalTo(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountNotEqualTo(String value) {
            return notEqualTo(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountGreaterThan(String value) {
            return greaterThan(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountLessThan(String value) {
            return lessThan(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountLike(String value) {
            return like(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountNotLike(String value) {
            return notLike(weixinAccount, value);
        }

        public DaifaSellerExample.Criteria andWeixinAccountIn(List<String> values) {
            return in(weixinAccount, values);
        }

        public DaifaSellerExample.Criteria andWeixinAccountNotIn(List<String> values) {
            return notIn(weixinAccount, values);
        }

        public DaifaSellerExample.Criteria andWeixinAccountBetween(String value1, String value2) {
            return between(weixinAccount, value1, value2);
        }

        public DaifaSellerExample.Criteria andWeixinAccountNotBetween(String value1, String value2) {
            return notBetween(weixinAccount, value1, value2);
        }
        public DaifaSellerExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaSellerExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaSellerExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaSellerExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaSellerExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaSellerExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaSellerExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaSellerExample.Criteria andEmailIsNull() {
            return isNull(email);
        }

        public DaifaSellerExample.Criteria andEmailIsNotNull() {
            return isNotNull(email);
        }

        public DaifaSellerExample.Criteria andEmailEqualTo(String value) {
            return equalTo(email, value);
        }

        public DaifaSellerExample.Criteria andEmailNotEqualTo(String value) {
            return notEqualTo(email, value);
        }

        public DaifaSellerExample.Criteria andEmailGreaterThan(String value) {
            return greaterThan(email, value);
        }

        public DaifaSellerExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(email, value);
        }

        public DaifaSellerExample.Criteria andEmailLessThan(String value) {
            return lessThan(email, value);
        }

        public DaifaSellerExample.Criteria andEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(email, value);
        }

        public DaifaSellerExample.Criteria andEmailLike(String value) {
            return like(email, value);
        }

        public DaifaSellerExample.Criteria andEmailNotLike(String value) {
            return notLike(email, value);
        }

        public DaifaSellerExample.Criteria andEmailIn(List<String> values) {
            return in(email, values);
        }

        public DaifaSellerExample.Criteria andEmailNotIn(List<String> values) {
            return notIn(email, values);
        }

        public DaifaSellerExample.Criteria andEmailBetween(String value1, String value2) {
            return between(email, value1, value2);
        }

        public DaifaSellerExample.Criteria andEmailNotBetween(String value1, String value2) {
            return notBetween(email, value1, value2);
        }
        public DaifaSellerExample.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaSellerExample.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaSellerExample.Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaSellerExample.Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaSellerExample.Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaSellerExample.Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaSellerExample.Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaSellerExample.Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaSellerExample.Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaSellerExample.Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaSellerExample.Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaSellerExample.Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public DaifaSellerExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public DaifaSellerExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public DaifaSellerExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public DaifaSellerExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public DaifaSellerExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public DaifaSellerExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public DaifaSellerExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public DaifaSellerExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public DaifaSellerExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public DaifaSellerExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public DaifaSellerExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public DaifaSellerExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
        public DaifaSellerExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaSellerExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaSellerExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaSellerExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaSellerExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaSellerExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaSellerExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}