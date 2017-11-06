package com.shigu.main4.ucenter.util;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：ZipUtil.java
 *@文件路径：com.shigu.test.ZipUtil.java
 *@内容摘要：
 *@编码作者：gzy
 *@完成日期：
 *@Date2015-9-26上午11:29:32
 *@comments:
 *
 *=========================================================
 */


import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

import java.io.*;
import java.util.Date;

public class ZipUtil {
 //private static final String ENCODE = DConfig.SJB_INPUT_ENCODING;//gbk
    private static final String ENCODE = "UTF-8";//gbk//


 public static void zip(File orgin, File dest) {
	 Project pro = new Project();
     Zip zip = new Zip();
     zip.setProject(new Project());
     zip.setDestFile(dest);

     FileSet fs = new FileSet();
     fs.setProject(pro);
     fs.setDir(orgin);
//   fs.setIncludes("**/*.java");
//   fs.setExcludes("**/*.xml");

     zip.addFileset(fs);
     zip.execute();

 }
 /****
  * 解压
  *
  * @param zipPath
  *            zip文件路径
  * @param destinationPath
  *            解压的目的地点
  */
 public static boolean  unZip(String zipPath, String destinationPath) {
  File zipFile = new File(zipPath);
  if (!zipFile.exists())
   throw new RuntimeException("zip file " + zipPath
     + " does not exist.");
  Project proj = new Project();
  Expand expand = new Expand();
  expand.setProject(proj);
  expand.setTaskType("unzip");
  expand.setTaskName("unzip");
  expand.setSrc(zipFile);

  expand.setDest(new File(destinationPath));
  expand.setEncoding(ENCODE);
  expand.execute();
  //System.out.println("unzip done!!!");
  return true;
 }
 public static void main(String[] args) {
  //String dir = new String("F:\\我的备份\\文档\\MyEclipse+9.0正式版破解与激活(亲测可用)");
 // dir = new String("F:/111.JPG");
 // zip(dir, "f:/BZBXB/zipant.zip");
  String orginString="/Users/gzy/testsjb/sjbfolder/1/e5d32a2a98573e29ec4989a08314b2bd10013/1461207545866/1461207545866.zip";
  //String destStirng ="D:\\home\\sjbfolder\\4\\csml11442571987448\\1443172368175";
  ZipUtil zUtil=new ZipUtil();
 //String csvName= zUtil.uzipall( orginString, destStirng);
 String csvName= zUtil.uzipall( orginString);
 //System.out.println(csvName);

 }

 public  synchronized String uzipall(String zipFileName){
     File zipfile=new File(zipFileName);
	 return uzipall( zipFileName, zipfile.getParent());
 }

 public  synchronized String uzipall(String orginString,String destStirng){
	 boolean flag=unZip(orginString, destStirng);
	 Date ddDate=new Date();
	 String ll= ddDate.getTime()+"";
	  if(flag){

          try {
              FileDeal.changeFiles(destStirng,ll);
          } catch (Exception e) {
              e.printStackTrace();
          }
		 /* File file=new File(destStirng+"/"+ll);
		  if(!file.isDirectory()){
			  file.mkdir();
		  }*/
	  }

		  return ll;
 }



 public static boolean copyFile(File srcFileName, File destFileName, String srcCoding, String destCoding) throws IOException {// 把文件转换为GBK文件
     BufferedReader br = null;
     BufferedWriter bw = null;
     try {
         br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFileName), srcCoding));
         bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFileName), destCoding));
         char[] cbuf = new char[1024 * 5];
         int len = cbuf.length;
         int off = 0;
         int ret = 0;
         while ((ret = br.read(cbuf, off, len)) > 0) {
             off += ret;
             len -= ret;
         }
         bw.write(cbuf, 0, off);
         bw.flush();
         return true;
     } finally {
         if (br != null)
             br.close();
         if (bw != null)
             bw.close();
     }
 }
 public static boolean copyFile(File srcFileName, File destFileName) throws IOException {// 把文件转换为GBK文件
	 char[] ch = new char[1024];
 	FileInputStream is1 = new FileInputStream(srcFileName);//文件读取
 	int[] head = new int[4];
     for(int i=0; i<4; i++){
             head[0]=is1.read();
     }

     String code="Unicode";//0.0.0.0Unicode//
     if (head[0]==115 && head[1]==0 && head[2]==0 && head[3]==0) {
         code = "gb2312";
     }
     is1.close();
    // BufferedReader br = null;
    // BufferedWriter bw = null;
     try {
    	// System.out.println("code="+code+"outputcode="+ENCODE);
    	 FileInputStream is = new FileInputStream(srcFileName);//文件读取
    	 InputStreamReader isr = new InputStreamReader(is, code);//解码  //gbk   //Unicode(服务器)
     	FileOutputStream os = new FileOutputStream(destFileName);//文件输出
     	OutputStreamWriter osw = new OutputStreamWriter(os, ENCODE);//开始编码  gbk  "UTF-8"(服务器)  //gb2312(本地)
         char[] c = new char[1024];//缓冲
         int length = 0;
         while(true){
             length = isr.read(c);
             if(length == -1){
                 break;
             }
            // System.out.println(new String(c, 0, length));
             osw.write(c, 0, length);
             osw.flush();
         }
         is.close();

         isr.close();
         os.flush();
         os.close();
         osw.flush();
         osw.close();




      /*   br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFileName),code));
         bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFileName),DConfig.SJB_INPUT_ENCODING));//DConfig.SJB_INPUT_ENCODING  "UTF-8"(服务器)  //gb2312(本地)
         char[] cbuf = new char[1024 * 1000];
         int len = cbuf.length;
         int off = 0;
         int ret = 0;
         while ((ret = br.read(cbuf, off, len)) > 0) {
             off += ret;
             len -= ret;
         }
         bw.write(cbuf, 0, off);
         bw.flush();*/
         return true;
     } finally {


        /* if (br != null)
             br.close();
         if (bw != null)
             bw.close();*/

     }
 }
}