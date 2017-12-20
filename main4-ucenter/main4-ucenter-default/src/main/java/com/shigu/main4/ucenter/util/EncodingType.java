package com.shigu.main4.ucenter.util;

/**
 * 编码集合
 * Created by zhaohongbo on 17/8/3.
 */
public enum EncodingType {
    UTF_8("UTF-8"),
    ISO_8859_1("ISO-8859-1"),
    GBK("GBK"),
    GB2312("GB2312"),
    GB18030("GB18030"),
    UNICODE("UNICODE"),
    UTF_16LE("UTF-16LE"),
    UTF_16BE("UTF-16BE"),
    US_ASCII("US-ASCII"),
    BIG5("BIG5");
    private final String encodingName;
    EncodingType(String encodingName) {
        this.encodingName = encodingName;
    }
    public String getEncodingName() {
        return encodingName;
    }
    @Override
    public String toString() {
        return this.getEncodingName();
    }
}
