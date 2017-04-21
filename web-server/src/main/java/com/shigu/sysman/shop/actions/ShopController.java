package com.shigu.sysman.shop.actions;


import com.alibaba.fastjson.JSON;
import com.openJar.exceptions.sgpay.ApiException;
import com.opentae.data.mall.beans.ShiguMarket;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.ShiguShopApply;
import com.shigu.component.common.globality.constant.SystemConStant;
import com.shigu.component.common.globality.controller.BackBaseController;
import com.shigu.component.common.globality.response.ResponseBase;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.exceptions.ShopExamineException;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopRegistService;
import com.shigu.main4.storeservices.impl.ShopServiceImpl;
import com.shigu.main4.vo.DmlReason;
import com.shigu.main4.vo.RefuseOpenReason;
import com.shigu.sysman.shop.bo.ShopApplyBo;
import com.shigu.sysman.shop.bo.ShopBo;
import com.shigu.sysman.shop.service.ShiguMarketService;
import com.shigu.sysman.shop.service.ShopService;
import com.shigu.sysman.shop.vo.ShiguShopVo;
import com.shigu.sysman.system.actions.SystemIndexController;
import com.shigu.tb.finder.services.TaobaoSynService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 店铺控制器
 *
 * @author shigu_zjb
 * @date 2017/03/09 15:50
 *
 *
 */
@Controller
public class ShopController extends BackBaseController{

    private static final Logger logger = Logger.getLogger(SystemIndexController.class);

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShiguMarketService shiguMarketService;

    @Autowired
    private ShopBaseService shopBaseService;

    @Autowired
    private ShopRegistService shopRegistService;

    /**
     * 店铺列表
     * @param
     * @return
     */
    @RequestMapping(value = "/sysman/shop/list")
    public String shopList(ShopBo shopBo, HttpServletRequest request){
        if(shopBo == null){
            shopBo = new ShopBo();
        }
        ShiguPager<ShiguShopVo> shiguPager = shopService.findShiguShopPageByBo(shopBo);
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setParentMarketId(0L);
        shiguMarket.setWebSite(shopBo.getWebsite());
        List<ShiguMarket> shiguMarketList = shiguMarketService.findShiguMarketListo(shiguMarket);
        request.setAttribute("shiguMarketList" ,shiguMarketList);
        request.setAttribute("pager", shiguPager);
        request.setAttribute("bo", shopBo);
        return "sysman/shop/shoplist";
    }

    /**
     * 店铺选择列表
     * @param
     * @return
     */
    @RequestMapping(value = "/sysman/shop/selectList")
    public String shopSelectList(ShopBo shopBo, HttpServletRequest request){
        if(shopBo == null){
            shopBo = new ShopBo();
        }
        ShiguPager<ShiguShopVo> shiguPager = shopService.findShiguShopPageByBo(shopBo);
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setParentMarketId(0L);
        shiguMarket.setWebSite(shopBo.getWebsite());
        List<ShiguMarket> shiguMarketList = shiguMarketService.findShiguMarketListo(shiguMarket);
        request.setAttribute("shiguMarketList" ,shiguMarketList);
        request.setAttribute("pager", shiguPager);
        request.setAttribute("bo", shopBo);
        return "sysman/shop/select_shop_list";
    }


    /**
     * 关店页面
     * @return
     */
    @RequestMapping(value = "/sysman/shop/closeView" , method = RequestMethod.GET)
    public String closeView(Long shopId, HttpServletRequest request){
        request.setAttribute("shopId" ,shopId);
        return "sysman/shop/shop_close_view";
    }

    /**
     * 关店
     * @param shopId
     * @return
     */
    @RequestMapping(value = "/sysman/shop/closeShop" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject closeShop(Long shopId, String reason){
        ResponseBase base = new ResponseBase();
        if(shopId == null){
            base.setMsg("店铺ID不能为空");
            return JSONObject.fromObject(base);
        }
        DmlReason dmlReason = new DmlReason();
        dmlReason.setWho(getUserName());
        dmlReason.setDoWhat("关店");
        dmlReason.setReason(reason);
        try{
            shopService.closeShop(shopId ,dmlReason);
            base.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (Main4Exception e){
            e.getMessage();
            logger.error("关店 发生错误>>error:" + e.toString());
            base.setMsg(e.getMessage());
        }
        return JSONObject.fromObject(base);
    }

    /**
     * 开店页面
     * @return
     */
    @RequestMapping(value = "/sysman/shop/openView" , method = RequestMethod.GET)
    public String openView(Long shopId, HttpServletRequest request){
        request.setAttribute("shopId" ,shopId);
        return "sysman/shop/shop_open_view";
    }

    /**
     * 开店
     * @return
     */
    @RequestMapping(value = "/sysman/shop/openShop" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject openShop(Long shopId, String reason) throws Exception {
        ResponseBase base = new ResponseBase();
        if(shopId == null){
            base.setMsg("店铺ID不能为空");
            return JSONObject.fromObject(base);
        }
        DmlReason dmlReason = new DmlReason();
        dmlReason.setWho(getUserName());
        dmlReason.setDoWhat("开店");
        dmlReason.setReason(reason);

//        try{
            shopService.openShop(shopId ,dmlReason);
//        }catch (Main4Exception e){
//            e.printStackTrace();
//            base.setMsg(e.getMessage());
//            logger.error("开店>>error:" + e.toString());
//        }catch (ApiException e) {
//            base.setMsg(e.getMsg());
//            logger.error("开店>>apiError:" + e.toString());
//        }catch (Exception e){
//            base.setMsg("系统错误");
//            return JSONObject.fromObject(base);
//        }

        String domain = shopBaseService.selDomain(shopId);
        if(StringUtils.isEmpty(domain)){
            base.setMsg("开店成功，店铺未设置二级域名或与其他店铺二级域名重复，请及时修改");
        }
        base.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(base);
    }


    /**
     * 审核店铺列表
     * @return
     */
    @RequestMapping(value = "/sysman/shop/examineShopList" , method = RequestMethod.GET)
    public String examineShopList(ShopApplyBo applyBo , HttpServletRequest request){
        if(applyBo == null){
            applyBo = new ShopApplyBo();
        }
        //applyBo.setApplyStatus(0);
        //applyBo.setCanExamine(1);
        ShiguPager<ShiguShopApply> shopApplyShiguPager = shopService.findShopApplyPagerByBo(applyBo);
        request.setAttribute("pager", shopApplyShiguPager);
        request.setAttribute("bo", applyBo);
        return "sysman/shop/shop_examine_list";
    }

    /**
     * 审核通过
     * @return
     */
    @RequestMapping(value = "/sysman/shop/examinePanss" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject examinePanss(Long applyId){
        ResponseBase base = new ResponseBase();

        if(applyId == null){
            base.setMsg("入驻不能为空");
            return JSONObject.fromObject(base);
        }

        try{
            shopService.examineShopPanss(applyId);
        }catch(ShopExamineException e){
            e.printStackTrace();
            base.setMsg(e.getMessage());
            return JSONObject.fromObject(base);
        }catch(Exception e){
            e.printStackTrace();
            base.setMsg("审核失败>error:" + e.getMessage());
            return JSONObject.fromObject(base);
        }

        base.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        return JSONObject.fromObject(base);
    }


    /**
     * 审核拒绝页面
     * @return
     */
    @RequestMapping(value = "/sysman/shop/examineRefuseView" , method = RequestMethod.GET)
    public String examineRefuseView(Long applyId, HttpServletRequest request){
        request.setAttribute("applyId" ,applyId);
        return "sysman/shop/shop_examine_refuse_view";
    }

    /**
     * 审核拒绝
     * @return
     */
    @RequestMapping(value = "/sysman/shop/examineRefuse" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject examineRefuse(Long applyId, String reason) throws ShopExamineException {
        ResponseBase base = new ResponseBase();

        if(applyId == null){
            base.setMsg("入驻ID不能为空");
            return JSONObject.fromObject(base);
        }

        RefuseOpenReason refuseOpenReason = new RefuseOpenReason();
        refuseOpenReason.setReason(reason);
        refuseOpenReason.setWho(getUserName());
        try{
            shopRegistService.toRefuse(applyId,refuseOpenReason);
        }catch(Exception e){
            e.printStackTrace();
            base.setMsg(e.getMessage());
            return JSONObject.fromObject(base);
        }

        base.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);

        return JSONObject.fromObject(base);
    }

    /**
     * 店铺审核修改
     * @return
     */
    @RequestMapping(value = "/sysman/shop/changeShopExamineView" , method = RequestMethod.GET)
    public String changeShopExamineView(Long applyId, String webSite,HttpServletRequest request){
        ShiguShopApply shiguShopApply = shopService.findShopApplyById(applyId);
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setParentMarketId(0L);
        shiguMarket.setWebSite(webSite);
        List<ShiguMarket> shiguMarketList = shiguMarketService.findShiguMarketListo(shiguMarket);
        request.setAttribute("shiguMarketList" ,shiguMarketList);
        request.setAttribute("apply",shiguShopApply);
        return "sysman/shop/change_shop_examine";
    }

    /**
     * 店铺审核
     * @param shiguShopApply
     * @return
     */
    @RequestMapping(value = "sysman/shop/changeShopExamine" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeShopExamine(ShiguShopApply shiguShopApply){
        ResponseBase rsp = new ResponseBase();

        if(shiguShopApply == null || shiguShopApply.getRuzhuId() == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }
        try{
            shopService.updateShopApply(shiguShopApply);
            rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (Main4Exception e){
            rsp.setMsg(e.getMessage());
        }

        return JSONObject.fromObject(rsp);
    }

    /**
     * 全店抓取
     *
     */
    @RequestMapping(value = "/sysman/shop/shopGrab" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject shopGrab(Long shopId){
        ResponseBase base = new ResponseBase();

        try{
            shopService.synShop(shopId);
            base.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (Main4Exception e){
            e.printStackTrace();
            logger.error("全店抓取 MAIN4发生错误>>" + e.toString());
            base.setMsg(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            logger.error("全店抓取 系统发生错误>>" + e.toString());
            base.setMsg(e.toString());
        }

        return JSONObject.fromObject(base);
    }

    /**
     * 店铺修改页面
     * @return
     */
    @RequestMapping(value = "/sysman/shop/changeShopView", method = RequestMethod.GET)
    public String changeShopView(Long shopId,String webSite ,HttpServletRequest request){
        ShiguShop shiguShop = shopService.findShopByShopId(shopId);
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setParentMarketId(0L);
        shiguMarket.setWebSite(webSite);
        List<ShiguMarket> shiguMarketList = shiguMarketService.findShiguMarketListo(shiguMarket);
        request.setAttribute("shiguMarketList" ,shiguMarketList);
        request.setAttribute("shop" ,shiguShop);
        return "sysman/shop/change_shop";
    }

    /**
     * 修改店铺
     * @param shiguShop
     * @return
     */
    @RequestMapping(value = "/sysman/shop/changeShop" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject changeShop(ShiguShop shiguShop, String createDateStr){
        ResponseBase rsp = new ResponseBase();

        if(shiguShop.getShopId() == null){
            rsp.setMsg("店铺ID不能为空");
            return JSONObject.fromObject(rsp);
        }

        try{
            if(!StringUtils.isEmpty(createDateStr)){
                shiguShop.setCreateDate(DateUtil.stringToDate(createDateStr, DateUtil.patternD));
            }
            shopService.updateShop(shiguShop);
            rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (Main4Exception e){
            e.printStackTrace();
            rsp.setMsg(e.getMessage());
        }

        return JSONObject.fromObject(rsp);
    }


    /**
     * 店铺迁移页面
     * @param shopId
     * @return
     */
    @RequestMapping(value = "/sysman/shop/qyShopView" , method = RequestMethod.GET)
    public String qyShopView(Long shopId, String webSite,HttpServletRequest request){
        ShiguShop shiguShop = shopService.findShopByShopId(shopId);
        ShiguMarket shiguMarket = new ShiguMarket();
        shiguMarket.setParentMarketId(0L);
        shiguMarket.setWebSite(webSite);
        List<ShiguMarket> shiguMarketList = shiguMarketService.findShiguMarketListo(shiguMarket);
        request.setAttribute("shiguMarketList" ,shiguMarketList);
        request.setAttribute("shop", shiguShop);
        request.setAttribute("webSite", webSite);
        return "sysman/shop/qy_shop";
    }

    /**
     * 档口迁移
     * @param marketId
     * @param floorId
     * @param shopNum
     * @param shopId
     * @return
     */
    @RequestMapping(value = "/sysman/shop/qyShop" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject qyShop(Long marketId, Long  floorId, String shopNum, Long shopId) {
        ResponseBase rsp = new ResponseBase();

        if(marketId == null || floorId == null || StringUtils.isEmpty(shopNum) || shopId == null){
            rsp.setMsg("请求数据有误");
            return JSONObject.fromObject(rsp);
        }

        try {
            shopService.qyshop(shopId, marketId, floorId, shopNum);
            rsp.setStatus(SystemConStant.RESPONSE_STATUS_SUCCESS);
        }catch (Main4Exception e) {
            e.printStackTrace();
            rsp.setMsg(e.getMessage());
        }

        return JSONObject.fromObject(rsp);
    }
}
