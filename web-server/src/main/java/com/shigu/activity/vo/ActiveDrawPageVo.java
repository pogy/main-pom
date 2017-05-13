package com.shigu.activity.vo;


import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;

import java.io.Serializable;
import java.util.List;

/**
 * 活动抽奖页面VO
 *
 * @author shigu_zjb
 * @date 2017/05/12 20:11
 *
 */
public class ActiveDrawPageVo implements Serializable {

    /**
     * 发现好货数据
     */
    private List<ActiveDrawGoodsVo> faGoodsList;

    /**
     * 每日发现数据
     */
    private List<ActiveDrawGoodsVo> dailyGoodsList;

    /**
     * 发现好店数据
     */
    private List<ActiveDrawShopVo> faShopList;

    public List<ActiveDrawGoodsVo> getFaGoodsList() {
        return faGoodsList;
    }

    public void setFaGoodsList(List<ActiveDrawGoodsVo> faGoodsList) {
        this.faGoodsList = faGoodsList;
    }

    public List<ActiveDrawGoodsVo> getDailyGoodsList() {
        return dailyGoodsList;
    }

    public void setDailyGoodsList(List<ActiveDrawGoodsVo> dailyGoodsList) {
        this.dailyGoodsList = dailyGoodsList;
    }

    public List<ActiveDrawShopVo> getFaShopList() {
        return faShopList;
    }

    public void setFaShopList(List<ActiveDrawShopVo> faShopList) {
        this.faShopList = faShopList;
    }
}
