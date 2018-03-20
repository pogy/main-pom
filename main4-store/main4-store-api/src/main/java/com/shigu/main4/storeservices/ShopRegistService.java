package com.shigu.main4.storeservices;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.exceptions.ShopExamineException;
import com.shigu.main4.exceptions.ShopRegistException;
import com.shigu.main4.vo.FloorForRegist;
import com.shigu.main4.vo.MarketForRegist;
import com.shigu.main4.vo.RefuseOpenReason;
import com.shigu.main4.vo.ShopApply;
import com.shigu.main4.vo.ShopApplyDetail;
import com.shigu.main4.vo.ShopApplyModify;
import com.shigu.main4.vo.ShopRegister;
import com.shigu.main4.vo.SiteForRegist;

import java.util.List;

/**
 * 店铺注册与审核服务
 * Created by Licca on 17/2/20.
 */
public interface ShopRegistService {


    /**
     * 注册用户
     * 1、档口已经被注册的，不能重复注册
     * 2、本用户已经有待审核的，档口号相同的，作为修改信息处理
     * @param shop 申请信息
     * @return 申请表的ID
     */
    long registShop(ShopRegister shop) throws ShopRegistException;

    /**
     * 判定档口是否允许开启
     * @param userId
     * @param marketId
     * @param shopNum
     * @return
     */
    boolean shopCanOpen(Long userId,String nick,Long marketId,String shopNum) throws ShopExamineException;

    /**
     * 淘宝店绑定注册申请信息
     * @param registId 申请表ID
     * @param tbshopId 淘宝店ID
     * @param tbuserId 淘宝用户ID
     * @return 是否完成
     */
    boolean completeRegist(Long registId,Long tbshopId,Long tbuserId,String tbNick,String tbUrl);

    /**
     * 按用户ID查用户的开店申请
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    ShiguPager<ShopApply> selApplysByUserId(Long userId,Integer pageNo,Integer pageSize);

    /**
     * 删除申请记录
     * @param userId
     * @param applyId
     */
    void delApply(Long userId,Long applyId) throws ShopRegistException;

    /**
     * 查询用户的申请详情
     * @param userId
     * @param ruzhuId
     * @return
     */
    ShopApplyDetail selDetailById(Long userId,Long ruzhuId);

//    /**   改调用registShop
//     * 修改开店申请
//     * @param shopApplyModify
//     */
//    void updateShopApply(ShopApplyModify shopApplyModify);

    /**
     * 重新提交申请
     * @param userId
     * @param ruzhuId
     */
    void resubmitShopApply(Long userId,Long ruzhuId) throws Main4Exception;
    /**
     * 审核店铺
     * @param registId 申请ID
     * @return 新店铺ID
     */
    long toExamine(Long registId) throws ShopExamineException;

    /**
     * 审核店铺
     * @param registId 申请ID
     * @param operator 审核人员
     * @return 新店铺ID
     * @throws ShopExamineException
     */
    long toExamine(Long registId, String operator) throws ShopExamineException;

    /**
     * 拒绝审核
     * @param registId
     * @param reason
     */
    int toRefuse(Long registId,RefuseOpenReason reason) throws ShopExamineException;

    /**
     * 查询所有可入驻的站点
     * @return
     */
    List<SiteForRegist> selSites();

    /**
     * 查询可注册的市场
     * @param webSite
     * @return
     */
    List<MarketForRegist> selMarkets(String webSite);

    /**
     * 查询可注册的楼层
     * @param marketId
     * @return
     */
    List<FloorForRegist> selFloors(Long marketId);
}
