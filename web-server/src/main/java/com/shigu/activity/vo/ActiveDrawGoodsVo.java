package com.shigu.activity.vo;


/**
 *  活动抽奖商品
 *
 * @author shigu_zjb
 * @date 2017/05/12 20:11
 *
 */
public class ActiveDrawGoodsVo {

    /** 期次ID */
    private Long pemId;

    /** 商品ID */
    private Long goodsId;

    /** 商品类别 */
    private String type;

    /** 图片 */
    private String imgsrc;

    /** 标题 */
    private String title;

    /** 市场名称 */
    private String marketName;

    /** 档口号 */
    private String shopNum;

    /** 批发价 */
    private String piprice;

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }
}
