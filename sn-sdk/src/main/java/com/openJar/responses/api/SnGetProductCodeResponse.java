package com.openJar.responses.api;

import com.openJar.responses.Response;

public class SnGetProductCodeResponse extends Response{
    private String productCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
