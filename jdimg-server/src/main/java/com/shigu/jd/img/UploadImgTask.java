package com.shigu.jd.img;

import com.openJar.commons.MD5Attestation;
import com.shigu.jd.tools.DownImage;
import com.shigu.jd.tools.JdOssIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;

/**
 * Created By admin on 2018/1/19/10:49
 */
public class UploadImgTask implements Callable<String> {
    private String url;

    public  String folder;

    private Long jdUid;

    private JdOssIO jdOssIO;

    private FileInputStream input;

    @Override
    public String call() throws Exception {
        byte[] bytes;
        Long contentLength;
        if(input!=null){
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int rc;
            while ((rc = input.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            bytes = swapStream.toByteArray();
            contentLength = input.getChannel().size();
        }else{
            contentLength = DownImage.getContentLengthClose(url);
            bytes = DownImage.downImgFile(url);
        }
        InputStream input = new ByteArrayInputStream(bytes);
        String pictureName = MD5Attestation.MD5Encode(bytes.toString());
        String filePath=folder+"/"+pictureName+".jpg";
        return jdOssIO.uploadFile(contentLength, input, filePath);
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getJdUid() {
        return this.jdUid;
    }

    public void setJdUid(Long jdUid) {
        this.jdUid = jdUid;
    }

    public JdOssIO getJdOssIO() {
        return this.jdOssIO;
    }

    public void setJdOssIO(JdOssIO jdOssIO) {
        this.jdOssIO = jdOssIO;
    }

    public String getFolder() {
        return this.folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public FileInputStream getInput() {
        return this.input;
    }

    public void setInput(FileInputStream input) {
        this.input = input;
    }
}
