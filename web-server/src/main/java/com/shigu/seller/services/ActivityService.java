package com.shigu.seller.services;

import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguActivityExample;
import com.opentae.data.mall.interfaces.*;
import com.opentae.data.mall.interfaces.ShiguActivityApplyMapper;
import com.opentae.data.mall.interfaces.ShiguActivityMapper;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.shigu.main4.active.enums.ApplyStatus;
import com.shigu.main4.active.process.ShiguActivityProcess;
import com.shigu.main4.active.vo.ShiguActivityApplyVO;
import com.shigu.main4.active.vo.ShiguActivityVO;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.vo.ItemShowBlock;
import com.shigu.seller.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

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

    @Autowired
    private ShiguActivityProcess shiguActivityProcess;

    @Autowired
    private ShiguActivityApproveMapper shiguActivityApproveMapper;

    @Autowired
    private ShiguActivityCategoryMapper shiguActivityCategoryMapper;

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
        t.createCriteria().andWebSiteEqualTo(webSite);
        List<ShiguActivity> activities = shiguActivityMapper.selectByExample(t);
        List<ActivityListVO> activityListVOS = new ArrayList<>(activities.size());
        for (ShiguActivityVO activity : BeanMapper.mapList(activities, ShiguActivityVO.class)) {
            ActivityListVO vo = new ActivityListVO();
            activityListVOS.add(vo);
            vo.setActid(activity.getActivityId());
            vo.setActTitle(activity.getTitle());
            vo.setActEndTime(pickTime(activity.getEndTime()));
            vo.setActStartTime(pickTime(activity.getStartTime()));
            vo.setActImg(activity.getImage());
            vo.setActNums(activity.getNums());
            vo.setApplyTime(
                    pickTime(activity.getStartApply())
                            + "-"
                            + pickTime(activity.getEndApply()));
            vo.setApplyRange(activity.getRuleInfo());
            vo.setChargeStyle(activity.getCostDesc());
            String services = activity.getServices();
            vo.setQualif(new ArrayList<ActivityQualifVO>());
            if (StringUtils.isNotEmpty(services)) {
                for (String s : services.split(";")) {
                    String[] split = s.split(":");
                    if (split.length == 2) {
                        vo.getQualif().add(new ActivityQualifVO(split[0], split[1].equals("1")));
                    }
                }
            }

            vo.setHdStatus(activity.getApplyStatus() == ApplyStatus.APPLY_NOT_BEGUN ? 0 : activity.getStatus().status);
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

    private String pickTime(Date date) {
        return date == null ? "待定" : DateUtil.dateToString(date, DATE_FORMAT_PATTERN);
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
        ShiguActivityApplyVO applyVO = shiguActivityProcess.someOneApply(actid,userId);
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

    private static final Pattern ITEM_PATTERN = Pattern.compile("http(s)?://(hz|gz|cs|jx|ss|bj|wa|www)\\.571xz\\.com/item\\.htm\\?id=(\\d)+");

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
            if (!ITEM_PATTERN.matcher(s).matches()) {
                throw new JsonErrException("必须是星座网商品");
            }
            vo.getItemIds().add(Long.valueOf(s.substring(s.indexOf("=") + 1)));
        }
        if (vo.getItemIds().size() == 0) {
            throw new JsonErrException("商品信息不完善");
        } else {
            ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(shopId);
            for (ItemShowBlock itemShowBlock :
                    shopForCdnService.searchItemOnsale(vo.getItemIds(), shiguShop.getWebSite(), 1, vo.getItemIds().size())
                    .getContent()) {
                if (!shopId.equals(itemShowBlock.getShopId())) {
                    throw new JsonErrException("必须是自己店铺的商品");
                }
            }
        }
        try {
            shiguActivityProcess.apply(actid,vo);
        } catch (Exception e) {
            throw new JsonErrException("申请出错.");
        }
    }

    /**
     * 活动信息
     * @param id
     * @return
     */
    public ShiguActivityVO activityInfo(Long id){
        return shiguActivityProcess.info(id);
    }

    public List<GfGoodsStyleVO> gfShow(Long id) throws Main4Exception {
        List<GfGoodsStyleVO> fGoodsStyleList = new ArrayList<>();
        List<Long> itemIds = new ArrayList<>();
        for (ShiguActivityApplyVO vo : shiguActivityProcess.luckyDogs(id)) {
            itemIds.addAll(vo.getItemIds());
        }
        String services = shiguActivityProcess.info(id).getServices();
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

            Map<Long, List<GfShowVO>> cateShowMap = new HashMap<>();
            for (ItemShowBlock hz : items) {
                GfShowVO vo = new GfShowVO();
                vo.setGoodsId(hz.getItemId());
                vo.setShopId(hz.getShopId());
                vo.setImgSrc(hz.getImgUrl());
                vo.setTitle(hz.getTitle());
                vo.setPiPriceString(hz.getPrice());
                vo.setShStatus(sum);

                ShiguActivityApprove approve = new ShiguActivityApprove();
                approve.setActivityId(id);
                approve.setItem(String.valueOf(hz.getItemId()));
                List<ShiguActivityApprove> approveList = shiguActivityApproveMapper.select(approve);
                if (approveList.size() != 1) {
//                    throw new Main4Exception("根据条件查找approve表里面的商品cateid数据有误：activityid="+id + "; itemId=" + hz.getItemId());
                    continue;
                }
                approve = approveList.get(0);
                vo.setGoodsStyleId(approve.getCateId());

                ShopNumAndMarket shopNumAndMarket = marketMap.get(hz.getShopId());
                if (shopNumAndMarket != null) {
                    vo.setMarketName(shopNumAndMarket.getMarket());
                    vo.setShopNum(shopNumAndMarket.getShopNum());
                }

                if (!cateShowMap.containsKey(vo.getGoodsStyleId())) {
                    List<GfShowVO> gfShowVoList = new ArrayList();
                    gfShowVoList.add(vo);
                    cateShowMap.put(vo.getGoodsStyleId(), gfShowVoList);
                } else {
                    cateShowMap.get(vo.getGoodsStyleId()).add(vo);
                }
            }


            for (Map.Entry<Long, List<GfShowVO>> item : cateShowMap.entrySet()) {
                ShiguActivityCategory shiguActivityCategory  = new ShiguActivityCategory();
                shiguActivityCategory.setCateId(item.getKey());
                shiguActivityCategory = shiguActivityCategoryMapper.selectOne(shiguActivityCategory);

                GfGoodsStyleVO gfGoodsStyleVO = new GfGoodsStyleVO();
                gfGoodsStyleVO.setId(shiguActivityCategory.getCateId());
                gfGoodsStyleVO.setTitleText(shiguActivityCategory.getTitle());
                gfGoodsStyleVO.setTitleImg(shiguActivityCategory.getTitleImg());
                gfGoodsStyleVO.setGoodsList(item.getValue());
                fGoodsStyleList.add(gfGoodsStyleVO);
            }
        }
        fGoodsStyleList.sort(new GfGoodsStyleVOCompatar());
        return fGoodsStyleList;
    }
    /**
     * 活动页面类目排序
     * todo 没有特别做过校验
     */
    class GfGoodsStyleVOCompatar implements Comparator<GfGoodsStyleVO> {
        @Override
        public int compare(GfGoodsStyleVO o1, GfGoodsStyleVO o2) {
            return (int)(o1.getId() - o2.getId());
        }
    }
}
