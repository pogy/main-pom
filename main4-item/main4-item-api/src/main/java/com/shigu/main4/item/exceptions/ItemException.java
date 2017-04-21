package com.shigu.main4.item.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created by wxc on 2017/2/26.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemException extends Main4Exception {

    private static final long serialVersionUID = 2394795388730962895L;
    protected String code;
    protected Long itemId;

    public ItemException(){}
    public ItemException(String message){
        super(message);
    }
    public ItemException(String message, Long itemId){
        super(message + ":" + itemId);
        this.itemId = itemId;
    }

    public String getCode() {
        return code;
    }

    public Long getItemId() {
        return itemId;
    }
}
