package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.ThirdLoinResponse;


/**
 * Created by pc on 2016-03-22.
 */
public class ThirdLoinRequest extends Request<ThirdLoinResponse> {

    private String loginName;//登陆名
    private String passWord;//手机号
    

    public String restApiUrl() {
        return HostEnum.REST_HOST+"thirdLoin.json";
    }

    public String testApiUrl() {
        return HostEnum.TEST_HOST+"thirdLoin.json";
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
