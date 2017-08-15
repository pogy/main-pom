package com.shigu.daifa.services;

import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.beans.GgoodsByStore;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsTasksMapper;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.actions.beans.MarketBean;
import com.shigu.daifa.bo.OrderAllocateBO;
import com.shigu.daifa.vo.OrderAllocateVO;
import com.shigu.main4.common.util.DateUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by pc on 2017-08-15.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Service
public class DaifaAllocateService {

    private static TreeMap<MarketBean, TreeMap<MarketBean, TreeMap<MarketBean, MarketBean>>> treeTree;//市场楼层档口，只有获取市场列表时更新
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;

    @Autowired
    public void setDaifaGgoodsTasksMapper(DaifaGgoodsTasksMapper daifaGgoodsTasksMapper) {
        this.daifaGgoodsTasksMapper = daifaGgoodsTasksMapper;
    }

    public List<OrderAllocateVO> orderAllcoation(OrderAllocateBO bo) {
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        DaifaGgoodsTasksExample.Criteria criteria = daifaGgoodsTasksExample.createCriteria();
        criteria.andUseStatusEqualTo(1).andAllocatStatusEqualTo(0);//可用的未分配的
        if (!StringUtils.isEmpty(bo.getChildOrderId())) {
            criteria.andDfOrderIdEqualTo(bo.getChildOrderId());
        }
        if (!StringUtils.isEmpty(bo.getOrderId())) {
            criteria.andDfOrderIdLike("%" + bo.getOrderId());
        }
        if (StringUtils.hasText(bo.getStartTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.stringToDate(bo.getStartTime()));
        }
        if (StringUtils.hasText(bo.getEndTiem())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtil.stringToDate(bo.getEndTiem()));
        }
        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        daifaGgoodsTasksExample.setOrderByClause("create_time desc");
        int page = Integer.parseInt(bo.getPage());
        int rows = 10;
        daifaGgoodsTasksExample.setStartIndex((page - 1) * rows);
        daifaGgoodsTasksExample.setEndIndex(rows);
        List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectByConditionList(daifaGgoodsTasksExample);
        List<OrderAllocateVO> orderAllocateVOS = new ArrayList<>();
        for (DaifaGgoodsTasks ggoodsTask : ggoodsTasks) {
            OrderAllocateVO vo = new OrderAllocateVO();
            vo.setChildOrderId(ggoodsTask.getDfOrderId());
            vo.setGoodsNo(ggoodsTask.getGoodsCode());
            vo.setNum(ggoodsTask.getGoodsNum());
            vo.setGoodsProperty(ggoodsTask.getPropStr());
            vo.setImgSrc(ggoodsTask.getPicPath());
            vo.setPiPrice(ggoodsTask.getSinglePiPrice());
            vo.setTitle(ggoodsTask.getTitle());
            orderAllocateVOS.add(vo);
        }
        int count = daifaGgoodsTasksMapper.countByExample(daifaGgoodsTasksExample);
        bo.setCount(count);
        return orderAllocateVOS;
    }

    /**
     * 获取市场列表
     * 只有该方法会更新treeTree
     *
     * @return json
     */
    public JSONObject getMarketList() {
        if (treeTree == null) {
            treeTree = new TreeMap<>();
        }


        return null;
    }

    private void makeMarket() {
        AuthorityUser user = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Long sellerId = user.getDaifaSellerId();


        TreeMap<MarketBean, TreeMap<MarketBean, TreeMap<MarketBean, MarketBean>>> treeTree;//市场楼层档口，只有获取市场列表时更新
        treeTree = new TreeMap<>();


        List<GgoodsByStore> ggoodsByStores = daifaGgoodsTasksMapper.selDaifaGoodsGroupByShop(sellerId);

        TreeMap<MarketBean, TreeMap<MarketBean, MarketBean>> floorMap = new TreeMap<>();
        for (GgoodsByStore ggoodsByStore : ggoodsByStores) {
            MarketBean floorkey = new MarketBean();
            floorkey.setId(ggoodsByStore.getFloorId());
            floorkey.setType(1);//楼层
            floorkey.setName(ggoodsByStore.getFloorName());
            TreeMap<MarketBean, MarketBean> storeMap = floorMap.get(floorkey);
            if (storeMap == null) {
                storeMap = new TreeMap<>();
                floorMap.put(floorkey,storeMap);
            }else{
                //更新key
                MarketBean marketBean = floorMap.ceilingKey(floorkey);
                marketBean.setNum(marketBean.getNum()+floorkey.getNum());
                //floorMap.ceilingKey()
            }
            MarketBean store = new MarketBean();
            store.setName(ggoodsByStore.getStoreNum());
            store.setId(ggoodsByStore.getStoreId());
            store.setType(2);
            store.setNum(ggoodsByStore.getGoodsNum());
            storeMap.put(store, store);
        }


    }
}
