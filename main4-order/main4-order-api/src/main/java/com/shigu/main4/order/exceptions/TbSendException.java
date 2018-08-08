package com.shigu.main4.order.exceptions;

public class TbSendException extends Exception{
    public TbSendException(String msg){
        super(msg);
    }

    public enum TbSendExceptionEnum{
        NOT_IS_TB_ORDER("不是淘宝订单"),
        WAIT_SENT("订单未发货"),
        SESSION_EXPORE("session过期"),
        IO_ERROR("调用接口失败"),
        SEND_ADDR_NOT_SET("请前往淘宝设置发货地址");


        private String msg;

        TbSendExceptionEnum(String msg){
            this.msg=msg;
        }
        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String toString(){
            return this.msg;
        }

    }
}

