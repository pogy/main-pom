package com.opentae.data.mall.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wxc on 2017/2/26.
 *  ES goods 对象， 非 数据库bean
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ESGoods implements Serializable {
    private static final long serialVersionUID = 1939439597965638703L;

    private Long goodsId;
    private Long inStoreSortOrder;
    private String storeNum;
    private String emsFee;
    private String type;
    private String city;
    private String title;
    private Long numIid;
    private Long piPrice;
    private Long is_off;
    private String webSite;
    private Date created;
    private Date listTime;
    private Long isExcelImp;
    private String parent_cname;
    private String postFee;
    private Long marketId;
    private String services;
    private String prov;
    private String picUrl;
    private Long sortOrder;
    private String parentMarketName;
    private String goodsNo;
    private Long cid;
    private String expressFee;
    private Date modified;
    private String cidAll;
    private Date delistTime;
    private Long num;
    private String market;
    private Long price;
    private String nick;
    private Long goods_level;
    private Date loadDate;
    private Long parent_cid;
    private Long parentMarketId;
    private Long relation_level_id;
    private Long storeId;
    private Long v_tradingVolume = 0L;
    private String cname;
    /**
     * 存放风格ID
     */
    private String sids;

    public String getSids() {
        return sids;
    }

    public void setSids(String sids) {
        this.sids = sids;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getInStoreSortOrder() {
        return inStoreSortOrder;
    }

    public void setInStoreSortOrder(Long inStoreSortOrder) {
        this.inStoreSortOrder = inStoreSortOrder;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public String getEmsFee() {
        return emsFee;
    }

    public void setEmsFee(String emsFee) {
        this.emsFee = emsFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public Long getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(Long piPrice) {
        this.piPrice = piPrice;
    }

    public Long getIs_off() {
        return is_off;
    }

    public void setIs_off(Long is_off) {
        this.is_off = is_off;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
    }

    public Long getIsExcelImp() {
        return isExcelImp;
    }

    public void setIsExcelImp(Long isExcelImp) {
        this.isExcelImp = isExcelImp;
    }

    public String getParent_cname() {
        return parent_cname;
    }

    public void setParent_cname(String parent_cname) {
        this.parent_cname = parent_cname;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getParentMarketName() {
        return parentMarketName;
    }

    public void setParentMarketName(String parentMarketName) {
        this.parentMarketName = parentMarketName;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(String expressFee) {
        this.expressFee = expressFee;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getCidAll() {
        return cidAll;
    }

    public void setCidAll(String cidAll) {
        this.cidAll = cidAll;
    }

    public Date getDelistTime() {
        return delistTime;
    }

    public void setDelistTime(Date delistTime) {
        this.delistTime = delistTime;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getGoods_level() {
        return goods_level;
    }

    public void setGoods_level(Long goods_level) {
        this.goods_level = goods_level;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Long getParent_cid() {
        return parent_cid;
    }

    public void setParent_cid(Long parent_cid) {
        this.parent_cid = parent_cid;
    }

    public Long getParentMarketId() {
        return parentMarketId;
    }

    public void setParentMarketId(Long parentMarketId) {
        this.parentMarketId = parentMarketId;
    }

    public Long getRelation_level_id() {
        return relation_level_id;
    }

    public void setRelation_level_id(Long relation_level_id) {
        this.relation_level_id = relation_level_id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getV_tradingVolume() {
        return v_tradingVolume;
    }

    public void setV_tradingVolume(Long v_tradingVolume) {
        this.v_tradingVolume = v_tradingVolume;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
