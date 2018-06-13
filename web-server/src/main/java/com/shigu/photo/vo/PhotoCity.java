package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoCity
 * 工程: main-pom
 * 时间: 18-4-28 下午5:02
 * 创建人: wanghaoxiang
 * 描述:
 */
public class PhotoCity implements Serializable {

    //市id
    private Long cityId;

    //市名
    private String cityText;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }
}
