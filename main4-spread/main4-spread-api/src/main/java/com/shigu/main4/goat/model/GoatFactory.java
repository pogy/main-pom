package com.shigu.main4.goat.model;

import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.model.Goat;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;


/**
 * 广告工厂类
 *
 * GoatLocation getALocation(String code)
 Goat selGoatById(Long goatId)
 Goat selGoatByVo(Goat goat)
 * Created by zhaohongbo on 17/5/4.
 */
public interface GoatFactory {
    /**
     * 按localID查
     * @param localId
     * @return
     * @throws GoatException
     */
    GoatLocation getAlocation(Long localId) throws GoatException;
    /**
     * 按广告位编号获取广告对象
     * @param code
     * @return
     */
    GoatLocation getALocation(String code) throws GoatException;

    /**
     * 按广告位值获取广告对象
     * @param vo
     * @return
     */
    GoatLocation getALocationByVo(GoatLocationVO vo);

    /**
     * 按广告ID获取广告对象
     * @param goatId
     * @param <T>
     * @return
     */
    <T extends Goat>T selGoatById(Long goatId) throws GoatException;

    <T extends Goat>T selGoatPrepareById(Long goatId) throws GoatException;

    /**
     * 按广告值获取广告对象
     * @param goatVO
     * @param <T>
     * @return
     */
    <T extends Goat,D extends GoatVO> T selGoatByVo(D goatVO);
}
