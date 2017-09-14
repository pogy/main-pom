package com.shigu.buyer.actions;

import com.alibaba.fastjson.JSON;
import com.searchtool.configs.ElasticConfiguration;
import com.shigu.buyer.bo.*;
import com.shigu.buyer.services.GoodsupRecordSimpleService;
import com.shigu.buyer.services.MemberSimpleService;
import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.buyer.services.UserAccountService;
import com.shigu.buyer.vo.*;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.exceptions.ShopRegistException;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.*;
import com.shigu.main4.ucenter.webvo.ItemCollectVO;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.main4.vo.ShopApply;
import com.shigu.main4.vo.ShopApplyDetail;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.PhoneVerify;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.session.main4.tool.BeanMapper;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.tools.DateParseUtil;
import com.shigu.tools.EmailUtil;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.XzSdkClient;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 会员中心
 * Created by zhaohongbo on 17/3/1.
 */
@Controller
public class MemberAction {
    private static final Logger logger = Logger.getLogger(UserLoginAction.class);

    @Autowired
    PaySdkClientService paySdkClientService;

    @Autowired
    UserBaseService userBaseService;

    @Autowired
    UserCollectService userCollectService;

    @Autowired
    ItemUpRecordService itemUpRecordService;

    /**
     * 用户权益服务
     */
    @Autowired
    UserLicenseService userLicenseService;
    /**
     * 店铺注册
     */
    @Autowired
    ShopRegistService shopRegistService;

    @Autowired
    XzSdkClient xzSdkClient;

    @Autowired
    MemberSimpleService memberSimpleService;

    @Autowired
    OssIO ossIO;

    @Autowired
    SpreadService spreadService;

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    GoodsupRecordSimpleService goodsupRecordSimpleService;
    /**
     * 分销商首页
     * @return
     */
    @RequestMapping({"member/index","member/memberDispense"})//后面一个地址,临时用一下
    public String index(HttpSession session, Model model){
        //如果有店铺权限,进商户中心
        if(SecurityUtils.getSubject().hasRole(RoleEnum.STORE.getValue())){
            return "redirect:/seller/index.htm";
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempCode=paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode",tempCode);
        model.addAttribute("jifenCount",userLicenseService.selUserScore(ps.getUserId()));
        // 分销商广告
        List<ImgBannerVO> imageGoat = spreadService.selImgBanners(SpreadEnum.BACK_MEMBER).selReal();
        if (!imageGoat.isEmpty()) {
            ImgBannerVO imgBannerVO = imageGoat.get(0);
            model.addAttribute("imgsrc", imgBannerVO.getImgsrc());
            model.addAttribute("tHref", imgBannerVO.getHref());
        }
        return "buyer/memberfxs";
    }


    /**
     * 第三方账号绑定
     * @return
     */
    @RequestMapping("member/fenxiaoZhanghao")
    public String fenxiaoZhanghao(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<OuterUser> outerUsers = userBaseService.selOuterUsers(ps.getUserId());
        for(OuterUser ou:outerUsers){
            OuterUserVO vo = new OuterUserVO(ou);
            model.addAttribute("outer_" + vo.getFrom(), vo);
        }
        return "buyer/fenxiaoZhanghao";
    }

    /**
     * 第三方用户解绑
     * @return
     */
    @RequestMapping("member/jsonUnbind")
    @ResponseBody
    public JSONObject jsonUnbind(Long subUserId,HttpSession session) throws JsonErrException {
        if(subUserId==null){
            throw new JsonErrException("缺少关键数据");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userBaseService.unBindUser(ps.getUserId(),subUserId);
        return JsonResponseUtil.success();
    }

    /**
     * 个人中心,我的数据包
     * @return
     */
    @RequestMapping("member/goodsCollectinit")
    public String goodsCollectinit(GoodsCollectBO bo,HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            if(!StringUtils.isEmpty(bo.getKeyword())){
                bo.setKeyword(URLDecoder.decode(bo.getKeyword(),"UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ShiguPager<ItemCollectVO> pager=userCollectService.selItemCollections(ps.getUserId(),bo.getKeyword(), bo.getWebsite(),
                bo.getPage(),bo.getRows());
        if(pager.getContent()!=null)
        model.addAttribute("goodslist",BeanMapper.mapList(pager.getContent(),GoodsCollectVO.class));
        model.addAttribute("pageOption",pager.selPageOption(bo.getRows()));
        model.addAttribute("get",bo);
        model.addAttribute("website",bo.getWebsite());
        model.addAttribute("keyword", bo.getKeyword());
        return "buyer/goodsCollectinit";
    }

    /**
     * 删除收藏
     * @return
     */
    @RequestMapping("member/rmv_mydp")
    @ResponseBody
    public JSONObject rmv_mydp(String ids,HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.delItemCollection(ps.getUserId(),parseIds(ids));
        return JsonResponseUtil.success();
    }

    /**
     * 个人中心,我的收藏,
     * @return
     */
    @RequestMapping("member/goodsCollect")
    public String goodsCollect(GoodsCollectBO bo,HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<ItemCollectVO> pager = userCollectService.selItemCollectionsByType(ps.getUserId(), bo.getKeyword(), bo.getWebsite(),
                bo.getPage(), bo.getRows(), bo.getType());
        if(pager.getContent()!=null)
            model.addAttribute("goodslist",BeanMapper.mapList(pager.getContent(),GoodsCollectVO.class));
        model.addAttribute("pageOption",pager.selPageOption(bo.getRows()));
        model.addAttribute("get",bo);
        model.addAttribute("website",bo.getWebsite());
        model.addAttribute("keyword", bo.getKeyword());

        return "buyer/goodsCollect";
    }

    /**
     * 创建数据包
     * @return
     */
    @RequestMapping("member/mk_mydp")
    @ResponseBody
    public JSONObject mk_mydp(String ids,HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.createDataPackageByCoolectIds(ps.getUserId(),parseIds(ids));
        return JsonResponseUtil.success();
    }


    /**
     * 数据包列表页面
     * @return
     */
    @RequestMapping("member/goodsDataPackageinit")
    public String goodsDataPackageinit(DataPackageBO bo,HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<DataPackage> pager=userCollectService.selPackages(ps.getUserId(),bo.getPage(),bo.getRows());
        model.addAttribute("website",bo.getWebsite());
        model.addAttribute("pageOption",pager.selPageOption(bo.getRows()));
        model.addAttribute("get",bo);
        model.addAttribute("page",bo.getPage());
        List<PackageVO> goodslist=new ArrayList<>();
        for(DataPackage dp:pager.getContent()){
            if(dp.getGoods()!=null)
                goodslist.add(new PackageVO(dp));
        }
        model.addAttribute("goodslist",goodslist);
        return "buyer/goodsDataPackageinit";
    }

    /**
     * ID串转货
     * @param ids
     * @return
     * @throws JsonErrException
     */
    private List<Long> parseIds(String ids) throws JsonErrException {
        if(ids==null){
            throw new JsonErrException("ids参数异常");
        }
        List<Long> idslist=new ArrayList<>();
        String[] idsarr=ids.split(",");
        for(String id:idsarr){
            idslist.add(Long.valueOf(id));
        }
        return idslist;
    }

    /**
     * 删除数据包
     * @return
     */
    @RequestMapping("member/rmv_zipdp")
    @ResponseBody
    public JSONObject rmv_zipdp(String ids,HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.delPackagesById(ps.getUserId(),parseIds(ids));
        return JsonResponseUtil.success();
    }

    /**
     * 展示淘宝一键上传的商品
     * @return
     */
    @RequestMapping("member/shiguOnekeyRecordinit")
    public String shiguOnekeyRecordinit(OnekeyRecordBO bo,HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SearchRequestBuilder srb = ElasticConfiguration.searchClient.prepareSearch("shigugoodsup");
        QueryBuilder userQuery = QueryBuilders.termQuery("fenUserId", ps.getUserId());
        QueryBuilder flagQuery = QueryBuilders.termsQuery("flag", "web-tb");
        QueryBuilder tbSoldoutQuery = QueryBuilders.termsQuery("tbSoldout", bo.isTbSoldout());
        QueryBuilder shopSoldoutQuery = QueryBuilders.termsQuery("shopSoldout", bo.isShopSoldout());
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(userQuery);
        boolQuery.must(flagQuery);
        boolQuery.mustNot(tbSoldoutQuery);
        boolQuery.mustNot(shopSoldoutQuery);

        srb.setQuery(boolQuery);
        SearchResponse response = srb.execute().actionGet();
        //聚合结果
        SearchHits hits = response.getHits();
        //总数
        long totalHits = hits.getTotalHits();

        List<ItemUpRecordVO> list = new ArrayList<>();
        SearchHit[] searchHits = hits.hits();
        for (SearchHit s : searchHits) {
            //单条数据
            String json = s.getSourceAsString();
            //字符串转对象
            ItemUpRecordVO itemUpRecordVO = JSON.parseObject(json, ItemUpRecordVO.class);
            list.add(itemUpRecordVO);
            System.out.println(itemUpRecordVO);
        }
        ShiguPager<ItemUpRecordVO> pager = new ShiguPager<ItemUpRecordVO>();
        pager.setTotalCount(Integer.parseInt(String.valueOf(totalHits)));
        pager.setContent(list);
        model.addAttribute("get",bo);
        model.addAttribute("page",bo.getPage());
        model.addAttribute("pageOption",pager.selPageOption(bo.getRows()));
        model.addAttribute("goodslist", list);

        //淘宝在售
        if (bo.isTbSoldout() == false) {
            //仅【档口在售】且【淘宝在售】；
            if (bo.isShopSoldout() == false) {
                return "buyer/shiguOnekeyRecordinit";
            }
            if (bo.isShopSoldout() == true){
                //仅【档口已下架】且【淘宝在售】；
                return "buyer/shiguOnekeyRecordinit";
            }
            return "buyer/shiguOnekeyRecordinit";
        }
        //【档口在售】和【档口已下架】，且【淘宝已下架】
        return "buyer/shiguOnekeyRecordinit";
    }


    /**
     * 删除一键上传商品
     * @return
     */
    @RequestMapping("member/rmv_arddp")
    @ResponseBody
    public JSONObject rmv_arddp(String ids,HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ids==null){
            throw new JsonErrException("ids参数异常");
        }
        List<String> idslist=new ArrayList<>();
        String[] idsarr=ids.split(",");
        for(String id:idsarr){
            idslist.add(id);
        }
        String nick;
        //查出用户nick
        if(ps.getLoginFromType().equals(LoginFromType.TAOBAO)){
            nick=ps.getLoginName();
        }else{
            nick=memberSimpleService.selNick(ps.getUserId());
        }
        try {
            itemUpRecordService.deleteUploadedItems(ps.getUserId(),nick,idslist);
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 我收藏的店铺
     * @return
     */
    @RequestMapping("member/storeCollectinit")
    public String storeCollectinit(StoreCollectBO bo, HttpSession session, Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<ShopCollectVO> pager=userCollectService.selShopCollections(ps.getUserId(),bo.getWebsite(),bo.getPage(),bo.getRows());
        model.addAttribute("pageOption",pager.selPageOption(bo.getRows()));
        model.addAttribute("page",bo.getPage());
        model.addAttribute("get",bo);
        model.addAttribute("website",bo.getWebsite());
        model.addAttribute("goodslist",pager.getContent());
        return "buyer/storeCollectinit";
    }

    /**
     * 删除收藏的店铺
     * @return
     */
    @RequestMapping("member/rmv_fvshop")
    @ResponseBody
    public JSONObject rmv_fvshop(String ids,HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.delShopCollection(ps.getUserId(),parseIds(ids));
        return JsonResponseUtil.success().element("msg","删除成功");
    }

    /**
     * 安全设置首页
     * @return
     */
    @RequestMapping("member/safeindex")
    public String safeindex(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SafeAbout safeAbout=userLicenseService.selUserLicenses(ps.getUserId());
        if(safeAbout!=null){
            model.addAttribute("safe_level",safeAbout.getScore());
            List<UserLicense> licenses=safeAbout.getLicenses();
            if(licenses!=null){
                for(UserLicense ul:licenses){
                    if(ul.getType().equals(MemberLicenseType.PHONE_BIND)){
                        model.addAttribute("info_mobile",true);
                        model.addAttribute("text_mobile",ul.getContext());
                    }else if(ul.getType().equals(MemberLicenseType.PASSWORD_SAFE)){
                        Integer pwdScore=Integer.valueOf(ul.getContext());
                        model.addAttribute("info_pwd",pwdScore>=75?"high":pwdScore>=50?"middle":"low");
                    }else if(ul.getType().equals(MemberLicenseType.EMAIL)){
                        model.addAttribute("info_email",true);
                    }else if(ul.getType().equals(MemberLicenseType.REAL_NAME)){
                        model.addAttribute("info_card",true);
                    }
                }
            }
        }else{
            model.addAttribute("safe_level",0);
        }
        return "buyer/safeindex";
    }

    /**
     * 上传实名认证
     * @return
     */
    @RequestMapping("member/saferz")
    public String saferz(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //查出权益
        SafeRzVO safeRzVO=new SafeRzVO();
        SafeAbout safeAbout=userLicenseService.selUserLicenses(ps.getUserId());
        if(safeAbout!=null){
            List<UserLicense> licenses=safeAbout.getLicenses();
            if(licenses!=null){
                for(UserLicense ul:licenses){
                    if(ul.getType().equals(MemberLicenseType.REAL_NAME)){
                        String context=ul.getContext();
                        String[] contextarr=context.split(";");
                        if(contextarr.length<2){
                            break;
                        }
                        safeRzVO.setCardnum(contextarr[0]);
                        safeRzVO.setImgurl1(contextarr[1]);
                    }
                }
            }
        }
        //查一下最后一次实名认证的情况
        RealNameApplyInfo info=userLicenseService.lastRealNameApply(ps.getUserId());
        if(info!=null){
            String msg="您在"+ DateParseUtil.parseDate("yyyy-MM-dd",info.getApplyTime())+"的申请 ";
            if(info.getApplyStatus()==0){
                msg+="还在审核中";
            }else if(info.getApplyStatus()==-1){
                msg+="不通过 原因:"+info.getReason();
            }else{
                msg+="已通过";
            }
            safeRzVO.setMsg(msg);
        }
        model.addAttribute("identity",safeRzVO);
        return "buyer/saferz";
    }

    /**
     * 上传认证图片
     */
    @RequestMapping("member/uploadCardimg")
    @ResponseBody
    public JSONObject uploadCardimg(@RequestParam(value = "file", required = false) MultipartFile file,HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //查一下最后一次实名认证的情况
        RealNameApplyInfo info=userLicenseService.lastRealNameApply(ps.getUserId());
        if(info!=null&&info.getApplyStatus()==0){
            throw new JsonErrException("").addErrMap("err","您的帐号正在实名认证中，如急需认证请联系客服");
        }
        String url="";
        try {
            url=ossIO.uploadFile(file.getBytes(),"mall/file/idcard/"+System.currentTimeMillis() + ".jpg");
//            url=fileUploadService.fileUpload("idcard/"+System.currentTimeMillis() + ".jpg",file.getBytes());
        } catch (IOException e) {
            throw new JsonErrException("").addErrMap("err","图片数据读取失败");
        }
        return JsonResponseUtil.success().element("imgurl",url);
    }

    /**
     * 提交实名认证
     * @return
     */
    @RequestMapping("member/saveCard")
    @ResponseBody
    public JSONObject saveCard(@Valid SafeRzBO bo, BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            userLicenseService.realNameApply(ps.getUserId(),bo.getCardid()+";"+bo.getCardimg1());
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }
    /**
     * 个人设置
     * @return
     */
    @RequestMapping("member/sysSetsindex")
    public String sysSetsindex(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        UserInfo userInfo = userBaseService.selUserInfo(ps.getUserId());
        UserInfoVO userInfoVO=BeanMapper.map(userInfo, UserInfoVO.class);
        userInfoVO.setUserId(ps.getUserId());
        model.addAttribute("userInfo", userInfoVO);
        return "buyer/sysSetsindex";
    }

    /**
     * 保存用户信息
     * @return
     */
    @RequestMapping("member/saveUserinfo")
    @ResponseBody
    public JSONObject saveUserinfo(@Valid SaveUserInfoBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        UserInfoUpdate userInfoUpdate=bo.parseToUserInfo();
        userInfoUpdate.setUserId(ps.getUserId());
        try {
            userBaseService.updateUserInfo(userInfoUpdate);
        } catch (UpdateUserInfoException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JSONObject.fromObject("{'result':'success'}");
    }

    /**
     * 上传头像
     * @return
     */
    @RequestMapping("member/uploadicon")
    @ResponseBody
    public JSONObject uploadicon(@RequestParam(value = "file", required = false) MultipartFile file,HttpSession session) throws JsonErrException {
        if(file==null){
            throw new JsonErrException("文件数据不存在");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String url="";
        try {
            url=ossIO.uploadFile(file.getBytes(),"mall/file/"+System.currentTimeMillis() + ".jpg");
//            url=fileUploadService.fileUpload(System.currentTimeMillis() + ".jpg",file.getBytes());
            UserInfoUpdate userInfoUpdate=new UserInfoUpdate();
            userInfoUpdate.setUserId(ps.getUserId());
            userInfoUpdate.setHeadUrl(url);
            memberSimpleService.updateUser(userInfoUpdate);
        } catch (IOException e) {
            throw new JsonErrException("图片数据读取失败");
        } catch (UpdateUserInfoException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success().element("imgurl",url+"?x-oss-process=image/resize,m_fixed,h_100,w_100");
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("member/safexgmm")
    public String safexgmm(String code,HttpSession session,Model model){
        //如果code和手机忘记密码验证码一样,则不需要原密码
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        PhoneVerify phoneCode= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_FORGET_MSG.getValue());
        if(checkFromForget(ps.getUserId(),code,phoneCode)){
            model.addAttribute("fromForget",phoneCode);
        }
        return "buyer/safexgmm";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("member/savePassword")
    @ResponseBody
    public JSONObject savePassword(@Valid SavePasswordBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //旧的密码查出来,与oldPwd比对
        String pwd=userBaseService.selUserPwdByUserId(ps.getUserId());

        PhoneVerify phoneCode= (PhoneVerify) session.getAttribute(SessionEnum.PHONE_FORGET_MSG.getValue());
        if(bo.getCode()!=null&&checkFromForget(ps.getUserId(),bo.getCode(),phoneCode)){//如果是验证密码过来的
            //忘记密码过来的不需要验证密码
        }else if(!EncryptUtil.encrypt(bo.getOldPwd()).equals(pwd)){
            throw new JsonErrException("原密码输入有误");
        }
        try {
            userLicenseService.changePassword(ps.getUserId(),bo.getNewPwd());
        } catch (Main4Exception e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 修改支付密码页面
     * @return
     */
    @RequestMapping("member/safeXgPaymm")
    public String safeXgPaymm(HttpSession session, Model model) throws Main4Exception {
        model.addAttribute("hasPayPwd",memberSimpleService.selIsPayPwdByUserId(((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId()));
        return "buyer/safeXgPaymm";
    }

    /**
     * 设置支付密码
     * @param newPwd
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("member/setPayPassword")
    @ResponseBody
    public JSONObject setPayPassword(String newPwd,HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        memberSimpleService.setPayPassword(ps.getUserId(),newPwd);
        return JsonResponseUtil.success();
    }

    /**
     * 修改支付密码
     * @param oldPwd
     * @param newPwd
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("member/savePayPassword")
    @ResponseBody
    public JSONObject savePayPassword(String oldPwd,String newPwd,HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        memberSimpleService.savePayPassword(ps.getUserId(),oldPwd,newPwd);
        return JsonResponseUtil.success();
    }


    /**
     * 验证是否忘记密码来的
     * @param code
     * @param phoneVerify
     * @return
     */
    private boolean checkFromForget(Long userId,String code,PhoneVerify phoneVerify){
        if(code!=null){
            //手机验证码一样,用户ID一样
            if(phoneVerify!=null&&phoneVerify.getVerify().equals(code)&&userId.equals(phoneVerify.getUserId())){
                return true;
            }
        }
        return false;
    }

    /**
     * 邮箱绑定
     * @return
     */
    @RequestMapping("member/safeszyx")
    public String safeszyx(HttpSession session,Model model){
        //查出旧的邮箱
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SafeAbout safeAbout=userLicenseService.selUserLicenses(ps.getUserId());
        if(safeAbout!=null){
            List<UserLicense> licenses=safeAbout.getLicenses();
            if(licenses!=null){
                for(UserLicense ul:licenses){
                    if(ul.getType().equals(MemberLicenseType.EMAIL)){
                        MailBindVO mail=new MailBindVO();
                        String context=ul.getContext();
                        mail.setEmail(context);
                        mail.setMsg("认证成功");
                        model.addAttribute("mail",mail);
                    }
                }
            }
        }
        return "buyer/safeszyx";
    }

    /**
     * 保存绑定邮箱
     * @return
     */
    @RequestMapping("member/saveEmail")
    @ResponseBody
    public JSONObject saveEmail(@Valid SaveEmailBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //以下为老的逻辑
        JSONObject obj=new JSONObject();
        obj.element("success",true);//不解的设置
        JSONObject json = new JSONObject();
        json.put("userName", ps.getUserNick());
        json.put("userId", ps.getUserId());
        json.put("email",bo.getEmail());
        String p = json.toString();
        p= Opt3Des.encryptPlainData(p);
        try {
            p= URLEncoder.encode(p,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url=xzSdkClient.getMainHost()+"member/safeemail.htm?p="+p;
        String [] emailAddr={bo.getEmail()};
        //发送邮件
        try {
            String sendMailInfo=new EmailUtil(xzSdkClient.getMailfrom(),xzSdkClient.getSmtphost(),xzSdkClient.getMailuser(),
                    xzSdkClient.getMailpwd()).send("571星座网邮箱认证","<a href="+url+">点击此处，认证邮箱,如果链接无效，请访问以下地址</a>"+url,emailAddr);
            obj.element("sendMailInfo",sendMailInfo);
        } catch (EmailException e) {
//            e.printStackTrace();
            obj.put("sendEmailException", e.getMessage());
        }
        String mail = "mail."+bo.getEmail().substring(bo.getEmail().indexOf("@")+1);
        obj.put("msg", "提交成功，邮件已经发送，请登录邮箱确认认证<a href='http://"+mail+"' target='_blank'>点此处登录邮箱</a>");
        return obj;
    }

    /**
     * 邮箱认证回调
     * @return
     */
    @RequestMapping("member/safeemail")
    public String safeemail(String p,HttpSession session,Model model) throws UnsupportedEncodingException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (p.contains("%"))
            p= URLDecoder.decode(p,"utf-8");
        p=Opt3Des.decryptPlainData(p);
        JSONObject json = JSONObject.fromObject(p);
        Long userId = json.getLong("userId");
        MailBindVO mail=new MailBindVO();
        mail.setEmail(json.getString("email"));
        if(ps.getUserId().equals(userId)){
            try {
                userLicenseService.bindEmail(ps.getUserId(),json.getString("email"));
                mail.setMsg("认证成功");
            } catch (Main4Exception e) {
                mail.setMsg(e.getMessage());
            }
        }else{
            mail.setMsg("当前登陆账号与认证发起账号不符合,请切换账号,重新激活");
        }
        model.addAttribute("mail",mail);
        return "buyer/safeszyx";
    }
    /**
     * 充值
     * @return
     */
    @RequestMapping("member/iwantToRechargein5")
    public String iwantToRechargein5(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempcode=paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode",tempcode);
        return "buyer/iwantToRechargein5";
    }

    /**
     * 充值操作
     * @return
     */
    @RequestMapping("member/saveCzinfo")
    @ResponseBody
    public JSONObject saveCzinfo(@Valid RechangeBO bo,BindingResult result,HttpSession session) throws JsonErrException {
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            String money=paySdkClientService.rechange(ps.getUserId(),bo.getPaynum(),bo.getAlipay());
        return JsonResponseUtil.success().element("data",JSONObject.fromObject("{'rechangeMoney':"+money+"}"));
    }

    /**
     * 提现
     * @return
     */
    @RequestMapping("member/withdraw5Apply")
    public String withdraw5Apply(HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempcode=paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode",tempcode);
        return "buyer/withdraw5Apply";
    }

    /**
     * 提现保存
     * @return
     */
    @RequestMapping("member/saveTixian")
    @ResponseBody
    public JSONObject saveTixian(@Valid TixianBO bo,BindingResult result,HttpSession session){
        if(result.hasErrors()){
            return JSONObject.fromObject("{'result':'error','msg':'"+result.getAllErrors().get(0).getDefaultMessage()+"'}");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return paySdkClientService.tixian(bo, ps.getUserId());
    }

    /**
     * 店铺入驻申请
     * @return
     */
    @RequestMapping("member/storeIn")
    public String storeIn(StoreInBO bo, HttpSession session,Model model){
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<ShopApply> shopApplys=shopRegistService.selApplysByUserId(ps.getUserId(),bo.getPage(),bo.getRows());
        List<ShopApply> applies=shopApplys.getContent();
        List<StoreInVO> storelist=new ArrayList<>();
        if(applies!=null){
            for(ShopApply apply:applies){
                storelist.add(new StoreInVO(apply));
            }
        }
        model.addAttribute("storelist",storelist);
        return "buyer/storeIn";
    }

    /**
     * 查看开店申请
     * @return
     */
    @RequestMapping("member/storeInRead")
    public String storeInRead(Long userCode,HttpSession session,Model model) throws Main4Exception {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(userCode==null){
            throw new Main4Exception("缺少关键数据userCode");
        }
        ShopApplyDetail detail=shopRegistService.selDetailById(ps.getUserId(),userCode);
        model.addAttribute("applyInfo",new ApplyInfoVO(detail));
        return "buyer/storeInRead";
    }

    /**
     * 修改开店申请
     * @return
     */
    @RequestMapping("member/storeInAlter")
    public String storeInAlter(Long userCode,HttpSession session,Model model) throws Main4Exception {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(userCode==null){
            throw new Main4Exception("缺少关键数据userCode");
        }
        ShopApplyDetail detail=shopRegistService.selDetailById(ps.getUserId(),userCode);
        model.addAttribute("applyInfo",new ApplyInfoVO(detail));
        return "buyer/storeInAlter";
    }

    /**
     * 删除申请记录
     * @return
     */
    @RequestMapping("member/removeStoreAdd")
    @ResponseBody
    public JSONObject removeStoreAdd(Long userCode,HttpSession session) throws JsonErrException {
        if(userCode==null){
            throw new JsonErrException("userCode参数异常");
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            shopRegistService.delApply(ps.getUserId(),userCode);
        } catch (ShopRegistException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success();
    }
    /**
     * 代理的交易状态,现在暂时没有用
     * @return
     */
    @RequestMapping("member/jsonUserCentergetTradeCount")
    @ResponseBody
    public JSONObject jsonUserCentergetTradeCount(){
        return null;
    }

    /**
     * 代理授权情况,现在暂时没有用,以后可能也不用
     * @return
     */
    @RequestMapping("member/jsonUserCentergetsouquan")
    @ResponseBody
    public JSONObject jsonUserCentergetsouquan(){
        return JsonResponseUtil.success();
    }

    /**
     * 。。。。。可能要放弃
     * @return
     */
    @RequestMapping("member/jsonUserCentergetUpStore")
    @ResponseBody
    public JSONObject jsonUserCentergetUpStore(){
        return JsonResponseUtil.success();
    }

    @RequestMapping("member/userBalance")
    public String userBalance(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempCode = paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode", tempCode);
        model.addAttribute("webSite", "hz");
        model.addAttribute("excelUrl", "");
        return "buyer/userBalance";
    }

    /**
     * 资金流水
     * @return
     */
    @RequestMapping("member/capStatistic")
    public String capStatistic(HttpSession session, Model model){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempCode = paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode",tempCode);
        return "buyer/capStatistic";
    }

    /**
     * 申请提现链接
     * @return
     */
    @RequestMapping({"member/rechargeJson","seller/rechargeJson"})
    @ResponseBody
    public JSONObject rechargeJson(HttpSession session,Double money) throws PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Double moneyfen=money*100;
        PayApplyVO applyVO=userAccountService.rechargeApply(ps.getUserId(),moneyfen.longValue());
        return JsonResponseUtil.success().element("href","/order/alipayByApplyId.htm?applyId="+applyVO.getApplyId());
    }


    /**
     * 已上传的商品列表
     * @param bo
     * @param session
     * @param model
     * @return
     */
    //todo:前端url没定
    public String goodsupRecordList(GoodsupSearchBO bo, HttpSession session, Model model) {
        //todo:前端搜索条件字段没定
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<ItemUpRecordVO> pager = goodsupRecordSimpleService.goodsupRecordList(ps.getUserId(), ps.getUserNick(), bo);
        //todo:前端没开始，字段没定，模板还没有
        return null;
    }

}
