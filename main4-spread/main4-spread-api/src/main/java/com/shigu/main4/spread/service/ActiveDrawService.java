package com.shigu.main4.spread.service;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawGoodsVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawRecordUserVo;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawShopVo;

import java.util.Date;
import java.util.List;

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
    public ActiveDrawPemVo selNowDrawPem();

    /**
     * 查询本期级以后的期次
     * @return
     */
    public List<ActiveDrawPemVo> selDrawPemQueList();

    /**
     * 查询全部期次
     * @return
     */
    public List<ActiveDrawPemVo> selDrawPemList();

    /**
     * 活动抽奖商品数据
     * @param pemId
     * @param type
     * @param size
     * @param enabled
     * @return
     */
    public List<ActiveDrawGoodsVo> selGoodsList(Long pemId, String type, int size, Boolean enabled);

    /**
     * 排序交换
     * @param type 1 上 2 下
     * @param drawGoodsId 主键ID
     */
    public void changeGoodsSort(int type, Long drawGoodsId);

    /**
     * 删除
     * @param drawGoodsId
     */
    public void delDrawGoods(Long drawGoodsId);

    /**
     * 修改商品
     * @param id 坑位ID
     * @param goodsId 商品ID
     * @param pemId 期次ID
     * @param type 商品类型
     */
    public void changeDrawGoods(Long id, Long goodsId, Long pemId, String type);

    /**
     * 新增商品
     * @param activeDrawGoodsVo
     */
    public void addDrawGoods(ActiveDrawGoodsVo activeDrawGoodsVo);

    /**
     * 查询
     * @return
     */
    public List<ActiveDrawShopVo> selShopList(Long pemId);

    /**
     * 修改店铺
     * @param drawShopVo
     */
    public void changeShop(ActiveDrawShopVo drawShopVo);

    /**
     * 好店修改位置
     * @param type
     * @param drawShopId
     */
    public void changeShopSort(int type,Long drawShopId);

    /**
     * 新增好店
     * @param drawShopVo
     */
    public void addDrawShop(ActiveDrawShopVo drawShopVo);

    /**
     * 新增新的期次
     * @param
     */
    public void addNewDrawPem(Date nextDrawPemTime);

    /**
     * 查询满足抽奖用户数据
     * @param pemId
     * @param ward
     * @return
     */
    public ShiguPager<ActiveDrawRecordUserVo> selComDrawUserRecord(Long pemId, String ward, int pageNum, int pageSize);

    /**
     * 查询当前中奖用户
     * @param pemId
     * @param ward
     * @return
     */
    public int selWardDrawYes(Long pemId, String ward);

    /**
     * 选择用户中奖
     * @param recordId
     */
    public void chooseDrawWard(Long recordId);

    /**
     * 查询本期店铺IDS
     * @return
     */
    public List<Long> findDrawShopIds();

    /**
     * 修改查阅时间
     * @param recordId
     */
    public void changeRefeTime(Long recordId);
}
