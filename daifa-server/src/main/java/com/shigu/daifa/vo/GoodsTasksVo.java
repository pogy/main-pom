package com.shigu.daifa.vo;

/**
 * Created By zyl on 2018/9/20 0020/12:38
 */
public class GoodsTasksVo {
    private Long daifaWorkerId;
    private Long tasksId;
    private String allocatTime;
    private String userName;

    public Long getDaifaWorkerId() {
        return daifaWorkerId;
    }

    public void setDaifaWorkerId(Long daifaWorkerId) {
        this.daifaWorkerId = daifaWorkerId;
    }

    public Long getTasksId() {
        return tasksId;
    }

    public void setTasksId(Long tasksId) {
        this.tasksId = tasksId;
    }

    public String getAllocatTime() {
        return allocatTime;
    }

    public void setAllocatTime(String allocatTime) {
        this.allocatTime = allocatTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
