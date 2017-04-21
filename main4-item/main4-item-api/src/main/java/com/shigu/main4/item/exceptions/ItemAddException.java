package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/3/8.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemAddException extends ItemModifyException {

    private static final long serialVersionUID = -7120904156670313378L;

    public ItemAddException() {
    }

    public ItemAddException(ItemAddExceptionEnum exceptionEnum, Long itemId) {
        super(exceptionEnum.message, itemId);
        super.code = exceptionEnum.code;
    }

    public enum ItemAddExceptionEnum {
        IllegalArgumentException("IllegalArgumentException", "传入参数的 webSite、shopId 不能为NULL"),
        ITEM_ALREADY_EXIST("ITEM_ALREADY_EXIST", "该商品已经存在"),
        ITEM_ALREADY_INSTOCK("ITEM_ALREADY_INSTOCK", "该商品已在仓库中"),
        SHOP_DOES_NOT_EXIST("SHOP_DOES_NOT_EXIST", "店铺不存在"),
        ;
        public String code;
        public String message;

        ItemAddExceptionEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
