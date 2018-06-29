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
    /**
     * 1淘宝 2阿里 4微信 6京东 7拼多多 第三方登陆type
     */
    private String ortherLoginType;
    /**
     * 图标地址
     */
    private String iconUrl;

    public OuterUserVO() {
    }

    public OuterUserVO(OuterUser user) {
        this.id = user.getSubUserId();
        switch (user.getLoginFromType()){
            case JD:{
                setFrom("jingdong");
                setName("京东");
                setOrtherLoginType("6");
                break;
            }
            case WX: {
                setFrom("weixin");
                setName("微信");
                setOrtherLoginType("4");
                break;
            }
            case TAOBAO:{
                setFrom("taobao");
                setName("淘宝");
                setOrtherLoginType("1");
                break;
            }
            case ALI:{
                setFrom("ali");
                setName("阿里");
                setOrtherLoginType("2");
                break;
            }
            case PDD:{
                setFrom("pinduoduo");
                setName("拼多多");
                setOrtherLoginType("7");
                break;
            }
            case SN:{
                setFrom("suning");
                setName("苏宁");
                setOrtherLoginType("8");
            }
            default:{
                setFrom("");
                setName("");
            }
        }
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

    public String getOrtherLoginType() {
        return ortherLoginType;
    }

    public void setOrtherLoginType(String ortherLoginType) {
        this.ortherLoginType = ortherLoginType;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
