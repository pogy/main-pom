package com.shigu.main4.tools;

import com.aliyun.oss.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * oss io 交互
 * Created by zhaohongbo on 17/4/21.
 */
@Component
public class OssIO {
    private static final Logger logger = LoggerFactory.getLogger(OssIO.class);

    // endpoint以杭州为例，其它region请按实际情况填写
    @Value("${oss.endpoint}")
    private String endpoint;
    // accessKey
    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;
    // 空间
    private String bucketName="shigu";

    @Value("${oss.ossHost}")
    private String domain;

    /**
     * 上传一个文件
     * @param f 文件
     * @param filePath 上传的目录,不能以/开头
     */
    public String uploadFile(File f,String filePath) throws FileNotFoundException {
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件流
            InputStream inputStream = new FileInputStream(f);
            ossClient.putObject(bucketName, filePath, new BufferedInputStream(inputStream));
// 关闭client
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return domain+filePath;
    }

    /**
     * 上传一个文件
     * @param data 文件
     * @param filePath 上传的目录,不能以/开头
     */
    public String uploadFile(byte[] data,String filePath) throws FileNotFoundException {
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件流
            ossClient.putObject(bucketName, filePath, new ByteArrayInputStream(data));
// 关闭client
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return domain+filePath;
    }

    /**
     * 删除一个文件
     * @param filePath
     */
    public void deleteFile(String filePath){
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 删除Object
            ossClient.deleteObject(bucketName, filePath);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 文件是否存在
     * @param filePath
     * @return
     */
    public boolean fileExist(String filePath){
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            return ossClient.doesObjectExist(bucketName, filePath);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }


    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
