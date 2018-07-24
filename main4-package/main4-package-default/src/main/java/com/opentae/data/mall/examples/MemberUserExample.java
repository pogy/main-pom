package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberUser;

import java.util.*;
public class MemberUserExample extends SgExample<MemberUserExample.Criteria> {
    public static final Class<MemberUser> beanClass = MemberUser.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn phoneMob;
    public static EntityColumn lastTime;
    public static EntityColumn remark18;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn portraitSavepath;
    public static EntityColumn remark14;
    public static EntityColumn lastIp;
    public static EntityColumn remark13;
    public static EntityColumn idCard;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn imAliww;
    public static EntityColumn remark19;
    public static EntityColumn isNameValidate;
    public static EntityColumn registerSource;
    public static EntityColumn password;
    public static EntityColumn isOpenStore;
    public static EntityColumn zfbAccount;
    public static EntityColumn isPhoneMob;
    public static EntityColumn sellerGrade;
    public static EntityColumn remark20;
    public static EntityColumn imSkype;
    public static EntityColumn portraitUrl;
    public static EntityColumn accountType;
    public static EntityColumn imYahooWeibo;
    public static EntityColumn buyerGrade;
    public static EntityColumn useStatus;
    public static EntityColumn accountId;
    public static EntityColumn regTime;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn idCardImg;
    public static EntityColumn remark1;
    public static EntityColumn isMailValidate;
    public static EntityColumn logins;
    public static EntityColumn remark3;
    public static EntityColumn imWeixin;
    public static EntityColumn remark2;
    public static EntityColumn birthday;
    public static EntityColumn passwordStrength;
    public static EntityColumn accountName;
    public static EntityColumn subUserNameGroups;
    public static EntityColumn isPayPassword;
    public static EntityColumn loginEmail;
    public static EntityColumn userNick;
    public static EntityColumn imQq;
    public static EntityColumn sellerVipGrade;
    public static EntityColumn email;
    public static EntityColumn birthdayMonthDay;
    public static EntityColumn sex;
    public static EntityColumn userName;
    public static EntityColumn userId;
    public static EntityColumn realName;
    public static EntityColumn imQqWeibo;
    public static EntityColumn loginPhone;
    public static EntityColumn phoneTel;
    public static EntityColumn payPassword;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        phoneMob = listMap.get("phoneMob");
        lastTime = listMap.get("lastTime");
        remark18 = listMap.get("remark18");
        remark17 = listMap.get("remark17");
        remark16 = listMap.get("remark16");
        remark15 = listMap.get("remark15");
        portraitSavepath = listMap.get("portraitSavepath");
        remark14 = listMap.get("remark14");
        lastIp = listMap.get("lastIp");
        remark13 = listMap.get("remark13");
        idCard = listMap.get("idCard");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        imAliww = listMap.get("imAliww");
        remark19 = listMap.get("remark19");
        isNameValidate = listMap.get("isNameValidate");
        registerSource = listMap.get("registerSource");
        password = listMap.get("password");
        isOpenStore = listMap.get("isOpenStore");
        zfbAccount = listMap.get("zfbAccount");
        isPhoneMob = listMap.get("isPhoneMob");
        sellerGrade = listMap.get("sellerGrade");
        remark20 = listMap.get("remark20");
        imSkype = listMap.get("imSkype");
        portraitUrl = listMap.get("portraitUrl");
        accountType = listMap.get("accountType");
        imYahooWeibo = listMap.get("imYahooWeibo");
        buyerGrade = listMap.get("buyerGrade");
        useStatus = listMap.get("useStatus");
        accountId = listMap.get("accountId");
        regTime = listMap.get("regTime");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        idCardImg = listMap.get("idCardImg");
        remark1 = listMap.get("remark1");
        isMailValidate = listMap.get("isMailValidate");
        logins = listMap.get("logins");
        remark3 = listMap.get("remark3");
        imWeixin = listMap.get("imWeixin");
        remark2 = listMap.get("remark2");
        birthday = listMap.get("birthday");
        passwordStrength = listMap.get("passwordStrength");
        accountName = listMap.get("accountName");
        subUserNameGroups = listMap.get("subUserNameGroups");
        isPayPassword = listMap.get("isPayPassword");
        loginEmail = listMap.get("loginEmail");
        userNick = listMap.get("userNick");
        imQq = listMap.get("imQq");
        sellerVipGrade = listMap.get("sellerVipGrade");
        email = listMap.get("email");
        birthdayMonthDay = listMap.get("birthdayMonthDay");
        sex = listMap.get("sex");
        userName = listMap.get("userName");
        userId = listMap.get("userId");
        realName = listMap.get("realName");
        imQqWeibo = listMap.get("imQqWeibo");
        loginPhone = listMap.get("loginPhone");
        phoneTel = listMap.get("phoneTel");
        payPassword = listMap.get("payPassword");
        }

    public MemberUserExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberUserExample.Criteria createCriteriaInternal() {
        return new MemberUserExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberUserExample.Criteria andPhoneMobIsNull() {
            return isNull(phoneMob);
        }

        public MemberUserExample.Criteria andPhoneMobIsNotNull() {
            return isNotNull(phoneMob);
        }

        public MemberUserExample.Criteria andPhoneMobEqualTo(String value) {
            return equalTo(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobNotEqualTo(String value) {
            return notEqualTo(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobGreaterThan(String value) {
            return greaterThan(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobLessThan(String value) {
            return lessThan(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobLike(String value) {
            return like(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobNotLike(String value) {
            return notLike(phoneMob, value);
        }

        public MemberUserExample.Criteria andPhoneMobIn(List<String> values) {
            return in(phoneMob, values);
        }

        public MemberUserExample.Criteria andPhoneMobNotIn(List<String> values) {
            return notIn(phoneMob, values);
        }

        public MemberUserExample.Criteria andPhoneMobBetween(String value1, String value2) {
            return between(phoneMob, value1, value2);
        }

        public MemberUserExample.Criteria andPhoneMobNotBetween(String value1, String value2) {
            return notBetween(phoneMob, value1, value2);
        }
        public MemberUserExample.Criteria andLastTimeIsNull() {
            return isNull(lastTime);
        }

        public MemberUserExample.Criteria andLastTimeIsNotNull() {
            return isNotNull(lastTime);
        }

        public MemberUserExample.Criteria andLastTimeEqualTo(Date value) {
            return equalTo(lastTime, value);
        }

        public MemberUserExample.Criteria andLastTimeNotEqualTo(Date value) {
            return notEqualTo(lastTime, value);
        }

        public MemberUserExample.Criteria andLastTimeGreaterThan(Date value) {
            return greaterThan(lastTime, value);
        }

        public MemberUserExample.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastTime, value);
        }

        public MemberUserExample.Criteria andLastTimeLessThan(Date value) {
            return lessThan(lastTime, value);
        }

        public MemberUserExample.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastTime, value);
        }

        public MemberUserExample.Criteria andLastTimeIn(List<Date> values) {
            return in(lastTime, values);
        }

        public MemberUserExample.Criteria andLastTimeNotIn(List<Date> values) {
            return notIn(lastTime, values);
        }

        public MemberUserExample.Criteria andLastTimeBetween(Date value1, Date value2) {
            return between(lastTime, value1, value2);
        }

        public MemberUserExample.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastTime, value1, value2);
        }
        public MemberUserExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public MemberUserExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public MemberUserExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public MemberUserExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public MemberUserExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public MemberUserExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public MemberUserExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public MemberUserExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public MemberUserExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public MemberUserExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public MemberUserExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public MemberUserExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public MemberUserExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public MemberUserExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public MemberUserExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public MemberUserExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public MemberUserExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public MemberUserExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public MemberUserExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public MemberUserExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public MemberUserExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public MemberUserExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public MemberUserExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public MemberUserExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public MemberUserExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public MemberUserExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public MemberUserExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public MemberUserExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public MemberUserExample.Criteria andPortraitSavepathIsNull() {
            return isNull(portraitSavepath);
        }

        public MemberUserExample.Criteria andPortraitSavepathIsNotNull() {
            return isNotNull(portraitSavepath);
        }

        public MemberUserExample.Criteria andPortraitSavepathEqualTo(String value) {
            return equalTo(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathNotEqualTo(String value) {
            return notEqualTo(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathGreaterThan(String value) {
            return greaterThan(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathLessThan(String value) {
            return lessThan(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathLike(String value) {
            return like(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathNotLike(String value) {
            return notLike(portraitSavepath, value);
        }

        public MemberUserExample.Criteria andPortraitSavepathIn(List<String> values) {
            return in(portraitSavepath, values);
        }

        public MemberUserExample.Criteria andPortraitSavepathNotIn(List<String> values) {
            return notIn(portraitSavepath, values);
        }

        public MemberUserExample.Criteria andPortraitSavepathBetween(String value1, String value2) {
            return between(portraitSavepath, value1, value2);
        }

        public MemberUserExample.Criteria andPortraitSavepathNotBetween(String value1, String value2) {
            return notBetween(portraitSavepath, value1, value2);
        }
        public MemberUserExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public MemberUserExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public MemberUserExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public MemberUserExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public MemberUserExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public MemberUserExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public MemberUserExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public MemberUserExample.Criteria andLastIpIsNull() {
            return isNull(lastIp);
        }

        public MemberUserExample.Criteria andLastIpIsNotNull() {
            return isNotNull(lastIp);
        }

        public MemberUserExample.Criteria andLastIpEqualTo(String value) {
            return equalTo(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpNotEqualTo(String value) {
            return notEqualTo(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpGreaterThan(String value) {
            return greaterThan(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpLessThan(String value) {
            return lessThan(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpLike(String value) {
            return like(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpNotLike(String value) {
            return notLike(lastIp, value);
        }

        public MemberUserExample.Criteria andLastIpIn(List<String> values) {
            return in(lastIp, values);
        }

        public MemberUserExample.Criteria andLastIpNotIn(List<String> values) {
            return notIn(lastIp, values);
        }

        public MemberUserExample.Criteria andLastIpBetween(String value1, String value2) {
            return between(lastIp, value1, value2);
        }

        public MemberUserExample.Criteria andLastIpNotBetween(String value1, String value2) {
            return notBetween(lastIp, value1, value2);
        }
        public MemberUserExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public MemberUserExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public MemberUserExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public MemberUserExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public MemberUserExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public MemberUserExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public MemberUserExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public MemberUserExample.Criteria andIdCardIsNull() {
            return isNull(idCard);
        }

        public MemberUserExample.Criteria andIdCardIsNotNull() {
            return isNotNull(idCard);
        }

        public MemberUserExample.Criteria andIdCardEqualTo(String value) {
            return equalTo(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardNotEqualTo(String value) {
            return notEqualTo(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardGreaterThan(String value) {
            return greaterThan(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardLessThan(String value) {
            return lessThan(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardLike(String value) {
            return like(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardNotLike(String value) {
            return notLike(idCard, value);
        }

        public MemberUserExample.Criteria andIdCardIn(List<String> values) {
            return in(idCard, values);
        }

        public MemberUserExample.Criteria andIdCardNotIn(List<String> values) {
            return notIn(idCard, values);
        }

        public MemberUserExample.Criteria andIdCardBetween(String value1, String value2) {
            return between(idCard, value1, value2);
        }

        public MemberUserExample.Criteria andIdCardNotBetween(String value1, String value2) {
            return notBetween(idCard, value1, value2);
        }
        public MemberUserExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public MemberUserExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public MemberUserExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public MemberUserExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public MemberUserExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public MemberUserExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public MemberUserExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public MemberUserExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public MemberUserExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public MemberUserExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public MemberUserExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public MemberUserExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public MemberUserExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public MemberUserExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public MemberUserExample.Criteria andImAliwwIsNull() {
            return isNull(imAliww);
        }

        public MemberUserExample.Criteria andImAliwwIsNotNull() {
            return isNotNull(imAliww);
        }

        public MemberUserExample.Criteria andImAliwwEqualTo(String value) {
            return equalTo(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwNotEqualTo(String value) {
            return notEqualTo(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwGreaterThan(String value) {
            return greaterThan(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwLessThan(String value) {
            return lessThan(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwLike(String value) {
            return like(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwNotLike(String value) {
            return notLike(imAliww, value);
        }

        public MemberUserExample.Criteria andImAliwwIn(List<String> values) {
            return in(imAliww, values);
        }

        public MemberUserExample.Criteria andImAliwwNotIn(List<String> values) {
            return notIn(imAliww, values);
        }

        public MemberUserExample.Criteria andImAliwwBetween(String value1, String value2) {
            return between(imAliww, value1, value2);
        }

        public MemberUserExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            return notBetween(imAliww, value1, value2);
        }
        public MemberUserExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public MemberUserExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public MemberUserExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public MemberUserExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public MemberUserExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public MemberUserExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public MemberUserExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public MemberUserExample.Criteria andIsNameValidateIsNull() {
            return isNull(isNameValidate);
        }

        public MemberUserExample.Criteria andIsNameValidateIsNotNull() {
            return isNotNull(isNameValidate);
        }

        public MemberUserExample.Criteria andIsNameValidateEqualTo(Integer value) {
            return equalTo(isNameValidate, value);
        }

        public MemberUserExample.Criteria andIsNameValidateNotEqualTo(Integer value) {
            return notEqualTo(isNameValidate, value);
        }

        public MemberUserExample.Criteria andIsNameValidateGreaterThan(Integer value) {
            return greaterThan(isNameValidate, value);
        }

        public MemberUserExample.Criteria andIsNameValidateGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isNameValidate, value);
        }

        public MemberUserExample.Criteria andIsNameValidateLessThan(Integer value) {
            return lessThan(isNameValidate, value);
        }

        public MemberUserExample.Criteria andIsNameValidateLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isNameValidate, value);
        }

        public MemberUserExample.Criteria andIsNameValidateIn(List<Integer> values) {
            return in(isNameValidate, values);
        }

        public MemberUserExample.Criteria andIsNameValidateNotIn(List<Integer> values) {
            return notIn(isNameValidate, values);
        }

        public MemberUserExample.Criteria andIsNameValidateBetween(Integer value1, Integer value2) {
            return between(isNameValidate, value1, value2);
        }

        public MemberUserExample.Criteria andIsNameValidateNotBetween(Integer value1, Integer value2) {
            return notBetween(isNameValidate, value1, value2);
        }
        public MemberUserExample.Criteria andRegisterSourceIsNull() {
            return isNull(registerSource);
        }

        public MemberUserExample.Criteria andRegisterSourceIsNotNull() {
            return isNotNull(registerSource);
        }

        public MemberUserExample.Criteria andRegisterSourceEqualTo(Long value) {
            return equalTo(registerSource, value);
        }

        public MemberUserExample.Criteria andRegisterSourceNotEqualTo(Long value) {
            return notEqualTo(registerSource, value);
        }

        public MemberUserExample.Criteria andRegisterSourceGreaterThan(Long value) {
            return greaterThan(registerSource, value);
        }

        public MemberUserExample.Criteria andRegisterSourceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(registerSource, value);
        }

        public MemberUserExample.Criteria andRegisterSourceLessThan(Long value) {
            return lessThan(registerSource, value);
        }

        public MemberUserExample.Criteria andRegisterSourceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(registerSource, value);
        }

        public MemberUserExample.Criteria andRegisterSourceIn(List<Long> values) {
            return in(registerSource, values);
        }

        public MemberUserExample.Criteria andRegisterSourceNotIn(List<Long> values) {
            return notIn(registerSource, values);
        }

        public MemberUserExample.Criteria andRegisterSourceBetween(Long value1, Long value2) {
            return between(registerSource, value1, value2);
        }

        public MemberUserExample.Criteria andRegisterSourceNotBetween(Long value1, Long value2) {
            return notBetween(registerSource, value1, value2);
        }
        public MemberUserExample.Criteria andPasswordIsNull() {
            return isNull(password);
        }

        public MemberUserExample.Criteria andPasswordIsNotNull() {
            return isNotNull(password);
        }

        public MemberUserExample.Criteria andPasswordEqualTo(String value) {
            return equalTo(password, value);
        }

        public MemberUserExample.Criteria andPasswordNotEqualTo(String value) {
            return notEqualTo(password, value);
        }

        public MemberUserExample.Criteria andPasswordGreaterThan(String value) {
            return greaterThan(password, value);
        }

        public MemberUserExample.Criteria andPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(password, value);
        }

        public MemberUserExample.Criteria andPasswordLessThan(String value) {
            return lessThan(password, value);
        }

        public MemberUserExample.Criteria andPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(password, value);
        }

        public MemberUserExample.Criteria andPasswordLike(String value) {
            return like(password, value);
        }

        public MemberUserExample.Criteria andPasswordNotLike(String value) {
            return notLike(password, value);
        }

        public MemberUserExample.Criteria andPasswordIn(List<String> values) {
            return in(password, values);
        }

        public MemberUserExample.Criteria andPasswordNotIn(List<String> values) {
            return notIn(password, values);
        }

        public MemberUserExample.Criteria andPasswordBetween(String value1, String value2) {
            return between(password, value1, value2);
        }

        public MemberUserExample.Criteria andPasswordNotBetween(String value1, String value2) {
            return notBetween(password, value1, value2);
        }
        public MemberUserExample.Criteria andIsOpenStoreIsNull() {
            return isNull(isOpenStore);
        }

        public MemberUserExample.Criteria andIsOpenStoreIsNotNull() {
            return isNotNull(isOpenStore);
        }

        public MemberUserExample.Criteria andIsOpenStoreEqualTo(Integer value) {
            return equalTo(isOpenStore, value);
        }

        public MemberUserExample.Criteria andIsOpenStoreNotEqualTo(Integer value) {
            return notEqualTo(isOpenStore, value);
        }

        public MemberUserExample.Criteria andIsOpenStoreGreaterThan(Integer value) {
            return greaterThan(isOpenStore, value);
        }

        public MemberUserExample.Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isOpenStore, value);
        }

        public MemberUserExample.Criteria andIsOpenStoreLessThan(Integer value) {
            return lessThan(isOpenStore, value);
        }

        public MemberUserExample.Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isOpenStore, value);
        }

        public MemberUserExample.Criteria andIsOpenStoreIn(List<Integer> values) {
            return in(isOpenStore, values);
        }

        public MemberUserExample.Criteria andIsOpenStoreNotIn(List<Integer> values) {
            return notIn(isOpenStore, values);
        }

        public MemberUserExample.Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            return between(isOpenStore, value1, value2);
        }

        public MemberUserExample.Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            return notBetween(isOpenStore, value1, value2);
        }
        public MemberUserExample.Criteria andZfbAccountIsNull() {
            return isNull(zfbAccount);
        }

        public MemberUserExample.Criteria andZfbAccountIsNotNull() {
            return isNotNull(zfbAccount);
        }

        public MemberUserExample.Criteria andZfbAccountEqualTo(String value) {
            return equalTo(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountNotEqualTo(String value) {
            return notEqualTo(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountGreaterThan(String value) {
            return greaterThan(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountLessThan(String value) {
            return lessThan(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountLike(String value) {
            return like(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountNotLike(String value) {
            return notLike(zfbAccount, value);
        }

        public MemberUserExample.Criteria andZfbAccountIn(List<String> values) {
            return in(zfbAccount, values);
        }

        public MemberUserExample.Criteria andZfbAccountNotIn(List<String> values) {
            return notIn(zfbAccount, values);
        }

        public MemberUserExample.Criteria andZfbAccountBetween(String value1, String value2) {
            return between(zfbAccount, value1, value2);
        }

        public MemberUserExample.Criteria andZfbAccountNotBetween(String value1, String value2) {
            return notBetween(zfbAccount, value1, value2);
        }
        public MemberUserExample.Criteria andIsPhoneMobIsNull() {
            return isNull(isPhoneMob);
        }

        public MemberUserExample.Criteria andIsPhoneMobIsNotNull() {
            return isNotNull(isPhoneMob);
        }

        public MemberUserExample.Criteria andIsPhoneMobEqualTo(Integer value) {
            return equalTo(isPhoneMob, value);
        }

        public MemberUserExample.Criteria andIsPhoneMobNotEqualTo(Integer value) {
            return notEqualTo(isPhoneMob, value);
        }

        public MemberUserExample.Criteria andIsPhoneMobGreaterThan(Integer value) {
            return greaterThan(isPhoneMob, value);
        }

        public MemberUserExample.Criteria andIsPhoneMobGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isPhoneMob, value);
        }

        public MemberUserExample.Criteria andIsPhoneMobLessThan(Integer value) {
            return lessThan(isPhoneMob, value);
        }

        public MemberUserExample.Criteria andIsPhoneMobLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isPhoneMob, value);
        }

        public MemberUserExample.Criteria andIsPhoneMobIn(List<Integer> values) {
            return in(isPhoneMob, values);
        }

        public MemberUserExample.Criteria andIsPhoneMobNotIn(List<Integer> values) {
            return notIn(isPhoneMob, values);
        }

        public MemberUserExample.Criteria andIsPhoneMobBetween(Integer value1, Integer value2) {
            return between(isPhoneMob, value1, value2);
        }

        public MemberUserExample.Criteria andIsPhoneMobNotBetween(Integer value1, Integer value2) {
            return notBetween(isPhoneMob, value1, value2);
        }
        public MemberUserExample.Criteria andSellerGradeIsNull() {
            return isNull(sellerGrade);
        }

        public MemberUserExample.Criteria andSellerGradeIsNotNull() {
            return isNotNull(sellerGrade);
        }

        public MemberUserExample.Criteria andSellerGradeEqualTo(Long value) {
            return equalTo(sellerGrade, value);
        }

        public MemberUserExample.Criteria andSellerGradeNotEqualTo(Long value) {
            return notEqualTo(sellerGrade, value);
        }

        public MemberUserExample.Criteria andSellerGradeGreaterThan(Long value) {
            return greaterThan(sellerGrade, value);
        }

        public MemberUserExample.Criteria andSellerGradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerGrade, value);
        }

        public MemberUserExample.Criteria andSellerGradeLessThan(Long value) {
            return lessThan(sellerGrade, value);
        }

        public MemberUserExample.Criteria andSellerGradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerGrade, value);
        }

        public MemberUserExample.Criteria andSellerGradeIn(List<Long> values) {
            return in(sellerGrade, values);
        }

        public MemberUserExample.Criteria andSellerGradeNotIn(List<Long> values) {
            return notIn(sellerGrade, values);
        }

        public MemberUserExample.Criteria andSellerGradeBetween(Long value1, Long value2) {
            return between(sellerGrade, value1, value2);
        }

        public MemberUserExample.Criteria andSellerGradeNotBetween(Long value1, Long value2) {
            return notBetween(sellerGrade, value1, value2);
        }
        public MemberUserExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public MemberUserExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public MemberUserExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public MemberUserExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public MemberUserExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public MemberUserExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public MemberUserExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public MemberUserExample.Criteria andImSkypeIsNull() {
            return isNull(imSkype);
        }

        public MemberUserExample.Criteria andImSkypeIsNotNull() {
            return isNotNull(imSkype);
        }

        public MemberUserExample.Criteria andImSkypeEqualTo(String value) {
            return equalTo(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeNotEqualTo(String value) {
            return notEqualTo(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeGreaterThan(String value) {
            return greaterThan(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeLessThan(String value) {
            return lessThan(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeLike(String value) {
            return like(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeNotLike(String value) {
            return notLike(imSkype, value);
        }

        public MemberUserExample.Criteria andImSkypeIn(List<String> values) {
            return in(imSkype, values);
        }

        public MemberUserExample.Criteria andImSkypeNotIn(List<String> values) {
            return notIn(imSkype, values);
        }

        public MemberUserExample.Criteria andImSkypeBetween(String value1, String value2) {
            return between(imSkype, value1, value2);
        }

        public MemberUserExample.Criteria andImSkypeNotBetween(String value1, String value2) {
            return notBetween(imSkype, value1, value2);
        }
        public MemberUserExample.Criteria andPortraitUrlIsNull() {
            return isNull(portraitUrl);
        }

        public MemberUserExample.Criteria andPortraitUrlIsNotNull() {
            return isNotNull(portraitUrl);
        }

        public MemberUserExample.Criteria andPortraitUrlEqualTo(String value) {
            return equalTo(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlNotEqualTo(String value) {
            return notEqualTo(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlGreaterThan(String value) {
            return greaterThan(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlLessThan(String value) {
            return lessThan(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlLike(String value) {
            return like(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlNotLike(String value) {
            return notLike(portraitUrl, value);
        }

        public MemberUserExample.Criteria andPortraitUrlIn(List<String> values) {
            return in(portraitUrl, values);
        }

        public MemberUserExample.Criteria andPortraitUrlNotIn(List<String> values) {
            return notIn(portraitUrl, values);
        }

        public MemberUserExample.Criteria andPortraitUrlBetween(String value1, String value2) {
            return between(portraitUrl, value1, value2);
        }

        public MemberUserExample.Criteria andPortraitUrlNotBetween(String value1, String value2) {
            return notBetween(portraitUrl, value1, value2);
        }
        public MemberUserExample.Criteria andAccountTypeIsNull() {
            return isNull(accountType);
        }

        public MemberUserExample.Criteria andAccountTypeIsNotNull() {
            return isNotNull(accountType);
        }

        public MemberUserExample.Criteria andAccountTypeEqualTo(Integer value) {
            return equalTo(accountType, value);
        }

        public MemberUserExample.Criteria andAccountTypeNotEqualTo(Integer value) {
            return notEqualTo(accountType, value);
        }

        public MemberUserExample.Criteria andAccountTypeGreaterThan(Integer value) {
            return greaterThan(accountType, value);
        }

        public MemberUserExample.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(accountType, value);
        }

        public MemberUserExample.Criteria andAccountTypeLessThan(Integer value) {
            return lessThan(accountType, value);
        }

        public MemberUserExample.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(accountType, value);
        }

        public MemberUserExample.Criteria andAccountTypeIn(List<Integer> values) {
            return in(accountType, values);
        }

        public MemberUserExample.Criteria andAccountTypeNotIn(List<Integer> values) {
            return notIn(accountType, values);
        }

        public MemberUserExample.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            return between(accountType, value1, value2);
        }

        public MemberUserExample.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(accountType, value1, value2);
        }
        public MemberUserExample.Criteria andImYahooWeiboIsNull() {
            return isNull(imYahooWeibo);
        }

        public MemberUserExample.Criteria andImYahooWeiboIsNotNull() {
            return isNotNull(imYahooWeibo);
        }

        public MemberUserExample.Criteria andImYahooWeiboEqualTo(String value) {
            return equalTo(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboNotEqualTo(String value) {
            return notEqualTo(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboGreaterThan(String value) {
            return greaterThan(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboLessThan(String value) {
            return lessThan(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboLike(String value) {
            return like(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboNotLike(String value) {
            return notLike(imYahooWeibo, value);
        }

        public MemberUserExample.Criteria andImYahooWeiboIn(List<String> values) {
            return in(imYahooWeibo, values);
        }

        public MemberUserExample.Criteria andImYahooWeiboNotIn(List<String> values) {
            return notIn(imYahooWeibo, values);
        }

        public MemberUserExample.Criteria andImYahooWeiboBetween(String value1, String value2) {
            return between(imYahooWeibo, value1, value2);
        }

        public MemberUserExample.Criteria andImYahooWeiboNotBetween(String value1, String value2) {
            return notBetween(imYahooWeibo, value1, value2);
        }
        public MemberUserExample.Criteria andBuyerGradeIsNull() {
            return isNull(buyerGrade);
        }

        public MemberUserExample.Criteria andBuyerGradeIsNotNull() {
            return isNotNull(buyerGrade);
        }

        public MemberUserExample.Criteria andBuyerGradeEqualTo(Long value) {
            return equalTo(buyerGrade, value);
        }

        public MemberUserExample.Criteria andBuyerGradeNotEqualTo(Long value) {
            return notEqualTo(buyerGrade, value);
        }

        public MemberUserExample.Criteria andBuyerGradeGreaterThan(Long value) {
            return greaterThan(buyerGrade, value);
        }

        public MemberUserExample.Criteria andBuyerGradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerGrade, value);
        }

        public MemberUserExample.Criteria andBuyerGradeLessThan(Long value) {
            return lessThan(buyerGrade, value);
        }

        public MemberUserExample.Criteria andBuyerGradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerGrade, value);
        }

        public MemberUserExample.Criteria andBuyerGradeIn(List<Long> values) {
            return in(buyerGrade, values);
        }

        public MemberUserExample.Criteria andBuyerGradeNotIn(List<Long> values) {
            return notIn(buyerGrade, values);
        }

        public MemberUserExample.Criteria andBuyerGradeBetween(Long value1, Long value2) {
            return between(buyerGrade, value1, value2);
        }

        public MemberUserExample.Criteria andBuyerGradeNotBetween(Long value1, Long value2) {
            return notBetween(buyerGrade, value1, value2);
        }
        public MemberUserExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public MemberUserExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public MemberUserExample.Criteria andUseStatusEqualTo(Long value) {
            return equalTo(useStatus, value);
        }

        public MemberUserExample.Criteria andUseStatusNotEqualTo(Long value) {
            return notEqualTo(useStatus, value);
        }

        public MemberUserExample.Criteria andUseStatusGreaterThan(Long value) {
            return greaterThan(useStatus, value);
        }

        public MemberUserExample.Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public MemberUserExample.Criteria andUseStatusLessThan(Long value) {
            return lessThan(useStatus, value);
        }

        public MemberUserExample.Criteria andUseStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public MemberUserExample.Criteria andUseStatusIn(List<Long> values) {
            return in(useStatus, values);
        }

        public MemberUserExample.Criteria andUseStatusNotIn(List<Long> values) {
            return notIn(useStatus, values);
        }

        public MemberUserExample.Criteria andUseStatusBetween(Long value1, Long value2) {
            return between(useStatus, value1, value2);
        }

        public MemberUserExample.Criteria andUseStatusNotBetween(Long value1, Long value2) {
            return notBetween(useStatus, value1, value2);
        }
        public MemberUserExample.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public MemberUserExample.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public MemberUserExample.Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public MemberUserExample.Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public MemberUserExample.Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public MemberUserExample.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public MemberUserExample.Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public MemberUserExample.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public MemberUserExample.Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public MemberUserExample.Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public MemberUserExample.Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public MemberUserExample.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public MemberUserExample.Criteria andRegTimeIsNull() {
            return isNull(regTime);
        }

        public MemberUserExample.Criteria andRegTimeIsNotNull() {
            return isNotNull(regTime);
        }

        public MemberUserExample.Criteria andRegTimeEqualTo(Date value) {
            return equalTo(regTime, value);
        }

        public MemberUserExample.Criteria andRegTimeNotEqualTo(Date value) {
            return notEqualTo(regTime, value);
        }

        public MemberUserExample.Criteria andRegTimeGreaterThan(Date value) {
            return greaterThan(regTime, value);
        }

        public MemberUserExample.Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(regTime, value);
        }

        public MemberUserExample.Criteria andRegTimeLessThan(Date value) {
            return lessThan(regTime, value);
        }

        public MemberUserExample.Criteria andRegTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(regTime, value);
        }

        public MemberUserExample.Criteria andRegTimeIn(List<Date> values) {
            return in(regTime, values);
        }

        public MemberUserExample.Criteria andRegTimeNotIn(List<Date> values) {
            return notIn(regTime, values);
        }

        public MemberUserExample.Criteria andRegTimeBetween(Date value1, Date value2) {
            return between(regTime, value1, value2);
        }

        public MemberUserExample.Criteria andRegTimeNotBetween(Date value1, Date value2) {
            return notBetween(regTime, value1, value2);
        }
        public MemberUserExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public MemberUserExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public MemberUserExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public MemberUserExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public MemberUserExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public MemberUserExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public MemberUserExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public MemberUserExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public MemberUserExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public MemberUserExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public MemberUserExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public MemberUserExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public MemberUserExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public MemberUserExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public MemberUserExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public MemberUserExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public MemberUserExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public MemberUserExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public MemberUserExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public MemberUserExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public MemberUserExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public MemberUserExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public MemberUserExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public MemberUserExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public MemberUserExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public MemberUserExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public MemberUserExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public MemberUserExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public MemberUserExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public MemberUserExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public MemberUserExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public MemberUserExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public MemberUserExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public MemberUserExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public MemberUserExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public MemberUserExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public MemberUserExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public MemberUserExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public MemberUserExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public MemberUserExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public MemberUserExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public MemberUserExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public MemberUserExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public MemberUserExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public MemberUserExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public MemberUserExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public MemberUserExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public MemberUserExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public MemberUserExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public MemberUserExample.Criteria andIdCardImgIsNull() {
            return isNull(idCardImg);
        }

        public MemberUserExample.Criteria andIdCardImgIsNotNull() {
            return isNotNull(idCardImg);
        }

        public MemberUserExample.Criteria andIdCardImgEqualTo(String value) {
            return equalTo(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgNotEqualTo(String value) {
            return notEqualTo(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgGreaterThan(String value) {
            return greaterThan(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgLessThan(String value) {
            return lessThan(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgLike(String value) {
            return like(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgNotLike(String value) {
            return notLike(idCardImg, value);
        }

        public MemberUserExample.Criteria andIdCardImgIn(List<String> values) {
            return in(idCardImg, values);
        }

        public MemberUserExample.Criteria andIdCardImgNotIn(List<String> values) {
            return notIn(idCardImg, values);
        }

        public MemberUserExample.Criteria andIdCardImgBetween(String value1, String value2) {
            return between(idCardImg, value1, value2);
        }

        public MemberUserExample.Criteria andIdCardImgNotBetween(String value1, String value2) {
            return notBetween(idCardImg, value1, value2);
        }
        public MemberUserExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public MemberUserExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public MemberUserExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public MemberUserExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public MemberUserExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public MemberUserExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public MemberUserExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public MemberUserExample.Criteria andIsMailValidateIsNull() {
            return isNull(isMailValidate);
        }

        public MemberUserExample.Criteria andIsMailValidateIsNotNull() {
            return isNotNull(isMailValidate);
        }

        public MemberUserExample.Criteria andIsMailValidateEqualTo(Integer value) {
            return equalTo(isMailValidate, value);
        }

        public MemberUserExample.Criteria andIsMailValidateNotEqualTo(Integer value) {
            return notEqualTo(isMailValidate, value);
        }

        public MemberUserExample.Criteria andIsMailValidateGreaterThan(Integer value) {
            return greaterThan(isMailValidate, value);
        }

        public MemberUserExample.Criteria andIsMailValidateGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isMailValidate, value);
        }

        public MemberUserExample.Criteria andIsMailValidateLessThan(Integer value) {
            return lessThan(isMailValidate, value);
        }

        public MemberUserExample.Criteria andIsMailValidateLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isMailValidate, value);
        }

        public MemberUserExample.Criteria andIsMailValidateIn(List<Integer> values) {
            return in(isMailValidate, values);
        }

        public MemberUserExample.Criteria andIsMailValidateNotIn(List<Integer> values) {
            return notIn(isMailValidate, values);
        }

        public MemberUserExample.Criteria andIsMailValidateBetween(Integer value1, Integer value2) {
            return between(isMailValidate, value1, value2);
        }

        public MemberUserExample.Criteria andIsMailValidateNotBetween(Integer value1, Integer value2) {
            return notBetween(isMailValidate, value1, value2);
        }
        public MemberUserExample.Criteria andLoginsIsNull() {
            return isNull(logins);
        }

        public MemberUserExample.Criteria andLoginsIsNotNull() {
            return isNotNull(logins);
        }

        public MemberUserExample.Criteria andLoginsEqualTo(Long value) {
            return equalTo(logins, value);
        }

        public MemberUserExample.Criteria andLoginsNotEqualTo(Long value) {
            return notEqualTo(logins, value);
        }

        public MemberUserExample.Criteria andLoginsGreaterThan(Long value) {
            return greaterThan(logins, value);
        }

        public MemberUserExample.Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(logins, value);
        }

        public MemberUserExample.Criteria andLoginsLessThan(Long value) {
            return lessThan(logins, value);
        }

        public MemberUserExample.Criteria andLoginsLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(logins, value);
        }

        public MemberUserExample.Criteria andLoginsIn(List<Long> values) {
            return in(logins, values);
        }

        public MemberUserExample.Criteria andLoginsNotIn(List<Long> values) {
            return notIn(logins, values);
        }

        public MemberUserExample.Criteria andLoginsBetween(Long value1, Long value2) {
            return between(logins, value1, value2);
        }

        public MemberUserExample.Criteria andLoginsNotBetween(Long value1, Long value2) {
            return notBetween(logins, value1, value2);
        }
        public MemberUserExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public MemberUserExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public MemberUserExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public MemberUserExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public MemberUserExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public MemberUserExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public MemberUserExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public MemberUserExample.Criteria andImWeixinIsNull() {
            return isNull(imWeixin);
        }

        public MemberUserExample.Criteria andImWeixinIsNotNull() {
            return isNotNull(imWeixin);
        }

        public MemberUserExample.Criteria andImWeixinEqualTo(String value) {
            return equalTo(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinNotEqualTo(String value) {
            return notEqualTo(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinGreaterThan(String value) {
            return greaterThan(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinLessThan(String value) {
            return lessThan(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinLike(String value) {
            return like(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinNotLike(String value) {
            return notLike(imWeixin, value);
        }

        public MemberUserExample.Criteria andImWeixinIn(List<String> values) {
            return in(imWeixin, values);
        }

        public MemberUserExample.Criteria andImWeixinNotIn(List<String> values) {
            return notIn(imWeixin, values);
        }

        public MemberUserExample.Criteria andImWeixinBetween(String value1, String value2) {
            return between(imWeixin, value1, value2);
        }

        public MemberUserExample.Criteria andImWeixinNotBetween(String value1, String value2) {
            return notBetween(imWeixin, value1, value2);
        }
        public MemberUserExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public MemberUserExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public MemberUserExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public MemberUserExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public MemberUserExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public MemberUserExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public MemberUserExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public MemberUserExample.Criteria andBirthdayIsNull() {
            return isNull(birthday);
        }

        public MemberUserExample.Criteria andBirthdayIsNotNull() {
            return isNotNull(birthday);
        }

        public MemberUserExample.Criteria andBirthdayEqualTo(Date value) {
            return equalTo(birthday, value);
        }

        public MemberUserExample.Criteria andBirthdayNotEqualTo(Date value) {
            return notEqualTo(birthday, value);
        }

        public MemberUserExample.Criteria andBirthdayGreaterThan(Date value) {
            return greaterThan(birthday, value);
        }

        public MemberUserExample.Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(birthday, value);
        }

        public MemberUserExample.Criteria andBirthdayLessThan(Date value) {
            return lessThan(birthday, value);
        }

        public MemberUserExample.Criteria andBirthdayLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(birthday, value);
        }

        public MemberUserExample.Criteria andBirthdayIn(List<Date> values) {
            return in(birthday, values);
        }

        public MemberUserExample.Criteria andBirthdayNotIn(List<Date> values) {
            return notIn(birthday, values);
        }

        public MemberUserExample.Criteria andBirthdayBetween(Date value1, Date value2) {
            return between(birthday, value1, value2);
        }

        public MemberUserExample.Criteria andBirthdayNotBetween(Date value1, Date value2) {
            return notBetween(birthday, value1, value2);
        }
        public MemberUserExample.Criteria andPasswordStrengthIsNull() {
            return isNull(passwordStrength);
        }

        public MemberUserExample.Criteria andPasswordStrengthIsNotNull() {
            return isNotNull(passwordStrength);
        }

        public MemberUserExample.Criteria andPasswordStrengthEqualTo(Integer value) {
            return equalTo(passwordStrength, value);
        }

        public MemberUserExample.Criteria andPasswordStrengthNotEqualTo(Integer value) {
            return notEqualTo(passwordStrength, value);
        }

        public MemberUserExample.Criteria andPasswordStrengthGreaterThan(Integer value) {
            return greaterThan(passwordStrength, value);
        }

        public MemberUserExample.Criteria andPasswordStrengthGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(passwordStrength, value);
        }

        public MemberUserExample.Criteria andPasswordStrengthLessThan(Integer value) {
            return lessThan(passwordStrength, value);
        }

        public MemberUserExample.Criteria andPasswordStrengthLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(passwordStrength, value);
        }

        public MemberUserExample.Criteria andPasswordStrengthIn(List<Integer> values) {
            return in(passwordStrength, values);
        }

        public MemberUserExample.Criteria andPasswordStrengthNotIn(List<Integer> values) {
            return notIn(passwordStrength, values);
        }

        public MemberUserExample.Criteria andPasswordStrengthBetween(Integer value1, Integer value2) {
            return between(passwordStrength, value1, value2);
        }

        public MemberUserExample.Criteria andPasswordStrengthNotBetween(Integer value1, Integer value2) {
            return notBetween(passwordStrength, value1, value2);
        }
        public MemberUserExample.Criteria andAccountNameIsNull() {
            return isNull(accountName);
        }

        public MemberUserExample.Criteria andAccountNameIsNotNull() {
            return isNotNull(accountName);
        }

        public MemberUserExample.Criteria andAccountNameEqualTo(String value) {
            return equalTo(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameNotEqualTo(String value) {
            return notEqualTo(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameGreaterThan(String value) {
            return greaterThan(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameLessThan(String value) {
            return lessThan(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameLike(String value) {
            return like(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameNotLike(String value) {
            return notLike(accountName, value);
        }

        public MemberUserExample.Criteria andAccountNameIn(List<String> values) {
            return in(accountName, values);
        }

        public MemberUserExample.Criteria andAccountNameNotIn(List<String> values) {
            return notIn(accountName, values);
        }

        public MemberUserExample.Criteria andAccountNameBetween(String value1, String value2) {
            return between(accountName, value1, value2);
        }

        public MemberUserExample.Criteria andAccountNameNotBetween(String value1, String value2) {
            return notBetween(accountName, value1, value2);
        }
        public MemberUserExample.Criteria andSubUserNameGroupsIsNull() {
            return isNull(subUserNameGroups);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsIsNotNull() {
            return isNotNull(subUserNameGroups);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsEqualTo(String value) {
            return equalTo(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsNotEqualTo(String value) {
            return notEqualTo(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsGreaterThan(String value) {
            return greaterThan(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsLessThan(String value) {
            return lessThan(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsLike(String value) {
            return like(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsNotLike(String value) {
            return notLike(subUserNameGroups, value);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsIn(List<String> values) {
            return in(subUserNameGroups, values);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsNotIn(List<String> values) {
            return notIn(subUserNameGroups, values);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsBetween(String value1, String value2) {
            return between(subUserNameGroups, value1, value2);
        }

        public MemberUserExample.Criteria andSubUserNameGroupsNotBetween(String value1, String value2) {
            return notBetween(subUserNameGroups, value1, value2);
        }
        public MemberUserExample.Criteria andIsPayPasswordIsNull() {
            return isNull(isPayPassword);
        }

        public MemberUserExample.Criteria andIsPayPasswordIsNotNull() {
            return isNotNull(isPayPassword);
        }

        public MemberUserExample.Criteria andIsPayPasswordEqualTo(Integer value) {
            return equalTo(isPayPassword, value);
        }

        public MemberUserExample.Criteria andIsPayPasswordNotEqualTo(Integer value) {
            return notEqualTo(isPayPassword, value);
        }

        public MemberUserExample.Criteria andIsPayPasswordGreaterThan(Integer value) {
            return greaterThan(isPayPassword, value);
        }

        public MemberUserExample.Criteria andIsPayPasswordGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isPayPassword, value);
        }

        public MemberUserExample.Criteria andIsPayPasswordLessThan(Integer value) {
            return lessThan(isPayPassword, value);
        }

        public MemberUserExample.Criteria andIsPayPasswordLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isPayPassword, value);
        }

        public MemberUserExample.Criteria andIsPayPasswordIn(List<Integer> values) {
            return in(isPayPassword, values);
        }

        public MemberUserExample.Criteria andIsPayPasswordNotIn(List<Integer> values) {
            return notIn(isPayPassword, values);
        }

        public MemberUserExample.Criteria andIsPayPasswordBetween(Integer value1, Integer value2) {
            return between(isPayPassword, value1, value2);
        }

        public MemberUserExample.Criteria andIsPayPasswordNotBetween(Integer value1, Integer value2) {
            return notBetween(isPayPassword, value1, value2);
        }
        public MemberUserExample.Criteria andLoginEmailIsNull() {
            return isNull(loginEmail);
        }

        public MemberUserExample.Criteria andLoginEmailIsNotNull() {
            return isNotNull(loginEmail);
        }

        public MemberUserExample.Criteria andLoginEmailEqualTo(String value) {
            return equalTo(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailNotEqualTo(String value) {
            return notEqualTo(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailGreaterThan(String value) {
            return greaterThan(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailLessThan(String value) {
            return lessThan(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailLike(String value) {
            return like(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailNotLike(String value) {
            return notLike(loginEmail, value);
        }

        public MemberUserExample.Criteria andLoginEmailIn(List<String> values) {
            return in(loginEmail, values);
        }

        public MemberUserExample.Criteria andLoginEmailNotIn(List<String> values) {
            return notIn(loginEmail, values);
        }

        public MemberUserExample.Criteria andLoginEmailBetween(String value1, String value2) {
            return between(loginEmail, value1, value2);
        }

        public MemberUserExample.Criteria andLoginEmailNotBetween(String value1, String value2) {
            return notBetween(loginEmail, value1, value2);
        }
        public MemberUserExample.Criteria andUserNickIsNull() {
            return isNull(userNick);
        }

        public MemberUserExample.Criteria andUserNickIsNotNull() {
            return isNotNull(userNick);
        }

        public MemberUserExample.Criteria andUserNickEqualTo(String value) {
            return equalTo(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickNotEqualTo(String value) {
            return notEqualTo(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickGreaterThan(String value) {
            return greaterThan(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickLessThan(String value) {
            return lessThan(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickLike(String value) {
            return like(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickNotLike(String value) {
            return notLike(userNick, value);
        }

        public MemberUserExample.Criteria andUserNickIn(List<String> values) {
            return in(userNick, values);
        }

        public MemberUserExample.Criteria andUserNickNotIn(List<String> values) {
            return notIn(userNick, values);
        }

        public MemberUserExample.Criteria andUserNickBetween(String value1, String value2) {
            return between(userNick, value1, value2);
        }

        public MemberUserExample.Criteria andUserNickNotBetween(String value1, String value2) {
            return notBetween(userNick, value1, value2);
        }
        public MemberUserExample.Criteria andImQqIsNull() {
            return isNull(imQq);
        }

        public MemberUserExample.Criteria andImQqIsNotNull() {
            return isNotNull(imQq);
        }

        public MemberUserExample.Criteria andImQqEqualTo(String value) {
            return equalTo(imQq, value);
        }

        public MemberUserExample.Criteria andImQqNotEqualTo(String value) {
            return notEqualTo(imQq, value);
        }

        public MemberUserExample.Criteria andImQqGreaterThan(String value) {
            return greaterThan(imQq, value);
        }

        public MemberUserExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQq, value);
        }

        public MemberUserExample.Criteria andImQqLessThan(String value) {
            return lessThan(imQq, value);
        }

        public MemberUserExample.Criteria andImQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQq, value);
        }

        public MemberUserExample.Criteria andImQqLike(String value) {
            return like(imQq, value);
        }

        public MemberUserExample.Criteria andImQqNotLike(String value) {
            return notLike(imQq, value);
        }

        public MemberUserExample.Criteria andImQqIn(List<String> values) {
            return in(imQq, values);
        }

        public MemberUserExample.Criteria andImQqNotIn(List<String> values) {
            return notIn(imQq, values);
        }

        public MemberUserExample.Criteria andImQqBetween(String value1, String value2) {
            return between(imQq, value1, value2);
        }

        public MemberUserExample.Criteria andImQqNotBetween(String value1, String value2) {
            return notBetween(imQq, value1, value2);
        }
        public MemberUserExample.Criteria andSellerVipGradeIsNull() {
            return isNull(sellerVipGrade);
        }

        public MemberUserExample.Criteria andSellerVipGradeIsNotNull() {
            return isNotNull(sellerVipGrade);
        }

        public MemberUserExample.Criteria andSellerVipGradeEqualTo(Long value) {
            return equalTo(sellerVipGrade, value);
        }

        public MemberUserExample.Criteria andSellerVipGradeNotEqualTo(Long value) {
            return notEqualTo(sellerVipGrade, value);
        }

        public MemberUserExample.Criteria andSellerVipGradeGreaterThan(Long value) {
            return greaterThan(sellerVipGrade, value);
        }

        public MemberUserExample.Criteria andSellerVipGradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerVipGrade, value);
        }

        public MemberUserExample.Criteria andSellerVipGradeLessThan(Long value) {
            return lessThan(sellerVipGrade, value);
        }

        public MemberUserExample.Criteria andSellerVipGradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerVipGrade, value);
        }

        public MemberUserExample.Criteria andSellerVipGradeIn(List<Long> values) {
            return in(sellerVipGrade, values);
        }

        public MemberUserExample.Criteria andSellerVipGradeNotIn(List<Long> values) {
            return notIn(sellerVipGrade, values);
        }

        public MemberUserExample.Criteria andSellerVipGradeBetween(Long value1, Long value2) {
            return between(sellerVipGrade, value1, value2);
        }

        public MemberUserExample.Criteria andSellerVipGradeNotBetween(Long value1, Long value2) {
            return notBetween(sellerVipGrade, value1, value2);
        }
        public MemberUserExample.Criteria andEmailIsNull() {
            return isNull(email);
        }

        public MemberUserExample.Criteria andEmailIsNotNull() {
            return isNotNull(email);
        }

        public MemberUserExample.Criteria andEmailEqualTo(String value) {
            return equalTo(email, value);
        }

        public MemberUserExample.Criteria andEmailNotEqualTo(String value) {
            return notEqualTo(email, value);
        }

        public MemberUserExample.Criteria andEmailGreaterThan(String value) {
            return greaterThan(email, value);
        }

        public MemberUserExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(email, value);
        }

        public MemberUserExample.Criteria andEmailLessThan(String value) {
            return lessThan(email, value);
        }

        public MemberUserExample.Criteria andEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(email, value);
        }

        public MemberUserExample.Criteria andEmailLike(String value) {
            return like(email, value);
        }

        public MemberUserExample.Criteria andEmailNotLike(String value) {
            return notLike(email, value);
        }

        public MemberUserExample.Criteria andEmailIn(List<String> values) {
            return in(email, values);
        }

        public MemberUserExample.Criteria andEmailNotIn(List<String> values) {
            return notIn(email, values);
        }

        public MemberUserExample.Criteria andEmailBetween(String value1, String value2) {
            return between(email, value1, value2);
        }

        public MemberUserExample.Criteria andEmailNotBetween(String value1, String value2) {
            return notBetween(email, value1, value2);
        }
        public MemberUserExample.Criteria andBirthdayMonthDayIsNull() {
            return isNull(birthdayMonthDay);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayIsNotNull() {
            return isNotNull(birthdayMonthDay);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayEqualTo(String value) {
            return equalTo(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotEqualTo(String value) {
            return notEqualTo(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayGreaterThan(String value) {
            return greaterThan(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayLessThan(String value) {
            return lessThan(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayLike(String value) {
            return like(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotLike(String value) {
            return notLike(birthdayMonthDay, value);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayIn(List<String> values) {
            return in(birthdayMonthDay, values);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotIn(List<String> values) {
            return notIn(birthdayMonthDay, values);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayBetween(String value1, String value2) {
            return between(birthdayMonthDay, value1, value2);
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotBetween(String value1, String value2) {
            return notBetween(birthdayMonthDay, value1, value2);
        }
        public MemberUserExample.Criteria andSexIsNull() {
            return isNull(sex);
        }

        public MemberUserExample.Criteria andSexIsNotNull() {
            return isNotNull(sex);
        }

        public MemberUserExample.Criteria andSexEqualTo(String value) {
            return equalTo(sex, value);
        }

        public MemberUserExample.Criteria andSexNotEqualTo(String value) {
            return notEqualTo(sex, value);
        }

        public MemberUserExample.Criteria andSexGreaterThan(String value) {
            return greaterThan(sex, value);
        }

        public MemberUserExample.Criteria andSexGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sex, value);
        }

        public MemberUserExample.Criteria andSexLessThan(String value) {
            return lessThan(sex, value);
        }

        public MemberUserExample.Criteria andSexLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sex, value);
        }

        public MemberUserExample.Criteria andSexLike(String value) {
            return like(sex, value);
        }

        public MemberUserExample.Criteria andSexNotLike(String value) {
            return notLike(sex, value);
        }

        public MemberUserExample.Criteria andSexIn(List<String> values) {
            return in(sex, values);
        }

        public MemberUserExample.Criteria andSexNotIn(List<String> values) {
            return notIn(sex, values);
        }

        public MemberUserExample.Criteria andSexBetween(String value1, String value2) {
            return between(sex, value1, value2);
        }

        public MemberUserExample.Criteria andSexNotBetween(String value1, String value2) {
            return notBetween(sex, value1, value2);
        }
        public MemberUserExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public MemberUserExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public MemberUserExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public MemberUserExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public MemberUserExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public MemberUserExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public MemberUserExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public MemberUserExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public MemberUserExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public MemberUserExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public MemberUserExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public MemberUserExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public MemberUserExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public MemberUserExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public MemberUserExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberUserExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberUserExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberUserExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberUserExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberUserExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberUserExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberUserExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberUserExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberUserExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberUserExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberUserExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberUserExample.Criteria andRealNameIsNull() {
            return isNull(realName);
        }

        public MemberUserExample.Criteria andRealNameIsNotNull() {
            return isNotNull(realName);
        }

        public MemberUserExample.Criteria andRealNameEqualTo(String value) {
            return equalTo(realName, value);
        }

        public MemberUserExample.Criteria andRealNameNotEqualTo(String value) {
            return notEqualTo(realName, value);
        }

        public MemberUserExample.Criteria andRealNameGreaterThan(String value) {
            return greaterThan(realName, value);
        }

        public MemberUserExample.Criteria andRealNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(realName, value);
        }

        public MemberUserExample.Criteria andRealNameLessThan(String value) {
            return lessThan(realName, value);
        }

        public MemberUserExample.Criteria andRealNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(realName, value);
        }

        public MemberUserExample.Criteria andRealNameLike(String value) {
            return like(realName, value);
        }

        public MemberUserExample.Criteria andRealNameNotLike(String value) {
            return notLike(realName, value);
        }

        public MemberUserExample.Criteria andRealNameIn(List<String> values) {
            return in(realName, values);
        }

        public MemberUserExample.Criteria andRealNameNotIn(List<String> values) {
            return notIn(realName, values);
        }

        public MemberUserExample.Criteria andRealNameBetween(String value1, String value2) {
            return between(realName, value1, value2);
        }

        public MemberUserExample.Criteria andRealNameNotBetween(String value1, String value2) {
            return notBetween(realName, value1, value2);
        }
        public MemberUserExample.Criteria andImQqWeiboIsNull() {
            return isNull(imQqWeibo);
        }

        public MemberUserExample.Criteria andImQqWeiboIsNotNull() {
            return isNotNull(imQqWeibo);
        }

        public MemberUserExample.Criteria andImQqWeiboEqualTo(String value) {
            return equalTo(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboNotEqualTo(String value) {
            return notEqualTo(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboGreaterThan(String value) {
            return greaterThan(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboLessThan(String value) {
            return lessThan(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboLike(String value) {
            return like(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboNotLike(String value) {
            return notLike(imQqWeibo, value);
        }

        public MemberUserExample.Criteria andImQqWeiboIn(List<String> values) {
            return in(imQqWeibo, values);
        }

        public MemberUserExample.Criteria andImQqWeiboNotIn(List<String> values) {
            return notIn(imQqWeibo, values);
        }

        public MemberUserExample.Criteria andImQqWeiboBetween(String value1, String value2) {
            return between(imQqWeibo, value1, value2);
        }

        public MemberUserExample.Criteria andImQqWeiboNotBetween(String value1, String value2) {
            return notBetween(imQqWeibo, value1, value2);
        }
        public MemberUserExample.Criteria andLoginPhoneIsNull() {
            return isNull(loginPhone);
        }

        public MemberUserExample.Criteria andLoginPhoneIsNotNull() {
            return isNotNull(loginPhone);
        }

        public MemberUserExample.Criteria andLoginPhoneEqualTo(String value) {
            return equalTo(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneNotEqualTo(String value) {
            return notEqualTo(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneGreaterThan(String value) {
            return greaterThan(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneLessThan(String value) {
            return lessThan(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneLike(String value) {
            return like(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneNotLike(String value) {
            return notLike(loginPhone, value);
        }

        public MemberUserExample.Criteria andLoginPhoneIn(List<String> values) {
            return in(loginPhone, values);
        }

        public MemberUserExample.Criteria andLoginPhoneNotIn(List<String> values) {
            return notIn(loginPhone, values);
        }

        public MemberUserExample.Criteria andLoginPhoneBetween(String value1, String value2) {
            return between(loginPhone, value1, value2);
        }

        public MemberUserExample.Criteria andLoginPhoneNotBetween(String value1, String value2) {
            return notBetween(loginPhone, value1, value2);
        }
        public MemberUserExample.Criteria andPhoneTelIsNull() {
            return isNull(phoneTel);
        }

        public MemberUserExample.Criteria andPhoneTelIsNotNull() {
            return isNotNull(phoneTel);
        }

        public MemberUserExample.Criteria andPhoneTelEqualTo(String value) {
            return equalTo(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelNotEqualTo(String value) {
            return notEqualTo(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelGreaterThan(String value) {
            return greaterThan(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelLessThan(String value) {
            return lessThan(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelLike(String value) {
            return like(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelNotLike(String value) {
            return notLike(phoneTel, value);
        }

        public MemberUserExample.Criteria andPhoneTelIn(List<String> values) {
            return in(phoneTel, values);
        }

        public MemberUserExample.Criteria andPhoneTelNotIn(List<String> values) {
            return notIn(phoneTel, values);
        }

        public MemberUserExample.Criteria andPhoneTelBetween(String value1, String value2) {
            return between(phoneTel, value1, value2);
        }

        public MemberUserExample.Criteria andPhoneTelNotBetween(String value1, String value2) {
            return notBetween(phoneTel, value1, value2);
        }
        public MemberUserExample.Criteria andPayPasswordIsNull() {
            return isNull(payPassword);
        }

        public MemberUserExample.Criteria andPayPasswordIsNotNull() {
            return isNotNull(payPassword);
        }

        public MemberUserExample.Criteria andPayPasswordEqualTo(String value) {
            return equalTo(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordNotEqualTo(String value) {
            return notEqualTo(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordGreaterThan(String value) {
            return greaterThan(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordLessThan(String value) {
            return lessThan(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordLike(String value) {
            return like(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordNotLike(String value) {
            return notLike(payPassword, value);
        }

        public MemberUserExample.Criteria andPayPasswordIn(List<String> values) {
            return in(payPassword, values);
        }

        public MemberUserExample.Criteria andPayPasswordNotIn(List<String> values) {
            return notIn(payPassword, values);
        }

        public MemberUserExample.Criteria andPayPasswordBetween(String value1, String value2) {
            return between(payPassword, value1, value2);
        }

        public MemberUserExample.Criteria andPayPasswordNotBetween(String value1, String value2) {
            return notBetween(payPassword, value1, value2);
        }
    }
}
