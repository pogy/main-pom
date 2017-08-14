package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguStoreUsercat;

import java.util.*;
public class ShiguStoreUsercatExample extends SgExample<ShiguStoreUsercatExample.Criteria> {
    public static final Class<ShiguStoreUsercat> beanClass = ShiguStoreUsercat.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn showName;
    public static EntityColumn created;
    public static EntityColumn useCatId;
    public static EntityColumn cname;
    public static EntityColumn storeId;
    public static EntityColumn allcids;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        showName = listMap.get("showName");
        created = listMap.get("created");
        useCatId = listMap.get("useCatId");
        cname = listMap.get("cname");
        storeId = listMap.get("storeId");
        allcids = listMap.get("allcids");
        cid = listMap.get("cid");
        }

    public ShiguStoreUsercatExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguStoreUsercatExample.Criteria createCriteriaInternal() {
        return new ShiguStoreUsercatExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameIsNull() {
            return isNull(showName);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameIsNotNull() {
            return isNotNull(showName);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameEqualTo(String value) {
            return equalTo(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotEqualTo(String value) {
            return notEqualTo(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameGreaterThan(String value) {
            return greaterThan(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameLessThan(String value) {
            return lessThan(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameLike(String value) {
            return like(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotLike(String value) {
            return notLike(showName, value);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameIn(List<String> values) {
            return in(showName, values);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotIn(List<String> values) {
            return notIn(showName, values);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameBetween(String value1, String value2) {
            return between(showName, value1, value2);
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotBetween(String value1, String value2) {
            return notBetween(showName, value1, value2);
        }
        public ShiguStoreUsercatExample.Criteria andCreatedIsNull() {
            return isNull(created);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedIsNotNull() {
            return isNotNull(created);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedEqualTo(Date value) {
            return equalTo(created, value);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedNotEqualTo(Date value) {
            return notEqualTo(created, value);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedGreaterThan(Date value) {
            return greaterThan(created, value);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(created, value);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedLessThan(Date value) {
            return lessThan(created, value);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(created, value);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedIn(List<Date> values) {
            return in(created, values);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedNotIn(List<Date> values) {
            return notIn(created, values);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedBetween(Date value1, Date value2) {
            return between(created, value1, value2);
        }

        public ShiguStoreUsercatExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            return notBetween(created, value1, value2);
        }
        public ShiguStoreUsercatExample.Criteria andUseCatIdIsNull() {
            return isNull(useCatId);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdIsNotNull() {
            return isNotNull(useCatId);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdEqualTo(Long value) {
            return equalTo(useCatId, value);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdNotEqualTo(Long value) {
            return notEqualTo(useCatId, value);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdGreaterThan(Long value) {
            return greaterThan(useCatId, value);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(useCatId, value);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdLessThan(Long value) {
            return lessThan(useCatId, value);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(useCatId, value);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdIn(List<Long> values) {
            return in(useCatId, values);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdNotIn(List<Long> values) {
            return notIn(useCatId, values);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdBetween(Long value1, Long value2) {
            return between(useCatId, value1, value2);
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdNotBetween(Long value1, Long value2) {
            return notBetween(useCatId, value1, value2);
        }
        public ShiguStoreUsercatExample.Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public ShiguStoreUsercatExample.Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public ShiguStoreUsercatExample.Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public ShiguStoreUsercatExample.Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public ShiguStoreUsercatExample.Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public ShiguStoreUsercatExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguStoreUsercatExample.Criteria andAllcidsIsNull() {
            return isNull(allcids);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsIsNotNull() {
            return isNotNull(allcids);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsEqualTo(String value) {
            return equalTo(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotEqualTo(String value) {
            return notEqualTo(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsGreaterThan(String value) {
            return greaterThan(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsLessThan(String value) {
            return lessThan(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsLike(String value) {
            return like(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotLike(String value) {
            return notLike(allcids, value);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsIn(List<String> values) {
            return in(allcids, values);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotIn(List<String> values) {
            return notIn(allcids, values);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsBetween(String value1, String value2) {
            return between(allcids, value1, value2);
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotBetween(String value1, String value2) {
            return notBetween(allcids, value1, value2);
        }
        public ShiguStoreUsercatExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguStoreUsercatExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguStoreUsercatExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguStoreUsercatExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguStoreUsercatExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguStoreUsercatExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguStoreUsercatExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguStoreUsercatExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguStoreUsercatExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguStoreUsercatExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguStoreUsercatExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguStoreUsercatExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}
