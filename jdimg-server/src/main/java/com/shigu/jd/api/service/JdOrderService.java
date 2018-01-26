package com.shigu.jd.api.service;

import com.jd.open.api.sdk.domain.order.SkuFareTemplateService.SkuFareTemplate;
import com.jd.open.api.sdk.request.order.SkuFareTemplateServiceGetTemplatesRequest;
import com.jd.open.api.sdk.response.order.SkuFareTemplateServiceGetTemplatesResponse;
import com.openJar.beans.JdAuthedInfo;
import com.openJar.beans.JdPostTemplate;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.responses.api.JdAuthedInfoResponse;
import com.openJar.responses.api.JdPostTemplateResponse;
import com.opentae.data.jd.beans.JdLogistTemplate;
import com.opentae.data.jd.examples.JdLogistTemplateExample;
import com.opentae.data.jd.interfaces.JdLogistTemplateMapper;
import com.shigu.exceptions.JdAuthOverdueException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.api.exceptions.JdAuthFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Ceated By admin on 2017/12/26/15:12
 */
@Service
public class JdOrderService {

    @Autowired
    private JdClientService jdClientService;

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdLogistTemplateMapper jdLogistTemplateMapper;

    /**
     * 获取商家运费模板
     *
     * @param jdUid
     * @return
     */
    public List<JdPostTemplate> getPostTemplates(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdLogistTemplateExample example = new JdLogistTemplateExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        List<JdLogistTemplate> jdLogistTemplates = jdLogistTemplateMapper.selectByExample(example);

        List<JdPostTemplate> vos;
        if (jdLogistTemplates == null || jdLogistTemplates.isEmpty()) {
            vos = addPostTemolates(jdUid);
        } else {
            vos = new ArrayList<>();
            for (JdLogistTemplate item : jdLogistTemplates) {
                JdPostTemplate vo = new JdPostTemplate();
                vo.setId(item.getTemplateId());
                vo.setTemplateName(item.getTemplateName());
                vo.setIndex(item.getTemplateIndex());
                vo.setIsFree(item.getIsFree());
                vo.setRuleType(item.getRuleType());
                vos.add(vo);
            }
        }
        return vos;
    }

    @Transactional
    public List<JdPostTemplate> updatePostTemplates(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdLogistTemplateExample example = new JdLogistTemplateExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        jdLogistTemplateMapper.deleteByExample(example);
        //再加
        return addPostTemolates(jdUid);
    }

    /**
     * 新增运费模板信息
     *
     * @param jdUid
     * @return
     */
    private List<JdPostTemplate> addPostTemolates(Long jdUid) throws JdAuthOverdueException, OtherCustomException {
        JdAuthedInfo authedInfo = jdAuthService.getAuthedInfo(jdUid);
        SkuFareTemplateServiceGetTemplatesRequest request = new SkuFareTemplateServiceGetTemplatesRequest();
        SkuFareTemplateServiceGetTemplatesResponse response = jdClientService.execute(request, authedInfo.getAccessToken());
        List<SkuFareTemplate> templateList = response.getQuerySkuFareTemplateResult().getTemplateList();
        if (templateList == null || templateList.isEmpty()) {
            return null;
        }
        List<JdPostTemplate> vos = new ArrayList<>();
        List<JdLogistTemplate> jdLogistTemplates = new ArrayList<>();
        for (SkuFareTemplate item : templateList) {
            JdLogistTemplate jdLogistTemplate = new JdLogistTemplate();
            jdLogistTemplate.setJdUid(jdUid);
            jdLogistTemplate.setTemplateId(item.getId());
            jdLogistTemplate.setTemplateIndex(item.getIndex());
            jdLogistTemplate.setTemplateName(item.getTemplateName());
            jdLogistTemplate.setRuleType(item.getRuleType());
            jdLogistTemplate.setIsFree(item.getIsFree());
            Date now = new Date();
            jdLogistTemplate.setGmtCreate(now);
            jdLogistTemplate.setGmtModify(now);
            jdLogistTemplates.add(jdLogistTemplate);

            JdPostTemplate vo = new JdPostTemplate();
            vo.setId(item.getId());
            vo.setTemplateName(item.getTemplateName());
            vo.setRuleType(item.getRuleType());
            vo.setIsFree(item.getIsFree());
            vo.setIndex(item.getIndex());
            vos.add(vo);
        }
        jdLogistTemplateMapper.insertListNoId(jdLogistTemplates);
        return vos;
    }
}
