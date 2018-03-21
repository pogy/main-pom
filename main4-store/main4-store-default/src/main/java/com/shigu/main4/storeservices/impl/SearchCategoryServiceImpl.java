package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.ShiguSiteSearchCategory;
import com.opentae.data.mall.examples.ShiguSiteSearchCategoryExample;
import com.opentae.data.mall.interfaces.ShiguSiteSearchCategoryMapper;
import com.shigu.main4.storeservices.SearchCategoryService;
import com.shigu.main4.vo.CateMenu;
import com.shigu.main4.vo.SubMenu;
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
        ssscOneExample.createCriteria().andTypeEqualTo(3).andCStatusEqualTo(1);
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
            ssscTwoExample.createCriteria().andParentCidEqualTo(ssscOneList.get(i).getId()).andCStatusEqualTo(1);
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
}
