package com.shigu.main4.monitor.enums;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 类名：CidMapEnum
 * 类路径：com.shigu.main4.monitor.enums.CidMapEnum
 * 创建者：王浩翔
 * 创建时间：2017-10-02 11:26
 * 项目：main-pom
 * 描述：cid映射
 */
public enum  CidMapEnum {

    MAN_CAT_RANKING(30L,"man_cat_upload_count_index_","本周男装排行榜",CidMarketIdMapEnum.MAN_CAT_SHOP_RANKING),         //男装类目排行索引
    WOMAN_CAT_RANKING(16L,"woman_cat_upload_count_index_","本周女装排行榜",CidMarketIdMapEnum.WOMAN_CAT_SHOP_RANKING),     //女装类目排行索引
    ;
    //cid
    public final Long cid;
    //映射索引前缀
    public final String indexPrefix;
    //标题
    public final String title;
    //顶级类目对应档口排行榜
    public final CidMarketIdMapEnum cidMarketIdMapEnum;

    CidMapEnum(Long cid, String indexPrefix, String title,CidMarketIdMapEnum cidMarketIdMapEnum) {
        this.cid = cid;
        this.indexPrefix = indexPrefix;
        this.title = title;
        this.cidMarketIdMapEnum = cidMarketIdMapEnum;
    }

    public static String map(Long cid) throws Main4Exception {
        for (CidMapEnum cidMapEnum : values()) {
            if (cidMapEnum.cid.equals(cid)) {
                return cidMapEnum.indexPrefix;
            }
        }
        throw new Main4Exception("没有对应的排行映射");
    }
}
