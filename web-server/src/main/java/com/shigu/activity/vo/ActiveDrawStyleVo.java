package com.shigu.activity.vo;

import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;

import java.io.Serializable;
import java.util.List;


/**
 * 活动抽奖风格数据
 *
 */
public class ActiveDrawStyleVo implements Serializable {

    private List<ActiveDrawShopVo> shopList;

    private List<ActiveDrawGoodsVo> goodsList;

    public List<ActiveDrawShopVo> getShopList() {
        return shopList;
    }

    public void setShopList(List<ActiveDrawShopVo> shopList) {
        this.shopList = shopList;
    }

    public List<ActiveDrawGoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ActiveDrawGoodsVo> goodsList) {
        this.goodsList = goodsList;
    }
}
