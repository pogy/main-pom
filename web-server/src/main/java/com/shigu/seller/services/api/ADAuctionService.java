package com.shigu.seller.services.api;

import com.opentae.data.mall.beans.SpreadAuctScren;
import com.opentae.data.mall.beans.SpreadAuctShop;
import com.opentae.data.mall.beans.SpreadAuctType;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.seller.bo.AuctionApplyBo;
import com.shigu.seller.vo.SpreadTypeViewVo;
import com.shigu.seller.vo.WinnerVo;

import java.util.Date;
import java.util.List;

/**
 * Created by wxc on 2017/3/22.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public interface ADAuctionService {

    /**
     * 广告区域类别
     * @return
     */
    List<SpreadTypeViewVo> getSpreadAuctTypeList();
    /**
     * 查询目标店铺在最近一次活动的中奖状态
     * @param shopId 用户ID
     * @return true/false
     */
    SpreadAuctShop checkWin(Long shopId, Long spreadTypeId);

    /**
     * 获取上次拍卖买受人名单。
     *
     * @return  竞买成功人员名单
     */
    List<WinnerVo> getWinners(Long spreadTypeId);

    /**
     * 获取下次拍卖时间
     * @return 日期
     */
    Date nextAuctionTime(Long spreadTypeId);

    /**
     * 申请竞拍
     * @param bo 申请信息
     */
    void applyAuction(AuctionApplyBo bo) throws Main4Exception;

    /**
     * 获取当前进行中的拍卖
     *  当前没有则返回null
     * @return 当前场次
     */
    SpreadAuctScren getCurrentAuction(Long spreadTypeId);

    /**
     * 活动规则
     *
     * <p>获取当前的正在进行的活动规则，若没有，或许下一期的活动规则</p>
     *
     * @param spreadTypeId
     * @return
     */
    String getActRulesDesc(Long spreadTypeId);


    /**
     * 活动
     * @param screnById
     * @return
     */
    SpreadAuctScren getSpreadScrenById(Long screnById);
}
