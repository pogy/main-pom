package com.shigu.buyer.actions;

import com.shigu.buyer.bo.SubmitRuzhuBO;
import com.shigu.buyer.services.ShopExamineTypeService;
import com.shigu.buyer.vo.FloorVO;
import com.shigu.buyer.vo.MarketVO;
import com.shigu.buyer.vo.SiteVO;
import com.shigu.component.shiro.enums.RoleEnum;
import com.shigu.exceptions.RuzhuException;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.exceptions.ShopRegistException;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.ucenter.services.UserBaseService;
import com.shigu.main4.ucenter.vo.OuterUser;
import com.shigu.main4.vo.FloorForRegist;
import com.shigu.main4.vo.MarketForRegist;
import com.shigu.main4.vo.ShopRegister;
import com.shigu.main4.vo.SiteForRegist;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.XzSdkClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 开店
 * Created by zhaohongbo on 17/3/3.
 */
@Controller
public class OpenShopAction {
    private static final Logger logger = Logger.getLogger(OpenShopAction.class);

    @Autowired
    ShopRegistService shopRegistService;

    @Autowired
    ShopExamineTypeService shopExamineTypeService;

    @Autowired
    XzSdkClient xzSdkClient;

    @Autowired
    UserBaseService userBaseService;
    /**
     * 入驻页面
     * @return
     */
    @RequestMapping("ruzhu")
    public String ruzhu(HttpSession session, HttpServletRequest request) throws Main4Exception {
        //如果已经有店,不能重复申请
        Subject currentUser = SecurityUtils.getSubject();
        if(currentUser.hasRole(RoleEnum.STORE.getValue())){
//            throw new Main4Exception("本账号下已经有");
            return "redirect:/seller/index.htm";
        }
        PersonalSession auth = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<OuterUser> outerUsers = userBaseService.selOuterUsers(auth.getUserId());
        for (OuterUser user : outerUsers) {
            if (user.getLoginFromType() == LoginFromType.TAOBAO) {
                request.setAttribute("tbNick", user.getOuterNick());
            }
        }
        request.setAttribute("mainbusList",xzSdkClient.getXzMainBus().split(","));
        return "ruzhu/ruzhu";
    }

    /**
     * 分站点请求
     * @return
     */
    @RequestMapping("jsonWbSite")
    @ResponseBody
    public JSONObject jsonWbSite(){
        List<SiteForRegist> sites=shopRegistService.selSites();
        List<SiteVO> siteVOs=new ArrayList<>();
        for(SiteForRegist sfr:sites){
            siteVOs.add(new SiteVO(sfr.getWebSite(),sfr.getSiteName()));
        }
        return JsonResponseUtil.success().element("citys", JSONArray.fromObject(siteVOs));
    }

    /**
     * 站点对应的市场
     * @return
     */
    @RequestMapping("jsonMarket")
    @ResponseBody
    public JSONObject jsonMarket(String cityId){
        List<MarketForRegist> markets=shopRegistService.selMarkets(cityId);
        List<MarketVO> marketVOs=new ArrayList<>();
        for(MarketForRegist mfr:markets){
            marketVOs.add(new MarketVO(mfr.getMarketId(),mfr.getMarketName()));
        }
        return JsonResponseUtil.success().element("markets", JSONArray.fromObject(marketVOs))
                .element("cityId",cityId);
    }

    /**
     * 市场里的楼层
     * @param marketId
     * @return
     */
    @RequestMapping("jsonFloor")
    @ResponseBody
    public JSONObject jsonFloor(Long marketId){
        List<FloorForRegist> floors=shopRegistService.selFloors(marketId);
        List<FloorVO> floorVOs=new ArrayList<>();
        for(FloorForRegist ffr:floors){
            floorVOs.add(new FloorVO(ffr.getFloorId(),ffr.getFloorName()));
        }
        return JsonResponseUtil.success().element("floors",JSONArray.fromObject(floorVOs));
    }

    /**
     * 入驻提交
     * @return
     */
    @RequestMapping("submitRuzhu")
    @ResponseBody
    public JSONObject submitRuzhu(@Valid SubmitRuzhuBO bo, BindingResult result,
                                  HttpServletRequest request, HttpSession session) throws JsonErrException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(result.hasErrors()){
            throw new JsonErrException(result.getAllErrors().get(0).getDefaultMessage());
        }
        //如果已经开过店,扔异常
        if(ps.getLogshop()!=null){
            throw new JsonErrException("账号已经开过店");
        }
        ShopRegister shopRegister=new ShopRegister();
        shopRegister.setIp(request.getRemoteHost());
        shopRegister.setUserId(ps.getUserId());
        shopRegister.setTags(bo.parseServerLevel());
        shopRegister.setFloorId(bo.getMarketFloor());
        shopRegister.setMarketId(bo.getMarketId());
        shopRegister.setMainBus(bo.getMainCate());
        shopRegister.setEmail(bo.getEmail());
        shopRegister.setShopNum(bo.getStoreNum());
        shopRegister.setImQq(bo.getQq());
        shopRegister.setImWx(bo.getWx());
        shopRegister.setTelephone(bo.getTel());
        shopRegister.setWebSite(bo.getCityId());
        shopRegister.setImAliww(bo.getAliWw());
        shopRegister.setCanExamine(true);
        shopRegister.setTbNick(bo.getTbNick());
        Long applyId;
        try {
            applyId=shopRegistService.registShop(shopRegister);
        } catch (ShopRegistException e) {
            throw new JsonErrException(e.getMessage());
        }
        return JsonResponseUtil.success().element("userCode",applyId);
    }

    /**
     * 入驻申请
     * @return
     */
    @RequestMapping("ruzhu_sq")
    public String ruzhu_sq(String userCode,HttpSession session) throws RuzhuException {
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        boolean result=shopExamineTypeService.canExamine(ps.getUserId(),Long.valueOf(userCode));
        if(!result){//信息不全
            return "redirect:https://oauth.taobao.com/authorize?response_type=code&client_id=21720662" +
                    "&redirect_uri="+xzSdkClient.getYjHost()+"openStoreAuth.htm&state="+userCode+"&view=web";
        }
        return "ruzhu/ruzhu_sq";
    }

}
