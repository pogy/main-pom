package com.shigu.activity.actions;

import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.activity.bo.QueryBo;
import com.shigu.activity.service.StyleService;
import com.shigu.activity.vo.PicCateNav;
import com.shigu.activity.vo.StyleGoodsVo;
import com.shigu.activity.vo.StyleNavVo;
import com.shigu.activity.vo.TextCateNav;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.item.vo.ShiguAggsPager;
import com.shigu.tools.KeyWordsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
    public String styleShow(QueryBo bo, HttpServletRequest request, Model model){
        if(StringUtils.isEmpty(bo.getSid())){
            Cookie[] cookies = request.getCookies();
            if (cookies != null)
                for (Cookie c : cookies) {
                    if ("sid".equals(c.getName())) {
                        bo.setSid(c.getValue());
                        break;
                    }
                }
            if(StringUtils.isEmpty(bo.getSid())){
                bo.setSid("9");
            }
        }

        model.addAttribute("query", bo);
        List<StyleNavVo> styleNavVos = new ArrayList<>();
        PicCateNav picCateNav = styleService.selPicCateNav(bo.getWebSite());
        styleNavVos.addAll(picCateNav.getPicCates());
        styleNavVos.addAll(picCateNav.getTextCates());
        ShiguAggsPager pager = styleService.searchGoods(bo);
        TextCateNav textCateNav=styleService.selTextCateNav(pager.getCats(), pager.getMarkets(),bo.getWebSite());


        //极限词过滤
        if(picCateNav.getTextCates()!=null)picCateNav.getTextCates().forEach(styleNavVo -> styleNavVo.setText(KeyWordsUtil.duleKeyWords(styleNavVo.getText())));
        if(pager.getContent()!=null)pager.getContent().forEach(searchItem -> {
            searchItem.setTitle(KeyWordsUtil.duleKeyWords(searchItem.getTitle()));
            searchItem.setHighLightTitle(KeyWordsUtil.duleKeyWords(searchItem.getHighLightTitle()));
        });


        model.addAttribute("picCateNav", picCateNav);
        model.addAttribute("textCateNav", textCateNav);
        model.addAttribute("goodslist", packGoods(pager.getContent()));
        model.addAttribute("totalPage", pager.getTotalPages());
        model.addAttribute("styleGoodsCount", pager.getTotalCount());
        model.addAttribute("styleTitle", selTextBySid(bo.getSid(), styleNavVos));
        model.addAttribute("webSite", bo.getWebSite());
        model.addAttribute("pageOption", pager.selPageOption(50));
        return "activity/styleGoods";
    }

    public String selTextBySid(String sid, List<StyleNavVo> styleNavVos) {
        for (StyleNavVo styleNavVo : styleNavVos) {
            if (sid.equals(styleNavVo.getId())) {
                return styleNavVo.getText();
            }
        }
        return null;
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
