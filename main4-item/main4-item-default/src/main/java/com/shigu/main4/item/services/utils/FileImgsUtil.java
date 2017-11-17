package com.shigu.main4.item.services.utils;

import com.shigu.main4.common.util.UUIDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.apache.tools.zip.ZipEntry;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 图片文件打包工具
 *
 */
public class FileImgsUtil {

    /**
     * =========================================================
     *
     * @param savepicPath
     * @param imageString
     * @时间：2014-7-2下午5:06:10
     * @方法名：addpic
     * @功能： 多个子图
     * @return:String<br>
     * @since: =========================================================
     */
    public static String addpic(String savepicPath, String imageString, String fileName) {
        String images = "";
        if (imageString != null && !"".equals(imageString)) {
            images += savePic(savepicPath,imageString,fileName);
        }
        return images;

    }


    /**
     * =========================================================
     *
     * @param savepicPath
     * @param url:void<br>
     * @时间：2014-7-2下午4:52:20
     * @方法名：savePic
     * @功能： 存储图片
     * @since: =========================================================
     */
    private static String savePic(String savepicPath, String url, String fileName) {
        String result = "";
        String picnameString[] = url.split("/");
        String picname = picnameString[picnameString.length - 1];

        Connection con = HttpConnUtil.getConnection(url);
        if (con != null) {
            Map<String, String> map = HttpConnUtil.getAllCookie(con);
            if (map != null) {
                Connection conn = HttpConnUtil.getConnection(url)
                        .cookies(map)

                        .timeout(100000);          // 设置连接超时时间
                File f2 = new File(savepicPath);

                // 创建文件夹
                if (!f2.exists()) {
                    f2.mkdirs();
                }
                result = fileName;
                if(StringUtils.isEmpty(result)){
                    result = UUIDGenerator.getUUID();
                }

                int suffixStartIndex = url.lastIndexOf(".");
                String suffix = url.substring(suffixStartIndex,url.length());

                File file = new File(savepicPath + result + suffix);

                BufferedOutputStream bos;
                try {
                    bos = new BufferedOutputStream(new FileOutputStream(file));

                    bos.write(conn.execute().bodyAsBytes());
                    bos.flush();
                    bos.close();

                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                } catch (Exception e) {

                }
            }

        } else {
        }
        return result;
    }

    /**
     * 存储详情中的文件
     *
     * @param savepicPath
     * @param desc
     * @return
     */
    public static String addDescpic(String savepicPath, String desc) {

        Document doc1 = Jsoup.parse(desc);
        Elements doc1_IMG = doc1.select("img");
        int picnum = 1;
        for (int i = 0; i < doc1_IMG.size(); i++) {
            String linkUrl = doc1_IMG.get(i).attr("src");
            if ("http://style.571xz.com/shop_item_temp/css/imgs/loading_s.gif".equals(linkUrl)) {
                linkUrl = doc1_IMG.get(i).attr("data-original");
            }
            if (linkUrl != null && (linkUrl.endsWith(".jpg") || linkUrl.endsWith(".png") || linkUrl.endsWith(".jpeg") || linkUrl.endsWith(".gif") || linkUrl.endsWith(".JPG") || linkUrl.endsWith(".PNG") || linkUrl.endsWith(".JPEG")||linkUrl.endsWith(".GIF"))) {
                savedescPic(savepicPath, linkUrl, picnum);
                picnum++;
            }
        }
        //desc.split()
        return "";

    }

    /**
     * =========================================================
     *
     * @param savepicPath
     * @param url:void<br>
     * @时间：2014-7-2下午4:52:20
     * @方法名：savePic
     * @功能： 存储图片
     * @since: =========================================================
     */
    private static String savedescPic(String savepicPath, String url, int picnum) {
        String result = "";
        Connection con = HttpConnUtil.getConnection(url);
        if (con != null) {
            Map<String, String> map = HttpConnUtil.getAllCookie(con);
            if (map != null) {
                Connection conn = HttpConnUtil.getConnection(url).cookies(map).timeout(100000);          // 设置连接超时时间
                File f2 = new File(savepicPath);
                // 创建文件夹
                if (!f2.exists()) {
                    f2.mkdirs();
                }
                String extnames[] = url.split("\\.");
                String exts = extnames[extnames.length - 1];
                File file = new File(savepicPath + picnum + "." + exts);
                BufferedOutputStream bos;
                try {
                    bos = new BufferedOutputStream(new FileOutputStream(file));
                    bos.write(conn.execute().bodyAsBytes());
                    bos.flush();
                    bos.close();
                } catch (Exception ignored) {
                }
            }
        }
        return result;
    }


    /**
     * =========================================================
     *
     * @param path
     * @param zipFileName
     * @throws Exception:void<br>
     * @时间：2014-7-2下午9:26:22
     * @方法名：zip
     * @功能： //压缩（整体文件夹）
     * @since: =========================================================
     */
    public static void zip(String path, String zipFileName) throws Exception {
        zip(zipFileName, new File(path));
    }

    private static void zip(String zipFileName, File path) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out, path, "");
        out.finish();
        out.close();
    }

    private static void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            if (fl != null) {
                base = base.length() == 0 ? "" : base + "/";
                for (File aFl : fl) {
                    zip(out, aFl, base + aFl.getName());
                }
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(in);
            byte[] tmp = new byte[204800];
            int b;
            while ((b = bis.read(tmp)) != -1) {
                out.write(tmp, 0, b);
            }
            bis.close();
        }
    }

    /**
     * 压缩文件
     *
     * @param srcfile File[] 需要压缩的文件列表
     * @param zipfile File 压缩后的文件
     */
    public static void ZipFiles(File[] srcfile, File zipfile) {
        byte[] buf = new byte[1024];
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            for (int i = 0; i < srcfile.length; i++) {
                FileInputStream in = new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                String str = srcfile[i].getName();
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            //System.out.println("压缩完成.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
