package com.shigu.main4.spread.service.impl;

import com.opentae.data.mall.beans.ActiveDrawRecord;
import com.opentae.data.mall.interfaces.ActiveDrawRecordMapper;
import com.opentae.data.mall.interfaces.ActivityDrawPrizePoolMapper;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.spread.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 类名：VoucherServiceImpl
 * 类路径：com.shigu.main4.spread.service.impl.VoucherServiceImpl
 * 创建者：王浩翔
 * 创建时间：2017-11-17 16:07
 * 项目：main-pom
 * 描述：
 */
@Service("vipVoucherService")
public class VoucherServiceImpl implements VoucherService {

    private List<ProvideRule> provideRules;

    private Set<Long> userIds = new HashSet<>();

    @Autowired
    private ActiveDrawRecordMapper activeDrawRecordMapper;

    @Autowired
    private ActivityDrawPrizePoolMapper activityDrawPrizePoolMapper;

    @Override
    public void obtainVoucher(Long userId, Integer uploadNum, Long pemId) {
        if (provideRules == null) {
            initProvideRules();
        }
        synchronized (userIds){
            boolean inProcess = false;
            do {
                inProcess = userIds.contains(userId);
                if (!inProcess) {
                    userIds.add(userId);
                } else {
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException ignore) {
                    }
                }
            }while (inProcess);
        }
        for (ProvideRule provideRule : provideRules) {
            provideVoucher(userId,pemId,uploadNum,provideRule);
        }
        synchronized (userIds){
            userIds.remove(userId);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    protected void provideVoucher(Long userId,Long pemId,Integer upNum,ProvideRule rule){
        if (upNum > rule.getShouldUpNum()) {
            ActiveDrawRecord record = new ActiveDrawRecord();
            record.setUserId(userId);
            record.setPemId(pemId);
            record.setWard(rule.getWardRank().toString());
            if (activeDrawRecordMapper.selectOne(record) == null) {
                //达到发放条件并且还未发放代金券，进行代金券发放
                record.setReceivesYes(false);
                record.setDrawStatus(3);
                record.setDrawCode(StringUtil.str10To37Str());
                record.setModifyTime(new Date());
                activeDrawRecordMapper.insertSelective(record);
                activityDrawPrizePoolMapper.addProvide(pemId,rule.getWardRank());
            }
        }
    }

    private void initProvideRules(){
        List<ProvideRule> rules = new ArrayList<>();
        rules.add(new ProvideRule(5,1,"上传5件商品，发放三张代金券"));
        rules.add(new ProvideRule(10,2,"上传10件商品，发放一张代金券"));
        rules.add(new ProvideRule(15,3,"上传15件商品，发放一张代金券"));
        this.provideRules = Collections.unmodifiableList(rules);
    }

    /**
     * 达到一定上传量直接发放代金券
     */
    class ProvideRule{
        //需要上传的商品数
        private final Integer shouldUpNum;
        //奖品等级
        private final Integer wardRank;
        //说明
        private String desc;

        public ProvideRule(Integer shouldUpNum, Integer wardRank, String desc) {
            this.shouldUpNum = shouldUpNum;
            this.wardRank = wardRank;
            this.desc = desc;
        }

        public Integer getShouldUpNum() {
            return shouldUpNum;
        }

        public Integer getWardRank() {
            return wardRank;
        }
    }

}
