package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.response.market.VasSubscribeGetResponse;
import com.shigu.main4.jd.exceptions.JdUpException;

/**
 * Created By admin on 2017/12/14/16:51
 * 京东服务市场service
 */
public interface JdServiceMarketService {

    /**
     * 订购关系查询（根据购买用户名和收费项目代码获取订购关系时长）
     * @param userName
     * @param itemCode
     * @param accessToken
     */
    VasSubscribeGetResponse subscribe(String userName, String itemCode, String accessToken) throws  JdUpException;

}
