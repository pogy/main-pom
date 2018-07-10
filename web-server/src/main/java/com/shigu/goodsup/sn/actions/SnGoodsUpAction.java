package com.shigu.goodsup.sn.actions;

import com.openJar.beans.SnToken;
import com.openJar.beans.SnTokenInfo;
import com.openJar.responses.api.SnAuthInfoResponse;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.sn.service.SnCategoryService;
import com.shigu.goodsup.sn.service.SnUpItemService;
import com.shigu.goodsup.sn.service.SnUserInfoService;
import com.shigu.goodsup.sn.vo.PropItemVo;
import com.shigu.goodsup.sn.vo.PropValueVo;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.goodsup.sn.vo.SnShowDataVo;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.HttpRequestUtil;
import com.shigu.tools.JsonResponseUtil;
import com.suning.api.entity.custom.CategoryredictGetResponse;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.item.CategoryQueryResponse;
import com.taobao.api.domain.Item;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("sn")
public class SnGoodsUpAction {

    @Autowired
    private MemberFilter memberFilter;

    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private SnCategoryService snCategoryService;

    @Autowired
    private SnUserInfoService snUserInfoService;

    @Autowired
    private JdUpItemService jdUpItemService;

    @Autowired
    private SnUpItemService snUpItemService;

    @Value("${sn.app.key}")
    private String SN_appkey;
    @Value("${sn.app.secret}")
    private String SN_appsecret;
    @Value("${sn.redirect_uri}")
    private String SN_redirect_uri;

    private static final String SN_Outh_URL = "https://open.suning.com/api/oauth/authorize?response_type=code&client_id=SN_appkey&redirect_uri=SN_redirect_uri&itemcode=4811";

    /**
     * 上传页面
     */
    @RequestMapping("publish")
    public String publish(Long itemId, HttpServletRequest request, HttpSession session, Map<String, Object> map) {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if (ps == null || ps.getLoginFromType() != LoginFromType.SN) {
                String queryString = request.getQueryString();
                return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=7&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                        (queryString == null ? "" : ("?" + queryString)), "utf-8");
            }
            String SnUsername=snUserInfoService.getSnUsernameBySubUid(ps.getSubUserId());
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser.hasRole(RoleEnum.STORE.getValue())) {
                throw new CustomException("档口不支持代理功能");
            }
            int total = Integer.valueOf(snCategoryService.getCategory(SnUsername).getTotalSize());
            if(total==0){
                throw new CustomException("不是苏宁商家");
            }
            List<CategoryQueryResponse.CategoryQuery> categoryQueries = snCategoryService.getCategory(SnUsername, itemId).getCategoryQueryList();
            if(categoryQueries.size()!=1){
                return "suning/catChoose";
            }else {
                String categoryCode=categoryQueries.get(0).getCategoryCode();
                List<NewbrandQueryResponse.QueryNewbrand> brands= snUserInfoService.getBrand(SnUsername,categoryCode);
                if(brands==null){
                    throw new CustomException("没有苏宁品牌,暂不支持上传");
                }
                SnPageItem snPageItem=snUpItemService.findGoods(itemId);
                if(snPageItem==null){
                    map.put("errmsg","商品不存在");
                    return "suning/uperror";
                }
                if(snPageItem.getItem().getTitle()!=null){
                    snPageItem.setTitleLength(snPageItem.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
                }
                if(snPageItem.getItem().getSellPoint()!=null){
                    snPageItem.setSellPointLength(snPageItem.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
                }
                SnShowDataVo snShowDataVo=new SnShowDataVo();
                snShowDataVo.setUsername(SnUsername);
                snShowDataVo.setSnPageItem(snPageItem);
                snShowDataVo.setDeliveyList(snUpItemService.selPostModel(SnUsername));
                snShowDataVo.setStoreCats(snUpItemService.selShopCats(SnUsername));
                snShowDataVo.setGoodsCat(categoryQueries.get(0).getDescPath().replace("|",">"));
                snShowDataVo.setPropsVo(snUpItemService.selProps(itemId,categoryCode,SnUsername,brands));
                int size=0;
                for(PropItemVo p:snShowDataVo.getPropsVo().getSaleProps()){
                    for(PropValueVo propValueVo:p.getValues()){
                        if(propValueVo.isFirstChange()){
                            System.out.println(propValueVo.getName());
                        }
                        if(propValueVo.isSelected()){
                            size++;
                        }
                    }
                }

                SnToken snToken=new SnToken();
                snToken.setUsername(SnUsername);
                snToken.setCreateTime(new Date());
                String tokenStr=Opt3Des.encryptPlainData(JSONObject.fromObject(snToken).toString());
                snShowDataVo.setToken(tokenStr);
                map.put("allData",snShowDataVo);
                map.put("size",size);
                map.put("id",itemId);
                map.put("sn_yj_sn_session",ps);
                return "suning/sn";
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("errmsg", "该商品暂不支持上传");
            return "suning/uperror";
        }
    }

    /**
     * 苏宁登入页
     *
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        String url = SN_Outh_URL.replace("SN_appkey", SN_appkey).replace("SN_redirect_uri", SN_redirect_uri);
        if (HttpRequestUtil.checkAgentIsMobile(request)) {
            url += "view=wap";
        }
        return "redirect:" + url;
    }

    @RequestMapping("callback")
    public String SnCallback(String code, HttpServletRequest request, HttpSession session) throws Main4Exception{
//        System.out.println(code);
        JSONObject jsonObject = JSONObject.fromObject(Opt3Des.decryptPlainData(code.replace(" ", "+")));
        SnAuthInfoResponse snAuthInfoResponse = (SnAuthInfoResponse) JSONObject.toBean(jsonObject, SnAuthInfoResponse.class);
        SnTokenInfo snTokenInfo = snAuthInfoResponse.getData();
        Subject currentUser = SecurityUtils.getSubject();
        String sun= snTokenInfo.getSuningUserName();
        CaptchaUsernamePasswordToken captchaUsernamePasswordToken = new CaptchaUsernamePasswordToken(sun, null, true, request.getRemoteAddr(), "", UserType.MEMBER);
        captchaUsernamePasswordToken.setLoginFromType(LoginFromType.SN);
        captchaUsernamePasswordToken.setSubKey(sun);
        try{
            currentUser.login(captchaUsernamePasswordToken);
            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(sun,sun, LoginFromType.SN);
            if (personalSession == null || personalSession.getUserId() == null) {
                //还是检查一遍避免 字符串+null 出现
                throw new Main4Exception("授权失败");
            }
            String backUrl = (String) session.getAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            session.removeAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            return "redirect:" + loginSuccessUrl(backUrl);
        }catch (LoginAuthException e){
            if(e.getMsgback().equals(LoginErrorEnum.TO_BIND_XZUSER)){//还没绑定星座网用户,去绑定一下
                return "redirect:/userPhoneBind.htm";
            }else{
                throw e;
            }
        }
    }

    /**
     * 得到登陆成功链接
     *
     * @param backUrl
     * @return
     */
    private String loginSuccessUrl(String backUrl) {
        String toUrl;
        if (backUrl != null && !"http://www.571xz.com/".equals(backUrl)) {//TODO 首页的,等页面改好,这里再去掉
            toUrl = backUrl;
        } else {
            //如果个人,跳到这个,如果商户跳到seller
            toUrl = memberFilter.getSuccessUrl();
        }
        return toUrl;
    }

}
