package com.shigu.main4.ucenter.util;

import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.vo.ShiguGoodsTinyVO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class PackageTask implements Callable<List<ShiguGoodsTinyVO>> {
    private String packageUrl;
    private Long storeId;
    private String flag;
    private ImportCsvFileService importCsvFileService;
    private OssIO oss;

    public PackageTask(String packageUrl, Long storeId, String flag, ImportCsvFileService importCsvFileService, OssIO oss) {
        this.packageUrl = packageUrl;
        this.storeId = storeId;
        this.flag = flag;
        this.importCsvFileService = importCsvFileService;
        this.oss = oss;
    }

    @Override
    public List<ShiguGoodsTinyVO> call() throws Main4Exception {
        Date date=new Date();
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String DATA_PACKAGE_ADDR = FilePathConstant.ITEM_COLLECT_PACKAGE_PATH_URL;//要解压出来存放的临时数据包地址
        String dateString= sdf.format(date);
        String temppath=DATA_PACKAGE_ADDR + File.separator + storeId + File.separator +dateString;
        String tempPath=packageUrl;

        if("rest".equals (flag)){
            String fileName="";
            if(tempPath.endsWith(".zip")){
                fileName=date.getTime ()+".zip";
            }else{
                if(tempPath.endsWith(".rar")){
                    fileName=date.getTime ()+".rar";
                }
            }
            packageUrl=packageUrl.replaceAll (oss.getDomain(),"");//不要域名
            if(oss.getSizeInfo(packageUrl)>104857600L){
                throw new Main4Exception("数据包过大,最大支持100M");
            }
            //正式的要从oss里读取下来存储后再进行解压
            File filef=new File(temppath);
            if(!filef.exists ()){
                filef.mkdirs ();
            }
            File file= oss.downFileToLocal(temppath+File.separator+fileName,packageUrl);

            tempPath=file.getPath ();
        }else{
            //测试的直接解压

            String fileName="";
            if(tempPath.endsWith(".zip")){
                fileName=new Date ().getTime ()+".zip";
            }else{
                if(tempPath.endsWith(".rar")){
                    fileName=new Date ().getTime ()+".rar";
                }
            }
            try {

                File file=new File(temppath);
                if(!file.exists ()){
                    file.mkdirs ();
                }
                FileInputStream fis = new FileInputStream (tempPath);
                FileOutputStream fos = new FileOutputStream (temppath + File.separator + fileName);

                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fis.read (buffer)) > 0) {
                    fos.write (buffer, 0, len);
                }
                fis.close ();
                fos.close ();
                tempPath=temppath + File.separator + fileName;
            }catch (Exception e){

            }

        }

        //解压数据包


        String tempDir=temppath+ File.separator;
        //解开
        if(tempPath.endsWith(".zip")){
            //UnzipUtil decompression=new UnzipUtil();
            ZipUtil decompression=new ZipUtil();
            try {
                String folder="";
                try {
                    // folder=decompression.unzipFile(tempPath);
                    folder=decompression.uzipall(tempPath);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    //e.printStackTrace();
                    // //System.out.println("解压失败！");
                    ///////////////////////////////////////////////////////////
                    throw new Main4Exception(packageUrl+",解压失败！");
                    ///////////////////////////////////////////////////////////
                }
                //判断是否有CSV

                if(!"".equals(folder)){
                    String csvname="";
                    boolean flags=false;
                    try {

                        File file = new File(tempDir);
                        String[] filelist = file.list();
                        for (int k = 0; k < filelist.length; k++) {

                            if(filelist[k].endsWith(".csv")&&!filelist[k].endsWith("_new.csv")){
                                csvname=filelist[k];
                                csvname= csvname.substring(0, csvname.length()-4);
                                // //System.out.println("ssss="+filelist[k]);
                                flags=true;
                            }
                        }
                        if(!flags){
                            //不是这一层的文件夹在他的下一层
                            File[] ffiles= file.listFiles ();
                            for(File ffile:ffiles){
                                if(ffile.isDirectory ()){
                                    tempDir=ffile.getAbsolutePath ();
                                    String[] filelist0 = ffile.list();
                                    for (int k = 0; k < filelist0.length; k++) {

                                        if(filelist0[k].endsWith(".csv")&&!filelist0[k].endsWith("_new.csv")){
                                            csvname=filelist0[k];
                                            csvname= csvname.substring(0, csvname.length()-4);

                                            flags=true;
                                        }
                                    }
                                }else{
                                    continue;
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String image_save_path=tempDir+"/"+csvname;

                    String csvFilepath=tempDir+"/"+csvname+".csv";
                    String newcsvFilepath=tempDir+"/"+csvname+"_new.csv";
                    File csvFile = new File(csvFilepath);
//                    File newcsvFile = new File(newcsvFilepath);

                    if(csvFile!=null&&csvFile.exists()){//存在CSV文件
                        ///////////////////////////////////////////////////////////////////////////////////////////////
                        //if(csvIntoGoodsService.convertionFile(csvFile,newcsvFile)){
                        //log.debug("@@@@@@@@@@@@@@@@@@@@@@@CSV转码完成");
                        List<ShiguGoodsTinyVO> goodsList=importCsvFileService.importCsvFileString(storeId,csvFilepath,image_save_path);
                       /* File file = new File(temppath);
                        file.delete ()*/

                        if(goodsList.size ()==0){
                            //写入错误表
                            // //System.out.println("商品转换失败！");
                            throw new Main4Exception (packageUrl+",商品转换失败！");
                        }else{
                            deleteFileAndFolder( temppath);
                            return goodsList;
                        }

                    }else{//CSV不存在
                        // //System.out.println("压缩包内没有CSV文件！");
                        throw new Main4Exception (packageUrl+",压缩包内没有CSV文件！");

                    }
                    //String imgPath=csvName.replace(".zip", "/")+folder+"/";
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////
                }else{
                    // //System.out.println("压缩包内没有CSV文件！");
                    throw new Main4Exception (packageUrl+",压缩包内没有CSV文件！");
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{
            //rar
            if(tempPath.endsWith(".rar")){
                UnzipUtil decompression=new UnzipUtil();
                String folder=decompression.unRarFile(tempPath);
                if(!"".equals(folder)){
                    String csvname="";
                    try {
                        File file = new File(tempDir);
                        String[] filelist = file.list();
                        for (int k = 0; k < filelist.length; k++) {

                            if(filelist[k].endsWith(".csv")){
                                csvname=filelist[k];
                                csvname= csvname.substring(0, csvname.length()-4);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String image_save_path=tempDir+"/"+csvname;
                    String csvFilePath=tempDir+"/"+csvname+".csv";
                    String newcsvFilepath=tempDir+"/"+csvname+"_new.csv";
                    File csvFile = new File(csvFilePath);
//                    File newcsvFile = new File(newcsvFilepath);
                    if(csvFile!=null&&csvFile.exists()){
                        try {
                            List<ShiguGoodsTinyVO> goodsList=importCsvFileService.importCsvFileString(storeId,csvFilePath,image_save_path);
                            if(goodsList.size ()==0){
                                //写入错误表
                                ////System.out.println("商品转换失败！");
                                throw new Main4Exception (packageUrl+",商品转换失败！");
                            }else{
                                deleteFileAndFolder( temppath);
                                return goodsList;
                            }
                            //}
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        ///////////////////////////////////////////////////////////////////////////////////////////////////
                    }else{
                        throw new Main4Exception (packageUrl+",压缩包内没有CSV文件！");
                    }
                }else{
                    // //System.out.println("压缩包内没有CSV文件！");
                    throw new Main4Exception (packageUrl+",压缩包内没有CSV文件！");
                }
            }
        }
        return null;
    }

    private void deleteFileAndFolder(String temppath){
        File file=new File(temppath);
        ////System.out.println("@@@@@@@@@@@@@@@@@开始删除"+temppath);
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
                            /*try {
                                Thread.sleep (5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace ();
                            }
                            //System.out.println (filename);*/
                        }
                        file2.delete ();
                        /*try {
                            Thread.sleep (5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }*/
                    }else{
                        String filename=file2.getName ();
                        file2.deleteOnExit ();
                       /* try {
                            Thread.sleep (5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                        //System.out.println (filename);*/
                    }

                }
                file1.delete ();
                /*try {
                    Thread.sleep (5000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }*/
            }else{
                String filename=file1.getName ();
                file1.deleteOnExit ();
                /*try {
                    Thread.sleep (5000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }*/
                // //System.out.println (filename);
            }

        }
        /*file.getParentFile ().delete ();
        try {
            Thread.sleep (5000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }*/

        // //System.out.println (file.getName ());
        File floders[]= file.listFiles ();
        for(File filess:floders){
            filess.delete ();
            /*try {
                Thread.sleep (5000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }*/
        }
        file.delete ();
        /*try {
            Thread.sleep (5000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }*/
        // //System.out.println ("删除完成！");
    }
    private long getFileLength(String url1) throws Main4Exception {
        long length=0;
        URL url;
        try {
            url = new  URL(url1);
            HttpURLConnection urlcon=(HttpURLConnection)url.openConnection();
            //根据响应获取文件大小
            length=urlcon.getContentLength();
            urlcon.disconnect();
        } catch (Exception e) {
            throw new Main4Exception("数据包解析失败");
        }
        return length;
    }
}
