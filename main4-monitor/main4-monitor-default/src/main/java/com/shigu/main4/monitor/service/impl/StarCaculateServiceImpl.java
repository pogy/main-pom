package com.shigu.main4.monitor.service.impl;

import com.opentae.data.mall.beans.ShiguShopLicense;
import com.opentae.data.mall.examples.ShiguShopLicenseExample;
import com.opentae.data.mall.interfaces.ShiguShopLicenseMapper;
import com.shigu.main4.monitor.services.StarCaculateService;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wxc on 2017/3/8.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("starCaculateService")
public class StarCaculateServiceImpl implements StarCaculateService {

    @Autowired
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    @Autowired
    RedisIO redisIO;

    /**
     * 增加一个流量
     * 默认,流量+100,星星+1
     *
     * @param shopId
     */
    @Override
    public void addBrower(Long shopId) {
        addBrower(shopId, null);
    }

    @Override
    public void addBrower(Long shopId, Long times) {
        if (cacheForAdd(shopId, times == null ? 100 : times)) {
            addStar(shopId, 1);
        }
    }

    /**
     * 增加一个商品上传
     * 默认上传+1,星星+1
     *
     * @param shopId
     */
    @Override
    public void addItemUp(Long shopId) {
        addStar(shopId, 1);
    }

    /**
     * 增加一个流量
     * 默认,流量+100,星星+1
     * 增加一个商品上传
     * 默认上传+1,星星+1
     *
     * @param shopId
     * @param addNumber
     */
    @Override
    public void addStar(Long shopId, int addNumber) {
        if (addNumber < 0)
            addNumber = -addNumber;
        ShiguShopLicenseExample licenseExample = new ShiguShopLicenseExample();
        licenseExample.createCriteria().andShopIdEqualTo(shopId).andLicenseTypeEqualTo(6);
        List<ShiguShopLicense> shopLicenses = shiguShopLicenseMapper.selectByExample(licenseExample);
        if (shopLicenses.isEmpty()) {
            ShiguShopLicense license = new ShiguShopLicense();
            license.setContext(addNumber + "");
            license.setShopId(shopId);
            license.setLicenseType(6);
            license.setLicenseFailure(0);
            shiguShopLicenseMapper.insertSelective(license);
        } else {
            ShiguShopLicense license = shopLicenses.get(0);
            String context = license.getContext();
            try {
                Integer star = Integer.valueOf(context);
                license.setContext((star + addNumber) + "");
                shiguShopLicenseMapper.updateByPrimaryKeySelective(license);
            } catch (Exception ignore) {
            }
        }
    }

    /**
     * 缓式添加
     * 如,每100次算加1次
     * 此方法实现的逻辑为
     * 按key取出redis中数据
     * 如果数据大于等于max,那么,redis中此key对应值设置为1
     * 如果数据不存在,那么,redis中此key对应值设置为1
     * 否则值++
     *
     * @param key
     * @param max
     * @return
     */
    @Override
    public boolean cacheForAdd(Long key, Long max) {
        Long value = redisIO.get(key.toString(), Long.TYPE);
        Long times = 1L;
        boolean reset = false;
        if (value != null && !(reset = value >= max)) {
            times += value;
        }
        redisIO.put(key.toString(), times);
        return reset;
    }
}
