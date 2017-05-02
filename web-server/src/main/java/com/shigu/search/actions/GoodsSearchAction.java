package com.shigu.search.actions;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.item.enums.SearchCategory;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.services.ItemSearchService;
import com.shigu.main4.tools.OssIO;
import com.shigu.search.bo.NewGoodsBO;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.services.CategoryInSearchService;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.services.StoreSelFromEsService;
import com.shigu.search.services.TodayNewGoodsService;
import com.shigu.search.vo.GoodsInSearch;
import com.shigu.search.vo.SearchNav;
import com.shigu.search.vo.SearchVO;
import com.shigu.tools.EncodeParamter;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
    OssIO ossIO;

    /**
     * 图搜
     * @return
     */
    @RequestMapping("picSearch")
    public String picSearch(Model model){
        model.addAttribute("webSite","hz");
        return "search/picSearch";
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
     * @return
     */
    @RequestMapping("goodsUrlSearch")
    @ResponseBody
    public JSONObject goodsUrlSearch(String imgAdress) throws JsonErrException {
        JSONObject result=JsonResponseUtil.success();
        try {
            result.element("imgurl",imgAdress);
            result.element("goodslist",JSONArray.fromObject(goodsSearchService.searchByPic(imgAdress,"hz")));
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
        if (bo.getKeyword() != null)
            bo.setKeyword(EncodeParamter.iosToUtf8(bo.getKeyword()));
        model.addAttribute("iconCateNav", todayNewGoodsService.selIconCateNav());
        if (bo.getCid() != null) {
            model.addAttribute("styleCateNavs", categoryInSearchService.selSubCates(todayNewGoodsService.selRealCid(bo.getCid()), SearchCategory.STYLE));
        }
        ShiguPager<GoodsInSearch> pager = todayNewGoodsService.selGoodsNew(bo);
        model.addAttribute("pageOption", pager.selPageOption(bo.getRows()));
        model.addAttribute("goodslist", pager.getContent() == null ? new ArrayList<>() : pager.getContent());
        model.addAttribute("query", bo);
        model.addAttribute("webSite", bo.getWebSite());
        return "search/newgoods";
    }

    /**
     * 搜索
     *
     * @return
     */
    @RequestMapping("hzsearch")
    public String hzsearch(SearchBO bo, Model model) {
        bo.setRows(40);
        if (bo.getKeyword() != null)
            bo.setKeyword(EncodeParamter.iosToUtf8(bo.getKeyword()));
        model.addAttribute("query", bo);

        //排序
        SearchOrderBy orderBy;
        if (bo.getSort() == null) {
            bo.setSort("comp");
        }
        if (bo.getSort().equals("xp")) {
            orderBy = SearchOrderBy.NEW;
        } else if (bo.getSort().equals("comp")) {
            orderBy = SearchOrderBy.GOODS_COMMON;
        } else if (bo.getSort().equals("price-asc")) {
            orderBy = SearchOrderBy.PRICEUP;
        } else if (bo.getSort().equals("price-desc")) {
            orderBy = SearchOrderBy.PRICEDOWN;
        } else {
            orderBy = SearchOrderBy.NEW;
        }
        SearchVO vo = goodsSearchService.search(bo, orderBy, true);

        ShiguPager<GoodsInSearch> pager = vo.getSearchData();
        //得到聚合后的结果
//        CateNavsInSearch cateNavsInSearch=goodsSearchService.selCateAfterAggs(bo);
        model.addAttribute("markets", goodsSearchService.aggOneCate(categoryInSearchService.selMarkets(),
                vo.getMarkets()));
        //查顶级类目
        model.addAttribute("cates", goodsSearchService.aggOneCate(categoryInSearchService.selCates(),
                vo.getParentCats()));
        //查匹配店铺
        if (bo.getPage() == 1) {
            model.addAttribute("topShopList", storeSelFromEsService.selByShopNum(bo.getKeyword()));
        }
        model.addAttribute("goodslist", pager.getContent() == null ? Collections.emptyList() : pager.getContent());
        model.addAttribute("tjGoodsList", goodsSearchService.selTj(bo.getWebSite(), 1, bo.getPid()));
        model.addAttribute("pageOption", selPageOption(pager.getTotalCount(), bo.getRows(), pager.getNumber()));
        //查顶部导航
//        SearchNav searchNav=goodsSearchService.categoryInSearch(bo);
//        SearchNav searchNav=new SearchNav();
//        searchNav.setGoodsCount(pager.getTotalCount());
        model.addAttribute("goodsCount", pager.getTotalCount());
        //搜索路径
//        model.addAttribute("cateNav",searchNav);
        model.addAttribute("totalPage", pager.getTotalPages());
        model.addAttribute("webSite", bo.getWebSite());
        return "search/search";
    }

    /**
     * 商品库
     *
     * @param bo
     * @param model
     * @return
     */
    @RequestMapping("hzgoods")
    public String hzgoods(SearchBO bo, Model model) {
        bo.setRows(56);
        if (bo.getPid() == null) {
            bo.setPid(30L);
        }
        if (bo.getKeyword() != null)
            bo.setKeyword(EncodeParamter.iosToUtf8(bo.getKeyword()));

        model.addAttribute("query", bo);
        //排序
        SearchOrderBy orderBy;
        if (bo.getSort() == null) {
            bo.setSort("comp");
        }
        if (bo.getSort().equals("xp")) {
            orderBy = SearchOrderBy.NEW;
        } else if (bo.getSort().equals("comp")) {
            orderBy = SearchOrderBy.GOODS_COMMON;
        } else if (bo.getSort().equals("price-asc")) {
            orderBy = SearchOrderBy.PRICEUP;
        } else if (bo.getSort().equals("price-desc")) {
            orderBy = SearchOrderBy.PRICEDOWN;
        } else {
            orderBy = SearchOrderBy.GOODS_COMMON;
        }
        //带聚合的结果
        ShiguPager<GoodsInSearch> pager = goodsSearchService.search(bo, orderBy, false).getSearchData();
        //处理市场
        model.addAttribute("markets", categoryInSearchService.selSubCates(bo.getPid().toString(), SearchCategory.MARKET));
        //查顶级类目
        model.addAttribute("navCate", categoryInSearchService.selCatesForGoods());
        if (bo.getPid() != null) {
            model.addAttribute("cates", categoryInSearchService.selSubCates(bo.getPid().toString(),
                    SearchCategory.CATEGORY)
            );
            model.addAttribute("styles", categoryInSearchService.selSubCates(bo.getPid().toString(), SearchCategory.STYLE));
            model.addAttribute("elements", categoryInSearchService.selSubCates(bo.getPid().toString(), SearchCategory.ELEMENT));
        }
        //查匹配店铺
        model.addAttribute("topShopList", storeSelFromEsService.selByShopNum(bo.getKeyword()));

        model.addAttribute("goodslist", pager.getContent() == null ? new ArrayList<>() : pager.getContent());
        model.addAttribute("tjGoodsList", goodsSearchService.selTj(bo.getWebSite(), 0, bo.getPid()));
        model.addAttribute("pageOption", selPageOption(pager.getTotalCount(), bo.getRows(), pager.getNumber()));
        //查顶部导航
        SearchNav searchNav = goodsSearchService.categoryInSearch(bo);
//        SearchNav searchNav=new SearchNav();
        searchNav.setGoodsCount(pager.getTotalCount());
        model.addAttribute("goodsCount", pager.getTotalCount());
        model.addAttribute("cateNav", searchNav);
        //搜索路径
        model.addAttribute("totalPage", pager.getTotalPages());
        model.addAttribute("webSite", bo.getWebSite());
        return "search/goods";
    }

    /**
     * 查红牛活动的商品数据
     *
     * @param ids
     * @return
     */
    @RequestMapping("redBull")
    @ResponseBody
    public JSONObject redBull(String ids) {
        JSONArray arr = JSONArray.fromObject(goodsSearchService.selRedBull(ids));
        return JsonResponseUtil.success().element("goodsList", arr);
    }

    /**
     * 清除红牛广告
     *
     * @return
     */
    @RequestMapping("clearBull")
    @ResponseBody
    public JSONObject clearBull() {
        goodsSearchService.clearReedBull();
        return JsonResponseUtil.success();
    }

    /**
     * 拿到翻页信息
     *
     * @return
     */
    public String selPageOption(int total, int size, int number) {
        int maxTotal = ItemSearchService.MAX_PAGE * size;
        return (total > maxTotal ? maxTotal : total) + "," + size + "," + number;
    }

    /**
     * 计算页数
     *
     * @param total
     * @param size
     * @return
     */
    public Integer calTotalPage(int total, int size) {
        int page = total / size;
        if (total % size > 0) {
            page++;
        }
        return page > ItemSearchService.MAX_PAGE ? ItemSearchService.MAX_PAGE : page;
    }
}
