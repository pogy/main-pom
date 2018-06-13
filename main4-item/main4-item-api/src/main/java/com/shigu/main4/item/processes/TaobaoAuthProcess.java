package com.shigu.main4.item.processes;

import com.shigu.main4.item.exceptions.TbAddSessionException;
import com.shigu.main4.item.exceptions.TbItemSynException;
import com.shigu.main4.item.vo.SessionVO;

import java.util.Map;

/**
 * 淘宝授权类业务
 */
public interface TaobaoAuthProcess {

    /**
     * 添加session到表
     * @param map
     * @throws TbAddSessionException
     */
    void addSession(Map<?, ?> map) throws TbAddSessionException;

    /**
     * 判断是否要重新加入队列,或者重新抓取
     * 1、如果之前session队列中失效或没有,加入队列并重新抓取
     * @param nick
     * @param session
     */
    void reGetItemIfDown(String nick, String session) throws TbItemSynException;

    SessionVO getSession(String appkey, String nick);
}
