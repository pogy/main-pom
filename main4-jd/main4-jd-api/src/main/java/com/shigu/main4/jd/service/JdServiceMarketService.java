package com.shigu.main4.jd.service;

import com.shigu.main4.jd.exceptions.JdApiException;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.vo.JdVasSubscribeVO;

import java.io.IOException;

/**
 * Created By admin on 2017/12/14/16:51
 * 京东服务市场service
 */
public interface JdServiceMarketService {

    /**
     * 订购关系查询（根据购买用户名和收费项目代码获取订购关系时长）
     * @param userName
     * @param itemCode
     * @param jdUid
     */
    JdVasSubscribeVO subscribe(String userName, String itemCode,Long jdUid) throws JdAuthFailureException, JdApiException;

    /**
     * 保存用户订购信息
     * @param vo
     * @return
     * @throws IOException
     * @throws JdAuthFailureException
     */
    void saveSubscribe(JdVasSubscribeVO vo) throws JdAuthFailureException;

}
