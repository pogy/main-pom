package com.shigu.phone.apps.services;

import com.openJar.exceptions.OpenException;
import com.openJar.requests.app.InstockMyItemRequest;
import com.openJar.requests.app.UpToWxRequest;
import com.openJar.requests.app.UploadedItemRequest;
import com.openJar.responses.app.InstockMyItemResponse;
import com.openJar.responses.app.UpToWxResponse;
import com.openJar.responses.app.UploadedItemResponse;
import com.shigu.phone.baseservices.BasePhoneGoodsUpService;
import com.shigu.phone.basevo.UploadedItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名：PhoneGoodsUpService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneGoodsUpService
 * 创建者：王浩翔
 * 创建时间：2017-08-30 9:22
 * 项目：main-pom
 * 描述：移动端商品上传
 */

@Service
public class PhoneGoodsUpService {

    @Autowired
    private BasePhoneGoodsUpService basePhoneGoodsUpService;

    public UpToWxResponse upToWx(UpToWxRequest request) {
        UpToWxResponse resp = new UpToWxResponse();
        try {
            basePhoneGoodsUpService.upToWx(request.getWebSite(),request.getGoodsId(),request.getUserId());
            resp.setSuccess(true);
            return resp;
        } catch (OpenException e) {
            OpenException openException = new OpenException();
            openException.setErrMsg(e.getErrMsg());
            resp.setSuccess(false);
            resp.setException(openException);
            return resp;
        }
    }

    public UploadedItemResponse uploadedItem(UploadedItemRequest request) {
        UploadedItemVO uploadedItemVO = basePhoneGoodsUpService.uploadedItem(request.getType(), request.getIndex(), request.getSize(), request.getUserId());
        UploadedItemResponse res=new UploadedItemResponse();
        res.setTotal(uploadedItemVO.getTotal());
        res.setHasNext(uploadedItemVO.getHasNext());
        res.setItems(uploadedItemVO.getItems());
        res.setSuccess(true);
        return res;
    }

    public InstockMyItemResponse instockMyItem(InstockMyItemRequest request) {
        InstockMyItemResponse res=new InstockMyItemResponse();
        try {
            basePhoneGoodsUpService.instockMyItem(request.getUploadId(), request.getUserId());
            res.setSuccess(true);
        } catch (OpenException e) {
           res.setException(e);
           res.setSuccess(false);
        }
        return res;
    }
}
