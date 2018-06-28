package com.openJar.responses.api;

import com.openJar.responses.Response;
import com.suning.api.entity.integrate.itemContentsAddResponse;

public class SnItemAddResponse extends Response{
    private itemContentsAddResponse.ItemContents itemContents;

    public itemContentsAddResponse.ItemContents getItemContents() {
        return itemContents;
    }

    public void setItemContents(itemContentsAddResponse.ItemContents itemContents) {
        this.itemContents = itemContents;
    }
}
