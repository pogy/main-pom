package com.shigu.goodsup.sn.service;

import com.openJar.beans.JdVenderBrandPubInfo;
import com.openJar.beans.SnShopCategory;
import com.openJar.requests.api.SnFreightTemplateRequest;
import com.openJar.requests.api.SnShopCategoryRequest;
import com.openJar.responses.api.SnFreightTemplateResponse;
import com.openJar.responses.api.SnShopCategoryResponse;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguGoodsIdGeneratorMapper;
import com.opentae.data.mall.interfaces.ShiguGoodsTinyMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.service.PropsService;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.shigu.goodsup.jd.vo.PropertyItemVO;
import com.shigu.goodsup.jd.vo.PropsVO;
import com.shigu.goodsup.jd.vo.StoreCatVO;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.tb.finder.vo.PropType;
import com.shigu.tools.KeyWordsUtil;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.sale.FreighttemplateQueryResponse;
import com.suning.api.entity.shop.ShopcategoryQueryResponse;
import com.taobao.api.domain.DeliveryTemplate;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.PropImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SnUpItemService {

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguShopMapper shiguShopMapper;
    @Autowired
    JdUpItemService jdUpItemService;
    @Autowired
    XzJdSdkSend xzJdSdkSend;
    @Autowired
    PropsService propsService;

    public SnPageItem findGoods(Long goodsId) throws CustomException {
        ShiguGoodsTiny shiguGoodsTiny = selTiny(goodsId);
        SnPageItem snPageItem = new SnPageItem();
        snPageItem.setNumIid(shiguGoodsTiny.getNumIid());
        snPageItem.setStoreId(shiguGoodsTiny.getStoreId());
        snPageItem.setWebSite(shiguGoodsTiny.getWebSite());
        snPageItem.setGoodsId(shiguGoodsTiny.getGoodsId());
        snPageItem.setHuohao(shiguGoodsTiny.getGoodsNo());
        snPageItem.setGoodsId(goodsId);
        snPageItem.setPiPrice(shiguGoodsTiny.getPiPriceString());
        if (shiguGoodsTiny.getStoreId() != null) {
            List<Long> storeIds = new ArrayList<>();
            storeIds.add(shiguGoodsTiny.getStoreId());
            List<ShopNumAndMarket> gmi = shiguShopMapper.selShopNumAndMarkets(storeIds);
            if (gmi.size() > 0) {
                snPageItem.setParentMarketName(gmi.get(0).getMarket());
                snPageItem.setStoreNum(gmi.get(0).getShopNum());
            }
        }
        Item item = jdUpItemService.staticGoods(shiguGoodsTiny);
        item.setTitle(KeyWordsUtil.duleKeyWords(item.getTitle()));
        item.setDesc(KeyWordsUtil.duleKeyWords(item.getDesc()));
        snPageItem.setItem(item);
        if (shiguGoodsTiny.getNumIid() == null) {
            snPageItem.setGoodsType(2);
        } else {
            snPageItem.setGoodsType(1);
        }
        snPageItem.setDataType(2);

        return snPageItem;
    }

    public ShiguGoodsTiny selTiny(Long goodsId) throws CustomException {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (shiguGoodsIdGenerator == null) {
            throw new CustomException(goodsId + " goodsId生成表没找到");
        }
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if (shiguGoodsTiny == null) {
            throw new CustomException(goodsId + " goodsTiny表没找到");
        }
        return shiguGoodsTiny;
    }

    /**
     * 获取运费模板
     *
     * @param username
     * @return
     * @throws AuthOverException
     * @throws CustomException
     */
    public List<DeliveryTemplate> selPostModel(String username) throws AuthOverException, CustomException {
        List<DeliveryTemplate> vs = new ArrayList<>();
        DeliveryTemplate v1 = new DeliveryTemplate();
        v1.setTemplateId(-1L);
        v1.setName("不使用运费模版");
        vs.add(v1);
        SnFreightTemplateRequest request = new SnFreightTemplateRequest();
        request.setUsername(username);
        SnFreightTemplateResponse response = xzJdSdkSend.send(request);
        if (!response.isSuccess()) {
            return vs;
        }
        List<FreighttemplateQueryResponse.QueryFreighttemplate> list = response.getQueryFreighttemplateList();
        if (list == null) {
            return vs;
        } else {
            vs.addAll(list.stream().map(l -> {
                DeliveryTemplate v = new DeliveryTemplate();
                v.setTemplateId(Long.valueOf(l.getFreighttemplateid()));
                v.setName(l.getFreighttemplatename());
                return v;
            }).collect(Collectors.toList()));
            return vs;
        }
    }

    public List<StoreCatVO> selShopCats(String username) throws AuthOverException, CustomException {
        SnShopCategoryRequest request = new SnShopCategoryRequest();
        request.setUsername(username);
        SnShopCategoryResponse response = xzJdSdkSend.send(request);
        if (!response.isSuccess()) {
            return new ArrayList<>();
        }
        List<SnShopCategory> shopCategories = response.getSnShopCategories();
        if (shopCategories == null) {
            return null;
        } else {
            Map<Integer, List<SnShopCategory>> map = shopCategories.stream().collect(Collectors.groupingBy(SnShopCategory::getIsFirst));
            return map.get(0).stream().map(shopCategory -> {
                StoreCatVO vo = new StoreCatVO();
                vo.setCatId(Long.valueOf(shopCategory.getCategoryCode()));
                vo.setName(shopCategory.getCategoryName());
                vo.setSubCat(map.get(1).stream().map(shopCategory1 -> {
                    StoreCatVO svo = new StoreCatVO();
                    svo.setName(shopCategory1.getCategoryName());
                    svo.setCatId(Long.valueOf(shopCategory1.getCategoryCode()));
                    return svo;
                }).collect(Collectors.toList()));
                return vo;
            }).collect(Collectors.toList());
        }
    }

    public PropsVO selProps(Long jdCid, String username, Item item, List<NewbrandQueryResponse.QueryNewbrand> brands) throws CloneNotSupportedException, IOException, ClassNotFoundException, AuthOverException, CustomException{
        PropsVO tbPropsVO=propsService.selProps(item.getCid());
        List<PropImg> propImgs=item.getPropImgs();
        if (propImgs == null) {
            propImgs=new ArrayList<>();
        }
        tbPropsVO=propsService.importValue(tbPropsVO,item.getPropsName(), BeanMapper.mapList(propImgs, PropImg.class),item.getPropertyAlias(),item
                .getInputStr(),item.getInputPids());
        PropsVO prop=new PropsVO();
        jdUpItemService.fillPropValue(prop.getColor(),tbPropsVO.getColor());
        jdUpItemService.fillProp(prop.getSaleProps(),tbPropsVO.getSaleProps());
        jdUpItemService.fillProp(prop.getProperties(),tbPropsVO.getProperties());
        for(PropertyItemVO p:prop.getProperties()){
            if("颜色".equals(p.getName())&&p.getType().equals(PropType.CHECKBOX)){
                jdUpItemService.fillPropValue(p,tbPropsVO.getColor());
                break;
            }
        }
        jdUpItemService.fillProp(prop.getProperties(),tbPropsVO.getSaleProps());
        jdUpItemService.fillProp(prop.getSpecification(),tbPropsVO.getProperties());
        prop.setSkus(propsService.calculateSku(prop.getColor(),prop.getSaleProps()));
        return prop;
    }
}
