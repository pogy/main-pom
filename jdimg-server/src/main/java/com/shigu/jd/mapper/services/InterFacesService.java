package com.shigu.jd.mapper.services;

import com.alibaba.fastjson.JSONArray;
import com.openJar.beans.*;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.jd.beans.JdSessionMap;
import com.opentae.data.jd.examples.*;
import com.opentae.data.jd.interfaces.*;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.service.JdCategoryService;
import com.shigu.jd.mapper.beans.JdCategoryAttrJosVO;
import com.shigu.jd.mapper.beans.JdFeatureCateAttrJosVO;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InterFacesService {
    @Autowired
    JdItemPropMapper jdItemPropMapper;
    @Autowired
    JdPropValueMapper jdPropValueMapper;
    @Autowired
    JdTbBindMapper jdTbBindMapper;
    @Autowired
    ShiguJdcatMapper shiguJdcatMapper;
    @Autowired
    JdSessionMapMapper jdSessionMapMapper;
    @Autowired
    JdCategoryService jdCategoryService;

    public List<JdItemProp> selJdItemProps(Long jdCid) {
        JdItemPropExample jdItemPropExample = new JdItemPropExample();
        jdItemPropExample.createCriteria().andCidEqualTo(jdCid);
        return BeanMapper.mapList(jdItemPropMapper.selectByExample(jdItemPropExample), JdItemProp.class);
    }

    public List<JdItemProp> selJdItemPropsNew(Long jdUid,Long jdCid) throws JdAuthOverdueException, OtherCustomException {
        JdItemPropExample jdItemPropExample = new JdItemPropExample();
        jdItemPropExample.createCriteria().andCidEqualTo(jdCid);
        return BeanMapper.mapList(prop(jdUid,jdCid), JdItemProp.class);
    }

    private List<com.opentae.data.jd.beans.JdItemProp> prop(Long jdUid,Long jdCid) throws JdAuthOverdueException, OtherCustomException {
        JdItemPropExample jdItemPropExample = new JdItemPropExample();
        jdItemPropExample.createCriteria().andCidEqualTo(jdCid);
        List<JdCategoryAttrJosVO> list3 = jdCategoryService.getJdCategoryAttrJos(jdUid, jdCid, 3);
        Map<Long, com.opentae.data.jd.beans.JdItemProp> propMap = new HashMap<>();
        list3.forEach(jdCategoryAttrJosVO -> {
            com.opentae.data.jd.beans.JdItemProp prop = getProp(jdCategoryAttrJosVO);
            propMap.put(jdCategoryAttrJosVO.getCategoryAttrId(), prop);
        });
        List<JdCategoryAttrJosVO> list4 = jdCategoryService.getJdCategoryAttrJos(jdUid, jdCid, 4);
        list4.forEach(jdCategoryAttrJosVO -> {
            com.opentae.data.jd.beans.JdItemProp prop = propMap.get(jdCategoryAttrJosVO.getCategoryAttrId());
            if (prop == null) {
                prop = getProp(jdCategoryAttrJosVO);
            }
            prop.setIsSaleProp(1);
            for (JdFeatureCateAttrJosVO f : jdCategoryAttrJosVO.getAttrFeatures()) {
                if ("color".equals(f.getAttrFeatureKey()) && "1".equals(f.getAttrFeatureValue())) {
                    prop.setIsKeyProp(1);
                    prop.setIsColorProp(1);
                    break;
                }
            }
            propMap.put(jdCategoryAttrJosVO.getCategoryAttrId(), prop);
        });
        List<com.opentae.data.jd.beans.JdItemProp> props = new ArrayList<>(propMap.values());
        props.sort(Comparator.comparing(com.opentae.data.jd.beans.JdItemProp::getPid));
        return props;
    }

    private com.opentae.data.jd.beans.JdItemProp getProp(JdCategoryAttrJosVO jdCategoryAttrJosVO) {
        com.opentae.data.jd.beans.JdItemProp prop = new com.opentae.data.jd.beans.JdItemProp();
        prop.setCid(jdCategoryAttrJosVO.getCategoryId());
        prop.setPid(jdCategoryAttrJosVO.getCategoryAttrId());
        prop.setIsAllowAlias(jdCategoryAttrJosVO.getInputType() == 3 ? 1 : 0);
        prop.setIsEnumProp(jdCategoryAttrJosVO.getInputType() == 3 ? 0 : 1);
        prop.setIsInputProp(prop.getIsAllowAlias());
        prop.setMulti(jdCategoryAttrJosVO.getInputType() == 2 ? 1 : 0);
        prop.setName(jdCategoryAttrJosVO.getAttName());
        prop.setIsColorProp(0);
        prop.setIsKeyProp(0);
        prop.setIsSaleProp(0);
        prop.setMust(0);
        prop.setIsBrand(0);
        prop.setIsItemProp(0);
        prop.setSortOrder(jdCategoryAttrJosVO.getAttrIndexId().longValue());
        for (JdFeatureCateAttrJosVO f : jdCategoryAttrJosVO.getAttrFeatures()) {
            if ("erpAttType".equals(f.getAttrFeatureKey()) && "GGCS".equals(f.getAttrFeatureValue())) {
                prop.setIsItemProp(1);
                continue;
            }
            if ("brand".equals(f.getAttrFeatureKey()) && "1".equals(f.getAttrFeatureValue())) {
                prop.setIsBrand(1);
                continue;
            }
            if ("isRequired".equals(f.getAttrFeatureKey()) && "1".equals(f.getAttrFeatureValue())) {
                prop.setMust(1);
            }
        }
        return prop;
    }

    public List<JdPropValue> selJdPropValues(Long jdCid) {
        JdPropValueExample jdPropValueExample = new JdPropValueExample();
        jdPropValueExample.createCriteria().andCidEqualTo(jdCid);
        return BeanMapper.mapList(jdPropValueMapper.selectByExample(jdPropValueExample), JdPropValue.class);
    }

    public List<JdTbBind> selJdTbBind(Long cid) {
        JdTbBindExample jdTbBindExample = new JdTbBindExample();
        jdTbBindExample.createCriteria().andTbCidEqualTo(cid);
        return BeanMapper.mapList(jdTbBindMapper.selectByExample(jdTbBindExample), JdTbBind.class);
    }

    public ShiguJdcat selShiguJdcat(Long cid) {
        return BeanMapper.map(shiguJdcatMapper.selectByPrimaryKey(cid), ShiguJdcat.class);
    }

    public void test1() {

        List<Long> notHave = new ArrayList<>();

        JdItemPropExample example = new JdItemPropExample();
        example.createCriteria().andIsSalePropEqualTo(1).andIsColorPropEqualTo(1);
        List<com.opentae.data.jd.beans.JdItemProp> jdItemProps = jdItemPropMapper.selectByExample(example);
        for (com.opentae.data.jd.beans.JdItemProp item : jdItemProps) {
            com.opentae.data.jd.beans.JdPropValue jdPropValue = new com.opentae.data.jd.beans.JdPropValue();
            jdPropValue.setCid(item.getCid());
            jdPropValue.setPid(item.getPid());
            List<com.opentae.data.jd.beans.JdPropValue> jdPropValueList = jdPropValueMapper.select(jdPropValue);
            if (jdPropValueList == null || jdPropValueList.isEmpty()) {
                notHave.add(item.getPid());
            }

        }
        System.err.println(notHave);
    }

    /**
     * 根据京东登陆名精确查询
     *
     * @param jdUserNick
     * @return
     */
    public List<JdSession> selJdUidsByFuzzyJdLoginName(String jdUserNick) {
        JdSessionMapExample example = new JdSessionMapExample();
        example.createCriteria().andJdUserNickEqualTo(jdUserNick);
        List<JdSessionMap> jdSessionMaps = jdSessionMapMapper.selectFieldsByExample(example, FieldUtil.codeFields("jd_uid,jd_user_nick"));
        if (jdSessionMaps == null || jdSessionMaps.isEmpty()) {
            return null;
        }
        return jdSessionMaps.stream().map(item -> {
            JdSession jdSession = new JdSession();
            jdSession.setJdUid(item.getJdUid());
            jdSession.setJdUserNick(item.getJdUserNick());

            return jdSession;
        }).collect(Collectors.toList());
    }
}


