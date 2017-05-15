package com.shigu.main4.activity.vo;

import java.util.List;

/**
 * 带报名信息的广告售卖
 * Created by zhaohongbo on 17/5/9.
 */
public class GoatActivityWithEnlist extends GoatActivityVO{
    private List<ActivityEnlistVO> enlists;

    public List<ActivityEnlistVO> getEnlists() {
        return enlists;
    }

    public void setEnlists(List<ActivityEnlistVO> enlists) {
        this.enlists = enlists;
    }
}
