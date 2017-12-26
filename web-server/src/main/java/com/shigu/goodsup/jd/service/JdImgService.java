package com.shigu.goodsup.jd.service;

import com.openJar.exceptions.imgs.JdUpImgException;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.openJar.tools.OpenClient;
import com.shigu.goodsup.jd.exceptions.JdNotBindException;
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
    
    @Autowired
    private JdUserInfoService jdUserInfoService;

    /**
     *上传图片到京东图片空间
     * @param subUid
     * @param imgUrls
     * @return
     * @throws JdUpImgException
     */
    public JdUpImgResponse addImgs(Long subUid, List<String> imgUrls) throws JdUpImgException, JdNotBindException {
        if(imgUrls == null || imgUrls.isEmpty()){
            return null;
        }
        String jdUid = jdUserInfoService.getJdUidBySubUid(subUid);
        JdUpImgRequest request = new JdUpImgRequest();
        request.setJdUid(Long.valueOf(jdUid));
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
    public Boolean bindGoodsImgs(JdImageUpdateBO bo,Long subUid) throws JdUpException, JdNotBindException {
        String jdUid = jdUserInfoService.getJdUidBySubUid(subUid);
       return jdGoodsService.jdImageUpdate(bo, Long.valueOf(jdUid));
    }
}
