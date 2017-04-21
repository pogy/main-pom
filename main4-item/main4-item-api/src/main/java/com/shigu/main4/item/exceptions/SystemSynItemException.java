package com.shigu.main4.item.exceptions;

/**
 * Created by wxc on 2017/3/3.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class SystemSynItemException extends ItemException {

    private static final long serialVersionUID = 140564995359500983L;

    public SystemSynItemException() {
    }

    public SystemSynItemException(SynItemExceptionEnum exceptionEnum) {
        super(exceptionEnum.message);
        this.code = exceptionEnum.code;
    }

    public enum  SynItemExceptionEnum {

        ES_SYN_HAS_ERROR("ES_SYN_HAS_ERROR", "请求搜索引擎批量同步商品时失败"),
        ;
        public String code;
        public String message;

        SynItemExceptionEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
