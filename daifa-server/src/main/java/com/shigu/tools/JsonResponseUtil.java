package com.shigu.tools;

import net.sf.json.JSONObject;

/**
 * json结果处理器
 * Created by zhaohongbo on 17/3/1.
 */
public class JsonResponseUtil {
    /**
     * 成功消息
     * @param msg 成功信息
     * @return json
     */
    public static JSONObject success(String msg){
        return JSONObject.fromObject("{'result':'success','msg':'"+msg+"'}");
    }

    /**
     * 成功消息
     * @return 返回json
     */
    public static JSONObject success(){
        return JSONObject.fromObject("{'result':'success'}");
    }

    /**
     * 失败消息
     * @param msg 错误信息
     * @return 返回值
     */
    public static JSONObject error(String msg){
        return JSONObject.fromObject("{'result':'error','msg':'"+msg+"'}");
    }
}
