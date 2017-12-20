package com.shigu.main4.spread.enums;

/**
 * 类名：ActiveEnum
 * 类路径：com.shigu.main4.spread.enums.ActiveEnum
 * 创建者：王浩翔
 * 创建时间：2017-11-17 15:56
 * 项目：main-pom
 * 描述：
 */
public enum ActiveEnum {
    NORMAL_ACTIVE("。。。","旧版活动"),
    FIND_GOODS("发现好货","发现好货"),
    NEW_ACTIVITY("秋款上新","秋装新品发布会"),
    VIP_VOUCHER("vip代金券","代金券"),
    ;
    //活动类型描述
    public final String desc;
    //活动类型标记，对应数据库中active_draw_pem中的flag字段
    public final String flag;

    ActiveEnum(String desc, String flag) {
        this.desc = desc;
        this.flag = flag;
    }

    public static ActiveEnum flagOf(String flag){
        for (ActiveEnum activeEnum : values()) {
            if (activeEnum.flag.equals(flag)) {
                return activeEnum;
            }
        }
        throw new RuntimeException("no such flag");
    }

    public String getDesc() {
        return desc;
    }

    public String getFlag() {
        return flag;
    }
}
