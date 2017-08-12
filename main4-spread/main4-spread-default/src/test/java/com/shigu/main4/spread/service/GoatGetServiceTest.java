package com.shigu.main4.spread.service;

import com.opentae.data.mall.beans.GoodsupNoreal;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.model.GoatFactory;
import com.shigu.main4.goat.vo.ItemGoatVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by Licca on 17/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/store_test.xml")
public class GoatGetServiceTest {
    @Autowired
    GoatFactory goatFactory;
    @Autowired
    GoodsupNorealMapper goodsupNorealMapper;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void selItemGoat_modifyUpTest(){
        Long itemId=1l;
        Integer num=10;
        ItemGoatVO vo=new ItemGoatVO();
        vo.setItemId(itemId);
        ItemGoat goat=goatFactory.selGoatByVo(vo);
        //测试一:原本无数据
        GoodsupNoreal gn=new GoodsupNoreal();
        gn.setItemId(itemId);
        gn=goodsupNorealMapper.selectOne(gn);
        assertEquals(gn,null);
        goat.modifyUp(10);
        gn=new GoodsupNoreal();
        gn.setItemId(itemId);
        gn=goodsupNorealMapper.selectOne(gn);
        assertNotEquals(gn,null);
        assertEquals(gn.getItemId(),itemId);
        assertEquals(gn.getAddNum(),num);

        //测试二:原本有数据(数据是上面测试创建的)
        goat.modifyUp(10);
        gn=new GoodsupNoreal();
        gn.setItemId(itemId);
        gn=goodsupNorealMapper.selectOne(gn);
        assertNotEquals(gn,null);
        assertEquals(gn.getItemId(),itemId);
        assertEquals(gn.getAddNum(),(Integer)(num*2));
    }
}
