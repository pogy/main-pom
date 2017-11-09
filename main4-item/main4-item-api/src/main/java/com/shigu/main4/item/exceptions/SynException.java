package com.shigu.main4.item.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 类名：SynException
 * 类路径：com.shigu.main4.item.exceptions.SynException
 * 创建者：王浩翔
 * 创建时间：2017-11-05 11:49
 * 项目：main-pom
 * 描述：
 */
public class SynException extends Main4Exception {
    SynExceptionEnum synExceptionEnum;

    public SynException(String message){
        super(message);
    }
    public SynException(SynExceptionEnum synExceptionEnum) {
        super(synExceptionEnum.message);
        this.synExceptionEnum = synExceptionEnum;
    }

    public enum SynExceptionEnum {
        END_OF_PAGED_SYN_INFO_EXCEPTION("END_OF_SYN_PAGED_INFO", "分页同步信息获取结束"),
        COULD_NOT_GET_SYN_INFO_EXCEPTION("COULD_NOT_GET_SYN_INFO", "无法获取同步数据"),
        SYN_ONE_ITEM_EXCEPTION("SYN_ONE_ITEM_EXCEPTION","获取单件商品同步信息时出错"),
        ;
        public final String message;
        public final String code;

        SynExceptionEnum(String code, String message) {
            this.message = message;
            this.code = code;
        }
    }

    public SynExceptionEnum getSynExceptionEnum() {
        return synExceptionEnum;
    }
}
