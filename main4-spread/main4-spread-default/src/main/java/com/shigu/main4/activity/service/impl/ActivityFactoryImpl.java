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
@Service
public class ActivityFactoryImpl implements ActivityFactory{
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
    public <T extends Activity> T selActivityById(Long activityId) throws ActivityException {
        SpreadActivity activity=spreadActivityMapper.selectByPrimaryKey(activityId);
        if(activity==null){
            throw new ActivityException(activityId+"活动不存在");
        }
        if(activity.getType().equals(ActivityType.GOAT_LED.ordinal())){
            return (T)selLedActivityWithFunc();
        }else if(activity.getType().equals(ActivityType.GOAT_SELL.ordinal())){
            return (T)BeanMapper.map(activity,selGoatActivityWithFunc());
        }
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
            public Long joinActivity(Long userId, Long shopId, String name, String phone) throws ActivityException {

                if(userId==null){
                    throw new ActivityException ("userId不能为空");
                }
                if(shopId==null){
                    throw new ActivityException ("shopId不能为空");
                }
                if(name==null||"".equals (name)){
                    throw new ActivityException ("name不能为空");
                }
                if(phone==null||"".equals (phone)){
                    throw new ActivityException ("phone不能为空");
                }

               ShiguShop ss= shiguShopMapper.selectByPrimaryKey (shopId);
               if(limit (ss.getMarketId ())){
                   SpreadEnlist se=new SpreadEnlist ();
                   se.setActivityId (this.getActivityId ());
                   se.setUserId (userId);
                   se.setTelephone (phone);
                   se.setShopId (shopId);
                   se.setName (name);
                   se.setDraw (0);
                   try {
                       spreadEnlistMapper.insertSelective (se);
                   } catch (RuntimeException e) {
                       if(e.getMessage()!=null&&e.getMessage().contains("Duplicate entry")){
                           throw new ActivityException ("重复参加");
                       }else{
                            throw e;
                       }

                   }
                   return se.getEnlistId ();

               }else{
                   throw new ActivityException ("不符合活动条件");
               }

            }

            @Override
            public List<ActivityEnlistVO> randomHit(Integer number) throws ActivityException{
                Long activityId=this.getActivityId();
                if(activityId==null){
                   throw new ActivityException("活动Id不存在");
                }
                SpreadEnlistExample seex=new SpreadEnlistExample();
                seex.createCriteria().andActivityIdEqualTo(activityId);
                List<SpreadEnlist> selsit=spreadEnlistMapper.selectByExample(seex);

                if(number>selsit.size()){
                    throw new ActivityException(activityId+":数量大于报名人数");
                }
                for(SpreadEnlist enlist:selsit){
                    if(enlist.getDraw()==1){
                        throw new ActivityException(activityId+":该活动已存在中签数据");
                    }

                }
                //随机选取元素。。
                List<SpreadEnlist> eidSet=new ArrayList<>();
                Random random = new Random();
                for(int i=0;i<number;i++){
                    int index =  random.nextInt(selsit.size());
                    eidSet.add(selsit.get(index));
                    selsit.remove(index);

                }
                //遍历set更新draw并传出list
                List<ActivityEnlistVO> volist=new ArrayList<>();

                for(SpreadEnlist enlist:eidSet){
                    ActivityEnlistVO vo=new ActivityEnlistVO();
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
                if(this.getActivityId()==null){
                    return null;
                }
                SpreadEnlistExample example=new SpreadEnlistExample();
                SpreadEnlistExample.Criteria ce=example.createCriteria();
                switch (hitType){
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
                List<SpreadEnlist> selist=spreadEnlistMapper.selectByExample(example);
                List<ActivityEnlistVO> vos=new ArrayList<>();
                for(SpreadEnlist se:selist){
                    ActivityEnlistVO vo=new ActivityEnlistVO();
                    vo.setActivityId(se.getActivityId());
                    vo.setEnId(se.getEnlistId());
                    vo.setName(se.getName());
                    vo.setShopId(se.getShopId());
                    vo.setTelephone(se.getTelephone());
                    vo.setUserId(se.getUserId());
                    vos.add(vo);
                }
                return vos;
            }
        };
    }

    @Override
    public <T extends Activity> T selActivityByVo(ActivityVO vo) {
        return null;
    }

    @Override
    public ActivityEnlist selEnlistById(Long enlistId) throws ActivityException {


        return new ActivityEnlist () {
                @Override public void hit () throws ActivityException {
                    if (this.getEnId () == null) {

                        throw new ActivityException ("没有EnId");
                    }
                    SpreadEnlist se= spreadEnlistMapper.selectByPrimaryKey (this.getEnId ());
                    se.setDraw (1);
                    spreadEnlistMapper.updateByPrimaryKey (se);
                }

                @Override public void unhit () throws ActivityException {
                    if (this.getEnId () == null) {

                        throw new ActivityException ("没有EnId");
                    }
                    SpreadEnlist se= spreadEnlistMapper.selectByPrimaryKey (this.getEnId ());
                    se.setDraw (0);
                    spreadEnlistMapper.updateByPrimaryKey (se);
                }
            };
      //
    }

    @Override
    public ActivityEnlist selEnlistByVo(ActivityEnlistVO vo) {
        return null;
    }
}
