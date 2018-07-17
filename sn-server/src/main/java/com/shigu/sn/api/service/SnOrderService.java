package com.shigu.sn.api.service;

import com.openJar.beans.SnTokenInfo;
import com.shigu.sn.client.SnSdkClient;
import com.suning.api.entity.custom.GetproductcodeQueryRequest;
import com.suning.api.entity.custom.GetproductcodeQueryResponse;
import com.suning.api.entity.govbus.GetproductclusterGetRequest;
import com.suning.api.entity.sale.FreighttemplateQueryRequest;
import com.suning.api.entity.sale.FreighttemplateQueryResponse;
import com.suning.api.exception.SuningApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnOrderService {
    @Autowired
    SnSdkClient snSdkClient;
    @Autowired
    SnAuthService snAuthService;

    public List<FreighttemplateQueryResponse.QueryFreighttemplate> getFreight(String username) throws SuningApiException{
        SnTokenInfo snTokenInfo=snAuthService.getToken(username);
        FreighttemplateQueryRequest request = new FreighttemplateQueryRequest();
        request.setPageNo(1);
        request.setPageSize(10);
        FreighttemplateQueryResponse response= new FreighttemplateQueryResponse();
        response=snSdkClient.send(request,snTokenInfo.getAccessToken());
        if(response.getSnerror()!=null){
            return null;
        }
        return response.getSnbody().getQueryFreighttemplate();
    }

    public String getCode(String username,String applyCode)throws SuningApiException{
        SnTokenInfo snTokenInfo=snAuthService.getToken(username);
        GetproductcodeQueryRequest request=new GetproductcodeQueryRequest();
        request.setApplycode(applyCode);
        GetproductcodeQueryResponse response=new GetproductcodeQueryResponse();
        response = snSdkClient.send(request,snTokenInfo.getAccessToken());
        return response.getSnbody().getQueryGetproductcode().getResultData().get(0).getProductcode();

    }
}
