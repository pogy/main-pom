package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsExtends;

import java.util.*;

public class ShiguGoodsExtendsExample extends SgExample<ShiguGoodsExtendsExample.Criteria> {
    public static final Class<ShiguGoodsExtends> beanClass = ShiguGoodsExtends.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn approveStatus;
    public static EntityColumn remark18;
    public static EntityColumn remark17;
    public static EntityColumn remark16;
    public static EntityColumn remark15;
    public static EntityColumn remark14;
    public static EntityColumn remark13;
    public static EntityColumn remark12;
    public static EntityColumn remark11;
    public static EntityColumn inputStr;
    public static EntityColumn is3d;
    public static EntityColumn templateId;
    public static EntityColumn isTiming;
    public static EntityColumn inputPids;
    public static EntityColumn hasWarranty;
    public static EntityColumn remark19;
    public static EntityColumn features;
    public static EntityColumn remark20;
    public static EntityColumn itemSize;
    public static EntityColumn barcode;
    public static EntityColumn goodsDesc;
    public static EntityColumn outerShopAuctionTemplateId;
    public static EntityColumn images;
    public static EntityColumn postageId;
    public static EntityColumn productId;
    public static EntityColumn customMadeTypeId;
    public static EntityColumn wapDetailUrl;
    public static EntityColumn props;
    public static EntityColumn auctionPoint;
    public static EntityColumn remark9;
    public static EntityColumn codPostageId;
    public static EntityColumn remark8;
    public static EntityColumn violation;
    public static EntityColumn sellPromise;
    public static EntityColumn subtitle;
    public static EntityColumn remark5;
    public static EntityColumn remark10;
    public static EntityColumn propsName;
    public static EntityColumn remark4;
    public static EntityColumn remark7;
    public static EntityColumn isVirtual;
    public static EntityColumn remark6;
    public static EntityColumn remark1;
    public static EntityColumn innerShopAuctionTemplateId;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    public static EntityColumn wapDesc;
    public static EntityColumn goodsId;
    public static EntityColumn sellerCids;
    public static EntityColumn hasInvoice;
    public static EntityColumn increment;
    public static EntityColumn afterSaleId;
    public static EntityColumn isEx;
    public static EntityColumn secondKill;
    public static EntityColumn loadDate;
    public static EntityColumn isTaobao;
    public static EntityColumn nolose;
    public static EntityColumn wirelessDesc;
    public static EntityColumn subStock;
    public static EntityColumn oneStation;
    public static EntityColumn itemWeight;
    public static EntityColumn propertyAlias;
    public static EntityColumn updateTime;
    public static EntityColumn withHoldQuantity;
    public static EntityColumn lastModifyTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        approveStatus = listMap.get("approveStatus");
        remark18 = listMap.get("remark18");
        remark17 = listMap.get("remark17");
        remark16 = listMap.get("remark16");
        remark15 = listMap.get("remark15");
        remark14 = listMap.get("remark14");
        remark13 = listMap.get("remark13");
        remark12 = listMap.get("remark12");
        remark11 = listMap.get("remark11");
        inputStr = listMap.get("inputStr");
        is3d = listMap.get("is3d");
        templateId = listMap.get("templateId");
        isTiming = listMap.get("isTiming");
        inputPids = listMap.get("inputPids");
        hasWarranty = listMap.get("hasWarranty");
        remark19 = listMap.get("remark19");
        features = listMap.get("features");
        remark20 = listMap.get("remark20");
        itemSize = listMap.get("itemSize");
        barcode = listMap.get("barcode");
        goodsDesc = listMap.get("goodsDesc");
        outerShopAuctionTemplateId = listMap.get("outerShopAuctionTemplateId");
        images = listMap.get("images");
        postageId = listMap.get("postageId");
        productId = listMap.get("productId");
        customMadeTypeId = listMap.get("customMadeTypeId");
        wapDetailUrl = listMap.get("wapDetailUrl");
        props = listMap.get("props");
        auctionPoint = listMap.get("auctionPoint");
        remark9 = listMap.get("remark9");
        codPostageId = listMap.get("codPostageId");
        remark8 = listMap.get("remark8");
        violation = listMap.get("violation");
        sellPromise = listMap.get("sellPromise");
        subtitle = listMap.get("subtitle");
        remark5 = listMap.get("remark5");
        remark10 = listMap.get("remark10");
        propsName = listMap.get("propsName");
        remark4 = listMap.get("remark4");
        remark7 = listMap.get("remark7");
        isVirtual = listMap.get("isVirtual");
        remark6 = listMap.get("remark6");
        remark1 = listMap.get("remark1");
        innerShopAuctionTemplateId = listMap.get("innerShopAuctionTemplateId");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        wapDesc = listMap.get("wapDesc");
        goodsId = listMap.get("goodsId");
        sellerCids = listMap.get("sellerCids");
        hasInvoice = listMap.get("hasInvoice");
        increment = listMap.get("increment");
        afterSaleId = listMap.get("afterSaleId");
        isEx = listMap.get("isEx");
        secondKill = listMap.get("secondKill");
        loadDate = listMap.get("loadDate");
        isTaobao = listMap.get("isTaobao");
        nolose = listMap.get("nolose");
        wirelessDesc = listMap.get("wirelessDesc");
        subStock = listMap.get("subStock");
        oneStation = listMap.get("oneStation");
        itemWeight = listMap.get("itemWeight");
        propertyAlias = listMap.get("propertyAlias");
        updateTime = listMap.get("updateTime");
        withHoldQuantity = listMap.get("withHoldQuantity");
        lastModifyTime = listMap.get("lastModifyTime");
        }

    public ShiguGoodsExtendsExample() {
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

        public Criteria andApproveStatusIsNull() {
            return isNull(approveStatus);
        }

        public Criteria andApproveStatusIsNotNull() {
            return isNotNull(approveStatus);
        }

        public Criteria andApproveStatusEqualTo(String value) {
            return equalTo(approveStatus, value);
        }

        public Criteria andApproveStatusNotEqualTo(String value) {
            return notEqualTo(approveStatus, value);
        }

        public Criteria andApproveStatusGreaterThan(String value) {
            return greaterThan(approveStatus, value);
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(approveStatus, value);
        }

        public Criteria andApproveStatusLessThan(String value) {
            return lessThan(approveStatus, value);
        }

        public Criteria andApproveStatusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(approveStatus, value);
        }

        public Criteria andApproveStatusLike(String value) {
            return like(approveStatus, value);
        }

        public Criteria andApproveStatusNotLike(String value) {
            return notLike(approveStatus, value);
        }

        public Criteria andApproveStatusIn(List<String> values) {
            return in(approveStatus, values);
        }

        public Criteria andApproveStatusNotIn(List<String> values) {
            return notIn(approveStatus, values);
        }

        public Criteria andApproveStatusBetween(String value1, String value2) {
            return between(approveStatus, value1, value2);
        }

        public Criteria andApproveStatusNotBetween(String value1, String value2) {
            return notBetween(approveStatus, value1, value2);
        }
        public Criteria andRemark18IsNull() {
            return isNull(remark18);
        }

        public Criteria andRemark18IsNotNull() {
            return isNotNull(remark18);
        }

        public Criteria andRemark18EqualTo(String value) {
            return equalTo(remark18, value);
        }

        public Criteria andRemark18NotEqualTo(String value) {
            return notEqualTo(remark18, value);
        }

        public Criteria andRemark18GreaterThan(String value) {
            return greaterThan(remark18, value);
        }

        public Criteria andRemark18GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark18, value);
        }

        public Criteria andRemark18LessThan(String value) {
            return lessThan(remark18, value);
        }

        public Criteria andRemark18LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark18, value);
        }

        public Criteria andRemark18Like(String value) {
            return like(remark18, value);
        }

        public Criteria andRemark18NotLike(String value) {
            return notLike(remark18, value);
        }

        public Criteria andRemark18In(List<String> values) {
            return in(remark18, values);
        }

        public Criteria andRemark18NotIn(List<String> values) {
            return notIn(remark18, values);
        }

        public Criteria andRemark18Between(String value1, String value2) {
            return between(remark18, value1, value2);
        }

        public Criteria andRemark18NotBetween(String value1, String value2) {
            return notBetween(remark18, value1, value2);
        }
        public Criteria andRemark17IsNull() {
            return isNull(remark17);
        }

        public Criteria andRemark17IsNotNull() {
            return isNotNull(remark17);
        }

        public Criteria andRemark17EqualTo(String value) {
            return equalTo(remark17, value);
        }

        public Criteria andRemark17NotEqualTo(String value) {
            return notEqualTo(remark17, value);
        }

        public Criteria andRemark17GreaterThan(String value) {
            return greaterThan(remark17, value);
        }

        public Criteria andRemark17GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark17, value);
        }

        public Criteria andRemark17LessThan(String value) {
            return lessThan(remark17, value);
        }

        public Criteria andRemark17LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark17, value);
        }

        public Criteria andRemark17Like(String value) {
            return like(remark17, value);
        }

        public Criteria andRemark17NotLike(String value) {
            return notLike(remark17, value);
        }

        public Criteria andRemark17In(List<String> values) {
            return in(remark17, values);
        }

        public Criteria andRemark17NotIn(List<String> values) {
            return notIn(remark17, values);
        }

        public Criteria andRemark17Between(String value1, String value2) {
            return between(remark17, value1, value2);
        }

        public Criteria andRemark17NotBetween(String value1, String value2) {
            return notBetween(remark17, value1, value2);
        }
        public Criteria andRemark16IsNull() {
            return isNull(remark16);
        }

        public Criteria andRemark16IsNotNull() {
            return isNotNull(remark16);
        }

        public Criteria andRemark16EqualTo(String value) {
            return equalTo(remark16, value);
        }

        public Criteria andRemark16NotEqualTo(String value) {
            return notEqualTo(remark16, value);
        }

        public Criteria andRemark16GreaterThan(String value) {
            return greaterThan(remark16, value);
        }

        public Criteria andRemark16GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark16, value);
        }

        public Criteria andRemark16LessThan(String value) {
            return lessThan(remark16, value);
        }

        public Criteria andRemark16LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark16, value);
        }

        public Criteria andRemark16Like(String value) {
            return like(remark16, value);
        }

        public Criteria andRemark16NotLike(String value) {
            return notLike(remark16, value);
        }

        public Criteria andRemark16In(List<String> values) {
            return in(remark16, values);
        }

        public Criteria andRemark16NotIn(List<String> values) {
            return notIn(remark16, values);
        }

        public Criteria andRemark16Between(String value1, String value2) {
            return between(remark16, value1, value2);
        }

        public Criteria andRemark16NotBetween(String value1, String value2) {
            return notBetween(remark16, value1, value2);
        }
        public Criteria andRemark15IsNull() {
            return isNull(remark15);
        }

        public Criteria andRemark15IsNotNull() {
            return isNotNull(remark15);
        }

        public Criteria andRemark15EqualTo(String value) {
            return equalTo(remark15, value);
        }

        public Criteria andRemark15NotEqualTo(String value) {
            return notEqualTo(remark15, value);
        }

        public Criteria andRemark15GreaterThan(String value) {
            return greaterThan(remark15, value);
        }

        public Criteria andRemark15GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark15, value);
        }

        public Criteria andRemark15LessThan(String value) {
            return lessThan(remark15, value);
        }

        public Criteria andRemark15LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark15, value);
        }

        public Criteria andRemark15Like(String value) {
            return like(remark15, value);
        }

        public Criteria andRemark15NotLike(String value) {
            return notLike(remark15, value);
        }

        public Criteria andRemark15In(List<String> values) {
            return in(remark15, values);
        }

        public Criteria andRemark15NotIn(List<String> values) {
            return notIn(remark15, values);
        }

        public Criteria andRemark15Between(String value1, String value2) {
            return between(remark15, value1, value2);
        }

        public Criteria andRemark15NotBetween(String value1, String value2) {
            return notBetween(remark15, value1, value2);
        }
        public Criteria andRemark14IsNull() {
            return isNull(remark14);
        }

        public Criteria andRemark14IsNotNull() {
            return isNotNull(remark14);
        }

        public Criteria andRemark14EqualTo(String value) {
            return equalTo(remark14, value);
        }

        public Criteria andRemark14NotEqualTo(String value) {
            return notEqualTo(remark14, value);
        }

        public Criteria andRemark14GreaterThan(String value) {
            return greaterThan(remark14, value);
        }

        public Criteria andRemark14GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark14, value);
        }

        public Criteria andRemark14LessThan(String value) {
            return lessThan(remark14, value);
        }

        public Criteria andRemark14LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark14, value);
        }

        public Criteria andRemark14Like(String value) {
            return like(remark14, value);
        }

        public Criteria andRemark14NotLike(String value) {
            return notLike(remark14, value);
        }

        public Criteria andRemark14In(List<String> values) {
            return in(remark14, values);
        }

        public Criteria andRemark14NotIn(List<String> values) {
            return notIn(remark14, values);
        }

        public Criteria andRemark14Between(String value1, String value2) {
            return between(remark14, value1, value2);
        }

        public Criteria andRemark14NotBetween(String value1, String value2) {
            return notBetween(remark14, value1, value2);
        }
        public Criteria andRemark13IsNull() {
            return isNull(remark13);
        }

        public Criteria andRemark13IsNotNull() {
            return isNotNull(remark13);
        }

        public Criteria andRemark13EqualTo(String value) {
            return equalTo(remark13, value);
        }

        public Criteria andRemark13NotEqualTo(String value) {
            return notEqualTo(remark13, value);
        }

        public Criteria andRemark13GreaterThan(String value) {
            return greaterThan(remark13, value);
        }

        public Criteria andRemark13GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark13, value);
        }

        public Criteria andRemark13LessThan(String value) {
            return lessThan(remark13, value);
        }

        public Criteria andRemark13LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark13, value);
        }

        public Criteria andRemark13Like(String value) {
            return like(remark13, value);
        }

        public Criteria andRemark13NotLike(String value) {
            return notLike(remark13, value);
        }

        public Criteria andRemark13In(List<String> values) {
            return in(remark13, values);
        }

        public Criteria andRemark13NotIn(List<String> values) {
            return notIn(remark13, values);
        }

        public Criteria andRemark13Between(String value1, String value2) {
            return between(remark13, value1, value2);
        }

        public Criteria andRemark13NotBetween(String value1, String value2) {
            return notBetween(remark13, value1, value2);
        }
        public Criteria andRemark12IsNull() {
            return isNull(remark12);
        }

        public Criteria andRemark12IsNotNull() {
            return isNotNull(remark12);
        }

        public Criteria andRemark12EqualTo(String value) {
            return equalTo(remark12, value);
        }

        public Criteria andRemark12NotEqualTo(String value) {
            return notEqualTo(remark12, value);
        }

        public Criteria andRemark12GreaterThan(String value) {
            return greaterThan(remark12, value);
        }

        public Criteria andRemark12GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark12, value);
        }

        public Criteria andRemark12LessThan(String value) {
            return lessThan(remark12, value);
        }

        public Criteria andRemark12LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark12, value);
        }

        public Criteria andRemark12Like(String value) {
            return like(remark12, value);
        }

        public Criteria andRemark12NotLike(String value) {
            return notLike(remark12, value);
        }

        public Criteria andRemark12In(List<String> values) {
            return in(remark12, values);
        }

        public Criteria andRemark12NotIn(List<String> values) {
            return notIn(remark12, values);
        }

        public Criteria andRemark12Between(String value1, String value2) {
            return between(remark12, value1, value2);
        }

        public Criteria andRemark12NotBetween(String value1, String value2) {
            return notBetween(remark12, value1, value2);
        }
        public Criteria andRemark11IsNull() {
            return isNull(remark11);
        }

        public Criteria andRemark11IsNotNull() {
            return isNotNull(remark11);
        }

        public Criteria andRemark11EqualTo(String value) {
            return equalTo(remark11, value);
        }

        public Criteria andRemark11NotEqualTo(String value) {
            return notEqualTo(remark11, value);
        }

        public Criteria andRemark11GreaterThan(String value) {
            return greaterThan(remark11, value);
        }

        public Criteria andRemark11GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark11, value);
        }

        public Criteria andRemark11LessThan(String value) {
            return lessThan(remark11, value);
        }

        public Criteria andRemark11LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark11, value);
        }

        public Criteria andRemark11Like(String value) {
            return like(remark11, value);
        }

        public Criteria andRemark11NotLike(String value) {
            return notLike(remark11, value);
        }

        public Criteria andRemark11In(List<String> values) {
            return in(remark11, values);
        }

        public Criteria andRemark11NotIn(List<String> values) {
            return notIn(remark11, values);
        }

        public Criteria andRemark11Between(String value1, String value2) {
            return between(remark11, value1, value2);
        }

        public Criteria andRemark11NotBetween(String value1, String value2) {
            return notBetween(remark11, value1, value2);
        }
        public Criteria andInputStrIsNull() {
            return isNull(inputStr);
        }

        public Criteria andInputStrIsNotNull() {
            return isNotNull(inputStr);
        }

        public Criteria andInputStrEqualTo(String value) {
            return equalTo(inputStr, value);
        }

        public Criteria andInputStrNotEqualTo(String value) {
            return notEqualTo(inputStr, value);
        }

        public Criteria andInputStrGreaterThan(String value) {
            return greaterThan(inputStr, value);
        }

        public Criteria andInputStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(inputStr, value);
        }

        public Criteria andInputStrLessThan(String value) {
            return lessThan(inputStr, value);
        }

        public Criteria andInputStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(inputStr, value);
        }

        public Criteria andInputStrLike(String value) {
            return like(inputStr, value);
        }

        public Criteria andInputStrNotLike(String value) {
            return notLike(inputStr, value);
        }

        public Criteria andInputStrIn(List<String> values) {
            return in(inputStr, values);
        }

        public Criteria andInputStrNotIn(List<String> values) {
            return notIn(inputStr, values);
        }

        public Criteria andInputStrBetween(String value1, String value2) {
            return between(inputStr, value1, value2);
        }

        public Criteria andInputStrNotBetween(String value1, String value2) {
            return notBetween(inputStr, value1, value2);
        }
        public Criteria andIs3dIsNull() {
            return isNull(is3d);
        }

        public Criteria andIs3dIsNotNull() {
            return isNotNull(is3d);
        }

        public Criteria andIs3dEqualTo(String value) {
            return equalTo(is3d, value);
        }

        public Criteria andIs3dNotEqualTo(String value) {
            return notEqualTo(is3d, value);
        }

        public Criteria andIs3dGreaterThan(String value) {
            return greaterThan(is3d, value);
        }

        public Criteria andIs3dGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(is3d, value);
        }

        public Criteria andIs3dLessThan(String value) {
            return lessThan(is3d, value);
        }

        public Criteria andIs3dLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(is3d, value);
        }

        public Criteria andIs3dLike(String value) {
            return like(is3d, value);
        }

        public Criteria andIs3dNotLike(String value) {
            return notLike(is3d, value);
        }

        public Criteria andIs3dIn(List<String> values) {
            return in(is3d, values);
        }

        public Criteria andIs3dNotIn(List<String> values) {
            return notIn(is3d, values);
        }

        public Criteria andIs3dBetween(String value1, String value2) {
            return between(is3d, value1, value2);
        }

        public Criteria andIs3dNotBetween(String value1, String value2) {
            return notBetween(is3d, value1, value2);
        }
        public Criteria andTemplateIdIsNull() {
            return isNull(templateId);
        }

        public Criteria andTemplateIdIsNotNull() {
            return isNotNull(templateId);
        }

        public Criteria andTemplateIdEqualTo(String value) {
            return equalTo(templateId, value);
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            return notEqualTo(templateId, value);
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            return greaterThan(templateId, value);
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(templateId, value);
        }

        public Criteria andTemplateIdLessThan(String value) {
            return lessThan(templateId, value);
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(templateId, value);
        }

        public Criteria andTemplateIdLike(String value) {
            return like(templateId, value);
        }

        public Criteria andTemplateIdNotLike(String value) {
            return notLike(templateId, value);
        }

        public Criteria andTemplateIdIn(List<String> values) {
            return in(templateId, values);
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            return notIn(templateId, values);
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            return between(templateId, value1, value2);
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            return notBetween(templateId, value1, value2);
        }
        public Criteria andIsTimingIsNull() {
            return isNull(isTiming);
        }

        public Criteria andIsTimingIsNotNull() {
            return isNotNull(isTiming);
        }

        public Criteria andIsTimingEqualTo(String value) {
            return equalTo(isTiming, value);
        }

        public Criteria andIsTimingNotEqualTo(String value) {
            return notEqualTo(isTiming, value);
        }

        public Criteria andIsTimingGreaterThan(String value) {
            return greaterThan(isTiming, value);
        }

        public Criteria andIsTimingGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isTiming, value);
        }

        public Criteria andIsTimingLessThan(String value) {
            return lessThan(isTiming, value);
        }

        public Criteria andIsTimingLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isTiming, value);
        }

        public Criteria andIsTimingLike(String value) {
            return like(isTiming, value);
        }

        public Criteria andIsTimingNotLike(String value) {
            return notLike(isTiming, value);
        }

        public Criteria andIsTimingIn(List<String> values) {
            return in(isTiming, values);
        }

        public Criteria andIsTimingNotIn(List<String> values) {
            return notIn(isTiming, values);
        }

        public Criteria andIsTimingBetween(String value1, String value2) {
            return between(isTiming, value1, value2);
        }

        public Criteria andIsTimingNotBetween(String value1, String value2) {
            return notBetween(isTiming, value1, value2);
        }
        public Criteria andInputPidsIsNull() {
            return isNull(inputPids);
        }

        public Criteria andInputPidsIsNotNull() {
            return isNotNull(inputPids);
        }

        public Criteria andInputPidsEqualTo(String value) {
            return equalTo(inputPids, value);
        }

        public Criteria andInputPidsNotEqualTo(String value) {
            return notEqualTo(inputPids, value);
        }

        public Criteria andInputPidsGreaterThan(String value) {
            return greaterThan(inputPids, value);
        }

        public Criteria andInputPidsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(inputPids, value);
        }

        public Criteria andInputPidsLessThan(String value) {
            return lessThan(inputPids, value);
        }

        public Criteria andInputPidsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(inputPids, value);
        }

        public Criteria andInputPidsLike(String value) {
            return like(inputPids, value);
        }

        public Criteria andInputPidsNotLike(String value) {
            return notLike(inputPids, value);
        }

        public Criteria andInputPidsIn(List<String> values) {
            return in(inputPids, values);
        }

        public Criteria andInputPidsNotIn(List<String> values) {
            return notIn(inputPids, values);
        }

        public Criteria andInputPidsBetween(String value1, String value2) {
            return between(inputPids, value1, value2);
        }

        public Criteria andInputPidsNotBetween(String value1, String value2) {
            return notBetween(inputPids, value1, value2);
        }
        public Criteria andHasWarrantyIsNull() {
            return isNull(hasWarranty);
        }

        public Criteria andHasWarrantyIsNotNull() {
            return isNotNull(hasWarranty);
        }

        public Criteria andHasWarrantyEqualTo(String value) {
            return equalTo(hasWarranty, value);
        }

        public Criteria andHasWarrantyNotEqualTo(String value) {
            return notEqualTo(hasWarranty, value);
        }

        public Criteria andHasWarrantyGreaterThan(String value) {
            return greaterThan(hasWarranty, value);
        }

        public Criteria andHasWarrantyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasWarranty, value);
        }

        public Criteria andHasWarrantyLessThan(String value) {
            return lessThan(hasWarranty, value);
        }

        public Criteria andHasWarrantyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasWarranty, value);
        }

        public Criteria andHasWarrantyLike(String value) {
            return like(hasWarranty, value);
        }

        public Criteria andHasWarrantyNotLike(String value) {
            return notLike(hasWarranty, value);
        }

        public Criteria andHasWarrantyIn(List<String> values) {
            return in(hasWarranty, values);
        }

        public Criteria andHasWarrantyNotIn(List<String> values) {
            return notIn(hasWarranty, values);
        }

        public Criteria andHasWarrantyBetween(String value1, String value2) {
            return between(hasWarranty, value1, value2);
        }

        public Criteria andHasWarrantyNotBetween(String value1, String value2) {
            return notBetween(hasWarranty, value1, value2);
        }
        public Criteria andRemark19IsNull() {
            return isNull(remark19);
        }

        public Criteria andRemark19IsNotNull() {
            return isNotNull(remark19);
        }

        public Criteria andRemark19EqualTo(String value) {
            return equalTo(remark19, value);
        }

        public Criteria andRemark19NotEqualTo(String value) {
            return notEqualTo(remark19, value);
        }

        public Criteria andRemark19GreaterThan(String value) {
            return greaterThan(remark19, value);
        }

        public Criteria andRemark19GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark19, value);
        }

        public Criteria andRemark19LessThan(String value) {
            return lessThan(remark19, value);
        }

        public Criteria andRemark19LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark19, value);
        }

        public Criteria andRemark19Like(String value) {
            return like(remark19, value);
        }

        public Criteria andRemark19NotLike(String value) {
            return notLike(remark19, value);
        }

        public Criteria andRemark19In(List<String> values) {
            return in(remark19, values);
        }

        public Criteria andRemark19NotIn(List<String> values) {
            return notIn(remark19, values);
        }

        public Criteria andRemark19Between(String value1, String value2) {
            return between(remark19, value1, value2);
        }

        public Criteria andRemark19NotBetween(String value1, String value2) {
            return notBetween(remark19, value1, value2);
        }
        public Criteria andFeaturesIsNull() {
            return isNull(features);
        }

        public Criteria andFeaturesIsNotNull() {
            return isNotNull(features);
        }

        public Criteria andFeaturesEqualTo(String value) {
            return equalTo(features, value);
        }

        public Criteria andFeaturesNotEqualTo(String value) {
            return notEqualTo(features, value);
        }

        public Criteria andFeaturesGreaterThan(String value) {
            return greaterThan(features, value);
        }

        public Criteria andFeaturesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(features, value);
        }

        public Criteria andFeaturesLessThan(String value) {
            return lessThan(features, value);
        }

        public Criteria andFeaturesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(features, value);
        }

        public Criteria andFeaturesLike(String value) {
            return like(features, value);
        }

        public Criteria andFeaturesNotLike(String value) {
            return notLike(features, value);
        }

        public Criteria andFeaturesIn(List<String> values) {
            return in(features, values);
        }

        public Criteria andFeaturesNotIn(List<String> values) {
            return notIn(features, values);
        }

        public Criteria andFeaturesBetween(String value1, String value2) {
            return between(features, value1, value2);
        }

        public Criteria andFeaturesNotBetween(String value1, String value2) {
            return notBetween(features, value1, value2);
        }
        public Criteria andRemark20IsNull() {
            return isNull(remark20);
        }

        public Criteria andRemark20IsNotNull() {
            return isNotNull(remark20);
        }

        public Criteria andRemark20EqualTo(String value) {
            return equalTo(remark20, value);
        }

        public Criteria andRemark20NotEqualTo(String value) {
            return notEqualTo(remark20, value);
        }

        public Criteria andRemark20GreaterThan(String value) {
            return greaterThan(remark20, value);
        }

        public Criteria andRemark20GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark20, value);
        }

        public Criteria andRemark20LessThan(String value) {
            return lessThan(remark20, value);
        }

        public Criteria andRemark20LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark20, value);
        }

        public Criteria andRemark20Like(String value) {
            return like(remark20, value);
        }

        public Criteria andRemark20NotLike(String value) {
            return notLike(remark20, value);
        }

        public Criteria andRemark20In(List<String> values) {
            return in(remark20, values);
        }

        public Criteria andRemark20NotIn(List<String> values) {
            return notIn(remark20, values);
        }

        public Criteria andRemark20Between(String value1, String value2) {
            return between(remark20, value1, value2);
        }

        public Criteria andRemark20NotBetween(String value1, String value2) {
            return notBetween(remark20, value1, value2);
        }
        public Criteria andItemSizeIsNull() {
            return isNull(itemSize);
        }

        public Criteria andItemSizeIsNotNull() {
            return isNotNull(itemSize);
        }

        public Criteria andItemSizeEqualTo(String value) {
            return equalTo(itemSize, value);
        }

        public Criteria andItemSizeNotEqualTo(String value) {
            return notEqualTo(itemSize, value);
        }

        public Criteria andItemSizeGreaterThan(String value) {
            return greaterThan(itemSize, value);
        }

        public Criteria andItemSizeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemSize, value);
        }

        public Criteria andItemSizeLessThan(String value) {
            return lessThan(itemSize, value);
        }

        public Criteria andItemSizeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemSize, value);
        }

        public Criteria andItemSizeLike(String value) {
            return like(itemSize, value);
        }

        public Criteria andItemSizeNotLike(String value) {
            return notLike(itemSize, value);
        }

        public Criteria andItemSizeIn(List<String> values) {
            return in(itemSize, values);
        }

        public Criteria andItemSizeNotIn(List<String> values) {
            return notIn(itemSize, values);
        }

        public Criteria andItemSizeBetween(String value1, String value2) {
            return between(itemSize, value1, value2);
        }

        public Criteria andItemSizeNotBetween(String value1, String value2) {
            return notBetween(itemSize, value1, value2);
        }
        public Criteria andBarcodeIsNull() {
            return isNull(barcode);
        }

        public Criteria andBarcodeIsNotNull() {
            return isNotNull(barcode);
        }

        public Criteria andBarcodeEqualTo(String value) {
            return equalTo(barcode, value);
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            return notEqualTo(barcode, value);
        }

        public Criteria andBarcodeGreaterThan(String value) {
            return greaterThan(barcode, value);
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barcode, value);
        }

        public Criteria andBarcodeLessThan(String value) {
            return lessThan(barcode, value);
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barcode, value);
        }

        public Criteria andBarcodeLike(String value) {
            return like(barcode, value);
        }

        public Criteria andBarcodeNotLike(String value) {
            return notLike(barcode, value);
        }

        public Criteria andBarcodeIn(List<String> values) {
            return in(barcode, values);
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            return notIn(barcode, values);
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            return between(barcode, value1, value2);
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            return notBetween(barcode, value1, value2);
        }
        public Criteria andGoodsDescIsNull() {
            return isNull(goodsDesc);
        }

        public Criteria andGoodsDescIsNotNull() {
            return isNotNull(goodsDesc);
        }

        public Criteria andGoodsDescEqualTo(String value) {
            return equalTo(goodsDesc, value);
        }

        public Criteria andGoodsDescNotEqualTo(String value) {
            return notEqualTo(goodsDesc, value);
        }

        public Criteria andGoodsDescGreaterThan(String value) {
            return greaterThan(goodsDesc, value);
        }

        public Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsDesc, value);
        }

        public Criteria andGoodsDescLessThan(String value) {
            return lessThan(goodsDesc, value);
        }

        public Criteria andGoodsDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsDesc, value);
        }

        public Criteria andGoodsDescLike(String value) {
            return like(goodsDesc, value);
        }

        public Criteria andGoodsDescNotLike(String value) {
            return notLike(goodsDesc, value);
        }

        public Criteria andGoodsDescIn(List<String> values) {
            return in(goodsDesc, values);
        }

        public Criteria andGoodsDescNotIn(List<String> values) {
            return notIn(goodsDesc, values);
        }

        public Criteria andGoodsDescBetween(String value1, String value2) {
            return between(goodsDesc, value1, value2);
        }

        public Criteria andGoodsDescNotBetween(String value1, String value2) {
            return notBetween(goodsDesc, value1, value2);
        }
        public Criteria andOuterShopAuctionTemplateIdIsNull() {
            return isNull(outerShopAuctionTemplateId);
        }

        public Criteria andOuterShopAuctionTemplateIdIsNotNull() {
            return isNotNull(outerShopAuctionTemplateId);
        }

        public Criteria andOuterShopAuctionTemplateIdEqualTo(Long value) {
            return equalTo(outerShopAuctionTemplateId, value);
        }

        public Criteria andOuterShopAuctionTemplateIdNotEqualTo(Long value) {
            return notEqualTo(outerShopAuctionTemplateId, value);
        }

        public Criteria andOuterShopAuctionTemplateIdGreaterThan(Long value) {
            return greaterThan(outerShopAuctionTemplateId, value);
        }

        public Criteria andOuterShopAuctionTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(outerShopAuctionTemplateId, value);
        }

        public Criteria andOuterShopAuctionTemplateIdLessThan(Long value) {
            return lessThan(outerShopAuctionTemplateId, value);
        }

        public Criteria andOuterShopAuctionTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(outerShopAuctionTemplateId, value);
        }

        public Criteria andOuterShopAuctionTemplateIdIn(List<Long> values) {
            return in(outerShopAuctionTemplateId, values);
        }

        public Criteria andOuterShopAuctionTemplateIdNotIn(List<Long> values) {
            return notIn(outerShopAuctionTemplateId, values);
        }

        public Criteria andOuterShopAuctionTemplateIdBetween(Long value1, Long value2) {
            return between(outerShopAuctionTemplateId, value1, value2);
        }

        public Criteria andOuterShopAuctionTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(outerShopAuctionTemplateId, value1, value2);
        }
        public Criteria andImagesIsNull() {
            return isNull(images);
        }

        public Criteria andImagesIsNotNull() {
            return isNotNull(images);
        }

        public Criteria andImagesEqualTo(String value) {
            return equalTo(images, value);
        }

        public Criteria andImagesNotEqualTo(String value) {
            return notEqualTo(images, value);
        }

        public Criteria andImagesGreaterThan(String value) {
            return greaterThan(images, value);
        }

        public Criteria andImagesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(images, value);
        }

        public Criteria andImagesLessThan(String value) {
            return lessThan(images, value);
        }

        public Criteria andImagesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(images, value);
        }

        public Criteria andImagesLike(String value) {
            return like(images, value);
        }

        public Criteria andImagesNotLike(String value) {
            return notLike(images, value);
        }

        public Criteria andImagesIn(List<String> values) {
            return in(images, values);
        }

        public Criteria andImagesNotIn(List<String> values) {
            return notIn(images, values);
        }

        public Criteria andImagesBetween(String value1, String value2) {
            return between(images, value1, value2);
        }

        public Criteria andImagesNotBetween(String value1, String value2) {
            return notBetween(images, value1, value2);
        }
        public Criteria andPostageIdIsNull() {
            return isNull(postageId);
        }

        public Criteria andPostageIdIsNotNull() {
            return isNotNull(postageId);
        }

        public Criteria andPostageIdEqualTo(Long value) {
            return equalTo(postageId, value);
        }

        public Criteria andPostageIdNotEqualTo(Long value) {
            return notEqualTo(postageId, value);
        }

        public Criteria andPostageIdGreaterThan(Long value) {
            return greaterThan(postageId, value);
        }

        public Criteria andPostageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(postageId, value);
        }

        public Criteria andPostageIdLessThan(Long value) {
            return lessThan(postageId, value);
        }

        public Criteria andPostageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(postageId, value);
        }

        public Criteria andPostageIdIn(List<Long> values) {
            return in(postageId, values);
        }

        public Criteria andPostageIdNotIn(List<Long> values) {
            return notIn(postageId, values);
        }

        public Criteria andPostageIdBetween(Long value1, Long value2) {
            return between(postageId, value1, value2);
        }

        public Criteria andPostageIdNotBetween(Long value1, Long value2) {
            return notBetween(postageId, value1, value2);
        }
        public Criteria andProductIdIsNull() {
            return isNull(productId);
        }

        public Criteria andProductIdIsNotNull() {
            return isNotNull(productId);
        }

        public Criteria andProductIdEqualTo(Long value) {
            return equalTo(productId, value);
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            return notEqualTo(productId, value);
        }

        public Criteria andProductIdGreaterThan(Long value) {
            return greaterThan(productId, value);
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(productId, value);
        }

        public Criteria andProductIdLessThan(Long value) {
            return lessThan(productId, value);
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(productId, value);
        }

        public Criteria andProductIdIn(List<Long> values) {
            return in(productId, values);
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            return notIn(productId, values);
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            return between(productId, value1, value2);
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            return notBetween(productId, value1, value2);
        }
        public Criteria andCustomMadeTypeIdIsNull() {
            return isNull(customMadeTypeId);
        }

        public Criteria andCustomMadeTypeIdIsNotNull() {
            return isNotNull(customMadeTypeId);
        }

        public Criteria andCustomMadeTypeIdEqualTo(String value) {
            return equalTo(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdNotEqualTo(String value) {
            return notEqualTo(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdGreaterThan(String value) {
            return greaterThan(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdLessThan(String value) {
            return lessThan(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdLike(String value) {
            return like(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdNotLike(String value) {
            return notLike(customMadeTypeId, value);
        }

        public Criteria andCustomMadeTypeIdIn(List<String> values) {
            return in(customMadeTypeId, values);
        }

        public Criteria andCustomMadeTypeIdNotIn(List<String> values) {
            return notIn(customMadeTypeId, values);
        }

        public Criteria andCustomMadeTypeIdBetween(String value1, String value2) {
            return between(customMadeTypeId, value1, value2);
        }

        public Criteria andCustomMadeTypeIdNotBetween(String value1, String value2) {
            return notBetween(customMadeTypeId, value1, value2);
        }
        public Criteria andWapDetailUrlIsNull() {
            return isNull(wapDetailUrl);
        }

        public Criteria andWapDetailUrlIsNotNull() {
            return isNotNull(wapDetailUrl);
        }

        public Criteria andWapDetailUrlEqualTo(String value) {
            return equalTo(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlNotEqualTo(String value) {
            return notEqualTo(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlGreaterThan(String value) {
            return greaterThan(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlLessThan(String value) {
            return lessThan(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlLike(String value) {
            return like(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlNotLike(String value) {
            return notLike(wapDetailUrl, value);
        }

        public Criteria andWapDetailUrlIn(List<String> values) {
            return in(wapDetailUrl, values);
        }

        public Criteria andWapDetailUrlNotIn(List<String> values) {
            return notIn(wapDetailUrl, values);
        }

        public Criteria andWapDetailUrlBetween(String value1, String value2) {
            return between(wapDetailUrl, value1, value2);
        }

        public Criteria andWapDetailUrlNotBetween(String value1, String value2) {
            return notBetween(wapDetailUrl, value1, value2);
        }
        public Criteria andPropsIsNull() {
            return isNull(props);
        }

        public Criteria andPropsIsNotNull() {
            return isNotNull(props);
        }

        public Criteria andPropsEqualTo(String value) {
            return equalTo(props, value);
        }

        public Criteria andPropsNotEqualTo(String value) {
            return notEqualTo(props, value);
        }

        public Criteria andPropsGreaterThan(String value) {
            return greaterThan(props, value);
        }

        public Criteria andPropsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(props, value);
        }

        public Criteria andPropsLessThan(String value) {
            return lessThan(props, value);
        }

        public Criteria andPropsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(props, value);
        }

        public Criteria andPropsLike(String value) {
            return like(props, value);
        }

        public Criteria andPropsNotLike(String value) {
            return notLike(props, value);
        }

        public Criteria andPropsIn(List<String> values) {
            return in(props, values);
        }

        public Criteria andPropsNotIn(List<String> values) {
            return notIn(props, values);
        }

        public Criteria andPropsBetween(String value1, String value2) {
            return between(props, value1, value2);
        }

        public Criteria andPropsNotBetween(String value1, String value2) {
            return notBetween(props, value1, value2);
        }
        public Criteria andAuctionPointIsNull() {
            return isNull(auctionPoint);
        }

        public Criteria andAuctionPointIsNotNull() {
            return isNotNull(auctionPoint);
        }

        public Criteria andAuctionPointEqualTo(String value) {
            return equalTo(auctionPoint, value);
        }

        public Criteria andAuctionPointNotEqualTo(String value) {
            return notEqualTo(auctionPoint, value);
        }

        public Criteria andAuctionPointGreaterThan(String value) {
            return greaterThan(auctionPoint, value);
        }

        public Criteria andAuctionPointGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(auctionPoint, value);
        }

        public Criteria andAuctionPointLessThan(String value) {
            return lessThan(auctionPoint, value);
        }

        public Criteria andAuctionPointLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(auctionPoint, value);
        }

        public Criteria andAuctionPointLike(String value) {
            return like(auctionPoint, value);
        }

        public Criteria andAuctionPointNotLike(String value) {
            return notLike(auctionPoint, value);
        }

        public Criteria andAuctionPointIn(List<String> values) {
            return in(auctionPoint, values);
        }

        public Criteria andAuctionPointNotIn(List<String> values) {
            return notIn(auctionPoint, values);
        }

        public Criteria andAuctionPointBetween(String value1, String value2) {
            return between(auctionPoint, value1, value2);
        }

        public Criteria andAuctionPointNotBetween(String value1, String value2) {
            return notBetween(auctionPoint, value1, value2);
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
        public Criteria andCodPostageIdIsNull() {
            return isNull(codPostageId);
        }

        public Criteria andCodPostageIdIsNotNull() {
            return isNotNull(codPostageId);
        }

        public Criteria andCodPostageIdEqualTo(Long value) {
            return equalTo(codPostageId, value);
        }

        public Criteria andCodPostageIdNotEqualTo(Long value) {
            return notEqualTo(codPostageId, value);
        }

        public Criteria andCodPostageIdGreaterThan(Long value) {
            return greaterThan(codPostageId, value);
        }

        public Criteria andCodPostageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(codPostageId, value);
        }

        public Criteria andCodPostageIdLessThan(Long value) {
            return lessThan(codPostageId, value);
        }

        public Criteria andCodPostageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(codPostageId, value);
        }

        public Criteria andCodPostageIdIn(List<Long> values) {
            return in(codPostageId, values);
        }

        public Criteria andCodPostageIdNotIn(List<Long> values) {
            return notIn(codPostageId, values);
        }

        public Criteria andCodPostageIdBetween(Long value1, Long value2) {
            return between(codPostageId, value1, value2);
        }

        public Criteria andCodPostageIdNotBetween(Long value1, Long value2) {
            return notBetween(codPostageId, value1, value2);
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
        public Criteria andViolationIsNull() {
            return isNull(violation);
        }

        public Criteria andViolationIsNotNull() {
            return isNotNull(violation);
        }

        public Criteria andViolationEqualTo(String value) {
            return equalTo(violation, value);
        }

        public Criteria andViolationNotEqualTo(String value) {
            return notEqualTo(violation, value);
        }

        public Criteria andViolationGreaterThan(String value) {
            return greaterThan(violation, value);
        }

        public Criteria andViolationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(violation, value);
        }

        public Criteria andViolationLessThan(String value) {
            return lessThan(violation, value);
        }

        public Criteria andViolationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(violation, value);
        }

        public Criteria andViolationLike(String value) {
            return like(violation, value);
        }

        public Criteria andViolationNotLike(String value) {
            return notLike(violation, value);
        }

        public Criteria andViolationIn(List<String> values) {
            return in(violation, values);
        }

        public Criteria andViolationNotIn(List<String> values) {
            return notIn(violation, values);
        }

        public Criteria andViolationBetween(String value1, String value2) {
            return between(violation, value1, value2);
        }

        public Criteria andViolationNotBetween(String value1, String value2) {
            return notBetween(violation, value1, value2);
        }
        public Criteria andSellPromiseIsNull() {
            return isNull(sellPromise);
        }

        public Criteria andSellPromiseIsNotNull() {
            return isNotNull(sellPromise);
        }

        public Criteria andSellPromiseEqualTo(String value) {
            return equalTo(sellPromise, value);
        }

        public Criteria andSellPromiseNotEqualTo(String value) {
            return notEqualTo(sellPromise, value);
        }

        public Criteria andSellPromiseGreaterThan(String value) {
            return greaterThan(sellPromise, value);
        }

        public Criteria andSellPromiseGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellPromise, value);
        }

        public Criteria andSellPromiseLessThan(String value) {
            return lessThan(sellPromise, value);
        }

        public Criteria andSellPromiseLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellPromise, value);
        }

        public Criteria andSellPromiseLike(String value) {
            return like(sellPromise, value);
        }

        public Criteria andSellPromiseNotLike(String value) {
            return notLike(sellPromise, value);
        }

        public Criteria andSellPromiseIn(List<String> values) {
            return in(sellPromise, values);
        }

        public Criteria andSellPromiseNotIn(List<String> values) {
            return notIn(sellPromise, values);
        }

        public Criteria andSellPromiseBetween(String value1, String value2) {
            return between(sellPromise, value1, value2);
        }

        public Criteria andSellPromiseNotBetween(String value1, String value2) {
            return notBetween(sellPromise, value1, value2);
        }
        public Criteria andSubtitleIsNull() {
            return isNull(subtitle);
        }

        public Criteria andSubtitleIsNotNull() {
            return isNotNull(subtitle);
        }

        public Criteria andSubtitleEqualTo(String value) {
            return equalTo(subtitle, value);
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            return notEqualTo(subtitle, value);
        }

        public Criteria andSubtitleGreaterThan(String value) {
            return greaterThan(subtitle, value);
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(subtitle, value);
        }

        public Criteria andSubtitleLessThan(String value) {
            return lessThan(subtitle, value);
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(subtitle, value);
        }

        public Criteria andSubtitleLike(String value) {
            return like(subtitle, value);
        }

        public Criteria andSubtitleNotLike(String value) {
            return notLike(subtitle, value);
        }

        public Criteria andSubtitleIn(List<String> values) {
            return in(subtitle, values);
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            return notIn(subtitle, values);
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            return between(subtitle, value1, value2);
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            return notBetween(subtitle, value1, value2);
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
        public Criteria andPropsNameIsNull() {
            return isNull(propsName);
        }

        public Criteria andPropsNameIsNotNull() {
            return isNotNull(propsName);
        }

        public Criteria andPropsNameEqualTo(String value) {
            return equalTo(propsName, value);
        }

        public Criteria andPropsNameNotEqualTo(String value) {
            return notEqualTo(propsName, value);
        }

        public Criteria andPropsNameGreaterThan(String value) {
            return greaterThan(propsName, value);
        }

        public Criteria andPropsNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propsName, value);
        }

        public Criteria andPropsNameLessThan(String value) {
            return lessThan(propsName, value);
        }

        public Criteria andPropsNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propsName, value);
        }

        public Criteria andPropsNameLike(String value) {
            return like(propsName, value);
        }

        public Criteria andPropsNameNotLike(String value) {
            return notLike(propsName, value);
        }

        public Criteria andPropsNameIn(List<String> values) {
            return in(propsName, values);
        }

        public Criteria andPropsNameNotIn(List<String> values) {
            return notIn(propsName, values);
        }

        public Criteria andPropsNameBetween(String value1, String value2) {
            return between(propsName, value1, value2);
        }

        public Criteria andPropsNameNotBetween(String value1, String value2) {
            return notBetween(propsName, value1, value2);
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
        public Criteria andIsVirtualIsNull() {
            return isNull(isVirtual);
        }

        public Criteria andIsVirtualIsNotNull() {
            return isNotNull(isVirtual);
        }

        public Criteria andIsVirtualEqualTo(String value) {
            return equalTo(isVirtual, value);
        }

        public Criteria andIsVirtualNotEqualTo(String value) {
            return notEqualTo(isVirtual, value);
        }

        public Criteria andIsVirtualGreaterThan(String value) {
            return greaterThan(isVirtual, value);
        }

        public Criteria andIsVirtualGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isVirtual, value);
        }

        public Criteria andIsVirtualLessThan(String value) {
            return lessThan(isVirtual, value);
        }

        public Criteria andIsVirtualLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isVirtual, value);
        }

        public Criteria andIsVirtualLike(String value) {
            return like(isVirtual, value);
        }

        public Criteria andIsVirtualNotLike(String value) {
            return notLike(isVirtual, value);
        }

        public Criteria andIsVirtualIn(List<String> values) {
            return in(isVirtual, values);
        }

        public Criteria andIsVirtualNotIn(List<String> values) {
            return notIn(isVirtual, values);
        }

        public Criteria andIsVirtualBetween(String value1, String value2) {
            return between(isVirtual, value1, value2);
        }

        public Criteria andIsVirtualNotBetween(String value1, String value2) {
            return notBetween(isVirtual, value1, value2);
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
        public Criteria andInnerShopAuctionTemplateIdIsNull() {
            return isNull(innerShopAuctionTemplateId);
        }

        public Criteria andInnerShopAuctionTemplateIdIsNotNull() {
            return isNotNull(innerShopAuctionTemplateId);
        }

        public Criteria andInnerShopAuctionTemplateIdEqualTo(Long value) {
            return equalTo(innerShopAuctionTemplateId, value);
        }

        public Criteria andInnerShopAuctionTemplateIdNotEqualTo(Long value) {
            return notEqualTo(innerShopAuctionTemplateId, value);
        }

        public Criteria andInnerShopAuctionTemplateIdGreaterThan(Long value) {
            return greaterThan(innerShopAuctionTemplateId, value);
        }

        public Criteria andInnerShopAuctionTemplateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(innerShopAuctionTemplateId, value);
        }

        public Criteria andInnerShopAuctionTemplateIdLessThan(Long value) {
            return lessThan(innerShopAuctionTemplateId, value);
        }

        public Criteria andInnerShopAuctionTemplateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(innerShopAuctionTemplateId, value);
        }

        public Criteria andInnerShopAuctionTemplateIdIn(List<Long> values) {
            return in(innerShopAuctionTemplateId, values);
        }

        public Criteria andInnerShopAuctionTemplateIdNotIn(List<Long> values) {
            return notIn(innerShopAuctionTemplateId, values);
        }

        public Criteria andInnerShopAuctionTemplateIdBetween(Long value1, Long value2) {
            return between(innerShopAuctionTemplateId, value1, value2);
        }

        public Criteria andInnerShopAuctionTemplateIdNotBetween(Long value1, Long value2) {
            return notBetween(innerShopAuctionTemplateId, value1, value2);
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
        public Criteria andWapDescIsNull() {
            return isNull(wapDesc);
        }

        public Criteria andWapDescIsNotNull() {
            return isNotNull(wapDesc);
        }

        public Criteria andWapDescEqualTo(String value) {
            return equalTo(wapDesc, value);
        }

        public Criteria andWapDescNotEqualTo(String value) {
            return notEqualTo(wapDesc, value);
        }

        public Criteria andWapDescGreaterThan(String value) {
            return greaterThan(wapDesc, value);
        }

        public Criteria andWapDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wapDesc, value);
        }

        public Criteria andWapDescLessThan(String value) {
            return lessThan(wapDesc, value);
        }

        public Criteria andWapDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wapDesc, value);
        }

        public Criteria andWapDescLike(String value) {
            return like(wapDesc, value);
        }

        public Criteria andWapDescNotLike(String value) {
            return notLike(wapDesc, value);
        }

        public Criteria andWapDescIn(List<String> values) {
            return in(wapDesc, values);
        }

        public Criteria andWapDescNotIn(List<String> values) {
            return notIn(wapDesc, values);
        }

        public Criteria andWapDescBetween(String value1, String value2) {
            return between(wapDesc, value1, value2);
        }

        public Criteria andWapDescNotBetween(String value1, String value2) {
            return notBetween(wapDesc, value1, value2);
        }
        public Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public Criteria andSellerCidsIsNull() {
            return isNull(sellerCids);
        }

        public Criteria andSellerCidsIsNotNull() {
            return isNotNull(sellerCids);
        }

        public Criteria andSellerCidsEqualTo(String value) {
            return equalTo(sellerCids, value);
        }

        public Criteria andSellerCidsNotEqualTo(String value) {
            return notEqualTo(sellerCids, value);
        }

        public Criteria andSellerCidsGreaterThan(String value) {
            return greaterThan(sellerCids, value);
        }

        public Criteria andSellerCidsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellerCids, value);
        }

        public Criteria andSellerCidsLessThan(String value) {
            return lessThan(sellerCids, value);
        }

        public Criteria andSellerCidsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellerCids, value);
        }

        public Criteria andSellerCidsLike(String value) {
            return like(sellerCids, value);
        }

        public Criteria andSellerCidsNotLike(String value) {
            return notLike(sellerCids, value);
        }

        public Criteria andSellerCidsIn(List<String> values) {
            return in(sellerCids, values);
        }

        public Criteria andSellerCidsNotIn(List<String> values) {
            return notIn(sellerCids, values);
        }

        public Criteria andSellerCidsBetween(String value1, String value2) {
            return between(sellerCids, value1, value2);
        }

        public Criteria andSellerCidsNotBetween(String value1, String value2) {
            return notBetween(sellerCids, value1, value2);
        }
        public Criteria andHasInvoiceIsNull() {
            return isNull(hasInvoice);
        }

        public Criteria andHasInvoiceIsNotNull() {
            return isNotNull(hasInvoice);
        }

        public Criteria andHasInvoiceEqualTo(String value) {
            return equalTo(hasInvoice, value);
        }

        public Criteria andHasInvoiceNotEqualTo(String value) {
            return notEqualTo(hasInvoice, value);
        }

        public Criteria andHasInvoiceGreaterThan(String value) {
            return greaterThan(hasInvoice, value);
        }

        public Criteria andHasInvoiceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(hasInvoice, value);
        }

        public Criteria andHasInvoiceLessThan(String value) {
            return lessThan(hasInvoice, value);
        }

        public Criteria andHasInvoiceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(hasInvoice, value);
        }

        public Criteria andHasInvoiceLike(String value) {
            return like(hasInvoice, value);
        }

        public Criteria andHasInvoiceNotLike(String value) {
            return notLike(hasInvoice, value);
        }

        public Criteria andHasInvoiceIn(List<String> values) {
            return in(hasInvoice, values);
        }

        public Criteria andHasInvoiceNotIn(List<String> values) {
            return notIn(hasInvoice, values);
        }

        public Criteria andHasInvoiceBetween(String value1, String value2) {
            return between(hasInvoice, value1, value2);
        }

        public Criteria andHasInvoiceNotBetween(String value1, String value2) {
            return notBetween(hasInvoice, value1, value2);
        }
        public Criteria andIncrementIsNull() {
            return isNull(increment);
        }

        public Criteria andIncrementIsNotNull() {
            return isNotNull(increment);
        }

        public Criteria andIncrementEqualTo(String value) {
            return equalTo(increment, value);
        }

        public Criteria andIncrementNotEqualTo(String value) {
            return notEqualTo(increment, value);
        }

        public Criteria andIncrementGreaterThan(String value) {
            return greaterThan(increment, value);
        }

        public Criteria andIncrementGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(increment, value);
        }

        public Criteria andIncrementLessThan(String value) {
            return lessThan(increment, value);
        }

        public Criteria andIncrementLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(increment, value);
        }

        public Criteria andIncrementLike(String value) {
            return like(increment, value);
        }

        public Criteria andIncrementNotLike(String value) {
            return notLike(increment, value);
        }

        public Criteria andIncrementIn(List<String> values) {
            return in(increment, values);
        }

        public Criteria andIncrementNotIn(List<String> values) {
            return notIn(increment, values);
        }

        public Criteria andIncrementBetween(String value1, String value2) {
            return between(increment, value1, value2);
        }

        public Criteria andIncrementNotBetween(String value1, String value2) {
            return notBetween(increment, value1, value2);
        }
        public Criteria andAfterSaleIdIsNull() {
            return isNull(afterSaleId);
        }

        public Criteria andAfterSaleIdIsNotNull() {
            return isNotNull(afterSaleId);
        }

        public Criteria andAfterSaleIdEqualTo(Long value) {
            return equalTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdGreaterThan(Long value) {
            return greaterThan(afterSaleId, value);
        }

        public Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdLessThan(Long value) {
            return lessThan(afterSaleId, value);
        }

        public Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleId, value);
        }

        public Criteria andAfterSaleIdIn(List<Long> values) {
            return in(afterSaleId, values);
        }

        public Criteria andAfterSaleIdNotIn(List<Long> values) {
            return notIn(afterSaleId, values);
        }

        public Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            return between(afterSaleId, value1, value2);
        }

        public Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleId, value1, value2);
        }
        public Criteria andIsExIsNull() {
            return isNull(isEx);
        }

        public Criteria andIsExIsNotNull() {
            return isNotNull(isEx);
        }

        public Criteria andIsExEqualTo(String value) {
            return equalTo(isEx, value);
        }

        public Criteria andIsExNotEqualTo(String value) {
            return notEqualTo(isEx, value);
        }

        public Criteria andIsExGreaterThan(String value) {
            return greaterThan(isEx, value);
        }

        public Criteria andIsExGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isEx, value);
        }

        public Criteria andIsExLessThan(String value) {
            return lessThan(isEx, value);
        }

        public Criteria andIsExLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isEx, value);
        }

        public Criteria andIsExLike(String value) {
            return like(isEx, value);
        }

        public Criteria andIsExNotLike(String value) {
            return notLike(isEx, value);
        }

        public Criteria andIsExIn(List<String> values) {
            return in(isEx, values);
        }

        public Criteria andIsExNotIn(List<String> values) {
            return notIn(isEx, values);
        }

        public Criteria andIsExBetween(String value1, String value2) {
            return between(isEx, value1, value2);
        }

        public Criteria andIsExNotBetween(String value1, String value2) {
            return notBetween(isEx, value1, value2);
        }
        public Criteria andSecondKillIsNull() {
            return isNull(secondKill);
        }

        public Criteria andSecondKillIsNotNull() {
            return isNotNull(secondKill);
        }

        public Criteria andSecondKillEqualTo(String value) {
            return equalTo(secondKill, value);
        }

        public Criteria andSecondKillNotEqualTo(String value) {
            return notEqualTo(secondKill, value);
        }

        public Criteria andSecondKillGreaterThan(String value) {
            return greaterThan(secondKill, value);
        }

        public Criteria andSecondKillGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(secondKill, value);
        }

        public Criteria andSecondKillLessThan(String value) {
            return lessThan(secondKill, value);
        }

        public Criteria andSecondKillLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(secondKill, value);
        }

        public Criteria andSecondKillLike(String value) {
            return like(secondKill, value);
        }

        public Criteria andSecondKillNotLike(String value) {
            return notLike(secondKill, value);
        }

        public Criteria andSecondKillIn(List<String> values) {
            return in(secondKill, values);
        }

        public Criteria andSecondKillNotIn(List<String> values) {
            return notIn(secondKill, values);
        }

        public Criteria andSecondKillBetween(String value1, String value2) {
            return between(secondKill, value1, value2);
        }

        public Criteria andSecondKillNotBetween(String value1, String value2) {
            return notBetween(secondKill, value1, value2);
        }
        public Criteria andLoadDateIsNull() {
            return isNull(loadDate);
        }

        public Criteria andLoadDateIsNotNull() {
            return isNotNull(loadDate);
        }

        public Criteria andLoadDateEqualTo(Date value) {
            return equalTo(loadDate, value);
        }

        public Criteria andLoadDateNotEqualTo(Date value) {
            return notEqualTo(loadDate, value);
        }

        public Criteria andLoadDateGreaterThan(Date value) {
            return greaterThan(loadDate, value);
        }

        public Criteria andLoadDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(loadDate, value);
        }

        public Criteria andLoadDateLessThan(Date value) {
            return lessThan(loadDate, value);
        }

        public Criteria andLoadDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(loadDate, value);
        }

        public Criteria andLoadDateIn(List<Date> values) {
            return in(loadDate, values);
        }

        public Criteria andLoadDateNotIn(List<Date> values) {
            return notIn(loadDate, values);
        }

        public Criteria andLoadDateBetween(Date value1, Date value2) {
            return between(loadDate, value1, value2);
        }

        public Criteria andLoadDateNotBetween(Date value1, Date value2) {
            return notBetween(loadDate, value1, value2);
        }
        public Criteria andIsTaobaoIsNull() {
            return isNull(isTaobao);
        }

        public Criteria andIsTaobaoIsNotNull() {
            return isNotNull(isTaobao);
        }

        public Criteria andIsTaobaoEqualTo(String value) {
            return equalTo(isTaobao, value);
        }

        public Criteria andIsTaobaoNotEqualTo(String value) {
            return notEqualTo(isTaobao, value);
        }

        public Criteria andIsTaobaoGreaterThan(String value) {
            return greaterThan(isTaobao, value);
        }

        public Criteria andIsTaobaoGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(isTaobao, value);
        }

        public Criteria andIsTaobaoLessThan(String value) {
            return lessThan(isTaobao, value);
        }

        public Criteria andIsTaobaoLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(isTaobao, value);
        }

        public Criteria andIsTaobaoLike(String value) {
            return like(isTaobao, value);
        }

        public Criteria andIsTaobaoNotLike(String value) {
            return notLike(isTaobao, value);
        }

        public Criteria andIsTaobaoIn(List<String> values) {
            return in(isTaobao, values);
        }

        public Criteria andIsTaobaoNotIn(List<String> values) {
            return notIn(isTaobao, values);
        }

        public Criteria andIsTaobaoBetween(String value1, String value2) {
            return between(isTaobao, value1, value2);
        }

        public Criteria andIsTaobaoNotBetween(String value1, String value2) {
            return notBetween(isTaobao, value1, value2);
        }
        public Criteria andNoloseIsNull() {
            return isNull(nolose);
        }

        public Criteria andNoloseIsNotNull() {
            return isNotNull(nolose);
        }

        public Criteria andNoloseEqualTo(Long value) {
            return equalTo(nolose, value);
        }

        public Criteria andNoloseNotEqualTo(Long value) {
            return notEqualTo(nolose, value);
        }

        public Criteria andNoloseGreaterThan(Long value) {
            return greaterThan(nolose, value);
        }

        public Criteria andNoloseGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(nolose, value);
        }

        public Criteria andNoloseLessThan(Long value) {
            return lessThan(nolose, value);
        }

        public Criteria andNoloseLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(nolose, value);
        }

        public Criteria andNoloseIn(List<Long> values) {
            return in(nolose, values);
        }

        public Criteria andNoloseNotIn(List<Long> values) {
            return notIn(nolose, values);
        }

        public Criteria andNoloseBetween(Long value1, Long value2) {
            return between(nolose, value1, value2);
        }

        public Criteria andNoloseNotBetween(Long value1, Long value2) {
            return notBetween(nolose, value1, value2);
        }
        public Criteria andWirelessDescIsNull() {
            return isNull(wirelessDesc);
        }

        public Criteria andWirelessDescIsNotNull() {
            return isNotNull(wirelessDesc);
        }

        public Criteria andWirelessDescEqualTo(String value) {
            return equalTo(wirelessDesc, value);
        }

        public Criteria andWirelessDescNotEqualTo(String value) {
            return notEqualTo(wirelessDesc, value);
        }

        public Criteria andWirelessDescGreaterThan(String value) {
            return greaterThan(wirelessDesc, value);
        }

        public Criteria andWirelessDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(wirelessDesc, value);
        }

        public Criteria andWirelessDescLessThan(String value) {
            return lessThan(wirelessDesc, value);
        }

        public Criteria andWirelessDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(wirelessDesc, value);
        }

        public Criteria andWirelessDescLike(String value) {
            return like(wirelessDesc, value);
        }

        public Criteria andWirelessDescNotLike(String value) {
            return notLike(wirelessDesc, value);
        }

        public Criteria andWirelessDescIn(List<String> values) {
            return in(wirelessDesc, values);
        }

        public Criteria andWirelessDescNotIn(List<String> values) {
            return notIn(wirelessDesc, values);
        }

        public Criteria andWirelessDescBetween(String value1, String value2) {
            return between(wirelessDesc, value1, value2);
        }

        public Criteria andWirelessDescNotBetween(String value1, String value2) {
            return notBetween(wirelessDesc, value1, value2);
        }
        public Criteria andSubStockIsNull() {
            return isNull(subStock);
        }

        public Criteria andSubStockIsNotNull() {
            return isNotNull(subStock);
        }

        public Criteria andSubStockEqualTo(Long value) {
            return equalTo(subStock, value);
        }

        public Criteria andSubStockNotEqualTo(Long value) {
            return notEqualTo(subStock, value);
        }

        public Criteria andSubStockGreaterThan(Long value) {
            return greaterThan(subStock, value);
        }

        public Criteria andSubStockGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subStock, value);
        }

        public Criteria andSubStockLessThan(Long value) {
            return lessThan(subStock, value);
        }

        public Criteria andSubStockLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subStock, value);
        }

        public Criteria andSubStockIn(List<Long> values) {
            return in(subStock, values);
        }

        public Criteria andSubStockNotIn(List<Long> values) {
            return notIn(subStock, values);
        }

        public Criteria andSubStockBetween(Long value1, Long value2) {
            return between(subStock, value1, value2);
        }

        public Criteria andSubStockNotBetween(Long value1, Long value2) {
            return notBetween(subStock, value1, value2);
        }
        public Criteria andOneStationIsNull() {
            return isNull(oneStation);
        }

        public Criteria andOneStationIsNotNull() {
            return isNotNull(oneStation);
        }

        public Criteria andOneStationEqualTo(String value) {
            return equalTo(oneStation, value);
        }

        public Criteria andOneStationNotEqualTo(String value) {
            return notEqualTo(oneStation, value);
        }

        public Criteria andOneStationGreaterThan(String value) {
            return greaterThan(oneStation, value);
        }

        public Criteria andOneStationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(oneStation, value);
        }

        public Criteria andOneStationLessThan(String value) {
            return lessThan(oneStation, value);
        }

        public Criteria andOneStationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(oneStation, value);
        }

        public Criteria andOneStationLike(String value) {
            return like(oneStation, value);
        }

        public Criteria andOneStationNotLike(String value) {
            return notLike(oneStation, value);
        }

        public Criteria andOneStationIn(List<String> values) {
            return in(oneStation, values);
        }

        public Criteria andOneStationNotIn(List<String> values) {
            return notIn(oneStation, values);
        }

        public Criteria andOneStationBetween(String value1, String value2) {
            return between(oneStation, value1, value2);
        }

        public Criteria andOneStationNotBetween(String value1, String value2) {
            return notBetween(oneStation, value1, value2);
        }
        public Criteria andItemWeightIsNull() {
            return isNull(itemWeight);
        }

        public Criteria andItemWeightIsNotNull() {
            return isNotNull(itemWeight);
        }

        public Criteria andItemWeightEqualTo(String value) {
            return equalTo(itemWeight, value);
        }

        public Criteria andItemWeightNotEqualTo(String value) {
            return notEqualTo(itemWeight, value);
        }

        public Criteria andItemWeightGreaterThan(String value) {
            return greaterThan(itemWeight, value);
        }

        public Criteria andItemWeightGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(itemWeight, value);
        }

        public Criteria andItemWeightLessThan(String value) {
            return lessThan(itemWeight, value);
        }

        public Criteria andItemWeightLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(itemWeight, value);
        }

        public Criteria andItemWeightLike(String value) {
            return like(itemWeight, value);
        }

        public Criteria andItemWeightNotLike(String value) {
            return notLike(itemWeight, value);
        }

        public Criteria andItemWeightIn(List<String> values) {
            return in(itemWeight, values);
        }

        public Criteria andItemWeightNotIn(List<String> values) {
            return notIn(itemWeight, values);
        }

        public Criteria andItemWeightBetween(String value1, String value2) {
            return between(itemWeight, value1, value2);
        }

        public Criteria andItemWeightNotBetween(String value1, String value2) {
            return notBetween(itemWeight, value1, value2);
        }
        public Criteria andPropertyAliasIsNull() {
            return isNull(propertyAlias);
        }

        public Criteria andPropertyAliasIsNotNull() {
            return isNotNull(propertyAlias);
        }

        public Criteria andPropertyAliasEqualTo(String value) {
            return equalTo(propertyAlias, value);
        }

        public Criteria andPropertyAliasNotEqualTo(String value) {
            return notEqualTo(propertyAlias, value);
        }

        public Criteria andPropertyAliasGreaterThan(String value) {
            return greaterThan(propertyAlias, value);
        }

        public Criteria andPropertyAliasGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propertyAlias, value);
        }

        public Criteria andPropertyAliasLessThan(String value) {
            return lessThan(propertyAlias, value);
        }

        public Criteria andPropertyAliasLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propertyAlias, value);
        }

        public Criteria andPropertyAliasLike(String value) {
            return like(propertyAlias, value);
        }

        public Criteria andPropertyAliasNotLike(String value) {
            return notLike(propertyAlias, value);
        }

        public Criteria andPropertyAliasIn(List<String> values) {
            return in(propertyAlias, values);
        }

        public Criteria andPropertyAliasNotIn(List<String> values) {
            return notIn(propertyAlias, values);
        }

        public Criteria andPropertyAliasBetween(String value1, String value2) {
            return between(propertyAlias, value1, value2);
        }

        public Criteria andPropertyAliasNotBetween(String value1, String value2) {
            return notBetween(propertyAlias, value1, value2);
        }
        public Criteria andUpdateTimeIsNull() {
            return isNull(updateTime);
        }

        public Criteria andUpdateTimeIsNotNull() {
            return isNotNull(updateTime);
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            return equalTo(updateTime, value);
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            return notEqualTo(updateTime, value);
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            return greaterThan(updateTime, value);
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(updateTime, value);
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            return lessThan(updateTime, value);
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(updateTime, value);
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            return in(updateTime, values);
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            return notIn(updateTime, values);
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            return between(updateTime, value1, value2);
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            return notBetween(updateTime, value1, value2);
        }
        public Criteria andWithHoldQuantityIsNull() {
            return isNull(withHoldQuantity);
        }

        public Criteria andWithHoldQuantityIsNotNull() {
            return isNotNull(withHoldQuantity);
        }

        public Criteria andWithHoldQuantityEqualTo(Long value) {
            return equalTo(withHoldQuantity, value);
        }

        public Criteria andWithHoldQuantityNotEqualTo(Long value) {
            return notEqualTo(withHoldQuantity, value);
        }

        public Criteria andWithHoldQuantityGreaterThan(Long value) {
            return greaterThan(withHoldQuantity, value);
        }

        public Criteria andWithHoldQuantityGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(withHoldQuantity, value);
        }

        public Criteria andWithHoldQuantityLessThan(Long value) {
            return lessThan(withHoldQuantity, value);
        }

        public Criteria andWithHoldQuantityLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(withHoldQuantity, value);
        }

        public Criteria andWithHoldQuantityIn(List<Long> values) {
            return in(withHoldQuantity, values);
        }

        public Criteria andWithHoldQuantityNotIn(List<Long> values) {
            return notIn(withHoldQuantity, values);
        }

        public Criteria andWithHoldQuantityBetween(Long value1, Long value2) {
            return between(withHoldQuantity, value1, value2);
        }

        public Criteria andWithHoldQuantityNotBetween(Long value1, Long value2) {
            return notBetween(withHoldQuantity, value1, value2);
        }
        public Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
    }
}
