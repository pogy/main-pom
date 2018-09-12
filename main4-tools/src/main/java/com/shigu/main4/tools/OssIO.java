package com.shigu.main4.tools;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
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



    /**
     * 上传一个文件
     * @param f 文件
     * @param filePath 上传的目录,不能以/开头
     */
    public String uploadFile(File f,String filePath) throws FileNotFoundException {
        return uploadFile(new FileInputStream(f), filePath);
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
    public List<OssFile> getFileList(String filePath) {
        OSSClient ossClient = null;
        List<OssFile> fileList = new ArrayList<OssFile>();
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ObjectListing objectListing = ossClient.listObjects(bucketName, filePath);

            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) { //以"/"结尾的是目录，否则是文件
                if(objectSummary.getKey().equals(filePath)){
                    continue;
                }
                OssFile file = new OssFile();
                file.setFileCreateTime(objectSummary.getLastModified().getTime());
                file.setFileId(objectSummary.getKey());
                file.setFileSize(String.valueOf(objectSummary.getSize()));//kb
                file.setFileName(objectSummary.getKey());
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
     * 获取文件或者目录总大小,以b为单位
     * @param filePath  文件路径
     */
    public long getSizeInfo(String filePath) {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        Long totalSize = 0L;
        if(filePath.endsWith("/")) {//目录
            ObjectListing objectListing = ossClient.listObjects(bucketName, filePath);
            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                totalSize += objectSummary.getSize();
            }
        } else {//单个文件
            OSSObject ossObject = ossClient.getObject(bucketName, filePath);
            ObjectMetadata metadata = ossObject.getObjectMetadata();
            totalSize += metadata.getContentLength();
        }

        return totalSize;
    }

    /**
     * 获取文件夹下的所有文件大小总合
     * @param filePath
     * @return
     */
    public Long getFileAllSizeInfo(String filePath){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        Long totalSize = 0L;
        if(filePath.endsWith("/")) {//目录
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
            // 列出fun目录下的所有文件和文件夹
            listObjectsRequest.setPrefix(filePath);
            ObjectListing objectListing = ossClient.listObjects(listObjectsRequest);
            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                totalSize += objectSummary.getSize();
            }
        } else {//单个文件
            OSSObject ossObject = ossClient.getObject(bucketName, filePath);
            ObjectMetadata metadata = ossObject.getObjectMetadata();
            totalSize += metadata.getContentLength();
        }

        return totalSize;
    }


    /**
     * 删除一个文件
     * @param filePath
     */
    public boolean deleteFile(String filePath) {
        boolean ret = true;
        // 创建OSSClient实例
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            if(filePath.endsWith("/")) {//目录
                ObjectListing objectListing = ossClient.listObjects(bucketName, filePath);
                List<OSSObjectSummary> summaries = objectListing.getObjectSummaries();
                int size = summaries.size();
                for (int i=size-1; 0<= i;i--) {
                    ossClient.deleteObject(bucketName, summaries.get(i).getKey());
                }
            } else {
                ossClient.deleteObject(bucketName, filePath);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            ret = false;
        }
        finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return ret;
    }

    /**
     * 移动文件
     * @param srcFilePath  原路径
     * @param dstFilePath  目标路径
     */
    public boolean moveFile(String srcFilePath, String dstFilePath) {
        boolean ret = true;
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            // 拷贝Object
            CopyObjectResult result = ossClient.copyObject(bucketName, srcFilePath, bucketName, dstFilePath );
            logger.info("ETag: " + result.getETag() + " LastModified: " + result.getLastModified());
            deleteFile(srcFilePath);
        } catch (Exception e) {
            logger.error(e.getMessage());
            ret = false;
        } finally {
            ossClient.shutdown();
        }
        return ret;
    }

    /**
     * 下载图片到本地
     * @param localPath  本地存放路径
     * @param key 域名后面的路径，开头不要/
     * @return 本地文件
     */
    public File downFileToLocal(String localPath,String key){
// 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 下载object到文件
        ossClient.getObject(new GetObjectRequest(bucketName, key), new File(localPath));
// 关闭client
        ossClient.shutdown();
        return new File(localPath);
    }


    /**
     * 重命名文件
     * @param srcFilePath  原名
     * @param dstFilePath  目标名
     */
    public boolean renameFile(String srcFilePath, String dstFilePath) {
        boolean ret = true;
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            if(srcFilePath.endsWith("/")) {//目录
                ObjectListing objectListing = ossClient.listObjects(bucketName, srcFilePath);
                for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                    String newDstFilePathItem = dstFilePath + objectSummary.getKey().substring(srcFilePath.length());
                    ossClient.copyObject(bucketName, objectSummary.getKey(), bucketName, newDstFilePathItem);
                }
            } else {
                // 拷贝Object
                CopyObjectResult result = ossClient.copyObject(bucketName, srcFilePath, bucketName, dstFilePath);
                logger.info("ETag: " + result.getETag() + " LastModified: " + result.getLastModified());
            }

            deleteFile(srcFilePath);
        } catch (Exception e) {
            logger.error(e.getMessage());
            ret = false;
        } finally {
            ossClient.shutdown();
        }
        return ret;
    }

    /**
     * 文件是否存在
     * @param filePath
     * @return
     */
    public boolean fileExist(String filePath){
        boolean ret = true;
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ret =  ossClient.doesObjectExist(bucketName, filePath);
        } catch (Exception e) {
            logger.error(e.getMessage());
            ret = false;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return ret;
    }

    /**
     * 构造Post签名信息
     * @return
     */
    public Map<String, String> createPostSignInfo(String filepath) throws UnsupportedEncodingException {
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        Map<String, String> respMap = new LinkedHashMap<String, String>();

        long expireTime = 600;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, filepath);

        String postPolicy = client.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = client.calculatePostSignature(postPolicy);

        respMap.put("accessid", accessKeyId);
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", filepath);
        respMap.put("host", domain);
        respMap.put("expire", String.valueOf(expireEndTime / 1000));
        return respMap;
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
