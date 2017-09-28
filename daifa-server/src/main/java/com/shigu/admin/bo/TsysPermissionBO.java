package com.shigu.admin.bo;
import com.shigu.base.bo.BaseBO;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TsysPermissionBo.java
 *@文件路径：com.shigu.songhuoyi.bo.TsysPermissionBo
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-09-19 03:55:59
 *@comments:
 *
 *=========================================================
 */
public class TsysPermissionBO extends BaseBO{
	
//permission_id
	private Long permissionId;//主键
//namespace
	private String namespace;//
//permission_tag
	private String permissionTag;//权限标签
//create_time
	private java.util.Date createTime;//创建时间
//create_user_id
	private Long createUserId;//创建者Id
//status
	private Long status;//状态，1为可用0为不可用
//permission_comment
	private String permissionComment;//权限备注
//parent_pid
	private Long parentPid;//
	 
	 //*************************get/set*****************************
    	/**
  	* 
  	*=========================================================
  	*permission_id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getPermissionId() {
        return permissionId;
    }

    /**
  	* 
  	*=========================================================
  	*permission_id
 		*@自动生成
 		*=========================================================
  	*/
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
	/**
  	* 
  	*=========================================================
  	*namespace
 		*@自动生成
 		*=========================================================
  	*/
    public String getNamespace() {
        return namespace;
    }

    /**
  	* 
  	*=========================================================
  	*namespace
 		*@自动生成
 		*=========================================================
  	*/
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
	/**
  	* 
  	*=========================================================
  	*permission_tag
 		*@自动生成
 		*=========================================================
  	*/
    public String getPermissionTag() {
        return permissionTag;
    }

    /**
  	* 
  	*=========================================================
  	*permission_tag
 		*@自动生成
 		*=========================================================
  	*/
    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }
	/**
  	* 
  	*=========================================================
  	*create_time
 		*@自动生成
 		*=========================================================
  	*/
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
  	* 
  	*=========================================================
  	*create_time
 		*@自动生成
 		*=========================================================
  	*/
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
	/**
  	* 
  	*=========================================================
  	*create_user_id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
  	* 
  	*=========================================================
  	*create_user_id
 		*@自动生成
 		*=========================================================
  	*/
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
	/**
  	* 
  	*=========================================================
  	*status
 		*@自动生成
 		*=========================================================
  	*/
    public Long getStatus() {
        return status;
    }

    /**
  	* 
  	*=========================================================
  	*status
 		*@自动生成
 		*=========================================================
  	*/
    public void setStatus(Long status) {
        this.status = status;
    }
	/**
  	* 
  	*=========================================================
  	*permission_comment
 		*@自动生成
 		*=========================================================
  	*/
    public String getPermissionComment() {
        return permissionComment;
    }

    /**
  	* 
  	*=========================================================
  	*permission_comment
 		*@自动生成
 		*=========================================================
  	*/
    public void setPermissionComment(String permissionComment) {
        this.permissionComment = permissionComment;
    }
	/**
  	* 
  	*=========================================================
  	*parent_pid
 		*@自动生成
 		*=========================================================
  	*/
    public Long getParentPid() {
        return parentPid;
    }

    /**
  	* 
  	*=========================================================
  	*parent_pid
 		*@自动生成
 		*=========================================================
  	*/
    public void setParentPid(Long parentPid) {
        this.parentPid = parentPid;
    }
}
