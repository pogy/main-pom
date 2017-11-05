package com.shigu.main4.ucenter.util;

import com.openJar.utils.OpenBean;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：PropBean.java
 *@文件路径：com.shigu.publics.beans.PropBean.java
 *@内容摘要：
 *@编码作者：赵洪波
 *@完成日期：
 *@Date2014-6-16下午3:33:33
 *@comments:属性对象
 *
 *=========================================================
 */
public class PropBean extends OpenBean {
	private String name;//查询表taobao_prop_value里的name
	private String nameAlias;//查询name_alias
	private Long pid;//pid
	private String propName;//prop_name
	private Long sortOrder;//sort_order
	private String status;//status
	private Long vid;//vid
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameAlias() {
		return nameAlias;
	}
	public void setNameAlias(String nameAlias) {
		this.nameAlias = nameAlias;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public Long getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}

}

