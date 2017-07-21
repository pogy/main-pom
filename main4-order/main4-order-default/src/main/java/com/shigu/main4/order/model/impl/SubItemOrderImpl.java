package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.ItemOrderRefund;
import com.opentae.data.mall.beans.ItemOrderSub;
import com.opentae.data.mall.beans.ShiguGoodsSoldout;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.interfaces.ItemOrderRefundMapper;
import com.opentae.data.mall.interfaces.ItemOrderSubMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsSoldoutMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.bo.RefundApplyBO;
import com.shigu.main4.order.enums.SubOrderStatus;
import com.shigu.main4.order.model.RefundItemOrder;
import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ItemSkuVO;
import com.shigu.main4.order.vo.RefundVO;
import com.shigu.main4.order.vo.SubItemOrderVO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by zhaohongbo on 17/7/19.
 */
@Service
@Scope("prototype")
public class SubItemOrderImpl implements SubItemOrder{

    private Long subOrderId;

    @Autowired
    private ItemOrderSubMapper itemOrderSubMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private ItemOrderRefundMapper itemOrderRefundMapper;

    public SubItemOrderImpl(Long subOrderId) {
        this.subOrderId = subOrderId;
    }

    /**
     * 标记为已发
     */
    @Override
    public void sended() {

    }

    /**
     * 关闭子订单
     * 没支付前,使用关闭
     */
    @Override
    public void closed() {

    }

    /**
     * 退款
     * @param money
     */
    @Override
    public Long refund(Long money) {
        return null;
    }

    /**
     * 添加备注
     * @param msg
     */
    @Override
    public void addMark(String msg) {

    }

    /**
     * 退款申请
     * @param number 退件数
     * @param money
     */
    @Override
    public Long refundApply(Integer type, Integer number, Long money, String reason) {
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subOrderId);
        RefundApplyBO refundApply = new RefundApplyBO();
        refundApply.setSoid(itemOrderSub.getSoid());

        refundApply.setOid(itemOrderSub.getOid());
        refundApply.setHopeMoney(money);
        refundApply.setNumber(number);
        refundApply.setReason(reason);
        refundApply.setType(type);

        RefundItemOrder refundItemOrder = SpringBeanFactory.getBean(RefundItemOrder.class, refundApply, true);
        Long refundId = refundItemOrder.getRefundId();
        return refundId;
    }

    /**
     * 退单信息
     *
     * @return
     */
    @Override
    public RefundVO refundInfos() {
        ItemOrderRefund query = new ItemOrderRefund();
        query.setSoid(subOrderId);
        ItemOrderRefund itemOrderRefund = itemOrderRefundMapper.selectOne(query);
        RefundItemOrder refund = SpringBeanFactory.getBean(RefundItemOrder.class, itemOrderRefund.getRefundId());
        return refund.refundinfo();
    }

    /**
     * 获取子单信息
     * @return
     */
    @Override
    public SubItemOrderVO subOrderInfo() {
        ItemOrderSub itemOrderSub = itemOrderSubMapper.selectByPrimaryKey(subOrderId);
        SubItemOrderVO subItemOrderVO = BeanMapper.map(itemOrderSub, SubItemOrderVO.class);
        subItemOrderVO.setNumber(itemOrderSub.getDistributionNum());
        subItemOrderVO.setSubOrderStatus(SubOrderStatus.statusOf(itemOrderSub.getStatus()));
        ItemProductVO itemProductVO = BeanMapper.map(itemOrderSub, ItemProductVO.class);
        ItemSkuVO itemSkuVO = BeanMapper.map(itemOrderSub,ItemSkuVO.class);
        itemProductVO.setSelectiveSku(itemSkuVO);
        subItemOrderVO.setProduct(itemProductVO);
        return filledSubItemOrderVO(subItemOrderVO);
    }

    /**
     * 填充子单信息中goodsNo,marketId,marketName,shopId,shopName
     * @param subItemOrderVO
     * @return
     */
    private SubItemOrderVO filledSubItemOrderVO(SubItemOrderVO subItemOrderVO) {
        subItemOrderVO.setGoodsNo("");
        ItemProductVO product = subItemOrderVO.getProduct();
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setWebSite(subItemOrderVO.getProduct().getWebSite());
        shiguGoodsTiny.setGoodsId(subItemOrderVO.getProduct().getGoodsId());
        ShiguGoodsTiny result = shiguGoodsTinyMapper.selectOne(shiguGoodsTiny);
        if (result != null) {
            subItemOrderVO.setGoodsNo(result.getGoodsNo());
            product.setMarketId(result.getMarketId());
            product.setMarketName(result.getParentMarketName());
            product.setShopId(result.getStoreId());
            product.setShopNum(result.getStoreNum());
            return subItemOrderVO;
        }
        ShiguGoodsSoldout shiguGoodsSoldout = BeanMapper.map(shiguGoodsTiny,ShiguGoodsSoldout.class);
        ShiguGoodsSoldout soldoutResult = shiguGoodsSoldoutMapper.selectOne(shiguGoodsSoldout);
        if (soldoutResult != null) {
            subItemOrderVO.setGoodsNo(soldoutResult.getGoodsNo());
            product.setMarketId(soldoutResult.getMarketId());
            product.setMarketName(soldoutResult.getMarket());
            product.setShopId(soldoutResult.getStoreId());
            product.setShopNum(soldoutResult.getStoreNum());
        }
        return subItemOrderVO;
    }

    public Long getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }
}
