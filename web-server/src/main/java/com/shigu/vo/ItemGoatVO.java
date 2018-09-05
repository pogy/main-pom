package com.shigu.vo;/**
 * Created by pc on 2017-09-19.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import com.shigu.spread.vo.ItemSpreadVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *Created By pc on 2017-09-19/10:46
 * 商品详情页广告对象
 */
public class ItemGoatVO implements Serializable {

    private static final long serialVersionUID = -1824641767828884431L;

    /**
     * 	商品id
     */
    private String goodsId;
    /**
     * 商品图片
     */
    private String imgSrc;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 店铺id
     */
    private String shopId;
    /**
     * 市场名
     */
    private String marketName;
    /**
     * 档口号
     */
    private String shopNum;
    /**
     * 商品标题
     */
    private String title;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static List<ItemGoatVO> copyListFromCache(Object obj){
        List<ItemGoatVO> result = new ArrayList<ItemGoatVO>();
        List<ItemSpreadVO> list = (List<ItemSpreadVO>)obj;
        for(ItemSpreadVO item : list){
            result.add(copyListFromCache(item));
        }
        return result;
    }

    public static ItemGoatVO copyListFromCache(ItemSpreadVO itemSpreadVO){
        if (itemSpreadVO == null)return null;
        ItemGoatVO itemGoatVO = new ItemGoatVO();
        itemGoatVO.setGoodsId(itemSpreadVO.getId());
        itemGoatVO.setImgSrc(itemSpreadVO.getImgSrc());
        itemGoatVO.setPrice(itemSpreadVO.getPiprice());
        itemGoatVO.setShopId(itemSpreadVO.getShopId());
        itemGoatVO.setMarketName(itemSpreadVO.getMarketName());
        itemGoatVO.setShopNum(itemSpreadVO.getStoreNum());
        itemGoatVO.setTitle(itemSpreadVO.getTitle());
        return itemGoatVO;
    }
}
