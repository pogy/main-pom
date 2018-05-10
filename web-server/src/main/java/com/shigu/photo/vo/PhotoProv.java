package com.shigu.photo.vo;

import java.io.Serializable;
import java.util.Collection;

/**
 * 路径: com.shigu.photo.vo.PhotoProv
 * 工程: main-pom
 * 时间: 18-4-28 下午5:01
 * 创建人: wanghaoxiang
 * 描述:
 */
public class PhotoProv implements Serializable {

    //省id
    private Long provId;

    //市id
    private String provText;

    //市数据
    private Collection<PhotoCity> citys;

    public Long getProvId() {
        return provId;
    }

    public void setProvId(Long provId) {
        this.provId = provId;
    }

    public String getProvText() {
        return provText;
    }

    public void setProvText(String provText) {
        this.provText = provText;
    }

    public Collection<PhotoCity> getCitys() {
        return citys;
    }

    public void setCitys(Collection<PhotoCity> citys) {
        this.citys = citys;
    }
}
