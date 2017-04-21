package com.shigu.main4.spread.service.impl;

import com.opentae.data.mall.beans.GoatField;
import com.opentae.data.mall.beans.GoatItemWithField;
import com.opentae.data.mall.beans.GoatLocation;
import com.opentae.data.mall.beans.GoatModel;
import com.opentae.data.mall.examples.GoatFieldExample;
import com.opentae.data.mall.examples.GoatLocationExample;
import com.opentae.data.mall.interfaces.GoatFieldMapper;
import com.opentae.data.mall.interfaces.GoatItemMapper;
import com.opentae.data.mall.interfaces.GoatLocationMapper;
import com.opentae.data.mall.interfaces.GoatModelMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.spread.enums.GoatTypeEnum;
import com.shigu.main4.spread.exceptions.GoatException;
import com.shigu.main4.spread.service.GoatGetService;
import com.shigu.main4.spread.vo.GoatALocation;
import com.shigu.main4.spread.vo.GoatFieldVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 广告数据的获取
 * Created by Licca on 17/4/10.
 */
@Service
public class GoatGetServiceImpl implements GoatGetService{

    /**
     * 广告位置
     */
    @Autowired
    GoatItemMapper goatItemMapper;

    @Autowired
    GoatLocationMapper goatLocationMapper;

    @Autowired
    GoatModelMapper goatModelMapper;

    @Autowired
    GoatFieldMapper goatFieldMapper;

    @Override
    public GoatALocation getAlocation(String code) throws GoatException {
        GoatLocation l=new GoatLocation();
        l.setLocalCode(code);
        l.setDisEnabled(false);
        l=goatLocationMapper.selectOne(l);
        if(l==null){
            throw new GoatException("广告编号["+code+"]对应的位置不存在");
        }
        GoatALocation location= BeanMapper.map(l,GoatALocation.class);
        location.setType(l.getType());
        //如果是普通类别的广告，需要查模板
        if(location.getType().equals(GoatTypeEnum.NORMAL)){
            GoatModel model=new GoatModel();
            model.setLocationId(location.getLocalId());
            model=goatModelMapper.selectOne(model);
            if (model != null) {
                location.setModel(model.getModelHtml());
            }
        }
        //读取广告位置属性
        GoatFieldExample fieldExample=new GoatFieldExample();
        fieldExample.createCriteria().andLocationIdEqualTo(location.getLocalId());
        List<GoatFieldVO> fieldVOs=BeanMapper.mapList(goatFieldMapper.selectByExample(fieldExample),GoatFieldVO.class);
        location.setFields(fieldVOs);
        return location;
    }

    /**
     * 查单个广告位置的全部数据
     * @param code
     * @return
     */
    @Override
    public GoatALocation getLocationData(String code) throws GoatException {
        //得到广告位置
        GoatALocation location=getAlocation(code);
        List<GoatItemWithField> itemFields=goatItemMapper.selItemsWithField(location.getLocalId());
        List<GoatALocation.GoatAItem> items=new ArrayList<>();
        location.setItems(items);
        for(GoatItemWithField g:itemFields){
            //创建一个临时实例
            GoatALocation.GoatAItem item=location.getItemInstense();
            item.setGoatId(g.getGoatId());
            if(items.contains(item)){//如果已经添加过了
                item=items.get(items.indexOf(item));//取出已经有了的那个item
            }else{//如果没有，添加到list
                items.add(item);
            }
            GoatFieldVO fieldVO=new GoatFieldVO();
            fieldVO.setFid(g.getFid());
            //从广告位置中取出本属性
            fieldVO=location.getFields().get(location.getFields().indexOf(fieldVO));
            if(fieldVO!=null){//如果属性存在
                item.put(fieldVO,g.getValue());
            }
        }
        return location;
    }
}
