package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/2/26.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemUpException extends ItemModifyException {

    private static final long serialVersionUID = -7215668755938528771L;

    public ItemUpException() {
    }

    public ItemUpException(String message) {
        super(message);
    }

    public ItemUpException(ItemUpExceptionEnum exceptionEnum, Long itemId) {
        super(exceptionEnum.message, itemId);
        this.code = exceptionEnum.code;
    }

    public enum ItemUpExceptionEnum {
        SYSTEM_UP_ERROR("SYSTEM_UP_ERROR", "用户下架的商品不允许系统上架"),
        ITEM_DOES_NOT_EXIST("ITEM_DOES_NOT_EXIST", "仓库中不存在该商品"),
        ITEM_ALREADY_UP("ITEM_ALREADY_UP", "该商品已经上架"),
        ;
        public String code;
        public String message;

        ItemUpExceptionEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
