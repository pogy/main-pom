package com.shigu.main4.spread.service;

import com.opentae.data.mall.beans.GoatItemData;
import com.opentae.data.mall.beans.GoatOneItem;
import com.opentae.data.mall.beans.GoodsupNoreal;
import com.opentae.data.mall.interfaces.GoatItemDataMapper;
import com.opentae.data.mall.interfaces.GoatOneItemMapper;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.model.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

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
    @Autowired
    GoodsupNorealMapper goodsupNorealMapper;

    @Test
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings("unchecked")
    public <T extends GoatVO>void getALocationByVo_selGoatsTest() throws ActivityException, GoatException {
        Calendar ca=Calendar.getInstance();
        ca.add(Calendar.DAY_OF_WEEK,-1);
        GoatOneItem oneItem=new GoatOneItem();
        oneItem.setDisEnabled(false);
        oneItem.setLocalId(1l);
        goatOneItemMapper.insertSelective(oneItem);
        GoatItemData oneData=new GoatItemData();
        oneData.setStatus(1);
        oneData.setGoatId(oneItem.getGoatId());
        oneData.setUserId(1000000808L);
        oneData.setFromTime(ca.getTime());
        oneData.setToTime(new Date());
        oneData.setContext("{\"itemId\":556363,\"title\":\"张大仙\"}");
        goatItemDataMapper.insertSelective(oneData);

        GoatLocationVO vo=new GoatLocationVO();
        vo.setLocalId(1l);
        vo.setGoatType(1);
        GoatLocation go= goatFactory.getALocationByVo(vo);

        List<T> tt= go.selGoats();

        for(T t:tt){
            //1. 验证dis_enabled有效性，添加dis_enabled=0的goat_one_item，添加，判断查询结果中是否出现
            assertEquals(t.getGoatId(),oneItem.getGoatId());
        }
        //第一条验证完成 删除数据
        goatOneItemMapper.deleteByPrimaryKey(oneItem.getGoatId());
        goatItemDataMapper.deleteByPrimaryKey(oneData.getDataId());

        //添加3条可用完整数据
        Map<Long,GoatItemData>  cmap=new HashMap<>();
        for(int i=0;i<3;i++){
            GoatOneItem omg=new GoatOneItem();
            omg.setDisEnabled(false);
            omg.setLocalId(1l);
            goatOneItemMapper.insertSelective(omg);
            //添加详细数据

            GoatItemData data=new GoatItemData();
            data.setContext("{\"itemId\":556363,\"title\":\"张大山"+i+"\"}");
            data.setFromTime(ca.getTime());
            data.setToTime(new Date());
            data.setGoatId(omg.getGoatId());
            data.setUserId(1000000808l+(long)i);
            data.setStatus(1);
            goatItemDataMapper.insertSelective(data);
            cmap.put(omg.getGoatId(),data);

        }
        //2.正常格式添加goat_one_item、goat_item_data数据若干条，验证返回数据正确性
        List<T> tt2= go.selGoats();
        for(T t:tt2){
            GoatItemData cdata= cmap.get(t.getGoatId());
            if(cdata==null){
                Assert.fail("验证数据正确性失败");
            }
            assertEquals(t.getDataId(),cdata.getDataId());

        }

        GoatOneItem goNoData=new GoatOneItem();
        goNoData.setDisEnabled(false);
        goNoData.setLocalId(1l);
        goatOneItemMapper.insertSelective(goNoData);
        System.out.println(goNoData.getGoatId());
        //添加详细数据状态为不可用
        GoatItemData data=new GoatItemData();
        data.setContext("{\"itemId\":556363,\"title\":\"张大山no\"}");
        data.setFromTime(ca.getTime());
        data.setToTime(new Date());
        data.setGoatId(goNoData.getGoatId());
        data.setUserId(1000000808l);
        data.setStatus(0);
        goatItemDataMapper.insertSelective(data);
        List<T> tt3= go.selGoats();
        //3.验证广告没数据的情况，添加goat_one_item，不添加goat_item_data的对应，验证是否有该条广告返回，理论上该
        boolean isexist=false;
        for(T t:tt3){
            if(t.getGoatId().longValue()==goNoData.getGoatId()){
                assertEquals(t.getDataId(),null);
                isexist=true;
            }

        }
        if(!isexist){
            Assert.fail("item查询不到数据~~");
        }
        //4、验证最终返回List的size与goat_one_item有效数量是否相等
        assertEquals(tt3.size(),4);




    }

    @SuppressWarnings("unchecked")
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void selItemGoat_selUpTest() {
        //1.Es中没数据、goodsup_noreal有数据的情况
        GoodsupNoreal gn=new GoodsupNoreal();
        gn.setActiveNum(1);
        gn.setAddNum(100);
        gn.setItemId(9000l);
        gn.setRealNum(50);
        goodsupNorealMapper.insertSelective(gn);

        ItemGoatVO vo=new ItemGoatVO();
        vo.setItemId(gn.getItemId());

        ItemGoat go=goatFactory.selGoatByVo(vo);
        ItemUpVO upvo = go.selUp();

        assertEquals( upvo.getUnRealNum(),(Long)gn.getAddNum().longValue());
        assertEquals(upvo.getRealNum(),null);
        //2.Es中有数据、goodsup_noreal没数据的情况
        goodsupNorealMapper.deleteByPrimaryKey(gn.getNorealId());

        vo.setItemId(1653046l);
        go=goatFactory.selGoatByVo(vo);
        upvo = go.selUp();
        assertEquals( upvo.getUnRealNum(),null);
        assertNotEquals(upvo.getRealNum(),null);

        //3、Es、goodsup_noreal都没数据的情况

        vo.setItemId(9000l);
        go=goatFactory.selGoatByVo(vo);
        upvo = go.selUp();
        assertEquals( upvo.getUnRealNum(),null);
        assertEquals(upvo.getRealNum(),null);

        //4.Es、goodsup_noreal都有数据的情况

        GoodsupNoreal gn2=new GoodsupNoreal();
        gn2.setActiveNum(1);
        gn2.setAddNum(100);
        gn2.setItemId(1653046l);
        gn2.setRealNum(50);
        goodsupNorealMapper.insertSelective(gn2);
        vo.setItemId(1653046l);
        go=goatFactory.selGoatByVo(vo);
        upvo = go.selUp();
        assertEquals( upvo.getUnRealNum(),(Long)gn2.getAddNum().longValue());
        assertNotEquals(upvo.getRealNum(),null);
        goodsupNorealMapper.deleteByPrimaryKey(gn.getNorealId());

    }

}
