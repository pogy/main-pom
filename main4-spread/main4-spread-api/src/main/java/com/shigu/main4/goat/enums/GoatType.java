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

    GoatType(Class<?> goatVoClass) {
        this.goatVoClass = goatVoClass;
    }

    /**
     * 值中类别
     */
    private Class<?> goatVoClass;
    /**
     * 对象类别
     */
    private Class<?> goatBeanClass;

    public Class<?> getGoatVoClass() {
        return goatVoClass;
    }

    public void setGoatVoClass(Class<?> goatVoClass) {
        this.goatVoClass = goatVoClass;
    }

    public Class<?> getGoatBeanClass() {
        return goatBeanClass;
    }

    public void setGoatBeanClass(Class<?> goatBeanClass) {
        this.goatBeanClass = goatBeanClass;
    }
}
