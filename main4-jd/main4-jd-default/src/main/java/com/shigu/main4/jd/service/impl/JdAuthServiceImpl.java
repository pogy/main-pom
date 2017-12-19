package com.shigu.main4.jd.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shigu.main4.jd.constant.JdUrlConstant;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.util.HttpClientUtil;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东授权接口
 */
@Service("jdAuthService")
public class JdAuthServiceImpl implements JdAuthService{

    private static final Logger logger = LoggerFactory.getLogger(JdAuthService.class);

    @Autowired
    private JdUtil jdUtil;


    /**
     * 获取jd登陆页面跳转地址
     * @param agentIsMobile
     * @return
     */
    @Override
    public String getAuthUrl(Boolean agentIsMobile){
        String url = JdUrlConstant.JD_AUTH_URL
                .replace("JD_APPKEY",jdUtil.getJdAppkey())
                .replace("JD_REDIRECT_URI",jdUtil.getJdRedirectUri())
                .replace("JD_STATE",jdUtil.getJdState());
        if (agentIsMobile){
            url += "view=wap";
        }
        return url;
    }

    /**
     * 获取授权信息
     * @param code
     * @return
     * @throws IOException
     */
    @Override
    public JdAuthedInfoVO getAuthedInfo(String code) throws IOException, JdUpException {
        String url = JdUrlConstant.JD_AUTH_TOKEN_URL
                        .replace("JD_APPKEY",jdUtil.getJdAppkey())
                        .replace("JD_SECRET",jdUtil.getJdSecret())
                        .replace("JD_REDIRECT_URI",jdUtil.getJdRedirectUri())
                        .replace("CODE",code)
                        .replace("JD_STATE",jdUtil.getJdState());
        HttpEntity entity = HttpClientUtil.excuteWithEntityRes(url);
        String entityString = EntityUtils.toString(entity);
        return getJdAithedInfo(entityString);
    }

    /**
     * 刷新token
     * @param refreshToken
     */
    @Override
    public JdAuthedInfoVO refreshToken(String refreshToken) throws IOException, JdUpException {
        String url = JdUrlConstant.JD_REFRESH_TOKEN_URL
                .replace("JD_APPKEY",jdUtil.getJdAppkey())
                .replace("JD_SECRET",jdUtil.getJdSecret())
                .replace("REFRESH_TOKEN",refreshToken);
        HttpEntity entity = HttpClientUtil.excuteWithEntityRes(url);
        String entityString = EntityUtils.toString(entity);
        return getJdAithedInfo(entityString);
    }

    private JdAuthedInfoVO getJdAithedInfo(String entityString) throws JdUpException {
        //注释：
        //uid：授权用户对应的京东ID
        //user_nick：授权用户对应的京东昵称
        //expires_in：失效时间（从当前时间算起，单位：秒）
        //time：授权的时间点（UNIX时间戳，单位：毫秒）
        //token_type：token类型（暂无意义）
        //access_token 获取的token
        //refresh_token 用来刷新access_tokend的刷新token
        //code 返回码
        JSONObject authedInfo = JSON.parseObject(entityString);
        int returnCode  = authedInfo.getIntValue("code");
        if (0 != returnCode) {
            String errorMsg  = authedInfo.getString("zh_desc");
            if (logger.isDebugEnabled()){
                logger.debug(String.format("授权失败"+authedInfo.toString()));
            }
            throw new JdUpException(String.valueOf(returnCode),errorMsg);
        }

        JdAuthedInfoVO jdAuthedInfoVO = new JdAuthedInfoVO();
        jdAuthedInfoVO.setAccessToken(authedInfo.getString("access_token"));
        jdAuthedInfoVO.setRefreshToken(authedInfo.getString("refresh_token"));
        jdAuthedInfoVO.setUid(authedInfo.getLong("uid"));
        jdAuthedInfoVO.setUserNick(authedInfo.getString("user_nick"));

        Integer expiresIn = authedInfo.getIntValue("expires_in");
        Long authTime = authedInfo.getLong("time");

        jdAuthedInfoVO.setAuthTime(authTime);
        jdAuthedInfoVO.setExpiresIn(expiresIn);

        return jdAuthedInfoVO;
    }
}
