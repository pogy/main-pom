package com.shigu.seller.bo;

import com.shigu.main4.item.bo.news.NewPushSynItemBO;
import com.shigu.main4.item.vo.SynItem;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 批量保存
 * Created by zhaohongbo on 17/3/19.
 */
public class MoreModifyUpdateBO implements Serializable{

    @NotEmpty(message = "缺少必要参数goodsIds")
    @SafeHtml(message = "goodsIds包含非法页面标签")
    private String goodsIds;

    @NotEmpty(message = "缺少必要参数goodsNos")
    @SafeHtml(message = "goodsNos包含非法页面标签")
    private String goodsNos;
    @NotEmpty(message = "缺少必要参数priceStrings")
    @SafeHtml(message = "priceStrings包含非法页面标签")
    private String priceStrings;
    @NotEmpty(message = "缺少必要参数piPriceStrings")
    @SafeHtml(message = "piPriceStrings包含非法页面标签")
    private String piPriceStrings;


    public List<NewPushSynItemBO> parseSynItems(Long shopId, String webSite){
        String[] goodsarr=goodsIds.split(",");
        String[] noarr=goodsNos.split(",");
        String[] pricearr=priceStrings.split(",");
        String[] pipricearr=piPriceStrings.split(",");
        List<NewPushSynItemBO> items=new ArrayList<>();
        for(int i=0;i<goodsarr.length;i++){
            NewPushSynItemBO synItem=new NewPushSynItemBO();
            synItem.setGoodsId(Long.valueOf(goodsarr[i]));
            synItem.setShopId(shopId);
            synItem.setWebSite(webSite);
            synItem.setGoodsNo(noarr.length>i?noarr[i]:null);
            synItem.setPriceString(pricearr.length>i?pricearr[i]:null);
            synItem.setPiPriceString(pipricearr.length>i?pipricearr[i]:null);
            items.add(synItem);
        }
        return items;
    }
    public String getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(String goodsIds) {
        this.goodsIds = goodsIds;
    }

    public String getGoodsNos() {
        return goodsNos;
    }

    public void setGoodsNos(String goodsNos) {
        this.goodsNos = goodsNos;
    }

    public String getPriceStrings() {
        return priceStrings;
    }

    public void setPriceStrings(String priceStrings) {
        this.priceStrings = priceStrings;
    }

    public String getPiPriceStrings() {
        return piPriceStrings;
    }

    public void setPiPriceStrings(String piPriceStrings) {
        this.piPriceStrings = piPriceStrings;
    }
}
