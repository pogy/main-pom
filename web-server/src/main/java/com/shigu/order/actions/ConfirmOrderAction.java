package com.shigu.order.actions;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.order.exceptions.LogisticsRuleException;
import com.shigu.main4.order.services.ItemOrderService;
import com.shigu.main4.order.services.LogisticsService;
import com.shigu.main4.order.services.OrderConstantService;
import com.shigu.main4.order.vo.*;
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
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
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
    private OrderConstantService orderConstantService;

    @Autowired
    private OrderOptionSafeService orderOptionSafeService;
    @Autowired
    LogisticsService logisticsService;

    private static String ACTIVITY_EXPRESS_DISCOUNTS = "activity_express_discounts";
    private static String ORDER_EXPRESS_ADDRESS = "order_express_address";
    private static String ORDER_EXPRESS_UPDATE = "order_express_update";
    private static String ORDER_EXPRESS_VERSION = "order_express_version";

    /**
     * 订单确认提交
     *
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
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ConfirmBO confirmBO = JSON.parseObject(boStr.toString(), ConfirmBO.class);
        Boolean b = redisIO.get(ORDER_EXPRESS_UPDATE, Boolean.class);
        if (b != null && b) {
            orderConstantService.initAddress();
        }
        confirmOrderService.isAddress(confirmBO.getAddressId());
        Long oid = confirmOrderService.confirmOrders(confirmBO, ps.getUserId());
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
        String webSite=orderSubmitVo.getProducts().get(0).getWebSite();
        Long senderId=confirmOrderService.selSendIdByItemId(webSite);
        List<SenderInfoVO> senderInfoVOList = confirmOrderService.senderListDefault(senderId);
        model.addAttribute("sender", senderInfoVOList);

        String version = redisIO.get(ORDER_EXPRESS_VERSION, String.class);
        if (StringUtils.isBlank(version)) {
            Long time = System.currentTimeMillis();
            redisIO.put(ORDER_EXPRESS_VERSION, time.toString());
            model.addAttribute("linkageVersion", time.toString());
        } else {
            String address = redisIO.get(ORDER_EXPRESS_ADDRESS, String.class);
            if (StringUtils.isBlank(address)) {
                Long time = System.currentTimeMillis();
                redisIO.put(ORDER_EXPRESS_VERSION, time.toString());
                model.addAttribute("linkageVersion", time.toString());
            } else {
                model.addAttribute("linkageVersion", version);
            }
        }
        // 商品信息
        List<CartOrderVO> vos = cartService.packCartProductVo(orderSubmitVo.getProducts()).getOrders();
        //极限词过滤
        vos.forEach(cartOrderVO -> cartOrderVO.getChildOrders().forEach(cartChildOrderVO -> cartChildOrderVO.setTitle(KeyWordsUtil.duleKeyWords(cartChildOrderVO.getTitle()))));

        // 商品服务信息
        model.addAttribute("serviceRulers", JSON.toJSONString(confirmOrderService.serviceRulePack(vos, senderId)));
        model.addAttribute("goodsOrders", vos);
        model.addAttribute("collList", confirmOrderService.collListByUser(userId));//收藏的地址数据
        model.addAttribute("webSite", "hz");//站点
        model.addAttribute("code", bo.getCode());
        model.addAttribute("tbOrderAddressInfo", orderSubmitVo.getTbOrderAddressInfo());
        return "order/confirmOrder";
    }

    @RequestMapping("getAreaData")
    @ResponseBody
    public JSONObject getAreaData(HttpServletResponse response) {
        response.setHeader("Content-type", "text/plain;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setDateHeader("expries", System.currentTimeMillis() + 1000 * 3600 * 24 * 20);
        PrintWriter out = null;
        String address = redisIO.get(ORDER_EXPRESS_ADDRESS, String.class);
        if (StringUtils.isBlank(address)) {
            address = confirmOrderService.getArea();
        }
        try {
            out = response.getWriter();
            out.append("var areaData = ");
            out.append(address);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        return JsonResponseUtil.success();
    }

    @ResponseBody
    @RequestMapping("deleteCollJson")
    public JSONObject deleteCollJson(Long id, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (!orderOptionSafeService.checkByAddressId(ps.getUserId(), id)) {
            return JsonResponseUtil.error("只能操作本用户下的地址");
        }
        itemOrderService.rmBuyerAddress(id);
        return JsonResponseUtil.success();
    }

    @ResponseBody
    @RequestMapping("collectCgneeJson")
    public JSONObject collectCgneeJson(BuyerAddressItemVO buyerAddressItem, HttpServletRequest request) throws JsonErrException {
        if (StringUtils.isEmpty(buyerAddressItem.getName()) || StringUtils.isEmpty(buyerAddressItem.getAddress())
                || StringUtils.isEmpty(buyerAddressItem.getPhone())) {
            throw new JsonErrException("地址缺少必要信息");
        }
        Long userId = null;
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (sessionUser != null) {
            userId = sessionUser.getUserId();
        }
        if (!orderOptionSafeService.checkCitySafe(buyerAddressItem.getProvId(), buyerAddressItem.getCityId())) {
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
     *
     * @param provId   省份id
     * @param senderId 发货方式id
     * @return
     * @throws JsonErrException
     * @throws LogisticsRuleException
     */
    @ResponseBody
    @RequestMapping("getPostListByProvId")
    public JSONObject getPostListByProvId(String provId, String senderId) throws JsonErrException, LogisticsRuleException {
        List<PostVO> postVOS = confirmOrderService.getPostListByProvId(provId, senderId);
        return JsonResponseUtil.success().element("postList",
                postVOS.stream().map(postVO -> new JSONObject().element("name", postVO.getId()).element("text", postVO.getText())).collect(Collectors.toList()));
    }

    /**
     * 获取快递与服务费信息
     *
     * @param postName
     * @param provId
     * @param eachShopNum 每家店铺的商品数量 如{店铺id:商品数量，店铺id:商品数量，}
     * @param totalWeight
     * @return
     * @throws JsonErrException
     * @throws LogisticsRuleException
     */
    @ResponseBody
    @RequestMapping("getOtherCost")
    public JSONObject getOtherCost(String postName, String provId, String eachShopNum, Long totalWeight, String senderId, HttpSession session) throws JsonErrException, LogisticsRuleException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        OtherCostVO otherCostVO = confirmOrderService.getOtherCost(new Long(postName), provId, eachShopNum, totalWeight, senderId, ps.getUserId());
        Boolean activity = Boolean.parseBoolean(redisIO.get(ACTIVITY_EXPRESS_DISCOUNTS, String.class));
        Long freePostCost = 0L;
        if (activity) {
            if (logisticsService.isMinusFreight(ps.getUserId(), null)) {
                freePostCost = otherCostVO.getPostPrice() > 500 ? 500 : otherCostVO.getPostPrice();
            }
        }
        return JsonResponseUtil
                .success()
                .element("postPrice", otherCostVO.getPostPrice())
                .element("servicePrice", otherCostVO.getServicePrice())
                .element("serviceInfosText", otherCostVO.getServiceInfosText())
                .element("freePostCost", freePostCost);
    }

    /**
     * 淘宝批量下单获取整合信息
     *
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
        if (!(Boolean) sessionUser.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())) {
            throw new OrderException("没有访问的权限");
        }
        List<OrderSubmitVo> tbTrades = redisIO.getList(bo.getIdCode(), OrderSubmitVo.class);
        if (tbTrades == null || tbTrades.size() == 0) {
            throw new OrderException("订单超时");
        }
        Long userId = sessionUser.getUserId();
        if (!Objects.equals(tbTrades.get(0).getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }
        String webSite=tbTrades.get(0).getProducts().get(0).getWebSite();
        Long senderId=confirmOrderService.selSendIdByItemId(webSite);
        List<PostVO> psv = logisticsService.defaultPost(senderId);
        return JSONObject.fromObject(confirmOrderService.confirmTbBatchOrder(tbTrades, senderId))
                .element("result", "success")
                .element("postTotalPrice", "0.00")
                .element("postList", psv.stream().map(postVO -> new JSONObject()
                        .element("id", postVO.getId()).element("name", postVO.getText())).collect(Collectors.toList()));

    }

    /**
     * 淘宝批量下单获取快递费
     *
     * @param bo
     * @param request
     * @return
     * @throws OrderException
     * @throws LogisticsRuleException
     */
    @RequestMapping("queryPostPriceForConfirmTbBatchOrder")
    @ResponseBody
    public JSONObject queryPostPriceForConfirmTbBatchOrder(ConfirmMoreTbBO bo, HttpServletRequest request) throws OrderException, LogisticsRuleException {
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (!(Boolean) sessionUser.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())) {
            throw new OrderException("没有访问的权限");
        }
        List<OrderSubmitVo> tbTrades = redisIO.getList(bo.getIdCode(), OrderSubmitVo.class);
        if (tbTrades == null || tbTrades.size() == 0) {
            throw new OrderException("订单超时");
        }
        Long userId = sessionUser.getUserId();
        if (!Objects.equals(tbTrades.get(0).getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }
        Double freePostCost = 0.00;
        String webSite=tbTrades.get(0).getProducts().get(0).getWebSite();
        Long senderId=confirmOrderService.selSendIdByItemId(webSite);
        String postTotalPrice = MoneyUtil.dealPrice(confirmOrderService.confirmTbBatchOrderPostFee(tbTrades, senderId, bo.getPostId(), sessionUser.getUserId()));
        Boolean activity = Boolean.parseBoolean(redisIO.get(ACTIVITY_EXPRESS_DISCOUNTS, String.class));
        if (activity) {
            if (logisticsService.isMinusFreight(sessionUser.getUserId(), null))
                freePostCost = Double.valueOf(postTotalPrice) > Double.valueOf(5.00) ? Double.valueOf(5.00) : Double.valueOf(postTotalPrice);
        }
        return JsonResponseUtil.success().element("postTotalPrice", postTotalPrice).element("freePostCost", freePostCost.toString());
    }

    /**
     * 淘宝批量下单,订单提交
     *
     * @param bo
     * @param request
     * @return
     * @throws OrderException
     * @throws JsonErrException
     */
    @RequestMapping("submitResultForConfirmTbBatchOrder")
    @ResponseBody
    public JSONObject submitResultForConfirmTbBatchOrder(ConfirmMoreTbBO bo, HttpServletRequest request) throws OrderException, JsonErrException {
        PersonalSession sessionUser = (PersonalSession) request.getSession().getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (!(Boolean) sessionUser.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())) {
            throw new OrderException("没有访问的权限");
        }
        List<OrderSubmitVo> tbTrades = redisIO.getList(bo.getIdCode(), OrderSubmitVo.class);
        if (tbTrades == null || tbTrades.size() == 0) {
            throw new OrderException("订单超时");
        }
        Long userId = sessionUser.getUserId();
        if (!Objects.equals(tbTrades.get(0).getUserId(), userId)) {
            throw new OrderException("订单信息错误");
        }
        return JsonResponseUtil.success().element("redectUrl", "/order/payMode.htm?orderCode=" + confirmOrderService.confirmTbBatchOrders(bo, userId, tbTrades));

    }

}
