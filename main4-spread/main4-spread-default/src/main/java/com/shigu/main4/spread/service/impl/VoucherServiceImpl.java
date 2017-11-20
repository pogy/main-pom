package com.shigu.main4.spread.service.impl;

import com.opentae.data.mall.beans.ActiveDrawPem;
import com.opentae.data.mall.examples.ActiveDrawPemExample;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.ActiveDrawPemMapper;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.spread.service.VoucherService;
import com.shigu.main4.spread.vo.VoucherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ActiveDrawPemMapper activeDrawPemMapper;

    @Autowired
    private ShiguTempMapper shiguTempMapper;

    @Override
    public void obtainVoucher(Long userId, Integer uploadNum, Long pemId) {
        ActiveDrawPem pem = activeDrawPemMapper.selectByPrimaryKey(pemId);
        Date now = new Date();
        if (now.after(pem.getStartTime())&&now.before(pem.getEndTime())) {
            if (uploadNum>5) {
                generateVoucher(userId,pemId,FirstVoucherGen.UPLOAD_FIVE);
            }
            if (uploadNum>10) {
                generateVoucher(userId,pemId,FirstVoucherGen.UPLOAD_TEN);
            }
            if (uploadNum>15) {
                generateVoucher(userId,pemId,FirstVoucherGen.UPLOAD_FIFTEN);
            }
        }
    }

    protected synchronized void generateVoucher(Long userId,Long pemId,FirstVoucherGen gen){

    }

    @Override
    public List<VoucherVO> selVoucherList(Long userId,List<Long> pemIds) {
        List<String> flags = new ArrayList<>(pemIds.size());
        for (Long pemId : pemIds) {
            flags.add(getVoucherFlag(pemId));
        }
        ShiguTempExample example = new ShiguTempExample();
        example.createCriteria().andKey1EqualTo(userId.toString()).andFlagIn(flags);
        shiguTempMapper.selectByExample(example);
        // TODO: 2017/11/17 0017 封装返回
        return null;
    }

    @Override
    public List<Long> selCurrentAvailableVoucherPems() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-7);
        Date time = calendar.getTime();
        ActiveDrawPemExample example = new ActiveDrawPemExample();
        example.createCriteria().andFlagEqualTo(flag).andEndTimeGreaterThan(time);
        return BeanMapper.getFieldList(activeDrawPemMapper.selectByExample(example), "id", Long.class);
    }

    /**
     * 获取本期代金券标记
     * @param pemId
     * @return
     */
    protected String getVoucherFlag(Long pemId){
        return flag + pemId;
    }


    enum FirstVoucherGen{
        // TODO: 2017/11/17 0017 区分标志
        UPLOAD_FIVE("","30"),
        UPLOAD_TEN("","10"),
        UPLOAD_FIFTEN("","10"),
        ;
        //区分标志
        private final String identifyStr;
        //值字符串
        private final String valueStr;

        FirstVoucherGen(String identifyStr, String valueStr) {
            this.identifyStr = identifyStr;
            this.valueStr = valueStr;
        }

        VoucherVO simpleVoucherGen(){
            // TODO: 2017/11/17 0017 设置代金券区分标志  5次 10次 15次。。。注册vip送代金券需要进行区分
            // TODO: 2017/11/17 0017 设置代金券面值
            return null;
        }
    }
}
