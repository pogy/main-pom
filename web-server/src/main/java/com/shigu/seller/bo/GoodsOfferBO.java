package com.shigu.seller.bo;

import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.item.bo.news.NewPushSynItemBO;
import com.shigu.main4.item.bo.news.SingleSkuBO;
import com.shigu.seller.services.DataPackageImportService;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.SafeHtml;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 商品发布的所有参数
 * Created by zhaohongbo on 17/3/15.
 */
public class GoodsOfferBO implements Serializable{
    /**
     * 首图
     */
    @SafeHtml(message = "首图包含非法页面标签")
    private String picPath;
    /**
     * 不包含首图
     */
    @SafeHtml(message = "5张图包含非法页面标签")
    private String allimg;
    /**
     * 自定义的pid
     */
    @SafeHtml(message = "自定义的pid包含非法页面标签")
    private String inputPids;
    /**
     * 自定义的值
     */
    @SafeHtml(message = "自定义的值包含非法页面标签")
    private String inputStr;
    /**
     * 所有属性ID串
     */
    @SafeHtml(message = "所有属性ID串包含非法页面标签")
    private String paramstr;
    /**
     * 属性值重定义
     */
    @SafeHtml(message = "属性值重定义包含非法页面标签")
    private String propertyAlias;
    /**
     * 批发价
     */
    @SafeHtml(message = "批发价包含非法页面标签")
    private String piPrice;
    /**
     * 零售价
     */
    @SafeHtml(message = "零售价包含非法页面标签")
    private String buynow;

    /**
     * 最低零售价
     */
    @SafeHtml(message = "零售价包含非法页面标签")
    private String lowestLiPrice;
    /**
     * 卖点
     */
    @SafeHtml(message = "卖点包含非法页面标签")
    private String sellPoint;
    /**
     * 商品数量
     */
    private Long quantity;
    /**
     * 商品标题
     */
    @SafeHtml(message = "商品标题包含非法页面标签")
    private String title;
    /**
     * 商品详情
     */
//    @SafeHtml(message = "商品详情包含非法页面标签")
    private String deschtml;
    /**
     * 店内类目ID串
     */
    @SafeHtml(message = "店内类目ID串包含非法页面标签")
    private String sellerids;
    /**
     * 淘宝类目ID
     */
    private Long cid;
    /**
     * 面料
     */
//    @NotNull(message = "面料成分为必填选项")
    private String fabric;
    /**
     * 里料
     */
    private String inFabric;
    /**
     * 货号
     */
    @NotNull(message = "货号为必填选项")
    private String goodsNo;

    /**
     * 商品id
     */
    private String goodsId;


    private List<String> skuSpecs;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getAllimg() {
        return allimg;
    }

    public void setAllimg(String allimg) {
        this.allimg = allimg;
    }

    public String getInputPids() {
        return inputPids;
    }

    public void setInputPids(String inputPids) {
        this.inputPids = inputPids;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public String getParamstr() {
        return paramstr;
    }

    public void setParamstr(String paramstr) {
        this.paramstr = paramstr;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
    }

    public String getPiPrice() {
        return piPrice;
    }

    public void setPiPrice(String piPrice) {
        this.piPrice = piPrice;
    }

    public String getLowestLiPrice() {
        return lowestLiPrice;
    }

    public void setLowestLiPrice(String lowestLiPrice) {
        this.lowestLiPrice = lowestLiPrice;
    }

    public String getBuynow() {
        return buynow;
    }

    public void setBuynow(String buynow) {
        this.buynow = buynow;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeschtml() {
        return deschtml;
    }

    public void setDeschtml(String deschtml) {
        if(deschtml!=null){
            Document dom= Jsoup.parse(deschtml);
            dom.select("script").remove();
            this.deschtml=dom.body().html();
        }
    }

    public String getSellerids() {
        return sellerids;
    }

    public void setSellerids(String sellerids) {
        this.sellerids = sellerids;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getInFabric() {
        return inFabric;
    }

    public void setInFabric(String inFabric) {
        this.inFabric = inFabric;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * 转化成标准对象
     * @return
     */
    public NewPushSynItemBO parseToSynItem(DataPackageImportService dataPackageImportService) throws JsonErrException {
        NewPushSynItemBO synItem=new NewPushSynItemBO();
        synItem.setInputPids(this.getInputPids());
        synItem.setInputStr(this.getInputStr());
        synItem.setProps(this.getParamstr());
        synItem.setPropertyAlias(this.getPropertyAlias());
        if (StringUtils.isBlank(this.buynow)) {
            this.buynow = this.getPiPrice();
        }
        synItem.setPriceString(this.getBuynow());
        synItem.setPiPriceString(this.getPiPrice());
        synItem.setSellPoint(this.getSellPoint());
        synItem.setNum(this.getQuantity());
        synItem.setTitle(this.getTitle());
        synItem.setCidAll(this.getSellerids());
        synItem.setCid(this.getCid());
        synItem.setFabric(this.getFabric());
        synItem.setInFabric(this.getInFabric());
        synItem.setGoodsNo(this.getGoodsNo());

        List<SingleSkuBO> singleSkus=new ArrayList<>();
        List<Long> singlePrices=new ArrayList<>();
        for(String skuSpec:skuSpecs){
            String[] cs=skuSpec.split("-");
            String[] colorStrs=cs[0].split("_");
            String[] sizeStrs=cs[1].split("_");
            Long price=MoneyUtil.StringToLong(cs[2]);
            singlePrices.add(price);
            String piPriceString= MoneyUtil.dealPrice(price);
            Integer num=new Integer(cs[3]);
            SingleSkuBO sbo=new SingleSkuBO();
            sbo.setPriceString(piPriceString);
            sbo.setStockNum(num);
            if(!"null".equals(colorStrs[1])){
                sbo.setColorVid(new Long(colorStrs[1]));
                sbo.setColorAlias(colorStrs[2]);
            }
            if(!"null".equals(sizeStrs[1])){
                sbo.setSizeVid(new Long(sizeStrs[1]));
                sbo.setSizeAlias(sizeStrs[2]);
            }
            singleSkus.add(sbo);
        }
        if(singlePrices.size()>0){
            singlePrices.sort(Comparator.comparingLong(o -> o));
            Long piprice=MoneyUtil.StringToLong(this.getPiPrice());
            if(piprice < singlePrices.get(0) || piprice >singlePrices.get(singlePrices.size()-1)){
                throw new JsonErrException(
                        "批发价修改失败,批发价必须在sku价格的区间范围之内,当前范围:[" + MoneyUtil.dealPrice(singlePrices.get(0)) + "-" +
                                MoneyUtil.dealPrice(singlePrices.get(singlePrices.size() - 1)) + "]");
            }
        }

        if(singleSkus.size()==0){
            SingleSkuBO sbo=new SingleSkuBO();
            sbo.setPriceString(this.getPiPrice());
            sbo.setStockNum(999);
            singleSkus.add(sbo);
        }
        synItem.setSingleSkus(singleSkus);


        synItem.setPicUrl(dataPackageImportService.banjia(picPath));
        List<String> allImgUrl=new ArrayList<>();
        if(this.picPath!=null){
            allImgUrl.add(synItem.getPicUrl());
        }
        if(this.allimg!=null&&!"".equals(allimg)){
            List<String> images=Arrays.asList(allimg.split(","));
            for(int i=0;i<images.size();i++){
                images.set(i,dataPackageImportService.banjia(images.get(i)));
            }
            allImgUrl.addAll(images);
            synItem.setImageList(allImgUrl);
        }else{
            synItem.setImageList(allImgUrl);
        }
        Document d=Jsoup.parse(this.getDeschtml());
        Elements imgs=d.select("img");
        imgs.forEach(element -> {
            element.attr("src",dataPackageImportService.banjia(element.attr("src")));
        });
        synItem.setGoodsDesc(d.body().html());
        return synItem;
    }

    public List<String> getSkuSpecs() {
        return this.skuSpecs;
    }

    public void setSkuSpecs(List<String> skuSpecs) {
        this.skuSpecs = skuSpecs;
    }
}
