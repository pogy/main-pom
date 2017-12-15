package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.bo.JdUpBO;
import com.shigu.main4.jd.exceptions.JdUpException;

import java.io.IOException;

/**
 * Created By admin on 2017/12/14/16:45
 * 京东商品接口
 */
public interface JdGoodsService {

    /**
     * 商品一键上传到京东
     * @param bo
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
     void upToJd(JdUpBO bo, String accessToken) throws JdUpException;
}
