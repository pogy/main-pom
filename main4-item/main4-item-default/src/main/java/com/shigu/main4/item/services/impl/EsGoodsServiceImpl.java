package com.shigu.main4.item.services.impl;

import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguGoodsUnlicenseExample;
import com.opentae.data.mall.examples.ShiguShopLicenseExample;
import com.opentae.data.mall.interfaces.ShiguGoodsStyleMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsUnlicenseMapper;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.opentae.data.mall.interfaces.ShiguTaobaocatMapper;
import com.shigu.main4.common.util.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wxc on 2017/3/3.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service
public class EsGoodsServiceImpl {

    @Autowired
    private ShiguTaobaocatMapper shiguTaobaocatMapper;

    @Autowired
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    @Autowired
    private ShiguGoodsUnlicenseMapper shiguGoodsUnlicenseMapper;

    @Autowired
    private ShiguGoodsStyleMapper shiguGoodsStyleMapper;

    private static final Map<String, String> licenseMap = new HashMap<>();

    static {
        licenseMap.put("1", "退现金");
        licenseMap.put("2", "包换款");
    }

    /**
     * 由数据库商品对象创建ES商品对象
     * @param t 数据库商品
     * @return ES商品对象
     */
    public <T> ESGoods createEsGoods(T t) {
        ESGoods esGoods = BeanMapper.map(t, ESGoods.class);
        Long cid = null;
        Long is_off = 0L;//is_off 1代表已下架，0代表正常
        if (t instanceof ShiguGoodsSoldout) {
            is_off = 1L;
            cid = ((ShiguGoodsSoldout) t).getCid();
        } else if (t instanceof ShiguGoodsTiny) {
            cid = ((ShiguGoodsTiny) t).getCid();
        }
        esGoods.setIs_off(is_off);
        ShiguTaobaocat taobaocat;
        if (cid != null && (taobaocat = shiguTaobaocatMapper.selectByPrimaryKey(cid)) != null) {
            esGoods.setCname(taobaocat.getCname());
            esGoods.setParent_cid(taobaocat.getParentCid());
            esGoods.setParent_cname(taobaocat.getParentCname());
        }
        Long shopId = esGoods.getStoreId();
        Long goodsId = esGoods.getGoodsId();
        if (goodsId != null) {
            ShiguGoodsStyle style = new ShiguGoodsStyle();
            style.setGoodsId(goodsId);
            ShiguGoodsStyle shiguGoodsStyle = shiguGoodsStyleMapper.selectOne(style);
            if (shiguGoodsStyle != null) {
                esGoods.setSids(shiguGoodsStyle.getSids());
            }
        }
        if (shopId != null && goodsId != null) {
            //查询店铺权益
            ShiguShopLicenseExample licenseExample = new ShiguShopLicenseExample();
            licenseExample.createCriteria().andShopIdEqualTo(shopId).andLicenseFailureEqualTo(0).andLicenseTypeEqualTo(5);
            List<ShiguShopLicense> shiguShopLicenses = shiguShopLicenseMapper.selectByExample(licenseExample);
            if (!shiguShopLicenses.isEmpty()) {
                ShiguShopLicense shopLicense = shiguShopLicenses.get(0);
                String context = shopLicense.getContext();
                if (context != null) {
                    List<String> list = new ArrayList<>(Arrays.asList(context.split(",")));
                    // 查询商品不支持的权益
                    ShiguGoodsUnlicenseExample goodsUnlicenseExample = new ShiguGoodsUnlicenseExample();
                    goodsUnlicenseExample.createCriteria().andGoodsIdEqualTo(goodsId);
                    List<ShiguGoodsUnlicense> shiguGoodsUnlicenses = shiguGoodsUnlicenseMapper.selectByExample(goodsUnlicenseExample);
                    if (!shiguGoodsUnlicenses.isEmpty()) {
                        ShiguGoodsUnlicense shiguGoodsUnlicense = shiguGoodsUnlicenses.get(0);
                        if (shiguGoodsUnlicense.getUnlicenseContext() != null) {
                            // 以店铺权益取商品不支持的权益的差集
                            list.removeAll(Arrays.asList(shiguGoodsUnlicense.getUnlicenseContext().split(",")));
                        }
                    }
                    List<String> licenseList = new ArrayList<>();
                    for (String s : list) {
                        String license = licenseMap.get(s);
                        if (license != null)
                            licenseList.add(license);
                    }
                    // 将最终权益拼装为‘,’隔开的字符串, 就是esGoods.services
                    esGoods.setServices(StringUtils.join(licenseList, ","));
                }
            }
        }
        return esGoods;
    }
}
