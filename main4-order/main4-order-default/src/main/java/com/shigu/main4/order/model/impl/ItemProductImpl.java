package com.shigu.main4.order.model.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.order.model.ItemProduct;
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

    private Long pid;

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

    public ItemProductImpl(Long goodsId,String color,String size) {
        this.goodsId = goodsId;
        this.color = color;
        this.size = size;
    }

    @PostConstruct
    private void initProduct() {
        com.opentae.data.mall.beans.ItemProduct itemProduct = selByGoodsId(goodsId);
        if (itemProduct == null) {
            itemProduct = createProduct(goodsId, color, size);
        }
        pid = itemProduct.getPid();
    }

    private com.opentae.data.mall.beans.ItemProduct selByGoodsId(Long goodsId) {
        com.opentae.data.mall.beans.ItemProduct itemProduct = new com.opentae.data.mall.beans.ItemProduct();
        itemProduct.setGoodsId(goodsId);
        return itemProductMapper.selectOne(itemProduct);
    }

    private com.opentae.data.mall.beans.ItemProduct createProduct(Long goodsId, String color, String size) {
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
        com.opentae.data.mall.beans.ItemProduct product = BeanMapper.map(goodsTiny, com.opentae.data.mall.beans.ItemProduct.class);
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

        ItemProductSku sku = new ItemProductSku();
        sku.setPid(product.getPid());
        sku.setColor(color);
        sku.setSize(size);
        itemProductSkuMapper.insertSelective(sku);
        return product;
    }

    @Override
    public List<ItemSkuVO> selSkus() {
        return null;
    }

    @Override
    public void modifyWeight(Long meter) {

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
        return null;
    }

    public Long getPid() {
        return pid;
    }
}
