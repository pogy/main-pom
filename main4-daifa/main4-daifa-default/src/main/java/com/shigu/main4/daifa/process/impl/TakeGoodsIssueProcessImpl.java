package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.CountTrans;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.examples.*;
import com.opentae.data.daifa.interfaces.CountTransMapper;
import com.opentae.data.daifa.interfaces.DaifaGgoodsMapper;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsMapper;
import com.opentae.data.daifa.interfaces.DaifaGgoodsTasksMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.beans.GgoodsForPrint;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.model.CargoManModel;
import com.shigu.main4.daifa.model.SubOrderModel;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.utils.Pingyin;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
@Repository
@Scope("prototype")
public class TakeGoodsIssueProcessImpl implements TakeGoodsIssueProcess {

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
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex, FieldUtil.codeFields("task_id"));
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
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                , FieldUtil.codeFields("task_id"));
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
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                , FieldUtil.codeFields("task_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt -> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId, taskIds);
    }

    @Override
    public List<PrintTagVO> printAllTags(Long sellerId) {
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
            vo.setpAndBarCode((int) Double.parseDouble(ggoodsForPrint.getSinglePiPrice()) + "N" + barcode);
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

    @Override
    public void uncompleteAll (Long wholeId, List<Long> issueIds,Boolean idIsCheck) throws DaifaException {
        String date=DateUtil.dateToString(new Date(),DateUtil.patternB);
        DaifaGgoodsExample ge=new DaifaGgoodsExample();
        ge.createCriteria().andDaifaWorkerIdEqualTo(wholeId);
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
            }
        }else{
            //缺货
            for(Long id:issueIds){
                DaifaGgoods g=gmap.get(id);
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.noTake();
                gmap.remove(id);
            }
            //剩下的已拿
            for(DaifaGgoods g:gmap.values()){
                SubOrderModel subOrderModel= SpringBeanFactory.getBean(SubOrderModel.class,g.getDfOrderId());
                subOrderModel.haveTake();
            }
        }
    }

    /**
     * 数据库批次转化到页面显示
     *
     * @param dbstr 数据库显示batch
     * @return 页面显示batch
     */
    private String batchDBconvert(String dbstr) {
        String[] bas = dbstr.split("_");
        Calendar ca = Calendar.getInstance();
        Date date = DateUtil.stringToDate(bas[0], DateUtil.patternB);
        assert (date) != null;
        ca.setTime(date);

        return ca.get(Calendar.MONTH) + 1 + "." + ca.get(Calendar.DAY_OF_MONTH) + "-"
                + bas[1];
    }


}
