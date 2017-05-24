package com.shigu.main4.tools;

import com.shigu.imgsearch.ImgSearchClient;
import com.shigu.imgsearch.requests.ImgRequest;
import com.shigu.imgsearch.responses.ImgResponse;

import java.io.IOException;

/**
 *
 * Created by bugzy on 2017/5/23 0023.
 */
public enum ImgClientEnum {

    /**
     * 杭州图搜
     */
    hz("aliyun_1582227", "vsDnnCviEeeHHwAWPhwgkg"),

    /**
     * 常熟、濮院图搜
     */
    cs("aliyun_1664974", "3fFTUD9fEeeHHwAWPhwgkg"),
    jx("aliyun_1664974", "3fFTUD9fEeeHHwAWPhwgkg"),

    ;

    private ImgSearchClient client;
    ImgClientEnum(String key, String secret) {
        this.client = new ImgSearchClient(key, secret);
    }

    public <T extends ImgResponse> T execute(ImgRequest<T> request) throws IOException {
        return client.execute(request);
    }
}
