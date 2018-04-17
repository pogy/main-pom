package com.shigu.main4.cdn.bo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.bo.StyleChanelMarketSearchBO
 * 工程:main-pom
 * 时间:18-1-26下午12:31
 * 创建人:wanghaoxiang
 * 描述：风格频道档口列表搜索条件
 */
public class StyleChanelMarketSearchBO extends StyleChannelSearchBO implements Serializable {

    private Long mid;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
}
