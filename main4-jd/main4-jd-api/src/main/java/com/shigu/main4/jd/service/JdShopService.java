package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdShopInfoVO;

import java.io.IOException;

/**
 * Created By admin on 2017/12/14/16:54
 * 京东店铺Service
 */
public interface JdShopService {

    /**
     * 京东店铺信息查询
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    JdShopInfoVO getJdShopInfo(String accessToken) throws JdUpException;

}
