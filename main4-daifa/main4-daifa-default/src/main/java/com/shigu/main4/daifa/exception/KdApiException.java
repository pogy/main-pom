package com.shigu.main4.daifa.exception;

/**
 * Created by Administrator on 2017-6-7.
 */
public class KdApiException extends Exception{
    private String msg;
    private String code;
    public KdApiException (String msg) {
        this.msg=msg;
    }
    public KdApiException (KdApiException.KdApiExceptionEnum kdApiExceptionEnum, String param){
        this(kdApiExceptionEnum.getMsg() + (param == null ? "" : param));
        this.code=kdApiExceptionEnum.getCode();
    }
    public KdApiException (KdApiException.KdApiExceptionEnum kdApiExceptionEnum){
        this(kdApiExceptionEnum.getMsg());
        this.code=kdApiExceptionEnum.getCode();
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public enum  KdApiExceptionEnum{
        SIGN_ERROR("10001","快递API验签错误"),
        API_ERROR("10002","API调用报错,错误信息:");


        KdApiExceptionEnum(String code,String msg){
            this.code=code;
            this.msg=msg;
        };
        private String code;
        private String msg;

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
}
