package com.shigu.main4.item.tools;

import com.opentae.data.mall.beans.ShiguGoodsExtends;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguPropImgs;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.vo.ShiguPropImg;
import com.shigu.main4.item.vo.SynItem;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxc on 2017/2/28.
 *
 * 商品 通讯 对象 到数据表 解构帮助类
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemHelper {

    /**
     * 商品信息包装为同步商品 对象
     * @param tiny 商品基础数据
     * @param goodsExtends 商品扩展数据
     * @param propImgs 商品属性图片
     * @return 同步商品对象
     */
    public static SynItem toSynItem(ShiguGoodsTiny tiny, ShiguGoodsExtends goodsExtends, ShiguPropImgs propImgs) {
        // 验证入参
        // id 都不一样 怎么能有爱情呢。
        Class<SynItem> clazz = SynItem.class;
        SynItem synItem = null;
        Long goodsId = null;
        if (tiny != null) {
            goodsId = tiny.getGoodsId();
            synItem = BeanMapper.map(tiny, clazz);
            synItem.setMarketId(tiny.getParentMarketId());
            synItem.setFloorId(tiny.getMarketId());
            synItem.setOnsale(true);
            synItem.setShopId(tiny.getStoreId());
            Integer from = tiny.getIsExcelImp();
            if (from != null)
                synItem.setItemFrom(ItemFrom.values()[from]);
        }

        if (goodsExtends != null) {
            if (goodsId == null) {
                goodsId = goodsExtends.getGoodsId();
            }

            // ID不同的抛弃
            if (goodsId != null && goodsId.equals(goodsExtends.getGoodsId())) {
                // extends名字一样的 塞进synItem.
                SynItem ext = BeanMapper.map(goodsExtends, clazz);
                if (synItem == null) {
                    synItem = ext;
                } else {
                    // 装入synItem
                    for (Field field : clazz.getDeclaredFields()) {
                        field.setAccessible(true);
                        try {
                            Object o = field.get(ext);
                            if (o != null) {
                                field.set(synItem, o);
                            }
                        } catch (Exception ignore) {
                        }
                    }
                }
                String images = goodsExtends.getImages();
                if (images != null)
                    synItem.setImageList(Arrays.asList(images.split(",")));
                synItem.setSellPoint(goodsExtends.getSellPromise());
            }
        }
        if (propImgs != null) {
            if (synItem != null && goodsId != null && goodsId.equals(propImgs.getItemId())) {
                synItem.setPropImgs(new ArrayList<ShiguPropImg>());
                String propimgs = propImgs.getPropimgs();
                if (propimgs != null) {
                    for (String s : propimgs.split(";")) {
                        String[] pvu = s.split("##");
                        if (pvu.length == 2) {
                            String[] pv = pvu[0].split(":");
                            try {
                                Long p = Long.valueOf(pv[0]);
                                Long v = Long.valueOf(pv[1]);
                                ShiguPropImg img = new ShiguPropImg();
                                img.setPid(p);
                                img.setVid(v);
                                img.setUrl(pvu[1]);
                                synItem.getPropImgs().add(img);
                            } catch (Exception ignore) {
                            }
                        }
                    }
                }
            }
        }
        return synItem;
    }

    /**
     * 救命啊，太复杂了
     * @param synItem 通讯对象
     * @return 结果集容器
     */
    public static SynItemContainer helpMe(SynItem synItem) {
        return new SynItemContainer(synItem);
    }

    /**
     * 商品数据反解结果容器
     */
    public static class SynItemContainer {
        private SynItemContainer(SynItem synItem) {
            deconstruction(synItem);
        }

        /**
         * 反解逻辑
         * @param synItem 通用商品数据
         */
        private void deconstruction(SynItem synItem) {
            parseTiny(synItem);

            parseGoodsExtends(synItem);

            parsePropImgs(synItem);
        }

        /**
         * 配置商品扩展对象
         * @param synItem 通讯对象
         */
        private void parseGoodsExtends(SynItem synItem) {
            this.goodsExtends = BeanMapper.map(synItem, ShiguGoodsExtends.class);
            // 商品图
            if (synItem.getImageList() != null){
                for(int i=0;i<synItem.getImageList().size();i++){
                    if(StringUtils.isBlank(synItem.getImageList().get(i))){
                        synItem.getImageList().remove(i);
                        i--;
                    }
                }
                if(synItem.getImageList().size()==0){
                    synItem.getImageList().add("");
                }
                this.goodsExtends.setImages(StringUtils.join(synItem.getImageList(), ","));
                this.goodsExtends.setSellPromise(synItem.getSellPoint());
                if(StringUtils.isBlank(this.tiny.getPicUrl())){
                    this.tiny.setPicUrl(synItem.getImageList().get(0));
                }
            }

        }

        /**
         * 配置商品属性图对象
         * @param synItem 通讯对象
         */
        private void parsePropImgs(SynItem synItem) {
            this.shiguPropImgs = new ShiguPropImgs();
            this.shiguPropImgs.setItemId(synItem.getGoodsId());
            List<ShiguPropImg> propImgs = synItem.getPropImgs();
            if (propImgs != null && !propImgs.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (ShiguPropImg img : synItem.getPropImgs()) {
                    sb.append(";");
                    sb.append(img.getPid());
                    sb.append(":");
                    sb.append(img.getVid());
                    sb.append("##");
                    sb.append(img.getUrl());
                }
                this.shiguPropImgs.setPropimgs(sb.substring(1));
            }
        }

        /**
         * 配置商品数据
         * @param synItem 通讯对象
         */
        private void parseTiny(SynItem synItem) {
            this.tiny = BeanMapper.map(synItem, ShiguGoodsTiny.class);
            // 提取parentMarketId
            this.tiny.setParentMarketId(synItem.getMarketId());
            // 提取MarketId
            this.tiny.setMarketId(synItem.getFloorId());
            this.tiny.setStoreId(synItem.getShopId());
            // 提取价格Long值
            if (this.tiny.getPriceString() != null)
                try {
                    Double dbPrice = Double.valueOf(synItem.getPriceString());
                    this.tiny.setPriceString(String.format("%.2f", dbPrice));
                    Double price = dbPrice * 100.0;
                    this.tiny.setPrice(price.longValue());
                } catch (Exception ignore) {}
            // 提取批发价Long值
            if (this.tiny.getPiPriceString() != null)
                try {
                    Double dbPiPrice = Double.valueOf(synItem.getPiPriceString());
                    this.tiny.setPiPriceString(String.format("%.2f", dbPiPrice));
                    Double piPrice = dbPiPrice * 100.0;
                    this.tiny.setPiPrice(piPrice.longValue());
                } catch (Exception ignore) {}
            // 设置商品来源
            if (synItem.getItemFrom() != null)
                this.tiny.setIsExcelImp(synItem.getItemFrom().ordinal());
        }

        private ShiguGoodsTiny tiny;
        private ShiguGoodsExtends goodsExtends;
        private ShiguPropImgs shiguPropImgs;

        public ShiguGoodsTiny getTiny() {
            return tiny;
        }

        public ShiguGoodsExtends getGoodsExtends() {
            return goodsExtends;
        }

        public ShiguPropImgs getShiguPropImgs() {
            return shiguPropImgs;
        }
    }
}
