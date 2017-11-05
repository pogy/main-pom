package com.shigu.main4.ucenter.util;

import java.io.File;

/**
 * @类编号
 * @类名称：FileDeal
 * @文件路径：com.common.utils.FileDeal
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：15/10/21 上午10:11
 * @commonents:
 */
public class FileDeal {

    public static void main(String[] args) throws Exception {
        changeFiles("/Users/gzy/testsjb/sjbfolder/266/fc0981eb78547806af01c2541e1dc21761509/1444881435144","12345");
    }


    public static void changeFiles(String parentFolderPath,String newFileName)throws Exception{
        File folder=new File(parentFolderPath);
        File[] fs = folder.listFiles();
        for (File f3 : fs)//foreach循环，取文件
            changeFile(f3,newFileName);
    }

    static void changeFile(File f,String name) throws Exception {
        if (f.isFile()) {//如果是文件，直接更名
            //System.out.println("文件名"+f.getPath());
            if(f.getName().endsWith(".csv")||f.getName().endsWith(".txt")) {
            //System.out.println("文件名全路径"+f.getPath());
               // System.out.println("文件名"+f.getName());
               // System.out.println("文件的上级文件夹全路径"+f.getParent());
               // System.out.println("CSV文件名"+f.getAbsolutePath());
                //System.out.println("CSV文件名"+f.getCanonicalPath());
                if(f.getName().endsWith(".csv")) {
                    f.renameTo(new File(f.getParent() + "/"+name+".csv"));
                }else{
                    f.renameTo(new File(f.getParent() + "/"+"readme.txt"));
                }
            }
        } else {//如果是文件夹，
           // java.io.File[] fs = f.listFiles();//得到文件夹下的所有文件列表。
            //for (java.io.File f3 : fs)//foreach循环，取文件
               // changeFile(f3);//递归

            //System.out.println("文件夹路径："+f.getPath());
            //System.out.println("文件夹名："+f.getName());
            //System.out.println("文件夹父级：" + f.getParent());
            if(!f.getName ().equals ("__MACOSX")) {

                f.renameTo (new File (f.getParent () + "/" + name));//循环完后，把该目录更名。
            }
        }
    }
}
