package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguFeedback;

import java.util.*;
public class ShiguFeedbackExample extends SgExample<ShiguFeedbackExample.Criteria> {
    public static final Class<ShiguFeedback> beanClass = ShiguFeedback.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn fcontents;
    public static EntityColumn createTime;
    public static EntityColumn remark5;
    public static EntityColumn feedbackId;
    public static EntityColumn remark4;
    public static EntityColumn updateTime;
    public static EntityColumn title;
    public static EntityColumn remark1;
    public static EntityColumn userId;
    public static EntityColumn remark3;
    public static EntityColumn status;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        fcontents = listMap.get("fcontents");
        createTime = listMap.get("createTime");
        remark5 = listMap.get("remark5");
        feedbackId = listMap.get("feedbackId");
        remark4 = listMap.get("remark4");
        updateTime = listMap.get("updateTime");
        title = listMap.get("title");
        remark1 = listMap.get("remark1");
        userId = listMap.get("userId");
        remark3 = listMap.get("remark3");
        status = listMap.get("status");
        remark2 = listMap.get("remark2");
        }

    public ShiguFeedbackExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguFeedbackExample.Criteria createCriteriaInternal() {
        return new ShiguFeedbackExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguFeedbackExample.Criteria andFcontentsIsNull() {
            return isNull(fcontents);
        }

        public ShiguFeedbackExample.Criteria andFcontentsIsNotNull() {
            return isNotNull(fcontents);
        }

        public ShiguFeedbackExample.Criteria andFcontentsEqualTo(String value) {
            return equalTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotEqualTo(String value) {
            return notEqualTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsGreaterThan(String value) {
            return greaterThan(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsLessThan(String value) {
            return lessThan(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsLike(String value) {
            return like(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotLike(String value) {
            return notLike(fcontents, value);
        }

        public ShiguFeedbackExample.Criteria andFcontentsIn(List<String> values) {
            return in(fcontents, values);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotIn(List<String> values) {
            return notIn(fcontents, values);
        }

        public ShiguFeedbackExample.Criteria andFcontentsBetween(String value1, String value2) {
            return between(fcontents, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andFcontentsNotBetween(String value1, String value2) {
            return notBetween(fcontents, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguFeedbackExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguFeedbackExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguFeedbackExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguFeedbackExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andFeedbackIdIsNull() {
            return isNull(feedbackId);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdIsNotNull() {
            return isNotNull(feedbackId);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdEqualTo(Long value) {
            return equalTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdNotEqualTo(Long value) {
            return notEqualTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdGreaterThan(Long value) {
            return greaterThan(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdLessThan(Long value) {
            return lessThan(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(feedbackId, value);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdIn(List<Long> values) {
            return in(feedbackId, values);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdNotIn(List<Long> values) {
            return notIn(feedbackId, values);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdBetween(Long value1, Long value2) {
            return between(feedbackId, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andFeedbackIdNotBetween(Long value1, Long value2) {
            return notBetween(feedbackId, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguFeedbackExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguFeedbackExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguFeedbackExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguFeedbackExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguFeedbackExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andUpdateTimeIsNull() {
            return isNull(updateTime);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeIsNotNull() {
            return isNotNull(updateTime);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeEqualTo(Date value) {
            return equalTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            return notEqualTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeGreaterThan(Date value) {
            return greaterThan(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeLessThan(Date value) {
            return lessThan(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(updateTime, value);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeIn(List<Date> values) {
            return in(updateTime, values);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            return notIn(updateTime, values);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            return between(updateTime, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            return notBetween(updateTime, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguFeedbackExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguFeedbackExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguFeedbackExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguFeedbackExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguFeedbackExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguFeedbackExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguFeedbackExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguFeedbackExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguFeedbackExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguFeedbackExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguFeedbackExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguFeedbackExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguFeedbackExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguFeedbackExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguFeedbackExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguFeedbackExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguFeedbackExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguFeedbackExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguFeedbackExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguFeedbackExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguFeedbackExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguFeedbackExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguFeedbackExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguFeedbackExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguFeedbackExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
        public ShiguFeedbackExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguFeedbackExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguFeedbackExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguFeedbackExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguFeedbackExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguFeedbackExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguFeedbackExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}