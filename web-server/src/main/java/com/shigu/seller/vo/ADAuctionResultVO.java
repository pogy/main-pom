package com.shigu.seller.vo;

import java.util.List;

/**
 * 广告结果页面
 * Created by zhaohongbo on 17/4/25.
 */
public class ADAuctionResultVO {

    private String title;

    private List<WinnerVo> ggList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<WinnerVo> getGgList() {
        return ggList;
    }

    public void setGgList(List<WinnerVo> ggList) {
        this.ggList = ggList;
    }
}
