package com.shigu.main4.goat.vo;

import java.util.List;

/**
 * 期内的广告
 * Created by zhaohongbo on 17/5/11.
 */
public class GoatIntermVO{
    /**
     * 0表示 在线
     * 1表示 预定
     */
    private Integer type;
    private List<GoatVO> goats;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<GoatVO> getGoats() {
        return goats;
    }

    public void setGoats(List<GoatVO> goats) {
        this.goats = goats;
    }
}
