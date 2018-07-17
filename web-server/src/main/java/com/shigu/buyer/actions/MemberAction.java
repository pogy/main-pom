package com.shigu.buyer.actions;

import com.opentae.data.mall.beans.ShiguBonusRecord;
import com.shigu.buyer.bo.*;
import com.shigu.buyer.enums.BonusRecordTypeEnum;
import com.shigu.buyer.enums.OutUserBindTypeEnum;
import com.shigu.buyer.services.GoodsupRecordSimpleService;
import com.shigu.buyer.services.MemberSimpleService;
import com.shigu.buyer.services.PaySdkClientService;
import com.shigu.buyer.services.UserAccountService;
import com.shigu.buyer.services.UserCollectSimpleService;
import com.shigu.buyer.vo.*;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.exceptions.ShopRegistException;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.order.exceptions.PayApplyException;
import com.shigu.main4.order.vo.PayApplyVO;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.enums.MemberLicenseType;
import com.shigu.main4.ucenter.exceptions.UpdateUserInfoException;
import com.shigu.main4.ucenter.services.MemberInviteService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.services.UserLicenseService;
import com.shigu.main4.ucenter.util.EncryptUtil;
import com.shigu.main4.ucenter.vo.*;
import com.shigu.main4.ucenter.webvo.ItemCollectVO;
import com.shigu.main4.ucenter.webvo.NewGoodsCollectVO;
import com.shigu.main4.vo.ShopApply;
import com.shigu.main4.vo.ShopApplyDetail;
import com.shigu.services.SendMsgService;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.PhoneVerify;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.session.main4.tool.BeanMapper;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ImgBannerVO;
import com.shigu.tools.*;
import com.utils.publics.Opt3Des;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 会员中心
 * Created by zhaohongbo on 17/3/1.
 */
@Controller
public class MemberAction {

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
    SendMsgService sendMsgService;

    @Autowired
    UserCollectSimpleService userCollectSimpleService;

    @Autowired
    GoodsupRecordSimpleService goodsupRecordSimpleService;

    @Autowired
    MemberInviteService memberInviteService;

    @Autowired
    private RedisIO redisIO;

    private final static String MEMBER_PATH = "member";

    private final static String SELLER_PATH = "seller";


    /**
     * 分销商首页
     *
     * @return
     */
    @RequestMapping({"member/index", "member/memberDispense"})//后面一个地址,临时用一下
    public String index(HttpSession session, Model model) {
        //如果有店铺权限,进商户中心
        if (SecurityUtils.getSubject().hasRole(RoleEnum.STORE.getValue())) {
            return "redirect:/seller/index.htm";
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        model.addAttribute("jifenCount", userLicenseService.selUserScore(ps.getUserId()));
        // 分销商广告
        List<ImgBannerVO> imageGoat = spreadService.selImgBanners(SpreadEnum.BACK_MEMBER).selReal();
        if (!imageGoat.isEmpty()) {
            ImgBannerVO imgBannerVO = imageGoat.get(0);
            model.addAttribute("imgsrc", imgBannerVO.getImgsrc());
            model.addAttribute("tHref", imgBannerVO.getHref());
        }
        // 用户红包余额
        Long bonusBalance = memberSimpleService.getUserBonusBalance(ps.getUserId());
        model.addAttribute("bonusBalance", String.format("%.2f", bonusBalance * 0.01));
        // 红包活动详情
        BonusBtnInfo bonusBtnInfo = redisIO.get("bonus_btn_info", BonusBtnInfo.class);
        model.addAttribute("bonusBtnInfo",bonusBtnInfo);
        model.addAttribute("bonusTips",bonusBtnInfo == null ? "" : bonusBtnInfo.getBonusTips());
        return "fxs/index";
    }


    /**
     * 第三方账号绑定
     *
     * @return
     */
    @RequestMapping("member/fenxiaoZhanghao")
    public String fenxiaoZhanghao(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<OuterUser> outerUsers = userBaseService.selOuterUsers(ps.getUserId());
        List<OuterUserVO> outerUserVOS = OutUserBindTypeEnum.psrseToOutUserVO(outerUsers);
        model.addAttribute("_outer_accountType_", outerUserVOS);
        return "fxs/fenxiaoZhanghao";
    }

    /**
     * 第三方用户解绑
     *
     * @return
     */
    @RequestMapping("member/jsonUnbind")
    @ResponseBody
    public JSONObject jsonUnbind(Long subUserId, HttpSession session) throws JsonErrException {
        if (subUserId == null) {
            throw new JsonErrException("缺少关键数据");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userBaseService.unBindUser(ps.getUserId(), subUserId);
        return JsonResponseUtil.success();
    }

    /**
     * 个人中心,我的数据包
     *
     * @return
     */
    @RequestMapping("member/goodsCollectinit")
    public String goodsCollectinit(GoodsCollectBO bo, HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            if (!StringUtils.isEmpty(bo.getKeyword())) {
                bo.setKeyword(URLDecoder.decode(bo.getKeyword(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ShiguPager<ItemCollectVO> pager = userCollectService.selItemCollections(ps.getUserId(), bo.getKeyword(), bo.getWebsite(),
                bo.getPage(), bo.getRows());
        if (pager.getContent() != null) {
            //极限词过滤
            pager.getContent().forEach(itemCollectVO -> itemCollectVO.setTitle(KeyWordsUtil.duleKeyWords(itemCollectVO.getTitle())));
            model.addAttribute("goodslist", BeanMapper.mapList(pager.getContent(), GoodsCollectVO.class));
        }
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        model.addAttribute("query", bo);
        model.addAttribute("website", bo.getWebsite());
        model.addAttribute("keyword", bo.getKeyword());
        return "fxs/goodsCollectinit";
    }

    /**
     * 从数据包移除
     *
     * @return
     */
    @RequestMapping("member/rmv_mydp")
    @ResponseBody
    public JSONObject rmv_mydp(String ids, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.delItemCollection(ps.getUserId(), parseIds(ids));
        return JsonResponseUtil.success();
    }

    /**
     * 新版个人中心,我的收藏
     *
     * @param bo
     * @param page
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("member/goodsCollectOriginal")
    public String goodsCollectOriginal(StoreCollectBO bo, Integer page, HttpSession session, Model model) {
        if (page == null) {
            page = 1;
        }
        //一页12条数据
        int size = 12;
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<NewGoodsCollectVO> pager = userCollectSimpleService.selNewGoodsCollect(ps.getUserId(), bo.getWebsite(), page, size);
        //极限词过滤
        if (pager.getContent() != null) {
            pager.getContent().forEach(itemCollectVO -> itemCollectVO.setTitle(KeyWordsUtil.duleKeyWords(itemCollectVO.getTitle())));
        }

        model.addAttribute("goodsList", pager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pager.selPageOption(size));
        return "fxs/goodsCollectOriginal";
    }

    /**
     * 删除收藏的商品
     *
     * @param ids
     * @param session
     * @return
     */
    @RequestMapping("member/rmvFavoriteGoods")
    @ResponseBody
    public JSONObject rmvFavoriteGoods(String ids, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectSimpleService.delCollectGoods(ps.getUserId(), ids);
        return JsonResponseUtil.success();
    }

    /**
     * 创建数据包
     *
     * @return
     */
    @RequestMapping("member/mk_mydp")
    @ResponseBody
    public JSONObject mk_mydp(String ids, HttpSession session) throws JsonErrException {
        List<Long> packegeIds = parseIds(ids);
        if (packegeIds == null || packegeIds.size() > 12) {
            return JsonResponseUtil.error("ids参数异常");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.createDataPackageByCoolectIds(ps.getUserId(), packegeIds);
        return JsonResponseUtil.success();
    }


    /**
     * 数据包列表页面
     *
     * @return
     */
    @RequestMapping("member/goodsDataPackageinit")
    public String goodsDataPackageinit(DataPackageBO bo, HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<DataPackage> pager = userCollectService.selPackages(ps.getUserId(), bo.getPage(), bo.getRows());
        List<PackageVO> goodslist = new ArrayList<>();
        for (DataPackage dp : pager.getContent()) {
            if (dp.getGoods() != null)
                goodslist.add(new PackageVO(dp));
        }
        //极限词过滤
        goodslist.forEach(packageVO -> {
            if (packageVO.getGoods() != null) {
                packageVO.getGoods().forEach(packageItemVO -> packageItemVO.setTitle(KeyWordsUtil.duleKeyWords(packageItemVO.getTitle())));
            }
        });
        model.addAttribute("goodslist", goodslist);
        model.addAttribute("website", bo.getWebsite());
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        model.addAttribute("query", bo);
        model.addAttribute("page", bo.getPage());
        return "fxs/goodsDataPackageinit";
    }

    /**
     * ID串转货
     *
     * @param ids
     * @return
     * @throws JsonErrException
     */
    private List<Long> parseIds(String ids) throws JsonErrException {
        if (ids == null) {
            throw new JsonErrException("ids参数异常");
        }
        List<Long> idslist = new ArrayList<>();
        String[] idsarr = ids.split(",");
        for (String id : idsarr) {
            idslist.add(Long.valueOf(id));
        }
        return idslist;
    }

    /**
     * 删除数据包
     *
     * @return
     */
    @RequestMapping("member/rmv_zipdp")
    @ResponseBody
    public JSONObject rmv_zipdp(String ids, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.delPackagesById(ps.getUserId(), parseIds(ids));
        return JsonResponseUtil.success();
    }

    /**
     * 展示淘宝一键上传的商品
     *
     * @return
     */
    @RequestMapping("member/shiguOnekeyRecordinit")
    public String shiguOnekeyRecordinit(OnekeyRecordBO bo, HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String nick;
        if (ps.getLoginFromType().equals(LoginFromType.TAOBAO)) {
            nick = ps.getLoginName();
        } else {
            nick = memberSimpleService.selNick(ps.getUserId());
        }
        ShiguPager<OnekeyRecoreVO> pager = goodsupRecordSimpleService.selOnekeyRecore(ps.getUserId(), nick, bo);
        //极限词过滤
        pager.getContent().forEach(onekeyRecoreVO -> onekeyRecoreVO.setTitle(KeyWordsUtil.duleKeyWords(onekeyRecoreVO.getTitle())));

        model.addAttribute("shopDownNum", goodsupRecordSimpleService.shopDownNum(ps.getUserId(), nick));
        model.addAttribute("query", bo);
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        model.addAttribute("goodsList", pager.getContent());
        return "fxs/shiguOnekeyRecordinit";
    }

    @RequestMapping("member/downTbGoods")
    @ResponseBody
    public JSONObject downTbGoods(String ids, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        try {
            boolean taobaoAuth = ps.getLoginFromType().equals(LoginFromType.TAOBAO);
            if (!taobaoAuth) {
                throw new JsonErrException("需要淘宝授权");
            }
            goodsupRecordSimpleService.downTbGoods(userId, ps.getLoginName(), ids);
        } catch (JsonErrException e) {
            if (e.getMessage().contains("需要淘宝授权")) {
                return JsonResponseUtil.error(e.getMessage()).element("redirectUrl", "https://oauth.taobao.com/authorize?response_type=code&client_id=21720662&redirect_uri=http://upload.571xz.com/redirect_auth.jsp&state=login&view=web");
            }
        }
        return JsonResponseUtil.success();
    }

    /**
     * 删除一键上传商品
     *
     * @return
     */
    @RequestMapping("member/rmv_arddp")
    @ResponseBody
    public JSONObject rmv_arddp(String ids, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ids == null) {
            return JsonResponseUtil.error("ids参数异常");
        }
        List<String> idslist = new ArrayList<>();
        String[] idsarr = ids.split(",");
        for (String id : idsarr) {
            idslist.add(id);
        }
        String nick;
        //查出用户nick
        if (ps.getLoginFromType().equals(LoginFromType.TAOBAO)) {
            nick = ps.getLoginName();
        } else {
            nick = memberSimpleService.selNick(ps.getUserId());
        }
        try {
            itemUpRecordService.deleteUploadedItems(ps.getUserId(), nick, idslist);
        } catch (Main4Exception e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 我收藏的店铺
     *
     * @return
     */
    @RequestMapping("member/storeCollectinit")
    public String storeCollectinit(StoreCollectBO bo, HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<NewStoreCollectVO> pager = userCollectSimpleService.selShopCollections(ps.getUserId(), bo.getWebsite(), bo.getPage(), bo.getSize());
        model.addAttribute("pageOption", pager.selPageOption(bo.getSize()));
        model.addAttribute("query", bo);
        model.addAttribute("shopList", pager.getContent());
        return "fxs/storeCollectinit";
    }

    /**
     * 删除收藏的店铺
     *
     * @return
     */
    @RequestMapping({"member/rmvFvshop", "member/rmv_fvshop"})
    @ResponseBody
    public JSONObject rmv_fvshop(String ids, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        userCollectService.delShopCollection(ps.getUserId(), parseIds(ids));
        return JsonResponseUtil.success().element("msg", "删除成功");
    }

    /**
     * 安全设置首页
     *
     * @return
     */
    @RequestMapping("{identity}/safeindex")
    public String safeindex(@PathVariable String identity, HttpSession session, Model model) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SafeAbout safeAbout = userLicenseService.selUserLicenses(ps.getUserId());
        try {
            Boolean info_payPwd = memberSimpleService.selIsPayPwdByUserId(ps.getUserId());
            model.addAttribute("info_payPwd", info_payPwd);
        } catch (Main4Exception e) {
            e.printStackTrace();

        }
        if (safeAbout != null) {
            model.addAttribute("safe_level", safeAbout.getScore());
            List<UserLicense> licenses = safeAbout.getLicenses();
            if (licenses != null) {
                for (UserLicense ul : licenses) {
                    if (ul.getType() == null) {
                        continue;
                    }
                    if (ul.getType().equals(MemberLicenseType.PHONE_BIND)) {
                        model.addAttribute("info_mobile", true);
                        model.addAttribute("text_mobile", ul.getContext());
                    } else if (ul.getType().equals(MemberLicenseType.PASSWORD_SAFE)) {
                        Integer pwdScore = Integer.valueOf(ul.getContext());
                        model.addAttribute("info_pwd", pwdScore >= 75 ? "high" : pwdScore >= 50 ? "middle" : "low");
                    } else if (ul.getType().equals(MemberLicenseType.EMAIL)) {
                        model.addAttribute("info_email", true);
                    } else if (ul.getType().equals(MemberLicenseType.REAL_NAME)) {
                        model.addAttribute("info_card", true);
                    }
                }
            }
        } else {
            model.addAttribute("safe_level", 0);
        }
        if (SELLER_PATH.equals(identity)) {
            return "gys/safeindex";
        }
        return "fxs/safeindex";
    }

    /**
     * 上传实名认证
     *
     * @return
     */
    @RequestMapping("member/saferz")
    public String saferz(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //查出权益
        SafeRzVO safeRzVO = new SafeRzVO();
        SafeAbout safeAbout = userLicenseService.selUserLicenses(ps.getUserId());
        if (safeAbout != null) {
            List<UserLicense> licenses = safeAbout.getLicenses();
            if (licenses != null) {
                for (UserLicense ul : licenses) {
                    if (ul.getType().equals(MemberLicenseType.REAL_NAME)) {
                        String context = ul.getContext();
                        String[] contextarr = context.split(";");
                        if (contextarr.length < 2) {
                            break;
                        }
                        safeRzVO.setCardnum(contextarr[0]);
                        safeRzVO.setImgurl1(contextarr[1]);
                    }
                }
            }
        }
        //查一下最后一次实名认证的情况
        RealNameApplyInfo info = userLicenseService.lastRealNameApply(ps.getUserId());
        if (info != null) {
            String msg = "您在" + DateParseUtil.parseDate("yyyy-MM-dd", info.getApplyTime()) + "的申请 ";
            if (info.getApplyStatus() == 0) {
                msg += "还在审核中";
            } else if (info.getApplyStatus() == -1) {
                msg += "不通过 原因:" + info.getReason();
            } else {
                msg += "已通过";
            }
            safeRzVO.setMsg(msg);
        }
        model.addAttribute("identity", safeRzVO);
        return "buyer/saferz";
    }

    /**
     * 上传认证图片
     */
    @RequestMapping("member/uploadCardimg")
    @ResponseBody
    public JSONObject uploadCardimg(@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //查一下最后一次实名认证的情况
        RealNameApplyInfo info = userLicenseService.lastRealNameApply(ps.getUserId());
        if (info != null && info.getApplyStatus() == 0) {
            throw new JsonErrException("").addErrMap("err", "您的帐号正在实名认证中，如急需认证请联系客服");
        }
        String url = "";
        try {
            url = ossIO.uploadFile(file.getBytes(), "mall/file/idcard/" + System.currentTimeMillis() + ".jpg");
//            url=fileUploadService.fileUpload("idcard/"+System.currentTimeMillis() + ".jpg",file.getBytes());
        } catch (IOException e) {
            throw new JsonErrException("").addErrMap("err", "图片数据读取失败");
        }
        return JsonResponseUtil.success().element("imgurl", url);
    }

    /**
     * 提交实名认证
     *
     * @return
     */
    @RequestMapping("member/saveCard")
    @ResponseBody
    public JSONObject saveCard(@Valid SafeRzBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            userLicenseService.realNameApply(ps.getUserId(), bo.getCardid() + ";" + bo.getCardimg1());
        } catch (Main4Exception e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 个人设置
     *
     * @return
     */
    @RequestMapping("member/sysSetsindex")
    public String sysSetsindex(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        UserInfo userInfo = userBaseService.selUserInfo(ps.getUserId());
        UserInfoVO userInfoVO = BeanMapper.map(userInfo, UserInfoVO.class);
        userInfoVO.setUserId(ps.getUserId());
        model.addAttribute("userInfo", userInfoVO);
        return "fxs/sysSetsindex";
    }

    /**
     * 保存用户信息
     *
     * @return
     */
    @RequestMapping("member/saveUserinfo")
    @ResponseBody
    public JSONObject saveUserinfo(@Valid SaveUserInfoBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        UserInfoUpdate userInfoUpdate = bo.parseToUserInfo();
        userInfoUpdate.setUserId(ps.getUserId());
        try {
            userBaseService.updateUserInfo(userInfoUpdate);
            ps.setUserNick(bo.getName());
            redisIO.put("session_user_redis__",ps);
        } catch (UpdateUserInfoException e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return JSONObject.fromObject("{'result':'success'}");
    }

    /**
     * 上传头像
     *
     * @return
     */
    @RequestMapping("member/uploadicon")
    @ResponseBody
    public JSONObject uploadicon(@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session) throws JsonErrException {
        if (file == null) {
            return JsonResponseUtil.error("文件数据不存在");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String url = "";
        try {
            url = ossIO.uploadFile(file.getBytes(), "mall/file/" + System.currentTimeMillis() + ".jpg");
//            url=fileUploadService.fileUpload(System.currentTimeMillis() + ".jpg",file.getBytes());
            UserInfoUpdate userInfoUpdate = new UserInfoUpdate();
            userInfoUpdate.setUserId(ps.getUserId());
            userInfoUpdate.setHeadUrl(url);
            memberSimpleService.updateUser(userInfoUpdate);
        } catch (IOException e) {
            return JsonResponseUtil.error("图片数据读取失败");
        } catch (UpdateUserInfoException e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return JsonResponseUtil.success().element("imgurl", url + "?x-oss-process=image/resize,m_fixed,h_100,w_100");
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping("member/safexgmm")
    public String safexgmm(String code, HttpSession session, Model model) {
        //如果code和手机忘记密码验证码一样,则不需要原密码
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        PhoneVerify phoneCode = (PhoneVerify) session.getAttribute(SessionEnum.PHONE_FORGET_MSG.getValue());
        if (checkFromForget(ps.getUserId(), code, phoneCode)) {
            model.addAttribute("fromForget", phoneCode);
        }
        return "fxs/safexgmm";
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping("member/savePassword")
    @ResponseBody
    public JSONObject savePassword(@Valid SavePasswordBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //旧的密码查出来,与oldPwd比对
        String pwd = userBaseService.selUserPwdByUserId(ps.getUserId());

        PhoneVerify phoneCode = (PhoneVerify) session.getAttribute(SessionEnum.PHONE_FORGET_MSG.getValue());
        if (bo.getCode() != null && checkFromForget(ps.getUserId(), bo.getCode(), phoneCode)) {//如果是验证密码过来的
            //忘记密码过来的不需要验证密码
        } else if (!EncryptUtil.encrypt(bo.getOldPwd()).equals(pwd)) {
            return JsonResponseUtil.error("原密码输入有误");
        }
        try {
            userLicenseService.changePassword(ps.getUserId(), bo.getNewPwd());
        } catch (Main4Exception e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 修改支付密码页面
     *
     * @param session
     * @param model
     * @param type    修改密码类型 1.立即设置 2.修改密码 3.找回密码
     * @return
     * @throws Main4Exception
     */
    @RequestMapping("{identity}/safeXgPaymm")
    public String safeXgPaymm(@PathVariable String identity, HttpSession session, Model model, Integer type) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //是否设置过支付密码
        Boolean hasPayPwdSet = memberSimpleService.selIsPayPwdByUserId(((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId());
        model.addAttribute("info_payPwd", hasPayPwdSet);
        //没设置过密码，设置密码  设置过密码，找回密码，找回密码，否则修改密码
        model.addAttribute("forPayPswType", hasPayPwdSet ? Objects.equals(3, type) ? 3 : 2 : 1);
        model.addAttribute("telphone", userLicenseService.findPhoneByUserId(ps.getUserId()));
        if (SELLER_PATH.equals(identity)) {
            return "gys/safeXgPaymm";
        }
        return "fxs/safeXgPaymm";
    }

    /**
     * 设置支付密码
     *
     * @param newPwd
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping({"member/setPayPassword", "seller/setPayPassword"})
    @ResponseBody
    public JSONObject setPayPassword(String newPwd, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        memberSimpleService.setPayPassword(ps.getUserId(), newPwd);
        return JsonResponseUtil.success();
    }

    /**
     * 修改支付密码
     *
     * @param oldPwd
     * @param newPwd
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping({"member/savePayPassword", "seller/savePayPassword"})
    @ResponseBody
    public JSONObject savePayPassword(String oldPwd, String newPwd, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        memberSimpleService.savePayPassword(ps.getUserId(), oldPwd, newPwd);
        return JsonResponseUtil.success();
    }

    //并入safeXgPaymm
    ///**
    // * 忘记支付密码页面
    // *
    // * @return
    // */
    //@RequestMapping("member/safeXgPaymmForget")
    //public String safeXgPaymmForget(HttpSession session, Model model) throws Main4Exception {
    //    PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
    //    String telephone = userLicenseService.findPhoneByUserId(ps.getUserId());
    //    model.addAttribute("telphone", telephone);
    //    model.addAttribute("forPayPswType", 3);
    //    return "buyer/safeXgPaymm";
    //}

    @RequestMapping({"member/saveBackPayPassword", "seller/saveBackPayPassword"})
    @ResponseBody
    public JSONObject changePayPassword(String code, String newPwd, HttpSession session) throws JsonErrException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String telephone = userLicenseService.findPhoneByUserId(ps.getUserId());

        PhoneVerify phoneCode = (PhoneVerify) session.getAttribute(SessionEnum.PHONE_FORGET_MSG.getValue());
        if (phoneCode == null || !phoneCode.getVerify().equals(code)
                || !phoneCode.getPhone().equals(telephone)) {//验证不通过
            return JsonResponseUtil.error("验证码错误");
        } else {
            userBaseService.setNewPayPwd(ps.getUserId(), newPwd);
        }
        return JsonResponseUtil.success();
    }

    @ResponseBody
    @RequestMapping({"member/getVerCode", "seller/getVerCode"})
    public JSONObject getVerCode(HttpSession session) throws JsonErrException {

        String code = RedomUtil.redomNumber(6);
        //直接获取用户手机信息，发送验证码
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String telephone = userLicenseService.findPhoneByUserId(ps.getUserId());

        session.setAttribute(SessionEnum.PHONE_FORGET_MSG.getValue(), new PhoneVerify(telephone, code));
        sendMsgService.sendVerificationCode(telephone, code);
        return JsonResponseUtil.success();
    }

    /**
     * 验证是否忘记密码来的
     *
     * @param code
     * @param phoneVerify
     * @return
     */
    private boolean checkFromForget(Long userId, String code, PhoneVerify phoneVerify) {
        if (code != null) {
            //手机验证码一样,用户ID一样
            if (phoneVerify != null && phoneVerify.getVerify().equals(code) && userId.equals(phoneVerify.getUserId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 邮箱绑定
     *
     * @return
     */
    @RequestMapping("member/safeszyx")
    public String safeszyx(HttpSession session, Model model) {
        //查出旧的邮箱
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        SafeAbout safeAbout = userLicenseService.selUserLicenses(ps.getUserId());
        if (safeAbout != null) {
            List<UserLicense> licenses = safeAbout.getLicenses();
            if (licenses != null) {
                for (UserLicense ul : licenses) {
                    if (ul.getType().equals(MemberLicenseType.EMAIL)) {
                        MailBindVO mail = new MailBindVO();
                        String context = ul.getContext();
                        mail.setEmail(context);
                        mail.setMsg("认证成功");
                        model.addAttribute("mail", mail);
                    }
                }
            }
        }
        return "buyer/safeszyx";
    }

    /**
     * 保存绑定邮箱
     *
     * @return
     */
    @RequestMapping("member/saveEmail")
    @ResponseBody
    public JSONObject saveEmail(@Valid SaveEmailBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        if (result.hasErrors()) {
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //以下为老的逻辑
        JSONObject obj = new JSONObject();
        obj.element("success", true);//不解的设置
        JSONObject json = new JSONObject();
        json.put("userName", ps.getUserNick());
        json.put("userId", ps.getUserId());
        json.put("email", bo.getEmail());
        String p = json.toString();
        p = Opt3Des.encryptPlainData(p);
        try {
            p = URLEncoder.encode(p, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = xzSdkClient.getMainHost() + "member/safeemail.htm?p=" + p;
        String[] emailAddr = {bo.getEmail()};
        //发送邮件
        try {
            String sendMailInfo = new EmailUtil(xzSdkClient.getMailfrom(), xzSdkClient.getSmtphost(), xzSdkClient.getMailuser(),
                    xzSdkClient.getMailpwd()).send("571星座网邮箱认证", "<a href=" + url + ">点击此处，认证邮箱,如果链接无效，请访问以下地址</a>" + url, emailAddr);
            obj.element("sendMailInfo", sendMailInfo);
        } catch (EmailException e) {
//            e.printStackTrace();
            obj.put("sendEmailException", e.getMessage());
        }
        String mail = "mail." + bo.getEmail().substring(bo.getEmail().indexOf("@") + 1);
        obj.put("msg", "提交成功，邮件已经发送，请登录邮箱确认认证<a href='http://" + mail + "' target='_blank'>点此处登录邮箱</a>");
        return obj;
    }

    /**
     * 邮箱认证回调
     *
     * @return
     */
    @RequestMapping("member/safeemail")
    public String safeemail(String p, HttpSession session, Model model) throws UnsupportedEncodingException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (p.contains("%"))
            p = URLDecoder.decode(p, "utf-8");
        p = Opt3Des.decryptPlainData(p);
        JSONObject json = JSONObject.fromObject(p);
        Long userId = json.getLong("userId");
        MailBindVO mail = new MailBindVO();
        mail.setEmail(json.getString("email"));
        if (ps.getUserId().equals(userId)) {
            try {
                userLicenseService.bindEmail(ps.getUserId(), json.getString("email"));
                mail.setMsg("认证成功");
            } catch (Main4Exception e) {
                mail.setMsg(e.getMessage());
            }
        } else {
            mail.setMsg("当前登陆账号与认证发起账号不符合,请切换账号,重新激活");
        }
        model.addAttribute("mail", mail);
        return "buyer/safeszyx";
    }

    /**
     * 充值
     *
     * @return
     */
    @RequestMapping("{identity}/iwantToRechargein5")
    public String iwantToRechargein5(@PathVariable String identity, HttpSession session, Model model) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("路径非法");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long bonusBalance = memberSimpleService.getUserBonusBalance(ps.getUserId());
        model.addAttribute("envelopeBalance", String.format("%.2f", bonusBalance * 0.01));
        if (SELLER_PATH.equals(identity)) {
            return "gys/iwantToRechargein5";
        }
        return "fxs/iwantToRechargein5";
    }

    /**
     * 充值操作
     *
     * @return
     */
    @RequestMapping("member/saveCzinfo")
    @ResponseBody
    public JSONObject saveCzinfo(@Valid RechangeBO bo, BindingResult result, HttpSession session) throws JsonErrException {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String money = paySdkClientService.rechange(ps.getUserId(), bo.getPaynum(), bo.getAlipay());
        return JsonResponseUtil.success().element("data", JSONObject.fromObject("{'rechangeMoney':" + money + "}"));
    }

    /**
     * 提现
     *
     * @return
     */
    @RequestMapping("{identity}/withdraw5Apply")
    public String withdraw5Apply(HttpSession session, Model model, @PathVariable String identity) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        // 手续费率
        model.addAttribute("handlingCharge", "0.6%");
        //model.addAttribute("userBalance",String.format("%.2f",memberSimpleService.getUserBalance(ps.getUserId()).getMoney()*0.01));
        model.addAttribute("alipayUserList", userAccountService.userAlipayBindList(ps.getUserId()));
        model.addAttribute("payPasswordIs", memberSimpleService.selIsPayPwdByUserId(ps.getUserId()) ? 1 : 0);
        if (SELLER_PATH.equals(identity)) {
            return "gys/withdraw5Apply";
        } else {
            return "fxs/withdraw5Apply";
        }
    }

    /**
     * 店铺入驻申请
     *
     * @return
     */
    @RequestMapping("member/storeIn")
    public String storeIn(StoreInBO bo, HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ShiguPager<ShopApply> shopApplys = shopRegistService.selApplysByUserId(ps.getUserId(), bo.getPage(), bo.getRows());
        List<ShopApply> applies = shopApplys.getContent();
        List<StoreInVO> storelist = new ArrayList<>();
        if (applies != null) {
            for (ShopApply apply : applies) {
                storelist.add(new StoreInVO(apply));
            }
        }
        model.addAttribute("storelist", storelist);
        return "fxs/storeIn";
    }

    /**
     * 查看开店申请
     *
     * @return
     */
    @RequestMapping("member/storeInRead")
    public String storeInRead(Long userCode, HttpSession session, Model model) throws Main4Exception {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (userCode == null) {
            throw new Main4Exception("缺少关键数据userCode");
        }
        ShopApplyDetail detail = shopRegistService.selDetailById(ps.getUserId(), userCode);
        model.addAttribute("applyInfo", new ApplyInfoVO(detail));
        return "fxs/storeInRead";
    }

    /**
     * 修改开店申请
     *
     * @return
     */
    @RequestMapping("member/storeInAlter")
    public String storeInAlter(Long userCode, HttpSession session, Model model) throws Main4Exception {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (userCode == null) {
            throw new Main4Exception("缺少关键数据userCode");
        }
        ShopApplyDetail detail = shopRegistService.selDetailById(ps.getUserId(), userCode);
        model.addAttribute("applyInfo", new ApplyInfoVO(detail));
        return "buyer/storeInAlter";
    }

    /**
     * 删除申请记录
     *
     * @return
     */
    @RequestMapping("member/removeStoreAdd")
    @ResponseBody
    public JSONObject removeStoreAdd(Long userCode, HttpSession session) throws JsonErrException {
        if (userCode == null) {
            return JsonResponseUtil.error("userCode参数异常");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        try {
            shopRegistService.delApply(ps.getUserId(), userCode);
        } catch (ShopRegistException e) {
            return JsonResponseUtil.error(e.getMessage());
        }
        return JsonResponseUtil.success();
    }

    /**
     * 代理的交易状态,现在暂时没有用
     *
     * @return
     */
    @RequestMapping("member/jsonUserCentergetTradeCount")
    @ResponseBody
    public JSONObject jsonUserCentergetTradeCount() {
        return null;
    }

    /**
     * 代理授权情况,现在暂时没有用,以后可能也不用
     *
     * @return
     */
    @RequestMapping("member/jsonUserCentergetsouquan")
    @ResponseBody
    public JSONObject jsonUserCentergetsouquan() {
        return JsonResponseUtil.success();
    }

    /**
     * 。。。。。可能要放弃
     *
     * @return
     */
    @RequestMapping("member/jsonUserCentergetUpStore")
    @ResponseBody
    public JSONObject jsonUserCentergetUpStore() {
        return JsonResponseUtil.success();
    }

    @RequestMapping("{identity}/userBalance")
    public String userBalance(@PathVariable String identity, HttpSession session, Model model) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempCode = paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode", tempCode);
        model.addAttribute("webSite", "hz");
        model.addAttribute("excelUrl", "");
        if (SELLER_PATH.equals(identity)) {
            return "gys/userBalance";
        }
        return "fxs/userBalance";
    }

    @RequestMapping("{identity}/userbalanceShow")
    @ResponseBody
    public JSONObject userBalanceInfo(@PathVariable String identity, HttpSession session) {
        if (!isMemberOrSeller(identity)) {
            return JsonResponseUtil.error("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return memberSimpleService.getUserBalanceShow(ps.getUserId());
    }

    /**
     * 红包余额
     *
     * @param identity
     * @param session
     * @param model
     * @return
     * @throws Main4Exception
     */
    @RequestMapping("{identity}/userBonus")
    public String userBonus(@PathVariable String identity, HttpSession session, Model model) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        // 用户红包余额
        Long bonusBalance = memberSimpleService.getUserBonusBalance(ps.getUserId());
        model.addAttribute("bonusBalance", String.format("%.2f", bonusBalance * 0.01));
        // 用户红包记录
        List<BonusRecordVo> bonusRecordVoList = new ArrayList<>();
        List<ShiguBonusRecord> bonusRecordList = memberSimpleService.getUserBonusRecord(ps.getUserId());
        if (bonusRecordList != null && !bonusRecordList.isEmpty()) {
            for (ShiguBonusRecord bonusRecord : bonusRecordList) {
                BonusRecordVo bonusRecordVo = new BonusRecordVo();
                bonusRecordVo = BonusRecordTypeEnum.fillBonusRecordVo(bonusRecordVo,bonusRecord);
                if (bonusRecordVo == null) {//未知类型不展示
                    continue;
                }
                bonusRecordVoList.add(bonusRecordVo);
            }
        }
        model.addAttribute("bonusList", bonusRecordVoList);
        if (SELLER_PATH.equals(identity)) {
            return "gys/userBonus";
        }
        return "fxs/userBonus";
    }

    /**
     * 资金流水
     *
     * @return
     */
    @RequestMapping("member/capStatistic")
    public String capStatistic(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String tempCode = paySdkClientService.tempcode(ps.getUserId());
        model.addAttribute("tempCode", tempCode);
        return "fxs/capStatistic";
    }

    /**
     * 申请提现链接
     *
     * @return
     */
    @RequestMapping({"member/rechargeJson", "seller/rechargeJson"})
    @ResponseBody
    public JSONObject rechargeJson(HttpSession session, Double money) throws PayApplyException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Double moneyfen = money * 100;
        PayApplyVO applyVO = userAccountService.rechargeApply(ps.getUserId(), moneyfen.longValue());
        return JsonResponseUtil.success().element("href", "/order/alipayByApplyId.htm?applyId=" + applyVO.getApplyId());
    }

    /**
     * 用户绑定支付宝列表页面
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("{identity}/bindAlipayUser")
    public String bindAlipayUser(@PathVariable String identity, HttpSession session, Model model) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //在shiro中配置过拦截,能进入member/下的请求都是已经登陆的
        Long userId = ps.getUserId();
        List<UserAlipayBindVO> alipayUserList = userAccountService.userAlipayBindList(userId);
        model.addAttribute("alipayUserList", alipayUserList);
        if (SELLER_PATH.equals(identity)) {
            return "gys/bindAlipayUser";
        }
        return "fxs/bindAlipayUser";
    }

    /**
     * 新增绑定支付宝号页面
     *
     * @param session
     * @param model
     * @return
     * @throws Main4Exception
     */
    @RequestMapping("{identity}/bindAlipayUserOpe")
    public String bindAlipayUserOpe(@PathVariable String identity, HttpSession session, Model model) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        String phoneByUserId = userLicenseService.findPhoneByUserId(userId);
        //用户绑定手机号是否存在校验
        if (StringUtils.isEmpty(phoneByUserId) || 11 != phoneByUserId.length()) {
            throw new Main4Exception("请检查绑定手机号");
        }
        String userTelephone = phoneByUserId.substring(0, 3).concat("****").concat(phoneByUserId.substring(8));
        model.addAttribute("userTelephone", userTelephone);
        if (SELLER_PATH.equals(identity)) {
            return "gys/bindAlipayUserOpe";
        }
        return "fxs/bindAlipayUserOpe";
    }

    /**
     * 校验手机号
     *
     * @param imgValidate
     * @param session
     * @return
     */
    @RequestMapping({"member/getTeleValidateCode", "seller/getTeleValidateCode"})
    @ResponseBody
    public JSONObject getTeleValidateCode(String imgValidate, HttpSession session) {
        //校验手机验证码
        if (imgValidate == null || !imgValidate.equals(session.getAttribute(SessionEnum.SEND_REGISTER_MSG.getValue()))) {
            return JsonResponseUtil.error("请输入正确的图形验证码");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String phone = userLicenseService.findPhoneByUserId(ps.getUserId());
        if (phone == null) {
            return JsonResponseUtil.error("请先绑定手机号");
        }
        String code = RedomUtil.redomNumber(6);
        sendMsgService.sendVerificationCode(phone, code);
        session.setAttribute(SessionEnum.PHONE_BIND_MSG.getValue(), new PhoneVerify(phone, code));
        return JsonResponseUtil.success();
    }

    /**
     * 用户支付宝绑定请求
     *
     * @param bo
     * @param session
     * @param result
     * @return
     */
    @RequestMapping({"member/applyAliUserBind", "seller/applyAliUserBind"})
    @ResponseBody
    public JSONObject applyAliUserBind(@Valid MemberAlipayBindBO bo, HttpSession session, BindingResult result) {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        String userRealName = bo.getUserRealName();
        if (StringUtils.isEmpty(userRealName)) {
            return JsonResponseUtil.error("提示：对不起，请您填写真实姓名，真实姓名是您进行支付宝账户绑定时重要的信息。");
        }
        if (userRealName.length() > 150) {
            return JsonResponseUtil.error("提示：对不起，请您填写真实姓名，真实姓名是您进行支付宝账户绑定时重要的信息。");
        }
        PhoneVerify verify = (PhoneVerify) session.getAttribute(SessionEnum.PHONE_BIND_MSG.getValue());
        if (verify == null || !verify.getVerify().equals(bo.getTeleValidateCode())) {
            return JsonResponseUtil.error("需要正确的手机验证码");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        String phone = userLicenseService.findPhoneByUserId(userId);
        if (phone == null) {
            return JsonResponseUtil.error("请先绑定手机号");
        }
        return userAccountService.applyAliUserBind(bo, userId);
    }

    /**
     * 删除绑定支付宝帐号
     *
     * @param aliAccountId 用户支付宝绑定记录id
     * @return
     */
    @RequestMapping({"member/deleteAliUser", "seller/deleteAliUser"})
    @ResponseBody
    public JSONObject deleteAliUser(Long aliAccountId, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return userAccountService.deleteAliUser(ps.getUserId(), aliAccountId);
    }

    /**
     * 新充值接口
     *
     * @param money   充值金额 元
     * @param type    充值类型 1支付宝 2微信  （目前只开放支付宝充值）
     * @param session
     * @return 支付宝支付连接跳转地址
     */
    @RequestMapping({"member/userRecharge", "seller/userRecharge"})
    @ResponseBody
    public JSONObject userRecharge(Double money, Integer type, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws PayApplyException, IOException {
        if (money == null || money <= 0) {
            return JsonResponseUtil.error("请输入正确的金额");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String servletPath = request.getServletPath();
        if (servletPath.contains("member") && type == 3) {//分销商不能红包充值  1支付宝充值 2微信充值 3红包充值
            return JsonResponseUtil.error("供应商不能进行红包充值");
        }

        if (type == 3) {
            boolean success = userAccountService.redPackApply(ps.getUserId(), (long) (money * 100));
            if (success) {
                return JsonResponseUtil.success();
            }
            return JsonResponseUtil.error("充值失败");
        }else {
            PayApplyVO payApplyVO = userAccountService.rechargeApply(ps.getUserId(), (long) (money * 100));
            return JsonResponseUtil.success().element("href", "/order/alipayByApplyId.htm?applyId=" + payApplyVO.getApplyId()).element("applyId", payApplyVO.getApplyId());
        }
    }

    /**
     * 提现保存
     *
     * @return
     */
    @RequestMapping({"member/saveTixian", "seller/saveTixian"})
    @ResponseBody
    public JSONObject saveTixian(@Valid NewCashApplyBO bo, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return JsonResponseUtil.error(result.getAllErrors().get(0).getDefaultMessage());
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        if (!memberSimpleService.isPayPwdMatch(userId, bo.getPayPassword())) {
            return JsonResponseUtil.error("请检查支付密码");
        }
        TixianBO tixianBO = userAccountService.selTixianAccountInfoByBindId(userId, bo.getAlipayId());
        if (tixianBO == null) {
            return JsonResponseUtil.error("帐号信息错误");
        }
        tixianBO.setPaynum(bo.getPaynum());
        return paySdkClientService.tixian(tixianBO, userId);
    }


    /**
     * 是否充值完成轮询
     *
     * @param identity 供应商/分销商
     * @param applyId  支付申请id
     * @param session
     * @return 支付完成，返回success与跳转地址
     */
    @RequestMapping("{identity}/userPayPolling")
    @ResponseBody
    public JSONObject userPayPolling(@PathVariable String identity, Long applyId, HttpSession session) {
        if (!isMemberOrSeller(identity)) {
            return JsonResponseUtil.error("非法的路径");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (userAccountService.alreadyCharged(ps.getUserId(), applyId)) {
            //供应商|分销商 充值完成跳转地址
            return JsonResponseUtil.success().element("redirectUrl", "userBalance.htm");
        }
        return JsonResponseUtil.error("支付未完成");
    }

    /**
     * 绑定成功跳转页
     *
     * @param identity
     * @return
     * @throws Main4Exception
     */
    @RequestMapping("{identity}/bindAlipaySuccess")
    public String bindAlipaySuccess(@PathVariable String identity) throws Main4Exception {
        if (!isMemberOrSeller(identity)) {
            throw new Main4Exception("非法的路径");
        }
        if (SELLER_PATH.equals(identity)) {
            return "gys/bindAlipaySuccess";
        }
        return "fxs/bindAlipaySuccess";
    }

    /**
     * 获取提现金额实际值
     *
     * @param userWirteMoney 用户填写金额，单位：元
     * @return
     */
    @RequestMapping({"member/getRealWithdrawMoney", "seller/getRealWithdrawMoney"})
    @ResponseBody
    public JSONObject getRealWithdrawMoney(Long userWirteMoney, Integer freeWithdrawNum) {
        if (userWirteMoney == null || userWirteMoney <= 0) {
            return JsonResponseUtil.error("请输入正确的金额");
        }
        if (freeWithdrawNum != null && freeWithdrawNum > 0) {
            return JsonResponseUtil.success().element("userRealWithdrawMoney", String.format("%.2f", 1.0 * userWirteMoney));
        }
        //单位 元->分，然后计算出手续费 目前为0.6%，不足1分部分由用户补齐 applyMoney(元) *100 * 994 /1000
        return JsonResponseUtil.success().element("userRealWithdrawMoney", String.format("%.2f", (userWirteMoney * 994 / (double) 10) * 0.01));
    }

    /**
     * 获取免费提现及限制信息
     *
     * @param session
     * @return
     */
    @RequestMapping({"member/getFreeWithdrawAndLimitInfo", "seller/getFreeWithdrawAndLimitInfo"})
    @ResponseBody
    public JSONObject getFreeWithdrawAndLimitInfo(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        return paySdkClientService.selCurrentFreeCashInfo(userId);
    }

    private boolean isMemberOrSeller(String identityPath) {
        return MEMBER_PATH.equals(identityPath) || SELLER_PATH.equals(identityPath);
    }



    @RequestMapping("member/inviteVip")
    public String inviteVip(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        String inviteCode = memberInviteService.userInviteCode(ps.getUserId());
        model.addAttribute("inviteCode", inviteCode);
        model.addAttribute("inviteSrc", "www.571xz.com/regedit.htm?inviteCode=" + inviteCode);
        model.addAttribute("invitedUserList", memberInviteService.inviteUserInfoList(ps.getUserId()));
        return "fxs/inviteVip";
    }
}
