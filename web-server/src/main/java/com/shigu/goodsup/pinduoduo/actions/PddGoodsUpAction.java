package com.shigu.goodsup.pinduoduo.actions;

import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.goodsup.pinduoduo.bo.PublishBO;
import com.shigu.goodsup.pinduoduo.exceptions.CustomException;
import com.shigu.goodsup.pinduoduo.service.PddGoodsUpService;
import com.shigu.goodsup.pinduoduo.vo.PddItemDetailVO;
import com.shigu.goodsup.pinduoduo.vo.ReturnsTemplateVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.sdk.pinduoduo.requests.PddRefreshAuthInfoRequest;
import com.shigu.sdk.pinduoduo.response.PddAuthInfoResponse;
import com.shigu.sdk.pinduoduo.response.PddRefreshAuthInfoResponse;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.XzSdkClient;
import com.utils.publics.Opt3Des;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pdd.constant.PddConfig;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by gtx on 2018/6/6.
 * 一键上传拼多多
 * @author gtx
 * @description
 * @since
 */
@Controller
@RequestMapping("pdd")
public class PddGoodsUpAction {

    @Resource
    private UserBaseService userBaseService;
    @Resource
    private ItemUpRecordService itemUpRecordService;
    @Resource
    private MemberFilter memberFilter;
    @Resource
    private RedisIO redisIO;
    @Resource
    private PddGoodsUpService pddGoodsUpService;
    @Resource
    private XzSdkClient xzSdkClient;
    //运费模板
    public static final String PDD_POST_TEMPLATE_PRE = "pdd_post_template_";
    //退换货模板
    public static final String PDD_RETURNS_TEMPLATE_PRE = "pdd_returns_template_";

    @RequestMapping("login")
    public String login(){
        String authUrl = PddConfig.AUTH_URL.replace("APP_KEY",PddConfig.APP_KEY)
                .replace("APP_REDIRECT_URI",PddConfig.APP_REDIRECT_URI)
                .replace("PDD_STATE",PddConfig.APP_STATE);

        return "redirect:"+authUrl;
    }

    /**
     * 拼多多CODE回调
     * @param code
     * @return
     */
    @RequestMapping("callback")
    public String jdCallback(String code, HttpServletRequest request, HttpSession session) throws Main4Exception {
        String jsonStr = Opt3Des.decryptPlainData(code.replace(" ", "+"));
        PddAuthInfoResponse pddAuthInfoResponse = com.alibaba.fastjson.JSONObject.parseObject(jsonStr, PddAuthInfoResponse.class);
        /******************登陆**********************/
        Subject currentUser = SecurityUtils.getSubject();
        String thirdUid = String.valueOf(pddAuthInfoResponse.getThirdUid());
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                pddAuthInfoResponse.getThirdUserNick(), null, false, request.getRemoteAddr(), "", UserType.MEMBER);
        token.setLoginFromType(LoginFromType.PDD);
        token.setRememberMe(true);
        token.setSubKey(thirdUid);
        try {
            currentUser.login(token);
            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(pddAuthInfoResponse.getThirdUserNick(),thirdUid, LoginFromType.PDD);
            if (personalSession == null || personalSession.getUserId() == null) {
                //还是检查一遍避免 字符串+null 出现
                throw new Main4Exception("授权失败");
            }

            //得到回调用地址
            String backUrl= (String) session.getAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            session.removeAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            return "redirect:"+loginSuccessUrl(backUrl);
        } catch (LoginAuthException e) {
            if(e.getMsgback().equals(LoginErrorEnum.TO_BIND_XZUSER)){//还没绑定星座网用户,去绑定一下
                return "redirect:/userPhoneBind.htm";
            }else{
                throw e;
            }
        }
    }

    /**
     * 得到登陆成功链接
     * @param backUrl
     * @return
     */
    private String loginSuccessUrl(String backUrl){
        String toUrl;
        if(backUrl!=null&&!"http://www.571xz.com/".equals(backUrl)){//TODO 首页的,等页面改好,这里再去掉
            toUrl=backUrl;
        }else{
            //如果个人,跳到这个,如果商户跳到seller
            toUrl = memberFilter.getSuccessUrl();
        }
        return toUrl;
    }

    @RequestMapping("publish")
    public String publish(PublishBO bo, HttpServletRequest request, HttpSession session, Model model) throws UnsupportedEncodingException, CustomException {
        //判断是否拼多多登陆
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        /********************************获取京东授权信息*******************************/
        if (ps==null) {
            return redirectLoginPdd(request);
        }
        if (ps.getLoginFromType() != LoginFromType.PDD) {
            //拿拼多多授权信息并刷新授权 无授权信息或刷新出现异常跳登陆
            Long pddUid = pddGoodsUpService.selPddUserId(ps.getUserId());
            if (pddUid != null) {
                return redirectLoginPdd(request);
            }
            //使用refreshToken刷新授权
            PddRefreshAuthInfoRequest pddRefreshAuthInfoRequest = new PddRefreshAuthInfoRequest();
            pddRefreshAuthInfoRequest.setThirdUid(pddUid);
            PddRefreshAuthInfoResponse pddRefreshAuthInfoResponse = xzSdkClient.getPcOpenClient().execute(pddRefreshAuthInfoRequest);
            if (!pddRefreshAuthInfoResponse.isSuccess()) {
                return redirectLoginPdd(request);
            }
        }


        /********************************屏蔽卖家用户使用********************************/
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole(RoleEnum.STORE.getValue())) {
            throw new CustomException("档口不支持代理功能");
        }

        /********************************查上传记录********************************/
        try {
            if (bo.getYesrepeat() == null || bo.getYesrepeat() != 1) {
                LastUploadedVO lastup = itemUpRecordService.selLastUpByIds(ps.getUserId(),bo.getGoodsId(), GoodsUploadFlagEnum.WEB_PDD);
                if (lastup != null) {
                    model.addAttribute("lastup", lastup);
                    model.addAttribute("goodsId", bo.getGoodsId());
                    return "pdd/hasuped";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        PddItemDetailVO pddItemDetailVO = pddGoodsUpService.goodsDetail(bo.getGoodsId(), ps.getUserId());
        if (pddItemDetailVO == null) {
            throw new CustomException("商品不存在");
        }

        /******************** 默认利润模板 *******************/


        /********************************查出类目信息********************************/
        Long cid = null;


        /******************** 退换货模板 *********************/
        ReturnsTemplateVO returnsTemplateVO = redisIO.get(PDD_RETURNS_TEMPLATE_PRE + ps.getUserId() + "_" + cid, ReturnsTemplateVO.class);

        /********************************查出以前用过的快递模板********************************/
        String postTemplateId = redisIO.get(PDD_POST_TEMPLATE_PRE + ps.getUserId() + "_" + cid);


        return "pdd/publish";
    }

    /**
     * 根据request获取重定向地址
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    public String redirectLoginPdd (HttpServletRequest request) throws UnsupportedEncodingException {
        String queryString = request.getQueryString();
        return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=7&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                (queryString == null ? "" : ("?" + queryString)), "utf-8");
    }

}
