package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoUser;

import java.util.*;
public class ShiguPhotoUserExample extends SgExample<ShiguPhotoUserExample.Criteria> {
    public static final Class<ShiguPhotoUser> beanClass = ShiguPhotoUser.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn userInfo;
    public static EntityColumn address;
    public static EntityColumn headImg;
    public static EntityColumn codeImg;
    public static EntityColumn sex;
    public static EntityColumn mainStyleId;
    public static EntityColumn userType;
    public static EntityColumn contactPhone;
    public static EntityColumn userName;
    public static EntityColumn authorId;
    public static EntityColumn userId;
    public static EntityColumn showImg;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        userInfo = listMap.get("userInfo");
        address = listMap.get("address");
        headImg = listMap.get("headImg");
        codeImg = listMap.get("codeImg");
        sex = listMap.get("sex");
        mainStyleId = listMap.get("mainStyleId");
        userType = listMap.get("userType");
        contactPhone = listMap.get("contactPhone");
        userName = listMap.get("userName");
        authorId = listMap.get("authorId");
        userId = listMap.get("userId");
        showImg = listMap.get("showImg");
        }

    public ShiguPhotoUserExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoUserExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoUserExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoIsNull() {
            return isNull(userInfo);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoIsNotNull() {
            return isNotNull(userInfo);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoEqualTo(String value) {
            return equalTo(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoNotEqualTo(String value) {
            return notEqualTo(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoGreaterThan(String value) {
            return greaterThan(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoLessThan(String value) {
            return lessThan(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoLike(String value) {
            return like(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoNotLike(String value) {
            return notLike(userInfo, value);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoIn(List<String> values) {
            return in(userInfo, values);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoNotIn(List<String> values) {
            return notIn(userInfo, values);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoBetween(String value1, String value2) {
            return between(userInfo, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andUserInfoNotBetween(String value1, String value2) {
            return notBetween(userInfo, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andAddressIsNull() {
            return isNull(address);
        }

        public ShiguPhotoUserExample.Criteria andAddressIsNotNull() {
            return isNotNull(address);
        }

        public ShiguPhotoUserExample.Criteria andAddressEqualTo(String value) {
            return equalTo(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressNotEqualTo(String value) {
            return notEqualTo(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressGreaterThan(String value) {
            return greaterThan(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressLessThan(String value) {
            return lessThan(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressLike(String value) {
            return like(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressNotLike(String value) {
            return notLike(address, value);
        }

        public ShiguPhotoUserExample.Criteria andAddressIn(List<String> values) {
            return in(address, values);
        }

        public ShiguPhotoUserExample.Criteria andAddressNotIn(List<String> values) {
            return notIn(address, values);
        }

        public ShiguPhotoUserExample.Criteria andAddressBetween(String value1, String value2) {
            return between(address, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andAddressNotBetween(String value1, String value2) {
            return notBetween(address, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andHeadImgIsNull() {
            return isNull(headImg);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgIsNotNull() {
            return isNotNull(headImg);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgEqualTo(String value) {
            return equalTo(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgNotEqualTo(String value) {
            return notEqualTo(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgGreaterThan(String value) {
            return greaterThan(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgLessThan(String value) {
            return lessThan(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgLike(String value) {
            return like(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgNotLike(String value) {
            return notLike(headImg, value);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgIn(List<String> values) {
            return in(headImg, values);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgNotIn(List<String> values) {
            return notIn(headImg, values);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgBetween(String value1, String value2) {
            return between(headImg, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andHeadImgNotBetween(String value1, String value2) {
            return notBetween(headImg, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andCodeImgIsNull() {
            return isNull(codeImg);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgIsNotNull() {
            return isNotNull(codeImg);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgEqualTo(String value) {
            return equalTo(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgNotEqualTo(String value) {
            return notEqualTo(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgGreaterThan(String value) {
            return greaterThan(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgLessThan(String value) {
            return lessThan(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgLike(String value) {
            return like(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgNotLike(String value) {
            return notLike(codeImg, value);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgIn(List<String> values) {
            return in(codeImg, values);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgNotIn(List<String> values) {
            return notIn(codeImg, values);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgBetween(String value1, String value2) {
            return between(codeImg, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andCodeImgNotBetween(String value1, String value2) {
            return notBetween(codeImg, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andSexIsNull() {
            return isNull(sex);
        }

        public ShiguPhotoUserExample.Criteria andSexIsNotNull() {
            return isNotNull(sex);
        }

        public ShiguPhotoUserExample.Criteria andSexEqualTo(Integer value) {
            return equalTo(sex, value);
        }

        public ShiguPhotoUserExample.Criteria andSexNotEqualTo(Integer value) {
            return notEqualTo(sex, value);
        }

        public ShiguPhotoUserExample.Criteria andSexGreaterThan(Integer value) {
            return greaterThan(sex, value);
        }

        public ShiguPhotoUserExample.Criteria andSexGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sex, value);
        }

        public ShiguPhotoUserExample.Criteria andSexLessThan(Integer value) {
            return lessThan(sex, value);
        }

        public ShiguPhotoUserExample.Criteria andSexLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sex, value);
        }

        public ShiguPhotoUserExample.Criteria andSexIn(List<Integer> values) {
            return in(sex, values);
        }

        public ShiguPhotoUserExample.Criteria andSexNotIn(List<Integer> values) {
            return notIn(sex, values);
        }

        public ShiguPhotoUserExample.Criteria andSexBetween(Integer value1, Integer value2) {
            return between(sex, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andSexNotBetween(Integer value1, Integer value2) {
            return notBetween(sex, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andMainStyleIdIsNull() {
            return isNull(mainStyleId);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdIsNotNull() {
            return isNotNull(mainStyleId);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdEqualTo(Long value) {
            return equalTo(mainStyleId, value);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdNotEqualTo(Long value) {
            return notEqualTo(mainStyleId, value);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdGreaterThan(Long value) {
            return greaterThan(mainStyleId, value);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(mainStyleId, value);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdLessThan(Long value) {
            return lessThan(mainStyleId, value);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(mainStyleId, value);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdIn(List<Long> values) {
            return in(mainStyleId, values);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdNotIn(List<Long> values) {
            return notIn(mainStyleId, values);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdBetween(Long value1, Long value2) {
            return between(mainStyleId, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andMainStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(mainStyleId, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andUserTypeIsNull() {
            return isNull(userType);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeIsNotNull() {
            return isNotNull(userType);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeEqualTo(Integer value) {
            return equalTo(userType, value);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeNotEqualTo(Integer value) {
            return notEqualTo(userType, value);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeGreaterThan(Integer value) {
            return greaterThan(userType, value);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(userType, value);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeLessThan(Integer value) {
            return lessThan(userType, value);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(userType, value);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeIn(List<Integer> values) {
            return in(userType, values);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeNotIn(List<Integer> values) {
            return notIn(userType, values);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeBetween(Integer value1, Integer value2) {
            return between(userType, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(userType, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andContactPhoneIsNull() {
            return isNull(contactPhone);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneIsNotNull() {
            return isNotNull(contactPhone);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneEqualTo(String value) {
            return equalTo(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneNotEqualTo(String value) {
            return notEqualTo(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneGreaterThan(String value) {
            return greaterThan(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneLessThan(String value) {
            return lessThan(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneLike(String value) {
            return like(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneNotLike(String value) {
            return notLike(contactPhone, value);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneIn(List<String> values) {
            return in(contactPhone, values);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneNotIn(List<String> values) {
            return notIn(contactPhone, values);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneBetween(String value1, String value2) {
            return between(contactPhone, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andContactPhoneNotBetween(String value1, String value2) {
            return notBetween(contactPhone, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public ShiguPhotoUserExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public ShiguPhotoUserExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public ShiguPhotoUserExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public ShiguPhotoUserExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public ShiguPhotoUserExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andAuthorIdIsNull() {
            return isNull(authorId);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdIsNotNull() {
            return isNotNull(authorId);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdEqualTo(Long value) {
            return equalTo(authorId, value);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdNotEqualTo(Long value) {
            return notEqualTo(authorId, value);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdGreaterThan(Long value) {
            return greaterThan(authorId, value);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdLessThan(Long value) {
            return lessThan(authorId, value);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdIn(List<Long> values) {
            return in(authorId, values);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdNotIn(List<Long> values) {
            return notIn(authorId, values);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdBetween(Long value1, Long value2) {
            return between(authorId, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            return notBetween(authorId, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguPhotoUserExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguPhotoUserExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguPhotoUserExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguPhotoUserExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguPhotoUserExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguPhotoUserExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguPhotoUserExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguPhotoUserExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguPhotoUserExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguPhotoUserExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguPhotoUserExample.Criteria andShowImgIsNull() {
            return isNull(showImg);
        }

        public ShiguPhotoUserExample.Criteria andShowImgIsNotNull() {
            return isNotNull(showImg);
        }

        public ShiguPhotoUserExample.Criteria andShowImgEqualTo(String value) {
            return equalTo(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgNotEqualTo(String value) {
            return notEqualTo(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgGreaterThan(String value) {
            return greaterThan(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgLessThan(String value) {
            return lessThan(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgLike(String value) {
            return like(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgNotLike(String value) {
            return notLike(showImg, value);
        }

        public ShiguPhotoUserExample.Criteria andShowImgIn(List<String> values) {
            return in(showImg, values);
        }

        public ShiguPhotoUserExample.Criteria andShowImgNotIn(List<String> values) {
            return notIn(showImg, values);
        }

        public ShiguPhotoUserExample.Criteria andShowImgBetween(String value1, String value2) {
            return between(showImg, value1, value2);
        }

        public ShiguPhotoUserExample.Criteria andShowImgNotBetween(String value1, String value2) {
            return notBetween(showImg, value1, value2);
        }
    }
}