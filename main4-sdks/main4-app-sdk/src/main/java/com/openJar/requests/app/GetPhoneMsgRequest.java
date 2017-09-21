package com.openJar.requests.app;

import com.openJar.enums.HostEnum;
import com.openJar.requests.Request;
import com.openJar.responses.app.AboutMeResponse;
import com.openJar.responses.app.GetPhoneMsgResponse;

import javax.validation.constraints.NotNull;

/**
 * 类名：GetPhoneMsgRequest
 * 类路径：com.openJar.requests.app.GetPhoneMsgRequest
 * 创建者：任真飞
 * 创建时间：2017-09-21 15:10
 * 项目：main-pom
 * 描述：得到手机验证码
 */
public class GetPhoneMsgRequest extends Request<GetPhoneMsgResponse> {
    //密码	必须
    @NotNull(message = "telephone is null")
    private String telephone;
    //1登录2注册3忘记密码4绑定	必须
    @NotNull(message = "type is null")
    private Integer type;

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public String getTelephone() {
        return telephone;
    }

    public Integer getType() {
        return type;
    }

    public String testApiUrl(){
        return HostEnum.TEST+"getPhoneMsg.json";
    }

    public String restApiUrl(){
        return HostEnum.REST+"getPhoneMsg.json";
    }
}
