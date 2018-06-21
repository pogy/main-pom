package com.shigu.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.order.vo
 * @ClassName: CityVo
 * @Author: sy
 * @CreateDate: 2018/6/13 0013 15:17
 */
public class CityVo implements Serializable{

    private Long cityId;
    private String cityText;
    private List<TownVo> countys;

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

    public List<TownVo> getCountys() {
        return countys;
    }

    public void setCountys(List<TownVo> countys) {
        this.countys = countys;
    }
}
