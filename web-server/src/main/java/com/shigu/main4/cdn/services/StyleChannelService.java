package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguOuterFloor;
import com.opentae.data.mall.beans.ShiguShopStyleRelation;
import com.opentae.data.mall.examples.ShiguShopExample;
import com.opentae.data.mall.examples.ShiguShopStyleRelationExample;
import com.opentae.data.mall.interfaces.ShiguOuterFloorMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.ShiguShopStyleRelationMapper;
import com.shigu.main4.cdn.vo.FloorVO;
import com.shigu.main4.cdn.vo.MarketVO;
import com.shigu.main4.cdn.vo.ShopInFloorVO;
import com.shigu.main4.storeservices.MarketShopService;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketShow;
import com.shigu.main4.vo.ShopShow;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    private MarketShopService marketShopService;

    @Autowired
    private MarketListService marketListService;

    @Autowired
    private ShiguShopStyleRelationMapper shiguShopStyleRelationMapper;


    public List<FloorVO> selStyleMarketShows(Long outerMarketId, Long parentStyleId) {
        if (parentStyleId == null) {
            return new ArrayList<>();
        }
        //没有传市场id，查电商基地
        if (outerMarketId == null) {
            outerMarketId = 1L;
        }
        MarketShow marketShow = marketShopService.selMarketShow(outerMarketId);
        if (marketShow == null) {
            return new ArrayList<>();
        }
        List<Long> shopIds = marketShow.getFloors().stream().filter(floorShow -> floorShow.getShops().size() > 0).flatMap(floorShow -> floorShow.getShops().stream().filter(Objects::nonNull).filter(shopShow -> shopShow.getShopId() != null).map(ShopShow::getShopId)).collect(Collectors.toList());
        List<FloorVO> marketList = new ArrayList<>();
        if (shopIds.size() > 0) {
            ShiguShopStyleRelationExample example = new ShiguShopStyleRelationExample();
            example.createCriteria().andShopIdIn(shopIds).andShopParentStyleIdsLike("%,"+parentStyleId+",%");
            Set<Long> styledShops = shiguShopStyleRelationMapper.selectByExample(example).stream().map(ShiguShopStyleRelation::getShopId).collect(Collectors.toSet());
            if (styledShops.size() > 0) {

            }
        }
        // TODO: 18-1-27  
        return null;
    }

    public MarketVO selStyleMarketVO(Long outerMarketId, Long parentStyleId) {
        if (parentStyleId == null) {
            return noneMarket();
        }
        MarketVO marketVO = redisIO.get("xxxxx", MarketVO.class);
        if (marketVO != null) {
            return marketVO;
        }
        //查询出市场中所有店铺，楼层数据
        marketVO = marketListService.selMarketData(outerMarketId, null);
        List<FloorVO> floorVOs = marketVO.getFloorVOs();
        //拿到所有可以显示在市场中的店铺id
        List<Long> shopIds = floorVOs.stream().flatMap(o -> o.getStores().stream().filter(shopInFloorVO -> shopInFloorVO.getId() != null).map(ShopInFloorVO::getId)).collect(Collectors.toList());
        if (shopIds.size() == 0) {
            return noneMarket();
        }
        //拿到设置过风格的店铺id
        ShiguShopStyleRelationExample example = new ShiguShopStyleRelationExample();
        example.createCriteria().andShopIdIn(shopIds).andShopParentStyleIdsLike("%,"+parentStyleId+",%");
        Set<Long> styledShops = shiguShopStyleRelationMapper.selectByExample(example).stream().map(ShiguShopStyleRelation::getShopId).collect(Collectors.toSet());
        if (styledShops.size() == 0) {
            return noneMarket();
        }
        //只留下设置过风格的店铺显示
        floorVOs.forEach(floorVO->floorVO.setStores(floorVO.getStores().stream().filter(shop->styledShops.contains(shop.getId())).collect(Collectors.toList())));
        //只留下仍有显示店铺的楼层
        marketVO.setFloorVOs(floorVOs.stream().filter(floorVO -> floorVO.getStores().size()>0).collect(Collectors.toList()));
        return marketVO;
    }

    /**
     * 非法输入/没有市场信息，返回一个没有数据的对象
     * @return
     */
    private MarketVO noneMarket() {
        MarketVO none = new MarketVO();
        none.setMarketName("");
        none.setWebSite("");
        ArrayList zeroList = new ArrayList<>(0);
        none.setFloorVOs(zeroList);
        none.setMarketTags(zeroList);
        none.setCates(zeroList);
        return none;
    }
}
