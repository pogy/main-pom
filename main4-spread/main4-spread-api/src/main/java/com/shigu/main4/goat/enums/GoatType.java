package com.shigu.main4.goat.enums;

import com.shigu.main4.goat.vo.ImgGoatVO;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.goat.vo.TextGoatVO;

/**
 * 广告类型
 * Created by zhaohongbo on 17/5/5.
 */
public enum GoatType {
    ImgGoat(ImgGoatVO.class),
    ItemGoat(ItemGoatVO.class),
    TextGoat(TextGoatVO.class);

    GoatType(Class<?> goatTypeClass) {
        this.goatTypeClass = goatTypeClass;
    }

    private Class<?> goatTypeClass;

    public Class<?> getGoatTypeClass() {
        return goatTypeClass;
    }

    public void setGoatTypeClass(Class<?> goatTypeClass) {
        this.goatTypeClass = goatTypeClass;
    }
}
