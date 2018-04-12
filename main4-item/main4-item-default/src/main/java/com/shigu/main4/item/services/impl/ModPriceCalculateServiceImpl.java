package com.shigu.main4.item.services.impl;

import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.item.services.PriceCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 价格分模型，计算
 * Created by bugzy on 2017/5/27 0027.
 */
//@Service("priceCalculateService")
public class ModPriceCalculateServiceImpl implements PriceCalculateService {

    @Autowired
    private  ShiguShopMapper shiguShopMapper;

    private List<Long> matchPrice(String c, String ... strs) {
        String uc = c.toUpperCase();
        String lc = c.toLowerCase();
        Pattern pattern = Pattern.compile(String.format("[%s|%s](\\d+(\\.[0-9]*)?)", lc, uc));

        List<Long> prices = new ArrayList<>();
        for (String s : strs) {
            if (s == null) {
                continue;
            }
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                String group = matcher.group().substring(1);
                try {
                    prices.add(((Double)(Double.valueOf(group) * 100)).longValue());
                } catch (NumberFormatException ignored){}
            }
            if (!prices.isEmpty()) {
                break;
            }
        }
        return prices;
    }

    @Override
    public Long pickPipriceFromTitle(Long shopId, Long price, String... strs) {
        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
        if (shiguShop != null) {
            String c = null;
            int mod = 2;
            if (shiguShop.getPriceRule() != null && shiguShop.getPriceRule().length() > 2) {
                String role = shiguShop.getPriceRule();
                String[] split = role.split(";");
                if (split.length == 2) {
                    c = split[0];
                    try {mod = Integer.valueOf(split[1]);} catch (Exception ignored){}
                }
            }
            if (c == null) {
                c = "p";
            }

            return ModHandle.modOf(mod).handle(matchPrice(c, strs), price);
        }
        return price;
    }

    @Override
    public Long pickPipriceFromTitle(Long shopId,String webSite, Long itemId, Long numIid, Long price, String... strs) {
        return null;
    }

    interface ModH {
        Long handle(List<Long> prices, Long oldPrice);
    }

    enum ModHandle implements ModH {

        /**
         * 直接取匹配得到的最后一个Long值
         */
        MOD1(1) {
            @Override
            public Long handle(List<Long> prices, Long oldPrice) {
                if (prices.isEmpty()) {
                    return oldPrice;
                }
                return prices.get(prices.size() - 1);
            }
        },

        /**
         * 取最后一个，如果大于原价，不采纳
         */
        MOD2(2) {
            @Override
            public Long handle(List<Long> prices, Long oldPrice) {
                Long lastPrice = MOD1.handle(prices, oldPrice);
                return lastPrice > oldPrice ? oldPrice : lastPrice;
            }
        },

        /**
         * 最后一个，取最大小于原价
         */
        MOD3(3) {
            @Override
            public Long handle(List<Long> prices, Long oldPrice) {
                Long handle = MOD1.handle(prices, oldPrice);
                if (!Objects.equals(handle, oldPrice)) {
                    Long price = MOD2.handle(prices, oldPrice);
                    if (!Objects.equals(price, oldPrice)) {
                        return price;
                    } else {
                        do {
                            handle /= 10;
                        } while (handle > oldPrice);
                        return handle;
                    }
                }
                return oldPrice;
            }
        };

        private int mod;

        ModHandle(int mod) {
            this.mod = mod;
        }

        private static ModHandle modOf(int mod) {
            for (ModHandle modHandle : values()) {
                if (modHandle.mod == mod) {
                    return modHandle;
                }
            }
            return values()[0];
        }
    }
}
