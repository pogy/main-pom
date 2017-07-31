package com.shigu.order.decorateUtil.concreteDetorates;

import com.shigu.main4.order.servicevo.RefundLogVO;
import com.shigu.order.decorateUtil.AbstractRefundVo;
import com.shigu.order.decorateUtil.RefundVoDecorate;
import com.shigu.order.vo.ApplyUserLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *售后用户日志修饰
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class RefundLogDecorate extends RefundVoDecorate {

    private List<RefundLogVO> list;

    public RefundLogDecorate(AbstractRefundVo vo, List<RefundLogVO> list){
        super(vo);
        this.list = list;
    }

    private void setRefundLog(){
        Map<String,Object> map = new HashMap<>();
        List<ApplyUserLog> alist = new ArrayList<>();
        for(RefundLogVO logVO:list){
            ApplyUserLog log = new ApplyUserLog();
            log.setRecordContent(logVO.getLogDesc());
            log.setRecordTime(logVO.getLogTime());
            log.setUserNickname(logVO.getUserNick());
            log.setUserType(logVO.getUserType().type);
            log.setUserHeadimg(logVO.getHeadImgUrl());
            alist.add(log);
        }
        map.put("applylist",alist);
        super.addMap(map);

    }

    @Override
    public void doAdd() {
        setRefundLog();
        super.doAdd();
    }
}
