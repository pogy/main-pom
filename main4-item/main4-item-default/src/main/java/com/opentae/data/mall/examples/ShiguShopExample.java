package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguShop;

import java.util.*;
public class ShiguShopExample extends SgExample<ShiguShopExample.Criteria> {
    public static final Class<ShiguShop> beanClass = ShiguShop.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn mainBus;
    public static EntityColumn itemLinkId;
    public static EntityColumn shopNum;
    public static EntityColumn shopName;
    public static EntityColumn taobaoUrl;
    public static EntityColumn tbNick;
    public static EntityColumn marketId;
    public static EntityColumn imAliww;
    public static EntityColumn floorId;
    public static EntityColumn webSite;
    public static EntityColumn expiresIn;
    public static EntityColumn shopStatus;
    public static EntityColumn imWx;
    public static EntityColumn imQq;
    public static EntityColumn userNick;
    public static EntityColumn shopAnnouncement;
    public static EntityColumn shopId;
    public static EntityColumn closeReason;
    public static EntityColumn displayInMarket;
    public static EntityColumn email;
    public static EntityColumn shopTagsContexts;
    public static EntityColumn createDate;
    public static EntityColumn systemRecommon;
    public static EntityColumn address;
    public static EntityColumn freshTime;
    public static EntityColumn userManager;
    public static EntityColumn telephone;
    public static EntityColumn userName;
    public static EntityColumn userId;
    public static EntityColumn synTaobao;
    public static EntityColumn priceRule;
    public static EntityColumn zipcode;
    public static EntityColumn dataPacketUrl;
    public static EntityColumn marketName;
    public static EntityColumn mobilePhone;
    public static EntityColumn sortOrderKey;
    public static EntityColumn domain;
    public static EntityColumn lastModifyTime;
    public static EntityColumn parentMarketName;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        mainBus = listMap.get("mainBus");
        itemLinkId = listMap.get("itemLinkId");
        shopNum = listMap.get("shopNum");
        shopName = listMap.get("shopName");
        taobaoUrl = listMap.get("taobaoUrl");
        tbNick = listMap.get("tbNick");
        marketId = listMap.get("marketId");
        imAliww = listMap.get("imAliww");
        floorId = listMap.get("floorId");
        webSite = listMap.get("webSite");
        expiresIn = listMap.get("expiresIn");
        shopStatus = listMap.get("shopStatus");
        imWx = listMap.get("imWx");
        imQq = listMap.get("imQq");
        userNick = listMap.get("userNick");
        shopAnnouncement = listMap.get("shopAnnouncement");
        shopId = listMap.get("shopId");
        closeReason = listMap.get("closeReason");
        displayInMarket = listMap.get("displayInMarket");
        email = listMap.get("email");
        shopTagsContexts = listMap.get("shopTagsContexts");
        createDate = listMap.get("createDate");
        systemRecommon = listMap.get("systemRecommon");
        address = listMap.get("address");
        freshTime = listMap.get("freshTime");
        userManager = listMap.get("userManager");
        telephone = listMap.get("telephone");
        userName = listMap.get("userName");
        userId = listMap.get("userId");
        synTaobao = listMap.get("synTaobao");
        priceRule = listMap.get("priceRule");
        zipcode = listMap.get("zipcode");
        dataPacketUrl = listMap.get("dataPacketUrl");
        marketName = listMap.get("marketName");
        mobilePhone = listMap.get("mobilePhone");
        sortOrderKey = listMap.get("sortOrderKey");
        domain = listMap.get("domain");
        lastModifyTime = listMap.get("lastModifyTime");
        parentMarketName = listMap.get("parentMarketName");
        }

    public ShiguShopExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguShopExample.Criteria createCriteriaInternal() {
        return new ShiguShopExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguShopExample.Criteria andMainBusIsNull() {
            return isNull(mainBus);
        }

        public ShiguShopExample.Criteria andMainBusIsNotNull() {
            return isNotNull(mainBus);
        }

        public ShiguShopExample.Criteria andMainBusEqualTo(String value) {
            return equalTo(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusNotEqualTo(String value) {
            return notEqualTo(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusGreaterThan(String value) {
            return greaterThan(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusLessThan(String value) {
            return lessThan(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusLike(String value) {
            return like(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusNotLike(String value) {
            return notLike(mainBus, value);
        }

        public ShiguShopExample.Criteria andMainBusIn(List<String> values) {
            return in(mainBus, values);
        }

        public ShiguShopExample.Criteria andMainBusNotIn(List<String> values) {
            return notIn(mainBus, values);
        }

        public ShiguShopExample.Criteria andMainBusBetween(String value1, String value2) {
            return between(mainBus, value1, value2);
        }

        public ShiguShopExample.Criteria andMainBusNotBetween(String value1, String value2) {
            return notBetween(mainBus, value1, value2);
        }
        public ShiguShopExample.Criteria andItemLinkIdIsNull() {
            return isNull(itemLinkId);
        }

        public ShiguShopExample.Criteria andItemLinkIdIsNotNull() {
            return isNotNull(itemLinkId);
        }

        public ShiguShopExample.Criteria andItemLinkIdEqualTo(Long value) {
            return equalTo(itemLinkId, value);
        }

        public ShiguShopExample.Criteria andItemLinkIdNotEqualTo(Long value) {
            return notEqualTo(itemLinkId, value);
        }

        public ShiguShopExample.Criteria andItemLinkIdGreaterThan(Long value) {
            return greaterThan(itemLinkId, value);
        }

        public ShiguShopExample.Criteria andItemLinkIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(itemLinkId, value);
        }

        public ShiguShopExample.Criteria andItemLinkIdLessThan(Long value) {
            return lessThan(itemLinkId, value);
        }

        public ShiguShopExample.Criteria andItemLinkIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(itemLinkId, value);
        }

        public ShiguShopExample.Criteria andItemLinkIdIn(List<Long> values) {
            return in(itemLinkId, values);
        }

        public ShiguShopExample.Criteria andItemLinkIdNotIn(List<Long> values) {
            return notIn(itemLinkId, values);
        }

        public ShiguShopExample.Criteria andItemLinkIdBetween(Long value1, Long value2) {
            return between(itemLinkId, value1, value2);
        }

        public ShiguShopExample.Criteria andItemLinkIdNotBetween(Long value1, Long value2) {
            return notBetween(itemLinkId, value1, value2);
        }
        public ShiguShopExample.Criteria andShopNumIsNull() {
            return isNull(shopNum);
        }

        public ShiguShopExample.Criteria andShopNumIsNotNull() {
            return isNotNull(shopNum);
        }

        public ShiguShopExample.Criteria andShopNumEqualTo(String value) {
            return equalTo(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumNotEqualTo(String value) {
            return notEqualTo(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumGreaterThan(String value) {
            return greaterThan(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumLessThan(String value) {
            return lessThan(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumLike(String value) {
            return like(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumNotLike(String value) {
            return notLike(shopNum, value);
        }

        public ShiguShopExample.Criteria andShopNumIn(List<String> values) {
            return in(shopNum, values);
        }

        public ShiguShopExample.Criteria andShopNumNotIn(List<String> values) {
            return notIn(shopNum, values);
        }

        public ShiguShopExample.Criteria andShopNumBetween(String value1, String value2) {
            return between(shopNum, value1, value2);
        }

        public ShiguShopExample.Criteria andShopNumNotBetween(String value1, String value2) {
            return notBetween(shopNum, value1, value2);
        }
        public ShiguShopExample.Criteria andShopNameIsNull() {
            return isNull(shopName);
        }

        public ShiguShopExample.Criteria andShopNameIsNotNull() {
            return isNotNull(shopName);
        }

        public ShiguShopExample.Criteria andShopNameEqualTo(String value) {
            return equalTo(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameNotEqualTo(String value) {
            return notEqualTo(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameGreaterThan(String value) {
            return greaterThan(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameLessThan(String value) {
            return lessThan(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameLike(String value) {
            return like(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameNotLike(String value) {
            return notLike(shopName, value);
        }

        public ShiguShopExample.Criteria andShopNameIn(List<String> values) {
            return in(shopName, values);
        }

        public ShiguShopExample.Criteria andShopNameNotIn(List<String> values) {
            return notIn(shopName, values);
        }

        public ShiguShopExample.Criteria andShopNameBetween(String value1, String value2) {
            return between(shopName, value1, value2);
        }

        public ShiguShopExample.Criteria andShopNameNotBetween(String value1, String value2) {
            return notBetween(shopName, value1, value2);
        }
        public ShiguShopExample.Criteria andTaobaoUrlIsNull() {
            return isNull(taobaoUrl);
        }

        public ShiguShopExample.Criteria andTaobaoUrlIsNotNull() {
            return isNotNull(taobaoUrl);
        }

        public ShiguShopExample.Criteria andTaobaoUrlEqualTo(String value) {
            return equalTo(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotEqualTo(String value) {
            return notEqualTo(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlGreaterThan(String value) {
            return greaterThan(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlLessThan(String value) {
            return lessThan(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlLike(String value) {
            return like(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotLike(String value) {
            return notLike(taobaoUrl, value);
        }

        public ShiguShopExample.Criteria andTaobaoUrlIn(List<String> values) {
            return in(taobaoUrl, values);
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotIn(List<String> values) {
            return notIn(taobaoUrl, values);
        }

        public ShiguShopExample.Criteria andTaobaoUrlBetween(String value1, String value2) {
            return between(taobaoUrl, value1, value2);
        }

        public ShiguShopExample.Criteria andTaobaoUrlNotBetween(String value1, String value2) {
            return notBetween(taobaoUrl, value1, value2);
        }
        public ShiguShopExample.Criteria andTbNickIsNull() {
            return isNull(tbNick);
        }

        public ShiguShopExample.Criteria andTbNickIsNotNull() {
            return isNotNull(tbNick);
        }

        public ShiguShopExample.Criteria andTbNickEqualTo(String value) {
            return equalTo(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickNotEqualTo(String value) {
            return notEqualTo(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickGreaterThan(String value) {
            return greaterThan(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickLessThan(String value) {
            return lessThan(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickLike(String value) {
            return like(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickNotLike(String value) {
            return notLike(tbNick, value);
        }

        public ShiguShopExample.Criteria andTbNickIn(List<String> values) {
            return in(tbNick, values);
        }

        public ShiguShopExample.Criteria andTbNickNotIn(List<String> values) {
            return notIn(tbNick, values);
        }

        public ShiguShopExample.Criteria andTbNickBetween(String value1, String value2) {
            return between(tbNick, value1, value2);
        }

        public ShiguShopExample.Criteria andTbNickNotBetween(String value1, String value2) {
            return notBetween(tbNick, value1, value2);
        }
        public ShiguShopExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguShopExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguShopExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguShopExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguShopExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguShopExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguShopExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguShopExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguShopExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguShopExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguShopExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguShopExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ShiguShopExample.Criteria andImAliwwIsNull() {
            return isNull(imAliww);
        }

        public ShiguShopExample.Criteria andImAliwwIsNotNull() {
            return isNotNull(imAliww);
        }

        public ShiguShopExample.Criteria andImAliwwEqualTo(String value) {
            return equalTo(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwNotEqualTo(String value) {
            return notEqualTo(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwGreaterThan(String value) {
            return greaterThan(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwLessThan(String value) {
            return lessThan(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwLike(String value) {
            return like(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwNotLike(String value) {
            return notLike(imAliww, value);
        }

        public ShiguShopExample.Criteria andImAliwwIn(List<String> values) {
            return in(imAliww, values);
        }

        public ShiguShopExample.Criteria andImAliwwNotIn(List<String> values) {
            return notIn(imAliww, values);
        }

        public ShiguShopExample.Criteria andImAliwwBetween(String value1, String value2) {
            return between(imAliww, value1, value2);
        }

        public ShiguShopExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            return notBetween(imAliww, value1, value2);
        }
        public ShiguShopExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public ShiguShopExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public ShiguShopExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public ShiguShopExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public ShiguShopExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public ShiguShopExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public ShiguShopExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public ShiguShopExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public ShiguShopExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public ShiguShopExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public ShiguShopExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public ShiguShopExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public ShiguShopExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguShopExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguShopExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguShopExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguShopExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguShopExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguShopExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguShopExample.Criteria andExpiresInIsNull() {
            return isNull(expiresIn);
        }

        public ShiguShopExample.Criteria andExpiresInIsNotNull() {
            return isNotNull(expiresIn);
        }

        public ShiguShopExample.Criteria andExpiresInEqualTo(Long value) {
            return equalTo(expiresIn, value);
        }

        public ShiguShopExample.Criteria andExpiresInNotEqualTo(Long value) {
            return notEqualTo(expiresIn, value);
        }

        public ShiguShopExample.Criteria andExpiresInGreaterThan(Long value) {
            return greaterThan(expiresIn, value);
        }

        public ShiguShopExample.Criteria andExpiresInGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expiresIn, value);
        }

        public ShiguShopExample.Criteria andExpiresInLessThan(Long value) {
            return lessThan(expiresIn, value);
        }

        public ShiguShopExample.Criteria andExpiresInLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expiresIn, value);
        }

        public ShiguShopExample.Criteria andExpiresInIn(List<Long> values) {
            return in(expiresIn, values);
        }

        public ShiguShopExample.Criteria andExpiresInNotIn(List<Long> values) {
            return notIn(expiresIn, values);
        }

        public ShiguShopExample.Criteria andExpiresInBetween(Long value1, Long value2) {
            return between(expiresIn, value1, value2);
        }

        public ShiguShopExample.Criteria andExpiresInNotBetween(Long value1, Long value2) {
            return notBetween(expiresIn, value1, value2);
        }
        public ShiguShopExample.Criteria andShopStatusIsNull() {
            return isNull(shopStatus);
        }

        public ShiguShopExample.Criteria andShopStatusIsNotNull() {
            return isNotNull(shopStatus);
        }

        public ShiguShopExample.Criteria andShopStatusEqualTo(Integer value) {
            return equalTo(shopStatus, value);
        }

        public ShiguShopExample.Criteria andShopStatusNotEqualTo(Integer value) {
            return notEqualTo(shopStatus, value);
        }

        public ShiguShopExample.Criteria andShopStatusGreaterThan(Integer value) {
            return greaterThan(shopStatus, value);
        }

        public ShiguShopExample.Criteria andShopStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(shopStatus, value);
        }

        public ShiguShopExample.Criteria andShopStatusLessThan(Integer value) {
            return lessThan(shopStatus, value);
        }

        public ShiguShopExample.Criteria andShopStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(shopStatus, value);
        }

        public ShiguShopExample.Criteria andShopStatusIn(List<Integer> values) {
            return in(shopStatus, values);
        }

        public ShiguShopExample.Criteria andShopStatusNotIn(List<Integer> values) {
            return notIn(shopStatus, values);
        }

        public ShiguShopExample.Criteria andShopStatusBetween(Integer value1, Integer value2) {
            return between(shopStatus, value1, value2);
        }

        public ShiguShopExample.Criteria andShopStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(shopStatus, value1, value2);
        }
        public ShiguShopExample.Criteria andImWxIsNull() {
            return isNull(imWx);
        }

        public ShiguShopExample.Criteria andImWxIsNotNull() {
            return isNotNull(imWx);
        }

        public ShiguShopExample.Criteria andImWxEqualTo(String value) {
            return equalTo(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxNotEqualTo(String value) {
            return notEqualTo(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxGreaterThan(String value) {
            return greaterThan(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxLessThan(String value) {
            return lessThan(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxLike(String value) {
            return like(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxNotLike(String value) {
            return notLike(imWx, value);
        }

        public ShiguShopExample.Criteria andImWxIn(List<String> values) {
            return in(imWx, values);
        }

        public ShiguShopExample.Criteria andImWxNotIn(List<String> values) {
            return notIn(imWx, values);
        }

        public ShiguShopExample.Criteria andImWxBetween(String value1, String value2) {
            return between(imWx, value1, value2);
        }

        public ShiguShopExample.Criteria andImWxNotBetween(String value1, String value2) {
            return notBetween(imWx, value1, value2);
        }
        public ShiguShopExample.Criteria andImQqIsNull() {
            return isNull(imQq);
        }

        public ShiguShopExample.Criteria andImQqIsNotNull() {
            return isNotNull(imQq);
        }

        public ShiguShopExample.Criteria andImQqEqualTo(String value) {
            return equalTo(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqNotEqualTo(String value) {
            return notEqualTo(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqGreaterThan(String value) {
            return greaterThan(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqLessThan(String value) {
            return lessThan(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqLike(String value) {
            return like(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqNotLike(String value) {
            return notLike(imQq, value);
        }

        public ShiguShopExample.Criteria andImQqIn(List<String> values) {
            return in(imQq, values);
        }

        public ShiguShopExample.Criteria andImQqNotIn(List<String> values) {
            return notIn(imQq, values);
        }

        public ShiguShopExample.Criteria andImQqBetween(String value1, String value2) {
            return between(imQq, value1, value2);
        }

        public ShiguShopExample.Criteria andImQqNotBetween(String value1, String value2) {
            return notBetween(imQq, value1, value2);
        }
        public ShiguShopExample.Criteria andUserNickIsNull() {
            return isNull(userNick);
        }

        public ShiguShopExample.Criteria andUserNickIsNotNull() {
            return isNotNull(userNick);
        }

        public ShiguShopExample.Criteria andUserNickEqualTo(String value) {
            return equalTo(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickNotEqualTo(String value) {
            return notEqualTo(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickGreaterThan(String value) {
            return greaterThan(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickLessThan(String value) {
            return lessThan(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickLike(String value) {
            return like(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickNotLike(String value) {
            return notLike(userNick, value);
        }

        public ShiguShopExample.Criteria andUserNickIn(List<String> values) {
            return in(userNick, values);
        }

        public ShiguShopExample.Criteria andUserNickNotIn(List<String> values) {
            return notIn(userNick, values);
        }

        public ShiguShopExample.Criteria andUserNickBetween(String value1, String value2) {
            return between(userNick, value1, value2);
        }

        public ShiguShopExample.Criteria andUserNickNotBetween(String value1, String value2) {
            return notBetween(userNick, value1, value2);
        }
        public ShiguShopExample.Criteria andShopAnnouncementIsNull() {
            return isNull(shopAnnouncement);
        }

        public ShiguShopExample.Criteria andShopAnnouncementIsNotNull() {
            return isNotNull(shopAnnouncement);
        }

        public ShiguShopExample.Criteria andShopAnnouncementEqualTo(String value) {
            return equalTo(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotEqualTo(String value) {
            return notEqualTo(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementGreaterThan(String value) {
            return greaterThan(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementLessThan(String value) {
            return lessThan(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementLike(String value) {
            return like(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotLike(String value) {
            return notLike(shopAnnouncement, value);
        }

        public ShiguShopExample.Criteria andShopAnnouncementIn(List<String> values) {
            return in(shopAnnouncement, values);
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotIn(List<String> values) {
            return notIn(shopAnnouncement, values);
        }

        public ShiguShopExample.Criteria andShopAnnouncementBetween(String value1, String value2) {
            return between(shopAnnouncement, value1, value2);
        }

        public ShiguShopExample.Criteria andShopAnnouncementNotBetween(String value1, String value2) {
            return notBetween(shopAnnouncement, value1, value2);
        }
        public ShiguShopExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShiguShopExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShiguShopExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShiguShopExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShiguShopExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShiguShopExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShiguShopExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShiguShopExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShiguShopExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShiguShopExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShiguShopExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShiguShopExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShiguShopExample.Criteria andCloseReasonIsNull() {
            return isNull(closeReason);
        }

        public ShiguShopExample.Criteria andCloseReasonIsNotNull() {
            return isNotNull(closeReason);
        }

        public ShiguShopExample.Criteria andCloseReasonEqualTo(String value) {
            return equalTo(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonNotEqualTo(String value) {
            return notEqualTo(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonGreaterThan(String value) {
            return greaterThan(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonLessThan(String value) {
            return lessThan(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonLike(String value) {
            return like(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonNotLike(String value) {
            return notLike(closeReason, value);
        }

        public ShiguShopExample.Criteria andCloseReasonIn(List<String> values) {
            return in(closeReason, values);
        }

        public ShiguShopExample.Criteria andCloseReasonNotIn(List<String> values) {
            return notIn(closeReason, values);
        }

        public ShiguShopExample.Criteria andCloseReasonBetween(String value1, String value2) {
            return between(closeReason, value1, value2);
        }

        public ShiguShopExample.Criteria andCloseReasonNotBetween(String value1, String value2) {
            return notBetween(closeReason, value1, value2);
        }
        public ShiguShopExample.Criteria andDisplayInMarketIsNull() {
            return isNull(displayInMarket);
        }

        public ShiguShopExample.Criteria andDisplayInMarketIsNotNull() {
            return isNotNull(displayInMarket);
        }

        public ShiguShopExample.Criteria andDisplayInMarketEqualTo(Long value) {
            return equalTo(displayInMarket, value);
        }

        public ShiguShopExample.Criteria andDisplayInMarketNotEqualTo(Long value) {
            return notEqualTo(displayInMarket, value);
        }

        public ShiguShopExample.Criteria andDisplayInMarketGreaterThan(Long value) {
            return greaterThan(displayInMarket, value);
        }

        public ShiguShopExample.Criteria andDisplayInMarketGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(displayInMarket, value);
        }

        public ShiguShopExample.Criteria andDisplayInMarketLessThan(Long value) {
            return lessThan(displayInMarket, value);
        }

        public ShiguShopExample.Criteria andDisplayInMarketLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(displayInMarket, value);
        }

        public ShiguShopExample.Criteria andDisplayInMarketIn(List<Long> values) {
            return in(displayInMarket, values);
        }

        public ShiguShopExample.Criteria andDisplayInMarketNotIn(List<Long> values) {
            return notIn(displayInMarket, values);
        }

        public ShiguShopExample.Criteria andDisplayInMarketBetween(Long value1, Long value2) {
            return between(displayInMarket, value1, value2);
        }

        public ShiguShopExample.Criteria andDisplayInMarketNotBetween(Long value1, Long value2) {
            return notBetween(displayInMarket, value1, value2);
        }
        public ShiguShopExample.Criteria andEmailIsNull() {
            return isNull(email);
        }

        public ShiguShopExample.Criteria andEmailIsNotNull() {
            return isNotNull(email);
        }

        public ShiguShopExample.Criteria andEmailEqualTo(String value) {
            return equalTo(email, value);
        }

        public ShiguShopExample.Criteria andEmailNotEqualTo(String value) {
            return notEqualTo(email, value);
        }

        public ShiguShopExample.Criteria andEmailGreaterThan(String value) {
            return greaterThan(email, value);
        }

        public ShiguShopExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(email, value);
        }

        public ShiguShopExample.Criteria andEmailLessThan(String value) {
            return lessThan(email, value);
        }

        public ShiguShopExample.Criteria andEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(email, value);
        }

        public ShiguShopExample.Criteria andEmailLike(String value) {
            return like(email, value);
        }

        public ShiguShopExample.Criteria andEmailNotLike(String value) {
            return notLike(email, value);
        }

        public ShiguShopExample.Criteria andEmailIn(List<String> values) {
            return in(email, values);
        }

        public ShiguShopExample.Criteria andEmailNotIn(List<String> values) {
            return notIn(email, values);
        }

        public ShiguShopExample.Criteria andEmailBetween(String value1, String value2) {
            return between(email, value1, value2);
        }

        public ShiguShopExample.Criteria andEmailNotBetween(String value1, String value2) {
            return notBetween(email, value1, value2);
        }
        public ShiguShopExample.Criteria andShopTagsContextsIsNull() {
            return isNull(shopTagsContexts);
        }

        public ShiguShopExample.Criteria andShopTagsContextsIsNotNull() {
            return isNotNull(shopTagsContexts);
        }

        public ShiguShopExample.Criteria andShopTagsContextsEqualTo(String value) {
            return equalTo(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsNotEqualTo(String value) {
            return notEqualTo(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsGreaterThan(String value) {
            return greaterThan(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsLessThan(String value) {
            return lessThan(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsLike(String value) {
            return like(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsNotLike(String value) {
            return notLike(shopTagsContexts, value);
        }

        public ShiguShopExample.Criteria andShopTagsContextsIn(List<String> values) {
            return in(shopTagsContexts, values);
        }

        public ShiguShopExample.Criteria andShopTagsContextsNotIn(List<String> values) {
            return notIn(shopTagsContexts, values);
        }

        public ShiguShopExample.Criteria andShopTagsContextsBetween(String value1, String value2) {
            return between(shopTagsContexts, value1, value2);
        }

        public ShiguShopExample.Criteria andShopTagsContextsNotBetween(String value1, String value2) {
            return notBetween(shopTagsContexts, value1, value2);
        }
        public ShiguShopExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public ShiguShopExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public ShiguShopExample.Criteria andCreateDateEqualTo(Date value) {
            return equalTo(createDate, value);
        }

        public ShiguShopExample.Criteria andCreateDateNotEqualTo(Date value) {
            return notEqualTo(createDate, value);
        }

        public ShiguShopExample.Criteria andCreateDateGreaterThan(Date value) {
            return greaterThan(createDate, value);
        }

        public ShiguShopExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public ShiguShopExample.Criteria andCreateDateLessThan(Date value) {
            return lessThan(createDate, value);
        }

        public ShiguShopExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public ShiguShopExample.Criteria andCreateDateIn(List<Date> values) {
            return in(createDate, values);
        }

        public ShiguShopExample.Criteria andCreateDateNotIn(List<Date> values) {
            return notIn(createDate, values);
        }

        public ShiguShopExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            return between(createDate, value1, value2);
        }

        public ShiguShopExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            return notBetween(createDate, value1, value2);
        }
        public ShiguShopExample.Criteria andSystemRecommonIsNull() {
            return isNull(systemRecommon);
        }

        public ShiguShopExample.Criteria andSystemRecommonIsNotNull() {
            return isNotNull(systemRecommon);
        }

        public ShiguShopExample.Criteria andSystemRecommonEqualTo(String value) {
            return equalTo(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonNotEqualTo(String value) {
            return notEqualTo(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonGreaterThan(String value) {
            return greaterThan(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonLessThan(String value) {
            return lessThan(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonLike(String value) {
            return like(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonNotLike(String value) {
            return notLike(systemRecommon, value);
        }

        public ShiguShopExample.Criteria andSystemRecommonIn(List<String> values) {
            return in(systemRecommon, values);
        }

        public ShiguShopExample.Criteria andSystemRecommonNotIn(List<String> values) {
            return notIn(systemRecommon, values);
        }

        public ShiguShopExample.Criteria andSystemRecommonBetween(String value1, String value2) {
            return between(systemRecommon, value1, value2);
        }

        public ShiguShopExample.Criteria andSystemRecommonNotBetween(String value1, String value2) {
            return notBetween(systemRecommon, value1, value2);
        }
        public ShiguShopExample.Criteria andAddressIsNull() {
            return isNull(address);
        }

        public ShiguShopExample.Criteria andAddressIsNotNull() {
            return isNotNull(address);
        }

        public ShiguShopExample.Criteria andAddressEqualTo(String value) {
            return equalTo(address, value);
        }

        public ShiguShopExample.Criteria andAddressNotEqualTo(String value) {
            return notEqualTo(address, value);
        }

        public ShiguShopExample.Criteria andAddressGreaterThan(String value) {
            return greaterThan(address, value);
        }

        public ShiguShopExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(address, value);
        }

        public ShiguShopExample.Criteria andAddressLessThan(String value) {
            return lessThan(address, value);
        }

        public ShiguShopExample.Criteria andAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(address, value);
        }

        public ShiguShopExample.Criteria andAddressLike(String value) {
            return like(address, value);
        }

        public ShiguShopExample.Criteria andAddressNotLike(String value) {
            return notLike(address, value);
        }

        public ShiguShopExample.Criteria andAddressIn(List<String> values) {
            return in(address, values);
        }

        public ShiguShopExample.Criteria andAddressNotIn(List<String> values) {
            return notIn(address, values);
        }

        public ShiguShopExample.Criteria andAddressBetween(String value1, String value2) {
            return between(address, value1, value2);
        }

        public ShiguShopExample.Criteria andAddressNotBetween(String value1, String value2) {
            return notBetween(address, value1, value2);
        }
        public ShiguShopExample.Criteria andFreshTimeIsNull() {
            return isNull(freshTime);
        }

        public ShiguShopExample.Criteria andFreshTimeIsNotNull() {
            return isNotNull(freshTime);
        }

        public ShiguShopExample.Criteria andFreshTimeEqualTo(Date value) {
            return equalTo(freshTime, value);
        }

        public ShiguShopExample.Criteria andFreshTimeNotEqualTo(Date value) {
            return notEqualTo(freshTime, value);
        }

        public ShiguShopExample.Criteria andFreshTimeGreaterThan(Date value) {
            return greaterThan(freshTime, value);
        }

        public ShiguShopExample.Criteria andFreshTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(freshTime, value);
        }

        public ShiguShopExample.Criteria andFreshTimeLessThan(Date value) {
            return lessThan(freshTime, value);
        }

        public ShiguShopExample.Criteria andFreshTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(freshTime, value);
        }

        public ShiguShopExample.Criteria andFreshTimeIn(List<Date> values) {
            return in(freshTime, values);
        }

        public ShiguShopExample.Criteria andFreshTimeNotIn(List<Date> values) {
            return notIn(freshTime, values);
        }

        public ShiguShopExample.Criteria andFreshTimeBetween(Date value1, Date value2) {
            return between(freshTime, value1, value2);
        }

        public ShiguShopExample.Criteria andFreshTimeNotBetween(Date value1, Date value2) {
            return notBetween(freshTime, value1, value2);
        }
        public ShiguShopExample.Criteria andUserManagerIsNull() {
            return isNull(userManager);
        }

        public ShiguShopExample.Criteria andUserManagerIsNotNull() {
            return isNotNull(userManager);
        }

        public ShiguShopExample.Criteria andUserManagerEqualTo(Integer value) {
            return equalTo(userManager, value);
        }

        public ShiguShopExample.Criteria andUserManagerNotEqualTo(Integer value) {
            return notEqualTo(userManager, value);
        }

        public ShiguShopExample.Criteria andUserManagerGreaterThan(Integer value) {
            return greaterThan(userManager, value);
        }

        public ShiguShopExample.Criteria andUserManagerGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(userManager, value);
        }

        public ShiguShopExample.Criteria andUserManagerLessThan(Integer value) {
            return lessThan(userManager, value);
        }

        public ShiguShopExample.Criteria andUserManagerLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(userManager, value);
        }

        public ShiguShopExample.Criteria andUserManagerIn(List<Integer> values) {
            return in(userManager, values);
        }

        public ShiguShopExample.Criteria andUserManagerNotIn(List<Integer> values) {
            return notIn(userManager, values);
        }

        public ShiguShopExample.Criteria andUserManagerBetween(Integer value1, Integer value2) {
            return between(userManager, value1, value2);
        }

        public ShiguShopExample.Criteria andUserManagerNotBetween(Integer value1, Integer value2) {
            return notBetween(userManager, value1, value2);
        }
        public ShiguShopExample.Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public ShiguShopExample.Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public ShiguShopExample.Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public ShiguShopExample.Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public ShiguShopExample.Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public ShiguShopExample.Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public ShiguShopExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public ShiguShopExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public ShiguShopExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public ShiguShopExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public ShiguShopExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public ShiguShopExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public ShiguShopExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public ShiguShopExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public ShiguShopExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguShopExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguShopExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguShopExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguShopExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguShopExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguShopExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguShopExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguShopExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguShopExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguShopExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguShopExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguShopExample.Criteria andSynTaobaoIsNull() {
            return isNull(synTaobao);
        }

        public ShiguShopExample.Criteria andSynTaobaoIsNotNull() {
            return isNotNull(synTaobao);
        }

        public ShiguShopExample.Criteria andSynTaobaoEqualTo(Integer value) {
            return equalTo(synTaobao, value);
        }

        public ShiguShopExample.Criteria andSynTaobaoNotEqualTo(Integer value) {
            return notEqualTo(synTaobao, value);
        }

        public ShiguShopExample.Criteria andSynTaobaoGreaterThan(Integer value) {
            return greaterThan(synTaobao, value);
        }

        public ShiguShopExample.Criteria andSynTaobaoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(synTaobao, value);
        }

        public ShiguShopExample.Criteria andSynTaobaoLessThan(Integer value) {
            return lessThan(synTaobao, value);
        }

        public ShiguShopExample.Criteria andSynTaobaoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(synTaobao, value);
        }

        public ShiguShopExample.Criteria andSynTaobaoIn(List<Integer> values) {
            return in(synTaobao, values);
        }

        public ShiguShopExample.Criteria andSynTaobaoNotIn(List<Integer> values) {
            return notIn(synTaobao, values);
        }

        public ShiguShopExample.Criteria andSynTaobaoBetween(Integer value1, Integer value2) {
            return between(synTaobao, value1, value2);
        }

        public ShiguShopExample.Criteria andSynTaobaoNotBetween(Integer value1, Integer value2) {
            return notBetween(synTaobao, value1, value2);
        }
        public ShiguShopExample.Criteria andPriceRuleIsNull() {
            return isNull(priceRule);
        }

        public ShiguShopExample.Criteria andPriceRuleIsNotNull() {
            return isNotNull(priceRule);
        }

        public ShiguShopExample.Criteria andPriceRuleEqualTo(String value) {
            return equalTo(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleNotEqualTo(String value) {
            return notEqualTo(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleGreaterThan(String value) {
            return greaterThan(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleLessThan(String value) {
            return lessThan(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleLike(String value) {
            return like(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleNotLike(String value) {
            return notLike(priceRule, value);
        }

        public ShiguShopExample.Criteria andPriceRuleIn(List<String> values) {
            return in(priceRule, values);
        }

        public ShiguShopExample.Criteria andPriceRuleNotIn(List<String> values) {
            return notIn(priceRule, values);
        }

        public ShiguShopExample.Criteria andPriceRuleBetween(String value1, String value2) {
            return between(priceRule, value1, value2);
        }

        public ShiguShopExample.Criteria andPriceRuleNotBetween(String value1, String value2) {
            return notBetween(priceRule, value1, value2);
        }
        public ShiguShopExample.Criteria andZipcodeIsNull() {
            return isNull(zipcode);
        }

        public ShiguShopExample.Criteria andZipcodeIsNotNull() {
            return isNotNull(zipcode);
        }

        public ShiguShopExample.Criteria andZipcodeEqualTo(String value) {
            return equalTo(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeNotEqualTo(String value) {
            return notEqualTo(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeGreaterThan(String value) {
            return greaterThan(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeLessThan(String value) {
            return lessThan(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeLike(String value) {
            return like(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeNotLike(String value) {
            return notLike(zipcode, value);
        }

        public ShiguShopExample.Criteria andZipcodeIn(List<String> values) {
            return in(zipcode, values);
        }

        public ShiguShopExample.Criteria andZipcodeNotIn(List<String> values) {
            return notIn(zipcode, values);
        }

        public ShiguShopExample.Criteria andZipcodeBetween(String value1, String value2) {
            return between(zipcode, value1, value2);
        }

        public ShiguShopExample.Criteria andZipcodeNotBetween(String value1, String value2) {
            return notBetween(zipcode, value1, value2);
        }
        public ShiguShopExample.Criteria andDataPacketUrlIsNull() {
            return isNull(dataPacketUrl);
        }

        public ShiguShopExample.Criteria andDataPacketUrlIsNotNull() {
            return isNotNull(dataPacketUrl);
        }

        public ShiguShopExample.Criteria andDataPacketUrlEqualTo(String value) {
            return equalTo(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotEqualTo(String value) {
            return notEqualTo(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlGreaterThan(String value) {
            return greaterThan(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlLessThan(String value) {
            return lessThan(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlLike(String value) {
            return like(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotLike(String value) {
            return notLike(dataPacketUrl, value);
        }

        public ShiguShopExample.Criteria andDataPacketUrlIn(List<String> values) {
            return in(dataPacketUrl, values);
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotIn(List<String> values) {
            return notIn(dataPacketUrl, values);
        }

        public ShiguShopExample.Criteria andDataPacketUrlBetween(String value1, String value2) {
            return between(dataPacketUrl, value1, value2);
        }

        public ShiguShopExample.Criteria andDataPacketUrlNotBetween(String value1, String value2) {
            return notBetween(dataPacketUrl, value1, value2);
        }
        public ShiguShopExample.Criteria andMarketNameIsNull() {
            return isNull(marketName);
        }

        public ShiguShopExample.Criteria andMarketNameIsNotNull() {
            return isNotNull(marketName);
        }

        public ShiguShopExample.Criteria andMarketNameEqualTo(String value) {
            return equalTo(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameNotEqualTo(String value) {
            return notEqualTo(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameGreaterThan(String value) {
            return greaterThan(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameLessThan(String value) {
            return lessThan(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameLike(String value) {
            return like(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameNotLike(String value) {
            return notLike(marketName, value);
        }

        public ShiguShopExample.Criteria andMarketNameIn(List<String> values) {
            return in(marketName, values);
        }

        public ShiguShopExample.Criteria andMarketNameNotIn(List<String> values) {
            return notIn(marketName, values);
        }

        public ShiguShopExample.Criteria andMarketNameBetween(String value1, String value2) {
            return between(marketName, value1, value2);
        }

        public ShiguShopExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            return notBetween(marketName, value1, value2);
        }
        public ShiguShopExample.Criteria andMobilePhoneIsNull() {
            return isNull(mobilePhone);
        }

        public ShiguShopExample.Criteria andMobilePhoneIsNotNull() {
            return isNotNull(mobilePhone);
        }

        public ShiguShopExample.Criteria andMobilePhoneEqualTo(String value) {
            return equalTo(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneNotEqualTo(String value) {
            return notEqualTo(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneGreaterThan(String value) {
            return greaterThan(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneLessThan(String value) {
            return lessThan(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneLike(String value) {
            return like(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneNotLike(String value) {
            return notLike(mobilePhone, value);
        }

        public ShiguShopExample.Criteria andMobilePhoneIn(List<String> values) {
            return in(mobilePhone, values);
        }

        public ShiguShopExample.Criteria andMobilePhoneNotIn(List<String> values) {
            return notIn(mobilePhone, values);
        }

        public ShiguShopExample.Criteria andMobilePhoneBetween(String value1, String value2) {
            return between(mobilePhone, value1, value2);
        }

        public ShiguShopExample.Criteria andMobilePhoneNotBetween(String value1, String value2) {
            return notBetween(mobilePhone, value1, value2);
        }
        public ShiguShopExample.Criteria andSortOrderKeyIsNull() {
            return isNull(sortOrderKey);
        }

        public ShiguShopExample.Criteria andSortOrderKeyIsNotNull() {
            return isNotNull(sortOrderKey);
        }

        public ShiguShopExample.Criteria andSortOrderKeyEqualTo(String value) {
            return equalTo(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotEqualTo(String value) {
            return notEqualTo(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyGreaterThan(String value) {
            return greaterThan(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyLessThan(String value) {
            return lessThan(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyLike(String value) {
            return like(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotLike(String value) {
            return notLike(sortOrderKey, value);
        }

        public ShiguShopExample.Criteria andSortOrderKeyIn(List<String> values) {
            return in(sortOrderKey, values);
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotIn(List<String> values) {
            return notIn(sortOrderKey, values);
        }

        public ShiguShopExample.Criteria andSortOrderKeyBetween(String value1, String value2) {
            return between(sortOrderKey, value1, value2);
        }

        public ShiguShopExample.Criteria andSortOrderKeyNotBetween(String value1, String value2) {
            return notBetween(sortOrderKey, value1, value2);
        }
        public ShiguShopExample.Criteria andDomainIsNull() {
            return isNull(domain);
        }

        public ShiguShopExample.Criteria andDomainIsNotNull() {
            return isNotNull(domain);
        }

        public ShiguShopExample.Criteria andDomainEqualTo(String value) {
            return equalTo(domain, value);
        }

        public ShiguShopExample.Criteria andDomainNotEqualTo(String value) {
            return notEqualTo(domain, value);
        }

        public ShiguShopExample.Criteria andDomainGreaterThan(String value) {
            return greaterThan(domain, value);
        }

        public ShiguShopExample.Criteria andDomainGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(domain, value);
        }

        public ShiguShopExample.Criteria andDomainLessThan(String value) {
            return lessThan(domain, value);
        }

        public ShiguShopExample.Criteria andDomainLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(domain, value);
        }

        public ShiguShopExample.Criteria andDomainLike(String value) {
            return like(domain, value);
        }

        public ShiguShopExample.Criteria andDomainNotLike(String value) {
            return notLike(domain, value);
        }

        public ShiguShopExample.Criteria andDomainIn(List<String> values) {
            return in(domain, values);
        }

        public ShiguShopExample.Criteria andDomainNotIn(List<String> values) {
            return notIn(domain, values);
        }

        public ShiguShopExample.Criteria andDomainBetween(String value1, String value2) {
            return between(domain, value1, value2);
        }

        public ShiguShopExample.Criteria andDomainNotBetween(String value1, String value2) {
            return notBetween(domain, value1, value2);
        }
        public ShiguShopExample.Criteria andLastModifyTimeIsNull() {
            return isNull(lastModifyTime);
        }

        public ShiguShopExample.Criteria andLastModifyTimeIsNotNull() {
            return isNotNull(lastModifyTime);
        }

        public ShiguShopExample.Criteria andLastModifyTimeEqualTo(Date value) {
            return equalTo(lastModifyTime, value);
        }

        public ShiguShopExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            return notEqualTo(lastModifyTime, value);
        }

        public ShiguShopExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            return greaterThan(lastModifyTime, value);
        }

        public ShiguShopExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguShopExample.Criteria andLastModifyTimeLessThan(Date value) {
            return lessThan(lastModifyTime, value);
        }

        public ShiguShopExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModifyTime, value);
        }

        public ShiguShopExample.Criteria andLastModifyTimeIn(List<Date> values) {
            return in(lastModifyTime, values);
        }

        public ShiguShopExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            return notIn(lastModifyTime, values);
        }

        public ShiguShopExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            return between(lastModifyTime, value1, value2);
        }

        public ShiguShopExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastModifyTime, value1, value2);
        }
        public ShiguShopExample.Criteria andParentMarketNameIsNull() {
            return isNull(parentMarketName);
        }

        public ShiguShopExample.Criteria andParentMarketNameIsNotNull() {
            return isNotNull(parentMarketName);
        }

        public ShiguShopExample.Criteria andParentMarketNameEqualTo(String value) {
            return equalTo(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameNotEqualTo(String value) {
            return notEqualTo(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameGreaterThan(String value) {
            return greaterThan(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameLessThan(String value) {
            return lessThan(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameLike(String value) {
            return like(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameNotLike(String value) {
            return notLike(parentMarketName, value);
        }

        public ShiguShopExample.Criteria andParentMarketNameIn(List<String> values) {
            return in(parentMarketName, values);
        }

        public ShiguShopExample.Criteria andParentMarketNameNotIn(List<String> values) {
            return notIn(parentMarketName, values);
        }

        public ShiguShopExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            return between(parentMarketName, value1, value2);
        }

        public ShiguShopExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            return notBetween(parentMarketName, value1, value2);
        }
    }
}
