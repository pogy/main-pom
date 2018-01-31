package com.shigu.seller.actions;

import com.shigu.seller.bo.GoodsStyleManageQueryBO;
import com.shigu.seller.services.ShopItemModService;
import com.shigu.seller.vo.ShopStyleGoodsAggrVO;
import com.shigu.seller.vo.ShopStyleGoodsInfoVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * 路径:com.shigu.seller.actions.ShopGoodsAction
 * 工程:main-pom
 * 时间:18-1-25下午6:07
 * 创建人:wanghaoxiang
 * 描述：
 */
@Controller
public class ShopGoodsAction {

    @Autowired
    private ShopItemModService shopItemModService;


    /**
     * 供应商风格管理
     * @param bo
     * @param page
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("seller/goodsStyleManager")
    public String goodsStyleManager(GoodsStyleManageQueryBO bo, Integer page, HttpSession session, Model model) {
        model.addAttribute("query",bo);
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShopSession logshop = ps.getLogshop();
        String webSite = logshop.getWebSite();
        Long shopId = logshop.getShopId();
        List<ShopStyleGoodsAggrVO> styleList = shopItemModService.selStyleAggrList(webSite, shopId);
        model.addAttribute("styleList",styleList);
        Long spid = bo.getSpid();
        int totalCount = 0;
        int pageSize = 20;
        if (page == null) {
            page = 1;
        }
        if (styleList.size()>0) {
            if (spid == null) {
                spid = styleList.get(0).getSpid();
            }
            List<ShopStyleGoodsInfoVO> goodsList = shopItemModService.selShopStyleGoods(webSite, shopId, spid, (page - 1)*pageSize, pageSize);
            model.addAttribute("goodsList",goodsList);
            for (ShopStyleGoodsAggrVO vo : styleList) {
                if (Objects.equals(spid,vo.getSpid())) {
                    totalCount = vo.getGoodsCount();
                }
            }
        }
        model.addAttribute("pageOption",totalCount+","+pageSize+","+page);
        return "gys/goodsStyleManager";
    }
}
