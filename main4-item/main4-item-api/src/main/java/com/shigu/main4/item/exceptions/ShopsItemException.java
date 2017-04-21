package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/3/2.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ShopsItemException extends ItemException {

    private static final long serialVersionUID = 6297902620890548277L;

    public ShopsItemException() {
    }

    public ShopsItemException(ShopsItemExceptionEnum itemExceptionEnum) {
        super(itemExceptionEnum.message);
        this.code = itemExceptionEnum.code;
    }

    public enum ShopsItemExceptionEnum {

        SHOP_DOES_NOT_EXIST("SHOP_DOES_NOT_EXIST", "店铺不存在"),
        ;

        ShopsItemExceptionEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }
        public String code;
        public String message;

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
