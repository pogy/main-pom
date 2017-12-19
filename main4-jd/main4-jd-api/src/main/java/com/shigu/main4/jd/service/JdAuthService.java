package com.shigu.main4.jd.service;

import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;

import java.io.IOException;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东授权接口
 */
public interface JdAuthService {

    /**
     * 获取jd登陆页面跳转地址
     * @param agentIsMobile 是否时手机登陆
     * @return
     */
    String getAuthUrl(Boolean agentIsMobile);

    /**
     * 获取授权信息
     * @param code
     * @return
     * @throws IOException
     */
    JdAuthedInfoVO getAuthedInfo(String code) throws IOException, JdUpException;

    /**
     * 刷新token
     * @param refreshToken
     */
    JdAuthedInfoVO refreshToken(String refreshToken) throws IOException, JdUpException;
}
