package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdFw;

import java.util.*;

public class JdFwExample extends SgExample<JdFwExample.Criteria> {
    public static final Class<JdFw> beanClass = JdFw.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn jdUid;
    public static EntityColumn gmtModify;
    public static EntityColumn endDate;
    public static EntityColumn itemCode;
    public static EntityColumn versionNo;
    public static EntityColumn itemSource;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn userName;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        jdUid = listMap.get("jdUid");
        gmtModify = listMap.get("gmtModify");
        endDate = listMap.get("endDate");
        itemCode = listMap.get("itemCode");
        versionNo = listMap.get("versionNo");
        itemSource = listMap.get("itemSource");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        userName = listMap.get("userName");
        }

    public JdFwExample() {
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

        public Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public Criteria andEndDateIsNull() {
            return isNull(endDate);
        }

        public Criteria andEndDateIsNotNull() {
            return isNotNull(endDate);
        }

        public Criteria andEndDateEqualTo(Date value) {
            return equalTo(endDate, value);
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            return notEqualTo(endDate, value);
        }

        public Criteria andEndDateGreaterThan(Date value) {
            return greaterThan(endDate, value);
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(endDate, value);
        }

        public Criteria andEndDateLessThan(Date value) {
            return lessThan(endDate, value);
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(endDate, value);
        }

        public Criteria andEndDateIn(List<Date> values) {
            return in(endDate, values);
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            return notIn(endDate, values);
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            return between(endDate, value1, value2);
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            return notBetween(endDate, value1, value2);
        }
        public Criteria andItemCodeIsNull() {
            return isNull(itemCode);
        }

        public Criteria andItemCodeIsNotNull() {
            return isNotNull(itemCode);
        }

        public Criteria andItemCodeEqualTo(String value) {
            return equalTo(itemCode, value);
        }

        public Criteria andItemCodeNotEqualTo(String value) {
            return notEqualTo(itemCode, value);
        }

        public Criteria andItemCodeGreaterThan(String value) {
            return greaterThan(itemCode, value);
        }

        public Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemCode, value);
        }

        public Criteria andItemCodeLessThan(String value) {
            return lessThan(itemCode, value);
        }

        public Criteria andItemCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemCode, value);
        }

        public Criteria andItemCodeLike(String value) {
            return like(itemCode, value);
        }

        public Criteria andItemCodeNotLike(String value) {
            return notLike(itemCode, value);
        }

        public Criteria andItemCodeIn(List<String> values) {
            return in(itemCode, values);
        }

        public Criteria andItemCodeNotIn(List<String> values) {
            return notIn(itemCode, values);
        }

        public Criteria andItemCodeBetween(String value1, String value2) {
            return between(itemCode, value1, value2);
        }

        public Criteria andItemCodeNotBetween(String value1, String value2) {
            return notBetween(itemCode, value1, value2);
        }
        public Criteria andVersionNoIsNull() {
            return isNull(versionNo);
        }

        public Criteria andVersionNoIsNotNull() {
            return isNotNull(versionNo);
        }

        public Criteria andVersionNoEqualTo(Integer value) {
            return equalTo(versionNo, value);
        }

        public Criteria andVersionNoNotEqualTo(Integer value) {
            return notEqualTo(versionNo, value);
        }

        public Criteria andVersionNoGreaterThan(Integer value) {
            return greaterThan(versionNo, value);
        }

        public Criteria andVersionNoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(versionNo, value);
        }

        public Criteria andVersionNoLessThan(Integer value) {
            return lessThan(versionNo, value);
        }

        public Criteria andVersionNoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(versionNo, value);
        }

        public Criteria andVersionNoIn(List<Integer> values) {
            return in(versionNo, values);
        }

        public Criteria andVersionNoNotIn(List<Integer> values) {
            return notIn(versionNo, values);
        }

        public Criteria andVersionNoBetween(Integer value1, Integer value2) {
            return between(versionNo, value1, value2);
        }

        public Criteria andVersionNoNotBetween(Integer value1, Integer value2) {
            return notBetween(versionNo, value1, value2);
        }
        public Criteria andItemSourceIsNull() {
            return isNull(itemSource);
        }

        public Criteria andItemSourceIsNotNull() {
            return isNotNull(itemSource);
        }

        public Criteria andItemSourceEqualTo(String value) {
            return equalTo(itemSource, value);
        }

        public Criteria andItemSourceNotEqualTo(String value) {
            return notEqualTo(itemSource, value);
        }

        public Criteria andItemSourceGreaterThan(String value) {
            return greaterThan(itemSource, value);
        }

        public Criteria andItemSourceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemSource, value);
        }

        public Criteria andItemSourceLessThan(String value) {
            return lessThan(itemSource, value);
        }

        public Criteria andItemSourceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemSource, value);
        }

        public Criteria andItemSourceLike(String value) {
            return like(itemSource, value);
        }

        public Criteria andItemSourceNotLike(String value) {
            return notLike(itemSource, value);
        }

        public Criteria andItemSourceIn(List<String> values) {
            return in(itemSource, values);
        }

        public Criteria andItemSourceNotIn(List<String> values) {
            return notIn(itemSource, values);
        }

        public Criteria andItemSourceBetween(String value1, String value2) {
            return between(itemSource, value1, value2);
        }

        public Criteria andItemSourceNotBetween(String value1, String value2) {
            return notBetween(itemSource, value1, value2);
        }
        public Criteria andIdIsNull() {
            return isNull(id);
        }

        public Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
    }
}