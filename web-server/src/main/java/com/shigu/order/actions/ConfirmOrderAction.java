package com.shigu.order.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.vo.BuyerAddressItemVO;
import com.shigu.main4.order.vo.BuyerAddressVO;
import com.shigu.main4.order.vo.OtherCostVO;
import com.shigu.main4.order.vo.PostVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.order.bo.ConfirmBO;
import com.shigu.order.bo.ConfirmMoreTbBO;
import com.shigu.order.exceptions.OrderException;
import com.shigu.order.services.CartService;
import com.shigu.order.services.ConfirmOrderService;
import com.shigu.order.services.OrderOptionSafeService;
import com.shigu.order.vo.CartOrderVO;
import com.shigu.order.vo.OrderSubmitVo;
import com.shigu.order.vo.SenderInfoVO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by zhaohongbo on 17/6/23.
 */
@Controller
@RequestMapping("order/")
public class ConfirmOrderAction {

    @Autowired
    private ConfirmOrderService confirmOrderService;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private CartService cartService;

    @Autowired
    ItemOrderService itemOrderService;

    @Autowired
    private OrderOptionSafeService orderOptionSafeService;
    @Autowired
    LogisticsService logisticsService;
    /**
     * 订单确认提交
     * @param request
     */
    @RequestMapping("confirmOrders")
    @ResponseBody
    public JSONObject confirmOrders(HttpServletRequest request, HttpSession session) throws JsonErrException {
        StringBuilder boStr = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();
            String s;
            while ((s = reader.readLine()) != null) {
                boStr.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long oid = null;
        try {
            oid = confirmOrderService.confirmOrders(JSON.parseObject(boStr.toString(), ConfirmBO.class),ps.getUserId());
        } catch (JsonErrException e) {
            e.printStackTrace();
        }
        String payUrl = "/order/payMode.htm?orderId=" + oid;
        return JsonResponseUtil.success().element("redectUrl", payUrl);
    }

    @RequestMapping("confirmOrder")
    public String confirmOrder(ConfirmBO bo, HttpServletRequest request, Model model) throws OrderException {
        String code = bo.getCode();
        OrderSubmitVo orderSubmitVo = redisIO.get(code, OrderSubmitVo.class);
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
        List<SenderInfoVO> senderInfoVOList = confirmOrderService.senderListDefault(bo.getSenderId());
        model.addAttribute("sender", senderInfoVOList);
        if (bo.getSenderId() == null) {
            SenderInfoVO senderInfoVO = senderInfoVOList.get(0);
            bo.setSenderId(Long.valueOf(senderInfoVO.getId()));
            senderInfoVO.setChecked(true);
        }

        model.addAttribute("collList", confirmOrderService.collListByUser(userId));//收藏的地址数据

        // 商品信息
        List<CartOrderVO> vos = cartService.packCartProductVo(orderSubmitVo.getProducts()).getOrders();
        // 商品服务信息
        model.addAttribute("serviceRulers", JSON.toJSONString(confirmOrderService.serviceRulePack(vos, bo.getSenderId())));
        model.addAttribute("goodsOrders", vos);
        model.addAttribute("webSite", "hz");//站点
        model.addAttribute("code", bo.getCode());
        model.addAttribute("tbOrderAddressInfo",orderSubmitVo.getTbOrderAddressInfo());
        return "trade/confirmOrder";
    }

    @ResponseBody
    @RequestMapping("deleteCollJson")
    public JSONObject deleteCollJson(Long id, HttpSession session) {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkByAddressId(ps.getUserId(),id)){
            return JsonResponseUtil.error("只能操作本用户下的地址");
        }
        itemOrderService.rmBuyerAddress(id);
        return JsonResponseUtil.success();
    }

    @ResponseBody
    @RequestMapping("collectCgneeJson")
    public JSONObject collectCgneeJson(BuyerAddressItemVO buyerAddressItem, HttpServletRequest request) throws JsonErrException {
        if(StringUtils.isEmpty(buyerAddressItem.getName())||StringUtils.isEmpty(buyerAddressItem.getAddress())
                ||StringUtils.isEmpty(buyerAddressItem.getPhone())){
            throw new JsonErrException("地址缺少必要信息");
        }
        Long userId = null;
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (sessionUser != null) {
            userId = sessionUser.getUserId();
        }
        if (!orderOptionSafeService.checkCitySafe(buyerAddressItem.getProvId(),buyerAddressItem.getCityId())) {
            throw new JsonErrException("省市无法对应");
        }
        BuyerAddressVO buyerAddress = new BuyerAddressVO();
        buyerAddress.setAddress(buyerAddressItem.getAddress());
        buyerAddress.setCityId(buyerAddressItem.getCityId());
        buyerAddress.setName(buyerAddressItem.getName());
        buyerAddress.setProvId(buyerAddressItem.getProvId());
        buyerAddress.setTelephone(buyerAddressItem.getPhone());
        buyerAddress.setTownId(buyerAddressItem.getCountyId());
        buyerAddress.setUserId(userId);

        buyerAddress.setProvince(confirmOrderService.selProvById(buyerAddress.getProvId()));
        buyerAddress.setCity(confirmOrderService.selCityById(buyerAddress.getCityId()));
        buyerAddress.setTown(confirmOrderService.selTownById(buyerAddress.getTownId()));
        String addressId;
        if (buyerAddressItem.getType().equalsIgnoreCase("1")) {//确认并且收藏
            addressId = itemOrderService.saveBuyerAddress(buyerAddress).toString();
        } else {
            addressId = confirmOrderService.saveTmpBuyerAddress(buyerAddress);
        }

        return JsonResponseUtil.success().element("addressId", addressId);
    }

    /**
     * 获取快递规则接口json
     * @param provId    省份id
     * @param senderId  发货方式id
     * @return
     * @throws JsonErrException
     * @throws LogisticsRuleException
     */
    @ResponseBody
    @RequestMapping("getPostListByProvId")
    public JSONObject getPostListByProvId (String provId, String senderId) throws JsonErrException, LogisticsRuleException {
        List<PostVO> postVOS = confirmOrderService.getPostListByProvId(provId, senderId);
        return JsonResponseUtil.success().element("postList",
                postVOS.stream().map(postVO -> new JSONObject().element("name",postVO.getId()).element("text",postVO.getText())).collect(Collectors.toList()));
    }

    /**
     * 获取快递与服务费信息
     * @param postName
     * @param provId
     * @param eachShopNum  每家店铺的商品数量 如{店铺id:商品数量，店铺id:商品数量，}
     * @param totalWeight
     * @return
     * @throws JsonErrException
     * @throws LogisticsRuleException
     */
    @ResponseBody
    @RequestMapping("getOtherCost")
    public JSONObject getOtherCost(String postName, String provId,String eachShopNum,Long totalWeight,String senderId) throws JsonErrException, LogisticsRuleException {
        OtherCostVO otherCostVO = confirmOrderService.getOtherCost(new Long(postName),provId,eachShopNum,totalWeight,senderId);
        return JsonResponseUtil
                    .success()
                    .element("postPrice",otherCostVO.getPostPrice())
                    .element("servicePrice",otherCostVO.getServicePrice())
                    .element("serviceInfosText",otherCostVO.getServiceInfosText());
    }

    /**
     * 淘宝批量下单获取整合信息
     * @param bo
     * @param request
     * @return
     * @throws OrderException
     * @throws LogisticsRuleException
     */
    @RequestMapping("confirmTbBatchOrder")
    @ResponseBody
    public JSONObject confirmTbBatchOrder(ConfirmMoreTbBO bo, HttpServletRequest request) throws OrderException, LogisticsRuleException {
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!(Boolean) sessionUser.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new OrderException("没有访问的权限");
        }
        List<OrderSubmitVo> tbTrades=redisIO.getList(bo.getIdCode(),OrderSubmitVo.class);
        if (tbTrades == null||tbTrades.size()==0) {
            throw new OrderException("订单超时");
        }
        Long userId = sessionUser.getUserId();
        if (!Objects.equals(tbTrades.get(0).getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }
        List<PostVO> psv=logisticsService.defaultPost(bo.getSenderId());
        return JSONObject.fromObject(confirmOrderService.confirmTbBatchOrder(tbTrades,bo.getSenderId()))
                .element("result","success")
                .element("postTotalPrice","0.00")
                .element("postList",psv.stream().map(postVO -> new JSONObject()
                        .element("id",postVO.getId()).element("name",postVO.getText())).collect(Collectors.toList()));

    }

    /**
     * 淘宝批量下单获取快递费
     * @param bo
     * @param request
     * @return
     * @throws OrderException
     * @throws LogisticsRuleException
     */
    @RequestMapping("queryPostPriceForConfirmTbBatchOrder")
    @ResponseBody
    public JSONObject queryPostPriceForConfirmTbBatchOrder(ConfirmMoreTbBO bo,HttpServletRequest request) throws OrderException, LogisticsRuleException {
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!(Boolean) sessionUser.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new OrderException("没有访问的权限");
        }
        List<OrderSubmitVo> tbTrades=redisIO.getList(bo.getIdCode(),OrderSubmitVo.class);
        if (tbTrades == null||tbTrades.size()==0) {
            throw new OrderException("订单超时");
        }
        Long userId = sessionUser.getUserId();
        if (!Objects.equals(tbTrades.get(0).getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }
        return JsonResponseUtil.success().element("postTotalPrice", MoneyUtil.dealPrice(confirmOrderService.confirmTbBatchOrderPostFee(tbTrades,bo.getSenderId(),bo.getPostId())));
    }

    /**
     * 淘宝批量下单,订单提交
     * @param bo
     * @param request
     * @return
     * @throws OrderException
     * @throws JsonErrException
     */
    @RequestMapping("submitResultForConfirmTbBatchOrder")
    @ResponseBody
    public JSONObject submitResultForConfirmTbBatchOrder(ConfirmMoreTbBO bo,HttpServletRequest request) throws OrderException, JsonErrException {
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!(Boolean) sessionUser.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new OrderException("没有访问的权限");
        }
        List<OrderSubmitVo> tbTrades=redisIO.getList(bo.getIdCode(),OrderSubmitVo.class);
        if (tbTrades == null||tbTrades.size()==0) {
            throw new OrderException("订单超时");
        }
        Long userId = sessionUser.getUserId();
        if (!Objects.equals(tbTrades.get(0).getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }
        return JsonResponseUtil.success().element("redectUrl", "/order/payMode.htm?orderCode="+confirmOrderService.confirmTbBatchOrders(bo,userId,tbTrades));

    }

}
