package com.openJar.responses.api;

import com.openJar.beans.SdkJdImgzoneCategory;
import com.openJar.responses.Response;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created By admin on 2017/12/27/17:33
 */
public class JdImgzoneCategoryResponse extends Response {
    private List<SdkJdImgzoneCategory> datas;

    public List<SdkJdImgzoneCategory> getDatas() {
        return this.datas;
    }

    public void setDatas(List<SdkJdImgzoneCategory> datas) {
        this.datas = datas;
    }
}
