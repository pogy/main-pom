package com.shigu.goodsup.shopee.services;

import com.opentae.data.mall.beans.ShiguShopeeCat;
import com.opentae.data.mall.examples.ShiguShopeeCatExample;
import com.opentae.data.mall.interfaces.ShiguShopeeCatMapper;
import com.shigu.goodsup.shopee.utils.ZHConverter;
import com.shigu.goodsup.shopee.vo.CategoryVO;
import com.shigu.tb.finder.exceptions.TbPropException;
import com.shigu.tb.finder.services.TbPropsService;
import com.shigu.tb.finder.vo.PropType;
import com.shigu.tb.finder.vo.PropertyItemVO;
import com.shigu.tb.finder.vo.PropertyValueVO;
import com.shigu.tb.finder.vo.PropsVO;
import com.shigu.upload.shopee.sdk.ShopeeClient;
import com.shigu.upload.shopee.sdk.domain.ShopeeAttributes;
import com.shigu.upload.shopee.sdk.request.ShopeeGetAttributesRequest;
import com.shigu.upload.shopee.sdk.response.ShopeeGetAttributesResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PropsVO selProps(Long id, Long cid) throws TbPropException {
        PropsVO propsVO = tbPropsService.selHasValueProps(id);
        Map<String, PropertyItemVO> tbPropMap = propsVO.getProperties()
                .stream().filter(propertyItemVO -> propertyItemVO.getType() == PropType.SELECT ||
                        propertyItemVO.getType() == PropType.CHECKBOX)
                .collect(Collectors.toMap(o -> ZHConverter.convert(o.getName(), ZHConverter.TRADITIONAL), o -> o));

        ShopeeGetAttributesRequest req = new ShopeeGetAttributesRequest();
        req.setCountry("TW");
        req.setCategoryId(cid);
        req.setIsCb(true);
        ShopeeGetAttributesResponse execute = client.execute(req);

        Map<Long, ShopeeAttributes> map = execute.getAttributes().stream()
                .collect(Collectors.toMap(ShopeeAttributes::getAttributeId, o -> o));

        propsVO.setHuohao(null);
        propsVO.setPingpai(null);
        List<PropertyItemVO> props=new ArrayList<>();
        execute.getAttributes().forEach((ShopeeAttributes shopeeAttributes) -> {
            PropertyItemVO pp = new PropertyItemVO();
            pp.setPid(shopeeAttributes.getAttributeId());
            pp.setMustHave(shopeeAttributes.getMandatory());
            pp.setName(shopeeAttributes.getAttributeName());
            pp.setType(PropType.SELECT);
            if ("品牌".equals(shopeeAttributes.getAttributeName())) {
                pp.setValues(shopeeAttributes.getValues().stream().map(shopeeValues -> {
                    PropertyValueVO pv = new PropertyValueVO();
                    pv.setName(shopeeValues.getOriginalValue());
                    pv.setSelected("自有品牌".equals(shopeeValues.getOriginalValue()));
                    return pv;
                }).collect(Collectors.toList()));
                propsVO.setPingpai(pp);
                return;
            }
            PropertyItemVO tbpp = tbPropMap.get(shopeeAttributes.getAttributeName());
            if (tbpp == null) {
                return;
            }
            Map<String, PropertyValueVO> tbpvmap = tbpp.getValues().stream()
                    .collect(Collectors.toMap(o -> ZHConverter.convert(o.getName(), ZHConverter.TRADITIONAL), o -> o));
            pp.setValues(shopeeAttributes.getValues().stream().map(shopeeValues -> {
                PropertyValueVO pv = new PropertyValueVO();
                pv.setName(shopeeValues.getOriginalValue());
                pv.setSelected(tbpvmap.get(shopeeValues.getOriginalValue())!=null&&tbpvmap.get(shopeeValues.getOriginalValue()).isSelected());
                return pv;
            }).collect(Collectors.toList()));
            props.add(pp);
        });
        propsVO.setProperties(props);
        return propsVO;
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

    public List<CategoryVO> selCate(Long cid){
        List<ShiguShopeeCat> shiguShopeeCats;
        if(cid==null||cid<=0L){
            List<Long> cids=Arrays.asList(63L,62L,1859L,64L,1837L,65L,2580L);
            ShiguShopeeCatExample shiguShopeeCatExample=new ShiguShopeeCatExample();
            shiguShopeeCatExample.createCriteria().andCidIn(cids);
            shiguShopeeCats=shiguShopeeCatMapper.selectByExample(shiguShopeeCatExample);
            shiguShopeeCats.sort(Comparator.comparingInt(shiguShopeeCat -> cids.indexOf(shiguShopeeCat.getCid())));
        }else{
            ShiguShopeeCatExample shiguShopeeCatExample=new ShiguShopeeCatExample();
            shiguShopeeCatExample.createCriteria().andParentCidEqualTo(cid);
            shiguShopeeCats=shiguShopeeCatMapper.selectByExample(shiguShopeeCatExample);
        }
        return shiguShopeeCats.stream().map(shiguShopeeCat -> {
            CategoryVO vo=new CategoryVO();
            vo.setCid(shiguShopeeCat.getCid());
            vo.setText(shiguShopeeCat.getCname());
            vo.setHasChild(shiguShopeeCat.getIsParent());
            return vo;
        }).collect(Collectors.toList());
    }
}
