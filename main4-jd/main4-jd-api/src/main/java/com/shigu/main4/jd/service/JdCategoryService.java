package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
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
     * @param jdUid
     * @throws JdException
     */
    List<JdShopCategoryVO> getJdSellercats(Long jdUid) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 更新京东自定义店内分类
     * @param jdUid
     * @throws JdException
     */
    List<JdShopCategoryVO> updateJdSellercats(Long jdUid) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 京东 获取类目属性列表
     * 属性类型:1.关键属性 2.不变属性 3.可变属性 4.销售属性
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    List<JdCategoryAttrJosVO> getJdCategoryAttrJos(Long jdUid,Long cid,Integer type) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 京东 商家类目信息
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    List<JdCategoryVO> getJdWarecats(Long jdUid) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 根据父级类目Id获取子集类目信息
     * @param jdUid
     * @param pid 父类目id
     * @return
     * @throws JdUpException
     */
    List<JdCategoryReadVO> getJdCategoryByPid(Long jdUid,Long pid) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 获取类目属性值
     * @param jdUid
     * @param pid
     * @return
     * @throws JdUpException
     */
    List<JdCategoryAttrValueJosVO> getCategoryReadFindValuesByAttrId(Long jdUid, Long pid) throws JdUpException, JdAuthFailureException, IOException;

    /**
     * 获取用户所拥有的品牌
     * @param jdUid
     * @return
     */
    List<JdVenderBrandPubInfoVO>  getAllBrand(Long jdUid) throws JdUpException, JdAuthFailureException, IOException;


}
