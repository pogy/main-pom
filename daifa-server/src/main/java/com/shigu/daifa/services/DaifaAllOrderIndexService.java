package com.shigu.daifa.services;

import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaAllOrder;
import com.opentae.data.daifa.beans.DaifaAllSubOrder;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.examples.DaifaWorkerExample;
import com.opentae.data.daifa.interfaces.DaifaMultipleMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.opentae.data.daifa.interfaces.DaifaWorkerMapper;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.bo.AllOrderBO;
import com.shigu.daifa.vo.AllSubOrderVO;
import com.shigu.daifa.vo.DaifaAllOrderVO;
import com.shigu.daifa.vo.DaifaWorkerVO;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-08-14.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class DaifaAllOrderIndexService {
    private static String LAST_OUT_TIME;//最后一次超时保存的时间yyyyMMdd

    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    public void setDaifaTradeMapper(DaifaTradeMapper daifaTradeMapper) {
        this.daifaTradeMapper = daifaTradeMapper;
    }

    private DaifaMultipleMapper daifaMultipleMapper;
    @Autowired
    public void setDaifaMultipleMapper(DaifaMultipleMapper daifaMultipleMapper) {
        this.daifaMultipleMapper = daifaMultipleMapper;
    }

    private DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    public void setDaifaWorkerMapper(DaifaWorkerMapper daifaWorkerMapper) {
        this.daifaWorkerMapper = daifaWorkerMapper;
    }

    private OrderManageProcess orderManageProcess;
    @Autowired
    public void setOrderManageProcess(OrderManageProcess orderManageProcess) {
        this.orderManageProcess = orderManageProcess;
    }

    public List<DaifaAllOrderVO> allOrderPage(AllOrderBO bo,Long sellerId) {


        DaifaTradeExample dtex = new DaifaTradeExample();
        DaifaOrderExample doex = new DaifaOrderExample();
        DaifaTradeExample.Criteria ce = dtex.createCriteria();
        ce.andSellerIdEqualTo(sellerId);
        if (StringUtils.hasText(bo.getEndTime())) {
            Date endDate = DateUtil.getIsEndTime (DateUtil.stringToDate(bo.getEndTime(),"yyyy-MM-dd"));
            ce.andCreateTimeLessThanOrEqualTo(endDate);
        }
        if(StringUtils.hasText(bo.getTelephone())){
            ce.andReceiverPhoneEqualTo(bo.getTelephone());
        }
        if (StringUtils.hasText(bo.getStartTime())) {
            Date startDate =DateUtil.getIsStartTime (DateUtil.stringToDate(bo.getStartTime(),"yyyy-MM-dd")) ;
            ce.andCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (StringUtils.hasText(bo.getOrderId())) {
            ce.andDfTradeIdLike("%" + bo.getOrderId());
        }
        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        int i = daifaTradeMapper.countByExample(dtex);
        bo.setCount(i);
        List<DaifaAllOrderVO> daifaAllOrderVOS = new ArrayList<>();
        if(i > 0){
            int page = Integer.parseInt(bo.getPage());
            int rows = 10;
            dtex.setStartIndex((page - 1) * rows);
            dtex.setEndIndex(rows);

            MultipleExample multipleExample = MultipleExampleBuilder.from(dtex).leftJoin(doex)
                    .on(new DaifaTradeExample().createCriteria().equalTo(DaifaTradeExample.dfTradeId, DaifaOrderExample.dfTradeId)).build();
            List<DaifaAllOrder> daifaAllOrders = daifaMultipleMapper.selectFieldsByMultipleExample(multipleExample, DaifaAllOrder.class);
            for (DaifaAllOrder daifaAllOrder : daifaAllOrders) {
                DaifaAllOrderVO vo = new DaifaAllOrderVO();
                List<AllSubOrderVO> allSubOrderVOS = new ArrayList<>();
                vo.setChildOrders(allSubOrderVOS);
                daifaAllOrderVOS.add(vo);
                BeanUtils.copyProperties(daifaAllOrder, vo, "childOrders");
                for (DaifaAllSubOrder daifaAllSubOrder : daifaAllOrder.getChildOrders()) {
                    AllSubOrderVO subvo = new AllSubOrderVO();
                    BeanUtils.copyProperties(daifaAllSubOrder, subvo);
                    allSubOrderVOS.add(subvo);
                }
                if (daifaAllOrder.getTradeState() == 2) {
                    for (DaifaAllSubOrder daifaAllSubOrder : daifaAllOrder.getChildOrders()) {
                        Integer afterSaleState = 1;//已发货
                        if (daifaAllSubOrder.getReturnGoodsStatus() != null && daifaAllSubOrder.getReturnGoodsStatus() > 0 ||
                                (daifaAllSubOrder.getChangeStatus() != null && daifaAllSubOrder.getChangeStatus() > 0)
                                ) {
                            switch (daifaAllSubOrder.getReturnGoodsStatus()) {
                                case 1: {
                                    afterSaleState = 2;//申请退货退款
                                    break;
                                }
                                case 2: {
                                    afterSaleState = 4;// 退货完成
                                    break;
                                }
                                case 3: {
                                    afterSaleState = 5;//拒绝退货退款
                                    break;
                                }
                                default: {
                                    break;
                                }

                            }
                            switch (daifaAllSubOrder.getChangeStatus()) {
                                case 1: {
                                    afterSaleState = 6;//申请换货
                                    break;
                                }
                                case 2: {
                                    afterSaleState = 8; //换货完成
                                    break;
                                }
                                case 3: {
                                    afterSaleState = 9;//换货失败
                                    break;
                                }
                                case 4: {
                                    afterSaleState = 9;//换货失败
                                    break;
                                }
                                default: {
                                    break;
                                }

                            }
                        }

                        for (AllSubOrderVO allSubOrderVO : vo.getChildOrders()) {
                            if (allSubOrderVO.getChildOrderId().equals(daifaAllSubOrder.getChildOrderId())) {
                                allSubOrderVO.setAfterSaleState(afterSaleState);
                            }
                        }
                    }
                }
            }
        }
        return daifaAllOrderVOS;
    }

    public JSONObject addChildRemarkJson(Long childOrderId, String remarkCon) throws DaifaException {
        orderManageProcess.markSubOrder(childOrderId,remarkCon);
        return JsonResponseUtil.success("备注成功");
    }

    public  List<DaifaWorkerVO> getUserList() {
        AuthorityUser user = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Long sellerId = user.getDaifaSellerId();
        DaifaWorkerExample daifaWorkerExample = new DaifaWorkerExample();
        daifaWorkerExample.createCriteria().andDaifaSellerIdEqualTo(sellerId);
        List<DaifaWorker> workers = daifaWorkerMapper.selectFieldsByExample(daifaWorkerExample
                , FieldUtil.codeFields("daifa_worker_id,daifa_worker"));

        List<DaifaWorkerVO> workerVOS = new ArrayList<>();
        workers.forEach(worker->{
            DaifaWorkerVO vo = new DaifaWorkerVO();
            vo.setId(worker.getDaifaWorkerId());
            vo.setName(worker.getDaifaWorker());
            workerVOS.add(vo);
        });

        return workerVOS;
    }

    public JSONObject setTimeJson(Long childOrderId, String timeStr) throws DaifaException {
        if(!StringUtils.hasText(timeStr)){
            return JsonResponseUtil.error("时间不能空");
        }
        orderManageProcess.haveGoodsTime(childOrderId,DateUtil.stringToDate(timeStr,DateUtil.patternD));
        return JsonResponseUtil.success("设置成功");
    }

    public JSONObject setTallyJson(Long userId,Long childOrderId) throws DaifaException {
        orderManageProcess.markDown(childOrderId);
        return JsonResponseUtil.success("标记下架成功");
    }

    public void timeOutExcute() {
        String s = DateUtil.dateToString(new Date(), DateUtil.patternB);
        if(LAST_OUT_TIME ==null|| !s.equals(LAST_OUT_TIME)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    orderManageProcess.orderTimeout();
                    LAST_OUT_TIME = s;
                }
            }).start();
        }


    }
}
