package com.shigu.main4.exceptions;

/**
 * 二级域名相关异常
 * Created by zhaohongbo on 17/2/25.
 */
public class ShopDomainException extends StoreException{

    private String code;
    private String msg;//TODO: 建议使用自带的message

    public ShopDomainException(String code, String message){
        this.code = code;
        this.msg = message;//TODO: 在构造方法中调用 super(message);
    }


    public enum ShopDomainExceptionErrorCode{
        DATA_IS_ERROR("DATA_IS_ERROR", "数据无效"),
        DOMAIN_WITH_REPEAT("DOMAIN_WITH_REPEAT", "二级域名已存在"),
        DOMAIN_WITH_SHOPNUM_REPEAT("DOMAIN_WITH_SHOPNUM_REPEAT", "二级域名已存在"),
        DOMAIN_WITH_SYSTEM_REPEAT("DOMAIN_WITH_SYSTEM_REPEAT", "该二级域名为系统保留域名"),
        DOMAIN_WITH_NUM4_REPEAT("DOMAIN_WITH_NUM4_REPEAT", "不允许使用3位以下8位以上二级域名（本店档口号除外）"),
        DOMAIN_NOT_ALLOWTED("DOMAIN_NOT_ALLOWTED", "该二级域名不允许注册"),
        DOMAIN_NOT_ALLOWTED_WITH_OTHERS("DOMAIN_NOT_ALLOWTED_WITH_OTHERS", "该二级域名为档口号,不允许其他档口注册"),
        ;

        private ShopDomainExceptionErrorCode(String code, String message){
            this.code = code;
            this.message = message;
        }

        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


    public String toString(){
        return "code:" + this.code + " msg:" + this.msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
