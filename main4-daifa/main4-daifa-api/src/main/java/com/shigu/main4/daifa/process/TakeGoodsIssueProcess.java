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
     * 按店铺分配
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
     * 打印全部条码
     * @param sellerId 代发机构id
     * @return list
     */
    List<PrintTagVO> printAllTags(Long sellerId)throws DaifaException;

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
    void complete(Long issueId) throws DaifaException;

    /**
     * 未拿到
     * @param issueId 分配记录ID
     */
    void uncomplete(Long issueId) throws DaifaException;

    /**
     * 按人头,拿到货
     * @param wholeId 拿货员ID
     * @param shopId 档口ID
     * @param issueIds 分配记录ID串
     * @param idIsCheck  true时issueIds是已拿，其余未拿，false则反过来
     */
    void uncompleteAll(Long wholeId,Long shopId,List<Long> issueIds,Boolean idIsCheck) throws DaifaException;

    /**
     * 按日期,拿货完成
     * @param date yyyyMMdd
     * @throws DaifaException
     */

    void completeWithDate(String date, Long sellerId) throws DaifaException;
}
