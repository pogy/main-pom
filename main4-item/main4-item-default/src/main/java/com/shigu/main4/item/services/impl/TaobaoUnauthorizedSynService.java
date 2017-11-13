package com.shigu.main4.item.services.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.TaobaoItemPropMapper;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.exceptions.SynException;
import com.shigu.main4.item.services.utils.OuterSynUtil;
import com.shigu.main4.item.vo.ShiguPropImg;
import com.shigu.main4.item.vo.SynItem;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * 类名：TaobaoUnauthorizedSynService
 * 类路径：com.shigu.main4.item.services.impl.TaobaoUnauthorizedSynService
 * 创建者：王浩翔
 * 创建时间：2017-11-05 11:54
 * 项目：main-pom
 * 描述：
 */
@Component("taobaoUnauthorizedSynService")
public class TaobaoUnauthorizedSynService extends OuterSynUtil {

    @Autowired
    TaobaoPropValueMapper taobaoPropValueMapper;

    @Autowired
    TaobaoItemPropMapper taobaoItemPropMapper;

    @Override
    protected void goodsExecute(SynShopBean synBean, Long otherGoodsId) {

    }

    @Override
    protected Map<Long, ShiguGoodsTiny> getLocalOuterGoodsMap(Long shopId, String webSite) {
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(webSite);
        tinyExample.createCriteria().andStoreIdEqualTo(shopId).andIsExcelImpEqualTo(ItemFrom.TAOBAO.ordinal());
        HashMap<Long, ShiguGoodsTiny> result = new HashMap<>();
        for (ShiguGoodsTiny tiny : shiguGoodsTinyMapper.selectFieldsByExample(tinyExample, FieldUtil.codeFields("goods_id,num_iid"))) {
            result.put(tiny.getNumIid(),tiny);
        }
        return result;
    }

    @Override
    protected Map<Long, ShiguGoodsSoldout> getSynLocalSoldoutMap(List<Long> outerIds, Long shopId, String webSite) {
        if (outerIds.size() == 0) {
            return new HashMap<>();
        }
        ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
        soldoutExample.setWebSite(webSite);
        soldoutExample.createCriteria().andStoreIdEqualTo(shopId).andNumIidIn(outerIds);
        HashMap<Long, ShiguGoodsSoldout> result = new HashMap<>();
        for (ShiguGoodsSoldout soldout : shiguGoodsSoldoutMapper.selectByExample(soldoutExample)) {
            result.put(soldout.getNumIid(),soldout);
        }
        return result;
    }

    @Override
    protected Map<Long, ?> getPagedGoodsInfo(SynShopBean synShopBean, int pageNo) throws SynException {
        String shopUrl = "https://".concat(synShopBean.shop.getTaobaoUrl().replace("http://","").replace("https://",""));
        if (shopUrl.endsWith("/")) {
            shopUrl = shopUrl.substring(0,shopUrl.length()-1);
        }
        try {
            Document dynaVerify = Jsoup.connect(String.format("%s/search.htm",shopUrl)).get();
            String dynaParam = dynaVerify.select("input#J_ShopAsynSearchURL").val();
            Connection connect = Jsoup.connect(String.format("%s%s&pageNo=%d", shopUrl,dynaParam, pageNo));
            Document orignalDoc = connect.get();
            String orignalHtml = orignalDoc.html().replaceAll("\\\\&quot;", "").replaceAll("\\\\\"","").replaceAll("=\"\"","");
            Document shopGoodsInfo = Jsoup.parse(orignalHtml);
            if ("0".equals(shopGoodsInfo.select("div.search-result").select("span").text())) {
                //分页数据搜索结束
                throw new SynException(SynException.SynExceptionEnum.END_OF_PAGED_SYN_INFO_EXCEPTION);
            }
            //不能直接拿到商品修改时间，先返回numiid，以后有需要了把map里的值改为其他数据
            Elements elements = shopGoodsInfo.select("dl");
            HashMap<Long, Object> resultMap = new HashMap<>();
            for (Element element : elements) {
                resultMap.put(Long.valueOf(element.attr("data-id")),Long.valueOf(element.attr("data-id")));
            }
            return resultMap;
        } catch (IOException e) {
            throw new SynException(SynException.SynExceptionEnum.COULD_NOT_GET_SYN_INFO_EXCEPTION);
        }
    }

    //todo 单商品信息获取封装
    @Override
    protected SynItem getGoodsInfo(Long outGoodsId, SynShopBean synShopBean, Long ignored) throws SynException {
        SynItem synItem = new SynItem();
        try {
            ShiguShop shop=synShopBean.shop;
            //不是抓取到的数据
            Date now = new Date();
            synItem.setListTime(now);
            synItem.setModified(now);
            //创建时间不应该为空
            synItem.setCreated(now);
            Calendar instance = Calendar.getInstance();
            instance.setTime(now);
            instance.add(Calendar.DATE,7);
            synItem.setDelistTime(instance.getTime());
            synItem.setNum(100L);

            //档口数据
            synItem.setItemFrom(ItemFrom.TAOBAO);
            synItem.setShopId(shop.getShopId());
            synItem.setWebSite(shop.getWebSite());
            synItem.setMarketId(shop.getMarketId());
            synItem.setFloorId(shop.getFloorId());

            //抓取数据
            String detailUrl = String.format("https://item.taobao.com/item.htm?id=%d", outGoodsId);
            synItem.setDetailUrl(detailUrl);
            Document goodsDoc = Jsoup.connect(detailUrl).get();
            synItem.setNumIid(outGoodsId);
            String title = goodsDoc.select("h3.tb-main-title").get(0).attr("data-title");
            synItem.setTitle(title);
            String piPriceStr = goodsDoc.select("em.tb-rmb-num").text();
            synItem.setPiPriceString(piPriceStr);
            synItem.setPriceString(piPriceStr);
            List<ShiguPropImg> propImgs = new ArrayList<>();
            synItem.setPropImgs(propImgs);
            for (Element script : goodsDoc.head().select("script")) {
                boolean configScriptIs = false;
                String confHtml = script.html();
                int startIndex = confHtml.indexOf("//desc.alicdn.com");
                if (startIndex>0) {
                    configScriptIs = true;
                    int endIndex = confHtml.indexOf("'", startIndex);
                    Document descDoc = Jsoup.connect(String.format("https:%s", confHtml.substring(startIndex, endIndex))).get();
                    String descResp = descDoc.html();
                    //WebClient webClient = new WebClient();
                    //webClient.getOptions().setCssEnabled(false);
                    //webClient.getOptions().setJavaScriptEnabled(false);
                    //TextPage page = webClient.getPage(String.format("https:%s", confHtml.substring(startIndex, endIndex)));
                    //String descResp = page.getContent();
                    //webClient.close();
                    int descStart = descResp.indexOf("'");
                    int descEnd = descResp.indexOf("';");
                    if (descEnd>descStart && descStart>0) {
                        String descStr = descResp.substring(descStart + 1, descEnd).replaceAll("<img src=\"https://img.alicdn.com/imgextra/i4/1642658218/TB2f_L8cV9gSKJjSspbXXbeNXXa-1642658218.jpg\" />","").replaceAll("<img src=\"https://img.alicdn.com/imgextra/i4/1642658218/TB2f_L8cV9gSKJjSspbXXbeNXXa-1642658218.jpg\">","").replaceAll("\\\\","");
                        synItem.setGoodsDesc(descStr);
                    }
                }
                if (configScriptIs) {
                    String online = getContextFromString(confHtml, "online", ":", ",", 6);
                    boolean onsale = online != null && online.contains("true");
                    synItem.setOnsale(onsale);
                    int parentCidIndex = confHtml.indexOf("rcid");
                    int cidIndex = confHtml.indexOf("cid");
                    if (cidIndex == parentCidIndex + 1) {
                        cidIndex = confHtml.indexOf("cid",parentCidIndex+4);
                    }
                    int cidStart = confHtml.indexOf("'", cidIndex);
                    if (cidStart>0) {
                        int cidEnd = confHtml.indexOf("'", cidStart + 1);
                        Long cid = Long.valueOf(confHtml.substring(cidStart + 1, cidEnd));
                        synItem.setCid(cid);
                    }
                    int idataIndex = confHtml.indexOf("idata            : {");
                    int picIndex = confHtml.indexOf("pic", idataIndex);
                    int picStart = confHtml.indexOf("'", picIndex);
                    int picEnd = confHtml.indexOf("'", picStart + 1);
                    synItem.setPicUrl(confHtml.substring(picStart+1,picEnd));
                    //商品六张图
                    List<String> imageList = new ArrayList<>(6);
                    String images = getContextFromString(confHtml, "auctionImages", "[", "]", 0).replace("[","").replace("]","");
                    String[] splitImgs = images.split(",");
                    for (String splitImg : splitImgs) {
                        imageList.add("https:".concat(splitImg.replaceAll("\"","")));
                    }
                    synItem.setImageList(imageList);
                }
            }
            for (Element bodyScript : goodsDoc.body().select("script")) {
                String scriptContext = bodyScript.html().trim();
                boolean isConfig = scriptContext.startsWith("Hub");
                if (isConfig) {
                    int cidAllIndex = scriptContext.indexOf("rstShopcatlist");
                    if (cidAllIndex>0) {
                        String cidAll = getContextFromString(scriptContext, "rstShopcatlist", "'", "'", 0);
                        synItem.setCidAll(cidAll);
                    }
                }
            }
            StringBuffer propBuf = new StringBuffer();
            StringBuffer propNamesBuf = new StringBuffer();
            StringBuffer propAlias = new StringBuffer();
            StringBuffer inputPids = new StringBuffer();
            StringBuffer inputStr = new StringBuffer();
            for (Element element : goodsDoc.select("ul[data-property]")) {
                String propName = element.attr("data-property");
                for (Element li : element.select("li")) {
                    //颜色，尺码
                    String kvPairStr = li.attr("data-value");
                    propBuf.append(';').append(kvPairStr);
                    propNamesBuf.append(';').append(kvPairStr).append(':').append(propName).append(':').append(li.select("a").select("span").html());
                    Elements propImgElement = li.select("a[style]");
                    if (propImgElement.size()>0) {
                        String origalPropUrl = propImgElement.get(0).attr("style");
                        int endIndex = origalPropUrl.indexOf(".jpg");
                        int startIndex = origalPropUrl.indexOf("//");
                        if (startIndex > 0 && endIndex >0) {
                            String propUrl = "https:".concat(origalPropUrl.substring(startIndex, endIndex + 4));
                            String[] kvPair = kvPairStr.split(":");
                            ShiguPropImg shiguPropImg = new ShiguPropImg();
                            shiguPropImg.setPid(Long.valueOf(kvPair[0]));
                            shiguPropImg.setVid(Long.valueOf(kvPair[1]));
                            shiguPropImg.setUrl(propUrl);
                            propImgs.add(shiguPropImg);
                        }
                    }
                }
            }
            long inputIndex = -1001;
            for (Element element : goodsDoc.select("ul.attributes-list").select("li")) {
                String[] kvPair = element.text().split(":");
                String keyStr = kvPair[0];
                String valueStr = element.attr("title");
                if ("货号".equals(keyStr)||"款号".equals(keyStr)) {
                    synItem.setGoodsNo(valueStr);
                } else if ("颜色".equals(keyStr)||"尺码".equals(keyStr)||"尺寸".equals(keyStr)){
                    //    颜色尺码忽略，在其他地方获取
                } else {
                    TaobaoPropValue taobaoPropValue = new TaobaoPropValue();
                    taobaoPropValue.setCid(synItem.getCid());
                    taobaoPropValue.setPropName(keyStr);
                    taobaoPropValue.setName(valueStr);
                    taobaoPropValue = taobaoPropValueMapper.selectOne(taobaoPropValue);
                    Long pid = null;
                    Long vid = null;
                    if (taobaoPropValue != null) {
                        pid = taobaoPropValue.getPid();
                        vid = taobaoPropValue.getVid();
                        propBuf.append(';').append(pid).append(':').append(vid);
                    } else {
                        TaobaoItemProp taobaoItemProp = new TaobaoItemProp();
                        taobaoItemProp.setCid(synItem.getCid());
                        taobaoItemProp.setName(keyStr);
                        taobaoItemProp = taobaoItemPropMapper.selectOne(taobaoItemProp);
                        if (taobaoItemProp != null) {
                            if (taobaoItemProp.getIsSaleProp() != null && taobaoItemProp.getIsSaleProp() ==1) {
                                //销售属性在其他地方取
                                continue;
                            }
                            pid = taobaoItemProp.getPid();
                            vid = inputIndex--;
                            Integer isAllowAlias = taobaoItemProp.getIsAllowAlias();
                            if (isAllowAlias != null && isAllowAlias == 1) {
                                propAlias.append(';').append(pid).append(':').append(vid).append(':').append(valueStr);
                            } else {
                                inputPids.append(',').append(pid);
                                inputStr.append(',').append(valueStr);
                            }
                        }
                    }
                    propNamesBuf.append(';').append("pid").append(':').append("vid").append(':').append(keyStr).append(':').append(valueStr);
                }
            }
            if (propBuf.length()>0) {
                synItem.setProps(propBuf.substring(1));
            }
            if (propNamesBuf.length()>0) {
                synItem.setPropsName(propNamesBuf.substring(1));
            }
            if (propAlias.length()>0) {
                synItem.setPropertyAlias(propAlias.substring(1));
            }
            if (inputPids.length()>0) {
                synItem.setInputPids(inputPids.substring(1));
                synItem.setInputStr(inputStr.substring(1));
            }

        } catch (Exception e) {
            throw new SynException(SynException.SynExceptionEnum.SYN_ONE_ITEM_EXCEPTION);
        }
        return synItem;
    }


    public static String getContextFromString(String original,String target,String begin,String end,int rotate){
        int targetIndex = original.indexOf(target);
        if (targetIndex > 0) {
            int targetStart = original.indexOf(begin, targetIndex + rotate)+1;
            int targetEnd = original.indexOf(end, targetStart);
            if (targetStart>0&&targetEnd>0) {
                return original.substring(targetStart,targetEnd);
            }
        }
        return null;
    }

    @Override
    protected boolean checkGoodsSyn(ShiguGoodsTiny goods, Object synGoods) {
        //暂时默认为所有淘宝上架且档口上架的都已经同步
        return true;
    }

    @Override
    protected boolean checkLocalModified(ShiguGoodsModified modified, OuterSynUtil.ModifiedStateEnum modifiedState) {
        //对应ShiguGoodsModified记录不存在，则没修改过
        if (modified == null) {
            return false;
        }
        switch (modifiedState){
            case HAS_LOCAL_UP:
                return !modified.getHasModInstock().equals(0);
            case HAS_LOCAL_DOWN:
                //手动进行过下架
                return !modified.getHasModInstock().equals(1);
        }
        return false;
    }


}
