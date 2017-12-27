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
    protected JdShopCategoryExample.Criteria createCriteriaInternal() {
        return new JdShopCategoryExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public JdShopCategoryExample.Criteria andJdUidIsNull() {
            return isNull(jdUid);
        }

        public JdShopCategoryExample.Criteria andJdUidIsNotNull() {
            return isNotNull(jdUid);
        }

        public JdShopCategoryExample.Criteria andJdUidEqualTo(Long value) {
            return equalTo(jdUid, value);
        }

        public JdShopCategoryExample.Criteria andJdUidNotEqualTo(Long value) {
            return notEqualTo(jdUid, value);
        }

        public JdShopCategoryExample.Criteria andJdUidGreaterThan(Long value) {
            return greaterThan(jdUid, value);
        }

        public JdShopCategoryExample.Criteria andJdUidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(jdUid, value);
        }

        public JdShopCategoryExample.Criteria andJdUidLessThan(Long value) {
            return lessThan(jdUid, value);
        }

        public JdShopCategoryExample.Criteria andJdUidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(jdUid, value);
        }

        public JdShopCategoryExample.Criteria andJdUidIn(List<Long> values) {
            return in(jdUid, values);
        }

        public JdShopCategoryExample.Criteria andJdUidNotIn(List<Long> values) {
            return notIn(jdUid, values);
        }

        public JdShopCategoryExample.Criteria andJdUidBetween(Long value1, Long value2) {
            return between(jdUid, value1, value2);
        }

        public JdShopCategoryExample.Criteria andJdUidNotBetween(Long value1, Long value2) {
            return notBetween(jdUid, value1, value2);
        }
        public JdShopCategoryExample.Criteria andOrderNoIsNull() {
            return isNull(orderNo);
        }

        public JdShopCategoryExample.Criteria andOrderNoIsNotNull() {
            return isNotNull(orderNo);
        }

        public JdShopCategoryExample.Criteria andOrderNoEqualTo(Integer value) {
            return equalTo(orderNo, value);
        }

        public JdShopCategoryExample.Criteria andOrderNoNotEqualTo(Integer value) {
            return notEqualTo(orderNo, value);
        }

        public JdShopCategoryExample.Criteria andOrderNoGreaterThan(Integer value) {
            return greaterThan(orderNo, value);
        }

        public JdShopCategoryExample.Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(orderNo, value);
        }

        public JdShopCategoryExample.Criteria andOrderNoLessThan(Integer value) {
            return lessThan(orderNo, value);
        }

        public JdShopCategoryExample.Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(orderNo, value);
        }

        public JdShopCategoryExample.Criteria andOrderNoIn(List<Integer> values) {
            return in(orderNo, values);
        }

        public JdShopCategoryExample.Criteria andOrderNoNotIn(List<Integer> values) {
            return notIn(orderNo, values);
        }

        public JdShopCategoryExample.Criteria andOrderNoBetween(Integer value1, Integer value2) {
            return between(orderNo, value1, value2);
        }

        public JdShopCategoryExample.Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            return notBetween(orderNo, value1, value2);
        }
        public JdShopCategoryExample.Criteria andIsOpenIsNull() {
            return isNull(isOpen);
        }

        public JdShopCategoryExample.Criteria andIsOpenIsNotNull() {
            return isNotNull(isOpen);
        }

        public JdShopCategoryExample.Criteria andIsOpenEqualTo(Boolean value) {
            return equalTo(isOpen, value);
        }

        public JdShopCategoryExample.Criteria andIsOpenNotEqualTo(Boolean value) {
            return notEqualTo(isOpen, value);
        }

        public JdShopCategoryExample.Criteria andIsOpenGreaterThan(Boolean value) {
            return greaterThan(isOpen, value);
        }

        public JdShopCategoryExample.Criteria andIsOpenGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isOpen, value);
        }

        public JdShopCategoryExample.Criteria andIsOpenLessThan(Boolean value) {
            return lessThan(isOpen, value);
        }

        public JdShopCategoryExample.Criteria andIsOpenLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isOpen, value);
        }

        public JdShopCategoryExample.Criteria andIsOpenIn(List<Boolean> values) {
            return in(isOpen, values);
        }

        public JdShopCategoryExample.Criteria andIsOpenNotIn(List<Boolean> values) {
            return notIn(isOpen, values);
        }

        public JdShopCategoryExample.Criteria andIsOpenBetween(Boolean value1, Boolean value2) {
            return between(isOpen, value1, value2);
        }

        public JdShopCategoryExample.Criteria andIsOpenNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isOpen, value1, value2);
        }
        public JdShopCategoryExample.Criteria andIsParentIsNull() {
            return isNull(isParent);
        }

        public JdShopCategoryExample.Criteria andIsParentIsNotNull() {
            return isNotNull(isParent);
        }

        public JdShopCategoryExample.Criteria andIsParentEqualTo(Boolean value) {
            return equalTo(isParent, value);
        }

        public JdShopCategoryExample.Criteria andIsParentNotEqualTo(Boolean value) {
            return notEqualTo(isParent, value);
        }

        public JdShopCategoryExample.Criteria andIsParentGreaterThan(Boolean value) {
            return greaterThan(isParent, value);
        }

        public JdShopCategoryExample.Criteria andIsParentGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isParent, value);
        }

        public JdShopCategoryExample.Criteria andIsParentLessThan(Boolean value) {
            return lessThan(isParent, value);
        }

        public JdShopCategoryExample.Criteria andIsParentLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isParent, value);
        }

        public JdShopCategoryExample.Criteria andIsParentIn(List<Boolean> values) {
            return in(isParent, values);
        }

        public JdShopCategoryExample.Criteria andIsParentNotIn(List<Boolean> values) {
            return notIn(isParent, values);
        }

        public JdShopCategoryExample.Criteria andIsParentBetween(Boolean value1, Boolean value2) {
            return between(isParent, value1, value2);
        }

        public JdShopCategoryExample.Criteria andIsParentNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isParent, value1, value2);
        }
        public JdShopCategoryExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public JdShopCategoryExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public JdShopCategoryExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public JdShopCategoryExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public JdShopCategoryExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public JdShopCategoryExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public JdShopCategoryExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public JdShopCategoryExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public JdShopCategoryExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public JdShopCategoryExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public JdShopCategoryExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public JdShopCategoryExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public JdShopCategoryExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public JdShopCategoryExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public JdShopCategoryExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public JdShopCategoryExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public JdShopCategoryExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public JdShopCategoryExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public JdShopCategoryExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public JdShopCategoryExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public JdShopCategoryExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public JdShopCategoryExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public JdShopCategoryExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public JdShopCategoryExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public JdShopCategoryExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public JdShopCategoryExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public JdShopCategoryExample.Criteria andIsHomeShowIsNull() {
            return isNull(isHomeShow);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowIsNotNull() {
            return isNotNull(isHomeShow);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowEqualTo(Boolean value) {
            return equalTo(isHomeShow, value);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowNotEqualTo(Boolean value) {
            return notEqualTo(isHomeShow, value);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowGreaterThan(Boolean value) {
            return greaterThan(isHomeShow, value);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(isHomeShow, value);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowLessThan(Boolean value) {
            return lessThan(isHomeShow, value);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(isHomeShow, value);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowIn(List<Boolean> values) {
            return in(isHomeShow, values);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowNotIn(List<Boolean> values) {
            return notIn(isHomeShow, values);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowBetween(Boolean value1, Boolean value2) {
            return between(isHomeShow, value1, value2);
        }

        public JdShopCategoryExample.Criteria andIsHomeShowNotBetween(Boolean value1, Boolean value2) {
            return notBetween(isHomeShow, value1, value2);
        }
        public JdShopCategoryExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public JdShopCategoryExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public JdShopCategoryExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public JdShopCategoryExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public JdShopCategoryExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public JdShopCategoryExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public JdShopCategoryExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public JdShopCategoryExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public JdShopCategoryExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public JdShopCategoryExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public JdShopCategoryExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public JdShopCategoryExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public JdShopCategoryExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public JdShopCategoryExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public JdShopCategoryExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public JdShopCategoryExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public JdShopCategoryExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public JdShopCategoryExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public JdShopCategoryExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public JdShopCategoryExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public JdShopCategoryExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public JdShopCategoryExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public JdShopCategoryExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public JdShopCategoryExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public JdShopCategoryExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public JdShopCategoryExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public JdShopCategoryExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public JdShopCategoryExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public JdShopCategoryExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public JdShopCategoryExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public JdShopCategoryExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public JdShopCategoryExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public JdShopCategoryExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public JdShopCategoryExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public JdShopCategoryExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public JdShopCategoryExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public JdShopCategoryExample.Criteria andParentIdIsNull() {
            return isNull(parentId);
        }

        public JdShopCategoryExample.Criteria andParentIdIsNotNull() {
            return isNotNull(parentId);
        }

        public JdShopCategoryExample.Criteria andParentIdEqualTo(Long value) {
            return equalTo(parentId, value);
        }

        public JdShopCategoryExample.Criteria andParentIdNotEqualTo(Long value) {
            return notEqualTo(parentId, value);
        }

        public JdShopCategoryExample.Criteria andParentIdGreaterThan(Long value) {
            return greaterThan(parentId, value);
        }

        public JdShopCategoryExample.Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentId, value);
        }

        public JdShopCategoryExample.Criteria andParentIdLessThan(Long value) {
            return lessThan(parentId, value);
        }

        public JdShopCategoryExample.Criteria andParentIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentId, value);
        }

        public JdShopCategoryExample.Criteria andParentIdIn(List<Long> values) {
            return in(parentId, values);
        }

        public JdShopCategoryExample.Criteria andParentIdNotIn(List<Long> values) {
            return notIn(parentId, values);
        }

        public JdShopCategoryExample.Criteria andParentIdBetween(Long value1, Long value2) {
            return between(parentId, value1, value2);
        }

        public JdShopCategoryExample.Criteria andParentIdNotBetween(Long value1, Long value2) {
            return notBetween(parentId, value1, value2);
        }
        public JdShopCategoryExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public JdShopCategoryExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public JdShopCategoryExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public JdShopCategoryExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public JdShopCategoryExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public JdShopCategoryExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public JdShopCategoryExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public JdShopCategoryExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public JdShopCategoryExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public JdShopCategoryExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public JdShopCategoryExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public JdShopCategoryExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}