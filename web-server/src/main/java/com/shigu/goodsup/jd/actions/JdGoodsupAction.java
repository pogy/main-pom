package com.shigu.goodsup.jd.actions;

import com.openJar.beans.JdImgInfo;
import com.openJar.commons.MD5Attestation;
import com.openJar.exceptions.imgs.JdUpImgException;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.goodsup.jd.exceptions.JdNotBindException;
import com.shigu.goodsup.jd.service.*;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.JdShowDataVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.*;
import com.shigu.main4.jd.vo.*;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.HttpRequestUtil;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
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
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created By admin on 2017/12/8/15:38
 */
@Controller
@RequestMapping("jd")
public class JdGoodsupAction {

    private static final Logger logger = LoggerFactory.getLogger(JdGoodsupAction.class);

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdGoodsUpService jdGoodsUpService;

    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private JdCategoryService jdCategoryService;

    @Autowired
    private JdPostageTemplateService jdPostageTemplateService;

    @Autowired
    private JdGoodsService jdGoodsService;

    @Autowired
    private MemberFilter memberFilter;

    @Autowired
    private ItemUpRecordService itemUpRecordService;

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private OssIO ossIO;

    @Autowired
    private JdImgService jdImgService;

//    @Autowired
//    private JdUpItemService jdUpItemService;

    @Autowired
    private JdUserInfoService jdUserInfoService;


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

        /******************登陆**********************/
        Subject currentUser = SecurityUtils.getSubject();
        String strJdUid = String.valueOf(jdAuthedInfoVO.getUid());
        CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(
                strJdUid, null, false, request.getRemoteAddr(), "", UserType.MEMBER);
        token.setLoginFromType(LoginFromType.JD);
        token.setRememberMe(true);
        token.setSubKey(strJdUid);
        try {
            currentUser.login(token);
            //京东暂时只支持一键上传
//            if(currentUser.hasRole(RoleEnum.STORE.getValue())){//有店铺
//                PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//                if(StringUtils.isEmpty(ps.getLogshop().getTbNick())){//需要绑定一下淘宝到店
////                    memberSimpleService.updateJdShopNike(ps.getLogshop().getShopId(),jdAuthedInfoVO.getUserNick());
//                }
//            }

            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(strJdUid,strJdUid, LoginFromType.JD);
            if (personalSession == null || personalSession.getUserId() == null) {
                //还是检查一遍避免 字符串+null 出现
                throw new JdUpException("授权失败");
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
     * @throws JdUpException
     */
    @RequestMapping("canbeUploaded")
    @ResponseBody
    public JSONObject canbeUploaded(Long itemId) throws JdUpException {
        Boolean canbeUploaded = jdGoodsUpService.goodsCanbeUploadedToJd(itemId);
        return JsonResponseUtil.success().element("canbeUploaded",canbeUploaded);
    }

    /**
     * 查询用户是否已上传过
     * @param itemId
     * @return
     * @throws JdUpException
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
    public JSONObject getAllBrand(HttpSession session) throws JdUpException, JdNotBindException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        List<JdVenderBrandPubInfoVO> allBrand = jdCategoryService.getAllBrand(Long.valueOf(jdUid));
        return JsonResponseUtil.success().element("allBrand",allBrand);
    }


    /**
     * 获取用户所拥有的品牌
     */
    @RequestMapping("getPostageTemplateList")
    @ResponseBody
    public JSONObject getPostageTemplateList(HttpSession session) throws JdUpException, JdNotBindException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<JdPostTemplateVO> postageTemplateList = jdPostageTemplateService.getPostageTemplateList(ps.getSubUserId());
        return JsonResponseUtil.success().element("postageTemplateList",postageTemplateList);
    }



    /**
     * 上传页面
     * @return
     */
    @RequestMapping("publish")
    public String publish(Long itemId, Integer yesrepeat, HttpServletRequest request, HttpSession session, Model model) throws Main4Exception, ClassNotFoundException, CloneNotSupportedException, IOException {

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        /********************************获取京东授权信息*******************************/

        /********************************屏蔽卖家用户使用********************************/
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole(RoleEnum.STORE.getValue())) {
            model.addAttribute("errmsg", "档口不支持代理功能");
            return "taobao/uperror";
        }
        /********************************查上传记录********************************/

        //todo jd上传记录查询
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
            if(item.getItem().getTitle()!=null){
                item.setTitleLength(item.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
            }
            if(item.getItem().getSellPoint()!=null){
                item.setSellPointLength(item.getItem().getSellPoint().getBytes(Charset.forName("GBK")).length);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("获取商品数据异常",e);
            model.addAttribute("errmsg","商品信息异常");
            return "taobao/uperror";
        }

        /********************************取京东店家类目********************************/
//        PropsVO props= jdUpItemService.selProps(itemId,ps.getSubUserId());

        List<JdCategoryVO> jdWarecats = jdCategoryService.getJdWarecats(null);

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

        allData.setDeliveyList(jdPostageTemplateService.getPostageTemplateList(ps.getSubUserId()));
        allData.setJdShopInfo(null);

        allData.setJdUserId(0L);
        model.addAttribute("allData", allData);
        model.addAttribute("id",itemId);
        model.addAttribute("jd_yj_zh_session",null);

        //测试用
        return "jd/publish";
    }

    @RequestMapping("jdYjUpload")
    @ResponseBody
    public JSONObject jdYjUpload(Long goodsId,String skuColorIds,HttpSession session) throws JdUpException, JdNotBindException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());


        //上传商品
        JdWareAddVO jdWareAddVO = jdGoodsService.upToJd(null, null);


        //绑定图片
        //颜色ID集合
        List<String> colorIds = new ArrayList<>();
        for(String skuColorId : colorIds){
            //根据skuColorId 获取图片地址集合
            List<String> imgUrls = new ArrayList<>();
            //图片搬家
            List<String> subMsgs=new ArrayList<>();
            JdUpImgResponse response = null;
            try {
                response = jdImgService.addImgs(ps.getSubUserId(), imgUrls);
                //1，操作成功；0，操作失败
                if ("0".equals(response.getReturnCode())) {
                    return JSONObject.fromObject("{'status':'0'}");
                }
            } catch (JdUpImgException e) {
                e.printStackTrace();
                subMsgs.add(e.getErrMsg());
            } catch (JdNotBindException e) {
                e.printStackTrace();
                subMsgs.add(e.getMessage());
            }
            List<JdImgInfo> jdImgInfos = response.getJdImgInfos();
            StringBuffer imgIds = new StringBuffer();
            StringBuffer skuImgUrls = new StringBuffer();
            StringBuffer imgIndex = new StringBuffer();
            int index = 1;//index值：1-N
            for(JdImgInfo imgInfo : jdImgInfos){
                imgIds.append(",").append(imgInfo.getPictureId());
                String pictureUrl = imgInfo.getPictureUrl();
                String skuImgUrl= pictureUrl.substring(pictureUrl.indexOf("jfs/"));
                skuImgUrls.append(",").append(skuImgUrl);
                imgIndex.append(",").append(index);
                index++;
            }
            //遍历颜色，设置图片
            JdImageUpdateBO jdImageUpdateBO = new JdImageUpdateBO();
            jdImageUpdateBO.setGoodsId(goodsId);
            jdImageUpdateBO.setColorId(skuColorId);
            jdImageUpdateBO.setImgId(imgIds.toString());
            jdImageUpdateBO.setImgUrl(skuImgUrls.toString());
            jdImageUpdateBO.setImgIndex(imgIndex.toString());
//            jdImageUpdateBO.setImgZoneId(null);

            jdImgService.bindGoodsImgs(jdImageUpdateBO,ps.getSubUserId());

        }

        //添加上传记录 TODO 传什么
        ItemUpRecordVO vo=new ItemUpRecordVO();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        vo.setDaiTime(sdf.format(new Date()));
//        vo.setFenGoodsName(subedItem.getTitle());
//        vo.setFenImage(subedItem.getPicUrl());
//        vo.setFenPrice(subedItem.getPrice());
        vo.setFenNumiid(jdWareAddVO.getGoodsId());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        JdAuthedInfoVO jdAuthedInfoVO = jdAuthService.getAuthedInfo(Long.valueOf(jdUid));

        vo.setFenUserId(jdAuthedInfoVO.getUid());
        vo.setFenUserNick(jdAuthedInfoVO.getUserNick());
        vo.setFlag("jd");
        vo.setSupperGoodsId(goodsId);
        jdGoodsUpService.saveRecord(vo);

        return null;
    }

    /**
     * 上传图片到星座网
     * @return
     */
    @RequestMapping("jd-up-xzw-img")
    @ResponseBody
    public String upxzwimg(@RequestParam(value = "multimagefile1") MultipartFile multimagefile, HttpSession httpSession) throws IOException {
        PersonalSession ps = (PersonalSession) httpSession.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String name=MD5Attestation.MD5Encode(multimagefile.getName()+Math.random())+".jpg";
        return ossIO.uploadFile(multimagefile.getInputStream(),"jdonkey"+"/"+ps.getUserId()+"/"+name);
    }

}
