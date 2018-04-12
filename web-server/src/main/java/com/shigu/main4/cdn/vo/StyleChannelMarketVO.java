package com.shigu.main4.cdn.vo;

import java.io.Serializable;

/**
 * 路径:com.shigu.main4.cdn.vo.StyleChannelMarketVO
 * 工程:main-pom
 * 时间:18-1-27下午6:26
 * 创建人:wanghaoxiang
 * 描述：风格频道页市场信息
 */
public class StyleChannelMarketVO implements Serializable {

    //市场id
    private Long mid;
    //市场名称
    private String name;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
