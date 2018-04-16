package com.shigu.jd.mapper.services;

import com.openJar.beans.JdItemProp;
import com.openJar.beans.JdPropValue;
import com.openJar.beans.JdTbBind;
import com.openJar.beans.ShiguJdcat;
import com.opentae.data.jd.examples.JdItemPropExample;
import com.opentae.data.jd.examples.JdPropValueExample;
import com.opentae.data.jd.examples.JdTbBindExample;
import com.opentae.data.jd.interfaces.JdItemPropMapper;
import com.opentae.data.jd.interfaces.JdPropValueMapper;
import com.opentae.data.jd.interfaces.JdTbBindMapper;
import com.opentae.data.jd.interfaces.ShiguJdcatMapper;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

}


