package com.shigu.seller.services;

import com.opentae.data.mall.beans.GoodsCountForsearch;
import com.opentae.data.mall.beans.SearchCategory;
import com.opentae.data.mall.beans.ShiguCustomerStyle;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.examples.SearchCategoryExample;
import com.opentae.data.mall.examples.ShiguCustomerStyleExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.GoodsCountForsearchMapper;
import com.opentae.data.mall.interfaces.SearchCategoryMapper;
import com.opentae.data.mall.interfaces.ShiguCustomerStyleMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.seller.vo.CategoryTabsVo;
import com.shigu.seller.vo.CategoryVo;
import com.shigu.seller.vo.UserGoodsStyleVo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
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
    @Autowired
    private GoodsCountForsearchMapper goodsCountForsearchMapper;
    /**
     * 获取自定义风格列表
     */
    public List<UserGoodsStyleVo> getUserStyle(Long pid, Long userId, Long shopId, String webSite){
        ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
        if(pid!=null){
            shiguCustomerStyleExample.createCriteria().andCIdEqualTo(pid).andUserIdEqualTo(userId);
        }else{
            shiguCustomerStyleExample.createCriteria().andUserIdEqualTo(userId);
        }
        List<ShiguCustomerStyle> shiguCustomerStyles = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample);
        ArrayList<UserGoodsStyleVo> list = new ArrayList<>();
        if(shiguCustomerStyles!=null&&shiguCustomerStyles.size()>0){
            for (ShiguCustomerStyle customerStyle:shiguCustomerStyles) {
                UserGoodsStyleVo userGoodsStyleVo = new UserGoodsStyleVo();
                userGoodsStyleVo.setGoodsStyleName(customerStyle.getStyleName());
                userGoodsStyleVo.setGoodsStyleId(customerStyle.getStyleId());
                userGoodsStyleVo.setCategoryId(customerStyle.getCId());
                SearchCategoryExample searchCategoryExample = new SearchCategoryExample();
                searchCategoryExample.createCriteria().andCateValueEqualTo(String.valueOf(customerStyle.getCId()));
                userGoodsStyleVo.setCategoryName(SearchCategoryMapper.selectByExample(searchCategoryExample).get(0).getCateName());
                //查店里当前风格的商品数
                int i = goodsCountForsearchMapper.countGoodsByStyle(userId, customerStyle.getStyleId().intValue(), webSite);
                userGoodsStyleVo.setGoodsNum((long)i);
                list.add(userGoodsStyleVo);
            }
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
            categoryVo.setCategoryId(Long.valueOf(searchCategory.getCateValue()));
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
    public Long addCustomerStyle(Long categoryId, String goodsStyleName, Long userId) {
        Long aLong = ItemAddOrUpdateService.addCustomerStyle(categoryId, goodsStyleName, userId);
        return aLong;
    }

    /**
     * 修改自定义风格
     * @param
     * @param categoryId
     * @param goodsStyleId
     * @param goodsStyleName
     * @param userId
     */
    public Long updateCustomerStyle(Long categoryId, Long goodsStyleId, String goodsStyleName, Long userId) {
        Long aLong = ItemAddOrUpdateService.updateCustomerStyle(categoryId, goodsStyleId, goodsStyleName, userId);
        return aLong;
    }

    /**
     * 删除自定义风格
     * @param
     * @param userId
     * @param website
     * @param goodsStyleId
     */
    public void delCustomerStyle(Long goodsStyleId, Long userId, String website, Long shopId) {
        if(goodsStyleId!=null){
            ItemAddOrUpdateService.deleteCustomerStyle(goodsStyleId,userId,website,shopId);
        }
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
        for (SearchCategory searchCategory:list) {
            CategoryTabsVo categoryTabsVo = new CategoryTabsVo();
            categoryTabsVo.setCateId(searchCategory.getCateValue());
            categoryTabsVo.setCateName(searchCategory.getCateName());
            int i = goodsCountForsearchMapper.countGoodsByStyles(userId, searchCategory.getCateValue(), webSite);
            categoryTabsVo.setGoodsNum((long)i);
            categoryTabsVos.add(categoryTabsVo);
        }
        return categoryTabsVos;
    }
}
