package com.shigu.main4.item.services.utils;

import com.shigu.main4.item.exceptions.TbException;
import com.shigu.main4.item.exceptions.TbItemSynException;
import com.shigu.main4.item.processes.TaobaoAuthProcess;
import com.shigu.main4.item.vo.SessionVO;
import com.taobao.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.shigu.main4.item.exceptions.TbItemSynException.TbItemSynExceptionEnum.SESSION_OVERDUE;

/**
 * 封装了一些淘宝请求器
 * Created by bugzy on 2017/6/6 0006.
 */
@Service
public class TaobaoExecutor {

    @Autowired
    private TaobaoAuthProcess taobaoAuthProcess;

    @Value("${taobao.app.key}")
    private String APPKEY;

    @Value("${taobao.app.secret}")
    private String SECRET;

    @Value("${taobao.app.server.url}")
    private String TOP_SERVER_URL;

    public <T extends TaobaoResponse> T success(BaseTaobaoRequest<T> request, String nick) throws TbException {
        SessionVO session = taobaoAuthProcess.getSession(APPKEY, nick);
        if (session == null || StringUtils.isEmpty(session.getSession())) {
            throw new TbItemSynException(SESSION_OVERDUE);
        }
        TaobaoClient client = new DefaultTaobaoClient(TOP_SERVER_URL,
                APPKEY, SECRET);
        try {
            T response = client.execute(request, session.getSession());
            if (!response.isSuccess()) {
                throw new TbException(String.format("%s:%s; %s, %s",
                        response.getErrorCode(),
                        response.getSubCode(),
                        response.getMsg(),
                        response.getSubMsg()
                ));
            }
            return response;
        } catch (ApiException e) {
            throw new TbException(String.format("taobao api error. code: %s, %s", e.getErrCode(), e.getErrMsg()));
        }
    }
}
