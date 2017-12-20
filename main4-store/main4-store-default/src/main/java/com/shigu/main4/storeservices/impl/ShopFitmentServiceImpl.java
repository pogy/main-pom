package com.shigu.main4.storeservices.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShopFitmentArea;
import com.opentae.data.mall.beans.ShopFitmentFtl;
import com.opentae.data.mall.beans.ShopFitmentModule;
import com.opentae.data.mall.beans.ShopFitmentPage;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.enums.FitmentAreaType;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.enums.FitmentPageType;
import com.shigu.main4.enums.FitmentPublished;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.storeservices.ShopFitmentService;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.*;
import com.shigu.main4.vo.fitment.BannerNav;
import com.shigu.main4.vo.fitment.BannerOption;
import com.shigu.main4.vo.fitment.ItemPromoteModule;
import com.shigu.main4.vo.fitment.ShopBanner;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 供商户中心修改
 *
 * @author shigu_zjb
 * @date 2017/02/25 15:24
 */
@Service("shopFitmentService")
public class ShopFitmentServiceImpl extends ShopServiceImpl implements ShopFitmentService {

    private static final Logger logger = Logger.getLogger(ShopFitmentServiceImpl.class);

    @Resource(name = "shopForCdnService")
    private ShopForCdnService shopForCdnService;

    @Autowired
    private ShopFitmentAreaMapper shopFitmentAreaMapper;

    @Autowired
    private ShopFitmentFtlMapper shopFitmentFtlMapper;

    @Autowired
    private ShopFitmentModuleMapper shopFitmentModuleMapper;

    @Autowired
    private ShopFitmentPageMapper shopFitmentPageMapper;

    /**
     * 初始化店铺装修
     *
     * @param shopId
     */
    @Override
    public void initShopFitment(Long shopId) throws ShopFitmentException {
        if (shopId == null) {
            return;
        }
        // 重置该店铺所有装修
        fitmentReset(shopId);

        Long index = addPage(shopId, FitmentPageType.INDEX.name, null, FitmentPageType.INDEX.value);
        Long firstImgArea = addArea(index, null, FitmentAreaType.CENTER.value(), null);
        addModule(firstImgArea, null, FitmentModuleType.WideImage.value, 3, null);

        Long indexFirstArea = addArea(index, firstImgArea, FitmentAreaType.LEFTRIGHT.value(), 2);
        addModule(indexFirstArea, null, FitmentModuleType.Category.value, 1, null);
        addModule(indexFirstArea, null, FitmentModuleType.Promote.value, 2, null);

        Long search = addPage(shopId, FitmentPageType.SEARCH.name, null, FitmentPageType.SEARCH.value);
        Long searchFirstArea = addArea(search, null, FitmentAreaType.LEFTRIGHT.value(),null);
        addModule(searchFirstArea, null, FitmentModuleType.Category.value, 1, null, false);
        addModule(searchFirstArea, null, FitmentModuleType.SearchItems.value, 2, null, false);

        createBanner(shopId);
//初始化发布
        initPublish(shopId);
    }

    @Override
    public int updatePageBackground(Long shopId,Long pageId, Integer type, String picUrl) {
        ShopFitmentPage page = new ShopFitmentPage();
        page.setBackgroundPic(picUrl);
        page.setBackgroundType(type);
        ShopFitmentPageExample pageExample = new ShopFitmentPageExample();
        pageExample.createCriteria().andPageIdEqualTo(pageId).andShopIdEqualTo(shopId);
        return shopFitmentPageMapper.updateByExampleSelective(page, pageExample);
    }

    private void fitmentReset(Long shopId) {
        ShopFitmentPageExample shopFitmentPageExample = new ShopFitmentPageExample();
        shopFitmentPageExample.createCriteria().andShopIdEqualTo(shopId);
        List<ShopFitmentPage> pages
                = shopFitmentPageMapper.selectFieldsByExample(shopFitmentPageExample, FieldUtil.codeFields("page_id"));
        List<Long> pageIds = BeanMapper.getFieldList(pages, "pageId", Long.class);
        shopFitmentPageMapper.deleteByExample(shopFitmentPageExample);

        if (!pageIds.isEmpty()) {
            ShopFitmentFtlExample fitmentFtlExample = new ShopFitmentFtlExample();
            fitmentFtlExample.createCriteria().andPageIdIn(pageIds);
            shopFitmentFtlMapper.deleteByExample(fitmentFtlExample);
        }

        ShopFitmentAreaExample areaExample = new ShopFitmentAreaExample();
        areaExample.createCriteria().andShopIdEqualTo(shopId);
        List<ShopFitmentArea> areas = shopFitmentAreaMapper.selectFieldsByExample(areaExample, FieldUtil.codeFields("area_id"));
        List<Long> areaIds = BeanMapper.getFieldList(areas, "areaId", Long.class);
        shopFitmentAreaMapper.deleteByExample(areaExample);

        if (!areaIds.isEmpty()) {
            ShopFitmentModuleExample moduleExample = new ShopFitmentModuleExample();
            moduleExample.createCriteria().andAreaIdIn(areaIds);
            shopFitmentModuleMapper.deleteByExample(moduleExample);
        }
    }

    private void createBanner(Long shopId) {
        ShopFitmentAreaExample areaExample = new ShopFitmentAreaExample();
        areaExample.createCriteria().andShopIdEqualTo(shopId).andAreaTypeEqualTo(FitmentAreaType.BANNER.value());
        List<ShopFitmentArea> shopFitmentAreas = shopFitmentAreaMapper.selectByExample(areaExample);

        ShopFitmentArea bannerArea;
        if (shopFitmentAreas.isEmpty()) {
            bannerArea = new ShopFitmentArea();
            bannerArea.setAreaType(FitmentAreaType.BANNER.value());
            bannerArea.setCanDel(false);
            bannerArea.setShopId(shopId);
            shopFitmentAreaMapper.insertSelective(bannerArea);
        } else {
            bannerArea = shopFitmentAreas.get(0);
        }

        ShopFitmentModuleExample moduleExample = new ShopFitmentModuleExample();
        moduleExample.createCriteria().andAreaIdEqualTo(bannerArea.getAreaId()).andTypeEqualTo(FitmentModuleType.Banner.value);
        List<ShopFitmentModule> shopFitmentModules = shopFitmentModuleMapper.selectByExample(moduleExample);

        ShopFitmentModule banner;
        if (shopFitmentModules.isEmpty()) {
            banner = new ShopFitmentModule();
            banner.setAreaId(bannerArea.getAreaId());
            banner.setType(FitmentModuleType.Banner.value);
            banner.setSideType(3);
            banner.setCanDel(false);
            banner.setModuleData("{\"imgShow\":1,\"spacing\":1}");
            banner.setModuleValue("{}");
            shopFitmentModuleMapper.insertSelective(banner);
        }
    }

    /**
     * 创建页面
     *
     * @param pageName 页面代称
     * @param pageType 版式
     * @return 页面id
     */
    public Long createPage(Long shopId, String pageName, Long code, Integer pageType) throws ShopFitmentException {
        Long page = addPage(shopId, pageName, code, FitmentPageType.CUSTOM.value);
        Long firstArea = addArea(page, null, FitmentAreaType.CENTER.value(),null);
        Long secondArea;
        switch (pageType) {
            case 1://通栏
                addModule(firstArea, null, FitmentModuleType.Custom.value, 3, null);
                secondArea = addArea(page, firstArea, FitmentAreaType.CENTER.value(),2);
                addModule(secondArea, null, FitmentModuleType.Promote.value, 3, null);
                break;
            case 2://左右栏
                addModule(firstArea, null, FitmentModuleType.WideImage.value, 3, null);
                secondArea = addArea(page, firstArea, FitmentAreaType.LEFTRIGHT.value(),2);
                addModule(secondArea, null, FitmentModuleType.Category.value, 1, null);
                addModule(secondArea, null, FitmentModuleType.Promote.value, 2, null);
                break;
            default://空白页面
        }
        return page;
    }
    public Long addPage(Long shopId, String pageName, Long code, Integer pageType) {
        ShopFitmentPage page = new ShopFitmentPage();
        page.setName(pageName);
        page.setType(pageType);
        page.setShopId(shopId);
        page.setCode(code);
        shopFitmentPageMapper.insertSelective(page);
        return page.getPageId();
    }

    /**
     * 删除一个页面
     *
     * @param pageId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rmPage(Long pageId) throws ShopFitmentException {
        if (pageId != null) {
            ShopFitmentPageExample pageExample = new ShopFitmentPageExample();
            pageExample.createCriteria().andPageIdEqualTo(pageId).andTypeEqualTo(FitmentPageType.CUSTOM.value);
            List<ShopFitmentPage> shopFitmentPages = shopFitmentPageMapper.selectByExample(pageExample);
            if (!shopFitmentPages.isEmpty()) {
                ShopFitmentPage page = shopFitmentPages.get(0);
                //1. 删除页面
                shopFitmentPageMapper.deleteByExample(pageExample);

                //2. 删除ftl
                ShopFitmentFtlExample fitmentFtlExample = new ShopFitmentFtlExample();
                fitmentFtlExample.createCriteria().andPageIdEqualTo(pageId);
                shopFitmentFtlMapper.deleteByExample(fitmentFtlExample);

                //3. 删除该页面的所有区域
                ShopFitmentAreaExample areaExample = new ShopFitmentAreaExample();
                areaExample.createCriteria().andPageIdEqualTo(pageId);
                List<ShopFitmentArea> areas = shopFitmentAreaMapper.selectFieldsByExample(areaExample, FieldUtil.codeFields("area_id"));
                List<Long> areaIds = BeanMapper.getFieldList(areas, "areaId", Long.class);
                shopFitmentAreaMapper.deleteByExample(areaExample);
                //4. 删除该页面的所有模块
                if (!areaIds.isEmpty()) {
                    ShopFitmentModuleExample moduleExample = new ShopFitmentModuleExample();
                    moduleExample.createCriteria().andAreaIdIn(areaIds);
                    shopFitmentModuleMapper.deleteByExample(moduleExample);
                }

                FitmentArea fitmentArea = selShopHead(page.getShopId());
                List<FitmentModule> allarea = fitmentArea.getAllarea();
                if (!allarea.isEmpty()) {
                    ShopBanner banner = (ShopBanner) allarea.get(0);
                    BannerNav storeNav = banner.getStoreNav();
                    if (storeNav != null) {
                        List<Long> pages = storeNav.getPages();
                        if (pages != null) {
                            if (pages.contains(pageId)) {
                                pages.remove(pageId);
                                revalueModule(banner.getModuleId(), banner);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 查页面的属主店铺ID
     *
     * @param pageId
     * @return
     */
    @Override
    public Long selShopIdByPageId(Long pageId) {
        ShopFitmentPage page;
        if (pageId != null && (page = shopFitmentPageMapper.selectByPrimaryKey(pageId)) != null) {
            return page.getShopId();
        }
        return null;
    }

    @Override
    public FitmentArea selShopHead(Long shopId) {
        FitmentArea fitmentArea = FitmentArea.emptyArea();
        if (shopId != null) {
            ShopFitmentAreaExample areaExample = new ShopFitmentAreaExample();
            areaExample.createCriteria().andShopIdEqualTo(shopId).andAreaTypeEqualTo(FitmentAreaType.BANNER.value());
            List<ShopFitmentArea> shopFitmentAreas = shopFitmentAreaMapper.selectByExample(areaExample);
            if (!shopFitmentAreas.isEmpty()) {
                ShopFitmentArea shopFitmentArea = shopFitmentAreas.get(0);
                fitmentArea = selAreaByAreaId(shopFitmentArea.getAreaId());
            }
        }
        return fitmentArea;
    }

    /**
     * 按areaID查区域
     *
     * @param pageId 页面id
     * @return 页面下区域
     */
    @Override
    public List<FitmentArea> selAreaByPageId(Long pageId) {
        List<FitmentArea> areas = Collections.emptyList();
        if (pageId != null) {
            ShopFitmentAreaExample areaExample = new ShopFitmentAreaExample();
            areaExample.createCriteria().andPageIdEqualTo(pageId);
            List<ShopFitmentArea> shopFitmentAreas = shopFitmentAreaMapper.selectFieldsByExample(areaExample, FieldUtil.codeFields("area_id, after_area_id"));
            if (!shopFitmentAreas.isEmpty()) {
                areas = new ArrayList<>(shopFitmentAreas.size());
                Map<Long, ShopFitmentArea> afterAreaMap = BeanMapper.list2Map(shopFitmentAreas, "afterAreaId", Long.class);
                ShopFitmentArea fitmentArea = afterAreaMap.get(0L);
                while (fitmentArea != null) {
                    areas.add(selAreaByAreaId(fitmentArea.getAreaId()));
                    fitmentArea = afterAreaMap.get(fitmentArea.getAreaId());
                }
            }
        }
        return areas;
    }

    @Override
    public FitmentArea selAreaByAreaId(Long areaId) {
        FitmentArea fitmentArea = null;
        if (areaId != null) {
            ShopFitmentArea shopFitmentArea = shopFitmentAreaMapper.selectByPrimaryKey(areaId);
            if (shopFitmentArea != null) {
                fitmentArea = FitmentArea.emptyArea();
                fitmentArea.setAreaId(areaId);
                fitmentArea.setAreaType(shopFitmentArea.getAreaType());
                Map<Long, FitmentModule> leftMap = new HashMap<>();
                Map<Long, FitmentModule> rightMap = new HashMap<>();
                Map<Long, FitmentModule> centerMap = new HashMap<>();
                for (FitmentModule module : selModuleByAreaId(areaId)) {
                    switch (module.getSideType()) {
                        case 1:
                            leftMap.put(module.getAfter(), module);
                            break;
                        case 2:
                            rightMap.put(module.getAfter(), module);
                            break;
                        default:
                            centerMap.put(module.getAfter(), module);
                    }
                }
                moduleSort(fitmentArea.getLeftarea(), leftMap);
                moduleSort(fitmentArea.getRightarea(), rightMap);
                moduleSort(fitmentArea.getAllarea(), centerMap);
            }
        }
        return fitmentArea;
    }

    private void moduleSort(List<FitmentModule> modules, Map<Long, FitmentModule> moduleMap) {
        FitmentModule fitmentModule = moduleMap.get(0L);
        while (fitmentModule != null) {
            modules.add(fitmentModule);
            fitmentModule = moduleMap.get(fitmentModule.getModuleId());
        }
    }

    /**
     * 按区域ID获取所有模块
     *
     * @param areaId 区域id
     * @return 区域下模块列表
     */
    @Override
    public <T extends FitmentModule> List<T> selModuleByAreaId(Long areaId) {
        List<T> modules = Collections.emptyList();
        if (areaId != null) {
            ShopFitmentModuleExample shopFitmentModuleExample = new ShopFitmentModuleExample();
            shopFitmentModuleExample.createCriteria().andAreaIdEqualTo(areaId);
            List<ShopFitmentModule> shopFitmentModules = shopFitmentModuleMapper.selectByExample(shopFitmentModuleExample);
            if (!shopFitmentModules.isEmpty()) {
                modules = new ArrayList<>(shopFitmentModules.size());
                for (ShopFitmentModule shopFitmentModule : shopFitmentModules) {
                    modules.add((T) packModule(shopFitmentModule));
                }
            }
        }
        return modules;
    }

    /**
     * 查询推荐位的商品
     *
     * @param promoteModule
     * @return
     */
    @Override
    public ShiguPager<ItemShowBlock> selItemByPromote(Long shopId,String webSite,ItemPromoteModule promoteModule) {
        if (promoteModule.getPromoteType() == 2) {
            //对推荐商品按推荐顺序进行排序
            ShiguPager<ItemShowBlock> pager = shopForCdnService.searchItemOnsale(promoteModule.getPromoteItems(), webSite, 1, promoteModule.getItemNum());
            Map<Long, ItemShowBlock> goodsIdShowMap = pager.getContent().stream().collect(Collectors.toMap(ItemShowBlock::getItemId, ItemShowBlock::getThis));
            List<ItemShowBlock> sortedItemList = new ArrayList<>(promoteModule.getPromoteItems().size());
            for (Long goodsId : promoteModule.getPromoteItems()) {
                if (goodsIdShowMap.get(goodsId) == null) {
                    continue;
                }
                sortedItemList.add(goodsIdShowMap.get(goodsId));
            }
            pager.setContent(sortedItemList);
            return pager;
        }
        String sort = "time_down";
        switch (promoteModule.getSort()) {
            case 1:
                sort = "common";
                break;
            case 2:
                sort = "time_down";
                break;
            case 3:
                sort = "popular";
                break;
            case 4:
                sort = "price-asc";
                break;
            case 5:
                sort = "price-desc";
                break;
            default:
                break;
        }
        return shopForCdnService.searchItemOnsale(
                promoteModule.getKeyword(),
                shopId,
                webSite,
                promoteModule.getLowerLimitPrice(),
                promoteModule.getUpperLimitPrice(),
                sort,
                null,null,
                1,
                promoteModule.getItemNum()
        );
    }

    /**
     * 取首页pageId
     *
     * @param shopId
     * @return
     */
    @Override
    public Long selIndexPageIdByShopId(Long shopId) throws ShopFitmentException {
        try {
            ShopFitmentPageExample pageExample = new ShopFitmentPageExample();
            pageExample.createCriteria().andShopIdEqualTo(shopId).andTypeEqualTo(FitmentPageType.INDEX.value);
            return shopFitmentPageMapper.selectByExample(pageExample).get(0).getPageId();
        } catch (Exception e) {
            throw new ShopFitmentException("该店铺不存在首页");
        }
    }

    /**
     * 取搜索页面
     * @param shopId 店铺ID
     * @return 搜索页面ID
     * @throws ShopFitmentException
     */
    @Override
    public Long selSearchPageIdByShopId(Long shopId) throws ShopFitmentException {
        try {
            ShopFitmentPageExample pageExample = new ShopFitmentPageExample();
            pageExample.createCriteria().andShopIdEqualTo(shopId).andTypeEqualTo(FitmentPageType.SEARCH.value);
            return shopFitmentPageMapper.selectByExample(pageExample).get(0).getPageId();
        } catch (Exception e) {
            throw new ShopFitmentException("该店铺不存在搜索页面");
        }
    }

    /**
     * 尝试删除区域
     * 1、如果区域内有模块,不删除
     * 2、如果区域是顶级区域,after_area_id=0 页面中再没有其它区域,不删除
     * @param areaId
     */
    @Override
    public void tryRmArea(Long areaId) {
        ShopFitmentModuleExample moduleExample=new ShopFitmentModuleExample();
        moduleExample.createCriteria().andAreaIdEqualTo(areaId);
        if(shopFitmentModuleMapper.countByExample(moduleExample)>0){
            return;
        }
        //本页面下,没有其它区域
        if(shopFitmentAreaMapper.countAreaNome(areaId)>0){
            rmArea(areaId);
        }
    }

    /**
     * 初始化发布
     * @param shopId
     */
    @Override
    public void initPublish(Long shopId) throws ShopFitmentException {
        //先删除老的
        ShopFitmentFtlExample ftlExample=new ShopFitmentFtlExample();
        ftlExample.createCriteria().andShopIdEqualTo(shopId);
        shopFitmentFtlMapper.deleteByExample(ftlExample);
        //初始化banner数据
        ShopFitmentFtl bannerFtl=new ShopFitmentFtl();
        bannerFtl.setContext(bannerJson(shopId).toJSONString());
        bannerFtl.setShopId(shopId);
        bannerFtl.setType(FitmentPublished.BANNER.value);
        shopFitmentFtlMapper.insertSelective(bannerFtl);
        //初始化首页
        Long firstPage=selIndexPageIdByShopId(shopId);
        shopFitmentFtlMapper.insertSelective(getFtlFromActive(firstPage,shopId));
        //初始化搜索
        Long searchPage=selSearchPageIdByShopId(shopId);
        shopFitmentFtlMapper.insertSelective(getFtlFromActive(searchPage,shopId));
    }

    /**
     * 取得动态里面的ftl页面信息
     * @param pageId
     * @param shopId
     * @return
     */
    public ShopFitmentFtl getFtlFromActive(Long pageId,Long shopId){
        FitmentPage page = selPage(pageId);
        page.setHeadArea(null);
        ShopFitmentFtl ftl=new ShopFitmentFtl();
        ftl.setContext(JSON.toJSONString(page));
        ftl.setType(FitmentPublished.PAGE.value);
        ftl.setShopId(shopId);
        ftl.setPageId(pageId);
        return ftl;
    }

    /**
     * 发布店铺banner
     * @param shopId 店铺ID
     */
    @Override
    public void publishBanner(Long shopId) {
        //直接更新发布区,当发布区是有的
        ShopFitmentFtlExample example=new ShopFitmentFtlExample();
        example.createCriteria().andShopIdEqualTo(shopId).andTypeEqualTo(FitmentPublished.BANNER.value);
        ShopFitmentFtl sff=new ShopFitmentFtl();
        sff.setContext(bannerJson(shopId).toJSONString());
        shopFitmentFtlMapper.updateByExampleSelective(sff,example);
    }

    /**
     * 查出要发布的banner的json数据
     * @param shopId
     * @return
     */
    private JSONObject bannerJson(Long shopId){
        ShopBanner banner=(ShopBanner) selShopHead(shopId).getAllarea().get(0);//拿到banner
        JSONObject bannerJson= (JSONObject) JSON.toJSON(banner);
        bannerJson.put("bannerOption",JSON.toJSON(banner.getBannerOption()));
        //重新包装成area
        return bannerJson;
    }

    @Override
    public FitmentArea bannerOnpub(Long shopId) {
        ShopFitmentFtl banner=new ShopFitmentFtl();
        banner.setShopId(shopId);
        banner.setType(FitmentPublished.BANNER.value);
        banner=shopFitmentFtlMapper.selectOne(banner);
        FitmentArea area=FitmentArea.emptyArea();
        area.getAllarea().add(JSON.parseObject(banner.getContext(),ShopBanner.class));
        return area;
    }

    @Override
    public void publishPage(Long pageId,Long shopId) {
        FitmentPage fitmentPage = selPage(pageId);
        fitmentPage.setHeadArea(null);
        ShopFitmentFtlExample example=new ShopFitmentFtlExample();
        example.createCriteria().andPageIdEqualTo(pageId);
        ShopFitmentFtl sff=new ShopFitmentFtl();
        sff.setContext(JSON.toJSONString(fitmentPage));
        if(shopFitmentFtlMapper.updateByExampleSelective(sff,example)==0){
            shopFitmentFtlMapper.insertSelective(getFtlFromActive(pageId,shopId));
        }
    }

    @Override
    public FitmentPage selPageOnpub(Long pageId) {
        ShopFitmentFtl pageFtl=new ShopFitmentFtl();
        pageFtl.setPageId(pageId);
        pageFtl=shopFitmentFtlMapper.selectOne(pageFtl);
        JSONObject pageJson=JSON.parseObject(pageFtl.getContext());
        //查shopId
        ShopFitmentPage sfpage=shopFitmentPageMapper.selectFieldsByPrimaryKey(pageId,FieldUtil.codeFields("page_id,shop_id"));

        FitmentPage page=new FitmentPage();
        page.setPageId(pageId);
        page.setBackgroundPic(pageJson.getString("backgroundPic"));
        page.setBackgroundType(pageJson.getInteger("backgroundType"));
        page.setHeadArea(bannerOnpub(sfpage.getShopId()));
        JSONArray areas=pageJson.getJSONArray("userDefineAreas");
        List<FitmentArea> fitmentAreas=new ArrayList<>();
        for(int i=0;i<areas.size();i++){
            JSONObject areaJson=areas.getJSONObject(i);
            FitmentArea area=new FitmentArea();
            area.setAreaId(areaJson.getLong("areaId"));
            area.setAreaType(areaJson.getInteger("areaType"));
            area.setAllarea(parseJsonModule(areaJson.getJSONArray("allarea")));
            area.setLeftarea(parseJsonModule(areaJson.getJSONArray("leftarea")));
            area.setRightarea(parseJsonModule(areaJson.getJSONArray("rightarea")));
            fitmentAreas.add(area);
        }
        page.setUserDefineAreas(fitmentAreas);
        return page;
    }

    /**
     * 包装module数组
     * @param moduleArr
     * @return
     */
    private List<FitmentModule> parseJsonModule(JSONArray moduleArr){
        List<FitmentModule> modules=new ArrayList<>();
        if(moduleArr!=null)
        for(int i=0;i<moduleArr.size();i++){
            JSONObject module=moduleArr.getJSONObject(i);
            Integer moduleType=module.getInteger("moduleType");
            modules.add(JSON.parseObject(module.toJSONString(),FitmentModuleType.typeOf(moduleType).moduleType.getClazz()));
        }
        return modules;
    }

    @Override
    public <T extends FitmentModule> T selModuleByModuleId(Long moduleId) {
        T t = null;
        if (moduleId != null) {
            t = packModule(shopFitmentModuleMapper.selectByPrimaryKey(moduleId));
        }
        return t;
    }

    @SuppressWarnings("unchecked")
    private <T extends FitmentModule> T packModule(ShopFitmentModule shopFitmentModule) {
        T t = null;
        if (shopFitmentModule != null) {
            FitmentModuleType fitmentModuleType = FitmentModuleType.typeOf(shopFitmentModule.getType());
            t = (T) JSON.parseObject(shopFitmentModule.getModuleValue(), fitmentModuleType.moduleType.getClazz());
            t.setModuleId(shopFitmentModule.getModuleId());
            t.setAreaId(shopFitmentModule.getAreaId());
            t.setSideType(shopFitmentModule.getSideType());
            t.setAfter(shopFitmentModule.getAfterModuleId());
            setModileOption(shopFitmentModule, t);
        }
        return t;
    }

    /**
     * 为模块设置特殊选项
     * @param shopFitmentModule
     * @param t
     * @param <T>
     */
    private <T extends FitmentModule> void setModileOption(ShopFitmentModule shopFitmentModule, T t) {
        switch (FitmentModuleType.typeOf(shopFitmentModule.getType())) {
            case Banner:
                ShopBanner banner = (ShopBanner) t;
                banner.setBannerOption(JSON.parseObject(shopFitmentModule.getModuleData(), BannerOption.class));
                break;
            case Promote:
                ItemPromoteModule promoteModule = (ItemPromoteModule) t;
                List<Long> ids = JSON.parseArray(shopFitmentModule.getModuleData(), Long.class);
                if (ids != null) {
                    promoteModule.setPromoteItems(ids);
                }
                break;
            case Search:
                break;
            case Custom:
                break;
            case Category:
                break;
            case WideImage:
                break;
            case Viwepager:
                break;
            case Slideshow:
                break;
            case SearchItems:
                break;
        }
    }

    @Override
    public FitmentPage selPage(Long pageId) {
        ShopFitmentPage page;
        if (pageId == null || (page = shopFitmentPageMapper.selectByPrimaryKey(pageId)) == null) {
            return null;
        }
        FitmentPage fitmentPage = new FitmentPage();
        fitmentPage.setUserDefineAreas(selAreaByPageId(pageId));
        fitmentPage.setHeadArea(selShopHead(page.getShopId()));
        fitmentPage.setPageId(pageId);
        fitmentPage.setPageName(page.getName());
        fitmentPage.setBackgroundPic(page.getBackgroundPic());
        fitmentPage.setBackgroundType(page.getBackgroundType());
        return fitmentPage;
    }

    /**
     * @param pageId 页面ID
     * @param sideId 邻模块ID
     * @param type 区域类型
     * @param after   1代表上方，2代表下方 NotNull
     * @return 新加区域ID
     * @throws ShopFitmentException 区域添加异常
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addArea(Long pageId, Long sideId, Integer type, Integer after) throws ShopFitmentException {
        ShopFitmentPage page;
        if (pageId == null || (page = shopFitmentPageMapper.selectByPrimaryKey(pageId)) == null) {
            throw new ShopFitmentException("所指定页面不存在");
        }
        boolean firstArea = sideId == null || sideId == 0;
        if (!firstArea && after == null) {
            throw new ShopFitmentException("存在临区域时，type不能为null");
        }
        ShopFitmentArea shopFitmentArea = new ShopFitmentArea();
        shopFitmentArea.setPageId(pageId);
        shopFitmentArea.setAfterAreaId(sideId);
        shopFitmentArea.setShopId(page.getShopId());
        shopFitmentArea.setAreaType(type);
        if (firstArea) {
            ShopFitmentAreaExample areaExample = new ShopFitmentAreaExample();
            areaExample.createCriteria().andAfterAreaIdEqualTo(0L).andPageIdEqualTo(pageId);
            if (shopFitmentAreaMapper.countByExample(areaExample) > 0)
                throw new ShopFitmentException("添加区域失败, 该页面已经存在区域了，添加请指定上层区域");
            shopFitmentArea.setAfterAreaId(0L);
            shopFitmentAreaMapper.insertSelective(shopFitmentArea);
        } else switch (after) {
            case 1://top
                ShopFitmentArea topSideArea = shopFitmentAreaMapper.selectByPrimaryKey(sideId);
                if (topSideArea == null) {
                    throw new ShopFitmentException("相邻区域不存在");
                }
                insertBefore(shopFitmentArea, topSideArea);
                break;
            case 2://bottom
                ShopFitmentAreaExample shopFitmentAreaExample = new ShopFitmentAreaExample();
                shopFitmentAreaExample.createCriteria().andAfterAreaIdEqualTo(sideId);
                List<ShopFitmentArea> shopFitmentAreas = shopFitmentAreaMapper.selectByExample(shopFitmentAreaExample);
                if (shopFitmentAreas.isEmpty()) {
                    shopFitmentArea.setAfterAreaId(sideId);
                    shopFitmentAreaMapper.insertSelective(shopFitmentArea);
                } else {
                    ShopFitmentArea bottomSideArea = shopFitmentAreas.get(0);
                    insertBefore(shopFitmentArea, bottomSideArea);
                }
                break;
            default:
                throw new ShopFitmentException("after:" + after + ", 未知区域添加方式");
        }
        return shopFitmentArea.getAreaId();
    }

    /**
     * 查区域的属主店铺ID
     *
     * @param areaId
     * @return
     */
    @Override
    public Long selShopIdByAreaId(Long areaId) {
        ShopFitmentArea shopFitmentArea;
        if (areaId != null && (shopFitmentArea = shopFitmentAreaMapper.selectByPrimaryKey(areaId)) != null) {
            return shopFitmentArea.getShopId();
        }
        return null;
    }

    /**
     * 删除一个区域
     *
     * @param areaId 区域id
     */
    @Override
    public void rmArea(Long areaId) {
        if (areaId != null) {
            ShopFitmentArea shopFitmentArea = shopFitmentAreaMapper.selectByPrimaryKey(areaId);
            if (shopFitmentArea != null) {
                shopFitmentAreaMapper.deleteByPrimaryKey(areaId);
                ShopFitmentModuleExample moduleExample = new ShopFitmentModuleExample();
                moduleExample.createCriteria().andAreaIdEqualTo(areaId);
                shopFitmentModuleMapper.deleteByExample(moduleExample);

//                ShopFitmentArea afterArea = shopFitmentAreaMapper.selectByPrimaryKey(shopFitmentArea.getAfterAreaId());
//                Long afterAreaId = 0L;
//                if (afterArea != null) {
//                    afterAreaId = afterArea.getAfterAreaId();
//                }
                ShopFitmentArea area = new ShopFitmentArea();
                area.setAfterAreaId(shopFitmentArea.getAfterAreaId());
                ShopFitmentAreaExample areaExample = new ShopFitmentAreaExample();
                areaExample.createCriteria().andAfterAreaIdEqualTo(areaId);
                shopFitmentAreaMapper.updateByExampleSelective(area, areaExample);
            }
        }
    }

    /**
     * 在原区域上层添加一个新区域
     * @param newArea 新区域
     * @param oldArea 原区域
     */
    @Transactional(rollbackFor = Exception.class)
    protected void insertBefore(ShopFitmentArea newArea, ShopFitmentArea oldArea) {
        newArea.setAfterAreaId(oldArea.getAfterAreaId());
        shopFitmentAreaMapper.insertSelective(newArea);
        oldArea.setAfterAreaId(newArea.getAreaId());
        shopFitmentAreaMapper.updateByPrimaryKeySelective(oldArea);
    }

    /**
     * 在原模块上层添加一个新模块
     * @param newModule 新模块
     * @param oldModule 原模块
     */
    @Transactional(rollbackFor = Exception.class)
    protected void insertBefore(ShopFitmentModule newModule, ShopFitmentModule oldModule) {
        newModule.setAfterModuleId(oldModule.getAfterModuleId());
        shopFitmentModuleMapper.insertSelective(newModule);
        oldModule.setAfterModuleId(newModule.getModuleId());
        shopFitmentModuleMapper.updateByPrimaryKeySelective(oldModule);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addModule(Long areaId,Long sideId,Integer type,Integer sideType,Integer after) throws ShopFitmentException {
        return addModule(areaId, sideId, type, sideType, after, null);
    }
    private Long addModule(Long areaId,Long sideId,Integer type,Integer sideType,Integer after, Boolean canDel) throws ShopFitmentException {
        if (areaId == null || shopFitmentAreaMapper.selectByPrimaryKey(areaId) == null) {
            throw new ShopFitmentException("无效区域");
        }
        if (sideId != null && after == null) {
            throw new ShopFitmentException("有临模块时必须指定相邻方式:after");
        }
        ShopFitmentModule module = new ShopFitmentModule();
        module.setAreaId(areaId);
        module.setSideType(sideType);
        module.setType(type);
        module.setAfterModuleId(sideId);
        module.setCanDel(canDel);
        module.setModuleValue("{}");
        if (sideId == null) {
            module.setAfterModuleId(0L);
            shopFitmentModuleMapper.insertSelective(module);
        } else switch (after) {
            case 1://top
                ShopFitmentModule shopFitmentModule = shopFitmentModuleMapper.selectByPrimaryKey(sideId);
                if (shopFitmentModule == null) {
                    throw new ShopFitmentException("所临模块不存在：" + sideId);
                }
                insertBefore(module, shopFitmentModule);
                break;
            case 2://bottom
                ShopFitmentModuleExample moduleExample = new ShopFitmentModuleExample();
                moduleExample.createCriteria().andAfterModuleIdEqualTo(sideId).andAreaIdEqualTo(areaId);
                List<ShopFitmentModule> shopFitmentModules = shopFitmentModuleMapper.selectByExample(moduleExample);
                if (shopFitmentModules.isEmpty()) {
                    //说明后面没有模块了，传入的sideid是该区域最后一个模块，下面在它下方添加模块
                    shopFitmentModuleMapper.insertSelective(module);
                } else {
                    //如果还有模块，拿到传入sideId 模块原来下方的模块，在其上添加新模块
                    ShopFitmentModule fitmentModule = shopFitmentModules.get(0);
                    insertBefore(module, fitmentModule);
                }
                break;
            default:
                throw new ShopFitmentException("不允许的after位置:" + sideType);
        }
        return module.getModuleId();
    }

    /**
     * 删除一个模块
     *
     * @param moduleId
     */
    @Override
    public void rmModule(Long moduleId) {
        if (moduleId != null) {
            ShopFitmentModule shopFitmentModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);
            if (shopFitmentModule != null) {
                shopFitmentModuleMapper.deleteByPrimaryKey(moduleId);
                ShopFitmentModule after = shopFitmentModuleMapper.selectByPrimaryKey(shopFitmentModule.getAfterModuleId());
                Long afterId = 0L;
                if (after != null) {
                    afterId = after.getModuleId();
                }
                ShopFitmentModuleExample moduleExample = new ShopFitmentModuleExample();
                moduleExample.createCriteria().andAfterModuleIdEqualTo(moduleId);
                ShopFitmentModule module = new ShopFitmentModule();
                module.setAfterModuleId(afterId);
                shopFitmentModuleMapper.updateByExampleSelective(module, moduleExample);

                tryRmArea(shopFitmentModule.getAreaId());
            }
        }
    }

    /**
     * 查模块的属主店铺ID
     *
     * @param moduleId
     * @return
     */
    @Override
    public Long selShopIdByModuleId(Long moduleId) {
        if (moduleId != null) {
            ShopFitmentModule shopFitmentModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);
            if (shopFitmentModule != null && shopFitmentModule.getAreaId() != null) {
                ShopFitmentArea shopFitmentArea = shopFitmentAreaMapper.selectByPrimaryKey(shopFitmentModule.getAreaId());
                if (shopFitmentArea != null) {
                    return shopFitmentArea.getShopId();
                }
            }
        }
        return null;
    }

    @Override
    public void revalueModule(Long moduleId, FitmentModule module) throws ShopFitmentException {
        if (moduleId == null) {
            throw new ShopFitmentException("模块不存在");
        }
        ShopFitmentModule shopFitmentModule = new ShopFitmentModule();
        shopFitmentModule.setModuleId(moduleId);
        JSONObject moduleObj= (JSONObject) JSON.toJSON(module);
        if(module instanceof ItemPromoteModule){
            moduleObj.remove("promoteItems");
        }
        shopFitmentModule.setModuleValue(moduleObj.toJSONString());
        shopFitmentModuleMapper.updateByPrimaryKeySelective(shopFitmentModule);
    }

    public void revalueModuleOption(Long moduleId, String Option) throws ShopFitmentException {
        if (moduleId == null) {
            throw new ShopFitmentException("模块不存在");
        }
        ShopFitmentModule shopFitmentModule = new ShopFitmentModule();
        shopFitmentModule.setModuleId(moduleId);
        shopFitmentModule.setModuleData(Option);
        shopFitmentModule.setModuleValue(null);
        shopFitmentModuleMapper.updateByPrimaryKeySelective(shopFitmentModule);

    }

    /**
     * 移动
     *
     * @param moduleId 模块id
     * @param type     1代表上移，2代表下移
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeModuleLocation(Long moduleId, Integer type) {
        if (moduleId != null && type != null) {
            ShopFitmentModule thisModule = shopFitmentModuleMapper.selectByPrimaryKey(moduleId);
            ShopFitmentModule parentModule = shopFitmentModuleMapper.selectByPrimaryKey(thisModule.getAfterModuleId());
            ShopFitmentModuleExample moduleExample = new ShopFitmentModuleExample();
            moduleExample.createCriteria().andAreaIdEqualTo(thisModule.getAreaId())
                    .andAfterModuleIdEqualTo(thisModule.getModuleId());
            List<ShopFitmentModule> subFitmentModules = shopFitmentModuleMapper.selectByExample(moduleExample);
            switch (type) {
                case 1://move up
                    if (parentModule != null) {
                        Long parentAfterModuleId = parentModule.getAfterModuleId();
                        parentModule.setAfterModuleId(thisModule.getModuleId());
                        thisModule.setAfterModuleId(parentAfterModuleId);
                        shopFitmentModuleMapper.updateByPrimaryKeySelective(thisModule);
                        shopFitmentModuleMapper.updateByPrimaryKeySelective(parentModule);
                        // if exist, only one.
                        for (ShopFitmentModule subFitmentModule : subFitmentModules) {
                            subFitmentModule.setAfterModuleId(parentModule.getModuleId());
                            shopFitmentModuleMapper.updateByPrimaryKeySelective(subFitmentModule);
                        }
                    }
                    break;
                case 2://move down
                    if (!subFitmentModules.isEmpty()) {
                        ShopFitmentModule shopFitmentModule = subFitmentModules.get(0);
                        Long thisAfterModuleId = thisModule.getAfterModuleId();
                        thisModule.setAfterModuleId(shopFitmentModule.getModuleId());
                        shopFitmentModule.setAfterModuleId(thisAfterModuleId);

                        ShopFitmentModuleExample subExample = new ShopFitmentModuleExample();
                        subExample.createCriteria().andAfterModuleIdEqualTo(shopFitmentModule.getModuleId());
                        ShopFitmentModule t = new ShopFitmentModule();
                        t.setAfterModuleId(thisModule.getModuleId());
                        shopFitmentModuleMapper.updateByExampleSelective(t, subExample);
                        shopFitmentModuleMapper.updateByPrimaryKeySelective(thisModule);
                        shopFitmentModuleMapper.updateByPrimaryKeySelective(shopFitmentModule);
                    }
                    break;
                default:
            }
        }
    }
}
