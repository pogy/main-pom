package com.shigu.main4.tools;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.*;

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

    @Value("${oss.dir}")
    private String dir;

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
     * 流式上传
     * @param inputStream
     * @param filePath
     * @return
     */
    public String uploadFile(InputStream inputStream,String filePath){
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件流
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
     * 创建一个文件夹
     * @param parentDir 上层目录
     * @param dirName 创建新目录
     */
    public String createDir(String parentDir, String dirName) {
        if (StringUtils.isEmpty(parentDir))  {
            parentDir = "";
        }
        String createdDir = null;
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            int end = dirName.lastIndexOf("/");
            if (end != dirName.length() -1) {
                dirName = dirName + "/";
            }

            createdDir = parentDir + dirName;
            ossClient.putObject(bucketName, createdDir, new ByteArrayInputStream(new byte[0]));
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return createdDir;
    }

    /**
     * 列出目录下所有的文件信息
     * @param filePath 目录
     */
    public List<OssFile> listFiles( String filePath) {
        OSSClient ossClient = null;
        List<OssFile> fileList = new ArrayList<OssFile>();
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ObjectListing objectListing = ossClient.listObjects(bucketName, filePath);
            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                OssFile file = new OssFile();
                file.setLastModified(objectSummary.getLastModified());
                file.setName(objectSummary.getKey());
                file.setSize(objectSummary.getSize());
                file.setType(0);//文件
                fileList.add(file);
            }
            for (String commonPrefix : objectListing.getCommonPrefixes()) {
                OssFile file = new OssFile();
                file.setName(commonPrefix);
                file.setType(1);//目录
                fileList.add(file);
            }
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return fileList;
    }

    /**
     * 重命名文件
     * @param srcFilePath  原名
     * @param dstFilePath  目标名
     */
    public void renameFile(String srcFilePath, String dstFilePath) {
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 拷贝Object
            CopyObjectResult result = ossClient.copyObject(bucketName, srcFilePath, bucketName, dstFilePath);
            logger.info("ETag: " + result.getETag() + " LastModified: " + result.getLastModified());
            ossClient.deleteObject(bucketName,srcFilePath);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 删除一个文件
     * @param filePath
     */
    public void deleteFile(String filePath) {
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
     * 移动文件
     * @param srcFilePath  原路径
     * @param dstFilePath  目标路径
     */
    public void moveFile(String srcFilePath, String dstFilePath) {
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 拷贝Object
            CopyObjectResult result = ossClient.copyObject(bucketName, srcFilePath, bucketName, dstFilePath);
            logger.info("ETag: " + result.getETag() + " LastModified: " + result.getLastModified());
            ossClient.deleteObject(bucketName,srcFilePath);
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

    /**
     * 构造Post签名信息
     * @return
     */
    public Map<String, String> createPostSignInfo() throws UnsupportedEncodingException {
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        Map<String, String> respMap = new LinkedHashMap<String, String>();

        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = client.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = client.calculatePostSignature(postPolicy);


        respMap.put("accessid", accessKeyId);
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", dir);
        respMap.put("host", domain);
        respMap.put("expire", String.valueOf(expireEndTime / 1000));
        return respMap;
    }


    /**
     * 添加关联关系
     * @param file
     * @param goodsId
     * @return
     */
    public void addRelatedGoods(String file, Long goodsId) {

    }

    /**
     * 删除关联关系
     * @param file
     * @param goodsId
     * @return
     */
    public void delRelatedGoods(String file, Long goodsId) {

    }

    /**
     * 返回关联商品
     * @param file
     * @return
     */
    public List<OssFile> selRelatedGoods(String file) {
        return null;
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
