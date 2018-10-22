package com.shigu.goodsup.shopee.services;

import com.opentae.data.mall.beans.ShiguShopeeCat;
import com.opentae.data.mall.examples.ShiguShopeeCatExample;
import com.opentae.data.mall.interfaces.ShiguShopeeCatMapper;
import com.shigu.goodsup.jd.bo.JdUploadSkuBO;
import com.shigu.goodsup.shopee.bo.UptoTbShopee;
import com.shigu.goodsup.shopee.utils.ZHConverter;
import com.shigu.goodsup.shopee.vo.CategoryVO;
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
import com.shigu.upload.shopee.sdk.request.ShopeeItemAddRequest;
import com.shigu.upload.shopee.sdk.response.ShopeeGetAttributesResponse;
import com.shigu.upload.shopee.sdk.response.ShopeeGetCategoriesResponse;
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

    public PropsVO selProps(Long id, Long cid) throws TbPropException {
        PropsVO propsVO = tbPropsService.selHasValueProps(id);
        propsVO.getSkus().forEach(this::tdToHans);

        Map<String, PropertyItemVO> tbPropMap = propsVO.getProperties()
                .stream().filter(propertyItemVO -> propertyItemVO.getType() == PropType.SELECT ||
                        propertyItemVO.getType() == PropType.CHECKBOX)
                .collect(Collectors.toMap(o -> ZHConverter.convert(o.getName(), ZHConverter.TRADITIONAL), o -> o));

        ShopeeGetAttributesRequest req = new ShopeeGetAttributesRequest();
        req.setCountry("TW");
        req.setCategoryId(cid);
        req.setIsCb(true);
        ShopeeGetAttributesResponse execute = client.execute(req);


        propsVO.setHuohao(null);
        propsVO.setPingpai(null);
        List<PropertyItemVO> props=new ArrayList<>();
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
                if(pp.getValues().size()==0){
                    pp.getValues().add(new PropertyValueVO());
                }
                propsVO.setPingpai(pp);
                return;
            }
            PropertyItemVO tbpp = tbPropMap.get(shopeeAttributes.getAttributeName());
            if (tbpp == null) {
                return;
            }
            Map<String, PropertyValueVO> tbpvmap = tbpp.getValues().stream()
                    .collect(Collectors.toMap(o -> ZHConverter.convert(o.getName(), ZHConverter.TRADITIONAL), o -> o));
            List<PropertyValueVO> propertyValueVOS =new ArrayList<>();
            propertyValueVOS.add(new PropertyValueVO());
            propertyValueVOS.addAll(shopeeAttributes.getValues().stream().map(shopeeValues -> {
                PropertyValueVO pv = new PropertyValueVO();
                pv.setName(shopeeValues.getOriginalValue());
                pv.setSelected(tbpvmap.get(shopeeValues.getOriginalValue())!=null&&tbpvmap.get(shopeeValues.getOriginalValue()).isSelected());
                return pv;
            }).collect(Collectors.toList()));
            pp.setValues(propertyValueVOS);
            props.add(pp);
        });
        propsVO.setProperties(props);


        propsVO.getSaleProps().forEach(this::toTans);
        toTans(propsVO.getColor());
        return propsVO;
    }

    private void tdToHans(ArrayList<TdVO> tdVOS){
        tdVOS.forEach(tdVO -> {
            tdVO.setValue(ZHConverter.convert(tdVO.getValue(), ZHConverter.TRADITIONAL));
            if(tdVO.getSkuRankVO()!=null&&tdVO.getSkuRankVO().size()>0){
                tdToHans(tdVO.getSkuRankVO());
            }
        });
    }

    private void toTans(PropertyItemVO propertyItemVO){
        propertyItemVO.setName(ZHConverter.convert(propertyItemVO.getName(), ZHConverter.TRADITIONAL));
        propertyItemVO.getValues().forEach(propertyValueVO -> {
            propertyValueVO.setName(ZHConverter.convert(propertyValueVO.getName(), ZHConverter.TRADITIONAL));
            propertyValueVO.setVname(ZHConverter.convert(propertyValueVO.getVname(), ZHConverter.TRADITIONAL));
        });
    }

    public String selCatPath(Long cid) {
        List<String> cnames=new ArrayList<>();
        selCname(cid,cnames);
        Collections.reverse(cnames);
        return StringUtils.join(cnames,"->");
    }

    private void selCname(Long cid,List<String> cnames){
        ShiguShopeeCat shiguShopeeCat=shiguShopeeCatMapper.selectByPrimaryKey(cid);
        if(shiguShopeeCat!=null){
            cnames.add(shiguShopeeCat.getCname());
            if(shiguShopeeCat.getParentCid()!=0L){
                selCname(shiguShopeeCat.getParentCid(),cnames);
            }
        }
    }

    static Map<Long,List<ShopeeCategories>> map=null;
    static long time=System.currentTimeMillis();

    public List<CategoryVO> selCate(Long cid){
//        List<ShiguShopeeCat> shiguShopeeCats;
//        if(cid==null||cid<=0L){
//            List<Long> cids=Arrays.asList(63L,62L,1859L,64L,1837L,65L,2580L);
//            ShiguShopeeCatExample shiguShopeeCatExample=new ShiguShopeeCatExample();
//            shiguShopeeCatExample.createCriteria().andCidIn(cids);
//            shiguShopeeCats=shiguShopeeCatMapper.selectByExample(shiguShopeeCatExample);
//            shiguShopeeCats.sort(Comparator.comparingInt(shiguShopeeCat -> cids.indexOf(shiguShopeeCat.getCid())));
//        }else{
//            ShiguShopeeCatExample shiguShopeeCatExample=new ShiguShopeeCatExample();
//            shiguShopeeCatExample.createCriteria().andParentCidEqualTo(cid);
//            shiguShopeeCats=shiguShopeeCatMapper.selectByExample(shiguShopeeCatExample);
//        }
//        return shiguShopeeCats.stream().map(shiguShopeeCat -> {
//            CategoryVO vo=new CategoryVO();
//            vo.setCid(shiguShopeeCat.getCid());
//            vo.setText(shiguShopeeCat.getCname());
//            vo.setHasChild(shiguShopeeCat.getIsParent());
//            return vo;
//        }).collect(Collectors.toList());
        if(map==null||System.currentTimeMillis()-time>600000L){
            ShopeeGetCategoriesByCountryRequest req=new ShopeeGetCategoriesByCountryRequest();
            req.setCountry("TW");
            req.setIsCb(1);
            ShopeeGetCategoriesResponse execute = client.execute(req);
            map =execute.getCategories().stream().collect(Collectors.groupingBy(ShopeeCategories::getParentId));
        }
        if(cid==null||cid==0L){
            return map.get(0L).stream()
                    .filter(shopeeCategories -> Arrays.asList(63L, 62L, 1859L, 64L, 1837L, 65L, 2580L)
                            .contains(shopeeCategories.getCategoryId())).map(shopeeCategories -> {
                        CategoryVO vo = new CategoryVO();
                        vo.setCid(shopeeCategories.getCategoryId());
                        vo.setText(shopeeCategories.getCategoryName());
                        vo.setHasChild(shopeeCategories.getHasChildren());
                        return vo;
                    }).collect(Collectors.toList());
        }
        return map.get(cid).stream().map(shopeeCategories -> {
            CategoryVO vo = new CategoryVO();
            vo.setCid(shopeeCategories.getCategoryId());
            vo.setText(shopeeCategories.getCategoryName());
            vo.setHasChild(shopeeCategories.getHasChildren());
            return vo;
        }).collect(Collectors.toList());
    }

    public void itemAdd(UptoTbShopee bo, List<JdUploadSkuBO> sku,String[] picUrl, String[] skuProps, String[] deliver, Long shopId){
        ShopeeItemAddRequest req=new ShopeeItemAddRequest();
        req.setCategoryId(bo.getCid());
        req.setCondition("new".endsWith(bo.getStuffStatus())?"NEW":"USED");
        req.setDescription(ZHConverter.convert(bo.getSellPoint(), ZHConverter.TRADITIONAL));
        req.setName(ZHConverter.convert(bo.getTitle(), ZHConverter.TRADITIONAL));
        req.setPrice(priceStringToDouble(bo.getPrice()));
        req.setWeight(new Double(bo.getWeight()));
        req.setShopId(shopId);

        req.setAttributes(Arrays.stream(skuProps).map(s -> {
            s+=" ";
            String[] strs=s.split(":");
            ShopeeUploadItemAttribute a=new ShopeeUploadItemAttribute();
            a.setAttributesId(new Long(strs[0]));
            a.setValue(strs[1].trim());
            return a;
        }).collect(Collectors.toList()));

        req.setImages(Arrays.stream(picUrl).map(s -> {
            ShopeeUploadImage i=new ShopeeUploadImage();
            i.setUrl(s);
            return i;
        }).collect(Collectors.toList()));

        req.setLogistics(Arrays.stream(deliver).map(s -> {
            ShopeeUploadLogistic l=new ShopeeUploadLogistic();
            l.setEnabled(true);
            l.setLogisticId(new Long(s));
            return l;
        }).collect(Collectors.toList()));

        final Long[] num = {0L};
        List<ShopeeUploadItemVariation> vs=new ArrayList<>();
        sku.forEach(color -> {
            color.getSizes().forEach(size -> {
                ShopeeUploadItemVariation v=new ShopeeUploadItemVariation();
                v.setName(color.getName()+"_"+size.getName());
                v.setPrice(priceStringToDouble(size.getPrice()));
                v.setStock(size.getNum().longValue());
                num[0]+=size.getNum();
                vs.add(v);
            });
        });
        req.setVariations(vs);
        req.setStock(num[0]);

        System.out.println(JSONObject.fromObject(req));

    }
    private Double priceStringToDouble(String priceString){
        return new Double(MoneyUtil.dealPrice(MoneyUtil.StringToLong(priceString)));
    }
}
