package com.openJar.requests.thirdSupport;

import com.openJar.beans.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.thirdSupport.ThirdIssuingLoinResponse;


/**
 * Created by pc on 2016-03-22.
 */
public class ThirdIssuingLoinRequest extends Request<ThirdIssuingLoinResponse> {

    private String loginName;//登陆名
    private String passWord;//手机号
    

    public String restApiUrl() {
        return HostEnum.DAIFA_HOST+"thirdLoin.json";
    }

    public String testApiUrl() {
        return HostEnum.DAIFA_HOST+"thirdLoin.json";
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
