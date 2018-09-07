package com.shigu.daifa.services;

import com.opentae.data.daifa.interfaces.DaifaSelFinaceMapper;
import com.shigu.daifa.vo.NewFinancialVo;
import com.shigu.main4.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * Created By zyl on 2018/9/6 0006/15:29
 */
@Service
public class DaifaTodayFinanceService {

    @Autowired
    DaifaSelFinaceMapper daifaSelFinaceMapper;

    private String toDouble(String fee){
        try {
            Double d=new Double(fee);
            DecimalFormat df = new DecimalFormat("0.00");
            return df.format(d);
        } catch (Exception e) {
            return "0.00";
        }
    }

    public NewFinancialVo getFinancial(String timeDate,Long daifaSellerId){
        String time = DateUtil.dateToString(DateUtil.stringToDate(timeDate,DateUtil.patternA),DateUtil.patternB);
        /**
         * 当天发货商品金额
         * 当天发货商品服务费
         * 当天快递费
         * 当日退货退款金额
         */

        //daifa_send_order send_status=2 create_data='' sellerId=
        String goodsFee=toDouble(daifaSelFinaceMapper.selTodayGoodsFee(time,daifaSellerId));
        // left join daifa_trade  daifa_send
        String serverFee=toDouble(daifaSelFinaceMapper.selTodayServerFee(time,daifaSellerId));
        //daifa_send
        String expressFee=toDouble(daifaSelFinaceMapper.selExpressFee(time,daifaSellerId));
        //
        String reFunFee=toDouble(daifaSelFinaceMapper.selTodayRefundFee(time));

        NewFinancialVo vo=new NewFinancialVo();
        vo.setTodayGoodsFee(goodsFee);
        vo.setTodayServerFee(serverFee);
        vo.setTodayExpressFee(expressFee);
        vo.setTodayRefunFee(reFunFee);
        return vo;
    }
}
