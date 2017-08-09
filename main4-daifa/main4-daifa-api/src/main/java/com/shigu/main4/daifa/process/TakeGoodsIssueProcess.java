package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.vo.PrintTagVO;

import java.util.List;

/**
 * 拿货全链路
 * Created by zhaohongbo on 17/8/8.
 */
public interface TakeGoodsIssueProcess {
    /**
     * 分配拿货任务
     * @param wholeId 拿货人ID
     * @param subOrderIds 子单ID
     * @return 波次号
     */
    String distributionTask(Long wholeId, List<Long> subOrderIds);

    /**
     * 按市场分配
     * @param wholeId 拿货人ID
     * @param shopId 店铺ID
     * @return 波次号
     */
    String distributionTaskWithShop(Long wholeId,Long shopId);

    /**
     * 按楼层分配
     * @param wholeId 拿货人ID
     * @param floorId 楼层ID
     * @return 波次号
     */
    String distributionTaskWithFloor(Long wholeId,Long floorId);

    /**
     * 按市场分配
     * @param wholeId 拿货人ID
     * @param marketId 市场ID
     * @return 波次号
     */
    String distributionTaskWithMarket(Long wholeId,Long marketId);

    /**
     * 打印当天所有应该打而未打的标签
     */
    List<PrintTagVO> printAllTags();

    /**
     * 打印选中的记录(可重复打印)
     * @param issueIds 分配记录ID
     * @return
     */
    List<PrintTagVO> printTags(List<Long> issueIds);

    /**
     * 已拿到
     * @param subOrderId 子订单ID
     */
    void complete(Long subOrderId);

    /**
     * 未拿到
     * @param subOrderId 子订单ID
     */
    void uncomplete(Long subOrderId);

    /**
     * 按人头,全部标记未拿
     * @param wholeId 拿货员ID
     */
    void uncompleteAll(Long wholeId);

}
