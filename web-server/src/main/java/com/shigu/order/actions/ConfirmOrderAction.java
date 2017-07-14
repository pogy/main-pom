package com.shigu.order.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.order.vo.CartVO;
import com.shigu.main4.order.vo.LogisticsCompanyVO;
import com.shigu.main4.order.vo.ServiceVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.exceptions.OrderException;
import com.shigu.order.vo.OrderSubmitVo;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhaohongbo on 17/6/23.
 */
@Controller
@RequestMapping
public class ConfirmOrderAction {

    @Autowired
    ItemOrderService itemOrderService;
    @Autowired
    OrderConstantService orderConstantService;

    @Autowired
    RedisIO redisIO;

    /**
     * 订单确认提交
     * @param bo
     */
    @RequestMapping("/order/confirmOrder")
    public String confirmOrders(ConfirmBO bo, HttpServletRequest request, Model model) throws JsonErrException, OrderException {
        ResponseBase rsp = new ResponseBase();
        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);

        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code, OrderSubmitVo.class);
        ///////////////////////////////////////////////////////////
        if (orderSubmitVo == null) {
            throw new OrderException("订单超时");
        }
        Long userId = null;
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (sessionUser != null) {
            userId = sessionUser.getUserId();
        }
        if (!Objects.equals(orderSubmitVo.getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }

        List<BuyerAddressVO> collList =  itemOrderService.selBuyerAddress(userId);//收藏的地址数据
        model.addAttribute("collList", collList);

        LogisticsCompanyVO logisticsDefault = orderConstantService.selLogisticsDefault(bo.getSenderId());//快递规则
        model.addAttribute("postRulers", JSON.toJSONString(logisticsDefault));

        List<ServiceVO> serviceRulers = orderConstantService.selServices(bo.getSenderId());//服务费规则
        model.addAttribute("serviceRulers", JSON.toJSONString(serviceRulers));

        LogisticsCompanyVO postInfo = orderConstantService.selLogisticsDefault(bo.getSenderId());//快递公司数据
        model.addAttribute("postInfo", JSON.toJSONString(postInfo));

        List<CartVO> cartVOList =  orderSubmitVo.getProducts();// 清单数据
        model.addAttribute("list", cartVOList);

        model.addAttribute("webSite", "hz");//站点

        return "trade/confirmOrder";
        ////////////////////////////////////////////////////////
//        Long oid = confirmOrderService.submit(bo);
//        String payUrl = "/order/payMode.htm?oid="+oid;
//
//        return "redirect:" + payUrl;
    }
}
