package com.openJar.responses.interfaces;

import com.openJar.beans.ShiguJdcat;
import com.openJar.responses.Response;

public class SelShiguJdCatResponse extends Response{
    private ShiguJdcat data;

    public ShiguJdcat getData() {
        return this.data;
    }

    public void setData(ShiguJdcat data) {
        this.data = data;
    }
}
