package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/7/25.
 */
public class GoodsFile {
    @Id
    @GeneratedValue(generator="JDBC")
    private Long id;

    private String fileKey;

    private Long goodsId;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey( String fileKey ) {
        this.fileKey = fileKey;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId( Long goodsId ) {
        this.goodsId = goodsId;
    }
}
