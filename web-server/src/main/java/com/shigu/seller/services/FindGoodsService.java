package com.shigu.seller.services;

import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.opentae.data.mall.beans.ActiveDrawPit;
import com.opentae.data.mall.beans.ActiveDrawShop;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.examples.ActiveDrawGoodsExample;
import com.opentae.data.mall.examples.ActiveDrawPitExample;
import com.opentae.data.mall.examples.ActiveDrawShopExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.ActiveDrawGoodsMapper;
import com.opentae.data.mall.interfaces.ActiveDrawPitMapper;
import com.opentae.data.mall.interfaces.ActiveDrawShopMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.bo.FindGoodsSelBO;
import com.shigu.seller.vo.FindGoodsItemVO;
import com.shigu.seller.vo.FindGoodsVO;
import com.shigu.seller.vo.MyFindTermVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by zhaohongbo on 17/5/27.
 */
@Service
public class FindGoodsService {

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    ActiveDrawService activeDrawService;

    @Autowired
    ActiveDrawPitMapper activeDrawPitMapper;

    @Autowired
    ActiveDrawShopMapper activeDrawShopMapper;

    @Autowired
    ActiveDrawGoodsMapper activeDrawGoodsMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    RedisIO redisIO;

    final String SHOP_SET_LIMIT_SUFFIX="shop_set_";

    public ShiguPager<FindGoodsItemVO> selItemsForFindGoods(FindGoodsSelBO bo, Long shopId, String webSite, Integer size){
        ShiguPager<ItemShowBlock> pager=shopForCdnService.searchItemOnsale(bo.getQ(),shopId,webSite
                ,bo.getStartPrice(),bo.getEndPrice(),"time_down",null,null,bo.getPage(),size);
        List<FindGoodsItemVO> items=new ArrayList<>();
        for(ItemShowBlock isb:pager.getContent()){
            items.add(new FindGoodsItemVO(isb));
        }
        ShiguPager<FindGoodsItemVO> resultpager=new ShiguPager<>();
        resultpager.setContent(items);
        resultpager.setTotalCount(pager.getTotalCount());
        resultpager.setNumber(pager.getNumber());
        resultpager.setTotalPages(pager.getTotalPages());
        return resultpager;
    }

    /**
     * 设置广告
     * @param pid
     * @param goodsId
     * @param shopId
     */
    public void setGoods(Long termId,Long pid,Long goodsId,Long shopId) throws Main4Exception {
        //验证坑位今天是否第二次设置
        String limitKey=SHOP_SET_LIMIT_SUFFIX+shopId+"_"+termId+"_"+pid;
        Long shoplimit=redisIO.get(limitKey,Long.class);
        if (shoplimit == null) {
            shoplimit=0L;
        }else if(shoplimit>1L){
            throw new Main4Exception("同一个广告位,一天最多更换两次");
        }

        ActiveDrawPit adp=activeDrawPitMapper.selectByPrimaryKey(pid);
        Integer num=adp.getNum();
        //查出发现好店的pid
        num=(num-1)%20+1;
        ActiveDrawPitExample pitExample=new ActiveDrawPitExample();
        pitExample.createCriteria().andNumEqualTo(num).andTypeEqualTo("shop");
        pitExample.setStartIndex(0);
        pitExample.setEndIndex(1);
        List<ActiveDrawPit> adplist=activeDrawPitMapper.selectByConditionList(pitExample);
        if(adplist.size()==0){
            throw new Main4Exception("广告位置信息错误");
        }
        Long shopPitId=adplist.get(0).getId();
        //验证店铺
        ActiveDrawShopExample shopExample=new ActiveDrawShopExample();
        shopExample.createCriteria().andShopIdEqualTo(shopId).andPemIdEqualTo(termId).andPitIdEqualTo(shopPitId);
        if(activeDrawShopMapper.countByExample(shopExample)==0){
            throw new Main4Exception("位置不属于当前店铺");
        }
        try {
            activeDrawService.changeDrawGoods(pid,goodsId,termId,"FAGOODS");
        } catch (Exception e) {
            throw new Main4Exception("同一个商品不能设置在多个广告位上");
        }
        shoplimit++;
        long oneDay=3600*24*1000;
        long now=System.currentTimeMillis()+8*3600*1000;
        int delay= (int) ((oneDay-now%oneDay)/1000);
        redisIO.putTemp(limitKey,shoplimit,delay);
    }

    /**
     * 每个人自己的期内容
     * @param shopId
     * @return
     * @throws Main4Exception
     */
    public List<MyFindTermVO> termVOs(Long shopId) throws Main4Exception {
        List<ActiveDrawPemVo>  pems=activeDrawService.selDrawPemQueList();//当前期或下一期
        Map<Long,ActiveDrawPemVo> pemMap=BeanMapper.list2Map(pems,"id",Long.class);
        List<Long> pemIds= BeanMapper.getFieldList(pems,"id",Long.class);
        if(pemIds.size()==0){
            throw new Main4Exception("活动不在进行中");
        }
        //把坑位都查出,放在这对照
        List<ActiveDrawPit> pitList=activeDrawPitMapper.selectByExample(new ActiveDrawPitExample());
        Map<Long,ActiveDrawPit> pitMap=BeanMapper.list2Map(pitList,"id",Long.class);
        //重出属于自己的坑位
        ActiveDrawShopExample shopExample=new ActiveDrawShopExample();
        shopExample.createCriteria().andPemIdIn(pemIds).andShopIdEqualTo(shopId);
        List<ActiveDrawShop> shops=activeDrawShopMapper.selectByExample(shopExample);
        Map<Long,MyFindTermVO> map=new HashMap<>();
        List<MyFindTermVO> myFindTermVOs=new ArrayList<>();
        for(ActiveDrawShop s:shops){
            MyFindTermVO mftvo=map.get(s.getPemId());
            if(mftvo == null){
                mftvo=new MyFindTermVO();
                mftvo.setTermId(s.getPemId());
                ActiveDrawPemVo adpem=pemMap.get(s.getPemId());
                mftvo.setTerm(adpem.getTerm());
                mftvo.setStartOnline(DateUtil.dateToString(adpem.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
                Calendar cal=Calendar.getInstance();
                cal.setTime(adpem.getStartTime());
                cal.add(Calendar.DATE,7);
                mftvo.setEndOnline(DateUtil.dateToString(cal.getTime(),"yyyy-MM-dd HH:mm:ss"));
                mftvo.setGoods(new ArrayList<FindGoodsVO>());
                map.put(s.getPemId(),mftvo);
                myFindTermVOs.add(mftvo);
            }
            //查出第N个和第20+N个广告位的数据
            Integer shopHoleNum=pitMap.get(s.getPitId()).getNum();
            for(ActiveDrawPit ap:pitList){
                ActiveDrawPit me=null;
                if(ap.getNum().equals(shopHoleNum)&&ap.getType().equals("goods")){
                    me=ap;
                }else if(ap.getNum().equals(shopHoleNum+20)&&ap.getType().equals("goods")){
                    me=ap;
                }
                if (me != null) {
                    FindGoodsVO findGoodsVO=new FindGoodsVO();
                    findGoodsVO.setId(me.getId());
                    findGoodsVO.setCode(parseCode(me.getNum()));
                    mftvo.getGoods().add(findGoodsVO);
                }
            }
            //把广告值填进去
            List<Long> pids=BeanMapper.getFieldList(mftvo.getGoods(),"id",Long.class);
            ActiveDrawGoodsExample goodsExample=new ActiveDrawGoodsExample();
            goodsExample.createCriteria().andPitIdIn(pids).andPemIdEqualTo(s.getPemId());
            List<ActiveDrawGoods> activeDrawGoodses=activeDrawGoodsMapper.selectByExample(goodsExample);
            Map<Long,ActiveDrawGoods> drawGoodsMap=BeanMapper.list2Map(activeDrawGoodses,"pitId",Long.class);

            List<Long> goodsIds=BeanMapper.getFieldList(activeDrawGoodses,"goodsId",Long.class);
            Map<Long,ShiguGoodsTiny> tinyMap=new HashMap<>();
            if(goodsIds.size()>0){
                ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
                example.setWebSite("hz");
                example.createCriteria().andGoodsIdIn(goodsIds);
                List<ShiguGoodsTiny> tinies=shiguGoodsTinyMapper.selectByExample(example);
                tinyMap=BeanMapper.list2Map(tinies,"goodsId",Long.class);
            }
            //把值赋好
            for(FindGoodsVO fgv:mftvo.getGoods()){
                //拿到坑的数据
                ActiveDrawGoods drawGoods=drawGoodsMap.get(fgv.getId());
                //拿到商品数据
                ShiguGoodsTiny tiny=tinyMap.get(drawGoods.getGoodsId());
                if (tiny == null) {
                    continue;
                }
                fgv.setWebSite(tiny.getWebSite());
                fgv.setGoodsId(tiny.getGoodsId());
                fgv.setPicUrl(tiny.getPicUrl());
            }
        }
        return myFindTermVOs;
    }

    private String parseCode(Integer number){
        String result="";
        if(number<20){
            result+=(number/5 + 1)+"-"+((number-1)%5+1);
        }else{
            number=number-20;
            result+=(number/5 + 1)+"-"+((number-1)%5+1)+"-1";
        }
        return result;
    }

}
