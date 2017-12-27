package com.shigu.goodsup.jd.service;

import com.shigu.goodsup.jd.exceptions.JdNotBindException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdOrderService;
import com.shigu.main4.jd.vo.JdPostTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created By admin on 2017/12/25/15:43
 */
@Service
public class JdPostageTemplateService {

    @Autowired
    private JdOrderService jdOrderService;

    @Autowired
    private JdUserInfoService jdUserInfoService;

    /**
     * 获取用户京东下的运费模板
     * @param subUid
     */
    public List<JdPostTemplateVO> getPostageTemplateList(Long subUid) throws JdUpException, JdNotBindException {
        String jdUid = jdUserInfoService.getJdUidBySubUid(subUid);
        return jdOrderService.getPostTemplates(Long.valueOf(jdUid));
    }
}
