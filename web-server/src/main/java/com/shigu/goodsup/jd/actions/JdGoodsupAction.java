package com.shigu.goodsup.jd.actions;

import com.openJar.beans.JdImgInfo;
import com.openJar.commons.MD5Attestation;
import com.openJar.exceptions.imgs.JdUpImgException;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.LoginErrorEnum;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.component.shiro.exceptions.LoginAuthException;
import com.shigu.component.shiro.filters.MemberFilter;
import com.shigu.goodsup.jd.exceptions.JdNotBindException;
import com.shigu.goodsup.jd.service.JdGoodsUpService;
import com.shigu.goodsup.jd.service.JdImgService;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.service.JdUserInfoService;
import com.shigu.goodsup.jd.util.JdParseStateUtil;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.jd.vo.JdShowDataVO;
import com.shigu.goodsup.jd.vo.StoreCatVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.jd.bo.JdImageUpdateBO;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.*;
import com.shigu.main4.jd.vo.*;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.HttpRequestUtil;
import com.shigu.tools.JsonResponseUtil;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.DeliveryTemplate;
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
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    private JdAuthService jdAuthService;

    @Autowired
    private JdGoodsUpService jdGoodsUpService;

    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private JdCategoryService jdCategoryService;

    @Autowired
    private JdGoodsService jdGoodsService;

    @Autowired
    private MemberFilter memberFilter;

    @Autowired
    private OssIO ossIO;

    @Autowired
    private JdImgService jdImgService;

    @Autowired
    private JdUpItemService jdUpItemService;

    @Autowired
    private JdUserInfoService jdUserInfoService;

    @Autowired
    private JdShopService jdShopService;

    @Autowired
    private JdServiceMarketService jdServiceMarketService;

    public static final String IMG_CATEGORY = "571xz";


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
    public String jdCallback(String code, String state, HttpServletRequest request,HttpSession session) throws IOException, JdUpException, JdAuthFailureException {
        /************检测是否订阅服务**********/
//        JdVasSubscribeVO subscribeVO = JdParseStateUtil.parseState(state);
//        if (subscribeVO.getEndDate().after(new Date())) {
//            //FW_GOODS-449409
//            String itemId = subscribeVO.getItemCode().replace("FW_GOODS-", "");
//            if (StringUtils.isEmpty(itemId)) {
//                throw new JdUpException("获取服务信息失败");
//            }
//            return "redirect:https://fw.jd.com/"+itemId+".html";
//        }

        /************获取用户登陆信息**********/
        JdAuthedInfoVO jdAuthedInfoVO = jdAuthService.getAuthedInfo(code);
        //保存订购信息
//        subscribeVO.setJdUid(jdAuthedInfoVO.getUid());
//        jdServiceMarketService.saveSubscribe(subscribeVO);

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
    public JSONObject getAllBrand(HttpSession session) throws JdUpException, JdNotBindException, JdAuthFailureException, IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        List<JdVenderBrandPubInfoVO> allBrand = jdCategoryService.getAllBrand(Long.valueOf(jdUid));
        return JsonResponseUtil.success().element("allBrand",allBrand);
    }

    @RequestMapping("getJdGoodsInfo")
    @ResponseBody
    public JSONObject jdGoodsInfo(Long goodsId) throws Main4Exception {
        Item item= jdUpItemService.staticGoods(jdUpItemService.selTiny(goodsId));
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
    public JSONObject updatePostModel(HttpSession session) throws JdUpException, JdNotBindException, JdAuthFailureException, IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        List<DeliveryTemplate> deliveryTemplates = jdUpItemService.updatePostModel(Long.valueOf(jdUid));
        return  JsonResponseUtil.success().element("deliveryTemplates",deliveryTemplates);
    }

    /**
     * 更新店内类目
     */
    @RequestMapping("updateShopCats")
    @ResponseBody
    public JSONObject updateShopCats(HttpSession session) throws JdUpException, JdNotBindException, JdAuthFailureException, IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String jdUid = jdUserInfoService.getJdUidBySubUid(ps.getSubUserId());
        List<StoreCatVO> storeCatVOS = jdUpItemService.updateShopCats(Long.valueOf(jdUid));
        return  JsonResponseUtil.success().element("storeCatVOS",storeCatVOS);
    }


    /**
     * 上传页面
     * @return
     */
    @RequestMapping("publish")
    public String publish(Long itemId, Integer yesrepeat, HttpServletRequest request, HttpSession session, Model model) throws Main4Exception, ClassNotFoundException, CloneNotSupportedException, IOException {

//        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//        if(ps==null){
//            String queryString=request.getQueryString();
//            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=6&backUrl="+ URLEncoder.encode(request.getRequestURL().toString()+
//                    (queryString==null?"":("?"+queryString)),"utf-8");
//        }
        /********************************获取京东授权信息*******************************/
//        Long jdUserId = new Long(jdUserInfoService.getJdUidBySubUid(ps.getSubUserId()));
        Long jdUserId=2299600652L;


        /********************************屏蔽卖家用户使用********************************/
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole(RoleEnum.STORE.getValue())) {
            model.addAttribute("errmsg", "档口不支持代理功能");
            return "taobao/uperror";
        }
        /********************************查上传记录********************************/

        //todo jd上传记录查询
//        if (yesrepeat == null || yesrepeat != 1) {
//            LastUploadedVO lastup = itemUpRecordService.selLastUpByIds(ps.getUserId(),itemId);
//            if (lastup != null) {
//                model.addAttribute("lastup", lastup);
//                model.addAttribute("goodsId", itemId);
//                return "taobao/hasuped";
//            }
//        }
        List<JdVenderBrandPubInfoVO> allBrand = null;
        try {
            allBrand = jdCategoryService.getAllBrand(jdUserId);
        } catch (JdUpException e) {
            String queryString=request.getQueryString();
            return "redirect:http://www.571xz.com/ortherLogin.htm?ortherLoginType=6&backUrl="+ URLEncoder.encode(request.getRequestURL().toString()+
                    (queryString==null?"":("?"+queryString)),"utf-8");
        }
        if(allBrand==null){
            model.addAttribute("errmsg", "不是京东商家");
            return "taobao/uperror";
        }
        /********************************取商品********************************/
        JdPageItem item=null;
        try {
            item= jdUpItemService.findGoods(itemId);
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

        /********************************包装所有数据********************************/
        JdShowDataVO allData=new JdShowDataVO();
        allData.setItems(item);
        allData.setJdUserId(jdUserId);
        allData.setDeliveyList(jdUpItemService.selPostModel(jdUserId));
        allData.setProps(jdUpItemService.selProps(itemId,item.getJdCid(),jdUserId,item.getItem(),allBrand));
        allData.setStoreCats(jdUpItemService.selShopCats(jdUserId));
        allData.setJdUserId(jdUserId);
        allData.setGoodsCat(jdUpItemService.selCatPath(item.getJdCid()));
        model.addAttribute("allData", allData);
        model.addAttribute("id",itemId);
        model.addAttribute("jd_yj_zh_session",null);

        //测试用
        return "jingdong/jd";
    }

    @RequestMapping("jdYjUpload")
    @ResponseBody
    public JSONObject jdYjUpload(Long goodsId,String skuColorIds,HttpSession session) throws JdUpException, JdNotBindException, JdAuthFailureException, IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
//        Long jdUid = Long.valueOf(jdUserInfoService.getJdUidBySubUid(ps.getSubUserId()));
        Long jdUid = 2299600652L;
        //上传商品
        JdWareAddVO jdWareAddVO = jdGoodsService.upToJd(null, jdUid);

        //查看星座上传图片类目是否存在
        List<JdImgzoneCategoryVO> vos = jdShopService.selImgCategory(jdUid,"商品货号",null);
        Long imgCategoryId;
        Long pImgCategoryId;
        if (vos == null || vos.isEmpty()) {
            //查图片主类目
            List<JdImgzoneCategoryVO> pvos = jdShopService.selImgCategory(jdUid,IMG_CATEGORY,null);
            if (pvos == null || pvos.isEmpty()) {
                pImgCategoryId = jdShopService.addImgCategory(jdUid, IMG_CATEGORY, null);
            }else {
                pImgCategoryId = pvos.get(0).getCateId();
            }
            imgCategoryId = jdShopService.addImgCategory(jdUid, "商品货号", pImgCategoryId);
        }else{
            imgCategoryId = vos.get(0).getCateId();
        }


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
                JdUpImgRequest request = new JdUpImgRequest();
                request.setJdUid(jdUid);
                request.setImgUrls(imgUrls);
                request.setPictureCateId(imgCategoryId);
                response = jdImgService.addImgs(request);
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
            Map<String, JdImgInfo> jdImgInfos1 = response.getJdImgInfos();
            List<JdImgInfo> jdImgInfos = new ArrayList<>();
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
        JdAuthedInfoVO jdAuthedInfoVO = jdAuthService.getAuthedInfo(jdUid);

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
