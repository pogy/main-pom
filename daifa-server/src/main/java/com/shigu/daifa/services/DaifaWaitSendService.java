package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.*;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.bo.WaitSendBO;
import com.shigu.daifa.vo.DaifaWaitSendVO;
import com.shigu.daifa.vo.WaitSendOrderVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public ShiguPager<DaifaWaitSendVO> selPageData(WaitSendBO bo, Long daifaSellerId) {
        if(bo.getPage()<1){
            bo.setPage(1);
        }
        List<DaifaWaitSendVO> sends = new ArrayList<>();
        int count = daifaWaitSendMapper.selectWaitSendsCount(daifaSellerId,
                bo.getOrderId(),
                StringUtils.hasText(bo.getTelephone())?bo.getTelephone():null,
                bo.getBuyerId(),
                StringUtils.hasText(bo.getStartTime())?DateUtil.stringToDate(bo.getStartTime()+" 00:00:00"):null,
                StringUtils.hasText(bo.getEndTime())?DateUtil.stringToDate(bo.getEndTime()+" 23:59:59"):null,
                bo.getCanSendState());
        if (count > 0) {
//            MultipleExample multipleExample = MultipleExampleBuilder.from(daifaWaitSendExample).join(daifaTradeExample).on(new DaifaWaitSendExample().createCriteria()
//                    .equalTo(DaifaWaitSendExample.dfTradeId,DaifaTradeExample.dfTradeId))
//                    .leftJoin(daifaWaitSendOrderExample)
//                    .on(daifaWaitSendExample.createCriteria()
//                            .equalTo(DaifaWaitSendExample.dwsId, DaifaWaitSendOrderExample.dwsId)).build();
//            List<DaifaWaitSendSimple> daifaWaitSendSimples = daifaMultipleMapper.selectFieldsByMultipleExample(multipleExample, DaifaWaitSendSimple.class);
            List<DaifaWaitSendSimple> daifaWaitSendSimples=daifaWaitSendMapper.selectWaitSends(daifaSellerId,
                    bo.getOrderId(),
                    StringUtils.hasText(bo.getTelephone())?bo.getTelephone():null,
                    bo.getBuyerId(),
                    StringUtils.hasText(bo.getStartTime())?DateUtil.stringToDate(bo.getStartTime()+" 00:00:00"):null,
                    StringUtils.hasText(bo.getEndTime())?DateUtil.stringToDate(bo.getEndTime()+" 23:59:59"):null,
                    bo.getCanSendState(),
                    (bo.getPage() - 1) * 10,
                    10);


            List<Long> oids=new ArrayList<>();
            for (DaifaWaitSendSimple daifaWaitSendSimple : daifaWaitSendSimples) {
                DaifaWaitSendVO vo = new DaifaWaitSendVO();
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
                        DaifaOrder o=map.get(so.getChildOrderId());
                        if(o!=null){
                            so.setChildServersFee(o.getSingleServicesFee());
                            so.setChildRemark(o.getOrderRemark());
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
        ShiguPager<DaifaWaitSendVO> pager = new ShiguPager<>();
        pager.setTotalCount(count);
        pager.setContent(sends);
        pager.setNumber(bo.getPage());
        return pager;
    }

    public synchronized JSONObject noPostRefund(Long childOrderId, String refundMoney) throws DaifaException {
        if(MoneyUtil.StringToLong(refundMoney)<0){
            throw new DaifaException("金额错误");
        }
        Integer status=takeGoodsIssueProcess.refundHasItemApply(childOrderId,refundMoney);
        DaifaOrder o=daifaOrderMapper.selectByPrimaryKey(childOrderId);

        DaifaTrade t=daifaTradeMapper.selectByPrimaryKey(o.getDfTradeId());
        if(t.getSendStatus()==2){
            throw new DaifaException("已发货");
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
