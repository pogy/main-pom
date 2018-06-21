package com.shigu.main4.item.services.utils;

import com.opentae.data.mall.beans.ShiguShop;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.vo.ShiguPropImg;
import com.shigu.main4.item.vo.SynItem;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.Location;
import com.taobao.api.domain.PropImg;
import com.taobao.api.internal.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/3/9.
 *
 * @author wxc
 * @version tb_site4.0 4.0.0
 * @since tb_site4.0 4.0.0
 */
public class TbItemSynMapper {

    public static SynItem toSynItem(Item item, ShiguShop shiguShop, Long goodsId) {
        SynItem synItem = new SynItem();
        synItem.setGoodsId(goodsId);
        synItem.setFreightPayer(item.getFreightPayer());
        synItem.setNumIid(item.getNumIid());
        synItem.setCreated(item.getCreated());
        synItem.setNum(item.getNum());
        synItem.setDelistTime(item.getDelistTime());
        synItem.setPropertyAlias(item.getPropertyAlias());
        synItem.setInputStr(item.getInputStr());
        synItem.setTitle(item.getTitle());
        if (item.getHasShowcase() != null)
            synItem.setHasShowcase(item.getHasShowcase().toString());
        synItem.setInputPids(item.getInputPids());
        synItem.setProps(item.getProps());
        synItem.setPicUrl(item.getPicUrl());
        if (item.getPropImgs() != null) {
            List<ShiguPropImg> list = new ArrayList<ShiguPropImg>();
            for (PropImg propImg : item.getPropImgs()) {
                ShiguPropImg img = new ShiguPropImg();
                img.setUrl(propImg.getUrl());
                String properties = propImg.getProperties();
                if (properties != null && properties.contains(":")) {
                    String[] split = properties.split(":");
                    if (split.length == 2) {
                        try {
                            img.setPid(Long.valueOf(split[0]));
                            img.setVid(Long.valueOf(split[1]));
                            list.add(img);
                        }catch (Exception ignore){}
                    }
                }
            }
            synItem.setPropImgs(list);
        }
        synItem.setWirelessDesc(item.getWirelessDesc());
        synItem.setSellPoint(item.getSellPoint());
        synItem.setModified(item.getModified());
        synItem.setPropsName(item.getPropsName());
        synItem.setOuterId(item.getOuterId());
        synItem.setDetailUrl(item.getDetailUrl());
        synItem.setItemSize(item.getItemSize());
        synItem.setItemWeight(item.getItemWeight());
        synItem.setCid(item.getCid());
        synItem.setListTime(item.getListTime());

        synItem.setShopId(shiguShop.getShopId());
        synItem.setPriceString(item.getPrice());
        synItem.setPiPriceString(item.getPrice());

        Location location = item.getLocation();
        if (location != null) {
            synItem.setProv(location.getState());
            synItem.setCity(location.getCity());
        }
        String propsName = item.getPropsName();
        if (propsName != null) {
            for (String s : propsName.split(";")) {
                String[] split = s.split(":");
                if (split.length == 4 && isGoodsNo(split)) {
                    synItem.setGoodsNo(split[3].replace("#cln#", ":").replace("#scln#", ";"));
                    break;
                }
            }
        }
        synItem.setCidAll(item.getSellerCids());
        synItem.setMarketId(shiguShop.getMarketId());
        synItem.setFloorId(shiguShop.getFloorId());
        synItem.setWebSite(shiguShop.getWebSite());
        synItem.setOnsale("onsale".equals(item.getApproveStatus()));
        if (!StringUtils.isEmpty(item.getDesc())) {
            item.setDesc(item.getDesc().replace("<img src=\"https://img.alicdn.com/imgextra/i4/1642658218/TB2f_L8cV9gSKJjSspbXXbeNXXa-1642658218.jpg\" />","")
            .replace("<img src=\"https://img.alicdn.com/imgextra/i4/1642658218/TB2f_L8cV9gSKJjSspbXXbeNXXa-1642658218.jpg\">",""));
        }
        synItem.setGoodsDesc(item.getDesc());
        try {
            synItem.setImageList(BeanMapper.getFieldList(item.getItemImgs(), "url", String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        synItem.setItemFrom(ItemFrom.TAOBAO);
        return synItem;
    }

    private static boolean isGoodsNo(String[] props) {
        String s = props[2];
        String v = props[1];
        return s.contains("货号") || s.contains("款号") || v.equals("1647377840") || v.equals("637078838");
    }
}
