package com.shigu.main4.item.dao;

import com.opentae.data.mall.beans.ShiguGoodsSingleSku;
import com.opentae.data.mall.beans.TaobaoItemProp;
import com.opentae.data.mall.beans.TaobaoPropValue;
import com.opentae.data.mall.examples.ShiguGoodsSingleSkuExample;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.ShiguGoodsSingleSkuMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.TaobaoItemPropMapper;
import com.opentae.data.mall.interfaces.TaobaoPropValueMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.bo.TaobaoPropValueBO;
import com.shigu.main4.item.services.utils.SkuCheckUtil;
import com.shigu.main4.item.vo.CatColorSizeVO;
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

    /**
     *
     * @param webSite 站点
     * @param inserts 新增的集合
     * @param updates 修改的集合
     * @param dels 无效化的集合
     * @param ipids 涉及的类目属性ID
     * @param cid 类目ID
     */
    @Transactional(rollbackFor = Exception.class)
    public void pushSkus(String webSite,List<ShiguGoodsSingleSku> inserts,List<ShiguGoodsSingleSku> updates,List<Long> dels,List<Long> ipids,Long cid){
        //执行写入
        if (inserts.size() > 0) {
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
                TaobaoPropValueExample taobaoPropValueExample = new TaobaoPropValueExample();
                taobaoPropValueExample.createCriteria().andCidEqualTo(cid).andVidIn(ivids).andPidIn(ipids);
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
        //执行修改
        if (updates.size() > 0) {
            updates.forEach(shiguGoodsSingleSku -> shiguGoodsSingleSkuMapper.updateByPrimaryKeySelective(shiguGoodsSingleSku));
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

    public CatColorSizeVO selCatColorSize(Long cid){
        CatColorSizeVO vo=new CatColorSizeVO();
        selProps(cid).stream().filter(taobaoItemProp -> taobaoItemProp.getIsColorProp() == 1
                || SkuCheckUtil.isSizeProp(taobaoItemProp.getPid().toString(), taobaoItemProp.getName()))
                .forEach(taobaoItemProp -> {
                    if(taobaoItemProp.getIsColorProp()==1){
                        vo.setColorPid(taobaoItemProp.getPid());
                    }else{
                        vo.setSizePid(taobaoItemProp.getPid());
                    }
                });
        return vo;
    }

    public List<TaobaoItemProp> selProps(Long cid){
        TaobaoItemProp itemProp = new TaobaoItemProp();
        itemProp.setCid(cid);
        itemProp.setIsSaleProp(1);
        return taobaoItemPropMapper.select(itemProp);
    }


    public List<TaobaoPropValueBO> taobaoPropValues(Long cid){
        CatColorSizeVO catColorSizeVO = selCatColorSize(cid);
        List<Long> pids = new ArrayList<>();
        pids.add(-1L);
        pids.add(catColorSizeVO.getColorPid());
        pids.add(catColorSizeVO.getSizePid());
        TaobaoPropValueExample taobaoPropValueExample = new TaobaoPropValueExample();
        taobaoPropValueExample.createCriteria().andCidEqualTo(cid).andPidIn(pids);
        return taobaoPropValueMapper.selectByExample(taobaoPropValueExample).stream().map(taobaoPropValue -> {
            TaobaoPropValueBO bo=BeanMapper.map(taobaoPropValue,TaobaoPropValueBO.class);
            if(bo.getPid().equals(catColorSizeVO.getColorPid())){
                bo.setIsColor(true);
            }else{
                bo.setIsColor(false);
            }
            return bo;
        }).collect(Collectors.toList());
    }
}
