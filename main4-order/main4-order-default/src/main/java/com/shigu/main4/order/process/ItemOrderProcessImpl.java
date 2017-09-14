package com.shigu.main4.order.process;

import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.SoidsModel;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.taobao.api.request.LogisticsOfflineSendRequest;
import com.taobao.api.response.LogisticsOfflineSendResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("itemOrderProcess")
public class ItemOrderProcessImpl implements ItemOrderProcess{

    @Autowired
    private SoidsModel soidsModel;

    @Override
    public void finish(Long oid) {
        ItemOrder order= SpringBeanFactory.getBean(ItemOrder.class,oid);
        order.finished();
    }

    @Override
    public void outOfStock(Long soidpid) {
        soidsModel.outOfStock(soidpid);
    }

    @Override
    public void cancleOutOfStock(Long soidpid) {
        soidsModel.cancleOutOfStock(soidpid);
    }

    @Override
    public void tbSend(Long oid
//            String nick, Long tid, String companyCode,String expressCode
        ) {
        ItemOrder orderModel= SpringBeanFactory.getBean(ItemOrder.class,oid);
        ItemOrderVO order=orderModel.orderInfo();
        LogisticsVO logistics=orderModel.selLogisticses().get(0);
        if(order.getOrderId()==null){
            //不是淘宝订单
        }
        if(StringUtils.isEmpty(logistics.getCourierNumber())){
            //订单未发货
        }



//        LogisticsOfflineSendRequest req = new LogisticsOfflineSendRequest();
//        req.setTid(tid);
//        req.setIsSplit(0L);//这边没有拆单的
//        req.setOutSid(expressCode);
//        req.setCompanyCode(companyCode);
//        LogisticsOfflineSendResponse rsp = getClient().execute(req,session);
//        System.out.println(rsp.getBody());
//        try {
//            boolean b=rsp.getShipping().getIsSuccess();
//            return b;
//        } catch (Exception e) {
//            return false;
//        }
    }
}
