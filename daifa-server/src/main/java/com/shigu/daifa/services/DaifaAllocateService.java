package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
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
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

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
    private static List<GgoodsByStore> allocateHouse;
    private DaifaGgoodsTasksMapper daifaGgoodsTasksMapper;

    @Autowired
    public void setDaifaGgoodsTasksMapper(DaifaGgoodsTasksMapper daifaGgoodsTasksMapper) {
        this.daifaGgoodsTasksMapper = daifaGgoodsTasksMapper;
    }

    private TakeGoodsIssueProcess takeGoodsIssueProcess;

    @Autowired
    public void setTakeGoodsIssueProcess(TakeGoodsIssueProcess takeGoodsIssueProcess) {
        this.takeGoodsIssueProcess = takeGoodsIssueProcess;
    }

    public List<OrderAllocateVO> orderAllcoation(OrderAllocateBO bo) {
        AuthorityUser user = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Long daifaSellerId = user.getDaifaSellerId();
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        DaifaGgoodsTasksExample.Criteria criteria = daifaGgoodsTasksExample.createCriteria();
        criteria.andUseStatusEqualTo(1).andAllocatStatusEqualTo(0).andSellerIdEqualTo(daifaSellerId);//可用的未分配的
        if (!StringUtils.isEmpty(bo.getChildOrderId())) {
            criteria.andDfOrderIdEqualTo(bo.getChildOrderId());
        }
        if (!StringUtils.isEmpty(bo.getOrderId())) {
            criteria.andDfTradeIdLike("%" + bo.getOrderId());
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
        //生成可分配档口
        makeMarket();

        TreeMap<MarketBean, MarketBean> marketMap = new TreeMap<>();
        for (GgoodsByStore ggoodsByStore : allocateHouse) {
            MarketBean key = new MarketBean();
            key.setName(ggoodsByStore.getMarketName());
            key.setId(ggoodsByStore.getMarketId());
            key.setOrderNumber(ggoodsByStore.getGoodsNum());
            key.setType(0);//市场
            MarketBean bean = marketMap.get(key);
            if (bean == null) {
                marketMap.put(key, key);
            } else {
                bean.setOrderNumber(bean.getOrderNumber() + key.getOrderNumber());
            }

        }
        List<MarketBean> marketBeanList = new ArrayList<>(marketMap.keySet());
        return JsonResponseUtil.success().element("marketList", marketBeanList);
    }

    private void makeMarket() {
        AuthorityUser user = (AuthorityUser) SecurityUtils.getSubject().getSession().getAttribute(DaifaSessionConfig.DAIFA_SESSION);
        Long sellerId = user.getDaifaSellerId();
        allocateHouse = daifaGgoodsTasksMapper.selDaifaGoodsGroupByShop(sellerId);


    }

    public static void main(String[] args) {
        TreeMap<MarketBean, MarketBean> map = new TreeMap<>();
        MarketBean bean = new MarketBean();
        bean.setId(10L);
        bean.setType(1);
        bean.setName("我的");
        map.put(bean, bean);
        MarketBean bean1 = new MarketBean();
        bean1.setId(10L);
        bean1.setType(1);
        MarketBean bean2 = map.ceilingKey(bean1);
        bean2.setName("卧槽");
        Iterator<Map.Entry<MarketBean, MarketBean>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<MarketBean, MarketBean> next = iterator.next();
            System.out.println(next.getKey().getName());
        }

    }

    public JSONObject getFloorList(Long marketId) {
        if (allocateHouse == null) {
            makeMarket();
        }
        TreeMap<MarketBean, MarketBean> floorMap = new TreeMap<>();
        for (GgoodsByStore ggoodsByStore : allocateHouse) {
            if (ggoodsByStore.getMarketId().longValue() == marketId) {
                MarketBean key = new MarketBean();
                key.setType(1);
                key.setId(ggoodsByStore.getFloorId());
                key.setName(ggoodsByStore.getFloorName());
                key.setOrderNumber(ggoodsByStore.getGoodsNum());
                MarketBean floorBean = floorMap.get(key);
                if (floorBean == null) {
                    floorMap.put(key, key);
                } else {
                    floorBean.setOrderNumber(floorBean.getOrderNumber() + key.getOrderNumber());
                }
            }
        }
        List<MarketBean> floorList = new ArrayList<>(floorMap.keySet());
        return JsonResponseUtil.success().element("floorList", floorList);
    }

    public JSONObject getShopList(Long floorId) {
        if (allocateHouse == null) {
            makeMarket();
        }
        TreeMap<MarketBean, MarketBean> storeMap = new TreeMap<>();
        for (GgoodsByStore ggoodsByStore : allocateHouse) {
            if (ggoodsByStore.getFloorId().longValue() == floorId) {
                MarketBean key = new MarketBean();
                key.setType(2);
                key.setId(ggoodsByStore.getStoreId());
                key.setName(ggoodsByStore.getStoreNum());
                key.setOrderNumber(ggoodsByStore.getGoodsNum());
                MarketBean floorBean = storeMap.get(key);
                if (floorBean == null) {
                    storeMap.put(key, key);
                } else {
                    floorBean.setOrderNumber(floorBean.getOrderNumber() + key.getOrderNumber());
                }
            }
        }
        List<MarketBean> storeList = new ArrayList<>(storeMap.keySet());
        return JsonResponseUtil.success().element("shopList", storeList);
    }

    public JSONObject submitAllocation(Long userId, String type, String ids) throws DaifaException {
        String[] idsArray = ids.split(",");
        switch (type) {
            case "market": {

                for (String s : idsArray) {
                    takeGoodsIssueProcess.distributionTaskWithMarket(userId, Long.parseLong(s));
                }
                break;
            }
            case "floor": {
                for (String s : idsArray) {
                    takeGoodsIssueProcess.distributionTaskWithFloor(userId,Long.parseLong(s));
                }
                break;
            }
            case "shop":{
                for (String s : idsArray) {
                    takeGoodsIssueProcess.distributionTaskWithShop(userId,Long.parseLong(s));
                }
                break;
            }
            case "childOrder":{
                List<Long> childOrderIds = new ArrayList<>();
                List<Long> tasksId = new ArrayList<>();
                for (String s : idsArray) {
                    childOrderIds.add(Long.parseLong(s));
                }
                DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
                daifaGgoodsTasksExample.createCriteria()
                        .andDfOrderIdIn(childOrderIds)//子弹
                        .andUseStatusEqualTo(1)//可用
                        .andAllocatStatusEqualTo(0);//未分配
                List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample
                        , FieldUtil.codeFields("tasks_id"));
                for (DaifaGgoodsTasks ggoodsTask : ggoodsTasks) {
                    tasksId.add(ggoodsTask.getTasksId());
                }
                takeGoodsIssueProcess.distributionTask(userId,tasksId);
                break;
            }
            default:{
                break;
            }
        }
        return JsonResponseUtil.success("分配成功");
    }
}
