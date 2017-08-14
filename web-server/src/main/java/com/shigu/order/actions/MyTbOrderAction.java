package com.shigu.order.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.vo.GoodsVO;
import com.shigu.order.bo.TaobaoOrderBO;
import com.shigu.order.services.MyTbOrderService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        ShiguPager<TbOrderVO> pager=myTbOrderService.myTbOrders(ps.getUserId(),bo.getOrderId(),
                bo.getPage(),size,bo.getSt(),bo.getEt());

        model.addAttribute("orders",pager.getContent());
        model.addAttribute("query",bo);
        model.addAttribute("pageOption",pager.getTotalCount()+","+size+","+bo.getPage());
        return "buyer/myTbOrder";
    }

    @RequestMapping("allGlGoodsJson")
    @ResponseBody
    public JSONObject allGlGoodsJson(String keyword,String webSite,Integer page){
        if(page==null||page<1){
            page=1;
        }
        Integer size=4;
        ShiguPager<GoodsVO> pager=myTbOrderService.selectglGoods(keyword,webSite,page,size);
        JSONObject obj=new JSONObject();
        obj.put("result","success");
        obj.put("goodsList",pager.getContent());
        obj.put("pageOption",pager.getTotalCount()+","+size+","+page);
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


    /**
     * 解析淘宝订单,返回
     * @param tbId 子单列表
     */
    @RequestMapping("submitTbOrders")
    @ResponseBody
    public JSONObject submitTbOrders(Long tbId, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            String code = myTbOrderService.submitTbOrders(tbId,ps.getUserId());
            return JsonResponseUtil.success().element("code", code);
        } catch (NotFindSessionException e) {
            throw new JsonErrException("淘宝授权过期");
        } catch (NotFindRelationGoodsException e) {
            throw new JsonErrException("存在未关联的商品");
        }
    }

}
