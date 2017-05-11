package com.shigu.main4.goat.beans;

import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;

import java.util.List;

/**
 * 广告位置
 * Created by zhaohongbo on 17/5/4.
 */
public abstract class GoatLocation extends GoatLocationVO{
    public abstract <T extends GoatVO> List<T> selGoats() throws GoatException;
    public abstract <T extends GoatVO> List<T> selGoatsByTermId(Long termId) throws GoatException;
}
