package com.shigu.main4.jd.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opentae.data.jd.beans.JdSessionMap;
import com.opentae.data.jd.interfaces.JdSessionMapMapper;
import com.opentae.data.jd.interfaces.JdShopInfoMapper;
import com.shigu.main4.jd.constant.JdUrlConstant;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.util.HttpClientUtil;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东授权接口
 */
@Service("jdAuthService")
public class JdAuthServiceImpl implements JdAuthService{

    private static final Logger logger = LoggerFactory.getLogger(JdAuthService.class);

    @Autowired
    private JdUtil jdUtil;

    @Autowired
    private JdSessionMapMapper jdSessionMapMapper;

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
     * 获取授权信息，并记录（更新）数据到库
     * @param code
     * @return
     * @throws IOException
     */
    @Override
    public JdAuthedInfoVO getAuthedInfo(String code) throws JdAuthFailureException {
        String url = JdUrlConstant.JD_AUTH_TOKEN_URL
                        .replace("JD_APPKEY",jdUtil.getJdAppkey())
                        .replace("JD_SECRET",jdUtil.getJdSecret())
                        .replace("JD_REDIRECT_URI",jdUtil.getJdRedirectUri())
                        .replace("CODE",code)
                        .replace("JD_STATE",jdUtil.getJdState());
        String entityString = null;
        try {
            HttpEntity entity = HttpClientUtil.excuteWithEntityRes(url);
            entityString = EntityUtils.toString(entity);
        } catch (IOException e) {
            throw new JdAuthFailureException("授权失败");
        }
        JdAuthedInfoVO jdAithedInfo = getJdAithedInfo(entityString);

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

    @Override
    public JdAuthedInfoVO getAuthedInfo(Long jdUid) throws JdAuthFailureException {
        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setJdUid(jdUid);
        JdSessionMap selJdSessionMap = jdSessionMapMapper.selectOne(jdSessionMap);
        if (selJdSessionMap == null) {
            throw new JdAuthFailureException("授权失效,请重新授权");
        }
        JdAuthedInfoVO vo;

        //校验token有效性，少于一小时视为无效
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selJdSessionMap.getAuthTime());
        calendar.add(Calendar.SECOND,selJdSessionMap.getExpiresIn());
        calendar.add(Calendar.HOUR_OF_DAY,-1);

        if(calendar.getTime().before(new Date())){
            //刷新授权信息'
           return refreshToken(selJdSessionMap.getId(),selJdSessionMap.getRefreshToken());
        }

        vo = new JdAuthedInfoVO();
        vo.setUid(selJdSessionMap.getJdUid());
        vo.setAccessToken(selJdSessionMap.getAccessToken());
        vo.setRefreshToken(selJdSessionMap.getRefreshToken());
        vo.setUserNick(selJdSessionMap.getJdUserNick());
        vo.setAuthTime(selJdSessionMap.getAuthTime().getTime());
        vo.setExpiresIn(selJdSessionMap.getExpiresIn());
        return vo;
    }

    /**
     * 刷新token
     * @param id
     * @param refreshToken
     */
    @Override
    public JdAuthedInfoVO refreshToken(Long id,String refreshToken) throws JdAuthFailureException {
        String url = JdUrlConstant.JD_REFRESH_TOKEN_URL
                .replace("JD_APPKEY",jdUtil.getJdAppkey())
                .replace("JD_SECRET",jdUtil.getJdSecret())
                .replace("REFRESH_TOKEN",refreshToken);
        String entityString = null;
        try {
            HttpEntity entity = HttpClientUtil.excuteWithEntityRes(url);
            entityString = EntityUtils.toString(entity);
        } catch (IOException e) {
            throw new JdAuthFailureException("授权失效,请重新授权");
        }
        JdAuthedInfoVO jdAithedInfo = getJdAithedInfo(entityString);

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

    private JdAuthedInfoVO getJdAithedInfo(String entityString) throws JdAuthFailureException {
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
            throw new JdAuthFailureException("授权失效,请重新授权");
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
