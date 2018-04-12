package com.shigu.main4.common.util;

import java.math.BigDecimal;

/**
 * Created by pc on 2015-12-26.
 */
public class MoneyUtil {

    public static String dealPrice(Long price){
        String gewei="";
        if(Math.abs((price%100))<10){
            gewei+="0"+ Math.abs((price%100));
        }else{
            gewei+= Math.abs((price%100));
        }
        return (price/100)+"."+gewei;
    }

    public static Long StringToLong(String price){
        BigDecimal mon = new BigDecimal(price);
        BigDecimal mon100 = new BigDecimal("100");
        return mon.multiply(mon100).longValue();

    }

    public static void main(String[] args) {

        //System.out.println(StringToLong("4.15"));


    }


}
