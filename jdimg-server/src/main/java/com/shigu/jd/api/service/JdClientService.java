package com.shigu.jd.api.service;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.JdRequest;
import com.jd.open.api.sdk.response.AbstractResponse;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.constant.JdUrlConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/11/16:29
 */
@Service
public class JdClientService {

    @Value("${jd.app.key}")
    private String jdAppkey;

    @Value("${jd.app.secret}")
    private String jdSecret;

    @Value("${jd.app.state}")
    private String jdState;

    @Value("${jd.app.redirect_uri}")
    private String jdRedirectUri;

    @Value("${jd.app.itemId}")
    private String itemId;

    /**
     * 获取京东Client
     * @param accessToken
     * @return
     */
    public JdClient getJdClient(String accessToken){
       return new DefaultJdClient(JdUrlConstant.JD_SERVER_URL,accessToken,jdAppkey,jdSecret);
    }

    public <T extends AbstractResponse> T execute(JdRequest<T> request, String accessToken) throws OtherCustomException, JdAuthOverdueException {
        try {
            T response = getJdClient(accessToken).execute(request);
            checkJdResponst(response);
            return response;
        } catch (JdException e) {
            throw new OtherCustomException(e.getErrMsg());
        }
    }

    /**
     * 验证jd接口是否正确返回
     */
    private void checkJdResponst(AbstractResponse response) throws OtherCustomException,JdAuthOverdueException {
        if ( !( "0".equals(response.getCode())) ) {
            if("19".equals(response.getCode())){
                throw new JdAuthOverdueException(response.getZhDesc());
            }
            throw new OtherCustomException(response.getZhDesc());
        }
    }


    public String getJdAppkey() {
        return jdAppkey;
    }

    public void setJdAppkey(String jdAppkey) {
        this.jdAppkey = jdAppkey;
    }

    public String getJdSecret() {
        return jdSecret;
    }

    public void setJdSecret(String jdSecret) {
        this.jdSecret = jdSecret;
    }

    public String getJdState() {
        return jdState;
    }

    public void setJdState(String jdState) {
        this.jdState = jdState;
    }

    public String getJdRedirectUri() {
        return jdRedirectUri;
    }

    public void setJdRedirectUri(String jdRedirectUri) {
        this.jdRedirectUri = jdRedirectUri;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
