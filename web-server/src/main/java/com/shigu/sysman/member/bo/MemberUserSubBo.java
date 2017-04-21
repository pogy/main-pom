package com.shigu.sysman.member.bo;


import com.shigu.component.common.page.PageParameter;

/**
 *
 * 会员子账号bo
 * @author shigu_zjb
 * @date 2017/04/04 15:52
 *
 */
public class MemberUserSubBo extends PageParameter {

    private Long userId;

    private Integer accountType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}
