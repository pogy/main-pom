package com.shigu.spread.services;

import com.opentae.data.mall.beans.ShiguRebateType;
import com.opentae.data.mall.beans.ShiguShopLicense;
import com.opentae.data.mall.examples.ShiguShopLicenseExample;
import com.opentae.data.mall.interfaces.ShiguRebateGoodsMapper;
import com.opentae.data.mall.interfaces.ShiguRebateTypeMapper;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.shigu.spread.bo.InvitePageSearchBO;
import com.shigu.spread.vo.InviteGoodsVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 类名：InviteGoodsActivityService
 * 类路径： com.shigu.spread.services.InviteGoodsActivityService
 * 创建者： whx
 * 创建时间： 7/24/18 2:23 PM
 * 项目： main-pom
 * 描述：
 */
@Service
public class InviteGoodsActivityService {

    @Autowired
    private ShiguRebateTypeMapper shiguRebateTypeMapper;

    @Autowired
    private ShiguRebateGoodsMapper shiguRebateGoodsMapper;

    @Autowired
    private ShiguShopLicenseMapper shiguShopLicenseMapper;


    public List<InviteGoodsVO> getInviteGoodsList(InvitePageSearchBO bo) {
        int pageSize = 20;
        List<InviteGoodsVO> result = new ArrayList<>();
        ShiguRebateType type = new ShiguRebateType();
        type.setIsActive(1);
        type.setTypeAbridge(bo.getType());
        type = shiguRebateTypeMapper.selectOne(type);
        if (type == null) {
            return result;
        }
        Long typeId = type.getTypeId();
        if (typeId == null) {
            return result;
        }
        List<InviteGoodsVO> inviteGoodsVOS = shiguRebateGoodsMapper.selRebateGoodsByType(typeId, (bo.getPage() - 1) * pageSize, pageSize);
        Set<Long> shopIds = inviteGoodsVOS.stream().map(InviteGoodsVO::getShopId).collect(Collectors.toSet());
        if (shopIds.size()>0) {
            ShiguShopLicenseExample shopLicenseExample = new ShiguShopLicenseExample();
            shopLicenseExample.createCriteria().andShopIdIn(new ArrayList<>(shopIds)).andLicenseTypeEqualTo(5).andLicenseFailureEqualTo(0);
            Map<Long, String> shopLicenseMap = shiguShopLicenseMapper.selectByExample(shopLicenseExample).stream().collect(Collectors.toMap(ShiguShopLicense::getShopId, ShiguShopLicense::getContext));
            for (InviteGoodsVO vo : inviteGoodsVOS) {
                if (vo.getPiPriceLong() != null) {
                    vo.setPiprice(String.format("%.2f",vo.getPiPriceLong() * 0.01));
                }
                List<String> services = new ArrayList<>();
                if (vo.getShopId() != null) {
                    String contextTags = shopLicenseMap.get(vo.getShopId());
                    if (StringUtils.isNotBlank(contextTags)) {
                        services.addAll(Arrays.asList(contextTags.split(",")));
                    }
                }
                vo.setServices(services);
                result.add(vo);
            }
        }
        return result;
    }

    public int countInviteGoods(String  typeAbridge) {
        ShiguRebateType type = new ShiguRebateType();
        type.setIsActive(1);
        type.setTypeAbridge(typeAbridge);
        type = shiguRebateTypeMapper.selectOne(type);
        if (type == null) {
            return 0;
        }
        Long typeId = type.getTypeId();
        if (typeId == null) {
            return 0;
        }
        return shiguRebateGoodsMapper.countRebateGoodsByType(typeId);
    }
}
