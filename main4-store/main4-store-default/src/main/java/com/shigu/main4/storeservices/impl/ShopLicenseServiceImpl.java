package com.shigu.main4.storeservices.impl;

import com.opentae.data.mall.beans.ShiguShopLicense;
import com.opentae.data.mall.examples.ShiguShopLicenseExample;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.vo.ShiguTags;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.vo.LinceseVo;
import com.shigu.main4.vo.ShopLicense;
import com.sun.jdi.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 店铺权益服务
 * Created by zhaohongbo on 17/3/13.
 */
@Service("shopLicenseService")
public class ShopLicenseServiceImpl implements ShopLicenseService{

    @Resource(name = "tae_mall_shiguShopLicenseMapper")
    private ShiguShopLicenseMapper shiguShopLicenseMapper;


    /**
     * 按主键查询店铺标签服务
     * @param shopId
     * @return
     */
    @Override
    public List<ShiguTags> selTagLicenseByShopId(Long shopId) {
        List<ShiguTags> shiguTagsList = new ArrayList<ShiguTags>();
        if(shopId == null){
            return shiguTagsList;
        }
        ShiguShopLicenseExample licenseExample = new ShiguShopLicenseExample();
        licenseExample.createCriteria().andShopIdEqualTo(shopId).andLicenseTypeEqualTo(ShopLicenseTypeEnum.TAGS.getValue())
                .andLicenseFailureEqualTo(0);
        List<ShiguShopLicense> shiguShopLicenseList = shiguShopLicenseMapper.selectByExample(licenseExample);
        if(shiguShopLicenseList.size() == 0){
            return shiguTagsList;
        }
        ShiguShopLicense shiguShopLicense = shiguShopLicenseList.get(0);
        String tags = shiguShopLicense.getContext();
        if(StringUtils.isEmpty(tags)){
            return shiguTagsList;
        }
        String [] tagcz = tags.split(",");
        for(int i = 0;i< tagcz.length;i++){
            String tag = tagcz[i];
            if(StringUtils.isEmpty(tag)){
                continue;
            }
            ShiguTags shiguTags = ShiguTags.getShiguTags(tag);
            if(shiguTags == null){
                continue;
            }
            shiguTagsList.add(shiguTags);
        }
        return shiguTagsList;
    }

    /**
     * 更新标签
     * 如果原记录不存在,需要创建
     * @param shopId
     * @param tags
     */
    @Override
    public void updateShopTagLicense(Long shopId, List<ShiguTags> tags) {
        if(shopId == null || tags == null || tags.size() == 0){
            return;
        }
        ShiguShopLicenseExample licenseExample = new ShiguShopLicenseExample();
        licenseExample.createCriteria().andShopIdEqualTo(shopId).andLicenseTypeEqualTo(ShopLicenseTypeEnum.TAGS.getValue());
        List<ShiguShopLicense> shiguShopLicenseList = shiguShopLicenseMapper.selectByExample(licenseExample);
        String tag = ShiguTags.getShiguTags(tags);
        if(shiguShopLicenseList.size() == 0){
            // 新增
            ShiguShopLicense shiguShopLicense = new ShiguShopLicense();
            shiguShopLicense.setShopId(shopId);
            shiguShopLicense.setContext(tag);
            shiguShopLicense.setLicenseFailure(0);
            shiguShopLicense.setLicenseType(ShopLicenseTypeEnum.TAGS.getValue());
            shiguShopLicenseMapper.insertSelective(shiguShopLicense);
            return;
        }
        // 更新
        ShiguShopLicense shiguShopLicense = shiguShopLicenseList.get(0);
        shiguShopLicense.setLicenseFailure(0);
        shiguShopLicense.setContext(tag);
        shiguShopLicenseMapper.updateByPrimaryKeySelective(shiguShopLicense);
    }

    /**
     * 店铺权益
     * 只查有用的
     *
     * @param shopId 店铺ID
     * @return 权益列表
     * @tip always List，Not null
     */
    @Override
    public List<ShopLicense> selShopLicenses(Long shopId) {
        if (shopId == null) return Collections.emptyList();
        ShiguShopLicense shopLicense = new ShiguShopLicense();
        shopLicense.setShopId(shopId);
        shopLicense.setLicenseFailure(0);//有效
        List<ShiguShopLicense> select = shiguShopLicenseMapper.select(shopLicense);

        List<ShopLicense> shopLicenses = new ArrayList<>(select.size());
        for (ShiguShopLicense license : select) {
            ShopLicense sl = new ShopLicense();
            sl.setLicenseType(license.getLicenseType());
            sl.setContext(license.getContext());
            sl.setLicenseId(license.getLicenseId());
            shopLicenses.add(sl);
        }
        return shopLicenses;
    }

    @Override
    public ShopLicense selShopLIcenseByType(Long shopId, ShopLicenseTypeEnum type) {
        ShiguShopLicenseExample shiguShopLicenseExample=new ShiguShopLicenseExample();
        shiguShopLicenseExample.createCriteria().andShopIdEqualTo(shopId).andLicenseTypeEqualTo(type.getValue());
        List<ShiguShopLicense> licenses=shiguShopLicenseMapper.selectByExample(shiguShopLicenseExample);
        if(licenses.size()>0){
            return BeanMapper.map(licenses.get(0),ShopLicense.class);
        }
        return null;
    }

    @Override
    public Integer updateShopLIcenseByType(Long shopId,Integer type, Integer licenseFailure, String content) {
        Integer tag;
        ShiguShopLicense license = new ShiguShopLicense();
        license.setShopId(shopId);
        license.setLicenseType(type);
        license = shiguShopLicenseMapper.selectOne(license);
        if (license == null){
            ShiguShopLicense license1 = new ShiguShopLicense();
            license1.setShopId(shopId);
            license1.setLicenseFailure(licenseFailure);
            license1.setContext(content);
            license1.setLicenseType(type);
            tag = shiguShopLicenseMapper.insertSelective(license1);
        }else {
            license.setLicenseFailure(licenseFailure);
            ShiguShopLicenseExample example = new ShiguShopLicenseExample();
            example.createCriteria().andShopIdEqualTo(shopId).andLicenseTypeEqualTo(type);
            license.setContext(content);
            tag = shiguShopLicenseMapper.updateByExampleSelective(license,example);
        }
        return tag;
    }

    @Override
    public List<LinceseVo> selShopLIcenseByIds(List<Long> shopIds) {
        List<LinceseVo> voList = new ArrayList<>();

        ShiguShopLicenseExample shiguShopLicenseExample=new ShiguShopLicenseExample();
        List<Integer> integers = new ArrayList<>();
        integers.add(ShopLicenseTypeEnum.WEIXIN.getValue());
        integers.add(ShopLicenseTypeEnum.ZIXUN.getValue());
        shiguShopLicenseExample.createCriteria().andShopIdIn(shopIds).andLicenseTypeIn(integers);
        List<ShiguShopLicense> licenses=shiguShopLicenseMapper.selectByExample(shiguShopLicenseExample);
        if (licenses.size() == 0) {
            return new ArrayList<>();
        }

        Map<Long, List<ShiguShopLicense>> maps = licenses.stream().collect(Collectors.groupingBy(ShiguShopLicense::getShopId));

        for (Long ls : maps.keySet()){
            LinceseVo vo = new LinceseVo();
            List<ShiguShopLicense> shiguShopLicenses = maps.get(ls);
            vo.setShopId(ls);
            for (ShiguShopLicense license : shiguShopLicenses){
                if (license.getLicenseType() == 9){
                    vo.setIsWx(license.getLicenseFailure());
                }
                if (license.getLicenseType() == 10){
                    vo.setIsZx(license.getLicenseFailure());
                    vo.setContext(license.getContext());
                }
            }
            voList.add(vo);
        }
        return voList;
    }

}
