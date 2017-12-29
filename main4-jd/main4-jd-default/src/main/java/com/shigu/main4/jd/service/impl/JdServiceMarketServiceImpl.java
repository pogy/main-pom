package com.shigu.main4.jd.service.impl;

import com.jd.open.api.sdk.request.market.VasSubscribeGetRequest;
import com.jd.open.api.sdk.response.market.VasSubscribeGetResponse;
import com.opentae.data.jd.beans.JdFw;
import com.opentae.data.jd.interfaces.JdFwMapper;
import com.shigu.main4.jd.exceptions.JdApiException;
import com.shigu.main4.jd.exceptions.JdAuthFailureException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdServiceMarketService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import com.shigu.main4.jd.vo.JdVasSubscribeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

/**
 * Created By admin on 2017/12/14/16:51
 * 京东服务市场service
 */
@Service("jdServiceMarketService")
public class JdServiceMarketServiceImpl implements JdServiceMarketService {

    @Autowired
    private JdUtil jdUtil;

    @Autowired
    private JdAuthService jdAuthService;

    @Autowired
    private JdFwMapper jdFwMapper;

    /**
     * 订购关系查询（根据购买用户名和收费项目代码获取订购关系时长）
     * @param userName
     * @param itemCode
     * @param jdUid
     */
    @Override
    public JdVasSubscribeVO subscribe(String userName, String itemCode, Long jdUid) throws JdAuthFailureException, JdApiException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(jdUid);
        VasSubscribeGetRequest request=new VasSubscribeGetRequest();
        request.setUserName(userName);
        request.setItemCode(itemCode);
        VasSubscribeGetResponse response = jdUtil.execute(request,authedInfo.getAccessToken());
        JdVasSubscribeVO vo = new JdVasSubscribeVO();
        vo.setUserName(userName);
        vo.setJdUid(jdUid);
        vo.setItemCode(itemCode);
        vo.setEndDate(new Date(response.getEndDate()));
        return vo;
    }

    /**
     * 保存用户订购信息
     * @param vo
     * @return
     * @throws IOException
     * @throws JdAuthFailureException
     */
    @Override
    public void saveSubscribe(JdVasSubscribeVO vo) throws JdAuthFailureException {
        JdFw jdFw = new JdFw();
        jdFw.setJdUid(vo.getJdUid());
        JdFw selJdFw = jdFwMapper.selectOne(jdFw);
        Date now = new Date();
        if (selJdFw == null){
            jdFw.setItemCode(vo.getItemCode());
            jdFw.setItemSource(vo.getItemSource());
            jdFw.setUserName(vo.getUserName());
            jdFw.setVersionNo(vo.getVersionNo());
            jdFw.setEndDate(vo.getEndDate());
            jdFw.setGmtCreate(now);
            jdFw.setGmtModify(now);
            jdFwMapper.insert(jdFw);
        } else {
            jdFw.setId(selJdFw.getId());
            jdFw.setItemCode(vo.getItemCode());
            jdFw.setItemSource(vo.getItemSource());
            jdFw.setUserName(vo.getUserName());
            jdFw.setVersionNo(vo.getVersionNo());
            jdFw.setEndDate(vo.getEndDate());
            jdFw.setGmtCreate(now);
            jdFw.setGmtModify(now);
            jdFwMapper.updateByPrimaryKeySelective(jdFw);
        }
    }

}
