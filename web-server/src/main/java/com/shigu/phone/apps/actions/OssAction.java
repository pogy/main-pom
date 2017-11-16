//package com.shigu.phone.apps.actions;
//
//import com.openJar.exceptions.OpenException;
//import com.openJar.requests.app.*;
//import com.openJar.responses.app.BindUserResponse;
//import com.shigu.phone.baseservices.BasePhoneUserService;
//import net.sf.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//
///**
// * 类名：AppUserAction
// * 类路径：com.shigu.phone.apps.actions.AppUserAction
// * 创建者：王浩翔
// * 创建时间：2017-08-31 16:56
// * 项目：main-pom
// * 描述：app端用户
// */
//@Controller
//@RequestMapping("oss/")
//public class OssAction {
//
//    @Autowired
//    private BasePhoneUserService phoneUserService;
//
//    /**
//     * 获取 OSS 临时授权
//     * @return
//     */
//    @RequestMapping("createPostSignInfo")
//    @ResponseBody
//    public JSONObject createPostSignInfo(HttpServletResponse response) throws OpenException {
//
//        // 指定允许其他域名访问
//        response.setHeader("Access-Control-Allow-Origin","*");
//        // 响应类型
//        response.setHeader("Access-Control-Allow-Methods","POST");
//        // 响应头设置
//        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
//        return JSONObject.fromObject(phoneUserService.createPostSignInfo());
//    }
//
//}
