package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.PhotoAuthApply;

import java.util.*;
public class PhotoAuthApplyExample extends SgExample<PhotoAuthApplyExample.Criteria> {
    public static final Class<PhotoAuthApply> beanClass = PhotoAuthApply.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn modifyTime;
    public static EntityColumn authApplyId;
    public static EntityColumn codeImg;
    public static EntityColumn mainStyleId;
    public static EntityColumn authType;
    public static EntityColumn authPhone;
    public static EntityColumn userName;
    public static EntityColumn applyTime;
    public static EntityColumn modifyLog;
    public static EntityColumn applyStatus;
    public static EntityColumn showImg;
    public static EntityColumn authId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        modifyTime = listMap.get("modifyTime");
        authApplyId = listMap.get("authApplyId");
        codeImg = listMap.get("codeImg");
        mainStyleId = listMap.get("mainStyleId");
        authType = listMap.get("authType");
        authPhone = listMap.get("authPhone");
        userName = listMap.get("userName");
        applyTime = listMap.get("applyTime");
        modifyLog = listMap.get("modifyLog");
        applyStatus = listMap.get("applyStatus");
        showImg = listMap.get("showImg");
        authId = listMap.get("authId");
        }

    public PhotoAuthApplyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected PhotoAuthApplyExample.Criteria createCriteriaInternal() {
        return new PhotoAuthApplyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeIsNull() {
            return isNull(modifyTime);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeIsNotNull() {
            return isNotNull(modifyTime);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeEqualTo(Date value) {
            return equalTo(modifyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeNotEqualTo(Date value) {
            return notEqualTo(modifyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeGreaterThan(Date value) {
            return greaterThan(modifyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modifyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeLessThan(Date value) {
            return lessThan(modifyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modifyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeIn(List<Date> values) {
            return in(modifyTime, values);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeNotIn(List<Date> values) {
            return notIn(modifyTime, values);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            return between(modifyTime, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(modifyTime, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andAuthApplyIdIsNull() {
            return isNull(authApplyId);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdIsNotNull() {
            return isNotNull(authApplyId);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdEqualTo(Long value) {
            return equalTo(authApplyId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdNotEqualTo(Long value) {
            return notEqualTo(authApplyId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdGreaterThan(Long value) {
            return greaterThan(authApplyId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authApplyId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdLessThan(Long value) {
            return lessThan(authApplyId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authApplyId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdIn(List<Long> values) {
            return in(authApplyId, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdNotIn(List<Long> values) {
            return notIn(authApplyId, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdBetween(Long value1, Long value2) {
            return between(authApplyId, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andAuthApplyIdNotBetween(Long value1, Long value2) {
            return notBetween(authApplyId, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andCodeImgIsNull() {
            return isNull(codeImg);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgIsNotNull() {
            return isNotNull(codeImg);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgEqualTo(String value) {
            return equalTo(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgNotEqualTo(String value) {
            return notEqualTo(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgGreaterThan(String value) {
            return greaterThan(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgLessThan(String value) {
            return lessThan(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgLike(String value) {
            return like(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgNotLike(String value) {
            return notLike(codeImg, value);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgIn(List<String> values) {
            return in(codeImg, values);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgNotIn(List<String> values) {
            return notIn(codeImg, values);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgBetween(String value1, String value2) {
            return between(codeImg, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andCodeImgNotBetween(String value1, String value2) {
            return notBetween(codeImg, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andMainStyleIdIsNull() {
            return isNull(mainStyleId);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdIsNotNull() {
            return isNotNull(mainStyleId);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdEqualTo(Long value) {
            return equalTo(mainStyleId, value);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdNotEqualTo(Long value) {
            return notEqualTo(mainStyleId, value);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdGreaterThan(Long value) {
            return greaterThan(mainStyleId, value);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(mainStyleId, value);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdLessThan(Long value) {
            return lessThan(mainStyleId, value);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(mainStyleId, value);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdIn(List<Long> values) {
            return in(mainStyleId, values);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdNotIn(List<Long> values) {
            return notIn(mainStyleId, values);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdBetween(Long value1, Long value2) {
            return between(mainStyleId, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andMainStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(mainStyleId, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andAuthTypeIsNull() {
            return isNull(authType);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeIsNotNull() {
            return isNotNull(authType);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeEqualTo(Integer value) {
            return equalTo(authType, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeNotEqualTo(Integer value) {
            return notEqualTo(authType, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeGreaterThan(Integer value) {
            return greaterThan(authType, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(authType, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeLessThan(Integer value) {
            return lessThan(authType, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(authType, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeIn(List<Integer> values) {
            return in(authType, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeNotIn(List<Integer> values) {
            return notIn(authType, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeBetween(Integer value1, Integer value2) {
            return between(authType, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andAuthTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(authType, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andAuthPhoneIsNull() {
            return isNull(authPhone);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneIsNotNull() {
            return isNotNull(authPhone);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneEqualTo(String value) {
            return equalTo(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneNotEqualTo(String value) {
            return notEqualTo(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneGreaterThan(String value) {
            return greaterThan(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneLessThan(String value) {
            return lessThan(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneLike(String value) {
            return like(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneNotLike(String value) {
            return notLike(authPhone, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneIn(List<String> values) {
            return in(authPhone, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneNotIn(List<String> values) {
            return notIn(authPhone, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneBetween(String value1, String value2) {
            return between(authPhone, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andAuthPhoneNotBetween(String value1, String value2) {
            return notBetween(authPhone, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public PhotoAuthApplyExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public PhotoAuthApplyExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public PhotoAuthApplyExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public PhotoAuthApplyExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public PhotoAuthApplyExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andApplyTimeIsNull() {
            return isNull(applyTime);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeIsNotNull() {
            return isNotNull(applyTime);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeEqualTo(Date value) {
            return equalTo(applyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeNotEqualTo(Date value) {
            return notEqualTo(applyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeGreaterThan(Date value) {
            return greaterThan(applyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(applyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeLessThan(Date value) {
            return lessThan(applyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(applyTime, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeIn(List<Date> values) {
            return in(applyTime, values);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeNotIn(List<Date> values) {
            return notIn(applyTime, values);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeBetween(Date value1, Date value2) {
            return between(applyTime, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(applyTime, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andModifyLogIsNull() {
            return isNull(modifyLog);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogIsNotNull() {
            return isNotNull(modifyLog);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogEqualTo(String value) {
            return equalTo(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogNotEqualTo(String value) {
            return notEqualTo(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogGreaterThan(String value) {
            return greaterThan(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogLessThan(String value) {
            return lessThan(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogLike(String value) {
            return like(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogNotLike(String value) {
            return notLike(modifyLog, value);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogIn(List<String> values) {
            return in(modifyLog, values);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogNotIn(List<String> values) {
            return notIn(modifyLog, values);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogBetween(String value1, String value2) {
            return between(modifyLog, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andModifyLogNotBetween(String value1, String value2) {
            return notBetween(modifyLog, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andApplyStatusIsNull() {
            return isNull(applyStatus);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusIsNotNull() {
            return isNotNull(applyStatus);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusEqualTo(Integer value) {
            return equalTo(applyStatus, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusNotEqualTo(Integer value) {
            return notEqualTo(applyStatus, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusGreaterThan(Integer value) {
            return greaterThan(applyStatus, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(applyStatus, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusLessThan(Integer value) {
            return lessThan(applyStatus, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(applyStatus, value);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusIn(List<Integer> values) {
            return in(applyStatus, values);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusNotIn(List<Integer> values) {
            return notIn(applyStatus, values);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusBetween(Integer value1, Integer value2) {
            return between(applyStatus, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(applyStatus, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andShowImgIsNull() {
            return isNull(showImg);
        }

        public PhotoAuthApplyExample.Criteria andShowImgIsNotNull() {
            return isNotNull(showImg);
        }

        public PhotoAuthApplyExample.Criteria andShowImgEqualTo(String value) {
            return equalTo(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgNotEqualTo(String value) {
            return notEqualTo(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgGreaterThan(String value) {
            return greaterThan(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgLessThan(String value) {
            return lessThan(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgLike(String value) {
            return like(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgNotLike(String value) {
            return notLike(showImg, value);
        }

        public PhotoAuthApplyExample.Criteria andShowImgIn(List<String> values) {
            return in(showImg, values);
        }

        public PhotoAuthApplyExample.Criteria andShowImgNotIn(List<String> values) {
            return notIn(showImg, values);
        }

        public PhotoAuthApplyExample.Criteria andShowImgBetween(String value1, String value2) {
            return between(showImg, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andShowImgNotBetween(String value1, String value2) {
            return notBetween(showImg, value1, value2);
        }
        public PhotoAuthApplyExample.Criteria andAuthIdIsNull() {
            return isNull(authId);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdIsNotNull() {
            return isNotNull(authId);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdEqualTo(Long value) {
            return equalTo(authId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdNotEqualTo(Long value) {
            return notEqualTo(authId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdGreaterThan(Long value) {
            return greaterThan(authId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdLessThan(Long value) {
            return lessThan(authId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authId, value);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdIn(List<Long> values) {
            return in(authId, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdNotIn(List<Long> values) {
            return notIn(authId, values);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdBetween(Long value1, Long value2) {
            return between(authId, value1, value2);
        }

        public PhotoAuthApplyExample.Criteria andAuthIdNotBetween(Long value1, Long value2) {
            return notBetween(authId, value1, value2);
        }
    }
}