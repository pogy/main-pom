package com.shigu.seller.bo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 类名：ModifyConstituentBO
 * 类路径：com.shigu.seller.bo.ModifyConstituentBO
 * 创建者：王浩翔
 * 创建时间：2017-10-25 17:46
 * 项目：main-pom
 * 描述：
 */
public class ModifyConstituentBO implements Serializable {

    //商品ID
    @NotNull(message = "请选择一个商品")
    private Long goodsId;
    //面料成分
    @NotNull(message = "必须填写面料成分")
    private String fabricStr;
    //里料成分
    private String inFabricStr;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getFabricStr() {
        return fabricStr;
    }

    public void setFabricStr(String fabricStr) {
        this.fabricStr = fabricStr;
    }

    public String getInFabricStr() {
        return inFabricStr;
    }

    public void setInFabricStr(String inFabricStr) {
        this.inFabricStr = inFabricStr;
    }
}
