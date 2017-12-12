package com.shigu.seller.services;

import com.opentae.data.mall.beans.SearchCategory;
import com.opentae.data.mall.examples.SearchCategoryExample;
import com.opentae.data.mall.interfaces.SearchCategoryMapper;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.seller.vo.CategoryVo;
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
    /**
     * 获取自定义风格列表
     */
    public List getStyle(){
        return null;
    }

    /**
     * 获取类目列表
     */
    public List<CategoryVo> getCategory(String website){
        SearchCategoryExample example = new SearchCategoryExample();
        example.createCriteria().andTypeEqualTo(1);
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
}
