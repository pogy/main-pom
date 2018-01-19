package test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 字段转化成md要的格式
 * Created by zhaohongbo on 17/2/24.
 */
public class FieldToMd {
    String path="/Users/zhaohongbo/Workspaces/idea-workspace8/main_site4.0/main4-test/src/test/resources/fields";
    @Test
    public void toTableDetail() throws IOException {
        BufferedReader sca=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String str=sca.readLine();
        //如果"ok"就结果
        while (str!=null){
            String[] strarr=str.split("\t");
            String must="";
            if("0".equals(strarr[5])){
                must="必填";
            }else{
                must="";
            }
            System.out.println(new MdField(strarr[1],
                    strarr[2]+"("+strarr[3]+")",strarr.length>7?strarr[7]:"",must,strarr[6]));
            str=sca.readLine();
        }
        sca.close();

    }
    class MdField{

        public MdField(String name, String type, String mean, String must, String defaultvalue) {
            this.name = name;
            this.type = type;
            this.mean = mean;
            this.must = must;
            this.defaultvalue = defaultvalue;
        }

        private String name;

        private String type;

        private String mean;

        private String must;

        private String defaultvalue;

        public String getMust() {
            return must;
        }

        public void setMust(String must) {
            this.must = must;
        }

        public String getDefaultvalue() {
            return defaultvalue;
        }

        public void setDefaultvalue(String defaultvalue) {
            this.defaultvalue = defaultvalue;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMean() {
            return mean;
        }

        public void setMean(String mean) {
            this.mean = mean;
        }

        @Override
        public String toString() {
            return "| " + name +" | "+type+" | "+must+" | "+defaultvalue+" | "+mean+" |  |";
        }
    }
}
