package com.shigu.phone.basevo;

import java.io.Serializable;
import java.util.List;

/**
 * 类名：UserWinningInfo
 * 类路径：com.shigu.phone.basevo.UserWinningInfo
 * 创建者：任真飞
 * 创建时间：2017-10-30 15:04
 * 项目：main-pom
 * 描述：用户中奖信息列表
 */
public class UserWinningInfo implements Serializable {
    //中奖信息标题
    private String title;
    //中奖信息显示的时间周期
    private String time;
    private List<Award> awardList;

    public UserWinningInfo() {
    }

    public UserWinningInfo( String title, String time, List<Award> awardList ) {

        this.title = title;
        this.time = time;
        this.awardList = awardList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime( String time ) {
        this.time = time;
    }

    public List<Award> getAwardList() {
        return awardList;
    }

    public void setAwardList( List<Award> awardList ) {
        this.awardList = awardList;
    }
}