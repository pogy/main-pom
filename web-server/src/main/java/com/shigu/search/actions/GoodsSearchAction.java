package com.shigu.search.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.storeservices.SearchCategoryService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.search.bo.NewGoodsBO;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.services.TodayNewGoodsService;
import com.shigu.search.vo.GoodsInSearch;
import com.shigu.search.vo.SearchVO;
import com.shigu.tools.EncodeParamter;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.tools.KeyWordsUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 商品搜索
 * Created by zhaohongbo on 17/4/5.
 */
@Controller
public class GoodsSearchAction {

    @Autowired
    TodayNewGoodsService todayNewGoodsService;
    @Autowired
    CategoryInSearchService categoryInSearchService;
    @Autowired
    GoodsSearchService goodsSearchService;

    @Autowired
    StoreSelFromEsService storeSelFromEsService;
    @Autowired
    SearchCategoryService searchCategoryService;

    @Autowired
    OssIO ossIO;

    @Autowired
    RedisIO redisIO;

    private static String SHIGU_ITEM_SEARCH_KEYWORD = "shigu_item_search_keyword";

    /**
     * 图搜
     * @return
     */
    @RequestMapping("picSearch")
    public String picSearch(String webSite,Model model){
        if (webSite == null) {
            webSite="hz";
        }
        model.addAttribute("webSite",webSite);
        return "xzPage/picSearch";
    }

    /**
     * 上传图搜用的图片
     * @param file
     * @return
     * @throws JsonErrException
     */
    @RequestMapping("uploadGoodsImg")
    @ResponseBody
    public JSONObject uploadGoodsImg(@RequestParam(value = "file", required = false) MultipartFile file) throws JsonErrException {
        String url="";
        try {
            url=ossIO.uploadFile(file.getBytes(),"picsearch/"+System.currentTimeMillis() + ".jpg");
//            url=fileUploadService.fileUpload("item/"+shopSession.getShopId()+"/"+System.currentTimeMillis() + ".jpg",file.getBytes());
        } catch (IOException e) {
            throw new JsonErrException("").addErrMap("err","图片数据读取失败");
        }
        return JsonResponseUtil.success().element("imgurl",url);
    }

    /**
     * 图搜
     * data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAoHBwgHBgoICAgLCgoLDhgQDg0NDh0VFhEYIx8lJCIfIiEmKzcvJik0KSEiMEExNDk7Pj4 JS5ESUM8SDc9Pjv/2wBDAQoLCw4NDhwQEBw7KCIoOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozv/wAARCAC1AI4DASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4 Tl5ufo6erx8vP09fb3 Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3 Pn6/9oADAMBAAIRAxEAPwDxmiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP//Z
     data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAoHBwgHBgoICAgLCgoLDhgQDg0NDh0VFhEYIx8lJCIfIiEmKzcvJik0KSEiMEExNDk7Pj4 JS5ESUM8SDc9Pjv/2wBDAQoLCw4NDhwQEBw7KCIoOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozv/wAARCACVAHgDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4 Tl5ufo6erx8vP09fb3 Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3 Pn6/9oADAMBAAIRAxEAPwDxmiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA//9k=
     * @return
     */
    @RequestMapping("goodsUrlSearch")
    @ResponseBody
    public JSONObject goodsUrlSearch(String imgAdress,String webSite,String baseCode) throws JsonErrException {
        if (webSite == null) {
            webSite="hz";
        }
        JSONObject result=JsonResponseUtil.success();
        try {
            if(baseCode!=null&&imgAdress==null){
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] data=decoder.decodeBuffer(baseCode);
                imgAdress=ossIO.uploadFile(data,"picsearch/"+System.currentTimeMillis() + ".jpg");
            }
            result.element("imgurl",imgAdress);
            result.element("goodslist",JSONArray.fromObject(goodsSearchService.searchByPic(imgAdress,webSite)));
        } catch (IOException e) {
            throw new JsonErrException("搜索接口调用异常");
        }
        return result;
    }
    /**
     * 新品发布
     *
     * @return
     */
    @RequestMapping("newgoods")
    public String newgoods(NewGoodsBO bo, Model model) {
        bo.setRows(40);
        if (bo.getCid() == null) {
            bo.setCid(1L);
        }
        if (bo.getWebSite() == null) {
            bo.setWebSite("hz");
        }
        if (bo.getKeyword() != null) {
            bo.setKeyword(EncodeParamter.iosToUtf8(bo.getKeyword()));
        }
        model.addAttribute("iconCateNav", todayNewGoodsService.selIconCateNav(bo.getWebSite()));
        if (bo.getCid() != null) {
            model.addAttribute("styleCateNavs", categoryInSearchService.selSubCates(todayNewGoodsService.selRealCid(bo.getCid()), SearchCategory.STYLE,bo.getWebSite()));
        }
        ShiguPager<GoodsInSearch> pager = todayNewGoodsService.selGoodsNew(bo);
        //极限词过滤
        if (pager.getContent() != null) {
            pager.getContent().forEach(goodsInSearch -> {
                goodsInSearch.setTitle(KeyWordsUtil.duleKeyWords(goodsInSearch.getTitle()));
                goodsInSearch.setHighLightTitle(KeyWordsUtil.duleKeyWords(goodsInSearch.getHighLightTitle()));
            });
        }

        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        model.addAttribute("goodslist", pager.getContent() == null ? new ArrayList<>() : pager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("webSite", bo.getWebSite());
        model.addAttribute("catemenu",searchCategoryService.getMarketCateShow(bo.getWebSite()));
        return "search/newgoods";
    }

    /**
     * 搜索
     *
     * @return
     */
    @RequestMapping("{website}search")
    public String hzsearch(@PathVariable("website") String website, SearchBO bo, Model model) {
        bo.setWebSite(website);
        if(StringUtils.isEmpty(website)){
            bo.setWebSite("hz");
        }
        bo.setRows(40);
        if (bo.getKeyword() != null) {
            bo.setKeyword(bo.getKeyword().trim());
            bo.setKeyword(EncodeParamter.iosToUtf8(bo.getKeyword()));
        }
        model.addAttribute("query", bo);

        //排序
        if (bo.getSort() == null) {
            bo.setSort("comp");
        }
        SearchOrderBy orderBy = SearchOrderBy.valueIs(bo.getSort());
        if (orderBy == null) {
            orderBy = SearchOrderBy.COMMON;
        }
        SearchVO vo = goodsSearchService.search(bo, orderBy, true);

        ShiguPager<GoodsInSearch> pager = vo.getSearchData();
        maxTotalSizeOrPage(pager, bo.getRows());
        //得到聚合后的结果
//        CateNavsInSearch cateNavsInSearch=goodsSearchService.selCateAfterAggs(bo);
//        model.addAttribute("markets", goodsSearchService.aggOneCate(categoryInSearchService.selMarkets(bo.getWebSite()),
//                vo.getMarkets()));
        model.addAttribute("markets", categoryInSearchService.selMarkets(website));

        //查顶级类目
//        model.addAttribute("cates", goodsSearchService.aggOneCate(categoryInSearchService.selCates(bo.getWebSite()),
//                vo.getParentCats()));
        model.addAttribute("cates", categoryInSearchService.selCatesForGoods(bo.getWebSite()));

        //查匹配店铺
        if (bo.getPage() == 1) {
            model.addAttribute("topShopList", storeSelFromEsService.selByShopNum(bo.getKeyword(),bo.getWebSite()));
        }
        //极限词过滤
        if (pager.getContent() != null) {
            pager.getContent().forEach(goodsInSearch -> {
                goodsInSearch.setTitle(KeyWordsUtil.duleKeyWords(goodsInSearch.getTitle()));
                goodsInSearch.setHighLightTitle(KeyWordsUtil.duleKeyWords(goodsInSearch.getHighLightTitle()));
            });
        }

        List<GoodsInSearch> goodsList = pager.getContent();
        if (bo.getPage() == 1 && bo.getCid() == null && bo.getPid() == null){
            Set<String> keywordSet = new HashSet<>();
            for (GoodsInSearch goods : goodsList) {
                Pattern p = Pattern.compile("\\<em>(.*?)\\</em>");//正则表达式，取=和|之间的字符串，不包括=和|
                if(!StringUtil.isNull(goods.getHighLightTitle()) && goods.getHighLightTitle().contains("<em>")) {
                    Matcher m = p.matcher(goods.getHighLightTitle());
                    while (m.find()) {
                        keywordSet.add(m.group(1));
                    }
                }
            }
            for (String keyword : keywordSet) {
                redisIO.rpush(SHIGU_ITEM_SEARCH_KEYWORD,keyword);
            }
        }
        model.addAttribute("goodslist", goodsList);
        model.addAttribute("tjGoodsList", goodsSearchService.selTj(bo.getWebSite(), 1, bo.getPid()));
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        //查顶部导航
//        SearchNav searchNav=goodsSearchService.categoryInSearch(bo);
//        SearchNav searchNav=new SearchNav();
//        searchNav.setGoodsCount(pager.getTotalCount());
        model.addAttribute("goodsCount", pager.getTotalCount());
        //搜索路径
//        model.addAttribute("cateNav",searchNav);
        model.addAttribute("totalPage",  pager.getTotalPages()>100?100:pager.getTotalPages());
        model.addAttribute("webSite", bo.getWebSite());
        model.addAttribute("catemenu",searchCategoryService.getMarketCateShow(bo.getWebSite()));
        if ("kx".equalsIgnoreCase(website)) {
            return "xieSearch/search";
        } else  {
            return "search/search";
        }

    }

    /**
     * 商品库
     *
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("{website}goods")
    public String hzgoods(SearchBO bo,@PathVariable("website")String website, Model model) {
        bo.setWebSite(website);
        if (StringUtils.isEmpty(website) || StringUtils.equals("new", website)) {
            bo.setWebSite("hz");
        }
        bo.setRows(56);
        if (bo.getPid() == null) {
            if ("kx".equalsIgnoreCase(website)) {//看鞋网的类目
                bo.setPid(50011740L);
            }else if ("zl".equalsIgnoreCase(website)){
                bo.setPid(50008165L);
            }else if ("wa".equalsIgnoreCase(website)){
                bo.setPid(1625L);
            }else if("qz".equalsIgnoreCase(website)){
                bo.setPid(50011740L);
            }else if("cz".equalsIgnoreCase(website)){
                bo.setPid(16L);
            }else{
                bo.setPid(30L);
            }
        }
        if (bo.getKeyword() != null) {
            bo.setKeyword(EncodeParamter.iosToUtf8(bo.getKeyword()));
        }

        model.addAttribute("query", bo);
        //排序
        if (bo.getSort() == null) {
            bo.setSort("comp");
        }
        SearchOrderBy orderBy = SearchOrderBy.valueIs(bo.getSort());
        if (orderBy == null) {
            orderBy = SearchOrderBy.GOODS_COMMON;
        }
        // 依据来源 from 匹配搜索排序表达式
        bo.setFrom("goods");
        //带聚合的结果
        ShiguPager<GoodsInSearch> pager = goodsSearchService.search(bo, orderBy, false).getSearchData();
        if(pager==null){
             pager=new ShiguPager<GoodsInSearch>();
        }
        //极限词过滤
        if (pager.getContent() != null&&pager.getContent().size()>0) {
            pager.getContent().forEach(goodsInSearch -> {
                goodsInSearch.setTitle(KeyWordsUtil.duleKeyWords(goodsInSearch.getTitle()));
                goodsInSearch.setHighLightTitle(KeyWordsUtil.duleKeyWords(goodsInSearch.getHighLightTitle()));
            });
        }
        maxTotalSizeOrPage(pager, bo.getRows());
        //处理市场
        model.addAttribute("markets", categoryInSearchService.selSubCates(bo.getPid().toString(), SearchCategory.MARKET, website));
        //查顶级类目
        model.addAttribute("navCate", categoryInSearchService.selCatesForGoods(bo.getWebSite()));
        if (bo.getPid() != null) {//分类
            model.addAttribute("cates", categoryInSearchService.selSubCates(bo.getPid().toString(),
                    SearchCategory.CATEGORY, website)
            );
            model.addAttribute("styles", categoryInSearchService.selSubCates(bo.getPid().toString(), SearchCategory.STYLE, website));
            model.addAttribute("elements", categoryInSearchService.selSubCates(bo.getPid().toString(), SearchCategory.ELEMENT, website));
//            model.addAttribute("custom", categoryInSearchService.selSubCates(bo.getPid().toString(), SearchCategory.CUSTOM, website));
        }
        //查匹配店铺
        model.addAttribute("topShopList", storeSelFromEsService.selByShopNum(bo.getKeyword(),bo.getWebSite()));

        model.addAttribute("goodslist", pager.getContent());
        model.addAttribute("tjGoodsList", goodsSearchService.selTj(bo.getWebSite(), 0, bo.getPid()));
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        //查顶部导航
//        SearchNav searchNav = goodsSearchService.categoryInSearch(bo);
//        SearchNav searchNav=new SearchNav();
//        searchNav.setGoodsCount(pager.getTotalCount());
        model.addAttribute("goodsCount", pager.getTotalCount());
//        model.addAttribute("cateNav", searchNav);
        //搜索路径
        model.addAttribute("totalPage", pager.getTotalPages());
        model.addAttribute("webSite", bo.getWebSite());
        model.addAttribute("catemenu",searchCategoryService.getMarketCateShow(bo.getWebSite()));
        if(website.equals("hz")&&bo.getPid().equals(30L)){
            model.addAttribute("goodsGoats", goodsSearchService.selBottomGoat(website).stream().peek(bottomGoodsGoat -> bottomGoodsGoat.setTitle(KeyWordsUtil.duleKeyWords(bottomGoodsGoat.getTitle()))).collect(Collectors.toList()));
        }else if(website.equals("cz")&&bo.getPid().equals(16L)){
            model.addAttribute("goodsGoats", goodsSearchService.selCzBottomGoat(website).stream().peek(bottomGoodsGoat -> bottomGoodsGoat.setTitle(KeyWordsUtil.duleKeyWords(bottomGoodsGoat.getTitle()))).collect(Collectors.toList()));
        }

        if ("kx".equalsIgnoreCase(website)) {
            return "xieSearch/goods";
        } else {
            return "search/goods";
        }

    }

    private void maxTotalSizeOrPage(ShiguPager pager, int pageSize) {
        if (pager.getTotalCount() > 5000) {
            pager.setTotalCount(5000);
        }
        pager.calPages(pager.getTotalCount(), pageSize);
        if (pager.getTotalPages() > 100) {
            pager.setTotalPages(100);
            pager.setTotalCount(100 * pageSize);
        }
    }

}
