package com.shigu.main4.monitor.services;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.vo.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 宝贝上传记录服务
 * Created by zhaohongbo on 17/3/13.
 */
public interface ItemUpRecordService {
    /**
     * 添加上传记录
     * @param itemUpRecordVO
     */
    void addItemUpRecord(ItemUpRecordVO itemUpRecordVO);

    /**
     * 修改上传记录
     * PS:原纪录通过"singleUploadedItem"接口查询
     * @param itemUpRecordVO
     * @param oneKeyId
     */
    void updateItemUpload(ItemUpRecordVO itemUpRecordVO,String oneKeyId);



    /**
     * 查最后一次上传的时间
     * @param userId
     * @param supperGoodsId
     * @return
     */
    LastUploadedVO selLastUpByIds(Long userId, Long supperGoodsId);
    /**
     * 查最后一次上传的时间
     * @param userId
     * @param supperGoodsId
     * @return
     */
    LastUploadedVO selLastUpByIds(Long userId, Long supperGoodsId,GoodsUploadFlagEnum flag);


        /**
         * 查询已上传的宝贝
         * @param userId 用户ID
         * @return 已上传的宝贝分页信息
         */
    ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId, String target, String keyword, Date fromDate, Date toDate,
                                             int pageNo, int pageSize);

    /**
     * 查询已上传的宝贝
     * @param userId 用户ID
     * @return 已上传的宝贝分页信息
     */
    ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId,String tbNick, String target, String keyword, Date fromDate, Date toDate,
                                             int pageNo, int pageSize);


    /**
     * 查询已上传的宝贝
     * @param userId 用户ID
     * @return 已上传的宝贝分页信息
     */
    ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId,int type,int pageNo, int pageSize);

    /**
     * 查询已上传的宝贝
     * @param userId 用户ID
     * @return 已上传的宝贝分页信息
     */
    ShiguPager<OnekeyRecoreVO> uploadedItems(Long userId,String tbNick,int type,int pageNo, int pageSize);

    /**
     * 根据ID查询已上传的宝贝
     * @return 已上传的宝贝信息
     */
    SingleItemUpRecordVO singleUploadedItem(String uploadId);

    /**
     * 删除一键上传记录
     * @param userId 用户ID
     * @param onekeyIds 已上传商品主键s
     */
    void deleteUploadedItems(Long userId,List<String> onekeyIds) throws Main4Exception;

    /**
     * 按昵称或userID
     * @param userId
     * @param nick
     * @param onekeyIds
     * @throws Main4Exception
     */
    void deleteUploadedItems(Long userId,String nick,List<String> onekeyIds) throws Main4Exception;
    /**
     * 上传最多的一些商品
     * @param shopId
     * @param size
     * @return
     */
    List<HotUpItem> selHotUpItems(Long shopId,Integer size);

    /**
     * 一段时间内,没有被上传的商品
     * @param shopId
     * @param size
     * @param fromTime
     * @return
     */
    List<NoUpItem> noUpItems(Long shopId,Integer size,Date fromTime);

    /**
     * 上传过的商品种类
     * @param shopId
     * @param fromTime
     * @param toTime
     * @return
     */
    int upedItemNum(Long shopId,Date fromTime,Date toTime);

    /**
     * 上传过的次数
     * @param shopId
     * @param fromTime
     * @param toTime
     * @return
     */
    int upedItemTimes(Long shopId,Date fromTime,Date toTime);

    /**
     * 统计代理数量
     * @param shopId
     * @return
     */
    int countDailiSellerNum(Long shopId);

    /**
     * 代理级别走线图
     * datestr放代理等级
     * @param shopId
     * @return
     */
    List<DataLineVO> dailiSellerLevelLine(Long shopId);

    /**
     * 修改 商品对应上传数
     * 不存在记录则会新建记录
     * @param goodsId
     * @param num
     */
    void updateGoodsUpCountForSearchNum(long goodsId,long num);

    /**
     * 批量修改 商品对应上传数
     * 不存在记录则会新建记录
     * @param goodsIds
     * @param num
     */
    void updateGoodsUpCountForSearchNum(Set<Long> goodsIds, long num);

}
