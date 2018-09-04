package com.shigu.main4.storeservices.vo;

import com.shigu.main4.vo.ShopShow;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 市场列表店铺档口排序
 *
 * @author shigu_zjb
 * @date 2017/02/2/28 13:47
 * <p>
 * <p>排序规则</p>
 * 1.按shopNum进行字母顺序升序排列
 * 2.如果碰到-，则只识别-前面部分，如果-前面部分一样，则-后面部分进行字母升序
 * <p>
 * method<compare>return:1升序 -1降序 0保持不变
 */
public class HzMarketShopListComparator implements Comparator<ShopShow> {
    
    @Override
    public int compare(ShopShow o1, ShopShow o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }
        if (o1.getFloorId().equals(o2.getFloorId())) {
            String shopNumo1 = o1.getSortOrderKey().trim();
            String shopNumo2 = o2.getSortOrderKey().trim();
            return shopNumo1.compareTo(shopNumo2);
        } else {
            int floor1 = floorNumber(o1.getFloor());
            int floor2 = floorNumber(o2.getFloor());
            return floor1-floor2;
        }
    }
    private int floorNumber(String floor) {
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(floor);
        if (m.find() && !"".equals(m.group())) {
            return Integer.valueOf(m.group());
        } else {
            return 100;
        }
    }

}
