package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.MemberStoreTaobaoSession;

import java.util.*;
public class MemberStoreTaobaoSessionExample extends SgExample<MemberStoreTaobaoSessionExample.Criteria> {
    public static final Class<MemberStoreTaobaoSession> beanClass = MemberStoreTaobaoSession.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn remark18;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn storeStatus;
    public static EntityColumn remark19;
    public static EntityColumn nick;
    public static EntityColumn loginIp;
    public static EntityColumn remark20;
    public static EntityColumn openStatus;
    public static EntityColumn taobaoBindSession;
    public static EntityColumn taobaoLoginSession;
    public static EntityColumn updateTime;
    public static EntityColumn mstsId;
    public static EntityColumn storeId;
    public static EntityColumn userId;
    public static EntityColumn openLogs;
    public static EntityColumn site;
    public static EntityColumn remark9;
    public static EntityColumn createTime;
    public static EntityColumn remark8;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        remark18 = listMap.get("remark18");
        remark17 = listMap.get("remark17");
        remark16 = listMap.get("remark16");
        remark15 = listMap.get("remark15");
        remark14 = listMap.get("remark14");
        remark13 = listMap.get("remark13");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        storeStatus = listMap.get("storeStatus");
        remark19 = listMap.get("remark19");
        nick = listMap.get("nick");
        loginIp = listMap.get("loginIp");
        remark20 = listMap.get("remark20");
        openStatus = listMap.get("openStatus");
        taobaoBindSession = listMap.get("taobaoBindSession");
        taobaoLoginSession = listMap.get("taobaoLoginSession");
        updateTime = listMap.get("updateTime");
        mstsId = listMap.get("mstsId");
        storeId = listMap.get("storeId");
        userId = listMap.get("userId");
        openLogs = listMap.get("openLogs");
        site = listMap.get("site");
        remark9 = listMap.get("remark9");
        createTime = listMap.get("createTime");
        remark8 = listMap.get("remark8");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public MemberStoreTaobaoSessionExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected MemberStoreTaobaoSessionExample.Criteria createCriteriaInternal() {
        return new MemberStoreTaobaoSessionExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusIsNull() {
            return isNull(storeStatus);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusIsNotNull() {
            return isNotNull(storeStatus);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusEqualTo(Integer value) {
            return equalTo(storeStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusNotEqualTo(Integer value) {
            return notEqualTo(storeStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusGreaterThan(Integer value) {
            return greaterThan(storeStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(storeStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusLessThan(Integer value) {
            return lessThan(storeStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(storeStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusIn(List<Integer> values) {
            return in(storeStatus, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusNotIn(List<Integer> values) {
            return notIn(storeStatus, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusBetween(Integer value1, Integer value2) {
            return between(storeStatus, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(storeStatus, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andNickIsNull() {
            return isNull(nick);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickIsNotNull() {
            return isNotNull(nick);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickEqualTo(String value) {
            return equalTo(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotEqualTo(String value) {
            return notEqualTo(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickGreaterThan(String value) {
            return greaterThan(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickLessThan(String value) {
            return lessThan(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickLike(String value) {
            return like(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotLike(String value) {
            return notLike(nick, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickIn(List<String> values) {
            return in(nick, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotIn(List<String> values) {
            return notIn(nick, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickBetween(String value1, String value2) {
            return between(nick, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andNickNotBetween(String value1, String value2) {
            return notBetween(nick, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andLoginIpIsNull() {
            return isNull(loginIp);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpIsNotNull() {
            return isNotNull(loginIp);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpEqualTo(String value) {
            return equalTo(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotEqualTo(String value) {
            return notEqualTo(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpGreaterThan(String value) {
            return greaterThan(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpLessThan(String value) {
            return lessThan(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpLike(String value) {
            return like(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotLike(String value) {
            return notLike(loginIp, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpIn(List<String> values) {
            return in(loginIp, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotIn(List<String> values) {
            return notIn(loginIp, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpBetween(String value1, String value2) {
            return between(loginIp, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andLoginIpNotBetween(String value1, String value2) {
            return notBetween(loginIp, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusIsNull() {
            return isNull(openStatus);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusIsNotNull() {
            return isNotNull(openStatus);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusEqualTo(Integer value) {
            return equalTo(openStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusNotEqualTo(Integer value) {
            return notEqualTo(openStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusGreaterThan(Integer value) {
            return greaterThan(openStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(openStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusLessThan(Integer value) {
            return lessThan(openStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(openStatus, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusIn(List<Integer> values) {
            return in(openStatus, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusNotIn(List<Integer> values) {
            return notIn(openStatus, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusBetween(Integer value1, Integer value2) {
            return between(openStatus, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(openStatus, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionIsNull() {
            return isNull(taobaoBindSession);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionIsNotNull() {
            return isNotNull(taobaoBindSession);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionEqualTo(String value) {
            return equalTo(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotEqualTo(String value) {
            return notEqualTo(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionGreaterThan(String value) {
            return greaterThan(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionLessThan(String value) {
            return lessThan(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionLike(String value) {
            return like(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotLike(String value) {
            return notLike(taobaoBindSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionIn(List<String> values) {
            return in(taobaoBindSession, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotIn(List<String> values) {
            return notIn(taobaoBindSession, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionBetween(String value1, String value2) {
            return between(taobaoBindSession, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoBindSessionNotBetween(String value1, String value2) {
            return notBetween(taobaoBindSession, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionIsNull() {
            return isNull(taobaoLoginSession);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionIsNotNull() {
            return isNotNull(taobaoLoginSession);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionEqualTo(String value) {
            return equalTo(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotEqualTo(String value) {
            return notEqualTo(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionGreaterThan(String value) {
            return greaterThan(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionLessThan(String value) {
            return lessThan(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionLike(String value) {
            return like(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotLike(String value) {
            return notLike(taobaoLoginSession, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionIn(List<String> values) {
            return in(taobaoLoginSession, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotIn(List<String> values) {
            return notIn(taobaoLoginSession, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionBetween(String value1, String value2) {
            return between(taobaoLoginSession, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andTaobaoLoginSessionNotBetween(String value1, String value2) {
            return notBetween(taobaoLoginSession, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeIsNull() {
            return isNull(updateTime);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeIsNotNull() {
            return isNotNull(updateTime);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeEqualTo(Date value) {
            return equalTo(updateTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            return notEqualTo(updateTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeGreaterThan(Date value) {
            return greaterThan(updateTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(updateTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeLessThan(Date value) {
            return lessThan(updateTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(updateTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeIn(List<Date> values) {
            return in(updateTime, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            return notIn(updateTime, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            return between(updateTime, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            return notBetween(updateTime, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andMstsIdIsNull() {
            return isNull(mstsId);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdIsNotNull() {
            return isNotNull(mstsId);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdEqualTo(Long value) {
            return equalTo(mstsId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdNotEqualTo(Long value) {
            return notEqualTo(mstsId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdGreaterThan(Long value) {
            return greaterThan(mstsId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(mstsId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdLessThan(Long value) {
            return lessThan(mstsId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(mstsId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdIn(List<Long> values) {
            return in(mstsId, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdNotIn(List<Long> values) {
            return notIn(mstsId, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdBetween(Long value1, Long value2) {
            return between(mstsId, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andMstsIdNotBetween(Long value1, Long value2) {
            return notBetween(mstsId, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsIsNull() {
            return isNull(openLogs);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsIsNotNull() {
            return isNotNull(openLogs);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsEqualTo(String value) {
            return equalTo(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotEqualTo(String value) {
            return notEqualTo(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsGreaterThan(String value) {
            return greaterThan(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsLessThan(String value) {
            return lessThan(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsLike(String value) {
            return like(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotLike(String value) {
            return notLike(openLogs, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsIn(List<String> values) {
            return in(openLogs, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotIn(List<String> values) {
            return notIn(openLogs, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsBetween(String value1, String value2) {
            return between(openLogs, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andOpenLogsNotBetween(String value1, String value2) {
            return notBetween(openLogs, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andSiteIsNull() {
            return isNull(site);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteIsNotNull() {
            return isNotNull(site);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteEqualTo(String value) {
            return equalTo(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotEqualTo(String value) {
            return notEqualTo(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteGreaterThan(String value) {
            return greaterThan(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteLessThan(String value) {
            return lessThan(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteLike(String value) {
            return like(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotLike(String value) {
            return notLike(site, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteIn(List<String> values) {
            return in(site, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotIn(List<String> values) {
            return notIn(site, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteBetween(String value1, String value2) {
            return between(site, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andSiteNotBetween(String value1, String value2) {
            return notBetween(site, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public MemberStoreTaobaoSessionExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public MemberStoreTaobaoSessionExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}