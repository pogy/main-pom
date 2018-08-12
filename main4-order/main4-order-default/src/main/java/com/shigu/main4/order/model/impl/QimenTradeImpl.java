package com.shigu.main4.order.model.impl;

import com.opentae.data.mall.beans.TaobaoSessionMap;
import com.opentae.data.mall.examples.TaobaoSessionMapExample;
import com.opentae.data.mall.interfaces.TaobaoSessionMapMapper;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.order.model.QimenTrade;
import com.shigu.main4.tools.RedisIO;
import com.shigu.tools.TbClient;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.QimenEventProduceRequest;
import com.taobao.api.request.QimenTradeUserAddRequest;
import com.taobao.api.response.QimenTradeUserAddResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope("prototype")
public class QimenTradeImpl implements QimenTrade{
    private String sessionKey;
    private String nick;
    @Autowired
    RedisIO redisIO;
    @Autowired
    TbClient tbClient;
    @Autowired
    TaobaoSessionMapMapper taobaoSessionMapMapper;

    public QimenTradeImpl(String nick) throws Main4Exception {
        if(StringUtils.isBlank(nick)){
            throw new Main4Exception("nick为空");
        }
        this.nick=nick;
        String u=redisIO.get("USER_QIMEN_ERP_"+nick,String.class);
        if(StringUtils.isBlank(u)){
            TaobaoSessionMapExample taobaoSessionMapExample=new TaobaoSessionMapExample();
            taobaoSessionMapExample.createCriteria().andNickEqualTo(nick);
            taobaoSessionMapExample.setOrderByClause("fresh_time desc");
            List<TaobaoSessionMap> sessions=taobaoSessionMapMapper.selectByExample(taobaoSessionMapExample);
            if(sessions.size()==0){
                throw new Main4Exception("无授权信息");
            }
            for(TaobaoSessionMap taobaoSessionMap:sessions){
                if(taobaoSessionMap.getSubTaobaoUserId()==null&&taobaoSessionMap.getFreshTime().getTime()>(System.currentTimeMillis()-(1296000000L))){
                    sessionKey=taobaoSessionMap.getSession();
                    break;
                }
            }
            if(sessionKey==null){
                sessionKey=sessions.get(0).getSession();
            }
            String s = redisIO.get("QIMEN_ERP_" + nick, String.class);
            if(StringUtils.isBlank(s)){
                TaobaoClient client = new DefaultTaobaoClient(tbClient.getUrl(), tbClient.getAppkey(),
                        tbClient.getSecret());
                QimenTradeUserAddRequest req = new QimenTradeUserAddRequest();
                req.setMemo("member_user");
                try {
                    client.execute(req, sessionKey);
                    redisIO.putTemp("QIMEN_ERP_" + nick,"1",604800);
                } catch (ApiException e) {
                    throw new Main4Exception("添加监控用户失败");
                }
            }
        }else{
            throw new Main4Exception("不处于监控队列");
        }
    }

    @Override
    public void toTransfer(String tid) throws Main4Exception {
        QimenEventProduceRequest req = new QimenEventProduceRequest();
        req.setStatus("QIMEN_ERP_TRANSFER");
        req.setTid(tid);
        TaobaoClient client = new DefaultTaobaoClient(tbClient.getUrl(), tbClient.getAppkey(),
                tbClient.getSecret());
        try {
            client.execute(req,sessionKey).getBody();
        } catch (ApiException e) {
            throw new Main4Exception("全链路监控推送失败:Transfer");
        }
    }

    @Override
    public void toCheack(String tid) throws Main4Exception {
        QimenEventProduceRequest req = new QimenEventProduceRequest();
        req.setStatus("QIMEN_ERP_CHECK");
        req.setTid(tid);
        TaobaoClient client = new DefaultTaobaoClient(tbClient.getUrl(), tbClient.getAppkey(),
                tbClient.getSecret());
        try {
            client.execute(req,sessionKey).getBody();
        } catch (ApiException e) {
            throw new Main4Exception("全链路监控推送失败:Cheack");
        }
    }

    @Override
    public void toNotify(String tid) throws Main4Exception {
        QimenEventProduceRequest req = new QimenEventProduceRequest();
        req.setStatus("QIMEN_CP_NOTIFY");
        req.setTid(tid);
        TaobaoClient client = new DefaultTaobaoClient(tbClient.getUrl(), tbClient.getAppkey(),
                tbClient.getSecret());
        try {
            client.execute(req,sessionKey).getBody();
        } catch (ApiException e) {
            throw new Main4Exception("全链路监控推送失败:Notify");
        }
    }

    @Override
    public void toOut(String tid) throws Main4Exception {
        QimenEventProduceRequest req = new QimenEventProduceRequest();
        req.setStatus("QIMEN_CP_OUT");
        req.setTid(tid);
        TaobaoClient client = new DefaultTaobaoClient(tbClient.getUrl(), tbClient.getAppkey(),
                tbClient.getSecret());
        try {
            client.execute(req,sessionKey).getBody();
        } catch (ApiException e) {
            throw new Main4Exception("全链路监控推送失败:Out");
        }
    }
}
