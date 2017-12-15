package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.CategoryAttrJosVO;
import com.shigu.main4.jd.vo.JdCategoryVO;
import com.shigu.main4.jd.vo.ShopCategoryVO;
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
    List<ShopCategoryVO> getJdSellercats(String accessToken) throws  JdUpException;

    /**
     * 京东 获取类目属性列表
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    List<CategoryAttrJosVO> getJdCategoryAttrJos(String accessToken) throws  JdUpException;

    /**
     * 京东 商家类目信息
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    List<JdCategoryVO> getJdWarecats(String accessToken) throws  JdUpException;

}
