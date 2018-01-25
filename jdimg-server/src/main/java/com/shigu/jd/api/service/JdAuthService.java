package com.shigu.jd.api.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.openJar.beans.JdAuthedInfo;
import com.openJar.responses.api.JdAuthedInfoResponse;
import com.opentae.data.jd.beans.JdSessionMap;
import com.opentae.data.jd.interfaces.JdSessionMapMapper;
import com.shigu.jd.api.constant.JdUrlConstant;
import com.shigu.jd.api.utils.JdKeyConfig;
import com.shigu.jd.tools.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东授权接口
 */
@Service
public class JdAuthService {

    @Autowired
    private JdClientService jdClientService;

    @Autowired
    private JdSessionMapMapper jdSessionMapMapper;

    /**
     * 获取jd登陆页面跳转地址
     * @param agentIsMobile
     * @return
     */
    public String getAuthUrl(Boolean agentIsMobile){
        String url = JdUrlConstant.JD_AUTH_URL
                .replace("JD_APPKEY",JdKeyConfig.jdAppkey)
                .replace("JD_REDIRECT_URI",JdKeyConfig.jdRedirectUri)
                .replace("JD_STATE",JdKeyConfig.jdState);
        if (agentIsMobile){
            url += "view=wap";
        }
        return url;
    }

    /**
     * 获取授权信息，并记录（更新）数据到库
     * @param code
     * @return
     * @throws IOException
     */
    public JdAuthedInfo getAuthedInfo(String code) {
        String url = JdUrlConstant.JD_AUTH_TOKEN_URL
                        .replace("JD_APPKEY", JdKeyConfig.jdAppkey)
                        .replace("JD_SECRET",JdKeyConfig.jdSecret)
                        .replace("JD_REDIRECT_URI",JdKeyConfig.jdRedirectUri)
                        .replace("CODE",code)
                        .replace("JD_STATE",JdKeyConfig.jdState);
        String entityString = null;
        try {
            HttpEntity entity = HttpClientUtil.excuteWithEntityRes(url);
            entityString = EntityUtils.toString(entity);
        } catch (IOException e) {
            return null;
        }
        JdAuthedInfo jdAithedInfo = getJdAithedInfo(entityString);

        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setJdUid(jdAithedInfo.getUid());
        Date now = new Date();
        JdSessionMap selJdSessionMap = jdSessionMapMapper.selectOne(jdSessionMap);
        if (selJdSessionMap == null) {
            jdSessionMap.setJdUserNick(jdAithedInfo.getUserNick());
            jdSessionMap.setAccessToken(jdAithedInfo.getAccessToken());
            jdSessionMap.setRefreshToken(jdAithedInfo.getRefreshToken());
            jdSessionMap.setAuthTime(new Date(jdAithedInfo.getAuthTime()));
            jdSessionMap.setExpiresIn(jdAithedInfo.getExpiresIn());
            jdSessionMap.setGmtCreate(now);
            jdSessionMap.setGmtModify(now);
            jdSessionMapMapper.insertSelective(jdSessionMap);
        }else{
            jdSessionMap.setId(selJdSessionMap.getId());
            jdSessionMap.setJdUserNick(jdAithedInfo.getUserNick());
            jdSessionMap.setAccessToken(jdAithedInfo.getAccessToken());
            jdSessionMap.setRefreshToken(jdAithedInfo.getRefreshToken());
            jdSessionMap.setAuthTime(new Date(jdAithedInfo.getAuthTime()));
            jdSessionMap.setExpiresIn(jdAithedInfo.getExpiresIn());
            jdSessionMapMapper.updateByPrimaryKeySelective(jdSessionMap);
        }
        return jdAithedInfo;
    }

    public JdAuthedInfo getAuthedInfo(Long jdUid) {
        JdAuthedInfo info=new JdAuthedInfo();
        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setJdUid(jdUid);
        JdSessionMap selJdSessionMap = jdSessionMapMapper.selectOne(jdSessionMap);
        if (selJdSessionMap == null) {
            return null;
        }

        //校验token有效性，少于一小时视为无效
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selJdSessionMap.getAuthTime());
        calendar.add(Calendar.SECOND,selJdSessionMap.getExpiresIn());
        calendar.add(Calendar.HOUR_OF_DAY,-1);

        if(calendar.getTime().before(new Date())){
            //刷新授权信息'
           return refreshToken(selJdSessionMap.getId(),selJdSessionMap.getRefreshToken());
        }
        info.setUid(selJdSessionMap.getJdUid());
        info.setAccessToken(selJdSessionMap.getAccessToken());
        info.setRefreshToken(selJdSessionMap.getRefreshToken());
        info.setUserNick(selJdSessionMap.getJdUserNick());
        info.setAuthTime(selJdSessionMap.getAuthTime().getTime());
        info.setExpiresIn(selJdSessionMap.getExpiresIn());
        return info;
    }

    /**
     * 刷新token
     * @param id
     * @param refreshToken
     */
    public JdAuthedInfo refreshToken(Long id,String refreshToken) {
        String url = JdUrlConstant.JD_REFRESH_TOKEN_URL
                .replace("JD_APPKEY",JdKeyConfig.jdAppkey)
                .replace("JD_SECRET",JdKeyConfig.jdSecret)
                .replace("REFRESH_TOKEN",refreshToken);
        String entityString = null;
        try {
            HttpEntity entity = HttpClientUtil.excuteWithEntityRes(url);
            entityString = EntityUtils.toString(entity);
        } catch (IOException e) {
           return null;
        }
        JdAuthedInfo jdAithedInfo = getJdAithedInfo(entityString);

        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setId(id);
        jdSessionMap.setJdUserNick(jdAithedInfo.getUserNick());
        jdSessionMap.setAccessToken(jdAithedInfo.getAccessToken());
        jdSessionMap.setRefreshToken(jdAithedInfo.getRefreshToken());
        jdSessionMap.setAuthTime(new Date(jdAithedInfo.getAuthTime()));
        jdSessionMap.setExpiresIn(jdAithedInfo.getExpiresIn());
        jdSessionMapMapper.updateByPrimaryKeySelective(jdSessionMap);
        return jdAithedInfo;
    }

    private JdAuthedInfo getJdAithedInfo(String entityString)  {
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
            return null;
        }

        JdAuthedInfo response = new JdAuthedInfo();
        response.setAccessToken(authedInfo.getString("access_token"));
        response.setRefreshToken(authedInfo.getString("refresh_token"));
        response.setUid(authedInfo.getLong("uid"));
        response.setUserNick(authedInfo.getString("user_nick"));

        Integer expiresIn = authedInfo.getIntValue("expires_in");
        Long authTime = authedInfo.getLong("time");

        response.setAuthTime(authTime);
        response.setExpiresIn(expiresIn);

        return response;
    }
}
