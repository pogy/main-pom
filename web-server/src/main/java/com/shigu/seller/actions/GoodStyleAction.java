package com.shigu.seller.actions;

import com.shigu.seller.bo.PidBo;
import com.shigu.seller.services.GoodStyleService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.sun.net.httpserver.Authenticator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("seller")
public class GoodStyleAction {
    @Autowired
    GoodStyleService goodStyleService;


    /**
     * 风格管理页
     *
     * @return
     */
    @RequestMapping("goodsStyleManager")
    public String goodsStyleManager(PidBo bo, HttpSession session, Model model) {
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(bo==null){
           bo.setPid(1L);
        }
        //类目选项卡数据
        model.addAttribute("categoryTabs", goodStyleService.selCategoryTabVos(personalSession.getLogshop().getWebSite(),personalSession.getLogshop().getShopId()));
//        //自定义商品风格列表数据
//        model.addAttribute("userGoodsStyleList",goodStyleService.getUserStyle(bo.getPid(),personalSession.getUserId(),personalSession.getLogshop().getShopId()));
//        model.addAttribute("query",bo);
        return "gys/goodsStyleManager";
    }
    /**
     * 获取类目列表
     */
    @RequestMapping("getCategoryList")
    @ResponseBody
    public JSONObject getCategoryList(HttpSession session){
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession shopSession = personalSession.getLogshop();
        return JsonResponseUtil.success().element("categoryList",goodStyleService.getCategory(shopSession.getWebSite()));
    }

    /**
     * 添加商品风格
     */
    @RequestMapping("addGoodsStyle")
    @ResponseBody
    public JSONObject addGoodsStyle(Long categoryId,String goodsStyleName,HttpSession session){
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//        ShopSession shopSession = personalSession.getLogshop();
        goodStyleService.addCustomerStyle(categoryId,goodsStyleName,personalSession.getUserId());
        return JSONObject.fromObject(JsonResponseUtil.success());
    }

    /**
     * 修改商品风格
     */
    @RequestMapping("editGoodsStyle")
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
    @RequestMapping("sortGoodsStyle")
    @ResponseBody
    public JSONObject sortGoodsStyle(Long goodsStyleId,Integer sortType){

        goodStyleService.sortCustomerStyle( goodsStyleId, sortType);
        return JSONObject.fromObject(JsonResponseUtil.success());
    }


    /**
     * 删除自定义商品风格
     */
    @RequestMapping("deleteGoodsStyle")
    @ResponseBody
    public JSONObject deleteGoodsStyle(Long goodsStyleId){
        goodStyleService.delCustomerStyle(goodsStyleId);
        return JSONObject.fromObject(JsonResponseUtil.success());
    }
}
