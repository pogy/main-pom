package com.shigu.seller.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
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
    public String goodsStyleManager(PidBo bo, HttpSession session, Model model) throws JsonErrException{
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long shopId=personalSession.getLogshop().getShopId();
        Long userId=personalSession.getUserId();
        String webSite=personalSession.getLogshop().getWebSite();
        //类目选项卡数据
       model.addAttribute("categoryTabs", goodStyleService.selCategoryTabVos(webSite,shopId,userId));
        //自定义商品风格列表数据
        model.addAttribute("userGoodsStyleList",goodStyleService.getUserStyle(bo.getPid(),userId,shopId,webSite));
        model.addAttribute("query",bo);
        return "gys/goodsStyleManager";
    }
    /**
     * 获取类目列表
     */
    @RequestMapping("getCategoryList")
    @ResponseBody
    public JSONObject getCategoryList(HttpSession session) throws JsonErrException{
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession shopSession = personalSession.getLogshop();
        return JsonResponseUtil.success().element("categoryList",goodStyleService.getCategory(shopSession.getWebSite()));
    }

    /**
     * 添加商品风格
     */
    @RequestMapping("addGoodsStyle")
    @ResponseBody
    public JSONObject addGoodsStyle(Long categoryId,String goodsStyleName,HttpSession session) throws JsonErrException{
        if(goodsStyleName.length()>45){
            return JsonResponseUtil.error("添加风格名超过限制");
        }
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//        ShopSession shopSession = personalSession.getLogshop();
        Long aLong = goodStyleService.addCustomerStyle(categoryId, goodsStyleName, personalSession.getUserId());
        if(aLong!=0){
            return JSONObject.fromObject(JsonResponseUtil.success().element("goodsStyleId",aLong));
        }
            return JsonResponseUtil.error("添加失败");
    }

    /**
     * 修改商品风格
     */
    @RequestMapping("editGoodsStyle")
    @ResponseBody
    public JSONObject editGoodsStyle(Long categoryId,Long goodsStyleId,String goodsStyleName,HttpSession session) throws JsonErrException{
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = personalSession.getUserId();
        if ( goodStyleService.updateCustomerStyle(categoryId, goodsStyleId, goodsStyleName,userId)!=0){
            return JSONObject.fromObject(JsonResponseUtil.success());
        }
        return JSONObject.fromObject(JsonResponseUtil.error("更改失败"));
    }
    /**
     * 移动商品风格排序
     */
    @RequestMapping("sortGoodsStyle")
    @ResponseBody
    public JSONObject sortGoodsStyle(Long goodsStyleId,Integer sortType) throws JsonErrException{

        goodStyleService.sortCustomerStyle( goodsStyleId, sortType);
        return JSONObject.fromObject(JsonResponseUtil.success());
    }


    /**
     * 删除自定义商品风格
     */
    @RequestMapping("deleteGoodsStyle")
    @ResponseBody
    public JSONObject deleteGoodsStyle(Long goodsStyleId,HttpSession session) throws JsonErrException {
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId=personalSession.getUserId();
        String website=personalSession.getLogshop().getWebSite();
        Long shopId=personalSession.getLogshop().getShopId();
        goodStyleService.delCustomerStyle(goodsStyleId,userId,website,shopId);
        return JSONObject.fromObject(JsonResponseUtil.success());
    }
}
