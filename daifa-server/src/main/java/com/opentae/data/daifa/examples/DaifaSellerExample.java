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
    public static EntityColumn dfSellerId;
    public static EntityColumn name;
    public static EntityColumn imWw;
    public static EntityColumn email;
    public static EntityColumn lastLogin;
    public static EntityColumn telephone;
    public static EntityColumn address;
    public static EntityColumn status;
    public static EntityColumn webSite;
    public static EntityColumn buycityId;
    public static EntityColumn imQq;
    public static EntityColumn lastDoTime;
    public static EntityColumn createTime;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn alipayAccount;
    public static EntityColumn weixinAccount;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dfSellerId = listMap.get("dfSellerId");
        name = listMap.get("name");
        imWw = listMap.get("imWw");
        email = listMap.get("email");
        lastLogin = listMap.get("lastLogin");
        telephone = listMap.get("telephone");
        address = listMap.get("address");
        status = listMap.get("status");
        webSite = listMap.get("webSite");
        buycityId = listMap.get("buycityId");
        imQq = listMap.get("imQq");
        lastDoTime = listMap.get("lastDoTime");
        createTime = listMap.get("createTime");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        alipayAccount = listMap.get("alipayAccount");
        weixinAccount = listMap.get("weixinAccount");
    }

    public DaifaSellerExample() {
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

        public Criteria andDfSellerIdIsNull() {
            return isNull(dfSellerId);
        }

        public Criteria andDfSellerIdIsNotNull() {
            return isNotNull(dfSellerId);
        }

        public Criteria andDfSellerIdEqualTo(Long value) {
            return equalTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdNotEqualTo(Long value) {
            return notEqualTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdGreaterThan(Long value) {
            return greaterThan(dfSellerId, value);
        }

        public Criteria andDfSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdLessThan(Long value) {
            return lessThan(dfSellerId, value);
        }

        public Criteria andDfSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdIn(List<Long> values) {
            return in(dfSellerId, values);
        }

        public Criteria andDfSellerIdNotIn(List<Long> values) {
            return notIn(dfSellerId, values);
        }

        public Criteria andDfSellerIdBetween(Long value1, Long value2) {
            return between(dfSellerId, value1, value2);
        }

        public Criteria andDfSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(dfSellerId, value1, value2);
        }
        public Criteria andNameIsNull() {
            return isNull(name);
        }

        public Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public Criteria andNameLike(String value) {
            return like(name, value);
        }

        public Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public Criteria andImWwIsNull() {
            return isNull(imWw);
        }

        public Criteria andImWwIsNotNull() {
            return isNotNull(imWw);
        }

        public Criteria andImWwEqualTo(String value) {
            return equalTo(imWw, value);
        }

        public Criteria andImWwNotEqualTo(String value) {
            return notEqualTo(imWw, value);
        }

        public Criteria andImWwGreaterThan(String value) {
            return greaterThan(imWw, value);
        }

        public Criteria andImWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imWw, value);
        }

        public Criteria andImWwLessThan(String value) {
            return lessThan(imWw, value);
        }

        public Criteria andImWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imWw, value);
        }

        public Criteria andImWwLike(String value) {
            return like(imWw, value);
        }

        public Criteria andImWwNotLike(String value) {
            return notLike(imWw, value);
        }

        public Criteria andImWwIn(List<String> values) {
            return in(imWw, values);
        }

        public Criteria andImWwNotIn(List<String> values) {
            return notIn(imWw, values);
        }

        public Criteria andImWwBetween(String value1, String value2) {
            return between(imWw, value1, value2);
        }

        public Criteria andImWwNotBetween(String value1, String value2) {
            return notBetween(imWw, value1, value2);
        }
        public Criteria andEmailIsNull() {
            return isNull(email);
        }

        public Criteria andEmailIsNotNull() {
            return isNotNull(email);
        }

        public Criteria andEmailEqualTo(String value) {
            return equalTo(email, value);
        }

        public Criteria andEmailNotEqualTo(String value) {
            return notEqualTo(email, value);
        }

        public Criteria andEmailGreaterThan(String value) {
            return greaterThan(email, value);
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(email, value);
        }

        public Criteria andEmailLessThan(String value) {
            return lessThan(email, value);
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(email, value);
        }

        public Criteria andEmailLike(String value) {
            return like(email, value);
        }

        public Criteria andEmailNotLike(String value) {
            return notLike(email, value);
        }

        public Criteria andEmailIn(List<String> values) {
            return in(email, values);
        }

        public Criteria andEmailNotIn(List<String> values) {
            return notIn(email, values);
        }

        public Criteria andEmailBetween(String value1, String value2) {
            return between(email, value1, value2);
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            return notBetween(email, value1, value2);
        }
        public Criteria andLastLoginIsNull() {
            return isNull(lastLogin);
        }

        public Criteria andLastLoginIsNotNull() {
            return isNotNull(lastLogin);
        }

        public Criteria andLastLoginEqualTo(Date value) {
            return equalTo(lastLogin, value);
        }

        public Criteria andLastLoginNotEqualTo(Date value) {
            return notEqualTo(lastLogin, value);
        }

        public Criteria andLastLoginGreaterThan(Date value) {
            return greaterThan(lastLogin, value);
        }

        public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastLogin, value);
        }

        public Criteria andLastLoginLessThan(Date value) {
            return lessThan(lastLogin, value);
        }

        public Criteria andLastLoginLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastLogin, value);
        }

        public Criteria andLastLoginIn(List<Date> values) {
            return in(lastLogin, values);
        }

        public Criteria andLastLoginNotIn(List<Date> values) {
            return notIn(lastLogin, values);
        }

        public Criteria andLastLoginBetween(Date value1, Date value2) {
            return between(lastLogin, value1, value2);
        }

        public Criteria andLastLoginNotBetween(Date value1, Date value2) {
            return notBetween(lastLogin, value1, value2);
        }
        public Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public Criteria andAddressIsNull() {
            return isNull(address);
        }

        public Criteria andAddressIsNotNull() {
            return isNotNull(address);
        }

        public Criteria andAddressEqualTo(String value) {
            return equalTo(address, value);
        }

        public Criteria andAddressNotEqualTo(String value) {
            return notEqualTo(address, value);
        }

        public Criteria andAddressGreaterThan(String value) {
            return greaterThan(address, value);
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(address, value);
        }

        public Criteria andAddressLessThan(String value) {
            return lessThan(address, value);
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(address, value);
        }

        public Criteria andAddressLike(String value) {
            return like(address, value);
        }

        public Criteria andAddressNotLike(String value) {
            return notLike(address, value);
        }

        public Criteria andAddressIn(List<String> values) {
            return in(address, values);
        }

        public Criteria andAddressNotIn(List<String> values) {
            return notIn(address, values);
        }

        public Criteria andAddressBetween(String value1, String value2) {
            return between(address, value1, value2);
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            return notBetween(address, value1, value2);
        }
        public Criteria andStatusIsNull() {
            return isNull(status);
        }

        public Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
        public Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public Criteria andBuycityIdIsNull() {
            return isNull(buycityId);
        }

        public Criteria andBuycityIdIsNotNull() {
            return isNotNull(buycityId);
        }

        public Criteria andBuycityIdEqualTo(Long value) {
            return equalTo(buycityId, value);
        }

        public Criteria andBuycityIdNotEqualTo(Long value) {
            return notEqualTo(buycityId, value);
        }

        public Criteria andBuycityIdGreaterThan(Long value) {
            return greaterThan(buycityId, value);
        }

        public Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buycityId, value);
        }

        public Criteria andBuycityIdLessThan(Long value) {
            return lessThan(buycityId, value);
        }

        public Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buycityId, value);
        }

        public Criteria andBuycityIdIn(List<Long> values) {
            return in(buycityId, values);
        }

        public Criteria andBuycityIdNotIn(List<Long> values) {
            return notIn(buycityId, values);
        }

        public Criteria andBuycityIdBetween(Long value1, Long value2) {
            return between(buycityId, value1, value2);
        }

        public Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            return notBetween(buycityId, value1, value2);
        }
        public Criteria andImQqIsNull() {
            return isNull(imQq);
        }

        public Criteria andImQqIsNotNull() {
            return isNotNull(imQq);
        }

        public Criteria andImQqEqualTo(String value) {
            return equalTo(imQq, value);
        }

        public Criteria andImQqNotEqualTo(String value) {
            return notEqualTo(imQq, value);
        }

        public Criteria andImQqGreaterThan(String value) {
            return greaterThan(imQq, value);
        }

        public Criteria andImQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQq, value);
        }

        public Criteria andImQqLessThan(String value) {
            return lessThan(imQq, value);
        }

        public Criteria andImQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQq, value);
        }

        public Criteria andImQqLike(String value) {
            return like(imQq, value);
        }

        public Criteria andImQqNotLike(String value) {
            return notLike(imQq, value);
        }

        public Criteria andImQqIn(List<String> values) {
            return in(imQq, values);
        }

        public Criteria andImQqNotIn(List<String> values) {
            return notIn(imQq, values);
        }

        public Criteria andImQqBetween(String value1, String value2) {
            return between(imQq, value1, value2);
        }

        public Criteria andImQqNotBetween(String value1, String value2) {
            return notBetween(imQq, value1, value2);
        }
        public Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
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
        public Criteria andAlipayAccountIsNull() {
            return isNull(alipayAccount);
        }

        public Criteria andAlipayAccountIsNotNull() {
            return isNotNull(alipayAccount);
        }

        public Criteria andAlipayAccountEqualTo(String value) {
            return equalTo(alipayAccount, value);
        }

        public Criteria andAlipayAccountNotEqualTo(String value) {
            return notEqualTo(alipayAccount, value);
        }

        public Criteria andAlipayAccountGreaterThan(String value) {
            return greaterThan(alipayAccount, value);
        }

        public Criteria andAlipayAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(alipayAccount, value);
        }

        public Criteria andAlipayAccountLessThan(String value) {
            return lessThan(alipayAccount, value);
        }

        public Criteria andAlipayAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(alipayAccount, value);
        }

        public Criteria andAlipayAccountLike(String value) {
            return like(alipayAccount, value);
        }

        public Criteria andAlipayAccountNotLike(String value) {
            return notLike(alipayAccount, value);
        }

        public Criteria andAlipayAccountIn(List<String> values) {
            return in(alipayAccount, values);
        }

        public Criteria andAlipayAccountNotIn(List<String> values) {
            return notIn(alipayAccount, values);
        }

        public Criteria andAlipayAccountBetween(String value1, String value2) {
            return between(alipayAccount, value1, value2);
        }

        public Criteria andAlipayAccountNotBetween(String value1, String value2) {
            return notBetween(alipayAccount, value1, value2);
        }
        public Criteria andWeixinAccountIsNull() {
            return isNull(weixinAccount);
        }

        public Criteria andWeixinAccountIsNotNull() {
            return isNotNull(weixinAccount);
        }

        public Criteria andWeixinAccountEqualTo(String value) {
            return equalTo(weixinAccount, value);
        }

        public Criteria andWeixinAccountNotEqualTo(String value) {
            return notEqualTo(weixinAccount, value);
        }

        public Criteria andWeixinAccountGreaterThan(String value) {
            return greaterThan(weixinAccount, value);
        }

        public Criteria andWeixinAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(weixinAccount, value);
        }

        public Criteria andWeixinAccountLessThan(String value) {
            return lessThan(weixinAccount, value);
        }

        public Criteria andWeixinAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(weixinAccount, value);
        }

        public Criteria andWeixinAccountLike(String value) {
            return like(weixinAccount, value);
        }

        public Criteria andWeixinAccountNotLike(String value) {
            return notLike(weixinAccount, value);
        }

        public Criteria andWeixinAccountIn(List<String> values) {
            return in(weixinAccount, values);
        }

        public Criteria andWeixinAccountNotIn(List<String> values) {
            return notIn(weixinAccount, values);
        }

        public Criteria andWeixinAccountBetween(String value1, String value2) {
            return between(weixinAccount, value1, value2);
        }

        public Criteria andWeixinAccountNotBetween(String value1, String value2) {
            return notBetween(weixinAccount, value1, value2);
        }
    }
}
