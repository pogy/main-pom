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
import com.shigu.goodsup.pinduoduo.bo.*;
import com.shigu.goodsup.pinduoduo.exceptions.CustomException;
import com.shigu.goodsup.pinduoduo.service.PddGoodsUpService;
import com.shigu.goodsup.pinduoduo.vo.*;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.UUIDGenerator;
import com.shigu.main4.monitor.enums.GoodsUploadFlagEnum;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.LastUploadedVO;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.seller.services.GoodsFileService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pdd.beans.FabricContent;
import pdd.beans.GoodsFabric;
import pdd.beans.LogisticsTemplate;
import pdd.constant.PddConfig;
import pdd.goods.add.GoodsAddResponse;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    private Logger logger = LoggerFactory.getLogger(PddGoodsUpAction.class);

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
    @Resource
    private OssIO ossIO;

    //运费模板
    public static final String PDD_POST_TEMPLATE_PRE = "pdd_post_template_";
    //退换货模板
    public static final String PDD_RETURNS_TEMPLATE_PRE = "pdd_returns_template_";
    //利润模板
    public static final String PDD_PROFIT_TEMPLATE_PRE = "pdd_profit_template_";
    //店内类目更新
    public static final String UPDATE_PDD_SHOP_CATS_PRE = "update_pdd_shop_cats_pre";
    //cat_id=3845,233,231,218,234时需要入参服饰成分信息和服饰面料信息
    public static final List<String> FABRIC_CONTENT_IDS = Arrays.asList("3845","233","231","218","234");
    //拼多多临时文件夹
    public static final String PDD_FORDER = "onekey/";

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
        PddAuthInfoResponse pddAuthInfoResponse = null;
        try {
            String jsonStr = Opt3Des.decryptPlainData(code.replace(" ", "+"));
            pddAuthInfoResponse = com.alibaba.fastjson.JSONObject.parseObject(jsonStr, PddAuthInfoResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("拼多多授权失败 ->>> code = " + code );
        }
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
//            PersonalSession personalSession = userBaseService.selUserForSessionByUserName(pddAuthInfoResponse.getThirdUserNick(),thirdUid, LoginFromType.PDD);
//            if (personalSession == null || personalSession.getUserId() == null) {
//                //还是检查一遍避免 字符串+null 出现
//                throw new Main4Exception("授权失败");
//            }

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
            model.addAttribute("errmsg","商品不存在");
            return "pinduoduo/uperror";
        }

        //判断是否拼多多登陆
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        /********************************获取京东授权信息*******************************/
        if (ps==null) {
            return redirectLoginPdd(request);
        }

        //拿拼多多授权信息并刷新授权 无授权信息或刷新出现异常跳登陆
        Long pddUid = pddGoodsUpService.selPddUserId(ps.getUserId());
        if (pddUid == null) {
            return redirectLoginPdd(request);
        }
        if (ps.getLoginFromType() != LoginFromType.PDD) {
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
//            throw new CustomException("档口不支持代理功能");
            model.addAttribute("errmsg","档口不支持上传");
            return "pinduoduo/uperror";
        }

        /********************************查上传记录********************************/
        try {
            if (bo.getYesrepeat() == null || bo.getYesrepeat() != 1) {
                LastUploadedVO lastup = itemUpRecordService.selLastUpByIds(ps.getUserId(),bo.getGoodsId(), GoodsUploadFlagEnum.PDD);
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
            model.addAttribute("errmsg","未查询到类目信息");
            return "pinduoduo/uperror";
        }
        PddItemDetailVO pddItemDetailVO = pddGoodsUpService.goodsDetail(bo.getGoodsId());
        if (pddItemDetailVO == null) {
            model.addAttribute("errmsg","商品不存在");
            return "pinduoduo/uperror";
        }

        /********************************查出类目信息********************************/

        Long pddCid = null;
        if (bo.getCid() != null) {
            pddCid = bo.getCid();
        }else {
            pddCid = pddGoodsUpService.selPddCidByXzCid(xzCid);
            if (pddCid == null) {
                //选类目
                return "redirect:http://www.571xz.com/pdd/changeGoodsCate.htm?goodsId="+bo.getGoodsId();
            }
        }
        String allCids = pddGoodsUpService.selPddCatsIdsByPddCid(pddCid);
        model.addAttribute("pddCatName",pddGoodsUpService.selPddCatsNamesByPddCid(pddCid));
        model.addAttribute("xzCatName",pddGoodsUpService.selXzCatsName(bo.getGoodsId()));
        model.addAttribute("allCids",allCids);
        model.addAttribute("pddCid",pddCid);

        //cat_id=3845,233,231,218,234时需要入参服饰成分信息和服饰面料信息
        boolean flag = false;
        for (String item : FABRIC_CONTENT_IDS){
            if (allCids.contains(item)) {
                flag = true;
                break;
            }
        }
        if (flag) {//查询服饰面料信息
            List<FabricContent> fabricContents = pddGoodsUpService.selFabricContent(ps.getUserId());
            List<GoodsFabric> goodsFabrics = pddGoodsUpService.selGoodsFabric(ps.getUserId());
            model.addAttribute("fabricContent",fabricContents);
            model.addAttribute("goodsFabric",goodsFabrics);
        }


        /******************** 根据利润模板设置利润 团购价 及 单买价 *******************/
        ProfitTemplate profitTemplate = redisIO.get(PDD_PROFIT_TEMPLATE_PRE + ps.getUserId(), ProfitTemplate.class);
        if (profitTemplate != null && profitTemplate.getActived() == 1) {

            BigDecimal price = new BigDecimal(pddItemDetailVO.getPrice());
            BigDecimal liPrice = null;
            BigDecimal profit = null;
            if (profitTemplate.getType() == 1) {
                profit = new BigDecimal(profitTemplate.getProfit());
                price = price.add(profit);
            }else {
                profit = new BigDecimal(profitTemplate.getProfit()).divide(new BigDecimal("100"),2,BigDecimal.ROUND_UP);
                profit = price.multiply(profit).setScale(2,BigDecimal.ROUND_UP);
                price = price.add(profit);
            }

            if (profitTemplate.getRounding() != null && profitTemplate.getRounding() == 1) {
                //结果取整
                price = price.setScale(0, BigDecimal.ROUND_UP);
                liPrice = new BigDecimal("2").multiply(price);
                profit = price.subtract(new BigDecimal(pddItemDetailVO.getPrice())).setScale(2,BigDecimal.ROUND_UP);
            }else {
                price = price.setScale(2, BigDecimal.ROUND_UP);
                liPrice = new BigDecimal("2").multiply(price).setScale(2,BigDecimal.ROUND_UP);
                profit = price.subtract(new BigDecimal(pddItemDetailVO.getPrice())).setScale(2,BigDecimal.ROUND_UP);
            }

            pddItemDetailVO.setPrice(price.toString());
            pddItemDetailVO.setLiPrice(liPrice.toString());//默认为团购件的2倍
            pddItemDetailVO.setProfit(profit.toString());
        }else {
            pddItemDetailVO.setPrice(pddItemDetailVO.getLiPrice());
            BigDecimal liPrice = new BigDecimal(pddItemDetailVO.getLiPrice()).multiply(new BigDecimal("2")).setScale(2,BigDecimal.ROUND_UP);
            pddItemDetailVO.setLiPrice(liPrice.toString());
        }
        model.addAttribute("item",pddItemDetailVO);
        if (profitTemplate != null) {
            model.addAttribute("profitTemplate",profitTemplate);
        }

        /******************** 退换货模板 *********************/
        ReturnsTemplate returnsTemplate = redisIO.get(PDD_RETURNS_TEMPLATE_PRE + ps.getUserId(), ReturnsTemplate.class);
        if (returnsTemplate == null) {
            returnsTemplate = new ReturnsTemplate();
            returnsTemplate.setArtificial(1);
            returnsTemplate.setDelivery(0);
            returnsTemplate.setReturns(1);
        }
        model.addAttribute("returnsTemplate",returnsTemplate);

        //生成本次上传唯一码 userId + uuid + goodsId  用来记录本次操作上传图片数，用户可能同时上传同一件商品
        String tempCode = ps.getUserId() + UUIDGenerator.getUUID() + bo.getGoodsId();
        model.addAttribute("tempCode",tempCode);

        return "pinduoduo/pdd";
    }

    /**
     * 上传
     * @return
     */
    @RequestMapping("index")
    public String upload (PddUploadBO bo,
                              @RequestParam(value = "picUrl[]")String[] picUrl,
                              @RequestParam(value = "descPicUrl[]")String[] descPicUrl,
                              String skus,
                              String tempCode,
                              Long mid,//goodsId
                              HttpSession session,Model model) {
        redisIO.del(tempCode);//删除图片上传记录

        String errMsg = null;
        try {
            bo.canUpload();
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            model.addAttribute("errorMsg",errMsg);
            return "pinduoduo/parts/success";
        }

        if (picUrl == null || picUrl.length <= 0 ){
            errMsg = "请上传轮播图";
            model.addAttribute("errorMsg",errMsg);
            return "pinduoduo/parts/success";
        }
        if (descPicUrl == null || descPicUrl.length <= 0) {
            errMsg = "请上传详情图";
            model.addAttribute("errorMsg",errMsg);
            return "pinduoduo/parts/success";
        }
        if (StringUtils.isBlank(skus)) {
            errMsg = "sku不能为空";
            model.addAttribute("errorMsg",errMsg);
            return "pinduoduo/parts/success";
        }

        List<SkuBO> skuBOS = com.alibaba.fastjson.JSONObject.parseArray(skus, SkuBO.class);
        if (skuBOS == null || skuBOS.isEmpty()) {
            errMsg = "颜色sku不能为空";
            model.addAttribute("errorMsg",errMsg);
            return "pinduoduo/parts/success";
        }

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        GoodsAddResponse response = null;
        try {
            response = pddGoodsUpService.upload(bo, picUrl, descPicUrl, skuBOS, ps.getUserId());
        } catch (CustomException e) {
            e.printStackTrace();
            errMsg = e.getMessage();
            model.addAttribute("errorMsg",errMsg);
            return "pinduoduo/parts/success";
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errorMsg","上传失败，请联系客服处理");
            return "pinduoduo/parts/success";
        }

        //记录上次是用的运费模板
        redisIO.put(PDD_POST_TEMPLATE_PRE + ps.getUserId(),bo.getPostage_id());
        //添加上传记录
        try {
            pddGoodsUpService.saveRecord(ps.getUserId(),bo.getCid(),mid,bo,response.getGoodsCommitId());
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("添加拼多多上传记录失败 >>> [userId = " +ps.getUserId() +" cid = "
                    +bo.getCid()+" goodsId ="+mid+"goodsCommitId ="+response.getGoodsCommitId()+"]");
        }

        try {
            pddGoodsUpService.addUsedCatRecord(ps.getUserId(),bo.getCid());
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("numIid",response.getGoodsCommitId());
        return "pinduoduo/parts/success";
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
        if (logisticsTemplates != null && !logisticsTemplates.isEmpty()) {
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
        if (bo.getType() != 1 && bo.getType() != 2 ) {
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
     * 查询pdd店内类目信息
     * @return
     */
    @RequestMapping("selPddCats")
    @ResponseBody
    public JSONObject selPddCats (Long pddCid,HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<com.openJar.pdd.beans.ShopCat> goodsCats = pddGoodsUpService.selAuthorizationCats(ps.getUserId(), pddCid);
        return JsonResponseUtil.success().element("goodsCats",goodsCats == null ? new ArrayList() : goodsCats);
    }

    /**
     * 强制更新pdd店内类目信息 每天最多更新3次
     * @return
     */
    @RequestMapping("updateShopCats")
    @ResponseBody
    public JSONObject updateShopCats (HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Integer updateNum = redisIO.get(UPDATE_PDD_SHOP_CATS_PRE + ps.getUserId(), Integer.class);
        if (updateNum != null && updateNum <= 0) {
            return JsonResponseUtil.error("今日更新次数已用完");
        }
        return pddGoodsUpService.updateShopCats(ps.getUserId());
    }


    /**
     * 生成商家自定义的规格
     * 1 颜色 0 尺码
     * @return
     */
    @RequestMapping("addProp")
    @ResponseBody
    public JSONObject addProp (AddPropBO bo, HttpSession session){
        if ((bo.getType() != 0 && bo.getType() != 1) || bo.getPddCid() == null) {
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

    /**
     * 记录上传使用过的类目信息
     * @return
     */
    @RequestMapping("addUsedCatRecord")
    @ResponseBody
    public JSONObject addUsedCatRecord (Long pddCid, HttpSession session){
//        if (pddCid == null) {//错误不影响正常使用
//            return JsonResponseUtil.success();
//        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        pddGoodsUpService.addUsedCatRecord(ps.getUserId(),pddCid);
        return JsonResponseUtil.success();
    }

    /**
     * 查询用户上传使用过的类目信息
     * @return
     */
    @RequestMapping("selUsedCatRecord")
    @ResponseBody
    public JSONObject selUsedCatRecord (String catName, HttpSession session){
        if (StringUtils.isBlank(catName)) {//错误不影响正常使用
            return JsonResponseUtil.success();
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<UsedCatRecordVO> usedCatRecordVOS = pddGoodsUpService.selUsedCatRecord(ps.getUserId(), catName);
        return JsonResponseUtil.success().element("pddHistoryCategory",usedCatRecordVOS);
    }

    /**
     * 选择类目信息
     * @return
     */
    @RequestMapping("changeGoodsCate")
    public String chooseCat (String allCids,Long goodsId,String catName,Model model, HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<UsedCatRecordVO> usedCatRecordVOS = pddGoodsUpService.selUsedCatRecord(ps.getUserId(), catName);
        Integer updateNum = redisIO.get(UPDATE_PDD_SHOP_CATS_PRE + ps.getUserId(), Integer.class);
        if (updateNum == null) {
            updateNum = 3;
        }

        model.addAttribute("updateNum",updateNum);
        model.addAttribute("allCids",allCids);
        model.addAttribute("goodsId",goodsId);
        model.addAttribute("pddHistoryCategory",usedCatRecordVOS);
        return "pinduoduo/changeGoodsCate";
    }

    /**
     * 上传图片
     * @return
     */
    @RequestMapping("uploadImg")
    @ResponseBody
    public JSONObject uploadImg (String imgUrl,String tempCode,Integer type,HttpSession session){
        if (StringUtils.isBlank(imgUrl)) {
            return JsonResponseUtil.error("图片地址不能为空");
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        ImgUploadVO vo = null;
        try {
            vo = pddGoodsUpService.uploadImg(imgUrl,tempCode,type,ps.getUserId());
        } catch (CustomException e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getMessage());
        }
        return JsonResponseUtil.success().element("pddImgInfo",vo);
    }

    @RequestMapping("getAccessInfo")
    public String getPostSign( HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> infoMap = ossIO.createPostSignInfo(PDD_FORDER);
        JSONObject jsonInfo = JSONObject.fromObject(infoMap);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        String callbackFunName = request.getParameter("callback");
        if (callbackFunName==null || callbackFunName.equalsIgnoreCase(""))
            response.getWriter().println(jsonInfo.toString());
        else
            response.getWriter().println(callbackFunName + "( "+jsonInfo.toString()+" )");
        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
        return null;
    }

}
