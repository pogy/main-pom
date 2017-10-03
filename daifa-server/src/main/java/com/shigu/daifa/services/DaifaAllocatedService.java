package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.custom.beans.DaifaGgoodsJoinOrder;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.vo.DaifaAllocatedVO;
import com.shigu.daifa.vo.DaifaWorkerVO;
import com.shigu.daifa.vo.PrintGoodsTagVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.vo.PrintTagVO;
import com.shigu.main4.order.process.ItemOrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DaifaAllocatedService {
    @Autowired
    private DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    private DaifaMultipleMapper daifaMultipleMapper;
    @Autowired
    private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    private TakeGoodsIssueProcess takeGoodsIssueProcess;
    @Autowired
    private ItemOrderProcess itemOrderProcess;

    public ShiguPager<DaifaAllocatedVO> selectDaifaGgoodsList(Long sellerId,Long workerId,Long searchWorkerId,Integer status, String lastOrderId, String lastSubOrderId,
                                                              String startDate, String endDate, Integer page, Integer size) {
        DaifaGgoodsExample daifaGgoodsExample = new DaifaGgoodsExample();
        DaifaGgoodsExample.Criteria ce = daifaGgoodsExample.createCriteria().andSellerIdEqualTo(sellerId)
                .andUseStatusEqualTo(1).andOperateIsEqualTo(0);
        daifaGgoodsExample.setOrderByClause("create_time desc");
        if (lastOrderId != null) {
            ce.andDfTradeIdLike("%" + lastOrderId);
        }
        if (lastSubOrderId != null) {
            ce.andDfOrderIdLike("%" + lastSubOrderId);
        }
        if (startDate != null) {
            String st = DateUtil.dateToString(DateUtil.stringToDate(startDate, DateUtil.patternA), DateUtil.patternB);
            ce.andCreateDateGreaterThanOrEqualTo(st);
        }
        if (endDate != null) {
            String et = DateUtil.dateToString(DateUtil.stringToDate(endDate, DateUtil.patternA), DateUtil.patternB);
            ce.andCreateDateLessThanOrEqualTo(et);
        }
        if(searchWorkerId!=null){
            ce.andDaifaWorkerIdEqualTo(searchWorkerId);
        }
        if(status!=null){
            ce.andPrintBarcodeStatusEqualTo(status);
        }
        Integer count = daifaGgoodsMapper.countByExample(daifaGgoodsExample);
        List<DaifaAllocatedVO> vos = new ArrayList<>();
        if (count > 0) {
            DaifaOrderExample daifaOrderExample = new DaifaOrderExample();
            DaifaTradeExample daifaTradeExample = new DaifaTradeExample();
            MultipleExample example = MultipleExampleBuilder.from(daifaGgoodsExample)
                    .join(daifaOrderExample)
                    .on(ce.equalTo(DaifaGgoodsExample.dfOrderId, DaifaOrderExample.dfOrderId))
                    .join(daifaTradeExample)
                    .on(daifaOrderExample.createCriteria().equalTo(DaifaOrderExample.dfTradeId, DaifaTradeExample.dfTradeId))
                    .build();
            example.setStartIndex((page - 1) * size);
            example.setEndIndex(size);
            List<DaifaGgoodsJoinOrder> ggoodsForPrints = daifaMultipleMapper
                    .selectFieldsByMultipleExample(example, DaifaGgoodsJoinOrder.class);
            for (DaifaGgoodsJoinOrder g : ggoodsForPrints) {
                DaifaAllocatedVO vo = new DaifaAllocatedVO();
                vo.setChildOrderId(g.getDfOrderId());
                vo.setTakeGoodsId(g.getTakeGoodsId());
                vo.setChildRemark(g.getOrderRemark());
                vo.setDffs(g.getDaifaType());
                vo.setGoodsNo(g.getStoreGoodsCode());
                vo.setGoodsProperty(g.getPropStr());
                vo.setHaveGoodsTime(DateUtil.dateToString(g.getYouhuoDate(), DateUtil.patternD));
                vo.setImgSrc(g.getPicPath());
                vo.setNoSaleIs(g.getDelistIs() == 1);
                vo.setNum(g.getGoodsNum());
                vo.setPiPrice(g.getSinglePiPrice());
                vo.setPayPrice(MoneyUtil.dealPrice(
                        MoneyUtil.StringToLong(g.getSinglePay())
                                + MoneyUtil.StringToLong(g.getOrderDiscountFee())
                                - MoneyUtil.StringToLong(g.getSingleServicesFee()))
                );
                vo.setTitle(g.getTitle());
                vo.setTakeGoodsState(g.getTakeGoodsStatus());
                vo.setIsMyTask(workerId.longValue()==g.getDaifaWorkerId());
                vos.add(vo);
            }
        }
        ShiguPager<DaifaAllocatedVO> pager=new ShiguPager<>();
        pager.setContent(vos);
        pager.setNumber(page);
        pager.calPages(count,size);
        return pager;
    }

    public void takeGoods(Long workerId,Long takeGoodsId,Integer takeType) throws DaifaException {
        if (takeType == null) {
            throw new DaifaException("类型为空");
        }
        DaifaGgoods g=new DaifaGgoods();
        g.setDaifaWorkerId(workerId);
        g.setTakeGoodsId(takeGoodsId);
        g=daifaGgoodsMapper.selectOne(g);
        if (g == null) {
            throw new DaifaException("不是分配给该拿货员的商品");
        }
        switch (takeType){
            case 1:{
                DaifaOrder o=daifaOrderMapper.selectFieldsByPrimaryKey(g.getDfOrderId(),FieldUtil.codeFields("take_goods_status"));
                takeGoodsIssueProcess.complete(takeGoodsId);
                if(o.getTakeGoodsStatus()==2){
                    orderServerTake(g.getDfOrderId());
                }
                break;
            }
            case 2:{
                takeGoodsIssueProcess.uncomplete(takeGoodsId);
                //发送缺货信息到order-server
                orderServerNotTake(g.getDfOrderId());
                break;
            }
        }
    }

    public List<PrintGoodsTagVO> printGoodsTab(Long sellerId,List<Long> ids)throws DaifaException{
        List<PrintTagVO> printTagVOS=new ArrayList<>();
        if(ids==null){
            printTagVOS=takeGoodsIssueProcess.printAllTags(sellerId);
        }else{
            DaifaGgoodsExample example=new DaifaGgoodsExample();
            example.createCriteria().andSellerIdEqualTo(sellerId).andTakeGoodsIdIn(ids);
            List<DaifaGgoods> gs=daifaGgoodsMapper.selectFieldsByExample(example, FieldUtil.codeFields("take_goods_id"));
            ids.clear();
            gs.forEach(daifaGgoods -> {
                ids.add(daifaGgoods.getTakeGoodsId());
            });
            printTagVOS=takeGoodsIssueProcess.printTags(ids);
        }
        List<PrintGoodsTagVO> vos=new ArrayList<>();
        printTagVOS.forEach(printTagVO -> {
            PrintGoodsTagVO vo= BeanMapper.map(printTagVO,PrintGoodsTagVO.class);
            vo.setStockoutDay(printTagVO.getRemarks());
            vo.setQueNum (printTagVO.getRemarks ());
            vos.add(vo);
        });
        return vos;
    }

    public void orderServerNotTake(Long dfOrderId){
        if(dfOrderId==null){
            return;
        }
        try {
            DaifaOrder o=daifaOrderMapper.selectFieldsByPrimaryKey(dfOrderId,FieldUtil.codeFields("df_order_id,order_partition_id"));
            if(o!=null){
                itemOrderProcess.outOfStock(new Long(o.getOrderPartitionId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void orderServerTake(Long dfOrderId){
        if(dfOrderId==null){
            return;
        }
        try {
            DaifaOrder o=daifaOrderMapper.selectFieldsByPrimaryKey(dfOrderId,FieldUtil.codeFields("df_order_id,order_partition_id"));
            if(o!=null){
                itemOrderProcess.cancleOutOfStock(new Long(o.getOrderPartitionId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void tongbuquehuo(){
        DaifaGgoodsTasksExample daifaGgoodsTasksExample=new DaifaGgoodsTasksExample();
        daifaGgoodsTasksExample.createCriteria().andTakeGoodsStatusEqualTo(2).andOperateIsEqualTo(0).andAllocatStatusEqualTo(0);
        List<DaifaGgoodsTasks> tasks=daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample,FieldUtil.codeFields("tasks_id,df_order_id"));
        Map<Long,List<DaifaGgoodsTasks>> tsMap=BeanMapper.groupBy(tasks,"dfOrderId",Long.class);
        for(List<DaifaGgoodsTasks> ts:tsMap.values()){
            if(ts.size()>0){
                orderServerNotTake(ts.get(0).getDfOrderId());
            }
        }
    }
}
