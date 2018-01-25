package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguNewActiveParticipants;

import java.util.*;
public class ShiguNewActiveParticipantsExample extends SgExample<ShiguNewActiveParticipantsExample.Criteria> {
    public static final Class<ShiguNewActiveParticipants> beanClass = ShiguNewActiveParticipants.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gmtModify;
    public static EntityColumn newActiveId;
    public static EntityColumn winningCode;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn goodsUploadNum;
    public static EntityColumn winningStatus;
    public static EntityColumn memberId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gmtModify = listMap.get("gmtModify");
        newActiveId = listMap.get("newActiveId");
        winningCode = listMap.get("winningCode");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        goodsUploadNum = listMap.get("goodsUploadNum");
        winningStatus = listMap.get("winningStatus");
        memberId = listMap.get("memberId");
        }

    public ShiguNewActiveParticipantsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguNewActiveParticipantsExample.Criteria createCriteriaInternal() {
        return new ShiguNewActiveParticipantsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdIsNull() {
            return isNull(newActiveId);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdIsNotNull() {
            return isNotNull(newActiveId);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdEqualTo(Long value) {
            return equalTo(newActiveId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdNotEqualTo(Long value) {
            return notEqualTo(newActiveId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdGreaterThan(Long value) {
            return greaterThan(newActiveId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(newActiveId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdLessThan(Long value) {
            return lessThan(newActiveId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(newActiveId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdIn(List<Long> values) {
            return in(newActiveId, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdNotIn(List<Long> values) {
            return notIn(newActiveId, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdBetween(Long value1, Long value2) {
            return between(newActiveId, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andNewActiveIdNotBetween(Long value1, Long value2) {
            return notBetween(newActiveId, value1, value2);
        }
        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeIsNull() {
            return isNull(winningCode);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeIsNotNull() {
            return isNotNull(winningCode);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeEqualTo(String value) {
            return equalTo(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeNotEqualTo(String value) {
            return notEqualTo(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeGreaterThan(String value) {
            return greaterThan(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeLessThan(String value) {
            return lessThan(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeLike(String value) {
            return like(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeNotLike(String value) {
            return notLike(winningCode, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeIn(List<String> values) {
            return in(winningCode, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeNotIn(List<String> values) {
            return notIn(winningCode, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeBetween(String value1, String value2) {
            return between(winningCode, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningCodeNotBetween(String value1, String value2) {
            return notBetween(winningCode, value1, value2);
        }
        public ShiguNewActiveParticipantsExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumIsNull() {
            return isNull(goodsUploadNum);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumIsNotNull() {
            return isNotNull(goodsUploadNum);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumEqualTo(Long value) {
            return equalTo(goodsUploadNum, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumNotEqualTo(Long value) {
            return notEqualTo(goodsUploadNum, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumGreaterThan(Long value) {
            return greaterThan(goodsUploadNum, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsUploadNum, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumLessThan(Long value) {
            return lessThan(goodsUploadNum, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsUploadNum, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumIn(List<Long> values) {
            return in(goodsUploadNum, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumNotIn(List<Long> values) {
            return notIn(goodsUploadNum, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumBetween(Long value1, Long value2) {
            return between(goodsUploadNum, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andGoodsUploadNumNotBetween(Long value1, Long value2) {
            return notBetween(goodsUploadNum, value1, value2);
        }
        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusIsNull() {
            return isNull(winningStatus);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusIsNotNull() {
            return isNotNull(winningStatus);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusEqualTo(Integer value) {
            return equalTo(winningStatus, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusNotEqualTo(Integer value) {
            return notEqualTo(winningStatus, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusGreaterThan(Integer value) {
            return greaterThan(winningStatus, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(winningStatus, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusLessThan(Integer value) {
            return lessThan(winningStatus, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(winningStatus, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusIn(List<Integer> values) {
            return in(winningStatus, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusNotIn(List<Integer> values) {
            return notIn(winningStatus, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusBetween(Integer value1, Integer value2) {
            return between(winningStatus, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andWinningStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(winningStatus, value1, value2);
        }
        public ShiguNewActiveParticipantsExample.Criteria andMemberIdIsNull() {
            return isNull(memberId);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdIsNotNull() {
            return isNotNull(memberId);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdEqualTo(Long value) {
            return equalTo(memberId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdNotEqualTo(Long value) {
            return notEqualTo(memberId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdGreaterThan(Long value) {
            return greaterThan(memberId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(memberId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdLessThan(Long value) {
            return lessThan(memberId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(memberId, value);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdIn(List<Long> values) {
            return in(memberId, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdNotIn(List<Long> values) {
            return notIn(memberId, values);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdBetween(Long value1, Long value2) {
            return between(memberId, value1, value2);
        }

        public ShiguNewActiveParticipantsExample.Criteria andMemberIdNotBetween(Long value1, Long value2) {
            return notBetween(memberId, value1, value2);
        }
    }
}