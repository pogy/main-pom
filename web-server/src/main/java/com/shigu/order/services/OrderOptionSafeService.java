package com.shigu.order.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.examples.BuyerAddressExample;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.interfaces.BuyerAddressMapper;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单类服务安全验证
 */
@Service
public class OrderOptionSafeService {
    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    @Autowired
    private BuyerAddressMapper buyerAddressMapper;
    /**
     * 按主订单验证操作安全性
     * @return
     */
    public boolean checkByOid(Long userId,Long oid){
        ItemOrderExample example=new ItemOrderExample();
        example.createCriteria().andOidEqualTo(oid).andUserIdEqualTo(userId);
        return itemOrderMapper.countByExample(example)>0;
    }

    /**
     * 按子订单验证操作安全性
     * @return
     */
    public boolean checkBySoid(Long userId,Long soid){
        ItemOrderSub sub=itemOrderSubMapper.selectFieldsByPrimaryKey(soid, FieldUtil.codeFields("oid,soid"));
        return (sub != null)&&checkByOid(userId,sub.getOid());
    }

    /**
     * 按退单ID验证操作安全性
     * @return
     */
    public boolean checkByRefundId(Long userId,Long refundId){
        ItemOrderRefund refund=itemOrderRefundMapper.selectFieldsByPrimaryKey(refundId,FieldUtil.codeFields("refund_id,oid"));
        return (refund != null)&&checkByOid(userId,refund.getOid());
    }

    /**
     * 按地址验证
     * @param userId
     * @param addressId
     * @return
     */
    public boolean checkByAddressId(Long userId,Long addressId){
        BuyerAddressExample example=new BuyerAddressExample();
        example.createCriteria().andUserIdEqualTo(userId).andAddressIdEqualTo(addressId);
        return buyerAddressMapper.countByExample(example)>0;
    }
}
