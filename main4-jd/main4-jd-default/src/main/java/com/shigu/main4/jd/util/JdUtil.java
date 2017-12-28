package com.shigu.main4.jd.util;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.JdRequest;
import com.jd.open.api.sdk.response.AbstractResponse;
import com.shigu.main4.jd.constant.JdUrlConstant;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.exceptions.JdUpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/11/16:29
 */
@Service
public class JdUtil {

    @Value("${jd.app.key}")
    private String jdAppkey;

    @Value("${jd.app.secret}")
    private String jdSecret;

    @Value("${jd.app.state}")
    private String jdState;

    @Value("${jd.app.redirect_uri}")
    private String jdRedirectUri;

    @Value("${jd.app.item_code}")
    private String jdItemCode;

    /**
     * 获取京东Client
     * @param accessToken
     * @return
     */
    public JdClient getJdClient(String accessToken){
       return new DefaultJdClient(JdUrlConstant.JD_SERVER_URL,accessToken,jdAppkey,jdSecret);
    }

    public <T extends AbstractResponse> T execute(JdRequest<T> request,String accessToken) throws JdUpException, JdAuthFailureException {
        try {
            T response = getJdClient(accessToken).execute(request);
            checkJdResponst(response);
            return response;
        } catch (JdException e) {
            e.printStackTrace();
            throw new JdUpException(e.getErrCode(),e.getErrMsg());
        }
    }

    /**
     * 验证jd接口是否正确返回
     */
    private void checkJdResponst(AbstractResponse response) throws JdUpException, JdAuthFailureException {
        if ("19".equals(response.getCode())) {
            throw new JdAuthFailureException("授权失效,请重新授权");
        }
        if ( !( "0".equals(response.getCode())) ) {
            throw new JdUpException(response.getCode(),response.getZhDesc());
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

    public String getJdItemCode() {
        return jdItemCode;
    }

    public void setJdItemCode(String jdItemCode) {
        this.jdItemCode = jdItemCode;
    }
}
