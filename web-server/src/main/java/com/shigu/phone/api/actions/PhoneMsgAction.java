package com.shigu.phone.api.actions;

import com.shigu.main4.tools.RedisIO;
import com.shigu.phone.api.enums.PhoneMsgTypeEnum;
import com.shigu.session.main4.PhoneVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类名：PhoneMsgAction
 * 类路径：com.shigu.phone.api.actions.PhoneMsgAction
 * 创建者：王浩翔
 * 创建时间：2017-09-18 16:07
 * 项目：main-pom
 * 描述：用户手机验证信息获取
 */
@Service
//@RequestMapping("api/")
public class PhoneMsgAction {

    @Autowired
    RedisIO redisIO;

    /**
     * 移动端获取手机验证信息，第三方登陆信息等
     * @param unique 唯一标记，手机号、第三方id等
     * @param type
     * @param clazz
     * @param <T> 返回类型
     * @return
     */
    //@RequestMapping("getPhoneMsg")
    //@ResponseBody
    public <T> T getPhoneMsg(String unique, PhoneMsgTypeEnum type, Class<T> clazz) {
        return redisIO.get(type.getType() + unique, clazz);
    }
}
