package com.shigu.jd.tools;

import com.jcloud.jss.JingdongStorageService;
import com.jcloud.jss.constant.JssHeaders;
import com.jcloud.jss.domain.ObjectListing;
import com.jcloud.jss.domain.ObjectSummary;
import com.jcloud.jss.domain.StorageClass;
import com.jcloud.jss.exception.StorageClientException;
import com.jcloud.jss.exception.StorageServerException;
import com.jcloud.jss.service.BucketService;
import com.jcloud.jss.service.ObjectService;
import com.shigu.exceptions.ImgDownloadException;
import com.shigu.exceptions.OtherCustomException;
import com.shigu.main4.common.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;


/**
 * oss io 交互
 * Created by zhaohongbo on 17/4/21.
 */
@Component
public class JdOssIO {


    // endpoint以杭州为例，其它region请按实际情况填写
    @Value("${jdoss.endpoint}")
    private String endpoint;
    // accessKey
    @Value("${jdoss.accessKeyId}")
    private String accessKeyId;

    @Value("${jdoss.accessKeySecret}")
    private String accessKeySecret;
    // 空间
    private String bucketName="shigu";

    @Value("${jdoss.ossHost}")
    private String domain;

    /**
     * 上传一个文件
     *
     * @param f        文件
     * @param filePath 上传的目录,不能以/开头
     */
    public  String uploadFile(File f, String filePath) throws FileNotFoundException {
        //创建JingdongStorageService实例
        JingdongStorageService jss = null;
        try {
            jss = initClient();

            //PutObject -- 流式上传
            //创建objectService实例
            ObjectService inputStreamPutService = jss.bucket(bucketName).object(filePath);
            //使用低冗余存储，则使用该句代码
            inputStreamPutService.getBuilder().getHeaders().put(JssHeaders.X_JSS_STORAGE_CLASS, StorageClass.ReducedRedundancy.toString());

            //设置上传文件Content-type为"text/html"。函数返回上传数据的Etag,目前Etag的值为上传数据的MD5
            inputStreamPutService.entity(f).contentType("image/jpeg").put();
            //若对上传文件进行加密，则使用该句代码
            //String inputStreamMd5 = objectService.entity(contentLength,inputStream).contentType("text/html").put(true);
        } catch (StorageClientException e) {
            e.printStackTrace();
        } catch (StorageServerException e) {
            e.printStackTrace();
        } finally {
            if (jss != null) {
                jss.destroy();
            }
        }
        return domain +"/" + filePath;
    }

    /**
     * 流式上传
     *
     * @param contentLength
     * @param inputStream
     * @param filePath
     * @return
     */
    public  String uploadFile(Long contentLength, InputStream inputStream, String filePath) {
        //创建JingdongStorageService实例
        JingdongStorageService jss = null;
        try {
            jss = initClient();

            //PutObject -- 流式上传
            //创建objectService实例
            ObjectService inputStreamPutService = jss.bucket(bucketName).object(filePath);
            //使用低冗余存储，则使用该句代码
            inputStreamPutService.getBuilder().getHeaders().put(JssHeaders.X_JSS_STORAGE_CLASS, StorageClass.ReducedRedundancy.toString());

            //设置上传文件Content-type为"text/html"。函数返回上传数据的Etag,目前Etag的值为上传数据的MD5
            inputStreamPutService.entity(contentLength, inputStream).contentType("image/jpeg").put();
            //若对上传文件进行加密，则使用该句代码
            //String inputStreamMd5 = objectService.entity(contentLength,inputStream).contentType("text/html").put(true);
        } catch (StorageClientException e) {
            e.printStackTrace();
        } catch (StorageServerException e) {
            e.printStackTrace();
        } finally {
            if (jss != null) {
                jss.destroy();
            }
        }
        return domain + "/" +filePath;
    }


    public  void deleteFile(String filePath) {
        //创建JingdongStorageService实例
        JingdongStorageService jss = null;
        try {
            jss = initClient();

            //PutObject -- 流式上传
            //创建objectService实例
            BucketService bucketService = jss.bucket(bucketName);
            ObjectListing objectList = bucketService.listObject();
            for (ObjectSummary objectSummary : objectList.getObjectSummaries()) {
                ObjectService service = bucketService.object(objectSummary.getKey());
                service.delete();
            }
        } catch (StorageClientException e) {
            e.printStackTrace();
        } catch (StorageServerException e) {
            e.printStackTrace();
        } finally {
            if (jss != null) {
                jss.destroy();
            }
        }
    }

    /**
     * 得到Oss适配器
     *
     * @return
     */
    public  JingdongStorageService initClient() {
        JingdongStorageService jss = new JingdongStorageService(accessKeyId,accessKeySecret);
        jss.setEndpoint(endpoint);
        return jss;
    }

}
