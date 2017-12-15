package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.ware.WareAddRequest;
import com.jd.open.api.sdk.response.ware.WareAddResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.bo.JdUpBO;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdGoodsService;
import com.shigu.main4.jd.util.JdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created By admin on 2017/12/14/16:45
 * 京东商品接口
 */
@Service("jdGoodsService")
public class JdGoodsServiceImpl implements JdGoodsService{

    @Autowired
    private JdUtil jdUtil;


    /**
     * 商品一键上传到京东
     * @param bo
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    @Override
    public void upToJd(JdUpBO bo, String accessToken) throws JdUpException {
        WareAddRequest request = BeanMapper.map(bo, WareAddRequest.class);
        request.setWarePackType("1");//普通商品
        WareAddResponse response;
        jdUtil.execute(request,accessToken);
    }
}
