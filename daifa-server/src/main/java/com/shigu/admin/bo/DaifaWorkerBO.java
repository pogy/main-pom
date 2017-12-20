package com.shigu.admin.bo;
import com.shigu.base.bo.BaseBO;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaWorkerBo.java
 *@文件路径：com.shigu.admin.bo.DaifaWorkerBo
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-10-26 01:54:17
 *@comments:
 *
 *=========================================================
 */
public class DaifaWorkerBO extends BaseBO{
	
//daifa_worker_id
	private Long daifaWorkerId;//
//daifa_seller_id
	private Long daifaSellerId;//
//df_group_id
	private Long dfGroupId;//
//daifa_worker
	private String daifaWorker;//
//password
	private String password;//
//user_Name
	private String userName;//
//phone
	private String phone;//
//work_type
	private Integer workType;//类别@0管理员1拿货人2退货人3换货人4库管员
//pay_bao_account
	private String payBaoAccount;//支付宝账户
//worker_id
	private Long workerId;//工作用户ID
//role_id
	private Long roleId;//角色ID
//account_Id
	private Long accountId;//支付账户ID
//use_status
	private Integer useStatus;//状态@1可用2停用
//remark1
	private String remark1;//
//remark2
	private String remark2;//
//remark3
	private String remark3;//
	 
	 //*************************get/set*****************************
    	/**
  	* 
  	*=========================================================
  	*daifa_worker_id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getDaifaWorkerId() {
        return daifaWorkerId;
    }

    /**
  	* 
  	*=========================================================
  	*daifa_worker_id
 		*@自动生成
 		*=========================================================
  	*/
    public void setDaifaWorkerId(Long daifaWorkerId) {
        this.daifaWorkerId = daifaWorkerId;
    }
	/**
  	* 
  	*=========================================================
  	*daifa_seller_id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getDaifaSellerId() {
        return daifaSellerId;
    }

    /**
  	* 
  	*=========================================================
  	*daifa_seller_id
 		*@自动生成
 		*=========================================================
  	*/
    public void setDaifaSellerId(Long daifaSellerId) {
        this.daifaSellerId = daifaSellerId;
    }
	/**
  	* 
  	*=========================================================
  	*df_group_id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getDfGroupId() {
        return dfGroupId;
    }

    /**
  	* 
  	*=========================================================
  	*df_group_id
 		*@自动生成
 		*=========================================================
  	*/
    public void setDfGroupId(Long dfGroupId) {
        this.dfGroupId = dfGroupId;
    }
	/**
  	* 
  	*=========================================================
  	*daifa_worker
 		*@自动生成
 		*=========================================================
  	*/
    public String getDaifaWorker() {
        return daifaWorker;
    }

    /**
  	* 
  	*=========================================================
  	*daifa_worker
 		*@自动生成
 		*=========================================================
  	*/
    public void setDaifaWorker(String daifaWorker) {
        this.daifaWorker = daifaWorker;
    }
	/**
  	* 
  	*=========================================================
  	*password
 		*@自动生成
 		*=========================================================
  	*/
    public String getPassword() {
        return password;
    }

    /**
  	* 
  	*=========================================================
  	*password
 		*@自动生成
 		*=========================================================
  	*/
    public void setPassword(String password) {
        this.password = password;
    }
	/**
  	* 
  	*=========================================================
  	*user_Name
 		*@自动生成
 		*=========================================================
  	*/
    public String getUserName() {
        return userName;
    }

    /**
  	* 
  	*=========================================================
  	*user_Name
 		*@自动生成
 		*=========================================================
  	*/
    public void setUserName(String userName) {
        this.userName = userName;
    }
	/**
  	* 
  	*=========================================================
  	*phone
 		*@自动生成
 		*=========================================================
  	*/
    public String getPhone() {
        return phone;
    }

    /**
  	* 
  	*=========================================================
  	*phone
 		*@自动生成
 		*=========================================================
  	*/
    public void setPhone(String phone) {
        this.phone = phone;
    }
	/**
  	* 
  	*=========================================================
  	*work_type
 		*@自动生成
 		*=========================================================
  	*/
    public Integer getWorkType() {
        return workType;
    }

    /**
  	* 
  	*=========================================================
  	*work_type
 		*@自动生成
 		*=========================================================
  	*/
    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
	/**
  	* 
  	*=========================================================
  	*pay_bao_account
 		*@自动生成
 		*=========================================================
  	*/
    public String getPayBaoAccount() {
        return payBaoAccount;
    }

    /**
  	* 
  	*=========================================================
  	*pay_bao_account
 		*@自动生成
 		*=========================================================
  	*/
    public void setPayBaoAccount(String payBaoAccount) {
        this.payBaoAccount = payBaoAccount;
    }
	/**
  	* 
  	*=========================================================
  	*worker_id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getWorkerId() {
        return workerId;
    }

    /**
  	* 
  	*=========================================================
  	*worker_id
 		*@自动生成
 		*=========================================================
  	*/
    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
	/**
  	* 
  	*=========================================================
  	*role_id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getRoleId() {
        return roleId;
    }

    /**
  	* 
  	*=========================================================
  	*role_id
 		*@自动生成
 		*=========================================================
  	*/
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
	/**
  	* 
  	*=========================================================
  	*account_Id
 		*@自动生成
 		*=========================================================
  	*/
    public Long getAccountId() {
        return accountId;
    }

    /**
  	* 
  	*=========================================================
  	*account_Id
 		*@自动生成
 		*=========================================================
  	*/
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
	/**
  	* 
  	*=========================================================
  	*use_status
 		*@自动生成
 		*=========================================================
  	*/
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
  	* 
  	*=========================================================
  	*use_status
 		*@自动生成
 		*=========================================================
  	*/
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }
	/**
  	* 
  	*=========================================================
  	*remark1
 		*@自动生成
 		*=========================================================
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*=========================================================
  	*remark1
 		*@自动生成
 		*=========================================================
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	* 
  	*=========================================================
  	*remark2
 		*@自动生成
 		*=========================================================
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	* 
  	*=========================================================
  	*remark2
 		*@自动生成
 		*=========================================================
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
	/**
  	* 
  	*=========================================================
  	*remark3
 		*@自动生成
 		*=========================================================
  	*/
    public String getRemark3() {
        return remark3;
    }

    /**
  	* 
  	*=========================================================
  	*remark3
 		*@自动生成
 		*=========================================================
  	*/
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
}
