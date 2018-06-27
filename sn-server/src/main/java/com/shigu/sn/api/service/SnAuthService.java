package com.shigu.sn.api.service;

import com.openJar.beans.SnTokenInfo;
import com.opentae.data.beans.SnSession;
import com.opentae.data.interfaces.SnSessionMapper;
import com.shigu.exception.AppNotBuyException;
import com.shigu.sn.api.util.HttpClientUtil;
import com.shigu.sn.api.util.SnKeyConfig;
import com.shigu.sn.client.SnSdkClient;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SnAuthService {

    @Autowired
    SnSessionMapper snSessionMapper;

    /**
     * 获取授权信息,记录到库
     * @param code
     * @return
     * @throws AppNotBuyException
     */
    public SnTokenInfo getSnTokenInfo(String code) throws AppNotBuyException{
        String url = "https://open.suning.com/api/oauth/token?grant_type=authorization_code&client_id="+ SnKeyConfig.snAppkey+"&client_secret="
                +SnKeyConfig.snSecret+"&redirect_uri="+SnKeyConfig.snRedirectUri+"&code="+code;
        String entityString = null;
        try {
            HttpEntity entity=HttpClientUtil.excuteWithEntityRes(url);
            entityString= EntityUtils.toString(entity);
        }catch (Exception e){
            return null;
        }
        SnTokenInfo snTokenInfo=getSnToken(entityString);
        if(snTokenInfo==null){
            return null;
        }
        SnSession snSession = new SnSession();
        snSession.setUserName(snTokenInfo.getSuningUserName());
        SnSession selSnSession = snSessionMapper.selectOne(snSession);
        if(selSnSession==null){
            snSession.setAccessToken(snTokenInfo.getAccessToken());
            snSession.setCustnum(snTokenInfo.getCustnum());
            snSession.setExpiresIn(snTokenInfo.getExpiresIn());
            snSession.setModule(snTokenInfo.getModule());
            snSession.setRefreshToken(snTokenInfo.getRefreshToken());
            snSession.setTokenType(snTokenInfo.getTokenType());
            snSession.setVendorCode(snTokenInfo.getVendorCode());
            snSessionMapper.insertSelective(snSession);
        }else{
            snSession.setId(selSnSession.getId());
            snSession.setAccessToken(snTokenInfo.getAccessToken());
            snSession.setCustnum(snTokenInfo.getCustnum());
            snSession.setExpiresIn(snTokenInfo.getExpiresIn());
            snSession.setModule(snTokenInfo.getModule());
            snSession.setRefreshToken(snTokenInfo.getRefreshToken());
            snSession.setTokenType(snTokenInfo.getTokenType());
            snSession.setVendorCode(snTokenInfo.getVendorCode());
            snSessionMapper.updateByPrimaryKeySelective(snSession);
        }
        return snTokenInfo;
    }

    private SnTokenInfo getSnToken(String entityString){
        JSONObject jsonObject = JSONObject.fromObject(entityString);
        SnTokenInfo snTokenInfo = new SnTokenInfo();
        snTokenInfo.setAccessToken(jsonObject.getString("access_token"));
        snTokenInfo.setCustnum(jsonObject.getLong("custnum"));
        snTokenInfo.setExpiresIn(jsonObject.getInt("expires_in"));
        snTokenInfo.setModule(jsonObject.getInt("module"));
        snTokenInfo.setRefreshToken(jsonObject.getString("refresh_token"));
        snTokenInfo.setSuningUserName(jsonObject.getString("suning_user_name"));
        snTokenInfo.setVendorCode(jsonObject.getLong("vendorCode"));
        snTokenInfo.setTokenType(jsonObject.getString("token_type"));
        return snTokenInfo;
    }

    public SnTokenInfo getToken(String username){
        SnTokenInfo snTokenInfo=new SnTokenInfo();
        SnSession snSession = new SnSession();
        snSession.setUserName(username);
        SnSession sel = snSessionMapper.selectOne(snSession);
        if(sel==null){
            return null;
        }
        snTokenInfo.setTokenType(sel.getTokenType());
        snTokenInfo.setVendorCode(sel.getVendorCode());
        snTokenInfo.setSuningUserName(sel.getUserName());
        snTokenInfo.setRefreshToken(sel.getRefreshToken());
        snTokenInfo.setModule(sel.getModule());
        snTokenInfo.setCustnum(sel.getCustnum());
        snTokenInfo.setAccessToken(sel.getAccessToken());
        return snTokenInfo;
    }

    /**
     * 刷新token
     * @param id
     * @param refreshToken
     * @return
     */
    public SnTokenInfo refreshToken(Long id,String refreshToken){
        String url = "https://open.suning.com/api/oauth/token?grant_type=refresh_token&client_id="+ SnKeyConfig.snAppkey+"&client_secret="
                +SnKeyConfig.snSecret+"&redirect_uri="+SnKeyConfig.snRedirectUri+"&refresh_token="+refreshToken;
        String entityString = null;
        try {
            HttpEntity entity=HttpClientUtil.excuteWithEntityRes(url);
            entityString= EntityUtils.toString(entity);
        }catch (Exception e){
            return null;
        }
        SnTokenInfo snTokenInfo=getSnToken(entityString);
        if(snTokenInfo==null){
            return null;
        }
        SnSession snSession = new SnSession();
        snSession.setId(id);
        snSession.setRefreshToken(snTokenInfo.getRefreshToken());
        snSession.setExpiresIn(snTokenInfo.getExpiresIn());
        snSession.setTokenType(snTokenInfo.getTokenType());
        snSession.setAccessToken(snTokenInfo.getAccessToken());
        snSessionMapper.updateByPrimaryKeySelective(snSession);
        return snTokenInfo;
    }
}
