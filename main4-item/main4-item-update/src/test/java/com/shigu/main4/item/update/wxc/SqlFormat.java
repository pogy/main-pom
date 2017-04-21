package com.shigu.main4.item.update.wxc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wxc on 2017/3/20.
 *
 * 从SQL查询语句寻找字段列表
 *
 * @author wxc
 * @since domwiki 4.0.0
 */
public class SqlFormat {

    public static void main(String[] args) throws IOException {
        System.out.println("Please input SQL (or path). must end with ';'. Any question, mail to:xiaochenyoo@gmail.com");
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (!sb.append(scanner.nextLine()).toString().endsWith(";"));
        String sql;
        String maybePath = sb.substring(0, sb.length() - 1);
        sb.delete(0, sb.length());
        File file = new File(maybePath);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String tmp;
            while ((tmp = br.readLine()) != null)
                sb.append(tmp);
            br.close();
            sql = sb.toString();
        } else {
            sql = maybePath;
        }
        parse(sql);
    }

    private static void parse(String sql) {
        sql = sql.replaceAll("\\s+", " ").toLowerCase().trim().split(" union ")[0];
        String paramString = matchesLoop(sql, "select ", " from ");
        if (paramString.length() < 12) {
            System.out.println("Bad SQL");
            return;
        }
        System.out.println("find sql fields:" + paramString);
        System.out.println("===================fields====================");
        for (String s : parseParam(paramString)) {
            System.out.println(s);
        }
    }


    private static List<String> parseParam(String paramString) {
        paramString = paramString.substring(7, paramString.length() - 6);
        int lastParamIndex = 0;
        List<String> params = new ArrayList<>();
        for (int i = 0; i < paramString.length(); i++) {
            char c = paramString.charAt(i);
            if ('(' == c) {
                String s = matchesLoop(paramString.substring(i), "(", ")");
                lastParamIndex = i += s.length();
            } else if (',' == c) {
                params.add(parseField(paramString.substring(lastParamIndex, i)));
                lastParamIndex = i + 1;
            }
        }
        params.add(parseField(paramString.substring(lastParamIndex)));
        return params;
    }

    private static String parseField(String fields) {
        String[] split = fields.split(" ");
        fields = split[split.length - 1];
        int i = fields.indexOf(".");
        if (i != -1) {
            fields = fields.substring(i + 1);
        }
        return fields.trim().replace("`", "");
    }

    private static String matchesLoop(String str, String open, String close) {
        int sum = 0;
        int end = 0;
        for (int i = 1; i < str.length(); i++) {
            String substring = str.substring(end, i);
            if (substring.endsWith(open)) {
                sum++;
                end = i;
            } else if (substring.endsWith(close)) {
                sum--;
                end = i;
                if (sum == 0) {
                    break;
                }
            }
        }
        return str.substring(0, end);
    }
}
