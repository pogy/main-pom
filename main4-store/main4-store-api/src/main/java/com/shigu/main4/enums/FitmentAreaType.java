package com.shigu.main4.enums;

/**
 * Created by wxc on 2017/4/14.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public enum FitmentAreaType {
    /**
     * 通栏
     */
    CENTER,
    /**
     * 页头区域
     */
    BANNER,
    /**
     * 左右
     */
    LEFTRIGHT,
    ;

    public int value() {
        return this.ordinal() + 1;
    }

    public static FitmentAreaType typeOf(Integer type) {
        return values()[type - 1];
    }
}
