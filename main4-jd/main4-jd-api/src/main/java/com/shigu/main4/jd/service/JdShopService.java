package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdImgzoneCategoryVO;
import com.shigu.main4.jd.vo.JdShopInfoVO;

import java.io.IOException;
import java.util.List;

/**
 * Created By admin on 2017/12/14/16:54
 * 京东店铺Service
 */
public interface JdShopService {
    /**
     * 京东店铺信息查询（只取数据库）
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    JdShopInfoVO getJdShopInfo(Long jdUid) throws JdUpException;

    /**
     * 京东店铺信息查询（京东API查询）,并记（更新）到库
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    JdShopInfoVO getJdShopInfoByJdApi(Long jdUid) throws JdUpException;

    /**
     * 新增京东店铺内图片空间
     * @param jdUid
     * @param imgCategory
     * @param parentCateId
     * @return 图片分类ID
     * @throws JdException
     */
    Long addImgCategory (Long jdUid,String imgCategory,Long parentCateId) throws JdUpException;

    /**
     * 查询京东店铺内图片空间
     * @param jdUid
     * @param imgCategory
     * @param parentCateId
     * @return 图片分类ID
     * @throws JdException
     */
    List<JdImgzoneCategoryVO> selImgCategory (Long jdUid, String imgCategory, Long parentCateId) throws JdUpException;

}
