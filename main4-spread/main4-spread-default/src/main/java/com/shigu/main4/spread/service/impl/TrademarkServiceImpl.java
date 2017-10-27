package com.shigu.main4.spread.service.impl;

import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import com.shigu.main4.spread.bo.TrademarkApplyBO;
import com.shigu.main4.spread.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名：TrademarkServiceImpl
 * 类路径：com.shigu.main4.spread.service.impl.TrademarkServiceImpl
 * 创建者：王浩翔
 * 创建时间：2017-10-13 17:20
 * 项目：main-pom
 * 描述：
 */
@Service("trademarkService")
public class TrademarkServiceImpl implements TrademarkService {

    /**
     * Flag:com.shigu.main4.spread.service.TrademarkService#TRADEMARK_APPLY_FLAG
     * Key1:userId
     * Key2:类型 1:商标普通注册,2:商标加急注册,3:商标担保注册,4:商标双享注册,5:普通登记,6:加急登记,7:外观专利,8:设计稿作品
     * Key3:姓名
     * Key4:联系号码
     * Key6:说明
     */

    @Autowired
    ShiguTempMapper shiguTempMapper;

    @Override
    public void giveInfoToServer(Long userId,TrademarkApplyBO bo) {
        //todo 暂时对报名不限制
        ShiguTemp shiguTemp = new ShiguTemp();
        shiguTemp.setFlag(TRADEMARK_APPLY_FLAG);
        shiguTemp.setKey1(userId.toString());
        String type = bo.getType();
        switch (bo.getType()){
            case "1":
                type += "商标普通注册";
                break;
            case "2":
                type += "商标加急注册";
                break;
            case "3":
                type += "商标担保注册";
                break;
            case "4":
                type += "商标双享注册";
                break;
            case "5":
                type += "普通登记";
                break;
            case "6":
                type += "加急登记";
                break;
            case "7":
                type += "外观专利";
                break;
            case "8":
                type += "设计稿作品";
                break;
        }
        shiguTemp.setKey2(type);
        shiguTemp.setKey3(bo.getName());
        shiguTemp.setKey4(bo.getTelephone());
        shiguTemp.setKey6(bo.getDetailText());
        shiguTempMapper.insertSelective(shiguTemp);
    }
}
