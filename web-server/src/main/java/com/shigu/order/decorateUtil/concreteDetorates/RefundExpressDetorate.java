package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.vo.ExpressVo;
import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *售后快递选择修饰
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
@Component
public class RefundExpressDetorate extends RefundVoDecorate {
    @Autowired
    AfterSaleService afterSaleService;

    private List<ExpressVo> list;
    private static String express;
    public RefundExpressDetorate(AbstractRefundVo vo, List<ExpressVo> list){
        super(vo);
        this.list = list;
    }

    private void setRefundExpress(){
        Map<String,Object> map = new HashMap<>();
        StringBuilder builder =new StringBuilder("");
        if(list == null) list = new ArrayList<>();

        for(ExpressVo expressVo:list){
            builder.append(expressVo.getExpressId()).append(":");
            builder.append(expressVo.getExpressName()).append(",");
        }
        if(builder.length()>0){
            builder.delete(builder.length()-1,builder.length());
        }else{
            builder.append(express);
        }

        map.put("expressList",builder.toString());
        super.addMap(map);
    }

    @PostConstruct
    public void init() {
        if (express == null) {
            List<ExpressVo> expressVos = afterSaleService.selectExpress();
            StringBuffer sb = new StringBuffer();
            for (ExpressVo expressVo : expressVos) {
                sb.append(',').append(expressVo.getExpressId()).append(':').append(expressVo.getExpressName());
            }
            if (sb.length()>0) {
                express=sb.substring(1);
            } else {
                express = "1:申通快递,2:圆通快递,3:韵达快递,4:百世汇通,5:EMS,6:其他";
            }
        }
        return;
    }

    @Override
    public void doAdd() {
        setRefundExpress();
        super.doAdd();
    }
}
