package com.openJar.responses.api;

import com.openJar.responses.Response;

public class JdTransportWriteUpdateWareTransportIdResponse extends Response{
    private boolean can;

    public boolean isCan() {
        return this.can;
    }

    public void setCan(boolean can) {
        this.can = can;
    }
}
