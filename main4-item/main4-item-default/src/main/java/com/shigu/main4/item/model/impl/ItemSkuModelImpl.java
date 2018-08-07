package com.shigu.main4.item.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.item.bo.news.SingleSkuBO;
import com.shigu.main4.item.dao.SingleSkuDao;
import com.shigu.main4.item.exceptions.ItemNotFundException;
import com.shigu.main4.item.model.ItemSkuModel;
import com.shigu.main4.item.news.utils.SingleSkuUtils;
import com.shigu.main4.item.vo.CatColorSizeVO;
import com.shigu.main4.item.vo.news.SingleSkuVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@Scope("prototype")
public class ItemSkuModelImpl implements ItemSkuModel {
    private Long goodsId;
    private String webSite;
    private Long cid;
    private List<SingleSkuVO> singleSkuVOS;
    private CatColorSizeVO catColorSizeVO;
    private Long tinyPiPrice;

    @Autowired
    SingleSkuDao singleSkuDao;

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;
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
            throw new ItemNotFundException("商品不存在");
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
        String field=FieldUtil.codeFields("goods_id,cid,price,pi_price");
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setWebSite(webSite);
        tiny.setGoodsId(goodsId);
        tiny = shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny,field);
        if (tiny == null) {
            ShiguGoodsSoldout shiguGoodsSoldout = new ShiguGoodsSoldout();
            shiguGoodsSoldout.setWebSite(webSite);
            shiguGoodsSoldout.setGoodsId(goodsId);
            shiguGoodsSoldout = shiguGoodsSoldoutMapper.selectFieldsByPrimaryKey(shiguGoodsSoldout,field);
            if (shiguGoodsSoldout == null) {
                throw new ItemNotFundException("商品不存在");
            }
            cid = shiguGoodsSoldout.getCid();
            tinyPiPrice=shiguGoodsSoldout.getPiPrice()==null?shiguGoodsSoldout.getPrice():shiguGoodsSoldout.getPiPrice();
        } else {
            cid = tiny.getCid();
            tinyPiPrice=tiny.getPiPrice()==null?tiny.getPrice():tiny.getPiPrice();
        }
        init();
    }

    @Override
    public List<SingleSkuVO> pull() {
        List<SingleSkuVO> skus=new ArrayList<>(singleSkuVOS);
        skus.removeIf(singleSkuVO -> singleSkuVO.getStatus()==0);
        if(skus.size()==0){
            SingleSkuVO vo=new SingleSkuVO();
            vo.setStatus(1);
            vo.setStockNum(999);
            vo.setThisColor("图片色");
            vo.setThisSize("均码");
            vo.setPriceString(MoneyUtil.dealPrice(tinyPiPrice));
            skus.add(vo);
        }
        return skus;
    }
    @Override
    public List<SingleSkuVO> pullAll(){
        return singleSkuVOS;
    }

    @Override
    public void push(List<SingleSkuBO> skus) {
        if (singleSkuVOS == null) {
            singleSkuVOS = new ArrayList<>();
        }
        if(goodsId.equals(30312792L)){
            System.out.println(JSONArray.fromObject(skus));
        }
        Map<String, SingleSkuVO> thMap = singleSkuVOS.stream().filter(singleSkuVO -> !(singleSkuVO.getColorVid()==null&&singleSkuVO.getSizeVid()==null))
                .collect(Collectors.toMap(sku -> sku.getColorVid() + "," + sku.getSizeVid(), sku -> sku));
        Map<String, SingleSkuBO> ahMap = skus.stream().filter(singleSkuVO -> !(singleSkuVO.getColorVid()==null&&singleSkuVO.getSizeVid()==null))
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
                sku.setColorPid(selColorSizeMap().getColorPid());
                sku.setColorVid(singleSkuBO.getColorVid());
                sku.setSizePid(selColorSizeMap().getSizePid());
                sku.setSizeVid(singleSkuBO.getSizeVid());
                sku.setColorName(singleSkuBO.getColorVname());
                sku.setSizeName(singleSkuBO.getSizeVname());
                sku.setColorPropertyAlias(singleSkuBO.getColorAlias());
                sku.setSizePropertyAlias(singleSkuBO.getSizeAlias());
                sku.setColorInputStr(singleSkuBO.getColorInput());
                sku.setSizeInputStr(singleSkuBO.getSizeInput());
                sku.setStockNum(singleSkuBO.getStockNum());
                sku.setPriceString(singleSkuBO.getPriceString());
                sku.setStatus(1);
                sku.setWebSite(webSite);
                inserts.add(sku);
            } else {
                //参数中存在的,数据库中也存在的
                singleSkuVO.setSizePid(selColorSizeMap().getSizePid());
                singleSkuVO.setColorPid(selColorSizeMap().getColorPid());
                ShiguGoodsSingleSku sku = BeanMapper.map(singleSkuVO, ShiguGoodsSingleSku.class);
                if (!Objects.equals(sku.getColorName(),singleSkuBO.getColorVname())) {
                    sku.setColorName(singleSkuBO.getColorVname());
                }
                if (!Objects.equals(sku.getSizeName(),singleSkuBO.getSizeVname())) {
                    sku.setSizeName(singleSkuBO.getSizeVname());
                }
                //根据条件修改别名
                if (!Objects.equals(sku.getColorPropertyAlias(),singleSkuBO.getColorAlias())) {
                    if (singleSkuBO.getColorAlias()== null) {
                        sku.setColorPropertyAlias("");
                    } else {
                        if (singleSkuBO.getColorAlias().equals(sku.getColorName())) {
                            sku.setColorPropertyAlias("");
                        } else if (!singleSkuBO.getColorAlias().equals(sku.getColorPropertyAlias())) {
                            sku.setColorPropertyAlias(singleSkuBO.getColorAlias());
                        }
                    }
                }
                if (!Objects.equals(sku.getSizePropertyAlias(),singleSkuBO.getSizeAlias())) {
                    if (singleSkuBO.getSizeAlias() == null) {
                        sku.setSizePropertyAlias("");
                    } else {
                        if (singleSkuBO.getSizeAlias().equals(sku.getSizeName())) {
                            sku.setSizePropertyAlias("");
                        } else if (!singleSkuBO.getSizeAlias().equals(sku.getSizePropertyAlias())) {
                            sku.setSizePropertyAlias(singleSkuBO.getSizeAlias());
                        }
                    }
                }
                if (!Objects.equals(sku.getColorInputStr(),singleSkuBO.getColorInput())) {
                    if (singleSkuBO.getColorInput() == null) {
                        sku.setColorInputStr("");
                    } else if(!singleSkuBO.getColorInput().equals(sku.getColorInputStr())){
                        sku.setColorInputStr(singleSkuBO.getColorInput());
                    }
                }
                if (!Objects.equals(sku.getSizeInputStr(),singleSkuBO.getSizeInput())) {
                    if (singleSkuBO.getSizeInput() == null) {
                        sku.setSizeInputStr("");
                    } else if (!singleSkuBO.getSizeInput().equals(sku.getSizeInputStr())) {
                        sku.setSizeInputStr(singleSkuBO.getSizeInput());
                    }
                }

                sku.setStatus(1);
                sku.setStockNum(singleSkuBO.getStockNum());
                sku.setPriceString(singleSkuBO.getPriceString());
                //别名修改后,和数据库不同了,写入待修改集合
                if (!Objects.equals(sku.getColorPropertyAlias(), singleSkuVO.getColorPropertyAlias()) ||
                        !Objects.equals(sku.getSizePropertyAlias(), singleSkuVO.getSizePropertyAlias()) ||
                        !Objects.equals(sku.getColorInputStr(), singleSkuVO.getColorInputStr()) ||
                        !Objects.equals(sku.getSizeInputStr(), singleSkuVO.getSizeInputStr()) ||
                        !Objects.equals(sku.getStatus(), singleSkuVO.getStatus()) ||
                        !Objects.equals(sku.getStockNum(), singleSkuVO.getStockNum()) ||
                        !Objects.equals(sku.getColorName(), singleSkuVO.getColorName()) ||
                        !Objects.equals(sku.getSizeName(), singleSkuVO.getSizeName()) ||
                        (sku.getPriceString() != null &&
                                !MoneyUtil.StringToLong(sku.getPriceString()).equals(MoneyUtil.StringToLong(singleSkuVO.getPriceString())))
                        ) {
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
        CatColorSizeVO catColorSizeVO = selColorSizeMap();
        List<Long> pids = new ArrayList<>();
        pids.add(catColorSizeVO.getSizePid());
        pids.add(catColorSizeVO.getColorPid());
        singleSkuDao.pushSkus(webSite, inserts, updates, dels, pids, cid);
        reload(false);
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

    @Override
    public Long tinyPiPrice() {
        return this.tinyPiPrice;
    }

    private CatColorSizeVO selColorSizeMap() {
        if (catColorSizeVO == null) {
            catColorSizeVO = singleSkuDao.selCatColorSize(cid);
        }
        return catColorSizeVO;
    }

    private void reload(boolean isInit) {
        ShiguGoodsSingleSku shiguGoodsSingleSku = new ShiguGoodsSingleSku();
        shiguGoodsSingleSku.setGoodsId(goodsId);
        shiguGoodsSingleSku.setWebSite(webSite);
        List<ShiguGoodsSingleSku> skus = shiguGoodsSingleSkuMapper.select(shiguGoodsSingleSku);
        if (skus.size() != 0) {
            singleSkuVOS = new ArrayList<>(skus.size());
            skus.forEach((ShiguGoodsSingleSku o) -> {
                o.setColorPid(selColorSizeMap().getColorPid());
                o.setSizePid(selColorSizeMap().getSizePid());
                SingleSkuVO vo = BeanMapper.map(o, SingleSkuVO.class);
                vo.setIsDefaultPrice(false);
                if(StringUtils.isBlank(vo.getPriceString())){
                    vo.setPriceString(MoneyUtil.dealPrice(this.tinyPiPrice));
                    vo.setIsDefaultPrice(true);
                }
                vo.setThisColor(StringUtils.isNotBlank(vo.getColorInputStr()) ? vo.getColorInputStr() : (StringUtils
                        .isNotBlank(vo.getColorPropertyAlias()) ? vo.getColorPropertyAlias() : vo.getColorName()));
                vo.setThisSize(StringUtils.isNotBlank(vo.getSizeInputStr()) ? vo.getSizeInputStr() : (StringUtils
                        .isNotBlank(vo.getSizePropertyAlias()) ? vo.getSizePropertyAlias() : vo.getSizeName()));
                if(StringUtils.isBlank(vo.getThisColor())){
                    vo.setThisColor("图片色");
                }
                if(StringUtils.isBlank(vo.getThisSize())){
                    vo.setThisSize("均码");
                }
                singleSkuVOS.add(vo);
            });
        }else{
            if(!isInit){
                singleSkuVOS = new ArrayList<>(skus.size());
                SingleSkuVO vo=new SingleSkuVO();
                vo.setThisColor("图片色");
                vo.setThisSize("均码");
                vo.setPriceString(MoneyUtil.dealPrice(this.tinyPiPrice));
                vo.setStatus(1);
                vo.setStockNum(999);
                singleSkuVOS.add(vo);
            }
        }
    }

    private void init() throws ItemNotFundException {
        reload(true);
        if (singleSkuVOS != null) {
            return;
        }
        ShiguGoodsExtends ext = new ShiguGoodsExtends();
        ext.setWebSite(webSite);
        ext.setGoodsId(goodsId);
        ext = shiguGoodsExtendsMapper.selectFieldsByPrimaryKey(ext, FieldUtil
                .codeFields("goods_id,props_name,property_alias"));
        if (ext == null) {
            throw new ItemNotFundException("商品不存在");
        }
        List<SingleSkuBO> singleSkuBOS = SingleSkuUtils.dealProps(ext.getPropsName(), ext.getPropertyAlias(),singleSkuDao.taobaoPropValues(cid));
        push(singleSkuBOS);
    }



    //----------------------get/set------------------------//
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
