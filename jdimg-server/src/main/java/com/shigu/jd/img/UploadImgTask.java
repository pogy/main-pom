package com.shigu.jd.img;

import com.shigu.jd.tools.JdOssIO;
import java.io.InputStream;
import java.util.concurrent.Callable;

/**
 * Created By admin on 2018/1/19/10:49
 */
public class UploadImgTask implements Callable<String> {
    /**
     * 文件大小
     */
    private Long contentLength;

    private InputStream input;

    private String filePath;

    private JdOssIO jdOssIO;

    @Override
    public String call() throws Exception {
        return jdOssIO.uploadFile(contentLength, input, filePath);
    }

    public Long getContentLength() {
        return contentLength;
    }

    public void setContentLength(Long contentLength) {
        this.contentLength = contentLength;
    }

    public InputStream getInput() {
        return input;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public JdOssIO getJdOssIO() {
        return jdOssIO;
    }

    public void setJdOssIO(JdOssIO jdOssIO) {
        this.jdOssIO = jdOssIO;
    }
}
