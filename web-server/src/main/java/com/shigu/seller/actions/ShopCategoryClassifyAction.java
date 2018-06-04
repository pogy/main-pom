package com.shigu.seller.actions;

import com.opentae.data.mall.beans.ShiguShop;
import com.shigu.main4.common.tools.ShiguPager;

import com.shigu.main4.storeservices.ShopCategoryClassifyService;
import com.shigu.main4.vo.GoodsVo;
import com.shigu.main4.vo.TabDatasVo;
import com.shigu.seller.vo.GoodsCateQueryVo;
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
import java.util.ArrayList;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.seller.actions
 * @ClassName: ShopCategoryClassifyAction
 * @Author: sy
 * @CreateDate: 2018/6/1 0001 13:07
 */
@Controller
public class ShopCategoryClassifyAction {

    @Autowired
    private ShopCategoryClassifyService shopCategoryClassifyService;

    @RequestMapping("seller/goodsCategory")
    public String goodsCategory(Long cnameId, Integer page,HttpSession session, Model model){
        ShopSession shop = getShopSession(session);
        ShiguPager<GoodsVo> pager = shopCategoryClassifyService.getShopShowGoods(shop.getShopId(),cnameId,page==null?1:page,60,shop.getWebSite());
        if (pager.getContent() != null && pager.getContent().size()>0){
            model.addAttribute("goodsList",pager.getContent());
        }else {
            model.addAttribute("goodsList",new ArrayList<>());
        }
        model.addAttribute("tabDatas",shopCategoryClassifyService.getShopTabDatas(shop.getShopId(),shop.getWebSite()));
        model.addAttribute("pageOption",pager.selPageOption(60));
        if (cnameId != null && cnameId > 0) {
            GoodsCateQueryVo queryVo = new GoodsCateQueryVo();
            queryVo.setCnameId(cnameId);
            model.addAttribute("query",queryVo);
        }
        return "gys/goodsCategory";
    }

    @RequestMapping("seller/addDiyCate")
    @ResponseBody
    public JSONObject goodsCaddDiyCateategory(String cname, HttpSession session){
        Integer b = shopCategoryClassifyService.addCustomCategory(cname,getShopSession(session).getShopId());
        if (b <= 0)
            return JsonResponseUtil.error("添加类目失败");
        return JsonResponseUtil.success();
    }

    @RequestMapping("seller/removeCate")
    @ResponseBody
    public JSONObject removeCate(Long cnameId,HttpSession session){
        Integer b = shopCategoryClassifyService.deleCate(cnameId);
        if (b <= 0)
            return JsonResponseUtil.error("删除类目失败");
        return JsonResponseUtil.success();
    }

    @RequestMapping("seller/setCateForGoods")
    @ResponseBody
    public JSONObject setCateForGoods(Long cnameId, String ids,Integer type,HttpSession session){
        ShopSession shop = getShopSession(session);
        Integer b = shopCategoryClassifyService.setCategoryForGoods(ids,cnameId,type,shop.getShopId());
        if (b <= 0)
            return JsonResponseUtil.error("商品设置分类失败");
        return JsonResponseUtil.success();
    }

    /**
     * 当前登陆的session
     *
     * @param session
     * @return
     */
    private ShopSession getShopSession(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getLogshop();
    }
}
