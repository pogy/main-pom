package com.shigu.main4.cdn.actions;

import com.alibaba.fastjson.JSON;
import com.shigu.main4.cdn.bo.*;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.cdn.services.IndexShowService;
import com.shigu.main4.cdn.services.OldStoreNumShowService;
import com.shigu.main4.cdn.services.SimpleVideoService;
import com.shigu.main4.cdn.vo.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.exceptions.ShopFitmentException;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.services.ItemCatService;
import com.shigu.main4.item.services.ShopsItemService;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.ItemGoatCidAndWebsiteVO;
import com.shigu.main4.monitor.services.ItemBrowerService;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.newcdn.vo.*;
import com.shigu.main4.storeservices.*;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.main4.vo.ShopBase;
import com.shigu.main4.vo.StoreRelation;
import com.shigu.main4.vo.fitment.ItemPromoteModule;
import com.shigu.search.bo.NewGoodsBO;
import com.shigu.search.services.TodayNewGoodsService;
import com.shigu.search.vo.GoodsInSearch;
import com.shigu.seller.services.GoodsFileService;
import com.shigu.seller.services.ShopDesignService;
import com.shigu.seller.vo.ContainerVO;
import com.shigu.seller.vo.DatuVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.spread.services.ObjFromCache;
import com.shigu.spread.services.SpreadService;
import com.shigu.spread.vo.ItemSpreadVO;
import com.shigu.tools.HtmlImgsLazyLoad;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.ResultRetUtil;
import com.shigu.tools.XzSdkClient;
import com.shigu.vo.ItemGoatVO;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

/**
 * 商品页面显示
 * Created by zhaohongbo on 17/3/2.
 */
@Controller
public class CdnAction {

    @Autowired
    ShowForCdnService showForCdnService;

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    StoreRelationService storeRelationService;

    @Autowired
    ShopBaseService shopBaseService;

    @Autowired
    CdnService cdnService;

    @Autowired
    ShopDiscusService shopDiscusService;

    @Autowired
    ShopLicenseService shopLicenseService;

    @Autowired
    OldStoreNumShowService oldStoreNumShowService;

    @Autowired
    IndexShowService indexShowService;

    @Autowired
    SpreadService spreadService;

    @Autowired
    ShopsItemService shopsItemService;

    @Autowired
    ItemUpRecordService itemUpRecordService;

    @Autowired
    ShopDesignService shopDesignService;

    @Autowired
    XzSdkClient xzSdkClient;

    @Autowired
    TodayNewGoodsService todayNewGoodsService;

    @Autowired
    ItemBrowerService itemBrowerService;

    @Autowired
    GoodsFileService goodsFileService;

    @Autowired
    ItemCatService itemCatService;

    @Autowired
    SimpleVideoService simpleVideoService;

    @RequestMapping("")
    public String jdUpload(){
        return "";
    }


    /**
     * 联系我们
     * @return
     */
    @RequestMapping("contact")
    public String contact(Model model){
        model.addAttribute("webSite","hz");
        return "contact/contact";
    }
    /**
     * 杭州首页动态页面
     * @return
     */
    @RequestMapping("hzindex4show")
    public String hzindex4show(HttpServletRequest request,Model model){
        Cookie[] cookies=request.getCookies();
        String manOrWoman="Man";
        String webSite="hz";
        IndexPageVO page=new IndexPageVO();
        page.setType("M");
        page.setTypeText("男装");
        Long cid=30L;
        if(cookies!=null)
        for(Cookie c:cookies){
            if("pageType".equals(c.getName())&&c.getValue().equals("W")){
                manOrWoman="Woman";
                page.setType("W");
                page.setTypeText("女装");
                cid=16L;
                break;
            }
        }
        model.addAttribute("page",page);
        //商品数量
        model.addAttribute("userCount",selFromCache(indexShowService.selNumList()));
        //全站公告
        model.addAttribute("notices",selFromCache(indexShowService.selNavVOs(SpreadEnum.QZGG)));
        //轮播下方小图
//        model.addAttribute("topStoread",selFromCache(spreadService.selImgBanners(
//                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_XT:SpreadEnum.MAN_XT)));
        model.addAttribute("topStoread",selFromCache(spreadService.selImgBanners(
                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_XT:SpreadEnum.MAN_GXT)));
        //大图
        model.addAttribute("topBanner",selFromCache(spreadService.selImgBanners(
                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_DT:SpreadEnum.MAN_DT)));
        //风格类目
        model.addAttribute("styleCateList",indexShowService.selStyleOrElementNav(cid.toString(), SearchCategory.STYLE, "hz"));
        //元素类目
        model.addAttribute("elementCateList",indexShowService.selStyleOrElementNav(cid.toString(),SearchCategory.ELEMENT, "hz"));
        //热卖
        model.addAttribute("hotsaleGoodslist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_RM:SpreadEnum.MAN_RM)));
        // 风格商品
        model.addAttribute("styleGoodslist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_FG:SpreadEnum.MAN_FG)));
        //元素商品
        model.addAttribute("elementGoodslist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_YS:SpreadEnum.MAN_YS)));
        //推荐档口
        model.addAttribute("recommendShoplist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_TJDK:SpreadEnum.MAN_TJDK)));
        //顶部
        model.addAttribute("topPic",selFromCache(spreadService.selImgBanners(SpreadEnum.INDEX_TOP)));
        //热卖下
//        model.addAttribute("hotBotAdvs",selFromCache(spreadService.selImgBanners(
//                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_HOTBOT:SpreadEnum.MAN_HOTBOT)));
        //风格下方广告
//        model.addAttribute("styleBotAdvs",selFromCache(spreadService.selImgBanners(
//                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_STYLEBOT:SpreadEnum.MAN_STYLEBOT)));
        //猜喜欢
        List<LoveGoodsList> loves=new ArrayList<>();

        if(manOrWoman.equals("Woman")){

            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"上装",webSite,indexShowService.womanUp())));
            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"下装",webSite,
                    indexShowService.womanBottom())));
        }else{
            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"棉衣",webSite,
                    indexShowService.manMianyi())));
            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"休闲裤",webSite,
                    indexShowService.manFree())));
        }
//        loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods("鞋子",webSite,
//                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_XHXZ:SpreadEnum.MAN_XHXZ)));
        model.addAttribute("loveGoodslist",loves);
        model.addAttribute("webSite",webSite);
        return "index/hz"+manOrWoman;
    }

    /**
     * 濮院站首页
     * @return
     */
    @RequestMapping(value = "jxindex4show" , method = RequestMethod.GET)
    public String jxindex4show(HttpServletRequest request,Model model){
        String website = "jx";

        // 商户总数
        int shopsNum = indexShowService.getShopAllCount(website);
        // 商品总数
        ObjFromCache<List<Integer>> goodsNum = indexShowService.selNumList();
        if(goodsNum != null){
            List<Integer> goodsNumList = (List<Integer>)goodsNum.selObj();
            StringBuffer stringBuffer = new StringBuffer();
            if(goodsNumList!=null){
                for(Integer integer : goodsNumList){
                    stringBuffer.append(integer);
                }
                model.addAttribute("hasGoods",stringBuffer.toString());
            }
        }

        // 今日新品
        NewGoodsBO newGoodsBO = new NewGoodsBO();
        newGoodsBO.setWebSite("jx");
        newGoodsBO.setRows(15);
        ShiguPager<GoodsInSearch> newGoodsPager = todayNewGoodsService.selGoodsNewForCid(newGoodsBO);

        List<IndexGoodsVo> indexNewGoodsVoList = new ArrayList<IndexGoodsVo>();
        if(newGoodsPager != null && newGoodsPager.getContent() != null){
            for(GoodsInSearch goodsInSearch : newGoodsPager.getContent()){
                IndexGoodsVo indexGoodsVo = BeanMapper.map(goodsInSearch, IndexGoodsVo.class);
                indexGoodsVo.setStoreId(goodsInSearch.getStoreid().toString());
                if(!StringUtils.isEmpty(goodsInSearch.getFullStoreName())){
                    int kgIndex = goodsInSearch.getFullStoreName().indexOf(" ");
                    if(kgIndex != -1){
                        String marketName = goodsInSearch.getFullStoreName().substring(0,kgIndex);
                        String storeNum = goodsInSearch.getFullStoreName().substring(kgIndex + 1,goodsInSearch.getFullStoreName().length());
                        indexGoodsVo.setParentMarketName(marketName);
                        indexGoodsVo.setStoreNum(storeNum);
                    }
                }
                indexNewGoodsVoList.add(indexGoodsVo);
            }
        }

        // 男装数据
        Object menSpread = selFromCache(spreadService.selItemSpreads(website, SpreadEnum.JX_SPREAD_INDEX_MENS));
        // 男鞋数据
        //Object menShoesSpread = selFromCache(spreadService.selItemSpreads(website, SpreadEnum.JX_SPREAD_INDEX_MENSHOES));
        // 童装数据
        Object chilrenSpread = selFromCache(spreadService.selItemSpreads(website, SpreadEnum.JX_SPREAD_INDEX_CHILDRENCOLTHING));
        // 女装数据
        Object womanSpread = selFromCache(spreadService.selItemSpreads(website, SpreadEnum.JX_SPREAD_INDEX_WOMAN));
        // 热销数据
        Object sellhotSpread = selFromCache(spreadService.selItemSpreads(website, SpreadEnum.JX_SPREAD_INDEX_SELLHOT));
        // 裤子数据
        Object kuziSpread = selFromCache(spreadService.selItemSpreads(website, SpreadEnum.JX_SPREAD_INDEX_KUZI));

        List<IndexGoodsVo> menSpreadList = changeGoods((List<ItemSpreadVO>)menSpread);
        //List<IndexGoodsVo> menShoesSpreadList = changeGoods((List<ItemSpreadVO>)menShoesSpread);
        List<IndexGoodsVo> chilrenSpreadList = changeGoods((List<ItemSpreadVO>)chilrenSpread);
        List<IndexGoodsVo> womanSpreadList = changeGoods((List<ItemSpreadVO>)womanSpread);
        List<IndexGoodsVo> sellhotSpreadList = changeGoods((List<ItemSpreadVO>)sellhotSpread);
        List<IndexGoodsVo> kuziSpreadList = changeGoods((List<ItemSpreadVO>)kuziSpread);
        /*if(menShoesSpreadList == null)
            menShoesSpreadList = Collections.emptyList();*/
        if(chilrenSpreadList == null)
            chilrenSpreadList = Collections.emptyList();
        if(womanSpreadList == null)
            womanSpreadList = Collections.emptyList();
        if(menSpreadList == null)
            menSpreadList = Collections.emptyList();
        if(sellhotSpreadList == null)
            sellhotSpreadList = Collections.emptyList();
        if(kuziSpreadList == null)
            kuziSpreadList = Collections.emptyList();

        //全站公告
        model.addAttribute("notices",selFromCache(indexShowService.selNavVOs(SpreadEnum.JX_QZGG)));
        //大图
        model.addAttribute("topBanner",selFromCache(spreadService.selImgBanners(
                SpreadEnum.JX_SPREAD_INDEX_DT)));
        //轮播下方小图
        model.addAttribute("topStoread",selFromCache(spreadService.selImgBanners(
                SpreadEnum.JX_SPREAD_INDEX_XT)));

        model.addAttribute("hasStore", shopsNum);
        model.addAttribute("webSite", website);
        model.addAttribute("list_newGoods", JSON.toJSONString(indexNewGoodsVoList));
        model.addAttribute("nzgoods", JSON.toJSONString(menSpreadList));
        model.addAttribute("list_childGoods", JSON.toJSONString(chilrenSpreadList));
        model.addAttribute("nvzgoods", JSON.toJSONString(womanSpreadList));
        model.addAttribute("hotgoods", JSON.toJSONString(sellhotSpreadList));
        model.addAttribute("pantgoods", JSON.toJSONString(kuziSpreadList));
        return "index/py";
    }

    /**
     * 数据转化
     * @return
     */
    public List<IndexGoodsVo> changeGoods(List<ItemSpreadVO> spreadVOList){
        if(spreadVOList == null || spreadVOList.size() == 0){
            return null;
        }
        List<IndexGoodsVo> indexGoodsVoList = new ArrayList<IndexGoodsVo>();
        for(ItemSpreadVO itemSpreadVO : spreadVOList){
            IndexGoodsVo indexGoodsVo = BeanMapper.map(itemSpreadVO, IndexGoodsVo.class);
            if(indexGoodsVo == null){
                continue;
            }
            indexGoodsVo.setParentMarketName(itemSpreadVO.getMarketText());
            indexGoodsVoList.add(indexGoodsVo);
        }
        return indexGoodsVoList;
    }

    /**
     * 看鞋网站首页
     * @return
     */
    @RequestMapping(value = "kxindex" , method = RequestMethod.GET)
    public String kxindex(Model model, HttpServletRequest request) {
        String webSite = "kx";
        Long cid=50011740L;

        //大图
        model.addAttribute("topBanner",selFromCache(spreadService.selImgBanners(SpreadEnum.KX_MAN_DT)));
        //轮播下方小图
        model.addAttribute("topStoread",selFromCache(spreadService.selImgBanners(SpreadEnum.KX_MAN_XT)));
        //热卖
        model.addAttribute("hotsaleGoodslist",selFromCache(spreadService.selItemSpreads(webSite, SpreadEnum.KX_MAN_RM)));

        //全站公告
        model.addAttribute("notices",selFromCache(indexShowService.selNavVOs(SpreadEnum.QZGG)));

        //猜喜欢
        List<LoveGoodsList> loves = new ArrayList<>();
        loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(30,"看鞋",webSite,indexShowService.xie())));
        model.addAttribute("loveGoodslist",loves);

        model.addAttribute("webSite", webSite);
        return "index/shoe";
    }

    /**
     * 常熟站首页
     * @return
     */
    @RequestMapping(value = "csindex4show" , method = RequestMethod.GET)
    public String index4showcs(Model model, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String manOrWoman = "Man";
        String webSite = "cs";
        IndexPageVO page = new IndexPageVO();
        page.setType("M");
        page.setTypeText("男装");
        Long cid = 30L;
        if (cookies != null)
            for (Cookie c : cookies) {
                if ("pageType".equals(c.getName()) && c.getValue().equals("W")) {
                    manOrWoman = "Woman";
                    page.setType("W");
                    page.setTypeText("女装");
                    cid = 16L;
                    break;
                }
            }
        model.addAttribute("page",page);
        //商品数量
        model.addAttribute("userCount",selFromCache(indexShowService.selNumList()));
        //全站公告
        model.addAttribute("notices",selFromCache(indexShowService.selNavVOs(SpreadEnum.QZGG)));
        //轮播下方小图
        model.addAttribute("topStoread",selFromCache(spreadService.selImgBanners(
                manOrWoman.equals("Woman")?SpreadEnum.CS_WOMAN_XT:SpreadEnum.CS_MAN_XT)));

        //大图
        model.addAttribute("topBanner",selFromCache(spreadService.selImgBanners(
                manOrWoman.equals("Woman")?SpreadEnum.CS_WOMAN_DT:SpreadEnum.CS_MAN_DT)));
        //风格类目
        model.addAttribute("styleCateList",indexShowService.selStyleOrElementNav(cid.toString(), SearchCategory.STYLE, webSite));
        //元素类目
        model.addAttribute("elementCateList",indexShowService.selStyleOrElementNav(cid.toString(),SearchCategory.ELEMENT, webSite));
        //热卖
        model.addAttribute("hotsaleGoodslist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.CS_WOMAN_RM:SpreadEnum.CS_MAN_RM)));
        // 风格商品
        model.addAttribute("styleGoodslist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.CS_WOMAN_FG:SpreadEnum.CS_MAN_FG)));
        //元素商品
        model.addAttribute("elementGoodslist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.CS_WOMAN_YS:SpreadEnum.CS_MAN_YS)));
        //推荐档口
        model.addAttribute("recommendShoplist",selFromCache(spreadService.selItemSpreads(webSite,
                manOrWoman.equals("Woman")?SpreadEnum.CS_WOMAN_TJDK:SpreadEnum.CS_MAN_TJDK)));
        //顶部
        //model.addAttribute("topPic",selFromCache(spreadService.selImgBanners(SpreadEnum.INDEX_TOP)));
        //热卖下
//        model.addAttribute("hotBotAdvs",selFromCache(spreadService.selImgBanners(
//                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_HOTBOT:SpreadEnum.MAN_HOTBOT)));
        //风格下方广告
//        model.addAttribute("styleBotAdvs",selFromCache(spreadService.selImgBanners(
//                manOrWoman.equals("Woman")?SpreadEnum.WOMAN_STYLEBOT:SpreadEnum.MAN_STYLEBOT)));
        //猜喜欢
        List<LoveGoodsList> loves=new ArrayList<>();
        if(manOrWoman.equals("Woman")){
            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"上装",webSite,indexShowService.womanUp())));
            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"下装",webSite,
                    indexShowService.womanBottom())));
        }else{
            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"夹克",webSite,
                    indexShowService.manJack())));
            loves.add((LoveGoodsList) selFromCache(indexShowService.loveGoods(5,"休闲裤",webSite,
                    indexShowService.manFree())));
        }
        model.addAttribute("loveGoodslist",loves);
        model.addAttribute("webSite",webSite);

        return "index/cs"+manOrWoman;
    }


    /**
     * 创建缓存
     * @param fromCache
     */
    private Object selFromCache(ObjFromCache fromCache){
//        Object obj=fromCache.selReal();
//        if(fromCache.getType().equals(SpreadCacheException.CacheType.LONG))//如果是从长缓存得到的,需要创建缓存
//            spreadService.createBySync(fromCache);
        return fromCache.selObj();
    }


    /**
     * 二级域名首页
     * @return
     */
    @RequestMapping("/index.html")
    public String domainindex(HttpServletRequest request,Model model) throws ShopFitmentException, CdnException, IOException {
        String url=request.getRequestURL().toString();
        if(!url.contains(".571xz.com")){
//            return "redirect:"+xzSdkClient.getMainHost();
            if(url.contains("127.0.0.1")){
                return hzindex4show(request,model);
            }
            return "index_test";
        }
        url=url.substring(7,url.indexOf(".571xz.com"));
        if("www".equals(url)||"hz".equals(url)||"testwww".equals(url)){
            return hzindex4show(request,model);
        }
        Long shopId=shopBaseService.selShopIdByDomain(url);
        if(shopId==null){
            return "redirect:"+xzSdkClient.getMainHost();
        }
        ShopCdnBO bo=new ShopCdnBO();
        bo.setId(shopId);
        StoreRelation storeRelation=storeRelationService.selRelationById(shopId);
        String webSite=storeRelation.getWebSite();
        model.addAttribute("baseUrl","http://"+webSite+".571xz.com/");
        return shop(bo,null, model);
        //拼baseUrl
    }

    /**
     * 商品点击量
     * @param id
     * @return
     */
    @RequestMapping("itemclicks")
    @ResponseBody
    public JSONObject itemclicks(Long id){
        if(id==null){
            return JsonResponseUtil.success().element("number",-1);
        }
        return JsonResponseUtil.success().element("number",itemBrowerService.addUnrealBrower(id,1).getNumber());
    }

    /**
     * 添加到商品收藏
     * @return
     */
    @RequestMapping("addGoodsFavorite")
    @ResponseBody
    public JSONObject addGoodsFavorite(@Valid ScGoodsBO bo,HttpSession session) {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        cdnService.addItemCollect(ps.getUserId(),bo,2);
        return JsonResponseUtil.success();
    }

    /**
     * 添加到数据包
     * @param bo
     */
    @RequestMapping({"jsonScAddGoods","jsonScAdd"})
    @ResponseBody
    public void jsonScAddGoods(@Valid ScGoodsBO bo,BindingResult result,HttpServletResponse response, HttpSession session) throws JsonErrException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if(result.hasErrors()){
//            throw new JsonErrException("2");//对前台说已经添加过了
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'result':'error','msg':'2'}",response);
            return;
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(cdnService.addItemCollect(ps.getUserId(),bo,1)){
//            return JsonResponseUtil.success();
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'result':'success'}",response);
        }else{
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'result':'error','msg':'2'}",response);
        }
    }

    /**
     * 收藏店铺
     * @param bo
     * @param result
     * @param session
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("jsonStoreCollectAdd")
    @ResponseBody
    public void jsonStoreCollectAdd(@Valid ScStoreBO bo, BindingResult result,HttpServletResponse response,HttpSession session) throws JsonErrException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if(result.hasErrors()){
//            throw new JsonErrException("2");
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'result':'error','msg':'2'}",response);
            return;
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(cdnService.addShopCollect(ps.getUserId(),bo)){
//            return JsonResponseUtil.success();
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'result':'success'}",response);
        }else{
//            throw new JsonErrException("2");
            ResultRetUtil.returnJsonp(bo.getCallback(),"{'result':'error','msg':'2'}",response);
        }
    }

    /**
     * 收藏店铺
     * @param bo
     * @return
     */
    @RequestMapping("shop")
    public String shop(@Valid ShopCdnBO bo, BindingResult result,Model model) throws CdnException, ShopFitmentException, IOException {
        // TODO: 17/3/20 如果分站过来的,跳现在的shopID

        if(bo.getId()>1000000){
            Long shopId=oldStoreNumShowService.selShopId(bo.getId());
            if(shopId!=null){
                return "redirect:/shop.htm?id="+shopId;
            }
        }
        if(result!=null&&result.hasErrors()){
            throw new CdnException(result.getAllErrors().get(0).getDefaultMessage());
        }
        StoreRelation storeRelation=storeRelationService.selRelationById(bo.getId());
        String webSite=storeRelation.getWebSite();
        int shopStatus = shopBaseService.getShopStatus(bo.getId());
        if(shopStatus == 1){
//            return "wa".equals(webSite)?"cdn/wa_shopDown":"cdn/shopDown";
            model.addAttribute("vo",cdnService.shopSimpleVo(bo.getId()));
            if ("kx".equalsIgnoreCase(webSite)) {
                return "cdn/xieShopDown";
            } else {
                return "cdn/shopDown";
            }
        }
        Long pageId=shopDesignService.selPageIdByShopId(bo.getId());
        ContainerVO vo=shopData(bo.getId(),pageId,webSite,model);
        //如果没有装修过
        if(noFitment(vo)){
            shopSearch(bo,result,model);
        }
        model.addAttribute("webSite",webSite);
        return "kx".equals(webSite)?"cdn/xieShop":"cdn/shop";

    }

    private boolean noFitment(ContainerVO vo){
        if(vo.getFitmentAreas()==null||vo.getFitmentAreas().size()!=2
                //上区域
                ||vo.getFitmentAreas().get(0).getAllarea()==null||vo.getFitmentAreas().get(0).getAllarea().size()!=1
                ||vo.getFitmentAreas().get(0).getAllarea().get(0).getModuleType()!=FitmentModuleType.WideImage.value
                //下区域
                ||vo.getFitmentAreas().get(1).getLeftarea()==null||vo.getFitmentAreas().get(1).getLeftarea().size()!=1
                ||vo.getFitmentAreas().get(1).getLeftarea().get(0).getModuleType()!= FitmentModuleType.Category.value
                ||vo.getFitmentAreas().get(1).getRightarea()==null||vo.getFitmentAreas().get(1).getRightarea().size()!=1
                ||vo.getFitmentAreas().get(1).getRightarea().get(0).getModuleType()!=FitmentModuleType.Promote.value){
            return false;
        }
        ItemPromoteModule promote= (ItemPromoteModule) vo.getFitmentAreas().get(1).getRightarea().get(0);
        if(promote.getPromoteType()==1&&promote.getSort()==1&&promote.getItemNum()==16&&promote.getShowPage()==0
                &&promote.getShowTitle()==1&&promote.getShowGoodsNo()==0&&promote.getShowPrice()==1
                &&promote.getTitle().equals("推荐宝贝")&&promote.getRadio()==4&&promote.getFilter()==0){
            //设置都为默认值后，检测大图区域数据是否是默认值
            if (!shopDesignService.defaultModuleValueIs(vo.getFitmentAreas().get(0).getAllarea().get(0).getModuleId())) {
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * 用户自定义页面
     * @return
     */
    @RequestMapping("shop/{shopId}/{pageKey}")
    public String shopDefine(@PathVariable("shopId")Long shopId,@PathVariable("pageKey") Long pageKey,Model model) throws ShopFitmentException, IOException {
        if(shopId==null||pageKey==null){
            return "redirect:"+xzSdkClient.getMainHost();
        }
        StoreRelation storeRelation=storeRelationService.selRelationById(shopId);
        String webSite=storeRelation.getWebSite();
        Long pageId=shopDesignService.selNormalIdByKey(shopId,pageKey);
        shopData(shopId,pageId,webSite,model);
        model.addAttribute("webSite",webSite);
        int shopStatus = shopBaseService.getShopStatus(shopId);
        if(shopStatus == 1){
//            return "wa".equals(webSite)?"cdn/wa_shopDown":"cdn/shopDown";
            if ("kx".equalsIgnoreCase(webSite)) {
                return "cdn/xieShopDown";
            } else {
                return "cdn/shopDown";
            }

        }
//        return "wa".equals(webSite)?"cdn/wa_shop":"cdn/shop";
        return "cdn/shop";
    }

    /**
     * 搜索页面
     * @return
     */
    @RequestMapping("shop/search")
    public String shopSearch(@Valid ShopCdnBO bo,BindingResult result,Model model) throws ShopFitmentException, IOException, CdnException {
        if(result!=null&&result.hasErrors()){
            throw new CdnException(result.getAllErrors().get(0).getDefaultMessage());
        }
        Long pageId=shopDesignService.selSearchIdByShopId(bo.getId());
        StoreRelation storeRelation=storeRelationService.selRelationById(bo.getId());
        String webSite=storeRelation.getWebSite();
        shopData(bo.getId(),pageId,webSite,model);
        ContainerVO containerVO= (ContainerVO) model.asMap().get("container");
        containerVO.getSearchModule().getData().put("catPolymerizations",cdnService.formatCatPoly(bo.getId()));//类目聚合
        ShiguPager<ItemShowBlock> pager;
        Date startDate;
        Date endDate;
        if(bo.getDd()!=null&&bo.getDd()>0){
            Calendar cal=Calendar.getInstance();
            endDate=cal.getTime();
            cal.add(Calendar.DATE,-bo.getDd());
            startDate=cal.getTime();
        }else{
            startDate=DateUtil.stringToDate(bo.getStartDate(),"yyyy-MM-dd");
            endDate=DateUtil.stringToDate(bo.getEndDate(),"yyyy-MM-dd");
        }
        if(bo.getCid()!=null||bo.getScid()!=null){//类目型
            pager=shopForCdnService.searchItemOnsale(bo.getPstring(),bo.getId(),webSite,
                    bo.getCid(),bo.getScid(),bo.getOrder(),startDate,endDate,bo.getPageNo(),bo.getPageSize());
        }else{
            pager=shopForCdnService.searchItemOnsale(bo.getPstring(),bo.getId(),webSite,
                    bo.getBeginPrice(),bo.getEndPrice(),bo.getOrder(),startDate,endDate,bo.getPageNo(),bo.getPageSize());
        }
        containerVO.getSearchModule().getData().put("goodsList",pager);
        containerVO.getSearchModule().getData().put("bo",bo);
        model.addAttribute("container",containerVO);
        model.addAttribute("webSite",webSite);
        //处理搜索条件
        int shopStatus = shopBaseService.getShopStatus(bo.getId());
        if(shopStatus == 1){
//            return "wa".equals(webSite)?"cdn/wa_shopDown":"cdn/shopDown";
            if ("kx".equalsIgnoreCase(webSite)) {
                return "cdn/xieShopDown";
            } else {
                return "cdn/shopDown";
            }
        }
//        return "wa".equals(webSite)?"cdn/wa_shop":"cdn/shop";
        return "cdn/shop";
    }

    /**
     * 包装店铺数据
     * @param shopId
     * @param pageId
     * @param webSite
     * @param model
     * @throws ShopFitmentException
     * @throws IOException
     */
    private ContainerVO shopData(Long shopId,Long pageId,String webSite,Model model) throws ShopFitmentException, IOException {
        ContainerVO containerVO=shopDesignService.selPagePublishedById(pageId,shopDesignService.selShopForModule(shopId,
                webSite));
        model.addAttribute("container",containerVO);
        model.addAttribute("pages",shopDesignService.selAllPage(shopId));
        model.addAttribute("isEditer",false);
        model.addAttribute("vo",cdnService.shopSimpleVo(shopId));
        return containerVO;
    }


    /**
     * 店铺讨论区
     * @return
     */
    @RequestMapping("shopcomment")
    public String shopcomment(ShopCommentBO bo,Model model){
        ShopCommentVO vo=new ShopCommentVO();
        vo.setHasAuth(shopBaseService.shopAuthState(bo.getId()));
        vo.setShopLicenses(shopLicenseService.selShopLicenses(bo.getId()));
        vo.setOther(shopForCdnService.selShopBase(bo.getId()));
        vo.setScoreAvg(shopDiscusService.selScoreAvg(bo.getId()).toString());
        vo.setStoreRelation(storeRelationService.selRelationById(bo.getId()));
        vo.setDiscus(shopDiscusService.selDiscusByShopId(bo.getId(),bo.getPageNo(),bo.getPageSize()));
        vo.setTotalCount(shopDiscusService.countAllDiscusByShopId(bo.getId()));
        model.addAttribute("vo",vo);
        if(vo.getDiscus()!=null)
        model.addAttribute("pageOption",vo.getDiscus().selPageOption(bo.getPageSize()));
        String webSite=vo.getStoreRelation().getWebSite();
//        return !"wa".equals(webSite)?"cdn/shopcomment":"cdn/wa_shopcomment";

        if ("kx".equalsIgnoreCase(webSite)) {
            return "cdn/xieShopcomment";
        } else {
            return "cdn/shopcomment";
        }
    }

    @RequestMapping("smallpic")
    @ResponseBody
    public JSONObject smallPic(Long id){
        return JsonResponseUtil.success().element("pic", shopsItemService.itemImgzipUrl(id));
    }

    @RequestMapping("downloadVideo")
    public void downloadVideo(Long id,HttpServletResponse resp) throws JsonErrException {
       simpleVideoService.downloadVideo(id, resp);
    }

    @RequestMapping("downloadImg")
    public void downloadImg(HttpServletResponse response, String callback, Long goodsId,Integer type, HttpSession session) throws IOException {
        PersonalSession personalSession = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        //如果店铺,不能下载图片
        if(personalSession.getLogshop()!=null){
            ResultRetUtil.returnJsonp(callback,"{'result':'error','msg':'档口不支持代理功能'}",response);
            return ;
        }
        String upflag="imgzip";
        DatuVO bigVo=goodsFileService.datuUrl(goodsId);
        String url = "smallpic.htm?id="+goodsId;//shopsItemService.itemImgzipUrl(goodsId);
//        String url="11";
        String content;
        if (StringUtils.isEmpty(url)) {
            content = "{'result':'error','msg':'图片打包失败'}";
        } else {
            CdnItem cdnItem = showForCdnService.selItemById(goodsId);
            StoreRelation storeRelation = storeRelationService.selRelationById(cdnItem.getShopId());
            ShopBase shopBase = shopBaseService.shopBaseForUpdate(cdnItem.getShopId());
            ItemUpRecordVO record = new ItemUpRecordVO();
            record.setFenUserId(personalSession.getUserId());
            record.setFenUserNick(personalSession.getUserNick());
            record.setFenPrice(cdnItem.getPiPrice());
            record.setSupperPiPrice(cdnItem.getPiPrice());
            record.setSupperPrice(cdnItem.getPrice());
            record.setStatus(0L);
            record.setFenGoodsName(cdnItem.getTitle());
            record.setSupperGoodsId(goodsId);
            record.setSupperStoreId(cdnItem.getShopId());
            record.setSupperMarketId(cdnItem.getMarketId());
            record.setSupperNumiid(cdnItem.getTbNumIid());
            record.setCid(cdnItem.getCid());
            if (!cdnItem.getImgUrl().isEmpty()) {
                String img = cdnItem.getImgUrl().get(0);
                record.setSupperImage(img);
                record.setFenImage(img);
            }
            record.setFlag(upflag);
            record.setSupperGoodsName(cdnItem.getTitle());
            record.setWebSite(cdnItem.getWebSite());
            record.setDaiTime(DateUtil.dateToString(new Date(),DateUtil.patternD));
            record.setFenNumiid(cdnItem.getTbNumIid());
            if (storeRelation != null) {
                record.setSupperServers("退现金,包换款");
                record.setSupperStorenum(storeRelation.getStoreNum());
                record.setSupperImww(storeRelation.getImWw());
                record.setSupperTelephone(storeRelation.getTelephone());
                record.setSupperTaobaoUrl(shopBase.getTaobaoUrl());
                record.setSupperMarket(storeRelation.getMarketName());
                record.setSupperStoreName(shopBase.getShopName());
                record.setSupperQq(storeRelation.getImQq());
            }
            itemUpRecordService.addItemUpRecord(record);
            content = "{'result':'success','msg':'成功','sourceHref':'" + url + "'";
            if(bigVo!=null){
                content+=",'bigPicSource':'"+bigVo.getUrl()+"'";
                if(StringUtils.isNotEmpty(bigVo.getPwd())){//是否有密码
                    content+=",'extractPsw':'"+bigVo.getPwd()+"'";
                }
            }
            content+="}";
        }
        ResultRetUtil.returnJsonp(callback,content,response);
    }

    /**
     * 著作权
     * @param model
     * @return
     */
    @RequestMapping("shopIconCopyright")
    public String shopIconCopyright(Integer page,Model model){
        model.addAttribute("webSite","hz");
        ShiguPager<ShopIconCopyrightVO> pager=cdnService.shopCopyrights(page,100);
        model.addAttribute("pageOption",pager.selPageOption(100));
        model.addAttribute("copyrightList",pager.getContent());
        return "activity/shopIconCopyright";
    }

    /**
     * 大图下载宣传页面
     * @return
     */
    @RequestMapping("bigPicExplain")
    public String bigPicExplain(){
        return "static/bigPicExplain";
    }

    //===================================================20170527张峰=======================================================

    /**
     * 商品详情
     * @param id
     * @param model
     * @return
     * @throws CdnException
     * @throws IOException
     * @throws TemplateException
     */
    @RequestMapping("item")
    public String item(Long id, Model model) throws Main4Exception, IOException, TemplateException {
        CdnGoodsInfoVO goods=cdnService.cdnGoodsInfo(id);
        if(StringUtils.isEmpty(goods.getColorsMeta())||"[]".equals(goods.getColorsMeta())){
            goods.setColorsMeta("[{\"text\":\"图片色\",\"imgSrc\":\"\"}]");
        }
        if(StringUtils.isEmpty(goods.getSizesMeta())||"[]".equals(goods.getSizesMeta())){
            goods.setSizesMeta("[\"均码\"]");
        }
        if ("kx".equalsIgnoreCase(goods.getWebSite())) {
            return oldItemForKx(id,model);
        }
        CdnShopInfoVO shop=cdnService.cdnShopInfo(goods.getShopId());
        String dzhtml=cdnService.bannerHtml(goods.getShopId(),goods.getWebSite());
        List<CdnShopCatVO> cats=cdnService.cdnShopCat(shop.getShopId());
        List<CdnSimpleGoodsVO> see=cdnService.cdnSimpleGoods(goods.getShopId(), goods.getWebSite());
        if (shop.getType() == null || shop.getType() != 1) {
            goods.setTbGoodsId(null);
        }
        model.addAttribute("webSite",goods.getWebSite());
        model.addAttribute("shopInfo",shop);
        model.addAttribute("userShopHdHtml",dzhtml);
        model.addAttribute("goodsInfo",goods);
        model.addAttribute("tjGoodsList",see);
        model.addAttribute("shopCats",cats);
        return "cdn/item";
    }

    /**
     * 获取商品详情页左侧广告  随机显示9条
     * @param goodsId 当前访问商品Id
     * @return
     */
    @RequestMapping("/itemGoat")
    @ResponseBody
    public Object itemGoat (HttpServletRequest request,Long goodsId) throws JsonErrException{
        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = getCidAndWebsite(goodsId);
        boolean instanOfWoman = itemCatService.instanOfWoman(itemGoatCidAndWebsiteVO.getCid());
        String website = itemGoatCidAndWebsiteVO.getWebsite();

        Object objFormCache = null;
        if(instanOfWoman){//父级或父父级cid=16的为女装
            objFormCache = selFromCache(spreadService.selItemSpreads(website,SpreadEnum.ITEM_GOAT_WOMAN));
        }else{
            objFormCache = selFromCache(spreadService.selItemSpreads(website,SpreadEnum.ITEM_GOAT_MAN));
        }
        List<ItemGoatVO> goatLists = ItemGoatVO.copyListFromCache(objFormCache);
        Set<ItemGoatVO>  goatList = new HashSet<>(goatLists);
        Collections.shuffle(goatLists);//乱序
        return JsonResponseUtil.success().element("goatList",goatList);
    }

    /**
     * 获取商品详情页底部广告  固定显示5条
     * @param goodsId 当前访问商品Id
     * @return
     */
    @RequestMapping("/itemBottomGoat")
    @ResponseBody
    public Object itemBottomGoat (HttpServletRequest request,Long goodsId)throws JsonErrException{
        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = getCidAndWebsite(goodsId);
        boolean instanOfWoman = itemCatService.instanOfWoman(itemGoatCidAndWebsiteVO.getCid());
        String website = itemGoatCidAndWebsiteVO.getWebsite();

        Object objFormCache = null;
        if(instanOfWoman){//父级或父父级cid=16的为女装
            objFormCache = selFromCache(spreadService.selItemSpreads(website,SpreadEnum.ITEM_BOTTOM_GOAT_WOMAN));
        }else{
            objFormCache = selFromCache(spreadService.selItemSpreads(website,SpreadEnum.ITEM_BOTTOM_GOAT_MAN));
        }
        List<ItemGoatVO> goatList = ItemGoatVO.copyListFromCache(objFormCache);
        return JsonResponseUtil.success().element("goatList",goatList);
    }

    private ItemGoatCidAndWebsiteVO getCidAndWebsite(Long goodsId)throws JsonErrException{
        ItemGoatCidAndWebsiteVO itemGoatCidAndWebsiteVO = null;
        try {
            itemGoatCidAndWebsiteVO = itemCatService.getItemCid(goodsId);
        } catch (ItemException e) {
            throw new JsonErrException(e.getMessage());
        }finally {
            if (itemGoatCidAndWebsiteVO == null ||
                    itemGoatCidAndWebsiteVO.getCid() == null ||
                    StringUtil.isNull(itemGoatCidAndWebsiteVO.getWebsite())) {
                throw new JsonErrException("未查询到分站信息");
            }
        }
        return  itemGoatCidAndWebsiteVO;
    }

    public String oldItemForKx(Long id, Model model) throws CdnException, IOException, TemplateException {
        //如果东北商品,用东北的模板
        ItemShowVO itemShowVO=new ItemShowVO();
        itemShowVO.setItemId(id);
        CdnItem cdnItem=showForCdnService.selItemById(id);
        itemShowVO.setOnsale(cdnItem!=null&&cdnItem.getOnsale());
        if(cdnItem==null){//已经下架
            cdnItem=showForCdnService.selItemInstockById(id);
        }
        if(cdnItem==null){//商品不存在
            throw new CdnException("商品不存在");
        }
        //店招
        model.addAttribute("navCon",cdnService.bannerHtml(cdnItem.getShopId(),cdnItem.getWebSite()));
        // 商品详情懒加载
        if(cdnItem.getDescription()!=null)
            cdnItem.setDescription(HtmlImgsLazyLoad.replaceLazyLoad(cdnItem.getDescription()).replace("<script ","")
                    .replace("<script>","")
                    .replace("</script>",""));
        itemShowVO.setCdnItem(cdnItem);
//        itemShowVO.setClicks(itemBrowerService.selItemBrower(id));
        itemShowVO.setShopCats(shopForCdnService.selShopCatsById(cdnItem.getShopId()));
        Long starNum=shopForCdnService.selShopStarById(cdnItem.getShopId());
        starNum=starNum==null?0:    starNum;
        itemShowVO.setStarNum(starNum);
        itemShowVO.setStoreRelation(storeRelationService.selRelationById(cdnItem.getShopId()));
        itemShowVO.setTags(showForCdnService.selItemLicenses(id, cdnItem.getShopId()));
        itemShowVO.setDomain(shopBaseService.selDomain(cdnItem.getShopId()));
        itemShowVO.setOther(shopForCdnService.selShopBase(cdnItem.getShopId()));
        model.addAttribute("vo",itemShowVO);
        ItemBO bo=new ItemBO();
        bo.setId(id);
        model.addAttribute("bo",bo);
        model.addAttribute("webSite",itemShowVO.getCdnItem().getWebSite());
        model.addAttribute("hasYt",goodsFileService.hasDatu(id)+"");
//        return "wa".equals(cdnItem.getWebSite())?"cdn/wa_item":"cdn/item";
        return "cdn/xieItem";
    }

    /**
     * 档口今日新品
     */
    @RequestMapping("newGoods")
    public String newGoods(Long shopId,String webSite,Model model){
        model.addAttribute("newGoodsList",cdnService.selShopNew(shopId,webSite,5));
        return "cdn/item_shopnew";
    }

    @RequestMapping("getShopCollection")
    public void getShopCollection(HttpSession session,HttpServletResponse response,String webSite,String callback) throws IOException {
        PersonalSession ps = (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        List<CdnCollectShopVO> vos=cdnService.colloectShop(ps.getUserId(), webSite);
        JSONObject obj=new JSONObject();
        obj.put("result","success");
        obj.put("shops",vos);
        ResultRetUtil.returnJsonp(callback,obj.toString(),response);
    }
    @RequestMapping("loginWindow")
    public String loginWindow(){
        return "cdn/loginWindow";
    }

    @RequestMapping("daifaIndex")
    public String daifaIndex(Model model){
        model.addAttribute("webSite","hz");
        return "trade/daifaIndex";
    }
}
