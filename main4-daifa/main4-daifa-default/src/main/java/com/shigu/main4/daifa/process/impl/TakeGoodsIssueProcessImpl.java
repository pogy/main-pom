package com.shigu.main4.daifa.process.impl;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
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
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service
public class TakeGoodsIssueProcessImpl implements TakeGoodsIssueProcess {
    @Autowired
    private DaifaGgoodsMapper daifaGgoodsMapper;


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

    @Override
    public String distributionTask (Long wholeId, List<Long> waitIssueIds) throws DaifaException {
        CargoManModel cargoManModel = SpringBeanFactory.getBean(CargoManModel.class, wholeId);
        return cargoManModel.takeToMe(waitIssueIds);
    }

    @Override
    public String distributionTaskWithShop (Long wholeId, Long shopId) throws DaifaException {
        //先根据shopId查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andStoreIdEqualTo(shopId)
                .andUseStatusEqualTo(1)//可用
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex, FieldUtil.codeFields("task_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt-> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId,taskIds);
    }

    @Override
    public String distributionTaskWithFloor (Long wholeId, Long floorId) throws DaifaException {

        //先根据floorid查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andUseStatusEqualTo(1)//可用
                .andFloorIdEqualTo(floorId)
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                ,FieldUtil.codeFields("task_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt-> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId,taskIds);
    }

    @Override
    public String distributionTaskWithMarket (Long wholeId, Long marketId) throws DaifaException {
          //先根据marketId查出待分配id
        DaifaGgoodsTasksExample dgtex = new DaifaGgoodsTasksExample();
        dgtex.createCriteria()
                .andUseStatusEqualTo(1)//可用
                .andMarketIdEqualTo(marketId)
                .andAllocatStatusEqualTo(0)//未分配
                .andEndStatusEqualTo(0);//未结算
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(dgtex
                ,FieldUtil.codeFields("task_id"));
        List<Long> taskIds = new ArrayList<>();
        ggoodsTasks.forEach(gt-> taskIds.add(gt.getTasksId()));
        return distributionTask(wholeId,taskIds);
    }

    @Override
    public List<PrintTagVO> printAllTags () {

        return null;
    }

    @Override
    public List<PrintTagVO> printTags (List<Long> issueIds) {
        String nowDate= DateUtil.dateToString(new Date(),DateUtil.patternB);
        //先根据ids查询出数据
        DaifaGgoodsExample dgex = new DaifaGgoodsExample();
        DaifaOrderExample doex = new DaifaOrderExample();
        DaifaTradeExample dtex = new DaifaTradeExample();

        MultipleExample multipleExample = MultipleExampleBuilder.from(dgex).join(dtex)
                .on(dgex.createCriteria().andTakeGoodsIdIn(issueIds)
                        .equalTo(DaifaGgoodsExample.dfTradeId, DaifaTradeExample.dfTradeId)).join(doex)
                .on(dgex.createCriteria().equalTo(DaifaGgoodsExample.dfOrderId, DaifaOrderExample.dfOrderId)).build();
        List<GgoodsForPrint> ggoodsForPrints = multipleMapper
                .selectFieldsByMultipleExample(multipleExample, GgoodsForPrint.class);

        List<PrintTagVO> pvos = new ArrayList<>();

//
//        CountTransExample ctex=new CountTransExample();
//        ctex.setOrderByClause("id desc");
//        ctex.setStartIndex(0);
//        ctex.setEndIndex(1);
//        ctex.createCriteria().andCreateDateEqualTo(nowDate);
//        //查询当天有无操作过批次
//        List<CountTrans> ctlist=countTransMapper.selectByConditionList(ctex);
//
//        int startindex=0;
//        if(ctlist.size()>0){
//            startindex=ctlist.get(0).getFinalNumber().intValue();
//        }


        ggoodsForPrints.forEach(ggoodsForPrint -> {
            PrintTagVO vo  = new PrintTagVO();
            vo.setOrderSort(ggoodsForPrint.getBarCodeKeyNum());
            vo.setSpecialStr(ggoodsForPrint.getBarCodeKey());
            vo.setPackages(ggoodsForPrint.getGoodsNum());
            String barcode = ggoodsForPrint.getDfOrderId().toString() + ggoodsForPrint.getDfTradeId().toString()
                    .substring(ggoodsForPrint.getDfTradeId().toString().length() - EZINT);//计算长度
            vo.setBarCode(barcode);
            vo.setpAndBarCode((int)Double.parseDouble(ggoodsForPrint.getSinglePiPrice())+"N"+barcode);
            vo.setBuyerNick(ggoodsForPrint.getBuyerNick());
            vo.setReceiverName(ggoodsForPrint.getRecieverName());





        });


        return pvos;
    }

    @Override
    public void complete (Long issueId) throws DaifaException {
        DaifaGgoods g=daifaGgoodsMapper.selectFieldsByPrimaryKey(issueId, FieldUtil.codeFields("take_goods_id,df_order_id"));
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
        DaifaGgoods g=daifaGgoodsMapper.selectFieldsByPrimaryKey(issueId, FieldUtil.codeFields("take_goods_id,df_order_id"));
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
        List<DaifaGgoods> gs=daifaGgoodsMapper.selectFieldsByExample(ge,FieldUtil.codeFields("take_goods_id,df_order_id,use_status,operate_is,create_time"));
        Map<Long,DaifaGgoods> gmap= BeanMapper.list2Map(gs,"take_goods_id",Long.class);
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
}
