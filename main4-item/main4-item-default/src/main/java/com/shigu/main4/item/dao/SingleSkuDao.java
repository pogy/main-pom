package com.shigu.main4.item.dao;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguGoodsSingleSku;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.TaobaoItemProp;
import com.opentae.data.mall.beans.TaobaoPropValue;
import com.opentae.data.mall.examples.ShiguGoodsSingleSkuExample;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.ShiguGoodsSingleSkuMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.TaobaoItemPropMapper;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.item.services.utils.SkuCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SingleSkuDao {
    @Autowired
    TaobaoItemPropMapper taobaoItemPropMapper;
    @Autowired
    TaobaoPropValueMapper taobaoPropValueMapper;
    @Autowired
    ShiguGoodsSingleSkuMapper shiguGoodsSingleSkuMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Transactional(rollbackFor = Exception.class)
    public void pushSkus(String webSite,Long goodsId,List<ShiguGoodsSingleSku> inserts,List<ShiguGoodsSingleSku> updates,List<Long> dels){
        //执行写入
        if (inserts.size() > 0) {
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setWebSite(webSite);
            tiny.setGoodsId(goodsId);
            tiny = shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny, FieldUtil.codeFields("goods_id,cid"));
            List<Long> ivids = new ArrayList<>();
            inserts.forEach(shiguGoodsSingleSku -> {
                if(shiguGoodsSingleSku.getColorVid()!=0L){
                    ivids.add(shiguGoodsSingleSku.getColorVid());
                }
                if(shiguGoodsSingleSku.getSizeVid()!=0L){
                    ivids.add(shiguGoodsSingleSku.getSizeVid());
                }
            });
            if(ivids.size()>0){
                TaobaoItemProp itemProp = new TaobaoItemProp();
                itemProp.setCid(tiny.getCid());
                itemProp.setIsSaleProp(1);
                List<TaobaoItemProp> itemProps = taobaoItemPropMapper.select(itemProp);
                List<Long> ipids = itemProps.stream().filter(taobaoItemProp -> taobaoItemProp.getIsColorProp() == 1
                        || SkuCheckUtil.isSizeProp(taobaoItemProp.getPid().toString(), taobaoItemProp.getName()))
                        .map(TaobaoItemProp::getPid).collect(Collectors.toList());
                TaobaoPropValueExample taobaoPropValueExample = new TaobaoPropValueExample();
                taobaoPropValueExample.createCriteria().andCidEqualTo(tiny.getCid()).andVidIn(ivids).andPidIn(ipids);
                List<TaobaoPropValue> propValues = taobaoPropValueMapper.selectByExample(taobaoPropValueExample);
                Map<Long, TaobaoPropValue> propValueMap = propValues.stream()
                        .collect(Collectors.toMap(TaobaoPropValue::getVid, o -> o));
                inserts.forEach(shiguGoodsSingleSku -> {
                    TaobaoPropValue v = propValueMap.get(shiguGoodsSingleSku.getColorVid());
                    if(v!=null){
                        shiguGoodsSingleSku.setColorPid(v.getPid());
                        shiguGoodsSingleSku.setColorName(v.getName());
                    }
                    TaobaoPropValue v1 = propValueMap.get(shiguGoodsSingleSku.getSizeVid());
                    if(v1!=null){
                        shiguGoodsSingleSku.setSizePid(v1.getPid());
                        shiguGoodsSingleSku.setSizeName(v1.getName());
                    }
                });
            }
            shiguGoodsSingleSkuMapper.insertListNoIdMore(inserts,webSite);
        }
        //执行修改,由于设计到null的问题,所以这里用全字段修改
        if (updates.size() > 0) {
            updates.forEach(shiguGoodsSingleSku -> shiguGoodsSingleSkuMapper.updateByPrimaryKey(shiguGoodsSingleSku));
        }
        //执行无效化
        if (dels.size() > 0) {
            ShiguGoodsSingleSkuExample shiguGoodsSingleSkuExample = new ShiguGoodsSingleSkuExample();
            shiguGoodsSingleSkuExample.createCriteria().andSkuIdIn(dels);
            shiguGoodsSingleSkuExample.setWebSite(webSite);
            ShiguGoodsSingleSku s = new ShiguGoodsSingleSku();
            s.setStatus(0);
            shiguGoodsSingleSkuMapper.updateByExampleSelective(s, shiguGoodsSingleSkuExample);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateByPrimaryKeySelective(ShiguGoodsSingleSku sku) {
        shiguGoodsSingleSkuMapper.updateByPrimaryKeySelective(sku);
    }
}
