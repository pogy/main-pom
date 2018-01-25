package com.shigu.goodsup.jd.service;

import com.openJar.beans.SdkJdImageUpdate;
import com.openJar.exceptions.imgs.JdUpImgException;
import com.openJar.requests.api.JdImageWriteUpdateRequest;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By admin on 2017/12/22/20:40
 */
@Service
public class JdImgService {
    @Autowired
    XzJdSdkSend xzJdSdkSend;
    @Autowired
    private JdUserInfoService jdUserInfoService;

    /**
     * 上传图片到京东图片空间
     *
     * @return
     * @throws JdUpImgException
     */
    public JdUpImgResponse addImgs(Long jdUid, List<String> imgUrls, Long imgCategoryId) throws AuthOverException, CustomException {
        JdUpImgRequest request = new JdUpImgRequest();
        request.setJdUid(jdUid);
        request.setImgUrls(imgUrls);
        request.setPictureCateId(imgCategoryId);
        JdUpImgResponse response = xzJdSdkSend.send(request);
        if (!"1".equals(response.getReturnCode())) {
            response.setSuccess(false);
        }
        return response;
    }

    /**
     * 绑定图片到商品
     */
    public Boolean bindGoodsImgs(SdkJdImageUpdate bo, Long jdUid) throws AuthOverException{
//        String jdUid = jdUserInfoService.getJdUidBySubUid(subUid);
        JdImageWriteUpdateRequest jdImageWriteUpdateRequest = new JdImageWriteUpdateRequest();
        jdImageWriteUpdateRequest.setBo(bo);
        jdImageWriteUpdateRequest.setJdUid(jdUid);
        try {
            return xzJdSdkSend.send(jdImageWriteUpdateRequest).isSuccess();
        } catch (CustomException e) {
            return false;
        }
    }
}
