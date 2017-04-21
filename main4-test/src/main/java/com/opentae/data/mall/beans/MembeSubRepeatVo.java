package com.opentae.data.mall.beans;


/**
 * 子账户对于两个不同的userId
 *
 */
public class MembeSubRepeatVo {

    private Long subUserId;

    private Long aId;

    private Long bId;

    private String subUserName;

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public Long getSubUserId() {
        return subUserId;
    }

    public void setSubUserId(Long subUserId) {
        this.subUserId = subUserId;
    }

    public String getSubUserName() {
        return subUserName;
    }

    public void setSubUserName(String subUserName) {
        this.subUserName = subUserName;
    }
}
