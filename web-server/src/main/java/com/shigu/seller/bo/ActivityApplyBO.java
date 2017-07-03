package com.shigu.seller.bo;

import java.util.List;

/**
 * 活动申请
 * Created by bugzy on 2017/7/2 0002.
 */
public class ActivityApplyBO {
    private List<String> activityInfo;
    private String phoneInfo;

    public List<String> getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(List<String> activityInfo) {
        this.activityInfo = activityInfo;
    }

    public String getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(String phoneInfo) {
        this.phoneInfo = phoneInfo;
    }
}
