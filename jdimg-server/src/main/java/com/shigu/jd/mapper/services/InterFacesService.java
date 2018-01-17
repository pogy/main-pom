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

import java.util.List;

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
}


