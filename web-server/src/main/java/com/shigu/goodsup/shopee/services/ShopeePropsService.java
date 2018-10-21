package com.shigu.goodsup.shopee.services;

import com.shigu.tb.finder.exceptions.TbPropException;
import com.shigu.tb.finder.services.TbPropsService;
import com.shigu.tb.finder.vo.PropertyItemVO;
import com.shigu.tb.finder.vo.PropsVO;
import com.shigu.upload.shopee.sdk.ShopeeClient;
import com.shigu.upload.shopee.sdk.domain.ShopeeAttributes;
import com.shigu.upload.shopee.sdk.request.ShopeeGetAttributesRequest;
import com.shigu.upload.shopee.sdk.request.ShopeeGetCategoriesByCountryRequest;
import com.shigu.upload.shopee.sdk.response.ShopeeGetAttributesResponse;
import com.shigu.upload.shopee.sdk.response.ShopeeGetCategoriesResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Collectors;

public class ShopeePropsService {

    private TbPropsService tbPropsService;
    @Autowired
    ShopeeClient client;

    public void v(Long id,Long cid) throws TbPropException {
        PropsVO propsVO = tbPropsService.selHasValueProps(id);

        ShopeeGetAttributesRequest req=new ShopeeGetAttributesRequest();
        req.setCountry("TW");
        req.setCategoryId(cid);
        req.setIsCb(true);
        ShopeeGetAttributesResponse execute = client.execute(req);

        Map<Long, ShopeeAttributes> map = execute.getAttributes().stream()
                .collect(Collectors.toMap(ShopeeAttributes::getAttributeId, o -> o));

        propsVO.setHuohao(null);


    }
}
