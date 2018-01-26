package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguOuterFloor;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.interfaces.ShiguOuterFloorMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.cdn.vo.ShopInFloorVO;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 路径:com.shigu.main4.cdn.services.StyleChannelService
 * 工程:main-pom
 * 时间:18-1-26下午8:25
 * 创建人:wanghaoxiang
 * 描述：风格频道
 */
@Service
public class StyleChannelService {

    @Autowired
    private RedisIO redisIO;

    @Autowired
    private ShiguOuterFloorMapper shiguOuterFloorMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    /**
     * 查询显示楼层中具有对应风格的档口
     *
     * @return
     */
    public List<ShopInFloorVO> selFloorStyleShops(Long parentStyleId, Long outFloorId) {
        if (parentStyleId == null || outFloorId == null) {
            return new ArrayList<>();
        }
        ShiguOuterFloor shiguOuterFloor = shiguOuterFloorMapper.selectByPrimaryKey(outFloorId);
        List<Long> floorIds = Arrays.stream(shiguOuterFloor.getFloorIds().split(",")).map(Long::parseLong).collect(Collectors.toList());
        ShiguShopExample shopExample = new ShiguShopExample();
        ShiguShopExample.Criteria criteria = shopExample.createCriteria().andFloorIdIn(floorIds).andShopStatusEqualTo(0).andDisplayInMarketEqualTo(1);
        if (StringUtils.isNotBlank(shiguOuterFloor.getAddedShop())) {
            List<Long> addedShopIds = Arrays.stream(shiguOuterFloor.getAddedShop().split(";")).map(o -> Long.parseLong(o.split(",")[0])).collect(Collectors.toList());
            if (addedShopIds != null && addedShopIds.size() > 0) {
                criteria.or().andShopIdIn(addedShopIds).andShopStatusEqualTo(0).andDisplayInMarketEqualTo(1);
            }
        }
        //shiguShopMapper.selectFieldsByExample(shopExample, FieldUtil.codeFields(""))
        return null;
    }
}
