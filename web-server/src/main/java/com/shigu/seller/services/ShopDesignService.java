package com.shigu.seller.services;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShopFitmentArea;
import com.opentae.data.mall.beans.ShopFitmentModule;
import com.opentae.data.mall.beans.ShopFitmentPage;
import com.opentae.data.mall.examples.ShopFitmentAreaExample;
import com.opentae.data.mall.examples.ShopFitmentPageExample;
import com.opentae.data.mall.interfaces.ShopFitmentAreaMapper;
import com.opentae.data.mall.interfaces.ShopFitmentModuleMapper;
import com.opentae.data.mall.interfaces.ShopFitmentPageMapper;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.enums.FitmentPageType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.FitmentArea;
import com.shigu.main4.vo.FitmentModule;
import com.shigu.main4.vo.FitmentPage;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.fitment.CategoryModule;
import com.shigu.main4.vo.fitment.ItemPromoteModule;
import com.shigu.main4.vo.fitment.SearchItemsModule;
import com.shigu.main4.vo.fitment.ShopBanner;
import com.shigu.seller.bo.*;
import com.shigu.seller.vo.*;
import com.shigu.tools.XzSdkClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.*;

/**
 * 店铺装修服务
 * Created by zhaohongbo on 17/4/17.
 */
@Service
public class ShopDesignService {
    private static final Logger logger = LoggerFactory.getLogger(ShopDesignService.class);
    @Autowired
    ShopFitmentService shopFitmentService;

    @Autowired
    FreeMarkerConfigurer cfg;      //模版配置对象

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    ShopFitmentPageMapper shopFitmentPageMapper;

    @Autowired
    XzSdkClient xzSdkClient;

    @Autowired
    ShopFitmentAreaMapper shopFitmentAreaMapper;

    @Autowired
    ShopFitmentModuleMapper shopFitmentModuleMapper;

    @Autowired
    ShopBaseService shopBaseService;

    /**
     * 得到模块
     * @param moduleId
     * @return
     */
    public ModuleVO selModuleByModuleId(Long moduleId){
        return new ModuleVO(shopFitmentService.selModuleByModuleId(moduleId),cfg);
    }

    /**
     * 得到模块
     * 带上数据
     * @param moduleId
     * @return
     */
    public ModuleVO selModuleByModuleIdWithData(Long moduleId,ShopForModuleVO shop,Boolean isEditer) throws IOException {
        return parseModule(shopFitmentService.selModuleByModuleId(moduleId),shop,isEditer);
    }

    /**
     * 得到顶部模块
     * @param shopId
     * @return
     */
    public ModuleVO selHeadModule(Long shopId){
        return new ModuleVO(shopFitmentService.selShopHead(shopId).getAllarea().get(0),cfg);
    }

    /**
     * 带数据的head
     * @param shopId
     * @return
     * @throws IOException
     */
    public ModuleVO selHeadModuleWithData(Long shopId,String webSite,Boolean isEditer) throws IOException {
        List<FitmentModule> allarea = shopFitmentService.selShopHead(shopId).getAllarea();
        if (allarea.isEmpty()) {
            return null;
        }
        return parseModule(allarea.get(0),selShopForModule(shopId,webSite)
                ,isEditer);
    }

    /**
     * 查页面ID
     * @param shopId
     * @return
     */
    public Long selPageIdByShopId(Long shopId) throws ShopFitmentException {
        return shopFitmentService.selIndexPageIdByShopId(shopId);
    }

    /**
     * 查搜索页的pageID
     * @param shopId
     * @return
     * @throws ShopFitmentException
     */
    public Long selSearchIdByShopId(Long shopId) throws ShopFitmentException {
        return shopFitmentService.selSearchPageIdByShopId(shopId);
    }

    /**
     * 查普通页面的页面ID
     * @param shopId
     * @param key
     * @return
     */
    public Long selNormalIdByKey(Long shopId,Long key){
        ShopFitmentPageExample example=new ShopFitmentPageExample();
        example.createCriteria().andShopIdEqualTo(shopId).andCodeEqualTo(key);
        List<ShopFitmentPage> pages=shopFitmentPageMapper.selectByExample(example);
        if(pages.size()>0){
            return pages.get(0).getPageId();
        }
        return null;
    }

    /**
     * 给模块用的店铺基本信息
     * @return
     */
    public ShopForModuleVO selShopForModule(Long shopId,String webSite){
        ShopForModuleVO shop=new ShopForModuleVO();
        shop.setShopId(shopId);
        shop.setWebSite(webSite);
        shop.setDomain(shopBaseService.selDomain(shopId));
        return shop;
    }
    /**
     * 查页面模块
     * @return
     */
    public ContainerVO selPageById(Long pageId,ShopForModuleVO shop,Boolean isEditer) throws ShopFitmentException, IOException {
        return parseToContainer(shopFitmentService.selPage(pageId),shop,isEditer);
    }

    /**
     * 已发布的页面模块
     * @param pageId
     * @param shop
     * @return
     * @throws IOException
     */
    public ContainerVO selPagePublishedById(Long pageId,ShopForModuleVO shop) throws IOException, ShopFitmentException {
        return parseToContainer(shopFitmentService.selPageOnpub(pageId),shop,false);
    }

    /**
     * 包装成内容对象
     * @param page
     * @param shop
     * @param isEditer
     * @return
     * @throws IOException
     */
    public ContainerVO parseToContainer(FitmentPage page,ShopForModuleVO shop,Boolean isEditer) throws IOException {
        ContainerVO containerVO=new ContainerVO(cfg);
        containerVO.setPageName(page.getPageName());
        AreaVO bannerArea=new AreaVO(page.getHeadArea());
        ShopBanner banner= (ShopBanner) bannerArea.getAllarea().get(0);
        //处理头部
        bannerArea.addAllModule(parseModule(banner,shop,isEditer));
        containerVO.setBanner(bannerArea);
        containerVO.getData().put("isEditer",isEditer);
        if(StringUtils.isNotEmpty(page.getBackgroundPic()))
        containerVO.getData().put("backgroundPic",page.getBackgroundPic());
        containerVO.getData().put("backgroundType",page.getBackgroundType());
        containerVO.setFitmentAreas(new ArrayList<AreaVO>());
        for(FitmentArea fa:page.getUserDefineAreas()){
            AreaVO areaVO=new AreaVO(fa);
            containerVO.getFitmentAreas().add(areaVO);
            if(areaVO.getAllarea() != null)
                for(FitmentModule fm:areaVO.getAllarea()){
                    areaVO.addAllModule(parseModule(fm,shop,isEditer));
                }
            if(areaVO.getLeftarea() != null)
                for(FitmentModule fm:areaVO.getLeftarea()){
                    areaVO.addLeftModule(parseModule(fm,shop,isEditer));
                }
            if(areaVO.getRightarea() != null)
                for(FitmentModule fm:areaVO.getRightarea()){
                    ModuleVO mv=parseModule(fm,shop,isEditer);
                    if(mv instanceof SearchModuleVO){
                        containerVO.setSearchModule((SearchModuleVO) mv);
                        containerVO.getData().put("searchModule",mv);
                    }
                    areaVO.addRightModule(mv);
                }
        }
        //把搜索里面变成不可编辑
        if(isEditer&&containerVO.getSearchModule()!=null){
            //如果是搜索的,以下为必有
            containerVO.getFitmentAreas().get(0).getLeftModules().get(0).getData().put("noedit",true);
        }
        return containerVO;
    }

    /**
     * 转化成有数据,有模板的模块
     * @param module
     * @return
     * @throws IOException
     */
    public ModuleVO parseModule(FitmentModule module,ShopForModuleVO shop,Boolean isEditer) throws IOException {
        ModuleVO mv= new ModuleVO(module,cfg);
        mv.getData().put("shop",shop);
        mv.getData().put("isEditer",isEditer);
        if(module instanceof CategoryModule){//如果是店内分类模块
            mv.getData().put("shopcats",shopForCdnService.selShopCatsById(shop.getShopId()));
        }else if(module instanceof ItemPromoteModule){//推荐需要查数据
            ShiguPager<ItemShowBlock> promotePage=shopFitmentService.selItemByPromote(shop.getShopId(),shop.getWebSite(),(ItemPromoteModule) module);
            mv.getData().put("promotes",promotePage);
        }else if(module instanceof SearchItemsModule){//搜索
            //栏目,+搜索条件
            mv=new SearchModuleVO(module,cfg);
            mv.getData().put("shop",shop);
        }else if(module instanceof ShopBanner){
            mv.getData().put("checkedNavs",selCheckedPageNav(shop.getShopId(),((ShopBanner) module).getStoreNav().getPages()));
            mv.getData().put("shopcats",shopForCdnService.selShopCatsById(shop.getShopId()));
        }
        return mv;
    }

    public List<Long> selPromoteItemIds(PromotePagerBo bo) {
        ItemPromoteModule promoteModule = shopFitmentService.selModuleByModuleId(bo.getMid());
        if (promoteModule != null) {
            return promoteModule.getPromoteItems();
        }
        return Collections.emptyList();
    }

    public ShiguPager<ItemShowBlock> selPromoteItems(PromotePagerBo bo, Long shopId,String webSite) {
        if (bo.getType() == 2) {
            return shopForCdnService.searchItemOnsale(bo.getIds(),webSite, bo.getPage(), bo.getSize());
        }
        return shopForCdnService.searchItemOnsale(bo.getQ(), shopId,webSite, bo.getLowPrice(), bo.getHighPrice(), null,null,null, bo.getPage(), bo.getSize());
    }

    public List<PageManageVo> selAllPage(Long shopId) {
        List<PageManageVo> vos = new ArrayList<>();
        if (shopId != null) {
            ShopFitmentPageExample pagerExample = new ShopFitmentPageExample();
            pagerExample.createCriteria().andShopIdEqualTo(shopId);
            for (ShopFitmentPage page : shopFitmentPageMapper.selectByExample(pagerExample)) {
                PageManageVo vo = BeanMapper.map(page, PageManageVo.class);
                vos.add(vo);
                switch (FitmentPageType.typeOf(page.getType())) {
                    case INDEX:
                        vo.setHref(xzSdkClient.getMainHost() + shopId);
                        break;
                    case SEARCH:
                        vo.setHref(xzSdkClient.getMainHost() + "shop/search.htm?id=" + shopId);
                        break;
                    case CUSTOM:
                        vo.setHref(xzSdkClient.getMainHost() + "shop/" + shopId + "/" + page.getCode() + ".htm");
                        break;
                }
            }
        }
        return vos;
    }

    public Long randomPageCode(Long shopId) {
        ShopFitmentPageExample pageExample;
        Long code;
        do {
            Double random = Math.random() * 1000000000;
            code = random.longValue();
            pageExample = new ShopFitmentPageExample();
            pageExample.createCriteria().andShopIdEqualTo(shopId).andCodeEqualTo(code);
        } while (shopFitmentPageMapper.countByExample(pageExample) > 0);
        return code;
    }
    /**
     * 查页面导航
     * @param shopId 店铺ID
     * @param selected 已选中的
     * @return
     */
    public List<PageNavVO> selPageNav(Long shopId,List<Long> selected){
        List<PageManageVo> allpages=selAllPage(shopId);
        Map<Long,PageManageVo> pageMap=new HashMap<>();
        for(PageManageVo pmv:allpages){
            if(pmv.getType()!=3){
                continue;
            }
            pageMap.put(pmv.getPageId(),pmv);
        }
        List<PageNavVO> list=new ArrayList<>();
        for(Long l:selected){
            PageManageVo pmv=pageMap.get(l);
            if(pmv!=null)
            list.add(new PageNavVO(l,pmv.getName(),true,pmv.getHref()));
            pageMap.remove(l);
        }
        if(pageMap.size()>0){
            Iterator<Long> keys=pageMap.keySet().iterator();
            while(keys.hasNext()){
                Long key=keys.next();
                PageManageVo pmv=pageMap.get(key);
                list.add(new PageNavVO(key,pmv.getName(),false,pmv.getHref()));
            }
        }
        return list;
    }

    /**
     * 查页面已选导航
     * @param shopId 店铺ID
     * @param selected 已选中的
     * @return
     */
    public List<PageNavVO> selCheckedPageNav(Long shopId,List<Long> selected){
        List<PageNavVO> checkeds=new ArrayList<>();
        List<PageNavVO> vos=selPageNav(shopId,selected);
        for(PageNavVO v:vos){
            if(v.getChecked()){
                checkeds.add(v);
            }
        }
        return checkeds;
    }

    @Transactional(rollbackFor = Exception.class)
    public void addCustomPage(AddPageBo bo, Long shopId) {
        try {
            shopFitmentService.createPage(shopId, bo.getTitle(), bo.getAlias(), bo.getType());
        } catch (ShopFitmentException e) {
            logger.error("店铺[" + shopId + "] 添加页面失败！", e);
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public DesignJsonVO removeCustomPage(Long id) {
        DesignJsonVO vo = new DesignJsonVO();
        try {
            shopFitmentService.rmPage(id);
            vo.setStatus(0);
            vo.setMessage("删除成功");
        } catch (ShopFitmentException e) {
            logger.error("页面删除失败 id：" + id, e);
            vo.setMessage("页面删除失败");
            vo.setStatus(1);
        }
        return vo;
    }
    @Transactional(rollbackFor = Exception.class)
    public DesignJsonVO updatePageHeadOption(PageHeadOptionBo bo, Long shopId) {
        DesignJsonVO vo = new DesignJsonVO();
        vo.setStatus(0);
        vo.setMessage("更新成功");
        FitmentArea bannerArea = shopFitmentService.selShopHead(shopId);
        ShopBanner banner = (ShopBanner) bannerArea.getAllarea().get(0);
        try {
            shopFitmentService.revalueModuleOption(banner.getModuleId(), JSON.toJSONString(bo));
        } catch (ShopFitmentException e) {
            logger.error("banner 设置更新失败", e);
            vo.setStatus(1);
            vo.setMessage("banner 设置更新失败");
        }
        return vo;
    }
    @Transactional(rollbackFor = Exception.class)
    public DesignJsonVO updateItemsPromote(PromoteItemBo bo, boolean sd) {
        DesignJsonVO vo = new DesignJsonVO();
        vo.setStatus(0);
        vo.setMessage("success");
        try {
            ItemPromoteModule module = shopFitmentService.selModuleByModuleId(bo.getMid());
            Long id = bo.getId();
            if (module != null) {
                List<Long> ids = module.getPromoteItems();
                if (sd && ids.size() >= 16) {
                    vo.setStatus(1);
                    vo.setMessage("已达到最大推荐数量");
                    return vo;
                }
                if (sd ? !ids.contains(id) && ids.add(id) : ids.remove(id))
                    shopFitmentService.revalueModuleOption(bo.getMid(), JSON.toJSONString(ids));
            } else {
                vo.setStatus(1);
                vo.setMessage("模块不存在");
            }
        } catch (ShopFitmentException e) {
            logger.error("推荐失败", e);
            vo.setStatus(1);
            vo.setMessage("推荐失败");
        }

        return vo;
    }

    /**
     * 设置店铺banner
     * @param shopId
     * @param banner
     * @throws ShopFitmentException
     */
    @Transactional(rollbackFor = Exception.class)
    public void revalueShopHead(Long shopId,ShopBanner banner) throws ShopFitmentException {
        FitmentArea bannerArea = shopFitmentService.selShopHead(shopId);
        shopFitmentService.revalueModule(bannerArea.getAllarea().get(0).getModuleId(),banner);
    }

    /**
     * 设置模块值
     * @param moduleId
     * @param module
     * @throws ShopFitmentException
     */
    @Transactional(rollbackFor = Exception.class)
    public void revalueModule(Long moduleId,FitmentModule module) throws ShopFitmentException {
        shopFitmentService.revalueModule(moduleId,module);
    }

    /**
     * 添加区域
     * @param side
     * @param after
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Long addArea(Long side,Integer sideType,Integer after) throws ShopFitmentException {
        //先查出相邻区域所在的页面
        ShopFitmentArea sideArea=shopFitmentAreaMapper.selectByPrimaryKey(side);
        if(sideArea==null){
            throw new ShopFitmentException("未知相邻区域");
        }
        //1变2,2变1
        if(after==1){
            after=2;
        }else{
            after=1;
        }
        return shopFitmentService.addArea(sideArea.getPageId(),side,sideType,after);
    }

    /**
     * 删除区域
     * @param areaId
     */
    @Transactional(rollbackFor = Exception.class)
    public void rmArea(Long areaId){
        shopFitmentService.rmArea(areaId);
    }

    /**
     * 删除模块
     * @param mid
     * @param areaId
     */
    @Transactional(rollbackFor = Exception.class)
    public void rmModule(Long mid,Long areaId){
        shopFitmentService.rmModule(mid);
    }

    /**
     * 添加模块
     * @param id
     * @param area
     * @param sideType
     * @param side
     * @param after
     * @return
     * @throws ShopFitmentException
     */
    @Transactional(rollbackFor = Exception.class)
    public ModuleVO addModule(String id,Long area,Integer sideType,Long side,Integer after,ShopForModuleVO shop) throws ShopFitmentException, IOException {
        Integer moduleType=0;
        if("goods-tui".equals(id)){
            moduleType=1;
        }else if("goods-cat".equals(id)){
            moduleType=4;
        }else if("custom".equals(id)){
            moduleType=3;
        }else if("goods-search".equals(id)){
            moduleType=2;
        }else if("banner".equals(id)){
            return null;
        }else if("bigcarousel".equals(id)){
            moduleType=7;
        }else if("piccarousel".equals(id)){
            moduleType=6;
        }else if("bigpic".equals(id)){
            moduleType=5;
        }else if("search-item".equals(id)){
            return null;
        }
        //1变2,2变1
        if(after==1){
            after=2;
        }else{
            after=1;
        }
        Long mid=shopFitmentService.addModule(area,side,moduleType,sideType,after);
        FitmentModule module=shopFitmentService.selModuleByModuleId(mid);
        return parseModule(module,shop,true);
    }

    /**
     * 移动模块
     * @param moduleId
     * @param after
     */
    @Transactional(rollbackFor = Exception.class)
    public void moveModule(Long moduleId,Integer after){
        shopFitmentService.changeModuleLocation(moduleId,after);
    }

    /**
     * 更新页面背景设置
     * @param bo 背景信息
     * @param shopId 店铺id
     * @return json
     */
    @Transactional(rollbackFor = Exception.class)
    public DesignJsonVO pageBackOptionUpdate(PageBackBo bo, Long shopId) {
        DesignJsonVO vo = new DesignJsonVO();
        vo.setStatus(0);
        vo.setMessage("应用成功");
        if (shopFitmentService.updatePageBackground(shopId,bo.getPage(),bo.getType(),bo.getPic()) == 0) {
            vo.setStatus(1);
            vo.setMessage("更新失败");
        }
        return vo;
    }

    /**
     * 发布全店页面
     * @param shopId 店铺id
     */
    public DesignJsonVO publishOneShop(Long shopId) {
        shopFitmentService.publishBanner(shopId);
        for (PageManageVo vo : selAllPage(shopId)) {
            shopFitmentService.publishPage(vo.getPageId(),shopId);
        }
        DesignJsonVO vo = new DesignJsonVO();
        vo.setStatus(0);
        vo.setMessage("发布成功");
        return vo;
    }

    public boolean defaultModuleValueIs(Long moduleId){
        ShopFitmentModule shopFitmentModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);
        if (shopFitmentModule != null) {
            if ("{}".equals(shopFitmentModule.getModuleValue())) {
                return true;
            }
        }
        return false;
    }
}
