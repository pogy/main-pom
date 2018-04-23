package com.shigu.jd.api.service;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.category.Category;
import com.jd.open.api.sdk.domain.list.CategoryAttrValueReadService.CategoryAttrValue;
import com.jd.open.api.sdk.domain.list.CategoryReadService.Feature;
import com.jd.open.api.sdk.domain.sellercat.ShopCategory;
import com.jd.open.api.sdk.request.category.CategorySearchRequest;
import com.jd.open.api.sdk.request.list.*;
import com.jd.open.api.sdk.request.sellercat.SellerCatsGetRequest;
import com.jd.open.api.sdk.response.category.CategorySearchResponse;
import com.jd.open.api.sdk.response.list.*;
import com.jd.open.api.sdk.response.sellercat.SellerCatsGetResponse;
import com.openJar.beans.*;
import com.openJar.responses.api.*;
import com.opentae.data.jd.beans.JdPropValue;
import com.opentae.data.jd.beans.JdShopCategory;
import com.opentae.data.jd.examples.JdPropValueExample;
import com.opentae.data.jd.examples.JdShopCategoryExample;
import com.opentae.data.jd.interfaces.JdPropValueMapper;
import com.opentae.data.jd.interfaces.JdShopCategoryMapper;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
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

    @Autowired
    private JdPropValueMapper jdPropValueMapper;


    /**
     * 京东自定义店内分类
     *
     * @param jdUid
     * @throws JdException
     */
    public List<SdkJdShopCategory> selJdSellercats(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdShopCategoryExample example = new JdShopCategoryExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        List<JdShopCategory> jdShopCategories = jdShopCategoryMapper.selectByExample(example);
        List<SdkJdShopCategory> vos;
        if (jdShopCategories == null || jdShopCategories.isEmpty()) {
            vos = addShopCatgorys(jdUid);
        } else {
            vos = new ArrayList<>();
            for (JdShopCategory item : jdShopCategories) {
                SdkJdShopCategory response = new SdkJdShopCategory();
                response.setCid(item.getCid());
                response.setParentId(item.getParentId());
                response.setName(item.getName());
                response.setParent(item.getIsParent());
                response.setOpen(item.getIsOpen());
                response.setHomeShow(item.getIsHomeShow());
                response.setShopId(item.getShopId());
                response.setOrderNo(item.getOrderNo());
                vos.add(response);
            }
        }
        return vos;
    }

    /**
     * 更新京东自定义店内分类
     *
     * @param jdUid
     * @throws JdException
     */
    @Transactional
    public List<SdkJdShopCategory> updateJdSellercats(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        //先删
        JdShopCategoryExample example = new JdShopCategoryExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        jdShopCategoryMapper.deleteByExample(example);
        //再加
        return addShopCatgorys(jdUid);
    }


    /**
     * 获取商家类目信息
     *
     * @param jdUid
     * @return
     */
    public List<SdkJdCategory> getJdWarecats(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        CategorySearchRequest request = new CategorySearchRequest();
        CategorySearchResponse response = jdClientService.execute(request, authedInfo.getAccessToken());
        List<Category> categorys = response.getCategory();
        List<SdkJdCategory> jdCategoryVOS = new ArrayList<>();
        for (Category item : categorys) {
            SdkJdCategory vo = new SdkJdCategory();
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
     *
     * @param jdUid
     * @param pid   父类目id
     * @return
     */
    public List<SdkJdCategoryRead> getJdCategoryByPid(Long jdUid, Long pid) throws  JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        CategoryReadFindByPIdRequest request = new CategoryReadFindByPIdRequest();
        request.setParentCid(pid);
        CategoryReadFindByPIdResponse response = jdClientService.execute(request, authedInfo.getAccessToken());
        List<com.jd.open.api.sdk.domain.list.CategoryReadService.Category> categories = response.getCategories();
        if (categories == null) {
            return new ArrayList<>();
        }
        List<SdkJdCategoryRead> jdCategoryReadVOS = new ArrayList<>();
        for (com.jd.open.api.sdk.domain.list.CategoryReadService.Category item : categories) {
            SdkJdCategoryRead vo = new SdkJdCategoryRead();
            vo.setFid(item.getFid());
            vo.setId(item.getId());
            vo.setLev(item.getLev());
            vo.setName(item.getName());
            Set<JdFeatureResponse> jdFeatures = new HashSet<>();
            for (Feature futureItem : item.getFeatures()) {
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
     *
     * @param jdUid
     * @param pid
     * @return
     */
    public List<JdCategoryAttrValue> getCategoryReadFindValuesByAttrId(Long jdUid, Long pid) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);

        CategoryReadFindValuesByAttrIdRequest req = new CategoryReadFindValuesByAttrIdRequest();
        req.setCategoryAttrId(pid);
        CategoryReadFindValuesByAttrIdResponse res = jdClientService.execute(req, authedInfo.getAccessToken());
        List<CategoryAttrValue> vos = res.getCategoryAttrValues();
//        List<JdPropValue> jdPropValues = new ArrayList<>();

        List<JdCategoryAttrValue> collect = vos.stream()
                .map(categoryAttrValue -> {
//                    JdPropValue jdPropValue = new JdPropValue();
//                    jdPropValue.setCid(categoryAttrValue.getCategoryId());
//                    jdPropValue.setPid(pid);
//                    jdPropValue.setPropName("颜色");
//                    jdPropValue.setVid(categoryAttrValue.getId());
//                    jdPropValue.setName(categoryAttrValue.getValue());
//                    jdPropValue.setSortOrder(categoryAttrValue.getIndexId().longValue());
//
//                    jdPropValue.setIsParent(0);
//                    jdPropValue.setStatus("1");
//                    jdPropValues.add(jdPropValue);

                    JdCategoryAttrValue jdCategoryAttrValueVO = new JdCategoryAttrValue();
                    jdCategoryAttrValueVO.setAttrValue(categoryAttrValue.getValue());
                    jdCategoryAttrValueVO.setAttrValueId(categoryAttrValue.getId());
                    jdCategoryAttrValueVO.setAttrValueIndexId(categoryAttrValue.getIndexId());
                    if (categoryAttrValue.getFeatures() != null) {
                        Set<JdFeatureCateAttrValueResponse> jdFeatureCateAttrValueVOS = categoryAttrValue.getFeatures().stream()
                                .map(featureCateAttrValueJos -> BeanMapper.map(featureCateAttrValueJos, JdFeatureCateAttrValueResponse.class))
                                .collect(Collectors.toSet());
                        jdCategoryAttrValueVO.setAttrValueFeatures(jdFeatureCateAttrValueVOS);
                    }
                    return jdCategoryAttrValueVO;
                }).collect(Collectors.toList());
//
//        if (jdPropValues != null && !jdPropValues.isEmpty()) {
//            jdPropValueMapper.insertListNoId(jdPropValues);
//        }

        return collect;
    }

    /**
     * 获取用户所拥有的品牌
     *
     * @param jdUid
     * @return
     */
    public List<JdVenderBrandPubInfo> getAllBrand(Long jdUid) throws JdAuthOverdueException, OtherCustomException {

        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        PopVenderCenerVenderBrandQueryRequest request = new PopVenderCenerVenderBrandQueryRequest();
        PopVenderCenerVenderBrandQueryResponse response = null;
        response = jdClientService.execute(request, authedInfo.getAccessToken());
        List<VenderBrandPubInfo> brandList = response.getBrandList();
        if (brandList == null || brandList.isEmpty()) {
            return null;
        }
        return BeanMapper.mapList(brandList, JdVenderBrandPubInfo.class);
    }

    /**
     * 新增店内类目数据
     *
     * @param jdUid
     */
    private List<SdkJdShopCategory> addShopCatgorys(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        SellerCatsGetRequest request = new SellerCatsGetRequest();
        SellerCatsGetResponse response = jdClientService.execute(request, authedInfo.getAccessToken());
        List<ShopCategory> shopCatList = response.getShopCatList();
        List<JdShopCategory> jdShopCategories = new ArrayList<>();
        List<SdkJdShopCategory> vos = new ArrayList<>();
        for (ShopCategory item : shopCatList) {
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
