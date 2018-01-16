package com.shigu.jd.api.service;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.category.Category;
import com.jd.open.api.sdk.domain.list.CategoryAttrReadService.CategoryAttrJos;
import com.jd.open.api.sdk.domain.list.CategoryAttrValueReadService.CategoryAttrValueJos;
import com.jd.open.api.sdk.domain.list.CategoryReadService.Feature;
import com.jd.open.api.sdk.domain.sellercat.ShopCategory;
import com.jd.open.api.sdk.request.category.CategorySearchRequest;
import com.jd.open.api.sdk.request.list.CategoryReadFindAttrsByCategoryIdJosRequest;
import com.jd.open.api.sdk.request.list.CategoryReadFindByPIdRequest;
import com.jd.open.api.sdk.request.list.CategoryReadFindValuesByAttrIdJosRequest;
import com.jd.open.api.sdk.request.list.PopVenderCenerVenderBrandQueryRequest;
import com.jd.open.api.sdk.request.sellercat.SellerCatsGetRequest;
import com.jd.open.api.sdk.response.category.CategorySearchResponse;
import com.jd.open.api.sdk.response.list.*;
import com.jd.open.api.sdk.response.sellercat.SellerCatsGetResponse;
import com.openJar.beans.JdCategoryAttrJos;
import com.openJar.beans.JdCategoryAttrValueJos;
import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.beans.SdkJdShopCategory;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.responses.api.*;
import com.opentae.data.jd.beans.JdShopCategory;
import com.opentae.data.jd.examples.JdShopCategoryExample;
import com.opentae.data.jd.interfaces.JdShopCategoryMapper;
import com.shigu.jd.api.exceptions.JdAuthFailureException;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东类目接口
 */
@Service
public class JdCategoryService {

    @Autowired
    private JdClientService jdClientService;

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdShopCategoryMapper jdShopCategoryMapper;


    /**
     * 京东自定义店内分类
     * @param jdUid
     * @throws JdException
     */
    public JdShopCategoryResponse getJdSellercats(Long jdUid) {
        JdShopCategoryResponse jdShopCategoryResponse = new JdShopCategoryResponse();
        try {
            JdShopCategoryExample example = new JdShopCategoryExample();
            example.createCriteria().andJdUidEqualTo(jdUid);
            List<JdShopCategory> jdShopCategories = jdShopCategoryMapper.selectByExample(example);
            List<SdkJdShopCategory> responses;
            if (jdShopCategories == null || jdShopCategories.isEmpty()) {
                responses = addShopCatgorys(jdUid);
            }else {
                responses = new ArrayList<>();
                for(JdShopCategory item :jdShopCategories){
                    SdkJdShopCategory response = new SdkJdShopCategory();
                    response.setCid(item.getCid());
                    response.setParentId(item.getParentId());
                    response.setName(item.getName());
                    response.setParent(item.getIsParent());
                    response.setOpen(item.getIsOpen());
                    response.setHomeShow(item.getIsHomeShow());
                    response.setShopId(item.getShopId());
                    response.setOrderNo(item.getOrderNo());
                    responses.add(response);
                }
            }

            jdShopCategoryResponse.setSuccess(true);
            jdShopCategoryResponse.setJdShopCategories(responses);
            return jdShopCategoryResponse;
        } catch (JdApiException e) {
            e.printStackTrace();
            jdShopCategoryResponse.setSuccess(false);
            jdShopCategoryResponse.setException(e);
            return jdShopCategoryResponse;
        }
    }

    /**
     * 更新京东自定义店内分类
     * @param jdUid
     * @throws JdException
     */
    @Transactional
    public JdShopCategoryResponse updateJdSellercats(Long jdUid)  {
        JdShopCategoryResponse response = new JdShopCategoryResponse();
        try {
            //先删
            JdShopCategoryExample example = new JdShopCategoryExample();
            example.createCriteria().andJdUidEqualTo(jdUid);
            jdShopCategoryMapper.deleteByExample(example);
            //再加
            List<SdkJdShopCategory> sdkJdShopCategories = addShopCatgorys(jdUid);

            response.setSuccess(true);
            response.setJdShopCategories(sdkJdShopCategories);
            return response;
        } catch (JdApiException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
            return response;
        }
    }

    /**
     * 京东 获取类目属性列表
     * 属性类型:1.关键属性 2.不变属性 3.可变属性 4.销售属性
     * @param jdUid
     * @throws JdException
     */
    public JdCategoryAttrJosResponse getJdCategoryAttrJos(Long jdUid, Long cid, Integer type) {
        JdCategoryAttrJosResponse jdCategoryAttrJosResponse = new JdCategoryAttrJosResponse();
        try {
            JdAuthedInfoResponse authedInfo = jdAuthService.getAuthedInfo(jdUid);
            CategoryReadFindAttrsByCategoryIdJosRequest request = new CategoryReadFindAttrsByCategoryIdJosRequest();
            request.setCid(cid);
            request.setAttributeType(type);
            CategoryReadFindAttrsByCategoryIdJosResponse response = jdClientService.execute(request,authedInfo.getAccessToken());
            List<CategoryAttrJos> shopCatList = response.getCategoryAttrs();
            List<JdCategoryAttrJos> vos=shopCatList.stream().map(categoryAttrJos -> {
                JdCategoryAttrJos vo=new JdCategoryAttrJos();
                vo.setAttName(categoryAttrJos.getAttName());
                vo.setAttributeType(categoryAttrJos.getAttributeType());
                vo.setAttrIndexId(categoryAttrJos.getAttrIndexId());
                vo.setCategoryAttrId(categoryAttrJos.getCategoryAttrId());
                vo.setCategoryId(categoryAttrJos.getCategoryId());
                vo.setInputType(categoryAttrJos.getInputType());
                if(categoryAttrJos.getAttrFeatures()!=null){
                    Set<JdFeatureCateAttrJosResponse> jdFeatureCateAttrJosVOS=categoryAttrJos.getAttrFeatures().stream()
                            .map(featureCateAttrJos -> BeanMapper.map(featureCateAttrJos,JdFeatureCateAttrJosResponse.class)).collect(Collectors.toSet());
                    vo.setAttrFeatures(jdFeatureCateAttrJosVOS);
                }
                if(categoryAttrJos.getCategoryAttrGroup()!=null){
                    JdCategoryAttrGroupJosResponse jdCategoryAttrGroupJosVO=new JdCategoryAttrGroupJosResponse();
                    jdCategoryAttrGroupJosVO.setAttrGroupIndexId(categoryAttrJos.getCategoryAttrGroup().getAttrGroupIndexId());
                    jdCategoryAttrGroupJosVO.setGroupId(categoryAttrJos.getCategoryAttrGroup().getGroupId());
                    jdCategoryAttrGroupJosVO.setGroupName(categoryAttrJos.getCategoryAttrGroup().getGroupName());
                    if(categoryAttrJos.getCategoryAttrGroup().getAttrGroupfeatures()!=null){
                        Set<JdFeatureCateAttrGroupJosResponse> jdFeatureCateAttrGroupJosVOS=categoryAttrJos.getCategoryAttrGroup().getAttrGroupfeatures().stream()
                                .map(featureCateAttrGroupJos -> BeanMapper.map(featureCateAttrGroupJos,JdFeatureCateAttrGroupJosResponse.class)).collect(Collectors.toSet());
                        jdCategoryAttrGroupJosVO.setAttrGroupfeatures(jdFeatureCateAttrGroupJosVOS);
                    }
                    vo.setCategoryAttrGroup(jdCategoryAttrGroupJosVO);
                }
                if(categoryAttrJos.getAttrValueList()!=null){
                    List<JdCategoryAttrValueJos> jdCategoryAttrValueJosVOS=categoryAttrJos.getAttrValueList().stream()
                            .map(categoryAttrValueJos -> {
                                JdCategoryAttrValueJos jdCategoryAttrValueJosVO=new JdCategoryAttrValueJos();
                                jdCategoryAttrValueJosVO.setAttrValue(categoryAttrValueJos.getAttrValue());
                                jdCategoryAttrValueJosVO.setAttrValueId(categoryAttrValueJos.getAttrValueId());
                                jdCategoryAttrValueJosVO.setAttrValueIndexId(categoryAttrValueJos.getAttrValueIndexId());
                                if(categoryAttrValueJos.getAttrValueFeatures()!=null){
                                    Set<JdFeatureCateAttrValueJosResponse> jdFeatureCateAttrValueJosVOS=categoryAttrValueJos.getAttrValueFeatures().stream()
                                            .map(featureCateAttrValueJos -> BeanMapper.map(featureCateAttrValueJos,JdFeatureCateAttrValueJosResponse.class))
                                            .collect(Collectors.toSet());
                                    jdCategoryAttrValueJosVO.setAttrValueFeatures(jdFeatureCateAttrValueJosVOS);
                                }
                                return jdCategoryAttrValueJosVO;
                            }).collect(Collectors.toList());
                    vo.setAttrValueList(jdCategoryAttrValueJosVOS);
                }
                return vo;
            }).collect(Collectors.toList());

            jdCategoryAttrJosResponse.setSuccess(true);
            jdCategoryAttrJosResponse.setJdCategoryAttrJos(vos);
            return jdCategoryAttrJosResponse;
        } catch (JdApiException e) {
            e.printStackTrace();
            jdCategoryAttrJosResponse.setSuccess(false);
            jdCategoryAttrJosResponse.setException(e);
            return jdCategoryAttrJosResponse;
        }
    }

    /**
     * 获取商家类目信息
     * @param jdUid
     * @return
     */
    public List<JdCategoryResponse> getJdWarecats(Long jdUid) throws JdAuthFailureException, com.shigu.jd.api.exceptions.JdApiException, JdApiException {
        JdAuthedInfoResponse authedInfo = jdAuthService.getAuthedInfo(jdUid);
        CategorySearchRequest request=new CategorySearchRequest();
        CategorySearchResponse response = jdClientService.execute(request,authedInfo.getAccessToken());
        List<Category> categorys = response.getCategory();
        List<JdCategoryResponse> jdCategoryVOS = new ArrayList<>();
        for (Category item : categorys){
            JdCategoryResponse vo = new JdCategoryResponse();
            vo.setFid(item.getFid());
            vo.setId(item.getId());
            vo.setIndexId(item.getIndexId());
            vo.setLev(item.getLev());
            vo.setName(item.getName());
            vo.setStatus(item.getStatus());
            vo.setParent(item.isParent());
            jdCategoryVOS.add(vo);
        }
        return jdCategoryVOS;
    }

    /**
     * 根据父级类目Id获取子集类目信息
     * @param jdUid
     *  @param pid 父类目id
     * @return
     */
    public List<JdCategoryReadResponse> getJdCategoryByPid(Long jdUid,Long pid) throws JdAuthFailureException, com.shigu.jd.api.exceptions.JdApiException, JdApiException {
        JdAuthedInfoResponse authedInfo = jdAuthService.getAuthedInfo(jdUid);
        CategoryReadFindByPIdRequest request = new CategoryReadFindByPIdRequest();
        request.setParentCid(pid);
        CategoryReadFindByPIdResponse response = jdClientService.execute(request,authedInfo.getAccessToken());
        List<com.jd.open.api.sdk.domain.list.CategoryReadService.Category> categories = response.getCategories();
        if(categories==null){
            return new ArrayList<>();
        }
        List<JdCategoryReadResponse> jdCategoryReadVOS = new ArrayList<>();
        for(com.jd.open.api.sdk.domain.list.CategoryReadService.Category item : categories){
            JdCategoryReadResponse vo = new JdCategoryReadResponse();
            vo.setFid(item.getFid());
            vo.setId(item.getId());
            vo.setLev(item.getLev());
            vo.setName(item.getName());
            Set<JdFeatureResponse> jdFeatures = new HashSet<>();
            for (Feature futureItem : item.getFeatures()){
                JdFeatureResponse jdFeature = new JdFeatureResponse();
                jdFeature.setFeatureCn(futureItem.getFeatureCn());
                jdFeature.setFeatureKey(futureItem.getFeatureKey());
                jdFeature.setFeatureValue(futureItem.getFeatureValue());
                jdFeatures.add(jdFeature);
            }
            vo.setFeatures(jdFeatures);
            jdCategoryReadVOS.add(vo);
        }
        return jdCategoryReadVOS;
    }

    /**
     * 获取类目属性值
     * @param jdUid
     * @param pid
     * @return
     */
    public JdCategoryAttrValueJosResponse getCategoryReadFindValuesByAttrId(Long jdUid,Long pid) {
        JdCategoryAttrValueJosResponse response =  new JdCategoryAttrValueJosResponse();
        List<JdCategoryAttrValueJos> jdCategoryAttrValueJosVOS= null;
        try {
            JdAuthedInfoResponse authedInfo = jdAuthService.getAuthedInfo(jdUid);
            CategoryReadFindValuesByAttrIdJosRequest req=new CategoryReadFindValuesByAttrIdJosRequest();
            req.setCategoryAttrId(pid);
            CategoryReadFindValuesByAttrIdJosResponse res=jdClientService.execute(req,authedInfo.getAccessToken());
            List<CategoryAttrValueJos> vos=res.getCategoryAttrValues();
            jdCategoryAttrValueJosVOS = vos.stream()
                    .map(categoryAttrValueJos -> {
                        JdCategoryAttrValueJos jdCategoryAttrValueJosVO=new JdCategoryAttrValueJos();
                        jdCategoryAttrValueJosVO.setAttrValue(categoryAttrValueJos.getValue());
                        jdCategoryAttrValueJosVO.setAttrValueId(categoryAttrValueJos.getId());
                        jdCategoryAttrValueJosVO.setAttrValueIndexId(categoryAttrValueJos.getIndexId());
                        if(categoryAttrValueJos.getFeatures()!=null){
                            Set<JdFeatureCateAttrValueJosResponse> jdFeatureCateAttrValueJosVOS=categoryAttrValueJos.getFeatures().stream()
                                    .map(featureCateAttrValueJos -> BeanMapper.map(featureCateAttrValueJos,JdFeatureCateAttrValueJosResponse.class))
                                    .collect(Collectors.toSet());
                            jdCategoryAttrValueJosVO.setAttrValueFeatures(jdFeatureCateAttrValueJosVOS);
                        }
                        return jdCategoryAttrValueJosVO;
                    }).collect(Collectors.toList());

            response.setSuccess(true);
            response.setJdCategoryAttrValueJos(jdCategoryAttrValueJosVOS);
            return response;
        } catch (JdApiException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setException(e);
            return response;
        }
    }

    /**
     * 获取用户所拥有的品牌
     * @param jdUid
     * @return
     */
    public JdVenderBrandPubInfoResponse getAllBrand(Long jdUid) {
        JdVenderBrandPubInfoResponse jdVenderBrandPubInfoResponse = new JdVenderBrandPubInfoResponse();

        JdAuthedInfoResponse authedInfo = jdAuthService.getAuthedInfo(jdUid);
        PopVenderCenerVenderBrandQueryRequest request=new PopVenderCenerVenderBrandQueryRequest();
        PopVenderCenerVenderBrandQueryResponse response = null;
        try {
            response = jdClientService.execute(request, authedInfo.getAccessToken());
        } catch (JdApiException e) {
            e.printStackTrace();
            jdVenderBrandPubInfoResponse.setSuccess(false);
            jdVenderBrandPubInfoResponse.setException(e);
            return jdVenderBrandPubInfoResponse;
        }
        List<VenderBrandPubInfo> brandList = response.getBrandList();
        if (brandList == null || brandList.isEmpty()) {
            jdVenderBrandPubInfoResponse.setSuccess(false);
            return jdVenderBrandPubInfoResponse;
        }
        List<JdVenderBrandPubInfo> jdVenderBrandPubInfos = BeanMapper.mapList(brandList, JdVenderBrandPubInfo.class);
        jdVenderBrandPubInfoResponse.setJdVenderBrandPubInfos(jdVenderBrandPubInfos);
        jdVenderBrandPubInfoResponse.setSuccess(true);
        return jdVenderBrandPubInfoResponse;
    }

    /**
     * 新增店内类目数据
     * @param jdUid
     */
    private List<SdkJdShopCategory> addShopCatgorys(Long jdUid) throws JdApiException {
        JdAuthedInfoResponse authedInfo = jdAuthService.getAuthedInfo(jdUid);
        SellerCatsGetRequest request = new SellerCatsGetRequest();
        SellerCatsGetResponse response = jdClientService.execute(request,authedInfo.getAccessToken());
        List<ShopCategory> shopCatList = response.getShopCatList();
        List<JdShopCategory> jdShopCategories = new ArrayList<>();
        List<SdkJdShopCategory> vos = new ArrayList<>();
        for(ShopCategory item : shopCatList){
            //构建数据库实体
            JdShopCategory jdShopCategory = new JdShopCategory();
            jdShopCategory.setJdUid(jdUid);
            jdShopCategory.setCid(item.getCid());
            jdShopCategory.setParentId(item.getParentId());
            jdShopCategory.setName(item.getName());
            jdShopCategory.setIsParent(item.getParent());
            jdShopCategory.setIsOpen(item.getOpen());
            jdShopCategory.setIsHomeShow(item.getHomeShow());
            jdShopCategory.setShopId(item.getShopId());
            jdShopCategory.setOrderNo(item.getOrderNo());
            Date now = new Date();
            jdShopCategory.setGmtCreate(now);
            jdShopCategory.setGmtModify(now);
            jdShopCategories.add(jdShopCategory);

            //构建返回数据
            SdkJdShopCategory vo = new SdkJdShopCategory();
            vo.setCid(item.getCid());
            vo.setParentId(item.getParentId());
            vo.setName(item.getName());
            vo.setParent(item.getParent());
            vo.setOpen(item.getOpen());
            vo.setHomeShow(item.getHomeShow());
            vo.setShopId(item.getShopId());
            vo.setOrderNo(item.getOrderNo());
            vos.add(vo);
        }
        jdShopCategoryMapper.insertListNoId(jdShopCategories);
        return vos;

    }


}
