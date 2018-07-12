package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.VirtualFlow;

import java.util.*;
public class VirtualFlowExample extends SgExample<VirtualFlowExample.Criteria> {
    public static final Class<VirtualFlow> beanClass = VirtualFlow.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gmtModif;
    public static EntityColumn virtualUploadNum;
    public static EntityColumn virtualClicks;
    public static EntityColumn clicksScale;
    public static EntityColumn goodsId;
    public static EntityColumn gmtCreate;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gmtModif = listMap.get("gmtModif");
        virtualUploadNum = listMap.get("virtualUploadNum");
        virtualClicks = listMap.get("virtualClicks");
        clicksScale = listMap.get("clicksScale");
        goodsId = listMap.get("goodsId");
        gmtCreate = listMap.get("gmtCreate");
        }

    public VirtualFlowExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected VirtualFlowExample.Criteria createCriteriaInternal() {
        return new VirtualFlowExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public VirtualFlowExample.Criteria andGmtModifIsNull() {
            return isNull(gmtModif);
        }

        public VirtualFlowExample.Criteria andGmtModifIsNotNull() {
            return isNotNull(gmtModif);
        }

        public VirtualFlowExample.Criteria andGmtModifEqualTo(Date value) {
            return equalTo(gmtModif, value);
        }

        public VirtualFlowExample.Criteria andGmtModifNotEqualTo(Date value) {
            return notEqualTo(gmtModif, value);
        }

        public VirtualFlowExample.Criteria andGmtModifGreaterThan(Date value) {
            return greaterThan(gmtModif, value);
        }

        public VirtualFlowExample.Criteria andGmtModifGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModif, value);
        }

        public VirtualFlowExample.Criteria andGmtModifLessThan(Date value) {
            return lessThan(gmtModif, value);
        }

        public VirtualFlowExample.Criteria andGmtModifLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModif, value);
        }

        public VirtualFlowExample.Criteria andGmtModifIn(List<Date> values) {
            return in(gmtModif, values);
        }

        public VirtualFlowExample.Criteria andGmtModifNotIn(List<Date> values) {
            return notIn(gmtModif, values);
        }

        public VirtualFlowExample.Criteria andGmtModifBetween(Date value1, Date value2) {
            return between(gmtModif, value1, value2);
        }

        public VirtualFlowExample.Criteria andGmtModifNotBetween(Date value1, Date value2) {
            return notBetween(gmtModif, value1, value2);
        }
        public VirtualFlowExample.Criteria andVirtualUploadNumIsNull() {
            return isNull(virtualUploadNum);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumIsNotNull() {
            return isNotNull(virtualUploadNum);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumEqualTo(Long value) {
            return equalTo(virtualUploadNum, value);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumNotEqualTo(Long value) {
            return notEqualTo(virtualUploadNum, value);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumGreaterThan(Long value) {
            return greaterThan(virtualUploadNum, value);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(virtualUploadNum, value);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumLessThan(Long value) {
            return lessThan(virtualUploadNum, value);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(virtualUploadNum, value);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumIn(List<Long> values) {
            return in(virtualUploadNum, values);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumNotIn(List<Long> values) {
            return notIn(virtualUploadNum, values);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumBetween(Long value1, Long value2) {
            return between(virtualUploadNum, value1, value2);
        }

        public VirtualFlowExample.Criteria andVirtualUploadNumNotBetween(Long value1, Long value2) {
            return notBetween(virtualUploadNum, value1, value2);
        }
        public VirtualFlowExample.Criteria andVirtualClicksIsNull() {
            return isNull(virtualClicks);
        }

        public VirtualFlowExample.Criteria andVirtualClicksIsNotNull() {
            return isNotNull(virtualClicks);
        }

        public VirtualFlowExample.Criteria andVirtualClicksEqualTo(Long value) {
            return equalTo(virtualClicks, value);
        }

        public VirtualFlowExample.Criteria andVirtualClicksNotEqualTo(Long value) {
            return notEqualTo(virtualClicks, value);
        }

        public VirtualFlowExample.Criteria andVirtualClicksGreaterThan(Long value) {
            return greaterThan(virtualClicks, value);
        }

        public VirtualFlowExample.Criteria andVirtualClicksGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(virtualClicks, value);
        }

        public VirtualFlowExample.Criteria andVirtualClicksLessThan(Long value) {
            return lessThan(virtualClicks, value);
        }

        public VirtualFlowExample.Criteria andVirtualClicksLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(virtualClicks, value);
        }

        public VirtualFlowExample.Criteria andVirtualClicksIn(List<Long> values) {
            return in(virtualClicks, values);
        }

        public VirtualFlowExample.Criteria andVirtualClicksNotIn(List<Long> values) {
            return notIn(virtualClicks, values);
        }

        public VirtualFlowExample.Criteria andVirtualClicksBetween(Long value1, Long value2) {
            return between(virtualClicks, value1, value2);
        }

        public VirtualFlowExample.Criteria andVirtualClicksNotBetween(Long value1, Long value2) {
            return notBetween(virtualClicks, value1, value2);
        }
        public VirtualFlowExample.Criteria andClicksScaleIsNull() {
            return isNull(clicksScale);
        }

        public VirtualFlowExample.Criteria andClicksScaleIsNotNull() {
            return isNotNull(clicksScale);
        }

        public VirtualFlowExample.Criteria andClicksScaleEqualTo(Long value) {
            return equalTo(clicksScale, value);
        }

        public VirtualFlowExample.Criteria andClicksScaleNotEqualTo(Long value) {
            return notEqualTo(clicksScale, value);
        }

        public VirtualFlowExample.Criteria andClicksScaleGreaterThan(Long value) {
            return greaterThan(clicksScale, value);
        }

        public VirtualFlowExample.Criteria andClicksScaleGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(clicksScale, value);
        }

        public VirtualFlowExample.Criteria andClicksScaleLessThan(Long value) {
            return lessThan(clicksScale, value);
        }

        public VirtualFlowExample.Criteria andClicksScaleLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(clicksScale, value);
        }

        public VirtualFlowExample.Criteria andClicksScaleIn(List<Long> values) {
            return in(clicksScale, values);
        }

        public VirtualFlowExample.Criteria andClicksScaleNotIn(List<Long> values) {
            return notIn(clicksScale, values);
        }

        public VirtualFlowExample.Criteria andClicksScaleBetween(Long value1, Long value2) {
            return between(clicksScale, value1, value2);
        }

        public VirtualFlowExample.Criteria andClicksScaleNotBetween(Long value1, Long value2) {
            return notBetween(clicksScale, value1, value2);
        }
        public VirtualFlowExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public VirtualFlowExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public VirtualFlowExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public VirtualFlowExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public VirtualFlowExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public VirtualFlowExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public VirtualFlowExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public VirtualFlowExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public VirtualFlowExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public VirtualFlowExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public VirtualFlowExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public VirtualFlowExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public VirtualFlowExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public VirtualFlowExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public VirtualFlowExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public VirtualFlowExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public VirtualFlowExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public VirtualFlowExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public VirtualFlowExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public VirtualFlowExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public VirtualFlowExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public VirtualFlowExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public VirtualFlowExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public VirtualFlowExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
    }
}