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

    private String colorText;
    private List<GoodsSizeVo> sizes;

    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }

    public List<GoodsSizeVo> getSizes() {
        return sizes;
    }

    public void setSizes(List<GoodsSizeVo> sizes) {
        this.sizes = sizes;
    }
}
