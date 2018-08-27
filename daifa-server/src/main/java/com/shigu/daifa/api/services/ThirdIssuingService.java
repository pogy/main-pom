package com.shigu.daifa.api.services;

import com.openJar.beans.WorkUserGgoodsTasksScan;
import com.openJar.exception.SystemInterfaceException;
import com.openJar.responses.thirdSupport.SelScanGgoodsResponse;
import com.openJar.responses.thirdSupport.SelTagHaveGgoodsResponse;
import com.openJar.responses.thirdSupport.SelWorkUserGgoodsTasksResponse;
import com.openJar.responses.thirdSupport.ThirdLoinResponse;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.beans.DaifaWorker;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.*;
import com.shigu.daifa.api.beans.NotCodeSets;
import com.shigu.daifa.services.DaifaAllocatedService;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.daifa.process.PackDeliveryProcess;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.daifa.vo.UnComleteAllVO;
import com.shigu.sms.utils.SmsJsoup;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.daifa.api.services
 * @ClassName: ThirdIssuingService
 * @Author: sy
 * @CreateDate: 2018/7/19 0019 13:50
 */
@Service
public class ThirdIssuingService {

    @Autowired
    private DaifaAllocatedService daifaAllocatedService;
    @Autowired
    DaifaWorkerMapper daifaWorkerMapper;
    @Autowired
    DaifaGgoodsMapper daifaGgoodsMapper;
    @Autowired
    DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;
    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    TakeGoodsIssueProcess takeGoodsIssueProcess;
    @Autowired
    OrderManageProcess orderManageProcess;
    @Autowired
    PackDeliveryProcess packDeliveryProcess;
    @Autowired
    DaifaTradeMapper daifaTradeMapper;
    @Value("${ERROR_SEND_PHONE}")
    String errorSendPhone;

    public ThirdLoinResponse thirdLogin(String userName, String password) throws SystemInterfaceException {
        if (userName == null || userName.trim().length() == 0 || password == null || password.trim().length() == 0) {
            throw new SystemInterfaceException("缺少参数");
        }
        ThirdLoinResponse user = new ThirdLoinResponse();
        DaifaWorker worker = new DaifaWorker();
        worker.setDaifaWorker(userName);
        worker.setPassword(password);
        worker = daifaWorkerMapper.selectOne(worker);
        if (worker == null) {
            user.setSuccess(false);
            SystemInterfaceException systemInterfaceException = new SystemInterfaceException();
            systemInterfaceException.setErrMsg("用户不存在");
            user.setException(systemInterfaceException);
            return user;
//            throw new SystemInterfaceException("用户不存在");
        }
        if (worker.getUseStatus()==2)
            return new ThirdLoinResponse();
        user.setDaifaSellerId(worker.getDaifaSellerId());
        user.setWorkerId(worker.getDaifaWorkerId());
        user.setLoginName(worker.getDaifaWorker());
        user.setPhone(worker.getPhone());
        user.setUserName(worker.getUserName());
        user.setSuccess(true);
        return user;
    }

    public SelWorkUserGgoodsTasksResponse selGgoodsTasksWorkerId(Long daifaWorkerId) throws SystemInterfaceException {
        if (daifaWorkerId == null ) {
            throw new SystemInterfaceException("缺少参数");
        }
        SelWorkUserGgoodsTasksResponse response = new SelWorkUserGgoodsTasksResponse();
        response.setSuccess(true);
        response.setHaveTakeSumCount(0);
        response.setHaveTakeSumPrice("0.00");
        response.setNeedTakeSumCount(0);
        response.setNeedTakeSumPrice("0.00");
        response.setNoTakeSumCount(0);
        response.setNoTakeSumPrice("0.00");
        response.setStockoutSumCount(0);
        response.setStockoutSumPrice("0.00");
        DaifaGgoodsExample example = new DaifaGgoodsExample();
        DaifaGgoodsExample.Criteria ce = example.createCriteria().andDaifaWorkerIdEqualTo(daifaWorkerId)
                .andCreateDateEqualTo(DateUtil.dateToString(new Date(), DateUtil.patternB)).andReturnStatusEqualTo(0);
        example.setOrderByClause("create_time desc");
        //获取需拿总数和总价
        List<DaifaGgoods> gs = daifaGgoodsMapper.selectFieldsByExample(example,"take_goods_id,df_order_id,goods_num,single_pi_price,take_goods_status");
        Integer needSum = 0;
        Double needPicSum = 0.00;
        Integer haveSum = 0;
        Double havePicSum = 0.00;
        Integer noSum = 0;
        Double noPicSum = 0.00;
        Integer stockoutSum = 0;
        Double stockoutPicSum = 0.00;
        if (gs != null || gs.size() > 0){
            List<Long> jys = new ArrayList<>();
            Boolean b;
            for (DaifaGgoods g : gs) {
                b = true;
                for (int i = 0; i < jys.size(); i++) {
                    if (g.getDfOrderId().equals(jys.get(i)) ){
                        b = false;
                    }
                }
                jys.add(g.getDfOrderId());
                if (b) {
                    if (g.getTakeGoodsStatus() == 0) {
                        noSum += g.getGoodsNum();
                        noPicSum += Double.valueOf(g.getSinglePiPrice());
                    }
                    if (g.getTakeGoodsStatus() == 1) {
                        haveSum += g.getGoodsNum();
                        havePicSum += Double.valueOf(g.getSinglePiPrice());
                    }
                    if (g.getTakeGoodsStatus() == 2) {
                        stockoutSum += g.getGoodsNum();
                        stockoutPicSum += Double.valueOf(g.getSinglePiPrice());
                    }
                    needSum += g.getGoodsNum();
                    needPicSum += Double.valueOf(g.getSinglePiPrice());
                }
            }
            response.setHaveTakeSumCount(haveSum);
            response.setHaveTakeSumPrice(havePicSum.toString());
            response.setNeedTakeSumCount(needSum);
            response.setNeedTakeSumPrice(needPicSum.toString());
            response.setNoTakeSumCount(noSum);
            response.setNoTakeSumPrice(noPicSum.toString());
            response.setStockoutSumCount(stockoutSum);
            response.setStockoutSumPrice(stockoutPicSum.toString());
        }else {
            return response;
        }
        return response;
    }

    public SelScanGgoodsResponse selScanGgoodsList(Long daifaWorkerId){
        SelScanGgoodsResponse response = new SelScanGgoodsResponse();
        DaifaGgoodsExample example = new DaifaGgoodsExample();
        DaifaGgoodsExample.Criteria ce = example.createCriteria().andDaifaWorkerIdEqualTo(daifaWorkerId).andReturnStatusEqualTo(0).andTakeGoodsStatusEqualTo(0).andUseStatusEqualTo(1).andCreateDateEqualTo(DateUtil.dateToString(new Date(), DateUtil.patternB));
        List<DaifaGgoods> daifaGgoods = daifaGgoodsMapper.selectFieldsByExample(example, "take_goods_id,df_trade_id,df_order_id,store_goods_code,single_pi_price");
        List<WorkUserGgoodsTasksScan> scanList = new ArrayList<>();
        if (daifaGgoods == null || daifaGgoods.size() <= 0) {
//            WorkUserGgoodsTasksScan scan = new WorkUserGgoodsTasksScan();
//            scan.setScanBarCode("1234567894556");
//            scan.setStoreGoodsCode("A401-r506-黑色mk-P897");
//            scan.setPrice(67.00);
//            scanList.add(scan);
//            scan.setScanBarCode("12344544578894556");
//            scan.setStoreGoodsCode("A404-r897-白色2mk-P669");
//            scan.setPrice(66.00);
//            scanList.add(scan);
//            response.setScanDate(scanList);
            response.setSuccess(true);
            return response;
        }
        DaifaGgoods daifa;
        for (int i = 0; i < daifaGgoods.size(); i++) {
            WorkUserGgoodsTasksScan scan = new WorkUserGgoodsTasksScan();
            daifa = daifaGgoods.get(i);
            scan.setScanBarCode(daifa.getDfOrderId().toString()+ daifa.getDfTradeId().toString().substring(daifa.getDfTradeId().toString().length()-7));
            scan.setStoreGoodsCode(daifa.getStoreGoodsCode());
            scan.setPrice(Double.valueOf(daifa.getSinglePiPrice()));
            scanList.add(scan);
        }
        response.setScanDate(scanList);
        response.setSuccess(true);
        return response;
    }

    public void selTagHaveGgoods(Long daifaWorkerId, Integer bostatus, List<Long> orderIds,Long haveGoodsTime) throws SystemInterfaceException, DaifaException {
        if (daifaWorkerId == null || bostatus == null || orderIds == null || orderIds.size() == 0) {
            throw new SystemInterfaceException("缺少参数");
        }
        if (bostatus == 3 && haveGoodsTime == null)
            throw new SystemInterfaceException("缺少参数");
        if (bostatus == 3){
            Date haveGoodsdate = new Date(haveGoodsTime);
            for (Long oid : orderIds) {
                orderManageProcess.haveGoodsTime(oid,haveGoodsdate);
            }
        }else {
            DaifaGgoodsExample example = new DaifaGgoodsExample();
            example.createCriteria().andUseStatusEqualTo(1).andDfOrderIdIn(orderIds)
                    .andDaifaWorkerIdEqualTo(daifaWorkerId)
                    .andOperateIsEqualTo(0);
            List<DaifaGgoods> daifaGgoods = daifaGgoodsMapper.selectFieldsByExample(example, FieldUtil.codeFields("take_goods_id,df_order_id"));

            List<Long> takeIds = BeanMapper.getFieldList(daifaGgoods, "takeGoodsId", Long.class);
            UnComleteAllVO vo =takeGoodsIssueProcess.tabIsTakeGoods(daifaWorkerId,  takeIds, bostatus == 1);

            if (vo.getNotTakeIds() != null && vo.getNotTakeIds().size() > 0) {
                //发送缺货信息到order-server
                for (Long notTakeDfOrderId : vo.getNotTakeIds()) {
                    daifaAllocatedService.orderServerNotTake(notTakeDfOrderId);
                }
            }
            if(vo.getTakeIds()!=null&&vo.getTakeIds().size()>0){
                for(Long takeDfOrderId:vo.getTakeIds()){
                    daifaAllocatedService.orderServerTake(takeDfOrderId);
                }
                //获取已拿到的主单ID集合
                DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
                daifaOrderExample.createCriteria().andDfOrderIdIn(vo.getTakeIds());
                List<DaifaOrder> hasOrders=daifaOrderMapper.selectFieldsByExample(daifaOrderExample,FieldUtil.codeFields("df_order_id,df_trade_id"));
                if(hasOrders.size()>0){
                    Set<Long> dfTradeIds=BeanMapper.getFieldSet(hasOrders,"dfTradeId",Long.class);
                    List<Long> tids=new ArrayList<>(dfTradeIds);
                    DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
                    daifaTradeExample.createCriteria().andDfTradeIdIn(tids);
                    List<DaifaTrade> trades=daifaTradeMapper.selectFieldsByExample(daifaTradeExample,FieldUtil.codeFields("df_trade_id,express_id,express_name"));
                    Map<Long,List<DaifaTrade>> tradeMap=BeanMapper.groupBy(trades,"expressId",Long.class);
                    Set<String> expressNames=new HashSet<>();
                    for(List<DaifaTrade> ts:tradeMap.values()){
                        for(DaifaTrade t:ts){
                            try {
                                packDeliveryProcess.queryExpressCode(t.getDfTradeId());
                            } catch (DaifaException e) {
                                expressNames.add(t.getExpressName());
                                break;
                            }
                        }
                    }
                    if(expressNames.size()>0){
                        for(String expressName:expressNames){
                            String str=expressName+"可用单号不足,请及时联系快递补充单号.";
                            SmsJsoup u=new SmsJsoup();
                            String phones=errorSendPhone;//接收号码集合
                            Date sendTime=new Date();//定时发送时间
                            u.sendHySms(phones,str,sendTime);
                        }
                    }
                }
            }
        }
    }
}
