package com.shigu.goodsup.pinduoduo.actions;

import com.openJar.requests.PddRefreshAuthInfoRequest;
import com.openJar.responses.PddAuthInfoResponse;
import com.openJar.responses.PddRefreshAuthInfoResponse;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.goodsup.pinduoduo.bo.AddPropBO;
import com.shigu.goodsup.pinduoduo.bo.PublishBO;
import com.shigu.goodsup.pinduoduo.exceptions.CustomException;
import com.shigu.goodsup.pinduoduo.service.PddGoodsUpService;
import com.shigu.goodsup.pinduoduo.vo.PddItemDetailVO;
import com.shigu.goodsup.pinduoduo.vo.ProfitTemplate;
import com.shigu.goodsup.pinduoduo.vo.ReturnsTemplate;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.XzSdkClient;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pdd.beans.GoodsCats;
import pdd.beans.LogisticsTemplate;
import pdd.constant.PddConfig;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

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
    //利润模板
    public static final String PDD_PROFIT_TEMPLATE_PRE = "pdd_profit_template_";

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
        if (bo.getGoodsId() == null) {
            throw new CustomException("商品不存在");
        }

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
                    return "pinduoduo/hasuped";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Long xzCid = pddGoodsUpService.selCidByGoodsId(bo.getGoodsId());
        if (xzCid == null) {
            throw new CustomException("未查询到类目信息");
        }
        PddItemDetailVO pddItemDetailVO = pddGoodsUpService.goodsDetail(bo.getGoodsId());
        if (pddItemDetailVO == null) {
            throw new CustomException("商品不存在");
        }
        /******************** 根据利润模板设置利润 团购价 及 单买价 *******************/
        ProfitTemplate profitTemplate = redisIO.get(PDD_PROFIT_TEMPLATE_PRE + ps.getUserId(), ProfitTemplate.class);
        if (profitTemplate != null) {
            BigDecimal price = new BigDecimal(pddItemDetailVO.getPrice());
            BigDecimal profit = null;
            if (profitTemplate.getType() == 1) {
                profit = new BigDecimal(profitTemplate.getProfit());
                price = price.add(profit);
            }else {
                profit = new BigDecimal(profitTemplate.getProfit()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_UP);
                price = price.multiply(profit);
            }
            price = price.setScale(2, BigDecimal.ROUND_UP);
            pddItemDetailVO.setPrice(price.toString());
            pddItemDetailVO.setLiPrice(price.multiply(new BigDecimal("2")).toString());//默认为团购件的2倍
            pddItemDetailVO.setProfit(profit.setScale(2,BigDecimal.ROUND_UP).toString());
        }
        model.addAttribute("item",pddItemDetailVO);


        /********************************查出类目信息********************************/

//        Long pddCid = null;
//        if (bo.getCid() != null) {
//            pddCid = bo.getCid();
//        }else {
//            pddCid = pddGoodsUpService.selPddCidByXzCid(xzCid);
//            if (pddCid == null) {
//                throw new CustomException("未查询到类目信息");
//            }
//        }
//        model.addAttribute("pddCatName",pddGoodsUpService.selPddCatsNamesByPddCid(pddCid));
        model.addAttribute("xzCatName",pddGoodsUpService.selXzCatsName(bo.getGoodsId()));

        /******************** 退换货模板 *********************/
        ReturnsTemplate returnsTemplate = redisIO.get(PDD_RETURNS_TEMPLATE_PRE + ps.getUserId() + "_" + xzCid, ReturnsTemplate.class);
        if (returnsTemplate != null) {
            returnsTemplate = new ReturnsTemplate();
            returnsTemplate.setArtificial(0);
            returnsTemplate.setDelivery(1);
            returnsTemplate.setReturns(1);
            model.addAttribute("returnsTemplate",returnsTemplate);
        }

        return "pinduoduo/pdd";
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

    /**
     * 获取运费模板
     * @return
     */
    @RequestMapping("selPostTemplate")
    public String selPostTemplate (HttpSession session,Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        /********************************查出以前用过的快递模板********************************/
        String postTemplateId = redisIO.get(PDD_POST_TEMPLATE_PRE + ps.getUserId());
        if (postTemplateId != null) {
            model.addAttribute("erverDyTemplateId",postTemplateId);
        }
        List<LogisticsTemplate> logisticsTemplates = pddGoodsUpService.selPostTemplate(ps.getUserId());
        if (logisticsTemplates != null || !logisticsTemplates.isEmpty()) {
            model.addAttribute("deliveyList",logisticsTemplates);
        }
        return "pinduoduo/parts/deliver";
    }

    /**
     * 更新利润模板
     * @return
     */
    @RequestMapping("updateProfitTemplate")
    @ResponseBody
    public JSONObject updateProfitTemplate (ProfitTemplate bo,HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (bo.getType() != 1 || bo.getType() != 2 ) {
            return JsonResponseUtil.error("参数错误");
        }
        if (bo.getProfit() <= 0 ) {
            return JsonResponseUtil.error("利润只能设置为正整数");
        }
        redisIO.putString(PDD_PROFIT_TEMPLATE_PRE + ps.getUserId(), JSONObject.fromObject(bo).toString());
        return JsonResponseUtil.success();
    }

    /**
     * 更新退换货模板
     * @return
     */
    @RequestMapping("updatereturnsTemplate")
    @ResponseBody
    public JSONObject updatereturnsTemplate (ReturnsTemplate bo, HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<Integer> vals = Arrays.asList(0,1);
        if (!vals.contains(bo.getArtificial()) || !vals.contains(bo.getDelivery()) || !vals.contains(bo.getReturns())) {
            return JsonResponseUtil.error("参数错误");
        }
        redisIO.putString(PDD_RETURNS_TEMPLATE_PRE + ps.getUserId(), JSONObject.fromObject(bo).toString());
        return JsonResponseUtil.success();
    }

    /**
     * 查询pdd类目信息
     * @return
     */
    @RequestMapping("selPddCats")
    @ResponseBody
    public JSONObject selPddCats (Long pddCid,HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<GoodsCats> goodsCats = pddGoodsUpService.selAuthorizationCats(ps.getUserId(), pddCid);
        return JsonResponseUtil.success().element("goodsCats",goodsCats);
    }

    /**
     * 生成商家自定义的规格
     * 0 颜色 1 尺码
     * @return
     */
    @RequestMapping("addProp")
    @ResponseBody
    public JSONObject addProp (AddPropBO bo, HttpSession session){
        if (bo.getType() != 0 || bo.getType() != 1 || bo.getPddCid() == null) {
            return JsonResponseUtil.error("参数错误");
        }
        if (StringUtils.isBlank(bo.getPropName())) {
            String msg = null;
            if (bo.getType() == 1) {
                msg = "颜色名不能为空";
            }else {
                msg = "尺码名不能为空";
            }
            return JsonResponseUtil.error(msg);
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long specId = pddGoodsUpService.addProp(ps.getUserId(), bo);
        return JsonResponseUtil.success().element("specId",specId);
    }


}
