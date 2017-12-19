package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.category.Category;
import com.jd.open.api.sdk.domain.list.CategoryAttrReadService.CategoryAttrJos;
import com.jd.open.api.sdk.domain.list.CategoryReadService.Feature;
import com.jd.open.api.sdk.domain.sellercat.ShopCategory;
import com.jd.open.api.sdk.request.category.CategorySearchRequest;
import com.jd.open.api.sdk.request.list.CategoryReadFindAttrsByCategoryIdJosRequest;
import com.jd.open.api.sdk.request.list.CategoryReadFindByPIdRequest;
import com.jd.open.api.sdk.request.sellercat.SellerCatsGetRequest;
import com.jd.open.api.sdk.response.category.CategorySearchResponse;
import com.jd.open.api.sdk.response.list.CategoryReadFindAttrsByCategoryIdJosResponse;
import com.jd.open.api.sdk.response.list.CategoryReadFindByPIdResponse;
import com.jd.open.api.sdk.response.market.MarketServiceCategoryListGetResponse;
import com.jd.open.api.sdk.response.sellercat.SellerCatsGetResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东类目接口
 */
@Service("jdCategoryService")
public class JdCategoryServiceImpl implements  JdCategoryService {

    @Autowired
    private JdUtil jdUtil;


    /**
     * 京东自定义店内分类
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    @Override
    public List<JdShopCategoryVO> getJdSellercats(String accessToken) throws JdUpException {
        SellerCatsGetRequest request = new SellerCatsGetRequest();
        SellerCatsGetResponse response = jdUtil.execute(request,accessToken);
        List<ShopCategory> shopCatList = response.getShopCatList();
        return BeanMapper.mapList(shopCatList,JdShopCategoryVO.class);
    }

    /**
     * 京东 获取类目属性列表
     * 属性类型:1.关键属性 2.不变属性 3.可变属性 4.销售属性
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    @Override
    public List<JdCategoryAttrJosVO> getJdCategoryAttrJos(String accessToken) throws JdUpException {
        CategoryReadFindAttrsByCategoryIdJosRequest request = new CategoryReadFindAttrsByCategoryIdJosRequest();
        CategoryReadFindAttrsByCategoryIdJosResponse response = jdUtil.execute(request,accessToken);
        List<CategoryAttrJos> shopCatList = response.getCategoryAttrs();
        return BeanMapper.mapList(shopCatList,JdCategoryAttrJosVO.class);
    }

    /**
     * 获取商家类目信息
     * @param accessToken
     * @return
     * @throws JdUpException
     */
    @Override
    public List<JdCategoryVO> getJdWarecats(String accessToken) throws JdUpException {
        CategorySearchRequest request=new CategorySearchRequest();
        CategorySearchResponse response = jdUtil.execute(request,accessToken);
        List<Category> categorys = response.getCategory();
        List<JdCategoryVO> jdCategoryVOS = new ArrayList<>();
        for (Category item : categorys){
            JdCategoryVO vo = new JdCategoryVO();
            vo.setFid(item.getFid());
            vo.setId(item.getId());
            vo.setIndexId(item.getIndexId());
            vo.setLev(item.getLev());
            vo.setName(item.getName());
            vo.setStatus(item.getStatus());
            vo.setParent(item.isParent());
            jdCategoryVOS.add(vo);
        }
        return jdCategoryVOS;
    }

    /**
     * 根据父级类目Id获取子集类目信息
     * @param accessToken
     *  @param pid 父类目id
     * @return
     * @throws JdUpException
     */
    @Override
    public List<JdCategoryReadVO> getJdCategoryByPid(String accessToken,Long pid) throws JdUpException {
        CategoryReadFindByPIdRequest request = new CategoryReadFindByPIdRequest();
        request.setParentCid(pid);
        CategoryReadFindByPIdResponse response = jdUtil.execute(request,accessToken);
        List<com.jd.open.api.sdk.domain.list.CategoryReadService.Category> categories = response.getCategories();
        List<JdCategoryReadVO> jdCategoryReadVOS = new ArrayList<>();
        for(com.jd.open.api.sdk.domain.list.CategoryReadService.Category item : categories){
            JdCategoryReadVO vo = new JdCategoryReadVO();
            vo.setFid(item.getFid());
            vo.setId(item.getId());
            vo.setLev(item.getLev());
            vo.setName(item.getName());
            Set<JdFeature> jdFeatures = new HashSet<>();
            for (Feature futureItem : item.getFeatures()){
                JdFeature jdFeature = new JdFeature();
                jdFeature.setFeatureCn(futureItem.getFeatureCn());
                jdFeature.setFeatureKey(futureItem.getFeatureKey());
                jdFeature.setFeatureValue(futureItem.getFeatureValue());
                jdFeatures.add(jdFeature);
            }
            vo.setFeatures(jdFeatures);
            jdCategoryReadVOS.add(vo);
        }
        return jdCategoryReadVOS;
    }

}
