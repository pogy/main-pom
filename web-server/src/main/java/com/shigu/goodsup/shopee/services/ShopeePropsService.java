package com.shigu.goodsup.shopee.services;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.ShiguShopeeCat;
import com.opentae.data.mall.examples.ShiguShopeeCatExample;
import com.opentae.data.mall.interfaces.ShiguShopeeCatMapper;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.shopee.bo.UptoTbShopee;
import com.shigu.goodsup.shopee.utils.ZHConverter;
import com.shigu.goodsup.shopee.vo.CategoryVO;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.tools.RedisIO;
import com.shigu.tb.finder.exceptions.TbPropException;
import com.shigu.tb.finder.services.TbPropsService;
import com.shigu.tb.finder.vo.*;
import com.shigu.upload.shopee.sdk.ShopeeClient;
import com.shigu.upload.shopee.sdk.domain.ShopeeAttributes;
import com.shigu.upload.shopee.sdk.domain.ShopeeCategories;
import com.shigu.upload.shopee.sdk.domain.upload.ShopeeUploadImage;
import com.shigu.upload.shopee.sdk.domain.upload.ShopeeUploadItemAttribute;
import com.shigu.upload.shopee.sdk.domain.upload.ShopeeUploadItemVariation;
import com.shigu.upload.shopee.sdk.domain.upload.ShopeeUploadLogistic;
import com.shigu.upload.shopee.sdk.request.ShopeeGetAttributesRequest;
import com.shigu.upload.shopee.sdk.request.ShopeeGetCategoriesByCountryRequest;
import com.shigu.upload.shopee.sdk.request.ShopeeGetCategoriesRequest;
import com.shigu.upload.shopee.sdk.request.ShopeeItemAddRequest;
import com.shigu.upload.shopee.sdk.response.ShopeeGetAttributesResponse;
import com.shigu.upload.shopee.sdk.response.ShopeeGetCategoriesResponse;
import com.shigu.upload.shopee.sdk.response.ShopeeItemAddResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShopeePropsService {
    @Autowired
    private TbPropsService tbPropsService;
    @Autowired
    ShiguShopeeCatMapper shiguShopeeCatMapper;
    @Autowired
    ShopeeClient client;
    @Autowired
    RedisIO redisIO;

    private final static String REDIS_SHOPEE_CAT_KEY = "redis_shopee_cat_key_";

    public PropsVO selProps(Long id, Long cid, Long shopId) throws TbPropException {
        PropsVO propsVO = tbPropsService.selHasValueProps(id);
        propsVO.getSkus().forEach(this::tdToHans);

        Map<String, PropertyItemVO> tbPropMap = propsVO.getProperties()
                .stream().filter(propertyItemVO -> propertyItemVO.getType() == PropType.SELECT ||
                        propertyItemVO.getType() == PropType.CHECKBOX)
                .collect(Collectors.toMap(o -> ZHConverter.convert(o.getName(), ZHConverter.TRADITIONAL), o -> o));

        ShopeeGetAttributesRequest req = new ShopeeGetAttributesRequest();
        req.setShopId(shopId);
        req.setCategoryId(cid);
        req.setIsCb(true);
        ShopeeGetAttributesResponse execute = client.execute(req);
        if (!execute.isSuccess()) {
            throw new TbPropException(execute.getErrorDescription());
        }

        propsVO.setHuohao(null);
        propsVO.setPingpai(null);
        List<PropertyItemVO> props = new ArrayList<>();
        execute.getAttributes().forEach(shopeeAttributes -> {
            PropertyItemVO pp = new PropertyItemVO();
            pp.setPid(shopeeAttributes.getAttributeId());
            pp.setMustHave(shopeeAttributes.getIsMandatory());
            pp.setName(shopeeAttributes.getAttributeName());
            pp.setType(PropType.SELECT);
            if ("品牌".equals(shopeeAttributes.getAttributeName())) {
                pp.setValues(shopeeAttributes.getValues().stream().map(shopeeValues -> {
                    PropertyValueVO pv = new PropertyValueVO();
                    pv.setName(shopeeValues.getOriginalValue());
                    pv.setSelected("自有品牌".equals(shopeeValues.getOriginalValue()));
                    return pv;
                }).collect(Collectors.toList()));
                if (pp.getValues().size() == 0) {
                    pp.getValues().add(new PropertyValueVO());
                }
                propsVO.setPingpai(pp);
                return;
            }
            PropertyItemVO tbpp = tbPropMap.get(shopeeAttributes.getAttributeName());
            List<PropertyValueVO> propertyValueVOS = new ArrayList<PropertyValueVO>();
            propertyValueVOS.add(new PropertyValueVO());
            if (tbpp != null) {
                Map<String, PropertyValueVO> tbpvmap = tbpp.getValues().stream()
                        .collect(Collectors
                                .toMap(o -> ZHConverter.convert(o.getName(), ZHConverter.TRADITIONAL), o -> o));
                propertyValueVOS.add(new PropertyValueVO());
                propertyValueVOS.addAll(shopeeAttributes.getValues().stream().map(shopeeValues -> {
                    PropertyValueVO pv = new PropertyValueVO();
                    pv.setName(shopeeValues.getOriginalValue());
                    pv.setSelected(tbpvmap.get(shopeeValues.getOriginalValue()) != null &&
                            tbpvmap.get(shopeeValues.getOriginalValue()).isSelected());
                    return pv;
                }).collect(Collectors.toList()));
            } else {
                propertyValueVOS.addAll(shopeeAttributes.getValues().stream().map(shopeeValues -> {
                    PropertyValueVO pv = new PropertyValueVO();
                    pv.setName(shopeeValues.getOriginalValue());
                    pv.setSelected(false);
                    return pv;
                }).collect(Collectors.toList()));
            }
            pp.setValues(propertyValueVOS);
            props.add(pp);
            return;
        });
        propsVO.setProperties(props);
        propsVO.getSaleProps().forEach(this::toTans);
        toTans(propsVO.getColor());
        return propsVO;
    }

    private void tdToHans(ArrayList<TdVO> tdVOS) {
        tdVOS.forEach(tdVO -> {
            tdVO.setValue(ZHConverter.convert(tdVO.getValue(), ZHConverter.TRADITIONAL));
            if (tdVO.getSkuRankVO() != null && tdVO.getSkuRankVO().size() > 0) {
                tdToHans(tdVO.getSkuRankVO());
            }
        });
    }

    private void toTans(PropertyItemVO propertyItemVO) {
        propertyItemVO.setName(ZHConverter.convert(propertyItemVO.getName(), ZHConverter.TRADITIONAL));
        propertyItemVO.getValues().forEach(propertyValueVO -> {
            propertyValueVO.setName(ZHConverter.convert(propertyValueVO.getName(), ZHConverter.TRADITIONAL));
            propertyValueVO.setVname(ZHConverter.convert(propertyValueVO.getVname(), ZHConverter.TRADITIONAL));
        });
    }

    public String selCatPath(Long cid) {
        List<String> cnames = new ArrayList<>();
        selCname(cid, cnames);
        Collections.reverse(cnames);
        return StringUtils.join(cnames, "->");
    }

    private void selCname(Long cid, List<String> cnames) {
        ShiguShopeeCat shiguShopeeCat = shiguShopeeCatMapper.selectByPrimaryKey(cid);
        if (shiguShopeeCat != null) {
            cnames.add(shiguShopeeCat.getCname());
            if (shiguShopeeCat.getParentCid() != 0L) {
                selCname(shiguShopeeCat.getParentCid(), cnames);
            }
        }
    }

    public List<CategoryVO> selCate(Long cid, Long shopId) {
        if (cid == null) {
            cid = 0L;
        }
        List<ShopeeCategories> list = redisIO
                .getList(REDIS_SHOPEE_CAT_KEY + shopId + "_" + cid, ShopeeCategories.class);
        if (list == null) {
            ShopeeGetCategoriesRequest request = new ShopeeGetCategoriesRequest();
            request.setShopId(shopId);
            ShopeeGetCategoriesResponse result = client.execute(request);
            Map<Long, List<ShopeeCategories>> map = result.getCategories().stream()
                    .collect(Collectors.groupingBy(ShopeeCategories::getParentId));
            map.forEach((key, value) -> redisIO.putTemp(REDIS_SHOPEE_CAT_KEY + shopId + "_" + key, value, 1200));
            list = map.get(cid);
        }
        if(cid==0L){
            List<Long> longs = Arrays.asList(63L, 62L, 1859L, 64L, 1837L, 65L, 2580L);
            list.removeIf(shopeeCategories -> !longs.contains(shopeeCategories.getCategoryId()));
            list.sort(Comparator
                    .comparingInt(shopeeCategories -> longs.lastIndexOf(shopeeCategories.getCategoryId())));
        }
        return list.stream().map(shopeeCategories -> {
            CategoryVO vo = new CategoryVO();
            vo.setCid(shopeeCategories.getCategoryId());
            vo.setText(shopeeCategories.getCategoryName());
            vo.setHasChild(shopeeCategories.getHasChildren());
            return vo;
        }).collect(Collectors.toList());
    }

    public Long itemAdd(UptoTbShopee bo, List<JdUploadSkuBO> sku, String[] picUrl, String[] skuProps, String[] deliver, Long shopId) throws Main4Exception {
        ShopeeItemAddRequest req = new ShopeeItemAddRequest();
        req.setCategoryId(bo.getCid());
        req.setCondition("new".endsWith(bo.getStuffStatus()) ? "NEW" : "USED");
        req.setDescription(ZHConverter.convert(bo.getSellPoint(), ZHConverter.TRADITIONAL));
        req.setName(ZHConverter.convert(bo.getTitle(), ZHConverter.TRADITIONAL));
        req.setPrice(priceStringToDouble(bo.getPrice()));
        req.setWeight(new Double(bo.getWeight()));
        req.setShopId(shopId);

        req.setAttributes(Arrays.stream(skuProps).map(s -> {
            String[] strs = s.split(":");
            if(strs.length!=2){
                return null;
            }
            ShopeeUploadItemAttribute a = new ShopeeUploadItemAttribute();
            a.setAttributesId(new Long(strs[0]));
            a.setValue(strs[1].trim());
            return a;
        }).filter(Objects::nonNull).collect(Collectors.toList()));

        req.setImages(Arrays.stream(picUrl).filter(StringUtils::isNotBlank).map(s -> {
            ShopeeUploadImage i = new ShopeeUploadImage();
            i.setUrl(s);
            return i;
        }).collect(Collectors.toList()));

        req.setLogistics(Arrays.stream(deliver).map(s -> {
            ShopeeUploadLogistic l = new ShopeeUploadLogistic();
            l.setEnabled(true);
            l.setLogisticId(new Long(s));
            return l;
        }).collect(Collectors.toList()));

        final Long[] num = {0L};
        List<ShopeeUploadItemVariation> vs = new ArrayList<>();
        sku.forEach(color -> {
            color.getSizes().forEach(size -> {
                ShopeeUploadItemVariation v = new ShopeeUploadItemVariation();
                v.setName(color.getName() + "_" + size.getName());
                v.setPrice(priceStringToDouble(size.getPrice()));
                v.setStock(size.getNum().longValue());
                num[0] += size.getNum();
                vs.add(v);
            });
        });
        req.setVariations(vs);
        req.setStock(num[0]);

        ShopeeItemAddResponse execute = client.execute(req);
        if(execute.isSuccess()){
            return execute.getItemId();
        }
        throw new Main4Exception(execute.getErrorDescription());
    }

    private Double priceStringToDouble(String priceString) {
        return new Double(MoneyUtil.dealPrice(MoneyUtil.StringToLong(priceString)));
    }
}
