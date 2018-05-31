package com.shigu.photo.vo;

import java.io.Serializable;

/**
 * 路径: com.shigu.photo.vo.PhotoUserInfoForEditVO
 * 工程: main-pom
 * 时间: 18-4-28 下午4:47
 * 创建人: wanghaoxiang
 * 描述:
 */
public class PhotoUserInfoForEditVO extends PhotoAuthWorkUserInfoWebVO implements Serializable {

    //省id
    private Long provId;

    //市id
    private Long cityId;

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
