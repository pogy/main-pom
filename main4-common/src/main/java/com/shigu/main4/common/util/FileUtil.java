package com.shigu.main4.common.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 文件操作
 * @author shigu_zjb
 * @date 2017/03/02 15:37
 *
 */
public class FileUtil {

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }


    // 缓存文件头信息-文件头信息
    public static final HashMap<String, String> mFileTypes = new HashMap<>();
    // 缓存图片文件格式信息
    public static List<String> imgTypes = Arrays.asList("jpg","png","gif","tif","bmp");

    static {
        // images
        mFileTypes.put("FFD8FF", "jpg");
        mFileTypes.put("89504E47", "png");
        mFileTypes.put("47494638", "gif");
        mFileTypes.put("49492A00", "tif");
        mFileTypes.put("424D", "bmp");
        //
        mFileTypes.put("41433130", "dwg"); // CAD
        mFileTypes.put("38425053", "psd");
        mFileTypes.put("7B5C727466", "rtf"); // 日记本
        mFileTypes.put("3C3F786D6C", "xml");
        mFileTypes.put("68746D6C3E", "html");
        mFileTypes.put("44656C69766572792D646174653A", "eml"); // 邮件
        mFileTypes.put("D0CF11E0", "doc");
        mFileTypes.put("5374616E64617264204A", "mdb");
        mFileTypes.put("252150532D41646F6265", "ps");
        mFileTypes.put("255044462D312E", "pdf");
        mFileTypes.put("504B03040A00000000008", "docx");
        mFileTypes.put("504B0304", "zip");// zip 压缩文件
        mFileTypes.put("52617221", "rar");
        mFileTypes.put("57415645", "wav");
        mFileTypes.put("41564920", "avi");
        mFileTypes.put("2E524D46", "rm");
        mFileTypes.put("000001BA", "mpg");
        mFileTypes.put("000001B3", "mpg");
        mFileTypes.put("6D6F6F76", "mov");
        mFileTypes.put("3026B2758E66CF11", "asf");
        mFileTypes.put("4D546864", "mid");
        mFileTypes.put("1F8B08", "gz");
    }

    /**
     * 根据文件路径获取文件类型
     * @return 文件类型
     */
    public static String getFileType(InputStream stream) {
        String value = getFileHeader(stream);
        String result = "";
        for (Map.Entry<String, String> entry : mFileTypes.entrySet()) {
            if (value.startsWith(entry.getKey())) {
                result = entry.getValue();
            }
        }
        return result;
    }

    /**
     * 根据文件路径获取文件头信息
     *
     * @return 文件头信息
     */
    public static String getFileHeader(InputStream is) {
        String value = "";
        try {
            byte[] b = new byte[20];
            is.read(b, 0, b.length);
            value = bytesToHexString(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /**
     * 将要读取文件头信息的文件的byte数组转换成string类型表示
     *
     * @param src
     *            要读取文件头信息的文件的byte数组
     * @return 文件头十六进制信息
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
//        System.out.println("HexString: " + builder.toString());
        return builder.toString();
    }


    public static void main(String[] args) throws Exception {
        String fileType = getFileType(new FileInputStream("D:\\1.txt"));
        System.out.println(fileType);
    }


}
