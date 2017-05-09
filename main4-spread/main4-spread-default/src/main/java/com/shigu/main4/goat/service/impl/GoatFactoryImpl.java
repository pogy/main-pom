package com.shigu.main4.goat.service.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.GoatItemData;
import com.opentae.data.mall.beans.GoatOneLocation;
import com.opentae.data.mall.beans.GoodsupNoreal;
import com.opentae.data.mall.examples.GoatItemDataExample;
import com.opentae.data.mall.examples.GoatOneLocationExample;
import com.opentae.data.mall.examples.GoodsupNorealExample;
import com.opentae.data.mall.interfaces.GoatItemDataMapper;
import com.opentae.data.mall.interfaces.GoatOneItemMapper;
import com.opentae.data.mall.interfaces.GoatOneLocationMapper;
import com.opentae.data.mall.interfaces.GoodsupNorealMapper;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.beans.ImgGoat;
import com.shigu.main4.goat.beans.ItemGoat;
import com.shigu.main4.goat.beans.TextGoat;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.exceptions.GoatException;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;
import com.shigu.main4.goat.vo.ImgGoatVO;
import com.shigu.main4.goat.vo.ItemGoatVO;
import com.shigu.main4.goat.vo.ItemUpVO;
import com.shigu.main4.goat.vo.TextGoatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 广告工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service("goatFactory")
public class GoatFactoryImpl implements GoatFactory{

    @Autowired
    GoatOneLocationMapper goatOneLocationMapper;

    @Autowired
    GoatOneItemMapper goatOneItemMapper;

    @Autowired
    GoatItemDataMapper goatItemDataMapper;
    @Autowired
    GoodsupNorealMapper goodsupNorealMapper;

    /**
     * 查一个广告位
     * @param code 广告编号
     * @return 广告位对象
     * @throws ActivityException
     */
    @Override
    public GoatLocation getALocation(String code) throws ActivityException {
        GoatOneLocationExample example=new GoatOneLocationExample();
        example.createCriteria().andLocalCodeEqualTo(code).andDisEnabledEqualTo(false);
        example.setStartIndex(0);
        example.setEndIndex(1);
        List<GoatOneLocation> locations=goatOneLocationMapper.selectByConditionList(example);
        if(locations.size()==0){
            throw new ActivityException("获取广告位置["+code+"]失败");
        }
        return getALocationByVo(BeanMapper.map(locations.get(0),GoatLocationVO.class));
    }

    @Override
    public GoatLocation getALocationByVo(GoatLocationVO vo) {
        GoatLocation location=new GoatLocation() {
            @Override
            public <T extends GoatVO> List<T> selGoats() {
                return null;
            }

            @Override
            public <T extends GoatVO> List<T> selPrepareGoats() {
                return null;
            }
        };
        return BeanMapper.map(vo,location);
    }

    @Override
    public <T extends Goat> T selGoatById(Long goatId) throws GoatException {
        //查出在线广告数据
        GoatItemDataExample goatItemDataExample=new GoatItemDataExample();
        goatItemDataExample.createCriteria().andGoatIdEqualTo(goatId).andStatusEqualTo(1);
        goatItemDataExample.setStartIndex(0);
        goatItemDataExample.setEndIndex(1);
        List<GoatItemData> datas=goatItemDataMapper.selectByConditionList(goatItemDataExample);
        GoatItemData gid;
        if(datas.size()==1){
            gid=datas.get(0);
        }else{
            gid=new GoatItemData();
            gid.setGoatId(goatId);
        }
        return selGoatByVo(unserializeGoat(gid));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Goat,D extends GoatVO> T selGoatByVo(D goatVO) {
        if(goatVO.getClass().equals(GoatType.ImgGoat.getGoatVoClass())){
            return (T) selImgGoat((ImgGoatVO) goatVO);
        }
        if(goatVO.getClass().equals(GoatType.TextGoat.getGoatVoClass())){
            return (T) selTextGoat((TextGoatVO) goatVO);
        }
        if(goatVO.getClass().equals(GoatType.ItemGoat.getGoatVoClass())){
            return (T) selItemGoat((ItemGoatVO) goatVO);
        }
        return null;
    }

    /**
     * 图片式广告对象制作
     * @param imgGoatVO
     * @return
     */
    private ImgGoat selImgGoat(ImgGoatVO imgGoatVO){
        ImgGoat goat=new ImgGoat() {
            @Override
            public void publish() {

            }

            @Override
            public void preparePublish(Long second) {

            }
        };
        return BeanMapper.mapAbstact(imgGoatVO,goat);
    }

    /**
     * 商品式广告对象制作
     * @param itemGoatVO
     * @return
     */
    private ItemGoat selItemGoat(ItemGoatVO itemGoatVO){
        ItemGoat goat=new ItemGoat() {
            @Override
            public void publish() {

            }

            @Override
            public void preparePublish(Long second) {

            }

            @Override
            public ItemUpVO selUp() {
                return null;
            }

            @Override
            public void modifyUp(Integer num) {
                GoodsupNoreal gn=new GoodsupNoreal();
                gn.setItemId(this.getItemId());
                gn=goodsupNorealMapper.selectOne(gn);
                if(gn==null){
                    gn=new GoodsupNoreal();
                    gn.setItemId(this.getItemId());
                    gn.setAddNum(num);
                    goodsupNorealMapper.insertSelective(gn);
                }else{
                    GoodsupNoreal g=new GoodsupNoreal();
                    g.setNorealId(gn.getNorealId());
                    g.setAddNum(gn.getAddNum()+num);
                    goodsupNorealMapper.updateByPrimaryKeySelective(g);
                }
            }

            @Override
            public Double selWeight() {
                return null;
            }

            @Override
            public void updateWeight(Double weight) {

            }
        };
        return BeanMapper.mapAbstact(itemGoatVO,goat);
    }

    /**
     * 文字式广告
     * @param textGoatVO
     * @return
     */
    private TextGoat selTextGoat(TextGoatVO textGoatVO){
        TextGoat goat=new TextGoat() {
            @Override
            public void publish() {

            }

            @Override
            public void preparePublish(Long second) {

            }
        };
        return BeanMapper.mapAbstact(textGoatVO,goat);
    }

    /**
     * 序列化对象数据
     * @param goat 广告数据
     * @param <T> 不同的广告类型
     * @return 数据库存储广告数据
     */
    private <T extends GoatVO> GoatItemData serializeGoat(T goat){
        return null;
    }

    /**
     * 反序列化对象数据
     * @param data 数据库存储广告数据
     * @param <T> 不同广告类型
     * @return 广告数据
     */
    private <T extends GoatVO> T unserializeGoat(GoatItemData data){
        return null;
    }
    /**
     * 发布广告
     * @param vo
     */
    private void publishCommon(GoatVO vo){

    }
}
