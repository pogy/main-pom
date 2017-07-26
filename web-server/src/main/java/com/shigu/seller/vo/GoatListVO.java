package com.shigu.seller.vo;

import java.util.List;

/**
 * 广告列表
 * Created by zhaohongbo on 17/7/6.
 */
public class GoatListVO {
    private String code;
    private List<IndexGoatVO> posList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<IndexGoatVO> getPosList() {
        return posList;
    }

    public void setPosList(List<IndexGoatVO> posList) {
        this.posList = posList;
    }
}
