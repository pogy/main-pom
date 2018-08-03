package com.shigu.order.services;

import com.opentae.data.mall.beans.InviteOrderRebateRecord;
import com.opentae.data.mall.examples.InviteOrderRebateRecordExample;
import com.opentae.data.mall.interfaces.InviteOrderRebateRecordMapper;
import com.shigu.main4.order.services.ItemOrderService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名：InviteRebateService
 * 类路径： com.shigu.order.services.InviteRebateService
 * 创建者： whx
 * 创建时间： 7/23/18 3:57 PM
 * 项目： main-pom
 * 描述： 邀请注册返点信息
 */
@Service
public class InviteRebateService {

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private InviteOrderRebateRecordMapper inviteOrderRebateRecordMapper;


    public JSONObject inviteRebateInfo(Long oid) {
        JSONObject data = new JSONObject();
        data.element("result", false);
        if (oid != null) {
            InviteOrderRebateRecord record = new InviteOrderRebateRecord();
            record.setOrderId(oid);
            record = inviteOrderRebateRecordMapper.selectOne(record);
            if (record != null) {
                data.element("inviteUserId", record.getInviteUserId());
                data.element("orderId", record.getOrderId());
                data.element("rebateAmount", record.getRebateAmount());
                data.element("result",record.getRebateState()!=null && record.getRebateState().equals(1));
            }
        }
        return data;
    }

    public void inviteRebateSuccessNotify(String data) {
        JSONObject dataJson = JSONObject.fromObject(data);
        if ("success".equals(dataJson.get("result"))) {
            Long orderId = dataJson.getLong("orderId");
            if (orderId != null) {
                itemOrderService.inviteRebateSuccessNotify(orderId);
            }
        }
    }
}
