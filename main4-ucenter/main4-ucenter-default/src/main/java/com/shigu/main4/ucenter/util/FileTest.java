package com.shigu.main4.ucenter.util;

import java.io.File;
import java.io.IOException;

/**
 * @类编号
 * @类名称：FileTest
 * @文件路径：com.shigu.main4.ucenter.util.FileTest
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/11/5 17:21
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class FileTest {

   public  static  String DATA_PACKAGE_ADDR = FilePathConstant.ITEM_COLLECT_PACKAGE_PATH_URL;//要解压出来存放的临时数据包地址

    public static String temppath=DATA_PACKAGE_ADDR + File.separator + "24806";


    public static void main(String args[]){


        //deleteFileAndFolder( temppath);

        //System.out.println(getgoodsId(24806L,12));
        File fs=new File("/var/folders/ht/xx91rk7178q76sj47j9gdx6m0000gp/T/24806/20171106141606/1509948969608.zip");


        try {
            ZipUtil.copyFile (fs,new File("/var/folders/ht/xx91rk7178q76sj47j9gdx6m0000gp/T/24806/20171106141606/1509948969608copy.zip"));
        } catch (IOException e) {
            e.printStackTrace ();
        }
        fs.delete ();
    }




    private static void deleteFileAndFolder(String temppath){
        File file=new File(temppath);
        File files[]= file.listFiles ();
        for(File file1:files){
            // file1.getParent ()
            if(file1.isDirectory ()){
                File files1[]=file1.listFiles ();
                for(File file2:files1){
                    if(file2.isDirectory ()){
                        File files2[]=file2.listFiles ();
                        for(File file3:files2){
                            String filename=file3.getName ();
                            file3.deleteOnExit ();
                            System.out.println (filename);
                        }
                        file2.delete ();
                    }else{
                        String filename=file2.getName ();
                        file2.deleteOnExit ();
                        System.out.println (filename);
                    }

                }
                file1.delete ();
            }else{
                String filename=file1.getName ();
                file1.deleteOnExit ();
                System.out.println (filename);
            }

        }
    }

}
