package com.shigu.jd.api.service;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.seller.ShopSafService.ShopJosResult;
import com.jd.open.api.sdk.request.imgzone.ImgzoneCategoryAddRequest;
import com.jd.open.api.sdk.request.imgzone.ImgzoneCategoryQueryRequest;
import com.jd.open.api.sdk.request.seller.VenderShopQueryRequest;
import com.jd.open.api.sdk.response.imgzone.ImgzoneCategory;
import com.jd.open.api.sdk.response.imgzone.ImgzoneCategoryAddResponse;
import com.jd.open.api.sdk.response.imgzone.ImgzoneCategoryQueryResponse;
import com.jd.open.api.sdk.response.seller.VenderShopQueryResponse;
import com.openJar.beans.JdAuthedInfo;
import com.openJar.beans.SdkJdImgzoneCategory;
import com.openJar.beans.SdkJdShopInfo;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.responses.api.JdAuthedInfoResponse;
import com.openJar.responses.api.JdImgzoneCategoryResponse;
import com.openJar.responses.api.JdShopInfoResponse;
import com.opentae.data.jd.beans.JdShopInfo;
import com.opentae.data.jd.interfaces.JdShopInfoMapper;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.exceptions.ImgZoneException;
import com.shigu.jd.api.exceptions.JdAuthFailureException;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By admin on 2017/12/14/16:54
 * 京东店铺Service
 */
@Service
public class JdShopService {

    @Autowired
    private JdClientService jdClientService;

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
    private SdkJdShopInfo getJdShopInfo(String accessToken) throws JdAuthOverdueException, OtherCustomException {
        VenderShopQueryRequest request = new VenderShopQueryRequest();
        VenderShopQueryResponse response = jdClientService.execute(request,accessToken);
        ShopJosResult shopJosResult = response.getShopJosResult();
        return BeanMapper.map(shopJosResult, SdkJdShopInfo.class);
    }

    /**
     * 京东店铺信息查询
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    public SdkJdShopInfo getJdShopInfo(Long jdUid) throws JdAuthFailureException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        JdShopInfo jdShopInfo = new JdShopInfo();
        jdShopInfo.setJdUid(authedInfo.getUid());
        jdShopInfo = jdShopInfoMapper.selectOne(jdShopInfo);
        if (jdShopInfo == null) {
            return null;
        }
        SdkJdShopInfo jdShopInfoVO = new SdkJdShopInfo();
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
    public SdkJdShopInfo getJdShopInfoByJdApi(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);

        JdShopInfo jdShopInfo = new JdShopInfo();
        jdShopInfo.setJdUid(authedInfo.getUid());
        JdShopInfo selJdShopInfo = jdShopInfoMapper.selectOne(jdShopInfo);

        SdkJdShopInfo  newJdShopInfo = getJdShopInfo(authedInfo.getAccessToken());

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
    public Long addImgCategory(Long jdUid, String imgCategory,Long parentCateId) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);

        ImgzoneCategoryAddRequest request=new ImgzoneCategoryAddRequest();
        request.setCateName(imgCategory);
        if (parentCateId != null) {
            request.setParentCateId(parentCateId);
        }
        ImgzoneCategoryAddResponse response = jdClientService.execute(request, authedInfo.getAccessToken());
        if (response.getReturnCode() == 0) {
            throw new OtherCustomException("新增图片分类失败:"+response.getDesc());
        }
        return response.getCateId();
    }

    public List<SdkJdImgzoneCategory> selImgCategory(Long jdUid, String imgCategory, Long parentCateId) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        ImgzoneCategoryQueryRequest selRequest = new ImgzoneCategoryQueryRequest();
        selRequest.setCateName(imgCategory);
        if (parentCateId != null) {
            selRequest.setParentCateId(parentCateId);
        }
        ImgzoneCategoryQueryResponse selResponse = jdClientService.execute(selRequest, authedInfo.getAccessToken());
        if (selResponse.getReturnCode() == 0) {
            throw new OtherCustomException("查询图片分类失败");
        }
        List<ImgzoneCategory> cateList = selResponse.getCateList();
        if (cateList == null || cateList.isEmpty()) {
            return new ArrayList<>();
        }
        List<SdkJdImgzoneCategory> vos = new ArrayList<>();
        for(ImgzoneCategory item : cateList){
            SdkJdImgzoneCategory vo = new SdkJdImgzoneCategory();
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
