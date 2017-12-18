package com.shigu.goodsup.jd.actions;

import com.openJar.commons.MD5Attestation;
import com.shigu.buyer.services.MemberSimpleService;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.JdShowDataVO;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAgingtemplService;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.service.JdShopService;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import com.shigu.main4.jd.vo.JdCategoryVO;
import com.shigu.main4.jd.vo.JdShopInfoVO;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tb.common.exceptions.TbException;
import com.shigu.tools.HttpRequestUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created By admin on 2017/12/8/15:38
 */
@Controller
@RequestMapping("zs")
public class JdGoodsuoAction {

    private static final Logger logger = LoggerFactory.getLogger(JdGoodsuoAction.class);

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdShopService jdShopService;

    @Autowired
    private JdCategoryService jdCategoryService;

    @Autowired
    private JdAgingtemplService jdAgingtemplService;


    @Autowired
    private MemberFilter memberFilter;

    @Autowired
    private MemberSimpleService memberSimpleService;

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    @Autowired
    private RedisIO redisIO;


    /**
     * 京东引导登陆页
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        return "redirect:" + jdAuthService.getAuthUrl(HttpRequestUtil.checkAgentIsMobile(request));
    }

    /**
     * 京东CODE回调
     * @param state
     * @param code
     * @return
     * @throws IOException
     */
    @RequestMapping("callback")
    public String jdCallback(String code, String state, HttpServletRequest request,HttpSession session) throws IOException, JdUpException {
        /************检测是否订阅服务**********/
//        SubscribeVO subscribeVO = jdTools.parseState(state);

        /************获取用户登陆信息**********/
        JdAuthedInfoVO jdAuthedInfoVO = jdAuthService.getAuthedInfo(code);
        JdShopInfoVO jdShopInfo = jdShopService.getJdShopInfo(jdAuthedInfoVO.getAccessToken());

        /******************登陆**********************/
        Subject currentUser = SecurityUtils.getSubject();
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                String.valueOf(jdAuthedInfoVO.getUid()), null, false, request.getRemoteAddr(), "", UserType.MEMBER);
        token.setLoginFromType(LoginFromType.JD);
        token.setRememberMe(true);
        token.setSubKey(String.valueOf(jdAuthedInfoVO.getUid()));
        try {
            currentUser.login(token);
            if(currentUser.hasRole(RoleEnum.STORE.getValue())){//有店铺
                PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
                if(StringUtils.isEmpty(ps.getLogshop().getTbNick())){//需要绑定一下淘宝到店
//                    memberSimpleService.updateJdShopNike(ps.getLogshop().getShopId(),jdAuthedInfoVO.getUserNick());
                }
            }
            //得到回调用地址
            String backUrl= (String) session.getAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            session.removeAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue());
            return "redirect:"+loginSuccessUrl(backUrl);
        } catch (LoginAuthException e) {
            if(e.getMsgback().equals(LoginErrorEnum.TO_BIND_XZUSER)){//还没绑定星座网用户,去绑定一下
                return "forward:userPhoneBind.htm";
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
     * 上传页面
     * @return
     */
    @RequestMapping("publish")
    public String publish(Long itemId, Integer yesrepeat, HttpServletRequest request, HttpSession session, Model model) throws JdUpException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        /********************************获取京东授权信息*******************************/

        /********************************屏蔽卖家用户使用********************************/
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole(RoleEnum.STORE.getValue())) {
            model.addAttribute("errmsg", "档口不支持代理功能");
            return "taobao/uperror";
        }
        /********************************查上传记录********************************/
        if (yesrepeat == null || yesrepeat != 1) {
            LastUploadedVO lastup = itemUpRecordService.selLastUpByIds(ps.getUserId(),itemId);
            if (lastup != null) {
                model.addAttribute("lastup", lastup);
                model.addAttribute("goodsId", itemId);
                return "taobao/hasuped";
            }
        }
        /********************************取商品********************************/
        JdPageItem item=null;
        try {
            item= null;
            if(item==null){
                model.addAttribute("errmsg","商品不存在");
                return "taobao/uperror";
            }
            //计算标题与卖点的长度
//            if(item.getItem().getTitle()!=null){
//                item.setTitleLength(item.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
//            }
//            if(item.getItem().getSellPoint()!=null){
//                item.setSellPointLength(item.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
//            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("获取商品数据异常",e);
            model.addAttribute("errmsg","商品信息异常");
            return "taobao/uperror";
        }

        /********************************取京东店家类目********************************/
        List<JdCategoryVO> jdWarecats = jdCategoryService.getJdWarecats("");

        /********************************手机详情验签********************************/
        JdShowDataVO allData=new JdShowDataVO();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("goodsId", itemId);
        map.put("jdUserId", "");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        map.put("dd", sdf.format(new Date()));
        allData.setMobileSign(MD5Attestation.signParam(map));


        /********************************日期来10条********************************/
        Calendar cal=Calendar.getInstance();
        List<Date> dateList=new ArrayList<>();
        for(int i=0;i<10;i++){
            dateList.add(cal.getTime());
            cal.add(Calendar.DATE,1);
        }
        allData.setDateList(dateList);

        /********************************查出以前用过的快递模板********************************/
        try {
            final String usrJdId="templateId_"+"";
            String templateId= redisIO.get(usrJdId);
            if(templateId!=null){
                allData.setErverDyTemplateId(Long.valueOf(templateId));
            }
        } catch (Exception e) {//这块出问题没那么重要
            logger.error("redis templateId get error",e);
        }

        /********************************包装所有数据********************************/
        allData.setJdUserId(0L);
        allData.setJdNick("");

        allData.setDeliveyList(jdAgingtemplService.getAgingtempl(""));
        allData.setJdShopInfo(null);

        allData.setJdUserId(0L);
        model.addAttribute("allData", allData);
        model.addAttribute("id",itemId);
        model.addAttribute("jd_yj_zh_session",null);

        //测试用
        return "taobao/tb2";
    }


    /**
     * 店内类目更新
     * @return
     */
    @RequestMapping("jd-shop-cat-update")
    public String shopCatUpdate(HttpSession httpsession,HttpServletRequest request,Model model)  {
        PersonalSession ps = (PersonalSession) httpsession.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        return "taobao/parts/storecat";
    }

    /**
     * 更新物流
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping("jd-express-update")
    public String expressUpdate(HttpSession httpSession,HttpServletRequest request,Model model)  {
        PersonalSession ps = (PersonalSession) httpSession.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        //这里查以前使用过的templateId
        model.addAttribute("erverDyTemplateId","");
        return "taobao/parts/deliver";
    }

    /**
     * 上传图片到星座网
     * @return
     */
    @RequestMapping("jd-up-xzw-img")
    @ResponseBody
    public String upxzwimg(@RequestParam(value = "multimagefile1") MultipartFile multimagefile, HttpSession httpSession) {
        PersonalSession ps = (PersonalSession) httpSession.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String name=MD5Attestation.MD5Encode(multimagefile.getName()+Math.random())+".jpg";
        return null;
    }

    /**
     * 更新橱窗数
     * @return
     */
    @RequestMapping("jd-windowsnum-update")
    public String windowsnumUpdate(HttpSession httpsession,HttpServletRequest request,Model model) {
        PersonalSession ps = (PersonalSession) httpsession.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        model.addAttribute("shop", null);
        return "taobao/parts/windowsnum";
    }

    /**
     * 品牌,更多
     * @param cid
     * @param value
     * @return
     */
    @RequestMapping("jd-propmore")
    @ResponseBody
    public JSONObject propMore(Long cid, String value){
        return null;
    }

    /**
     * 做手机详情
     * @return
     */
    @RequestMapping("jd-make-mobile-desc")
    @ResponseBody
    public JSONObject makeMobileDesc(String imgList, @RequestParam("num_iid") Long numIid, HttpServletRequest request, HttpSession httpsession)  {
        PersonalSession ps = (PersonalSession) httpsession.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        return JSONObject.fromObject("{'status':'0'}");
    }

    /**
     * 查单个品牌
     * @param cid
     * @param key
     * @return
     */
    @RequestMapping("jd-prop-select")
    public String propSelect(Long cid,String key,Model model){

        return "taobao/parts/propselect";
    }

}
