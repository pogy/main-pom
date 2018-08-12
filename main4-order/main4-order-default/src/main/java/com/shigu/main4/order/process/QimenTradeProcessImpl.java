package com.shigu.main4.order.process;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.ItemOrder;
import com.opentae.data.mall.beans.MemberUserSub;
import com.opentae.data.mall.examples.MemberUserSubExample;
import com.opentae.data.mall.interfaces.ItemOrderMapper;
import com.opentae.data.mall.interfaces.MemberUserSubMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.model.QimenTrade;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("qimenTradeProcess")
public class QimenTradeProcessImpl implements QimenTradeProcess {
    private static final Logger logger = LoggerFactory.getLogger(QimenTradeProcessImpl.class);
    @Autowired
    ItemOrderMapper itemOrderMapper;
    @Autowired
    MemberUserSubMapper memberUserSubMapper;
    @Override
    public void toTransfer(Long oid) {
        ItemOrder o=itemOrderMapper.selectFieldsByPrimaryKey(oid, FieldUtil.codeFields("oid,outer_id,user_id"));
        if(o==null|| StringUtils.isBlank(o.getOuterId())){
            return;
        }
        MemberUserSubExample memberUserSubExample=new MemberUserSubExample();
        memberUserSubExample.createCriteria().andAccountTypeEqualTo(3).andUserIdEqualTo(o.getUserId());
        List<MemberUserSub> us=memberUserSubMapper.selectByExample(memberUserSubExample);
        if(us.size()==0){
            return;
        }
        QimenTrade model= SpringBeanFactory.getBean(QimenTrade.class,us.get(0).getSubUserName());
        try {
            model.toTransfer(o.getOuterId());
        } catch (Main4Exception e) {
            if(!"不处于监控队列".equals(e.getMessage())){
                logger.warn(o.getOuterId()+"_"+e.getMessage());
            }
        }
    }
    @Override
    public void toCheack(Long oid) {
        ItemOrder o=itemOrderMapper.selectFieldsByPrimaryKey(oid, FieldUtil.codeFields("oid,outer_id,user_id"));
        if(o==null|| StringUtils.isBlank(o.getOuterId())){
            return;
        }
        MemberUserSubExample memberUserSubExample=new MemberUserSubExample();
        memberUserSubExample.createCriteria().andAccountTypeEqualTo(3).andUserIdEqualTo(o.getUserId());
        List<MemberUserSub> us=memberUserSubMapper.selectByExample(memberUserSubExample);
        if(us.size()==0){
            return;
        }
        QimenTrade model= SpringBeanFactory.getBean(QimenTrade.class,us.get(0).getSubUserName());
        try {
            model.toCheack(o.getOuterId());
        } catch (Main4Exception e) {
            if(!"不处于监控队列".equals(e.getMessage())){
                logger.warn(o.getOuterId()+"_"+e.getMessage());
            }
        }
    }
    @Override
    public void toNotify(Long oid) {
        ItemOrder o=itemOrderMapper.selectFieldsByPrimaryKey(oid, FieldUtil.codeFields("oid,outer_id,user_id"));
        if(o==null|| StringUtils.isBlank(o.getOuterId())){
            return;
        }
        MemberUserSubExample memberUserSubExample=new MemberUserSubExample();
        memberUserSubExample.createCriteria().andAccountTypeEqualTo(3).andUserIdEqualTo(o.getUserId());
        List<MemberUserSub> us=memberUserSubMapper.selectByExample(memberUserSubExample);
        if(us.size()==0){
            return;
        }
        QimenTrade model= SpringBeanFactory.getBean(QimenTrade.class,us.get(0).getSubUserName());
        try {
            model.toNotify(o.getOuterId());
        } catch (Main4Exception e) {
            if(!"不处于监控队列".equals(e.getMessage())){
                logger.warn(o.getOuterId()+"_"+e.getMessage());
            }
        }
    }
    @Override
    public void toOut(Long oid) {
        ItemOrder o=itemOrderMapper.selectFieldsByPrimaryKey(oid, FieldUtil.codeFields("oid,outer_id,user_id"));
        if(o==null|| StringUtils.isBlank(o.getOuterId())){
            return;
        }
        MemberUserSubExample memberUserSubExample=new MemberUserSubExample();
        memberUserSubExample.createCriteria().andAccountTypeEqualTo(3).andUserIdEqualTo(o.getUserId());
        List<MemberUserSub> us=memberUserSubMapper.selectByExample(memberUserSubExample);
        if(us.size()==0){
            return;
        }
        QimenTrade model= SpringBeanFactory.getBean(QimenTrade.class,us.get(0).getSubUserName());
        try {
            model.toOut(o.getOuterId());
        } catch (Main4Exception e) {
            if(!"不处于监控队列".equals(e.getMessage())){
                logger.warn(o.getOuterId()+"_"+e.getMessage());
            }
        }
    }


}
