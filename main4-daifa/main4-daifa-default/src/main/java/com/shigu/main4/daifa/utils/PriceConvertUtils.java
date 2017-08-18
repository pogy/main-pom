package com.shigu.main4.daifa.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by whx on 2017/7/20 0020.
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
    public static Long StringToLong(String price){
        BigDecimal mon = new BigDecimal(price);
        BigDecimal mon100 = new BigDecimal("100");
        return mon.multiply(mon100).longValue();

    }

    public static String doublePriceToString(Double price) {
        if (price == null) {
            return "--";
        }
        Double priceValue = price.doubleValue();
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(priceValue);
    }

    public static String stringPriceToString(String price) {
        if (price == null) {
            return "--";
        }
        Double priceValue = Double.parseDouble (price);
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(priceValue);
    }
}