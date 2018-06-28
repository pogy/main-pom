package com.shigu.sn.api.service;

import com.openJar.beans.SnAuthInfo;
import com.openJar.beans.SnTokenInfo;
import com.opentae.data.beans.SnShopCategory;
import com.opentae.data.examples.SnShopCategoryExample;
import com.opentae.data.interfaces.SnShopCategoryMapper;
import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.custom.CategoryredictGetRequest;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.custom.NewbrandQueryRequest;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.item.CategoryQueryRequest;
import com.suning.api.entity.item.CategoryQueryResponse;
import com.suning.api.entity.shop.ShopcategoryQueryRequest;
import com.suning.api.entity.shop.ShopcategoryQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnGoodsService {
    @Autowired
    SnAuthService snAuthService;
    @Autowired
    SnSdkClient snSdkClient;
    @Autowired
    SnShopCategoryMapper snShopCategoryMapper;

    /**
     * 类目预测信息
     * @param username
     * @return
     * @throws SuningApiException
     */
    public CategoryredictGetResponse.GetCategoryredict getCategoryredict(String username) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        CategoryredictGetRequest categoryredictGetRequest = new CategoryredictGetRequest();
        CategoryredictGetResponse response=new CategoryredictGetResponse();
        categoryredictGetRequest.setCmTitle("");
        categoryredictGetRequest.setCategoryCode("");
        response=snSdkClient.send(categoryredictGetRequest,snTokenInfo.getAccessToken());
        return response.getSnbody().getGetCategoryredict();
    }

    /**
     * 类目查询
     * @param username
     * @return
     * @throws SuningApiException
     */
    public List<CategoryQueryResponse.CategoryQuery> getCategory(String username) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        CategoryQueryRequest request=new CategoryQueryRequest();
        CategoryQueryResponse response = new CategoryQueryResponse();
        response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getCategoryQueries();
    }

    /**
     * 类目品牌
     * @param username
     * @param categoryCode
     * @return
     * @throws SuningApiException
     */
    public NewbrandQueryResponse.QueryNewbrand getBrand(String username,String categoryCode) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        NewbrandQueryRequest request = new NewbrandQueryRequest();
        NewbrandQueryResponse response= new NewbrandQueryResponse();
        request.setCategoryCode(categoryCode);
        response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getQueryNewbrand().get(0);
    }

    /**
     * 获取苏宁店铺类目
     * @param username
     * @return
     * @throws SuningApiException
     */
    public List<SnShopCategory> selSnCats(String username) throws SuningApiException{
        SnShopCategoryExample snShopCategoryExample=new SnShopCategoryExample();
        snShopCategoryExample.createCriteria().andUsernameEqualTo(username);
        List<SnShopCategory> snShopCategories= snShopCategoryMapper.selectByExample(snShopCategoryExample);
        if(snShopCategories==null||snShopCategories.isEmpty()){
            snShopCategories=addShopCategory(username);
            return snShopCategories;
        }else{
            return snShopCategories;
        }
    }

    /**
     * 更新店铺类目
     * @param username
     * @return
     * @throws SuningApiException
     */
    public List<SnShopCategory> updateCats(String username) throws SuningApiException{
        SnShopCategoryExample snShopCategoryExample=new SnShopCategoryExample();
        snShopCategoryExample.createCriteria().andUsernameEqualTo(username);
        snShopCategoryMapper.deleteByExample(snShopCategoryExample);
        return addShopCategory(username);
    }

    public List<SnShopCategory> addShopCategory(String username) throws SuningApiException{
        SnTokenInfo snTokenInfo=snAuthService.getToken(username);
        ShopcategoryQueryRequest shopcategoryQueryRequest=new ShopcategoryQueryRequest();
        ShopcategoryQueryResponse shopcategoryQueryResponse=snSdkClient.send(shopcategoryQueryRequest,snTokenInfo.getAccessToken());
        List<ShopcategoryQueryResponse.ShopCategory> shopCategories=shopcategoryQueryResponse.getSnbody().getShopCategory();
        List<SnShopCategory> snShopCategories=new ArrayList<>();
        for (ShopcategoryQueryResponse.ShopCategory s:shopCategories){
            SnShopCategory snShopCategory=new SnShopCategory();
            snShopCategory.setCategoryCode(s.getFirstCategoryCode());
            snShopCategory.setCategoryImg(s.getFirstCategoryImg());
            snShopCategory.setCategoryName(s.getFirstCategoryName());
            snShopCategory.setCategorySet(Integer.valueOf(s.getCategorySet()));
            snShopCategory.setCategorySort(Integer.valueOf(s.getFirstCategorySort()));
            snShopCategory.setUsername(username);
            snShopCategory.setIsFirst(1);
            snShopCategoryMapper.insert(snShopCategory);
            for(ShopcategoryQueryResponse.SecondCategory secondCategory:s.getSecondCategory()){
                SnShopCategory snShopCategory2=new SnShopCategory();
                snShopCategory2.setIsFirst(0);
                snShopCategory2.setUsername(username);
                snShopCategory2.setFirstId(snShopCategory.getId());
                snShopCategory2.setCategorySort(Integer.valueOf(secondCategory.getSecondCategorySort()));
                snShopCategory2.setCategoryName(secondCategory.getSecondCategoryName());
                snShopCategory2.setCategoryImg(secondCategory.getSecondCategoryImg());
                snShopCategory2.setCategoryCode(secondCategory.getSecondCategoryCode());
                snShopCategories.add(snShopCategory2);
            }
        }
        snShopCategoryMapper.insertListNoId(snShopCategories);
        return snShopCategories;
    }
}
