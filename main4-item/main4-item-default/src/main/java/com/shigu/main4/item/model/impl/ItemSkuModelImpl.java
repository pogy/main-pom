package com.shigu.main4.item.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguGoodsSingleSkuExample;
import com.opentae.data.mall.examples.TaobaoPropValueExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.bo.SingleSkuBO;
import com.shigu.main4.item.dao.SingleSkuDao;
import com.shigu.main4.item.exceptions.ItemNotFundException;
import com.shigu.main4.item.model.ItemSkuModel;
import com.shigu.main4.item.services.utils.SkuCheckUtil;
import com.shigu.main4.item.vo.SinglePropVO;
import com.shigu.main4.item.vo.SingleSkuVO;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@Scope("prototype")
public class ItemSkuModelImpl implements ItemSkuModel {
    private Long goodsId;
    private String webSite;
    private List<SingleSkuVO> singleSkuVOS;

    @Autowired
    SingleSkuDao singleSkuDao;

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;
    @Autowired
    TaobaoItemPropMapper taobaoItemPropMapper;
    @Autowired
    TaobaoPropValueMapper taobaoPropValueMapper;
    @Autowired
    ShiguGoodsSingleSkuMapper shiguGoodsSingleSkuMapper;

    public ItemSkuModelImpl(Long goodsId) throws ItemNotFundException {
        if (goodsId == null) {
            throw new ItemNotFundException("商8品不存在");
        }
        this.goodsId = goodsId;
    }

    @PostConstruct
    public void load() throws ItemNotFundException {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (shiguGoodsIdGenerator == null) {
            throw new ItemNotFundException("商品不存在");
        }
        this.webSite = shiguGoodsIdGenerator.getWebSite();
        init();
    }

    @Override
    public List<SingleSkuVO> pull() {
        return singleSkuVOS;
    }

    @Override
    public void push(List<SingleSkuBO> skus) {
        if (singleSkuVOS == null) {
            singleSkuVOS = new ArrayList<>();
        }
        Map<String, SingleSkuVO> thMap = singleSkuVOS.stream()
                .collect(Collectors.toMap(sku -> sku.getColorVid() + "," + sku.getSizeVid(), sku -> sku));
        Map<String, SingleSkuBO> ahMap = skus.stream()
                .collect(Collectors.toMap(sku -> sku.getColorVid() + "," + sku.getSizeVid(), sku -> sku));
        List<ShiguGoodsSingleSku> inserts = new ArrayList<>();
        List<ShiguGoodsSingleSku> updates = new ArrayList<>();
        List<Long> dels = new ArrayList<>();
        ahMap.forEach((s, singleSkuBO) -> {
            SingleSkuVO singleSkuVO = thMap.get(s);
            if (singleSkuVO == null) {
                //参数中存在的,数据库中不存在的,写入新增集合
                ShiguGoodsSingleSku sku = new ShiguGoodsSingleSku();
                sku.setGoodsId(goodsId);
                sku.setColorVid(singleSkuBO.getColorVid());
                sku.setSizeVid(singleSkuBO.getSizeVid());
                sku.setColorPropertyAlias(singleSkuBO.getColorAlias());
                sku.setSizePropertyAlias(singleSkuBO.getSizeAlias());
                sku.setStockNum(singleSkuBO.getStockNum());
                sku.setStatus(1);
                if (singleSkuBO.getStockNum() == 0) {
                    sku.setStatus(0);
                }
                sku.setWebSite(webSite);
                inserts.add(sku);
            } else {
                if (singleSkuBO.getStockNum() == 0) {
                    dels.add(singleSkuVO.getSkuId());
                }
                //参数中存在的,数据库中也存在的
                ShiguGoodsSingleSku sku = BeanMapper.map(singleSkuVO, ShiguGoodsSingleSku.class);
                //根据条件修改别名
                if (sku.getColorPropertyAlias() != null) {
                    if (singleSkuBO.getColorAlias() == null) {
                        sku.setColorPropertyAlias(null);
                    } else {
                        if (singleSkuBO.getColorAlias().equals(sku.getColorName())) {
                            sku.setColorPropertyAlias(null);
                        } else if (!singleSkuBO.getColorAlias().equals(sku.getColorPropertyAlias())) {
                            sku.setColorPropertyAlias(singleSkuBO.getColorAlias());
                        }
                    }
                }
                if (sku.getSizePropertyAlias() != null) {
                    if (singleSkuBO.getSizeAlias() == null) {
                        sku.setSizePropertyAlias(null);
                    } else {
                        if (singleSkuBO.getSizeAlias().equals(sku.getSizeName())) {
                            sku.setSizePropertyAlias(null);
                        } else if (!singleSkuBO.getSizeAlias().equals(sku.getSizePropertyAlias())) {
                            sku.setSizePropertyAlias(singleSkuBO.getSizeAlias());
                        }
                    }
                }
                sku.setStatus(1);
                sku.setStockNum(singleSkuBO.getStockNum());
                //别名修改后,和数据库不同了,写入待修改集合
                if (!Objects.equals(sku.getColorPropertyAlias(), singleSkuVO.getColorPropertyAlias()) ||
                        !Objects.equals(sku.getSizePropertyAlias(), singleSkuVO.getSizePropertyAlias()) ||
                        !Objects.equals(sku.getStatus(), singleSkuVO.getStatus()) ||
                        !Objects.equals(sku.getStockNum(), singleSkuVO.getStockNum())) {
                    sku.setWebSite(webSite);
                    updates.add(sku);
                }
                //删除数据库中已存在的key
                thMap.remove(s);
            }
        });
        //读取剩余的skuId,这些是在参数中不存在的,但数据库中存在的,这些sku需要进行无效化操作
        dels.addAll(thMap.entrySet().stream().map(Map.Entry::getValue).map(SingleSkuVO::getSkuId)
                .collect(Collectors.toList()));
        singleSkuDao.pushSkus(webSite, goodsId, inserts, updates, dels);
        reload();
    }

    @Override
    public void updateStockNum(Long skuId, Integer stockNum) {
        ShiguGoodsSingleSku sku = new ShiguGoodsSingleSku();
        sku.setStockNum(stockNum);
        sku.setSkuId(skuId);
        if (stockNum <= 0) {
            sku.setStatus(0);
        } else {
            sku.setStatus(1);
        }
        singleSkuDao.updateByPrimaryKeySelective(sku);
    }

    private void reload() {
        ShiguGoodsSingleSku shiguGoodsSingleSku = new ShiguGoodsSingleSku();
        shiguGoodsSingleSku.setGoodsId(goodsId);
        shiguGoodsSingleSku.setWebSite(webSite);
        List<ShiguGoodsSingleSku> skus = shiguGoodsSingleSkuMapper.select(shiguGoodsSingleSku);
        if (skus.size() != 0) {
            singleSkuVOS = new ArrayList<>(skus.size());
            skus.forEach(o -> singleSkuVOS.add(BeanMapper.map(o, SingleSkuVO.class)));
        }
    }

    private void init() throws ItemNotFundException {
        reload();
        if (singleSkuVOS != null) {
            return;
        }
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setWebSite(webSite);
        tiny.setGoodsId(goodsId);
        tiny = shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny, FieldUtil.codeFields("goods_id,cid"));
        ShiguGoodsExtends ext = new ShiguGoodsExtends();
        ext.setWebSite(webSite);
        ext.setGoodsId(goodsId);
        ext = shiguGoodsExtendsMapper.selectFieldsByPrimaryKey(ext, FieldUtil
                .codeFields("goods_id,props_name,property_alias"));
        if(ext==null){
            throw new ItemNotFundException("商品不存在");
        }
        List<SingleSkuBO> singleSkuBOS = dealProps(tiny.getCid(), ext.getPropsName(), ext.getPropertyAlias());
        push(singleSkuBOS);
    }

    private boolean isLong(String str){
        try {
            new Long(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    private List<SingleSkuBO> dealProps(Long cid, String propName, String propertyAlias) {
        propertyAlias = propertyAlias == null ? "" : StringEscapeUtils.unescapeHtml(propertyAlias);
        String[] tas=propertyAlias.split(";");
        StringBuilder propertyAliasBuilder = new StringBuilder();
        for(String a:tas){
            String[] as=a.split(":");
            //如果单段字符窜分割后,长度为2且两个都是Long型,可以认为是"20549:28389:"这类数据,别名的值为空字符串,该类数据抛弃
            if(as.length==2&&isLong(as[0])&&isLong(as[1])){
                continue;
            }
            //如果长度为3,且前两个都是Long型,认为是标准的别名值
            if(as.length==3&&isLong(as[0])&&isLong(as[1])){
                propertyAliasBuilder.append(a).append(";");
            }else{
                //剩余的则认为是别名中存在";"导致形成错误的分割,重新进行组合,将分割符转为"&"
                //propertyAlias的长度为0,意味着一开始就是错误的,抛弃
                if(propertyAliasBuilder.length()==0){
                    continue;
                }
                //剔除上一个循环添加上的最后一个";"
                propertyAliasBuilder = new StringBuilder(
                        propertyAliasBuilder.substring(0, propertyAliasBuilder.length() - 1) + "&" + a + ";");
            }
        }
        propertyAlias = propertyAliasBuilder.toString();
        propName=propName==null?"":StringEscapeUtils.unescapeHtml(propName);
        String[] tps=propName.split(";");
        StringBuilder propNameBuilder = new StringBuilder();
        for(String p:tps){
            String[] ps=p.split(":");
            //如果长度为4,且前两个都是Long型,认为是标准的别名值
            if(ps.length==4&&isLong(ps[0])&&isLong(ps[1])){
                propNameBuilder.append(p).append(";");
            }else{
                //剩余的则认为是别名中存在";"导致形成错误的分割,重新进行组合,将分割符转为"&"
                //propName,意味着一开始就是错误的,抛弃
                if(propNameBuilder.length()==0){
                    continue;
                }
                //剔除上一个循环添加上的最后一个";"
                propNameBuilder = new StringBuilder(
                        propNameBuilder.substring(0, propNameBuilder.length() - 1) + "&" + p + ";");
            }
        }
        propName = propNameBuilder.toString();

        TaobaoItemProp itemProp = new TaobaoItemProp();
        itemProp.setCid(cid);
        itemProp.setIsSaleProp(1);
        List<TaobaoItemProp> itemProps = taobaoItemPropMapper.select(itemProp);
        List<Long> pids = new ArrayList<>();
        pids.add(-1L);
        Map<Long, Integer> isColorMap = new HashMap<>();
        itemProps.stream().filter(taobaoItemProp -> taobaoItemProp.getIsColorProp() == 1
                || SkuCheckUtil.isSizeProp(taobaoItemProp.getPid().toString(), taobaoItemProp.getName()))
                .forEach(taobaoItemProp -> {
                    pids.add(taobaoItemProp.getPid());
                    isColorMap.put(taobaoItemProp.getPid(), taobaoItemProp.getIsColorProp());
                });

        TaobaoPropValueExample taobaoPropValueExample = new TaobaoPropValueExample();
        taobaoPropValueExample.createCriteria().andCidEqualTo(cid).andPidIn(pids);
        List<TaobaoPropValue> propValues = taobaoPropValueMapper.selectByExample(taobaoPropValueExample);
        Map<Long, TaobaoPropValue> colors = new HashMap<>();
        Map<Long, TaobaoPropValue> sizes = new HashMap<>();
        propValues.forEach(taobaoPropValue -> {
            if (isColorMap.get(taobaoPropValue.getPid()) == 1) {
                colors.put(taobaoPropValue.getVid(), taobaoPropValue);
            } else {
                sizes.put(taobaoPropValue.getVid(), taobaoPropValue);
            }
        });

        List<String> propNames = Arrays.asList(propName.split(";"));
        Map<String, String> propertyAliass = new HashMap<>();
        Arrays.stream(propertyAlias.split(";")).filter(s -> StringUtils.isNotBlank(s) && !s.trim().endsWith(":"))
                .forEach(s -> {
                    String[] ps = s.split(":");
                    propertyAliass.put(ps[0] + ":" + ps[1], ps[2]);
                });

        List<SinglePropVO> vos = propNames.stream().filter(StringUtils::isNotBlank).map(s -> {
            String[] ps = s.split(":");
            if(ps.length!=4){
                return null;
            }
            Long tmpPid = new Long(ps[0]);
            if (!pids.contains(tmpPid)) {
                return null;
            }
            SinglePropVO vo = new SinglePropVO();
            vo.setPid(tmpPid);
            vo.setVid(new Long(ps[1]));
            vo.setPname(ps[2]);
            String alias = propertyAliass.get(vo.getPid() + ":" + vo.getVid());
            if (alias != null) {
                if (isColorMap.get(vo.getPid()) == 1) {
                    if (dealValueByName(colors, alias, vo)) {
                        return vo;
                    }
                    vo.setAliasName(alias);
                } else {
                    if (dealValueByName(sizes, alias, vo)) {
                        return vo;
                    }
                    vo.setAliasName(alias);
                }
            }
            if (isColorMap.get(tmpPid) == 1) {
                if (colors.keySet().contains(vo.getVid())) {
                    vo.setVname(ps[3]);
                } else {
                    if (dealValueByName(colors, ps[3], vo)) {
                        return vo;
                    }
                    vo.setInputName(ps[3]);
                }
                colors.remove(vo.getVid());
            } else {
                if (sizes.keySet().contains(vo.getVid())) {
                    vo.setVname(ps[3]);
                } else {
                    if (dealValueByName(sizes, ps[3], vo)) {
                        return vo;
                    }
                    vo.setInputName(ps[3]);
                }
                sizes.remove(vo.getVid());
            }

            return vo;
        }).filter(Objects::nonNull).collect(Collectors.toList());

        //取出颜色
        List<SinglePropVO> colorVOS = vos.stream().filter(singlePropVO -> isColorMap.get(singlePropVO.getPid()) == 1)
                .collect(Collectors.toList());
        //如果不存在颜色,添加一个"图片色"
        if (colorVOS.size() == 0 && isColorMap.size() > 0 && colors.size() > 0) {
            try {
                SinglePropVO vo = new SinglePropVO();
                vo.setPid(isColorMap.entrySet().stream().filter(longIntegerEntry -> longIntegerEntry.getValue() == 1)
                        .findFirst().get().getKey());
                vo.setInputName("图片色");
                colorVOS.add(vo);
            } catch (Exception e) {
            }
        }
        //取出尺码
        List<SinglePropVO> sizeVOS = vos.stream().filter(singlePropVO -> isColorMap.get(singlePropVO.getPid()) != 1)
                .collect(Collectors.toList());
        //如果没有尺码,添加一个"均码"
        if (sizeVOS.size() == 0 && isColorMap.size() > 0 && sizes.size() > 0) {
            try {
                SinglePropVO vo = new SinglePropVO();
                vo.setPid(isColorMap.entrySet().stream().filter(longIntegerEntry -> longIntegerEntry.getValue() != 1)
                        .findFirst().get().getKey());
                vo.setInputName("均码");
                sizeVOS.add(vo);
            } catch (Exception e) {
            }
        }
        //获取剩余的颜色
        Map<Long, TaobaoPropValue> surplusColors = new HashMap<>(colors);
        colorVOS.forEach(singlePropVO -> {
            if (singlePropVO.getInputName() == null) {
                surplusColors.remove(singlePropVO.getVid());
            }
        });
        //获取剩余尺码
        Map<Long, TaobaoPropValue> surplusSizes = new HashMap<>(sizes);
        sizeVOS.forEach(singlePropVO -> {
            if (singlePropVO.getInputName() == null) {
                surplusSizes.remove(singlePropVO.getVid());
            }
        });

        //转化自定义颜色
        colorVOS.forEach(singlePropVO -> {
            if (singlePropVO.getInputName() != null) {
                if (surplusColors.size() > 0) {
                    inputDeal(singlePropVO, surplusColors);
                }
            }
        });
        //转化自定义尺码
        sizeVOS.forEach(singlePropVO -> {
            if (singlePropVO.getInputName() != null) {
                if (surplusSizes.size() > 0) {
                    inputDeal(singlePropVO, surplusSizes);
                }
            }
        });
        //转化为写入数据库对象
        List<SingleSkuBO> skuVOS = new ArrayList<>();
        if (colorVOS.size() > 0) {
            colorVOS.forEach(c -> {
                if (sizeVOS.size() > 0) {
                    sizeVOS.forEach(s -> {
                        SingleSkuBO v = new SingleSkuBO();
                        v.setColorVid(c.getVid());
                        v.setColorAlias(c.getAliasName());
                        v.setSizeVid(s.getVid());
                        v.setSizeAlias(s.getAliasName());
                        v.setStockNum(999);
                        skuVOS.add(v);
                    });
                } else {
                    SingleSkuBO v = new SingleSkuBO();
                    v.setColorVid(c.getVid());
                    v.setColorAlias(c.getAliasName());
                    v.setSizeVid(0L);
                    v.setSizeAlias("均码");
                    v.setStockNum(999);
                    skuVOS.add(v);
                }

            });
        } else {
            if (sizeVOS.size() > 0) {
                sizeVOS.forEach(s -> {
                    SingleSkuBO v = new SingleSkuBO();
                    v.setColorVid(0L);
                    v.setColorAlias("图片色");
                    v.setSizeVid(s.getVid());
                    v.setSizeAlias(s.getAliasName());
                    v.setStockNum(999);
                    skuVOS.add(v);
                });
            } else {
                SingleSkuBO v = new SingleSkuBO();
                v.setColorVid(0L);
                v.setColorAlias("图片色");
                v.setSizeVid(0L);
                v.setSizeAlias("均码");
                v.setStockNum(999);
                skuVOS.add(v);
            }

        }

        return skuVOS;
    }

    private void inputDeal(SinglePropVO singlePropVO, Map<Long, TaobaoPropValue> surplus) {
        List<TaobaoPropValue> taobaoPropValues = surplus.values().stream()
                .filter(taobaoPropValue1 -> taobaoPropValue1.getName().equals(singlePropVO.getInputName()))
                .collect(Collectors.toList());
        TaobaoPropValue taobaoPropValue;
        if (taobaoPropValues.size() == 0) {
            taobaoPropValue = surplus.values().stream().findFirst().get();
        } else {
            taobaoPropValue = taobaoPropValues.get(0);
        }
        singlePropVO.setAliasName(singlePropVO.getInputName());
        singlePropVO.setVid(taobaoPropValue.getVid());
        singlePropVO.setVname(taobaoPropValue.getName());
        singlePropVO.setPid(taobaoPropValue.getPid());
        singlePropVO.setPname(taobaoPropValue.getPropName());
        singlePropVO.setInputName(null);
        surplus.remove(taobaoPropValue.getVid());
    }

    /**
     * 尝试用vname匹配属性值,如果匹配上,这直接使用改属性值替换原来的别名或自定义名
     *
     * @param map
     * @param name
     * @param vo
     * @return
     */
    private boolean dealValueByName(Map<Long, TaobaoPropValue> map, String name, SinglePropVO vo) {
        if (map.values().stream().map(TaobaoPropValue::getName).collect(Collectors.toSet()).contains(name)) {
            TaobaoPropValue tv = map.values().stream().filter(taobaoPropValue -> taobaoPropValue.getName().equals(name))
                    .findFirst().get();
            vo.setVid(tv.getVid());
            vo.setVname(tv.getName());
            map.remove(tv.getVid());
            return true;
        }
        return false;
    }

    //----------------------get/set------------------------//
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
