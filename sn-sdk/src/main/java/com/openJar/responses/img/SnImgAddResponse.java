package com.openJar.responses.img;

import com.openJar.responses.Response;
import com.suning.api.entity.item.NPicAddResponse;

import java.util.List;

public class SnImgAddResponse extends Response{
    private List<NPicAddResponse.AddNPic> addNPics;

    public List<NPicAddResponse.AddNPic> getAddNPics() {
        return addNPics;
    }

    public void setAddNPics(List<NPicAddResponse.AddNPic> addNPics) {
        this.addNPics = addNPics;
    }
}
