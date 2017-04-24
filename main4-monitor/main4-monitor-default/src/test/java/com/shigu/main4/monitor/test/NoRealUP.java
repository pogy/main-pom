package com.shigu.main4.monitor.test;

import com.opentae.data.mall.beans.GoatField;
import com.opentae.data.mall.beans.GoatFieldValue;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.examples.GoatFieldExample;
import com.opentae.data.mall.examples.GoatFieldValueExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.GoatFieldMapper;
import com.opentae.data.mall.interfaces.GoatFieldValueMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.monitor.services.ItemUpRecordService;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 不真  上传
 * Created by zhaohongbo on 17/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( value="/spring/store_test.xml" )
public class NoRealUP {
    @Autowired
    ItemUpRecordService itemUpRecordService;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    GoatFieldMapper goatFieldMapper;

    @Autowired
    GoatFieldValueMapper goatFieldValueMapper;

    /**
     * 撸7天内
     */
    @Test
    public void gogogo(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-7);
        Date to=cal.getTime();
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.setWebSite("hz");
        example.createCriteria().andCreatedGreaterThan(to);
        int page=0;
        int size=100;
        example.setStartIndex(page);
        example.setEndIndex(size);
        List<ShiguGoodsTiny> list=shiguGoodsTinyMapper.selectByConditionList(example);
        Set<Long> set=new HashSet<>();
        while(list.size()>0){
            for(ShiguGoodsTiny sgt:list){
                if(Math.random()<0.2){
                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
//                    if(set.contains(sgt.getGoodsId())){
//                        System.out.println(sgt.getGoodsId());
//                    }
                    set.add(sgt.getGoodsId());
                }
//                if(Math.random()<0.3){
//                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
////                    if(set.contains(sgt.getGoodsId())){
////                        System.out.println(sgt.getGoodsId());
////                    }
//                    set.add(sgt.getGoodsId());
//                }
//                if(Math.random()<0.4){
//                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
////                    if(set.contains(sgt.getGoodsId())){
////                        System.out.println(sgt.getGoodsId());
////                    }
//                    set.add(sgt.getGoodsId());
//                }
            }
            page++;
            example.setStartIndex(page*size);
            example.setEndIndex(size);
            list=shiguGoodsTinyMapper.selectByConditionList(example);
        }
    }

    /**
     * 撸广告
     */
    @Test
    public void adsgo(){
        GoatFieldExample fieldExample=new GoatFieldExample();
        fieldExample.createCriteria().andFieldNameEqualTo("goods_id");
        List<GoatField> fields=goatFieldMapper.selectByExample(fieldExample);
        List<Long> fids=new ArrayList<>();
        for(GoatField field:fields){
            fids.add(field.getFid());
        }
        GoatFieldValueExample fieldValueExample=new GoatFieldValueExample();
        fieldValueExample.createCriteria().andFidIn(fids);
        List<GoatFieldValue> fieldValues=goatFieldValueMapper.selectByExample(fieldValueExample);

        List<Long> goodsIds=new ArrayList<>();
        for(GoatFieldValue g:fieldValues){
            goodsIds.add(Long.valueOf(g.getValue()));
        }

        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.setWebSite("hz");
        example.createCriteria().andGoodsIdIn(goodsIds);
        List<ShiguGoodsTiny> list=shiguGoodsTinyMapper.selectByExample(example);
            for(ShiguGoodsTiny sgt:list){
//                if(Math.random()<0.5){
//                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
//                }
//                if(Math.random()<0.4){
//                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
//                }
//                if(Math.random()<0.3){
//                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
//                }
//                if(Math.random()<0.2){
//                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
//                }
                if(Math.random()<0.1){
                    itemUpRecordService.addItemUpRecord(upGoods(sgt));
                }
            }
    }


    public ItemUpRecordVO upGoods(ShiguGoodsTiny tiny){
        ItemUpRecordVO itemUpRecordVO=new ItemUpRecordVO();
        itemUpRecordVO.setSupperGoodsId(tiny.getGoodsId());
        itemUpRecordVO.setWebSite("hz");
        itemUpRecordVO.setFenUserNick("赵洪波5");
        itemUpRecordVO.setFenUserId(1000063657L);
        itemUpRecordVO.setFenGoodsName(tiny.getTitle());
        itemUpRecordVO.setFenImage(tiny.getPicUrl());
        itemUpRecordVO.setFenNumiid(1000000L);
        itemUpRecordVO.setFenPrice(tiny.getPriceString());
        itemUpRecordVO.setSupperImage(tiny.getPicUrl());
        //itemUpRecordVO.setSupperTaobaoUrl(tiny.getDetailUrl());
        itemUpRecordVO.setSupperGoodsId(tiny.getGoodsId());
        itemUpRecordVO.setSupperGoodsName(tiny.getTitle());
        itemUpRecordVO.setSupperPrice(tiny.getPriceString());
        itemUpRecordVO.setSupperPiPrice(tiny.getPiPriceString());
        itemUpRecordVO.setSupperStoreId(tiny.getStoreId());
        itemUpRecordVO.setSupperMarketId(tiny.getMarketId());
        itemUpRecordVO.setSupperNumiid(tiny.getNumIid());
//        itemUpRecordVO.setSupper
        itemUpRecordVO.setFlag("wx");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        itemUpRecordVO.setDaiTime(sdf.format(new Date()));
        ShiguShop shop=shiguShopMapper.selectByPrimaryKey(tiny.getStoreId());
        itemUpRecordVO.setSupperStorenum(shop.getShopNum());
        itemUpRecordVO.setStatus(0L);
        return itemUpRecordVO;

    }
}
