package com.shigu.spread.services;

import com.opentae.data.mall.beans.ShiguTemp;
import com.opentae.data.mall.interfaces.ShiguTempMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：公告信息
 * 工程：main-pom
 * 类路径：com.shigu.spread.services.AnnounceService
 * 创建人：wanghaoxiang 17-12-4 下午12:33
 */
@Service
public class AnnounceService {

    @Autowired
    private ShiguTempMapper shiguTempMapper;

    //在temp表中用来获取公告类型数据的标记
    private static final String ANNOUNCE_IDENTITY_FLAG = "ANNOUNCE_IDENTITY_FLAG";

    /**
     * 获取公告信息,没有找到匹配的，返回null
     *
     * @param announceId 公告识别标志
     * @return
     */
    public String acquireAnnounceInfo(String announceId) {
        if (StringUtils.isBlank(announceId)) {
            return null;
        }
        ShiguTemp shiguTemp = new ShiguTemp();
        shiguTemp.setFlag(ANNOUNCE_IDENTITY_FLAG);
        shiguTemp.setKey1(announceId);
        shiguTemp = shiguTempMapper.selectOne(shiguTemp);
        if (shiguTemp == null || StringUtils.isBlank(shiguTemp.getKey6())) {
            return null;
        }
        //能匹配到有效数据，输出为公告
        return shiguTemp.getKey6();
    }
}
