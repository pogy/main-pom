package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.seller.ShopSafService.ShopJosResult;
import com.jd.open.api.sdk.request.seller.VenderShopQueryRequest;
import com.jd.open.api.sdk.request.sellercat.SellerCatsGetRequest;
import com.jd.open.api.sdk.response.seller.VenderShopQueryResponse;
import com.opentae.data.jd.beans.JdSessionMap;
import com.opentae.data.jd.beans.JdShopInfo;
import com.opentae.data.jd.interfaces.JdSessionMapMapper;
import com.opentae.data.jd.interfaces.JdShopInfoMapper;
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

    @Autowired
    private JdSessionMapMapper jdSessionMapMapper;

    @Autowired
    private JdShopInfoMapper jdShopInfoMapper;

    /**
     * 京东店铺信息查询
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    private JdShopInfoVO getJdShopInfo(String accessToken) throws JdUpException {
        VenderShopQueryRequest request = new VenderShopQueryRequest();
        VenderShopQueryResponse response = jdUtil.execute(request,accessToken);
        ShopJosResult shopJosResult = response.getShopJosResult();
        return BeanMapper.map(shopJosResult, JdShopInfoVO.class);
    }

    /**
     * 京东店铺信息查询
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    @Override
    public JdShopInfoVO getJdShopInfo(Long jdUid) {
        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setJdUid(jdUid);
        jdSessionMap = jdSessionMapMapper.selectOne(jdSessionMap);
        if (jdSessionMap == null) {
            return null;
        }
        JdShopInfo jdShopInfo = new JdShopInfo();
        jdShopInfo.setJdUid(jdSessionMap.getJdUid());
        jdShopInfo = jdShopInfoMapper.selectOne(jdShopInfo);
        if (jdShopInfo == null) {
            return null;
        }
        JdShopInfoVO jdShopInfoVO = new JdShopInfoVO();
        jdShopInfoVO.setJdUid(jdSessionMap.getJdUid());
        jdShopInfoVO.setShopId(jdShopInfo.getJdShopId());
        jdShopInfoVO.setShopName(jdShopInfo.getJdShopName());
        jdShopInfoVO.setLogoUrl(jdShopInfo.getJdShopLogoUrl());
        jdShopInfoVO.setCategoryMain(jdShopInfo.getCategoryMain());
        jdShopInfoVO.setCategoryMainName(jdShopInfo.getCategoryMainName());
        jdShopInfoVO.setVenderId(jdShopInfo.getVenderId());
        jdShopInfoVO.setBrief(jdShopInfo.getBrief());
        jdShopInfoVO.setOpenTime(jdShopInfo.getOpenTime());
        return jdShopInfoVO;
    }

    /**
     * 京东店铺信息查询（京东API查询）,并记（更新）到库
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    @Override
    public JdShopInfoVO getJdShopInfoByJdApi(Long jdUid) throws JdUpException {
        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setJdUid(jdUid);
        jdSessionMap = jdSessionMapMapper.selectOne(jdSessionMap);
        if (jdSessionMap == null) {
            throw new JdUpException("更新京东店铺信息失败");
        }

        JdShopInfo jdShopInfo = new JdShopInfo();
        jdShopInfo.setJdUid(jdSessionMap.getJdUid());
        JdShopInfo selJdShopInfo = jdShopInfoMapper.selectOne(jdShopInfo);

        JdShopInfoVO  newJdShopInfo = getJdShopInfo(jdSessionMap.getAccessToken());

        if (selJdShopInfo == null) {
            jdShopInfo.setJdUid(jdSessionMap.getJdUid());
            jdShopInfo.setJdShopId(newJdShopInfo.getShopId());
            jdShopInfo.setJdShopName(newJdShopInfo.getShopName());
            jdShopInfo.setJdShopLogoUrl(newJdShopInfo.getLogoUrl());
            jdShopInfo.setCategoryMain(newJdShopInfo.getCategoryMain());
            jdShopInfo.setCategoryMainName(newJdShopInfo.getCategoryMainName());
            jdShopInfo.setVenderId(newJdShopInfo.getVenderId());
            jdShopInfo.setBrief(newJdShopInfo.getBrief());
            jdShopInfo.setOpenTime(newJdShopInfo.getOpenTime());
            jdShopInfoMapper.insertSelective(jdShopInfo);
        }else {
            jdShopInfo.setId(selJdShopInfo.getId());
            jdShopInfo.setJdUid(jdSessionMap.getJdUid());
            jdShopInfo.setJdShopId(newJdShopInfo.getShopId());
            jdShopInfo.setJdShopName(newJdShopInfo.getShopName());
            jdShopInfo.setJdShopLogoUrl(newJdShopInfo.getLogoUrl());
            jdShopInfo.setCategoryMain(newJdShopInfo.getCategoryMain());
            jdShopInfo.setCategoryMainName(newJdShopInfo.getCategoryMainName());
            jdShopInfo.setVenderId(newJdShopInfo.getVenderId());
            jdShopInfo.setBrief(newJdShopInfo.getBrief());
            jdShopInfo.setOpenTime(newJdShopInfo.getOpenTime());
            jdShopInfoMapper.updateByPrimaryKeySelective(jdShopInfo);
        }

        newJdShopInfo.setJdUid(jdSessionMap.getJdUid());
        return newJdShopInfo;
    }


}
