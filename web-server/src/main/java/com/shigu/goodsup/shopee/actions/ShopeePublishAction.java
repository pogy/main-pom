package com.shigu.goodsup.shopee.actions;

import com.shigu.buyer.actions.UserLoginAction;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.configBean.MainSiteConfig;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.shopee.service.ShopeeService;
import com.shigu.goodsup.shopee.services.ShopeePropsService;
import com.shigu.goodsup.shopee.vo.ShopeeShowDataVO;
import com.shigu.search.actions.PageErrAction;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tb.finder.exceptions.TbPropException;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.upload.shopee.sdk.response.ShopeeGetShopInfoResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;

@Controller
public class ShopeePublishAction {
    @Autowired
    JdUpItemService jdUpItemService;
    @Autowired
    ShopeePropsService shopeePropsService;
    private static final Logger logger = LoggerFactory.getLogger(ShopeePublishAction.class);

    @Autowired
    private ShopeeService shopeeService;

    @Autowired
    private MainSiteConfig mainSiteConfig;

    @Autowired
    private PageErrAction pageErrAction;

    @Autowired
    private UserLoginAction userLoginAction;

    @RequestMapping("login")
    public String login(String backUrl) {
        String toUrl = "";
        if (StringUtils.isNotBlank(backUrl)) {
            toUrl = backUrl;
        }
        return "redirect:" + shopeeService.authorUrl(mainSiteConfig.getMainSiteDomain() + "shopee/callback.htm?backUrl=" + toUrl);
    }

    @RequestMapping("callback")
    public String callback(Long shop_id, String backUrl, HttpServletRequest request, Model model, HttpSession session) {
        if (shop_id == null) {
            return pageErrAction.pageErr("授权失败", model);
        }
        ShopeeGetShopInfoResponse shopInfo = shopeeService.shopeeShopInfo(shop_id);
        if (!shopInfo.isSuccess()) {
            return pageErrAction.pageErr(shopInfo.getErrorDescription(), model);
        }
        if (shopInfo.getShopId() != null) {
            shopeeService.refreshShopeeUser(shopInfo);
            Subject currentUser = SecurityUtils.getSubject();
            CaptchaUsernamePasswordToken token = new CaptchaUsernamePasswordToken(shopInfo.getShopName(), null, true, request.getRemoteAddr(), "", UserType.MEMBER);
            token.setLoginFromType(LoginFromType.SHOPEE);
            token.setSubKey(shopInfo.getShopId().toString());
            token.setRememberMe(true);
            session.setAttribute(SessionEnum.OTHEER_LOGIN_CALLBACK.getValue(), backUrl);
            return userLoginAction.tryLogin(currentUser, token, session);
        } else {
            return pageErrAction.pageErr("获取用户信息失败", model);
        }
    }

    @RequestMapping("sp/publish")
    public String publish(Long goodsId, Long cid, Model model) throws CustomException, TbPropException {
        if(cid==null){
            //todo 获取类目列表,并指向到类目选择页
            return "redirect:changeGoodsCate.htm?id="+goodsId;
        }
        Long shopeeId=0L;
        JdPageItem item;
        try {
            item= jdUpItemService.findGoods(goodsId);
            if(item==null){
                model.addAttribute("errmsg","商品不存在");
                return "shopee/uperror";
            }
            //计算标题与卖点的长度
            if(item.getItem().getTitle()!=null){
                item.setTitleLength(item.getItem().getTitle().getBytes(Charset.forName("GBK")).length);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("获取商品数据异常",e);
            throw new CustomException("商品信息异常");
        }

        ShopeeShowDataVO allData=new ShopeeShowDataVO();
        allData.setItems(item);
        allData.setJdUserId(shopeeId);
//        allData.setDeliveyList(shopeePropsService.selPostModel(shopeeId));
        allData.setProps(shopeePropsService.selProps(goodsId,cid));
//        allData.setStoreCats(jdUpItemService.selShopCats(jdUserId));
        allData.setGoodsCat(shopeePropsService.selCatPath(cid));
        return "shopee/sp";
    }

    @RequestMapping("sp/getCateDatas")
    @ResponseBody
    public JSONObject getCateDatas(Long cid){
        return JsonResponseUtil.success().element("datas",shopeePropsService.selCate(cid));
    }
}
