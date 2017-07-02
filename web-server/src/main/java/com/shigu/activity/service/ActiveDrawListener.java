package com.shigu.activity.service;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.opentae.data.mall.beans.ActiveDrawGoods;
import com.shigu.main4.monitor.vo.ItemUpRecordVO;
import com.shigu.main4.spread.service.ActiveDrawService;
import com.shigu.main4.spread.vo.active.draw.ActiveDrawPemVo;
import com.shigu.main4.tools.RedisIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 发现好货监听
 * Created by zhaohongbo on 17/7/2.
 */
@Service("activeDrawListener")
public class ActiveDrawListener implements MessageListener {

    @Autowired
    ActiveDrawService activeDrawServiceImpl;

    @Autowired
    RedisIO redisIO;

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        //1、拿到消息
        //2、验证是否本期发现好货,如果不是,中止
        //3、修改redis,如果有修改,执行4
        //4、验证用户当前应该是怎样一个档次,依靠redis
        //5、加操作
        ItemUpRecordVO itemUpRecordVO = JSON.parseObject(message.getBody(),ItemUpRecordVO.class);
        // 当前期次
        List<ActiveDrawPemVo> activeDrawPemVos = activeDrawServiceImpl.selDrawPemQueList();
        ActiveDrawPemVo drawPem = activeDrawPemVos.get(0);
        // 验证是发现好货商品
        if(activeDrawServiceImpl.findGoods(itemUpRecordVO.getSupperGoodsId(),drawPem.getId())){
            doChange(drawPem.getId(),itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),ActiveDrawGoods.TYPE_FAGOODS);
        }
        //验证是否每日发现
        if(activeDrawServiceImpl.findDaliy(itemUpRecordVO.getSupperGoodsId(),drawPem.getId())){
            doChange(drawPem.getId(),itemUpRecordVO.getFenUserId(),itemUpRecordVO.getSupperGoodsId(),ActiveDrawGoods.TYPE_DAILYFIND);
        }
        return Action.CommitMessage;
    }

    /**
     * 改变中奖资格
     * @param pemId 期次ID
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param findType 发现的类别,好货还是每日
     */
    private void doChange(Long pemId,Long userId,Long goodsId,String findType){
        //1、得出当前上传过的商品数
        //2、找到对应的规则进行修改数据
    }
}
