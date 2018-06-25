package com.shigu.main4.item.services.utils;

import com.opentae.data.mall.beans.TaobaoPropValue;
import com.taobao.api.domain.PropValue;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 更新属性值
 * Created by Licca on 17/5/21.
 */
@Service
public class UpdatePropValueService {

    @Async
    public void updatePropValue(Long cid,Long pid,String name,List<PropValue> pvlist){
        //do nothing
    }

    /**
     *
     *=========================================================
     *@方法名：parseLocalItemProp
     *@功能： 把淘宝的改成本地对象
     *@return:TaobaoItemProp
     *=========================================================
     */
    private List<TaobaoPropValue> parseLocalPropValues(List<PropValue> pvlist, Long cid, Long pid, String pName){
        if(pvlist==null){
            return null;
        }
        List<TaobaoPropValue> lists=new ArrayList<>();
        for(PropValue pv:pvlist){
            TaobaoPropValue tpv=new TaobaoPropValue();
            tpv.setCid(cid);
            tpv.setPid(pid);
            tpv.setPropName(pName);
            if(pv.getIsParent()==null){
                tpv.setIsParent(0);
            }else{
                tpv.setIsParent(pv.getIsParent()?1:0);
            }
            tpv.setName(pv.getName());
            tpv.setNameAlias(pv.getNameAlias());
            tpv.setSortOrder(pv.getSortOrder());
            tpv.setStatus(pv.getStatus());
            tpv.setVid(pv.getVid());
            lists.add(tpv);
        }
        return lists;
    }
}
