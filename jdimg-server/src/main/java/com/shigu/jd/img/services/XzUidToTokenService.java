package com.shigu.jd.img.services;

import com.opentae.data.jd.beans.JdSessionMap;
import com.opentae.data.jd.interfaces.JdSessionMapMapper;
import com.shigu.exceptions.JdAuthFailureException;
import com.shigu.exceptions.JdAuthOverdueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/11/16:29
 */
@Service
public class XzUidToTokenService {

    @Autowired
    private JdSessionMapMapper jdSessionMapMapper;

    public String getTokenByUid(Long jdUid) throws JdAuthOverdueException {
        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setJdUid(jdUid);
        jdSessionMap = jdSessionMapMapper.selectOne(jdSessionMap);
        if (jdSessionMap == null) {
            throw new JdAuthOverdueException("获取京东授权信息失败");
        }
        return jdSessionMap.getAccessToken();
    }
}
