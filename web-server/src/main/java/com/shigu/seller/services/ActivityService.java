package com.shigu.seller.services;

import com.opentae.data.mall.beans.ShiguActivity;
import com.opentae.data.mall.beans.ShiguActivityApply;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.ShiguActivityApplyMapper;
import com.opentae.data.mall.interfaces.ShiguActivityMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.activity.enums.ActivityStatus;
import com.shigu.main4.activity.services.ShiguActivityService;
import com.shigu.main4.activity.vo.ShiguActivityApplyVO;
import com.shigu.main4.activity.vo.ShiguActivityVO;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.tools.SpringBeanFactory;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.vo.ActivityDetailsVo;
import com.shigu.seller.vo.ActivityListVO;
import com.shigu.seller.vo.ApplyItemVO;
import com.shigu.seller.vo.GfShowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<ActivityListVO> selAllActivities(Long userId) {
        // 已参加的活动
        ShiguActivityApply apply = new ShiguActivityApply();
        apply.setUserId(userId);
        List<ShiguActivityApply> select = shiguActivityApplyMapper.select(apply);
        Map<Long, ShiguActivityApply> applyMap = BeanMapper.list2Map(select, "activityId", Long.class);

        ShiguActivity t = new ShiguActivity();
        List<ShiguActivity> activities = shiguActivityMapper.select(t);
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

            vo.setHdStatus(activity.getStatus() != ActivityStatus.ACTIVITY_CLOSED);
            ShiguActivityApply activityApply = applyMap.get(activity.getActivityId());
            if (activityApply != null) {
                vo.setSqStatus(activityApply.getChoose() ? 2 : 1);
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

    public void submitApply(Long actid, Long shopId, Long userId, String activityInfo, String phoneInfo) throws JsonErrException {
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
        try {
            activity(actid).apply(vo);
        } catch (Exception e) {
            throw new JsonErrException("您已经申请过了");
        }
    }

    private ShiguActivityService activity(Long actid) {
        return SpringBeanFactory.getBean(ShiguActivityService.class, actid);
    }

    public List<GfShowVO> gfShow() {
        List<GfShowVO> vos = new ArrayList<>();
        List<Long> itemIds = new ArrayList<>();
        for (ShiguActivityApplyVO vo : activity(ActivityEnum.GF.activityId).luckyDogs()) {
            itemIds.addAll(vo.getItemIds());
        }
        if (!itemIds.isEmpty()) {
            List<ItemShowBlock> items = shopForCdnService.searchItemOnsale(itemIds, "hz", 1, itemIds.size()).getContent();
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
                GfShowVO vo = new GfShowVO();
                vos.add(vo);
                vo.setGoodsId(hz.getItemId());
                vo.setShopId(hz.getShopId());
                vo.setImgSrc(hz.getImgUrl());
                vo.setTitle(hz.getTitle());
                vo.setPiPriceString(hz.getPrice());
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
