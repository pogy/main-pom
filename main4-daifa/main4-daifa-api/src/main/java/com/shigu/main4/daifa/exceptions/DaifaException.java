package com.shigu.main4.daifa.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * 异常类
 * Created by zhaohongbo on 17/8/9.
 */
public class DaifaException extends Main4Exception {
    private String level;//级别，debug,info,warn,error

    public static String DEBUG="debug";
    public static String WARN="warn";//level表明会出现潜在错误的情形
    public static String INFO="info";
    public static String ERROR="error";//level指出虽然发生错误事件，但仍然不影响系统的继续运行
    public static String FATAL="fatal";//level指出每个严重的错误事件将会导致应用程序的退出


    /*public enum DaifaExceptionEnum{
        DEBUG("debug"),
        WARN("warn"),//level表明会出现潜在错误的情形
        ERROR("error"),//level指出虽然发生错误事件，但仍然不影响系统的继续运行
        INFO("info"),
        FATAL("fatal");//level指出每个严重的错误事件将会导致应用程序的退出
        private String msg;
        DaifaExceptionEnum(String msg){
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

    }*/

    public DaifaException() {
        super();
    }

    public DaifaException(String message) {
        super(message);
    }
    public DaifaException(String message,String level) {
        super(message);
        this.level=level;
    }



    public String getLevel () {
        return level;
    }

    public void setLevel (String level) {
        this.level = level;
    }
}
