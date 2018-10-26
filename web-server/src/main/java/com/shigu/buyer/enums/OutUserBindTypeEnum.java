package com.shigu.buyer.enums;

import com.shigu.buyer.vo.OuterUserVO;
import com.shigu.main4.ucenter.vo.OuterUser;
import com.shigu.tools.DateParseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by admin on 2018/6/28.
 * 绑定第三方账号类型
 * @author admin
 * @description
 * @since
 */
public enum OutUserBindTypeEnum {
    JD("jingdong","京东","6","",8),
    WX("weixin","微信","4","",5),
    TAOBAO("taobao","淘宝","1","",3),
    ALI("ali","阿里","2","",6),
    PDD("pinduoduo","拼多多","7","",9),
    SN("suning","苏宁","8","",10),
    SHOPEE("shopee","shopee","9","",11),
    ;

    /**
     * 子账户来源
     */
    private String from;
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
    /**
     * 网站里存的标志
     */
    private int accountType;

    OutUserBindTypeEnum(String from, String name, String ortherLoginType, String iconUrl, int accountType) {
        this.from = from;
        this.name = name;
        this.ortherLoginType = ortherLoginType;
        this.iconUrl = iconUrl;
        this.accountType = accountType;
    }

    public static List<OuterUserVO> psrseToOutUserVO(List<OuterUser> outerUsers){
        Map<String, OuterUser> outerUsersMap = outerUsers.stream().collect(Collectors.toMap(item -> String.valueOf(item.getLoginFromType().getAccountType()), Function.identity()));

        List<OuterUserVO> outerUserVOS = new ArrayList<>();
        for (OutUserBindTypeEnum item : OutUserBindTypeEnum.values()){
            OuterUserVO outerUserVO = new OuterUserVO();
            outerUserVO.setName(item.getName());
            outerUserVO.setFrom(item.getFrom());
            outerUserVO.setIconUrl(item.getIconUrl());
            outerUserVO.setOrtherLoginType(item.getOrtherLoginType());

            OuterUser outerUser = outerUsersMap.get(String.valueOf(item.getAccountType()));
            if (outerUser != null) {
                outerUserVO.setId(outerUser.getSubUserId());
                outerUserVO.setNick(outerUser.getOuterNick());
                outerUserVO.setCreated(DateParseUtil.parseDate("yyyy-MM-dd",outerUser.getCreateTime()));
            }

            outerUserVOS.add(outerUserVO);
        }

        return outerUserVOS;
    }

    public String getFrom() {
        return from;
    }

    public String getName() {
        return name;
    }

    public String getOrtherLoginType() {
        return ortherLoginType;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public int getAccountType() {
        return accountType;
    }
}
