package com.shigu.activity.actions;

import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.activity.bo.QueryBo;
import com.shigu.activity.service.StyleService;
import com.shigu.activity.vo.StyleGoodsVo;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.item.vo.ShiguAggsPager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 风格馆
 * Created by bugzy on 2017/5/18 0018.
 */
@Controller
public class StyleAction {

    @Autowired
    private StyleService styleService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @RequestMapping("/activity/style")
    public String styleShow(QueryBo bo, Model model){
        model.addAttribute("query", bo);
        model.addAttribute("picCateNav", styleService.selPicCateNav());
        ShiguAggsPager pager = styleService.searchGoods(bo);
        model.addAttribute("textCateNav", styleService.selTextCateNav(pager.getCats(), pager.getMarkets()));
        model.addAttribute("goodslist", packGoods(pager.getContent()));
        model.addAttribute("totalPage", pager.getTotalPages());
        model.addAttribute("webSite", bo.getWebSite());
        model.addAttribute("pageOption", pager.selPageOption(50));
        return "activity/styleGoods";
    }

    private List<StyleGoodsVo> packGoods(List<SearchItem> content) {
        List<StyleGoodsVo> goodsVos = new ArrayList<>(content.size());
        if (!content.isEmpty()) {
            Set<Long> storeIds = BeanMapper.getFieldSet(content, "storeId", Long.class);
            Map<Long, ShopNumAndMarket> shopMap =
                    BeanMapper.list2Map(shiguShopMapper.selShopNumAndMarkets(new ArrayList<>(storeIds)), "shopId", Long.class);
            for (SearchItem searchItem : content) {
                StyleGoodsVo vo = new StyleGoodsVo();
                goodsVos.add(vo);
                vo.setId(searchItem.getItemId());
                vo.setImgsrc(searchItem.getPicUrl());
                vo.setPiprice(searchItem.getPrice());
                vo.setStoreid(searchItem.getStoreId());
                ShopNumAndMarket numAndMarket = shopMap.get(searchItem.getStoreId());
                if (numAndMarket != null) {
                    vo.setFullStoreName(numAndMarket.getMarket() + " " + numAndMarket.getShopNum());
                }
            }
        }
        return goodsVos;
    }
}
