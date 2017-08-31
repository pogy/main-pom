package com.openJar.enums.exceptions;

/**
 * Created by pc on 2017-08-29.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public enum OneShopExceptionEnum {
    PARAM_MISS("1001");
    String code;
    OneShopExceptionEnum(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
