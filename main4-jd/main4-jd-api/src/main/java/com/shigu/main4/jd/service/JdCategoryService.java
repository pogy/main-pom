package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.*;

import java.io.IOException;
import java.util.List;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东类目接口
 */
public interface JdCategoryService {

    /**
     * 京东自定义店内分类
     * @param userId
     * @throws JdException
     */
    List<JdShopCategoryVO> getJdSellercats(Long userId) throws  JdUpException;

    /**
     * 京东 获取类目属性列表
     * 属性类型:1.关键属性 2.不变属性 3.可变属性 4.销售属性
     * @param userId
     * @throws JdException
     * @throws IOException
     */
    List<JdCategoryAttrJosVO> getJdCategoryAttrJos(Long userId,Long cid,Integer type) throws  JdUpException;

    /**
     * 京东 商家类目信息
     * @param userId
     * @throws JdException
     * @throws IOException
     */
    List<JdCategoryVO> getJdWarecats(Long userId) throws  JdUpException;

    /**
     * 根据父级类目Id获取子集类目信息
     * @param userId
     * @param pid 父类目id
     * @return
     * @throws JdUpException
     */
    List<JdCategoryReadVO> getJdCategoryByPid(Long userId,Long pid) throws JdUpException ;

    /**
     * 获取类目属性值
     * @param userId
     * @param pid
     * @return
     * @throws JdUpException
     */
    List<JdCategoryAttrValueJosVO> getCategoryReadFindValuesByAttrId(Long userId, Long pid) throws JdUpException;

    /**
     * 获取用户所拥有的品牌
     * @param userId
     * @return
     */
    List<JdVenderBrandPubInfoVO>  getAllBrand(Long userId) throws JdUpException;


}
