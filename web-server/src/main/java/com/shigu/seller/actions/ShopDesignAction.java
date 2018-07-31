package com.shigu.seller.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.FitmentModule;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.fitment.*;
import com.shigu.seller.bo.*;
import com.shigu.seller.services.ShopDesignService;
import com.shigu.seller.vo.ContainerVO;
import com.shigu.seller.vo.DesignJsonVO;
import com.shigu.seller.vo.ModuleVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.ShopSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 店铺装修
 * Created by zhaohongbo on 17/4/13.
 */
@RequestMapping("seller")
@Controller
public class ShopDesignAction {

    private static final Logger logger = LoggerFactory.getLogger(ShopDesignAction.class);
    @Autowired
    ShopDesignService shopDesignService;

    @Autowired
    ShopBaseService shopBaseService;

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    CdnService cdnService;

    @Autowired
    ShopFitmentService shopFitmentService;

    /**
     * 店铺装修
     * @return
     */
    @RequestMapping("design")
    public String design(Long pageId, HttpSession session, Model model) throws ShopFitmentException, IOException {
        ShopSession shopSession=getShopSession(session);
        if(pageId==null){
            pageId=shopDesignService.selPageIdByShopId(shopSession.getShopId());
        }
        ContainerVO containerVO=shopDesignService.selPageById(pageId,shopDesignService.selShopForModule(shopSession.getShopId(),
                shopSession.getWebSite()),true);
        model.addAttribute("page_id",pageId);
        model.addAttribute("container",containerVO);
        model.addAttribute("pages",shopDesignService.selAllPage(shopSession.getShopId()));
        model.addAttribute("isEditer",true);
        //如果有搜索模块
        if(containerVO.getSearchModule()!=null){
            containerVO.getSearchModule().getData().put("catPolymerizations",shopForCdnService.selCatRolymerizations(shopSession.getShopId()));//类目聚合
            containerVO.getSearchModule().getData().put("goodsList",shopForCdnService.searchItemOnsale(null,shopSession.getShopId(),shopSession.getWebSite(),"time_down",1,20));
        }
        return "/shop_design/design";
    }

    /**
     * 店铺预显
     * @return
     */
    @RequestMapping("design/preview")
    public String designPreview(Long pageId,HttpSession session,Model model) throws ShopFitmentException, IOException {
        ShopSession shopSession=getShopSession(session);
        if(pageId==null){
            pageId=shopDesignService.selPageIdByShopId(shopSession.getShopId());
        }
        ContainerVO containerVO=shopDesignService.selPageById(pageId,shopDesignService.selShopForModule(shopSession.getShopId(),
                shopSession.getWebSite()),false);
        model.addAttribute("container",containerVO);
        model.addAttribute("pages",shopDesignService.selAllPage(shopSession.getShopId()));
        model.addAttribute("isEditer",false);
        //如果有搜索模块
        if(containerVO.getSearchModule()!=null){
            containerVO.getSearchModule().getData().put("catPolymerizations",shopForCdnService.selCatRolymerizations(shopSession.getShopId()));//类目聚合
            containerVO.getSearchModule().getData().put("goodsList",shopForCdnService.searchItemOnsale(null,shopSession.getShopId(),shopSession.getWebSite(),"time_down",1,20));
        }
        model.addAttribute("vo",cdnService.shopSimpleVo(shopSession.getShopId()));
        return "/cdn/shop";
    }

    @RequestMapping("design/publish")
    @ResponseBody
    public DesignJsonVO publish(HttpSession session) {
        ShopSession shopSession = getShopSession(session);
        Long shopId = shopSession.getShopId();
        return shopDesignService.publishOneShop(shopId);
    }

    /**
     * 增加一个模块
     * @return
     */
    @RequestMapping("design/addModule")
    public String addModule(AddModuleBO bo,HttpSession session,Model model) throws ShopFitmentException, IOException {
        ShopSession shopSession=getShopSession(session);
        Long sideId=null;
        if(bo.getSide()!=null&&!"none".equals(bo.getSide())){
            sideId=Long.valueOf(bo.getSide());
        }
        ModuleVO mv=shopDesignService.addModule(bo.getId(),bo.getArea(),bo.getType(),sideId,bo.getAfter(),shopDesignService.selShopForModule(shopSession.getShopId(),
                shopSession.getWebSite()));
        model.addAllAttributes(mv.getData());
        return "/shop_design/"+bo.getId();
    }

    /**
     * 添加一个区域
     * @return
     */
    @RequestMapping("design/addArea")
    @ResponseBody
    public JSONObject addArea(AddAreaBO bo){
        DesignJsonVO designJsonVO=new DesignJsonVO();
        try {
            Long areaId=shopDesignService.addArea(bo.getSide(),bo.getType(),bo.getAfter());
            designJsonVO.setStatus(0);
            designJsonVO.setData(areaId.toString());
        } catch (ShopFitmentException e) {
            e.printStackTrace();
            designJsonVO.setStatus(1);
            designJsonVO.setMessage(e.getMessage());
        }
        return JSONObject.fromObject(designJsonVO);
    }
    /**
     * 移除模块
     * @return
     */
    @RequestMapping("design/remModule")
    @ResponseBody
    public String remModule(RemModuleBO bo){
        shopDesignService.rmModule(bo.getId(),bo.getArea());
        return "ok";
    }

    /**
     * 移除区域
     * @param id
     * @return
     */
    @RequestMapping("design/remArea")
    @ResponseBody
    public String remArea(Long id){
        shopDesignService.rmArea(id);
        return "ok";
    }

    /**
     * 取得模块选项
     * @param bo
     * @return
     */
    @RequestMapping("design/getModuleOption")
    public String getModuleOption(ModuleOptionBO bo,Model model){
        //查出module的类型
        ModuleVO module=shopDesignService.selModuleByModuleId(bo.getId());
        model.addAttribute("moduleSet",module.getModuleSet());
        return module.getTemplate().getSourceName().replace(".ftl","-option");
    }

    /**
     * 手动添加商品
     * @return
     */
    @RequestMapping("design/goods-tui-get-goods-list")
    public String goodsTuiGetGoodsList(PromotePagerBo bo, HttpSession session, Model model){
        ShopSession shopSession = getShopSession(session);
        Long shopId = shopSession.getShopId();
        List<Long> goodsIds = shopDesignService.selPromoteItemIds(bo);
        List<Long> onsaleGoodsIds = shopForCdnService.searchItemOnsale(goodsIds, shopSession.getWebSite(), 1, 20).getContent().stream().map(ItemShowBlock::getItemId).collect(Collectors.toList());
        if (goodsIds.size()>onsaleGoodsIds.size()) {
            //有已下架的商品
            try {
                shopFitmentService.revalueModuleOption(bo.getMid(), JSON.toJSONString(onsaleGoodsIds));
            } catch (ShopFitmentException ignore) {
            }
        }
        bo.setIds(goodsIds);
        ShiguPager<ItemShowBlock> itemShowBlockShiguPager = shopDesignService.selPromoteItems(bo, shopId, shopSession.getWebSite());
        //极限词过滤
        itemShowBlockShiguPager.getContent().forEach(itemShowBlock -> itemShowBlock.setTitle(KeyWordsUtil.duleKeyWords(itemShowBlock.getTitle())));

        model.addAttribute("bo", bo);
        model.addAttribute("pager", itemShowBlockShiguPager);
        model.addAttribute("totalOnsale", shopForCdnService.selItemNumberById(shopId, shopSession.getWebSite()));
        return "/shop_design/goods-tui-get-goods-list";
    }

    /**
     * 编辑顶部
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("design/page-get-head")
    public String pageGetHead(HttpSession session,Model model){
        ShopSession shopSession=getShopSession(session);
        ModuleVO module=shopDesignService.selHeadModule(shopSession.getShopId());
        ShopBanner banner= (ShopBanner) module.getModuleSet();
        model.addAttribute("allpages",shopDesignService.selPageNav(shopSession.getShopId(),
                banner.getStoreNav().getPages()));
        model.addAttribute("moduleSet",module.getModuleSet());
        return "/shop_design/banner-option";
    }

    /**
     * 手动推荐设置商品
     * @param bo 商品信息
     * @return json
     */
    @RequestMapping("design/design-option/goods-tui-set-goods")
    @ResponseBody
    public DesignJsonVO promoteItemsSet(PromoteItemBo bo) {
        return shopDesignService.updateItemsPromote(bo, true);
    }

    /**
     * 手动推荐删除商品
     * @param bo 商品信息
     * @return JSON
     */
    @RequestMapping("design/design-option/goods-tui-del-goods")
    @ResponseBody
    public DesignJsonVO promoteItemsDel(PromoteItemBo bo) {
        return shopDesignService.updateItemsPromote(bo, false);
    }

    /**
     * 店铺更新店铺招牌
     * @param bo 招牌信息
     * @param session 用户信息
     * @return JSON
     */
    @RequestMapping("design/page-update-head-option")
    @ResponseBody
    public DesignJsonVO pageHeadOption(PageHeadOptionBo bo, HttpSession session) {
        return shopDesignService.updatePageHeadOption(bo, getShopSession(session).getShopId());
    }

    /**
     * 更新设置页面背景图信息
     * @param bo 背景图
     * @param session 用户session
     * @return json
     */
    @RequestMapping("design/page-update-background")
    @ResponseBody
    public DesignJsonVO pageBackgroundOption(PageBackBo bo, HttpSession session) {
        return shopDesignService.pageBackOptionUpdate(bo, getShopSession(session).getShopId());
    }

    /**
     * 设置页banner
     * @param bo 店招信息
     * @param session 用户session
     * @return json
     */
    @RequestMapping("design/pageUpdateHead")
    @ResponseBody
    public JSONObject pageUpdateHead(ShopBanner bo,HttpSession session){
        ShopSession shopSession=getShopSession(session);
        DesignJsonVO design=new DesignJsonVO();
        try {
            shopDesignService.revalueShopHead(shopSession.getShopId(),bo);
            design.setStatus(0);
        } catch (ShopFitmentException e) {
            logger.error("set banner error!!",e);
            design.setStatus(1);
        }
        return JSONObject.fromObject(design);
    }

    /**
     * 保存搜索块设置
     * @param bo
     * @return
     */
    @RequestMapping("design/saveGoodsSearchOption")
    public String saveGoodsSearchOption(ItemSearchModule bo,HttpSession session,Model model) throws ShopFitmentException, IOException {
        return saveModuleOption(bo,session,model);
    }

    /**
     * 保存自定义
     * @param bo
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("design/saveCustomOption")
    public String saveCustomOption(CustomModule bo,HttpSession session,Model model) throws ShopFitmentException, IOException {
        if (bo.getContent() != null) {
            bo.setContent(bo.getContent().replaceAll("网商园","").replaceAll("(?i)wsy.com","").replaceAll("(?i)wsy",""));
        }
        return saveModuleOption(bo,session,model);
    }

    /**
     * 保存大图轮播
     * @return
     */
    @RequestMapping("design/saveBigcarouselOption")
    public String saveBigcarouselOption(SlideshowModule bo, HttpSession session, Model model) throws ShopFitmentException, IOException {
        return saveModuleOption(bo,session,model);
    }

    /**
     * 保存宽屏图片
     * @param bo
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("design/saveBigpicOption")
    public String saveBigpicOption(WideImageModule bo, HttpSession session, Model model) throws ShopFitmentException, IOException {
        return saveModuleOption(bo,session,model);
    }

    /**
     * 推荐模块保存
     * @param bo
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("design/savePromoteOption")
    public String savePromoteOption(ItemPromoteModule bo, HttpSession session, Model model) throws ShopFitmentException, IOException {
        return saveModuleOption(bo,session,model);
    }
    /**
     * 保存图片轮播
     * @param bo
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("design/savePiccarouselOption")
    public String savePiccarouselOption(ViwepagerModule bo, HttpSession session, Model model) throws ShopFitmentException, IOException {
        return saveModuleOption(bo,session,model);
    }

    private String saveModuleOption(FitmentModule module,HttpSession session,Model model) throws ShopFitmentException, IOException {
        ShopSession shopSession=getShopSession(session);
        shopDesignService.revalueModule(module.getModuleId(),module);
        ModuleVO mv=shopDesignService.selModuleByModuleIdWithData(module.getModuleId(),shopDesignService.selShopForModule(shopSession.getShopId(),
                shopSession.getWebSite()),true);
        model.addAllAttributes(mv.getData());
        return "/"+mv.getTemplate().getSourceName().replace(".ftl","");
    }

    @RequestMapping("design/move-module")
    @ResponseBody
    public JSONObject moveModule(MoveModuleBO bo){
        shopDesignService.moveModule(bo.getModuleId(),bo.getAfter());
        DesignJsonVO design=new DesignJsonVO();
        design.setStatus(0);
        design.setMessage("更新成功");
        return JSONObject.fromObject(design);
    }

    /**
     * 页面管理
     * @return
     */
    @RequestMapping("designManage")
    public String designManage(HttpSession session, Model model){
        ShopSession shopSession=getShopSession(session);
        model.addAttribute("pages", shopDesignService.selAllPage(shopSession.getShopId()));
        return "/shop_design/designManage";
    }

    /**
     * 页面添加
     * @return
     */
    @RequestMapping("designManage/page-add")
    public String pageAdd(AddPageBo bo, HttpSession session, Model model) {
        ShopSession shopSession=getShopSession(session);
        if ("submit".equals(bo.getMethod())){
            try {
                bo.setTitle(new String(bo.getTitle().getBytes("iso-8859-1"), "UTF-8"));
            } catch (UnsupportedEncodingException ignored) {
            }
            shopDesignService.addCustomPage(bo, shopSession.getShopId());
            return "redirect:/seller/designManage.htm";
        }
        model.addAttribute("code", shopDesignService.randomPageCode(shopSession.getShopId()));
        model.addAttribute("shop", shopSession.getShopId());
        return "/shop_design/page-add";
    }

    @RequestMapping("designManage/page-remove")
    @ResponseBody
    public DesignJsonVO pageRemove(Long id) {
        return shopDesignService.removeCustomPage(id);
    }


    /**
     * 当前登陆的session
     *
     * @param session
     * @return
     */
    private ShopSession getShopSession(HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        return ps.getLogshop();
    }
}
