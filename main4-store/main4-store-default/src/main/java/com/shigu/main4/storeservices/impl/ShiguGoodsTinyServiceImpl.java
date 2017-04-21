package com.shigu.main4.storeservices.impl;


import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service("shiguGoodsTinyService")
public class ShiguGoodsTinyServiceImpl {

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    /**
     * 更新阿里旺旺信息
     *
     * @param website 站点
     * @param storeId 店铺ID
     * @param imWw    阿里旺旺
     */
    public int updateImWwByStoreId(String website, Long storeId, String imWw, String storeNum) {
        if (storeId == null) {
            return 0;
        }
        int result = shiguGoodsTinyMapper.updateImAliwwByStoreId(website, storeId, imWw, storeNum);
        return result;
    }

}
