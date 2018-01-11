package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TaobaoItemProp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaobaoItemPropExample extends SgExample<TaobaoItemPropExample.Criteria> {
    public static final Class<TaobaoItemProp> beanClass = TaobaoItemProp.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn isItemProp;
    public static EntityColumn isEnumProp;
    public static EntityColumn childTemplate;
    public static EntityColumn isSaleProp;
    public static EntityColumn pid;
    public static EntityColumn isKeyProp;
    public static EntityColumn multi;
    public static EntityColumn isColorProp;
    public static EntityColumn isAllowAlias;
    public static EntityColumn parentVid;
    public static EntityColumn tipid;
    public static EntityColumn parentPid;
    public static EntityColumn remark9;
    public static EntityColumn remark8;
    public static EntityColumn sortOrder;
    public static EntityColumn name;
    public static EntityColumn remark10;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn isInputProp;
    public static EntityColumn must;
    public static EntityColumn remark7;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn status;
    public static EntityColumn cid;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        isItemProp = listMap.get("isItemProp");
        isEnumProp = listMap.get("isEnumProp");
        childTemplate = listMap.get("childTemplate");
        isSaleProp = listMap.get("isSaleProp");
        pid = listMap.get("pid");
        isKeyProp = listMap.get("isKeyProp");
        multi = listMap.get("multi");
        isColorProp = listMap.get("isColorProp");
        isAllowAlias = listMap.get("isAllowAlias");
        parentVid = listMap.get("parentVid");
        tipid = listMap.get("tipid");
        parentPid = listMap.get("parentPid");
        remark9 = listMap.get("remark9");
        remark8 = listMap.get("remark8");
        sortOrder = listMap.get("sortOrder");
        name = listMap.get("name");
        remark10 = listMap.get("remark10");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        isInputProp = listMap.get("isInputProp");
        must = listMap.get("must");
        remark7 = listMap.get("remark7");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        status = listMap.get("status");
        cid = listMap.get("cid");
        remark2 = listMap.get("remark2");
        }

    public TaobaoItemPropExample() {
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

        public Criteria andIsItemPropIsNull() {
            return isNull(isItemProp);
        }

        public Criteria andIsItemPropIsNotNull() {
            return isNotNull(isItemProp);
        }

        public Criteria andIsItemPropEqualTo(Integer value) {
            return equalTo(isItemProp, value);
        }

        public Criteria andIsItemPropNotEqualTo(Integer value) {
            return notEqualTo(isItemProp, value);
        }

        public Criteria andIsItemPropGreaterThan(Integer value) {
            return greaterThan(isItemProp, value);
        }

        public Criteria andIsItemPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isItemProp, value);
        }

        public Criteria andIsItemPropLessThan(Integer value) {
            return lessThan(isItemProp, value);
        }

        public Criteria andIsItemPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isItemProp, value);
        }

        public Criteria andIsItemPropIn(List<Integer> values) {
            return in(isItemProp, values);
        }

        public Criteria andIsItemPropNotIn(List<Integer> values) {
            return notIn(isItemProp, values);
        }

        public Criteria andIsItemPropBetween(Integer value1, Integer value2) {
            return between(isItemProp, value1, value2);
        }

        public Criteria andIsItemPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isItemProp, value1, value2);
        }
        public Criteria andIsEnumPropIsNull() {
            return isNull(isEnumProp);
        }

        public Criteria andIsEnumPropIsNotNull() {
            return isNotNull(isEnumProp);
        }

        public Criteria andIsEnumPropEqualTo(Integer value) {
            return equalTo(isEnumProp, value);
        }

        public Criteria andIsEnumPropNotEqualTo(Integer value) {
            return notEqualTo(isEnumProp, value);
        }

        public Criteria andIsEnumPropGreaterThan(Integer value) {
            return greaterThan(isEnumProp, value);
        }

        public Criteria andIsEnumPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isEnumProp, value);
        }

        public Criteria andIsEnumPropLessThan(Integer value) {
            return lessThan(isEnumProp, value);
        }

        public Criteria andIsEnumPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isEnumProp, value);
        }

        public Criteria andIsEnumPropIn(List<Integer> values) {
            return in(isEnumProp, values);
        }

        public Criteria andIsEnumPropNotIn(List<Integer> values) {
            return notIn(isEnumProp, values);
        }

        public Criteria andIsEnumPropBetween(Integer value1, Integer value2) {
            return between(isEnumProp, value1, value2);
        }

        public Criteria andIsEnumPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isEnumProp, value1, value2);
        }
        public Criteria andChildTemplateIsNull() {
            return isNull(childTemplate);
        }

        public Criteria andChildTemplateIsNotNull() {
            return isNotNull(childTemplate);
        }

        public Criteria andChildTemplateEqualTo(String value) {
            return equalTo(childTemplate, value);
        }

        public Criteria andChildTemplateNotEqualTo(String value) {
            return notEqualTo(childTemplate, value);
        }

        public Criteria andChildTemplateGreaterThan(String value) {
            return greaterThan(childTemplate, value);
        }

        public Criteria andChildTemplateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(childTemplate, value);
        }

        public Criteria andChildTemplateLessThan(String value) {
            return lessThan(childTemplate, value);
        }

        public Criteria andChildTemplateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(childTemplate, value);
        }

        public Criteria andChildTemplateLike(String value) {
            return like(childTemplate, value);
        }

        public Criteria andChildTemplateNotLike(String value) {
            return notLike(childTemplate, value);
        }

        public Criteria andChildTemplateIn(List<String> values) {
            return in(childTemplate, values);
        }

        public Criteria andChildTemplateNotIn(List<String> values) {
            return notIn(childTemplate, values);
        }

        public Criteria andChildTemplateBetween(String value1, String value2) {
            return between(childTemplate, value1, value2);
        }

        public Criteria andChildTemplateNotBetween(String value1, String value2) {
            return notBetween(childTemplate, value1, value2);
        }
        public Criteria andIsSalePropIsNull() {
            return isNull(isSaleProp);
        }

        public Criteria andIsSalePropIsNotNull() {
            return isNotNull(isSaleProp);
        }

        public Criteria andIsSalePropEqualTo(Integer value) {
            return equalTo(isSaleProp, value);
        }

        public Criteria andIsSalePropNotEqualTo(Integer value) {
            return notEqualTo(isSaleProp, value);
        }

        public Criteria andIsSalePropGreaterThan(Integer value) {
            return greaterThan(isSaleProp, value);
        }

        public Criteria andIsSalePropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isSaleProp, value);
        }

        public Criteria andIsSalePropLessThan(Integer value) {
            return lessThan(isSaleProp, value);
        }

        public Criteria andIsSalePropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isSaleProp, value);
        }

        public Criteria andIsSalePropIn(List<Integer> values) {
            return in(isSaleProp, values);
        }

        public Criteria andIsSalePropNotIn(List<Integer> values) {
            return notIn(isSaleProp, values);
        }

        public Criteria andIsSalePropBetween(Integer value1, Integer value2) {
            return between(isSaleProp, value1, value2);
        }

        public Criteria andIsSalePropNotBetween(Integer value1, Integer value2) {
            return notBetween(isSaleProp, value1, value2);
        }
        public Criteria andPidIsNull() {
            return isNull(pid);
        }

        public Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public Criteria andIsKeyPropIsNull() {
            return isNull(isKeyProp);
        }

        public Criteria andIsKeyPropIsNotNull() {
            return isNotNull(isKeyProp);
        }

        public Criteria andIsKeyPropEqualTo(Integer value) {
            return equalTo(isKeyProp, value);
        }

        public Criteria andIsKeyPropNotEqualTo(Integer value) {
            return notEqualTo(isKeyProp, value);
        }

        public Criteria andIsKeyPropGreaterThan(Integer value) {
            return greaterThan(isKeyProp, value);
        }

        public Criteria andIsKeyPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isKeyProp, value);
        }

        public Criteria andIsKeyPropLessThan(Integer value) {
            return lessThan(isKeyProp, value);
        }

        public Criteria andIsKeyPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isKeyProp, value);
        }

        public Criteria andIsKeyPropIn(List<Integer> values) {
            return in(isKeyProp, values);
        }

        public Criteria andIsKeyPropNotIn(List<Integer> values) {
            return notIn(isKeyProp, values);
        }

        public Criteria andIsKeyPropBetween(Integer value1, Integer value2) {
            return between(isKeyProp, value1, value2);
        }

        public Criteria andIsKeyPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isKeyProp, value1, value2);
        }
        public Criteria andMultiIsNull() {
            return isNull(multi);
        }

        public Criteria andMultiIsNotNull() {
            return isNotNull(multi);
        }

        public Criteria andMultiEqualTo(Integer value) {
            return equalTo(multi, value);
        }

        public Criteria andMultiNotEqualTo(Integer value) {
            return notEqualTo(multi, value);
        }

        public Criteria andMultiGreaterThan(Integer value) {
            return greaterThan(multi, value);
        }

        public Criteria andMultiGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(multi, value);
        }

        public Criteria andMultiLessThan(Integer value) {
            return lessThan(multi, value);
        }

        public Criteria andMultiLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(multi, value);
        }

        public Criteria andMultiIn(List<Integer> values) {
            return in(multi, values);
        }

        public Criteria andMultiNotIn(List<Integer> values) {
            return notIn(multi, values);
        }

        public Criteria andMultiBetween(Integer value1, Integer value2) {
            return between(multi, value1, value2);
        }

        public Criteria andMultiNotBetween(Integer value1, Integer value2) {
            return notBetween(multi, value1, value2);
        }
        public Criteria andIsColorPropIsNull() {
            return isNull(isColorProp);
        }

        public Criteria andIsColorPropIsNotNull() {
            return isNotNull(isColorProp);
        }

        public Criteria andIsColorPropEqualTo(Integer value) {
            return equalTo(isColorProp, value);
        }

        public Criteria andIsColorPropNotEqualTo(Integer value) {
            return notEqualTo(isColorProp, value);
        }

        public Criteria andIsColorPropGreaterThan(Integer value) {
            return greaterThan(isColorProp, value);
        }

        public Criteria andIsColorPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isColorProp, value);
        }

        public Criteria andIsColorPropLessThan(Integer value) {
            return lessThan(isColorProp, value);
        }

        public Criteria andIsColorPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isColorProp, value);
        }

        public Criteria andIsColorPropIn(List<Integer> values) {
            return in(isColorProp, values);
        }

        public Criteria andIsColorPropNotIn(List<Integer> values) {
            return notIn(isColorProp, values);
        }

        public Criteria andIsColorPropBetween(Integer value1, Integer value2) {
            return between(isColorProp, value1, value2);
        }

        public Criteria andIsColorPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isColorProp, value1, value2);
        }
        public Criteria andIsAllowAliasIsNull() {
            return isNull(isAllowAlias);
        }

        public Criteria andIsAllowAliasIsNotNull() {
            return isNotNull(isAllowAlias);
        }

        public Criteria andIsAllowAliasEqualTo(Integer value) {
            return equalTo(isAllowAlias, value);
        }

        public Criteria andIsAllowAliasNotEqualTo(Integer value) {
            return notEqualTo(isAllowAlias, value);
        }

        public Criteria andIsAllowAliasGreaterThan(Integer value) {
            return greaterThan(isAllowAlias, value);
        }

        public Criteria andIsAllowAliasGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isAllowAlias, value);
        }

        public Criteria andIsAllowAliasLessThan(Integer value) {
            return lessThan(isAllowAlias, value);
        }

        public Criteria andIsAllowAliasLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isAllowAlias, value);
        }

        public Criteria andIsAllowAliasIn(List<Integer> values) {
            return in(isAllowAlias, values);
        }

        public Criteria andIsAllowAliasNotIn(List<Integer> values) {
            return notIn(isAllowAlias, values);
        }

        public Criteria andIsAllowAliasBetween(Integer value1, Integer value2) {
            return between(isAllowAlias, value1, value2);
        }

        public Criteria andIsAllowAliasNotBetween(Integer value1, Integer value2) {
            return notBetween(isAllowAlias, value1, value2);
        }
        public Criteria andParentVidIsNull() {
            return isNull(parentVid);
        }

        public Criteria andParentVidIsNotNull() {
            return isNotNull(parentVid);
        }

        public Criteria andParentVidEqualTo(Long value) {
            return equalTo(parentVid, value);
        }

        public Criteria andParentVidNotEqualTo(Long value) {
            return notEqualTo(parentVid, value);
        }

        public Criteria andParentVidGreaterThan(Long value) {
            return greaterThan(parentVid, value);
        }

        public Criteria andParentVidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentVid, value);
        }

        public Criteria andParentVidLessThan(Long value) {
            return lessThan(parentVid, value);
        }

        public Criteria andParentVidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentVid, value);
        }

        public Criteria andParentVidIn(List<Long> values) {
            return in(parentVid, values);
        }

        public Criteria andParentVidNotIn(List<Long> values) {
            return notIn(parentVid, values);
        }

        public Criteria andParentVidBetween(Long value1, Long value2) {
            return between(parentVid, value1, value2);
        }

        public Criteria andParentVidNotBetween(Long value1, Long value2) {
            return notBetween(parentVid, value1, value2);
        }
        public Criteria andTipidIsNull() {
            return isNull(tipid);
        }

        public Criteria andTipidIsNotNull() {
            return isNotNull(tipid);
        }

        public Criteria andTipidEqualTo(Long value) {
            return equalTo(tipid, value);
        }

        public Criteria andTipidNotEqualTo(Long value) {
            return notEqualTo(tipid, value);
        }

        public Criteria andTipidGreaterThan(Long value) {
            return greaterThan(tipid, value);
        }

        public Criteria andTipidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(tipid, value);
        }

        public Criteria andTipidLessThan(Long value) {
            return lessThan(tipid, value);
        }

        public Criteria andTipidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(tipid, value);
        }

        public Criteria andTipidIn(List<Long> values) {
            return in(tipid, values);
        }

        public Criteria andTipidNotIn(List<Long> values) {
            return notIn(tipid, values);
        }

        public Criteria andTipidBetween(Long value1, Long value2) {
            return between(tipid, value1, value2);
        }

        public Criteria andTipidNotBetween(Long value1, Long value2) {
            return notBetween(tipid, value1, value2);
        }
        public Criteria andParentPidIsNull() {
            return isNull(parentPid);
        }

        public Criteria andParentPidIsNotNull() {
            return isNotNull(parentPid);
        }

        public Criteria andParentPidEqualTo(Long value) {
            return equalTo(parentPid, value);
        }

        public Criteria andParentPidNotEqualTo(Long value) {
            return notEqualTo(parentPid, value);
        }

        public Criteria andParentPidGreaterThan(Long value) {
            return greaterThan(parentPid, value);
        }

        public Criteria andParentPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentPid, value);
        }

        public Criteria andParentPidLessThan(Long value) {
            return lessThan(parentPid, value);
        }

        public Criteria andParentPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentPid, value);
        }

        public Criteria andParentPidIn(List<Long> values) {
            return in(parentPid, values);
        }

        public Criteria andParentPidNotIn(List<Long> values) {
            return notIn(parentPid, values);
        }

        public Criteria andParentPidBetween(Long value1, Long value2) {
            return between(parentPid, value1, value2);
        }

        public Criteria andParentPidNotBetween(Long value1, Long value2) {
            return notBetween(parentPid, value1, value2);
        }
        public Criteria andRemark9IsNull() {
            return isNull(remark9);
        }

        public Criteria andRemark9IsNotNull() {
            return isNotNull(remark9);
        }

        public Criteria andRemark9EqualTo(String value) {
            return equalTo(remark9, value);
        }

        public Criteria andRemark9NotEqualTo(String value) {
            return notEqualTo(remark9, value);
        }

        public Criteria andRemark9GreaterThan(String value) {
            return greaterThan(remark9, value);
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9LessThan(String value) {
            return lessThan(remark9, value);
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark9, value);
        }

        public Criteria andRemark9Like(String value) {
            return like(remark9, value);
        }

        public Criteria andRemark9NotLike(String value) {
            return notLike(remark9, value);
        }

        public Criteria andRemark9In(List<String> values) {
            return in(remark9, values);
        }

        public Criteria andRemark9NotIn(List<String> values) {
            return notIn(remark9, values);
        }

        public Criteria andRemark9Between(String value1, String value2) {
            return between(remark9, value1, value2);
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            return notBetween(remark9, value1, value2);
        }
        public Criteria andRemark8IsNull() {
            return isNull(remark8);
        }

        public Criteria andRemark8IsNotNull() {
            return isNotNull(remark8);
        }

        public Criteria andRemark8EqualTo(String value) {
            return equalTo(remark8, value);
        }

        public Criteria andRemark8NotEqualTo(String value) {
            return notEqualTo(remark8, value);
        }

        public Criteria andRemark8GreaterThan(String value) {
            return greaterThan(remark8, value);
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8LessThan(String value) {
            return lessThan(remark8, value);
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark8, value);
        }

        public Criteria andRemark8Like(String value) {
            return like(remark8, value);
        }

        public Criteria andRemark8NotLike(String value) {
            return notLike(remark8, value);
        }

        public Criteria andRemark8In(List<String> values) {
            return in(remark8, values);
        }

        public Criteria andRemark8NotIn(List<String> values) {
            return notIn(remark8, values);
        }

        public Criteria andRemark8Between(String value1, String value2) {
            return between(remark8, value1, value2);
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            return notBetween(remark8, value1, value2);
        }
        public Criteria andSortOrderIsNull() {
            return isNull(sortOrder);
        }

        public Criteria andSortOrderIsNotNull() {
            return isNotNull(sortOrder);
        }

        public Criteria andSortOrderEqualTo(Long value) {
            return equalTo(sortOrder, value);
        }

        public Criteria andSortOrderNotEqualTo(Long value) {
            return notEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderGreaterThan(Long value) {
            return greaterThan(sortOrder, value);
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderLessThan(Long value) {
            return lessThan(sortOrder, value);
        }

        public Criteria andSortOrderLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sortOrder, value);
        }

        public Criteria andSortOrderIn(List<Long> values) {
            return in(sortOrder, values);
        }

        public Criteria andSortOrderNotIn(List<Long> values) {
            return notIn(sortOrder, values);
        }

        public Criteria andSortOrderBetween(Long value1, Long value2) {
            return between(sortOrder, value1, value2);
        }

        public Criteria andSortOrderNotBetween(Long value1, Long value2) {
            return notBetween(sortOrder, value1, value2);
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
        public Criteria andRemark10IsNull() {
            return isNull(remark10);
        }

        public Criteria andRemark10IsNotNull() {
            return isNotNull(remark10);
        }

        public Criteria andRemark10EqualTo(String value) {
            return equalTo(remark10, value);
        }

        public Criteria andRemark10NotEqualTo(String value) {
            return notEqualTo(remark10, value);
        }

        public Criteria andRemark10GreaterThan(String value) {
            return greaterThan(remark10, value);
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10LessThan(String value) {
            return lessThan(remark10, value);
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark10, value);
        }

        public Criteria andRemark10Like(String value) {
            return like(remark10, value);
        }

        public Criteria andRemark10NotLike(String value) {
            return notLike(remark10, value);
        }

        public Criteria andRemark10In(List<String> values) {
            return in(remark10, values);
        }

        public Criteria andRemark10NotIn(List<String> values) {
            return notIn(remark10, values);
        }

        public Criteria andRemark10Between(String value1, String value2) {
            return between(remark10, value1, value2);
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            return notBetween(remark10, value1, value2);
        }
        public Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public Criteria andIsInputPropIsNull() {
            return isNull(isInputProp);
        }

        public Criteria andIsInputPropIsNotNull() {
            return isNotNull(isInputProp);
        }

        public Criteria andIsInputPropEqualTo(Integer value) {
            return equalTo(isInputProp, value);
        }

        public Criteria andIsInputPropNotEqualTo(Integer value) {
            return notEqualTo(isInputProp, value);
        }

        public Criteria andIsInputPropGreaterThan(Integer value) {
            return greaterThan(isInputProp, value);
        }

        public Criteria andIsInputPropGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isInputProp, value);
        }

        public Criteria andIsInputPropLessThan(Integer value) {
            return lessThan(isInputProp, value);
        }

        public Criteria andIsInputPropLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isInputProp, value);
        }

        public Criteria andIsInputPropIn(List<Integer> values) {
            return in(isInputProp, values);
        }

        public Criteria andIsInputPropNotIn(List<Integer> values) {
            return notIn(isInputProp, values);
        }

        public Criteria andIsInputPropBetween(Integer value1, Integer value2) {
            return between(isInputProp, value1, value2);
        }

        public Criteria andIsInputPropNotBetween(Integer value1, Integer value2) {
            return notBetween(isInputProp, value1, value2);
        }
        public Criteria andMustIsNull() {
            return isNull(must);
        }

        public Criteria andMustIsNotNull() {
            return isNotNull(must);
        }

        public Criteria andMustEqualTo(Integer value) {
            return equalTo(must, value);
        }

        public Criteria andMustNotEqualTo(Integer value) {
            return notEqualTo(must, value);
        }

        public Criteria andMustGreaterThan(Integer value) {
            return greaterThan(must, value);
        }

        public Criteria andMustGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(must, value);
        }

        public Criteria andMustLessThan(Integer value) {
            return lessThan(must, value);
        }

        public Criteria andMustLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(must, value);
        }

        public Criteria andMustIn(List<Integer> values) {
            return in(must, values);
        }

        public Criteria andMustNotIn(List<Integer> values) {
            return notIn(must, values);
        }

        public Criteria andMustBetween(Integer value1, Integer value2) {
            return between(must, value1, value2);
        }

        public Criteria andMustNotBetween(Integer value1, Integer value2) {
            return notBetween(must, value1, value2);
        }
        public Criteria andRemark7IsNull() {
            return isNull(remark7);
        }

        public Criteria andRemark7IsNotNull() {
            return isNotNull(remark7);
        }

        public Criteria andRemark7EqualTo(String value) {
            return equalTo(remark7, value);
        }

        public Criteria andRemark7NotEqualTo(String value) {
            return notEqualTo(remark7, value);
        }

        public Criteria andRemark7GreaterThan(String value) {
            return greaterThan(remark7, value);
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7LessThan(String value) {
            return lessThan(remark7, value);
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark7, value);
        }

        public Criteria andRemark7Like(String value) {
            return like(remark7, value);
        }

        public Criteria andRemark7NotLike(String value) {
            return notLike(remark7, value);
        }

        public Criteria andRemark7In(List<String> values) {
            return in(remark7, values);
        }

        public Criteria andRemark7NotIn(List<String> values) {
            return notIn(remark7, values);
        }

        public Criteria andRemark7Between(String value1, String value2) {
            return between(remark7, value1, value2);
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            return notBetween(remark7, value1, value2);
        }
        public Criteria andRemark6IsNull() {
            return isNull(remark6);
        }

        public Criteria andRemark6IsNotNull() {
            return isNotNull(remark6);
        }

        public Criteria andRemark6EqualTo(String value) {
            return equalTo(remark6, value);
        }

        public Criteria andRemark6NotEqualTo(String value) {
            return notEqualTo(remark6, value);
        }

        public Criteria andRemark6GreaterThan(String value) {
            return greaterThan(remark6, value);
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6LessThan(String value) {
            return lessThan(remark6, value);
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark6, value);
        }

        public Criteria andRemark6Like(String value) {
            return like(remark6, value);
        }

        public Criteria andRemark6NotLike(String value) {
            return notLike(remark6, value);
        }

        public Criteria andRemark6In(List<String> values) {
            return in(remark6, values);
        }

        public Criteria andRemark6NotIn(List<String> values) {
            return notIn(remark6, values);
        }

        public Criteria andRemark6Between(String value1, String value2) {
            return between(remark6, value1, value2);
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            return notBetween(remark6, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public Criteria andStatusIsNull() {
            return isNull(status);
        }

        public Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public Criteria andStatusEqualTo(String value) {
            return equalTo(status, value);
        }

        public Criteria andStatusNotEqualTo(String value) {
            return notEqualTo(status, value);
        }

        public Criteria andStatusGreaterThan(String value) {
            return greaterThan(status, value);
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(status, value);
        }

        public Criteria andStatusLessThan(String value) {
            return lessThan(status, value);
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(status, value);
        }

        public Criteria andStatusLike(String value) {
            return like(status, value);
        }

        public Criteria andStatusNotLike(String value) {
            return notLike(status, value);
        }

        public Criteria andStatusIn(List<String> values) {
            return in(status, values);
        }

        public Criteria andStatusNotIn(List<String> values) {
            return notIn(status, values);
        }

        public Criteria andStatusBetween(String value1, String value2) {
            return between(status, value1, value2);
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            return notBetween(status, value1, value2);
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
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}