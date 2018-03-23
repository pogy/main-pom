package com.shigu.goodsup.jd.actions;

import com.openJar.beans.JdAuthedInfo;
import com.openJar.beans.JdToken;
import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.responses.api.JdAuthedInfoResponse;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.*;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.JdShowDataVO;
import com.shigu.goodsup.jd.vo.StoreCatVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.HttpRequestUtil;
import com.shigu.tools.JsonResponseUtil;
import com.taobao.api.domain.DeliveryTemplate;
import com.taobao.api.domain.Item;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By admin on 2017/12/8/15:38
 */
@Controller
@RequestMapping("jd")
public class JdGoodsupAction {

    private static final Logger logger = LoggerFactory.getLogger(JdGoodsupAction.class);

    @Autowired
    private JdGoodsUpService jdGoodsUpService;

    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private MemberFilter memberFilter;

    @Autowired
    private JdUpItemService jdUpItemService;

    @Autowired
    private JdUserInfoService jdUserInfoService;

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    @Autowired
    private JdCategoryService jdCategoryService;

    public static final String IMG_CATEGORY = "571xz";

    public static final String JD_AUTH_URL = "https://oauth.jd.com/oauth/authorize?response_type=code&client_id=JD_APPKEY&redirect_uri=JD_REDIRECT_URI&state=JD_STATE";

    @Value("${jd.app.key}")
    private String jdAppkey;

    @Value("${jd.app.secret}")
    private String jdSecret;

    @Value("${jd.app.state}")
    private String jdState;

    @Value("${jd.app.redirect_uri}")
    private String jdRedirectUri;

    /**
     * 京东引导登陆页
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        String url = JD_AUTH_URL
                .replace("JD_APPKEY",jdAppkey)
                .replace("JD_REDIRECT_URI",jdRedirectUri)
                .replace("JD_STATE",jdState);

        if (HttpRequestUtil.checkAgentIsMobile(request)){
            url += "view=wap";
        }
        return "redirect:" + url;
    }

    /**
     * 京东CODE回调
     * @param code
     * @return
     * @throws IOException
     */
    @RequestMapping("callback")
    public String jdCallback(String code, HttpServletRequest request,HttpSession session) throws Main4Exception {
        JSONObject jsonObject = JSONObject.fromObject(Opt3Des.decryptPlainData(code.replace(" ", "+")));
        JdAuthedInfoResponse res = (JdAuthedInfoResponse) JSONObject.toBean(jsonObject, JdAuthedInfoResponse.class);
        JdAuthedInfo jdAuthedInfo=res.getData();
        /******************登陆**********************/
        Subject currentUser = SecurityUtils.getSubject();
        String strJdUid = String.valueOf(jdAuthedInfo.getUid());
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                strJdUid, null, false, request.getRemoteAddr(), "", UserType.MEMBER);
        token.setLoginFromType(LoginFromType.JD);
        token.setRememberMe(true);
        token.setSubKey(strJdUid);
        try {
            currentUser.login(token);
            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(strJdUid,strJdUid, LoginFromType.JD);
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
            toUrl=memberFilter.getSuccessUrl();
        }
        return toUrl;
    }

    /**
     * 查询商品是否可京东上传
     * @param itemId
     * @return
     */
    @RequestMapping("canbeUploaded")
    @ResponseBody
    public JSONObject canbeUploaded(Long itemId){
        Boolean canbeUploaded = jdGoodsUpService.goodsCanbeUploadedToJd(itemId);
        return JsonResponseUtil.success().element("canbeUploaded",canbeUploaded);
    }

    /**
     * 查询用户是否已上传过
     * @param itemId
     * @return
     */
    @RequestMapping("hasBeUploaded")
    @ResponseBody
    public JSONObject hasBeUploaded(Long itemId,HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Boolean hasBeUploaded = jdGoodsUpService.hasBeUploaded(ps.getUserId(),itemId);
        return JsonResponseUtil.success().element("hasBeUploaded",hasBeUploaded);
    }

    /**
     * 获取用户所拥有的品牌
     */
    @RequestMapping("getAllBrand")
    @ResponseBody
    public JSONObject getAllBrand(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        List<JdVenderBrandPubInfo> allBrand = jdCategoryService.getAllBrand(Long.valueOf(jdUid));
        if (allBrand == null) {
            return JsonResponseUtil.success().element("allBrand",new ArrayList());
        }
        return JsonResponseUtil.success().element("allBrand",allBrand);
    }

    @RequestMapping("getJdGoodsInfo")
    @ResponseBody
    public JSONObject jdGoodsInfo(Long goodsId){
        Item item;
        try {
            item = jdUpItemService.staticGoods(jdUpItemService.selTiny(goodsId));
        } catch (CustomException e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        Map<String,String> map=new HashMap<>();
        Arrays.stream(item.getPropsName().split(";")).forEach(s -> {
            String[] strs=s.split(":");
            String str=map.get(strs[2]);
            if(str==null){
                str="";
            }
            str+=strs[3]+",";
            map.put(strs[2],str);
        });
        return JsonResponseUtil.success().element("attrList",map.entrySet().stream().map(s -> {
            JSONObject o=new JSONObject();
            o.put("name",s.getKey());
            o.put("value",s.getValue().substring(0,s.getValue().length()-1));
            return o;
        }).collect(Collectors.toList()));
    }


    /**
     * 更新运费模板
     */
    @RequestMapping("updatePostModel")
    @ResponseBody
    public JSONObject updatePostModel(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        List<DeliveryTemplate> deliveryTemplates;
        try {
            deliveryTemplates = jdUpItemService.updatePostModel(Long.valueOf(jdUid));
        } catch (AuthOverException e) {
            return JsonResponseUtil.error("授权失效");
        } catch (CustomException e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return  JsonResponseUtil.success().element("deliveryTemplates",deliveryTemplates);
    }

    /**
     * 更新店内类目
     */
    @RequestMapping("updateShopCats")
    @ResponseBody
    public JSONObject updateShopCats(HttpSession session)  {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        List<StoreCatVO> storeCatVOS = null;
        try {
            storeCatVOS = jdUpItemService.selShopCats(Long.valueOf(jdUid));
        } catch (AuthOverException e) {
            return JsonResponseUtil.error("授权失效");
        } catch (CustomException e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return  JsonResponseUtil.success().element("storeCatVOS",storeCatVOS);
    }


    /**
     * 上传页面
     * @return
     */
    @RequestMapping("publish")
    public String publish(Long itemId, Integer yesrepeat,HttpServletRequest request, HttpSession session, Model model) throws ClassNotFoundException, CloneNotSupportedException, IOException {
        try {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            if(ps==null){
                String queryString = request.getQueryString();
                return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=6&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                        (queryString == null ? "" : ("?" + queryString)), "utf-8");
            }
            /********************************获取京东授权信息*******************************/
            Long jdUserId = new Long(jdUserInfoService.getJdUidBySubUid(ps.getSubUserId()));

            /********************************屏蔽卖家用户使用********************************/
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser.hasRole(RoleEnum.STORE.getValue())) {
                throw new CustomException("档口不支持代理功能");
            }
            /********************************查上传记录********************************/

            if (yesrepeat == null || yesrepeat != 1) {
                LastUploadedVO lastup = itemUpRecordService.selLastUpByIds(ps.getUserId(),itemId);
                if (lastup != null) {
                    model.addAttribute("lastup", lastup);
                    model.addAttribute("goodsId", itemId);
                    return "jingdong/hasuped";
                }
            }
            List<JdVenderBrandPubInfo> allBrand = null;
            allBrand = jdCategoryService.getAllBrand(jdUserId);
            if(allBrand==null){
                throw new CustomException("不是京东商家");
            }
            /********************************取商品********************************/
            JdPageItem item;
            try {
                item= jdUpItemService.findGoods(itemId);
                if(item==null){
                    model.addAttribute("errmsg","商品不存在");
                    return "jingdong/uperror";
                }
                //计算标题与卖点的长度
                if(item.getItem().getTitle()!=null){
                    item.setTitleLength(item.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
                }
                if(item.getItem().getSellPoint()!=null){
                    item.setSellPointLength(item.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.error("获取商品数据异常",e);
                throw new CustomException("商品信息异常");
            }
            /********************************包装所有数据********************************/
            JdShowDataVO allData=new JdShowDataVO();
            allData.setItems(item);
            allData.setJdUserId(jdUserId);
            allData.setDeliveyList(jdUpItemService.selPostModel(jdUserId));
            allData.setProps(jdUpItemService.selProps(itemId,item.getJdCid(),jdUserId,item.getItem(),allBrand));
            allData.setStoreCats(jdUpItemService.selShopCats(jdUserId));
            allData.setGoodsCat(jdUpItemService.selCatPath(item.getJdCid()));

            JdToken token=new JdToken();
            token.setId(jdUserId);
            token.setCreateTime(new Date());
            String tokenStr=Opt3Des.encryptPlainData(JSONObject.fromObject(token).toString());
            allData.setToken(tokenStr);

            model.addAttribute("allData", allData);
            model.addAttribute("id",itemId);
            model.addAttribute("jd_yj_zh_session",ps);

            return "jingdong/jd";


        } catch (CustomException e) {
            model.addAttribute("errmsg", e.getMessage());
            return "jingdong/uperror";
        } catch (AuthOverException e) {
            String queryString = request.getQueryString();
            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=6&backUrl=" + URLEncoder.encode(request.getRequestURL().toString() +
                    (queryString == null ? "" : ("?" + queryString)), "utf-8");
        }
    }
}
