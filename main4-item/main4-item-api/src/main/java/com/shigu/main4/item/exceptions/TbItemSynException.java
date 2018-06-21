package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/3/9.
 *
 * @author wxc
 * @version tb_site4.0 4.0.0
 * @since tb_site4.0 4.0.0
 */
public class TbItemSynException extends TbException {
    private String code;
    public TbItemSynException(String message) {
        super(message);
        this.code = "NORMAL";
    }

    public TbItemSynException(TbItemSynExceptionEnum exceptionEnum) {
        super(exceptionEnum.message);
        this.code = exceptionEnum.code;
    }

    public enum TbItemSynExceptionEnum {
        SESSION_OVERDUE("SESSION_OVERDUE", "用户授权过期"),
        TAOBAO_CLIENT_ERROR("TAOBAO_CLIENT_ERROR", "接口调用失败"),
        SHOP_DOES_NOT_EXIST("SHOP_DOES_NOT_EXIST", "店铺不存在"),
        TB_ITEM_DOES_NOT_EXIST("TB_ITEM_DOES_NOT_EXIST", "淘宝商品不存在"),
        ;
        public String code;
        public String message;

        TbItemSynExceptionEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public String getCode() {
        return code;
    }
}
