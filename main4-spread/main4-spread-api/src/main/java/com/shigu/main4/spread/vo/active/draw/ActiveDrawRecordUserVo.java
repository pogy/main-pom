package com.shigu.main4.spread.vo.active.draw;


import org.apache.commons.lang3.StringUtils;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动抽奖记录
 *
 */
public class ActiveDrawRecordUserVo implements Serializable {

    private Long id;

    /** 用户ID */
    private Long userId;

    /** 奖项 */
    private String ward;

    /** 期次 */
    private Long pemId;

    /** 是否领取 */
    private Boolean receivesYes;

    /** 中奖码 */
    private String drawCode;

    /** 中奖状态 */
    private Integer drawStatus;

    /** 用户昵称 */
    private String userNick;

    /** 用户隐藏昵称 */
    private String hideUserNick;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public Boolean getReceivesYes() {
        return receivesYes;
    }

    public void setReceivesYes(Boolean receivesYes) {
        this.receivesYes = receivesYes;
    }

    public String getDrawCode() {
        return drawCode;
    }

    public void setDrawCode(String drawCode) {
        this.drawCode = drawCode;
    }

    public Integer getDrawStatus() {
        return drawStatus;
    }

    public void setDrawStatus(Integer drawStatus) {
        this.drawStatus = drawStatus;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;

        if(StringUtils.isEmpty(userNick)){
            return;
        }
        if(userNick.length() >= 4){
            String qstr = userNick.substring(0,2);
            String hstr = userNick.substring(userNick.length() - 2, userNick.length());
            setHideUserNick(qstr + "***" + hstr );
            return;
        }
        if(userNick.length() < 4){
            setHideUserNick(userNick + "**");
        }
    }

    public String getHideUserNick() {
        return hideUserNick;
    }

    public void setHideUserNick(String hideUserNick) {
        this.hideUserNick = hideUserNick;
    }
}
