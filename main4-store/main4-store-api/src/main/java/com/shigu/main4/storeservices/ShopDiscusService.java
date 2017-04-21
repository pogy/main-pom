package com.shigu.main4.storeservices;

import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.vo.Discus;

/**
 * 店铺评论服务
 * Created by zhaohongbo on 17/2/22.
 */
public interface ShopDiscusService {
    /**
     * 查评分的平均值
     * @param shopId
     * @return
     */
    Double selScoreAvg(Long shopId);

    /**
     * 查分页数据
     * @param shopId 店铺ID
     * @param pageNo 当前页
     * @param pageSize 每页条数
     * @return
     */
    ShiguPager<Discus> selDiscusByShopId(Long shopId, Integer pageNo, Integer pageSize);

    /**
     * 累计店铺评论
     * @param shopId
     * @return
     */
    int countAllDiscusByShopId(Long shopId);

    /**
     * 添加评论
     * @param discus
     */
    void addDiscus(Discus discus);
}
