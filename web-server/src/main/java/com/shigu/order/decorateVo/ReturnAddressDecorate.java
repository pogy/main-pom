package com.shigu.order.decorateVo;

import com.shigu.main4.order.vo.ReturnableAddressVO;
import com.shigu.order.vo.AddInfoVo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2017-07-26.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class ReturnAddressDecorate extends RefundVoDecorate{
    private ReturnableAddressVO returnableAddressVO;

    public ReturnAddressDecorate(AbstractRefundVo vo,ReturnableAddressVO returnableAddressVO){
        super(vo);
        this.returnableAddressVO = returnableAddressVO;
    }
    private void setReturnAdress(){
        Map<String,Object> map = new HashMap<>();
        AddInfoVo vo = new AddInfoVo();
        vo.setAddress(returnableAddressVO.getReceiverAddress());
        vo.setName(returnableAddressVO.getReceiverName());
        vo.setPhone(returnableAddressVO.getReceiverPhone());
        map.put("addrInfo",vo);
        super.addMap(map);
    }

    @Override
    public void doAdd() {
        setReturnAdress();
        super.doAdd();
    }
}
