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
    protected JdFwExample.Criteria createCriteriaInternal() {
        return new JdFwExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdFwExample.Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public JdFwExample.Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public JdFwExample.Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public JdFwExample.Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public JdFwExample.Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public JdFwExample.Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public JdFwExample.Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public JdFwExample.Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public JdFwExample.Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public JdFwExample.Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public JdFwExample.Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public JdFwExample.Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public JdFwExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public JdFwExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public JdFwExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public JdFwExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public JdFwExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public JdFwExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public JdFwExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public JdFwExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public JdFwExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public JdFwExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public JdFwExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public JdFwExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public JdFwExample.Criteria andEndDateIsNull() {
            return isNull(endDate);
        }

        public JdFwExample.Criteria andEndDateIsNotNull() {
            return isNotNull(endDate);
        }

        public JdFwExample.Criteria andEndDateEqualTo(Date value) {
            return equalTo(endDate, value);
        }

        public JdFwExample.Criteria andEndDateNotEqualTo(Date value) {
            return notEqualTo(endDate, value);
        }

        public JdFwExample.Criteria andEndDateGreaterThan(Date value) {
            return greaterThan(endDate, value);
        }

        public JdFwExample.Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(endDate, value);
        }

        public JdFwExample.Criteria andEndDateLessThan(Date value) {
            return lessThan(endDate, value);
        }

        public JdFwExample.Criteria andEndDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(endDate, value);
        }

        public JdFwExample.Criteria andEndDateIn(List<Date> values) {
            return in(endDate, values);
        }

        public JdFwExample.Criteria andEndDateNotIn(List<Date> values) {
            return notIn(endDate, values);
        }

        public JdFwExample.Criteria andEndDateBetween(Date value1, Date value2) {
            return between(endDate, value1, value2);
        }

        public JdFwExample.Criteria andEndDateNotBetween(Date value1, Date value2) {
            return notBetween(endDate, value1, value2);
        }
        public JdFwExample.Criteria andItemCodeIsNull() {
            return isNull(itemCode);
        }

        public JdFwExample.Criteria andItemCodeIsNotNull() {
            return isNotNull(itemCode);
        }

        public JdFwExample.Criteria andItemCodeEqualTo(String value) {
            return equalTo(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeNotEqualTo(String value) {
            return notEqualTo(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeGreaterThan(String value) {
            return greaterThan(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeLessThan(String value) {
            return lessThan(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeLike(String value) {
            return like(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeNotLike(String value) {
            return notLike(itemCode, value);
        }

        public JdFwExample.Criteria andItemCodeIn(List<String> values) {
            return in(itemCode, values);
        }

        public JdFwExample.Criteria andItemCodeNotIn(List<String> values) {
            return notIn(itemCode, values);
        }

        public JdFwExample.Criteria andItemCodeBetween(String value1, String value2) {
            return between(itemCode, value1, value2);
        }

        public JdFwExample.Criteria andItemCodeNotBetween(String value1, String value2) {
            return notBetween(itemCode, value1, value2);
        }
        public JdFwExample.Criteria andVersionNoIsNull() {
            return isNull(versionNo);
        }

        public JdFwExample.Criteria andVersionNoIsNotNull() {
            return isNotNull(versionNo);
        }

        public JdFwExample.Criteria andVersionNoEqualTo(Integer value) {
            return equalTo(versionNo, value);
        }

        public JdFwExample.Criteria andVersionNoNotEqualTo(Integer value) {
            return notEqualTo(versionNo, value);
        }

        public JdFwExample.Criteria andVersionNoGreaterThan(Integer value) {
            return greaterThan(versionNo, value);
        }

        public JdFwExample.Criteria andVersionNoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(versionNo, value);
        }

        public JdFwExample.Criteria andVersionNoLessThan(Integer value) {
            return lessThan(versionNo, value);
        }

        public JdFwExample.Criteria andVersionNoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(versionNo, value);
        }

        public JdFwExample.Criteria andVersionNoIn(List<Integer> values) {
            return in(versionNo, values);
        }

        public JdFwExample.Criteria andVersionNoNotIn(List<Integer> values) {
            return notIn(versionNo, values);
        }

        public JdFwExample.Criteria andVersionNoBetween(Integer value1, Integer value2) {
            return between(versionNo, value1, value2);
        }

        public JdFwExample.Criteria andVersionNoNotBetween(Integer value1, Integer value2) {
            return notBetween(versionNo, value1, value2);
        }
        public JdFwExample.Criteria andItemSourceIsNull() {
            return isNull(itemSource);
        }

        public JdFwExample.Criteria andItemSourceIsNotNull() {
            return isNotNull(itemSource);
        }

        public JdFwExample.Criteria andItemSourceEqualTo(String value) {
            return equalTo(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceNotEqualTo(String value) {
            return notEqualTo(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceGreaterThan(String value) {
            return greaterThan(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceLessThan(String value) {
            return lessThan(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceLike(String value) {
            return like(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceNotLike(String value) {
            return notLike(itemSource, value);
        }

        public JdFwExample.Criteria andItemSourceIn(List<String> values) {
            return in(itemSource, values);
        }

        public JdFwExample.Criteria andItemSourceNotIn(List<String> values) {
            return notIn(itemSource, values);
        }

        public JdFwExample.Criteria andItemSourceBetween(String value1, String value2) {
            return between(itemSource, value1, value2);
        }

        public JdFwExample.Criteria andItemSourceNotBetween(String value1, String value2) {
            return notBetween(itemSource, value1, value2);
        }
        public JdFwExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public JdFwExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public JdFwExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public JdFwExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public JdFwExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public JdFwExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public JdFwExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public JdFwExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public JdFwExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public JdFwExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public JdFwExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public JdFwExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public JdFwExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public JdFwExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public JdFwExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public JdFwExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public JdFwExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public JdFwExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public JdFwExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public JdFwExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public JdFwExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public JdFwExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public JdFwExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public JdFwExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public JdFwExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public JdFwExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public JdFwExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public JdFwExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public JdFwExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public JdFwExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public JdFwExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public JdFwExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public JdFwExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public JdFwExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public JdFwExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public JdFwExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public JdFwExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public JdFwExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
    }
}