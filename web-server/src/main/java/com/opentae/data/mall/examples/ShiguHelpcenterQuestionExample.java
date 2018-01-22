package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguHelpcenterQuestion;

import java.util.*;
public class ShiguHelpcenterQuestionExample extends SgExample<ShiguHelpcenterQuestionExample.Criteria> {
    public static final Class<ShiguHelpcenterQuestion> beanClass = ShiguHelpcenterQuestion.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gid;
    public static EntityColumn answer;
    public static EntityColumn id;
    public static EntityColumn title;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gid = listMap.get("gid");
        answer = listMap.get("answer");
        id = listMap.get("id");
        title = listMap.get("title");
        cid = listMap.get("cid");
        }

    public ShiguHelpcenterQuestionExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguHelpcenterQuestionExample.Criteria createCriteriaInternal() {
        return new ShiguHelpcenterQuestionExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidIsNull() {
            return isNull(gid);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidIsNotNull() {
            return isNotNull(gid);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidEqualTo(Integer value) {
            return equalTo(gid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidNotEqualTo(Integer value) {
            return notEqualTo(gid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidGreaterThan(Integer value) {
            return greaterThan(gid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(gid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidLessThan(Integer value) {
            return lessThan(gid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(gid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidIn(List<Integer> values) {
            return in(gid, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidNotIn(List<Integer> values) {
            return notIn(gid, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidBetween(Integer value1, Integer value2) {
            return between(gid, value1, value2);
        }

        public ShiguHelpcenterQuestionExample.Criteria andGidNotBetween(Integer value1, Integer value2) {
            return notBetween(gid, value1, value2);
        }
        public ShiguHelpcenterQuestionExample.Criteria andAnswerIsNull() {
            return isNull(answer);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerIsNotNull() {
            return isNotNull(answer);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerEqualTo(String value) {
            return equalTo(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerNotEqualTo(String value) {
            return notEqualTo(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerGreaterThan(String value) {
            return greaterThan(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerLessThan(String value) {
            return lessThan(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerLike(String value) {
            return like(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerNotLike(String value) {
            return notLike(answer, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerIn(List<String> values) {
            return in(answer, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerNotIn(List<String> values) {
            return notIn(answer, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerBetween(String value1, String value2) {
            return between(answer, value1, value2);
        }

        public ShiguHelpcenterQuestionExample.Criteria andAnswerNotBetween(String value1, String value2) {
            return notBetween(answer, value1, value2);
        }
        public ShiguHelpcenterQuestionExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdEqualTo(Integer value) {
            return equalTo(id, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdNotEqualTo(Integer value) {
            return notEqualTo(id, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdGreaterThan(Integer value) {
            return greaterThan(id, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdLessThan(Integer value) {
            return lessThan(id, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdIn(List<Integer> values) {
            return in(id, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdNotIn(List<Integer> values) {
            return notIn(id, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdBetween(Integer value1, Integer value2) {
            return between(id, value1, value2);
        }

        public ShiguHelpcenterQuestionExample.Criteria andIdNotBetween(Integer value1, Integer value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguHelpcenterQuestionExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguHelpcenterQuestionExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ShiguHelpcenterQuestionExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidEqualTo(Integer value) {
            return equalTo(cid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidNotEqualTo(Integer value) {
            return notEqualTo(cid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidGreaterThan(Integer value) {
            return greaterThan(cid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidLessThan(Integer value) {
            return lessThan(cid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidIn(List<Integer> values) {
            return in(cid, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidNotIn(List<Integer> values) {
            return notIn(cid, values);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidBetween(Integer value1, Integer value2) {
            return between(cid, value1, value2);
        }

        public ShiguHelpcenterQuestionExample.Criteria andCidNotBetween(Integer value1, Integer value2) {
            return notBetween(cid, value1, value2);
        }
    }
}