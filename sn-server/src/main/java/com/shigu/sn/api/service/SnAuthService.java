package com.shigu.sn.api.service;

import com.openJar.beans.SnTokenInfo;
import com.shigu.exception.AppNotBuyException;
import com.shigu.sn.api.util.HttpClientUtil;
import com.shigu.sn.client.SnSdkClient;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnAuthService {

    public SnTokenInfo getSnTokenInfo(String code) throws AppNotBuyException{
        String url = "";
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
}
