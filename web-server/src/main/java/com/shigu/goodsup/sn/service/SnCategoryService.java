package com.shigu.goodsup.sn.service;

import com.openJar.requests.api.SnCategoryRequest;
import com.openJar.requests.api.SnCategoryredictRequest;
import com.openJar.responses.api.SnCategoryResponse;
import com.openJar.responses.api.SnCategoryredictResponse;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguTaobaocat;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
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
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguTaobaocatMapper shiguTaobaocatMapper;
    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

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

    public SnCategoryResponse getCategory(String username,Long goodsId) throws CustomException{
        SnCategoryRequest request = new SnCategoryRequest();
        request.setUsername(username);
        ShiguGoodsIdGenerator shiguGoodsIdGenerator=new ShiguGoodsIdGenerator();
        shiguGoodsIdGenerator.setGoodId(goodsId);
        shiguGoodsIdGenerator=shiguGoodsIdGeneratorMapper.selectByPrimaryKey(shiguGoodsIdGenerator);
        if(shiguGoodsIdGenerator==null){
            throw new CustomException(goodsId+" goodsId生成表没找到");
        }
        ShiguGoodsTiny shiguGoodsTiny= new ShiguGoodsTiny();
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsTiny= shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if(shiguGoodsTiny==null){
            throw new CustomException(goodsId+" goodsTiny表没找到");
        }
        ShiguTaobaocat shiguTaobaocat=new ShiguTaobaocat();
        shiguTaobaocat.setCid(shiguGoodsTiny.getCid());
        shiguTaobaocat=shiguTaobaocatMapper.selectByPrimaryKey(shiguTaobaocat);
        request.setCategoryName(shiguTaobaocat.getCname());
        SnCategoryResponse response = new SnCategoryResponse();
        try{
            response=xzJdSdkSend.send(request);
        }catch (Exception e){
            return null;
        }
        if(!response.isSuccess()){
            return null;
        }
        return response;
    }

    public SnCategoryResponse getCategory(String username){
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
        return response;
    }
}
