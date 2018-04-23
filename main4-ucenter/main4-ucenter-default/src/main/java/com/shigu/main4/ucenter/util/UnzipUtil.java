package com.shigu.main4.ucenter.util;


import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;
import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarOutputStream;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.Date;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：Test.java
 *@文件路径：com.test.Test.java
 *@内容摘要：压缩、解压文件公用类
 *@编码作者：顾邹阳
 *@完成日期：
 *@Date2014-12-22下午5:15:37
 *@comments:
 *
 *=========================================================
 */

public class UnzipUtil {
    private static final int BUFFEREDSIZE = 1024;
    public UnzipUtil () {
        // TODO Auto-generated constructor stub
    }

    /**
     * 解压zip格式的压缩文件到当前文件夹
     * @param zipFileName
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public synchronized String unzipFile(String zipFileName) throws Exception {
    	String csvName="";
//    	String pathString=new Date().getTime()+"";
        try {
            File f = new File(zipFileName);
            ZipFile zipFile = new ZipFile(zipFileName);
            if((!f.exists()) && (f.length() <= 0)) {
                throw new Exception("要解压的文件不存在!");
            }
            String strPath, gbkPath, strtemp;
            File tempFile = new File(f.getParent());
            strPath = tempFile.getAbsolutePath();
            java.util.Enumeration e = zipFile.getEntries();
            while(e.hasMoreElements()){
                ZipEntry zipEnt = (ZipEntry) e.nextElement();
                gbkPath=zipEnt.getName();
                if(zipEnt.isDirectory()){
                    strtemp = strPath + "/" + gbkPath;
                    File dir = new File(strtemp);
                    dir.mkdirs();
                    continue;
                } else {
                    //读写文件
                    InputStream is = zipFile.getInputStream(zipEnt);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    gbkPath=zipEnt.getName();

                    String csv_extends[]=gbkPath.split("\\.");
                    if(csv_extends.length>=2){
                    	String exFileName=csv_extends[1];
                    	if("csv".equals(exFileName)){
                    		csvName=csv_extends[0];
                    	}

                   // //System.out.println("gbkPath="+gbkPath);
                    }
                    strtemp = strPath + "/" + gbkPath;

                    //建目录
                    String strsubdir = gbkPath;
                    for(int i = 0; i < strsubdir.length(); i++) {
                        if(strsubdir.substring(i, i + 1).equalsIgnoreCase("/")) {
                            String temp = strPath + "/" + strsubdir.substring(0, i);
                           // //System.out.println("temp="+temp);
                            File subdir = new File(temp);
                            if(!subdir.exists())
                            subdir.mkdir();
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(strtemp);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    int c;
                    while((c = bis.read()) != -1) {
                        bos.write((byte) c);
                    }
                    is.close();
                    bis.close();
                    fos.flush();
                    bos.flush();
                    bos.close();
                    fos.close();
                }
            }
            return csvName;
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    @SuppressWarnings("unchecked")
    public synchronized String unzipFile(String zipFileName,boolean zhongwen) throws Exception {
    	String csvName="";
    	String pathString=new Date().getTime()+"";
    	csvName=pathString;
        try {
            File f = new File(zipFileName);
            ZipFile zipFile = new ZipFile(zipFileName);
            if((!f.exists()) && (f.length() <= 0)) {
                throw new Exception("要解压的文件不存在!");
            }
            String strPath, gbkPath, strtemp;
            File tempFile = new File(f.getParent());
            strPath = tempFile.getAbsolutePath();
            java.util.Enumeration e = zipFile.getEntries();
            while(e.hasMoreElements()){
                ZipEntry zipEnt = (ZipEntry) e.nextElement();
                gbkPath=zipEnt.getName();
                gbkPath=dealccaddr(gbkPath,pathString);
               // //System.out.println(gbkPath);
                if(gbkPath.endsWith(".csv")||gbkPath.endsWith(".txt")||gbkPath.endsWith(".tbi")){
                	//读写文件
                    InputStream is = zipFile.getInputStream(zipEnt);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    gbkPath=zipEnt.getName();
                    gbkPath=dealccaddr(gbkPath,pathString);
                   /* String csv_extends[]=gbkPath.split("\\.");
                    if(csv_extends.length>=2){
                    	String exFileName=csv_extends[1];
                    	if("csv".equals(exFileName)){
                    		csvName=csv_extends[0];
                    	}

                   // //System.out.println("gbkPath="+gbkPath);
                    }*/
                    strtemp = strPath + "/" + gbkPath;

                    //建目录
                    String strsubdir = gbkPath;
                    for(int i = 0; i < strsubdir.length(); i++) {
                        if(strsubdir.substring(i, i + 1).equalsIgnoreCase("/")) {
                            String temp = strPath + "/" + strsubdir.substring(0, i);
                           // //System.out.println("temp="+temp);
                            File subdir = new File(temp);
                            if(!subdir.exists())
                            subdir.mkdir();
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(strtemp);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    int c;
                    while((c = bis.read()) != -1) {
                        bos.write((byte) c);
                    }
                    is.close();
                    bis.close();
                    fos.flush();
                    bos.flush();
                    bos.close();
                    fos.close();
                }else{
                	 strtemp = strPath + "/" + gbkPath;
                     File dir = new File(strtemp);
                     if(!dir.isDirectory()){

                         dir.mkdirs();
                         continue;
                     }else{
                    	 continue;
                     }
                }


              /*  strtemp = strPath + "/" + gbkPath;
                File dir = new File(strtemp);
                if(!dir.isDirectory()){

                    dir.mkdirs();
                    continue;
                } else {
                	if(gbkPath.endsWith(".csv")||gbkPath.endsWith(".txt")||gbkPath.endsWith(".tbi")){

                	}
                }*/

            }

            return csvName;
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String  dealccaddr(String addr,String t2){
//    	String se1="";
//		try {
//			se1 = new String(addr.getBytes("gbk"));
//			//if(addr.endsWith(".csv")){
//				//System.out.println("addr="+se1);
//			//}
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	//System.out.println(se1);
    	String repalced="";
        	int se=addr.lastIndexOf("\\");
        	////System.out.println(se);
        	String seeString[]=null;
        	/*if(se==-1){
        		 seeString=addr.split(File.separator);
        	}else{

        		 seeString=addr.split(File.separator+File.separator);
        	}*/
        	if(se==-1){
    	   		 seeString=addr.split("/");
    	   	}else{

    	   		 seeString=addr.split("\\\\");
    	   	}

        	// seeString=addr.split(File.separator+File.separator);
        	String path="";
        	if(seeString.length>=0){
        		if(addr.endsWith(".csv")){
    				repalced=t2+".csv";
    				////System.out.println(repalced);
    				addr=repalced;
    				//addr=addr.replaceAll(repalced, t2);
    			}else{
    				if(addr.endsWith(".txt")){
    					repalced="readme.txt";
    				//	//System.out.println(repalced);

    					addr=repalced;
    				}else{
    					if(addr.endsWith(".tbi")){
    						////System.out.println(addr);
    						addr=t2+"/"+seeString[seeString.length-1];
    					}else{
    						addr=t2;
    					}
    				}
    			}
        	}




        	return addr;
        }

    /**
     * 解压zip格式的压缩文件到指定位置
     * @param zipFileName 压缩文件
     * @param extPlace 解压目录
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public synchronized void unzip(String zipFileName, String extPlace) throws Exception {
        try {
            (new File(extPlace)).mkdirs();
            File f = new File(zipFileName);
            ZipFile zipFile = new ZipFile(zipFileName);
            if((!f.exists()) && (f.length() <= 0)) {
                throw new Exception("要解压的文件不存在!");
            }
            String strPath, gbkPath, strtemp;
            File tempFile = new File(extPlace);
            strPath = tempFile.getAbsolutePath();
            java.util.Enumeration e = zipFile.getEntries();
            while(e.hasMoreElements()){
                ZipEntry zipEnt = (ZipEntry) e.nextElement();
                gbkPath=zipEnt.getName();
                if(zipEnt.isDirectory()){
                    strtemp = strPath + File.separator + gbkPath;
                    File dir = new File(strtemp);
                    dir.mkdirs();
                    continue;
                } else {
                    //读写文件
                    InputStream is = zipFile.getInputStream(zipEnt);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    gbkPath=zipEnt.getName();
                    strtemp = strPath + File.separator + gbkPath;

                    //建目录
                    String strsubdir = gbkPath;
                    for(int i = 0; i < strsubdir.length(); i++) {
                        if(strsubdir.substring(i, i + 1).equalsIgnoreCase("/")) {
                            String temp = strPath + File.separator + strsubdir.substring(0, i);
                            File subdir = new File(temp);
                            if(!subdir.exists())
                            subdir.mkdir();
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(strtemp);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    int c;
                    while((c = bis.read()) != -1) {
                        bos.write((byte) c);
                    }
                    is.close();
                    bis.close();
                    fos.flush();
                    bos.flush();
                    bos.close();
                    fos.close();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 解压zip格式的压缩文件到指定位置
     * @param zipFileName 压缩文件
     * @param extPlace 解压目录
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public synchronized void unzip(String zipFileName, String extPlace,boolean whether) throws Exception {
        try {
            (new File(extPlace)).mkdirs();
            File f = new File(zipFileName);
            ZipFile zipFile = new ZipFile(zipFileName);
            if((!f.exists()) && (f.length() <= 0)) {
                throw new Exception("要解压的文件不存在!");
            }
            String strPath, gbkPath, strtemp;
            File tempFile = new File(extPlace);
            strPath = tempFile.getAbsolutePath();
            java.util.Enumeration e = zipFile.getEntries();
            while(e.hasMoreElements()){
                ZipEntry zipEnt = (ZipEntry) e.nextElement();
                gbkPath=zipEnt.getName();
                if(zipEnt.isDirectory()){
                    strtemp = strPath + File.separator + gbkPath;
                    File dir = new File(strtemp);
                    dir.mkdirs();
                    continue;
                } else {
                    //读写文件
                    InputStream is = zipFile.getInputStream(zipEnt);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    gbkPath=zipEnt.getName();
                    strtemp = strPath + File.separator + gbkPath;

                    //建目录
                    String strsubdir = gbkPath;
                    for(int i = 0; i < strsubdir.length(); i++) {
                        if(strsubdir.substring(i, i + 1).equalsIgnoreCase("/")) {
                            String temp = strPath + File.separator + strsubdir.substring(0, i);
                            File subdir = new File(temp);
                            if(!subdir.exists())
                            subdir.mkdir();
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(strtemp);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    int c;
                    while((c = bis.read()) != -1) {
                        bos.write((byte) c);
                    }
                    is.close();
                    bis.close();
                    fos.flush();
                    bos.flush();
                    bos.close();
                    fos.close();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    /**
     * 压缩zip格式的压缩文件
     * @param inputFilename 压缩的文件或文件夹及详细路径
     * @param zipFilename 输出文件名称及详细路径
     * @throws IOException
     */
    public synchronized void zip(String inputFilename, String zipFilename) throws IOException {
        zip(new File(inputFilename), zipFilename);
    }

    /**
     * 压缩zip格式的压缩文件
     * @param inputFile 需压缩文件
     * @param zipFilename 输出文件及详细路径
     * @throws IOException
     */
    public synchronized void zip(File inputFile, String zipFilename) throws IOException {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFilename));
        try {
            zip(inputFile, out, "");
        } catch (IOException e) {
            throw e;
        } finally {
            out.close();
        }
    }

    /**
     * 压缩zip格式的压缩文件
     * @param inputFile 需压缩文件
     * @param out 输出压缩文件
     * @param base 结束标识
     * @throws IOException
     */
    @SuppressWarnings("unused")
    private synchronized void zip(File inputFile, ZipOutputStream out, String base) throws IOException {
        if (inputFile.isDirectory()) {
            File[] inputFiles = inputFile.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < inputFiles.length; i++) {
                zip(inputFiles[i], out, base + inputFiles[i].getName());
            }
        } else {
            if (base.length() > 0) {
                out.putNextEntry(new ZipEntry(base));
            } else {
                out.putNextEntry(new ZipEntry(inputFile.getName()));
            }
            FileInputStream in = new FileInputStream(inputFile);
            try {
                int c;
                byte[] by = new byte[BUFFEREDSIZE];
                while ((c = in.read(by)) != -1) {
                    out.write(by, 0, c);
                }
            } catch (IOException e) {
                throw e;
            } finally {
            	out.flush();
            	out.close();
                in.close();
            }
        }
    }


    /**
     * 解压tar格式的压缩文件到指定目录下
     * @param tarFileName 压缩文件
     * @param extPlace 解压目录
     * @throws Exception
     */
    public synchronized void untar(String tarFileName, String extPlace) throws Exception{

    }

    /**
     * 压缩tar格式的压缩文件
     * @param inputFilename 压缩文件
     * @param tarFilename 输出路径
     * @throws IOException
     */
    public synchronized void tar(String inputFilename, String tarFilename) throws IOException{
        tar(new File(inputFilename), tarFilename);
    }

    /**
     * 压缩tar格式的压缩文件
     * @param inputFile 压缩文件
     * @param tarFilename 输出路径
     * @throws IOException
     */
    public synchronized void tar(File inputFile, String tarFilename) throws IOException{
        TarOutputStream out = new TarOutputStream(new FileOutputStream(tarFilename));
        try {
            tar(inputFile, out, "");
        } catch (IOException e) {
            throw e;
        } finally {
        	out.flush();
            out.close();
        }
    }

    /**
     * 压缩tar格式的压缩文件
     * @param inputFile 压缩文件
     * @param out 输出文件
     * @param base 结束标识
     * @throws IOException
     */
    @SuppressWarnings("unused")
    private synchronized void tar(File inputFile, TarOutputStream out, String base) throws IOException {
        if (inputFile.isDirectory()) {
            File[] inputFiles = inputFile.listFiles();
            out.putNextEntry(new TarEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < inputFiles.length; i++) {
                tar(inputFiles[i], out, base + inputFiles[i].getName());
            }
        } else {
            if (base.length() > 0) {
                out.putNextEntry(new TarEntry(base));
            } else {
                out.putNextEntry(new TarEntry(inputFile.getName()));
            }
            FileInputStream in = new FileInputStream(inputFile);
            try {
                int c;
                byte[] by = new byte[BUFFEREDSIZE];
                while ((c = in.read(by)) != -1) {
                    out.write(by, 0, c);
                }
            } catch (IOException e) {
                throw e;
            } finally {
                in.close();
                out.flush();
                out.close();
            }
        }
    }


    public static String unRarFile(String srcRarPath, String dstDirectoryPath) {
    	String csvName="";
        if (!srcRarPath.toLowerCase().endsWith(".rar")) {
            ////System.out.println("非rar文件！");
            return "非法rar";
        }
        File dstDiretory = new File(dstDirectoryPath);
        if (!dstDiretory.exists()) {// 目标目录不存在时，创建该文件夹
            dstDiretory.mkdirs();
        }
        Archive a = null;
        try {
            a = new Archive(new File(srcRarPath));
            if (a != null) {
               // a.getMainHeader().print(); // 打印文件信息.
                FileHeader fh = a.nextFileHeader();
                Long t2=new Date().getTime();
                csvName=t2+"";
                while (fh != null) {
                    if (fh.isDirectory()) { // 文件夹
                       // File fol = new File(dstDirectoryPath + File.separator+ fh.getFileNameW());//.getFileNameString()

                    	String pathrsString="";
                    	if(fh.getFileNameW()==null||"".equals(fh.getFileNameW())){
                    		//filenameString=fh.getFileNameString();
                    		pathrsString=dealzhongwenaddr2(fh.getFileNameString(),t2);
                    	}else{

                    		pathrsString=dealzhongwenaddr2(fh.getFileNameW(),t2);
                    	}

                    	//String pathrsString=dealzhongwenaddr(filenameString,t2);
                    	String paths[]=pathrsString.split(":");
                    	if(paths.length==2){
                    		csvName=paths[1];
                    	}
                    	////////////////////////////////////////////////////////
                        File fol = new File(dstDirectoryPath + File.separator+paths[0]);//.getFileNameString()
                        fol.mkdirs();
                    } else { // 文件

                    	String pathrsString="";
                    	if(fh.getFileNameW()==null||"".equals(fh.getFileNameW())){
                    		//filenameString=fh.getFileNameString();
                    		pathrsString=dealzhongwenaddr2(fh.getFileNameString(),t2);
                    	}else{

                    		pathrsString=dealzhongwenaddr2(fh.getFileNameW(),t2);
                    	}

                    	//String pathrsString=dealzhongwenaddr(filenameString,t2);
                        if(pathrsString!=null&&!pathrsString.equals("")) {
                            String paths[] = pathrsString.split(":");

                            if (paths.length == 2) {
                                csvName = paths[1];
                            }
                            File out = new File(dstDirectoryPath + File.separator + paths[0]);//  + fh.getFileNameString().trim());
                            ////System.out.println(out.getAbsolutePath());
                            try {// 之所以这么写try，是因为万一这里面有了异常，不影响继续解压.
                                if (!out.exists()) {
                                    if (!out.getParentFile().exists()) {// 相对路径可能多级，可能需要创建父目录.
                                        out.getParentFile().mkdirs();
                                    }
                                    out.createNewFile();
                                }

                                FileOutputStream os = new FileOutputStream(out);
                                a.extractFile(fh, os);
                                os.flush();
                                os.close();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    fh = a.nextFileHeader();
                }

                a.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvName;
    }

    public static String unRarFile(String srcRarPath) {
        if (!srcRarPath.toLowerCase().endsWith(".rar")) {
            ////System.out.println("非rar文件！");
            return "非rar文件";
        }
        String dstDirectoryPath=getrarpath(srcRarPath);
       return unRarFile( srcRarPath,dstDirectoryPath);
    }


    private  static String  dealzhongwenaddr2(String addr,Long t2){//有中文
    	////System.out.println("有中文");

    	int se=addr.lastIndexOf("\\");
    	////System.out.println(se);
    	String seeString[]=null;

    	if(se==-1){
	   		 seeString=addr.split("/");
	   	}else{

	   		 seeString=addr.split("\\\\");
	   	}

    	// seeString=addr.split(File.separator+File.separator);
    	String pcsv="";
    	String path="";
    	if(seeString.length>0){
    		if(seeString[seeString.length-1].endsWith(".tbi")){
    			//pcsv=seeString[seeString.length-2]+".csv";
    			path=t2+File.separator+seeString[seeString.length-1];
    		}else{
    			if(seeString[seeString.length-1].endsWith(".csv")){
    				//pcsv=seeString[seeString.length-1];
    				path=t2+".csv";
    				pcsv=t2+".csv";
    			}else{
    				if(seeString[seeString.length-1].endsWith(".txt")){
    					path="txt_"+t2+".txt";
        			}
    			}
    		}
    	}

    	String result=path;
    	if(!"".equals(pcsv)){
    		result=path+":"+pcsv;

    	}
    	////System.out.println(result);
    	return result;
    }

    private static String getrarpath(String path){
    	String rarpath="";
    	if(path.endsWith(".rar")){

    		int se=path.lastIndexOf("\\");
        	////System.out.println(se);
        	String seeString[]=null;
        	if(se==-1){
	   	   		 seeString=path.split("/");
	   	   	}else{

	   	   		 seeString=path.split("\\\\");
	   	   	}
    		for(int i=0;i<seeString.length-1;i++){
    			if(i<seeString.length-2){
    				rarpath+=seeString[i]+File.separator;
    			}else{
    				rarpath+=seeString[i];
    			}
    		}
    	}
    	return rarpath;
    }
    /**
     * 执行实例
     * @param args
     */
    public static void main(String[] args) throws Exception {
       // UnzipUtil decompression=new UnzipUtil();
      //  decompression.unzipFile("E:\\1111\\zip\\BBL20150702\\BBL20150702.zip");
       // decompression.unzipFile("E:\\1111\\zip\\a11.zip");
        //decompression.unzip("d:/Inetpub.zip","d://Inetpub");
        //decompression.zip("c:/Inetpub", "c:/Inetpub.zip");
        //decompression.unRarFile("E:/1111/zip/BBL20150702.rar", "E:/1111/zip");

       // decompression.unRarFile("E:/1111/zip/BBL20150702.rar");
        ////System.out.println(decompression.getrarpath("E:/1111/zip/BBL20150702.rar"));
       // decompression.dealzhongwenaddr("BBL20150702\\布芭啦10款\\00585843632.csv",12365890L);
    	UnzipUtil decompression=new UnzipUtil();
    	//String se=decompression.unzipFile("D:\\home\\sjbfolder\\4\\csml11442571987448\\1443172368175\\1443172368175.zip",true);

    	String se=decompression.unRarFile("/Users/gzy/testsjb/sjbfolder/266/fc0981eb78547806af01c2541e1dc21761509/1444928922894/1444928922894.rar");
    	////System.out.println("%%%%%"+se);

      /*  String pathrsString=dealzhongwenaddr("BBL20150702\\布芭啦10款\\00585843632.csv",12365890L);
    	String paths[]=pathrsString.split(":");
    	if(paths.length==2){
    		//System.out.println(paths[0]+"@@@"+paths[1]);
    	}else{
    		//System.out.println(paths[0]+"!!!!!!!!!!!"+pathrsString);
    	}*/

    }
}