package com.shigu.main4.packages.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;

public class FileOperator {
	public static void fileChannelCopy(File s, File t) {
		if(!isExistingFolder(t)){
			try {
				t.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
        FileInputStream fi = null;

        FileOutputStream fo = null;

        FileChannel in = null;

        FileChannel out = null;

        try {

            fi = new FileInputStream(s);

            fo = new FileOutputStream(t);

            in = fi.getChannel();//得到对应的文件通道

            out = fo.getChannel();//得到对应的文件通道

            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                fi.close();

                in.close();

                fo.close();

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }
	/**
	 * 判断文件是否存在,存在返回true
	 * @param folderPath
	 * @return
	 */
	public static boolean isExistingFolder(String folderPath) {
		if(StringUtils.isEmpty(folderPath)){
			return false;
		}
		return isExistingFolder(new File(folderPath));
	}
	/**
	 * 判断文件是否存在,存在返回true
	 * @param folder 
	 * @return
	 */
	public static boolean isExistingFolder(File folder) {
		if (folder.exists() || folder.isDirectory()) {
			return true;
		}
		return false;
	}
	/**
	 * 创建目录
	 * @param path
	 */
	public static void createDirectory(String path){
		File file = new File(path);
		createDirectory(file);
	}
	/**
	 * 创建目录
	 * @param file
	 */
	public static void createDirectory(File file){
		if(!file.exists()){
			file.mkdirs();
		}
	}
	/**
	 * 获取文件路径
	 * @param currentClass
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentClassPath(Class<?> currentClass)throws Exception {
		URL url = currentClass.getProtectionDomain().getCodeSource().getLocation();
		String filePath = null;
		try {
			filePath = URLDecoder.decode(url.getPath(), EncodingType.UTF_8.getEncodingName());
		} catch (UnsupportedEncodingException ex) {
			throw ex;
		}
		if (filePath.endsWith(".jar")) {
			filePath = filePath.substring(0x0, filePath.lastIndexOf("/") + 0x1);
		}
		return filePath;
	}
}
