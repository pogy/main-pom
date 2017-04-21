package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/2/26.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemModifyException extends ItemException {
    private static final long serialVersionUID = 5908243343609375991L;

    public ItemModifyException() {

    }

    public ItemModifyException(String message) {
        super(message);
    }
    public ItemModifyException(String message, Long itemId) {
        super(message, itemId);
    }
}
