package com.opentae.data.mall.beans;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by wxc on 2017/3/2.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class TinyItemCollect implements Serializable {

    private static final long serialVersionUID = -9123051214714368157L;
    /** 商品ID */
    private Long id;

    /** 站点 */
    private String website;

    /** 图片地址 */
    private String imgsrc;

    /** 批发价格 */
    private String piprice;

    /** 标题 */
    private String title;

    /** 市场归属 */
    private String marketname;

    /** 数据包ID */
    private Long goodsCollectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPiprice() {
        return piprice;
    }

    public void setPiprice(String piprice) {
        this.piprice = piprice;
    }

    public String getTitle() {
        //TODO powell important 111
        if(StringUtils.isNotBlank(title)){
            title= KeyWordsUtil.duleKeyWords(title);
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public Long getGoodsCollectId() {
        return goodsCollectId;
    }

    public void setGoodsCollectId(Long goodsCollectId) {
        this.goodsCollectId = goodsCollectId;
    }
}
