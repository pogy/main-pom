package com.shigu.phone.waps.service;

import com.openJar.exceptions.OpenException;
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
public class WapPhoneGoodsUpService {

    @Autowired
    private BasePhoneGoodsUpService basePhoneGoodsUpService;

    public void upToWx(String webSite,Long goodsId,Long userId) throws OpenException {
        basePhoneGoodsUpService.upToWx(webSite,goodsId,userId);
    }

    public UploadedItemVO uploadedItem(Integer type,Integer index,Integer size,Long userId) {
        return basePhoneGoodsUpService.uploadedItem(type, index, size, userId);
    }

    public void instockMyItem(String goodsId,Long userId) throws OpenException {
        basePhoneGoodsUpService.instockMyItem(Long.valueOf(goodsId), userId);
    }
}
