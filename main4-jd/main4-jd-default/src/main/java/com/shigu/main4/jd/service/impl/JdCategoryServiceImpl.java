package com.shigu.main4.jd.service.impl;

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
import com.opentae.data.jd.beans.JdShopCategory;
import com.opentae.data.jd.examples.JdShopCategoryExample;
import com.opentae.data.jd.interfaces.JdShopCategoryMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By admin on 2017/12/11/16:29
 * 京东类目接口
 */
@Service("jdCategoryService")
public class JdCategoryServiceImpl implements  JdCategoryService {

    @Autowired
    private JdUtil jdUtil;

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdShopCategoryMapper jdShopCategoryMapper;


    /**
     * 京东自定义店内分类
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    @Override
    public List<JdShopCategoryVO> getJdSellercats(Long jdUid) throws JdUpException, JdAuthFailureException, IOException {
        JdShopCategoryExample example = new JdShopCategoryExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        List<JdShopCategory> jdShopCategories = jdShopCategoryMapper.selectByExample(example);
        List<JdShopCategoryVO> vos;
        if (jdShopCategories == null || jdShopCategories.isEmpty()) {
            vos = addShopCatgorys(jdUid);
        }else {
            vos = new ArrayList<>();
            for(JdShopCategory item :jdShopCategories){
                JdShopCategoryVO vo = new JdShopCategoryVO();
                vo.setCid(item.getCid());
                vo.setParentId(item.getParentId());
                vo.setName(item.getName());
                vo.setParent(item.getIsParent());
                vo.setOpen(item.getIsOpen());
                vo.setHomeShow(item.getIsHomeShow());
                vo.setShopId(item.getShopId());
                vo.setOrderNo(item.getOrderNo());
                vos.add(vo);
            }
        }
        return vos;
    }

    /**
     * 更新京东自定义店内分类
     * @param jdUid
     * @throws JdException
     */
    @Override
    @Transactional
    public List<JdShopCategoryVO> updateJdSellercats(Long jdUid) throws JdUpException, JdAuthFailureException, IOException {
        //先删
        JdShopCategoryExample example = new JdShopCategoryExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        jdShopCategoryMapper.deleteByExample(example);
        //再加
        return addShopCatgorys(jdUid);
    }

    /**
     * 京东 获取类目属性列表
     * 属性类型:1.关键属性 2.不变属性 3.可变属性 4.销售属性
     * @param jdUid
     * @throws JdException
     * @throws IOException
     */
    @Override
    public List<JdCategoryAttrJosVO> getJdCategoryAttrJos(Long jdUid,Long cid,Integer type) throws JdUpException, JdAuthFailureException, IOException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        CategoryReadFindAttrsByCategoryIdJosRequest request = new CategoryReadFindAttrsByCategoryIdJosRequest();
        request.setCid(cid);
        request.setAttributeType(type);
        CategoryReadFindAttrsByCategoryIdJosResponse response = jdUtil.execute(request,authedInfo.getAccessToken());
        List<CategoryAttrJos> shopCatList = response.getCategoryAttrs();
        List<JdCategoryAttrJosVO> vos=shopCatList.stream().map(categoryAttrJos -> {
            JdCategoryAttrJosVO vo=new JdCategoryAttrJosVO();
            vo.setAttName(categoryAttrJos.getAttName());
            vo.setAttributeType(categoryAttrJos.getAttributeType());
            vo.setAttrIndexId(categoryAttrJos.getAttrIndexId());
            vo.setCategoryAttrId(categoryAttrJos.getCategoryAttrId());
            vo.setCategoryId(categoryAttrJos.getCategoryId());
            vo.setInputType(categoryAttrJos.getInputType());
            if(categoryAttrJos.getAttrFeatures()!=null){
                Set<JdFeatureCateAttrJosVO> jdFeatureCateAttrJosVOS=categoryAttrJos.getAttrFeatures().stream()
                        .map(featureCateAttrJos -> BeanMapper.map(featureCateAttrJos,JdFeatureCateAttrJosVO.class)).collect(Collectors.toSet());
                vo.setAttrFeatures(jdFeatureCateAttrJosVOS);
            }
            if(categoryAttrJos.getCategoryAttrGroup()!=null){
                JdCategoryAttrGroupJosVO jdCategoryAttrGroupJosVO=new JdCategoryAttrGroupJosVO();
                jdCategoryAttrGroupJosVO.setAttrGroupIndexId(categoryAttrJos.getCategoryAttrGroup().getAttrGroupIndexId());
                jdCategoryAttrGroupJosVO.setGroupId(categoryAttrJos.getCategoryAttrGroup().getGroupId());
                jdCategoryAttrGroupJosVO.setGroupName(categoryAttrJos.getCategoryAttrGroup().getGroupName());
                if(categoryAttrJos.getCategoryAttrGroup().getAttrGroupfeatures()!=null){
                    Set<JdFeatureCateAttrGroupJosVO> jdFeatureCateAttrGroupJosVOS=categoryAttrJos.getCategoryAttrGroup().getAttrGroupfeatures().stream()
                            .map(featureCateAttrGroupJos -> BeanMapper.map(featureCateAttrGroupJos,JdFeatureCateAttrGroupJosVO.class)).collect(Collectors.toSet());
                    jdCategoryAttrGroupJosVO.setAttrGroupfeatures(jdFeatureCateAttrGroupJosVOS);
                }
                vo.setCategoryAttrGroup(jdCategoryAttrGroupJosVO);
            }
            if(categoryAttrJos.getAttrValueList()!=null){
                List<JdCategoryAttrValueJosVO> jdCategoryAttrValueJosVOS=categoryAttrJos.getAttrValueList().stream()
                        .map(categoryAttrValueJos -> {
                            JdCategoryAttrValueJosVO jdCategoryAttrValueJosVO=new JdCategoryAttrValueJosVO();
                            jdCategoryAttrValueJosVO.setAttrValue(categoryAttrValueJos.getAttrValue());
                            jdCategoryAttrValueJosVO.setAttrValueId(categoryAttrValueJos.getAttrValueId());
                            jdCategoryAttrValueJosVO.setAttrValueIndexId(categoryAttrValueJos.getAttrValueIndexId());
                            if(categoryAttrValueJos.getAttrValueFeatures()!=null){
                                Set<JdFeatureCateAttrValueJosVO> jdFeatureCateAttrValueJosVOS=categoryAttrValueJos.getAttrValueFeatures().stream()
                                        .map(featureCateAttrValueJos -> BeanMapper.map(featureCateAttrValueJos,JdFeatureCateAttrValueJosVO.class))
                                        .collect(Collectors.toSet());
                                jdCategoryAttrValueJosVO.setAttrValueFeatures(jdFeatureCateAttrValueJosVOS);
                            }
                            return jdCategoryAttrValueJosVO;
                        }).collect(Collectors.toList());
                vo.setAttrValueList(jdCategoryAttrValueJosVOS);
            }
            return vo;
        }).collect(Collectors.toList());
        return vos;
    }

    /**
     * 获取商家类目信息
     * @param jdUid
     * @return
     * @throws JdUpException
     */
    @Override
    public List<JdCategoryVO> getJdWarecats(Long jdUid) throws JdUpException, JdAuthFailureException, IOException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        CategorySearchRequest request=new CategorySearchRequest();
        CategorySearchResponse response = jdUtil.execute(request,authedInfo.getAccessToken());
        List<Category> categorys = response.getCategory();
        List<JdCategoryVO> jdCategoryVOS = new ArrayList<>();
        for (Category item : categorys){
            JdCategoryVO vo = new JdCategoryVO();
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
     * @throws JdUpException
     */
    @Override
    public List<JdCategoryReadVO> getJdCategoryByPid(Long jdUid,Long pid) throws JdUpException, JdAuthFailureException, IOException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        CategoryReadFindByPIdRequest request = new CategoryReadFindByPIdRequest();
        request.setParentCid(pid);
        CategoryReadFindByPIdResponse response = jdUtil.execute(request,authedInfo.getAccessToken());
        List<com.jd.open.api.sdk.domain.list.CategoryReadService.Category> categories = response.getCategories();
        if(categories==null){
            return new ArrayList<>();
        }
        List<JdCategoryReadVO> jdCategoryReadVOS = new ArrayList<>();
        for(com.jd.open.api.sdk.domain.list.CategoryReadService.Category item : categories){
            JdCategoryReadVO vo = new JdCategoryReadVO();
            vo.setFid(item.getFid());
            vo.setId(item.getId());
            vo.setLev(item.getLev());
            vo.setName(item.getName());
            Set<JdFeature> jdFeatures = new HashSet<>();
            for (Feature futureItem : item.getFeatures()){
                JdFeature jdFeature = new JdFeature();
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
     * @throws JdUpException
     */
    @Override
    public List<JdCategoryAttrValueJosVO> getCategoryReadFindValuesByAttrId(Long jdUid,Long pid) throws JdUpException, JdAuthFailureException, IOException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        CategoryReadFindValuesByAttrIdJosRequest req=new CategoryReadFindValuesByAttrIdJosRequest();
        req.setCategoryAttrId(pid);
        CategoryReadFindValuesByAttrIdJosResponse res=jdUtil.execute(req,authedInfo.getAccessToken());
        List<CategoryAttrValueJos> vos=res.getCategoryAttrValues();
        List<JdCategoryAttrValueJosVO> jdCategoryAttrValueJosVOS=vos.stream()
                .map(categoryAttrValueJos -> {
                    JdCategoryAttrValueJosVO jdCategoryAttrValueJosVO=new JdCategoryAttrValueJosVO();
                    jdCategoryAttrValueJosVO.setAttrValue(categoryAttrValueJos.getValue());
                    jdCategoryAttrValueJosVO.setAttrValueId(categoryAttrValueJos.getId());
                    jdCategoryAttrValueJosVO.setAttrValueIndexId(categoryAttrValueJos.getIndexId());
                    if(categoryAttrValueJos.getFeatures()!=null){
                        Set<JdFeatureCateAttrValueJosVO> jdFeatureCateAttrValueJosVOS=categoryAttrValueJos.getFeatures().stream()
                                .map(featureCateAttrValueJos -> BeanMapper.map(featureCateAttrValueJos,JdFeatureCateAttrValueJosVO.class))
                                .collect(Collectors.toSet());
                        jdCategoryAttrValueJosVO.setAttrValueFeatures(jdFeatureCateAttrValueJosVOS);
                    }
                    return jdCategoryAttrValueJosVO;
                }).collect(Collectors.toList());
        return jdCategoryAttrValueJosVOS;
    }

    /**
     * 获取用户所拥有的品牌
     * @param jdUid
     * @return
     */
    @Override
    public List<JdVenderBrandPubInfoVO> getAllBrand(Long jdUid) throws JdUpException, JdAuthFailureException, IOException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        PopVenderCenerVenderBrandQueryRequest request=new PopVenderCenerVenderBrandQueryRequest();
        PopVenderCenerVenderBrandQueryResponse response = jdUtil.execute(request, authedInfo.getAccessToken());
        List<VenderBrandPubInfo> brandList = response.getBrandList();
        if (brandList == null || brandList.isEmpty()) {
            return null;
        }
        return BeanMapper.mapList(brandList,JdVenderBrandPubInfoVO.class);
    }

    /**
     * 新增店内类目数据
     * @param jdUid
     * @throws JdUpException
     */
    private List<JdShopCategoryVO> addShopCatgorys(Long jdUid) throws JdUpException, JdAuthFailureException, IOException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        SellerCatsGetRequest request = new SellerCatsGetRequest();
        SellerCatsGetResponse response = jdUtil.execute(request,authedInfo.getAccessToken());
        List<ShopCategory> shopCatList = response.getShopCatList();
        List<JdShopCategory> jdShopCategories = new ArrayList<>();
        List<JdShopCategoryVO> vos = new ArrayList<>();
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
            JdShopCategoryVO vo = new JdShopCategoryVO();
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
