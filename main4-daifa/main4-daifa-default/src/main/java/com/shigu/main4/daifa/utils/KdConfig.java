package com.shigu.main4.daifa.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KdConfig {

	//电商ID
	@Value("${KD_EID}")
	public String eid;
	//电商加密私钥，快递鸟提供，注意保管，不要泄漏
	@Value("${KD_APP_AKY}")
	public String appKey;
	//请求url, 正式环境地址：http://api.kdniao.cc/api/Eorderservice    测试环境地址：http://testapi.kdniao.cc:8081/api/EOrderService
	@Value("${KD_EORDERSERVICE_REQ_URL}")
	public String eorderserviceReqURL;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getEorderserviceReqURL() {
		return eorderserviceReqURL;
	}

	public void setEorderserviceReqURL(String eorderserviceReqURL) {
		this.eorderserviceReqURL = eorderserviceReqURL;
	}
}
