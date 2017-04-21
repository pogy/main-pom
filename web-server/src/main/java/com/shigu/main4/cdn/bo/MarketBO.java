package com.shigu.main4.cdn.bo;


/**
 * 市场页参数
 * Created by zhaohongbo on 17/3/25.
 */
public class MarketBO {

    private Long mid;

    private Long cid;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getMid() {
        if(mid==null){//默认电商基地
            mid=1L;
        }
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
}
