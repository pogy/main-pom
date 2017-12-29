package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.seller.ShopSafService.ShopJosResult;
import com.jd.open.api.sdk.request.imgzone.ImgzoneCategoryAddRequest;
import com.jd.open.api.sdk.request.imgzone.ImgzoneCategoryQueryRequest;
import com.jd.open.api.sdk.request.seller.VenderShopQueryRequest;
import com.jd.open.api.sdk.response.imgzone.ImgzoneCategory;
import com.jd.open.api.sdk.response.imgzone.ImgzoneCategoryAddResponse;
import com.jd.open.api.sdk.response.imgzone.ImgzoneCategoryQueryResponse;
import com.jd.open.api.sdk.response.seller.VenderShopQueryResponse;
import com.opentae.data.jd.beans.JdShopInfo;
import com.opentae.data.jd.interfaces.JdSessionMapMapper;
import com.opentae.data.jd.interfaces.JdShopInfoMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.ImgZoneException;
import com.shigu.main4.jd.exceptions.JdApiException;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdShopService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import com.shigu.main4.jd.vo.JdImgzoneCategoryVO;
import com.shigu.main4.jd.vo.JdShopInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By admin on 2017/12/14/16:54
 * 京东店铺Service
 */
@Service("jdShopService")
public class JdShopServiceImpl implements JdShopService {

    @Autowired
    private JdUtil jdUtil;

    @Autowired
    private JdShopInfoMapper jdShopInfoMapper;
    @Autowired
    JdAuthService jdAuthService;

    /**
     * 京东店铺信息查询
     * @param accessToken
     * @throws JdException
     * @throws IOException
     */
    private JdShopInfoVO getJdShopInfo(String accessToken) throws JdAuthFailureException, JdApiException {
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
    public JdShopInfoVO getJdShopInfo(Long jdUid) throws JdAuthFailureException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        JdShopInfo jdShopInfo = new JdShopInfo();
        jdShopInfo.setJdUid(authedInfo.getUid());
        jdShopInfo = jdShopInfoMapper.selectOne(jdShopInfo);
        if (jdShopInfo == null) {
            return null;
        }
        JdShopInfoVO jdShopInfoVO = new JdShopInfoVO();
        jdShopInfoVO.setJdUid(authedInfo.getUid());
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
    public JdShopInfoVO getJdShopInfoByJdApi(Long jdUid) throws JdAuthFailureException, JdApiException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);

        JdShopInfo jdShopInfo = new JdShopInfo();
        jdShopInfo.setJdUid(authedInfo.getUid());
        JdShopInfo selJdShopInfo = jdShopInfoMapper.selectOne(jdShopInfo);

        JdShopInfoVO  newJdShopInfo = getJdShopInfo(authedInfo.getAccessToken());

        if (selJdShopInfo == null) {
            jdShopInfo.setJdUid(authedInfo.getUid());
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
            jdShopInfo.setJdUid(authedInfo.getUid());
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

        newJdShopInfo.setJdUid(authedInfo.getUid());
        return newJdShopInfo;
    }

    /**
     * 新增京东店铺内图片空间
     * @param jdUid
     * @param imgCategory
     * @param parentCateId
     * @return 图片分类ID
     * @throws JdException
     */
    @Override
    public Long addImgCategory(Long jdUid, String imgCategory,Long parentCateId) throws JdAuthFailureException, ImgZoneException, JdApiException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);

        ImgzoneCategoryAddRequest request=new ImgzoneCategoryAddRequest();
        request.setCateName(imgCategory);
        if (parentCateId != null) {
            request.setParentCateId(parentCateId);
        }
        ImgzoneCategoryAddResponse response = jdUtil.execute(request, authedInfo.getAccessToken());
        if (response.getReturnCode() == 0) {
            throw new ImgZoneException("新增图片分类失败");
        }
        return response.getCateId();
    }

    @Override
    public List<JdImgzoneCategoryVO> selImgCategory(Long jdUid, String imgCategory, Long parentCateId) throws JdAuthFailureException, ImgZoneException, JdApiException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        ImgzoneCategoryQueryRequest selRequest = new ImgzoneCategoryQueryRequest();
        selRequest.setCateName(imgCategory);
        if (parentCateId != null) {
            selRequest.setParentCateId(parentCateId);
        }
        ImgzoneCategoryQueryResponse selResponse = jdUtil.execute(selRequest, authedInfo.getAccessToken());
        if (selResponse.getReturnCode() == 0) {
            throw new ImgZoneException("查询图片分类失败");
        }
        List<ImgzoneCategory> cateList = selResponse.getCateList();
        if (cateList == null || cateList.isEmpty()) {
            return null;
        }
        List<JdImgzoneCategoryVO> vos = new ArrayList<>();
        for(ImgzoneCategory item : cateList){
            JdImgzoneCategoryVO vo = new JdImgzoneCategoryVO();
            vo.setCateId(item.getCateId());
            vo.setCateLevel(item.getCateLevel());
            vo.setCateName(item.getCateName());
            vo.setCateOrder(item.getCateOrder());
            vo.setParentCateId(item.getParentCateId());
            vo.setCreated(item.getCreated());
            vo.setModified(item.getModified());
            vos.add(vo);
        }
        return vos;
    }


}
