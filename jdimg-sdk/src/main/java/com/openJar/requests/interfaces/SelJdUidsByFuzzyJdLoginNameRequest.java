package com.openJar.requests.interfaces;

import com.openJar.beans.enums.JdImgEnum;
import com.openJar.requests.Request;
import com.openJar.responses.interfaces.SelJdUidsByFuzzyJdLoginNameResponse;

/**
 * Created by gtx on 2018/5/2.
 * 根据京东登陆名模糊查询
 * @author gtx
 * @description
 * @since
 */
public class SelJdUidsByFuzzyJdLoginNameRequest extends Request<SelJdUidsByFuzzyJdLoginNameResponse>{
    /**
     * 京东登录名(昵称)
     */
    private String jdUserNick;

    public String getJdUserNick() {
        return jdUserNick;
    }

    public void setJdUserNick(String jdUserNick) {
        this.jdUserNick = jdUserNick;
    }

    public String restApiUrl() {
        return JdImgEnum.REST+"api/selJdUidsByFuzzyJdLoginName.json";
    }

    public String testApiUrl() {
        return JdImgEnum.TEST+"api/selJdUidsByFuzzyJdLoginName.json";
    }
}
