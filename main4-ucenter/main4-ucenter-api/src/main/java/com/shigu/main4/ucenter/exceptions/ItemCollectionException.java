package com.shigu.main4.ucenter.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

import java.io.Serializable;

/**
 * Created by wxc on 2017/3/2.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class ItemCollectionException extends Main4Exception implements Serializable{

    public ItemCollectionException( ) {
    }


    private String code;
    public ItemCollectionException(ItemCollecExcpEnum excpEnum) {
        super(excpEnum.message);
        this.code = excpEnum.code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public enum ItemCollecExcpEnum {
        IllegalArgumentException("ARG_EXCP", "用户ID 或 商品ID 不能为null"),
        CollectionAlreadyExist("ALREADY_EXIST", "已收藏该商品"),
        ;

        private String message;
        private String code;

        ItemCollecExcpEnum(String code, String message) {
            this.message = message;
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public String getCode() {
            return code;
        }
    }
}
