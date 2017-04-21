package com.shigu.buyer.vo;

import com.shigu.main4.ucenter.vo.OuterUser;
import com.shigu.session.main4.enums.LoginFromType;
import com.shigu.tools.DateParseUtil;

import java.io.Serializable;

/**
 * 第三方绑定账户
 * Created by zhaohongbo on 17/3/1.
 */
public class OuterUserVO implements Serializable{
    /**
     * 子账户ID
     */
    private Long id;
    /**
     * 子账户来源
     */
    private String from;
    /**
     * 用户昵称
     */
    private String nick;
    /**
     * 创建时间的yyyy-MM-dd格式
     */
    private String created;
    /**
     * 输出 淘宝、阿里巴巴、微信   中文字样
     */
    private String name;

    public OuterUserVO() {
    }

    public OuterUserVO(OuterUser user) {
        this.id = user.getSubUserId();
        setFrom(user.getLoginFromType()== LoginFromType.TAOBAO?"taobao":
                user.getLoginFromType()==LoginFromType.ALI?"ali":
                        user.getLoginFromType()==LoginFromType.WX?"weixin":"");
        setName(user.getLoginFromType()== LoginFromType.TAOBAO?"淘宝":
                user.getLoginFromType()==LoginFromType.ALI?"阿里":
                        user.getLoginFromType()==LoginFromType.WX?"微信":"");
        this.setNick(user.getOuterNick());
        this.setCreated(DateParseUtil.parseDate("yyyy-MM-dd",user.getCreateTime()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
