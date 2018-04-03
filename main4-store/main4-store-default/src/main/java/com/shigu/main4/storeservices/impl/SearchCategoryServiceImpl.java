package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.ShiguSiteSearchCategory;
import com.opentae.data.mall.examples.ShiguSiteSearchCategoryExample;
import com.opentae.data.mall.interfaces.ShiguSiteSearchCategoryMapper;
import com.shigu.main4.storeservices.SearchCategoryService;
import com.shigu.main4.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("searchCategoryService")
public class SearchCategoryServiceImpl implements SearchCategoryService{

    @Resource(name = "tae_mall_shiguSiteSearchCategoryMapper")
    ShiguSiteSearchCategoryMapper shiguSiteSearchCategoryMapper;

    @Override
    public List<CateMenu> getMarketCateShow() {
        ShiguSiteSearchCategoryExample ssscOneExample = new ShiguSiteSearchCategoryExample();
        ssscOneExample.createCriteria().andTypeEqualTo(3).andCStatusEqualTo(1).andDisplayEqualTo(1).andPageTypeEqualTo(1);
        List<ShiguSiteSearchCategory> ssscOneList = shiguSiteSearchCategoryMapper.selectByExample(ssscOneExample);
        if (ssscOneList == null){
            return new ArrayList<>();
        }
        List<CateMenu> cateMenus = new ArrayList<CateMenu>();
        ShiguSiteSearchCategoryExample ssscTwoExample = null;
        List<ShiguSiteSearchCategory> ssscTwoList = null;
        CateMenu cateMenu = null ;
        SubMenu subMenu = null;
        List<SubMenu> subMenuList = null;
        for (int i = 0; i <ssscOneList.size() ; i++) {
            cateMenu = new CateMenu();
            cateMenu.setId(ssscOneList.get(i).getId());
            cateMenu.setIcon(ssscOneList.get(i).getIcon());
            cateMenu.setText(ssscOneList.get(i).getCname());
            ssscTwoExample = new ShiguSiteSearchCategoryExample();
            ssscTwoExample.createCriteria().andParentCidEqualTo(ssscOneList.get(i).getId()).andCStatusEqualTo(1).andDisplayEqualTo(1);
            ssscTwoList = shiguSiteSearchCategoryMapper.selectByExample(ssscTwoExample);
            subMenuList = new ArrayList<SubMenu>();
            for (int j = 0; j <ssscTwoList.size() ; j++) {
                subMenu = new SubMenu();
                subMenu.setText(ssscTwoList.get(j).getCname());
                subMenu.setPid(ssscTwoList.get(j).getParentCid());
                if(ssscTwoList.get(j).getCid() == null){
                    subMenu.setKeyword(ssscTwoList.get(j).getKeyword());
                }else{
                    subMenu.setCid(ssscTwoList.get(j).getCid());
                }
                subMenuList.add(subMenu);
            }
            cateMenu.setSubmenu(subMenuList);
            cateMenus.add(cateMenu);
        }
        return cateMenus;
    }

    @Override
    public List<HomeCateMenu> getHomeCateShow() {
        ShiguSiteSearchCategoryExample ssscExample1 = new ShiguSiteSearchCategoryExample();
        ssscExample1.createCriteria().andCStatusEqualTo(1).andDisplayEqualTo(1).andTypeEqualTo(3).andPageTypeEqualTo(2);
        List<ShiguSiteSearchCategory> ssscList1 = shiguSiteSearchCategoryMapper.selectByExample(ssscExample1);
        if (ssscList1 == null){
            return new ArrayList<>();
        }

        HomeCateMenu homeCateMenu;
        List<ShiguSiteSearchCategory> ssscList2;
        HomeCateItem homeCateItem;
        ThreeCateMenu detailItem;
        List<ThreeCateMenu> detailItemList;
        List<HomeCateItem> itemList;
        List<ShiguSiteSearchCategory> ssscList3;
        List<HomeCateItem> hotItemList;
        List<HomeCateMenu> homeCateMenus = new ArrayList<>();

        for (int i = 0; i <ssscList1.size() ; i++) {
            homeCateMenu = new HomeCateMenu();
            homeCateMenu.setId(ssscList1.get(i).getId());
            homeCateMenu.setText(ssscList1.get(i).getCname());
            ShiguSiteSearchCategoryExample ssscExample2 = new ShiguSiteSearchCategoryExample();
            ssscExample2.createCriteria().andDisplayEqualTo(1).andCStatusEqualTo(1).andParentCidEqualTo(ssscList1.get(i).getId());
            ssscList2 = shiguSiteSearchCategoryMapper.selectByExample(ssscExample2);
            if (ssscList2 != null && ssscList2.size() > 0){
                detailItemList = new ArrayList<>();
                hotItemList = new ArrayList<>();
                for (int j = 0; j <ssscList2.size() ; j++) {
                    detailItem = new ThreeCateMenu();
                    detailItem.setText(ssscList2.get(j).getCname());
                    ShiguSiteSearchCategoryExample ssscExample3 = new ShiguSiteSearchCategoryExample();
                    ssscExample3.createCriteria().andCStatusEqualTo(1).andDisplayEqualTo(1).andParentCidEqualTo(ssscList2.get(j).getId());
                    ssscList3 = shiguSiteSearchCategoryMapper.selectByExample(ssscExample3);
                    if (ssscList3 != null && ssscList3.size() > 0){
                        itemList = new ArrayList<>();
                        for (int k = 0; k <ssscList3.size() ; k++) {
                            homeCateItem = new HomeCateItem();
                            homeCateItem.setName(ssscList3.get(k).getCname());
                            if (ssscList3.get(k).getKeyword() == null || ssscList3.get(k).getKeyword() =="") {
                                homeCateItem.setHref("http://so.571xz.com/hzgoods.htm?pid="+ssscList3.get(k).getTopCid()+"&cid="+ssscList3.get(k).getCid());
                            }else {
                                homeCateItem.setHref("http://so.571xz.com/hzgoods.htm?pid=" + ssscList3.get(k).getTopCid() + "&keyword=" + ssscList3.get(k).getKeyword());
                            }
                            if (ssscList3.get(k).getHot() == 1){
                                hotItemList.add(homeCateItem);
                            }
                            itemList.add(homeCateItem);
                        }
                        detailItem.setItems(itemList);
                    }
                    detailItemList.add(detailItem);
                }
                homeCateMenu.setDetailitems(detailItemList);
                homeCateMenu.setListitems(hotItemList);
            }
            homeCateMenus.add(homeCateMenu);
        }
        return homeCateMenus;
    }
}