package com.shigu.order.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemOrderExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.exceptions.PayerException;
import com.shigu.main4.order.model.PayerService;
import com.shigu.main4.order.process.PayProcess;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.vo.ItemOrderVO;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.order.vo.PayModePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 收款台-支付方式选择
 *
 * Created by whx on 2017/7/17 0017.
 * @author bugzy
 */
@Service
public class PayModeService {

    @Autowired
    private PaySdkClientService paySdkClientService;

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Autowired
    private OrderPayMapper orderPayMapper;

    @Autowired
    private OrderPayRelationshipMapper orderPayRelationshipMapper;

    @Autowired
    private ItemOrderService itemOrderService;

    @Autowired
    private PayProcess payProcess;

    @Autowired
    private OrderPayApplyMapper orderPayApplyMapper;
    @Autowired
    private ItemOrderMapper itemOrderMapper;

    /**
     * 订单信息
     * @param orderId
     * @return
     */
    public ItemOrderVO orderInfo(Long orderId){
        return itemOrderService.orderInfo(orderId);
    }
    /**
     * 获取支付方式页面数据
     * @param orderId
     * @param userId
     * @return 返回给PayMode页面的信息
     * @throws PayApplyException 支付异常
     */
    public PayModePageVO selPayModePageVO(Long orderId, Long userId) throws PayApplyException {
        checkedMyOrder(Collections.singletonList(orderId),userId);
        Long payed = checkPayed(orderId);
        if (payed != null) {
            throw new PayApplyException("该笔订单已经支付");
        }
        PayModePageVO payModePageVO = new PayModePageVO();
        payModePageVO.setOrderId(orderId);
        ItemOrderVO itemOrderVO = orderInfo(orderId);
        if(!Objects.equals(userId, itemOrderVO.getUserId())){
            throw new PayApplyException("只能支付自己的订单");
        }
        payModePageVO.setWebSite(itemOrderVO.getWebSite());
        payModePageVO.setTempCode(paySdkClientService.tempcode(userId));
        payModePageVO.setAmountPay(String.format("%.2f", itemOrderVO.getTotalFee() * .01));
        if("qz".equals(itemOrderVO.getWebSite())){
            payModePageVO.setAlipayUrl("/order/qzAlipay.htm");
        }else{
            payModePageVO.setAlipayUrl("/order/alipay.htm");
        }
        payModePageVO.setCurrentAmount(String.format("%.2f", memberUserMapper.userBalance(userId) * .01));
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        payModePageVO.setNotSetPassword(memberUser.getPayPassword() == null ? "没有支付密码" : null);
        return payModePageVO;
    }

    /**
     * 支付请求
     * @param orderId 主单id
     * @param payType 支付类型
     * @return 支付链接，星座宝没有支付链接
     * @throws PayApplyException 支付申请异常
     */
    @Transactional(rollbackFor = Exception.class)
    public PayApplyVO payApply(Long orderId,Long userId,PayType payType) throws PayApplyException {
        checkedMyOrder(Collections.singletonList(orderId),userId);
        return payProcess.payApply(orderId,payType);
    }

    public PayApplyVO payApplyByApplyId(Long applyId) throws PayApplyException {
        OrderPayApply apply=orderPayApplyMapper.selectByPrimaryKey(applyId);
        return BeanMapper.map(apply,PayApplyVO.class);
    }


    /**\
     * 验证密码，错误则抛出异常
     * @param pwd 密码
     * @param userId 用户
     * @throws JsonErrException
     */
    public void checkPwd(String pwd, Long userId) throws JsonErrException {
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        if (memberUser.getPayPassword() == null) {
            throw new JsonErrException("请设置支付密码");
        } else if (!memberUser.getPayPassword().equals(EncryptUtil.encrypt(pwd))){
            throw new JsonErrException("密码错误");
        }
    }

    /**
     * 检查支付状态
     * @param orderId 订单id
     * @return
     */
    public Long checkPayed(Long orderId) {
        if (orderId == null) {
            return null;
        }
        OrderPayRelationship orderPayRelationship = new OrderPayRelationship();
        orderPayRelationship.setOid(orderId);
        List<OrderPayRelationship> relationships = orderPayRelationshipMapper.select(orderPayRelationship);
        if (!relationships.isEmpty()) {
            return relationships.get(0).getPayId();
        }
        return null;
    }

    /**
     * 查询支付记录
     * @param orderId 支付id
     * @return
     */
    public String selPayType(Long orderId) throws Main4Exception {
        Long payed = checkPayed(orderId);
        if (payed == null) {
            throw new Main4Exception("请前往订单列表查看结果");
        }
        OrderPay orderPay = orderPayMapper.selectByPrimaryKey(payed);
        switch (orderPay.getType()) {
            case 1:
                return "微信";
            case 2:
                return "支付宝";
            case 3:
                return "星座宝";
            default:
                throw new Main4Exception("支付成功，请前往订单列表查看结果");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void payxz(PayApplyVO payApplyVO, Long userId) throws JsonErrException {
        String outerId = PayerService.OUTER_ID_PRE + payApplyVO.getApplyId();
        paySdkClientService.xzpay(userId, payApplyVO.getMoney(), outerId);
        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(userId);
        try {
            SpringBeanFactory.getBean("xzPayerService", PayerService.class)
                    .paySure(
                            payApplyVO.getApplyId(),
                            outerId,
                            memberUser.getUserName(),
                            payApplyVO.getMoney());
        } catch (PayerException e) {
            throw new JsonErrException("扣款异常");
        }
    }


    public List<Long> checkedMyOrder(List<Long> orderIds,Long userId) throws PayApplyException {
        if(orderIds.size()==0){
            throw new PayApplyException("操作过期");
        }
        ItemOrderExample itemOrderExample=new ItemOrderExample();
        itemOrderExample.createCriteria().andOidIn(orderIds);
        List<ItemOrder> ios=itemOrderMapper.selectFieldsByExample(itemOrderExample, FieldUtil.codeFields("oid,user_id,sender_id"));
        Set<Long> sids=new HashSet<>();
        for(ItemOrder io:ios){
            if(!Objects.equals(io.getUserId(), userId)){
                throw new PayApplyException("只能支付自己的订单");
            }
            sids.add(io.getSenderId());
            if(sids.size()>1){
                throw new PayApplyException("单次只能支付同一分站的订单");
            }
        }
        return ios.stream().map(ItemOrder::getOid).collect(Collectors.toList());
    }
}
