package com.shigu.main4.packages.util;

import com.shigu.main4.common.util.UUIDGenerator;
import org.apache.tools.zip.ZipEntry;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * ==========================================================
 * TODO
 *
 * @类编号：
 * @类名称：DataPackageUtil.java
 * @文件路径：com.shigu.common.utils.DataPackageUtil.java
 * @内容摘要：数据包处理
 * @编码作者：顾邹阳
 * @完成日期：
 * @Date2014-7-2下午9:24:56
 * @comments: =========================================================
 */
public class DataPackageUtil {

    /**
     * =========================================================
     *
     * @param args:void<br>
     * @时间：2014-7-2下午9:24:56
     * @方法名：main
     * @功能：
     * @since: =========================================================
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            zip("/Users/gzy/testsjb/sjbfolder/dataupload/201602/35377/1456736754806/571sjb/1456736754806/", "/Users/gzy/testsjb/sjbfolder/dataupload/201602/35377/1456736754806/571sjb/a59f4c07016e45308ede98581b13ef69.zip");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		/*String desc="<div style='text-align:center;'><p style='color:#000000;'><strong style='line-height:54.0px;font-size:36.0px;'><span style='font-family:microsoft yahei;'><span style='background-color:#ffff00;'>&nbsp; &nbsp;100%韩国官网模特 自主实拍 &nbsp;&nbsp;</span></span></strong></p><p style='color:#000000;'><strong><span style='color:#ffffff;'><span style='font-size:24.0px;'><span style='background-color:#ff0000;'>&nbsp; &nbsp;颜色：红色 &nbsp;&nbsp;</span></span></span></strong></p><p style='color:#000000;'><span style='font-size:24.0px;'></span></p><div><span style='line-height:1.5;color:#ff0000;'>面料成分：全涤｛俗名：加厚双层麻｝ &nbsp;&nbsp;</span><span style='line-height:1.5;color:#ff0000;'>里布：舒美绸</span></div><div>&nbsp;</div><div><span style='line-height:1.5;color:#ff0000;'></span>&nbsp;S &nbsp;肩+袖 70.5cm &nbsp; &nbsp;胸围 92cm &nbsp; &nbsp;衣长 90cm</div><div>&nbsp;</div><div>&nbsp;M &nbsp;肩+袖 72cm &nbsp; &nbsp; &nbsp; 胸围 96cm &nbsp; &nbsp;衣长 91cm</div><div>&nbsp;</div><div>&nbsp;L &nbsp; 肩+袖 73.5cm &nbsp; &nbsp;胸围 100cm &nbsp;衣长 92cm</div><div>&nbsp;</div><div>XL &nbsp;肩+袖 75cm &nbsp; &nbsp; &nbsp; &nbsp;胸围104cm &nbsp;衣长 93cm</div><div>&nbsp;</div><div><img align='absmiddle' src='https://img.alicdn.com/imgextra/i4/49221274/TB2_TCAeVXXXXXbXXXXXXXXXXXX_!!49221274.jpg'><img align='absmiddle' src='https://img.alicdn.com/imgextra/i2/49221274/TB2RA46eVXXXXcPXpXXXXXXXXXX_!!49221274.jpg'><img align='absmiddle' src='https://img.alicdn.com/imgextra/i3/49221274/TB2whmueVXXXXaZXXXXXXXXXXXX_!!49221274.jpg'><img align='absmiddle' src='https://img.alicdn.com/imgextra/i4/49221274/TB2S6iseVXXXXbEXXXXXXXXXXXX_!!49221274.jpg'><img align='absmiddle' src='https://img.alicdn.com/imgextra/i1/49221274/TB28VOleVXXXXcGXXXXXXXXXXXX_!!49221274.jpg'><img align='absmiddle' src='https://img.alicdn.com/imgextra/i1/49221274/TB2R8yneVXXXXcwXXXXXXXXXXXX_!!49221274.jpg'><img align='absmiddle' src='https://img.alicdn.com/imgextra/i3/49221274/TB2LBGteVXXXXbhXXXXXXXXXXXX_!!49221274.jpg'><img align='absmiddle' src='https://img.alicdn.com/imgextra/i2/49221274/TB2vjd_eVXXXXb_XpXXXXXXXXXX_!!49221274.jpg'></div></div>";
        String savepath="/Users/gzy/testsjb/sjbfolder/35377/1446111197968/xiangqing/";
		addDescpic(savepath,desc);*/
    }

    public static void createCsv(String date_package_contents, String savepath) {

        FileWriter fw = null;


        File f = new File(savepath);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            fw = new FileWriter(f);

            BufferedWriter out = new BufferedWriter(fw);
            out.write(date_package_contents, 0, date_package_contents.length() - 1);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * =========================================================
     *
     * @param page
     * @param contents
     * @时间：2014-7-17下午3:15:30
     * @方法名：printContent
     * @功能： 可用
     * @return:boolean<br>
     * @since: =========================================================
     */
    public static boolean printContent(String page, String contents) {
        //URL url;
        String rLine = null;
        FileOutputStream out = null;
        OutputStreamWriter writer = null;
        try {

            out = new FileOutputStream(page);
            //writer = new OutputStreamWriter(out, "gb2312");
            //writer = new OutputStreamWriter(out, "UTF-8");
            writer = new OutputStreamWriter(out, "x-utf-16le-bom"); //UTF-16LE//Unicode
            writer.write(contents);
            //out.flush();

            return true;
        } catch (IOException e) {
            ////System.out.println("error: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception es) {
            ////System.out.println(es.getMessage());
            return false;
        } finally {// 关闭资源
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void printCSV1(String date_package_contents, String savepath) {
		/*try {
			date_package_contents=new String(date_package_contents.getBytes(), "GB2312");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        String rLine = null;
        PrintWriter fileOut = null;
        InputStream ins = null;
        try {

            ins = new StringBufferInputStream(date_package_contents);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(ins, "utf-8"));// 获取编码为gb2312的文件

            FileOutputStream out = new FileOutputStream(savepath);
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
            fileOut = new PrintWriter(writer);
            // 循环取取数据,并写入目标文件中
            while ((rLine = bReader.readLine()) != null) {
                String tmp_rLine = rLine;
                int str_len = tmp_rLine.length();
                if (str_len > 0) {
                    fileOut.println(tmp_rLine);
                    fileOut.flush();
                }
                tmp_rLine = null;
            }


        } catch (IOException e) {
            ////System.out.println("error: " + e.getMessage());
            e.printStackTrace();

        } catch (Exception es) {
            ////System.out.println(es.getMessage());

        } finally {// 关闭资源
            fileOut.close();
            try {
                ins.close();
            } catch (IOException ex) {
                // 关闭输入流出错
                ex.printStackTrace();
            }
        }
    }

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
    public static String addpic(String savepicPath, String imageString) {
        String images = "";
        if (imageString != null && !"".equals(imageString)) {
            String imagesurl[] = imageString.split(",");

            if (imagesurl.length > 0) {
                int p = 0;
                int size = 0;
                size = imagesurl.length;
                if (imagesurl.length > 5) {
                    size = 5;
                }
                for (int i = 0; i < size; i++) {
                    //p=i+1;
                    p = i;
                    images += savePic(savepicPath, imagesurl[i]) + ":1:" + p + ":|;";
                    ;
                }

            }
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
    private static String savePic(String savepicPath, String url) {
        String result = "";
//        String picnameString[] = url.split("/");
//        String picname = picnameString[picnameString.length - 1];

        Connection con = HttpConnUtil.getConnection(url);
        if (con != null) {
            Map<String, String> map = HttpConnUtil.getAllCookie(con);
            if (map != null) {
                Connection conn = HttpConnUtil.getConnection(url)
                        // .data("IntCls", intCls)   // 请求参数
                        .cookies(map)

                        .timeout(100000);          // 设置连接超时时间
                File f2 = new File(savepicPath);

                // 创建文件夹
                if (!f2.exists()) {
                    f2.mkdirs();
                }


                // result=picname+"_460x460";
                //File file=new File(savepicPath+picname+"_460x460.tbi");
                result = UUIDGenerator.getUUID();
                File file = new File(savepicPath + result + ".tbi");

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
            //log.error(regNo+"原始图片保存出错输入输出流出错：连接断开了！");
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
        for (int i = 0; i < doc1_IMG.size(); i++) {
            String linkUrl = doc1_IMG.get(i).attr("src");
            if (linkUrl != null && (linkUrl.endsWith(".jpg") || linkUrl.endsWith(".png") || linkUrl.endsWith(".jpeg") || linkUrl.endsWith(".JPG") || linkUrl.endsWith(".PNG") || linkUrl.endsWith(".JPEG"))) {
                savedescPic(savepicPath, linkUrl, System.currentTimeMillis());
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
    private static String savedescPic(String savepicPath, String url, Long picnum) {
        String result = "";
        //String picnameString[]=url.split("/");
        //String picname=picnameString[picnameString.length-1];

        Connection con = HttpConnUtil.getConnection(url);
        if (con != null) {
            Map<String, String> map = HttpConnUtil.getAllCookie(con);
            if (map != null) {
                Connection conn = HttpConnUtil.getConnection(url)
                        // .data("IntCls", intCls)   // 请求参数
                        .cookies(map)

                        .timeout(100000);          // 设置连接超时时间
                File f2 = new File(savepicPath);

                // 创建文件夹
                if (!f2.exists()) {
                    f2.mkdirs();
                }

                // result=picname+"_460x460";
                //File file=new File(savepicPath+picname+"_460x460.tbi");
                String extnames[] = url.split("\\.");
                String exts = extnames[extnames.length - 1];


                File file = new File(savepicPath + picnum + "." + exts);

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
            //log.error(regNo+"原始图片保存出错输入输出流出错：连接断开了！");
        }
        return result;
    }

    /**
     * 存储read me
     *
     * @param savePath
     * @param readmeUrl
     * @return
     */
    public static String saveReadMe(String savePath, String readmeUrl) {
        String result = "";
        //String picnameString[]=url.split("/");
        //String picname=picnameString[picnameString.length-1];

        Connection con = HttpConnUtil.getConnection(readmeUrl);
        if (con != null) {
            Map<String, String> map = HttpConnUtil.getAllCookie(con);
            if (map != null) {
                Connection conn = HttpConnUtil.getConnection(readmeUrl)
                        // .data("IntCls", intCls)   // 请求参数
                        .cookies(map)

                        .timeout(100000);          // 设置连接超时时间
                File f2 = new File(savePath);

                // 创建文件夹
                if (!f2.exists()) {
                    f2.mkdirs();
                }

                // result=picname+"_460x460";
                //File file=new File(savepicPath+picname+"_460x460.tbi");

                File file = new File(savePath + "read me.txt");

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
            //log.error(regNo+"原始图片保存出错输入输出流出错：连接断开了！");
        }
        return result;
    }

    /**
     * =========================================================
     *
     * @param inputFileName
     * @param zipFileName
     * @throws Exception:void<br>
     * @时间：2014-7-2下午9:26:22
     * @方法名：zip
     * @功能： //压缩（整体文件夹）
     * @since: =========================================================
     */
    public static void zip(String inputFileName, String zipFileName) throws Exception {
        //zipFileName = "D:/tomcat6.0/webapps/main_site/upload/1/a59f4c07016e45308ede98581b13ef69.zip"; //打包后文件名字
        ////System.out.println("inputFileName="+inputFileName);
        // //System.out.println(zipFileName);
        zip(zipFileName, new File(inputFileName));
    }

    private static void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out, inputFile, "");
        ////System.out.println("zip done");
        out.finish();
        out.close();
        out = null;
    }

    private static void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++) {
                zip(out, fl[i], base + fl[i].getName());
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            // //System.out.println(base);
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
            in = null;
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
            ////System.out.println("压缩完成.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
