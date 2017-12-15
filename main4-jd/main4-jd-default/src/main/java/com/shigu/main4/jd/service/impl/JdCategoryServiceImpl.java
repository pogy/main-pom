package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.category.Category;
import com.jd.open.api.sdk.domain.list.CategoryAttrReadService.CategoryAttrJos;
import com.jd.open.api.sdk.domain.sellercat.ShopCategory;
import com.jd.open.api.sdk.request.category.CategorySearchRequest;
import com.jd.open.api.sdk.request.list.CategoryReadFindAttrsByCategoryIdJosRequest;
import com.jd.open.api.sdk.request.sellercat.SellerCatsGetRequest;
import com.jd.open.api.sdk.response.category.CategorySearchResponse;
import com.jd.open.api.sdk.response.list.CategoryReadFindAttrsByCategoryIdJosResponse;
import com.jd.open.api.sdk.response.sellercat.SellerCatsGetResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.CategoryAttrJosVO;
import com.shigu.main4.jd.vo.JdCategoryVO;
import com.shigu.main4.jd.vo.ShopCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public List<ShopCategoryVO> getJdSellercats(String accessToken) throws JdUpException {
        SellerCatsGetRequest request = new SellerCatsGetRequest();
        SellerCatsGetResponse response;
        response = jdUtil.execute(request,accessToken);
        List<ShopCategory> shopCatList = response.getShopCatList();
        return BeanMapper.mapList(shopCatList,ShopCategoryVO.class);
    }

    /**
     * 京东 获取类目属性列表
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    @Override
    public List<CategoryAttrJosVO> getJdCategoryAttrJos(String accessToken) throws JdUpException {
        CategoryReadFindAttrsByCategoryIdJosRequest request = new CategoryReadFindAttrsByCategoryIdJosRequest();
        CategoryReadFindAttrsByCategoryIdJosResponse response;
        response = jdUtil.execute(request,accessToken);
        List<CategoryAttrJos> shopCatList = response.getCategoryAttrs();
        return BeanMapper.mapList(shopCatList,CategoryAttrJosVO.class);
    }

    /**
     * 商家类目信息
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

}
