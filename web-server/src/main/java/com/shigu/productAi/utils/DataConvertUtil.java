package com.shigu.productAi.utils;

import com.shigu.productAi.beans.AiImageInfo;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-07-13.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class DataConvertUtil {

    public static String DEL = "del";
    public static String ADD = "add";
    private String type;
    private String path;

    public DataConvertUtil(String type) {
        this.type = type;
    }

    public File convert(List<AiImageInfo> list) {
        String propath = System.getProperty("user.dir");
        //System.out.println(propath);
        Long id = new Date().getTime();
        path = propath + "/" + type + "AiGoods" + id + ".csv";
        File file = new File(path);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            BufferedWriter writer = new BufferedWriter(writerStream);
            //添加bom头
            writer.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            for (AiImageInfo info : list) {
                StringBuilder goodsinfo = new StringBuilder(info.getImageUrl());
                if (!StringUtils.isEmpty(info.getMeta())) {
                    goodsinfo.append(",").append(info.getMeta());
                }
                if (!StringUtils.isEmpty(info.getTags())) {
                    goodsinfo.append(",").append(info.getTags());
                }

                writer.write(goodsinfo.toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return file;
    }

    public void destroyCsv() {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    public static byte[] dataToMLBytes(List<AiImageInfo> list) {
        StringBuilder builder = new StringBuilder();
        for (AiImageInfo info : list) {
            builder.append(info.getImageUrl());
            if (!StringUtils.isEmpty(info.getMeta())) {
                builder.append(",").append(info.getMeta());
            }
            if (!StringUtils.isEmpty(info.getTags())) {
                builder.append(",").append(info.getTags());
            }
            builder.append("\r\n");


        }
        return builder.toString().getBytes();
    }


}
