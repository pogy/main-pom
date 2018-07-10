package com.shigu.main4.order.services.impl;


import com.opentae.data.mall.beans.ShiguSellerAppMsg;
import com.opentae.data.mall.examples.ShiguSellerAppMsgExample;
import com.opentae.data.mall.interfaces.ShiguSellerAppMsgMapper;
import com.shigu.main4.order.services.SellerMsgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gtx on 2018/7/9.
 * 供应商消息
 * @author gtx
 * @since
 */
@Service("sellerMsgService")
public class SellerMsgServiceImpl implements SellerMsgService {

    @Resource(name = "tae_mall_shiguSellerAppMsgMapper")
    private ShiguSellerAppMsgMapper shiguSellerAppMsgMapper;

    /**
     * 标记为已读消息
     * @param userId
     * @param msgIds
     */
    @Override
    public boolean markReaded(Long userId, String msgIds) {
        if (userId == null) {
            return false;
        }
        if ((StringUtils.isBlank(msgIds))) {
            return false;
        }
        String[] split = msgIds.split(",");
        if (split == null || split.length <= 0) {
            return false;
        }
        List<Long> ids = Arrays.stream(split).filter(item->StringUtils.isNotBlank(item))
                .map(item -> Long.parseLong(item)).collect(Collectors.toList());
        if (ids == null || ids.size() <= 0) {
            return false;
        }
        ShiguSellerAppMsgExample example = new ShiguSellerAppMsgExample();
        example.createCriteria().andUserIdEqualTo(userId).andIdIn(ids);

        ShiguSellerAppMsg shiguSellerAppMsg = new ShiguSellerAppMsg();
        shiguSellerAppMsg.setMsgStatus(1);
        shiguSellerAppMsg.setGmtModify(new Date());
        shiguSellerAppMsgMapper.updateByExampleSelective(shiguSellerAppMsg,example);

        return true;
    }

    /**
     * 删除消息
     * @param userId
     * @param msgIds
     */
    @Override
    public boolean deleteMsg(Long userId, String msgIds) {
        if (userId == null) {
            return false;
        }
        if ((StringUtils.isBlank(msgIds))) {
            return false;
        }
        String[] split = msgIds.split(",");
        if (split == null || split.length <= 0) {
            return false;
        }
        List<Long> ids = Arrays.stream(split).filter(item->StringUtils.isNotBlank(item))
                .map(item -> Long.parseLong(item)).collect(Collectors.toList());
        if (ids == null || ids.size() <= 0) {
            return false;
        }
        ShiguSellerAppMsgExample example = new ShiguSellerAppMsgExample();
        example.createCriteria().andUserIdEqualTo(userId).andIdIn(ids);
        shiguSellerAppMsgMapper.deleteByExample(example);

        return true;
    }
}
