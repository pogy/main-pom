package com.shigu.admin.services;

import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.shigu.admin.bo.StatisGoodsBO;
import com.shigu.admin.vo.StatisGoodsVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.TypeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @类编号
 * @类名称：GoodsStatisticsService
 * @文件路径：com.shigu.admin.services.GoodsStatisticsService
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/7 13:51
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service
public class GoodsStatisticsService {

    @Autowired
    private DaifaOrderMapper daifaOrderMapper;//
    /**
     * ====================================================================================
     * @方法名： statisGoodsbyGoodsByPage
     * @user gzy 2017/11/7 15:16
     * @功能：按拿货状态，开始时间，结束时间统计商品信息
     * @param: [bo]
     * @return: java.util.List<com.shigu.admin.vo.StatisGoodsVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<StatisGoodsVO> statisGoodsbyGoodsByPage(StatisGoodsBO bo){

        DaifaOrderExample example=new DaifaOrderExample ();
        if(bo.getTakeGoodsStatus ()!=null&&bo.getTakeGoodsStatus ()>0){
            example.setTakegoodstatus (bo.getTakeGoodsStatus ());
        }
        if (StringUtils.hasText(bo.getStartTime())) {
            example.setStartTime (bo.getStartTime());
        }else{
            String  dd= TypeConvert.formatDateTime(TypeConvert.getDateStratTime(new Date()), "yyyy-MM-dd HH:mm:ss");
            example.setStartTime (dd);
        }
        if (StringUtils.hasText(bo.getEndTime())) {
            example.setEndTime (bo.getEndTime());
        }else{
            String  dd= TypeConvert.formatDateTime(TypeConvert.getDateEndTime(new Date()), "yyyy-MM-dd HH:mm:ss");
            example.setEndTime (dd);
        }

        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        int i = daifaOrderMapper.countStatisGoodsbyGoods(example);
        bo.setCount(i);
        if(i > 0) {
            int page = Integer.parseInt (bo.getPage ());
            int rows = 10;
            example.setStartIndex ((page - 1) * rows);
            example.setEndIndex (rows);
        }
        List<StatisGoodsVO> listVO = new ArrayList<> ();
        List<DaifaOrder> list_order= daifaOrderMapper.statisGoodsbyGoods (example);
        if(list_order.size ()>0){
            for(DaifaOrder order:list_order){
                StatisGoodsVO vo=new StatisGoodsVO();
                vo.setMarketId (order.getMarketId ());
                vo.setMarketName (order.getMarketName ());
                vo.setFloorName (order.getFloorName ());
                vo.setStoreId (order.getStoreId ());
                vo.setStoreNum (order.getStoreNum ());
                vo.setGoodsId (order.getGoodsId ());
                vo.setGoodsCode (order.getGoodsCode ());
                vo.setStoreGoodsCode (order.getStoreGoodsCode ());
                vo.setGoodsNum (order.getGoodsNum ());
                vo.setTitle (order.getTitle ());
                vo.setSinglePiPrice (order.getSinglePiPrice ());
                listVO.add (vo);
            }
        }
        return listVO;
    }


    /**
     * ====================================================================================
     * @方法名： statisGoodsByStoreNumByPage
     * @user gzy 2017/11/7 15:21
     * @功能： 按拿货状态，开始时间，结束时间统计档口信息
     * @param: [bo]
     * @return: java.util.List<com.shigu.admin.vo.StatisGoodsVO>
     * @exception:
     * ====================================================================================
     *
     */
    public List<StatisGoodsVO> statisGoodsByStoreNumByPage(StatisGoodsBO bo){

        DaifaOrderExample example=new DaifaOrderExample ();
        if(bo.getTakeGoodsStatus ()!=null&&bo.getTakeGoodsStatus ()>0){
            example.setTakegoodstatus (bo.getTakeGoodsStatus ());
        }
        if (StringUtils.hasText(bo.getStartTime())) {
            example.setStartTime (bo.getStartTime());
        }else{
            String  dd= TypeConvert.formatDateTime(TypeConvert.getDateStratTime(new Date()), "yyyy-MM-dd HH:mm:ss");
            example.setStartTime (dd);
        }
        if (StringUtils.hasText(bo.getEndTime())) {
            example.setEndTime (bo.getEndTime());
        }else{
            String  dd= TypeConvert.formatDateTime(TypeConvert.getDateEndTime(new Date()), "yyyy-MM-dd HH:mm:ss");
            example.setEndTime (dd);
        }
        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        int i = daifaOrderMapper.countStatisGoodsByStoreNum(example);
        bo.setCount(i);
        if(i > 0) {
            int page = Integer.parseInt (bo.getPage ());
            int rows = 10;
            example.setStartIndex ((page - 1) * rows);
            example.setEndIndex (rows);
        }
        List<StatisGoodsVO> listVO = new ArrayList<> ();
        List<DaifaOrder> list_order= daifaOrderMapper.statisGoodsByStoreNum (example);
        if(list_order.size ()>0){
            for(DaifaOrder order:list_order){
                StatisGoodsVO vo=new StatisGoodsVO();
                vo.setMarketId (order.getMarketId ());
                vo.setMarketName (order.getMarketName ());
                vo.setFloorName (order.getFloorName ());
                vo.setStoreId (order.getStoreId ());
                vo.setStoreNum (order.getStoreNum ());
                vo.setGoodsNum (order.getGoodsNum ());
                listVO.add (vo);
            }
        }
        return listVO;
    }
}
