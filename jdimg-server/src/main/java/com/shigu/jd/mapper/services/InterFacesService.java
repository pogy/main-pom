package com.shigu.jd.mapper.services;

import com.openJar.beans.*;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.jd.beans.JdSessionMap;
import com.opentae.data.jd.examples.JdItemPropExample;
import com.opentae.data.jd.examples.JdPropValueExample;
import com.opentae.data.jd.examples.JdSessionMapExample;
import com.opentae.data.jd.examples.JdTbBindExample;
import com.opentae.data.jd.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<JdItemProp> selJdItemProps(Long jdCid) {
        JdItemPropExample jdItemPropExample=new JdItemPropExample();
        jdItemPropExample.createCriteria().andCidEqualTo(jdCid);
//        test1();
        return BeanMapper.mapList(jdItemPropMapper.selectByExample(jdItemPropExample),JdItemProp.class);
    }


    public List<JdPropValue> selJdPropValues(Long jdCid){
        JdPropValueExample jdPropValueExample=new JdPropValueExample();
        jdPropValueExample.createCriteria().andCidEqualTo(jdCid);
        return BeanMapper.mapList(jdPropValueMapper.selectByExample(jdPropValueExample),JdPropValue.class);
    }

    public List<JdTbBind> selJdTbBind(Long cid){
        JdTbBindExample jdTbBindExample=new JdTbBindExample();
        jdTbBindExample.createCriteria().andTbCidEqualTo(cid);
        return BeanMapper.mapList(jdTbBindMapper.selectByExample(jdTbBindExample),JdTbBind.class);
    }

    public ShiguJdcat selShiguJdcat(Long cid){
        return BeanMapper.map(shiguJdcatMapper.selectByPrimaryKey(cid),ShiguJdcat.class);
    }

    public void test1(){

        List<Long> notHave = new ArrayList<>();

        JdItemPropExample example = new JdItemPropExample();
        example.createCriteria().andIsSalePropEqualTo(1).andIsColorPropEqualTo(1);
        List<com.opentae.data.jd.beans.JdItemProp> jdItemProps = jdItemPropMapper.selectByExample(example);
        for(com.opentae.data.jd.beans.JdItemProp item : jdItemProps){
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
     * 根据京东登陆名模糊查询
     * @param jdUserNick
     * @return
     */
    public List<JdSession> selJdUidsByFuzzyJdLoginName(String jdUserNick) {
        JdSessionMapExample example = new JdSessionMapExample();
        example.createCriteria().andJdUserNickLike("%"+jdUserNick+"%");
        List<JdSessionMap> jdSessionMaps = jdSessionMapMapper.selectFieldsByExample(example, FieldUtil.codeFields("jd_uid,jd_user_nick"));
        if (jdSessionMaps == null || jdSessionMaps.isEmpty()) {
            return null;
        }
        return jdSessionMaps.stream().map(item->{
            JdSession jdSession = new JdSession();
            jdSession.setJdUid(item.getJdUid());
            jdSession.setJdUserNick(item.getJdUserNick());

            return jdSession;
        }).collect(Collectors.toList());
    }
}


