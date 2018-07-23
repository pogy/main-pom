package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemCidWeightExample;
import com.opentae.data.mall.examples.ItemProductSkuExample;
import com.opentae.data.mall.examples.ShiguGoodsSingleSkuExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ItemSkuVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

/**
 * 商品形式的产品实现类
 * Created by zhaohongbo on 17/6/9.
 */
@Repository
@Scope("prototype")
public class ItemProductImpl implements ItemProduct {

    @Autowired
    private ItemProductMapper itemProductMapper;

    @Autowired
    private ItemProductSkuMapper itemProductSkuMapper;

    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ItemCidWeightMapper itemCidWeightMapper;
    @Autowired
    ShiguGoodsSingleSkuMapper shiguGoodsSingleSkuMapper;


    private Long goodsId;
    private String color;
    private String size;


    private Long skuId;
    private Long pid;

    public ItemProductImpl(Long pid, Long skuId) {
        this.pid = pid;
        this.skuId = skuId;
    }

    public ItemProductImpl(Long goodsId,String color, String size) {
        this.goodsId = goodsId;
        this.color = color;
        this.size = size;
    }

    @PostConstruct
    private void initProduct() {
        if (pid != null && skuId != null) {
            ItemProductVO info = info();
            goodsId = info.getGoodsId();
            color = info.getSelectiveSku().getColor();
            size = info.getSelectiveSku().getSize();
            return;
        }
        if(StringUtils.isBlank(color)){
            color="-1";
        }
        if(StringUtils.isBlank(size)){
            size="-1";
        }
        ItemProductInfo productInfo = createProduct(goodsId,color, size);
        pid = productInfo.getPid();
        skuId = productInfo.getSkuId();
    }

    private ItemProductInfo createProduct(Long goodsId,String color, String size) {
        ItemProductInfo productInfo = itemProductMapper.selProduct(goodsId,color, size);
        if (productInfo != null) {
            Long price=selSkuPrice(goodsId,color,size);
            if(price==null){
                price=productInfo.getSuperPrice();
            }
            if(!Objects.equals(price,productInfo.getPrice())){
                ItemProductSku sku = new ItemProductSku();
                sku.setSkuId(productInfo.getSkuId());
                sku.setPrice(price);
                itemProductSkuMapper.updateByPrimaryKeySelective(sku);
                productInfo.setPrice(sku.getPrice());
            }
            return productInfo;
        }
        com.opentae.data.mall.beans.ItemProduct product = new com.opentae.data.mall.beans.ItemProduct();
        product.setGoodsId(goodsId);
        product = itemProductMapper.selectOne(product);
        if (product == null) {
            ShiguGoodsIdGenerator idGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
            if (idGenerator == null) {
                throw new IllegalArgumentException(String.format("goodId[%d] 不存在.", goodsId));
            }
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setWebSite(idGenerator.getWebSite());
            tiny.setGoodsId(idGenerator.getGoodId());
            ShiguGoodsTiny goodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
            if (goodsTiny == null) {
                throw new IllegalStateException("商品不存在.id=" + goodsId);
            }
            product = BeanMapper.map(goodsTiny, com.opentae.data.mall.beans.ItemProduct.class);
            product.setShopId(goodsTiny.getStoreId());
            product.setPrice(goodsTiny.getPiPrice());
            product.setMarketId(goodsTiny.getParentMarketId());
            product.setFloorId(goodsTiny.getMarketId());

            ShiguShop shiguShop = shiguShopMapper.selectFieldsByPrimaryKey(goodsTiny.getStoreId(), FieldUtil.codeFields("shop_id, shop_num"));
            if (shiguShop != null) {
                product.setShopNum(shiguShop.getShopNum());
            }

            ShiguMarket shiguMarket = shiguMarketMapper.selectByPrimaryKey(goodsTiny.getMarketId());
            if (shiguMarket != null) {
                product.setFloor(shiguMarket.getMarketName());
                product.setMarketName(shiguMarket.getParentMarketName());
            }
            itemProductMapper.insertSelective(product);
        }

        ItemProductSku sku = new ItemProductSku();
        sku.setPid(product.getPid());
        sku.setColor(color);
        sku.setSize(size);
        sku.setPrice(selSkuPrice(goodsId,color,size));
        itemProductSkuMapper.insertSelective(sku);

        ItemProductInfo info = new ItemProductInfo();
        info.setPid(product.getPid());
        info.setSkuId(sku.getSkuId());
        return info;
    }

    private Long selSkuPrice(Long goodsId,String color, String size){
        if(goodsId==null){
            return null;
        }
        ShiguGoodsIdGenerator idGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if(idGenerator==null){
            return null;
        }
        ShiguGoodsSingleSkuExample shiguGoodsSingleSkuExample=new ShiguGoodsSingleSkuExample();
        shiguGoodsSingleSkuExample.setWebSite(idGenerator.getWebSite());
        shiguGoodsSingleSkuExample.createCriteria().andGoodsIdEqualTo(goodsId);
        List<ShiguGoodsSingleSku> select = shiguGoodsSingleSkuMapper.selectByExample(shiguGoodsSingleSkuExample);
        for(ShiguGoodsSingleSku s:select){
            if((color.equals(s.getColorName())||color.equals(s.getColorPropertyAlias())||color.equals(s.getColorInputStr()))
                    &&(size.equals(s.getSizePropertyAlias())||size.equals(s.getSizeName())||size.equals(s.getSizeInputStr()))){
                if(StringUtils.isBlank(s.getPriceString())){
                    ShiguGoodsTiny tiny=new ShiguGoodsTiny();
                    tiny.setGoodsId(goodsId);
                    tiny.setWebSite(idGenerator.getWebSite());
                    tiny=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny,FieldUtil.codeFields("goods_id,pi_price_string"));
                    if(tiny==null||StringUtils.isBlank(tiny.getPiPriceString())){
                        return null;
                    }
                    return MoneyUtil.StringToLong(tiny.getPiPriceString());
                }
                return MoneyUtil.StringToLong(s.getPriceString());
            }
        }
        return null;
    }

    @Override
    public ItemProductVO info() {
        ItemProductVO productVO = BeanMapper.map(itemProductMapper.selectByPrimaryKey(pid), ItemProductVO.class);
        productVO.setSelectiveSku(selSelectiveSku());
        Long price=productVO.getSelectiveSku().getPrice();
        if(price!=null){
            productVO.setPrice(price);
        }
        return productVO;
    }

    @Override
    public ItemSkuVO selSelectiveSku() {
        ItemSkuVO productInfo = BeanMapper.map(itemProductSkuMapper.selectByPrimaryKey(skuId), ItemSkuVO.class);
        callPrice(productInfo);
        return productInfo;
    }

    @Override
    public List<ItemSkuVO> selSkus() {
        ItemProductSkuExample skuExample = new ItemProductSkuExample();
        skuExample.createCriteria().andPidEqualTo(pid);
        List<ItemSkuVO> itemSkuVOS = BeanMapper
                .mapList(itemProductSkuMapper.selectByExample(skuExample), ItemSkuVO.class);
        itemSkuVOS.forEach(itemSkuVO -> callPrice(itemSkuVO));
        return itemSkuVOS;
    }

    private void callPrice(ItemSkuVO productInfo){
        if (productInfo != null) {
            Long price=selSkuPrice(goodsId,color,size);
            if(price==null){
                price=productInfo.getPrice();
            }
            if(!Objects.equals(price,productInfo.getPrice())){
                ItemProductSku sku = new ItemProductSku();
                sku.setSkuId(productInfo.getSkuId());
                sku.setPrice(price);
                itemProductSkuMapper.updateByPrimaryKeySelective(sku);
                productInfo.setPrice(sku.getPrice());
            }
        }
    }



    @Override
    public void modifyWeight(Long meter) {
        com.opentae.data.mall.beans.ItemProduct product = new com.opentae.data.mall.beans.ItemProduct();
        product.setPid(pid);
        product.setWeight(meter);
        itemProductMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public void modifyPrice(Long price) {
//        com.opentae.data.mall.beans.ItemProduct product = new com.opentae.data.mall.beans.ItemProduct();
//        product.setPrice(price);
//        product.setPid(pid);
//        itemProductMapper.updateByPrimaryKeySelective(product);
        ItemProductSku itemProductSku=new ItemProductSku();
        itemProductSku.setPrice(price);
        itemProductSku.setSkuId(skuId);
        itemProductSkuMapper.updateByPrimaryKeySelective(itemProductSku);

    }

    /**
     * 修改sku信息
     *
     * @param color 颜色
     * @param size  尺码
     */
    @Override
    public Long modSelectiveSku(String color, String size) {
        this.color = color;
        this.size = size;
        return this.skuId = createProduct(goodsId,color, size).getSkuId();
    }

    /**
     * 产品重量查询
     *
     * @return
     */
    @Override
    public Long selWeight() {
        com.opentae.data.mall.beans.ItemProduct itemProduct = itemProductMapper.selectByPrimaryKey(pid);
        if (itemProduct.getWeight() == 0) {
            ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
            shiguGoodsTiny.setWebSite("hz");
            shiguGoodsTiny.setGoodsId(itemProduct.getGoodsId());
            shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
            ItemCidWeightExample itemCidWeightExample = new ItemCidWeightExample();
            if (shiguGoodsTiny != null) {

                itemCidWeightExample.createCriteria().andCidEqualTo(shiguGoodsTiny.getCid());

                List<ItemCidWeight> weights = itemCidWeightMapper.selectByExample(itemCidWeightExample);
                if (weights.size() > 0 ) {
                    return weights.get(0).getWeight();
                } else {
                    return 1000L;
                }
            }
        }

        return itemProduct.getWeight();


    }

    public Long getPid() {
        return pid;
    }

    public Long getSkuId() {
        return skuId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}
