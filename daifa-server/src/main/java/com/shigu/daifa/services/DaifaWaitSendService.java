package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaPostCustomerExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.bo.WaitSendBO;
import com.shigu.daifa.vo.DaifaWaitSendVO;
import com.shigu.daifa.vo.WaitSendOrderVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.bo.SubOrderExpressBO;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by pc on 2017-09-05.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class DaifaWaitSendService {
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;
    @Autowired
    private AfterSaleService afterSaleService;
    @Autowired
    private DaifaWaitSendMapper daifaWaitSendMapper;
    @Autowired
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    private DaifaOrderMapper daifaOrderMapper;
    @Autowired
    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    private DaifaPostCustomerMapper daifaPostCustomerMapper;
    @Autowired
    private PackDeliveryProcess packDeliveryProcess;


    /**
     * 快递列表
     * @return
     */
    public List<DaifaPostCustomer> selPost(){
        DaifaPostCustomerExample example=new DaifaPostCustomerExample();
        example.setOrderByClause("express_id desc");
        example.setStartIndex(0);
        example.setEndIndex(20);
        List<DaifaPostCustomer> list=daifaPostCustomerMapper.selectFieldsByConditionList(example,"express_id,express");
        return list;
    }


    public ShiguPager<DaifaWaitSendVO> selPageData(WaitSendBO bo, Long daifaSellerId) {
        if(bo.getPage()<1){
            bo.setPage(1);
        }
        Date st=null;
        Date et=null;
        Long stId=null;
        Long etId=null;

        //查询时间间隔，没有则查一月内
        if(StringUtils.isBlank(bo.getStartTime())&&StringUtils.isBlank(bo.getEndTime())){
            st=DateUtil.getdate(-30);
        }else{
            //查询时间间隔，有则按时间查
            st=StringUtils.isNotBlank(bo.getStartTime())?DateUtil.stringToDate(bo.getStartTime()+" 00:00:00"):null;
            et=StringUtils.isNotBlank(bo.getEndTime())?DateUtil.stringToDate(bo.getEndTime()+" 23:59:59"):null;
        }
        DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
        DaifaTradeExample.Criteria criteria = daifaTradeExample.createCriteria();
        if(st!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(st);
        }
        if (bo.getExpressId() != null){
            criteria.andExpressIdEqualTo(Long.valueOf(bo.getExpressId()));
        }
        daifaTradeExample.setOrderByClause("df_trade_id asc");
        daifaTradeExample.setStartIndex(0);
        daifaTradeExample.setEndIndex(1);
        //查DaifaTrade 表中订单id
        List<DaifaTrade> ts1 = daifaTradeMapper
                .selectFieldsByConditionList(daifaTradeExample, FieldUtil.codeFields("df_trade_id"));
        List<DaifaWaitSendVO> sends = new ArrayList<>();
        int count=0;
        if(ts1.size()>0){
            stId=ts1.get(0).getDfTradeId();
            if(et!=null){
                criteria.andCreateTimeLessThanOrEqualTo(et);
                daifaTradeExample.setOrderByClause("df_trade_id desc");
                ts1 = daifaTradeMapper
                        .selectFieldsByConditionList(daifaTradeExample, FieldUtil.codeFields("df_trade_id"));
                etId=ts1.get(0).getDfTradeId();
            }
            //按条件查询
            count = daifaWaitSendMapper.selectWaitSendsCount(daifaSellerId,
                    bo.getOrderId(),
                    StringUtils.isNotBlank(bo.getTelephone())?bo.getTelephone():null,
                    bo.getBuyerId(),
                    stId,
                    etId,
                    bo.getCanSendState());
            if (count > 0) {
                List<DaifaWaitSendSimple> daifaWaitSendSimples=daifaWaitSendMapper.selectWaitSendsIds(daifaSellerId,
                        bo.getOrderId(),
                        StringUtils.isNotBlank(bo.getTelephone())?bo.getTelephone():null,
                        bo.getBuyerId(),
                        stId,
                        etId,
                        bo.getCanSendState(),
                        (bo.getPage() - 1) * 10,
                        10);
                List<Long> tids=daifaWaitSendSimples.stream().map(DaifaWaitSendSimple::getOrderId).collect(Collectors.toList());
                List<Long> dwsIds=daifaWaitSendSimples.stream().map(DaifaWaitSendSimple::getDwsId).collect(Collectors.toList());
                String dwsIdsStr=StringUtils.join(dwsIds,",");
                daifaWaitSendSimples=daifaWaitSendMapper.selectWaitSends(dwsIdsStr);
                DaifaTradeExample te=new DaifaTradeExample();
                te.createCriteria().andDfTradeIdIn(tids);
                List<DaifaTrade> trades=daifaTradeMapper.selectFieldsByExample(te,
                        FieldUtil.codeFields("df_trade_id,trade_discount_fee,services_fee,daifa_type"));
                Map<Long,DaifaTrade> tradeMap=trades.stream().collect(Collectors.toMap(DaifaTrade::getDfTradeId,daifaTrade -> daifaTrade));
                daifaWaitSendSimples.forEach(daifaWaitSendSimple -> {
                    DaifaTrade trade=tradeMap.get(daifaWaitSendSimple.getOrderId());
                    daifaWaitSendSimple.setDiscountFee(trade.getTradeDiscountFee());
                    daifaWaitSendSimple.setServersFee(trade.getServicesFee());
                    daifaWaitSendSimple.setIsTbOrder(trade.getDaifaType()==2);
                });
                List<Long> oids=new ArrayList<>();
                for (DaifaWaitSendSimple daifaWaitSendSimple : daifaWaitSendSimples) {
                    DaifaWaitSendVO vo = new DaifaWaitSendVO();
                    String exprName=daifaWaitSendSimple.getExpressName();
                    DaifaPostCustomer customer=new DaifaPostCustomer();
                    customer.setExpress(exprName);
                    List<DaifaPostCustomer> cs=daifaPostCustomerMapper.select(customer);
                    Long orderid=daifaWaitSendSimple.getOrderId();
                    try {
                        List<SubOrderExpressBO> bos=packDeliveryProcess.cheackeSend(orderid);
                        int csc=cs.get(0).getManual();
                        if (bos != null && csc == 1){
                            vo.setEnableSendBtn(true);
                        }
                    } catch (DaifaException e) {
                        e.printStackTrace();
                    }
                    sends.add(vo);
                    BeanUtils.copyProperties(daifaWaitSendSimple, vo, "childOrders");
                    if("无".equals(vo.getImWw())){
                        vo.setImWw(null);
                    }
                    List<WaitSendOrderVO> subList = new ArrayList<>();
                    for (DaifaWaitSendOrderSimple daifaWaitSendOrderSimple : daifaWaitSendSimple.getChildOrders()) {
                        WaitSendOrderVO subVo = new WaitSendOrderVO();
                        subVo.setRefundState(daifaWaitSendOrderSimple.getRefundStatus());
                        BeanUtils.copyProperties(daifaWaitSendOrderSimple, subVo);
                        subList.add(subVo);
                        oids.add(daifaWaitSendOrderSimple.getChildOrderId());
                    }
                    vo.setChildOrders(subList);
                }
                if(oids.size()>0){
                    DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
                    daifaOrderExample.createCriteria().andDfOrderIdIn(oids);
                    List<DaifaOrder> os=daifaOrderMapper.selectByExample(daifaOrderExample);
                    Map<Long,DaifaOrder> map= BeanMapper.list2Map(os,"dfOrderId",Long.class);

                    DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
                    daifaGgoodsTasksExample.setOrderByClause("tasks_id desc");
                    daifaGgoodsTasksExample.createCriteria()
                            .andDfOrderIdIn(oids);
                    List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample,FieldUtil.codeFields("df_order_id,end_status"));
                    Map<Long,List<DaifaGgoodsTasks>> taskMap=BeanMapper.groupBy(ggoodsTasks,"dfOrderId",Long.class);

                    for(DaifaWaitSendVO send:sends){
                        for(WaitSendOrderVO so:send.getChildOrders()){
                            so.setNoSaleIs(false);
                            DaifaOrder o=map.get(so.getChildOrderId());
                            if(o!=null){
                                so.setChildServersFee(o.getSingleServicesFee());
                                so.setChildRemark(o.getOrderRemark());
                                so.setNoSaleIs(o.getDelistIs()==1);
                            }
                            List<DaifaGgoodsTasks> t=taskMap.get(so.getChildOrderId());
                            if(t!=null&&t.size()>0){
                                if(so.getRefundState()==2&&t.get(0).getEndStatus()==1){
                                    so.setRefundState(3);
                                }
                            }
                        }
                    }
                }
            }

        }

        ShiguPager<DaifaWaitSendVO> pager = new ShiguPager<>();
        pager.setTotalCount(count);
        pager.setContent(sends);
        pager.setNumber(bo.getPage());
        return pager;
    }


    public synchronized JSONObject noPostRefund(Long childOrderId, String refundMoney) throws DaifaException {
        if(MoneyUtil.StringToLong(refundMoney)<0){
            throw new DaifaException("金额错误",DaifaException.DEBUG);
        }
        Integer status=takeGoodsIssueProcess.refundHasItemApply(childOrderId,refundMoney);
        DaifaOrder o=daifaOrderMapper.selectByPrimaryKey(childOrderId);

        DaifaTrade t=daifaTradeMapper.selectByPrimaryKey(o.getDfTradeId());
        if(t.getSendStatus()==2){
            throw new DaifaException("已发货",DaifaException.DEBUG);
        }
        Long otherPrice=MoneyUtil.StringToLong(t.getExpressFee());
        DaifaOrder ox = new DaifaOrder();
        ox.setDfTradeId(o.getDfTradeId());
        List<DaifaOrder> os = daifaOrderMapper.select(ox);
        for(DaifaOrder o1:os){
            if(o1.getRefundStatus() == 0){
                otherPrice=0L;
                break;
            }
        }
        if(otherPrice!=0L){
            refundMoney=MoneyUtil.dealPrice(MoneyUtil.StringToLong(refundMoney)+otherPrice);
        }
        Long refundId;
        try {
            refundId =afterSaleService.refundHasItem(new Long(o.getOrderPartitionId()), MoneyUtil.StringToLong(refundMoney));
        } catch (Exception e) {
            takeGoodsIssueProcess.refundHasItemErrorRollback(childOrderId,status);
            return JsonResponseUtil.error(e.getMessage());
        }
        takeGoodsIssueProcess.refundHasItem(refundId,new Long(o.getOrderPartitionId()),MoneyUtil.StringToLong(refundMoney));
        return JsonResponseUtil.success();
    }

}
