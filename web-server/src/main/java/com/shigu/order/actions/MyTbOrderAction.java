package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.servicevo.SubTbOrderVO;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.vo.GoodsVO;
import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.order.bo.MoreTbOrderBO;
import com.shigu.order.bo.TaobaoOrderBO;
import com.shigu.order.exceptions.OrderException;
import com.shigu.order.services.MyTbOrderService;
import com.shigu.order.vo.MoreErrorAddressVO;
import com.shigu.order.vo.MyTbOrderVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @类编号
 * @类名称：MyTbOrderAction
 * @文件路径：com.shigu.order.actions.MyTbOrderAction
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/21 09:19
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
@Controller
@RequestMapping("order/")
public class MyTbOrderAction {
    @Autowired
    MyTbOrderService myTbOrderService;

    /**
     * ====================================================================================
     * @方法名： myTbOrder
     * @user lys 2017/7/21 09:23
     * @功能： 淘宝订单列表
     * @param: [session, model, bo]
     * @return: java.lang.String
     * @exception:
     * ====================================================================================
     *
     */
    @RequestMapping("myTbOrder")
    public String myTbOrder(HttpSession session, TaobaoOrderBO bo, Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Integer size=10;
        if(StringUtils.isEmpty(bo.getPage())){
            bo.setPage(1);
        }
        MyTbOrderVO<TbOrderVO> pager=myTbOrderService.myTbOrders(ps.getUserId(),bo.getOrderId(),
                bo.getPage(),size,bo.getSt(),bo.getEt());
        //极限词过滤
        pager.getContent().forEach(tbOrderVO -> tbOrderVO.getChildOrders().forEach(subTbOrderVO -> subTbOrderVO.setTitle(KeyWordsUtil.duleKeyWords(subTbOrderVO.getTitle()))));

        model.addAttribute("orders",pager.getContent());
        model.addAttribute("notLinkNum",pager.getNotLinkNum());
        model.addAttribute("notLinkCode",pager.getNotLinkCode());
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",pager.getTotalCount()+","+size+","+bo.getPage());
        return "fxs/myTbOrder";
    }

    @RequestMapping("myBatchTbOrder")
    public String myBatchTbOrder(HttpSession session, TaobaoOrderBO bo, Model model) throws OrderException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps == null) {
            throw new OrderException("没有访问的权限");
        }
        if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new OrderException("没有访问的权限");
        }
        myTbOrder(session,bo,model);
        return "fxs/myBatchTbOrder";
    }


    @RequestMapping("allGlGoodsJson")
    @ResponseBody
    public JSONObject allGlGoodsJson(String keyword,String webSite,Integer page){
        if(page==null||page<1){
            page=1;
        }
        Integer size=4;
        Integer maxPage=5000/size;
        ShiguPager<GoodsVO> pager=myTbOrderService.selectglGoods(keyword,webSite,page,size);
        //极限词过滤
        pager.getContent().forEach(goodsVO -> goodsVO.setTitle(KeyWordsUtil.duleKeyWords(goodsVO.getTitle())));

        JSONObject obj=new JSONObject();
        obj.put("result","success");
        obj.put("goodsList",pager.getContent());
        obj.put("pageOption",(pager.getTotalCount()>maxPage?maxPage:pager.getTotalCount())+","+size+","+page);
        return obj;
    }
    //手动关联

    @RequestMapping("glGoodsJson")
    @ResponseBody
    public JSONObject glGoodsJson(Long goodsId,Long numiid,HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        JSONObject obj=new JSONObject();
        try {
            myTbOrderService.glGoodsJson(numiid,goodsId,ps.getUserId());
            obj.put("result","success");
        } catch (NotFindRelationGoodsException e) {
            obj.put("result","error");
            obj.put("msg","未找到可关联的商品");
        }
        return obj;
    }

//    @RequestMapping("ttttt")
//    @ResponseBody
//    public JSONObject ttttt(){
////        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//        JSONObject obj=new JSONObject();
//        try {
//            myTbOrderService.glGoodsJson(556613638156L,21195361L,1000074682L);
//            obj.put("result","success");
//        } catch (NotFindRelationGoodsException e) {
//            obj.put("result","error");
//            obj.put("msg","未找到可关联的商品");
//        }
//        return obj;
//    }


    /**
     * 解析淘宝订单,返回
     * @param tbId 子单列表
     */
    @RequestMapping("submitTbOrders")
    @ResponseBody
    public JSONObject submitTbOrders(Long tbId, HttpSession session) throws JsonErrException, OrderException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            String code = myTbOrderService.submitTbOrders(tbId,ps.getUserId());
            return JsonResponseUtil.success().element("code", code);
        } catch (NotFindRelationGoodsException e) {
            throw new JsonErrException("存在未关联的商品");
        }
    }

    /**
     * 批量解析淘宝订单,尝试返回code
     * @param bo
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("tbBatchOrder")
    @ResponseBody
    public JSONObject tbBatchOrder(MoreTbOrderBO bo, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new JsonErrException("没有访问的权限");
        }
        return myTbOrderService.submitMoreTbOrders(bo.getTids(),ps.getUserId(),bo.getRepeatIs());
    }

    /**
     * 未关联的商品列表
     * @param notLinkCode
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("tbBindGoodsNo")
    public String moreTbNeedBind(String notLinkCode, HttpSession session,Model model) throws OrderException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new OrderException("没有访问的权限");
        }
        List<SubTbOrderVO> vos= myTbOrderService.moreTbNeedBind(notLinkCode,ps.getUserId());
        //极限词过滤
        vos.forEach(subTbOrderVO -> subTbOrderVO.setTitle(KeyWordsUtil.duleKeyWords(subTbOrderVO.getTitle())));

        model.addAttribute("goodsList",vos);
        return "fxs/tbBindGoodsNo";
    }

    /**
     * 错误地址列表
     * @param bo
     * @param session
     * @return
     */
    @RequestMapping("lookErrorAdress")
    @ResponseBody
    public JSONObject lookErrorAdress(MoreTbOrderBO bo, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!(Boolean) ps.getOtherPlatform().get(OtherPlatformEnum.MORE_ORDER.getValue())){
            throw new JsonErrException("没有访问的权限");
        }
        List<MoreErrorAddressVO> vos= myTbOrderService.moreErrorAddress(bo.getTids(),ps.getUserId());
        JSONObject obj=JsonResponseUtil.success();
        obj.put("addressList",vos);
        return  obj;
    }


}
