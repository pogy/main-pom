package com.shigu.main4.example.test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by sean on 2017-02-13-0013.
 */
public class Example {
    private Example() {
    }

    public static void create() {
        System.out.println("请输入类路径：");
        Scanner sca = new Scanner(System.in);
        String path = sca.nextLine();
        String sprit = "/";
        if(!path.contains("/")) {
            sprit = "\\";
        }

        String dir = path.substring(0, path.lastIndexOf(sprit));
        String parentdir = dir.substring(0, dir.lastIndexOf(sprit));
        String fileName = path.replace(dir + sprit, "");
        String packageName;
        String interfacePackage;
        String beanClassName;
        String flag = "src" + sprit + "main" + sprit + "java";
        if(path.contains(flag)) {
            packageName = path.substring(path.indexOf(flag)).replace(flag + sprit, "").replace(sprit + fileName, "");
            beanClassName = packageName.replace(sprit, ".") + "." + fileName.replace(".java", "");
            packageName = packageName.substring(0, packageName.lastIndexOf(sprit)) + sprit;
            interfacePackage = packageName + "interfaces";
            interfacePackage = interfacePackage.replace(sprit, ".");
            packageName = packageName + "examples";
            packageName = packageName.replace(sprit, ".");
            String beanName = fileName.replace(".java", "");

            try {
                String e = CreateUtil.exampleString(packageName, beanClassName, beanName);
                File examdir = new File(parentdir + sprit + "examples");
                examdir.mkdir();
                FileOutputStream fos = new FileOutputStream(parentdir + sprit + "examples" + sprit + beanName + "Example.java");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                OutputStreamWriter osw = new OutputStreamWriter(bos);
                BufferedWriter fw = new BufferedWriter(osw);
                fw.write(e);
                fw.close();
                osw.close();
                bos.close();
                fos.close();
                System.out.println("Example类生成成功！！");
                System.out.println("是否继续生成接口类？(y/n)");
                String needNext = sca.nextLine();
                if("y".equals(needNext)) {
                    String interfaceCode = CreateUtil.interfaceString(beanName, interfacePackage, beanClassName);
                    examdir = new File(parentdir + sprit + "interfaces");
                    examdir.mkdir();
                    fos = new FileOutputStream(parentdir + sprit + "interfaces" + sprit + beanName + "Mapper.java");
                    bos = new BufferedOutputStream(fos);
                    osw = new OutputStreamWriter(bos);
                    fw = new BufferedWriter(osw);
                    fw.write(interfaceCode);
                    fw.close();
                    osw.close();
                    bos.close();
                    fos.close();
                    System.out.println("接口类生成成功！！");
                }
            } catch (Exception var19) {
                var19.printStackTrace();
            }
        } else {
            System.out.println("没有找到src/main/java目录");
        }
    }

    public static void main(String[] args) {
        create();
    }
}
