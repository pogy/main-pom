package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.seller.ShopSafService.ShopJosResult;
import com.jd.open.api.sdk.request.seller.VenderShopQueryRequest;
import com.jd.open.api.sdk.response.seller.VenderShopQueryResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdShopService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdShopInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created By admin on 2017/12/14/16:54
 * 京东店铺Service
 */
@Service("jdShopService")
public class JdShopServiceImpl implements JdShopService {

    @Autowired
    private JdUtil jdUtil;

    /**
     * 京东店铺信息查询
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    @Override
    public JdShopInfoVO getJdShopInfo(String accessToken) throws JdUpException {
        VenderShopQueryRequest request = new VenderShopQueryRequest();
        VenderShopQueryResponse response;
        response = jdUtil.execute(request,accessToken);
        ShopJosResult shopJosResult = response.getShopJosResult();
        return BeanMapper.map(shopJosResult, JdShopInfoVO.class);
    }


}
