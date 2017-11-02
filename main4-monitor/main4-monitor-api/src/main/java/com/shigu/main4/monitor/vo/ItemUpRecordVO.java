package com.shigu.main4.monitor.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品上传记录数据
 * Created by zhaohongbo on 17/3/13.
 */
public class ItemUpRecordVO implements Serializable{

    /**
     * 上游卖家旺旺
     */
    private String supperImww;
    /**
     * 上游卖家零售价
     */
    private String supperPrice;
    /**
     * 下游卖家商品标题
     */
    private String fenGoodsName;
    /**
     * 上游卖家的主图
     */
    private String supperImage;
    /**
     * 上游商品ID
     */
    private Long supperGoodsId;
    /**
     * 上游店铺ID
     */
    private Long supperStoreId;
    /**
     * 上游店铺链接电话
     */
    private String supperTelephone;
    /**
     * 是否删除,是否删除,0:否,1:是
     * 暂不用,使用status来代替
     */
//    private Long idDel;
    /**
     * 分销商主图
     */
    private String fenImage;
    /**
     * 上游卖家批发价
     */
    private String supperPiPrice;
    /**
     * 分站
     */
    private String webSite;
    /**
     * 上游卖家淘宝店地址
     */
    private String supperTaobaoUrl;
    /**
     * 上游店铺所在市场
     */
    private String supperMarket;
    /**
     * 上游店铺档口号
     */
    private String supperStorenum;
    /**
     * 下游卖家店铺设置
     */
    private String fenPrice;
    /**
     *  0:show 1:unshow
     */
    private Long status;
    /**
     * 上游卖家服务
     */
    private String supperServers;
    /**
     * 上游档口所在市场ID
     */
    private Long supperMarketId;
    /**
     * 上游商品ID
     */
    private Long supperNumiid;
    /**
     * 上游店铺名
     */
    private String supperStoreName;
    /**
     * 上传平台标识,web-tb是电脑上的淘宝
     * wx是微信
     * tb是手机上传淘宝
     * ali是阿里
     *
     */
    private String flag;
    /**
     * 上游商品名
     */
    private String supperGoodsName;
    /**
     * 下游用户淘宝昵称
     */
    private String fenUserNick;
    /**
     * 下游用户ID
     */
    private Long fenUserId;
    /**
     * 上传发生时间
     * yyyy-MM-dd HH:mm:ss
     */
    private String daiTime;
    /**
     * 上游卖家QQ
     */
    private String supperQq;
    /**
     * 下游numIid
     */
    private Long fenNumiid;
    /**
     * 淘宝子类目id
     */
    private Long cid;
    /**
     * 档口下架
     */
    private Boolean shopSoldout;
    /**
     * 淘宝下架
     */

    private Boolean tbSoldout;


    public String getSupperImww() {
        return supperImww;
    }

    public void setSupperImww(String supperImww) {
        this.supperImww = supperImww;
    }

    public String getSupperPrice() {
        return supperPrice;
    }

    public void setSupperPrice(String supperPrice) {
        this.supperPrice = supperPrice;
    }

    public String getFenGoodsName() {
        return fenGoodsName;
    }

    public void setFenGoodsName(String fenGoodsName) {
        this.fenGoodsName = fenGoodsName;
    }

    public String getSupperImage() {
        return supperImage;
    }

    public void setSupperImage(String supperImage) {
        this.supperImage = supperImage;
    }

    public Long getSupperGoodsId() {
        return supperGoodsId;
    }

    public void setSupperGoodsId(Long supperGoodsId) {
        this.supperGoodsId = supperGoodsId;
    }

    public Long getSupperStoreId() {
        return supperStoreId;
    }

    public void setSupperStoreId(Long supperStoreId) {
        this.supperStoreId = supperStoreId;
    }

    public String getSupperTelephone() {
        return supperTelephone;
    }

    public void setSupperTelephone(String supperTelephone) {
        this.supperTelephone = supperTelephone;
    }

    public String getFenImage() {
        return fenImage;
    }

    public void setFenImage(String fenImage) {
        this.fenImage = fenImage;
    }

    public String getSupperPiPrice() {
        return supperPiPrice;
    }

    public void setSupperPiPrice(String supperPiPrice) {
        this.supperPiPrice = supperPiPrice;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getSupperTaobaoUrl() {
        return supperTaobaoUrl;
    }

    public void setSupperTaobaoUrl(String supperTaobaoUrl) {
        this.supperTaobaoUrl = supperTaobaoUrl;
    }

    public String getSupperMarket() {
        return supperMarket;
    }

    public void setSupperMarket(String supperMarket) {
        this.supperMarket = supperMarket;
    }

    public String getSupperStorenum() {
        return supperStorenum;
    }

    public void setSupperStorenum(String supperStorenum) {
        this.supperStorenum = supperStorenum;
    }

    public String getFenPrice() {
        return fenPrice;
    }

    public void setFenPrice(String fenPrice) {
        this.fenPrice = fenPrice;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getSupperServers() {
        return supperServers;
    }

    public void setSupperServers(String supperServers) {
        this.supperServers = supperServers;
    }

    public Long getSupperMarketId() {
        return supperMarketId;
    }

    public void setSupperMarketId(Long supperMarketId) {
        this.supperMarketId = supperMarketId;
    }

    public Long getSupperNumiid() {
        return supperNumiid;
    }

    public void setSupperNumiid(Long supperNumiid) {
        this.supperNumiid = supperNumiid;
    }

    public String getSupperStoreName() {
        return supperStoreName;
    }

    public void setSupperStoreName(String supperStoreName) {
        this.supperStoreName = supperStoreName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSupperGoodsName() {
        return supperGoodsName;
    }

    public void setSupperGoodsName(String supperGoodsName) {
        this.supperGoodsName = supperGoodsName;
    }

    public String getFenUserNick() {
        return fenUserNick;
    }

    public void setFenUserNick(String fenUserNick) {
        this.fenUserNick = fenUserNick;
    }

    public Long getFenUserId() {
        return fenUserId;
    }

    public void setFenUserId(Long fenUserId) {
        this.fenUserId = fenUserId;
    }

    public String getDaiTime() {
        return daiTime;
    }

    public void setDaiTime(String daiTime) {
        this.daiTime = daiTime;
    }

    public String getSupperQq() {
        return supperQq;
    }

    public void setSupperQq(String supperQq) {
        this.supperQq = supperQq;
    }

    public Long getFenNumiid() {
        return fenNumiid;
    }

    public void setFenNumiid(Long fenNumiid) {
        this.fenNumiid = fenNumiid;
    }



    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Boolean getShopSoldout() {
        return shopSoldout;
    }

    public void setShopSoldout(Boolean shopSoldout) {
        this.shopSoldout = shopSoldout;
    }

    public Boolean getTbSoldout() {
        return tbSoldout;
    }

    public void setTbSoldout(Boolean tbSoldout) {
        this.tbSoldout = tbSoldout;
    }
}
