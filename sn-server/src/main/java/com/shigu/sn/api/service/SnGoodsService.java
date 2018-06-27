package com.shigu.sn.api.service;

import com.openJar.beans.SnAuthInfo;
import com.openJar.beans.SnTokenInfo;
import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.custom.CategoryredictGetRequest;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.custom.NewbrandQueryRequest;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.item.CategoryQueryRequest;
import com.suning.api.entity.item.CategoryQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnGoodsService {
    @Autowired
    SnAuthService snAuthService;
    @Autowired
    SnSdkClient snSdkClient;

    public CategoryredictGetResponse.GetCategoryredict getCategoryredict(String username) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        CategoryredictGetRequest categoryredictGetRequest = new CategoryredictGetRequest();
        CategoryredictGetResponse response=null;
        categoryredictGetRequest.setCmTitle("");
        categoryredictGetRequest.setCategoryCode("");
        response=snSdkClient.send(categoryredictGetRequest,snTokenInfo.getAccessToken());
        return response.getSnbody().getGetCategoryredict();
    }

    public List<CategoryQueryResponse.CategoryQuery> getCategory(String username) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        CategoryQueryRequest request=new CategoryQueryRequest();
        CategoryQueryResponse response = new CategoryQueryResponse();
        response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getCategoryQueries();
    }

    public NewbrandQueryResponse.QueryNewbrand getBrand(String username,String categoryCode) throws SuningApiException{
        SnTokenInfo snTokenInfo = snAuthService.getToken(username);
        NewbrandQueryRequest request = new NewbrandQueryRequest();
        NewbrandQueryResponse response= new NewbrandQueryResponse();
        request.setCategoryCode(categoryCode);
        response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getQueryNewbrand().get(0);
    }
}
