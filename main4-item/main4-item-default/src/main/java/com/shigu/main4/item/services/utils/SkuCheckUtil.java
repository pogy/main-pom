package com.shigu.main4.item.services.utils;

public class SkuCheckUtil {
    /**
     * 判断属性是否是颜色
     * @param colorPid pid
     * @param name pname
     * @return is or not
     */
    public static boolean isColorProp(String colorPid, String name) {
        return "1627207,".contains(colorPid) || "颜色,颜色分类".contains(name);
    }

    /**
     * 判断属性是否是尺码
     * @param sizePid pid
     * @param name pname
     * @return is or not
     */
    public static boolean isSizeProp(String sizePid, String name) {
        return "20509,20518,20549,122216343".contains(sizePid) || "尺寸,尺码,鞋码,参考身高".contains(name);
    }
}
