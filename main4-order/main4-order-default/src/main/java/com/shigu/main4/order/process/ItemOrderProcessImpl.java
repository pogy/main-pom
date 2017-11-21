package com.shigu.main4.order.process;

import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.beans.TaobaoSessionMap;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.examples.TaobaoSessionMapExample;
import com.opentae.data.mall.interfaces.ExpressCompanyMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.opentae.data.mall.interfaces.TaobaoSessionMapMapper;
import com.opentae.tbauth.configs.KeyConfig;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.exceptions.TbSendException;
import com.shigu.main4.order.model.ItemOrder;
import com.shigu.main4.order.model.SoidsModel;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.LogisticsVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.LogisticsOfflineSendRequest;
import com.taobao.api.response.LogisticsOfflineSendResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("itemOrderProcess")
public class ItemOrderProcessImpl implements ItemOrderProcess{

    @Autowired
    private SoidsModel soidsModel;
    @Autowired
    private ExpressCompanyMapper expressCompanyMapper;
    @Autowired
    private MemberUserSubMapper memberUserSubMapper;
    @Autowired
    private TaobaoSessionMapMapper taobaoSessionMapMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;

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
    public void updateInStok(Long soidpid) {
        soidsModel.updateInStok(soidpid);
    }

    @Override
    public void tbSend(Long oid) throws TbSendException {
        ItemOrder orderModel= SpringBeanFactory.getBean(ItemOrder.class,oid);
        ItemOrderVO order=orderModel.orderInfo();
        LogisticsVO logistics=orderModel.selLogisticses().get(0);
        if(order.getOrderId()==null){
            //不是淘宝订单
            throw new TbSendException(TbSendException.TbSendExceptionEnum.NOT_IS_TB_ORDER.toString());
        }
        if(StringUtils.isEmpty(logistics.getCourierNumber())){
            //订单未发货
            throw new TbSendException(TbSendException.TbSendExceptionEnum.WAIT_SENT.toString());
        }
        Long userId=order.getUserId();
        String session=myTbSessionKey(userId);

        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", KeyConfig.appKey, KeyConfig.secret);
        LogisticsOfflineSendRequest req = new LogisticsOfflineSendRequest();
        req.setTid(new Long(order.getOuterId()));
        req.setIsSplit(0L);//这边没有拆单的
        req.setOutSid(logistics.getCourierNumber());
        req.setCompanyCode(expressCompanyMapper.selectByPrimaryKey(logistics.getCompanyId()).getRemark2());
        LogisticsOfflineSendResponse rsp;
        try {
            rsp = client.execute(req,session);
        } catch (ApiException e) {
            throw new TbSendException(TbSendException.TbSendExceptionEnum.IO_ERROR.toString());
        }
        if(!StringUtils.isEmpty(rsp.getErrorCode())){
            List<String> hasSendException=Arrays.asList("isv.logistics-offline-service-error:B27",
                    "isv.logistics-offline-service-error:B55",
                    "isv.logistics-offline-service-error:AT0112");
            if(rsp.getSubCode().equals("isv.logistics-offline-service-error:P03")){
                throw new TbSendException(TbSendException.TbSendExceptionEnum.SESSION_EXPORE.toString());
            }else if(!hasSendException.contains(rsp.getSubCode())){
                throw new TbSendException(rsp.getSubMsg());
            }
        }
        updateTbSend(oid);
    }


    private void updateTbSend(Long oid){
        com.opentae.data.mall.beans.ItemOrder o=new com.opentae.data.mall.beans.ItemOrder();
        o.setOid(oid);
        o.setTbSend(true);
        itemOrderMapper.updateByPrimaryKeySelective(o);
    }

    private String myTbSessionKey(Long userId){
        MemberUserSubExample example=new MemberUserSubExample();
        example.createCriteria().andUserIdEqualTo(userId).andAccountTypeEqualTo(3);
        List<MemberUserSub> session = memberUserSubMapper.selectByExample(example);
        TaobaoSessionMapExample taobaoSessionMapExample=new TaobaoSessionMapExample();
        taobaoSessionMapExample.createCriteria().andUserIdEqualTo(Long.parseLong(session.get(0).getSubUserKey())).andAppkeyEqualTo(KeyConfig.appKey);
        List<TaobaoSessionMap> taobaoSessionMaps = taobaoSessionMapMapper.selectByExample(taobaoSessionMapExample);
        return taobaoSessionMaps.get(0).getSession();
    }
}
