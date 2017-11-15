package com.shigu.phone.baseservices;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.openJar.beans.app.AppGoodsBlock;
import com.openJar.beans.app.AppItemKv;
import com.openJar.exceptions.OpenException;
import com.opentae.data.mall.beans.ShiguGoodsCollect;
import com.opentae.data.mall.beans.ShiguOuterMarket;
import com.opentae.data.mall.interfaces.ShiguGoodsCollectMapper;
import com.opentae.data.mall.interfaces.ShiguOuterMarketMapper;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.services.CdnService;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.SearchOrderBy;
import com.shigu.main4.item.vo.SearchItem;
import com.shigu.main4.newcdn.vo.CdnGoodsInfoVO;
import com.shigu.main4.newcdn.vo.CdnShopInfoVO;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.webvo.ItemCollectInfoVO;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.phone.api.enums.ImgFormatEnum;
import com.shigu.phone.apps.utils.ImgUtils;
import com.shigu.phone.basevo.ItemSearchVO;
import com.shigu.phone.basevo.OneItemVO;
import com.shigu.search.bo.SearchBO;
import com.shigu.search.bo.WapSearchBO;
import com.shigu.search.services.GoodsSearchService;
import com.shigu.search.services.GoodsSelFromEsService;
import com.shigu.search.vo.GoodsInSearch;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名：PhoneGoodsSearchService
 * 类路径：com.shigu.phone.apps.baseservices.PhoneGoodsSearchService
 * 创建者：王浩翔
 * 创建时间：2017-08-29 14:35
 * 项目：main-pom
 * 描述：移动端商品搜索service
 */
@Service
public class BasePhoneGoodsSearchService {

    @Autowired
    private GoodsSearchService goodsSearchService;

    @Autowired
    private CdnService cdnService;

    @Autowired
    private UserCollectService userCollectService;
    @Autowired
    private ShopForCdnService shopForCdnService;
    @Autowired
    private GoodsSelFromEsService goodsSelFromEsService;

    @Autowired
    private OssIO ossIO;

    @Autowired
    private ShiguOuterMarketMapper shiguOuterMarketMapper;

    @Autowired
    private ShiguGoodsCollectMapper goodsCollectMapper;

    /**
     * 移动端商品搜索
     *
     * @return
     */
    public ItemSearchVO itemSearch(WapSearchBO bo, String orderBy) throws OpenException {
        if (bo.getMid() != null) {
            parseMid(bo);
        }

        ItemSearchVO vo = new ItemSearchVO();
        ShiguPager<GoodsInSearch> result = goodsSearchService.search(bo, SearchOrderBy.valueIs(orderBy), false).getSearchData();
        vo.setTotal(result.getTotalCount());
        vo.setHasNext(result.getNumber() < result.getTotalPages());
        vo.setItems(result.getContent().stream()
                .filter(item-> item!=null && !StringUtil.isNull(item.getPiprice()))
                .map(o -> {
            AppGoodsBlock appGoodsBlock = BeanMapper.map(o, AppGoodsBlock.class);
            appGoodsBlock.setGoodsId(o.getId());
            appGoodsBlock.setImgsrc(ImgUtils.formatImg(appGoodsBlock.getImgsrc(), ImgFormatEnum.GOODS_IMAGES));
            return appGoodsBlock;
        }).collect(Collectors.toList()));
        return vo;
    }
    /**
     * 移动端店内商品搜索
     *
     * @return
     */
    public ItemSearchVO itemSearch(WapSearchBO bo, String orderBy,Long shopId) throws OpenException {
        if (bo.getMid() != null) {
            parseMid(bo);
        }

        if("xp".equals(orderBy)){
            orderBy="time_down";
        }
        ShiguPager<ItemShowBlock> pager=shopForCdnService.searchItemOnsale(null,shopId,bo.getWebSite(),null,bo.getCid()==null?null:bo.getCid().toString(),orderBy,null,null,bo.getPage(),bo.getRows());

        ShiguPager<SearchItem> p=new ShiguPager<>();
        p.setNumber(pager.getNumber());
        p.setTotalPages(pager.getTotalPages());
        p.setTotalCount(pager.getTotalCount());
        p.setContent(pager.getContent().stream().map(itemShowBlock -> {
            SearchItem item=new SearchItem();
            item.setGoodsNo(itemShowBlock.getGoodsNo());
            item.setStoreId(itemShowBlock.getShopId());
            item.setPrice(itemShowBlock.getPrice());
            item.setTitle(itemShowBlock.getTitle());
            item.setItemId(itemShowBlock.getItemId());
            item.setPicUrl(itemShowBlock.getImgUrl());
            item.setCreated(new Date());
            if (itemShowBlock.getGoodsNo().contains("<em>")) {
                item.setHighLightGoodsNo(itemShowBlock.getGoodsNo());
                item.setGoodsNo(itemShowBlock.getGoodsNo().replace("<em>","").replace("</em>", ""));
            } else {
                item.setGoodsNo(null);
                item.setHighLightTitle(itemShowBlock.getTitle());
                item.setTitle(itemShowBlock.getTitle().replace("<em>","").replace("</em>", ""));
            }
            return item;
        }).collect(Collectors.toList()));
        ItemSearchVO vo=new ItemSearchVO();
        vo.setItems(goodsSelFromEsService.addShopInfoToGoods(p,bo.getWebSite()).getContent().stream()
                .filter(item-> item!=null && !StringUtil.isNull(item.getPiprice()))
                .map(o -> {
            AppGoodsBlock appGoodsBlock = BeanMapper.map(o, AppGoodsBlock.class);
            appGoodsBlock.setGoodsId(o.getId());
            appGoodsBlock.setImgsrc(ImgUtils.formatImg(appGoodsBlock.getImgsrc(), ImgFormatEnum.GOODS_IMAGES));
            return appGoodsBlock;
        }).collect(Collectors.toList()));
        vo.setTotal(pager.getTotalCount());
        vo.setHasNext(pager.getNumber() < pager.getTotalPages());
        return vo;
    }

    public void parseMid(SearchBO bo) throws OpenException {
        //转mid
        ShiguOuterMarket shiguOuterMarket = shiguOuterMarketMapper.selectByPrimaryKey(bo.getMid());
        if (shiguOuterMarket == null || shiguOuterMarket.getMarketId() == null) {
            OpenException openException = new OpenException();
            openException.setErrMsg("未查询到市场信息");
            throw openException;
        }
        bo.setMid(shiguOuterMarket.getMarketId());
    }

    /**
     * 移动端图搜
     *
     * @return
     */
    public List<AppGoodsBlock>  imgSearch(String imgUrl,String webSite) throws IOException {
        //图搜时传缩略图
        return goodsSearchService.searchByPic(imgUrl,webSite).parallelStream().map(o -> {
            if (o != null&& StringUtils.isNotEmpty(o.getId())) {
                AppGoodsBlock vo = BeanMapper.map(o, AppGoodsBlock.class);
                vo.setGoodsId(o.getId());
                vo.setImgsrc(ImgUtils.formatImg(vo.getImgsrc(), ImgFormatEnum.GOODS_IMAGES));
                return vo;
            }
            return new AppGoodsBlock();
        }).filter(o -> StringUtils.isNotEmpty(o.getGoodsId())).collect(Collectors.toList());
    }

    /**
     * app单商品信息
     * @return
     */
    public OneItemVO oneItem(String webSite,Long itemId,Long userId) throws IOException, TemplateException, Main4Exception {
        OneItemVO vo = new OneItemVO();
        //商品数据填充
        CdnGoodsInfoVO goods = cdnService.cdnGoodsInfo(itemId);
        vo.setGoodsId(goods.getGoodsId()+"");
        vo.setGoodsNo(goods.getGoodsNo());
        vo.setPrice(goods.getLiPrice());
        vo.setTitle(goods.getTitle());
        vo.setCreateTime(goods.getPostTime());
        vo.setImgSrcs(goods.getImgUrls().stream().map(s -> ImgUtils.formatImg(s,ImgFormatEnum.GOODS_IMAGES)).collect(Collectors.toList()));
        vo.setLiPrice(goods.getPiPrice());
        vo.setDetails(replacelazyLoadImg(goods.getDescHtml()));
        //获取 商品服务类型, services权限,1(退现金)，2（保换款），可以有的服务都传进来
        List<String> services = goods.getServices();
        List<String> list=new ArrayList<>();
        for (String s:services) {
            if("1".equals(s)){
                list.add("可退款");
            }else if("2".equals(s)){
                list.add("可换款");
            }
        }
        vo.setGoodsLicenses(list);
        vo.setColors(JSONArray.parseArray(goods.getColorsMeta()).parallelStream().map(o -> {
            JSONObject color = (JSONObject) o;
            return color.get("text").toString();
        }).collect(Collectors.toList()));
        vo.setSize(JSONArray.parseArray(goods.getSizesMeta()).parallelStream().map(Object::toString).collect(Collectors.toList()));
        vo.setItemKvs(goods.getNormalAttrs().parallelStream().map(o -> {
            AppItemKv itemKv = new AppItemKv();
            itemKv.setKey(o.getName());
            itemKv.setValue(o.getValue());
            return itemKv;
        }).collect(Collectors.toList()));
        //店铺数据填充
        CdnShopInfoVO shop = cdnService.cdnShopInfo(goods.getShopId());
        vo.setStoreId(goods.getShopId());
        vo.setStoreNum(shop.getShopNo());
        vo.setMarket(shop.getMarketName());
        vo.setStarNum(shop.getStarNum().intValue());
        vo.setShopHeadUrl(ImgUtils.headUrl(shop.getImWw()));
        if (userId != null) {
            // 查询商品是否收藏
            ShiguGoodsCollect shiguGoodsCollect = new ShiguGoodsCollect();
            shiguGoodsCollect.setUserId(userId);
            shiguGoodsCollect.setGoodsId(itemId);
            shiguGoodsCollect.setWebsite(webSite);
            shiguGoodsCollect = goodsCollectMapper.selectOne(shiguGoodsCollect);
            if (shiguGoodsCollect != null){
               vo.setCollectId(shiguGoodsCollect.getGoodsCollectId());
            }
        }

        return vo;
    }


    /**
     * 过滤HTML只返回内容中的 img 标签<br>直接将真实图片地址赋值到src<br>同时返回内容的img标签只包含 src data-original title 三种属性
     * @param source
     * @return
     */
    public  String replacelazyLoadImg(String source){
        if (StringUtil.isNull(source)){
            return null;
        }
        //只接受图片
        Whitelist whitelist = new Whitelist();
        whitelist.addTags("img").addAttributes("img",  "src","data-original", "title").addProtocols("img", "src", "http", "https");
        String cleanSource = Jsoup.clean(source,whitelist);

        Document cleanOriginnal = Jsoup.parse(cleanSource);

        Elements imgs = cleanOriginnal.select("img");
        StringBuilder  result = new StringBuilder();
        for (Element img : imgs){
            String imgUrl = img.attr("data-original");
            img.attr("src",ImgUtils.formatImg(imgUrl, ImgFormatEnum.GOODS_DETAIL));
            result.append(img.toString());
        }
        return result.toString();
    }

//    public static void main(String[] args) {
//        String str = "<html>\n" +
//                " <head></head>\n" +
//                " <body>\n" +
//                "  <img title=\"我是标题\" onclick=\"test()\" width=\"1000px\" class=\"lazyload\"  src=\"https://123.jpg\" data-original=\"https://img.alicdn.com/imgextra/i1/353297098/TB2sgKdbVXXXXaGXpXXXXXXXXXX-353297098.jpg\" />\n" +
//                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB2aFChbVXXXXX6XpXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB2aFChbVXXXXX6XpXXXXXXXXXX-353297098.jpg\" />\n" +
//                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB2nxSgbVXXXXXKXpXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB2nxSgbVXXXXXKXpXXXXXXXXXX-353297098.jpg\" />\n" +
//                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB2jqKmbVXXXXc5XXXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB2jqKmbVXXXXc5XXXXXXXXXXXX-353297098.jpg\" />\n" +
//                "  <img class=\"lazyload\" src=\"https://img.alicdn.com/imgextra/i2/353297098/TB21uKhbVXXXXalXpXXXXXXXXXX-353297098.jpg\" data-original=\"https://img.alicdn.com/imgextra/i2/353297098/TB21uKhbVXXXXalXpXXXXXXXXXX-353297098.jpg\" /\n" +
//                " <scripts></scripts" +
//                " </body>\n" +
//                "</html>";
//        System.out.println(replacelazyLoadImg(str));
//    }

}
