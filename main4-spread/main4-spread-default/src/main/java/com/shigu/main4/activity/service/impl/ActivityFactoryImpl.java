package com.shigu.main4.activity.service.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.SpreadActivity;
import com.opentae.data.mall.beans.SpreadTerm;
import com.opentae.data.mall.examples.SpreadTermExample;
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

import java.util.Date;
import java.util.List;

/**
 * 活动工厂
 * Created by zhaohongbo on 17/5/4.
 */
@Service
public class ActivityFactoryImpl implements ActivityFactory{
    @Autowired
    SpreadActivityMapper spreadActivityMapper;

    @Autowired
    SpreadEnlistMapper spreadEnlistMapper;

    @Autowired
    SpreadTermMapper spreadTermMapper;

    @Override
    public ActivityTerm addAndGetTerm(ActivityTermVO vo) throws ActivityException {
        //验证是否可加,如果同一类别活动,时间上有重叠,视为加失败
        SpreadTermExample termExample=new SpreadTermExample();
        termExample.createCriteria().andEndTimeGreaterThan(vo.getStartTime()).andTypeEqualTo(vo.getActivityType().ordinal());
        termExample.or().andStartTimeLessThan(vo.getEndTime()).andTypeEqualTo(vo.getActivityType().ordinal());
        if(spreadTermMapper.countByExample(termExample)>0){
            throw new ActivityException("本类活动,与上一期时间上有重叠");
        }
        SpreadTerm term=BeanMapper.map(vo,SpreadTerm.class);
        term.setType(vo.getActivityType().ordinal());
        spreadTermMapper.insertSelective(term);
        ActivityTerm at=selTermWithFunc();
        at.setStartTime(term.getStartTime());
        at.setEndTime(term.getEndTime());
        at.setTermId(term.getTermId());
        at.setActivityType(ActivityType.values()[term.getType()]);
        return at;
    }

    @Override
    public ActivityTerm selTermByTime(ActivityType type, Date time) {
        //查出当前一期的ID
        SpreadTermExample example=new SpreadTermExample();
        example.createCriteria().andTypeEqualTo(type.ordinal()).andStartTimeLessThanOrEqualTo(time)
                .andEndTimeGreaterThanOrEqualTo(time);
        example.setStartIndex(0);
        example.setEndIndex(1);
        List<SpreadTerm> terms=spreadTermMapper.selectFieldsByConditionList(example, FieldUtil.codeFields("term_id"));
        if(terms.size()>0){
            return selTermById(terms.get(0).getTermId());
        }
        return null;
    }

    @Override
    public ActivityTerm selTermById(Long termId) {
        if (termId == null) {
            return null;
        }
        SpreadTerm sterm=new SpreadTerm();
        sterm.setTermId(termId);
        sterm=spreadTermMapper.selectOne(sterm);
        if (sterm == null) {
            return null;
        }
        ActivityTerm term=selTermWithFunc();
        BeanMapper.map(sterm,term);
        return term;
    }

    /**
     * 期次拥有的方法
     * @return 带方法但没数据的期次
     */
    private ActivityTerm selTermWithFunc(){
        return new ActivityTerm() {
            @Override
            public <T extends ActivityVO> Long throwActivity(T activity) {
                //防止数据有变,通通用本活动的ID,不管有没有传入
                activity.setTermId(this.getTermId());

                SpreadActivity sactivity=BeanMapper.map(activity,SpreadActivity.class);
                sactivity.setContext(JSON.toJSONString(activity));
                sactivity.setActivityId(null);
                spreadActivityMapper.insertSelective(sactivity);
                return sactivity.getActivityId();
            }
        };
    }

    @Override
    public <T extends Activity> T selActivityById(Long activityId) {
        return null;
    }

    /**
     * led功能对你赋能
     * @return
     */
    private LedActivity selLedActivityWithFunc(){
        return new LedActivity() {
            @Override
            public boolean limit(Object... param) {
                return (Long)(param[0])==1087L;
            }

            @Override
            public Long joinActivity(Long userId, Long shopId, String name, String phone) {
                System.out.println(shopId);
                return null;
            }

            @Override
            public List<ActivityEnlistVO> randomHit(Integer number) {
                return null;
            }

            @Override
            public List<ActivityEnlistVO> selEnlist(int hitType) {
                return null;
            }
        };
    }

    /**
     * 广告报名对象赋能
     * @return
     */
    private GoatActivity selGoatActivityWithFunc(){
        return new GoatActivity() {

            @Override
            public boolean limit(Object... param) {
                return false;
            }

            @Override
            public Long joinActivity(Long userId, Long shopId, String name, String phone) {
                return null;
            }

            @Override
            public List<ActivityEnlistVO> randomHit(Integer number) {
                return null;
            }

            @Override
            public List<ActivityEnlistVO> selEnlist(int hitType) {
                return null;
            }
        };
    }

    @Override
    public <T extends Activity> T selActivityByVo(ActivityVO vo) {
        return null;
    }

    @Override
    public ActivityEnlist selEnlistById(Long enlistId) {
        return null;
    }

    @Override
    public ActivityEnlist selEnlistByVo(ActivityEnlistVO vo) {
        return null;
    }
}
