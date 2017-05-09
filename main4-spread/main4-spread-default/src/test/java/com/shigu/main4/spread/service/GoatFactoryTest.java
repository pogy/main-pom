package com.shigu.main4.spread.service;

import com.opentae.data.mall.beans.GoatItemData;
import com.opentae.data.mall.beans.GoatOneItem;
import com.opentae.data.mall.interfaces.GoatItemDataMapper;
import com.opentae.data.mall.interfaces.GoatOneItemMapper;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by pc on 2017-05-08.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class GoatFactoryTest {

    @Autowired
    GoatFactory goatFactory;

    @Autowired
    GoatOneItemMapper goatOneItemMapper;

    @Autowired
    GoatItemDataMapper goatItemDataMapper;
    @Test
    @Transactional
    public <T extends GoatVO>void getALocationByVo_selGoatsTest() throws ActivityException{

        GoatOneItem oneItem=new GoatOneItem();
        oneItem.setDisEnabled(false);
        oneItem.setGoatId(1l);
        oneItem.setLocalId(1l);
        goatOneItemMapper.insertSelective(oneItem);

        GoatLocationVO vo=new GoatLocationVO();
        vo.setLocalId(1l);
        vo.setGoatType(1);
        GoatLocation go= goatFactory.getALocationByVo(vo);
        List<T> tt= go.selGoats();
        //添加4条数据
        Calendar ca=Calendar.getInstance();
        ca.add(Calendar.DAY_OF_WEEK,-1);
        //启用的广告数量
        int enu=1;
        for(int i=2;i<6;i++){
            GoatOneItem omg=new GoatOneItem();
            Random rom=new Random();
            int z=rom.nextInt(2);

            omg.setDisEnabled(z==1?true:false);
            if(!omg.getDisEnabled()){
                enu++;
            }
            omg.setLocalId(1l);
            goatOneItemMapper.insertSelective(omg);
            //添加详细数据

            GoatItemData data=new GoatItemData();
            data.setContext("{}");
            data.setFromActivityId(1L+(long)i);
            data.setFromTime(ca.getTime());
            data.setToTime(new Date());
            data.setGoatId(omg.getGoatId());
            data.setUserId(1000000808l+(long)i);
            goatItemDataMapper.insertSelective(data);

        }

        List<T> tt2= go.selGoats();
        assertEquals(tt2.size(),enu);



    }
    @Test
    public  void test1() {

    }

}
