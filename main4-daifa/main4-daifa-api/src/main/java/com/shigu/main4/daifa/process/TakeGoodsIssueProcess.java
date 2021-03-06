package com.shigu.main4.daifa.process;

import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.daifa.vo.UnComleteAllVO;

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
     * 打印用户下全部条码,包括打印过的
     * @param workerId
     * @return
     * @throws DaifaException
     */
    List<PrintTagVO> printWorkerTodayAllTags(Long workerId) throws DaifaException;

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
     * 按日期,拿货完成
     * @param date yyyyMMdd
     * @throws DaifaException
     * @return 缺货了的子单ID
     */

    List<Long> completeWithDate(String date, Long sellerId) throws DaifaException;
    /**
     * 未发退款(代发系统调起)
     * @param dfOrderId
     */

    Integer refundHasItemApply(Long dfOrderId,String money) throws DaifaException;

    /**
     * 未发退款失败时回滚
     * @param dfOrderId
     * @param status
     */
    void refundHasItemErrorRollback(Long dfOrderId,Integer status) throws DaifaException;
    /**
     * 未发退款
     * @param refundId
     * @param psoid
     * @param refundPrice
     * @throws DaifaException
     */
    void refundHasItem(Long refundId, Long psoid,Long refundPrice) throws DaifaException;

    /**
     * 手动退款,系统后台专用
     * 该操作会将订单变成缺货,然后改为退款状态
     * 如果订单已拿到(无论是否已发货),都改成缺货,同时在待分配表写一条缺货数据,然后进行退款
     * @param dfOrderIds
     * @param tid
     * @param refundId
     * @throws DaifaException
     */
    void adminRefund(List<Long> dfOrderIds,Long tid,Long refundId,Long money) throws DaifaException;

    /**
     * 单店铺拿货完成
     * @param wholeId
     * @param shopId
     * @param issueIds
     * @param idIsCheck
     * @return
     * @throws DaifaException
     */
    UnComleteAllVO uncompleteAllNew(Long wholeId,Long shopId,List<Long> issueIds,Boolean idIsCheck) throws DaifaException;

    /**
     * 当前拿货人账户标记拿货缺货
     * @param wholeId
     * @param issueIds
     * @param idIsCheck
     * @return
     * @throws DaifaException
     */
    UnComleteAllVO tabIsTakeGoods(Long wholeId, List<Long> issueIds, Boolean idIsCheck) throws DaifaException;

    /**
     * @警告: 请确认需求再调该接口
     * 该操作会修改下列表为缺货状态
     * daifa_order,daifa_ggoods_tasks,daifa_ggoods,daifa_wait_send_order,daifa_send_order
     * @param dfOrderId
     * @return tasksId
     */
    Long toNotTake(Long dfOrderId);

    /**
     * 添加操作失误
     * @param tasksId
     */
    void addMistake(Long tasksId);

    /**
     * 退回金额
     * @param workerId
     * @param refundFee
     */
    void userRefundedFee(String day,Long workerId,String refundFee) throws DaifaException;

    /**
     * 获取当前已分配未拿货的档口的手机号码
     * @param sellerId
     * @return
     */
    List<String> selTasksShopPhone(Long sellerId);
}
