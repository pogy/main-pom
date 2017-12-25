package com.shigu.goodsup.jd.service;

import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAgingtemplService;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.vo.JdAgingTemplateVO;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By admin on 2017/12/25/15:43
 */
@Service
public class JdPostageTemplateService {

    @Autowired
    private JdAgingtemplService jdAgingtemplService;

    @Autowired
    private JdAuthService jdAuthService;

    /**
     * 获取用户京东下的运费模板
     * @param userId
     */
    public List<JdAgingTemplateVO> getPostageTemplateList(Long userId) throws JdUpException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(userId);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        return jdAgingtemplService.getAgingtempl(userId);
    }
}
