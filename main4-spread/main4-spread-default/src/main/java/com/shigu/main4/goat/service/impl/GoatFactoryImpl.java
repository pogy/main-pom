package com.shigu.main4.goat.service.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.GoatItemData;
import com.opentae.data.mall.beans.GoatOneItem;
import com.opentae.data.mall.beans.GoatOneLocation;
import com.opentae.data.mall.examples.GoatItemDataExample;
import com.opentae.data.mall.examples.GoatOneItemExample;
import com.opentae.data.mall.examples.GoatOneLocationExample;
import com.opentae.data.mall.interfaces.GoatItemDataMapper;
import com.opentae.data.mall.interfaces.GoatOneItemMapper;
import com.opentae.data.mall.interfaces.GoatOneLocationMapper;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.goat.beans.GoatLocation;
import com.shigu.main4.goat.enums.GoatType;
import com.shigu.main4.goat.service.Goat;
import com.shigu.main4.goat.service.GoatFactory;
import com.shigu.main4.goat.vo.GoatLocationVO;
import com.shigu.main4.goat.vo.GoatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * 广告工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service
public class GoatFactoryImpl implements GoatFactory{

    @Autowired
    GoatOneLocationMapper goatOneLocationMapper;

    @Resource(name="tae_mall_goatOneItemMapper")
    GoatOneItemMapper goatOneItemMapper;

    @Resource(name="tae_mall_goatItemDataMapper")
    GoatItemDataMapper goatItemDataMapper;

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
            public <T extends GoatVO> List<T> selGoats() throws ActivityException {
                Long loacalId=this.getLocalId();
                GoatOneItemExample goiex=new GoatOneItemExample();
                goiex.createCriteria().andLocalIdEqualTo(loacalId).andDisEnabledEqualTo(false);
                //1.查询广告位置下的有效广告
                List<GoatOneItem> goilist=goatOneItemMapper.selectByExample(goiex);

                //2.查询这些广告的线上版本数据
                List<Long> gIdlist=new ArrayList<>();
                for(GoatOneItem gi:goilist){
                    gIdlist.add(gi.getGoatId());
                }
                GoatItemDataExample gidex=new GoatItemDataExample();
                gidex.createCriteria().andGoatIdIn(gIdlist);
                List<GoatItemData> gidlist;
                if(gIdlist.size()>0)
                    gidlist=goatItemDataMapper.selectByExample(gidex);
                else
                    gidlist=new ArrayList<>();

                List<T> rlist = new ArrayList<>();
                //3.根据Location中的goatType判断需要包装的返回对象

                for (GoatOneItem oneItem : goilist) {
                    boolean isde = false;
                    for (GoatItemData item : gidlist) {
                        if (oneItem.getGoatId().longValue() == item.getGoatId()) {

                            T t = (T)JSON.parseObject(item.getContext(),
                                    GoatType.values()[this.getGoatType()].getGoatVoClass());
                            BeanMapper.map(item, t);
                            rlist.add(t);
                            isde = true;
                        }

                    }
                    //4.验证广告没有数据的情况，在goat_item_data中查不到在线的对应，保持GoatVO中fromTime、
                    // toTime为null添加到结果集中
                    T t;
                    if (!isde) {
                        try {
                            t = (T) GoatType.values()[this.getGoatType()].getGoatVoClass().newInstance();
                            BeanMapper.map(oneItem, t);
                            rlist.add(t);
                        } catch (InstantiationException e) {
                            throw new ActivityException("系统错误");
                        } catch (IllegalAccessException e) {
                            throw new ActivityException("系统错误");
                        }


                    }


                }




                return rlist;
            }

            @Override
            public <T extends GoatVO> List<T> selPrepareGoats() {
                return null;
            }
        };
        return BeanMapper.mapAbstact(vo,location);
    }

    @Override
    public <T extends Goat> T selGoatById(Long goatId) {
        return null;
    }

    @Override
    public <T extends Goat,D extends GoatVO> T selGoatByVo(D goatVO) {

        return null;
    }


}
