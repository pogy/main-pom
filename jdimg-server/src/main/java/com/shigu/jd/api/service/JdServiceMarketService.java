package com.shigu.jd.api.service;

import com.jd.open.api.sdk.request.market.VasSubscribeGetRequest;
import com.jd.open.api.sdk.response.market.VasSubscribeGetResponse;
import com.openJar.exceptions.imgs.JdApiException;
import com.openJar.responses.api.JdAuthedInfoResponse;
import com.openJar.responses.api.JdVasSubscribeResponse;
import com.opentae.data.jd.beans.JdFw;
import com.opentae.data.jd.interfaces.JdFwMapper;
import com.shigu.jd.api.exceptions.JdAuthFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

/**
 * Created By admin on 2017/12/14/16:51
 * 京东服务市场service
 */
@Service
public class JdServiceMarketService {

    @Autowired
    private JdClientService jdClientService;

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
    public JdVasSubscribeResponse subscribe(String userName, String itemCode, Long jdUid) throws JdAuthFailureException, com.shigu.jd.api.exceptions.JdApiException, JdApiException {
        JdAuthedInfoResponse authedInfo = jdAuthService.getAuthedInfo(jdUid);
        VasSubscribeGetRequest request=new VasSubscribeGetRequest();
        request.setUserName(userName);
        request.setItemCode(itemCode);
        VasSubscribeGetResponse response = jdClientService.execute(request,authedInfo.getAccessToken());
        JdVasSubscribeResponse vo = new JdVasSubscribeResponse();
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
    public void saveSubscribe(JdVasSubscribeResponse vo) throws JdAuthFailureException {
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
