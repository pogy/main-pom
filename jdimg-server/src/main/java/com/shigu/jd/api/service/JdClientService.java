package com.shigu.jd.api.service;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.JdRequest;
import com.jd.open.api.sdk.response.AbstractResponse;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.constant.JdUrlConstant;
import com.shigu.jd.api.utils.JdKeyConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/11/16:29
 */
@Service
public class JdClientService {

    /**
     * 获取京东Client
     * @param accessToken
     * @return
     */
    public JdClient getJdClient(String accessToken){
       return new DefaultJdClient(JdUrlConstant.JD_SERVER_URL,accessToken, JdKeyConfig.jdAppkey,JdKeyConfig.jdSecret);
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

}
