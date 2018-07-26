package com.shigu.goodsup.sn.vo;

public class SnQueryVo {
    private String cid;
    private Long goodsId;

    public SnQueryVo(){

    }

    public SnQueryVo(String cid, Long goodsId) {
        this.cid = cid;
        this.goodsId = goodsId;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
