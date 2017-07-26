package com.shigu.main4.order.services.impl;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.order.bo.TbOrderBO;
import com.shigu.main4.order.enums.TbOrderStatusEnum;
import com.shigu.main4.order.exceptions.NotFindRelationGoodsException;
import com.shigu.main4.order.exceptions.NotFindSessionException;
import com.shigu.main4.order.services.TaoOrderService;
import com.shigu.main4.order.servicevo.RelationGoodsVO;
import com.shigu.main4.order.servicevo.SubTbOrderVO;
import com.shigu.main4.order.servicevo.TbOrderVO;
import com.shigu.main4.order.vo.GoodsVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zf on 2017/7/21.
 */
@Service
public class TaoOrderServiceImpl implements TaoOrderService{


    @Override
    public String myTbSessionKey(Long userId) throws NotFindSessionException {
        if(userId.longValue()==35377l){
            return "62007011dfh93fZZ2797b05c16099c139f508bddae20d2149286892";
        }
        throw new NotFindSessionException();
    }

    @Override
    public ShiguPager<TbOrderVO> myTbOrders(TbOrderBO bo, String sessionKey) {
        List<TbOrderVO> tbs=new ArrayList<>();
        for(int i=0;i<20;i++){
            TbOrderVO v=new TbOrderVO();
            v.setTime("2017-07-"+(10+i)+" 16:59:00");
            v.setLastTime("2017-07-"+(11+i)+" 16:59:00");
            v.setTbId(10000l+i);
            v.setAddress("王朝晖 , 136847653874 , 浙江省杭州市江干区火炬大道3586号海创园12幢356室 ");
            List<SubTbOrderVO> sbs=new ArrayList<>();
            int r=new Random().nextInt(3)+1;
            for(int j = 0; j<r; j++){
                SubTbOrderVO sb=new SubTbOrderVO();
                if(j==0){
                    if(i!=5){
                        sb.setXzPrice("10.00");
                        sb.setXzPriceLong(1000l);
                        sb.setGoodsNo("a01");
                    }


                    sb.setColor("白");
                    sb.setSize("XL");
                    sb.setNewTbPrice("15.00");
                    sb.setNewTbPriceLong(1500l);
                    sb.setImgSrc("https://img.alicdn.com/bao/uploaded/i3/88883256/TB2M.kXwbxmpuFjSZJiXXXauVXa_!!88883256.jpg");
                    sb.setNum(1);
                    sb.setNumiid(900000l+i);
                    sb.setOldTbPrice("25.00");
                    sb.setOldTbPriceLong(2500l);
                    sb.setTbChildOrderId(110000l+i);
                    sb.setTitle("男士棉麻5分五分裤男夏天运动沙滩中");
                    sbs.add(sb);
                }
                if(j==1){
                    if(i%2!=1){
                        sb.setXzPrice("20.00");
                        sb.setXzPriceLong(2000l);
                        sb.setGoodsNo("a01");
                    }
                    sb.setColor("白");
                    sb.setSize("L");
                    sb.setNewTbPrice("35.00");
                    sb.setNewTbPriceLong(3500l);
                    sb.setImgSrc("https://img.alicdn.com/bao/uploaded/i1/666491460/TB2X1PTqr4npuFjSZFmXXXl4FXa_!!666491460.jpg");
                    sb.setNum(1);
                    sb.setNumiid(900001l+i);
                    sb.setOldTbPrice("50.00");
                    sb.setOldTbPriceLong(5000l);
                    sb.setTbChildOrderId(110000l+i);
                    sb.setTitle("男士棉麻5分五分裤男夏天运动沙滩中");

                    sbs.add(sb);
                }
                if(j==2){
                    if(i%4!=1){
                        sb.setXzPrice("10.00");
                        sb.setXzPriceLong(1000l);
                        sb.setGoodsNo("a01");
                    }
                    sb.setColor("黑");
                    sb.setSize("XL");
                    sb.setNewTbPrice("15.00");
                    sb.setNewTbPriceLong(1500l);
                    sb.setImgSrc("https://img.alicdn.com/bao/uploaded/i4/691575494/TB29FoJwhxmpuFjSZFNXXXrRXXa_!!691575494.jpg");
                    sb.setNum(1);
                    sb.setNumiid(900002l+i);
                    sb.setOldTbPrice("25.00");
                    sb.setOldTbPriceLong(2500l);
                    sb.setTbChildOrderId(110000l+i);
                    sb.setTitle("男士棉麻5分五分裤男夏天运动沙滩中");
                    sbs.add(sb);
                }
            }
            v.setChildOrders(sbs);
            tbs.add(v);
        }
        if(bo.getEndTime()!=null){
            Integer et=new Integer(DateUtil.dateToString(bo.getEndTime(),DateUtil.patternB));
            for(int i=0;i<tbs.size();i++){
                if(new Integer(DateUtil.dateToString(DateUtil.stringToDate(tbs.get(i).getTime(),DateUtil.patternD),DateUtil.patternB))>et){
                    tbs.remove(i);
                    i--;
                }
            }
        }
        if(bo.getStartTime()!=null){
            Integer st=new Integer(DateUtil.dateToString(bo.getStartTime(),DateUtil.patternB));
            for(int i=0;i<tbs.size();i++){
                if(new Integer(DateUtil.dateToString(DateUtil.stringToDate(tbs.get(i).getTime(),DateUtil.patternD),DateUtil.patternB))<st){
                    tbs.remove(i);
                    i--;
                }
            }
        }
        int num=0;
        List<TbOrderVO> ts=new ArrayList<>();
        for(int i=(bo.getPage()-1)*bo.getPageSize();i<tbs.size();i++){
            ts.add(tbs.get(i));
            num++;
            if(num==bo.getPageSize()){
                break;
            }
        }
        ShiguPager<TbOrderVO> sp=new ShiguPager<>();
        sp.setContent(ts);
        sp.setNumber(bo.getPage());
        sp.calPages(tbs.size(),bo.getPageSize());
        return sp;
    }

    @Override
    public TbOrderVO myTbOrder(Long tid, TbOrderStatusEnum status, String sessionKey) {
        if(tid.longValue()!=10000l){
            return null;
        }

        TbOrderVO v=new TbOrderVO();
        v.setTime("2017-07-"+(10)+" 16:59:00");
        v.setLastTime("2017-07-"+(11)+" 16:59:00");
        v.setTbId(10000l);
        v.setAddress("王朝晖 , 136847653874 , 浙江省杭州市江干区火炬大道3586号海创园12幢356室 ");
        List<SubTbOrderVO> sbs=new ArrayList<>();
        int r=new Random().nextInt(3)+1;
        for(int j = 0; j<r; j++){
            SubTbOrderVO sb=new SubTbOrderVO();
            if(j==0){
                sb.setXzPrice("10.00");
                sb.setXzPriceLong(1000l);
                sb.setGoodsNo("a01");
                sb.setColor("白");
                sb.setSize("XL");
                sb.setNewTbPrice("15.00");
                sb.setNewTbPriceLong(1500l);
                sb.setImgSrc("https://img.alicdn.com/bao/uploaded/i3/88883256/TB2M.kXwbxmpuFjSZJiXXXauVXa_!!88883256.jpg");
                sb.setNum(1);
                sb.setNumiid(900000l);
                sb.setOldTbPrice("25.00");
                sb.setOldTbPriceLong(2500l);
                sb.setTbChildOrderId(110000l);
                sb.setTitle("男士棉麻5分五分裤男夏天运动沙滩中");
                sbs.add(sb);
            }
            if(j==1){
                sb.setXzPrice("20.00");
                sb.setXzPriceLong(2000l);
                sb.setGoodsNo("a01");
                sb.setColor("白");
                sb.setSize("L");
                sb.setNewTbPrice("35.00");
                sb.setNewTbPriceLong(3500l);
                sb.setImgSrc("https://img.alicdn.com/bao/uploaded/i1/666491460/TB2X1PTqr4npuFjSZFmXXXl4FXa_!!666491460.jpg");
                sb.setNum(1);
                sb.setNumiid(900001l);
                sb.setOldTbPrice("50.00");
                sb.setOldTbPriceLong(5000l);
                sb.setTbChildOrderId(110000l);
                sb.setTitle("男士棉麻5分五分裤男夏天运动沙滩中");

                sbs.add(sb);
            }
            if(j==2){
                sb.setXzPrice("10.00");
                sb.setXzPriceLong(1000l);
                sb.setGoodsNo("a01");
                sb.setColor("黑");
                sb.setSize("XL");
                sb.setNewTbPrice("15.00");
                sb.setNewTbPriceLong(1500l);
                sb.setImgSrc("https://img.alicdn.com/bao/uploaded/i4/691575494/TB29FoJwhxmpuFjSZFNXXXrRXXa_!!691575494.jpg");
                sb.setNum(1);
                sb.setNumiid(900002l);
                sb.setOldTbPrice("25.00");
                sb.setOldTbPriceLong(2500l);
                sb.setTbChildOrderId(110000l);
                sb.setTitle("男士棉麻5分五分裤男夏天运动沙滩中");
                sbs.add(sb);
            }
        }
        v.setChildOrders(sbs);
        return v;
    }

    @Override
    public RelationGoodsVO glGoodsJson(Long numiid) throws NotFindRelationGoodsException {
        if(numiid.longValue()==900005l){
            throw new NotFindRelationGoodsException();
        }
        RelationGoodsVO v=new RelationGoodsVO();
        v.setGoodsNo("A1");
        v.setPrice("15.00");
        v.setPriceLong(1500l);
        return v;
    }


    @Override
    public RelationGoodsVO glGoodsJson(Long numiid, Long goodsId) throws NotFindRelationGoodsException {
        if(goodsId.longValue()==900005l){
            throw new NotFindRelationGoodsException();
        }
        RelationGoodsVO v=new RelationGoodsVO();
        v.setGoodsNo("A1");
        v.setPrice("15.00");
        v.setPriceLong(1500l);
        return v;
    }
}
