package com.shigu.seller.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.vo
 * @ClassName: GoodsSkuVo
 * @Author: sy
 * @CreateDate: 2018/9/26 0026 17:58
 */
public class GoodsSkuVo implements Serializable{

    private String color;
    private List<GoodsSizeVo> sizeSku;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<GoodsSizeVo> getSizeSku() {
        return sizeSku;
    }

    public void setSizeSku(List<GoodsSizeVo> sizeSku) {
        this.sizeSku = sizeSku;
    }
}
