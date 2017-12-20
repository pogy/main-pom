package com.shigu.main4.vo.fitment;

import java.io.Serializable;

/**
 * banner 图配置
 * Created by Administrator on 2017/4/18 0018.
 */
public class BannerImage implements Serializable {

    /**
     * 招牌类型 1: 默认招牌 2：自定招牌
     */
    private Integer type = 1;

    /**
     * 图
     */
    private String imgPic = "http://imgs.571xz.net/mall/default_fitment_logo.png";

    /**
     * 自定义banner
     */
    private String content;

    private Integer height = 130;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImgPic() {
        return imgPic;
    }

    public void setImgPic(String imgPic) {
        this.imgPic = imgPic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
