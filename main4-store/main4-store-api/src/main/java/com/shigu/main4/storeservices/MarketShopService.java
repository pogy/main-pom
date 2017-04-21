package com.shigu.main4.storeservices;

import com.shigu.main4.vo.FloorShow;
import com.shigu.main4.vo.MarketShow;
import com.shigu.main4.vo.ShopShow;

import java.util.Comparator;
import java.util.List;

/**
 * 市场内档口数据查询
 * Created by zhaohongbo on 17/2/27.
 */
public interface MarketShopService {
    /**
     * 按市场ID,查本市场信息
     * @param outerMarketId
     * @return
     */
    MarketShow selMarketShow(Long outerMarketId);

    /**
     * 按外部楼层ID查一层的数据
     * @param outerFloor
     * @return
     */
    FloorShow selFloorShow(Long outerFloor);

    /**
     * 得取店铺排序的比较器
     * @return
     */
    void getShopComparator(List<ShopShow> shopShowList);
}
