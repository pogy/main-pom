package com.shigu.main4.spread.service;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.spread.bo.ActiveDrawRecordBO;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawRecordUserVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 活动抽奖发现好货SERVICE
 *
 * @author shigu_zjb
 * @date 2017/05/13 16:57
 *
 */
public interface ActiveDrawService {

    /**
     * 获取当前正在进行的期次
     * @return
     */
    ActiveDrawPemVo selNowDrawPem();

    /**
     * 查询本期级以后的期次
     * @return
     */
    List<ActiveDrawPemVo> selDrawPemQueList();

    /**
     * 查询全部期次
     * @return
     */
    List<ActiveDrawPemVo> selDrawPemList();

    ActiveDrawPemVo selNowDrawPem(Date startTime);

    List<ActiveDrawRecordUserVo> selDrawNowUserRecord(Long userId);

    ActiveDrawRecordUserVo selUserDrawList(String drawCode) throws Main4Exception;

    void receUserWard(String tqcode, Long userId) throws Main4Exception;

    /**
     * 活动抽奖商品数据
     * @param pemId
     * @param type
     * @param size
     * @param enabled
     * @return
     */
    List<ActiveDrawGoodsVo> selGoodsList(Long pemId, String type, int size, Boolean enabled,boolean back);

    /**
     * 排序交换
     * @param type 1 上 2 下
     * @param drawGoodsId 主键ID
     */
    void changeGoodsSort(int type, Long drawGoodsId);

    /**
     * 删除
     * @param drawGoodsId
     */
    void delDrawGoods(Long drawGoodsId);

    /**
     * 修改商品
     * @param id 坑位ID
     * @param goodsId 商品ID
     * @param pemId 期次ID
     * @param type 商品类型
     */
    void changeDrawGoods(Long id, Long goodsId, Long pemId, String type);

    /**
     * 新增商品
     * @param activeDrawGoodsVo
     */
    void addDrawGoods(ActiveDrawGoodsVo activeDrawGoodsVo);

    /**
     * 查询
     * @return
     */
    List<ActiveDrawShopVo> selShopList(Long pemId, boolean back);

    List<ActiveDrawRecordUserVo> selDrawRecordList(Long pemId,Long userId, String type);

    /**
     * 修改店铺
     * @param drawShopVo
     */
    void changeShop(ActiveDrawShopVo drawShopVo);

    /**
     * 好店修改位置
     * @param type
     * @param drawShopId
     */
    void changeShopSort(int type,Long drawShopId);

    /**
     * 新增好店
     * @param drawShopVo
     */
    void addDrawShop(ActiveDrawShopVo drawShopVo);

    /**
     * 新增新的期次
     * @param
     */
    void addNewDrawPem(Date nextDrawPemTime);

    /**
     * 查询满足抽奖用户数据
     * @param pemId
     * @param ward
     * @return
     */
    ShiguPager<ActiveDrawRecordUserVo> selComDrawUserRecord(Long pemId, String ward,Long userId, String userNick,int pageNum, int pageSize);

    /**
     * 查询当前中奖用户
     * @param pemId
     * @param ward
     * @return
     */
    int selWardDrawYes(Long pemId, String ward);

    /**
     * 选择用户中奖
     * @param recordId
     */
    void chooseDrawWard(Long recordId);

    /**
     * 查询本期店铺IDS
     * @return
     */
    List<Long> findDrawShopIds();

    /**
     * 修改查阅时间
     * @param recordId
     */
    void changeRefeTime(Long recordId);

    /**
     * 上传产生的新numIid串
     * @param nick
     * @param goodsId
     * @return
     */
    Map<Long,Long> newNumIids(String nick, List<Long> goodsId, Date fromTime, Date endTime);

    void addActiveDrawRecord(ActiveDrawRecordBO activeDrawRecord);

    String shiguTempSigup(String flag, Long userId, Long shopId);

    void receUserWard(String tqcode) throws Main4Exception;

}
