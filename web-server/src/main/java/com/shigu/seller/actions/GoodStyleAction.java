package com.shigu.seller.actions;

import com.shigu.seller.services.GoodStyleService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class GoodStyleAction {
    @Autowired
    GoodStyleService goodStyleService;


    /**
     * 风格管理页
     *
     * @return
     */
    @RequestMapping("seller/goodsStyleManager")
    public String goodsStyleManager(Model model) {

        return "gys/goodsStyleManager";
    }
    /**
     * 获取类目列表
     */
    @RequestMapping("seller/getCategoryList")
    @ResponseBody
    public JSONObject getCategoryList(HttpSession session, Model model){
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession shopSession = personalSession.getLogshop();
        return JSONObject.fromObject(goodStyleService.getCategory(shopSession.getWebSite()));
    }

    /**
     * 添加商品风格
     */
    @RequestMapping("seller/addGoodsStyle")
    @ResponseBody
    public JSONObject addGoodsStyle(Long categoryId,String goodsStyleName,HttpSession session){
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession shopSession = personalSession.getLogshop();
        goodStyleService.addCustomerStyle(categoryId,goodsStyleName,personalSession.getUserId());
        return JSONObject.fromObject(JsonResponseUtil.success());
    }

    /**
     * 修改商品风格
     */
    @RequestMapping("seller/editGoodsStyle")
    @ResponseBody
    public JSONObject editGoodsStyle(Long categoryId,Long goodsStyleId,String goodsStyleName,HttpSession session){
//        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//        ShopSession shopSession = personalSession.getLogshop();
        goodStyleService.updateCustomerStyle(categoryId, goodsStyleId, goodsStyleName);
        return JSONObject.fromObject(JsonResponseUtil.success());
    }
    /**
     * 移动商品风格排序
     */
    @RequestMapping("seller/sortGoodsStyle")
    @ResponseBody
    public JSONObject sortGoodsStyle(Long goodsStyleId,Integer sortType){

        goodStyleService.sortCustomerStyle( goodsStyleId, sortType);
        return JSONObject.fromObject(JsonResponseUtil.success());
    }


    /**
     * 删除自定义商品风格
     */
    @RequestMapping("seller/deleteGoodsStyle")
    @ResponseBody
    public JSONObject deleteGoodsStyle(Long goodsStyleId){
        goodStyleService.delCustomerStyle(goodsStyleId);
        return JSONObject.fromObject(JsonResponseUtil.success());
    }
}
