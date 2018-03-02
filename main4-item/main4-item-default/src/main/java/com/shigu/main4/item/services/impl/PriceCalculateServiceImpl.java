package com.shigu.main4.item.services.impl;

import com.opentae.data.mall.beans.GoodsPiPriceError;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.GoodsPiPriceErrorExample;
import com.opentae.data.mall.interfaces.GoodsPiPriceErrorMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.item.services.PriceCalculateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("priceCalculateService")
public class PriceCalculateServiceImpl implements PriceCalculateService {

    private static final Logger logger = LoggerFactory.getLogger(PriceCalculateServiceImpl.class);

    /**
     * 默认的批发价解析规则
     */
    private static final Pattern DEFAULT_P_RULE = Pattern.compile("[^a-zA-Z][p|P](\\d+(\\.[0-9]*)?)");
    private static final Pattern DEFAULT_F_RULE = Pattern.compile("[^a-zA-Z][f|F](\\d+(\\.[0-9]*)?)");

    private static final Pattern NUMBER = Pattern.compile("[1-9]\\d*(\\.\\d*)?|0\\.\\d*[1-9]\\d*");

    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    private GoodsPiPriceErrorMapper goodsPiPriceErrorMapper;
    /**
     * 计算批发价
     * @param shopId 店铺ID
     * @param price 原价,分为单位
     * @param strs 来源   {标题 , 货号  ,  外部编号,,,,} 将以此顺序匹配
     *                  {title,huohao,outerId,,,,}
     * @return 批发价
     */
    @Override
    public Long pickPipriceFromTitle(Long shopId, Long price, String ... strs) {
        Pattern pattern = null;

        //如果店铺有设置price_rule，以price_rule进行正则匹配
        ShiguShop shiguShop;
        if (shopId != null && (shiguShop = shiguShopMapper.selectByPrimaryKey(shopId)) != null) {
            try {
                pattern = Pattern.compile(shiguShop.getPriceRule());
            } catch (Exception ignored) {
                logger.info("批发价规则解析：店铺没有设置批发价规则或者规则不是合法的正则表达式，应用默认规则");
            }
        } else {
            logger.info("批发价规则解析：店铺没有找到，应用默认规则");
        }

        //标题(title) > 货号(goods_no) > 商家外部编号(outer_id)
        List<Long> piPrices = new ArrayList<>(strs.length);
        List<Long> errPrices = new ArrayList<>(strs.length);
        for (String s : strs) {
            if (StringUtils.isEmpty(s))
                continue;
            Long piPrice = pickString(pattern, "0" + s);
            if (piPrice != null) {
                //批价区间	批价/原价占比	处置方案
                //10元以下	小于10%	舍弃
                //10元以上	小于15%	舍弃
                //30元以上	小于5%	舍弃
                //50元以上	小于1%	舍弃
                //批发价大于原价      取最大小于原价，如：唯一检测P602017 原价98 6 < 98 60 < 98 最终得到60为匹配价
                boolean discard = piPrice < 1000 && piPrice * 10 < price
                        ||    piPrice > 1000 && piPrice <= 3000 && piPrice * 100 / 15 < price
                        ||    piPrice > 3000 && piPrice <= 5000 && piPrice * 100 / 5 < price
                        ||    piPrice > 5000  && piPrice * 100 < price;
                boolean isErrPrice;
                if (discard) {
                    continue;
                } else if (isErrPrice = piPrice > price) {
                    String s2 = String.format("%.2f", piPrice / 100.0);
                    String piStr = "";
                    double priceD = price / 100.0;
                    for (int i = 0; i < s2.length(); i++) {
                        piStr += s2.charAt(i);
                        Double pi = Double.valueOf(piStr);
                        if (pi > priceD) {
                            break;
                        }
                        Double piD = pi * 100;
                        piPrice = piD.longValue();
                    }
                    // 处理完还大于的放弃掉
                    if (piPrice > price)
                        continue;
                }
                if (isErrPrice)
                    errPrices.add(piPrice);
                else
                    piPrices.add(piPrice);
            }
        }
        for (Long piPrice : piPrices) {
            return piPrice;
        }
        for (Long errPrice : errPrices) {
            return errPrice;
        }
        return price; // 没有匹配到的返回原价
    }

    @Override
    public Long pickPipriceFromTitle(Long shopId,String webSite,Long itemId,Long numIid, Long price, String... strs) {
        //标题(title) > 货号(goods_no) > 商家外部编号(outer_id)
        List<Long> piPrices = new ArrayList<>(strs.length);
        Set<Long> allPrices = new HashSet<>();
        boolean isErr=false;
        for (String s : strs) {
            if (StringUtils.isEmpty(s)) {
                continue;
            }
            Long piPrice = pickString(null, "0" + s);
            if (piPrice != null) {
                allPrices.add(piPrice);
                //批价区间	批价/原价占比	处置方案
                //10元以下	小于10%	舍弃
                //10元以上	小于15%	舍弃
                //30元以上	小于5%	舍弃
                //50元以上	小于1%	舍弃
                boolean discard = piPrice < 1000 && piPrice * 10 < price
                        ||    piPrice > 1000 && piPrice <= 3000 && piPrice * 100 / 15 < price
                        ||    piPrice > 3000 && piPrice <= 5000 && piPrice * 100 / 5 < price
                        ||    piPrice > 5000  && piPrice * 100 < price;
                if (discard) {
                    isErr=true;
                    continue;
                }
                if(piPrice > price){
                    isErr=true;
                }
                piPrices.add(piPrice);
            }
        }
        Long returnPrice=price;
        if(piPrices.size()>0){
            returnPrice= piPrices.get(0);
        }else{
            isErr=true;
        }
        if(itemId!=null||numIid!=null){
            GoodsPiPriceErrorExample goodsPiPriceErrorExample=new GoodsPiPriceErrorExample();
            goodsPiPriceErrorExample.setOrderByClause("create_time asc");
            GoodsPiPriceErrorExample.Criteria ca=goodsPiPriceErrorExample.createCriteria();
            if(itemId!=null){
                ca.andGoodsIdEqualTo(itemId);
            }
            if(numIid!=null){
                ca.andNumIidEqualTo(numIid);
            }
            List<GoodsPiPriceError> ges=goodsPiPriceErrorMapper.selectByExample(goodsPiPriceErrorExample);
            GoodsPiPriceError g=new GoodsPiPriceError();
            g.setNumIid(numIid);
            g.setGoodsId(itemId);
            g.setHasEnt(0);
            g.setPrice(price);
            try {
                g.setTitle(strs[0]);
                g.setGoodsNo(strs[1]);
                g.setOtherId(strs[2]);
            } catch (Exception ignored) {
            }
            g.setSysPiPrice(returnPrice);
            g.setWebSite(webSite);
            StringBuilder pistr= new StringBuilder();
            for(Long p:piPrices){
                pistr.append(p).append(",");
            }
            if(pistr.length()>0){
                pistr = new StringBuilder(pistr.substring(0, pistr.length() - 1));
            }
            g.setErrorPiPrice(pistr.toString());
            if(ges.size()>0&&ges.get(0).getSysPiPrice().longValue()==returnPrice&&ges.get(0).getHasEnt()==1){
                //符合条件,意味着这个已经手动处理过了
                returnPrice= ges.get(0).getCustomPiPrice();
                //手动处理过,定义为批发价正常
                isErr=false;
            }
            if (isErr) {
                try {
                    if(ges.size()==0){
                        goodsPiPriceErrorMapper.insertSelective(g);
                    }else{
                        g.setPipriceId(ges.get(0).getPipriceId());
                        goodsPiPriceErrorMapper.updateByPrimaryKeySelective(g);
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return returnPrice;
    }



    /**
     * 批发价解析
     * @param pattern 正则 默认是 {@link #DEFAULT_P_RULE}
     * @param str 目标
     * @return 批发价
     */
    private Long pickString(Pattern pattern, String str) {
        Long l = null;
        String piPriceString;
        if (pattern != null) {
            piPriceString = findMatcher(pattern, str);
        } else {
            piPriceString = findMatcher(DEFAULT_P_RULE, str);
            if (piPriceString == null) {
                piPriceString = findMatcher(DEFAULT_F_RULE, str);
            }
        }
        if (piPriceString != null) {
            // 从符合规则的字符串中解出数字，元为单位的小数
            Matcher numMatch = NUMBER.matcher(piPriceString);
            // 需要保证 str 仅有一个匹配
            String lastNumber = null;
            while (numMatch.find()) {
                lastNumber = numMatch.group();
            }
            if (lastNumber != null) {
                Double num = Double.valueOf(lastNumber) * 100;
                l = num.longValue();
            }
        }
        return l;
    }

    private String findMatcher(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (!matcher.find())
                return group;
        }
        return null;
    }
}