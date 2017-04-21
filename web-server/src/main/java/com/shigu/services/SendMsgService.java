package com.shigu.services;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;


/**
 * 发短信服务
 * Created by zhaohongbo on 17/2/28.
 */
@Service
public class SendMsgService {
    private static final Logger logger = LoggerFactory.getLogger(SendMsgService.class);

    private static String account_quick = "sdk_sgwl";
    private static String pwd_quick = "20150630";
    private static String account_ordinary = "3377";
    private static String pwd_ordinary = "D47C126518CE8632397A155F11BDF6C2";

    /**
     * 发送忘记密码短信
     * @param phone
     * @param code
     */
    public void sendForgetPwd(String phone,String code){
        String content="验证码["+code+"]。温馨提示：验证码有效时间为10分钟，请及时输入。【四季星座网】";
        sendSms_quick(phone,content);//发送短信
    }

    /**
     * 发送注册短信
     * @param phone
     * @param code
     */
    public void sendRegist(String phone,String code){
        String content = "效验码：" + code + "。温馨提示：效验码有效时间为10分钟，请及时输入 【四季星座网】";
        sendSms_quick(phone,content);
    }



    /**
     * 直接发短信
     * @param mobile
     * @param content
     * @return
     */
    private String sendSms_quick(String mobile, String content) {
        String result = "";
        String memo = content.length() < 70?content.trim():content.trim().substring(0, 70);
        try {
            Document document = Jsoup.connect("http://www.jianzhou.sh.cn/JianzhouSMSWSServer/http/sendBatchMessage").data("account", account_quick).data("password", pwd_quick).data("destmobile", mobile).data("msgText", memo).timeout(1000000).post();
            result = document.text();
        } catch (Exception e) {
            logger.error("发送短信网络通信问题",e);
        }
        return result;
    }
}
