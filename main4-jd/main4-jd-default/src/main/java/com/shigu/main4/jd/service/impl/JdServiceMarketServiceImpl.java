package com.shigu.main4.jd.service.impl;


import com.jd.open.api.sdk.request.market.VasSubscribeGetRequest;
import com.jd.open.api.sdk.response.market.VasSubscribeGetResponse;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdAuthService;
import com.shigu.main4.jd.service.JdServiceMarketService;
import com.shigu.main4.jd.util.JdUtil;
import com.shigu.main4.jd.vo.JdAuthedInfoVO;
import com.shigu.main4.jd.vo.JdVasSubscribeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 订购关系查询（根据购买用户名和收费项目代码获取订购关系时长）
     * @param userName
     * @param itemCode
     * @param userId
     */
    @Override
    public JdVasSubscribeVO subscribe(String userName, String itemCode, Long userId) throws JdUpException {
        JdAuthedInfoVO authedInfo = jdAuthService.getAuthedInfo(userId);
        if (authedInfo == null) {
            throw new JdUpException("未获取到京东授权信息");
        }
        VasSubscribeGetRequest request=new VasSubscribeGetRequest();
        request.setUserName(userName);
        request.setItemCode(itemCode);
        VasSubscribeGetResponse response = jdUtil.execute(request,authedInfo.getAccessToken());
        JdVasSubscribeVO vo = new JdVasSubscribeVO();
        vo.setItemCode(response.getItemCode());
        vo.setEndDate(response.getEndDate());
        return vo;
    }

}
