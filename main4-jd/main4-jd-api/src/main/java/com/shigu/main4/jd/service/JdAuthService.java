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
     * 获取授权信息,并记录（更新）数据到库
     * @param code
     * @return
     * @throws IOException
     */
    JdAuthedInfoVO getAuthedInfo(String code) throws IOException, JdUpException;

    /**
     * 根据星座网用户Id获取授权信息
     * @param userId
     * @return
     * @throws IOException
     */
    JdAuthedInfoVO getAuthedInfo(Long userId) ;


    /**
     * 刷新token
     * @param refreshToken
     */
    JdAuthedInfoVO refreshToken(String refreshToken) throws IOException, JdUpException;

    /**
     * 给授权信息绑定xz网用户ID
     * @param xzUid
     * @param jdUid
     */
    void bindXzUid(Long xzUid, Long jdUid);
}
