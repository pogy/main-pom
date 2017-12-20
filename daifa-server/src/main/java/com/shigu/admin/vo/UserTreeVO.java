package com.shigu.admin.vo;

import java.io.Serializable;

/**
 * @类编号
 * @类名称：UserTreeVO
 * @文件路径：com.shigu.admin.vo.UserTreeVO
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/9/21 13:19
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class UserTreeVO implements Serializable {

   private Long daifaWorkerId;//用户ID
   private String userName;//用户名

    public Long getDaifaWorkerId () {
        return daifaWorkerId;
    }

    public void setDaifaWorkerId (Long daifaWorkerId) {
        this.daifaWorkerId = daifaWorkerId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }
}
