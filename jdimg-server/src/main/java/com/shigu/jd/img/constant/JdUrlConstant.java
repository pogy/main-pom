package com.shigu.jd.img.constant;

/**
 * Created By admin on 2017/12/12/15:25
 */
public class JdUrlConstant {
    /**引导授权地址*/
    public static final String JD_AUTH_URL = "https://oauth.jd.com/oauth/authorize?response_type=code&client_id=JD_APPKEY&redirect_uri=JD_REDIRECT_URI&state=JD_STATE";

    /**换取access_token地址*/
    public static final String JD_AUTH_TOKEN_URL = "https://oauth.jd.com/oauth/token?grant_type=authorization_code&client_id=JD_APPKEY&client_secret=JD_SECRET&scope=read" +
            "&redirect_uri=JD_REDIRECT_URI&code=CODE&state=JD_STATE";

    /**京东API请求路径*/
    public static final String JD_REFRESH_TOKEN_URL ="https://oauth.jd.com/oauth/token?client_id=JD_APPKEY&client_secret=JD_SECRET&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

    /**京东API请求路径*/
    public static final String JD_SERVER_URL ="https://api.jd.com/routerjson";

}
