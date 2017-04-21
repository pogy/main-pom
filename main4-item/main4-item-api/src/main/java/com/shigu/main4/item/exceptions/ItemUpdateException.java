package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/3/8.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemUpdateException extends ItemModifyException {

    private static final long serialVersionUID = -5226413041063645183L;

    public ItemUpdateException(ItemUpdateExceptionEnum exceptionEnum, Long itemId) {
        super(exceptionEnum.message, itemId);
        this.code = exceptionEnum.code;
    }

    public ItemUpdateException() {
    }

    public enum ItemUpdateExceptionEnum {
        ITEM_DOES_NOT_EXIST("ITEM_DOES_NOT_EXIST", "架上不存在该商品"),
        ITEM_ALREADY_DOWN_SET("ITEM_ALREADY_DOWN_SET", "该商品已被下架"),
        IllegalArgumentException("IllegalArgumentException", "传入商品的 goodsId、webSite、shopId、numIid不能为null"),
        ;
        public String code;
        public String message;

        ItemUpdateExceptionEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
