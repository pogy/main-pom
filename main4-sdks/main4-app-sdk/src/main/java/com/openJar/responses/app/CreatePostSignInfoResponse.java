package com.openJar.responses.app;
import com.openJar.responses.Response;
/**
 * 类名:CreatePostSignInfoResponse
 * 类路径:com.openJar.responses.appCreatePostSignInfoResponse
 * 创建者:自动生成
 * 创建时间:2017-10-16
 * 描述:获取 OSS 临时授权
 */
public class CreatePostSignInfoResponse extends Response {
	//授权id	必须
	private String accessid;
	//授权策略	必须
	private String policy;
	//签名	必须
	private String signature;
	//授权路径	必须
	private String dir;
	//ossHost&nbsp;&nbsp;OSS地址	必须
	private String host;
	//过期时间，单位秒	必须
	private String expire;
	public String getAccessid(){
		return accessid;
	}

	public void setAccessid(String accessid){
		this.accessid=accessid;
	}

	public String getPolicy(){
		return policy;
	}

	public void setPolicy(String policy){
		this.policy=policy;
	}

	public String getSignature(){
		return signature;
	}

	public void setSignature(String signature){
		this.signature=signature;
	}

	public String getDir(){
		return dir;
	}

	public void setDir(String dir){
		this.dir=dir;
	}

	public String getHost(){
		return host;
	}

	public void setHost(String host){
		this.host=host;
	}

	public String getExpire(){
		return expire;
	}

	public void setExpire(String expire){
		this.expire=expire;
	}

}