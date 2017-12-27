package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.domain.order.SkuFareTemplateService.SkuFareTemplate;
import com.jd.open.api.sdk.request.order.SkuFareTemplateServiceGetTemplatesRequest;
import com.jd.open.api.sdk.response.order.SkuFareTemplateServiceGetTemplatesResponse;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdOrderService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import com.shigu.main4.jd.vo.JdPostTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Ceated By admin on 2017/12/26/15:12
 */
@Service("jdOrderService")
public class JdOrderServiceImpl implements JdOrderService {

    @Autowired
    private JdUtil jdUtil;

    @Autowired
    private JdAuthService jdAuthService;


    /**
     * 获取商家运费模板
     * @param jdUid
     * @return
     */
    @Override
    public List<JdPostTemplateVO> getPostTemplates(Long jdUid) throws JdUpException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        SkuFareTemplateServiceGetTemplatesRequest request=new SkuFareTemplateServiceGetTemplatesRequest();
        SkuFareTemplateServiceGetTemplatesResponse response = jdUtil.execute(request, authedInfo.getAccessToken());
        List<SkuFareTemplate> templateList = response.getQuerySkuFareTemplateResult().getTemplateList();

        return BeanMapper.mapList(templateList,JdPostTemplateVO.class);
    }
}
