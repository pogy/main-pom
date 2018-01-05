package com.shigu.goodsup.jd.service;

import com.openJar.exceptions.imgs.JdUpImgException;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.openJar.tools.OpenClient;
import com.shigu.goodsup.jd.exceptions.JdNotBindException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.exceptions.ImgZoneException;
import com.shigu.main4.jd.exceptions.JdApiException;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.service.JdGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By admin on 2017/12/22/20:40
 */
@Service
public class JdImgService {

    @Autowired
    private OpenClientService openClientService;

    @Autowired
    private JdGoodsService jdGoodsService;
    
    @Autowired
    private JdUserInfoService jdUserInfoService;

    /**
     *上传图片到京东图片空间
     * @return
     * @throws JdUpImgException
     */
    public JdUpImgResponse addImgs(Long jdUid,List<String> imgUrls,Long imgCategoryId) throws ImgZoneException {
        OpenClient openClient = openClientService.getOpenClient();
        JdUpImgRequest request = new JdUpImgRequest();
        request.setJdUid(jdUid);
        request.setImgUrls(imgUrls);
        request.setPictureCateId(imgCategoryId);
        JdUpImgResponse response = openClient.execute(request);
        if(!"1".equals(response.getReturnCode())){
            throw new ImgZoneException(response.getDesc());
        }
        return response;
    }

    /**
     * 绑定图片到商品
     */
    public Boolean bindGoodsImgs(JdImageUpdateBO bo,Long jdUid) throws JdNotBindException, JdAuthFailureException, JdApiException {
//        String jdUid = jdUserInfoService.getJdUidBySubUid(subUid);
       return jdGoodsService.jdImageUpdate(bo, Long.valueOf(jdUid));
    }
}
