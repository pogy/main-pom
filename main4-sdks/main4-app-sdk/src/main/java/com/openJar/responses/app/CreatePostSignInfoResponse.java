package com.openJar.responses.app;
import com.openJar.responses.Response;

/**
 * 类名:CreatePostSignInfoResponse
 * 类路径:com.openJar.responses.CreatePostSignInfoResponse
 * 创建者:自动生成
 * 创建时间:2017-08-29
 * 描述:我的信息
 */
public class CreatePostSignInfoResponse extends Response {

	private String accessid;
	private String policy;
	private String signature;
	private String dir;
	private String host;
	/**过期时间 单位秒*/
	private String expire;

	public String getAccessid() {
		return accessid;
	}

	public void setAccessid(String accessid) {
		this.accessid = accessid;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}
}