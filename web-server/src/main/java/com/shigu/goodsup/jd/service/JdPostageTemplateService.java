package com.shigu.goodsup.jd.service;

import com.shigu.goodsup.jd.exceptions.JdNotBindException;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAgingtemplService;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.vo.JdAgingTemplateVO;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created By admin on 2017/12/25/15:43
 */
@Service
public class JdPostageTemplateService {

    @Autowired
    private JdAgingtemplService jdAgingtemplService;

    @Autowired
    private JdUserInfoService jdUserInfoService;

    /**
     * 获取用户京东下的运费模板
     * @param subUid
     */
    public List<JdAgingTemplateVO> getPostageTemplateList(Long subUid) throws JdUpException, JdNotBindException {
        String jdUid = jdUserInfoService.getJdUidBySubUid(subUid);
        return jdAgingtemplService.getAgingtempl(Long.valueOf(jdUid));
    }
}
