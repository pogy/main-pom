package com.shigu.main4.order.utils;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.tools
 * @ClassName: MoneyUtil
 * @Author: sy
 * @CreateDate: 2018/4/9 0009 13:22
 */
public class MoneyUtil {
    public static Integer moneyToCent(Double money){
        Double m = money * 100;
        return m.intValue();
    }

    
    public static Double moneyToDollar(Integer money){
        Double m = Double.valueOf(money)/100;
        return m;
    }
}
