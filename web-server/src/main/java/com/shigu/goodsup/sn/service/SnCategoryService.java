package com.shigu.goodsup.sn.service;

import com.openJar.requests.api.SnCategoryRequest;
import com.openJar.requests.api.SnCategoryredictRequest;
import com.openJar.responses.api.SnCategoryResponse;
import com.openJar.responses.api.SnCategoryredictResponse;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.item.CategoryQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnCategoryService {
    @Autowired
    XzJdSdkSend xzJdSdkSend;

    public List<CategoryredictGetResponse.CategoryList> getCategoryredict(String username){
        SnCategoryredictRequest snCategoryredictRequest = new SnCategoryredictRequest();
        snCategoryredictRequest.setUsername(username);
        SnCategoryredictResponse snCategoryredictResponse= null;
        try{
            snCategoryredictResponse=xzJdSdkSend.send(snCategoryredictRequest);
        }catch (Exception e){
            return null;
        }
        if(!snCategoryredictResponse.isSuccess()){
            return null;
        }
        return snCategoryredictResponse.getGetCategoryredict().getCategoryList();
    }

    public List<CategoryQueryResponse.CategoryQuery> getCategory(String username){
        SnCategoryRequest request = new SnCategoryRequest();
        request.setUsername(username);
        SnCategoryResponse response = new SnCategoryResponse();
        try{
            response=xzJdSdkSend.send(request);
        }catch (Exception e){
            return null;
        }
        if(!response.isSuccess()){
            return null;
        }
        return response.getCategoryQueryList();
    }
}
