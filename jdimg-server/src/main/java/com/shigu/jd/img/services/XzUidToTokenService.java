package com.shigu.jd.img.services;


import com.opentae.data.mall.beans.JdSessionMap;
import com.opentae.data.mall.interfaces.JdSessionMapMapper;
import com.shigu.exceptions.XzUidToTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By admin on 2017/12/11/16:29
 */
@Service
public class XzUidToTokenService {

    @Autowired
    private JdSessionMapMapper jdSessionMapMapper;

    public String getTokenByUid(Long userId) throws XzUidToTokenException {
        JdSessionMap jdSessionMap = new JdSessionMap();
        jdSessionMap.setShiguUid(userId);
        jdSessionMap = jdSessionMapMapper.selectOne(jdSessionMap);
        if (jdSessionMap == null) {
            throw new XzUidToTokenException("获取京东授权信息失败");
        }
        return jdSessionMap.getAccessToken();
    }
}
