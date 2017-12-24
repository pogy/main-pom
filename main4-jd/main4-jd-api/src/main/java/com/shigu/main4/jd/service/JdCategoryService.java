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
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    List<JdShopCategoryVO> getJdSellercats(String accessToken) throws  JdUpException;

    /**
     * 京东 获取类目属性列表
     * 属性类型:1.关键属性 2.不变属性 3.可变属性 4.销售属性
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    List<JdCategoryAttrJosVO> getJdCategoryAttrJos(String accessToken,Long cid,Integer type) throws  JdUpException;

    /**
     * 京东 商家类目信息
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    List<JdCategoryVO> getJdWarecats(String accessToken) throws  JdUpException;

    /**
     * 根据父级类目Id获取子集类目信息
     * @param accessToken
     * @param pid 父类目id
     * @return
     * @throws JdUpException
     */
    List<JdCategoryReadVO> getJdCategoryByPid(String accessToken,Long pid) throws JdUpException ;

    /**
     * 获取类目属性值
     * @param token
     * @param pid
     * @return
     * @throws JdUpException
     */
    List<JdCategoryAttrValueJosVO> getCategoryReadFindValuesByAttrId(String token, Long pid) throws JdUpException;

}
