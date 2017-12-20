package com.shigu.daifa.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.daifa.beans.DaifaOrder;
import com.opentae.data.daifa.examples.DaifaOrderExample;
import com.opentae.data.daifa.interfaces.DaifaOrderMapper;
import com.shigu.daifa.vo.NoGoodsnoOrder;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.daifa.exceptions.DaifaException;
import com.shigu.main4.daifa.process.OrderManageProcess;
import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.process.ItemProductProcess;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoGoodsnoOrderService {
    @Autowired
    DaifaOrderMapper daifaOrderMapper;
    @Autowired
    OrderManageProcess orderManageProcess;
    @Autowired
    ItemProductProcess itemProductProcess;

    public ShiguPager<NoGoodsnoOrder> selNoGoodsnoOrderList(Integer page,Long sellerId){
        DaifaOrderExample daifaOrderExample=new DaifaOrderExample();
        daifaOrderExample.createCriteria().andGoodsCodeIsNull().andGoodsIdNotEqualTo(-1L);
        Integer count=daifaOrderMapper.countByExample(daifaOrderExample);
        ShiguPager<NoGoodsnoOrder> pager=new ShiguPager<>();
        if(count>0){
            daifaOrderExample.setStartIndex((page-1)*10);
            daifaOrderExample.setEndIndex(10);
            List<DaifaOrder> os=daifaOrderMapper.selectByConditionList(daifaOrderExample);
            List<NoGoodsnoOrder> vos=new ArrayList<>();
            for(DaifaOrder o:os){
                NoGoodsnoOrder vo=new NoGoodsnoOrder();
                vo.setChildOrderId(o.getDfOrderId());
                vo.setChildServersFee(o.getSingleServicesFee());
                vo.setImgSrc(o.getPicPath());
                vo.setGoodsProperty(o.getPropStr());
                vo.setTitle(o.getTitle());
                vo.setGoodsId(o.getGoodsId());
                vos.add(vo);
            }
            pager.setContent(vos);
        }
        pager.setNumber(page);
        pager.calPages(count,10);
        return pager;
    }

    public void updateGoodsNo(Long dfOrderId,String goodsNo) throws DaifaException {
        if(dfOrderId==null|| StringUtils.isEmpty(goodsNo)){
            throw new DaifaException("缺少参数",DaifaException.DEBUG);
        }
        DaifaOrder o=daifaOrderMapper.selectFieldsByPrimaryKey(dfOrderId, FieldUtil.codeFields("df_order_id,goods_id"));
        if(o==null){
            throw new DaifaException("订单不存在",DaifaException.DEBUG);
        }
        if(o.getGoodsId()==-1){
            throw new DaifaException("不支持修改",DaifaException.DEBUG);
        }
        try {
            itemProductProcess.updateGoodsNo(o.getGoodsId(),goodsNo);
        } catch (OrderException e) {
            throw new DaifaException("订单系统修改失败:"+e.getMessage(),DaifaException.ERROR);
        }
        orderManageProcess.putGoodsCode(o.getGoodsId(),goodsNo);
    }
}
