package com.shigu.jd.img.services;


import com.openJar.commons.MD5Attestation;
import com.openJar.requests.imgs.JdUpImgRequest;
import com.openJar.responses.imgs.JdUpImgResponse;
import com.openJar.tools.OpenClient;
import com.openJar.tools.PcOpenClient;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.jd.tools.DownImage;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class ImgMovingServiceTest {

    @Test
    public void imgUploadTest(){
        OpenClient client=new PcOpenClient("3838438","37456A6A5CA10F9A988F12BFECD88575","test");
        JdUpImgRequest request = new JdUpImgRequest();
        request.setJdUid(2299600652L);
        request.setImgUrls(Arrays.asList("http://imgs.571xz.net/banjia/4c60837d1018a39a0459ce446824c795.jpg","https://img.alicdn.com/bao/uploaded/i4/2351239052/TB2lvDNXQT85uJjSZFhXXcPEVXa_!!2351239052.jpg_300x300.jpg"));
        request.setPictureCateId(47350850L);
        JdUpImgResponse response = client.execute(request);
        //1，操作成功；0，操作失败
        if ("0".equals(response.getReturnCode())) {
            System.err.println(response.getDesc());
        }
    }

    @Test
    public void byteMd5() throws OtherCustomException {
        String imgUrl = "http://imgs.571xz.net/mall/xzw/11ac6d63-f577-4bf4-9c99-5a877e44e7ed.jpg";
        byte[] bytes = DownImage.downImgFile(imgUrl);
        String pictureName = MD5Attestation.MD5Encode(bytes.toString());
        System.err.println(pictureName);
    }
}
