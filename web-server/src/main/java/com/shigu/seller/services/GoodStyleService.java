package com.shigu.seller.services;

import com.opentae.data.mall.beans.SearchCategory;
import com.opentae.data.mall.beans.ShiguCustomerStyle;
import com.opentae.data.mall.examples.SearchCategoryExample;
import com.opentae.data.mall.examples.ShiguCustomerStyleExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.SearchCategoryMapper;
import com.opentae.data.mall.interfaces.ShiguCustomerStyleMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.seller.vo.CategoryTabsVo;
import com.shigu.seller.vo.CategoryVo;
import com.shigu.seller.vo.UserGoodsStyleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodStyleService {
    @Autowired
    private  SearchCategoryMapper SearchCategoryMapper;
    @Autowired
    private ItemAddOrUpdateService ItemAddOrUpdateService;
    @Autowired
    private ShiguCustomerStyleMapper shiguCustomerStyleMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    /**
     * 获取自定义风格列表
     */
    public List<UserGoodsStyleVo> getUserStyle(Long pid, Long userId, Long shopId, String webSite){
        ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
        if(pid!=null){
            shiguCustomerStyleExample.createCriteria().andCIdEqualTo(pid);
        }else{
            shiguCustomerStyleExample.createCriteria().andUserIdEqualTo(userId);
        }
        List<ShiguCustomerStyle> shiguCustomerStyles = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample);
        ArrayList<UserGoodsStyleVo> list = new ArrayList<>();
        for (ShiguCustomerStyle customerStyle:shiguCustomerStyles) {
            UserGoodsStyleVo userGoodsStyleVo = new UserGoodsStyleVo();
            userGoodsStyleVo.setGoodsStyleName(customerStyle.getStyleName());
            userGoodsStyleVo.setGoodsStyleId(customerStyle.getStyleId());
            userGoodsStyleVo.setCategoryId(customerStyle.getCId());
            userGoodsStyleVo.setCategoryName(SearchCategoryMapper.selectByPrimaryKey(customerStyle.getCId()).getCateName());
            //查店里当前风格的商品数
            ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
            example.createCriteria().andStoreIdEqualTo(shopId).andRemark9EqualTo(customerStyle.getStyleId()+"");
            example.setWebSite(webSite);
            userGoodsStyleVo.setGoodsNum((long)(shiguGoodsTinyMapper.countByExample(example)));
            list.add(userGoodsStyleVo);
        }


        return list;
    }

    /**
     * 获取类目列表
     */
    public List<CategoryVo> getCategory(String website){
        SearchCategoryExample example = new SearchCategoryExample();
        example.createCriteria().andTypeEqualTo(1).andWebSiteEqualTo(website);
        List<SearchCategory> list = SearchCategoryMapper.selectByExample(example);
        List<CategoryVo> categoryVos = new ArrayList();
        for (SearchCategory searchCategory:list) {
            CategoryVo categoryVo = new CategoryVo();
            categoryVo.setCategoryId(searchCategory.getCategoryId());
            categoryVo.setCategoryName(searchCategory.getCateName());
            categoryVos.add(categoryVo);
        }
        return categoryVos;
    }

    /**
     * 添加自定义风格
     * @param categoryId
     * @param goodsStyleName
     * @param
     * @param userId
     */
    public void addCustomerStyle(Long categoryId, String goodsStyleName, Long userId) {
        ItemAddOrUpdateService.addCustomerStyle(categoryId,goodsStyleName,userId);
    }

    /**
     * 修改自定义风格
     * @param categoryId
     * @param goodsStyleId
     * @param goodsStyleName
     * @param
     */
    public void updateCustomerStyle(Long categoryId, Long goodsStyleId, String goodsStyleName) {
        ItemAddOrUpdateService.updateCustomerStyle(categoryId,goodsStyleId,goodsStyleName);
    }

    /**
     * 删除自定义风格
     * @param goodsStyleId
     */
    public void delCustomerStyle(Long goodsStyleId) {

        ItemAddOrUpdateService.deleteCustomerStyle( goodsStyleId);
    }

    /**
     * 移动商品风格排序
     * @param goodsStyleId
     * @param sortType
     */
    public void sortCustomerStyle(Long goodsStyleId, Integer sortType) {
        ItemAddOrUpdateService.moveSortCustomerStyle(goodsStyleId,sortType);
    }

    /**
     * 查类目选项卡数据
     * @param webSite
     * @param shopId
     * @param userId
     */
    public List<CategoryTabsVo> selCategoryTabVos(String webSite, Long shopId, Long userId) {
        SearchCategoryExample example = new SearchCategoryExample();
        example.createCriteria().andTypeEqualTo(1).andWebSiteEqualTo(webSite);
        List<SearchCategory> list = SearchCategoryMapper.selectByExample(example);
        List<CategoryTabsVo> categoryTabsVos = new ArrayList();
        ShiguCustomerStyleExample example1 = new ShiguCustomerStyleExample();
        ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
        Long num=0L;
        for (SearchCategory searchCategory:list) {
            CategoryTabsVo categoryTabsVo = new CategoryTabsVo();
            categoryTabsVo.setCateId(searchCategory.getCategoryId()+"");
            categoryTabsVo.setCateName(searchCategory.getCateName());
            example1.createCriteria().andUserIdEqualTo(userId).andCIdEqualTo(searchCategory.getCategoryId());
            List<ShiguCustomerStyle> shiguCustomerStyles = shiguCustomerStyleMapper.selectByExample(example1);
            if (shiguCustomerStyles.size()>0){
                for (ShiguCustomerStyle shiguCustomerStyle: shiguCustomerStyles) {
                    shiguGoodsTinyExample.createCriteria().andStoreIdEqualTo(shopId).andRemark9EqualTo(String.valueOf(shiguCustomerStyle.getStyleId()));
                    shiguGoodsTinyExample.setWebSite(webSite);
                    int i = shiguGoodsTinyMapper.selectByExample(shiguGoodsTinyExample).size();
                    num=num+Long.valueOf(i);
                }
            }else{
                num=0L;
            }

            categoryTabsVo.setGoodsNum(num);
            categoryTabsVos.add(categoryTabsVo);


        }
        return categoryTabsVos;
    }
}
