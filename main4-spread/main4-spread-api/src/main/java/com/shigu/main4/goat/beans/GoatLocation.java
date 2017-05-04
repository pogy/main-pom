package com.shigu.main4.goat.beans;

import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.vo.GoatLocationVO;

import java.util.List;

/**
 * 广告位置
 * Created by zhaohongbo on 17/5/4.
 */
public abstract class GoatLocation extends GoatLocationVO{
    public abstract List<Goat> selGoats();
}
