import com.alibaba.fastjson.JSONArray;
import com.opentae.data.jd.beans.*;
import com.opentae.data.jd.examples.JdItemPropExample;
import com.opentae.data.jd.examples.JdPropValueExample;
import com.opentae.data.jd.examples.ShiguJdcatExample;
import com.opentae.data.jd.interfaces.*;
import com.shigu.main4.jd.exceptions.JdApiException;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.vo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Created by bugzy on 2017/8/1 0001.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jd_test.xml")
public class BaseSpringTest {
    @Autowired
    JdCategoryService jdCategoryService;
    @Autowired
    JdItemPropMapper jdItemPropMapper;
    @Autowired
    JdPropValueMapper jdPropValueMapper;
    @Autowired
    ShiguJdcatMapper shiguJdcatMapper;
    @Autowired
    JdTbBindMapper jdTbBindMapper;

    String token="50a911b2-243f-48ac-887a-01bd909d43f1";
    Long userId = 4670196954L;
//    List list=Arrays.asList(1315L,1672L,1620L,15248L,9709L,1319L,1318L,2574L,11729L,14239L,14301L);
    List list=Arrays.asList(1620L,15248L,1319L);

//    @Test
    public void v() throws JdAuthFailureException, JdApiException {
        List<ShiguJdcat> l=new ArrayList<>();
        List<JdCategoryReadVO> jdCats=jdCategoryService.getJdCategoryByPid(userId,0L);
        jdCats=jdCats.stream().filter(jdCategoryReadVO -> list.contains(jdCategoryReadVO.getId())).collect(Collectors.toList());
        for(JdCategoryReadVO jdCat:jdCats){
            findCats(jdCat,null,l);
        }
        System.out.println(JSONArray.toJSON(l));
        for(ShiguJdcat s:l){
            shiguJdcatMapper.insertSelective(s);
        }
        System.out.println();
    }
    private void findCats(JdCategoryReadVO parentJdCat,String pname,List<ShiguJdcat> list) throws JdAuthFailureException, JdApiException {
        ShiguJdcat cat=new ShiguJdcat();
        list.add(cat);
        cat.setCid(parentJdCat.getId());
        cat.setParentCid(parentJdCat.getFid());
        cat.setCname(parentJdCat.getName());
        cat.setParentCname(pname);
        cat.setIsParent(0);
        if(parentJdCat.getLev()<3){
            List<JdCategoryReadVO> jdCats=jdCategoryService.getJdCategoryByPid(userId,parentJdCat.getId());
            if(jdCats.size()>0){
                cat.setIsParent(1);
                for(JdCategoryReadVO jdCat:jdCats){
                    findCats(jdCat,parentJdCat.getName(),list);
                }
            }
        }
    }

    @Test
    public void prop() throws JdAuthFailureException, JdApiException {
        ShiguJdcatExample jdcatExample=new ShiguJdcatExample();
        jdcatExample.createCriteria().andIsParentEqualTo(0).andCidGreaterThanOrEqualTo(0L);
        jdcatExample.setOrderByClause("cid asc");
        List<ShiguJdcat> cats=shiguJdcatMapper.selectByExample(jdcatExample);
        for(ShiguJdcat cat:cats){
            JdItemPropExample jdItemPropExample=new JdItemPropExample();
            jdItemPropExample.createCriteria().andCidEqualTo(cat.getCid());
            if(jdItemPropMapper.countByExample(jdItemPropExample)>0){
                continue;
            }
            try {
                List<JdCategoryAttrJosVO> list3=jdCategoryService.getJdCategoryAttrJos(userId,cat.getCid(),3);
                Map<Long,JdItemProp> propMap=new HashMap<>();
                list3.forEach(jdCategoryAttrJosVO -> {
                    JdItemProp prop=getProp(jdCategoryAttrJosVO);
                    propMap.put(jdCategoryAttrJosVO.getCategoryAttrId(),prop);
                });
                List<JdCategoryAttrJosVO> list4=jdCategoryService.getJdCategoryAttrJos(userId,cat.getCid(),4);
                list4.forEach(jdCategoryAttrJosVO -> {
                    JdItemProp prop=propMap.get(jdCategoryAttrJosVO.getCategoryAttrId());
                    if(prop==null){
                        prop=getProp(jdCategoryAttrJosVO);
                    }
                    prop.setIsSaleProp(1);
                    for(JdFeatureCateAttrJosVO f:jdCategoryAttrJosVO.getAttrFeatures()){
                        if("color".equals(f.getAttrFeatureKey())&&"1".equals(f.getAttrFeatureValue())){
                            prop.setIsKeyProp(1);
                            prop.setIsColorProp(1);
                            break;
                        }
                    }
                    propMap.put(jdCategoryAttrJosVO.getCategoryAttrId(),prop);
                });
                List<JdItemProp> props= new ArrayList<>(propMap.values());
                props.sort(Comparator.comparing(JdItemProp::getPid));
                for(JdItemProp p:props){
                    jdItemPropMapper.insertSelective(p);
                }
            } catch (Exception e) {
                System.out.println(cat.getCid());
                throw e;
            }
        }
    }


    private JdItemProp getProp(JdCategoryAttrJosVO jdCategoryAttrJosVO){
        JdItemProp prop=new JdItemProp();
        prop.setCid(jdCategoryAttrJosVO.getCategoryId());
        prop.setPid(jdCategoryAttrJosVO.getCategoryAttrId());
        prop.setIsAllowAlias(jdCategoryAttrJosVO.getInputType()==3?1:0);
        prop.setIsEnumProp(jdCategoryAttrJosVO.getInputType()==3?0:1);
        prop.setIsInputProp(prop.getIsAllowAlias());
        prop.setMulti(jdCategoryAttrJosVO.getInputType()==2?1:0);
        prop.setName(jdCategoryAttrJosVO.getAttName());
        prop.setIsColorProp(0);
        prop.setIsKeyProp(0);
        prop.setIsSaleProp(0);
        prop.setMust(0);
        prop.setIsBrand(0);
        prop.setIsItemProp(0);
        prop.setSortOrder(jdCategoryAttrJosVO.getAttrIndexId().longValue());
        for(JdFeatureCateAttrJosVO f:jdCategoryAttrJosVO.getAttrFeatures()){
            if("erpAttType".equals(f.getAttrFeatureKey())&&"GGCS".equals(f.getAttrFeatureValue())){
                prop.setIsItemProp(1);
                continue;
            }
            if("brand".equals(f.getAttrFeatureKey())&&"1".equals(f.getAttrFeatureValue())){
                prop.setIsBrand(1);
                continue;
            }
            if("isRequired".equals(f.getAttrFeatureKey())&&"1".equals(f.getAttrFeatureValue())){
                prop.setMust(1);
            }
        }
        return prop;
    }


    Long lastPid=0L;
//    @Test
    public void findPropValue() throws JdAuthFailureException, JdApiException {
        Set<Long> cids=jdTbBindMapper.select(new JdTbBind()).stream().map(JdTbBind::getJdCid).collect(Collectors.toSet());
        JdItemPropExample jdItemPropExample=new JdItemPropExample();
        jdItemPropExample.createCriteria().andCidIn(new ArrayList<>(cids)).andPidGreaterThanOrEqualTo(lastPid);
        jdItemPropExample.setOrderByClause("pid asc");
        List<JdItemProp> props=jdItemPropMapper.selectByExample(jdItemPropExample);
        for(JdItemProp prop:props){
            JdPropValueExample jdPropValueExample=new JdPropValueExample();
            jdPropValueExample.createCriteria().andPidEqualTo(prop.getPid());
            if(prop.getPid() ==10123063L){
                System.out.println();
            }
            if(jdPropValueMapper.countByExample(jdPropValueExample)>0){
                continue;
            }
            try{
                List<JdCategoryAttrValueJosVO> values=jdCategoryService.getCategoryReadFindValuesByAttrId(userId,prop.getPid());
                List<JdPropValue> vs=values.stream().map(jdCategoryAttrValueJosVO -> {
                    JdPropValue v=new JdPropValue();
                    v.setCid(prop.getCid());
                    v.setIsParent(0);
                    v.setName(jdCategoryAttrValueJosVO.getAttrValue());
                    v.setPid(prop.getPid());
                    v.setPropName(prop.getName());
                    v.setVid(jdCategoryAttrValueJosVO.getAttrValueId());
                    v.setStatus("1");
                    v.setSortOrder(jdCategoryAttrValueJosVO.getAttrValueIndexId().longValue());
                    return v;
                }).collect(Collectors.toList());
                vs.forEach(jdPropValue -> jdPropValueMapper.insertSelective(jdPropValue));
            }catch (Exception e){
                System.out.println(prop.getPid());
                throw e;
            }
        }
    }
}
