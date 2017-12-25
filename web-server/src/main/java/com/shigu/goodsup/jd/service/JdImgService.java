package com.shigu.goodsup.jd.service;

import com.openJar.exceptions.imgs.JdUpImgException;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.openJar.tools.OpenClient;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.exceptions.JdUpException;
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

    /**
     *上传图片到京东图片空间
     * @param userId
     * @param imgUrls
     * @return
     * @throws JdUpImgException
     */
    public JdUpImgResponse addImgs(Long userId, List<String> imgUrls) throws JdUpImgException {
        if(imgUrls == null || imgUrls.isEmpty()){
            return null;
        }
        JdUpImgRequest request = new JdUpImgRequest();
        request.setUserId(userId);
        request.setImgUrls(imgUrls);
        OpenClient openClient = openClientService.getOpenClient();
        JdUpImgResponse response = openClient.execute(request);
        if(!"1".equals(response.getReturnCode())){
            throw new JdUpImgException(String.valueOf(response.getReturnCode()),response.getDesc());
        }
        return response;
    }

    /**
     * 绑定图片到商品
     */
    public Boolean bindGoodsImgs(JdImageUpdateBO bo,Long userId) throws JdUpException {
       return jdGoodsService.jdImageUpdate(bo, userId);
    }
}
