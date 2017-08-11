package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.exceptions.DaifaException;
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
     * @param waitIssueIds 待分配ID
     * @return 波次号
     */
    String distributionTask(Long wholeId, List<Long> waitIssueIds) throws DaifaException;

    /**
     * 按市场分配
     * @param wholeId 拿货人ID
     * @param shopId 店铺ID
     * @return 波次号
     */
    String distributionTaskWithShop(Long wholeId,Long shopId) throws DaifaException;

    /**
     * 按楼层分配
     * @param wholeId 拿货人ID
     * @param floorId 楼层ID
     * @return 波次号
     */
    String distributionTaskWithFloor(Long wholeId,Long floorId) throws DaifaException;

    /**
     * 按市场分配
     * @param wholeId 拿货人ID
     * @param marketId 市场ID
     * @return 波次号
     */
    String distributionTaskWithMarket(Long wholeId,Long marketId) throws DaifaException;

    /**
     * 打印当天所有应该打而未打的标签
     */
    List<PrintTagVO> printAllTags();

    /**
     * 打印选中的记录(可重复打印)
     * @param issueIds 分配记录ID
     * @return list
     */
    List<PrintTagVO> printTags(List<Long> issueIds);

    /**
     * 已拿到
     * @param issueId 分配记录IDID
     */
    void complete(Long issueId);

    /**
     * 未拿到
     * @param issueId 分配记录ID
     */
    void uncomplete(Long issueId);

    /**
     * 按人头,全部标记未拿
     * @param wholeId 拿货员ID
     * @param issueIds 分配记录ID串
     * @param idIsCheck  true时issueIds是已拿，其余未拿，false则反过来
     */
    void uncompleteAll(Long wholeId,List<Long> issueIds,Boolean idIsCheck);

}
