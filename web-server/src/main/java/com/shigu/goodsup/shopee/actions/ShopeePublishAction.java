package com.shigu.goodsup.shopee.actions;

import com.shigu.buyer.actions.UserLoginAction;
import com.shigu.component.shiro.CaptchaUsernamePasswordToken;
import com.shigu.component.shiro.enums.UserType;
import com.shigu.configBean.MainSiteConfig;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.vo.JdPageItem;
import com.shigu.goodsup.shopee.bo.UptoTbShopee;
import com.shigu.goodsup.shopee.service.ShopeeService;
import com.shigu.goodsup.shopee.services.ShopeePropsService;
import com.shigu.goodsup.shopee.utils.ZHConverter;
import com.shigu.goodsup.shopee.vo.ShopeeShowDataVO;
import com.shigu.search.actions.PageErrAction;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tb.finder.exceptions.TbPropException;
import com.shigu.tools.JsonResponseUtil;
import com.taobao.api.domain.Item;
import com.shigu.upload.shopee.sdk.response.ShopeeGetShopInfoResponse;
import net.sf.json.JSONArray;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    @RequestMapping("sp/login")
    public String login() {
        return "redirect:" + shopeeService.authorUrl(mainSiteConfig.getMainSiteDomain() + "sp/callback.htm");
    }

    @RequestMapping("sp/callback")
    public String callback(@RequestParam(value = "shop_id",required = false)Long shopId, HttpServletRequest request, Model model, HttpSession session) {
        if (shopId == null) {
            return pageErrAction.pageErr("授权失败", model);
        }
        ShopeeGetShopInfoResponse shopInfo = shopeeService.shopeeShopInfo(shopId);
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
            return userLoginAction.tryLogin(currentUser, token, session);
        } else {
            return pageErrAction.pageErr("获取用户信息失败", model);
        }
    }

    @RequestMapping("sp/changeGoodsCate")
    public String changeGoodsCate(Long goodsId,Model model, HttpSession session){
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps==null||ps.getLoginFromType()!=LoginFromType.SHOPEE){
            String url=mainSiteConfig.getMainSiteDomain()+"sp/changeGoodsCate.htm?goodsId="+goodsId;
            try {
                url= URLEncoder.encode(url,"utf-8");
            } catch (UnsupportedEncodingException e) {
            }
            return "redirect:"+mainSiteConfig.getMainSiteDomain()+"ortherLogin.htm?ortherLoginType=9&&backUrl="+url;
        }
        model.addAttribute("goodsId",goodsId);
        return "shopee/changeGoodsCate";
    }

    @RequestMapping("sp/publish")
    public String publish(Long goodsId, Long cid, Model model, HttpSession session) throws CustomException, TbPropException {
        if(cid==null){
            return "redirect:changeGoodsCate.htm?goodsId="+goodsId;
        }
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(ps==null||ps.getLoginFromType()!=LoginFromType.SHOPEE){
            return "redirect:changeGoodsCate.htm?goodsId="+goodsId;
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

        item.getItem().setTitle(ZHConverter.convert(item.getItem().getTitle(), ZHConverter.TRADITIONAL));
        item.getItem().setSellPoint(null);
        item.getItem().setCid(cid);
        if (item.getItem().getItemImgs().size()==6) {
            item.getItem().setItemImgs(item.getItem().getItemImgs().subList(0,5));
        }
        ShopeeShowDataVO allData=new ShopeeShowDataVO();
        allData.setItems(item);
        allData.setJdUserId(shopeeId);
        allData.setDeliveyList(shopeeService.shopLogistics(shopeeId));
        allData.setProps(shopeePropsService.selProps(goodsId,cid));
//        allData.setStoreCats(jdUpItemService.selShopCats(jdUserId));
        allData.setGoodsCat(shopeePropsService.selCatPath(cid));
        model.addAttribute("allData",allData);
        return "shopee/sp";
    }

    @RequestMapping("sp/getCateDatas")
    @ResponseBody
    public JSONObject getCateDatas(Long cid){
        return JsonResponseUtil.success().element("datas",shopeePropsService.selCate(cid));
    }

    @RequestMapping({"sp/getSpGoodsInfo","jd/getJdGoodsInfo"})
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

    @RequestMapping("sp/index")
    public String submit(UptoTbShopee bo,
                         @RequestParam(value = "picUrl[]",required = false)String[] picUrl,
                         @RequestParam(value = "sku_props[]",required = false)String[] skuProps,
                         @RequestParam(value = "deliver[]",required = false)String[] deliver,
                         String skus,
                         HttpSession httpsession,
                         HttpServletRequest request, HttpServletResponse httpServletResponse, Model model) throws IOException {
        List<JdUploadSkuBO> sku = (List<JdUploadSkuBO>) JSONArray.toList(JSONArray.fromObject(skus), JdUploadSkuBO.class, new HashMap<String, Class>() {{
            put("sizes", JdUploadSkuBO.class);
        }});
        Long shopeeId=0L;
        shopeePropsService.itemAdd(bo,sku,picUrl,skuProps,deliver,shopeeId);

        return  "";
    }
}
