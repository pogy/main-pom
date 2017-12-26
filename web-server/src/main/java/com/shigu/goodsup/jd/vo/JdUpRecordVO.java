package com.shigu.goodsup.jd.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By admin on 2017/12/26/11:34
 * 上传京东记录信息
 */
public class JdUpRecordVO implements Serializable {
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 商品Id
     */
    private Long goodsId;
    /**
     * 站点
     */
    private String webSite;
    /**
     * 记录创建时间
     */
    private Date gmtCreate;
    /**
     * 记录修改时间
     */
    private Date gmtModify;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}
