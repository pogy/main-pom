package com.shigu.tools;

import com.aliyun.oss.OSSClient;

import java.io.InputStream;

/**
 * Created by wxc on 2017/2/27.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class OSSUtil {

    // endpoint以杭州为例，其它region请按实际情况填写
    public static String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // accessKey
    public static String accessKeyId = "YsqgyCrBUiYFIdRE";
    public static String accessKeySecret = "KdV0QWhwUbftdfLpOoED1cIq1bHPyA";
    public static String bucket = "shigu";

    public static void deleteObject(String key) {
        OSSClient client = newOSSClient();
        client.deleteObject(bucket, key);
        client.shutdown();
    }

    public static String addItemPic(String fileName, InputStream file) {
        OSSClient client = newOSSClient();
        String path = "mall/file/"+fileName;
        client.putObject(bucket, path,file);
        return "http://imgs.571xz.net/" + path;
    }

    private static OSSClient newOSSClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }
}