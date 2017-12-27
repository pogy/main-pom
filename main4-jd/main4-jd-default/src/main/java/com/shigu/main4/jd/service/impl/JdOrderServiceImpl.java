package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.domain.order.SkuFareTemplateService.SkuFareTemplate;
import com.jd.open.api.sdk.request.order.SkuFareTemplateServiceGetTemplatesRequest;
import com.jd.open.api.sdk.response.order.SkuFareTemplateServiceGetTemplatesResponse;
import com.opentae.data.jd.beans.JdLogistTemplate;
import com.opentae.data.jd.examples.JdLogistTemplateExample;
import com.opentae.data.jd.interfaces.JdLogistTemplateMapper;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdOrderService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import com.shigu.main4.jd.vo.JdPostTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private JdLogistTemplateMapper jdLogistTemplateMapper;


    /**
     * 获取商家运费模板
     * @param jdUid
     * @return
     */
    @Override
    public List<JdPostTemplateVO> getPostTemplates(Long jdUid) throws JdUpException {
        JdLogistTemplateExample example =  new JdLogistTemplateExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        List<JdLogistTemplate> jdLogistTemplates = jdLogistTemplateMapper.selectByExample(example);

        List<JdPostTemplateVO> vos;
        if (jdLogistTemplates == null || jdLogistTemplates.isEmpty()) {
            vos = addPostTemolates(jdUid);
        } else {
            vos  = new ArrayList<>();
            for(JdLogistTemplate item : jdLogistTemplates) {
                JdPostTemplateVO vo = new JdPostTemplateVO();
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

    @Override
    @Transactional
    public List<JdPostTemplateVO> updatePostTemplates(Long jdUid) throws JdUpException {
        //先删
        JdLogistTemplateExample example =  new JdLogistTemplateExample();
        example.createCriteria().andJdUidEqualTo(jdUid);
        jdLogistTemplateMapper.deleteByExample(example);
        //再加
        return addPostTemolates(jdUid);
    }

    /**
     *新增运费模板信息
     * @param jdUid
     * @return
     * @throws JdUpException
     */
    private List<JdPostTemplateVO> addPostTemolates(Long jdUid) throws JdUpException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        SkuFareTemplateServiceGetTemplatesRequest request=new SkuFareTemplateServiceGetTemplatesRequest();
        SkuFareTemplateServiceGetTemplatesResponse response = jdUtil.execute(request, authedInfo.getAccessToken());
        List<SkuFareTemplate> templateList = response.getQuerySkuFareTemplateResult().getTemplateList();
        if (templateList == null || templateList.isEmpty()) {
            return null;
        }
        List<JdPostTemplateVO> vos = new ArrayList<>();
        List<JdLogistTemplate> jdLogistTemplates = new ArrayList<>();
        for (SkuFareTemplate item : templateList){
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

            JdPostTemplateVO vo = new JdPostTemplateVO();
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
