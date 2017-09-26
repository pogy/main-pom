package com.shigu.main4.daifa.process.impl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.beans.GgoodsForPrint;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.utils.Pingyin;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.daifa.vo.UnComleteAllVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @类编号
 * @类名称：TakeGoodsIssueProcessImpl
 * @文件路径：com.shigu.main4.daifa.process.TakeGoodsIssueProcessImpl
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/8/9 15:57
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Service("takeGoodsIssueProcess")
public class TakeGoodsIssueProcessImpl implements TakeGoodsIssueProcess {
    private static final Logger logger = LoggerFactory.getLogger(TakeGoodsIssueProcessImpl.class);

    private final static Integer EZINT = 7; //截取长度
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;

    @Autowired
    public void setDaifaGgoodsTasksMapper(DaifaGgoodsTasksMapper daifaGgoodsTasksMapper) {
        this.daifaGgoodsTasksMapper = daifaGgoodsTasksMapper;
    }

    private MultipleMapper multipleMapper;

    @Autowired
    public void setMultipleMapper(MultipleMapper multipleMapper) {
        this.multipleMapper = multipleMapper;
    }

    private CountTransMapper countTransMapper;

    @Autowired
    public void setCountTransMapper(CountTransMapper countTransMapper) {
        this.countTransMapper = countTransMapper;
    }

    private DaifaGgoodsMapper daifaGgoodsMapper;

    @Autowired
    public void setDaifaGgoodsMapper(DaifaGgoodsMapper daifaGgoodsMapper) {
        this.daifaGgoodsMapper = daifaGgoodsMapper;
    }

    private DaifaOrderMapper daifaOrderMapper;

    @Autowired
    public void setDaifaOrderMapper(DaifaOrderMapper daifaOrderMapper) {
        this.daifaOrderMapper = daifaOrderMapper;
    }


    private DaifaWaitSendOrderMapper daifaWaitSendOrderMapper;

    @Autowired
    public void setDaifaWaitSendOrderMapper(DaifaWaitSendOrderMapper daifaWaitSendOrderMapper) {
        this.daifaWaitSendOrderMapper = daifaWaitSendOrderMapper;
    }

    private DaifaSendOrderMapper daifaSendOrderMapper;

    @Autowired
    public void setDaifaSendOrderMapper(DaifaSendOrderMapper daifaSendOrderMapper) {
        this.daifaSendOrderMapper = daifaSendOrderMapper;
    }
    @Override
    public String distributionTask(Long wholeId, List<Long> waitIssueIds) throws DaifaException {
        CargoManModel cargoManModel = SpringBeanFactory.getBean(CargoManModel.class, wholeId);
        return cargoManModel.takeToMe(waitIssueIds);
    }

    @Override
    public String distributionTaskWithShop(Long wholeId, Long shopId) throws DaifaException {
        //先根据shopId查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andStoreIdEqualTo(shopId)
                .andUseStatusEqualTo(1)//可用
                .andGoodsCodeIsNotNull()
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0)//未结算
                .andCustomSql("(youhuo_date is null or (if(youhuo_date is not null, " +
                        "date_format(youhuo_date,'%Y%m%d')-create_date<=0 or date_format(now(),'%Y%m%d')-create_date>0,true)))");
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper
                .selectFieldsByExample(dgtex, FieldUtil.codeFields("tasks_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt -> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId, taskIds);
    }

    @Override
    public String distributionTaskWithFloor(Long wholeId, Long floorId) throws DaifaException {

        //先根据floorid查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andUseStatusEqualTo(1)//可用
                .andFloorIdEqualTo(floorId)
                .andGoodsCodeIsNotNull()
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0)//未结算
                .andCustomSql("(youhuo_date is null or (if(youhuo_date is not null, " +
                        "date_format(youhuo_date,'%Y%m%d')-create_date<=0 or date_format(now(),'%Y%m%d')-create_date>0,true)))");
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                , FieldUtil.codeFields("tasks_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt -> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId, taskIds);
    }

    @Override
    public String distributionTaskWithMarket(Long wholeId, Long marketId) throws DaifaException {
        //先根据marketId查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andUseStatusEqualTo(1)//可用
                .andMarketIdEqualTo(marketId)
                .andGoodsCodeIsNotNull()
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0)//未结算
                .andCustomSql("(youhuo_date is null or (if(youhuo_date is not null, " +
                        "date_format(youhuo_date,'%Y%m%d')-create_date<=0 or date_format(now(),'%Y%m%d')-create_date>0,true)))");
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                , FieldUtil.codeFields("tasks_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt -> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId, taskIds);
    }

    @Override
    public List<PrintTagVO> printAllTags(Long sellerId) throws DaifaException{
        //查出今天未打印的


        String nowDate = DateUtil.dateToString(new Date(), DateUtil.patternB);
        DaifaGgoodsExample dgex = new DaifaGgoodsExample();
        dgex.createCriteria()
                .andUseStatusEqualTo(1)//可用的
                .andPrintBarcodeStatusEqualTo(1)//未打印
                .andSellerIdEqualTo(sellerId)
                .andCreateDateEqualTo(nowDate);
        List<DaifaGgoods> ggoods = daifaGgoodsMapper.selectFieldsByExample(dgex
                ,FieldUtil.codeFields("take_goods_id"));
        if(ggoods.size ()==0){
            throw new DaifaException("没有可打印的数据");
        }
        List<Long> issueIds = new ArrayList<>();
        ggoods.forEach(dg->issueIds.add(dg.getTakeGoodsId()));

        return printTags(issueIds);
    }

    @Override
    public List<PrintTagVO> printTags(List<Long> issueIds) {
        String nowDate = DateUtil.dateToString(new Date(), DateUtil.patternB);
        Calendar ca = Calendar.getInstance();
        //先根据ids查询出数据
        DaifaGgoodsExample daifaGgoodsExample = new DaifaGgoodsExample();
        DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
        DaifaTradeExample daifaTradeExample = new DaifaTradeExample();

        MultipleExample multipleExample = MultipleExampleBuilder.from(daifaGgoodsExample).join(daifaTradeExample)
                .on(daifaGgoodsExample.createCriteria().andTakeGoodsIdIn(issueIds)
                        .equalTo(DaifaGgoodsExample.dfTradeId, DaifaTradeExample.dfTradeId))
                .join(daifaOrderExample)
                .on(daifaOrderExample.createCriteria().equalTo(DaifaOrderExample.dfOrderId, DaifaGgoodsExample.dfOrderId)).build();
        multipleExample.setOrderByClause("daifa_ggoods.market_id asc,lpad(daifa_ggoods.floor_name,10,0) asc,lpad(daifa_ggoods.store_num,10,0) asc,daifa_ggoods.goods_code asc,daifa_ggoods.take_goods_id asc");
        List<GgoodsForPrint> ggoodsForPrints = multipleMapper
                .selectFieldsByMultipleExample(multipleExample, GgoodsForPrint.class);

        List<PrintTagVO> pvos = new ArrayList<>();

        CountTransExample ctex = new CountTransExample();
        ctex.setOrderByClause("id desc");
        ctex.setStartIndex(0);
        ctex.setEndIndex(1);
        ctex.createCriteria().andCreateDateEqualTo(nowDate);
        //查询当天有无操作过批次
        List<CountTrans> ctlist = countTransMapper.selectByConditionList(ctex);
        int batch = 0;
        if (ctlist.size() > 0) {
            batch = ctlist.get(0).getBatch();
        }
        List<Long> unPrints = new ArrayList<>();
        for (GgoodsForPrint ggoodsForPrint : ggoodsForPrints) {
            PrintTagVO vo = new PrintTagVO();
            vo.setOrderSort(ggoodsForPrint.getBarCodeKeyNum());
            vo.setSpecialStr(ggoodsForPrint.getBarCodeKey());
            vo.setPackages(ggoodsForPrint.getGoodsNum());
            String barcode = ggoodsForPrint.getDfOrderId().toString() + ggoodsForPrint.getDfTradeId().toString()
                    .substring(ggoodsForPrint.getDfTradeId().toString().length() - EZINT);//计算长度
            vo.setBarCode(barcode);
            vo.setPriceAndBarCode((int) Double.parseDouble(ggoodsForPrint.getSinglePiPrice()) + "N" + barcode);
            vo.setBuyerNick(ggoodsForPrint.getBuyerNick());
            vo.setReceiverName(ggoodsForPrint.getRecieverName());

            if (ggoodsForPrint.getPrintBarcodeStatus() != null && ggoodsForPrint.getPrintBarcodeStatus() == 1) {
                vo.setDateIncBatch(ca.get(Calendar.MONTH) + 1 + "." + ca.get(Calendar.DAY_OF_MONTH) + "-"
                        + (batch + 1));
                unPrints.add(ggoodsForPrint.getTakeGoodsId());
            } else {
                vo.setDateIncBatch(batchDBconvert(ggoodsForPrint.getPrintBatch()));
            }
            int subDays = Integer.parseInt(nowDate) - Integer.parseInt(DateUtil
                    .dateToString(ggoodsForPrint.getCreateTime(), DateUtil.patternB));
            vo.setRemarks(subDays + "");

            String market = ggoodsForPrint.getStoreGoodsCode().split("_")[0];
            vo.setGoodsSku(market + "-" + ggoodsForPrint.getStoreNum() + "-" + ggoodsForPrint.getGoodsCode()
                    + "-" + ggoodsForPrint.getPropStr());
            vo.setPostName(Pingyin.getPinYinHeadChar(ggoodsForPrint.getExpressName()).toUpperCase());
            pvos.add(vo);
        }

        if (unPrints.size() > 0) {
            DaifaGgoodsExample dgexF = new DaifaGgoodsExample();
            dgexF.createCriteria().andTakeGoodsIdIn(unPrints);
            DaifaGgoods ggoods = new DaifaGgoods();
            ggoods.setPrintBarcodeStatus(2);//已打印
            ggoods.setPrintBatch(nowDate + "-" + (batch + 1));
            daifaGgoodsMapper.updateByExampleSelective(ggoods, dgexF);//更新未打印
            //插入打印表
            CountTrans ct = new CountTrans();
            ct.setBatch(batch + 1);
            ct.setCreateDate(nowDate);
            ct.setCreateTime(new Date());
            ct.setUseSituation("d7打印条码");
            countTransMapper.insertSelective(ct);

        }
        return pvos;
    }

    @Override
    public void complete (Long issueId) throws DaifaException {
        DaifaGgoods g=daifaGgoodsMapper.selectFieldsByPrimaryKey(issueId, FieldUtil.codeFields("take_goods_id,df_order_id,use_status,operate_is,create_date"));
        if(g==null){
            throw new DaifaException("未找到分配信息");
        }
        if(g.getUseStatus()!=1||g.getOperateIs()==1){
            throw new DaifaException("无效的数据,该ID已操作过拿货完成");
        }
        String date=DateUtil.dateToString(new Date(),DateUtil.patternB);
        if(!g.getCreateDate().equals(date)){
            throw new DaifaException("不是今天的分配数据");
        }
        SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
        subOrderModel.haveTake();
    }

    @Override
    public void uncomplete (Long issueId) throws DaifaException {
        DaifaGgoods g=daifaGgoodsMapper.selectFieldsByPrimaryKey(issueId, FieldUtil.codeFields("take_goods_id,df_order_id,use_status,operate_is,create_date"));
        if(g==null){
            throw new DaifaException("未找到分配信息");
        }
        if(g.getUseStatus()!=1||g.getOperateIs()==1){
            throw new DaifaException("无效的数据,该ID已操作过拿货完成");
        }
        String date=DateUtil.dateToString(new Date(),DateUtil.patternB);
        if(!g.getCreateDate().equals(date)){
            throw new DaifaException("不是今天的分配数据");
        }
        SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
        subOrderModel.noTake();
    }
    /**
     * 按人头,拿到货
     * @param wholeId 拿货员ID
     * @param shopId 档口ID
     * @param issueIds 分配记录ID串
     * @param idIsCheck  true时issueIds是已拿，其余未拿，false则反过来
     * @return 缺货了的子单ID
     */
    @Override
    public List<Long> uncompleteAll (Long wholeId,Long shopId, List<Long> issueIds,Boolean idIsCheck) throws DaifaException {
        List<Long> notTakeDfOrderIds=new ArrayList<>();
        String date=DateUtil.dateToString(new Date(),DateUtil.patternB);
        DaifaGgoodsExample ge=new DaifaGgoodsExample();
        ge.createCriteria().andDaifaWorkerIdEqualTo(wholeId).andStoreIdEqualTo(shopId);
        List<DaifaGgoods> gs=daifaGgoodsMapper.selectFieldsByExample(ge,FieldUtil.codeFields("take_goods_id,df_order_id,use_status,operate_is,create_date"));
        Map<Long,DaifaGgoods> gmap= BeanMapper.list2Map(gs,"takeGoodsId",Long.class);
        //校验是否存在不可操作数据
        for(Long id:issueIds){
            DaifaGgoods g=gmap.get(id);
            if(g==null){
                throw new DaifaException("存在非该拿货员的分配数据");
            }
            if(g.getOperateIs()==1){
                throw new DaifaException("存在已拿货完成的分配数据");
            }
            if(g.getUseStatus()==0){
                throw new DaifaException("存在无效的分配数据");
            }
            if(!g.getCreateDate().equals(date)){
                throw new DaifaException("存在不是今天的分配数据");
            }
        }
        //清理不可操作的数据
        List<Long> keys=new ArrayList<>(gmap.keySet());
        for(Long id:keys){
            DaifaGgoods g=gmap.get(id);
            if(g.getOperateIs()==1||g.getUseStatus()==0||!g.getCreateDate().equals(date)){
                gmap.remove(id);
            }
        }
        //根据idIsCheck对相应的数据进行已拿操作
        if(idIsCheck){
            //已拿
            for(Long id:issueIds){
                DaifaGgoods g=gmap.get(id);
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.haveTake();
                gmap.remove(id);
            }
            //剩下的缺货
            for(DaifaGgoods g:gmap.values()){
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.noTake();
                notTakeDfOrderIds.add(g.getDfOrderId());
            }
        }else{
            //缺货
            for(Long id:issueIds){
                DaifaGgoods g=gmap.get(id);
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.noTake();
                notTakeDfOrderIds.add(g.getDfOrderId());
                gmap.remove(id);
            }
            //剩下的已拿
            for(DaifaGgoods g:gmap.values()){
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.haveTake();
            }
        }
        return notTakeDfOrderIds;
    }

    /**
     * 按日期拿货完成
     * @param date yyyyMMdd
     * @param sellerId 代发机构id
     * @throws DaifaException
     * @return 缺货了的子单ID
     */
    @Override
    public List<Long> completeWithDate(String date,Long sellerId) throws DaifaException {
        DaifaGgoodsExample ge=new DaifaGgoodsExample();
        ge.createCriteria().andCreateDateEqualTo(date).andOperateIsEqualTo(0).andSellerIdEqualTo(sellerId);
        List<DaifaGgoods> daifaGgoods =daifaGgoodsMapper.selectFieldsByExample(ge
                ,FieldUtil.codeFields("take_goods_id,df_order_id,use_status,operate_is,create_date"));
        List<Long> notTakeDfOrderIds=new ArrayList<>();
        for (DaifaGgoods daifaGgood : daifaGgoods) {
             SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,daifaGgood.getDfOrderId());
             subOrderModel.noTake();
            notTakeDfOrderIds.add(daifaGgood.getDfOrderId());
        }
        return notTakeDfOrderIds;
    }

    /**
     * 未发退款(代发系统调起)
     * @param dfOrderId
     */
    @Override
    public void refundHasItemApply(Long dfOrderId) throws DaifaException {
    }


    /**
     * 未发退款(订单系统调起)
     * @param refundId
     * @param psoid
     */
    @Override
    public void refundHasItem(Long refundId, Long psoid) {
    }


    /**
     * 数据库批次转化到页面显示
     *
     * @param dbstr 数据库显示batch
     * @return 页面显示batch
     */
    private String batchDBconvert(String dbstr) {
        String[] bas = dbstr.split("-");
        Calendar ca = Calendar.getInstance();
        Date date = DateUtil.stringToDate(bas[0], DateUtil.patternB);
        assert (date) != null;
        ca.setTime(date);

        return ca.get(Calendar.MONTH) + 1 + "." + ca.get(Calendar.DAY_OF_MONTH) + "-"
                + bas[1];
    }


    /**
     * 手动退款,系统后台专用
     * 该操作会将订单变成缺货,然后改为退款状态
     * 如果订单已拿到(无论是否已发货),都改成缺货,同时在待分配表写一条缺货数据,然后进行退款
     * @param dfOrderIds
     * @param tid
     * @param refundId
     * @throws DaifaException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class}, isolation = Isolation.DEFAULT)
    public void adminRefund(List<Long> dfOrderIds, Long tid, Long refundId) throws DaifaException {
        DaifaOrderExample searchDaifaOrderExample=new DaifaOrderExample();
        searchDaifaOrderExample.createCriteria().andDfOrderIdIn(dfOrderIds);
        List<DaifaOrder> cheakedOrders=daifaOrderMapper.selectByExample(searchDaifaOrderExample);
        if(cheakedOrders.size()<dfOrderIds.size()){
            //存在未查到数据的子单号
            throw new DaifaException("存在未查到数据的子单号");
        }
        for(DaifaOrder o :cheakedOrders){
            if(o.getDfTradeId().longValue()!=tid){
                //部分子单号和传递的主单号不匹配
                throw new DaifaException("部分子单号和传递的主单号不匹配");
            }
        }
        searchDaifaOrderExample=new DaifaOrderExample();
        searchDaifaOrderExample.createCriteria().andRefundIdEqualTo(refundId);
        cheakedOrders=daifaOrderMapper.selectByExample(searchDaifaOrderExample);
        if(cheakedOrders.size()>0){
            for(DaifaOrder o:cheakedOrders){
                if(o.getDfTradeId().longValue()!=tid){
                    throw new DaifaException("退款ID已存在");
                }
            }
        }

        Date time=new Date();
        String date= DateUtil.dateToString(time,DateUtil.patternB);
        for(Long dfOrderId:dfOrderIds){
            DaifaOrder uorder=new DaifaOrder();
            uorder.setDfOrderId(dfOrderId);
            uorder.setTakeGoodsStatus(2);//设置拿货状态
            uorder.setStockoutCycleStatus(1);
            daifaOrderMapper.updateByPrimaryKeySelective(uorder);

            DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
            daifaGgoodsTasksExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
            daifaGgoodsTasksExample.setOrderByClause("tasks_id asc");
            List<DaifaGgoodsTasks> ts=daifaGgoodsTasksMapper.selectByExample(daifaGgoodsTasksExample);
            if(ts.size()==0){
                continue;
            }
            DaifaGgoodsTasks updateTask=new DaifaGgoodsTasks();
            updateTask.setOperateIs(1);//设置已操作过拿货完成
            updateTask.setUseStatus(0);
            updateTask.setTakeGoodsStatus(2);//设置拿货状态
            daifaGgoodsTasksMapper.updateByExampleSelective(updateTask,daifaGgoodsTasksExample);

            DaifaGgoodsTasks t=ts.get(0);
            if(t.getTakeGoodsStatus()==1){
                DaifaGgoodsTasks insertTasks= BeanMapper.map(t,DaifaGgoodsTasks.class);
                insertTasks.setTakeGoodsStatus(2);//设置缺货
                insertTasks.setTasksId(null);//清空id
                insertTasks.setOperateIs(0);//重置操作状态
                insertTasks.setAllocatStatus(0);//重置分配状态
                insertTasks.setUseStatus(1);//设置数据有效
                insertTasks.setCreateDate(date);
                insertTasks.setCreateTime(time);
                insertTasks.setDaifaWorker(null);
                insertTasks.setDaifaWorkerId(null);
                insertTasks.setAllocatDate(null);
                insertTasks.setAllocatTime(null);
                insertTasks.setEndStatus(0);//设置待截单
                insertTasks.setGgoodsCode(null);//重置分配批号
                insertTasks.setPrintBarcodeStatus(1);//重置导出状态
                insertTasks.setPrintBatch(null);
                insertTasks.setPrintGoodsStatus(1);//重置打印状态
                daifaGgoodsTasksMapper.insertSelective(insertTasks);

                DaifaGgoods updateGgoods=new DaifaGgoods();
                updateGgoods.setUseStatus(0);//设置记录不可用
                updateGgoods.setOperateIs(1);//设置已操作过拿货完成
                updateGgoods.setTakeGoodsStatus(2);//设置拿货状态
                DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
                daifaGgoodsExample.createCriteria().andDfOrderIdEqualTo(dfOrderId);
                daifaGgoodsMapper.updateByExampleSelective(updateGgoods,daifaGgoodsExample);

                DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
                daifaWaitSendOrder.setDfOrderId(dfOrderId);
                daifaWaitSendOrder=daifaWaitSendOrderMapper.selectOne(daifaWaitSendOrder);
                if(daifaWaitSendOrder!=null){
                    DaifaWaitSendOrder updateWaitSendOrder=new DaifaWaitSendOrder();
                    updateWaitSendOrder.setDwsoId(daifaWaitSendOrder.getDwsoId());
                    updateWaitSendOrder.setTakeGoodsStatus(2);//设置拿货状态
                    updateWaitSendOrder.setHasNum(0);//设置已拿到数量
                    daifaWaitSendOrderMapper.updateByPrimaryKeySelective(updateWaitSendOrder);
                }

                DaifaSendOrder daifaSendOrder=new DaifaSendOrder();
                daifaSendOrder.setDfOrderId(dfOrderId);
                daifaSendOrder=daifaSendOrderMapper.selectOne(daifaSendOrder);
                if(daifaSendOrder!=null){
                    DaifaSendOrder updateSendOrder=new DaifaSendOrder();
                    updateSendOrder.setSendoId(daifaSendOrder.getSendoId());
                    updateSendOrder.setTakeGoodsStatus(2);//设置拿货状态
                    updateSendOrder.setHasNum(0);//设置已拿到数量
                    daifaSendOrderMapper.updateByPrimaryKeySelective(updateSendOrder);
                }
            }
        }
        tui(refundId,dfOrderIds,tid);
    }

    private void tui(Long refundId,List<Long> subOrderIds,Long tid){
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(subOrderIds);
        DaifaOrder daifaOrder=new DaifaOrder();
        daifaOrder.setRefundStatus(2);
        daifaOrder.setRefundId(refundId);
        daifaOrder.setRefundFinishTime(new Date());
        daifaOrderMapper.updateByExampleSelective(daifaOrder,daifaOrderExample);

        //更新已分配表状态为已退款
        DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
        daifaGgoodsExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoods daifaGgoods =new DaifaGgoods();
        daifaGgoods.setReturnStatus(2);
        daifaGgoods.setUseStatus(0);
        daifaGgoodsMapper.updateByExampleSelective(daifaGgoods,daifaGgoodsExample);

        //更新待分配表状态为已退款
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaGgoodsTasks daifaGgoodsTasks=new DaifaGgoodsTasks();
        daifaGgoodsTasks.setReturnStatus(2);
        daifaGgoodsTasks.setUseStatus(0);
        daifaGgoodsTasksMapper.updateByExampleSelective(daifaGgoodsTasks,daifaGgoodsTasksExample);

        //更新已发货表状态为已退款
        DaifaSendOrderExample daifaSendOrderExample=new DaifaSendOrderExample();
        daifaSendOrderExample.createCriteria().andDfOrderIdIn(subOrderIds).andDfTradeIdEqualTo(tid);
        DaifaSendOrder daifaSendOrder=new DaifaSendOrder();
        daifaSendOrder.setRefundStatus(2);
        daifaSendOrderMapper.updateByExampleSelective(daifaSendOrder,daifaSendOrderExample);

        //更新待发货表状态为已退款
        DaifaWaitSendOrderExample daifaWaitSendOrderExample=new DaifaWaitSendOrderExample();
        daifaWaitSendOrderExample.createCriteria().andDfTradeIdEqualTo(tid).andDfOrderIdIn(subOrderIds);
        DaifaWaitSendOrder daifaWaitSendOrder=new DaifaWaitSendOrder();
        daifaWaitSendOrder.setRefundStatus(2);
        daifaWaitSendOrder.setRefundTime(new Date());
        daifaWaitSendOrderMapper.updateByExampleSelective(daifaWaitSendOrder,daifaWaitSendOrderExample);
    }




    @Override
    public UnComleteAllVO uncompleteAllNew(Long wholeId, Long shopId, List<Long> issueIds, Boolean idIsCheck) throws DaifaException {
        String date=DateUtil.dateToString(new Date(),DateUtil.patternB);
        DaifaGgoodsExample ge=new DaifaGgoodsExample();
        ge.createCriteria().andDaifaWorkerIdEqualTo(wholeId).andStoreIdEqualTo(shopId);
        List<DaifaGgoods> gs=daifaGgoodsMapper.selectFieldsByExample(ge,FieldUtil.codeFields("take_goods_id,df_order_id,use_status,operate_is,create_date"));
        Map<Long,DaifaGgoods> gmap= BeanMapper.list2Map(gs,"takeGoodsId",Long.class);
        //校验是否存在不可操作数据
        for(Long id:issueIds){
            DaifaGgoods g=gmap.get(id);
            if(g==null){
                throw new DaifaException("存在非该拿货员的分配数据");
            }
            if(g.getOperateIs()==1){
                throw new DaifaException("存在已拿货完成的分配数据");
            }
            if(g.getUseStatus()==0){
                throw new DaifaException("存在无效的分配数据");
            }
            if(!g.getCreateDate().equals(date)){
                throw new DaifaException("存在不是今天的分配数据");
            }
        }
        //清理不可操作的数据
        List<Long> keys=new ArrayList<>(gmap.keySet());
        for(Long id:keys){
            DaifaGgoods g=gmap.get(id);
            if(g.getOperateIs()==1||g.getUseStatus()==0||!g.getCreateDate().equals(date)){
                gmap.remove(id);
            }
        }
        List<Long> oids=BeanMapper.getFieldList(gmap.values(),"dfOrderId",Long.class);
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
        List<DaifaOrder> os=daifaOrderMapper.selectFieldsByExample(daifaOrderExample,FieldUtil.codeFields("df_order_id,take_goods_status"));
        Map<Long,DaifaOrder> orderMap=BeanMapper.list2Map(os,"dfOrderId",Long.class);

        UnComleteAllVO vo=new UnComleteAllVO();
        List<Long> notTakeDfOrderIds=new ArrayList<>();
        List<Long> takeDfOrderIds=new ArrayList<>();

        //根据idIsCheck对相应的数据进行已拿操作
        if(idIsCheck){
            //已拿
            for(Long id:issueIds){
                DaifaGgoods g=gmap.get(id);
                if(orderMap.get(g.getDfOrderId())!=null&&orderMap.get(g.getDfOrderId()).getTakeGoodsStatus()==2){
                    takeDfOrderIds.add(g.getDfOrderId());
                }
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.haveTake();
                gmap.remove(id);
            }
            //剩下的缺货
            for(DaifaGgoods g:gmap.values()){
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.noTake();
                notTakeDfOrderIds.add(g.getDfOrderId());
            }
        }else{
            //缺货
            for(Long id:issueIds){
                DaifaGgoods g=gmap.get(id);
                if(orderMap.get(g.getDfOrderId())!=null&&orderMap.get(g.getDfOrderId()).getTakeGoodsStatus()==2){
                    takeDfOrderIds.add(g.getDfOrderId());
                }
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.noTake();
                notTakeDfOrderIds.add(g.getDfOrderId());
                gmap.remove(id);
            }
            //剩下的已拿
            for(DaifaGgoods g:gmap.values()){
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.haveTake();
            }
        }
        vo.setNotTakeIds(notTakeDfOrderIds);
        vo.setTakeIds(takeDfOrderIds);
        return vo;
    }
}
