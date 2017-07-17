package com.shigu.order.util;

import java.text.DecimalFormat;

/**
 * Created by whx on 2017/7/17 0017.
 */
public class PriceConvertUtils {

    public static String priceToString(Long price) {
        if (price == null) {
            return "--";
        }
        Double priceValue = price.doubleValue()/100;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(priceValue);
    }
}
