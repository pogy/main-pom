package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaGgoods;
import com.opentae.data.daifa.beans.DaifaGgoodsTasks;
import com.opentae.data.daifa.beans.DaifaTrade;
import com.opentae.data.daifa.beans.GgoodsByStore;
import com.opentae.data.daifa.examples.DaifaGgoodsExample;
import com.opentae.data.daifa.examples.DaifaGgoodsTasksExample;
import com.opentae.data.daifa.examples.DaifaTradeExample;
import com.opentae.data.daifa.interfaces.DaifaGgoodsMapper;
import com.opentae.data.daifa.interfaces.DaifaGgoodsTasksMapper;
import com.opentae.data.daifa.interfaces.DaifaTradeMapper;
import com.shigu.component.shiro.AuthorityUser;
import com.shigu.config.DaifaSessionConfig;
import com.shigu.daifa.beans.MarketBean;
import com.shigu.daifa.bo.OrderAllocateBO;
import com.shigu.daifa.vo.OrderAllocateVO;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.TakeGoodsIssueProcess;
import com.shigu.main4.order.process.QimenTradeProcess;
import com.shigu.tools.JsonResponseUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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
    private DaifaGgoodsMapper daifaGgoodsMapper;

    private DaifaTradeMapper daifaTradeMapper;
    @Autowired
    QimenTradeProcess qimenTradeProcess;

    @Autowired
    public void setDaifaTradeMapper(DaifaTradeMapper daifaTradeMapper) {
        this.daifaTradeMapper = daifaTradeMapper;
    }

    @Autowired
    public void setDaifaGgoodsTasksMapper(DaifaGgoodsTasksMapper daifaGgoodsTasksMapper) {
        this.daifaGgoodsTasksMapper = daifaGgoodsTasksMapper;
    }

    private TakeGoodsIssueProcess takeGoodsIssueProcess;

    @Autowired
    public void setTakeGoodsIssueProcess(TakeGoodsIssueProcess takeGoodsIssueProcess) {
        this.takeGoodsIssueProcess = takeGoodsIssueProcess;
    }

    public List<OrderAllocateVO> orderAllcoation(OrderAllocateBO bo, Long sellerId) {
        DaifaGgoodsTasksExample daifaGgoodsTasksExample = new DaifaGgoodsTasksExample();
        DaifaGgoodsTasksExample.Criteria criteria = daifaGgoodsTasksExample.createCriteria();
        criteria.andUseStatusEqualTo(1).andAllocatStatusEqualTo(0).andSellerIdEqualTo(sellerId).andEndStatusEqualTo(0)
                .andGoodsCodeIsNotNull()
                .andCustomSql("(youhuo_date is null or (if(youhuo_date is not null, " +
                        "date_format(youhuo_date,'%Y%m%d')-create_date<=0 or date_format(now(),'%Y%m%d')-create_date>0,true)))");//可用的未分配的
        if (!StringUtils.isEmpty(bo.getChildOrderId())) {
            criteria.andDfOrderIdEqualTo(bo.getChildOrderId());
        }
        if (!StringUtils.isEmpty(bo.getOrderId())) {
            criteria.andDfTradeIdLike("%" + bo.getOrderId());
        }
        if (StringUtils.hasText(bo.getStartTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getIsStartTime (DateUtil.stringToDate(bo.getStartTime(),"yyyy-MM-dd")));
        }
        if (StringUtils.hasText(bo.getEndTime())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtil.getIsEndTime (DateUtil.stringToDate(bo.getEndTime(),"yyyy-MM-dd")));
        }
        if (StringUtils.isEmpty(bo.getPage())) {
            bo.setPage("1");
        }
        int count = daifaGgoodsTasksMapper.countByExample(daifaGgoodsTasksExample);
        bo.setCount(count);
        List<OrderAllocateVO> orderAllocateVOS = new ArrayList<>();
        if(count>0){
            daifaGgoodsTasksExample.setOrderByClause("create_time desc");
            int page = Integer.parseInt(bo.getPage());
            int rows = 10;
            daifaGgoodsTasksExample.setStartIndex((page - 1) * rows);
            daifaGgoodsTasksExample.setEndIndex(rows);
            List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectByConditionList(daifaGgoodsTasksExample);
            if(ggoodsTasks.size()>0){
                List<Long> tids=new ArrayList<>();
                for(DaifaGgoodsTasks t:ggoodsTasks){
                    tids.add(t.getDfTradeId());
                }
                DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
                daifaTradeExample.createCriteria().andDfTradeIdIn(tids);
                List<DaifaTrade> ts=daifaTradeMapper.selectFieldsByExample(daifaTradeExample,FieldUtil.codeFields("df_trade_id,daifa_type"));
                Map<Long,DaifaTrade> tradeMap= BeanMapper.list2Map(ts,"dfTradeId",Long.class);
                for (DaifaGgoodsTasks ggoodsTask : ggoodsTasks) {
                    OrderAllocateVO vo = new OrderAllocateVO();
                    vo.setChildOrderId(ggoodsTask.getDfOrderId());
                    vo.setGoodsNo(ggoodsTask.getGoodsCode());
                    vo.setNum(ggoodsTask.getGoodsNum());
                    vo.setGoodsProperty(ggoodsTask.getPropStr());
                    vo.setImgSrc(ggoodsTask.getPicPath());
                    vo.setPiPrice(ggoodsTask.getSinglePiPrice());
                    vo.setTitle(ggoodsTask.getTitle());
                    vo.setDffs(tradeMap.get(ggoodsTask.getDfTradeId())==null?1:tradeMap.get(ggoodsTask.getDfTradeId()).getDaifaType());
                    orderAllocateVOS.add(vo);
                }
            }
        }
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

  /*  public static void main(String[] args) {


        TreeMap<MarketBean, MarketBean> map = new TreeMap<>();
        MarketBean bean = new MarketBean();
        bean.setId(999L);
        bean.setType(2);
        bean.setName("我的");
        //System.out.println(bean.hashCode());
        map.put(bean, bean);
        MarketBean bean2 = new MarketBean();
        bean2.setId(621L);
        bean2.setType(2);
        bean2.setName("卧槽");
        //System.out.println(bean2.equals(bean) );

        MarketBean marketBean = map.get(bean2);
        //System.out.println(marketBean.getName());
//        MarketBean bean2 = map.ceilingKey(bean);
//        bean2.setName("卧槽");
        Iterator<Map.Entry<MarketBean, MarketBean>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<MarketBean, MarketBean> next = iterator.next();
            //System.out.println(next.getKey().getName());
        }

    }*/

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
        List<String> codes=new ArrayList<>();
        switch (type) {
            case "market": {
                for (String s : idsArray) {
                    codes.add(takeGoodsIssueProcess.distributionTaskWithMarket(userId, Long.parseLong(s)));
                }
                break;
            }
            case "floor": {
                for (String s : idsArray) {
                    codes.add(takeGoodsIssueProcess.distributionTaskWithFloor(userId,Long.parseLong(s)));
                }
                break;
            }
            case "shop":{
                for (String s : idsArray) {
                    codes.add(takeGoodsIssueProcess.distributionTaskWithShop(userId,Long.parseLong(s)));
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
                        .andGoodsCodeIsNotNull()
                        .andUseStatusEqualTo(1)//可用
                        .andEndStatusEqualTo(0)
                        .andAllocatStatusEqualTo(0);//未分配
                List<DaifaGgoodsTasks> ggoodsTasks = daifaGgoodsTasksMapper.selectFieldsByExample(daifaGgoodsTasksExample
                        , FieldUtil.codeFields("tasks_id"));
                if(ggoodsTasks.size()==0){
                    return JsonResponseUtil.error("分配失败,未找到可分配的数据");
                }
                for (DaifaGgoodsTasks ggoodsTask : ggoodsTasks) {
                    tasksId.add(ggoodsTask.getTasksId());
                }
                codes.add(takeGoodsIssueProcess.distributionTask(userId,tasksId));
                break;
            }
            default:{
                break;
            }
        }
        if(codes.size()>0){
            DaifaGgoodsExample daifaGgoodsExample=new DaifaGgoodsExample();
            daifaGgoodsExample.createCriteria().andGgoodsCodeIn(codes);
            List<DaifaGgoods> gs=daifaGgoodsMapper.selectFieldsByExample(daifaGgoodsExample,FieldUtil.codeFields("take_goods_id,df_trade_id"));
            if(gs.size()>0){
                List<Long> tids=gs.stream().map(DaifaGgoods::getDfTradeId).collect(Collectors.toList());
                DaifaTradeExample daifaTradeExample=new DaifaTradeExample();
                daifaTradeExample.createCriteria().andDfTradeIdIn(tids);
                List<DaifaTrade> daifaTrades = daifaTradeMapper
                        .selectFieldsByExample(daifaTradeExample, FieldUtil.codeFields("df_trade_id,trade_code"));
                daifaTrades.forEach(daifaTrade -> {
                    try {
                        qimenTradeProcess.toNotify(new Long(daifaTrade.getTradeCode()));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                });
            }
        }


        return JsonResponseUtil.success("分配成功");
    }
}
