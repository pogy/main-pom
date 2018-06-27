package com.openJar.responses.img;

import com.openJar.responses.Response;
import com.suning.api.entity.item.NPicAddResponse;

public class SnImgAddResponse extends Response{
    private NPicAddResponse.AddNPic addNPic;

    public NPicAddResponse.AddNPic getAddNPic() {
        return addNPic;
    }

    public void setAddNPic(NPicAddResponse.AddNPic addNPic) {
        this.addNPic = addNPic;
    }
}
