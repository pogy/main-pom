package com.shigu.daifa.services;

import com.opentae.data.daifa.beans.DaifaAfterMoneyConsult;
import com.opentae.data.daifa.examples.DaifaAfterMoneyConsultExample;
import com.opentae.data.daifa.interfaces.DaifaAfterMoneyConsultMapper;
import com.opentae.data.daifa.interfaces.DaifaSelFinaceMapper;
import com.shigu.daifa.vo.NewFinancialVo;
import com.shigu.daifa.vo.NewRefundFeeVo;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created By zyl on 2018/9/6 0006/15:29
 */
@Service
public class DaifaTodayFinanceService {

    @Autowired
    DaifaSelFinaceMapper daifaSelFinaceMapper;
    @Autowired
    private DaifaAfterMoneyConsultMapper daifaAfterMoneyConsultMapper;

    private String toDouble(String fee) {
        try {
            Double d = new Double(fee);
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(d);
        } catch (Exception e) {
            return "0.00";
        }
    }

    public NewFinancialVo getFinancial(String timeDate, Long daifaSellerId) {
        String time = DateUtil.dateToString(DateUtil.stringToDate(timeDate, DateUtil.patternA), DateUtil.patternB);
        /**
         * 当天发货商品金额
         * 当天发货商品服务费
         * 当天快递费
         * 当日退货退款金额
         */
        NewFinancialVo vo = new NewFinancialVo();
        //daifa_send_order send_status=2 create_data='' sellerId=
        String goodsFee = toDouble(daifaSelFinaceMapper.selTodayGoodsFee(time, daifaSellerId));
        // left join daifa_trade  daifa_send
        String serverFee = toDouble(daifaSelFinaceMapper.selTodayServerFee(time, daifaSellerId));
        //daifa_send
        String expressFee = toDouble(daifaSelFinaceMapper.selExpressFee(time, daifaSellerId));
        //
        Map<Long, String> conMap = new HashMap<>();
        Double d = 0.0;
        List<NewRefundFeeVo> list = daifaSelFinaceMapper.selTodayRefundFee(time);
        if (list.size() > 0) {
            List<Long> ids = list.stream().map(newRefundFeeVo -> newRefundFeeVo.getRefundId()).collect(Collectors.toList());
            DaifaAfterMoneyConsultExample example = new DaifaAfterMoneyConsultExample();
            example.createCriteria().andRefundIdIn(ids).andConsultTypeEqualTo(1);
            List<DaifaAfterMoneyConsult> consults = daifaAfterMoneyConsultMapper.selectByExample(example);
            if (consults != null) {
                conMap = consults.stream().collect(Collectors.toMap(DaifaAfterMoneyConsult::getRefundId, DaifaAfterMoneyConsult::getConsultMoney));
                for (NewRefundFeeVo feeVo : list) {
                    String m = conMap.get(feeVo.getRefundId());
                    if (m != null) {
                        feeVo.setMoney(m);
                    }
                    d += Double.valueOf(feeVo.getMoney());
                }

            } else {
                for (NewRefundFeeVo feeVo : list) {
                    d += Double.valueOf(feeVo.getMoney());
                }
            }
        }


        String reFunFee = toDouble(d.toString());
        vo.setTodayGoodsFee(goodsFee);
        vo.setTodayServerFee(serverFee);
        vo.setTodayExpressFee(expressFee);
        vo.setTodayRefunFee(reFunFee);
        return vo;
    }
}
