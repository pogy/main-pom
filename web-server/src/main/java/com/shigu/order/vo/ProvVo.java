package com.shigu.order.vo;

import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.order.vo
 * @ClassName: ProvVo
 * @Author: sy
 * @CreateDate: 2018/6/13 0013 15:17
 */
public class ProvVo {

    private Long provId;
    private String provText;
    private List<CityVo> citys;

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

    public List<CityVo> getCitys() {
        return citys;
    }

    public void setCitys(List<CityVo> citys) {
        this.citys = citys;
    }
}
