package com.shigu.activity.actions;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.ShiguActivity;
import com.opentae.data.mall.interfaces.ShiguActivityMapper;
import com.shigu.activity.service.ActivityWebService;
import com.shigu.activity.service.DrawQualification;
import com.shigu.activity.service.NewPopularService;
import com.shigu.activity.tempvo.PopularGoodsVO;
import com.shigu.activity.vo.ActiveDrawStyleVo;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.active.vo.ShiguActivityVO;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.spread.enums.AutumnNewConstant;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.spread.vo.ActiveForShowVO;
import com.shigu.main4.spread.vo.active.draw.*;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.ucenter.enums.OtherPlatformEnum;
import com.shigu.seller.services.ActivityService;
import com.shigu.seller.vo.GfGoodsStyleVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 奖品活动
 * Created by zhaohongbo on 17/4/26.
 */
@Controller
public class ActivityAction {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActiveDrawService activeDrawServiceImpl;

    @Autowired
    private ShiguActivityMapper shiguActivityMapper;

    @Autowired
    private ActivityWebService activityWebService;

    @Autowired
    private RedisIO redisIO;

    /**
     * 秋装新品发布会0811临时使用
     */
    @Autowired
    private NewPopularService newPopularService;

    @Autowired
    private DrawQualification newAutumnDrawQualification;
    /**
     * 任性送现金活动
     */
    @RequestMapping("activity/cash")
    public String cash(Model model){
        model.addAttribute("webSite", "hz");
        return "xzSearch/cash";
    }
    /**
     * 发现好货
     *
     * @param model
     * @return
     */
    //@RequestMapping(value = "activity/redbull" , method = RequestMethod.GET)
    @Deprecated
    public String findGodos(HttpSession session, Model model) {
        // 当前期次
        ActiveDrawPemVo drawPem = activeDrawServiceImpl.selNowDrawPem(null);
        // 发现好货商品
        List<ActiveDrawGoodsVo> faGoodsVoList = activeDrawServiceImpl.selGoodsList(
                drawPem.getId(),
                ActiveDrawGoods.TYPE_FAGOODS,
                40,
                false, false);
        // 发现好店
        List<ActiveDrawShopVo> faShopVoList = activeDrawServiceImpl.selShopList(drawPem.getId(), false);
        ActiveDrawStyleVo drawStyleVo = new ActiveDrawStyleVo();
        drawStyleVo.setGoodsList(faGoodsVoList);
        drawStyleVo.setShopList(faShopVoList);

        // 每日发现商品
        List<ActiveDrawGoodsVo> daliyGoodsVoList = activeDrawServiceImpl.selGoodsList(
                drawPem.getId(),
                ActiveDrawGoods.TYPE_DAILYFIND,
                60,
                false, false);

        Collections.shuffle(daliyGoodsVoList);

        // 获奖数据
        List<ActiveDrawRecordUserVo> recordUserVoList = activeDrawServiceImpl.selDrawRecordList(null, null, "ben");

        // 用户上一期获奖数据
        List<ActiveDrawRecordUserVo> userVoList = new ArrayList<>();
        Object object = session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (object != null) {
            PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
            ActiveDrawPemVo drawLastPem = activeDrawServiceImpl.selNowDrawPem(drawPem.getStartTime());
            if (drawLastPem != null) {
                // 用户上一期获奖数据
                userVoList = activeDrawServiceImpl.selDrawRecordList(drawLastPem.getId(), ps.getUserId(), null);
            }
        }

        if (userVoList == null) {
            userVoList = new ArrayList<>();
        }

        for (ActiveDrawRecordUserVo anUserVoList : userVoList) {
            if (1 == anUserVoList.getDrawStatus()) {
                anUserVoList.setDrawStatus(2);
            }
        }


        //极限词过滤
        drawStyleVo.getShopList().forEach(activeDrawShopVo -> {
            if (activeDrawShopVo.getItems() != null) {
                activeDrawShopVo.getItems().forEach(shopItemVo -> shopItemVo.setTitle(KeyWordsUtil.duleKeyWords(shopItemVo.getTitle())));
            }
        });
        drawStyleVo.getGoodsList().forEach(activeDrawGoodsVo -> activeDrawGoodsVo.setTitle(KeyWordsUtil.duleKeyWords(activeDrawGoodsVo.getTitle())));
        daliyGoodsVoList.forEach(activeDrawGoodsVo -> activeDrawGoodsVo.setTitle(KeyWordsUtil.duleKeyWords(activeDrawGoodsVo.getTitle())));


        model.addAttribute("lastUserAward", JSON.toJSONString(userVoList));
        model.addAttribute("styleItem", drawStyleVo);
        model.addAttribute("likeGoodsList", daliyGoodsVoList);
        model.addAttribute("awardList", recordUserVoList);
        model.addAttribute("webSite", "hz");
        return "activity/styleHuodong";
    }

    /**
     * 分销商后台
     *
     * @return
     */
    @RequestMapping({"member/awardInfo","fxs/awardInfo"})
    public String awardInfo(HttpSession session, Model model) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        boolean vipIs = Objects.equals(true, ps.getOtherPlatform().get(OtherPlatformEnum.MEMBER_VIP.getValue()));
        List<ActiveForShowVO> actList = activityWebService.getAwardInfo(ps.getUserId(), vipIs);
        model.addAttribute("actList",actList);
        return "fxs/awardInfo";
    }

    /**
     * 发现好货开始结束时间显示
     * @param start
     * @return
     */
    private String parseToStartEnd(Date start) {
        final String dateFitment = "yyyy年MM月dd日";
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        String thisStart = DateUtil.dateToString(cal.getTime(), dateFitment);
        cal.add(Calendar.DATE, 7);
        String thisEnd = DateUtil.dateToString(cal.getTime(), dateFitment);
        return thisStart + " ——— " + thisEnd;
    }

    @RequestMapping("activity/redbull")
    public String findGoods(HttpSession session, Model model) {

        // 当前期次
        List<ActiveDrawPemVo> activeDrawPemVos = activeDrawServiceImpl.selDrawPemQueList();
        ActiveDrawPemVo drawPem = activeDrawPemVos.get(0);
        model.addAttribute("allInfo", drawPem.getInfo());
        ActiveDrawStyleVo drawStyleVo = new ActiveDrawStyleVo();
//        drawStyleVo.setGoodsList(faGoodsVoList);
        model.addAttribute("styleItem", drawStyleVo);

        // 每日发现商品
        List<ActiveDrawGoodsVo> daliyGoodsVoList = activeDrawServiceImpl.selGoodsList(
                drawPem.getId(),
                ActiveDrawGoods.TYPE_DAILYFIND,
                60,
                false, false
        );

        Collections.shuffle(daliyGoodsVoList);
        //极限词过滤
        daliyGoodsVoList.forEach(activeDrawGoodsVo -> activeDrawGoodsVo.setTitle(KeyWordsUtil.duleKeyWords(activeDrawGoodsVo.getTitle())));

        model.addAttribute("likeGoodsList", daliyGoodsVoList);
        // 时间处理
        model.addAttribute("webSite", "hz");
        return "activity/findGoods";
    }

    /**
     * 用户中奖记录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "activity/userWard", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject userWard(HttpSession session) {

        ResponseBase rsp = new ResponseBase();

        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());

        if (ps == null) {
            // 未登录
            rsp.setMsg("用户未登陆");
            return JSONObject.fromObject(rsp);
        }

//        // 当前期次
//        ActiveDrawPemVo drawPem = activeDrawServiceImpl.selNowDrawPem(null);
        // 中奖记录
        List<ActiveDrawRecordUserVo> drawRecordList = activeDrawServiceImpl.selDrawNowUserRecord(ps.getUserId());

        rsp.setResult(SystemConStant.RESPONSE_STATUS_SUCCESS);
        rsp.setData(drawRecordList);

        return JSONObject.fromObject(rsp);
    }

    /**
     * 查询抽奖
     *
     * @param tqcode
     * @return
     */
    @RequestMapping(value = "activity/qtiqucode", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject qtiqucode(String tqcode) {
        if (StringUtils.isEmpty(tqcode)) {
            return JsonResponseUtil.error("请输入有效领取码");
        }

        try {
            return JsonResponseUtil.success().element("awardInfo", activityWebService.queryByCode(tqcode));
        } catch (Main4Exception me) {
            me.printStackTrace();
            return JsonResponseUtil.error(me.getMessage());
        }
    }

    /**
     * 领取奖品
     *
     * @param tqcode
     * @return
     */
    @RequestMapping(value = "activity/qzhongjinag", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject qzhongjinag(String tqcode) {
        if (StringUtils.isEmpty(tqcode)) {
            return JsonResponseUtil.error("请输入有效领取码和用户");
        }
        try {
            activeDrawServiceImpl.receUserWard(tqcode);
            return JsonResponseUtil.success();
        } catch (Main4Exception e) {
            e.printStackTrace();
            return JsonResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 领取奖地址
     *
     * @return
     */
    @RequestMapping(value = "activity/receWards", method = RequestMethod.GET)
    public String receWards() {
        return "webApp/pickUpVouchers";
    }

    @RequestMapping("activity/popular")
    public String gfShow(Long id, Model model) throws Main4Exception {
        ShiguActivity activity;
        if (id == null || (activity = shiguActivityMapper.selectByPrimaryKey(id)) == null){
            throw new Main4Exception("页面不存在");
        }


        List<GfGoodsStyleVO> goodsStyles=activityService.gfShow(id);

        //极限词过滤
        activity.setTitle(KeyWordsUtil.duleKeyWords(activity.getTitle()));
        goodsStyles.forEach(gfGoodsStyleVO -> {
            gfGoodsStyleVO.setTitleText(KeyWordsUtil.duleKeyWords(gfGoodsStyleVO.getTitleText()));
            if(gfGoodsStyleVO.getGoodsList()!=null)
            gfGoodsStyleVO.getGoodsList().forEach(gfShowVO -> {
                gfShowVO.setTitle(KeyWordsUtil.duleKeyWords(gfShowVO.getTitle()));
            });
        });

        model.addAttribute("activeName", activity.getTitle());
        model.addAttribute("bannerSrc", activity.getBanner());
        model.addAttribute("bgColor", activity.getBkcolor());
        model.addAttribute("goodsStyle", goodsStyles);
        model.addAttribute("webSite", "hz");
        return "xzSearch/popular";
    }

    @RequestMapping("activity/apply")
    public String apply(Long id, Model model) throws Main4Exception {
        model.addAttribute("webSite", "hz");
//        if (id == null) {
//            throw new Main4Exception("页面不存在");
//        }
        int actState;
        ShiguActivityVO vo = activityService.activityInfo(id);
        long current = System.currentTimeMillis();
        if (vo == null || vo.getStartApply() == null || vo.getEndApply() == null) {
            actState = 2;
        }else if (vo.getStartApply().getTime() > current) {
            actState = 0;
        } else if (vo.getEndApply().getTime() > current) {
            actState = 1;
        } else {
            actState = 2;
        }

        //极限词过滤
        vo.setTitle(KeyWordsUtil.duleKeyWords(vo.getTitle()));

        model.addAttribute("actState", actState);
        model.addAttribute("id", id);
        return "activity/apply";
    }

    final String flag = "autumn_new5";

    @RequestMapping("activity/jsonapply")
    @ResponseBody
    public JSONObject signUp(HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        Long userId = ps.getUserId();
        String checkResult = activeDrawServiceImpl.shiguTempSigup(flag, userId, ps.getLogshop().getShopId());
        if (checkResult.equals("true")) {
            jsonObject.put("result", "success");
        } else {
            jsonObject.put("msg", checkResult);
        }
        return jsonObject;
    }

    @RequestMapping("activity/qzxpApply")
    public String qzxpApply(Model model, HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if (ps != null && ps.getLogshop() != null) {
            model.addAttribute("alreadyApply", newPopularService.checkTempSignUp(flag,ps.getUserId(), ps.getLogshop().getShopId()));
        }
        model.addAttribute("webSite", "hz");
        return "xzSearch/qzxpApply";
    }

    /**
     * 临时用一下
     */
    @RequestMapping("activity/qzxpShop")
    public String qzxpShop(Model model) {
        model.addAttribute("webSite", "hz");
        return "xzSearch/qzxpShop";
    }

    /**
     * 秋装新品发布会0811临时使用，仅杭州
     *
     * @param model
     * @return
     */
    @RequestMapping("activity/newPopular")
    public String newPopular(Model model) {
        List<PopularGoodsVO> popularGoodsVOS=newPopularService.selNewPopularGoodsList(AutumnNewConstant.ACTIVE_FLAG);
        //极限词过滤
        popularGoodsVOS.forEach(popularGoodsVO -> popularGoodsVO.setTitle(KeyWordsUtil.duleKeyWords(popularGoodsVO.getTitle())));

        model.addAttribute("webSite", "hz");
        model.addAttribute("goodsList", popularGoodsVOS);
        return "activity/newPopular";
    }

    @RequestMapping("activity/lottery")
    public String lottery(Model model, HttpSession session) {
        model.addAttribute("webSite", "hz");
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        DrawVerifyVO qualification = newAutumnDrawQualification.hasDrawQualification(ps.getUserId());
        int lotteryNum = qualification.getOpportunityFrequency() - qualification.getUsedFrequency();
        model.addAttribute("lettoryNumber", lotteryNum);
        return "xzSearch/lottery";
    }

    @RequestMapping("activity/getAwards")
    @ResponseBody
    public JSONObject getAwards(HttpSession session) throws JsonErrException {
        Long userId = ((PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue())).getUserId();
        int awards = 5;
        try {
            DrawResult drawResult = newAutumnDrawQualification.tryHitDraw(userId);
            awards = drawResult == null || drawResult.getRank() == null ? 6 : drawResult.getRank() == 0 ? 5 : drawResult.getRank();
        } catch (JsonErrException e){
            if ("没有抽奖资格".equals(e.getMessage())) {
                awards=6;
            } else {
                throw e;
            }
        }
        return JsonResponseUtil.success().element("awards", awards);
    }


    /**
     * 批量下单活动宣传页
     * @return
     */
    @RequestMapping("batchOrders")
    public String batchOrders() {
        return "xzPage/batchOrders";
    }

    /**
     *
     */
    @RequestMapping("qualityControl")
    public String qualityControl() {
        return "xzPage/qualityControl";
    }

    /**
     *
     */
    @RequestMapping("xzPage/about")
    public String about() {
        return "xzPage/about";
    }
}
