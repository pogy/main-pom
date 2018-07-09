package com.shigu.sn.api.service;

import com.openJar.beans.SnAuthInfo;
import com.openJar.beans.SnGood;
import com.openJar.beans.SnTokenInfo;
import com.opentae.data.beans.SnShopCategory;
import com.opentae.data.examples.SnShopCategoryExample;
import com.opentae.data.interfaces.SnShopCategoryMapper;
import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.custom.CategoryredictGetRequest;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.custom.NewbrandQueryRequest;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.integrate.itemContentsAddResponse;
import com.suning.api.entity.item.*;
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

    public String getCategorySize(String username) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        CategoryQueryRequest request=new CategoryQueryRequest();
        request.setPageNo(1);
        request.setPageSize(10);
        CategoryQueryResponse response = new CategoryQueryResponse();
        response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnhead().getTotalSize();
    }

    /**
     * 类目查询
     * @param username
     * @return
     * @throws SuningApiException
     */
    public List<CategoryQueryResponse.CategoryQuery> getCategory(String username,String categoryName) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        CategoryQueryRequest request=new CategoryQueryRequest();
        request.setCategoryName(categoryName);
        request.setPageNo(1);
        request.setPageSize(10);
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
    public List<NewbrandQueryResponse.QueryNewbrand> getBrand(String username,String categoryCode) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        NewbrandQueryRequest request = new NewbrandQueryRequest();
        NewbrandQueryResponse response= new NewbrandQueryResponse();
        request.setCategoryCode(categoryCode);
        request.setPageSize(10);
        request.setPageNo(1);
        response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getQueryNewbrand();
    }

    /**
     * 获取苏宁店铺类目
     * @param username
     * @return
     * @throws SuningApiException
     */
    public List<com.openJar.beans.SnShopCategory> selSnCats(String username) throws SuningApiException{
        SnShopCategoryExample snShopCategoryExample=new SnShopCategoryExample();
        snShopCategoryExample.createCriteria().andUsernameEqualTo(username);
        List<SnShopCategory> snShopCategories= snShopCategoryMapper.selectByExample(snShopCategoryExample);
        List<com.openJar.beans.SnShopCategory> list=new ArrayList<>();
        if(snShopCategories==null||snShopCategories.isEmpty()){
            snShopCategories=addShopCategory(username);
            if(snShopCategories==null){
                return null;
            }
            return listTolist(snShopCategories);
        }else{
            return listTolist(snShopCategories);
        }
    }

    public List<com.openJar.beans.SnShopCategory> listTolist(List<SnShopCategory> list){
        List<com.openJar.beans.SnShopCategory> snShopCategories=new ArrayList<>();
        for (SnShopCategory sn:list) {
            com.openJar.beans.SnShopCategory snShopCategory= new com.openJar.beans.SnShopCategory();
            snShopCategory.setCategoryCode(sn.getCategoryCode());
            snShopCategory.setCategoryImg(sn.getCategoryImg());
            snShopCategory.setCategoryName(sn.getCategoryName());
            snShopCategory.setCategorySet(sn.getCategorySet());
            snShopCategory.setCategorySort(sn.getCategorySort());
            snShopCategory.setFirstId(sn.getFirstId());
            snShopCategory.setGmtCreat(sn.getGmtCreat());
            snShopCategory.setGmtModif(sn.getGmtModif());
            snShopCategory.setId(sn.getId());
            snShopCategory.setIsFirst(sn.getIsFirst());
            snShopCategory.setUsername(sn.getUsername());
            snShopCategories.add(snShopCategory);
        }
        return snShopCategories;
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
        shopcategoryQueryRequest.setPageNo(1);
        shopcategoryQueryRequest.setPageSize(10);
        ShopcategoryQueryResponse shopcategoryQueryResponse=snSdkClient.send(shopcategoryQueryRequest,snTokenInfo.getAccessToken());
        if(shopcategoryQueryResponse.getSnerror().getErrorCode().equals("biz.handler.data-get:no-result")){
            return null;
        }
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

    /**
     * 上传一件商品
     * @param username
     * @param snGood
     * @return
     * @throws SuningApiException
     */
    public ApplyParams getItemAdd(String username, SnGood snGood) throws SuningApiException{
        SnTokenInfo snTokenInfo=snAuthService.getToken(username);
        ItemAddRequest request=new ItemAddRequest();
        request.setAfterSaleServiceDec(snGood.getAfterSaleServiceDec());
        request.setAlertQty(snGood.getAlertQty());
        request.setAssortCode(snGood.getAssortCode());
        request.setAutoRefund(snGood.getAutoRefund());
        request.setBarpic(snGood.getBarpic());
        request.setBookingShop(snGood.getBookingShop());
        request.setCategoryCode(snGood.getCategoryCode());
        request.setBrandCode(snGood.getBrandCode());
        request.setCmTitle(snGood.getCmTitle());
        request.setDeductiblePrice(snGood.getDeductiblePrice());
        request.setEffectiveDay(snGood.getEffectiveDay());
        request.setFreightTemplateId(snGood.getFreightTemplateId());
        request.setExtractMode(snGood.getExtractMode());
        request.setInsaleRefund(snGood.getInsaleRefund());
        request.setIntroduction(snGood.getIntroduction());
        request.setItemCode(snGood.getItemCode());
        request.setPayTemplate(snGood.getPayTemplate());
        request.setPrice(snGood.getPrice());
        request.setPriceType(snGood.getPriceType());
        request.setProductName(snGood.getProductName());
        request.setSaleDate(snGood.getSaleDate());
        request.setSaleSet(snGood.getSaleSet());
        request.setSellChannel(snGood.getSellChannel());
        request.setSellPoint(snGood.getSellPoint());
        request.setVerticalPic(snGood.getVerticalPic());
        request.setWriteoffPayment(snGood.getWirteoffPayment());
        request.setWriteoffShop(snGood.getWirteoffShop());
        ItemAddResponse response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getApplyParams();
    }

    /**
     * 获取苏宁商品参数模板
     * @param username
     * @param categoryCode
     * @return
     * @throws SuningApiException
     */
    public List<ItemparametersQueryResponse.ItemparametersQuery> getItem(String username,String categoryCode) throws SuningApiException{
        SnTokenInfo snTokenInfo=snAuthService.getToken(username);
        ItemparametersQueryRequest request=new ItemparametersQueryRequest();
        request.setCategoryCode(categoryCode);
        request.setPageNo(1);
        request.setPageSize(50);
        ItemparametersQueryResponse response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getItemparametersQueries();
    }
}
