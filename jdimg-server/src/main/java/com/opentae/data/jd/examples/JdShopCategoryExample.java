package com.opentae.data.jd.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.jd.beans.JdShopCategory;

import java.util.*;

public class JdShopCategoryExample extends SgExample<JdShopCategoryExample.Criteria> {
    public static final Class<JdShopCategory> beanClass = JdShopCategory.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn jdUid;
    public static EntityColumn orderNo;
    public static EntityColumn isOpen;
    public static EntityColumn isParent;
    public static EntityColumn gmtModify;
    public static EntityColumn name;
    public static EntityColumn isHomeShow;
    public static EntityColumn shopId;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn parentId;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        jdUid = listMap.get("jdUid");
        orderNo = listMap.get("orderNo");
        isOpen = listMap.get("isOpen");
        isParent = listMap.get("isParent");
        gmtModify = listMap.get("gmtModify");
        name = listMap.get("name");
        isHomeShow = listMap.get("isHomeShow");
        shopId = listMap.get("shopId");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        parentId = listMap.get("parentId");
        cid = listMap.get("cid");
        }

    public JdShopCategoryExample() {
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

    public static class Criteria extends GeneratedCriteria<Criteria> {
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
        public Criteria andOrderNoIsNull() {
            return isNull(orderNo);
        }

        public Criteria andOrderNoIsNotNull() {
            return isNotNull(orderNo);
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            return equalTo(orderNo, value);
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            return notEqualTo(orderNo, value);
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            return greaterThan(orderNo, value);
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(orderNo, value);
        }

        public Criteria andOrderNoLessThan(Integer value) {
            return lessThan(orderNo, value);
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(orderNo, value);
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            return in(orderNo, values);
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            return notIn(orderNo, values);
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            return between(orderNo, value1, value2);
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            return notBetween(orderNo, value1, value2);
        }
        public Criteria andIsOpenIsNull() {
            return isNull(isOpen);
        }

        public Criteria andIsOpenIsNotNull() {
            return isNotNull(isOpen);
        }

        public Criteria andIsOpenEqualTo(Boolean value) {
            return equalTo(isOpen, value);
        }

        public Criteria andIsOpenNotEqualTo(Boolean value) {
            return notEqualTo(isOpen, value);
        }

        public Criteria andIsOpenGreaterThan(Boolean value) {
            return greaterThan(isOpen, value);
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isOpen, value);
        }

        public Criteria andIsOpenLessThan(Boolean value) {
            return lessThan(isOpen, value);
        }

        public Criteria andIsOpenLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isOpen, value);
        }

        public Criteria andIsOpenIn(List<Boolean> values) {
            return in(isOpen, values);
        }

        public Criteria andIsOpenNotIn(List<Boolean> values) {
            return notIn(isOpen, values);
        }

        public Criteria andIsOpenBetween(Boolean value1, Boolean value2) {
            return between(isOpen, value1, value2);
        }

        public Criteria andIsOpenNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isOpen, value1, value2);
        }
        public Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public Criteria andIsParentEqualTo(Boolean value) {
            return equalTo(isParent, value);
        }

        public Criteria andIsParentNotEqualTo(Boolean value) {
            return notEqualTo(isParent, value);
        }

        public Criteria andIsParentGreaterThan(Boolean value) {
            return greaterThan(isParent, value);
        }

        public Criteria andIsParentGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public Criteria andIsParentLessThan(Boolean value) {
            return lessThan(isParent, value);
        }

        public Criteria andIsParentLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public Criteria andIsParentIn(List<Boolean> values) {
            return in(isParent, values);
        }

        public Criteria andIsParentNotIn(List<Boolean> values) {
            return notIn(isParent, values);
        }

        public Criteria andIsParentBetween(Boolean value1, Boolean value2) {
            return between(isParent, value1, value2);
        }

        public Criteria andIsParentNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isParent, value1, value2);
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
        public Criteria andNameIsNull() {
            return isNull(name);
        }

        public Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public Criteria andNameLike(String value) {
            return like(name, value);
        }

        public Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public Criteria andIsHomeShowIsNull() {
            return isNull(isHomeShow);
        }

        public Criteria andIsHomeShowIsNotNull() {
            return isNotNull(isHomeShow);
        }

        public Criteria andIsHomeShowEqualTo(Boolean value) {
            return equalTo(isHomeShow, value);
        }

        public Criteria andIsHomeShowNotEqualTo(Boolean value) {
            return notEqualTo(isHomeShow, value);
        }

        public Criteria andIsHomeShowGreaterThan(Boolean value) {
            return greaterThan(isHomeShow, value);
        }

        public Criteria andIsHomeShowGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isHomeShow, value);
        }

        public Criteria andIsHomeShowLessThan(Boolean value) {
            return lessThan(isHomeShow, value);
        }

        public Criteria andIsHomeShowLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isHomeShow, value);
        }

        public Criteria andIsHomeShowIn(List<Boolean> values) {
            return in(isHomeShow, values);
        }

        public Criteria andIsHomeShowNotIn(List<Boolean> values) {
            return notIn(isHomeShow, values);
        }

        public Criteria andIsHomeShowBetween(Boolean value1, Boolean value2) {
            return between(isHomeShow, value1, value2);
        }

        public Criteria andIsHomeShowNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isHomeShow, value1, value2);
        }
        public Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
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
        public Criteria andParentIdIsNull() {
            return isNull(parentId);
        }

        public Criteria andParentIdIsNotNull() {
            return isNotNull(parentId);
        }

        public Criteria andParentIdEqualTo(Long value) {
            return equalTo(parentId, value);
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            return notEqualTo(parentId, value);
        }

        public Criteria andParentIdGreaterThan(Long value) {
            return greaterThan(parentId, value);
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentId, value);
        }

        public Criteria andParentIdLessThan(Long value) {
            return lessThan(parentId, value);
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentId, value);
        }

        public Criteria andParentIdIn(List<Long> values) {
            return in(parentId, values);
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            return notIn(parentId, values);
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            return between(parentId, value1, value2);
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            return notBetween(parentId, value1, value2);
        }
        public Criteria andCidIsNull() {
            return isNull(cid);
        }

        public Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}