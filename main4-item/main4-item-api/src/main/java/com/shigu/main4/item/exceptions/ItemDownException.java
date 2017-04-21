package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/2/26.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemDownException extends ItemModifyException {

    private static final long serialVersionUID = 9085489546069331768L;

    public ItemDownException() {
    }

    public ItemDownException(String message) {
        super(message);
    }

    public ItemDownException(ItemDownExceptionEnum exceptionEnum, Long itemId) {
        this(exceptionEnum.code, exceptionEnum.message, itemId);
    }
    public ItemDownException(String code, String message, Long itemId) {
        super(message, itemId);
        this.code = code;
    }

    public enum ItemDownExceptionEnum {
        SYSTEM_DOWN_ERROR("SYSTEM_DOWN_ERROR", "系统下架异常"),
        ITEM_DOES_NOT_EXIST("ITEM_DOES_NOT_EXIST", "不存在该出售中的商品"),
        ITEM_ALREADY_DOWN("ITEM_ALREADY_DOWN", "该商品已经下架"),
        TB_ITEM_NOT_ALLOW_DOWN("TB_ITEM_NOT_ALLOW_DOWN", "淘宝商品不允许下架"),
        ;
        public String code;
        public String message;

        ItemDownExceptionEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
