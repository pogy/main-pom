package com.shigu.main4.vo.fitment;

import java.io.Serializable;

/**
 * 店招选项设置
 * Created by Administrator on 2017/4/20 0020.
 */
public class BannerOption implements Serializable {

    /**
     * 是否显示电铺招牌
     */
    private Integer imgShow = 1;

    /**
     * 页面头部下边距10px
     */
    private Integer spacing = 1;

    public Integer getImgShow() {
        return imgShow;
    }

    public void setImgShow(Integer imgShow) {
        this.imgShow = imgShow;
    }

    public Integer getSpacing() {
        return spacing;
    }

    public void setSpacing(Integer spacing) {
        this.spacing = spacing;
    }
}
