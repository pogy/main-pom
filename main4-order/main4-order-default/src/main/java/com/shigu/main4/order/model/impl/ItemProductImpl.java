package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemProductSkuExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.ItemProduct;
import com.shigu.main4.order.vo.ItemProductVO;
import com.shigu.main4.order.vo.ItemSkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 商品形式的产品实现类
 * Created by zhaohongbo on 17/6/9.
 */
@Repository
@Scope("prototype")
public class ItemProductImpl implements ItemProduct{

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

    private Long goodsId;
    private String color;
    private String size;

    private Long skuId;
    private Long pid;

    public ItemProductImpl(Long pid, Long skuId) {
        this.pid = pid;
        this.skuId = skuId;
    }

    public ItemProductImpl(Long goodsId,String color,String size) {
        this.goodsId = goodsId;
        this.color = color;
        this.size = size;
    }

    @PostConstruct
    private void initProduct() {
        ItemProductInfo productInfo = itemProductMapper.selProduct(goodsId, color, size);
        if (productInfo == null) {
            productInfo = createProduct(goodsId, color, size);
        }
        pid = productInfo.getPid();
        skuId = productInfo.getSkuId();
    }

    private ItemProductInfo createProduct(Long goodsId, String color, String size) {
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
        itemProductSkuMapper.insertSelective(sku);

        ItemProductInfo info = new ItemProductInfo();
        info.setPid(product.getPid());
        info.setSkuId(sku.getSkuId());
        return info;
    }

    @Override
    public ItemProductVO info() {
        ItemProductVO productVO = BeanMapper.map(itemProductMapper.selectByPrimaryKey(pid), ItemProductVO.class);
        productVO.setSelectiveSku(selSelectiveSku());
        return productVO;
    }

    @Override
    public ItemSkuVO selSelectiveSku() {
        return BeanMapper.map(itemProductSkuMapper.selectByPrimaryKey(skuId), ItemSkuVO.class);
    }

    @Override
    public List<ItemSkuVO> selSkus() {
        ItemProductSkuExample skuExample = new ItemProductSkuExample();
        skuExample.createCriteria().andPidEqualTo(pid);
        return BeanMapper.mapList(itemProductSkuMapper.selectByExample(skuExample), ItemSkuVO.class);
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
        com.opentae.data.mall.beans.ItemProduct product = new com.opentae.data.mall.beans.ItemProduct();
        product.setPrice(price);
        product.setPid(pid);
        itemProductMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public Long selWeight() {
        return itemProductMapper.selectByPrimaryKey(pid).getWeight();
    }

    public Long getPid() {
        return pid;
    }

    public Long getSkuId() {
        return skuId;
    }
}
