package com.shigu.main4.goat.vo;

import java.io.Serializable;

/**
 * 上款量数据
 *
 * -Long realNum //真实上款量
 -Long unRealNum //不真实的上款量
 * Created by zhaohongbo on 17/5/4.
 */
public class ItemUpVO implements Serializable{
    /**
     * 真实上款量
     */
    private Long realNum;
    /**
     * 非真实的上款量
     */
    private Long unRealNum;

    public Long getRealNum() {
        return realNum;
    }

    public void setRealNum(Long realNum) {
        this.realNum = realNum;
    }

    public Long getUnRealNum() {
        return unRealNum;
    }

    public void setUnRealNum(Long unRealNum) {
        this.unRealNum = unRealNum;
    }
}
