package com.shigu.main4.spread.service;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.examples.ActiveDrawRecordExample;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhaohongbo on 17/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:store_test.xml")
public class ActiveDrawServiceTest {

    @Autowired
    ActiveDrawService activeDrawService;

    @Autowired
    ActiveDrawRecordMapper activeDrawRecordMapper;

    @Test
    public void test() throws ParseException {
        List<Long> goodsIds=new ArrayList<Long>();
        goodsIds.add(2217907L);
        goodsIds.add(2263425L);
        goodsIds.add(2219652L);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Map<Long,Long> set=activeDrawService.newNumIids("赵洪波5",goodsIds,sdf.parse("2015-03-01"),sdf.parse("2015-06-01"));
        System.out.println(set);
    }

    @Test
    public void selTrade(){
        ActiveDrawRecordExample example=new ActiveDrawRecordExample();
        example.createCriteria().andPemIdEqualTo(8L);
        example.setDistinct(true);
        List<ActiveDrawRecord> records=activeDrawRecordMapper.selectFieldsByExample(example, FieldUtil.codeFields(""));
        List<Long> users= BeanMapper.getFieldList(records,"user_id",Long.class);
        System.out.println(users.size());
    }

    @Test
    public void receUserWardTest() throws Main4Exception {
        activeDrawService.receUserWard("8rywjqu");
    }
}
