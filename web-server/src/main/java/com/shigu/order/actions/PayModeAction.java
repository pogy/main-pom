package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.order.enums.PayType;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.order.services.MorePayModeService;
import com.shigu.order.services.PayModeService;
import com.shigu.order.vo.PayModePageVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 收银台页面
 * Created by whx on 2017/7/17 0017.
 * @author bugzy
 */
@Controller
@RequestMapping("order/")
public class PayModeAction {

    @Autowired
    private PayModeService payModeService;
    @Autowired
    private MorePayModeService morePayModeService;
    @Autowired
    RedisIO redisIO;

    /**
     * 选择支付方式，默认支付宝
     * @param orderId
     * @param session
     * @param model
     * @return
     * @throws PayApplyException
     */
    @RequestMapping("payMode")
    public String payMode(Long orderId,String orderCode, HttpSession session, Model model) throws PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        PayModePageVO payModePageVO;
        if(orderId!=null){
            payModePageVO = payModeService.selPayModePageVO(orderId, userId);
            model.addAttribute("orderId", orderId);
            model.addAttribute("type",1);
        }else{
            if(StringUtils.isEmpty(orderCode)){
                throw new PayApplyException("缺少参数");
            }
            if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
                throw new PayApplyException("没有访问的权限");
            }
            List<Long> orderIds= redisIO.getList(orderCode,Long.class);
            model.addAttribute("orderCode", orderCode);
            model.addAttribute("orderNum",orderIds.size());
            model.addAttribute("type",2);
            payModePageVO=morePayModeService.selPayModePageVO(orderIds,userId);
        }
        model.addAttribute("amountPay", payModePageVO.getAmountPay());
        model.addAttribute("currentAmount", payModePageVO.getCurrentAmount());
        model.addAttribute("notSetPassword", payModePageVO.getNotSetPassword());
        model.addAttribute("tempCode", payModePageVO.getTempCode());
        model.addAttribute("alipayUrl", payModePageVO.getAlipayUrl());
        return "/order/payMode";
    }

    /**
     * 微信支付
     * @param orderId
     * @return
     * @throws JsonErrException
     * @throws PayApplyException
     */
    @RequestMapping("payInfoJson")
    @ResponseBody
    public JSONObject payInfoJson(Long orderId,String orderCode, HttpSession session) throws JsonErrException, PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        if(orderId!=null){
            return JsonResponseUtil.success()
                    // 使用百度云盘二维码生成api
                    .element("qrcodeImg","http://pan.baidu.com/share/qrcode?w=300&h=300&url=" + payModeService.payApply(orderId,userId, PayType.WX).getPayLink());
        }else{
            if(StringUtils.isEmpty(orderCode)){
                throw new PayApplyException("缺少参数");
            }
            if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
                throw new PayApplyException("没有访问的权限");
            }
            List<Long> orderIds= redisIO.getList(orderCode,Long.class);
            return JsonResponseUtil.success()
                    // 使用百度云盘二维码生成api
                    .element("qrcodeImg","http://pan.baidu.com/share/qrcode?w=300&h=300&url=" + morePayModeService.payApply(orderIds,userId, PayType.WX).getPayLink());
        }
    }

    /**
     * 星座宝支付
     * @param orderId
     * @param pwd
     * @param session
     * @return
     * @throws JsonErrException
     * @throws PayApplyException
     */
    @RequestMapping("xzpayJson")
    @ResponseBody
    public JSONObject xzpayJson(Long orderId,String orderCode, String pwd, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        payModeService.checkPwd(pwd, ps.getUserId());
        PayApplyVO v;
        if(orderId!=null){
            try {
                v = payModeService.payApply(orderId,ps.getUserId(), PayType.XZ);
            } catch (PayApplyException e) {
                throw new  JsonErrException(e.getMessage());
            }
        }else{
            if(StringUtils.isEmpty(orderCode)){
                return JsonResponseUtil.error("缺少参数");
            }
            if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
                return JsonResponseUtil.error("没有访问的权限");
            }
            List<Long> orderIds= redisIO.getList(orderCode,Long.class);
            try {
                v=morePayModeService.payApply(orderIds,ps.getUserId(),PayType.XZ);
            } catch (PayApplyException e) {
                throw new  JsonErrException(e.getMessage());
            }
        }
        payModeService.payxz(v, ps.getUserId());
        return JsonResponseUtil.success();
    }

    @RequestMapping("alipay")
    public void alipay(Long id,String orderCode, HttpServletResponse response, HttpSession session) throws PayApplyException, IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        PayApplyVO v;
        if(id!=null){
            v=payModeService.payApply(id,userId,PayType.ALI);
        }else{
            if(StringUtils.isEmpty(orderCode)){
                throw new PayApplyException("缺少参数");
            }
            if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
                throw new PayApplyException("没有访问的权限");
            }
            List<Long> orderIds= redisIO.getList(orderCode,Long.class);
            v=morePayModeService.payApply(orderIds,userId,PayType.ALI);
        }
        writer.println(v.getPayLink());
        writer.flush();
        writer.close();
    }

    @RequestMapping("qzAlipay")
    public void qzAlipay(Long id,String orderCode, HttpServletResponse response, HttpSession session) throws PayApplyException, IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        PayApplyVO v;
        if(id!=null){
            v=payModeService.payApply(id,userId,PayType.QZ_ALI);
        }else{
            if(StringUtils.isEmpty(orderCode)){
                throw new PayApplyException("缺少参数");
            }
            if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
                throw new PayApplyException("没有访问的权限");
            }
            List<Long> orderIds= redisIO.getList(orderCode,Long.class);
            v=morePayModeService.payApply(orderIds,userId,PayType.QZ_ALI);
        }
        writer.println(v.getPayLink());
        writer.flush();
        writer.close();
    }



    @RequestMapping("alipayByApplyId")
    public void alipayByApplyId(Long applyId, HttpServletResponse response) throws PayApplyException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(payModeService.payApplyByApplyId(applyId).getPayLink());
        writer.flush();
        writer.close();
    }

    /**
     * 支付轮询
     * @return
     */
    @RequestMapping("payPollingJson")
    @ResponseBody
    public JSONObject payPollingJson(Long orderId,String orderCode) throws PayApplyException {
        if(orderId==null){
            if(StringUtils.isEmpty(orderCode)){
                throw new PayApplyException("缺少参数");
            }
            List<Long> orderIds= redisIO.getList(orderCode,Long.class);
            orderId=orderIds.get(0);
        }
        Long payId;
        if ((payId = payModeService.checkPayed(orderId)) != null) {
            return JsonResponseUtil.success().element("payId", payId);
        }
        return null;
    }

    @RequestMapping("paySuccess")
    public String paySuccess(Long orderId,String orderCode, Model model) throws Main4Exception {
        String totalMoney;
        if(orderId!=null){
            totalMoney=String.format("%.2f", payModeService.orderInfo(orderId).getTotalFee() * .01);
            model.addAttribute("orderId", orderId);
        }else{
            if(StringUtils.isEmpty(orderCode)){
                throw new PayApplyException("缺少参数");
            }
            List<Long> orderIds= redisIO.getList(orderCode,Long.class);
            orderId=orderIds.get(0);
            totalMoney=morePayModeService.selTotalMoney(orderIds);
            model.addAttribute("orderNum",orderIds.size());
        }
        model.addAttribute("amountPay", totalMoney);
        model.addAttribute("payType", payModeService.selPayType(orderId));
        return "order/paySuccess";
    }

    /**
     * 获取批量支付的code
     * @param leftOrderIds
     * @return
     */
    @RequestMapping("upBatchPayDataToServer")
    @ResponseBody
    public JSONObject upBatchPayDataToServer(String leftOrderIds,HttpSession session) throws PayApplyException {
        if(StringUtils.isEmpty(leftOrderIds)){
            throw new PayApplyException("缺少参数");
        }
        List<Long> oids= Arrays.stream(leftOrderIds.split(",")).filter(StringUtils::isNotEmpty).map(Long::parseLong).collect(Collectors.toList());
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new PayApplyException("没有访问的权限");
        }
        Long userId = ps.getUserId();
        oids=payModeService.checkedMyOrder(oids,userId);
        List<Long> payedOids=oids.stream().map(oid->{
            if(payModeService.checkPayed(oid)!=null){
                return oid;
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        if(payedOids.size()>0){
            return JsonResponseUtil.error("存在已支付的订单");
        }
        String uuid=redisIO.get("moreToPayCode"+session.getId());
        if(StringUtils.isEmpty(uuid)){
            uuid= UUIDGenerator.getUUID();
            Jedis jedis = redisIO.getJedis();
            try {
                jedis.setex("moreToPayCode" + session.getId(), 3600, uuid);
            }finally {
                redisIO.returnJedis(jedis);
            }
        }
        redisIO.putTemp(uuid, oids, 3600);
        return JsonResponseUtil.success().element("redectUrl", "/order/payMode.htm?orderCode="+uuid);
    }
}
