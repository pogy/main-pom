package com.shigu.jd.actions;

import com.openJar.beans.JdAuthedInfo;
import com.openJar.beans.SdkJdVasSubscribe;
import com.openJar.responses.api.JdAuthedInfoResponse;
import com.openJar.responses.api.JdVasSubscribeResponse;
import com.shigu.jd.api.exceptions.AppNotBuyException;
import com.shigu.jd.api.exceptions.JdAuthFailureException;
import com.shigu.jd.api.service.JdAuthService;
import com.shigu.jd.api.service.JdClientService;
import com.shigu.jd.api.service.JdServiceMarketService;
import com.shigu.jd.api.utils.JdKeyConfig;
import com.shigu.jd.tools.JdParseStateUtil;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.Date;

/**
 * Created By admin on 2017/12/25/10:46
 */
@Controller
@RequestMapping("zs")
public class JdAuthAction {

    @Autowired
    private JdAuthService jdAuthService;
    @Autowired
    private JdServiceMarketService jdServiceMarketService;

    /**
     * 京东CODE回调
     * @param state
     * @param code
     * @return
     * @throws IOException
     */
    @RequestMapping("callback")
    public String jdCallback(String code, String state) throws JdAuthFailureException {
        if (StringUtils.isBlank(code) || StringUtils.isBlank(state)) {
            return "redirect:http://www.571xz.com";
        }
        /************检测是否订阅服务**********/
        JdAuthedInfo jdAuthedInfoVO;
        try {
            jdAuthedInfoVO = jdAuthService.getAuthedInfo(code);
        } catch (AppNotBuyException e) {
            return "redirect:https://fw.jd.com/591601.html";
        }
        if(jdAuthedInfoVO==null){
            throw new JdAuthFailureException("授权失败");
        }
        SdkJdVasSubscribe subscribeVO;
        try {
            subscribeVO = JdParseStateUtil.parseState(state);
            if (subscribeVO == null || subscribeVO.getEndDate().after(new Date())) {
                //FW_GOODS-449409
                return "redirect:https://fw.jd.com/591601.html";
            }
        } catch (Exception ignored) {
        }
//        try {
//            //保存订购信息
//            subscribeVO.setJdUid(jdAuthedInfoVO.getUid());
//            jdServiceMarketService.saveSubscribe(subscribeVO);
//        } catch (JdAuthFailureException e) {
//            e.printStackTrace();
//            return "redirect:http://www.571xz.com";
//        }

        /************获取用户登陆信息**********/
        JdAuthedInfoResponse res=new JdAuthedInfoResponse();
        res.setSuccess(true);
        res.setData(jdAuthedInfoVO);
        JSONObject jsonObject = JSONObject.fromObject(res);
        String encryptPlainData = Opt3Des.encryptPlainData(jsonObject.toString());//加密
        return "redirect:http://www.571xz.com/jd/callback.htm?code="+encryptPlainData;
    }


}
