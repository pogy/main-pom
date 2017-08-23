package com.shigu.order.actions;

import com.shigu.main4.order.exceptions.OrderException;
import com.shigu.main4.order.services.AfterSaleService;
import com.shigu.main4.order.servicevo.AfterSaleEntVO;
import com.shigu.main4.order.servicevo.AfterSaleInfoVO;
import com.shigu.main4.order.servicevo.AfterSaleStatusVO;

import com.shigu.order.services.OrderOptionSafeService;
import com.shigu.order.services.PreSaleShowService;
import com.shigu.order.vo.RefundApplyRecordVO;
import com.shigu.order.vo.RefundOrderVO;
import com.shigu.order.vo.SubRefundOrderVO;
import com.shigu.session.main4.PersonalSession;
import com.shigu.session.main4.names.SessionEnum;
import com.shigu.tools.JsonResponseUtil;
import com.shigu.zf.utils.PriceConvertUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.List;

@Controller
public class PreSaleShowAction {
    @Autowired
    AfterSaleService afterSaleService;
    @Autowired
    PreSaleShowService preSaleShowService;
    @Autowired
    private OrderOptionSafeService orderOptionSafeService;


    @RequestMapping("order/onlyRefund")
    public String onlyRefundId(Long childOrderId,Long refundId,Model model){
        if(childOrderId==null&&refundId==null){
            return "trade/noOrderInfo";
        }
        if(childOrderId!=null){
            SubRefundOrderVO sub=preSaleShowService.selSubRefundOrderVO(childOrderId);
            RefundOrderVO order=preSaleShowService.selRefundOrderVO(childOrderId);
            model=toModel(model,sub,order);
            model.addAttribute("onlyRefundStateNum",1);
        }else{
            AfterSaleStatusVO assvo=afterSaleService.afterSaleStatus(refundId);
            switch (assvo.getAfterSaleStatus().returnGoodsStatus){
                case 0:case 1:{
                    model.addAttribute("onlyRefundStateNum",2);
                    break;
                }
                case 6:{
                    model.addAttribute("onlyRefundStateNum",3);
                    AfterSaleEntVO afterEnt=afterSaleService.afterEnt(refundId);
                    model.addAttribute("finalRefundAmount", PriceConvertUtils.priceToString(afterEnt.getPrice()));
                    model.addAttribute("refundGoto",afterEnt.getPriceGoto());
                    model.addAttribute("refundSuccessTime",afterEnt.getAfterSeleEntDate());
                    break;
                }
                case 2: case 3: case 4: case 5: {
                    model.addAttribute("onlyRefundStateNum",4);
                    model.addAttribute("refuseReason",assvo.getContent());
                    break;
                }
                default:{
                    return "trade/noOrderInfo";
                }
            }
            SubRefundOrderVO sub=preSaleShowService.selSubRefundOrderVO(assvo.getSubOrderId());
            RefundOrderVO order=preSaleShowService.selRefundOrderVO(assvo.getSubOrderId());
            model=toModel(model,sub,order);
            AfterSaleInfoVO afterSaleInfo=afterSaleService.afterSaleInfo(refundId);
            model.addAttribute("refundId",afterSaleInfo.getRefundId());
            model.addAttribute("refundAmount",PriceConvertUtils.priceToString(afterSaleInfo.getRefundPrice()));
            List<RefundApplyRecordVO> applyList=preSaleShowService.refundApplyRecordList(refundId);
            model.addAttribute("applylist",applyList);
        }
        return "trade/onlyRefund";
    }

    @RequestMapping("order/onlyRefundApply")
    @ResponseBody
    public JSONObject onlyRefundApply(Long childOrderId, Integer refundCount, HttpSession session) throws OrderException {
        SubRefundOrderVO sub=preSaleShowService.selSubRefundOrderVO(childOrderId);
        Long price=refundCount*PriceConvertUtils.StringToLong(sub.getRefundGoodsPrice());
        if(sub.getOtherRefundPrice()!=null){
            price+=PriceConvertUtils.StringToLong(sub.getOtherRefundPrice());
        }
        PersonalSession ps= (PersonalSession) session.getAttribute(SessionEnum.LOGIN_SESSION_USER.getValue());
        if(!orderOptionSafeService.checkBySoid(childOrderId,ps.getUserId())){
            return JsonResponseUtil.error("只能操作本用户下的订单");
        }
        Long refundId=afterSaleService.preRefundApply(childOrderId,refundCount,price);
        JSONObject obj=new JSONObject();
        obj.put("result","success");
        obj.put("refundId",refundId);
        return obj;
    }


    private Model toModel(Model model,Object... objs){
        for(Object obj:objs){
            Class clazz=obj.getClass();
            Field[] fields=clazz.getDeclaredFields();
            for(Field field:fields){
                try {
                    field.setAccessible(true);
                    Object o=field.get(obj);
                    model.addAttribute(field.getName(),o);
                } catch (IllegalAccessException e) {
                }
            }
        }
        return model;
    }
}
