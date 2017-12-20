package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberUserCopy2;

import java.util.*;
public class MemberUserCopy2Example extends SgExample<MemberUserCopy2Example.Criteria> {
    public static final Class<MemberUserCopy2> beanClass = MemberUserCopy2.class;
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
        }

    public MemberUserCopy2Example() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberUserCopy2Example.Criteria createCriteriaInternal() {
        return new MemberUserCopy2Example.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobIsNull() {
            return isNull(phoneMob);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobIsNotNull() {
            return isNotNull(phoneMob);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobEqualTo(String value) {
            return equalTo(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotEqualTo(String value) {
            return notEqualTo(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobGreaterThan(String value) {
            return greaterThan(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobLessThan(String value) {
            return lessThan(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobLike(String value) {
            return like(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotLike(String value) {
            return notLike(phoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobIn(List<String> values) {
            return in(phoneMob, values);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotIn(List<String> values) {
            return notIn(phoneMob, values);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobBetween(String value1, String value2) {
            return between(phoneMob, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotBetween(String value1, String value2) {
            return notBetween(phoneMob, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andLastTimeIsNull() {
            return isNull(lastTime);
        }

        public MemberUserCopy2Example.Criteria andLastTimeIsNotNull() {
            return isNotNull(lastTime);
        }

        public MemberUserCopy2Example.Criteria andLastTimeEqualTo(Date value) {
            return equalTo(lastTime, value);
        }

        public MemberUserCopy2Example.Criteria andLastTimeNotEqualTo(Date value) {
            return notEqualTo(lastTime, value);
        }

        public MemberUserCopy2Example.Criteria andLastTimeGreaterThan(Date value) {
            return greaterThan(lastTime, value);
        }

        public MemberUserCopy2Example.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastTime, value);
        }

        public MemberUserCopy2Example.Criteria andLastTimeLessThan(Date value) {
            return lessThan(lastTime, value);
        }

        public MemberUserCopy2Example.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastTime, value);
        }

        public MemberUserCopy2Example.Criteria andLastTimeIn(List<Date> values) {
            return in(lastTime, values);
        }

        public MemberUserCopy2Example.Criteria andLastTimeNotIn(List<Date> values) {
            return notIn(lastTime, values);
        }

        public MemberUserCopy2Example.Criteria andLastTimeBetween(Date value1, Date value2) {
            return between(lastTime, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastTime, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public MemberUserCopy2Example.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public MemberUserCopy2Example.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public MemberUserCopy2Example.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public MemberUserCopy2Example.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public MemberUserCopy2Example.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public MemberUserCopy2Example.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public MemberUserCopy2Example.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public MemberUserCopy2Example.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public MemberUserCopy2Example.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public MemberUserCopy2Example.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public MemberUserCopy2Example.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public MemberUserCopy2Example.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public MemberUserCopy2Example.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public MemberUserCopy2Example.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public MemberUserCopy2Example.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public MemberUserCopy2Example.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public MemberUserCopy2Example.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public MemberUserCopy2Example.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public MemberUserCopy2Example.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public MemberUserCopy2Example.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andPortraitSavepathIsNull() {
            return isNull(portraitSavepath);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathIsNotNull() {
            return isNotNull(portraitSavepath);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathEqualTo(String value) {
            return equalTo(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotEqualTo(String value) {
            return notEqualTo(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathGreaterThan(String value) {
            return greaterThan(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathLessThan(String value) {
            return lessThan(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathLike(String value) {
            return like(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotLike(String value) {
            return notLike(portraitSavepath, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathIn(List<String> values) {
            return in(portraitSavepath, values);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotIn(List<String> values) {
            return notIn(portraitSavepath, values);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathBetween(String value1, String value2) {
            return between(portraitSavepath, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotBetween(String value1, String value2) {
            return notBetween(portraitSavepath, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public MemberUserCopy2Example.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public MemberUserCopy2Example.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public MemberUserCopy2Example.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public MemberUserCopy2Example.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public MemberUserCopy2Example.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andLastIpIsNull() {
            return isNull(lastIp);
        }

        public MemberUserCopy2Example.Criteria andLastIpIsNotNull() {
            return isNotNull(lastIp);
        }

        public MemberUserCopy2Example.Criteria andLastIpEqualTo(String value) {
            return equalTo(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpNotEqualTo(String value) {
            return notEqualTo(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpGreaterThan(String value) {
            return greaterThan(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpLessThan(String value) {
            return lessThan(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpLike(String value) {
            return like(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpNotLike(String value) {
            return notLike(lastIp, value);
        }

        public MemberUserCopy2Example.Criteria andLastIpIn(List<String> values) {
            return in(lastIp, values);
        }

        public MemberUserCopy2Example.Criteria andLastIpNotIn(List<String> values) {
            return notIn(lastIp, values);
        }

        public MemberUserCopy2Example.Criteria andLastIpBetween(String value1, String value2) {
            return between(lastIp, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andLastIpNotBetween(String value1, String value2) {
            return notBetween(lastIp, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public MemberUserCopy2Example.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public MemberUserCopy2Example.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public MemberUserCopy2Example.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public MemberUserCopy2Example.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public MemberUserCopy2Example.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andIdCardIsNull() {
            return isNull(idCard);
        }

        public MemberUserCopy2Example.Criteria andIdCardIsNotNull() {
            return isNotNull(idCard);
        }

        public MemberUserCopy2Example.Criteria andIdCardEqualTo(String value) {
            return equalTo(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardNotEqualTo(String value) {
            return notEqualTo(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardGreaterThan(String value) {
            return greaterThan(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardLessThan(String value) {
            return lessThan(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardLike(String value) {
            return like(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardNotLike(String value) {
            return notLike(idCard, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardIn(List<String> values) {
            return in(idCard, values);
        }

        public MemberUserCopy2Example.Criteria andIdCardNotIn(List<String> values) {
            return notIn(idCard, values);
        }

        public MemberUserCopy2Example.Criteria andIdCardBetween(String value1, String value2) {
            return between(idCard, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andIdCardNotBetween(String value1, String value2) {
            return notBetween(idCard, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public MemberUserCopy2Example.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public MemberUserCopy2Example.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public MemberUserCopy2Example.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public MemberUserCopy2Example.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public MemberUserCopy2Example.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public MemberUserCopy2Example.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public MemberUserCopy2Example.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public MemberUserCopy2Example.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public MemberUserCopy2Example.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public MemberUserCopy2Example.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andImAliwwIsNull() {
            return isNull(imAliww);
        }

        public MemberUserCopy2Example.Criteria andImAliwwIsNotNull() {
            return isNotNull(imAliww);
        }

        public MemberUserCopy2Example.Criteria andImAliwwEqualTo(String value) {
            return equalTo(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotEqualTo(String value) {
            return notEqualTo(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwGreaterThan(String value) {
            return greaterThan(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwLessThan(String value) {
            return lessThan(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwLike(String value) {
            return like(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotLike(String value) {
            return notLike(imAliww, value);
        }

        public MemberUserCopy2Example.Criteria andImAliwwIn(List<String> values) {
            return in(imAliww, values);
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotIn(List<String> values) {
            return notIn(imAliww, values);
        }

        public MemberUserCopy2Example.Criteria andImAliwwBetween(String value1, String value2) {
            return between(imAliww, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotBetween(String value1, String value2) {
            return notBetween(imAliww, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public MemberUserCopy2Example.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public MemberUserCopy2Example.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public MemberUserCopy2Example.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public MemberUserCopy2Example.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public MemberUserCopy2Example.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andIsNameValidateIsNull() {
            return isNull(isNameValidate);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateIsNotNull() {
            return isNotNull(isNameValidate);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateEqualTo(Integer value) {
            return equalTo(isNameValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateNotEqualTo(Integer value) {
            return notEqualTo(isNameValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateGreaterThan(Integer value) {
            return greaterThan(isNameValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isNameValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateLessThan(Integer value) {
            return lessThan(isNameValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isNameValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateIn(List<Integer> values) {
            return in(isNameValidate, values);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateNotIn(List<Integer> values) {
            return notIn(isNameValidate, values);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateBetween(Integer value1, Integer value2) {
            return between(isNameValidate, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateNotBetween(Integer value1, Integer value2) {
            return notBetween(isNameValidate, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRegisterSourceIsNull() {
            return isNull(registerSource);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceIsNotNull() {
            return isNotNull(registerSource);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceEqualTo(Long value) {
            return equalTo(registerSource, value);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceNotEqualTo(Long value) {
            return notEqualTo(registerSource, value);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceGreaterThan(Long value) {
            return greaterThan(registerSource, value);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(registerSource, value);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceLessThan(Long value) {
            return lessThan(registerSource, value);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(registerSource, value);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceIn(List<Long> values) {
            return in(registerSource, values);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceNotIn(List<Long> values) {
            return notIn(registerSource, values);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceBetween(Long value1, Long value2) {
            return between(registerSource, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceNotBetween(Long value1, Long value2) {
            return notBetween(registerSource, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andPasswordIsNull() {
            return isNull(password);
        }

        public MemberUserCopy2Example.Criteria andPasswordIsNotNull() {
            return isNotNull(password);
        }

        public MemberUserCopy2Example.Criteria andPasswordEqualTo(String value) {
            return equalTo(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordNotEqualTo(String value) {
            return notEqualTo(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordGreaterThan(String value) {
            return greaterThan(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordLessThan(String value) {
            return lessThan(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordLike(String value) {
            return like(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordNotLike(String value) {
            return notLike(password, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordIn(List<String> values) {
            return in(password, values);
        }

        public MemberUserCopy2Example.Criteria andPasswordNotIn(List<String> values) {
            return notIn(password, values);
        }

        public MemberUserCopy2Example.Criteria andPasswordBetween(String value1, String value2) {
            return between(password, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andPasswordNotBetween(String value1, String value2) {
            return notBetween(password, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andIsOpenStoreIsNull() {
            return isNull(isOpenStore);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreIsNotNull() {
            return isNotNull(isOpenStore);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreEqualTo(Integer value) {
            return equalTo(isOpenStore, value);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreNotEqualTo(Integer value) {
            return notEqualTo(isOpenStore, value);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreGreaterThan(Integer value) {
            return greaterThan(isOpenStore, value);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isOpenStore, value);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreLessThan(Integer value) {
            return lessThan(isOpenStore, value);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isOpenStore, value);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreIn(List<Integer> values) {
            return in(isOpenStore, values);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreNotIn(List<Integer> values) {
            return notIn(isOpenStore, values);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            return between(isOpenStore, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            return notBetween(isOpenStore, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andZfbAccountIsNull() {
            return isNull(zfbAccount);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountIsNotNull() {
            return isNotNull(zfbAccount);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountEqualTo(String value) {
            return equalTo(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotEqualTo(String value) {
            return notEqualTo(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountGreaterThan(String value) {
            return greaterThan(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountLessThan(String value) {
            return lessThan(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountLike(String value) {
            return like(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotLike(String value) {
            return notLike(zfbAccount, value);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountIn(List<String> values) {
            return in(zfbAccount, values);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotIn(List<String> values) {
            return notIn(zfbAccount, values);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountBetween(String value1, String value2) {
            return between(zfbAccount, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotBetween(String value1, String value2) {
            return notBetween(zfbAccount, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andIsPhoneMobIsNull() {
            return isNull(isPhoneMob);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobIsNotNull() {
            return isNotNull(isPhoneMob);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobEqualTo(Integer value) {
            return equalTo(isPhoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobNotEqualTo(Integer value) {
            return notEqualTo(isPhoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobGreaterThan(Integer value) {
            return greaterThan(isPhoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isPhoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobLessThan(Integer value) {
            return lessThan(isPhoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isPhoneMob, value);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobIn(List<Integer> values) {
            return in(isPhoneMob, values);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobNotIn(List<Integer> values) {
            return notIn(isPhoneMob, values);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobBetween(Integer value1, Integer value2) {
            return between(isPhoneMob, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobNotBetween(Integer value1, Integer value2) {
            return notBetween(isPhoneMob, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andSellerGradeIsNull() {
            return isNull(sellerGrade);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeIsNotNull() {
            return isNotNull(sellerGrade);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeEqualTo(Long value) {
            return equalTo(sellerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeNotEqualTo(Long value) {
            return notEqualTo(sellerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeGreaterThan(Long value) {
            return greaterThan(sellerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeLessThan(Long value) {
            return lessThan(sellerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeIn(List<Long> values) {
            return in(sellerGrade, values);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeNotIn(List<Long> values) {
            return notIn(sellerGrade, values);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeBetween(Long value1, Long value2) {
            return between(sellerGrade, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andSellerGradeNotBetween(Long value1, Long value2) {
            return notBetween(sellerGrade, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public MemberUserCopy2Example.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public MemberUserCopy2Example.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public MemberUserCopy2Example.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public MemberUserCopy2Example.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public MemberUserCopy2Example.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andImSkypeIsNull() {
            return isNull(imSkype);
        }

        public MemberUserCopy2Example.Criteria andImSkypeIsNotNull() {
            return isNotNull(imSkype);
        }

        public MemberUserCopy2Example.Criteria andImSkypeEqualTo(String value) {
            return equalTo(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotEqualTo(String value) {
            return notEqualTo(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeGreaterThan(String value) {
            return greaterThan(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeLessThan(String value) {
            return lessThan(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeLike(String value) {
            return like(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotLike(String value) {
            return notLike(imSkype, value);
        }

        public MemberUserCopy2Example.Criteria andImSkypeIn(List<String> values) {
            return in(imSkype, values);
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotIn(List<String> values) {
            return notIn(imSkype, values);
        }

        public MemberUserCopy2Example.Criteria andImSkypeBetween(String value1, String value2) {
            return between(imSkype, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotBetween(String value1, String value2) {
            return notBetween(imSkype, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andPortraitUrlIsNull() {
            return isNull(portraitUrl);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlIsNotNull() {
            return isNotNull(portraitUrl);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlEqualTo(String value) {
            return equalTo(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotEqualTo(String value) {
            return notEqualTo(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlGreaterThan(String value) {
            return greaterThan(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlLessThan(String value) {
            return lessThan(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlLike(String value) {
            return like(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotLike(String value) {
            return notLike(portraitUrl, value);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlIn(List<String> values) {
            return in(portraitUrl, values);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotIn(List<String> values) {
            return notIn(portraitUrl, values);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlBetween(String value1, String value2) {
            return between(portraitUrl, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotBetween(String value1, String value2) {
            return notBetween(portraitUrl, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andAccountTypeIsNull() {
            return isNull(accountType);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeIsNotNull() {
            return isNotNull(accountType);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeEqualTo(Integer value) {
            return equalTo(accountType, value);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeNotEqualTo(Integer value) {
            return notEqualTo(accountType, value);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeGreaterThan(Integer value) {
            return greaterThan(accountType, value);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(accountType, value);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeLessThan(Integer value) {
            return lessThan(accountType, value);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(accountType, value);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeIn(List<Integer> values) {
            return in(accountType, values);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeNotIn(List<Integer> values) {
            return notIn(accountType, values);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            return between(accountType, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(accountType, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andImYahooWeiboIsNull() {
            return isNull(imYahooWeibo);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboIsNotNull() {
            return isNotNull(imYahooWeibo);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboEqualTo(String value) {
            return equalTo(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotEqualTo(String value) {
            return notEqualTo(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboGreaterThan(String value) {
            return greaterThan(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboLessThan(String value) {
            return lessThan(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboLike(String value) {
            return like(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotLike(String value) {
            return notLike(imYahooWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboIn(List<String> values) {
            return in(imYahooWeibo, values);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotIn(List<String> values) {
            return notIn(imYahooWeibo, values);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboBetween(String value1, String value2) {
            return between(imYahooWeibo, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotBetween(String value1, String value2) {
            return notBetween(imYahooWeibo, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andBuyerGradeIsNull() {
            return isNull(buyerGrade);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeIsNotNull() {
            return isNotNull(buyerGrade);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeEqualTo(Long value) {
            return equalTo(buyerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeNotEqualTo(Long value) {
            return notEqualTo(buyerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeGreaterThan(Long value) {
            return greaterThan(buyerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeLessThan(Long value) {
            return lessThan(buyerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerGrade, value);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeIn(List<Long> values) {
            return in(buyerGrade, values);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeNotIn(List<Long> values) {
            return notIn(buyerGrade, values);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeBetween(Long value1, Long value2) {
            return between(buyerGrade, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeNotBetween(Long value1, Long value2) {
            return notBetween(buyerGrade, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public MemberUserCopy2Example.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public MemberUserCopy2Example.Criteria andUseStatusEqualTo(Long value) {
            return equalTo(useStatus, value);
        }

        public MemberUserCopy2Example.Criteria andUseStatusNotEqualTo(Long value) {
            return notEqualTo(useStatus, value);
        }

        public MemberUserCopy2Example.Criteria andUseStatusGreaterThan(Long value) {
            return greaterThan(useStatus, value);
        }

        public MemberUserCopy2Example.Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public MemberUserCopy2Example.Criteria andUseStatusLessThan(Long value) {
            return lessThan(useStatus, value);
        }

        public MemberUserCopy2Example.Criteria andUseStatusLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public MemberUserCopy2Example.Criteria andUseStatusIn(List<Long> values) {
            return in(useStatus, values);
        }

        public MemberUserCopy2Example.Criteria andUseStatusNotIn(List<Long> values) {
            return notIn(useStatus, values);
        }

        public MemberUserCopy2Example.Criteria andUseStatusBetween(Long value1, Long value2) {
            return between(useStatus, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andUseStatusNotBetween(Long value1, Long value2) {
            return notBetween(useStatus, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andAccountIdIsNull() {
            return isNull(accountId);
        }

        public MemberUserCopy2Example.Criteria andAccountIdIsNotNull() {
            return isNotNull(accountId);
        }

        public MemberUserCopy2Example.Criteria andAccountIdEqualTo(Long value) {
            return equalTo(accountId, value);
        }

        public MemberUserCopy2Example.Criteria andAccountIdNotEqualTo(Long value) {
            return notEqualTo(accountId, value);
        }

        public MemberUserCopy2Example.Criteria andAccountIdGreaterThan(Long value) {
            return greaterThan(accountId, value);
        }

        public MemberUserCopy2Example.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(accountId, value);
        }

        public MemberUserCopy2Example.Criteria andAccountIdLessThan(Long value) {
            return lessThan(accountId, value);
        }

        public MemberUserCopy2Example.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(accountId, value);
        }

        public MemberUserCopy2Example.Criteria andAccountIdIn(List<Long> values) {
            return in(accountId, values);
        }

        public MemberUserCopy2Example.Criteria andAccountIdNotIn(List<Long> values) {
            return notIn(accountId, values);
        }

        public MemberUserCopy2Example.Criteria andAccountIdBetween(Long value1, Long value2) {
            return between(accountId, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            return notBetween(accountId, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRegTimeIsNull() {
            return isNull(regTime);
        }

        public MemberUserCopy2Example.Criteria andRegTimeIsNotNull() {
            return isNotNull(regTime);
        }

        public MemberUserCopy2Example.Criteria andRegTimeEqualTo(Date value) {
            return equalTo(regTime, value);
        }

        public MemberUserCopy2Example.Criteria andRegTimeNotEqualTo(Date value) {
            return notEqualTo(regTime, value);
        }

        public MemberUserCopy2Example.Criteria andRegTimeGreaterThan(Date value) {
            return greaterThan(regTime, value);
        }

        public MemberUserCopy2Example.Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(regTime, value);
        }

        public MemberUserCopy2Example.Criteria andRegTimeLessThan(Date value) {
            return lessThan(regTime, value);
        }

        public MemberUserCopy2Example.Criteria andRegTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(regTime, value);
        }

        public MemberUserCopy2Example.Criteria andRegTimeIn(List<Date> values) {
            return in(regTime, values);
        }

        public MemberUserCopy2Example.Criteria andRegTimeNotIn(List<Date> values) {
            return notIn(regTime, values);
        }

        public MemberUserCopy2Example.Criteria andRegTimeBetween(Date value1, Date value2) {
            return between(regTime, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRegTimeNotBetween(Date value1, Date value2) {
            return notBetween(regTime, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public MemberUserCopy2Example.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public MemberUserCopy2Example.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public MemberUserCopy2Example.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public MemberUserCopy2Example.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public MemberUserCopy2Example.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public MemberUserCopy2Example.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public MemberUserCopy2Example.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public MemberUserCopy2Example.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public MemberUserCopy2Example.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public MemberUserCopy2Example.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public MemberUserCopy2Example.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public MemberUserCopy2Example.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public MemberUserCopy2Example.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public MemberUserCopy2Example.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public MemberUserCopy2Example.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public MemberUserCopy2Example.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public MemberUserCopy2Example.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public MemberUserCopy2Example.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public MemberUserCopy2Example.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public MemberUserCopy2Example.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public MemberUserCopy2Example.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public MemberUserCopy2Example.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public MemberUserCopy2Example.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public MemberUserCopy2Example.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public MemberUserCopy2Example.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public MemberUserCopy2Example.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public MemberUserCopy2Example.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public MemberUserCopy2Example.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public MemberUserCopy2Example.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public MemberUserCopy2Example.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public MemberUserCopy2Example.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public MemberUserCopy2Example.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public MemberUserCopy2Example.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public MemberUserCopy2Example.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public MemberUserCopy2Example.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andIdCardImgIsNull() {
            return isNull(idCardImg);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgIsNotNull() {
            return isNotNull(idCardImg);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgEqualTo(String value) {
            return equalTo(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotEqualTo(String value) {
            return notEqualTo(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgGreaterThan(String value) {
            return greaterThan(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgLessThan(String value) {
            return lessThan(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgLike(String value) {
            return like(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotLike(String value) {
            return notLike(idCardImg, value);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgIn(List<String> values) {
            return in(idCardImg, values);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotIn(List<String> values) {
            return notIn(idCardImg, values);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgBetween(String value1, String value2) {
            return between(idCardImg, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotBetween(String value1, String value2) {
            return notBetween(idCardImg, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public MemberUserCopy2Example.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public MemberUserCopy2Example.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public MemberUserCopy2Example.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public MemberUserCopy2Example.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public MemberUserCopy2Example.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andIsMailValidateIsNull() {
            return isNull(isMailValidate);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateIsNotNull() {
            return isNotNull(isMailValidate);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateEqualTo(Integer value) {
            return equalTo(isMailValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateNotEqualTo(Integer value) {
            return notEqualTo(isMailValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateGreaterThan(Integer value) {
            return greaterThan(isMailValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isMailValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateLessThan(Integer value) {
            return lessThan(isMailValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isMailValidate, value);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateIn(List<Integer> values) {
            return in(isMailValidate, values);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateNotIn(List<Integer> values) {
            return notIn(isMailValidate, values);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateBetween(Integer value1, Integer value2) {
            return between(isMailValidate, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateNotBetween(Integer value1, Integer value2) {
            return notBetween(isMailValidate, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andLoginsIsNull() {
            return isNull(logins);
        }

        public MemberUserCopy2Example.Criteria andLoginsIsNotNull() {
            return isNotNull(logins);
        }

        public MemberUserCopy2Example.Criteria andLoginsEqualTo(Long value) {
            return equalTo(logins, value);
        }

        public MemberUserCopy2Example.Criteria andLoginsNotEqualTo(Long value) {
            return notEqualTo(logins, value);
        }

        public MemberUserCopy2Example.Criteria andLoginsGreaterThan(Long value) {
            return greaterThan(logins, value);
        }

        public MemberUserCopy2Example.Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(logins, value);
        }

        public MemberUserCopy2Example.Criteria andLoginsLessThan(Long value) {
            return lessThan(logins, value);
        }

        public MemberUserCopy2Example.Criteria andLoginsLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(logins, value);
        }

        public MemberUserCopy2Example.Criteria andLoginsIn(List<Long> values) {
            return in(logins, values);
        }

        public MemberUserCopy2Example.Criteria andLoginsNotIn(List<Long> values) {
            return notIn(logins, values);
        }

        public MemberUserCopy2Example.Criteria andLoginsBetween(Long value1, Long value2) {
            return between(logins, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andLoginsNotBetween(Long value1, Long value2) {
            return notBetween(logins, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public MemberUserCopy2Example.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public MemberUserCopy2Example.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public MemberUserCopy2Example.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public MemberUserCopy2Example.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public MemberUserCopy2Example.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andImWeixinIsNull() {
            return isNull(imWeixin);
        }

        public MemberUserCopy2Example.Criteria andImWeixinIsNotNull() {
            return isNotNull(imWeixin);
        }

        public MemberUserCopy2Example.Criteria andImWeixinEqualTo(String value) {
            return equalTo(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotEqualTo(String value) {
            return notEqualTo(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinGreaterThan(String value) {
            return greaterThan(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinLessThan(String value) {
            return lessThan(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinLike(String value) {
            return like(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotLike(String value) {
            return notLike(imWeixin, value);
        }

        public MemberUserCopy2Example.Criteria andImWeixinIn(List<String> values) {
            return in(imWeixin, values);
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotIn(List<String> values) {
            return notIn(imWeixin, values);
        }

        public MemberUserCopy2Example.Criteria andImWeixinBetween(String value1, String value2) {
            return between(imWeixin, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotBetween(String value1, String value2) {
            return notBetween(imWeixin, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public MemberUserCopy2Example.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public MemberUserCopy2Example.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public MemberUserCopy2Example.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public MemberUserCopy2Example.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public MemberUserCopy2Example.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andBirthdayIsNull() {
            return isNull(birthday);
        }

        public MemberUserCopy2Example.Criteria andBirthdayIsNotNull() {
            return isNotNull(birthday);
        }

        public MemberUserCopy2Example.Criteria andBirthdayEqualTo(Date value) {
            return equalTo(birthday, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayNotEqualTo(Date value) {
            return notEqualTo(birthday, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayGreaterThan(Date value) {
            return greaterThan(birthday, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(birthday, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayLessThan(Date value) {
            return lessThan(birthday, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(birthday, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayIn(List<Date> values) {
            return in(birthday, values);
        }

        public MemberUserCopy2Example.Criteria andBirthdayNotIn(List<Date> values) {
            return notIn(birthday, values);
        }

        public MemberUserCopy2Example.Criteria andBirthdayBetween(Date value1, Date value2) {
            return between(birthday, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andBirthdayNotBetween(Date value1, Date value2) {
            return notBetween(birthday, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andPasswordStrengthIsNull() {
            return isNull(passwordStrength);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthIsNotNull() {
            return isNotNull(passwordStrength);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthEqualTo(Integer value) {
            return equalTo(passwordStrength, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthNotEqualTo(Integer value) {
            return notEqualTo(passwordStrength, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthGreaterThan(Integer value) {
            return greaterThan(passwordStrength, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(passwordStrength, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthLessThan(Integer value) {
            return lessThan(passwordStrength, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(passwordStrength, value);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthIn(List<Integer> values) {
            return in(passwordStrength, values);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthNotIn(List<Integer> values) {
            return notIn(passwordStrength, values);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthBetween(Integer value1, Integer value2) {
            return between(passwordStrength, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthNotBetween(Integer value1, Integer value2) {
            return notBetween(passwordStrength, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andAccountNameIsNull() {
            return isNull(accountName);
        }

        public MemberUserCopy2Example.Criteria andAccountNameIsNotNull() {
            return isNotNull(accountName);
        }

        public MemberUserCopy2Example.Criteria andAccountNameEqualTo(String value) {
            return equalTo(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotEqualTo(String value) {
            return notEqualTo(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameGreaterThan(String value) {
            return greaterThan(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameLessThan(String value) {
            return lessThan(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameLike(String value) {
            return like(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotLike(String value) {
            return notLike(accountName, value);
        }

        public MemberUserCopy2Example.Criteria andAccountNameIn(List<String> values) {
            return in(accountName, values);
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotIn(List<String> values) {
            return notIn(accountName, values);
        }

        public MemberUserCopy2Example.Criteria andAccountNameBetween(String value1, String value2) {
            return between(accountName, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotBetween(String value1, String value2) {
            return notBetween(accountName, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andIsPayPasswordIsNull() {
            return isNull(isPayPassword);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordIsNotNull() {
            return isNotNull(isPayPassword);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordEqualTo(Integer value) {
            return equalTo(isPayPassword, value);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordNotEqualTo(Integer value) {
            return notEqualTo(isPayPassword, value);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordGreaterThan(Integer value) {
            return greaterThan(isPayPassword, value);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isPayPassword, value);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordLessThan(Integer value) {
            return lessThan(isPayPassword, value);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isPayPassword, value);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordIn(List<Integer> values) {
            return in(isPayPassword, values);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordNotIn(List<Integer> values) {
            return notIn(isPayPassword, values);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordBetween(Integer value1, Integer value2) {
            return between(isPayPassword, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordNotBetween(Integer value1, Integer value2) {
            return notBetween(isPayPassword, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andLoginEmailIsNull() {
            return isNull(loginEmail);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailIsNotNull() {
            return isNotNull(loginEmail);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailEqualTo(String value) {
            return equalTo(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotEqualTo(String value) {
            return notEqualTo(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailGreaterThan(String value) {
            return greaterThan(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailLessThan(String value) {
            return lessThan(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailLike(String value) {
            return like(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotLike(String value) {
            return notLike(loginEmail, value);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailIn(List<String> values) {
            return in(loginEmail, values);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotIn(List<String> values) {
            return notIn(loginEmail, values);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailBetween(String value1, String value2) {
            return between(loginEmail, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotBetween(String value1, String value2) {
            return notBetween(loginEmail, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andUserNickIsNull() {
            return isNull(userNick);
        }

        public MemberUserCopy2Example.Criteria andUserNickIsNotNull() {
            return isNotNull(userNick);
        }

        public MemberUserCopy2Example.Criteria andUserNickEqualTo(String value) {
            return equalTo(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickNotEqualTo(String value) {
            return notEqualTo(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickGreaterThan(String value) {
            return greaterThan(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickLessThan(String value) {
            return lessThan(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickLike(String value) {
            return like(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickNotLike(String value) {
            return notLike(userNick, value);
        }

        public MemberUserCopy2Example.Criteria andUserNickIn(List<String> values) {
            return in(userNick, values);
        }

        public MemberUserCopy2Example.Criteria andUserNickNotIn(List<String> values) {
            return notIn(userNick, values);
        }

        public MemberUserCopy2Example.Criteria andUserNickBetween(String value1, String value2) {
            return between(userNick, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andUserNickNotBetween(String value1, String value2) {
            return notBetween(userNick, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andImQqIsNull() {
            return isNull(imQq);
        }

        public MemberUserCopy2Example.Criteria andImQqIsNotNull() {
            return isNotNull(imQq);
        }

        public MemberUserCopy2Example.Criteria andImQqEqualTo(String value) {
            return equalTo(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqNotEqualTo(String value) {
            return notEqualTo(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqGreaterThan(String value) {
            return greaterThan(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqLessThan(String value) {
            return lessThan(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqLike(String value) {
            return like(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqNotLike(String value) {
            return notLike(imQq, value);
        }

        public MemberUserCopy2Example.Criteria andImQqIn(List<String> values) {
            return in(imQq, values);
        }

        public MemberUserCopy2Example.Criteria andImQqNotIn(List<String> values) {
            return notIn(imQq, values);
        }

        public MemberUserCopy2Example.Criteria andImQqBetween(String value1, String value2) {
            return between(imQq, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andImQqNotBetween(String value1, String value2) {
            return notBetween(imQq, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andSellerVipGradeIsNull() {
            return isNull(sellerVipGrade);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeIsNotNull() {
            return isNotNull(sellerVipGrade);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeEqualTo(Long value) {
            return equalTo(sellerVipGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeNotEqualTo(Long value) {
            return notEqualTo(sellerVipGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeGreaterThan(Long value) {
            return greaterThan(sellerVipGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerVipGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeLessThan(Long value) {
            return lessThan(sellerVipGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerVipGrade, value);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeIn(List<Long> values) {
            return in(sellerVipGrade, values);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeNotIn(List<Long> values) {
            return notIn(sellerVipGrade, values);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeBetween(Long value1, Long value2) {
            return between(sellerVipGrade, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeNotBetween(Long value1, Long value2) {
            return notBetween(sellerVipGrade, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andEmailIsNull() {
            return isNull(email);
        }

        public MemberUserCopy2Example.Criteria andEmailIsNotNull() {
            return isNotNull(email);
        }

        public MemberUserCopy2Example.Criteria andEmailEqualTo(String value) {
            return equalTo(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailNotEqualTo(String value) {
            return notEqualTo(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailGreaterThan(String value) {
            return greaterThan(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailLessThan(String value) {
            return lessThan(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailLike(String value) {
            return like(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailNotLike(String value) {
            return notLike(email, value);
        }

        public MemberUserCopy2Example.Criteria andEmailIn(List<String> values) {
            return in(email, values);
        }

        public MemberUserCopy2Example.Criteria andEmailNotIn(List<String> values) {
            return notIn(email, values);
        }

        public MemberUserCopy2Example.Criteria andEmailBetween(String value1, String value2) {
            return between(email, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andEmailNotBetween(String value1, String value2) {
            return notBetween(email, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andBirthdayMonthDayIsNull() {
            return isNull(birthdayMonthDay);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayIsNotNull() {
            return isNotNull(birthdayMonthDay);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayEqualTo(String value) {
            return equalTo(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotEqualTo(String value) {
            return notEqualTo(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayGreaterThan(String value) {
            return greaterThan(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayLessThan(String value) {
            return lessThan(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayLike(String value) {
            return like(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotLike(String value) {
            return notLike(birthdayMonthDay, value);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayIn(List<String> values) {
            return in(birthdayMonthDay, values);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotIn(List<String> values) {
            return notIn(birthdayMonthDay, values);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayBetween(String value1, String value2) {
            return between(birthdayMonthDay, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotBetween(String value1, String value2) {
            return notBetween(birthdayMonthDay, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andSexIsNull() {
            return isNull(sex);
        }

        public MemberUserCopy2Example.Criteria andSexIsNotNull() {
            return isNotNull(sex);
        }

        public MemberUserCopy2Example.Criteria andSexEqualTo(String value) {
            return equalTo(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexNotEqualTo(String value) {
            return notEqualTo(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexGreaterThan(String value) {
            return greaterThan(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexLessThan(String value) {
            return lessThan(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexLike(String value) {
            return like(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexNotLike(String value) {
            return notLike(sex, value);
        }

        public MemberUserCopy2Example.Criteria andSexIn(List<String> values) {
            return in(sex, values);
        }

        public MemberUserCopy2Example.Criteria andSexNotIn(List<String> values) {
            return notIn(sex, values);
        }

        public MemberUserCopy2Example.Criteria andSexBetween(String value1, String value2) {
            return between(sex, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andSexNotBetween(String value1, String value2) {
            return notBetween(sex, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public MemberUserCopy2Example.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public MemberUserCopy2Example.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public MemberUserCopy2Example.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public MemberUserCopy2Example.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public MemberUserCopy2Example.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberUserCopy2Example.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberUserCopy2Example.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberUserCopy2Example.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberUserCopy2Example.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberUserCopy2Example.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberUserCopy2Example.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberUserCopy2Example.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberUserCopy2Example.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberUserCopy2Example.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberUserCopy2Example.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andRealNameIsNull() {
            return isNull(realName);
        }

        public MemberUserCopy2Example.Criteria andRealNameIsNotNull() {
            return isNotNull(realName);
        }

        public MemberUserCopy2Example.Criteria andRealNameEqualTo(String value) {
            return equalTo(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameNotEqualTo(String value) {
            return notEqualTo(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameGreaterThan(String value) {
            return greaterThan(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameLessThan(String value) {
            return lessThan(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameLike(String value) {
            return like(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameNotLike(String value) {
            return notLike(realName, value);
        }

        public MemberUserCopy2Example.Criteria andRealNameIn(List<String> values) {
            return in(realName, values);
        }

        public MemberUserCopy2Example.Criteria andRealNameNotIn(List<String> values) {
            return notIn(realName, values);
        }

        public MemberUserCopy2Example.Criteria andRealNameBetween(String value1, String value2) {
            return between(realName, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andRealNameNotBetween(String value1, String value2) {
            return notBetween(realName, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andImQqWeiboIsNull() {
            return isNull(imQqWeibo);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboIsNotNull() {
            return isNotNull(imQqWeibo);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboEqualTo(String value) {
            return equalTo(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotEqualTo(String value) {
            return notEqualTo(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboGreaterThan(String value) {
            return greaterThan(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboLessThan(String value) {
            return lessThan(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboLike(String value) {
            return like(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotLike(String value) {
            return notLike(imQqWeibo, value);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboIn(List<String> values) {
            return in(imQqWeibo, values);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotIn(List<String> values) {
            return notIn(imQqWeibo, values);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboBetween(String value1, String value2) {
            return between(imQqWeibo, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotBetween(String value1, String value2) {
            return notBetween(imQqWeibo, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andLoginPhoneIsNull() {
            return isNull(loginPhone);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneIsNotNull() {
            return isNotNull(loginPhone);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneEqualTo(String value) {
            return equalTo(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotEqualTo(String value) {
            return notEqualTo(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneGreaterThan(String value) {
            return greaterThan(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneLessThan(String value) {
            return lessThan(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneLike(String value) {
            return like(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotLike(String value) {
            return notLike(loginPhone, value);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneIn(List<String> values) {
            return in(loginPhone, values);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotIn(List<String> values) {
            return notIn(loginPhone, values);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneBetween(String value1, String value2) {
            return between(loginPhone, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotBetween(String value1, String value2) {
            return notBetween(loginPhone, value1, value2);
        }
        public MemberUserCopy2Example.Criteria andPhoneTelIsNull() {
            return isNull(phoneTel);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelIsNotNull() {
            return isNotNull(phoneTel);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelEqualTo(String value) {
            return equalTo(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotEqualTo(String value) {
            return notEqualTo(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelGreaterThan(String value) {
            return greaterThan(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelLessThan(String value) {
            return lessThan(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelLike(String value) {
            return like(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotLike(String value) {
            return notLike(phoneTel, value);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelIn(List<String> values) {
            return in(phoneTel, values);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotIn(List<String> values) {
            return notIn(phoneTel, values);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelBetween(String value1, String value2) {
            return between(phoneTel, value1, value2);
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotBetween(String value1, String value2) {
            return notBetween(phoneTel, value1, value2);
        }
    }
}
