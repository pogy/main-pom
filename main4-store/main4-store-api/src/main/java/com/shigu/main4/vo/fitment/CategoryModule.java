package com.shigu.main4.vo.fitment;

import com.shigu.main4.enums.FitmentModuleType;
import com.shigu.main4.vo.FitmentModule;

/**
 * 宝贝分类模块
 * Created by Administrator on 2017/4/18 0018.
 */
public class CategoryModule extends FitmentModule {
    @Override
    public Integer getModuleType() {
        return FitmentModuleType.Category.value;
    }
}
