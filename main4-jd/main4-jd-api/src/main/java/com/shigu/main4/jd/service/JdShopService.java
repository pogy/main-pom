package com.shigu.main4.jd.service;

import com.jd.open.api.sdk.JdException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.vo.JdShopInfoVO;

import java.io.IOException;

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

}
