package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShiguActivity;
import com.opentae.data.mall.beans.ShiguActivityApply;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.examples.ShiguActivityExample;
import com.opentae.data.mall.interfaces.ShiguActivityApplyMapper;
import com.opentae.data.mall.interfaces.ShiguActivityMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.activity.enums.ActivityStatus;
import com.shigu.main4.activity.services.ShiguActivityService;
import com.shigu.main4.activity.vo.ShiguActivityApplyVO;
import com.shigu.main4.activity.vo.ShiguActivityVO;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.vo.ActivityDetailsVo;
import com.shigu.seller.vo.ActivityListVO;
import com.shigu.seller.vo.ApplyItemVO;
import com.shigu.seller.vo.GfShowVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 港风活动报名
 * Created by bugzy on 2017/6/30 0030.
 */
@Service
public class ActivityService {

    @Autowired
    private ShiguActivityMapper shiguActivityMapper;

    @Autowired
    private ShiguActivityApplyMapper shiguActivityApplyMapper;

    @Autowired
    private ShopForCdnService shopForCdnService;

    @Autowired
    private ShiguShopMapper shiguShopMapper;


    private static final String DATE_FORMAT_PATTERN = "yyyy.MM.dd";

    public List<ActivityListVO> selAllActivities(Long userId, String webSite) {
        // 已参加的活动
        ShiguActivityApply apply = new ShiguActivityApply();
        apply.setUserId(userId);
        List<ShiguActivityApply> select = shiguActivityApplyMapper.select(apply);
        Map<Long, ShiguActivityApply> applyMap = new HashMap<>();

        // 分拣用户申请，每个活动取一个活动的申请，活动的申请意思是 除 choose = 2 以外的其他申请为活动的申请，如果没有其他申请，那么取最后一个被拒的申请做活动的申请
        // 同一个活动的申请，只会有一个 choose != 2 的申请， 反之有多个
        for (ShiguActivityApply activityApply : select) {
            ShiguActivityApply shiguActivityApply = applyMap.get(activityApply.getActivityId());
            if (shiguActivityApply == null || activityApply.getChoose() != 2) {
                applyMap.put(activityApply.getActivityId(), activityApply);
            }
        }

        // 兼容 多个商品ID的情况，取得第一个有效的ID
        List<Long> itemIds = new ArrayList<>();
        for (String items : BeanMapper.getFieldList(new ArrayList<>(applyMap.values()), "items", String.class)) {
            Long itemId;
            for (String s : items.split(",")) {
                try {
                    itemId = Long.valueOf(s);
                    itemIds.add(itemId);
                } catch (NumberFormatException ignored){
                }
            }
        }
        Map<Long, ItemShowBlock> showBlockMap = Collections.emptyMap();
        if (!itemIds.isEmpty()) {
            showBlockMap = BeanMapper.list2Map(
                    shopForCdnService.searchItemOnsale(itemIds, webSite, 1, itemIds.size()).getContent(),
                    "itemId",
                    Long.class);
        }

        ShiguActivityExample t = new ShiguActivityExample();
        t.setOrderByClause("end_time desc");
        List<ShiguActivity> activities = shiguActivityMapper.selectByExample(t);
        List<ActivityListVO> activityListVOS = new ArrayList<>(activities.size());
        for (ShiguActivityVO activity : BeanMapper.mapList(activities, ShiguActivityVO.class)) {
            ActivityListVO vo = new ActivityListVO();
            activityListVOS.add(vo);
            vo.setActid(activity.getActivityId());
            vo.setActTitle(activity.getTitle());
            vo.setActEndTime(DateUtil.dateToString(activity.getEndTime(), DATE_FORMAT_PATTERN));
            vo.setActStartTime(DateUtil.dateToString(activity.getStartTime(), DATE_FORMAT_PATTERN));
            vo.setActImg(activity.getImage());
            vo.setActNums(activity.getNums());
            vo.setApplyTime(
                    DateUtil.dateToString(activity.getStartApply(), DATE_FORMAT_PATTERN)
                            + "-"
                            + DateUtil.dateToString(activity.getEndApply(), DATE_FORMAT_PATTERN));
            vo.setApplyRange(activity.getRuleInfo());
            vo.setChargeStyle(activity.getCostDesc());
            vo.setSupportReturn(activity.getServices().contains("1"));
            vo.setSupportBarter(activity.getServices().contains("2"));

            vo.setHdStatus(activity.getStatus().status);
            ShiguActivityApply activityApply = applyMap.get(activity.getActivityId());
            if (activityApply != null) {
                for (String s : activityApply.getItems().split(",")) {
                    ItemShowBlock itemShowBlock;
                    try {
                        itemShowBlock = showBlockMap.get(Long.valueOf(s));
                    } catch (NumberFormatException ignored) {
                        continue;
                    }
                    if (itemShowBlock != null) {
                        vo.setGoodsImgSrc(itemShowBlock.getImgUrl());
                    }
                }
                vo.setSqStatus(activityApply.getChoose());
            }
        }
        return activityListVOS;
    }

    public ActivityDetailsVo selActivityDetails(Long actid) {
        ActivityDetailsVo vo = new ActivityDetailsVo();
        ShiguActivity activity = shiguActivityMapper.selectByPrimaryKey(actid);
        vo.setActImg(activity.getImage());
        vo.setActStartTime(DateUtil.dateToString(activity.getStartTime(), DATE_FORMAT_PATTERN));
        vo.setActEndTime(DateUtil.dateToString(activity.getEndTime(), DATE_FORMAT_PATTERN));
        vo.setActTitle(activity.getTitle());
        vo.setActPosition("首页");
        vo.setApplyRange(activity.getRuleInfo());
        vo.setApplyCondition(activity.getDescInfo());
        vo.setChargeStyle(activity.getCostDesc());
        return vo;
    }

    public List<ApplyItemVO> applyItems(Long actid, Long userId) {
        List<ApplyItemVO> list = new ArrayList<>();

        List<Long> itemIds;
        ShiguActivityApplyVO applyVO = activity(actid).someOneApply(userId);
        if (applyVO != null && !(itemIds = applyVO.getItemIds()).isEmpty()) {
            List<ItemShowBlock> items = shopForCdnService.searchItemOnsale(itemIds, "hz", 1, 5).getContent();
            Map<Long, ShopNumAndMarket> marketMap = BeanMapper.list2Map(
                    shiguShopMapper.selShopNumAndMarkets(
                        new ArrayList<>(
                                BeanMapper.getFieldSet(
                                        items,
                                        "shopId",
                                        Long.class)
                        )),
                        "shopId",
                        Long.class
            );
            for (ItemShowBlock hz : items) {
                ApplyItemVO vo = new ApplyItemVO();
                list.add(vo);
                vo.setItemId(hz.getItemId());
                vo.setImgUrl(hz.getImgUrl());
                vo.setTitle(hz.getTitle());
                vo.setPrice(hz.getPrice());
                ShopNumAndMarket shopNumAndMarket = marketMap.get(hz.getShopId());
                if (shopNumAndMarket != null) {
                    vo.setMarketName(shopNumAndMarket.getMarket() + " " + shopNumAndMarket.getShopNum());
                }
            }
        }
        return list;
    }

    public void submitApply(Long actid, Long shopId, Long userId, List<String> activityInfo, String phoneInfo) throws JsonErrException {
        if (actid == null || activityInfo == null || phoneInfo == null || shiguActivityMapper.selectByPrimaryKey(actid) == null) {
            throw new JsonErrException("活动申请信息不全");
        }
        if (userId == null || shopId == null) {
            throw new JsonErrException("用户没有权限参加此项活动");
        }

        ShiguActivityApplyVO vo = new ShiguActivityApplyVO();
        vo.setPhone(phoneInfo);
        vo.setShopId(shopId);
        vo.setUserId(userId);
        vo.setItemIds(new ArrayList<Long>());
        for (String s : activityInfo) {
            int i = s.indexOf("=");
            if (i != -1) {
                try {
                    vo.getItemIds().add(Long.valueOf(s.substring(i + 1)));
                } catch (NumberFormatException ignored){}
            }
        }
        if (vo.getItemIds().size() == 0) {
            throw new JsonErrException("商品信息不完善");
        }
        try {
            activity(actid).apply(vo);
        } catch (Exception e) {
            throw new JsonErrException("您已经申请过了");
        }
    }

    private ShiguActivityService activity(Long actid) {
        return SpringBeanFactory.getBean(ShiguActivityService.class, actid);
    }

    public List<GfShowVO> gfShow(Long id) throws Main4Exception {
        List<GfShowVO> vos = new ArrayList<>();
        List<Long> itemIds = new ArrayList<>();
        ShiguActivityService activityService = activity(id);
        for (ShiguActivityApplyVO vo : activityService.luckyDogs()) {
            itemIds.addAll(vo.getItemIds());
        }
        String services = activityService.info().getServices();
        int sum = 0;
        try {
            if (StringUtils.isNotEmpty(services))
                for (String s : services.split(","))
                    sum += Integer.valueOf(s);
        } catch (NumberFormatException ignored){}
        if (!itemIds.isEmpty()) {
            List<ItemShowBlock> items = shopForCdnService.searchItemOnsale(itemIds, "hz", 1, itemIds.size()).getContent();
            Map<Long, ShopNumAndMarket> marketMap = Collections.emptyMap();
            if (!items.isEmpty()) {
                marketMap = BeanMapper.list2Map(
                        shiguShopMapper.selShopNumAndMarkets(
                                new ArrayList<>(
                                        BeanMapper.getFieldSet(
                                                items,
                                                "shopId",
                                                Long.class)
                                )),
                        "shopId",
                        Long.class
                );
            }
            for (ItemShowBlock hz : items) {
                GfShowVO vo = new GfShowVO();
                vos.add(vo);
                vo.setGoodsId(hz.getItemId());
                vo.setShopId(hz.getShopId());
                vo.setImgSrc(hz.getImgUrl());
                vo.setTitle(hz.getTitle());
                vo.setPiPriceString(hz.getPrice());
                vo.setShStatus(sum);
                ShopNumAndMarket shopNumAndMarket = marketMap.get(hz.getShopId());
                if (shopNumAndMarket != null) {
                    vo.setMarketName(shopNumAndMarket.getMarket());
                    vo.setShopNum(shopNumAndMarket.getShopNum());
                }
            }
        }
        return vos;
    }

    private enum ActivityEnum {
        GF("港风", 1),;

        public String name;
        public Long activityId;
        ActivityEnum(String name, long activityId) {
            this.name = name;
            this.activityId = activityId;
        }
    }
}
