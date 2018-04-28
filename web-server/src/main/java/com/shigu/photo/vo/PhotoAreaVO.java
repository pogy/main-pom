package com.shigu.photo.vo;

import java.io.Serializable;
import java.util.Collection;

/**
 * 路径: com.shigu.photo.vo.PhotoAreaVO
 * 工程: main-pom
 * 时间: 18-4-28 下午5:00
 * 创建人: wanghaoxiang
 * 描述:
 */
public class PhotoAreaVO implements Serializable {

    //省数据
    Collection<PhotoProv> provs;

    public Collection<PhotoProv> getProvs() {
        return provs;
    }

    public void setProvs(Collection<PhotoProv> provs) {
        this.provs = provs;
    }
}
