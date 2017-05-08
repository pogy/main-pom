package com.shigu.main4.activity.service.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ShiguShop;
import com.opentae.data.mall.beans.SpreadActivity;
import com.opentae.data.mall.beans.SpreadEnlist;
import com.opentae.data.mall.beans.SpreadTerm;
import com.opentae.data.mall.examples.SpreadEnlistExample;
import com.opentae.data.mall.examples.SpreadTermExample;
import com.opentae.data.mall.interfaces.ShiguShopMapper;
import com.opentae.data.mall.interfaces.SpreadActivityMapper;
import com.opentae.data.mall.interfaces.SpreadEnlistMapper;
import com.opentae.data.mall.interfaces.SpreadTermMapper;
import com.shigu.main4.activity.beans.ActivityEnlist;
import com.shigu.main4.activity.beans.ActivityTerm;
import com.shigu.main4.activity.beans.GoatActivity;
import com.shigu.main4.activity.beans.LedActivity;
import com.shigu.main4.activity.enums.ActivityType;
import com.shigu.main4.activity.exceptions.ActivityException;
import com.shigu.main4.activity.service.Activity;
import com.shigu.main4.activity.service.ActivityFactory;
import com.shigu.main4.activity.vo.ActivityEnlistVO;
import com.shigu.main4.activity.vo.ActivityTermVO;
import com.shigu.main4.activity.vo.ActivityVO;
import com.shigu.main4.common.util.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 活动工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service("activityFactory")
public class ActivityFactoryImpl implements ActivityFactory {
    @Autowired
    SpreadActivityMapper spreadActivityMapper;

    @Autowired
    SpreadEnlistMapper spreadEnlistMapper;

    @Autowired
    SpreadTermMapper spreadTermMapper;
    @Autowired
    ShiguShopMapper shiguShopMapper;


    @Override
    public ActivityTerm addAndGetTerm(ActivityTermVO vo) throws ActivityException {
        //验证是否可加,如果同一类别活动,时间上有重叠,视为加失败
        termTimeCheck(null,vo.getActivityType(),vo.getStartTime(),vo.getEndTime());
        SpreadTerm term = BeanMapper.map(vo, SpreadTerm.class);
        term.setType(vo.getActivityType().ordinal());
        spreadTermMapper.insertSelective(term);
        ActivityTerm at = selTermWithFunc();
        at.setStartTime(term.getStartTime());
        at.setEndTime(term.getEndTime());
        at.setTermId(term.getTermId());
        at.setActivityType(ActivityType.values()[term.getType()]);
        return at;
    }

    /**
     * 期时间重叠验证
     * @param termId 期次ID,排除自己用
     * @param type
     * @param startTime
     * @param endTime
     * @throws ActivityException
     */
    private void termTimeCheck(Long termId,ActivityType type,Date startTime,Date endTime) throws ActivityException {
        //验证是否可加,如果同一类别活动,时间上有重叠,视为加失败
        SpreadTermExample termExample = new SpreadTermExample();
        SpreadTermExample.Criteria cri1=termExample.createCriteria().andEndTimeGreaterThan(startTime)
                .andStartTimeLessThan(startTime).andTypeEqualTo(type.ordinal());
        SpreadTermExample.Criteria cri2=termExample.or().andStartTimeLessThan(endTime).andEndTimeGreaterThan(endTime)
                .andTypeEqualTo(type.ordinal());
        if (termId != null) {
            cri1.andTermIdNotEqualTo(termId);
            cri2.andTermIdNotEqualTo(termId);
        }
        if (spreadTermMapper.countByExample(termExample) > 0) {
            throw new ActivityException("本类活动,与上一期时间上有重叠");
        }
    }

    @Override
    public ActivityTerm selTermByTime(ActivityType type, Date time) {
        //查出当前一期的ID
        SpreadTermExample example = new SpreadTermExample();
        example.createCriteria().andTypeEqualTo(type.ordinal()).andStartTimeLessThanOrEqualTo(time)
                .andEndTimeGreaterThanOrEqualTo(time);
        example.setStartIndex(0);
        example.setEndIndex(1);
        List<SpreadTerm> terms = spreadTermMapper.selectFieldsByConditionList(example, FieldUtil.codeFields("term_id"));
        if (terms.size() > 0) {
            return selTermById(terms.get(0).getTermId());
        }
        return null;
    }

    @Override
    public ActivityTerm selTermById(Long termId) {
        if (termId == null) {
            return null;
        }
        SpreadTerm sterm = new SpreadTerm();
        sterm.setTermId(termId);
        sterm = spreadTermMapper.selectOne(sterm);
        if (sterm == null) {
            return null;
        }
        ActivityTerm term = selTermWithFunc();
        BeanMapper.mapAbstact(sterm, term);
        return term;
    }

    /**
     * 期次拥有的方法
     *
     * @return 带方法但没数据的期次
     */
    private ActivityTerm selTermWithFunc() {
        return new ActivityTerm() {
            @Override
            public <T extends ActivityVO> Long throwActivity(T activity) {
                //防止数据有变,通通用本活动的ID,不管有没有传入
                activity.setTermId(this.getTermId());
                SpreadActivity sactivity = BeanMapper.map(activity, SpreadActivity.class);
                sactivity.setContext(JSON.toJSONString(activity));
                sactivity.setActivityId(null);
                spreadActivityMapper.insertSelective(sactivity);
                return sactivity.getActivityId();
            }

            @Override
            public void modify(ActivityType type, Date start, Date end) throws ActivityException {
                termTimeCheck(this.getTermId(),type,start,end);
                SpreadTerm term=new SpreadTerm();
                term.setTermId(this.getTermId());
                term.setType(type.ordinal());
                term.setStartTime(start);
                term.setEndTime(end);
                spreadTermMapper.updateByPrimaryKeySelective(term);
            }
        };
    }

    @Override
    public <T extends Activity> T selActivityById(Long activityId) throws ActivityException {
        SpreadActivity activity = spreadActivityMapper.selectByPrimaryKey(activityId);
        if (activity == null) {
            throw new ActivityException(activityId + "活动不存在");
        }
        ActivityVO vo= (ActivityVO) JSON.parseObject(activity.getContext(),ActivityType.values()[activity.getType()].getActivityVoClass());
        return selActivityByVo(BeanMapper.map(activity,vo));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Activity> T selActivityByVo(ActivityVO vo) {
        T activity;
        if(vo.getClass().equals(ActivityType.GOAT_SELL.getActivityVoClass())){
            activity= (T) selGoatActivityWithFunc();
        }else{
            activity= (T) selLedActivityWithFunc();
        }
        return BeanMapper.mapAbstact(vo,activity);
    }

    /**
     * led功能对你赋能
     *
     * @return
     */
    private LedActivity selLedActivityWithFunc() {
        return new LedActivity() {
            @Override
            public boolean limit(Object... param) {
                return (Long) (param[0]) == 1087L;
            }

            @Override
            public Long joinActivity(Long userId, Long shopId, String name, String phone) throws ActivityException {
                if (shopId == null) {
                    throw new ActivityException("shopId不能为空");
                }
                ShiguShop ss = shiguShopMapper.selectByPrimaryKey(shopId);
                if (limit(ss.getMarketId())) {
                    throw new ActivityException("不符合活动条件");
                }
                return joinActivityCommon(userId,shopId,name,phone,this.getActivityId());
            }

            @Override
            public List<ActivityEnlistVO> randomHit(Integer number) throws ActivityException {
                Long activityId = this.getActivityId();
                if (activityId == null) {
                    throw new ActivityException("活动Id不存在");
                }
                SpreadEnlistExample seex = new SpreadEnlistExample();
                seex.createCriteria().andActivityIdEqualTo(activityId);
                List<SpreadEnlist> selsit = spreadEnlistMapper.selectByExample(seex);

                if (number > selsit.size()) {
                    throw new ActivityException(activityId + ":数量大于报名人数");
                }
                for (SpreadEnlist enlist : selsit) {
                    if (enlist.getDraw() == 1) {
                        throw new ActivityException(activityId + ":该活动已存在中签数据");
                    }

                }
                //随机选取元素。。
                List<SpreadEnlist> eidSet = new ArrayList<>();
                Random random = new Random();
                for (int i = 0; i < number; i++) {
                    int index = random.nextInt(selsit.size());
                    eidSet.add(selsit.get(index));
                    selsit.remove(index);

                }
                //遍历set更新draw并传出list
                List<ActivityEnlistVO> volist = new ArrayList<>();

                for (SpreadEnlist enlist : eidSet) {
                    ActivityEnlistVO vo = new ActivityEnlistVO();
                    enlist.setDraw(1);
                    spreadEnlistMapper.updateByPrimaryKeySelective(enlist);
                    vo.setActivityId(enlist.getActivityId());
                    vo.setEnId(enlist.getEnlistId());
                    vo.setName(enlist.getName());
                    vo.setShopId(enlist.getShopId());
                    vo.setTelephone(enlist.getTelephone());
                    vo.setUserId(enlist.getUserId());
                    volist.add(vo);

                }

                return volist;
            }

            @Override
            public List<ActivityEnlistVO> selEnlist(int hitType) {
                return selEnlistCommon(this.getActivityId(),hitType);
            }

        };
    }

    /**
     * 广告报名对象赋能
     *
     * @return
     */
    private GoatActivity selGoatActivityWithFunc() {
        return new GoatActivity() {

            @Override
            public boolean limit(Object... param) {
                return false;
            }

            @Override
            public Long joinActivity(Long userId, Long shopId, String name, String phone) throws ActivityException {
                return joinActivityCommon(userId,shopId,name,phone,this.getActivityId());
            }

            @Override
            public List<ActivityEnlistVO> randomHit(Integer number) {
                return null;
            }

            @Override
            public List<ActivityEnlistVO> selEnlist(int hitType) {
                return selEnlistCommon(this.getActivityId(),hitType);
            }

        };
    }

    /**
     * 查询报名列表公共
     * @param activityId
     * @param hitType
     * @return
     */
    private List<ActivityEnlistVO> selEnlistCommon(Long activityId,Integer hitType){
        if (activityId == null) {
            return null;
        }
        SpreadEnlistExample example = new SpreadEnlistExample();
        SpreadEnlistExample.Criteria ce = example.createCriteria().andActivityIdEqualTo(activityId);
        switch (hitType) {
            case 0:
                ce.andDrawEqualTo(0);
                break;
            case 1:
                ce.andDrawEqualTo(1);
                break;
            default:
                break;
        }
        example.setOrderByClause("create_time desc");
        List<SpreadEnlist> selist = spreadEnlistMapper.selectByExample(example);
        List<ActivityEnlistVO> vos = new ArrayList<>();
        for (SpreadEnlist se : selist) {
            ActivityEnlistVO vo = BeanMapper.map(se, ActivityEnlistVO.class);
            vo.setEnId(se.getEnlistId());
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 加入活动公共
     * @param userId
     * @param shopId
     * @param name
     * @param phone
     * @param activityId
     * @return
     * @throws ActivityException
     */
    private Long joinActivityCommon(Long userId, Long shopId, String name, String phone, Long activityId) throws ActivityException {
        if (userId == null) {
            throw new ActivityException("userId不能为空");
        }
        if (shopId == null) {
            throw new ActivityException("shopId不能为空");
        }
        if (name == null || "".equals(name)) {
            throw new ActivityException("name不能为空");
        }
        if (phone == null || "".equals(phone)) {
            throw new ActivityException("phone不能为空");
        }
        SpreadEnlist se = new SpreadEnlist();
        se.setActivityId(activityId);
        se.setUserId(userId);
        se.setTelephone(phone);
        se.setShopId(shopId);
        se.setName(name);
        se.setDraw(0);
        try {
            spreadEnlistMapper.insertSelective(se);
        } catch (RuntimeException e) {
            if (e.getMessage() != null && e.getMessage().contains("Duplicate entry")) {
                throw new ActivityException("重复参加");
            } else {
                throw e;
            }

        }
        return se.getEnlistId();
    }

    @Override
    public ActivityEnlist selEnlistById(Long enlistId) throws ActivityException {
        SpreadEnlist en=spreadEnlistMapper.selectByPrimaryKey(enlistId);
        if(en==null){
            throw new ActivityException(enlistId+" 报名信息不存在");
        }
        return selEnlistByVo(BeanMapper.map(en,ActivityEnlistVO.class));
    }

    @Override
    public ActivityEnlist selEnlistByVo(ActivityEnlistVO vo) {
        ActivityEnlist enlist=new ActivityEnlist() {
            @Override
            public void hit() throws ActivityException {
                if (this.getEnId() == null) {
                    throw new ActivityException("没有EnId");
                }
                SpreadEnlist se = spreadEnlistMapper.selectByPrimaryKey(this.getEnId());
                se.setDraw(1);
                spreadEnlistMapper.updateByPrimaryKey(se);
            }

            @Override
            public void unhit() throws ActivityException {
                if (this.getEnId() == null) {
                    throw new ActivityException("没有EnId");
                }
                SpreadEnlist se = spreadEnlistMapper.selectByPrimaryKey(this.getEnId());
                se.setDraw(0);
                spreadEnlistMapper.updateByPrimaryKey(se);
            }
        };
        return BeanMapper.mapAbstact(vo,enlist);
    }
}
