package com.shigu.seller.bo;

import com.shigu.main4.vo.ShopFitment;
import com.shigu.main4.vo.ShopFitmentForUpadte;
import org.hibernate.validator.constraints.SafeHtml;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 修改装修
 * Created by zhaohongbo on 17/3/18.
 */
public class FitmentBO implements Serializable{
    /**
     * 修改的field
     */
    @SafeHtml(message = "imgExcName包含非法页面标签")
    private String imgExcName;
    /**
     * 图片路径
     */
    @SafeHtml(message = "imgUrl包含非法页面标签")
    private String imgUrl;
    /**
     * 开关,1开,0关
     */
    private Integer isOpen;
    /**
     * 详情
     */
//    @SafeHtml(message = "descStr包含非法页面标签")
    private String descStr;

    /**
     * 导出可更新的格式
     * @return
     */
    public ShopFitmentForUpadte toParseUpdate(){
        ShopFitmentForUpadte upadte=new ShopFitmentForUpadte();
        if("logo".equals(imgExcName)){
            upadte.setShopLogo(imgUrl);
            upadte.setShowLogo(isOpen);
        }else if(imgExcName.contains("banner")){
            List<String> banners=Arrays.asList(imgUrl.split(","));
            upadte.setShopBanner(banners.get(0));
            upadte.setShopBanner2(banners.size()>1?banners.get(1):"");
            upadte.setShopBanner3(banners.size()>2?banners.get(2):"");
            upadte.setShopBanner4(banners.size()>3?banners.get(3):"");
            upadte.setShopBanner5(banners.size()>4?banners.get(4):"");
        }else if(imgExcName.equals("delBan")){
            upadte.setShopBanner("");
            upadte.setShopBanner2("");
            upadte.setShopBanner3("");
            upadte.setShopBanner4("");
            upadte.setShopBanner5("");
            upadte.setShowSlide(isOpen);
        }else if("desc".equals(imgExcName)){
            upadte.setDescription(descStr);
            upadte.setShowDescription(isOpen);
        }
        return upadte;
    }

    public String getImgExcName() {
        return imgExcName;
    }

    public void setImgExcName(String imgExcName) {
        this.imgExcName = imgExcName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getDescStr() {
        return descStr;
    }

    public void setDescStr(String descStr) {
        if(descStr!=null){
            Document dom=Jsoup.parse(descStr);
            dom.select("script").remove();
            this.descStr=dom.body().html();
        }
//        this.descStr = descStr;
    }
}
