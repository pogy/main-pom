package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.alpha.PromiseService.AgingTemplate;
import com.jd.open.api.sdk.request.alpha.AgingtemplGetRequest;
import com.jd.open.api.sdk.response.alpha.AgingtemplGetResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAgingtemplService;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAgingTemplateVO;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created By admin on 2017/12/14/17:13
 * 京东阿尔法API
 */
@Service("jdAgingtemplService")
public class JdAgingtemplServiceImpl implements JdAgingtemplService {

    @Autowired
    private JdUtil jdUtil;

    @Autowired
    private JdAuthService jdAuthService;

    /**
     * 商家时效模板查询接口
     * @param jdUid
     * @return
     * @throws JdException
     */
    @Override
    public List<JdAgingTemplateVO> getAgingtempl(Long jdUid) throws JdUpException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        AgingtemplGetRequest request = new AgingtemplGetRequest();
        AgingtemplGetResponse response = jdUtil.execute(request,authedInfo.getAccessToken());
        List<AgingTemplate> agingTemplateList = response.getAgingTemplateResponse().getAgingTemplateList();
        return BeanMapper.mapList(agingTemplateList,JdAgingTemplateVO.class);
    }

}
