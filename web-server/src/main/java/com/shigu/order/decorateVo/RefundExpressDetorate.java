package com.shigu.order.decorateVo;

import com.shigu.main4.order.vo.ExpressVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class RefundExpressDetorate extends RefundVoDecorate{
    private List<ExpressVo> list;

    public RefundExpressDetorate(AbstractRefundVo vo,List<ExpressVo> list){
        super(vo);
        this.list = list;
    }

    RefundExpressDetorate(AbstractRefundVo vo) {
        super(vo);
    }

    private void setRefundExpress(){
        Map<String,Object> map = new HashMap<>();
        StringBuilder builder =new StringBuilder("");
        for(ExpressVo expressVo:list){
            builder.append(expressVo.getExpressId()).append(":");
            builder.append(expressVo.getExpressName()).append(",");
        }
        if(builder.length()>0){
            builder.delete(builder.length()-1,builder.length());
        }
        map.put("expressList",builder.toString());
        super.addMap(map);
    }

    @Override
    public void doAdd() {
        setRefundExpress();
        super.doAdd();
    }
}
